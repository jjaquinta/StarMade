package it.unimi.dsi.fastutil.ints;

import it.unimi.dsi.fastutil.BigListIterator;

public abstract interface IntBigListIterator extends IntBidirectionalIterator, BigListIterator<Integer>
{
  public abstract void set(int paramInt);

  public abstract void add(int paramInt);

  public abstract void set(Integer paramInteger);

  public abstract void add(Integer paramInteger);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.ints.IntBigListIterator
 * JD-Core Version:    0.6.2
 */