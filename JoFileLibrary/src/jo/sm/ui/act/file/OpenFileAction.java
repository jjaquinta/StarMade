package jo.sm.ui.act.file;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import jo.sm.data.SparseMatrix;
import jo.sm.logic.StarMadeLogic;
import jo.sm.mods.IBlocksPlugin;
import jo.sm.ship.data.Block;
import jo.sm.ship.data.Data;
import jo.sm.ship.data.Header;
import jo.sm.ship.data.Logic;
import jo.sm.ship.data.Meta;
import jo.sm.ship.logic.DataLogic;
import jo.sm.ship.logic.HeaderLogic;
import jo.sm.ship.logic.LogicLogic;
import jo.sm.ship.logic.MetaLogic;
import jo.sm.ship.logic.ShipLogic;
import jo.sm.ui.RenderFrame;
import jo.sm.ui.act.GenericAction;
import jo.sm.ui.logic.ShipSpec;
import jo.vecmath.Point3i;

@SuppressWarnings("serial")
public class OpenFileAction extends GenericAction
{
    private RenderFrame mFrame;
    
    public OpenFileAction(RenderFrame frame)
    {
        mFrame = frame;
        setName("Open File...");
        setToolTipText("Open a file on disk");
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        File dir;
        if (StarMadeLogic.getProps().contains("open.file.dir"))
            dir = new File(StarMadeLogic.getProps().getProperty("open.file.dir"));
        else
            dir = StarMadeLogic.getInstance().getBaseDir();
        JFileChooser chooser = new JFileChooser(StarMadeLogic.getInstance().getBaseDir());
        chooser.setSelectedFile(dir);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
            "Starmade Ship File", "smd2");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "Starmade Exported Ship File", "sment");
        chooser.addChoosableFileFilter(filter1);
        chooser.addChoosableFileFilter(filter2);
        int returnVal = chooser.showOpenDialog(mFrame);
        if(returnVal != JFileChooser.APPROVE_OPTION)
            return;
       File smb2 = chooser.getSelectedFile();
       StarMadeLogic.getProps().setProperty("open.file.dir", smb2.getParent());
       StarMadeLogic.saveProps();
       String name = smb2.getName();
       try
       {
           Header header = null;
           Meta meta = null;
           Logic logic = null;
           Map<Point3i, Data> data = new HashMap<Point3i, Data>();
           InputStream is = new FileInputStream(smb2);;
           if (smb2.getName().endsWith(".smd2"))
           {
               Data datum = DataLogic.readFile(is, true);
               data.put(new Point3i(), datum);
               name = name.substring(0, name.length() - 5);
           }
           else if (smb2.getName().endsWith(".sment"))
           {
               name = null;
               ZipInputStream zis = new ZipInputStream(new FileInputStream(smb2));
               for (;;)
               {
                   ZipEntry entry = zis.getNextEntry();
                   if (entry == null)
                       break;
                   String ename = entry.getName();
                   if (name == null)
                   {
                       int o = ename.indexOf('/');
                       if (o > 0)
                           name = ename.substring(0, o);
                   }
                   if (name != null)
                       if (ename.startsWith(name+"/DATA/") && ename.endsWith(".smd2"))
                       {
                           Data datum = DataLogic.readFile(zis, false);
                           String[] parts = entry.getName().split("\\.");
                           Point3i position = new Point3i(Integer.parseInt(parts[1]),
                                   Integer.parseInt(parts[2]),
                                   Integer.parseInt(parts[3]));
                           data.put(position, datum);
                       }
                       else if (ename.equals(name+"/header.smbph"))
                           header = HeaderLogic.readFile(zis, false);
                       else if (ename.equals(name+"/logic.smbpl"))
                           logic = LogicLogic.readFile(zis, false);
                       else if (ename.equals(name+"/meta.smbpm"))
                           meta = MetaLogic.readFile(zis, false);
               }
               zis.close();
           }
           else
           {
               is.close();
               throw new IllegalArgumentException("Unsupported file type '"+smb2+"'");
           }
           SparseMatrix<Block> grid = ShipLogic.getBlocks(data);
           ShipSpec spec = new ShipSpec();
           spec.setName(name);
           spec.setType(ShipSpec.FILE);
           spec.setClassification(IBlocksPlugin.TYPE_SHIP); // TODO: autodetect
           spec.setFile(smb2);
           mFrame.setSpec(spec);
           mFrame.getClient().setGrid(grid);
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }

}
