/*    */ package org.jaxen.expr;
/*    */ 
/*    */ import org.jaxen.ContextSupport;
/*    */ import org.jaxen.Navigator;
/*    */ import org.jaxen.expr.iter.IterableAxis;
/*    */ 
/*    */ /** @deprecated */
/*    */ public class DefaultTextNodeStep extends DefaultStep
/*    */   implements TextNodeStep
/*    */ {
/*    */   private static final long serialVersionUID = -3821960984972022948L;
/*    */ 
/*    */   public DefaultTextNodeStep(IterableAxis axis, PredicateSet predicateSet)
/*    */   {
/* 69 */     super(axis, predicateSet);
/*    */   }
/*    */ 
/*    */   public boolean matches(Object node, ContextSupport support)
/*    */   {
/* 75 */     Navigator nav = support.getNavigator();
/*    */ 
/* 77 */     return nav.isText(node);
/*    */   }
/*    */ 
/*    */   public String getText()
/*    */   {
/* 82 */     return getAxisName() + "::text()" + super.getText();
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jaxen.expr.DefaultTextNodeStep
 * JD-Core Version:    0.6.2
 */