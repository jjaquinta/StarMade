/*    */ import javax.vecmath.Vector3f;
/*    */ 
/*    */ public class zg
/*    */ {
/*    */   public static Vector3f[][] a(Vector3f paramVector3f1, Vector3f paramVector3f2)
/*    */   {
/* 29 */     return a(paramVector3f1, paramVector3f2, a());
/*    */   }
/*    */   public static Vector3f[][] a(Vector3f paramVector3f1, Vector3f paramVector3f2, Vector3f[][] paramArrayOfVector3f) {
/* 32 */     if ((!a) && (paramArrayOfVector3f == null)) throw new AssertionError();
/* 33 */     if ((!a) && (paramArrayOfVector3f.length != 6)) throw new AssertionError(paramArrayOfVector3f.length);
/* 34 */     if ((!a) && (paramArrayOfVector3f[0].length != 4)) throw new AssertionError(paramArrayOfVector3f[0].length);
/* 35 */     paramArrayOfVector3f[0][0].set(paramVector3f2.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[0][1].set(paramVector3f2.x, paramVector3f2.y, paramVector3f1.z); paramArrayOfVector3f[0][2].set(paramVector3f2.x, paramVector3f2.y, paramVector3f2.z); paramArrayOfVector3f[0][3].set(paramVector3f2.x, paramVector3f1.y, paramVector3f2.z);
/* 36 */     paramArrayOfVector3f[1][3].set(paramVector3f1.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[1][2].set(paramVector3f1.x, paramVector3f2.y, paramVector3f1.z); paramArrayOfVector3f[1][1].set(paramVector3f1.x, paramVector3f2.y, paramVector3f2.z); paramArrayOfVector3f[1][0].set(paramVector3f1.x, paramVector3f1.y, paramVector3f2.z);
/*    */ 
/* 38 */     paramArrayOfVector3f[2][3].set(paramVector3f1.x, paramVector3f2.y, paramVector3f1.z); paramArrayOfVector3f[2][2].set(paramVector3f2.x, paramVector3f2.y, paramVector3f1.z); paramArrayOfVector3f[2][1].set(paramVector3f2.x, paramVector3f2.y, paramVector3f2.z); paramArrayOfVector3f[2][0].set(paramVector3f1.x, paramVector3f2.y, paramVector3f2.z);
/* 39 */     paramArrayOfVector3f[3][0].set(paramVector3f1.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[3][1].set(paramVector3f2.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[3][2].set(paramVector3f2.x, paramVector3f1.y, paramVector3f2.z); paramArrayOfVector3f[3][3].set(paramVector3f1.x, paramVector3f1.y, paramVector3f2.z);
/*    */ 
/* 41 */     paramArrayOfVector3f[4][0].set(paramVector3f1.x, paramVector3f1.y, paramVector3f2.z); paramArrayOfVector3f[4][1].set(paramVector3f2.x, paramVector3f1.y, paramVector3f2.z); paramArrayOfVector3f[4][2].set(paramVector3f2.x, paramVector3f2.y, paramVector3f2.z); paramArrayOfVector3f[4][3].set(paramVector3f1.x, paramVector3f2.y, paramVector3f2.z);
/* 42 */     paramArrayOfVector3f[5][3].set(paramVector3f1.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[5][2].set(paramVector3f2.x, paramVector3f1.y, paramVector3f1.z); paramArrayOfVector3f[5][1].set(paramVector3f2.x, paramVector3f2.y, paramVector3f1.z); paramArrayOfVector3f[5][0].set(paramVector3f1.x, paramVector3f2.y, paramVector3f1.z);
/*    */ 
/* 44 */     return paramArrayOfVector3f;
/*    */   }
/*    */ 
/*    */   public static Vector3f[][] a() {
/* 48 */     Vector3f[][] arrayOfVector3f = new Vector3f[6][4];
/* 49 */     for (int i = 0; i < arrayOfVector3f.length; i++) {
/* 50 */       for (int j = 0; j < arrayOfVector3f[i].length; j++) {
/* 51 */         arrayOfVector3f[i][j] = new Vector3f();
/*    */       }
/*    */     }
/* 54 */     return arrayOfVector3f;
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     zg
 * JD-Core Version:    0.6.2
 */