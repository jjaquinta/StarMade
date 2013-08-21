package jo.sm.ship.data;

import java.util.ArrayList;
import java.util.List;

import jo.vecmath.Point3s;


public class ControllerEntry
{
    private Point3s     mPosition;
    private List<GroupEntry> mGroups;
    
    public ControllerEntry()
    {
        mGroups = new ArrayList<GroupEntry>();
    }
    
    public Point3s getPosition()
    {
        return mPosition;
    }
    public void setPosition(Point3s position)
    {
        mPosition = position;
    }
    public List<GroupEntry> getGroups()
    {
        return mGroups;
    }
    public void setGroups(List<GroupEntry> groups)
    {
        mGroups = groups;
    }
}
