package it.unimi.dsi.fastutil.doubles;

import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

public abstract interface DoubleBidirectionalIterator extends DoubleIterator, ObjectBidirectionalIterator<Double>
{
  public abstract double previousDouble();

  public abstract int back(int paramInt);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
 * JD-Core Version:    0.6.2
 */