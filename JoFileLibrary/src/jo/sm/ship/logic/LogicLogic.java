package jo.sm.ship.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jo.sm.data.BlockTypes;
import jo.sm.data.SparseMatrix;
import jo.sm.logic.IOLogic;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.ControllerEntry;
import jo.sm.ship.data.GroupEntry;
import jo.sm.ship.data.Logic;
import jo.vecmath.Point3i;
import jo.vecmath.Point3s;

public class LogicLogic 
{
	public static Logic readFile(InputStream is, boolean close) throws IOException
	{
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream)is;
		else
			dis = new DataInputStream(is);
		Logic logic = new Logic();
		logic.setUnknown1(dis.readInt());
		int numControllers = dis.readInt();
		for (int i = 0; i < numControllers; i++)
		{
		    ControllerEntry controller = new ControllerEntry();
		    controller.setPosition(IOLogic.readPoint3s(dis));
		    int numGroups = dis.readInt();
		    for (int j = 0; j < numGroups; j++)
		    {
		        GroupEntry group = new GroupEntry();
		        group.setBlockID(dis.readShort());
		        int numBlocks = dis.readInt();
		        for (int k = 0; k < numBlocks; k++)
		            group.getBlocks().add(IOLogic.readPoint3s(dis));
		        controller.getGroups().add(group);
		    }
	        logic.getControllers().add(controller);
		}
        if (close)
            dis.close();
		return logic;
	}
    
	public static void writeFile(Logic logic, OutputStream os, boolean close) throws IOException
    {
        DataOutputStream dos;
        if (os instanceof DataOutputStream)
            dos = (DataOutputStream)os;
        else
            dos = new DataOutputStream(os);
        dos.writeInt(logic.getUnknown1());
        dos.writeInt(logic.getControllers().size());
        for (ControllerEntry controller : logic.getControllers())
        {
            IOLogic.writePoint3s(dos, controller.getPosition());
            dos.writeInt(controller.getGroups().size());
            for (GroupEntry group : controller.getGroups())
            {
                dos.writeShort(group.getBlockID());
                dos.writeInt(group.getBlocks().size());
                for (Point3s block : group.getBlocks())
                    IOLogic.writePoint3s(dos, block);
            }
        }
        if (close)
            dos.close();
    }
    
    public static Logic makeLogic(SparseMatrix<Block> grid)
    {
        Logic logic = new Logic();
        logic.setUnknown1(0);
        Point3i coreLocation = ShipLogic.findCore(grid);
        if (coreLocation == null)
            throw new IllegalArgumentException("No core!");
        ControllerEntry coreController = new ControllerEntry();
        coreController.setPosition(new Point3s((short)coreLocation.x, (short)coreLocation.y, (short)coreLocation.z));
        logic.getControllers().add(coreController);
        // controlled blocks
        List<Point3i> controllerBlocks = findAllControllerBlocks(grid);
        for (Point3i controllerBlockPosition : controllerBlocks)
        {
            Block controllerBlock = grid.get(controllerBlockPosition);
            GroupEntry controllerGroup = new GroupEntry();
            controllerGroup.setBlockID(controllerBlock.getBlockID());
            coreController.getGroups().add(controllerGroup);
            controllerGroup.getBlocks().add(new Point3s(controllerBlockPosition));

            ControllerEntry controlledEntry = new ControllerEntry();
            logic.getControllers().add(controlledEntry);
            controlledEntry.setPosition(new Point3s(controllerBlockPosition));
            GroupEntry controlledGroup = new GroupEntry();
            controlledEntry.getGroups().add(controlledGroup);
            short controlledBlockID = BlockTypes.CONTROLLER_IDS.get(controllerBlock.getBlockID());
            controlledGroup.setBlockID(controlledBlockID);
            List<Point3i> controlledBlocks = ShipLogic.findBlocks(grid, controlledBlockID);
            for (Point3i block : controlledBlocks)
                controlledGroup.getBlocks().add(new Point3s(block));
        }
        // uncontrolled blocks
        for (short controlledBlockID : new short[] { BlockTypes.THRUSTER_ID })
        {
            List<Point3i> controlledBlocks = ShipLogic.findBlocks(grid, controlledBlockID);
            if (controlledBlocks.size() == 0)
                continue;
            GroupEntry controlledGroup = new GroupEntry();
            coreController.getGroups().add(controlledGroup);
            controlledGroup.setBlockID(controlledBlockID);
            for (Point3i p : controlledBlocks)
                controlledGroup.getBlocks().add(new Point3s(p));
        }
        return logic;
    }
    
    private static List<Point3i> findAllControllerBlocks(SparseMatrix<Block> grid)
    {
        List<Point3i> blocks = new ArrayList<Point3i>();
        for (Iterator<Point3i> i = grid.iteratorNonNull(); i.hasNext(); )
        {
            Point3i pp = i.next();
            Block b = grid.get(pp);
            if (BlockTypes.isController(b.getBlockID()))
                blocks.add(pp);
        }        
        return blocks;
    }
    
    public static void dumpLogic(Logic logic, SparseMatrix<Block> grid)
    {
        System.out.println("Logic, unknown="+logic.getUnknown1()+", #controllers="+logic.getControllers().size());
        for (ControllerEntry controller : logic.getControllers())
        {
            Block controllerBlock = grid.get(controller.getPosition());
            System.out.println("  Controller at "+controller.getPosition()+" ("+BlockTypes.BLOCK_NAMES.get(controllerBlock.getBlockID())+"), #groups="+controller.getGroups().size());
            for (GroupEntry group : controller.getGroups())
            {
                System.out.println("    Group of "+group.getBlocks().size()+" "+BlockTypes.BLOCK_NAMES.get(group.getBlockID()));
//                for (Point3s block : group.getBlocks())
//                {
//                    Block groupBlock = grid.get(block);
//                    System.out.println("      "+block+" ("+BlockTypes.BLOCK_NAMES.get(groupBlock.getBlockID())+")");
//                }
            }
        }
    }
}
