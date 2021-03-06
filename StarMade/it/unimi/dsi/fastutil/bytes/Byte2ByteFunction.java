package it.unimi.dsi.fastutil.bytes;

import it.unimi.dsi.fastutil.Function;

public abstract interface Byte2ByteFunction extends Function<Byte, Byte>
{
  public abstract byte put(byte paramByte1, byte paramByte2);

  public abstract byte get(byte paramByte);

  public abstract byte remove(byte paramByte);

  public abstract boolean containsKey(byte paramByte);

  public abstract void defaultReturnValue(byte paramByte);

  public abstract byte defaultReturnValue();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
 * JD-Core Version:    0.6.2
 */