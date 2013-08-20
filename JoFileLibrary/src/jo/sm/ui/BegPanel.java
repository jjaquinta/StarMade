package jo.sm.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BegPanel extends JPanel
{
    private static final int TICK = 200;
    private static final int CHOP = 120;

    private static final String THE_RAIDERS_LAMENT_AUDIO = "http://podiobooks.com/title/the-raiders-lament";
    private static final String THE_RAIDERS_LAMENT = "https://www.smashwords.com/books/view/347157";
    
    private int mMessageOffset;
    private int mRepeats;
    
    private JLabel  mStatus;
    private JButton mAudio;
    private JButton mText;
    
    public BegPanel()
    {
        mRepeats = 3;
        // instantiate
        mStatus = new JLabel(MESSAGE.substring(0, CHOP));
        setBackground(Color.cyan);
        mAudio = new JButton("Audiobook");
        mText = new JButton("E-book");
        Dimension d1 = mAudio.getPreferredSize();
        Dimension d2 = mText.getPreferredSize();
        mStatus.setPreferredSize(new Dimension(1024 - d1.width - d2.width, Math.max(d1.height, d2.height)));
        // layout
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add("Center", mStatus);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(mAudio);
        buttons.add(mText);
        add("East", buttons);
        // link
        Thread t = new Thread("beg_ticker") { public void run() { doTicker(); } };
        t.setDaemon(true);
        t.start();
        mText.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                doGoto(THE_RAIDERS_LAMENT);
            }            
        });
        mText.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                doGoto(THE_RAIDERS_LAMENT_AUDIO);
            }            
        });
    }
    
    private void doTicker()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
        }
        for (;;)
        {
            try
            {
                Thread.sleep(TICK);
            }
            catch (InterruptedException e)
            {
            }
            mMessageOffset++;
            if (mMessageOffset == MESSAGE.length())
            {
                mMessageOffset = 0;
                mRepeats--;
                if (mRepeats < 0)
                    return;
            }
            String msg = MESSAGE.substring(mMessageOffset) + MESSAGE.substring(0, mMessageOffset);
            msg = msg.substring(0, CHOP);
            mStatus.setText(msg);
        }
    }
    
    private void doGoto(String url)
    {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Action.BROWSE))
                try {
                    desktop.browse(URI.create(url));
                    return;
                } catch (IOException e) {
                    // handled below
                }
        }
    }

    private static final String MESSAGE = "This software is made freely available with no charge or limitation. "
            + "Even the source is included. "
            + "It is distributed as \"begware\", and here is the begging. "
            + "If you like and use this software, please go and download my book \"The Raider's Lament\". "
            + "It's a light hearted Sci-Fi novel that's a fun waste of time. "
            + "You don't have to actually read/listen to it. "
            + "(The recording is not the best.) "
            + "Clocking up the downloads is appreciated. "
            + "If you *really* like this software (or the story) you could buy or donate to it. "
            + "Proceeds will go towards buying my daughter the Minecraft Lego Kit! "
            + "                                                           ";
}
