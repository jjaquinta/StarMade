package it.unimi.dsi.fastutil.booleans;

import java.util.Iterator;

public abstract interface BooleanIterator extends Iterator<Boolean>
{
  public abstract boolean nextBoolean();

  public abstract int skip(int paramInt);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.booleans.BooleanIterator
 * JD-Core Version:    0.6.2
 */