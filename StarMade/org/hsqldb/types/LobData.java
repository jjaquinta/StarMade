package org.hsqldb.types;

import org.hsqldb.SessionInterface;

public abstract interface LobData
{
  public abstract long length(SessionInterface paramSessionInterface);

  public abstract long getId();

  public abstract void setId(long paramLong);

  public abstract void setSession(SessionInterface paramSessionInterface);

  public abstract boolean isBinary();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.hsqldb.types.LobData
 * JD-Core Version:    0.6.2
 */