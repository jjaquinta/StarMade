package org.jaxen.expr;

public abstract interface PathExpr extends Expr
{
  public abstract Expr getFilterExpr();

  public abstract void setFilterExpr(Expr paramExpr);

  public abstract LocationPath getLocationPath();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jaxen.expr.PathExpr
 * JD-Core Version:    0.6.2
 */