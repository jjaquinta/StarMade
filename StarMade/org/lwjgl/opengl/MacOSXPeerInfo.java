/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.LWJGLException;
/*    */ import org.lwjgl.LWJGLUtil;
/*    */ 
/*    */ abstract class MacOSXPeerInfo extends PeerInfo
/*    */ {
/*    */   MacOSXPeerInfo(PixelFormat pixel_format, ContextAttribs attribs, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered)
/*    */     throws LWJGLException
/*    */   {
/* 47 */     super(createHandle());
/*    */ 
/* 49 */     boolean gl32 = (attribs != null) && (attribs.getMajorVersion() == 3) && (attribs.getMinorVersion() == 2) && (attribs.isProfileCore());
/* 50 */     if ((gl32) && (!LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 7))) {
/* 51 */       throw new LWJGLException("OpenGL 3.2 requested, but it requires MacOS X 10.7 or newer");
/*    */     }
/* 53 */     choosePixelFormat(pixel_format, gl32, use_display_bpp, support_window, support_pbuffer, double_buffered);
/*    */   }
/*    */   private static native ByteBuffer createHandle();
/*    */ 
/*    */   private void choosePixelFormat(PixelFormat pixel_format, boolean gl32, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
/* 58 */     nChoosePixelFormat(getHandle(), pixel_format, gl32, use_display_bpp, support_window, support_pbuffer, double_buffered);
/*    */   }
/*    */   private static native void nChoosePixelFormat(ByteBuffer paramByteBuffer, PixelFormat paramPixelFormat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) throws LWJGLException;
/*    */ 
/*    */   public void destroy() {
/* 63 */     nDestroy(getHandle());
/*    */   }
/*    */ 
/*    */   private static native void nDestroy(ByteBuffer paramByteBuffer);
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.lwjgl.opengl.MacOSXPeerInfo
 * JD-Core Version:    0.6.2
 */