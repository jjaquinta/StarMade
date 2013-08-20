package jo.sm.ui.act.file;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import jo.sm.logic.DraftImageLogic;
import jo.sm.ui.RenderFrame;
import jo.sm.ui.act.GenericAction;

@SuppressWarnings("serial")
public class ExportImagesAction extends GenericAction
{
    private File mDirectory;
    private int  mWidth;
    private int  mHeight;
    private RenderFrame mFrame;
    
    public ExportImagesAction(RenderFrame frame)
    {
        mFrame = frame;
        mDirectory = new File(System.getProperty("user.home"));
        mWidth = 1024;
        mHeight = 768;
        setName("Export Images");
        setToolTipText("Save drafting style images");
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        if (mFrame.getSpec() == null)
            return;
        String name = mFrame.getSpec().getName();
        ExportImagesDlg dlg = new ExportImagesDlg(mFrame, mDirectory, name, mWidth, mHeight);
        dlg.setVisible(true);
        if (dlg.getDirectory() == null)
            return;
        mDirectory = dlg.getDirectory();
        name = dlg.getName();
        mWidth = dlg.getWidth();
        mHeight = dlg.getHeight();
        try
        {
            DraftImageLogic.saveDrafImages(mDirectory, name, new Dimension(mWidth, mHeight), mFrame.getClient().getGrid());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
