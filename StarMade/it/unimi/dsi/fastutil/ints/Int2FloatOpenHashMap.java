/*     */ package it.unimi.dsi.fastutil.ints;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.Hash;
/*     */ import it.unimi.dsi.fastutil.HashCommon;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanArrays;
/*     */ import it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
/*     */ import it.unimi.dsi.fastutil.floats.FloatCollection;
/*     */ import it.unimi.dsi.fastutil.floats.FloatIterator;
/*     */ import it.unimi.dsi.fastutil.objects.AbstractObjectSet;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectIterator;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class Int2FloatOpenHashMap extends AbstractInt2FloatMap
/*     */   implements Serializable, Cloneable, Hash
/*     */ {
/*     */   public static final long serialVersionUID = 0L;
/*     */   private static final boolean ASSERTS = false;
/*     */   protected transient int[] key;
/*     */   protected transient float[] value;
/*     */   protected transient boolean[] used;
/*     */   protected final float f;
/*     */   protected transient int n;
/*     */   protected transient int maxFill;
/*     */   protected transient int mask;
/*     */   protected int size;
/*     */   protected volatile transient Int2FloatMap.FastEntrySet entries;
/*     */   protected volatile transient IntSet keys;
/*     */   protected volatile transient FloatCollection values;
/*     */ 
/*     */   public Int2FloatOpenHashMap(int expected, float f)
/*     */   {
/* 107 */     if ((f <= 0.0F) || (f > 1.0F)) throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
/* 108 */     if (expected < 0) throw new IllegalArgumentException("The expected number of elements must be nonnegative");
/* 109 */     this.f = f;
/* 110 */     this.n = HashCommon.arraySize(expected, f);
/* 111 */     this.mask = (this.n - 1);
/* 112 */     this.maxFill = HashCommon.maxFill(this.n, f);
/* 113 */     this.key = new int[this.n];
/* 114 */     this.value = new float[this.n];
/* 115 */     this.used = new boolean[this.n];
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(int expected)
/*     */   {
/* 122 */     this(expected, 0.75F);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap()
/*     */   {
/* 128 */     this(16, 0.75F);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(Map<? extends Integer, ? extends Float> m, float f)
/*     */   {
/* 136 */     this(m.size(), f);
/* 137 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(Map<? extends Integer, ? extends Float> m)
/*     */   {
/* 144 */     this(m, 0.75F);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(Int2FloatMap m, float f)
/*     */   {
/* 152 */     this(m.size(), f);
/* 153 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(Int2FloatMap m)
/*     */   {
/* 160 */     this(m, 0.75F);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(int[] k, float[] v, float f)
/*     */   {
/* 170 */     this(k.length, f);
/* 171 */     if (k.length != v.length) throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
/* 172 */     for (int i = 0; i < k.length; i++) put(k[i], v[i]);
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap(int[] k, float[] v)
/*     */   {
/* 181 */     this(k, v, 0.75F);
/*     */   }
/*     */ 
/*     */   public float put(int k, float v)
/*     */   {
/* 189 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 191 */     while (this.used[pos] != 0) {
/* 192 */       if (this.key[pos] == k) {
/* 193 */         float oldValue = this.value[pos];
/* 194 */         this.value[pos] = v;
/* 195 */         return oldValue;
/*     */       }
/* 197 */       pos = pos + 1 & this.mask;
/*     */     }
/* 199 */     this.used[pos] = true;
/* 200 */     this.key[pos] = k;
/* 201 */     this.value[pos] = v;
/* 202 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 204 */     return this.defRetValue;
/*     */   }
/*     */   public Float put(Integer ok, Float ov) {
/* 207 */     float v = ov.floatValue();
/* 208 */     int k = ok.intValue();
/*     */ 
/* 210 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 212 */     while (this.used[pos] != 0) {
/* 213 */       if (this.key[pos] == k) {
/* 214 */         Float oldValue = Float.valueOf(this.value[pos]);
/* 215 */         this.value[pos] = v;
/* 216 */         return oldValue;
/*     */       }
/* 218 */       pos = pos + 1 & this.mask;
/*     */     }
/* 220 */     this.used[pos] = true;
/* 221 */     this.key[pos] = k;
/* 222 */     this.value[pos] = v;
/* 223 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 225 */     return null;
/*     */   }
/*     */ 
/*     */   public float add(int k, float incr)
/*     */   {
/* 240 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 242 */     while (this.used[pos] != 0) {
/* 243 */       if (this.key[pos] == k) {
/* 244 */         float oldValue = this.value[pos];
/* 245 */         this.value[pos] += incr;
/* 246 */         return oldValue;
/*     */       }
/* 248 */       pos = pos + 1 & this.mask;
/*     */     }
/* 250 */     this.used[pos] = true;
/* 251 */     this.key[pos] = k;
/* 252 */     this.value[pos] = (this.defRetValue + incr);
/* 253 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 255 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   protected final int shiftKeys(int pos)
/*     */   {
/*     */     int last;
/*     */     while (true)
/*     */     {
/* 267 */       pos = (last = pos) + 1 & this.mask;
/* 268 */       while (this.used[pos] != 0) {
/* 269 */         int slot = HashCommon.murmurHash3(this.key[pos]) & this.mask;
/* 270 */         if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 271 */         pos = pos + 1 & this.mask;
/*     */       }
/* 273 */       if (this.used[pos] == 0) break;
/* 274 */       this.key[last] = this.key[pos];
/* 275 */       this.value[last] = this.value[pos];
/*     */     }
/* 277 */     this.used[last] = false;
/* 278 */     return last;
/*     */   }
/*     */ 
/*     */   public float remove(int k)
/*     */   {
/* 283 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 285 */     while (this.used[pos] != 0) {
/* 286 */       if (this.key[pos] == k) {
/* 287 */         this.size -= 1;
/* 288 */         float v = this.value[pos];
/* 289 */         shiftKeys(pos);
/* 290 */         return v;
/*     */       }
/* 292 */       pos = pos + 1 & this.mask;
/*     */     }
/* 294 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public Float remove(Object ok) {
/* 298 */     int k = ((Integer)ok).intValue();
/*     */ 
/* 300 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 302 */     while (this.used[pos] != 0) {
/* 303 */       if (this.key[pos] == k) {
/* 304 */         this.size -= 1;
/* 305 */         float v = this.value[pos];
/* 306 */         shiftKeys(pos);
/* 307 */         return Float.valueOf(v);
/*     */       }
/* 309 */       pos = pos + 1 & this.mask;
/*     */     }
/* 311 */     return null;
/*     */   }
/*     */   public Float get(Integer ok) {
/* 314 */     int k = ok.intValue();
/*     */ 
/* 316 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 318 */     while (this.used[pos] != 0) {
/* 319 */       if (this.key[pos] == k) return Float.valueOf(this.value[pos]);
/* 320 */       pos = pos + 1 & this.mask;
/*     */     }
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */   public float get(int k)
/*     */   {
/* 327 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 329 */     while (this.used[pos] != 0) {
/* 330 */       if (this.key[pos] == k) return this.value[pos];
/* 331 */       pos = pos + 1 & this.mask;
/*     */     }
/* 333 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public boolean containsKey(int k)
/*     */   {
/* 338 */     int pos = HashCommon.murmurHash3(k) & this.mask;
/*     */ 
/* 340 */     while (this.used[pos] != 0) {
/* 341 */       if (this.key[pos] == k) return true;
/* 342 */       pos = pos + 1 & this.mask;
/*     */     }
/* 344 */     return false;
/*     */   }
/*     */   public boolean containsValue(float v) {
/* 347 */     float[] value = this.value;
/* 348 */     boolean[] used = this.used;
/* 349 */     for (int i = this.n; i-- != 0; return true) label16: if ((used[i] == 0) || (value[i] != v))
/*     */         break label16; return false;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 359 */     if (this.size == 0) return;
/* 360 */     this.size = 0;
/* 361 */     BooleanArrays.fill(this.used, false);
/*     */   }
/*     */ 
/*     */   public int size() {
/* 365 */     return this.size;
/*     */   }
/*     */   public boolean isEmpty() {
/* 368 */     return this.size == 0;
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
/* 385 */     return 16;
/*     */   }
/*     */ 
/*     */   public Int2FloatMap.FastEntrySet int2FloatEntrySet()
/*     */   {
/* 591 */     if (this.entries == null) this.entries = new MapEntrySet(null);
/* 592 */     return this.entries;
/*     */   }
/*     */ 
/*     */   public IntSet keySet()
/*     */   {
/* 625 */     if (this.keys == null) this.keys = new KeySet(null);
/* 626 */     return this.keys;
/*     */   }
/*     */ 
/*     */   public FloatCollection values()
/*     */   {
/* 640 */     if (this.values == null) this.values = new AbstractFloatCollection() {
/*     */         public FloatIterator iterator() {
/* 642 */           return new Int2FloatOpenHashMap.ValueIterator(Int2FloatOpenHashMap.this);
/*     */         }
/*     */         public int size() {
/* 645 */           return Int2FloatOpenHashMap.this.size;
/*     */         }
/*     */         public boolean contains(float v) {
/* 648 */           return Int2FloatOpenHashMap.this.containsValue(v);
/*     */         }
/*     */         public void clear() {
/* 651 */           Int2FloatOpenHashMap.this.clear();
/*     */         }
/*     */       };
/* 654 */     return this.values;
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public boolean rehash()
/*     */   {
/* 668 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean trim()
/*     */   {
/* 683 */     int l = HashCommon.arraySize(this.size, this.f);
/* 684 */     if (l >= this.n) return true; try
/*     */     {
/* 686 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 688 */       return false;
/* 689 */     }return true;
/*     */   }
/*     */ 
/*     */   public boolean trim(int n)
/*     */   {
/* 710 */     int l = HashCommon.nextPowerOfTwo((int)Math.ceil(n / this.f));
/* 711 */     if (this.n <= l) return true; try
/*     */     {
/* 713 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 715 */       return false;
/* 716 */     }return true;
/*     */   }
/*     */ 
/*     */   protected void rehash(int newN)
/*     */   {
/* 729 */     int i = 0;
/* 730 */     boolean[] used = this.used;
/*     */ 
/* 732 */     int[] key = this.key;
/* 733 */     float[] value = this.value;
/* 734 */     int newMask = newN - 1;
/* 735 */     int[] newKey = new int[newN];
/* 736 */     float[] newValue = new float[newN];
/* 737 */     boolean[] newUsed = new boolean[newN];
/* 738 */     for (int j = this.size; j-- != 0; ) {
/* 739 */       while (used[i] == 0) i++;
/* 740 */       int k = key[i];
/* 741 */       int pos = HashCommon.murmurHash3(k) & newMask;
/* 742 */       while (newUsed[pos] != 0) pos = pos + 1 & newMask;
/* 743 */       newUsed[pos] = true;
/* 744 */       newKey[pos] = k;
/* 745 */       newValue[pos] = value[i];
/* 746 */       i++;
/*     */     }
/* 748 */     this.n = newN;
/* 749 */     this.mask = newMask;
/* 750 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 751 */     this.key = newKey;
/* 752 */     this.value = newValue;
/* 753 */     this.used = newUsed;
/*     */   }
/*     */ 
/*     */   public Int2FloatOpenHashMap clone()
/*     */   {
/*     */     Int2FloatOpenHashMap c;
/*     */     try
/*     */     {
/* 766 */       c = (Int2FloatOpenHashMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 769 */       throw new InternalError();
/*     */     }
/* 771 */     c.keys = null;
/* 772 */     c.values = null;
/* 773 */     c.entries = null;
/* 774 */     c.key = ((int[])this.key.clone());
/* 775 */     c.value = ((float[])this.value.clone());
/* 776 */     c.used = ((boolean[])this.used.clone());
/* 777 */     return c;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 789 */     int h = 0;
/* 790 */     int j = this.size; int i = 0; for (int t = 0; j-- != 0; ) {
/* 791 */       while (this.used[i] == 0) i++;
/* 792 */       t = this.key[i];
/* 793 */       t ^= HashCommon.float2int(this.value[i]);
/* 794 */       h += t;
/* 795 */       i++;
/*     */     }
/* 797 */     return h;
/*     */   }
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 800 */     int[] key = this.key;
/* 801 */     float[] value = this.value;
/* 802 */     MapIterator i = new MapIterator(null);
/* 803 */     s.defaultWriteObject();
/* 804 */     for (int j = this.size; j-- != 0; ) {
/* 805 */       int e = i.nextEntry();
/* 806 */       s.writeInt(key[e]);
/* 807 */       s.writeFloat(value[e]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 812 */     s.defaultReadObject();
/* 813 */     this.n = HashCommon.arraySize(this.size, this.f);
/* 814 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 815 */     this.mask = (this.n - 1);
/* 816 */     int[] key = this.key = new int[this.n];
/* 817 */     float[] value = this.value = new float[this.n];
/* 818 */     boolean[] used = this.used = new boolean[this.n];
/*     */ 
/* 821 */     int i = this.size; for (int pos = 0; i-- != 0; ) {
/* 822 */       int k = s.readInt();
/* 823 */       float v = s.readFloat();
/* 824 */       pos = HashCommon.murmurHash3(k) & this.mask;
/* 825 */       while (used[pos] != 0) pos = pos + 1 & this.mask;
/* 826 */       used[pos] = true;
/* 827 */       key[pos] = k;
/* 828 */       value[pos] = v;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void checkTable()
/*     */   {
/*     */   }
/*     */ 
/*     */   private final class ValueIterator extends Int2FloatOpenHashMap.MapIterator
/*     */     implements FloatIterator
/*     */   {
/*     */     public ValueIterator()
/*     */     {
/* 635 */       super(null); } 
/* 636 */     public float nextFloat() { return Int2FloatOpenHashMap.this.value[nextEntry()]; } 
/* 637 */     public Float next() { return Float.valueOf(Int2FloatOpenHashMap.this.value[nextEntry()]); }
/*     */ 
/*     */   }
/*     */ 
/*     */   private final class KeySet extends AbstractIntSet
/*     */   {
/*     */     private KeySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public IntIterator iterator()
/*     */     {
/* 607 */       return new Int2FloatOpenHashMap.KeyIterator(Int2FloatOpenHashMap.this);
/*     */     }
/*     */     public int size() {
/* 610 */       return Int2FloatOpenHashMap.this.size;
/*     */     }
/*     */     public boolean contains(int k) {
/* 613 */       return Int2FloatOpenHashMap.this.containsKey(k);
/*     */     }
/*     */     public boolean remove(int k) {
/* 616 */       int oldSize = Int2FloatOpenHashMap.this.size;
/* 617 */       Int2FloatOpenHashMap.this.remove(k);
/* 618 */       return Int2FloatOpenHashMap.this.size != oldSize;
/*     */     }
/*     */     public void clear() {
/* 621 */       Int2FloatOpenHashMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class KeyIterator extends Int2FloatOpenHashMap.MapIterator
/*     */     implements IntIterator
/*     */   {
/*     */     public KeyIterator()
/*     */     {
/* 601 */       super(null); } 
/* 602 */     public int nextInt() { return Int2FloatOpenHashMap.this.key[nextEntry()]; } 
/* 603 */     public Integer next() { return Integer.valueOf(Int2FloatOpenHashMap.this.key[nextEntry()]); }
/*     */ 
/*     */   }
/*     */ 
/*     */   private final class MapEntrySet extends AbstractObjectSet<Int2FloatMap.Entry>
/*     */     implements Int2FloatMap.FastEntrySet
/*     */   {
/*     */     private MapEntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Int2FloatMap.Entry> iterator()
/*     */     {
/* 547 */       return new Int2FloatOpenHashMap.EntryIterator(Int2FloatOpenHashMap.this, null);
/*     */     }
/*     */     public ObjectIterator<Int2FloatMap.Entry> fastIterator() {
/* 550 */       return new Int2FloatOpenHashMap.FastEntryIterator(Int2FloatOpenHashMap.this, null);
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 554 */       if (!(o instanceof Map.Entry)) return false;
/* 555 */       Map.Entry e = (Map.Entry)o;
/* 556 */       int k = ((Integer)e.getKey()).intValue();
/*     */ 
/* 558 */       int pos = HashCommon.murmurHash3(k) & Int2FloatOpenHashMap.this.mask;
/*     */ 
/* 560 */       while (Int2FloatOpenHashMap.this.used[pos] != 0) {
/* 561 */         if (Int2FloatOpenHashMap.this.key[pos] == k) return Int2FloatOpenHashMap.this.value[pos] == ((Float)e.getValue()).floatValue();
/* 562 */         pos = pos + 1 & Int2FloatOpenHashMap.this.mask;
/*     */       }
/* 564 */       return false;
/*     */     }
/*     */ 
/*     */     public boolean remove(Object o) {
/* 568 */       if (!(o instanceof Map.Entry)) return false;
/* 569 */       Map.Entry e = (Map.Entry)o;
/* 570 */       int k = ((Integer)e.getKey()).intValue();
/*     */ 
/* 572 */       int pos = HashCommon.murmurHash3(k) & Int2FloatOpenHashMap.this.mask;
/*     */ 
/* 574 */       while (Int2FloatOpenHashMap.this.used[pos] != 0) {
/* 575 */         if (Int2FloatOpenHashMap.this.key[pos] == k) {
/* 576 */           Int2FloatOpenHashMap.this.remove(e.getKey());
/* 577 */           return true;
/*     */         }
/* 579 */         pos = pos + 1 & Int2FloatOpenHashMap.this.mask;
/*     */       }
/* 581 */       return false;
/*     */     }
/*     */     public int size() {
/* 584 */       return Int2FloatOpenHashMap.this.size;
/*     */     }
/*     */     public void clear() {
/* 587 */       Int2FloatOpenHashMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class FastEntryIterator extends Int2FloatOpenHashMap.MapIterator
/*     */     implements ObjectIterator<Int2FloatMap.Entry>
/*     */   {
/* 537 */     final AbstractInt2FloatMap.BasicEntry entry = new AbstractInt2FloatMap.BasicEntry(0, 0.0F);
/*     */ 
/*     */     private FastEntryIterator()
/*     */     {
/* 536 */       super(null);
/*     */     }
/*     */     public AbstractInt2FloatMap.BasicEntry next() {
/* 539 */       int e = nextEntry();
/* 540 */       this.entry.key = Int2FloatOpenHashMap.this.key[e];
/* 541 */       this.entry.value = Int2FloatOpenHashMap.this.value[e];
/* 542 */       return this.entry;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class EntryIterator extends Int2FloatOpenHashMap.MapIterator
/*     */     implements ObjectIterator<Int2FloatMap.Entry>
/*     */   {
/*     */     private Int2FloatOpenHashMap.MapEntry entry;
/*     */ 
/*     */     private EntryIterator()
/*     */     {
/* 525 */       super(null);
/*     */     }
/*     */     public Int2FloatMap.Entry next() {
/* 528 */       return this.entry = new Int2FloatOpenHashMap.MapEntry(Int2FloatOpenHashMap.this, nextEntry());
/*     */     }
/*     */ 
/*     */     public void remove() {
/* 532 */       super.remove();
/* 533 */       Int2FloatOpenHashMap.MapEntry.access$102(this.entry, -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MapIterator
/*     */   {
/*     */     int pos;
/*     */     int last;
/*     */     int c;
/*     */     IntArrayList wrapped;
/*     */ 
/*     */     private MapIterator()
/*     */     {
/* 434 */       this.pos = Int2FloatOpenHashMap.this.n;
/*     */ 
/* 437 */       this.last = -1;
/*     */ 
/* 439 */       this.c = Int2FloatOpenHashMap.this.size;
/*     */ 
/* 444 */       boolean[] used = Int2FloatOpenHashMap.this.used;
/* 445 */       while ((this.c != 0) && (used[(--this.pos)] == 0));
/*     */     }
/*     */ 
/*     */     public boolean hasNext()
/*     */     {
/* 448 */       return this.c != 0;
/*     */     }
/*     */     public int nextEntry() {
/* 451 */       if (!hasNext()) throw new NoSuchElementException();
/* 452 */       this.c -= 1;
/*     */ 
/* 454 */       if (this.pos < 0) {
/* 455 */         int k = this.wrapped.getInt(-(this.last = --this.pos) - 2);
/*     */ 
/* 457 */         int pos = HashCommon.murmurHash3(k) & Int2FloatOpenHashMap.this.mask;
/*     */ 
/* 459 */         while (Int2FloatOpenHashMap.this.used[pos] != 0) {
/* 460 */           if (Int2FloatOpenHashMap.this.key[pos] == k) return pos;
/* 461 */           pos = pos + 1 & Int2FloatOpenHashMap.this.mask;
/*     */         }
/*     */       }
/* 464 */       this.last = this.pos;
/*     */ 
/* 466 */       if (this.c != 0) {
/* 467 */         boolean[] used = Int2FloatOpenHashMap.this.used;
/* 468 */         while ((this.pos-- != 0) && (used[this.pos] == 0));
/*     */       }
/* 471 */       return this.last;
/*     */     }
/*     */ 
/*     */     protected final int shiftKeys(int pos)
/*     */     {
/*     */       int last;
/*     */       while (true)
/*     */       {
/* 484 */         pos = (last = pos) + 1 & Int2FloatOpenHashMap.this.mask;
/* 485 */         while (Int2FloatOpenHashMap.this.used[pos] != 0) {
/* 486 */           int slot = HashCommon.murmurHash3(Int2FloatOpenHashMap.this.key[pos]) & Int2FloatOpenHashMap.this.mask;
/* 487 */           if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 488 */           pos = pos + 1 & Int2FloatOpenHashMap.this.mask;
/*     */         }
/* 490 */         if (Int2FloatOpenHashMap.this.used[pos] == 0) break;
/* 491 */         if (pos < last)
/*     */         {
/* 493 */           if (this.wrapped == null) this.wrapped = new IntArrayList();
/* 494 */           this.wrapped.add(Int2FloatOpenHashMap.this.key[pos]);
/*     */         }
/* 496 */         Int2FloatOpenHashMap.this.key[last] = Int2FloatOpenHashMap.this.key[pos];
/* 497 */         Int2FloatOpenHashMap.this.value[last] = Int2FloatOpenHashMap.this.value[pos];
/*     */       }
/* 499 */       Int2FloatOpenHashMap.this.used[last] = false;
/* 500 */       return last;
/*     */     }
/*     */ 
/*     */     public void remove() {
/* 504 */       if (this.last == -1) throw new IllegalStateException();
/* 505 */       if (this.pos < -1)
/*     */       {
/* 507 */         Int2FloatOpenHashMap.this.remove(this.wrapped.getInt(-this.pos - 2));
/* 508 */         this.last = -1;
/* 509 */         return;
/*     */       }
/* 511 */       Int2FloatOpenHashMap.this.size -= 1;
/* 512 */       if ((shiftKeys(this.last) == this.pos) && (this.c > 0)) {
/* 513 */         this.c += 1;
/* 514 */         nextEntry();
/*     */       }
/* 516 */       this.last = -1;
/*     */     }
/*     */ 
/*     */     public int skip(int n) {
/* 520 */       int i = n;
/* 521 */       while ((i-- != 0) && (hasNext())) nextEntry();
/* 522 */       return n - i - 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class MapEntry
/*     */     implements Int2FloatMap.Entry, Map.Entry<Integer, Float>
/*     */   {
/*     */     private int index;
/*     */ 
/*     */     MapEntry(int index)
/*     */     {
/* 395 */       this.index = index;
/*     */     }
/*     */     public Integer getKey() {
/* 398 */       return Integer.valueOf(Int2FloatOpenHashMap.this.key[this.index]);
/*     */     }
/*     */     public int getIntKey() {
/* 401 */       return Int2FloatOpenHashMap.this.key[this.index];
/*     */     }
/*     */     public Float getValue() {
/* 404 */       return Float.valueOf(Int2FloatOpenHashMap.this.value[this.index]);
/*     */     }
/*     */     public float getFloatValue() {
/* 407 */       return Int2FloatOpenHashMap.this.value[this.index];
/*     */     }
/*     */     public float setValue(float v) {
/* 410 */       float oldValue = Int2FloatOpenHashMap.this.value[this.index];
/* 411 */       Int2FloatOpenHashMap.this.value[this.index] = v;
/* 412 */       return oldValue;
/*     */     }
/*     */     public Float setValue(Float v) {
/* 415 */       return Float.valueOf(setValue(v.floatValue()));
/*     */     }
/*     */ 
/*     */     public boolean equals(Object o) {
/* 419 */       if (!(o instanceof Map.Entry)) return false;
/* 420 */       Map.Entry e = (Map.Entry)o;
/* 421 */       return (Int2FloatOpenHashMap.this.key[this.index] == ((Integer)e.getKey()).intValue()) && (Int2FloatOpenHashMap.this.value[this.index] == ((Float)e.getValue()).floatValue());
/*     */     }
/*     */     public int hashCode() {
/* 424 */       return Int2FloatOpenHashMap.this.key[this.index] ^ HashCommon.float2int(Int2FloatOpenHashMap.this.value[this.index]);
/*     */     }
/*     */     public String toString() {
/* 427 */       return Int2FloatOpenHashMap.this.key[this.index] + "=>" + Int2FloatOpenHashMap.this.value[this.index];
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap
 * JD-Core Version:    0.6.2
 */