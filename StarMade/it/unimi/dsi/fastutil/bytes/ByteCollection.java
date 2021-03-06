package it.unimi.dsi.fastutil.bytes;

import java.util.Collection;

public abstract interface ByteCollection extends Collection<Byte>, ByteIterable
{
  public abstract ByteIterator iterator();

  @Deprecated
  public abstract ByteIterator byteIterator();

  public abstract <T> T[] toArray(T[] paramArrayOfT);

  public abstract boolean contains(byte paramByte);

  public abstract byte[] toByteArray();

  public abstract byte[] toByteArray(byte[] paramArrayOfByte);

  public abstract byte[] toArray(byte[] paramArrayOfByte);

  public abstract boolean add(byte paramByte);

  public abstract boolean rem(byte paramByte);

  public abstract boolean addAll(ByteCollection paramByteCollection);

  public abstract boolean containsAll(ByteCollection paramByteCollection);

  public abstract boolean removeAll(ByteCollection paramByteCollection);

  public abstract boolean retainAll(ByteCollection paramByteCollection);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.bytes.ByteCollection
 * JD-Core Version:    0.6.2
 */