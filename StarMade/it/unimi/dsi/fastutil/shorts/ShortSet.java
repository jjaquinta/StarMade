package it.unimi.dsi.fastutil.shorts;

import java.util.Set;

public abstract interface ShortSet extends ShortCollection, Set<Short>
{
  public abstract ShortIterator iterator();

  public abstract boolean remove(short paramShort);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.shorts.ShortSet
 * JD-Core Version:    0.6.2
 */