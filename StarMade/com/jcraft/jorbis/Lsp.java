/*    */ package com.jcraft.jorbis;
/*    */ 
/*    */ class Lsp
/*    */ {
/*    */   static final float M_PI = 3.141593F;
/*    */ 
/*    */   static void lsp_to_curve(float[] curve, int[] map, int n, int ln, float[] lsp, int m, float amp, float ampoffset)
/*    */   {
/* 46 */     float wdel = 3.141593F / ln;
/* 47 */     for (int i = 0; i < m; i++)
/* 48 */       lsp[i] = Lookup.coslook(lsp[i]);
/* 49 */     int m2 = m / 2 * 2;
/*    */ 
/* 51 */     i = 0;
/* 52 */     while (i < n) {
/* 53 */       int k = map[i];
/* 54 */       float p = 0.7071068F;
/* 55 */       float q = 0.7071068F;
/* 56 */       float w = Lookup.coslook(wdel * k);
/*    */ 
/* 58 */       for (int j = 0; j < m2; j += 2) {
/* 59 */         q *= (lsp[j] - w);
/* 60 */         p *= (lsp[(j + 1)] - w);
/*    */       }
/*    */ 
/* 63 */       if ((m & 0x1) != 0)
/*    */       {
/* 66 */         q *= (lsp[(m - 1)] - w);
/* 67 */         q *= q;
/* 68 */         p *= p * (1.0F - w * w);
/*    */       }
/*    */       else
/*    */       {
/* 72 */         q *= q * (1.0F + w);
/* 73 */         p *= p * (1.0F - w);
/*    */       }
/*    */ 
/* 77 */       q = p + q;
/* 78 */       int hx = Float.floatToIntBits(q);
/* 79 */       int ix = 0x7FFFFFFF & hx;
/* 80 */       int qexp = 0;
/*    */ 
/* 82 */       if ((ix < 2139095040) && (ix != 0))
/*    */       {
/* 86 */         if (ix < 8388608) {
/* 87 */           q = (float)(q * 33554432.0D);
/* 88 */           hx = Float.floatToIntBits(q);
/* 89 */           ix = 0x7FFFFFFF & hx;
/* 90 */           qexp = -25;
/*    */         }
/* 92 */         qexp += (ix >>> 23) - 126;
/* 93 */         hx = hx & 0x807FFFFF | 0x3F000000;
/* 94 */         q = Float.intBitsToFloat(hx);
/*    */       }
/*    */ 
/* 97 */       q = Lookup.fromdBlook(amp * Lookup.invsqlook(q) * Lookup.invsq2explook(qexp + m) - ampoffset);
/*    */       do
/*    */       {
/* 101 */         curve[(i++)] *= q;
/*    */       }
/* 103 */       while ((i < n) && (map[i] == k));
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     com.jcraft.jorbis.Lsp
 * JD-Core Version:    0.6.2
 */