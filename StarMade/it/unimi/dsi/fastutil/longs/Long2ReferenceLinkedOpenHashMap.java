/*      */ package it.unimi.dsi.fastutil.longs;
/*      */ 
/*      */ import it.unimi.dsi.fastutil.Hash;
/*      */ import it.unimi.dsi.fastutil.HashCommon;
/*      */ import it.unimi.dsi.fastutil.booleans.BooleanArrays;
/*      */ import it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
/*      */ import it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectArrays;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectIterator;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectListIterator;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
/*      */ import it.unimi.dsi.fastutil.objects.ReferenceCollection;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.Comparator;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.NoSuchElementException;
/*      */ 
/*      */ public class Long2ReferenceLinkedOpenHashMap<V> extends AbstractLong2ReferenceSortedMap<V>
/*      */   implements Serializable, Cloneable, Hash
/*      */ {
/*      */   public static final long serialVersionUID = 0L;
/*      */   private static final boolean ASSERTS = false;
/*      */   protected transient long[] key;
/*      */   protected transient V[] value;
/*      */   protected transient boolean[] used;
/*      */   protected final float f;
/*      */   protected transient int n;
/*      */   protected transient int maxFill;
/*      */   protected transient int mask;
/*      */   protected int size;
/*      */   protected volatile transient Long2ReferenceSortedMap.FastSortedEntrySet<V> entries;
/*      */   protected volatile transient LongSortedSet keys;
/*      */   protected volatile transient ReferenceCollection<V> values;
/*  118 */   protected transient int first = -1;
/*      */ 
/*  120 */   protected transient int last = -1;
/*      */   protected transient long[] link;
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(int expected, float f)
/*      */   {
/*  139 */     if ((f <= 0.0F) || (f > 1.0F)) throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
/*  140 */     if (expected < 0) throw new IllegalArgumentException("The expected number of elements must be nonnegative");
/*  141 */     this.f = f;
/*  142 */     this.n = HashCommon.arraySize(expected, f);
/*  143 */     this.mask = (this.n - 1);
/*  144 */     this.maxFill = HashCommon.maxFill(this.n, f);
/*  145 */     this.key = new long[this.n];
/*  146 */     this.value = ((Object[])new Object[this.n]);
/*  147 */     this.used = new boolean[this.n];
/*  148 */     this.link = new long[this.n];
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(int expected)
/*      */   {
/*  155 */     this(expected, 0.75F);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap()
/*      */   {
/*  161 */     this(16, 0.75F);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(Map<? extends Long, ? extends V> m, float f)
/*      */   {
/*  169 */     this(m.size(), f);
/*  170 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(Map<? extends Long, ? extends V> m)
/*      */   {
/*  177 */     this(m, 0.75F);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(Long2ReferenceMap<V> m, float f)
/*      */   {
/*  185 */     this(m.size(), f);
/*  186 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(Long2ReferenceMap<V> m)
/*      */   {
/*  193 */     this(m, 0.75F);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(long[] k, V[] v, float f)
/*      */   {
/*  203 */     this(k.length, f);
/*  204 */     if (k.length != v.length) throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
/*  205 */     for (int i = 0; i < k.length; i++) put(k[i], v[i]);
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap(long[] k, V[] v)
/*      */   {
/*  214 */     this(k, v, 0.75F);
/*      */   }
/*      */ 
/*      */   public V put(long k, V v)
/*      */   {
/*  222 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  224 */     while (this.used[pos] != 0) {
/*  225 */       if (this.key[pos] == k) {
/*  226 */         Object oldValue = this.value[pos];
/*  227 */         this.value[pos] = v;
/*  228 */         return oldValue;
/*      */       }
/*  230 */       pos = pos + 1 & this.mask;
/*      */     }
/*  232 */     this.used[pos] = true;
/*  233 */     this.key[pos] = k;
/*  234 */     this.value[pos] = v;
/*  235 */     if (this.size == 0) {
/*  236 */       this.first = (this.last = pos);
/*      */ 
/*  238 */       this.link[pos] = -1L;
/*      */     }
/*      */     else {
/*  241 */       this.link[this.last] ^= (this.link[this.last] ^ pos & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  242 */       this.link[pos] = ((this.last & 0xFFFFFFFF) << 32 | 0xFFFFFFFF);
/*  243 */       this.last = pos;
/*      */     }
/*  245 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*      */ 
/*  247 */     return this.defRetValue;
/*      */   }
/*      */   public V put(Long ok, V ov) {
/*  250 */     Object v = ov;
/*  251 */     long k = ok.longValue();
/*      */ 
/*  253 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  255 */     while (this.used[pos] != 0) {
/*  256 */       if (this.key[pos] == k) {
/*  257 */         Object oldValue = this.value[pos];
/*  258 */         this.value[pos] = v;
/*  259 */         return oldValue;
/*      */       }
/*  261 */       pos = pos + 1 & this.mask;
/*      */     }
/*  263 */     this.used[pos] = true;
/*  264 */     this.key[pos] = k;
/*  265 */     this.value[pos] = v;
/*  266 */     if (this.size == 0) {
/*  267 */       this.first = (this.last = pos);
/*      */ 
/*  269 */       this.link[pos] = -1L;
/*      */     }
/*      */     else {
/*  272 */       this.link[this.last] ^= (this.link[this.last] ^ pos & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  273 */       this.link[pos] = ((this.last & 0xFFFFFFFF) << 32 | 0xFFFFFFFF);
/*  274 */       this.last = pos;
/*      */     }
/*  276 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size + 1, this.f));
/*      */ 
/*  278 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   protected final int shiftKeys(int pos)
/*      */   {
/*      */     int last;
/*      */     while (true)
/*      */     {
/*  290 */       pos = (last = pos) + 1 & this.mask;
/*  291 */       while (this.used[pos] != 0) {
/*  292 */         int slot = (int)HashCommon.murmurHash3(this.key[pos]) & this.mask;
/*  293 */         if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/*  294 */         pos = pos + 1 & this.mask;
/*      */       }
/*  296 */       if (this.used[pos] == 0) break;
/*  297 */       this.key[last] = this.key[pos];
/*  298 */       this.value[last] = this.value[pos];
/*  299 */       fixPointers(pos, last);
/*      */     }
/*  301 */     this.used[last] = false;
/*  302 */     this.value[last] = null;
/*  303 */     return last;
/*      */   }
/*      */ 
/*      */   public V remove(long k)
/*      */   {
/*  308 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  310 */     while (this.used[pos] != 0) {
/*  311 */       if (this.key[pos] == k) {
/*  312 */         this.size -= 1;
/*  313 */         fixPointers(pos);
/*  314 */         Object v = this.value[pos];
/*  315 */         shiftKeys(pos);
/*  316 */         return v;
/*      */       }
/*  318 */       pos = pos + 1 & this.mask;
/*      */     }
/*  320 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V remove(Object ok) {
/*  324 */     long k = ((Long)ok).longValue();
/*      */ 
/*  326 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  328 */     while (this.used[pos] != 0) {
/*  329 */       if (this.key[pos] == k) {
/*  330 */         this.size -= 1;
/*  331 */         fixPointers(pos);
/*  332 */         Object v = this.value[pos];
/*  333 */         shiftKeys(pos);
/*  334 */         return v;
/*      */       }
/*  336 */       pos = pos + 1 & this.mask;
/*      */     }
/*  338 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V removeFirst()
/*      */   {
/*  345 */     if (this.size == 0) throw new NoSuchElementException();
/*  346 */     this.size -= 1;
/*  347 */     int pos = this.first;
/*      */ 
/*  349 */     this.first = ((int)this.link[pos]);
/*  350 */     if (0 <= this.first)
/*      */     {
/*  352 */       this.link[this.first] |= -4294967296L;
/*      */     }
/*  354 */     Object v = this.value[pos];
/*  355 */     shiftKeys(pos);
/*  356 */     return v;
/*      */   }
/*      */ 
/*      */   public V removeLast()
/*      */   {
/*  363 */     if (this.size == 0) throw new NoSuchElementException();
/*  364 */     this.size -= 1;
/*  365 */     int pos = this.last;
/*      */ 
/*  367 */     this.last = ((int)(this.link[pos] >>> 32));
/*  368 */     if (0 <= this.last)
/*      */     {
/*  370 */       this.link[this.last] |= 4294967295L;
/*      */     }
/*  372 */     Object v = this.value[pos];
/*  373 */     shiftKeys(pos);
/*  374 */     return v;
/*      */   }
/*      */   private void moveIndexToFirst(int i) {
/*  377 */     if ((this.size == 1) || (this.first == i)) return;
/*  378 */     if (this.last == i) {
/*  379 */       this.last = ((int)(this.link[i] >>> 32));
/*      */ 
/*  381 */       this.link[this.last] |= 4294967295L;
/*      */     }
/*      */     else {
/*  384 */       long linki = this.link[i];
/*  385 */       int prev = (int)(linki >>> 32);
/*  386 */       int next = (int)linki;
/*  387 */       this.link[prev] ^= (this.link[prev] ^ linki & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  388 */       this.link[next] ^= (this.link[next] ^ linki & 0x0) & 0x0;
/*      */     }
/*  390 */     this.link[this.first] ^= (this.link[this.first] ^ (i & 0xFFFFFFFF) << 32) & 0x0;
/*  391 */     this.link[i] = (0x0 | this.first & 0xFFFFFFFF);
/*  392 */     this.first = i;
/*      */   }
/*      */   private void moveIndexToLast(int i) {
/*  395 */     if ((this.size == 1) || (this.last == i)) return;
/*  396 */     if (this.first == i) {
/*  397 */       this.first = ((int)this.link[i]);
/*      */ 
/*  399 */       this.link[this.first] |= -4294967296L;
/*      */     }
/*      */     else {
/*  402 */       long linki = this.link[i];
/*  403 */       int prev = (int)(linki >>> 32);
/*  404 */       int next = (int)linki;
/*  405 */       this.link[prev] ^= (this.link[prev] ^ linki & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  406 */       this.link[next] ^= (this.link[next] ^ linki & 0x0) & 0x0;
/*      */     }
/*  408 */     this.link[this.last] ^= (this.link[this.last] ^ i & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  409 */     this.link[i] = ((this.last & 0xFFFFFFFF) << 32 | 0xFFFFFFFF);
/*  410 */     this.last = i;
/*      */   }
/*      */ 
/*      */   public V getAndMoveToFirst(long k)
/*      */   {
/*  418 */     long[] key = this.key;
/*  419 */     boolean[] used = this.used;
/*  420 */     int mask = this.mask;
/*      */ 
/*  422 */     int pos = (int)HashCommon.murmurHash3(k) & mask;
/*      */ 
/*  424 */     while (used[pos] != 0) {
/*  425 */       if (k == key[pos]) {
/*  426 */         moveIndexToFirst(pos);
/*  427 */         return this.value[pos];
/*      */       }
/*  429 */       pos = pos + 1 & mask;
/*      */     }
/*  431 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V getAndMoveToLast(long k)
/*      */   {
/*  439 */     long[] key = this.key;
/*  440 */     boolean[] used = this.used;
/*  441 */     int mask = this.mask;
/*      */ 
/*  443 */     int pos = (int)HashCommon.murmurHash3(k) & mask;
/*      */ 
/*  445 */     while (used[pos] != 0) {
/*  446 */       if (k == key[pos]) {
/*  447 */         moveIndexToLast(pos);
/*  448 */         return this.value[pos];
/*      */       }
/*  450 */       pos = pos + 1 & mask;
/*      */     }
/*  452 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V putAndMoveToFirst(long k, V v)
/*      */   {
/*  461 */     long[] key = this.key;
/*  462 */     boolean[] used = this.used;
/*  463 */     int mask = this.mask;
/*      */ 
/*  465 */     int pos = (int)HashCommon.murmurHash3(k) & mask;
/*      */ 
/*  467 */     while (used[pos] != 0) {
/*  468 */       if (k == key[pos]) {
/*  469 */         Object oldValue = this.value[pos];
/*  470 */         this.value[pos] = v;
/*  471 */         moveIndexToFirst(pos);
/*  472 */         return oldValue;
/*      */       }
/*  474 */       pos = pos + 1 & mask;
/*      */     }
/*  476 */     used[pos] = true;
/*  477 */     key[pos] = k;
/*  478 */     this.value[pos] = v;
/*  479 */     if (this.size == 0) {
/*  480 */       this.first = (this.last = pos);
/*      */ 
/*  482 */       this.link[pos] = -1L;
/*      */     }
/*      */     else {
/*  485 */       this.link[this.first] ^= (this.link[this.first] ^ (pos & 0xFFFFFFFF) << 32) & 0x0;
/*  486 */       this.link[pos] = (0x0 | this.first & 0xFFFFFFFF);
/*  487 */       this.first = pos;
/*      */     }
/*  489 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size, this.f));
/*      */ 
/*  491 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V putAndMoveToLast(long k, V v)
/*      */   {
/*  500 */     long[] key = this.key;
/*  501 */     boolean[] used = this.used;
/*  502 */     int mask = this.mask;
/*      */ 
/*  504 */     int pos = (int)HashCommon.murmurHash3(k) & mask;
/*      */ 
/*  506 */     while (used[pos] != 0) {
/*  507 */       if (k == key[pos]) {
/*  508 */         Object oldValue = this.value[pos];
/*  509 */         this.value[pos] = v;
/*  510 */         moveIndexToLast(pos);
/*  511 */         return oldValue;
/*      */       }
/*  513 */       pos = pos + 1 & mask;
/*      */     }
/*  515 */     used[pos] = true;
/*  516 */     key[pos] = k;
/*  517 */     this.value[pos] = v;
/*  518 */     if (this.size == 0) {
/*  519 */       this.first = (this.last = pos);
/*      */ 
/*  521 */       this.link[pos] = -1L;
/*      */     }
/*      */     else {
/*  524 */       this.link[this.last] ^= (this.link[this.last] ^ pos & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  525 */       this.link[pos] = ((this.last & 0xFFFFFFFF) << 32 | 0xFFFFFFFF);
/*  526 */       this.last = pos;
/*      */     }
/*  528 */     if (++this.size >= this.maxFill) rehash(HashCommon.arraySize(this.size, this.f));
/*      */ 
/*  530 */     return this.defRetValue;
/*      */   }
/*      */   public V get(Long ok) {
/*  533 */     long k = ok.longValue();
/*      */ 
/*  535 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  537 */     while (this.used[pos] != 0) {
/*  538 */       if (this.key[pos] == k) return this.value[pos];
/*  539 */       pos = pos + 1 & this.mask;
/*      */     }
/*  541 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public V get(long k)
/*      */   {
/*  546 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  548 */     while (this.used[pos] != 0) {
/*  549 */       if (this.key[pos] == k) return this.value[pos];
/*  550 */       pos = pos + 1 & this.mask;
/*      */     }
/*  552 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   public boolean containsKey(long k)
/*      */   {
/*  557 */     int pos = (int)HashCommon.murmurHash3(k) & this.mask;
/*      */ 
/*  559 */     while (this.used[pos] != 0) {
/*  560 */       if (this.key[pos] == k) return true;
/*  561 */       pos = pos + 1 & this.mask;
/*      */     }
/*  563 */     return false;
/*      */   }
/*      */   public boolean containsValue(Object v) {
/*  566 */     Object[] value = this.value;
/*  567 */     boolean[] used = this.used;
/*  568 */     for (int i = this.n; i-- != 0; return true) label16: if ((used[i] == 0) || (value[i] != v))
/*      */         break label16; return false;
/*      */   }
/*      */ 
/*      */   public void clear()
/*      */   {
/*  578 */     if (this.size == 0) return;
/*  579 */     this.size = 0;
/*  580 */     BooleanArrays.fill(this.used, false);
/*      */ 
/*  582 */     ObjectArrays.fill(this.value, null);
/*  583 */     this.first = (this.last = -1);
/*      */   }
/*      */   public int size() {
/*  586 */     return this.size;
/*      */   }
/*      */   public boolean isEmpty() {
/*  589 */     return this.size == 0;
/*      */   }
/*      */ 
/*      */   @Deprecated
/*      */   public void growthFactor(int growthFactor)
/*      */   {
/*      */   }
/*      */ 
/*      */   @Deprecated
/*      */   public int growthFactor()
/*      */   {
/*  606 */     return 16;
/*      */   }
/*      */ 
/*      */   protected void fixPointers(int i)
/*      */   {
/*  653 */     if (this.size == 0) {
/*  654 */       this.first = (this.last = -1);
/*  655 */       return;
/*      */     }
/*  657 */     if (this.first == i) {
/*  658 */       this.first = ((int)this.link[i]);
/*  659 */       if (0 <= this.first)
/*      */       {
/*  661 */         this.link[this.first] |= -4294967296L;
/*      */       }
/*  663 */       return;
/*      */     }
/*  665 */     if (this.last == i) {
/*  666 */       this.last = ((int)(this.link[i] >>> 32));
/*  667 */       if (0 <= this.last)
/*      */       {
/*  669 */         this.link[this.last] |= 4294967295L;
/*      */       }
/*  671 */       return;
/*      */     }
/*  673 */     long linki = this.link[i];
/*  674 */     int prev = (int)(linki >>> 32);
/*  675 */     int next = (int)linki;
/*  676 */     this.link[prev] ^= (this.link[prev] ^ linki & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  677 */     this.link[next] ^= (this.link[next] ^ linki & 0x0) & 0x0;
/*      */   }
/*      */ 
/*      */   protected void fixPointers(int s, int d)
/*      */   {
/*  688 */     if (this.size == 1) {
/*  689 */       this.first = (this.last = d);
/*      */ 
/*  691 */       this.link[d] = -1L;
/*  692 */       return;
/*      */     }
/*  694 */     if (this.first == s) {
/*  695 */       this.first = d;
/*  696 */       this.link[((int)this.link[s])] ^= (this.link[((int)this.link[s])] ^ (d & 0xFFFFFFFF) << 32) & 0x0;
/*  697 */       this.link[d] = this.link[s];
/*  698 */       return;
/*      */     }
/*  700 */     if (this.last == s) {
/*  701 */       this.last = d;
/*  702 */       this.link[((int)(this.link[s] >>> 32))] ^= (this.link[((int)(this.link[s] >>> 32))] ^ d & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  703 */       this.link[d] = this.link[s];
/*  704 */       return;
/*      */     }
/*  706 */     long links = this.link[s];
/*  707 */     int prev = (int)(links >>> 32);
/*  708 */     int next = (int)links;
/*  709 */     this.link[prev] ^= (this.link[prev] ^ d & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  710 */     this.link[next] ^= (this.link[next] ^ (d & 0xFFFFFFFF) << 32) & 0x0;
/*  711 */     this.link[d] = links;
/*      */   }
/*      */ 
/*      */   public long firstLongKey()
/*      */   {
/*  718 */     if (this.size == 0) throw new NoSuchElementException();
/*  719 */     return this.key[this.first];
/*      */   }
/*      */ 
/*      */   public long lastLongKey()
/*      */   {
/*  726 */     if (this.size == 0) throw new NoSuchElementException();
/*  727 */     return this.key[this.last];
/*      */   }
/*  729 */   public LongComparator comparator() { return null; } 
/*  730 */   public Long2ReferenceSortedMap<V> tailMap(long from) { throw new UnsupportedOperationException(); } 
/*  731 */   public Long2ReferenceSortedMap<V> headMap(long to) { throw new UnsupportedOperationException(); } 
/*  732 */   public Long2ReferenceSortedMap<V> subMap(long from, long to) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */ 
/*      */   public Long2ReferenceSortedMap.FastSortedEntrySet<V> long2ReferenceEntrySet()
/*      */   {
/*  973 */     if (this.entries == null) this.entries = new MapEntrySet(null);
/*  974 */     return this.entries;
/*      */   }
/*      */ 
/*      */   public LongSortedSet keySet()
/*      */   {
/* 1029 */     if (this.keys == null) this.keys = new KeySet(null);
/* 1030 */     return this.keys;
/*      */   }
/*      */ 
/*      */   public ReferenceCollection<V> values()
/*      */   {
/* 1046 */     if (this.values == null) this.values = new AbstractReferenceCollection() {
/*      */         public ObjectIterator<V> iterator() {
/* 1048 */           return new Long2ReferenceLinkedOpenHashMap.ValueIterator(Long2ReferenceLinkedOpenHashMap.this);
/*      */         }
/*      */         public int size() {
/* 1051 */           return Long2ReferenceLinkedOpenHashMap.this.size;
/*      */         }
/*      */         public boolean contains(Object v) {
/* 1054 */           return Long2ReferenceLinkedOpenHashMap.this.containsValue(v);
/*      */         }
/*      */         public void clear() {
/* 1057 */           Long2ReferenceLinkedOpenHashMap.this.clear();
/*      */         }
/*      */       };
/* 1060 */     return this.values;
/*      */   }
/*      */ 
/*      */   @Deprecated
/*      */   public boolean rehash()
/*      */   {
/* 1074 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean trim()
/*      */   {
/* 1089 */     int l = HashCommon.arraySize(this.size, this.f);
/* 1090 */     if (l >= this.n) return true; try
/*      */     {
/* 1092 */       rehash(l);
/*      */     } catch (OutOfMemoryError cantDoIt) {
/* 1094 */       return false;
/* 1095 */     }return true;
/*      */   }
/*      */ 
/*      */   public boolean trim(int n)
/*      */   {
/* 1116 */     int l = HashCommon.nextPowerOfTwo((int)Math.ceil(n / this.f));
/* 1117 */     if (this.n <= l) return true; try
/*      */     {
/* 1119 */       rehash(l);
/*      */     } catch (OutOfMemoryError cantDoIt) {
/* 1121 */       return false;
/* 1122 */     }return true;
/*      */   }
/*      */ 
/*      */   protected void rehash(int newN)
/*      */   {
/* 1135 */     int i = this.first; int prev = -1; int newPrev = -1;
/*      */ 
/* 1137 */     long[] key = this.key;
/* 1138 */     Object[] value = this.value;
/* 1139 */     int newMask = newN - 1;
/* 1140 */     long[] newKey = new long[newN];
/* 1141 */     Object[] newValue = (Object[])new Object[newN];
/* 1142 */     boolean[] newUsed = new boolean[newN];
/* 1143 */     long[] link = this.link;
/* 1144 */     long[] newLink = new long[newN];
/* 1145 */     this.first = -1;
/* 1146 */     for (int j = this.size; j-- != 0; ) {
/* 1147 */       long k = key[i];
/* 1148 */       int pos = (int)HashCommon.murmurHash3(k) & newMask;
/* 1149 */       while (newUsed[pos] != 0) pos = pos + 1 & newMask;
/* 1150 */       newUsed[pos] = true;
/* 1151 */       newKey[pos] = k;
/* 1152 */       newValue[pos] = value[i];
/* 1153 */       if (prev != -1) {
/* 1154 */         newLink[newPrev] ^= (newLink[newPrev] ^ pos & 0xFFFFFFFF) & 0xFFFFFFFF;
/* 1155 */         newLink[pos] ^= (newLink[pos] ^ (newPrev & 0xFFFFFFFF) << 32) & 0x0;
/* 1156 */         newPrev = pos;
/*      */       }
/*      */       else {
/* 1159 */         newPrev = this.first = pos;
/*      */ 
/* 1161 */         newLink[pos] = -1L;
/*      */       }
/* 1163 */       int t = i;
/* 1164 */       i = (int)link[i];
/* 1165 */       prev = t;
/*      */     }
/* 1167 */     this.n = newN;
/* 1168 */     this.mask = newMask;
/* 1169 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 1170 */     this.key = newKey;
/* 1171 */     this.value = newValue;
/* 1172 */     this.used = newUsed;
/* 1173 */     this.link = newLink;
/* 1174 */     this.last = newPrev;
/* 1175 */     if (newPrev != -1)
/*      */     {
/* 1177 */       newLink[newPrev] |= 4294967295L;
/*      */     }
/*      */   }
/*      */ 
/*      */   public Long2ReferenceLinkedOpenHashMap<V> clone()
/*      */   {
/*      */     Long2ReferenceLinkedOpenHashMap c;
/*      */     try
/*      */     {
/* 1190 */       c = (Long2ReferenceLinkedOpenHashMap)super.clone();
/*      */     }
/*      */     catch (CloneNotSupportedException cantHappen) {
/* 1193 */       throw new InternalError();
/*      */     }
/* 1195 */     c.keys = null;
/* 1196 */     c.values = null;
/* 1197 */     c.entries = null;
/* 1198 */     c.key = ((long[])this.key.clone());
/* 1199 */     c.value = ((Object[])this.value.clone());
/* 1200 */     c.used = ((boolean[])this.used.clone());
/* 1201 */     c.link = ((long[])this.link.clone());
/* 1202 */     return c;
/*      */   }
/*      */ 
/*      */   public int hashCode()
/*      */   {
/* 1214 */     int h = 0;
/* 1215 */     int j = this.size; int i = 0; for (int t = 0; j-- != 0; ) {
/* 1216 */       while (this.used[i] == 0) i++;
/* 1217 */       t = HashCommon.long2int(this.key[i]);
/* 1218 */       if (this != this.value[i])
/* 1219 */         t ^= (this.value[i] == null ? 0 : System.identityHashCode(this.value[i]));
/* 1220 */       h += t;
/* 1221 */       i++;
/*      */     }
/* 1223 */     return h;
/*      */   }
/*      */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 1226 */     long[] key = this.key;
/* 1227 */     Object[] value = this.value;
/* 1228 */     MapIterator i = new MapIterator(null);
/* 1229 */     s.defaultWriteObject();
/* 1230 */     for (int j = this.size; j-- != 0; ) {
/* 1231 */       int e = i.nextEntry();
/* 1232 */       s.writeLong(key[e]);
/* 1233 */       s.writeObject(value[e]);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 1238 */     s.defaultReadObject();
/* 1239 */     this.n = HashCommon.arraySize(this.size, this.f);
/* 1240 */     this.maxFill = HashCommon.maxFill(this.n, this.f);
/* 1241 */     this.mask = (this.n - 1);
/* 1242 */     long[] key = this.key = new long[this.n];
/* 1243 */     Object[] value = this.value = (Object[])new Object[this.n];
/* 1244 */     boolean[] used = this.used = new boolean[this.n];
/* 1245 */     long[] link = this.link = new long[this.n];
/* 1246 */     int prev = -1;
/* 1247 */     this.first = (this.last = -1);
/*      */ 
/* 1250 */     int i = this.size; for (int pos = 0; i-- != 0; ) {
/* 1251 */       long k = s.readLong();
/* 1252 */       Object v = s.readObject();
/* 1253 */       pos = (int)HashCommon.murmurHash3(k) & this.mask;
/* 1254 */       while (used[pos] != 0) pos = pos + 1 & this.mask;
/* 1255 */       used[pos] = true;
/* 1256 */       key[pos] = k;
/* 1257 */       value[pos] = v;
/* 1258 */       if (this.first != -1) {
/* 1259 */         link[prev] ^= (link[prev] ^ pos & 0xFFFFFFFF) & 0xFFFFFFFF;
/* 1260 */         link[pos] ^= (link[pos] ^ (prev & 0xFFFFFFFF) << 32) & 0x0;
/* 1261 */         prev = pos;
/*      */       }
/*      */       else {
/* 1264 */         prev = this.first = pos;
/*      */ 
/* 1266 */         link[pos] |= -4294967296L;
/*      */       }
/*      */     }
/* 1269 */     this.last = prev;
/* 1270 */     if (prev != -1)
/*      */     {
/* 1272 */       link[prev] |= 4294967295L;
/*      */     }
/*      */   }
/*      */ 
/*      */   private void checkTable()
/*      */   {
/*      */   }
/*      */ 
/*      */   private final class ValueIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator
/*      */     implements ObjectListIterator<V>
/*      */   {
/*      */     public V previous()
/*      */     {
/* 1039 */       return Long2ReferenceLinkedOpenHashMap.this.value[previousEntry()]; } 
/* 1040 */     public void set(V v) { throw new UnsupportedOperationException(); } 
/* 1041 */     public void add(V v) { throw new UnsupportedOperationException(); } 
/* 1042 */     public ValueIterator() { super(null); } 
/* 1043 */     public V next() { return Long2ReferenceLinkedOpenHashMap.this.value[nextEntry()]; }
/*      */ 
/*      */   }
/*      */ 
/*      */   private final class KeySet extends AbstractLongSortedSet
/*      */   {
/*      */     private KeySet()
/*      */     {
/*      */     }
/*      */ 
/*      */     public LongListIterator iterator(long from)
/*      */     {
/*  996 */       return new Long2ReferenceLinkedOpenHashMap.KeyIterator(Long2ReferenceLinkedOpenHashMap.this, from);
/*      */     }
/*      */     public LongListIterator iterator() {
/*  999 */       return new Long2ReferenceLinkedOpenHashMap.KeyIterator(Long2ReferenceLinkedOpenHashMap.this);
/*      */     }
/*      */     public int size() {
/* 1002 */       return Long2ReferenceLinkedOpenHashMap.this.size;
/*      */     }
/*      */     public boolean contains(long k) {
/* 1005 */       return Long2ReferenceLinkedOpenHashMap.this.containsKey(k);
/*      */     }
/*      */     public boolean remove(long k) {
/* 1008 */       int oldSize = Long2ReferenceLinkedOpenHashMap.this.size;
/* 1009 */       Long2ReferenceLinkedOpenHashMap.this.remove(k);
/* 1010 */       return Long2ReferenceLinkedOpenHashMap.this.size != oldSize;
/*      */     }
/*      */     public void clear() {
/* 1013 */       Long2ReferenceLinkedOpenHashMap.this.clear();
/*      */     }
/*      */     public long firstLong() {
/* 1016 */       if (Long2ReferenceLinkedOpenHashMap.this.size == 0) throw new NoSuchElementException();
/* 1017 */       return Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.first];
/*      */     }
/*      */     public long lastLong() {
/* 1020 */       if (Long2ReferenceLinkedOpenHashMap.this.size == 0) throw new NoSuchElementException();
/* 1021 */       return Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.last];
/*      */     }
/* 1023 */     public LongComparator comparator() { return null; } 
/* 1024 */     public final LongSortedSet tailSet(long from) { throw new UnsupportedOperationException(); } 
/* 1025 */     public final LongSortedSet headSet(long to) { throw new UnsupportedOperationException(); } 
/* 1026 */     public final LongSortedSet subSet(long from, long to) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private final class KeyIterator extends Long2ReferenceLinkedOpenHashMap.MapIterator
/*      */     implements LongListIterator
/*      */   {
/*      */     public KeyIterator(long k)
/*      */     {
/*  983 */       super(k, null); } 
/*  984 */     public long previousLong() { return Long2ReferenceLinkedOpenHashMap.this.key[previousEntry()]; } 
/*  985 */     public void set(long k) { throw new UnsupportedOperationException(); } 
/*  986 */     public void add(long k) { throw new UnsupportedOperationException(); } 
/*  987 */     public Long previous() { return Long.valueOf(Long2ReferenceLinkedOpenHashMap.this.key[previousEntry()]); } 
/*  988 */     public void set(Long ok) { throw new UnsupportedOperationException(); } 
/*  989 */     public void add(Long ok) { throw new UnsupportedOperationException(); } 
/*  990 */     public KeyIterator() { super(null); } 
/*  991 */     public long nextLong() { return Long2ReferenceLinkedOpenHashMap.this.key[nextEntry()]; } 
/*  992 */     public Long next() { return Long.valueOf(Long2ReferenceLinkedOpenHashMap.this.key[nextEntry()]); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private final class MapEntrySet extends AbstractObjectSortedSet<Long2ReferenceMap.Entry<V>>
/*      */     implements Long2ReferenceSortedMap.FastSortedEntrySet<V>
/*      */   {
/*      */     private MapEntrySet()
/*      */     {
/*      */     }
/*      */ 
/*      */     public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator()
/*      */     {
/*  911 */       return new Long2ReferenceLinkedOpenHashMap.EntryIterator(Long2ReferenceLinkedOpenHashMap.this);
/*      */     }
/*  913 */     public Comparator<? super Long2ReferenceMap.Entry<V>> comparator() { return null; } 
/*  914 */     public ObjectSortedSet<Long2ReferenceMap.Entry<V>> subSet(Long2ReferenceMap.Entry<V> fromElement, Long2ReferenceMap.Entry<V> toElement) { throw new UnsupportedOperationException(); } 
/*  915 */     public ObjectSortedSet<Long2ReferenceMap.Entry<V>> headSet(Long2ReferenceMap.Entry<V> toElement) { throw new UnsupportedOperationException(); } 
/*  916 */     public ObjectSortedSet<Long2ReferenceMap.Entry<V>> tailSet(Long2ReferenceMap.Entry<V> fromElement) { throw new UnsupportedOperationException(); } 
/*      */     public Long2ReferenceMap.Entry<V> first() {
/*  918 */       if (Long2ReferenceLinkedOpenHashMap.this.size == 0) throw new NoSuchElementException();
/*  919 */       return new Long2ReferenceLinkedOpenHashMap.MapEntry(Long2ReferenceLinkedOpenHashMap.this, Long2ReferenceLinkedOpenHashMap.this.first);
/*      */     }
/*      */     public Long2ReferenceMap.Entry<V> last() {
/*  922 */       if (Long2ReferenceLinkedOpenHashMap.this.size == 0) throw new NoSuchElementException();
/*  923 */       return new Long2ReferenceLinkedOpenHashMap.MapEntry(Long2ReferenceLinkedOpenHashMap.this, Long2ReferenceLinkedOpenHashMap.this.last);
/*      */     }
/*      */ 
/*      */     public boolean contains(Object o) {
/*  927 */       if (!(o instanceof Map.Entry)) return false;
/*  928 */       Map.Entry e = (Map.Entry)o;
/*  929 */       long k = ((Long)e.getKey()).longValue();
/*      */ 
/*  931 */       int pos = (int)HashCommon.murmurHash3(k) & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */ 
/*  933 */       while (Long2ReferenceLinkedOpenHashMap.this.used[pos] != 0) {
/*  934 */         if (Long2ReferenceLinkedOpenHashMap.this.key[pos] == k) return Long2ReferenceLinkedOpenHashMap.this.value[pos] == e.getValue();
/*  935 */         pos = pos + 1 & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */       }
/*  937 */       return false;
/*      */     }
/*      */ 
/*      */     public boolean remove(Object o) {
/*  941 */       if (!(o instanceof Map.Entry)) return false;
/*  942 */       Map.Entry e = (Map.Entry)o;
/*  943 */       long k = ((Long)e.getKey()).longValue();
/*      */ 
/*  945 */       int pos = (int)HashCommon.murmurHash3(k) & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */ 
/*  947 */       while (Long2ReferenceLinkedOpenHashMap.this.used[pos] != 0) {
/*  948 */         if (Long2ReferenceLinkedOpenHashMap.this.key[pos] == k) {
/*  949 */           Long2ReferenceLinkedOpenHashMap.this.remove(e.getKey());
/*  950 */           return true;
/*      */         }
/*  952 */         pos = pos + 1 & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */       }
/*  954 */       return false;
/*      */     }
/*      */     public int size() {
/*  957 */       return Long2ReferenceLinkedOpenHashMap.this.size;
/*      */     }
/*      */     public void clear() {
/*  960 */       Long2ReferenceLinkedOpenHashMap.this.clear();
/*      */     }
/*      */     public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator(Long2ReferenceMap.Entry<V> from) {
/*  963 */       return new Long2ReferenceLinkedOpenHashMap.EntryIterator(Long2ReferenceLinkedOpenHashMap.this, ((Long)from.getKey()).longValue());
/*      */     }
/*      */     public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> fastIterator() {
/*  966 */       return new Long2ReferenceLinkedOpenHashMap.FastEntryIterator(Long2ReferenceLinkedOpenHashMap.this);
/*      */     }
/*      */     public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> fastIterator(Long2ReferenceMap.Entry<V> from) {
/*  969 */       return new Long2ReferenceLinkedOpenHashMap.FastEntryIterator(Long2ReferenceLinkedOpenHashMap.this, ((Long)from.getKey()).longValue());
/*      */     }
/*      */   }
/*      */ 
/*      */   private class FastEntryIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator
/*      */     implements ObjectListIterator<Long2ReferenceMap.Entry<V>>
/*      */   {
/*  889 */     final AbstractLong2ReferenceMap.BasicEntry<V> entry = new AbstractLong2ReferenceMap.BasicEntry(0L, null);
/*      */ 
/*  890 */     public FastEntryIterator() { super(null); } 
/*      */     public FastEntryIterator(long from) {
/*  892 */       super(from, null);
/*      */     }
/*      */     public AbstractLong2ReferenceMap.BasicEntry<V> next() {
/*  895 */       int e = nextEntry();
/*  896 */       this.entry.key = Long2ReferenceLinkedOpenHashMap.this.key[e];
/*  897 */       this.entry.value = Long2ReferenceLinkedOpenHashMap.this.value[e];
/*  898 */       return this.entry;
/*      */     }
/*      */     public AbstractLong2ReferenceMap.BasicEntry<V> previous() {
/*  901 */       int e = previousEntry();
/*  902 */       this.entry.key = Long2ReferenceLinkedOpenHashMap.this.key[e];
/*  903 */       this.entry.value = Long2ReferenceLinkedOpenHashMap.this.value[e];
/*  904 */       return this.entry;
/*      */     }
/*  906 */     public void set(Long2ReferenceMap.Entry<V> ok) { throw new UnsupportedOperationException(); } 
/*  907 */     public void add(Long2ReferenceMap.Entry<V> ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private class EntryIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator
/*      */     implements ObjectListIterator<Long2ReferenceMap.Entry<V>>
/*      */   {
/*      */     private Long2ReferenceLinkedOpenHashMap<V>.MapEntry entry;
/*      */ 
/*      */     public EntryIterator()
/*      */     {
/*  870 */       super(null);
/*      */     }
/*  872 */     public EntryIterator(long from) { super(from, null); }
/*      */ 
/*      */     public Long2ReferenceLinkedOpenHashMap<V>.MapEntry next() {
/*  875 */       return this.entry = new Long2ReferenceLinkedOpenHashMap.MapEntry(Long2ReferenceLinkedOpenHashMap.this, nextEntry());
/*      */     }
/*      */     public Long2ReferenceLinkedOpenHashMap<V>.MapEntry previous() {
/*  878 */       return this.entry = new Long2ReferenceLinkedOpenHashMap.MapEntry(Long2ReferenceLinkedOpenHashMap.this, previousEntry());
/*      */     }
/*      */ 
/*      */     public void remove() {
/*  882 */       super.remove();
/*  883 */       Long2ReferenceLinkedOpenHashMap.MapEntry.access$202(this.entry, -1);
/*      */     }
/*  885 */     public void set(Long2ReferenceMap.Entry<V> ok) { throw new UnsupportedOperationException(); } 
/*  886 */     public void add(Long2ReferenceMap.Entry<V> ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private class MapIterator
/*      */   {
/*  741 */     int prev = -1;
/*      */ 
/*  743 */     int next = -1;
/*      */ 
/*  745 */     int curr = -1;
/*      */ 
/*  747 */     int index = -1;
/*      */ 
/*  749 */     private MapIterator() { this.next = Long2ReferenceLinkedOpenHashMap.this.first;
/*  750 */       this.index = 0; }
/*      */ 
/*      */     private MapIterator(long from) {
/*  753 */       if (Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.last] == from) {
/*  754 */         this.prev = Long2ReferenceLinkedOpenHashMap.this.last;
/*  755 */         this.index = Long2ReferenceLinkedOpenHashMap.this.size;
/*      */       }
/*      */       else
/*      */       {
/*  759 */         int pos = (int)HashCommon.murmurHash3(from) & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */ 
/*  761 */         while (Long2ReferenceLinkedOpenHashMap.this.used[pos] != 0) {
/*  762 */           if (Long2ReferenceLinkedOpenHashMap.this.key[pos] == from)
/*      */           {
/*  764 */             this.next = ((int)Long2ReferenceLinkedOpenHashMap.this.link[pos]);
/*  765 */             this.prev = pos;
/*  766 */             return;
/*      */           }
/*  768 */           pos = pos + 1 & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */         }
/*  770 */         throw new NoSuchElementException("The key " + from + " does not belong to this map.");
/*      */       }
/*      */     }
/*  773 */     public boolean hasNext() { return this.next != -1; } 
/*  774 */     public boolean hasPrevious() { return this.prev != -1; } 
/*      */     private final void ensureIndexKnown() {
/*  776 */       if (this.index >= 0) return;
/*  777 */       if (this.prev == -1) {
/*  778 */         this.index = 0;
/*  779 */         return;
/*      */       }
/*  781 */       if (this.next == -1) {
/*  782 */         this.index = Long2ReferenceLinkedOpenHashMap.this.size;
/*  783 */         return;
/*      */       }
/*  785 */       int pos = Long2ReferenceLinkedOpenHashMap.this.first;
/*  786 */       this.index = 1;
/*  787 */       while (pos != this.prev) {
/*  788 */         pos = (int)Long2ReferenceLinkedOpenHashMap.this.link[pos];
/*  789 */         this.index += 1;
/*      */       }
/*      */     }
/*      */ 
/*  793 */     public int nextIndex() { ensureIndexKnown();
/*  794 */       return this.index; }
/*      */ 
/*      */     public int previousIndex() {
/*  797 */       ensureIndexKnown();
/*  798 */       return this.index - 1;
/*      */     }
/*      */     public int nextEntry() {
/*  801 */       if (!hasNext()) return Long2ReferenceLinkedOpenHashMap.this.size();
/*  802 */       this.curr = this.next;
/*  803 */       this.next = ((int)Long2ReferenceLinkedOpenHashMap.this.link[this.curr]);
/*  804 */       this.prev = this.curr;
/*  805 */       if (this.index >= 0) this.index += 1;
/*  806 */       return this.curr;
/*      */     }
/*      */     public int previousEntry() {
/*  809 */       if (!hasPrevious()) return -1;
/*  810 */       this.curr = this.prev;
/*  811 */       this.prev = ((int)(Long2ReferenceLinkedOpenHashMap.this.link[this.curr] >>> 32));
/*  812 */       this.next = this.curr;
/*  813 */       if (this.index >= 0) this.index -= 1;
/*  814 */       return this.curr;
/*      */     }
/*      */ 
/*      */     public void remove() {
/*  818 */       ensureIndexKnown();
/*  819 */       if (this.curr == -1) throw new IllegalStateException();
/*  820 */       if (this.curr == this.prev)
/*      */       {
/*  823 */         this.index -= 1;
/*  824 */         this.prev = ((int)(Long2ReferenceLinkedOpenHashMap.this.link[this.curr] >>> 32));
/*      */       }
/*      */       else {
/*  827 */         this.next = ((int)Long2ReferenceLinkedOpenHashMap.this.link[this.curr]);
/*  828 */       }Long2ReferenceLinkedOpenHashMap.this.size -= 1;
/*      */ 
/*  831 */       if (this.prev == -1) Long2ReferenceLinkedOpenHashMap.this.first = this.next;
/*      */       else
/*  833 */         Long2ReferenceLinkedOpenHashMap.this.link[this.prev] ^= (Long2ReferenceLinkedOpenHashMap.this.link[this.prev] ^ this.next & 0xFFFFFFFF) & 0xFFFFFFFF;
/*  834 */       if (this.next == -1) Long2ReferenceLinkedOpenHashMap.this.last = this.prev;
/*      */       else
/*  836 */         Long2ReferenceLinkedOpenHashMap.this.link[this.next] ^= (Long2ReferenceLinkedOpenHashMap.this.link[this.next] ^ (this.prev & 0xFFFFFFFF) << 32) & 0x0; int pos = this.curr;
/*      */       int last;
/*      */       while (true) {
/*  840 */         pos = (last = pos) + 1 & Long2ReferenceLinkedOpenHashMap.this.mask;
/*  841 */         while (Long2ReferenceLinkedOpenHashMap.this.used[pos] != 0) {
/*  842 */           int slot = (int)HashCommon.murmurHash3(Long2ReferenceLinkedOpenHashMap.this.key[pos]) & Long2ReferenceLinkedOpenHashMap.this.mask;
/*  843 */           if (last <= pos ? (last < slot) && (slot <= pos) : (last >= slot) && (slot > pos)) break;
/*  844 */           pos = pos + 1 & Long2ReferenceLinkedOpenHashMap.this.mask;
/*      */         }
/*  846 */         if (Long2ReferenceLinkedOpenHashMap.this.used[pos] == 0) break;
/*  847 */         Long2ReferenceLinkedOpenHashMap.this.key[last] = Long2ReferenceLinkedOpenHashMap.this.key[pos];
/*  848 */         Long2ReferenceLinkedOpenHashMap.this.value[last] = Long2ReferenceLinkedOpenHashMap.this.value[pos];
/*  849 */         if (this.next == pos) this.next = last;
/*  850 */         if (this.prev == pos) this.prev = last;
/*  851 */         Long2ReferenceLinkedOpenHashMap.this.fixPointers(pos, last);
/*      */       }
/*  853 */       Long2ReferenceLinkedOpenHashMap.this.used[last] = false;
/*  854 */       Long2ReferenceLinkedOpenHashMap.this.value[last] = null;
/*  855 */       this.curr = -1;
/*      */     }
/*      */     public int skip(int n) {
/*  858 */       int i = n;
/*  859 */       while ((i-- != 0) && (hasNext())) nextEntry();
/*  860 */       return n - i - 1;
/*      */     }
/*      */     public int back(int n) {
/*  863 */       int i = n;
/*  864 */       while ((i-- != 0) && (hasPrevious())) previousEntry();
/*  865 */       return n - i - 1;
/*      */     }
/*      */   }
/*      */ 
/*      */   private final class MapEntry
/*      */     implements Long2ReferenceMap.Entry<V>, Map.Entry<Long, V>
/*      */   {
/*      */     private int index;
/*      */ 
/*      */     MapEntry(int index)
/*      */     {
/*  616 */       this.index = index;
/*      */     }
/*      */     public Long getKey() {
/*  619 */       return Long.valueOf(Long2ReferenceLinkedOpenHashMap.this.key[this.index]);
/*      */     }
/*      */     public long getLongKey() {
/*  622 */       return Long2ReferenceLinkedOpenHashMap.this.key[this.index];
/*      */     }
/*      */     public V getValue() {
/*  625 */       return Long2ReferenceLinkedOpenHashMap.this.value[this.index];
/*      */     }
/*      */     public V setValue(V v) {
/*  628 */       Object oldValue = Long2ReferenceLinkedOpenHashMap.this.value[this.index];
/*  629 */       Long2ReferenceLinkedOpenHashMap.this.value[this.index] = v;
/*  630 */       return oldValue;
/*      */     }
/*      */ 
/*      */     public boolean equals(Object o) {
/*  634 */       if (!(o instanceof Map.Entry)) return false;
/*  635 */       Map.Entry e = (Map.Entry)o;
/*  636 */       return (Long2ReferenceLinkedOpenHashMap.this.key[this.index] == ((Long)e.getKey()).longValue()) && (Long2ReferenceLinkedOpenHashMap.this.value[this.index] == e.getValue());
/*      */     }
/*      */     public int hashCode() {
/*  639 */       return HashCommon.long2int(Long2ReferenceLinkedOpenHashMap.this.key[this.index]) ^ (Long2ReferenceLinkedOpenHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Long2ReferenceLinkedOpenHashMap.this.value[this.index]));
/*      */     }
/*      */     public String toString() {
/*  642 */       return Long2ReferenceLinkedOpenHashMap.this.key[this.index] + "=>" + Long2ReferenceLinkedOpenHashMap.this.value[this.index];
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap
 * JD-Core Version:    0.6.2
 */