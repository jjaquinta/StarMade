package org.dom4j;

public abstract interface Attribute extends Node
{
  public abstract QName getQName();

  public abstract Namespace getNamespace();

  public abstract void setNamespace(Namespace paramNamespace);

  public abstract String getNamespacePrefix();

  public abstract String getNamespaceURI();

  public abstract String getQualifiedName();

  public abstract String getValue();

  public abstract void setValue(String paramString);

  public abstract Object getData();

  public abstract void setData(Object paramObject);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.dom4j.Attribute
 * JD-Core Version:    0.6.2
 */