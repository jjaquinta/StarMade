package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

public abstract interface Drawable
{
  public abstract boolean isCurrent()
    throws LWJGLException;

  public abstract void makeCurrent()
    throws LWJGLException;

  public abstract void releaseContext()
    throws LWJGLException;

  public abstract void destroy();

  public abstract void setCLSharingProperties(PointerBuffer paramPointerBuffer)
    throws LWJGLException;
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.lwjgl.opengl.Drawable
 * JD-Core Version:    0.6.2
 */