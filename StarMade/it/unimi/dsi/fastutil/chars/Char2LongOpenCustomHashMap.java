/*     */ package it.unimi.dsi.fastutil.chars;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.Hash;
/*     */ import it.unimi.dsi.fastutil.HashCommon;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanArrays;
/*     */ import it.unimi.dsi.fastutil.longs.AbstractLongCollection;
/*     */ import it.unimi.dsi.fastutil.longs.LongCollection;
/*     */ import it.unimi.dsi.fastutil.longs.LongIterator;
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
/*     */ public class Char2LongOpenCustomHashMap extends AbstractChar2LongMap
/*     */   implements Serializable, Cloneable, Hash
/*     */ {
/*     */   public static final long serialVersionUID = 0L;
/*     */   private static final boolean ASSERTS = false;
/*     */   protected transient char[] key;
/*     */   protected transient long[] value;
/*     */   protected transient boolean[] used;
/*     */   protected final float f;
/*     */   protected transient int n;
/*     */   protected transient int maxFill;
/*     */   protected transient int mask;
/*     */   protected int size;
/*     */   protected volatile transient Char2LongMap.FastEntrySet entries;
/*     */   protected volatile transient CharSet keys;
/*     */   protected volatile transient LongCollection values;
/*     */   protected CharHash.Strategy strategy;
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(int expected, float f, CharHash.Strategy strategy)
/*     */   {
/* 111 */     this.strategy = strategy;
/* 112 */     if ((f <= 0.0F) || (f > 1.0F)) throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
/* 113 */     if (expected < 0) throw new IllegalArgumentException("The expected number of elements must be nonnegative");
/* 114 */     this.f = f;
/* 115 */     this.n = HashCommon.arraySize(expected, f);
/* 116 */     this.mask = (this.n - 1);
/* 117 */     this.maxFill = HashCommon.maxFill(this.n, f);
/* 118 */     this.key = new char[this.n];
/* 119 */     this.value = new long[this.n];
/* 120 */     this.used = new boolean[this.n];
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(int expected, CharHash.Strategy strategy)
/*     */   {
/* 128 */     this(expected, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(CharHash.Strategy strategy)
/*     */   {
/* 135 */     this(16, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(Map<? extends Character, ? extends Long> m, float f, CharHash.Strategy strategy)
/*     */   {
/* 144 */     this(m.size(), f, strategy);
/* 145 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(Map<? extends Character, ? extends Long> m, CharHash.Strategy strategy)
/*     */   {
/* 153 */     this(m, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(Char2LongMap m, float f, CharHash.Strategy strategy)
/*     */   {
/* 162 */     this(m.size(), f, strategy);
/* 163 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(Char2LongMap m, CharHash.Strategy strategy)
/*     */   {
/* 171 */     this(m, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(char[] k, long[] v, float f, CharHash.Strategy strategy)
/*     */   {
/* 182 */     this(k.length, f, strategy);
/* 183 */     if (k.length != v.length) throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
/* 184 */     for (int i = 0; i < k.length; i++) put(k[i], v[i]);
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap(char[] k, long[] v, CharHash.Strategy strategy)
/*     */   {
/* 194 */     this(k, v, 0.75F, strategy);
/*     */   }
/*     */ 
/*     */   public CharHash.Strategy strategy()
/*     */   {
/* 201 */     return this.strategy;
/*     */   }
/*     */ 
/*     */   public long put(char k, long v)
/*     */   {
/* 209 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 211 */     while (this.used[pos] != 0) {
/* 212 */       if (this.strategy.equals(this.key[pos], k)) {
/* 213 */         long oldValue = this.value[pos];
/* 214 */         this.value[pos] = v;
/* 215 */         return oldValue;
/*     */       }
/* 217 */       pos = pos + 1 & this.mask;
/*     */     }
/* 219 */     this.used[pos] = true;
/* 220 */     this.key[pos] = k;
/* 221 */     this.value[pos] = v;
/* 222 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 224 */     return this.defRetValue;
/*     */   }
/*     */   public Long put(Character ok, Long ov) {
/* 227 */     long v = ov.longValue();
/* 228 */     char k = ok.charValue();
/*     */ 
/* 230 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 232 */     while (this.used[pos] != 0) {
/* 233 */       if (this.strategy.equals(this.key[pos], k)) {
/* 234 */         Long oldValue = Long.valueOf(this.value[pos]);
/* 235 */         this.value[pos] = v;
/* 236 */         return oldValue;
/*     */       }
/* 238 */       pos = pos + 1 & this.mask;
/*     */     }
/* 240 */     this.used[pos] = true;
/* 241 */     this.key[pos] = k;
/* 242 */     this.value[pos] = v;
/* 243 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 245 */     return null;
/*     */   }
/*     */ 
/*     */   public long add(char k, long incr)
/*     */   {
/* 260 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 262 */     while (this.used[pos] != 0) {
/* 263 */       if (this.strategy.equals(this.key[pos], k)) {
/* 264 */         long oldValue = this.value[pos];
/* 265 */         this.value[pos] += incr;
/* 266 */         return oldValue;
/*     */       }
/* 268 */       pos = pos + 1 & this.mask;
/*     */     }
/* 270 */     this.used[pos] = true;
/* 271 */     this.key[pos] = k;
/* 272 */     this.value[pos] = (this.defRetValue + incr);
/* 273 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*     */ 
/* 275 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   protected final int shiftKeys(int pos)
/*     */   {
/*     */     int last;
/*     */     while (true)
/*     */     {
/* 287 */       pos = (last = pos) + 1 & this.mask;
/* 288 */       while (this.used[pos] != 0) {
/* 289 */         int slot = HashCommon.murmurHash3(this.strategy.hashCode(this.key[pos])) & this.mask;
/* 290 */         if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 291 */         pos = pos + 1 & this.mask;
/*     */       }
/* 293 */       if (this.used[pos] == 0) break;
/* 294 */       this.key[last] = this.key[pos];
/* 295 */       this.value[last] = this.value[pos];
/*     */     }
/* 297 */     this.used[last] = false;
/* 298 */     return last;
/*     */   }
/*     */ 
/*     */   public long remove(char k)
/*     */   {
/* 303 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 305 */     while (this.used[pos] != 0) {
/* 306 */       if (this.strategy.equals(this.key[pos], k)) {
/* 307 */         this.size -= 1;
/* 308 */         long v = this.value[pos];
/* 309 */         shiftKeys(pos);
/* 310 */         return v;
/*     */       }
/* 312 */       pos = pos + 1 & this.mask;
/*     */     }
/* 314 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public Long remove(Object ok) {
/* 318 */     char k = ((Character)ok).charValue();
/*     */ 
/* 320 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 322 */     while (this.used[pos] != 0) {
/* 323 */       if (this.strategy.equals(this.key[pos], k)) {
/* 324 */         this.size -= 1;
/* 325 */         long v = this.value[pos];
/* 326 */         shiftKeys(pos);
/* 327 */         return Long.valueOf(v);
/*     */       }
/* 329 */       pos = pos + 1 & this.mask;
/*     */     }
/* 331 */     return null;
/*     */   }
/*     */   public Long get(Character ok) {
/* 334 */     char k = ok.charValue();
/*     */ 
/* 336 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 338 */     while (this.used[pos] != 0) {
/* 339 */       if (this.strategy.equals(this.key[pos], k)) return Long.valueOf(this.value[pos]);
/* 340 */       pos = pos + 1 & this.mask;
/*     */     }
/* 342 */     return null;
/*     */   }
/*     */ 
/*     */   public long get(char k)
/*     */   {
/* 347 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 349 */     while (this.used[pos] != 0) {
/* 350 */       if (this.strategy.equals(this.key[pos], k)) return this.value[pos];
/* 351 */       pos = pos + 1 & this.mask;
/*     */     }
/* 353 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public boolean containsKey(char k)
/*     */   {
/* 358 */     int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/*     */ 
/* 360 */     while (this.used[pos] != 0) {
/* 361 */       if (this.strategy.equals(this.key[pos], k)) return true;
/* 362 */       pos = pos + 1 & this.mask;
/*     */     }
/* 364 */     return false;
/*     */   }
/*     */   public boolean containsValue(long v) {
/* 367 */     long[] value = this.value;
/* 368 */     boolean[] used = this.used;
/* 369 */     for (int i = this.n; i-- != 0; return true) label17: if ((used[i] == 0) || (value[i] != v))
/*     */         break label17; return false;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 379 */     if (this.size == 0) return;
/* 380 */     this.size = 0;
/* 381 */     BooleanArrays.fill(this.used, false);
/*     */   }
/*     */ 
/*     */   public int size() {
/* 385 */     return this.size;
/*     */   }
/*     */   public boolean isEmpty() {
/* 388 */     return this.size == 0;
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
/* 405 */     return 16;
/*     */   }
/*     */ 
/*     */   public Char2LongMap.FastEntrySet char2LongEntrySet()
/*     */   {
/* 611 */     if (this.entries == null) this.entries = new MapEntrySet(null);
/* 612 */     return this.entries;
/*     */   }
/*     */ 
/*     */   public CharSet keySet()
/*     */   {
/* 645 */     if (this.keys == null) this.keys = new KeySet(null);
/* 646 */     return this.keys;
/*     */   }
/*     */ 
/*     */   public LongCollection values()
/*     */   {
/* 660 */     if (this.values == null) this.values = new AbstractLongCollection() {
/*     */         public LongIterator iterator() {
/* 662 */           return new Char2LongOpenCustomHashMap.ValueIterator(Char2LongOpenCustomHashMap.this);
/*     */         }
/*     */         public int size() {
/* 665 */           return Char2LongOpenCustomHashMap.this.size;
/*     */         }
/*     */         public boolean contains(long v) {
/* 668 */           return Char2LongOpenCustomHashMap.this.containsValue(v);
/*     */         }
/*     */         public void clear() {
/* 671 */           Char2LongOpenCustomHashMap.this.clear();
/*     */         }
/*     */       };
/* 674 */     return this.values;
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public boolean rehash()
/*     */   {
/* 688 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean trim()
/*     */   {
/* 703 */     int l = HashCommon.arraySize(this.size, this.f);
/* 704 */     if (l >= this.n) return true; try
/*     */     {
/* 706 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 708 */       return false;
/* 709 */     }return true;
/*     */   }
/*     */ 
/*     */   public boolean trim(int n)
/*     */   {
/* 730 */     int l = HashCommon.nextPowerOfTwo((int)Math.ceil(n / this.f));
/* 731 */     if (this.n <= l) return true; try
/*     */     {
/* 733 */       rehash(l);
/*     */     } catch (OutOfMemoryError cantDoIt) {
/* 735 */       return false;
/* 736 */     }return true;
/*     */   }
/*     */ 
/*     */   protected void rehash(int newN)
/*     */   {
/* 749 */     int i = 0;
/* 750 */     boolean[] used = this.used;
/*     */ 
/* 752 */     char[] key = this.key;
/* 753 */     long[] value = this.value;
/* 754 */     int newMask = newN - 1;
/* 755 */     char[] newKey = new char[newN];
/* 756 */     long[] newValue = new long[newN];
/* 757 */     boolean[] newUsed = new boolean[newN];
/* 758 */     for (int j = this.size; j-- != 0; ) {
/* 759 */       while (used[i] == 0) i++;
/* 760 */       char k = key[i];
/* 761 */       int pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & newMask;
/* 762 */       while (newUsed[pos] != 0) pos = pos + 1 & newMask;
/* 763 */       newUsed[pos] = true;
/* 764 */       newKey[pos] = k;
/* 765 */       newValue[pos] = value[i];
/* 766 */       i++;
/*     */     }
/* 768 */     this.n = newN;
/* 769 */     this.mask = newMask;
/* 770 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 771 */     this.key = newKey;
/* 772 */     this.value = newValue;
/* 773 */     this.used = newUsed;
/*     */   }
/*     */ 
/*     */   public Char2LongOpenCustomHashMap clone()
/*     */   {
/*     */     Char2LongOpenCustomHashMap c;
/*     */     try
/*     */     {
/* 786 */       c = (Char2LongOpenCustomHashMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 789 */       throw new InternalError();
/*     */     }
/* 791 */     c.keys = null;
/* 792 */     c.values = null;
/* 793 */     c.entries = null;
/* 794 */     c.key = ((char[])this.key.clone());
/* 795 */     c.value = ((long[])this.value.clone());
/* 796 */     c.used = ((boolean[])this.used.clone());
/* 797 */     c.strategy = this.strategy;
/* 798 */     return c;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 810 */     int h = 0;
/* 811 */     int j = this.size; int i = 0; for (int t = 0; j-- != 0; ) {
/* 812 */       while (this.used[i] == 0) i++;
/* 813 */       t = this.strategy.hashCode(this.key[i]);
/* 814 */       t ^= HashCommon.long2int(this.value[i]);
/* 815 */       h += t;
/* 816 */       i++;
/*     */     }
/* 818 */     return h;
/*     */   }
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 821 */     char[] key = this.key;
/* 822 */     long[] value = this.value;
/* 823 */     MapIterator i = new MapIterator(null);
/* 824 */     s.defaultWriteObject();
/* 825 */     for (int j = this.size; j-- != 0; ) {
/* 826 */       int e = i.nextEntry();
/* 827 */       s.writeChar(key[e]);
/* 828 */       s.writeLong(value[e]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 833 */     s.defaultReadObject();
/* 834 */     this.n = HashCommon.arraySize(this.size, this.f);
/* 835 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 836 */     this.mask = (this.n - 1);
/* 837 */     char[] key = this.key = new char[this.n];
/* 838 */     long[] value = this.value = new long[this.n];
/* 839 */     boolean[] used = this.used = new boolean[this.n];
/*     */ 
/* 842 */     int i = this.size; for (int pos = 0; i-- != 0; ) {
/* 843 */       char k = s.readChar();
/* 844 */       long v = s.readLong();
/* 845 */       pos = HashCommon.murmurHash3(this.strategy.hashCode(k)) & this.mask;
/* 846 */       while (used[pos] != 0) pos = pos + 1 & this.mask;
/* 847 */       used[pos] = true;
/* 848 */       key[pos] = k;
/* 849 */       value[pos] = v;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void checkTable()
/*     */   {
/*     */   }
/*     */ 
/*     */   private final class ValueIterator extends Char2LongOpenCustomHashMap.MapIterator
/*     */     implements LongIterator
/*     */   {
/*     */     public ValueIterator()
/*     */     {
/* 655 */       super(null); } 
/* 656 */     public long nextLong() { return Char2LongOpenCustomHashMap.this.value[nextEntry()]; } 
/* 657 */     public Long next() { return Long.valueOf(Char2LongOpenCustomHashMap.this.value[nextEntry()]); }
/*     */ 
/*     */   }
/*     */ 
/*     */   private final class KeySet extends AbstractCharSet
/*     */   {
/*     */     private KeySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CharIterator iterator()
/*     */     {
/* 627 */       return new Char2LongOpenCustomHashMap.KeyIterator(Char2LongOpenCustomHashMap.this);
/*     */     }
/*     */     public int size() {
/* 630 */       return Char2LongOpenCustomHashMap.this.size;
/*     */     }
/*     */     public boolean contains(char k) {
/* 633 */       return Char2LongOpenCustomHashMap.this.containsKey(k);
/*     */     }
/*     */     public boolean remove(char k) {
/* 636 */       int oldSize = Char2LongOpenCustomHashMap.this.size;
/* 637 */       Char2LongOpenCustomHashMap.this.remove(k);
/* 638 */       return Char2LongOpenCustomHashMap.this.size != oldSize;
/*     */     }
/*     */     public void clear() {
/* 641 */       Char2LongOpenCustomHashMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class KeyIterator extends Char2LongOpenCustomHashMap.MapIterator
/*     */     implements CharIterator
/*     */   {
/*     */     public KeyIterator()
/*     */     {
/* 621 */       super(null); } 
/* 622 */     public char nextChar() { return Char2LongOpenCustomHashMap.this.key[nextEntry()]; } 
/* 623 */     public Character next() { return Character.valueOf(Char2LongOpenCustomHashMap.this.key[nextEntry()]); }
/*     */ 
/*     */   }
/*     */ 
/*     */   private final class MapEntrySet extends AbstractObjectSet<Char2LongMap.Entry>
/*     */     implements Char2LongMap.FastEntrySet
/*     */   {
/*     */     private MapEntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Char2LongMap.Entry> iterator()
/*     */     {
/* 567 */       return new Char2LongOpenCustomHashMap.EntryIterator(Char2LongOpenCustomHashMap.this, null);
/*     */     }
/*     */     public ObjectIterator<Char2LongMap.Entry> fastIterator() {
/* 570 */       return new Char2LongOpenCustomHashMap.FastEntryIterator(Char2LongOpenCustomHashMap.this, null);
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 574 */       if (!(o instanceof Map.Entry)) return false;
/* 575 */       Map.Entry e = (Map.Entry)o;
/* 576 */       char k = ((Character)e.getKey()).charValue();
/*     */ 
/* 578 */       int pos = HashCommon.murmurHash3(Char2LongOpenCustomHashMap.this.strategy.hashCode(k)) & Char2LongOpenCustomHashMap.this.mask;
/*     */ 
/* 580 */       while (Char2LongOpenCustomHashMap.this.used[pos] != 0) {
/* 581 */         if (Char2LongOpenCustomHashMap.this.strategy.equals(Char2LongOpenCustomHashMap.this.key[pos], k)) return Char2LongOpenCustomHashMap.this.value[pos] == ((Long)e.getValue()).longValue();
/* 582 */         pos = pos + 1 & Char2LongOpenCustomHashMap.this.mask;
/*     */       }
/* 584 */       return false;
/*     */     }
/*     */ 
/*     */     public boolean remove(Object o) {
/* 588 */       if (!(o instanceof Map.Entry)) return false;
/* 589 */       Map.Entry e = (Map.Entry)o;
/* 590 */       char k = ((Character)e.getKey()).charValue();
/*     */ 
/* 592 */       int pos = HashCommon.murmurHash3(Char2LongOpenCustomHashMap.this.strategy.hashCode(k)) & Char2LongOpenCustomHashMap.this.mask;
/*     */ 
/* 594 */       while (Char2LongOpenCustomHashMap.this.used[pos] != 0) {
/* 595 */         if (Char2LongOpenCustomHashMap.this.strategy.equals(Char2LongOpenCustomHashMap.this.key[pos], k)) {
/* 596 */           Char2LongOpenCustomHashMap.this.remove(e.getKey());
/* 597 */           return true;
/*     */         }
/* 599 */         pos = pos + 1 & Char2LongOpenCustomHashMap.this.mask;
/*     */       }
/* 601 */       return false;
/*     */     }
/*     */     public int size() {
/* 604 */       return Char2LongOpenCustomHashMap.this.size;
/*     */     }
/*     */     public void clear() {
/* 607 */       Char2LongOpenCustomHashMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class FastEntryIterator extends Char2LongOpenCustomHashMap.MapIterator
/*     */     implements ObjectIterator<Char2LongMap.Entry>
/*     */   {
/* 557 */     final AbstractChar2LongMap.BasicEntry entry = new AbstractChar2LongMap.BasicEntry('\000', 0L);
/*     */ 
/*     */     private FastEntryIterator()
/*     */     {
/* 556 */       super(null);
/*     */     }
/*     */     public AbstractChar2LongMap.BasicEntry next() {
/* 559 */       int e = nextEntry();
/* 560 */       this.entry.key = Char2LongOpenCustomHashMap.this.key[e];
/* 561 */       this.entry.value = Char2LongOpenCustomHashMap.this.value[e];
/* 562 */       return this.entry;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class EntryIterator extends Char2LongOpenCustomHashMap.MapIterator
/*     */     implements ObjectIterator<Char2LongMap.Entry>
/*     */   {
/*     */     private Char2LongOpenCustomHashMap.MapEntry entry;
/*     */ 
/*     */     private EntryIterator()
/*     */     {
/* 545 */       super(null);
/*     */     }
/*     */     public Char2LongMap.Entry next() {
/* 548 */       return this.entry = new Char2LongOpenCustomHashMap.MapEntry(Char2LongOpenCustomHashMap.this, nextEntry());
/*     */     }
/*     */ 
/*     */     public void remove() {
/* 552 */       super.remove();
/* 553 */       Char2LongOpenCustomHashMap.MapEntry.access$102(this.entry, -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MapIterator
/*     */   {
/*     */     int pos;
/*     */     int last;
/*     */     int c;
/*     */     CharArrayList wrapped;
/*     */ 
/*     */     private MapIterator()
/*     */     {
/* 454 */       this.pos = Char2LongOpenCustomHashMap.this.n;
/*     */ 
/* 457 */       this.last = -1;
/*     */ 
/* 459 */       this.c = Char2LongOpenCustomHashMap.this.size;
/*     */ 
/* 464 */       boolean[] used = Char2LongOpenCustomHashMap.this.used;
/* 465 */       while ((this.c != 0) && (used[(--this.pos)] == 0));
/*     */     }
/*     */ 
/*     */     public boolean hasNext()
/*     */     {
/* 468 */       return this.c != 0;
/*     */     }
/*     */     public int nextEntry() {
/* 471 */       if (!hasNext()) throw new NoSuchElementException();
/* 472 */       this.c -= 1;
/*     */ 
/* 474 */       if (this.pos < 0) {
/* 475 */         char k = this.wrapped.getChar(-(this.last = --this.pos) - 2);
/*     */ 
/* 477 */         int pos = HashCommon.murmurHash3(Char2LongOpenCustomHashMap.this.strategy.hashCode(k)) & Char2LongOpenCustomHashMap.this.mask;
/*     */ 
/* 479 */         while (Char2LongOpenCustomHashMap.this.used[pos] != 0) {
/* 480 */           if (Char2LongOpenCustomHashMap.this.strategy.equals(Char2LongOpenCustomHashMap.this.key[pos], k)) return pos;
/* 481 */           pos = pos + 1 & Char2LongOpenCustomHashMap.this.mask;
/*     */         }
/*     */       }
/* 484 */       this.last = this.pos;
/*     */ 
/* 486 */       if (this.c != 0) {
/* 487 */         boolean[] used = Char2LongOpenCustomHashMap.this.used;
/* 488 */         while ((this.pos-- != 0) && (used[this.pos] == 0));
/*     */       }
/* 491 */       return this.last;
/*     */     }
/*     */ 
/*     */     protected final int shiftKeys(int pos)
/*     */     {
/*     */       int last;
/*     */       while (true)
/*     */       {
/* 504 */         pos = (last = pos) + 1 & Char2LongOpenCustomHashMap.this.mask;
/* 505 */         while (Char2LongOpenCustomHashMap.this.used[pos] != 0) {
/* 506 */           int slot = HashCommon.murmurHash3(Char2LongOpenCustomHashMap.this.strategy.hashCode(Char2LongOpenCustomHashMap.this.key[pos])) & Char2LongOpenCustomHashMap.this.mask;
/* 507 */           if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/* 508 */           pos = pos + 1 & Char2LongOpenCustomHashMap.this.mask;
/*     */         }
/* 510 */         if (Char2LongOpenCustomHashMap.this.used[pos] == 0) break;
/* 511 */         if (pos < last)
/*     */         {
/* 513 */           if (this.wrapped == null) this.wrapped = new CharArrayList();
/* 514 */           this.wrapped.add(Char2LongOpenCustomHashMap.this.key[pos]);
/*     */         }
/* 516 */         Char2LongOpenCustomHashMap.this.key[last] = Char2LongOpenCustomHashMap.this.key[pos];
/* 517 */         Char2LongOpenCustomHashMap.this.value[last] = Char2LongOpenCustomHashMap.this.value[pos];
/*     */       }
/* 519 */       Char2LongOpenCustomHashMap.this.used[last] = false;
/* 520 */       return last;
/*     */     }
/*     */ 
/*     */     public void remove() {
/* 524 */       if (this.last == -1) throw new IllegalStateException();
/* 525 */       if (this.pos < -1)
/*     */       {
/* 527 */         Char2LongOpenCustomHashMap.this.remove(this.wrapped.getChar(-this.pos - 2));
/* 528 */         this.last = -1;
/* 529 */         return;
/*     */       }
/* 531 */       Char2LongOpenCustomHashMap.this.size -= 1;
/* 532 */       if ((shiftKeys(this.last) == this.pos) && (this.c > 0)) {
/* 533 */         this.c += 1;
/* 534 */         nextEntry();
/*     */       }
/* 536 */       this.last = -1;
/*     */     }
/*     */ 
/*     */     public int skip(int n) {
/* 540 */       int i = n;
/* 541 */       while ((i-- != 0) && (hasNext())) nextEntry();
/* 542 */       return n - i - 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class MapEntry
/*     */     implements Char2LongMap.Entry, Map.Entry<Character, Long>
/*     */   {
/*     */     private int index;
/*     */ 
/*     */     MapEntry(int index)
/*     */     {
/* 415 */       this.index = index;
/*     */     }
/*     */     public Character getKey() {
/* 418 */       return Character.valueOf(Char2LongOpenCustomHashMap.this.key[this.index]);
/*     */     }
/*     */     public char getCharKey() {
/* 421 */       return Char2LongOpenCustomHashMap.this.key[this.index];
/*     */     }
/*     */     public Long getValue() {
/* 424 */       return Long.valueOf(Char2LongOpenCustomHashMap.this.value[this.index]);
/*     */     }
/*     */     public long getLongValue() {
/* 427 */       return Char2LongOpenCustomHashMap.this.value[this.index];
/*     */     }
/*     */     public long setValue(long v) {
/* 430 */       long oldValue = Char2LongOpenCustomHashMap.this.value[this.index];
/* 431 */       Char2LongOpenCustomHashMap.this.value[this.index] = v;
/* 432 */       return oldValue;
/*     */     }
/*     */     public Long setValue(Long v) {
/* 435 */       return Long.valueOf(setValue(v.longValue()));
/*     */     }
/*     */ 
/*     */     public boolean equals(Object o) {
/* 439 */       if (!(o instanceof Map.Entry)) return false;
/* 440 */       Map.Entry e = (Map.Entry)o;
/* 441 */       return (Char2LongOpenCustomHashMap.this.strategy.equals(Char2LongOpenCustomHashMap.this.key[this.index], ((Character)e.getKey()).charValue())) && (Char2LongOpenCustomHashMap.this.value[this.index] == ((Long)e.getValue()).longValue());
/*     */     }
/*     */     public int hashCode() {
/* 444 */       return Char2LongOpenCustomHashMap.this.strategy.hashCode(Char2LongOpenCustomHashMap.this.key[this.index]) ^ HashCommon.long2int(Char2LongOpenCustomHashMap.this.value[this.index]);
/*     */     }
/*     */     public String toString() {
/* 447 */       return Char2LongOpenCustomHashMap.this.key[this.index] + "=>" + Char2LongOpenCustomHashMap.this.value[this.index];
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.chars.Char2LongOpenCustomHashMap
 * JD-Core Version:    0.6.2
 */