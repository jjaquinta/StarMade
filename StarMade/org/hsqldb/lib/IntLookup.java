package org.hsqldb.lib;

import java.util.NoSuchElementException;

public abstract interface IntLookup
{
  public abstract int add(int paramInt1, int paramInt2);

  public abstract int lookup(int paramInt)
    throws NoSuchElementException;

  public abstract int lookup(int paramInt1, int paramInt2);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.hsqldb.lib.IntLookup
 * JD-Core Version:    0.6.2
 */