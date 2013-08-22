package jo.sm.ship.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jo.sm.data.BlockTypes;
import jo.sm.data.SparseMatrix;
import jo.sm.ent.data.Tag;
import jo.sm.ent.logic.TagLogic;
import jo.sm.ent.logic.TagUtils;
import jo.sm.logic.IOLogic;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.DockEntry;
import jo.sm.ship.data.Meta;

public class MetaLogic 
{
	public static Meta readFile(InputStream is, boolean close) throws IOException
	{
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream)is;
		else
			dis = new DataInputStream(is);
		Meta meta = new Meta();
		meta.setUnknown1(dis.readInt());
        meta.setUnknown2(dis.readByte());
        if (meta.getUnknown2() == 1)
            return meta;
        if (meta.getUnknown2() != 3)
            throw new IllegalArgumentException("Unrecognized unknown2: "+meta.getUnknown2());
        int docksNum = dis.readInt();
        for (int i = 0; i < docksNum; i++)
        {
            DockEntry entry = new DockEntry();
            entry.setSubFolder(dis.readUTF());
//            int clen = dis.readInt();
//            byte[] cdata = new byte[clen];
//            dis.readFully(cdata);
//            entry.setSubFolder(new String(cdata, "utf-8"));
            entry.setPosition(IOLogic.readPoint3i(dis));
            entry.setA(IOLogic.readPoint3f(dis));
            entry.setBlockID(dis.readShort());
            entry.setUnknown1(dis.readByte());
            meta.getDocks().add(entry);
        }
        meta.setUnknown3(dis.readByte());
        Tag tags = TagLogic.readFile(dis, close);
        meta.setData(tags);
		return meta;
	}
    public static void writeFile(Meta meta, OutputStream os, boolean close) throws IOException
    {
        DataOutputStream dos;
        if (os instanceof DataOutputStream)
            dos = (DataOutputStream)os;
        else
            dos = new DataOutputStream(os);
        dos.writeInt(meta.getUnknown1());
        dos.writeByte(meta.getUnknown2());
        if (meta.getUnknown2() == 3)
        {
            dos.writeInt(meta.getDocks().size());
            for (DockEntry entry : meta.getDocks())
            {
                dos.writeUTF(entry.getSubFolder());
                IOLogic.write(dos, entry.getPosition());
                IOLogic.write(dos, entry.getA());
                dos.writeShort(entry.getBlockID());
                dos.writeByte(entry.getUnknown1());
            }
            dos.writeByte(meta.getUnknown3());
            TagLogic.writeFile(meta.getData(), dos, false);
        }
        else if (meta.getUnknown2() == 1)
            ;
        else
            throw new IllegalArgumentException("Unrecognized unknown2: "+meta.getUnknown2());
        if (close)
            dos.close();
    }
    public static void dump(Meta meta)
    {
        System.out.println("Meta (u1="+meta.getUnknown1()+", u2="+meta.getUnknown2()+", u3="+meta.getUnknown3()+")");
        for (DockEntry entry : meta.getDocks())
            System.out.println("    "+entry.getSubFolder()+" @"+entry.getPosition()+"/"+entry.getA()
                    +" "+BlockTypes.BLOCK_NAMES.get(entry.getBlockID())+" ("+entry.getUnknown1()+")");
        TagUtils.dump(meta.getData(), "  ");
    }
    public static Meta make(SparseMatrix<Block> grid)
    {
        Meta meta = new Meta();
        meta.setUnknown1(0);
        meta.setUnknown2((byte)1);
        return meta;
    }
}
