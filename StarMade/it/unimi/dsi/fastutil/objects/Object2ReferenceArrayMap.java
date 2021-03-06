/*     */ package it.unimi.dsi.fastutil.objects;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class Object2ReferenceArrayMap<K, V> extends AbstractObject2ReferenceMap<K, V>
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient Object[] key;
/*     */   private transient Object[] value;
/*     */   private int size;
/*     */ 
/*     */   public Object2ReferenceArrayMap(Object[] key, Object[] value)
/*     */   {
/*  75 */     this.key = key;
/*  76 */     this.value = value;
/*  77 */     this.size = key.length;
/*  78 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap()
/*     */   {
/*  83 */     this.key = ObjectArrays.EMPTY_ARRAY;
/*  84 */     this.value = ObjectArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap(int capacity)
/*     */   {
/*  91 */     this.key = new Object[capacity];
/*  92 */     this.value = new Object[capacity];
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap(Object2ReferenceMap<K, V> m)
/*     */   {
/*  99 */     this(m.size());
/* 100 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap(Map<? extends K, ? extends V> m)
/*     */   {
/* 107 */     this(m.size());
/* 108 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap(Object[] key, Object[] value, int size)
/*     */   {
/* 119 */     this.key = key;
/* 120 */     this.value = value;
/* 121 */     this.size = size;
/* 122 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 123 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Object2ReferenceMap.FastEntrySet<K, V> object2ReferenceEntrySet()
/*     */   {
/* 169 */     return new EntrySet(null);
/*     */   }
/*     */ 
/*     */   private int findKey(Object k) {
/* 173 */     Object[] key = this.key;
/* 174 */     for (int i = this.size; i-- != 0; return i) label10: if (key[i] == null ? k != null : !key[i].equals(k))
/*     */         break label10; return -1;
/*     */   }
/*     */ 
/*     */   public V get(Object k)
/*     */   {
/* 184 */     Object[] key = this.key;
/* 185 */     for (int i = this.size; i-- != 0; return this.value[i]) label10: if (key[i] == null ? k != null : !key[i].equals(k))
/*     */         break label10; return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public int size() {
/* 190 */     return this.size;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 196 */     for (int i = this.size; i-- != 0; )
/*     */     {
/* 198 */       this.key[i] = null;
/*     */ 
/* 201 */       this.value[i] = null;
/*     */     }
/*     */ 
/* 205 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   public boolean containsKey(Object k)
/*     */   {
/* 210 */     return findKey(k) != -1;
/*     */   }
/*     */ 
/*     */   public boolean containsValue(Object v)
/*     */   {
/* 216 */     for (int i = this.size; i-- != 0; ) if (this.value[i] == v) return true;
/* 217 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 222 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   public V put(K k, V v)
/*     */   {
/* 228 */     int oldKey = findKey(k);
/* 229 */     if (oldKey != -1) {
/* 230 */       Object oldValue = this.value[oldKey];
/* 231 */       this.value[oldKey] = v;
/* 232 */       return oldValue;
/*     */     }
/* 234 */     if (this.size == this.key.length) {
/* 235 */       Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
/* 236 */       Object[] newValue = new Object[this.size == 0 ? 2 : this.size * 2];
/* 237 */       for (int i = this.size; i-- != 0; ) {
/* 238 */         newKey[i] = this.key[i];
/* 239 */         newValue[i] = this.value[i];
/*     */       }
/* 241 */       this.key = newKey;
/* 242 */       this.value = newValue;
/*     */     }
/* 244 */     this.key[this.size] = k;
/* 245 */     this.value[this.size] = v;
/* 246 */     this.size += 1;
/* 247 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public V remove(Object k)
/*     */   {
/* 258 */     int oldPos = findKey(k);
/* 259 */     if (oldPos == -1) return this.defRetValue;
/* 260 */     Object oldValue = this.value[oldPos];
/* 261 */     int tail = this.size - oldPos - 1;
/* 262 */     for (int i = 0; i < tail; i++) {
/* 263 */       this.key[(oldPos + i)] = this.key[(oldPos + i + 1)];
/* 264 */       this.value[(oldPos + i)] = this.value[(oldPos + i + 1)];
/*     */     }
/* 266 */     this.size -= 1;
/*     */ 
/* 268 */     this.key[this.size] = null;
/*     */ 
/* 271 */     this.value[this.size] = null;
/*     */ 
/* 273 */     return oldValue;
/*     */   }
/*     */ 
/*     */   public ObjectSet<K> keySet()
/*     */   {
/* 280 */     return new ObjectArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public ReferenceCollection<V> values()
/*     */   {
/* 285 */     return ReferenceCollections.unmodifiable(new ReferenceArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Object2ReferenceArrayMap<K, V> clone()
/*     */   {
/*     */     Object2ReferenceArrayMap c;
/*     */     try
/*     */     {
/* 300 */       c = (Object2ReferenceArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 303 */       throw new InternalError();
/*     */     }
/* 305 */     c.key = ((Object[])this.key.clone());
/* 306 */     c.value = ((Object[])this.value.clone());
/* 307 */     return c;
/*     */   }
/*     */ 
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 311 */     s.defaultWriteObject();
/* 312 */     for (int i = 0; i < this.size; i++) {
/* 313 */       s.writeObject(this.key[i]);
/* 314 */       s.writeObject(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
/*     */   {
/* 320 */     s.defaultReadObject();
/* 321 */     this.key = new Object[this.size];
/* 322 */     this.value = new Object[this.size];
/* 323 */     for (int i = 0; i < this.size; i++) {
/* 324 */       this.key[i] = s.readObject();
/* 325 */       this.value[i] = s.readObject();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Object2ReferenceMap.Entry<K, V>>
/*     */     implements Object2ReferenceMap.FastEntrySet<K, V>
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Object2ReferenceMap.Entry<K, V>> iterator()
/*     */     {
/* 128 */       return new AbstractObjectIterator() {
/* 129 */         int next = 0;
/*     */ 
/* 131 */         public boolean hasNext() { return this.next < Object2ReferenceArrayMap.this.size; }
/*     */ 
/*     */         public Object2ReferenceMap.Entry<K, V> next()
/*     */         {
/* 135 */           if (!hasNext()) throw new NoSuchElementException();
/* 136 */           return new AbstractObject2ReferenceMap.BasicEntry(Object2ReferenceArrayMap.this.key[this.next], Object2ReferenceArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Object2ReferenceMap.Entry<K, V>> fastIterator() {
/* 141 */       return new AbstractObjectIterator() {
/* 142 */         int next = 0;
/* 143 */         final AbstractObject2ReferenceMap.BasicEntry<K, V> entry = new AbstractObject2ReferenceMap.BasicEntry(null, null);
/*     */ 
/* 145 */         public boolean hasNext() { return this.next < Object2ReferenceArrayMap.this.size; }
/*     */ 
/*     */         public Object2ReferenceMap.Entry<K, V> next()
/*     */         {
/* 149 */           if (!hasNext()) throw new NoSuchElementException();
/* 150 */           this.entry.key = Object2ReferenceArrayMap.this.key[this.next];
/* 151 */           this.entry.value = Object2ReferenceArrayMap.this.value[(this.next++)];
/* 152 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 157 */       return Object2ReferenceArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 161 */       if (!(o instanceof Map.Entry)) return false;
/* 162 */       Map.Entry e = (Map.Entry)o;
/* 163 */       Object k = e.getKey();
/* 164 */       return (Object2ReferenceArrayMap.this.containsKey(k)) && (Object2ReferenceArrayMap.this.get(k) == e.getValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.Object2ReferenceArrayMap
 * JD-Core Version:    0.6.2
 */