/*    */ package org.jaxen.xom;
/*    */ 
/*    */ import org.jaxen.BaseXPath;
/*    */ import org.jaxen.JaxenException;
/*    */ 
/*    */ public class XOMXPath extends BaseXPath
/*    */ {
/*    */   private static final long serialVersionUID = -5332108546921857671L;
/*    */ 
/*    */   public XOMXPath(String xpathExpr)
/*    */     throws JaxenException
/*    */   {
/* 88 */     super(xpathExpr, new DocumentNavigator());
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jaxen.xom.XOMXPath
 * JD-Core Version:    0.6.2
 */