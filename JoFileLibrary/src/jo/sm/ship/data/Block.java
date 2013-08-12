package jo.sm.ship.data;

public class Block
{
    private short   mBlockID;
    private boolean mActive;
    private short   mHitPoints;
    private short   mOrientation;
    private int     mBitfield;
    
    public Block()
    {
    }
    
    public Block(Block b)
    {
        mBlockID = b.mBlockID;
        mActive = b.mActive;
        mHitPoints = b.mHitPoints;
        mOrientation = b.mOrientation;
        mBitfield = b.mBitfield;
    }
    
    public short getBlockID()
    {
        return mBlockID;
    }
    public void setBlockID(short blockID)
    {
        mBlockID = blockID;
    }
    public boolean isActive()
    {
        return mActive;
    }
    public void setActive(boolean active)
    {
        mActive = active;
    }
    public short getHitPoints()
    {
        return mHitPoints;
    }
    public void setHitPoints(short hitPoints)
    {
        mHitPoints = hitPoints;
    }
    public short getOrientation()
    {
        return mOrientation;
    }
    public void setOrientation(short orientation)
    {
        mOrientation = orientation;
    }
    public int getBitfield()
    {
        return mBitfield;
    }
    public void setBitfield(int bitfield)
    {
        mBitfield = bitfield;
    }
}
