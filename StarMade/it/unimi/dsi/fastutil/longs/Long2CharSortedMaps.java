/*     */ package it.unimi.dsi.fastutil.longs;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectSortedSets;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class Long2CharSortedMaps
/*     */ {
/* 103 */   public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();
/*     */ 
/*     */   public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator)
/*     */   {
/*  64 */     return new Comparator() {
/*     */       public int compare(Map.Entry<Long, ?> x, Map.Entry<Long, ?> y) {
/*  66 */         return this.val$comparator.compare(x.getKey(), y.getKey());
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap singleton(Long key, Character value)
/*     */   {
/* 173 */     return new Singleton(key.longValue(), value.charValue());
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap singleton(Long key, Character value, LongComparator comparator)
/*     */   {
/* 187 */     return new Singleton(key.longValue(), value.charValue(), comparator);
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap singleton(long key, char value)
/*     */   {
/* 202 */     return new Singleton(key, value);
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap singleton(long key, char value, LongComparator comparator)
/*     */   {
/* 216 */     return new Singleton(key, value, comparator);
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap synchronize(Long2CharSortedMap m)
/*     */   {
/* 272 */     return new SynchronizedSortedMap(m);
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap synchronize(Long2CharSortedMap m, Object sync)
/*     */   {
/* 282 */     return new SynchronizedSortedMap(m, sync);
/*     */   }
/*     */ 
/*     */   public static Long2CharSortedMap unmodifiable(Long2CharSortedMap m)
/*     */   {
/* 332 */     return new UnmodifiableSortedMap(m);
/*     */   }
/*     */ 
/*     */   public static class UnmodifiableSortedMap extends Long2CharMaps.UnmodifiableMap
/*     */     implements Long2CharSortedMap, Serializable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     protected final Long2CharSortedMap sortedMap;
/*     */ 
/*     */     protected UnmodifiableSortedMap(Long2CharSortedMap m)
/*     */     {
/* 296 */       super();
/* 297 */       this.sortedMap = m;
/*     */     }
/*     */     public LongComparator comparator() {
/* 300 */       return this.sortedMap.comparator();
/*     */     }
/* 302 */     public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() { if (this.entries == null) this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2CharEntrySet()); return (ObjectSortedSet)this.entries; } 
/*     */     public ObjectSortedSet<Map.Entry<Long, Character>> entrySet() {
/* 304 */       return long2CharEntrySet(); } 
/* 305 */     public LongSortedSet keySet() { if (this.keys == null) this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet()); return (LongSortedSet)this.keys; } 
/*     */     public Long2CharSortedMap subMap(long from, long to) {
/* 307 */       return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to)); } 
/* 308 */     public Long2CharSortedMap headMap(long to) { return new UnmodifiableSortedMap(this.sortedMap.headMap(to)); } 
/* 309 */     public Long2CharSortedMap tailMap(long from) { return new UnmodifiableSortedMap(this.sortedMap.tailMap(from)); } 
/*     */     public long firstLongKey() {
/* 311 */       return this.sortedMap.firstLongKey(); } 
/* 312 */     public long lastLongKey() { return this.sortedMap.lastLongKey(); }
/*     */ 
/*     */     public Long firstKey() {
/* 315 */       return (Long)this.sortedMap.firstKey(); } 
/* 316 */     public Long lastKey() { return (Long)this.sortedMap.lastKey(); } 
/*     */     public Long2CharSortedMap subMap(Long from, Long to) {
/* 318 */       return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to)); } 
/* 319 */     public Long2CharSortedMap headMap(Long to) { return new UnmodifiableSortedMap(this.sortedMap.headMap(to)); } 
/* 320 */     public Long2CharSortedMap tailMap(Long from) { return new UnmodifiableSortedMap(this.sortedMap.tailMap(from)); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class SynchronizedSortedMap extends Long2CharMaps.SynchronizedMap
/*     */     implements Long2CharSortedMap, Serializable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     protected final Long2CharSortedMap sortedMap;
/*     */ 
/*     */     protected SynchronizedSortedMap(Long2CharSortedMap m, Object sync)
/*     */     {
/* 231 */       super(sync);
/* 232 */       this.sortedMap = m;
/*     */     }
/*     */ 
/*     */     protected SynchronizedSortedMap(Long2CharSortedMap m) {
/* 236 */       super();
/* 237 */       this.sortedMap = m;
/*     */     }
/*     */     public LongComparator comparator() {
/* 240 */       synchronized (this.sync) { return this.sortedMap.comparator(); } 
/*     */     }
/* 242 */     public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() { if (this.entries == null) this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2CharEntrySet(), this.sync); return (ObjectSortedSet)this.entries; } 
/*     */     public ObjectSortedSet<Map.Entry<Long, Character>> entrySet() {
/* 244 */       return long2CharEntrySet(); } 
/* 245 */     public LongSortedSet keySet() { if (this.keys == null) this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync); return (LongSortedSet)this.keys; } 
/*     */     public Long2CharSortedMap subMap(long from, long to) {
/* 247 */       return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync); } 
/* 248 */     public Long2CharSortedMap headMap(long to) { return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync); } 
/* 249 */     public Long2CharSortedMap tailMap(long from) { return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync); } 
/*     */     public long firstLongKey() {
/* 251 */       synchronized (this.sync) { return this.sortedMap.firstLongKey(); }  } 
/* 252 */     public long lastLongKey() { synchronized (this.sync) { return this.sortedMap.lastLongKey(); } }
/*     */ 
/*     */     public Long firstKey() {
/* 255 */       synchronized (this.sync) { return (Long)this.sortedMap.firstKey(); }  } 
/* 256 */     public Long lastKey() { synchronized (this.sync) { return (Long)this.sortedMap.lastKey(); }  } 
/*     */     public Long2CharSortedMap subMap(Long from, Long to) {
/* 258 */       return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync); } 
/* 259 */     public Long2CharSortedMap headMap(Long to) { return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync); } 
/* 260 */     public Long2CharSortedMap tailMap(Long from) { return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class Singleton extends Long2CharMaps.Singleton
/*     */     implements Long2CharSortedMap, Serializable, Cloneable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     protected final LongComparator comparator;
/*     */ 
/*     */     protected Singleton(long key, char value, LongComparator comparator)
/*     */     {
/* 119 */       super(value);
/* 120 */       this.comparator = comparator;
/*     */     }
/*     */ 
/*     */     protected Singleton(long key, char value) {
/* 124 */       this(key, value, null);
/*     */     }
/*     */ 
/*     */     final int compare(long k1, long k2)
/*     */     {
/* 129 */       return this.comparator == null ? 1 : k1 == k2 ? 0 : k1 < k2 ? -1 : this.comparator.compare(k1, k2);
/*     */     }
/*     */     public LongComparator comparator() {
/* 132 */       return this.comparator;
/*     */     }
/*     */     public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() {
/* 135 */       if (this.entries == null) this.entries = ObjectSortedSets.singleton(new Long2CharMaps.Singleton.SingletonEntry(this), Long2CharSortedMaps.entryComparator(this.comparator)); return (ObjectSortedSet)this.entries;
/*     */     }
/* 137 */     public ObjectSortedSet<Map.Entry<Long, Character>> entrySet() { return long2CharEntrySet(); } 
/*     */     public LongSortedSet keySet() {
/* 139 */       if (this.keys == null) this.keys = LongSortedSets.singleton(this.key, this.comparator); return (LongSortedSet)this.keys;
/*     */     }
/*     */     public Long2CharSortedMap subMap(long from, long to) {
/* 142 */       if ((compare(from, this.key) <= 0) && (compare(this.key, to) < 0)) return this; return Long2CharSortedMaps.EMPTY_MAP;
/*     */     }
/*     */     public Long2CharSortedMap headMap(long to) {
/* 145 */       if (compare(this.key, to) < 0) return this; return Long2CharSortedMaps.EMPTY_MAP;
/*     */     }
/*     */     public Long2CharSortedMap tailMap(long from) {
/* 148 */       if (compare(from, this.key) <= 0) return this; return Long2CharSortedMaps.EMPTY_MAP;
/*     */     }
/* 150 */     public long firstLongKey() { return this.key; } 
/* 151 */     public long lastLongKey() { return this.key; }
/*     */ 
/*     */     public Long2CharSortedMap headMap(Long oto) {
/* 154 */       return headMap(oto.longValue()); } 
/* 155 */     public Long2CharSortedMap tailMap(Long ofrom) { return tailMap(ofrom.longValue()); } 
/* 156 */     public Long2CharSortedMap subMap(Long ofrom, Long oto) { return subMap(ofrom.longValue(), oto.longValue()); } 
/*     */     public Long firstKey() {
/* 158 */       return Long.valueOf(firstLongKey()); } 
/* 159 */     public Long lastKey() { return Long.valueOf(lastLongKey()); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class EmptySortedMap extends Long2CharMaps.EmptyMap
/*     */     implements Long2CharSortedMap, Serializable, Cloneable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */ 
/*     */     public LongComparator comparator()
/*     */     {
/*  78 */       return null;
/*     */     }
/*  80 */     public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() { return ObjectSortedSets.EMPTY_SET; } 
/*     */     public ObjectSortedSet<Map.Entry<Long, Character>> entrySet() {
/*  82 */       return ObjectSortedSets.EMPTY_SET;
/*     */     }
/*  84 */     public LongSortedSet keySet() { return LongSortedSets.EMPTY_SET; } 
/*     */     public Long2CharSortedMap subMap(long from, long to) {
/*  86 */       return Long2CharSortedMaps.EMPTY_MAP;
/*     */     }
/*  88 */     public Long2CharSortedMap headMap(long to) { return Long2CharSortedMaps.EMPTY_MAP; } 
/*     */     public Long2CharSortedMap tailMap(long from) {
/*  90 */       return Long2CharSortedMaps.EMPTY_MAP; } 
/*  91 */     public long firstLongKey() { throw new NoSuchElementException(); } 
/*  92 */     public long lastLongKey() { throw new NoSuchElementException(); } 
/*  93 */     public Long2CharSortedMap headMap(Long oto) { return headMap(oto.longValue()); } 
/*  94 */     public Long2CharSortedMap tailMap(Long ofrom) { return tailMap(ofrom.longValue()); } 
/*  95 */     public Long2CharSortedMap subMap(Long ofrom, Long oto) { return subMap(ofrom.longValue(), oto.longValue()); } 
/*  96 */     public Long firstKey() { return Long.valueOf(firstLongKey()); } 
/*  97 */     public Long lastKey() { return Long.valueOf(lastLongKey()); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.longs.Long2CharSortedMaps
 * JD-Core Version:    0.6.2
 */