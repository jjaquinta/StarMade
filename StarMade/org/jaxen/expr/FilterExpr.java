package org.jaxen.expr;

import org.jaxen.Context;
import org.jaxen.JaxenException;

public abstract interface FilterExpr extends Expr, Predicated
{
  public abstract boolean asBoolean(Context paramContext)
    throws JaxenException;

  public abstract Expr getExpr();
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jaxen.expr.FilterExpr
 * JD-Core Version:    0.6.2
 */