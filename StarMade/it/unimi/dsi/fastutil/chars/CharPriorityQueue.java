package it.unimi.dsi.fastutil.chars;

import it.unimi.dsi.fastutil.PriorityQueue;

public abstract interface CharPriorityQueue extends PriorityQueue<Character>
{
  public abstract void enqueue(char paramChar);

  public abstract char dequeueChar();

  public abstract char firstChar();

  public abstract char lastChar();

  public abstract CharComparator comparator();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.chars.CharPriorityQueue
 * JD-Core Version:    0.6.2
 */