package jo.sm.ship.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import jo.sm.logic.IOLogic;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.Chunk;
import jo.sm.ship.data.Data;
import jo.vecmath.Point3i;

public class DataLogic 
{
    public static Map<Point3i, Data> readFiles(File dataDir, String prefix) throws IOException
    {
        Map<Point3i, Data> data = new HashMap<Point3i, Data>();
        for (File dataFile : dataDir.listFiles())
            if (dataFile.getName().endsWith(".smd2") && dataFile.getName().startsWith(prefix))
            {
                String[] parts = dataFile.getName().split("\\.");
                Point3i position = new Point3i(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]));
                Data datum = DataLogic.readFile(new FileInputStream(dataFile), true);
                data.put(position, datum);
            }
        return data;
    }
    
    public static Data readFile(InputStream is, boolean close) throws IOException
	{
        //System.out.println("Reading...");
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream)is;
		else
			dis = new DataInputStream(is);
		Data data = new Data();
		data.setUnknown1(dis.readInt());
		int[][][][] offsetSizeTable = new int[16][16][16][2];
		IOLogic.readFully(dis, offsetSizeTable);
		//data.setOffsetSizeTable(unknown2);
        long[][][] timestampTable = new long[16][16][16];
        IOLogic.readFully(dis, timestampTable);
        //data.setTimestampTable(unknown3);
        List<Chunk> chunks = new ArrayList<Chunk>();
        for (;;)
        {
            byte[] chunkData = new byte[5120];
            try
            {
                dis.readFully(chunkData);
            }
            catch (EOFException e)
            {
                break;
            }
            //System.out.println(ByteUtils.toStringDump(chunkData));
            DataInputStream dis2 = new DataInputStream(new ByteArrayInputStream(chunkData));
            Chunk chunk = new Chunk();
            chunk.setTimestamp(dis2.readLong());
            chunk.setPosition(IOLogic.readPoint3i(dis2));
            chunk.setType(dis2.readByte());
            int compressedLen = dis2.readInt();
            //System.out.println("Chunk "+chunk.getPosition());
            //System.out.println("CompressedLen="+compressedLen);
            byte[] compressedData = new byte[compressedLen];
            dis2.readFully(compressedData);
            DataInputStream dis3 = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(compressedData)));
            Block[][][] blocks = new Block[16][16][16];
            //int blockCount = 0;
            byte[] inbuf = new byte[3];
            for (int z = 0; z < 16; z++)
                for (int y = 0; y < 16; y++)
                    for (int x = 0; x < 16; x++)
                    {
                        blocks[x][y][z] = new Block();
                        dis3.readFully(inbuf);
                        int bitfield = toUnsignedInt(inbuf);
                        blocks[x][y][z].setBlockID((short)((bitfield>>0)&0x7ff));
                        blocks[x][y][z].setHitPoints((short)((bitfield>>11)&0x1ff));
                        blocks[x][y][z].setActive(((bitfield>>20)&0x1) == 1);
                        blocks[x][y][z].setOrientation((short)(((bitfield>>21)&0x7)
                                | ((bitfield>>(20-3))&0x8)));
                        blocks[x][y][z].setBitfield(bitfield);
                        //if (BlockTypes.isHull(blocks[x][y][z].getBlockID()))
                        //    System.out.println("  Block "+Integer.toHexString(bitfield)
                        //            +" (id="+ blocks[x][y][z].getBlockID()+", hp="+ blocks[x][y][z].getHitPoints()+")"
                        //            +" "+ByteUtils.toString(inbuf));
                        //if (bitfield != 0)
                        //    blockCount++;
                    }
            //System.out.println("Block count="+blockCount);
            chunk.setBlocks(blocks);
            chunks.add(chunk);
        }
        data.setChunks(chunks.toArray(new Chunk[0]));
        if (close)
            dis.close();
        // cross check
        for (int z = 0; z < 16; z++)
            for (int y = 0; y < 16; y++)
                for (int x = 0; x < 16; x++)
                {
                    int off = offsetSizeTable[x][y][z][0];
                    //int siz = offsetSizeTable[x][y][z][1];
                    //long ts = timestampTable[x][y][z];
                    if (off < 0)
                        continue;
//                    System.out.print(off+" x"+siz+" ");
                    Chunk chunk = data.getChunks()[off];
                    System.out.println("idx="+x+","+y+","+z+" -> "+chunk.getPosition());
//                    System.out.println("     "+ts+" -> "+chunk.getTimestamp());
                }
		return data;
	}
    
    public static void writeFile(Data data, OutputStream os, boolean close) throws IOException
    {
        System.out.println("Writing...");
        DataOutputStream dos;
        if (os instanceof DataOutputStream)
            dos = (DataOutputStream)os;
        else
            dos = new DataOutputStream(os);
        dos.writeInt(0); // non-compressed header

        int[][][][] offsetSizeTable = new int[16][16][16][2];
        for (int z = 0; z < 16; z++)
            for (int y = 0; y < 16; y++)
                for (int x = 0; x < 16; x++)
                    offsetSizeTable[x][y][z][0] = -1;
        long[][][] timestampTable = new long[16][16][16];
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        DataOutputStream dos2 = new DataOutputStream(baos2);
        for (int i = 0; i < data.getChunks().length; i++)
        {
            Chunk chunk = data.getChunks()[i];
            //System.out.println("Chunk "+chunk.getPosition());
            ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
            DataOutputStream dos3 = new DataOutputStream(new DeflaterOutputStream(baos3));
            //int blockCount = 0;
            for (int z = 0; z < 16; z++)
                for (int y = 0; y < 16; y++)
                    for (int x = 0; x < 16; x++)
                    {
                        Block b = chunk.getBlocks()[x][y][z];
                        int bitfield = 0;
                        if (b != null)
                        {
                            bitfield |= ((b.getBlockID()&0x7ff)<<0);
                            bitfield |= ((b.getHitPoints()&0x1ff)<<11);
                            bitfield |= ((b.getOrientation()&0x8)<<(20-3));
                            bitfield |= ((b.getOrientation()&0x7)<<21);
//                            blockCount++;
//                            if (BlockTypes.isHull(b.getBlockID()))
//                                System.out.println("  Block "+Integer.toHexString(bitfield)
//                                        +" (id="+b.getBlockID()+", hp="+b.getHitPoints()+")"
//                                        +" "+ByteUtils.toString(fromUnsignedInt(bitfield)));
                        }
                        dos3.write(fromUnsignedInt(bitfield));
                    }
            dos3.close();
            byte[] compressedData = baos3.toByteArray();
            //System.out.println("Block count="+blockCount);

            dos2.writeLong(chunk.getTimestamp());
            IOLogic.write(dos2, chunk.getPosition());
            dos2.writeByte(chunk.getType());
            //System.out.println("CompressedLen="+compressedData.length);
            dos2.writeInt(compressedData.length);
            dos2.write(compressedData);
            for (int j = 25 + compressedData.length; j < 5120; j++)
                dos2.writeByte(0);
            int cx = chunk.getPosition().x/16 + 8;
            int cy = chunk.getPosition().y/16 + 8;
            int cz = chunk.getPosition().z/16 + 8;
            offsetSizeTable[cx][cy][cz][1] = 25 + compressedData.length;
            offsetSizeTable[cx][cy][cz][0] = i;
            timestampTable[cx][cy][cz] = chunk.getTimestamp();
            //System.out.println("  idx="+cx+","+cy+","+cz);
        }
        dos2.flush();

        // chunk index
        IOLogic.write(dos,  offsetSizeTable);
        IOLogic.write(dos, timestampTable);
        dos.write(baos2.toByteArray());
        
        if (close)
            dos.close();
    }

    private static byte[] fromUnsignedInt(int i)
    {
        byte[] outbuf = new byte[3];
        outbuf[2] = (byte)(i&0xff);
        i >>= 8;
        outbuf[1] = (byte)(i&0xff);
        i >>= 8;
        outbuf[0] = (byte)(i&0xff);
        return outbuf;
    }
    
 
    private static int toUnsignedInt(byte[] bytes)
    {
        return toUnsignedInt(bytes, 0, bytes.length);
    }
    
    private static int toUnsignedInt(byte[] bytes, int o, int l)
    {
        long v = 0;
        for (int i = 0; i < l; i++)
            v = (v<<8) | (bytes[o + i]&0xff);
        return (int)v;
    }

    public static void writeFiles(Map<Point3i, Data> data, File baseDir,
            String baseName) throws IOException
    {
        for (Point3i p : data.keySet())
        {
            File dataFile = new File(baseDir, baseName+"."+p.x+"."+p.y+"."+p.z+".smd2");
            // TEST
            /*
            byte[] original = FileUtils.readFile(dataFile.toString());
            //String oTxt = ByteUtils.toStringDump(original);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            writeFile(data.get(p), baos, true);
            byte[] save = baos.toByteArray();
            String sTxt = ByteUtils.toStringDump(save);
            if (oTxt.equals(sTxt))
                System.out.println("Identical");
            else
            {
                StringTokenizer oST = new StringTokenizer(oTxt, "\r\n");
                StringTokenizer sST = new StringTokenizer(sTxt, "\r\n");
                while (oST.hasMoreTokens())
                {
                    String oLine = oST.nextToken();
                    String sLine = sST.nextToken();
                    if (!oLine.equals(sLine))
                    {
                        System.out.println("O: "+oLine);
                        System.out.println("S: "+sLine);
                    }
                }
            }
            try
            {
                readFile(new ByteArrayInputStream(save), true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }
            */
            if (dataFile.exists())
            {
                File dest = new File(baseDir, baseName+"."+p.x+"."+p.y+"."+p.z+".smd2.bak");
                if (dest.exists())
                    dest.delete();
                dataFile.renameTo(dest);
            }
            writeFile(data.get(p), new FileOutputStream(dataFile), true);
        }        
    }
}
