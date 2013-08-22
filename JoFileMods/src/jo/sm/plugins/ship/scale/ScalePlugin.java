package jo.sm.plugins.ship.scale;

import java.util.Iterator;

import jo.sm.data.BlockTypes;
import jo.sm.data.SparseMatrix;
import jo.sm.mods.IBlocksPlugin;
import jo.sm.ship.data.Block;
import jo.vecmath.Point3f;
import jo.vecmath.Point3i;
import jo.vecmath.logic.Transform;

public class ScalePlugin implements IBlocksPlugin
{
    public static final String NAME = "Scale";
    public static final String DESC = "Scale ship's size.";
    public static final String AUTH = "Jo Jaquinta";
    public static final int[][] CLASSIFICATIONS = 
        {
        { TYPE_SHIP, SUBTYPE_MODIFY },
        { TYPE_STATION, SUBTYPE_MODIFY },
        { TYPE_SHOP, SUBTYPE_MODIFY },
        };

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public String getDescription()
    {
        return DESC;
    }

    @Override
    public String getAuthor()
    {
        return AUTH;
    }

    @Override
    public Object getParameterBean()
    {
        return new ScaleParameters();
    }

    @Override
    public int[][] getClassifications()
    {
        return CLASSIFICATIONS;
    }

    @Override
    public SparseMatrix<Block> modify(SparseMatrix<Block> original,
            Object p)
    {
        ScaleParameters params = (ScaleParameters)p;        
        //System.out.println("Params: X="+params.getXRotate()
        //        +", Y="+params.getYRotate()
        //        +", Z="+params.getZRotate());
        if (params.getXScale() < 1)
            params.setXScale(1);
        if (params.getYScale() < 1)
            params.setYScale(1);
        if (params.getZScale() < 1)
            params.setZScale(1);
        Point3i core = findCore(original);
        System.out.println("  Core at "+core);
        Transform t = new Transform();
        t.setIdentity();
        t.translate(-core.x, -core.y, -core.z);
        t.scale(params.getXScale(), params.getYScale(), params.getZScale());
        t.translate(core.x, core.y, core.z);
        SparseMatrix<Block> modified = new SparseMatrix<Block>();
        for (Iterator<Point3i> i = original.iteratorNonNull(); i.hasNext(); )
        {
            Point3i xyz = i.next();
            Block b = original.get(xyz);
            Point3f fPoint = new Point3f(xyz.x, xyz.y, xyz.z);
            t.transform(fPoint);
            Point3i iPoint = new Point3i(toInt(fPoint.x), toInt(fPoint.y), toInt(fPoint.z));
            //System.out.println("  "+xyz+" -> "+fPoint);
            modified.set(iPoint, b);
            if (b.getBlockID() != BlockTypes.CORE_ID)
            {
                for (int x = 0; x < params.getXScale(); x++)
                    for (int y = 0; y < params.getYScale(); y++)
                        for (int z = 0; z < params.getZScale(); z++)
                            if ((x != 0) || (y != 0) || (z != 0))
                            {
                                Block newB = new Block(b);
                                if (BlockTypes.isController(newB.getBlockID()))
                                    newB.setBlockID(BlockTypes.CONTROLLER_IDS.get(newB.getBlockID()));
                                modified.set(iPoint.x + x, iPoint.y + y, iPoint.z + z, newB);
                            }
            }
        }
        return modified;
    }
    
    private int toInt(float f)
    {
        return (int)(f + .5f);
    }

    private Point3i findCore(SparseMatrix<Block> grid)
    {
        for (Iterator<Point3i> i = grid.iteratorNonNull(); i.hasNext(); )
        {
            Point3i xyz = i.next();
            if (grid.get(xyz).getBlockID() == BlockTypes.CORE_ID)
                return xyz;
        }
        return null;
    }
}
