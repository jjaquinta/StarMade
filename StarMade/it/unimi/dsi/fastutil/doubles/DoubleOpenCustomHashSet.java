/*     */ package it.unimi.dsi.fastutil.doubles;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.Hash;
/*     */ import it.unimi.dsi.fastutil.HashCommon;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanArrays;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class DoubleOpenCustomHashSet extends AbstractDoubleSet
/*     */   implements Serializable, Cloneable, Hash
/*     */ {
/*     */   public static final long serialVersionUID = 0L;
/*     */   private static final boolean ASSERTS = false;
/*     */   protected transient double[] key;
/*     */   protected transient boolean[] used;
/*     */   protected final float f;
/*     */   protected transient int n;
/*     */   protected transient int maxFill;
/*     */   protected transient int mask;
/*     */   protected int size;
/*     */   protected DoubleHash.Strategy strategy;
/*     */ 
/*     */   public DoubleOpenCustomHashSet(int expected, float f, DoubleHash.Strategy strategy)
/*     */   {
/*  98 */     this.strategy = strategy;
/*  99 */     if ((f <= 0.0F) || (f > 1.0F)) throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
/* 100 */     if (expected < 0) throw new IllegalArgumentException("The expected number of elements must be nonnegative");
/* 101 */     this.f = f;
/* 102 */     this.n = HashCommon.arraySize(expected, f);
/* 103 */     this.mask = (this.n - 1);
/* 104 */     this.maxFill = HashCommon.maxFill(this.n, f);
/* 105 */     this.key = new double[this.n];
/* 106 */     this.used = new boolean[this.n];
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(int expected, DoubleHash.Strategy strategy)
/*     */   {
/* 114 */     this(expected, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(DoubleHash.Strategy strategy)
/*     */   {
/* 121 */     this(16, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(Collection<? extends Double> c, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 130 */     this(c.size(), f, strategy);
/* 131 */     addAll(c);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(Collection<? extends Double> c, DoubleHash.Strategy strategy)
/*     */   {
/* 140 */     this(c, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(DoubleCollection c, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 149 */     this(c.size(), f, strategy);
/* 150 */     addAll(c);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(DoubleCollection c, DoubleHash.Strategy strategy)
/*     */   {
/* 159 */     this(c, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(DoubleIterator i, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 168 */     this(16, f, strategy);
/* 169 */     while (i.hasNext()) add(i.nextDouble());
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(DoubleIterator i, DoubleHash.Strategy strategy)
/*     */   {
/* 177 */     this(i, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(Iterator<?> i, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 186 */     this(DoubleIterators.asDoubleIterator(i), f, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(Iterator<?> i, DoubleHash.Strategy strategy)
/*     */   {
/* 194 */     this(DoubleIterators.asDoubleIterator(i), strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(double[] a, int offset, int length, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 205 */     this(length < 0 ? 0 : length, f, strategy);
/* 206 */     DoubleArrays.ensureOffsetLength(a, offset, length);
/* 207 */     for (int i = 0; i < length; i++) add(a[(offset + i)]);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(double[] a, int offset, int length, DoubleHash.Strategy strategy)
/*     */   {
/* 217 */     this(a, offset, length, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(double[] a, float f, DoubleHash.Strategy strategy)
/*     */   {
/* 226 */     this(a, 0, a.length, f, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet(double[] a, DoubleHash.Strategy strategy)
/*     */   {
/* 235 */     this(a, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public DoubleHash.Strategy strategy()
/*     */   {
/* 242 */     return this.strategy;
/*     */   }
/*     */ 
/*     */   public boolean add(double k)
/*     */   {
/* 250 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 252 */     while (this.used[pos] != 0) {
/* 253 */       if (this.strategy.equals(this.key[pos], k)) return false;
/* 254 */       pos = pos + 1 & this.mask;
/*     */     }
/* 256 */     this.used[pos] = true;
/* 257 */     this.key[pos] = k;
/* 258 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   protected final int shiftKeys(int pos)
/*     */   {
/*     */     int last;
/*     */     while (true)
/*     */     {
/* 272 */       pos = (last = pos) + 1 & this.mask;
/* 273 */       while (this.used[pos] != 0) {
/* 274 */         int slot = HashCommon.murmurHash3(this.strategy.hashCode(this.key[pos])) & this.mask;
/* 275 */         if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 276 */         pos = pos + 1 & this.mask;
/*     */       }
/* 278 */       if (this.used[pos] == 0) break;
/* 279 */       this.key[last] = this.key[pos];
/*     */     }
/* 281 */     this.used[last] = false;
/* 282 */     return last;
/*     */   }
/*     */ 
/*     */   public boolean remove(double k)
/*     */   {
/* 287 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 289 */     while (this.used[pos] != 0) {
/* 290 */       if (this.strategy.equals(this.key[pos], k)) {
/* 291 */         this.size -= 1;
/* 292 */         shiftKeys(pos);
/*     */ 
/* 294 */         return true;
/*     */       }
/* 296 */       pos = pos + 1 & this.mask;
/*     */     }
/* 298 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean contains(double k)
/*     */   {
/* 303 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 305 */     while (this.used[pos] != 0) {
/* 306 */       if (this.strategy.equals(this.key[pos], k)) return true;
/* 307 */       pos = pos + 1 & this.mask;
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 318 */     if (this.size == 0) return;
/* 319 */     this.size = 0;
/* 320 */     BooleanArrays.fill(this.used, false);
/*     */   }
/*     */   public int size() {
/* 323 */     return this.size;
/*     */   }
/*     */   public boolean isEmpty() {
/* 326 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public void growthFactor(int growthFactor)
/*     */   {
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public int growthFactor()
/*     */   {
/* 343 */     return 16;
/*     */   }
/*     */ 
/*     */   public DoubleIterator iterator()
/*     */   {
/* 426 */     return new SetIterator(null);
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public boolean rehash()
/*     */   {
/* 440 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean trim()
/*     */   {
/* 455 */     int l = HashCommon.arraySize(this.size, this.f);
/* 456 */     if (l >= this.n) return true; try
/*     */     {
/* 458 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 460 */       return false;
/* 461 */     }return true;
/*     */   }
/*     */ 
/*     */   public boolean trim(int n)
/*     */   {
/* 482 */     int l = HashCommon.nextPowerOfTwo((int)Math.ceil(n / this.f));
/* 483 */     if (this.n <= l) return true; try
/*     */     {
/* 485 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 487 */       return false;
/* 488 */     }return true;
/*     */   }
/*     */ 
/*     */   protected void rehash(int newN)
/*     */   {
/* 501 */     int i = 0;
/* 502 */     boolean[] used = this.used;
/*     */ 
/* 504 */     double[] key = this.key;
/* 505 */     int newMask = newN - 1;
/* 506 */     double[] newKey = new double[newN];
/* 507 */     boolean[] newUsed = new boolean[newN];
/* 508 */     for (int j = this.size; j-- != 0; ) {
/* 509 */       while (used[i] == 0) i++;
/* 510 */       double k = key[i];
/* 511 */       int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & newMask;
/* 512 */       while (newUsed[pos] != 0) pos = pos + 1 & newMask;
/* 513 */       newUsed[pos] = true;
/* 514 */       newKey[pos] = k;
/* 515 */       i++;
/*     */     }
/* 517 */     this.n = newN;
/* 518 */     this.mask = newMask;
/* 519 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 520 */     this.key = newKey;
/* 521 */     this.used = newUsed;
/*     */   }
/*     */ 
/*     */   public DoubleOpenCustomHashSet clone()
/*     */   {
/*     */     DoubleOpenCustomHashSet c;
/*     */     try
/*     */     {
/* 534 */       c = (DoubleOpenCustomHashSet)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 537 */       throw new InternalError();
/*     */     }
/* 539 */     c.key = ((double[])this.key.clone());
/* 540 */     c.used = ((boolean[])this.used.clone());
/* 541 */     c.strategy = this.strategy;
/* 542 */     return c;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 554 */     int h = 0; int i = 0; int j = this.size;
/* 555 */     while (j-- != 0) {
/* 556 */       while (this.used[i] == 0) i++;
/* 557 */       h += this.strategy.hashCode(this.key[i]);
/* 558 */       i++;
/*     */     }
/* 560 */     return h; } 
/* 563 */   private void writeObject(ObjectOutputStream s) throws IOException { DoubleIterator i = iterator();
/* 564 */     s.defaultWriteObject();
/* 565 */     for (int j = this.size; j-- != 0; s.writeDouble(i.nextDouble()));
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 569 */     s.defaultReadObject();
/* 570 */     this.n = HashCommon.arraySize(this.size, this.f);
/* 571 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 572 */     this.mask = (this.n - 1);
/* 573 */     double[] key = this.key = new double[this.n];
/* 574 */     boolean[] used = this.used = new boolean[this.n];
/*     */ 
/* 576 */     int i = this.size; for (int pos = 0; i-- != 0; ) {
/* 577 */       double k = s.readDouble();
/* 578 */       pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/* 579 */       while (used[pos] != 0) pos = pos + 1 & this.mask;
/* 580 */       used[pos] = true;
/* 581 */       key[pos] = k;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void checkTable()
/*     */   {
/*     */   }
/*     */ 
/*     */   private class SetIterator extends AbstractDoubleIterator
/*     */   {
/*     */     int pos;
/*     */     int last;
/*     */     int c;
/*     */     DoubleArrayList wrapped;
/*     */ 
/*     */     private SetIterator()
/*     */     {
/* 349 */       this.pos = DoubleOpenCustomHashSet.this.n;
/*     */ 
/* 352 */       this.last = -1;
/*     */ 
/* 354 */       this.c = DoubleOpenCustomHashSet.this.size;
/*     */ 
/* 359 */       boolean[] used = DoubleOpenCustomHashSet.this.used;
/* 360 */       while ((this.c != 0) && (used[(--this.pos)] == 0));
/*     */     }
/*     */ 
/*     */     public boolean hasNext()
/*     */     {
/* 363 */       return this.c != 0;
/*     */     }
/*     */     public double nextDouble() {
/* 366 */       if (!hasNext()) throw new NoSuchElementException();
/* 367 */       this.c -= 1;
/*     */ 
/* 369 */       if (this.pos < 0) return this.wrapped.getDouble(-(this.last = --this.pos) - 2);
/* 370 */       double retVal = DoubleOpenCustomHashSet.this.key[(this.last = this.pos)];
/*     */ 
/* 372 */       if (this.c != 0) {
/* 373 */         boolean[] used = DoubleOpenCustomHashSet.this.used;
/* 374 */         while ((this.pos-- != 0) && (used[this.pos] == 0));
/*     */       }
/* 377 */       return retVal;
/*     */     }
/*     */ 
/*     */     final int shiftKeys(int pos)
/*     */     {
/*     */       int last;
/*     */       while (true)
/*     */       {
/* 390 */         pos = (last = pos) + 1 & DoubleOpenCustomHashSet.this.mask;
/* 391 */         while (DoubleOpenCustomHashSet.this.used[pos] != 0) {
/* 392 */           int slot = HashCommon.murmurHash3(DoubleOpenCustomHashSet.this.strategy.hashCode(DoubleOpenCustomHashSet.this.key[pos])) & DoubleOpenCustomHashSet.this.mask;
/* 393 */           if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 394 */           pos = pos + 1 & DoubleOpenCustomHashSet.this.mask;
/*     */         }
/* 396 */         if (DoubleOpenCustomHashSet.this.used[pos] == 0) break;
/* 397 */         if (pos < last)
/*     */         {
/* 399 */           if (this.wrapped == null) this.wrapped = new DoubleArrayList();
/* 400 */           this.wrapped.add(DoubleOpenCustomHashSet.this.key[pos]);
/*     */         }
/* 402 */         DoubleOpenCustomHashSet.this.key[last] = DoubleOpenCustomHashSet.this.key[pos];
/*     */       }
/* 404 */       DoubleOpenCustomHashSet.this.used[last] = false;
/* 405 */       return last;
/*     */     }
/*     */ 
/*     */     public void remove() {
/* 409 */       if (this.last == -1) throw new IllegalStateException();
/* 410 */       if (this.pos < -1)
/*     */       {
/* 412 */         DoubleOpenCustomHashSet.this.remove(this.wrapped.getDouble(-this.pos - 2));
/* 413 */         this.last = -1;
/* 414 */         return;
/*     */       }
/* 416 */       DoubleOpenCustomHashSet.this.size -= 1;
/* 417 */       if ((shiftKeys(this.last) == this.pos) && (this.c > 0)) {
/* 418 */         this.c += 1;
/* 419 */         nextDouble();
/*     */       }
/* 421 */       this.last = -1;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.doubles.DoubleOpenCustomHashSet
 * JD-Core Version:    0.6.2
 */