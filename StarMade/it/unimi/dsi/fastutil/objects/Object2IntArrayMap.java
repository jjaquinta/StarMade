/*     */ package it.unimi.dsi.fastutil.objects;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.ints.IntArraySet;
/*     */ import it.unimi.dsi.fastutil.ints.IntArrays;
/*     */ import it.unimi.dsi.fastutil.ints.IntCollection;
/*     */ import it.unimi.dsi.fastutil.ints.IntCollections;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class Object2IntArrayMap<K> extends AbstractObject2IntMap<K>
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient Object[] key;
/*     */   private transient int[] value;
/*     */   private int size;
/*     */ 
/*     */   public Object2IntArrayMap(Object[] key, int[] value)
/*     */   {
/*  76 */     this.key = key;
/*  77 */     this.value = value;
/*  78 */     this.size = key.length;
/*  79 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap()
/*     */   {
/*  84 */     this.key = ObjectArrays.EMPTY_ARRAY;
/*  85 */     this.value = IntArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap(int capacity)
/*     */   {
/*  92 */     this.key = new Object[capacity];
/*  93 */     this.value = new int[capacity];
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap(Object2IntMap<K> m)
/*     */   {
/* 100 */     this(m.size());
/* 101 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap(Map<? extends K, ? extends Integer> m)
/*     */   {
/* 108 */     this(m.size());
/* 109 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap(Object[] key, int[] value, int size)
/*     */   {
/* 120 */     this.key = key;
/* 121 */     this.value = value;
/* 122 */     this.size = size;
/* 123 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 124 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Object2IntMap.FastEntrySet<K> object2IntEntrySet()
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
/*     */   public int getInt(Object k)
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
/*     */   public boolean containsValue(int v)
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
/*     */   public int put(K k, int v)
/*     */   {
/* 228 */     int oldKey = findKey(k);
/* 229 */     if (oldKey != -1) {
/* 230 */       int oldValue = this.value[oldKey];
/* 231 */       this.value[oldKey] = v;
/* 232 */       return oldValue;
/*     */     }
/* 234 */     if (this.size == this.key.length) {
/* 235 */       Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
/* 236 */       int[] newValue = new int[this.size == 0 ? 2 : this.size * 2];
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
/*     */   public int removeInt(Object k)
/*     */   {
/* 258 */     int oldPos = findKey(k);
/* 259 */     if (oldPos == -1) return this.defRetValue;
/* 260 */     int oldValue = this.value[oldPos];
/* 261 */     int tail = this.size - oldPos - 1;
/* 262 */     for (int i = 0; i < tail; i++) {
/* 263 */       this.key[(oldPos + i)] = this.key[(oldPos + i + 1)];
/* 264 */       this.value[(oldPos + i)] = this.value[(oldPos + i + 1)];
/*     */     }
/* 266 */     this.size -= 1;
/*     */ 
/* 268 */     this.key[this.size] = null;
/*     */ 
/* 273 */     return oldValue;
/*     */   }
/*     */ 
/*     */   public ObjectSet<K> keySet()
/*     */   {
/* 280 */     return new ObjectArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public IntCollection values()
/*     */   {
/* 285 */     return IntCollections.unmodifiable(new IntArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Object2IntArrayMap<K> clone()
/*     */   {
/*     */     Object2IntArrayMap c;
/*     */     try
/*     */     {
/* 300 */       c = (Object2IntArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 303 */       throw new InternalError();
/*     */     }
/* 305 */     c.key = ((Object[])this.key.clone());
/* 306 */     c.value = ((int[])this.value.clone());
/* 307 */     return c;
/*     */   }
/*     */ 
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 311 */     s.defaultWriteObject();
/* 312 */     for (int i = 0; i < this.size; i++) {
/* 313 */       s.writeObject(this.key[i]);
/* 314 */       s.writeInt(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
/*     */   {
/* 320 */     s.defaultReadObject();
/* 321 */     this.key = new Object[this.size];
/* 322 */     this.value = new int[this.size];
/* 323 */     for (int i = 0; i < this.size; i++) {
/* 324 */       this.key[i] = s.readObject();
/* 325 */       this.value[i] = s.readInt();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Object2IntMap.Entry<K>>
/*     */     implements Object2IntMap.FastEntrySet<K>
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Object2IntMap.Entry<K>> iterator()
/*     */     {
/* 129 */       return new AbstractObjectIterator() {
/* 130 */         int next = 0;
/*     */ 
/* 132 */         public boolean hasNext() { return this.next < Object2IntArrayMap.this.size; }
/*     */ 
/*     */         public Object2IntMap.Entry<K> next()
/*     */         {
/* 136 */           if (!hasNext()) throw new NoSuchElementException();
/* 137 */           return new AbstractObject2IntMap.BasicEntry(Object2IntArrayMap.this.key[this.next], Object2IntArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Object2IntMap.Entry<K>> fastIterator() {
/* 142 */       return new AbstractObjectIterator() {
/* 143 */         int next = 0;
/* 144 */         final AbstractObject2IntMap.BasicEntry<K> entry = new AbstractObject2IntMap.BasicEntry(null, 0);
/*     */ 
/* 146 */         public boolean hasNext() { return this.next < Object2IntArrayMap.this.size; }
/*     */ 
/*     */         public Object2IntMap.Entry<K> next()
/*     */         {
/* 150 */           if (!hasNext()) throw new NoSuchElementException();
/* 151 */           this.entry.key = Object2IntArrayMap.this.key[this.next];
/* 152 */           this.entry.value = Object2IntArrayMap.this.value[(this.next++)];
/* 153 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 158 */       return Object2IntArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 162 */       if (!(o instanceof Map.Entry)) return false;
/* 163 */       Map.Entry e = (Map.Entry)o;
/* 164 */       Object k = e.getKey();
/* 165 */       return (Object2IntArrayMap.this.containsKey(k)) && (Object2IntArrayMap.this.get(k).intValue() == ((Integer)e.getValue()).intValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.Object2IntArrayMap
 * JD-Core Version:    0.6.2
 */