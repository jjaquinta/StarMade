package jo.sm.ship.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jo.sm.data.SparseMatrix;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.BlockEntry;
import jo.sm.ship.data.Header;
import jo.vecmath.Point3i;
import jo.vecmath.Vector3f;

public class HeaderLogic 
{
    public static Header readFile(InputStream is, boolean close) throws IOException
    {
        DataInputStream dis;
        if (is instanceof DataInputStream)
            dis = (DataInputStream)is;
        else
            dis = new DataInputStream(is);
        Header header = new Header();
        header.setUnknown1(dis.readInt());
        header.setUnknown2(dis.readInt());
        header.setUpperBound(new Vector3f(dis.readFloat(),
                        dis.readFloat(),
                        dis.readFloat()));
        header.setLowerBound(new Vector3f(dis.readFloat(),
                dis.readFloat(),
                dis.readFloat()));
        int manifestLen = dis.readInt();
        BlockEntry[] manifest = new BlockEntry[manifestLen];
        for (int i = 0; i < manifest.length; i++)
        {
            manifest[i] = new BlockEntry();
            manifest[i].setBlockID(dis.readShort());
            manifest[i].setBlockQuantity(dis.readInt());
        }
        header.setManifest(manifest);
        if (close)
            dis.close();
        return header;
    }
    
	public static void writeFile(Header header, OutputStream os, boolean close) throws IOException
	{
		DataOutputStream dos;
		if (os instanceof DataOutputStream)
			dos = (DataOutputStream)os;
		else
			dos = new DataOutputStream(os);
		dos.writeInt(header.getUnknown1());
		dos.writeInt(header.getUnknown2());
		dos.writeFloat(header.getUpperBound().x);
		dos.writeFloat(header.getUpperBound().y);
		dos.writeFloat(header.getUpperBound().z);
        dos.writeFloat(header.getLowerBound().x);
        dos.writeFloat(header.getLowerBound().y);
        dos.writeFloat(header.getLowerBound().z);
        dos.writeInt(header.getManifest().length);
        for (BlockEntry block : header.getManifest())
        {
            dos.writeShort(block.getBlockID());
            dos.writeInt(block.getBlockQuantity());
        }
        if (close)
            dos.close();
	}
	
	public static Header makeHeader(SparseMatrix<Block> grid)
	{
        Point3i lower = new Point3i();
        Point3i upper = new Point3i();
        grid.getBounds(lower, upper);
        Map<Short,BlockEntry> manifest = new HashMap<Short, BlockEntry>();
        for (Iterator<Point3i> i = grid.iteratorNonNull(); i.hasNext(); )
        {
            Block b = grid.get(i.next());
            BlockEntry entry = manifest.get(b.getBlockID());
            if (entry == null)
            {
                entry = new BlockEntry();
                entry.setBlockID(b.getBlockID());
                entry.setBlockQuantity(0);
            }
            entry.setBlockQuantity(entry.getBlockQuantity() + 1);
        }
        
	    Header header = new Header();
	    header.setUnknown1(0);
	    header.setUnknown2(0);
	    header.setUpperBound(new Vector3f(upper.x, upper.y, upper.z));
        header.setLowerBound(new Vector3f(lower.x, lower.y, lower.z));
	    header.setManifest(manifest.values().toArray(new BlockEntry[0]));
	    return header;
	}
}
