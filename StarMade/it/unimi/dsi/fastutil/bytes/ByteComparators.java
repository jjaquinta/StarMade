/*    */ package it.unimi.dsi.fastutil.bytes;
/*    */ 
/*    */ public class ByteComparators
/*    */ {
/* 51 */   public static final ByteComparator NATURAL_COMPARATOR = new AbstractByteComparator() {
/*    */     public final int compare(byte a, byte b) {
/* 53 */       return a == b ? 0 : a < b ? -1 : 1;
/*    */     }
/* 51 */   };
/*    */ 
/* 58 */   public static final ByteComparator OPPOSITE_COMPARATOR = new AbstractByteComparator() {
/*    */     public final int compare(byte a, byte b) {
/* 60 */       return b == a ? 0 : b < a ? -1 : 1;
/*    */     }
/* 58 */   };
/*    */ 
/*    */   public static ByteComparator oppositeComparator(ByteComparator c)
/*    */   {
/* 69 */     return new AbstractByteComparator() {
/* 70 */       private final ByteComparator comparator = this.val$c;
/*    */ 
/* 72 */       public final int compare(byte a, byte b) { return -this.comparator.compare(a, b); }
/*    */ 
/*    */     };
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.bytes.ByteComparators
 * JD-Core Version:    0.6.2
 */