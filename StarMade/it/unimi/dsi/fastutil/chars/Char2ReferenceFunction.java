package it.unimi.dsi.fastutil.chars;

import it.unimi.dsi.fastutil.Function;

public abstract interface Char2ReferenceFunction<V> extends Function<Character, V>
{
  public abstract V put(char paramChar, V paramV);

  public abstract V get(char paramChar);

  public abstract V remove(char paramChar);

  public abstract boolean containsKey(char paramChar);

  public abstract void defaultReturnValue(V paramV);

  public abstract V defaultReturnValue();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
 * JD-Core Version:    0.6.2
 */