package org.jaxen;

import java.util.Iterator;

public abstract interface NamedAccessNavigator extends Navigator
{
  public abstract Iterator getChildAxisIterator(Object paramObject, String paramString1, String paramString2, String paramString3)
    throws UnsupportedAxisException;

  public abstract Iterator getAttributeAxisIterator(Object paramObject, String paramString1, String paramString2, String paramString3)
    throws UnsupportedAxisException;
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jaxen.NamedAccessNavigator
 * JD-Core Version:    0.6.2
 */