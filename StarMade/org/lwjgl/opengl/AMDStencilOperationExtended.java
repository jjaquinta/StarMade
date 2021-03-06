/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.BufferChecks;
/*    */ 
/*    */ public final class AMDStencilOperationExtended
/*    */ {
/*    */   public static final int GL_SET_AMD = 34634;
/*    */   public static final int GL_AND = 5377;
/*    */   public static final int GL_XOR = 5382;
/*    */   public static final int GL_OR = 5383;
/*    */   public static final int GL_NOR = 5384;
/*    */   public static final int GL_EQUIV = 5385;
/*    */   public static final int GL_NAND = 5390;
/*    */   public static final int GL_REPLACE_VALUE_AMD = 34635;
/*    */   public static final int GL_STENCIL_OP_VALUE_AMD = 34636;
/*    */   public static final int GL_STENCIL_BACK_OP_VALUE_AMD = 34637;
/*    */ 
/*    */   public static void glStencilOpValueAMD(int face, int value)
/*    */   {
/* 33 */     ContextCapabilities caps = GLContext.getCapabilities();
/* 34 */     long function_pointer = caps.glStencilOpValueAMD;
/* 35 */     BufferChecks.checkFunctionAddress(function_pointer);
/* 36 */     nglStencilOpValueAMD(face, value, function_pointer);
/*    */   }
/*    */ 
/*    */   static native void nglStencilOpValueAMD(int paramInt1, int paramInt2, long paramLong);
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.lwjgl.opengl.AMDStencilOperationExtended
 * JD-Core Version:    0.6.2
 */