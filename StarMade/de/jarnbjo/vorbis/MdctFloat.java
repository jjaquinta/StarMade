/*     */ package de.jarnbjo.vorbis;
/*     */ 
/*     */ class MdctFloat
/*     */ {
/*     */   private static final float cPI3_8 = 0.3826834F;
/*     */   private static final float cPI2_8 = 0.7071068F;
/*     */   private static final float cPI1_8 = 0.92388F;
/*     */   private int n;
/*     */   private int log2n;
/*     */   private float[] trig;
/*     */   private int[] bitrev;
/*     */   private float[] equalizer;
/*     */   private float scale;
/*     */   private int itmp1;
/*     */   private int itmp2;
/*     */   private int itmp3;
/*     */   private int itmp4;
/*     */   private int itmp5;
/*     */   private int itmp6;
/*     */   private int itmp7;
/*     */   private int itmp8;
/*     */   private int itmp9;
/*     */   private float dtmp1;
/*     */   private float dtmp2;
/*     */   private float dtmp3;
/*     */   private float dtmp4;
/*     */   private float dtmp5;
/*     */   private float dtmp6;
/*     */   private float dtmp7;
/*     */   private float dtmp8;
/*     */   private float dtmp9;
/*  94 */   private float[] _x = new float[1024];
/*  95 */   private float[] _w = new float[1024];
/*     */ 
/*     */   protected MdctFloat(int n)
/*     */   {
/*  48 */     this.bitrev = new int[n / 4];
/*  49 */     this.trig = new float[n + n / 4];
/*     */ 
/*  51 */     int n2 = n >>> 1;
/*  52 */     this.log2n = ((int)Math.rint(Math.log(n) / Math.log(2.0D)));
/*  53 */     this.n = n;
/*     */ 
/*  55 */     int AE = 0;
/*  56 */     int AO = 1;
/*  57 */     int BE = AE + n / 2;
/*  58 */     int BO = BE + 1;
/*  59 */     int CE = BE + n / 2;
/*  60 */     int CO = CE + 1;
/*     */ 
/*  62 */     for (int i = 0; i < n / 4; i++) {
/*  63 */       this.trig[(AE + i * 2)] = ((float)Math.cos(3.141592653589793D / n * (4 * i)));
/*  64 */       this.trig[(AO + i * 2)] = ((float)-Math.sin(3.141592653589793D / n * (4 * i)));
/*  65 */       this.trig[(BE + i * 2)] = ((float)Math.cos(3.141592653589793D / (2 * n) * (2 * i + 1)));
/*  66 */       this.trig[(BO + i * 2)] = ((float)Math.sin(3.141592653589793D / (2 * n) * (2 * i + 1)));
/*     */     }
/*  68 */     for (int i = 0; i < n / 8; i++) {
/*  69 */       this.trig[(CE + i * 2)] = ((float)Math.cos(3.141592653589793D / n * (4 * i + 2)));
/*  70 */       this.trig[(CO + i * 2)] = ((float)-Math.sin(3.141592653589793D / n * (4 * i + 2)));
/*     */     }
/*     */ 
/*  74 */     int mask = (1 << this.log2n - 1) - 1;
/*  75 */     int msb = 1 << this.log2n - 2;
/*  76 */     for (int i = 0; i < n / 8; i++) {
/*  77 */       int acc = 0;
/*  78 */       for (int j = 0; msb >>> j != 0; j++)
/*  79 */         if ((msb >>> j & i) != 0) acc |= 1 << j;
/*  80 */       this.bitrev[(i * 2)] = ((acc ^ 0xFFFFFFFF) & mask);
/*     */ 
/*  82 */       this.bitrev[(i * 2 + 1)] = acc;
/*     */     }
/*     */ 
/*  85 */     this.scale = (4.0F / n);
/*     */   }
/*     */ 
/*     */   protected void setEqualizer(float[] equalizer)
/*     */   {
/*  98 */     this.equalizer = equalizer;
/*     */   }
/*     */ 
/*     */   protected float[] getEqualizer() {
/* 102 */     return this.equalizer;
/*     */   }
/*     */ 
/*     */   protected synchronized void imdct(float[] frq, float[] window, int[] pcm)
/*     */   {
/* 107 */     float[] in = frq;
/* 108 */     if (this._x.length < this.n / 2) this._x = new float[this.n / 2];
/* 109 */     if (this._w.length < this.n / 2) this._w = new float[this.n / 2];
/* 110 */     float[] x = this._x;
/* 111 */     float[] w = this._w;
/* 112 */     int n2 = this.n >> 1;
/* 113 */     int n4 = this.n >> 2;
/* 114 */     int n8 = this.n >> 3;
/*     */ 
/* 116 */     if (this.equalizer != null) {
/* 117 */       for (int i = 0; i < this.n; i++) {
/* 118 */         frq[i] *= this.equalizer[i];
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 124 */     int inO = -1;
/* 125 */     int xO = 0;
/* 126 */     int A = n2;
/*     */ 
/* 129 */     for (int i = 0; i < n8; i++) {
/* 130 */       inO += 2; this.dtmp1 = in[inO];
/* 131 */       inO += 2; this.dtmp2 = in[inO];
/* 132 */       this.dtmp3 = this.trig[(--A)];
/* 133 */       this.dtmp4 = this.trig[(--A)];
/* 134 */       x[(xO++)] = (-this.dtmp2 * this.dtmp3 - this.dtmp1 * this.dtmp4);
/* 135 */       x[(xO++)] = (this.dtmp1 * this.dtmp3 - this.dtmp2 * this.dtmp4);
/*     */     }
/*     */ 
/* 142 */     inO = n2;
/*     */ 
/* 144 */     for (i = 0; i < n8; i++) {
/* 145 */       inO -= 2; this.dtmp1 = in[inO];
/* 146 */       inO -= 2; this.dtmp2 = in[inO];
/* 147 */       this.dtmp3 = this.trig[(--A)];
/* 148 */       this.dtmp4 = this.trig[(--A)];
/* 149 */       x[(xO++)] = (this.dtmp2 * this.dtmp3 + this.dtmp1 * this.dtmp4);
/* 150 */       x[(xO++)] = (this.dtmp2 * this.dtmp4 - this.dtmp1 * this.dtmp3);
/*     */     }
/*     */ 
/* 158 */     float[] xxx = kernel(x, w, this.n, n2, n4, n8);
/* 159 */     int xx = 0;
/*     */ 
/* 164 */     int B = n2;
/* 165 */     int o1 = n4; int o2 = o1 - 1;
/* 166 */     int o3 = n4 + n2; int o4 = o3 - 1;
/*     */ 
/* 168 */     for (int i = 0; i < n4; i++) {
/* 169 */       this.dtmp1 = xxx[(xx++)];
/* 170 */       this.dtmp2 = xxx[(xx++)];
/* 171 */       this.dtmp3 = this.trig[(B++)];
/* 172 */       this.dtmp4 = this.trig[(B++)];
/*     */ 
/* 174 */       float temp1 = this.dtmp1 * this.dtmp4 - this.dtmp2 * this.dtmp3;
/* 175 */       float temp2 = -(this.dtmp1 * this.dtmp3 + this.dtmp2 * this.dtmp4);
/*     */ 
/* 187 */       pcm[o1] = ((int)(-temp1 * window[o1]));
/* 188 */       pcm[o2] = ((int)(temp1 * window[o2]));
/* 189 */       pcm[o3] = ((int)(temp2 * window[o3]));
/* 190 */       pcm[o4] = ((int)(temp2 * window[o4]));
/*     */ 
/* 192 */       o1++;
/* 193 */       o2--;
/* 194 */       o3++;
/* 195 */       o4--;
/*     */     }
/*     */   }
/*     */ 
/*     */   private float[] kernel(float[] x, float[] w, int n, int n2, int n4, int n8)
/*     */   {
/* 206 */     int xA = n4;
/* 207 */     int xB = 0;
/* 208 */     int w2 = n4;
/* 209 */     int A = n2;
/*     */ 
/* 211 */     for (int i = 0; i < n4; ) {
/* 212 */       float x0 = x[xA] - x[xB];
/*     */ 
/* 214 */       w[(w2 + i)] = (x[(xA++)] + x[(xB++)]);
/*     */ 
/* 216 */       float x1 = x[xA] - x[xB];
/* 217 */       A -= 4;
/*     */ 
/* 219 */       w[(i++)] = (x0 * this.trig[A] + x1 * this.trig[(A + 1)]);
/* 220 */       w[i] = (x1 * this.trig[A] - x0 * this.trig[(A + 1)]);
/*     */ 
/* 222 */       w[(w2 + i)] = (x[(xA++)] + x[(xB++)]);
/* 223 */       i++;
/*     */     }
/*     */ 
/* 229 */     for (int i = 0; i < this.log2n - 3; i++) {
/* 230 */       int k0 = n >>> i + 2;
/* 231 */       int k1 = 1 << i + 3;
/* 232 */       int wbase = n2 - 2;
/*     */ 
/* 234 */       A = 0;
/*     */ 
/* 237 */       for (int r = 0; r < k0 >>> 2; r++) {
/* 238 */         int w1 = wbase;
/* 239 */         w2 = w1 - (k0 >> 1);
/* 240 */         float AEv = this.trig[A];
/* 241 */         float AOv = this.trig[(A + 1)];
/* 242 */         wbase -= 2;
/*     */ 
/* 244 */         k0++;
/* 245 */         for (int s = 0; s < 2 << i; s++) {
/* 246 */           this.dtmp1 = w[w1];
/* 247 */           this.dtmp2 = w[w2];
/* 248 */           float wB = this.dtmp1 - this.dtmp2;
/* 249 */           x[w1] = (this.dtmp1 + this.dtmp2);
/* 250 */           this.dtmp1 = w[(++w1)];
/* 251 */           this.dtmp2 = w[(++w2)];
/* 252 */           float wA = this.dtmp1 - this.dtmp2;
/* 253 */           x[w1] = (this.dtmp1 + this.dtmp2);
/* 254 */           x[w2] = (wA * AEv - wB * AOv);
/* 255 */           x[(w2 - 1)] = (wB * AEv + wA * AOv);
/*     */ 
/* 268 */           w1 -= k0;
/* 269 */           w2 -= k0;
/*     */         }
/* 271 */         k0--;
/* 272 */         A += k1;
/*     */       }
/*     */ 
/* 275 */       float[] temp = w;
/* 276 */       w = x;
/* 277 */       x = temp;
/*     */     }
/*     */ 
/* 283 */     int C = n;
/* 284 */     int bit = 0;
/* 285 */     int x1 = 0;
/* 286 */     int x2 = n2 - 1;
/*     */ 
/* 288 */     for (int i = 0; i < n8; i++) {
/* 289 */       int t1 = this.bitrev[(bit++)];
/* 290 */       int t2 = this.bitrev[(bit++)];
/*     */ 
/* 292 */       float wA = w[t1] - w[(t2 + 1)];
/* 293 */       float wB = w[(t1 - 1)] + w[t2];
/* 294 */       float wC = w[t1] + w[(t2 + 1)];
/* 295 */       float wD = w[(t1 - 1)] - w[t2];
/*     */ 
/* 297 */       float wACE = wA * this.trig[C];
/* 298 */       float wBCE = wB * this.trig[(C++)];
/* 299 */       float wACO = wA * this.trig[C];
/* 300 */       float wBCO = wB * this.trig[(C++)];
/*     */ 
/* 302 */       x[(x1++)] = ((wC + wACO + wBCE) * 16383.0F);
/* 303 */       x[(x2--)] = ((-wD + wBCO - wACE) * 16383.0F);
/* 304 */       x[(x1++)] = ((wD + wBCO - wACE) * 16383.0F);
/* 305 */       x[(x2--)] = ((wC - wACO - wBCE) * 16383.0F);
/*     */     }
/*     */ 
/* 308 */     return x;
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     de.jarnbjo.vorbis.MdctFloat
 * JD-Core Version:    0.6.2
 */