package it.unimi.dsi.fastutil.doubles;

public abstract interface DoubleHash
{
  public static abstract interface Strategy
  {
    public abstract int hashCode(double paramDouble);

    public abstract boolean equals(double paramDouble1, double paramDouble2);
  }
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.doubles.DoubleHash
 * JD-Core Version:    0.6.2
 */