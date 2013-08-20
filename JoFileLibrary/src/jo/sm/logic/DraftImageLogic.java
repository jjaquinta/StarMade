package jo.sm.logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import jo.sm.data.RenderTile;
import jo.sm.data.SparseMatrix;
import jo.sm.ship.data.Block;
import jo.vecmath.Matrix3f;
import jo.vecmath.Matrix4f;
import jo.vecmath.Point3f;
import jo.vecmath.Point3i;
import jo.vecmath.Vector3f;
import jo.vecmath.logic.Matrix4fLogic;

public class DraftImageLogic
{
    public static void saveDrafImages(File dir, String name, Dimension size, SparseMatrix<Block> grid) throws IOException
    {
        String space = "_";
        if (name.indexOf(" ") >= 0)
            space = " ";
        Point3i lower = new Point3i();
        Point3i upper = new Point3i();
        grid.getBounds(lower, upper);
        int shipWidth = upper.x - lower.x + 1;
        int shipHeight = upper.z - lower.z + 1;
        int shipDepth = upper.y - lower.y + 1;
        int shipMass = grid.size();

        BufferedImage contactSheet = new BufferedImage(size.width,  size.height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = contactSheet.getGraphics();
        BufferedImage img;

        img = saveDraftImage(new File(dir, name+space+"fore.png"), size, grid, (float)Math.PI, 0);
        g.drawImage(img, size.width*1/3, size.height*1/3, size.width*2/3, size.height*2/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"port.png"), size, grid, (float)Math.PI, (float)Math.PI/2f);
        g.drawImage(img, size.width*2/3, size.height*1/3, size.width*3/3, size.height*2/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"aft.png"), size, grid, (float)Math.PI, (float)Math.PI);
        g.drawImage(img, size.width*2/3, size.height*0/3, size.width*3/3, size.height*1/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"starboard.png"), size, grid, (float)Math.PI, -(float)Math.PI/2f);
        g.drawImage(img, size.width*0/3, size.height*1/3, size.width*1/3, size.height*2/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"dorsal.png"), size, grid, -(float)Math.PI/2, 0);
        g.drawImage(img, size.width*1/3, size.height*0/3, size.width*2/3, size.height*1/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"ventral.png"), size, grid, (float)Math.PI/2, 0);
        g.drawImage(img, size.width*1/3, size.height*2/3, size.width*2/3, size.height*3/3, 0, 0, size.width, size.height, null);
        img = saveDraftImage(new File(dir, name+space+"iso.png"), size, grid, 1.125f*(float)Math.PI, 0.125f*(float)Math.PI);
        g.drawImage(img, size.width*2/3, size.height*2/3, size.width*3/3, size.height*3/3, 0, 0, size.width, size.height, null);
        
        int dy = g.getFontMetrics().getHeight();
        int y = dy*2;
        g.drawString(name, size.width/3/4, y);
        y += dy;
        g.drawString("Width: "+shipWidth, size.width/3/4, y);
        y += dy;
        g.drawString("Height: "+shipHeight, size.width/3/4, y);
        y += dy;
        g.drawString("Depth: "+shipDepth, size.width/3/4, y);
        y += dy;
        g.drawString("Mass: "+shipMass, size.width/3/4, y);

        g.dispose();
        ImageIO.write(contactSheet, "PNG", new File(dir, name+space+"contact.png"));
    }
    
    public static BufferedImage saveDraftImage(File f, Dimension size, SparseMatrix<Block> grid, float rotX, float rotY) throws IOException
    {
        BufferedImage img = getDraftImage(grid, size, rotX, rotY);
        ImageIO.write(img, "PNG", f);
        return img;
    }
    
    public static BufferedImage getDraftImage(SparseMatrix<Block> grid, Dimension size, float rotX, float rotY)
    {
        Matrix4f transform = new Matrix4f();
        Vector3f mPreTranslate = new Vector3f();
        float  scale;
        Vector3f postTranslate = new Vector3f();
        List<RenderTile> tiles = RenderLogic.getRender(grid);

        Point3i lower = new Point3i();
        Point3i upper = new Point3i();
        grid.getBounds(lower, upper);
        mPreTranslate.x = -(lower.x + upper.x)/2;
        mPreTranslate.y = -(lower.y + upper.y)/2;
        mPreTranslate.z = -(lower.z + upper.z)/2;
        float maxModel = Math.max(Math.max(upper.x - lower.x, upper.y - lower.y), upper.z - lower.z);
        float maxScreen = Math.max(size.width, size.height);
        scale = maxScreen/maxModel/2f;

        postTranslate.x = size.width/2;
        postTranslate.y = size.height/2;
        
        transform.setIdentity();
        Matrix4fLogic.translate(transform, mPreTranslate);
        Matrix4fLogic.scale(transform, scale);
        Matrix4fLogic.rotX(transform, rotX);
        Matrix4fLogic.rotY(transform, rotY);
        Matrix4fLogic.translate(transform, postTranslate);
        
        Matrix3f rot = new Matrix3f();
        transform.get(rot);
        Point3f unitX = new Point3f(scale, 0, 0);
        rot.transform(unitX);
        Point3f unitY = new Point3f(0, scale, 0);
        rot.transform(unitY);
        Point3f unitZ = new Point3f(0, 0, scale);
        rot.transform(unitZ);
        
        BufferedImage img = new BufferedImage(size.width,  size.height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        
        RenderLogic.transformAndSort(tiles, transform);
        RenderLogic.draw(g2, tiles, unitX, unitY, unitZ);
        g2.dispose();
        return img;
    }
}
