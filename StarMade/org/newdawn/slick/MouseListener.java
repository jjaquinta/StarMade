package org.newdawn.slick;

public abstract interface MouseListener extends ControlledInputReciever
{
  public abstract void mouseWheelMoved(int paramInt);

  public abstract void mouseClicked(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void mousePressed(int paramInt1, int paramInt2, int paramInt3);

  public abstract void mouseReleased(int paramInt1, int paramInt2, int paramInt3);

  public abstract void mouseMoved(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void mouseDragged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.newdawn.slick.MouseListener
 * JD-Core Version:    0.6.2
 */