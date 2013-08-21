package jo.sm.ship.data;

import java.util.ArrayList;
import java.util.List;

import jo.vecmath.Point3s;


public class GroupEntry
{
    private short      mBlockID;
    private List<Point3s> mBlocks;
    
    public GroupEntry()
    {
        mBlocks = new ArrayList<Point3s>();
    }

    public short getBlockID()
    {
        return mBlockID;
    }

    public void setBlockID(short blockID)
    {
        mBlockID = blockID;
    }

    public List<Point3s> getBlocks()
    {
        return mBlocks;
    }

    public void setBlocks(List<Point3s> blocks)
    {
        mBlocks = blocks;
    }
}
