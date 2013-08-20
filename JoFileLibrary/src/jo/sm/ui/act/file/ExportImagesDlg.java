package jo.sm.ui.act.file;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jo.sm.ui.TableLayout;

@SuppressWarnings("serial")
public class ExportImagesDlg extends JDialog
{
    private File    mDirectory;
    private String  mName;
    private int     mWidth;
    private int     mHeight;
    
    private JTextField  mDirectoryCtrl;
    private JTextField  mNameCtrl;
    private JTextField  mWidthCtrl;
    private JTextField  mHeightCtrl;
    
    public ExportImagesDlg(JFrame base, File directory, String name, int width, int height)
    {
        super(base, "Export Images", Dialog.ModalityType.DOCUMENT_MODAL);
        mDirectory = directory;
        mName = name;
        mWidth = width;
        mHeight = height;
        // instantiate
        mDirectoryCtrl = new JTextField(mDirectory.toString());
        JButton browse = new JButton("Browse...");
        mNameCtrl = new JTextField(mName);
        mWidthCtrl = new JTextField(String.valueOf(mWidth));
        mHeightCtrl = new JTextField(String.valueOf(mHeight));
        JButton ok = new JButton("OK");
        ok.setDefaultCapable(true);
        JButton cancel = new JButton("Cancel");
        // layout
        JPanel inputs = new JPanel();
        inputs.setLayout(new TableLayout());
        inputs.add("1,1", new JLabel("Directory:"));
        inputs.add("+,.", mDirectoryCtrl);
        inputs.add("+,.", browse);
        inputs.add("1,+", new JLabel("Name:"));
        inputs.add("+,.", mNameCtrl);
        inputs.add("1,+", new JLabel("Width:"));
        inputs.add("+,.", mWidthCtrl);
        inputs.add("1,+", new JLabel("Height:"));
        inputs.add("+,.", mHeightCtrl);
        
        JPanel client = new JPanel();
        getContentPane().add(client);
        client.setLayout(new BorderLayout());
        client.add(BorderLayout.CENTER, inputs);
        JPanel buttonBar = new JPanel();
        client.add(BorderLayout.SOUTH, buttonBar);
        buttonBar.setLayout(new FlowLayout());
        buttonBar.add(ok);
        buttonBar.add(cancel);
        // link
        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                doOK();
            }});
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                doCancel();
            }});
        
        setSize(640, 480);
        setLocationRelativeTo(base);
    }
    
    private void doOK()
    {
        mDirectory = new File(mDirectoryCtrl.getText());
        mName = mNameCtrl.getText();
        mWidth = Integer.parseInt(mWidthCtrl.getText());
        mHeight = Integer.parseInt(mHeightCtrl.getText());
        setVisible(false);
        dispose();
    }
    
    private void doCancel()
    {
        mDirectory = null;
        setVisible(false);
        dispose();
    }

    public File getDirectory()
    {
        return mDirectory;
    }

    public void setDirectory(File directory)
    {
        mDirectory = directory;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public int getWidth()
    {
        return mWidth;
    }

    public void setWidth(int width)
    {
        mWidth = width;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public void setHeight(int height)
    {
        mHeight = height;
    }
}
