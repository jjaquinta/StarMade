package it.unimi.dsi.fastutil.floats;

import it.unimi.dsi.fastutil.Stack;

public abstract interface FloatStack extends Stack<Float>
{
  public abstract void push(float paramFloat);

  public abstract float popFloat();

  public abstract float topFloat();

  public abstract float peekFloat(int paramInt);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.floats.FloatStack
 * JD-Core Version:    0.6.2
 */