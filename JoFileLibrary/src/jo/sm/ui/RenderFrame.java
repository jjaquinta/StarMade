package jo.sm.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import jo.sm.logic.StarMadeLogic;
import jo.sm.mods.IBlocksPlugin;
import jo.sm.ui.act.edit.HardenAction;
import jo.sm.ui.act.edit.SmoothAction;
import jo.sm.ui.act.edit.SoftenAction;
import jo.sm.ui.act.file.ExportImagesAction;
import jo.sm.ui.act.file.OpenExistingAction;
import jo.sm.ui.act.file.OpenFileAction;
import jo.sm.ui.act.file.QuitAction;
import jo.sm.ui.act.file.SaveAction;
import jo.sm.ui.act.file.SaveAsBlueprintAction;
import jo.sm.ui.act.file.SaveAsFileAction;
import jo.sm.ui.act.plugin.BlocksPluginAction;
import jo.sm.ui.act.view.FilterMissileDumbAction;
import jo.sm.ui.act.view.FilterMissileFafoAction;
import jo.sm.ui.act.view.FilterMissileHeatAction;
import jo.sm.ui.act.view.FilterNoneAction;
import jo.sm.ui.act.view.FilterPowerAction;
import jo.sm.ui.act.view.FilterRepairAction;
import jo.sm.ui.act.view.FilterSalvageAction;
import jo.sm.ui.act.view.FilterThrusterAction;
import jo.sm.ui.act.view.FilterWeaponsAction;
import jo.sm.ui.logic.ShipSpec;

@SuppressWarnings("serial")
public class RenderFrame extends JFrame implements WindowListener
{
    private ShipSpec    mSpec;
    private RenderPanel mClient;

    public RenderFrame()
    {
        super("StarMade Ship Preview");
        // instantiate
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuView = new JMenu("View");
        JMenu menuModify = new JMenu("Modify");
        JMenu menuViewMissiles = new JMenu("Missiles");
        mClient = new RenderPanel();
        // layout
        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuFile.add(new OpenExistingAction(this));
        menuFile.add(new OpenFileAction(this));
        menuFile.add(new SaveAction(this));
        JMenu saveAs = new JMenu("Save As");
        menuFile.add(saveAs);
        saveAs.add(new SaveAsBlueprintAction(this, false));
        saveAs.add(new SaveAsBlueprintAction(this, true));
        saveAs.add(new SaveAsFileAction(this));
        menuFile.add(new ExportImagesAction(this));
        menuFile.add(new QuitAction(this));
        menuBar.add(menuEdit);
        menuEdit.add(new SmoothAction(this));
        menuEdit.add(new HardenAction(this));
        menuEdit.add(new SoftenAction(this));
        menuBar.add(menuView);
        menuView.add(new FilterNoneAction(this));
        menuView.add(new FilterPowerAction(this));
        menuView.add(new FilterThrusterAction(this));
        menuView.add(new FilterRepairAction(this));
        menuView.add(new FilterSalvageAction(this));
        menuView.add(new FilterWeaponsAction(this));
        menuView.add(menuViewMissiles);
        menuViewMissiles.add(new FilterMissileDumbAction(this));
        menuViewMissiles.add(new FilterMissileHeatAction(this));
        menuViewMissiles.add(new FilterMissileFafoAction(this));
        menuBar.add(menuModify);
        getContentPane().add(BorderLayout.WEST, new EditPanel(mClient));
        getContentPane().add(BorderLayout.CENTER, mClient);
        getContentPane().add(BorderLayout.SOUTH, new BegPanel());
        // link
        menuModify.addMenuListener(new MenuListener() {            
            @Override
            public void menuSelected(MenuEvent ev)
            {
                updateModify((JMenu)ev.getSource());
            }            
            @Override
            public void menuDeselected(MenuEvent e)
            {
            }            
            @Override
            public void menuCanceled(MenuEvent e)
            {
            }
        });
        this.addWindowListener(this);
        setSize(1024, 768);
    }

    public void windowClosing(WindowEvent evt)
    {
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent evt)
    {
    }

    public void windowClosed(WindowEvent evt)
    {
    }

    public void windowIconified(WindowEvent evt)
    {
    }

    public void windowDeiconified(WindowEvent evt)
    {
    }

    public void windowActivated(WindowEvent evt)
    {
    }

    public void windowDeactivated(WindowEvent evt)
    {
    }

    private void updateModify(JMenu modify)
    {
        modify.removeAll();
        if (mSpec == null)
            return;
        int type = mSpec.getClassification();
        List<IBlocksPlugin> plugins = StarMadeLogic.getBlocksPlugins(type, IBlocksPlugin.SUBTYPE_MODIFY);
        if (plugins.size() == 0)
            return;
        for (IBlocksPlugin plugin : plugins)
        {
            BlocksPluginAction action = new BlocksPluginAction(mClient, plugin);
            JMenuItem menu = new JMenuItem(action);
            modify.add(menu);
        }
    }
    
    private static void preLoad()
    {
        Properties props = StarMadeLogic.getProps();
        String home = props.getProperty("starmade.home", "");
        if (!StarMadeLogic.isStarMadeDirectory(home))
        {
            home = System.getProperty("user.dir");
            if (!StarMadeLogic.isStarMadeDirectory(home))
            {
                home = JOptionPane.showInputDialog(null, "Enter in the home directory for StarMade", home);
                if (home == null)
                    System.exit(0);
            }
            props.put("starmade.home", home);
            StarMadeLogic.saveProps();
        }
        StarMadeLogic.setBaseDir(home);
    }

    public static void main(String[] args)
    {
        preLoad();
        RenderFrame f = new RenderFrame();
        f.setVisible(true);
    }

    public ShipSpec getSpec()
    {
        return mSpec;
    }

    public void setSpec(ShipSpec spec)
    {
        mSpec = spec;
        mClient.setSpec(mSpec);
    }

    public RenderPanel getClient()
    {
        return mClient;
    }

    public void setClient(RenderPanel client)
    {
        mClient = client;
    }
}
