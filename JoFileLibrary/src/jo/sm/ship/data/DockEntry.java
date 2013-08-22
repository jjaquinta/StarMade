package jo.sm.ship.data;

import jo.vecmath.Point3f;
import jo.vecmath.Point3i;

/*
    dockEntry is a variable length struct
    start   type
    0       int         length of the string giving attached ship's subfolder
    4       wchar[N]    ship subfolder string given in modified UTF-8 encoding
    vary    int[3]      q vector, the location of the dock block
    vary    float[3]    a vector, ???
    vary    short       block ID of the dock block
 */
public class DockEntry
{
    private String mSubFolder;
    private Point3i mPosition;
    private Point3f mA;
    private short mBlockID;
    private byte  mUnknown1;

    public short getBlockID()
    {
        return mBlockID;
    }

    public void setBlockID(short blockID)
    {
        mBlockID = blockID;
    }

    public String getSubFolder()
    {
        return mSubFolder;
    }

    public void setSubFolder(String subFolder)
    {
        mSubFolder = subFolder;
    }

    public Point3i getPosition()
    {
        return mPosition;
    }

    public void setPosition(Point3i position)
    {
        mPosition = position;
    }

    public Point3f getA()
    {
        return mA;
    }

    public void setA(Point3f a)
    {
        mA = a;
    }

    public byte getUnknown1()
    {
        return mUnknown1;
    }

    public void setUnknown1(byte unknown1)
    {
        mUnknown1 = unknown1;
    }
}
