package it.unimi.dsi.fastutil.doubles;

import java.util.ListIterator;

public abstract interface DoubleListIterator extends ListIterator<Double>, DoubleBidirectionalIterator
{
  public abstract void set(double paramDouble);

  public abstract void add(double paramDouble);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.doubles.DoubleListIterator
 * JD-Core Version:    0.6.2
 */