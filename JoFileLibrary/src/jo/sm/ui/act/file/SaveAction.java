package jo.sm.ui.act.file;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import jo.sm.data.SparseMatrix;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.Data;
import jo.sm.ship.logic.DataLogic;
import jo.sm.ship.logic.ShipLogic;
import jo.sm.ui.RenderFrame;
import jo.sm.ui.act.GenericAction;
import jo.sm.ui.logic.ShipSpec;
import jo.vecmath.Point3i;

@SuppressWarnings("serial")
public class SaveAction extends GenericAction
{
    private RenderFrame mFrame;
    
    public SaveAction(RenderFrame frame)
    {
        mFrame = frame;
        setName("Save");
        setToolTipText("Save object back to source");
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        if (mFrame.getSpec() == null)
            return;
        if (mFrame.getSpec().getType() == ShipSpec.FILE)
            doSaveFile();
        else if (mFrame.getSpec().getType() == ShipSpec.ENTITY)
            doSaveEntity();
    }
    
    private void doSaveFile()
    {
        
    }
    
    private void doSaveEntity()
    {
        System.out.println("Saving "+mFrame.getSpec().getName());
        SparseMatrix<Block> grid = mFrame.getClient().getGrid();
        Map<Point3i, Data> data = ShipLogic.getData(grid);
        File baseDir = new File(mFrame.getSpec().getEntity().getFile().getParentFile(), "DATA");
        String baseName = mFrame.getSpec().getEntity().getFile().getName();
        System.out.println("Saving "+mFrame.getSpec().getEntity().getFile().toString());
        baseName = baseName.substring(0, baseName.length() - 4); // remove .ent
        try
        {
            DataLogic.writeFiles(data, baseDir, baseName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }        
    }

}
