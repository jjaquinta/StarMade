/*    */ package org.dom4j.tree;
/*    */ 
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class DefaultComment extends FlyweightComment
/*    */ {
/*    */   private Element parent;
/*    */ 
/*    */   public DefaultComment(String text)
/*    */   {
/* 33 */     super(text);
/*    */   }
/*    */ 
/*    */   public DefaultComment(Element parent, String text)
/*    */   {
/* 45 */     super(text);
/* 46 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */   public void setText(String text) {
/* 50 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public Element getParent() {
/* 54 */     return this.parent;
/*    */   }
/*    */ 
/*    */   public void setParent(Element parent) {
/* 58 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */   public boolean supportsParent() {
/* 62 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean isReadOnly() {
/* 66 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.dom4j.tree.DefaultComment
 * JD-Core Version:    0.6.2
 */