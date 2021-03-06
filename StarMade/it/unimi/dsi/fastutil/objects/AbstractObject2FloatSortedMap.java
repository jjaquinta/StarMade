/*     */ package it.unimi.dsi.fastutil.objects;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
/*     */ import it.unimi.dsi.fastutil.floats.AbstractFloatIterator;
/*     */ import it.unimi.dsi.fastutil.floats.FloatCollection;
/*     */ import it.unimi.dsi.fastutil.floats.FloatIterator;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public abstract class AbstractObject2FloatSortedMap<K> extends AbstractObject2FloatMap<K>
/*     */   implements Object2FloatSortedMap<K>
/*     */ {
/*     */   public static final long serialVersionUID = -1773560792952436569L;
/*     */ 
/*     */   public ObjectSortedSet<K> keySet()
/*     */   {
/*  69 */     return new KeySet();
/*     */   }
/*     */ 
/*     */   public FloatCollection values()
/*     */   {
/* 112 */     return new ValuesCollection();
/*     */   }
/*     */ 
/*     */   public ObjectSortedSet<Map.Entry<K, Float>> entrySet()
/*     */   {
/* 136 */     return object2FloatEntrySet();
/*     */   }
/*     */ 
/*     */   protected static class ValuesIterator<K> extends AbstractFloatIterator
/*     */   {
/*     */     protected final ObjectBidirectionalIterator<Map.Entry<K, Float>> i;
/*     */ 
/*     */     public ValuesIterator(ObjectBidirectionalIterator<Map.Entry<K, Float>> i)
/*     */     {
/* 129 */       this.i = i;
/*     */     }
/* 131 */     public float nextFloat() { return ((Float)((Map.Entry)this.i.next()).getValue()).floatValue(); } 
/* 132 */     public boolean hasNext() { return this.i.hasNext(); }
/*     */ 
/*     */   }
/*     */ 
/*     */   protected class ValuesCollection extends AbstractFloatCollection
/*     */   {
/*     */     protected ValuesCollection()
/*     */     {
/*     */     }
/*     */ 
/*     */     public FloatIterator iterator()
/*     */     {
/* 116 */       return new AbstractObject2FloatSortedMap.ValuesIterator(AbstractObject2FloatSortedMap.this.entrySet().iterator()); } 
/* 117 */     public boolean contains(float k) { return AbstractObject2FloatSortedMap.this.containsValue(k); } 
/* 118 */     public int size() { return AbstractObject2FloatSortedMap.this.size(); } 
/* 119 */     public void clear() { AbstractObject2FloatSortedMap.this.clear(); }
/*     */ 
/*     */   }
/*     */ 
/*     */   protected static class KeySetIterator<K> extends AbstractObjectBidirectionalIterator<K>
/*     */   {
/*     */     protected final ObjectBidirectionalIterator<Map.Entry<K, Float>> i;
/*     */ 
/*     */     public KeySetIterator(ObjectBidirectionalIterator<Map.Entry<K, Float>> i)
/*     */     {
/*  93 */       this.i = i;
/*     */     }
/*  95 */     public K next() { return ((Map.Entry)this.i.next()).getKey(); } 
/*  96 */     public K previous() { return ((Map.Entry)this.i.previous()).getKey(); } 
/*  97 */     public boolean hasNext() { return this.i.hasNext(); } 
/*  98 */     public boolean hasPrevious() { return this.i.hasPrevious(); }
/*     */ 
/*     */   }
/*     */ 
/*     */   protected class KeySet extends AbstractObjectSortedSet<K>
/*     */   {
/*     */     protected KeySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean contains(Object k)
/*     */     {
/*  73 */       return AbstractObject2FloatSortedMap.this.containsKey(k); } 
/*  74 */     public int size() { return AbstractObject2FloatSortedMap.this.size(); } 
/*  75 */     public void clear() { AbstractObject2FloatSortedMap.this.clear(); } 
/*  76 */     public Comparator<? super K> comparator() { return AbstractObject2FloatSortedMap.this.comparator(); } 
/*  77 */     public K first() { return AbstractObject2FloatSortedMap.this.firstKey(); } 
/*  78 */     public K last() { return AbstractObject2FloatSortedMap.this.lastKey(); } 
/*  79 */     public ObjectSortedSet<K> headSet(K to) { return AbstractObject2FloatSortedMap.this.headMap(to).keySet(); } 
/*  80 */     public ObjectSortedSet<K> tailSet(K from) { return AbstractObject2FloatSortedMap.this.tailMap(from).keySet(); } 
/*  81 */     public ObjectSortedSet<K> subSet(K from, K to) { return AbstractObject2FloatSortedMap.this.subMap(from, to).keySet(); } 
/*  82 */     public ObjectBidirectionalIterator<K> iterator(K from) { return new AbstractObject2FloatSortedMap.KeySetIterator(AbstractObject2FloatSortedMap.this.entrySet().iterator(new AbstractObject2FloatMap.BasicEntry(from, 0.0F))); } 
/*  83 */     public ObjectBidirectionalIterator<K> iterator() { return new AbstractObject2FloatSortedMap.KeySetIterator(AbstractObject2FloatSortedMap.this.entrySet().iterator()); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap
 * JD-Core Version:    0.6.2
 */