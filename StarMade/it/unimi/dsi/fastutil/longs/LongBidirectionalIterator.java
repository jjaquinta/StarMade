package it.unimi.dsi.fastutil.longs;

import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

public abstract interface LongBidirectionalIterator extends LongIterator, ObjectBidirectionalIterator<Long>
{
  public abstract long previousLong();

  public abstract int back(int paramInt);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
 * JD-Core Version:    0.6.2
 */