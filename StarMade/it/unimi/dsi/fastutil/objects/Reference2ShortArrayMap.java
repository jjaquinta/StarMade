/*     */ package it.unimi.dsi.fastutil.objects;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.shorts.ShortArraySet;
/*     */ import it.unimi.dsi.fastutil.shorts.ShortArrays;
/*     */ import it.unimi.dsi.fastutil.shorts.ShortCollection;
/*     */ import it.unimi.dsi.fastutil.shorts.ShortCollections;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class Reference2ShortArrayMap<K> extends AbstractReference2ShortMap<K>
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient Object[] key;
/*     */   private transient short[] value;
/*     */   private int size;
/*     */ 
/*     */   public Reference2ShortArrayMap(Object[] key, short[] value)
/*     */   {
/*  76 */     this.key = key;
/*  77 */     this.value = value;
/*  78 */     this.size = key.length;
/*  79 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap()
/*     */   {
/*  84 */     this.key = ObjectArrays.EMPTY_ARRAY;
/*  85 */     this.value = ShortArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap(int capacity)
/*     */   {
/*  92 */     this.key = new Object[capacity];
/*  93 */     this.value = new short[capacity];
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap(Reference2ShortMap<K> m)
/*     */   {
/* 100 */     this(m.size());
/* 101 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap(Map<? extends K, ? extends Short> m)
/*     */   {
/* 108 */     this(m.size());
/* 109 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap(Object[] key, short[] value, int size)
/*     */   {
/* 120 */     this.key = key;
/* 121 */     this.value = value;
/* 122 */     this.size = size;
/* 123 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 124 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Reference2ShortMap.FastEntrySet<K> reference2ShortEntrySet()
/*     */   {
/* 169 */     return new EntrySet(null);
/*     */   }
/*     */ 
/*     */   private int findKey(Object k) {
/* 173 */     Object[] key = this.key;
/* 174 */     for (int i = this.size; i-- != 0; ) if (key[i] == k) return i;
/* 175 */     return -1;
/*     */   }
/*     */ 
/*     */   public short getShort(Object k)
/*     */   {
/* 184 */     Object[] key = this.key;
/* 185 */     for (int i = this.size; i-- != 0; ) if (key[i] == k) return this.value[i];
/* 186 */     return this.defRetValue;
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
/*     */   public boolean containsValue(short v)
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
/*     */   public short put(K k, short v)
/*     */   {
/* 228 */     int oldKey = findKey(k);
/* 229 */     if (oldKey != -1) {
/* 230 */       short oldValue = this.value[oldKey];
/* 231 */       this.value[oldKey] = v;
/* 232 */       return oldValue;
/*     */     }
/* 234 */     if (this.size == this.key.length) {
/* 235 */       Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
/* 236 */       short[] newValue = new short[this.size == 0 ? 2 : this.size * 2];
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
/*     */   public short removeShort(Object k)
/*     */   {
/* 258 */     int oldPos = findKey(k);
/* 259 */     if (oldPos == -1) return this.defRetValue;
/* 260 */     short oldValue = this.value[oldPos];
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
/*     */   public ReferenceSet<K> keySet()
/*     */   {
/* 280 */     return new ReferenceArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public ShortCollection values()
/*     */   {
/* 285 */     return ShortCollections.unmodifiable(new ShortArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Reference2ShortArrayMap<K> clone()
/*     */   {
/*     */     Reference2ShortArrayMap c;
/*     */     try
/*     */     {
/* 300 */       c = (Reference2ShortArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 303 */       throw new InternalError();
/*     */     }
/* 305 */     c.key = ((Object[])this.key.clone());
/* 306 */     c.value = ((short[])this.value.clone());
/* 307 */     return c;
/*     */   }
/*     */ 
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 311 */     s.defaultWriteObject();
/* 312 */     for (int i = 0; i < this.size; i++) {
/* 313 */       s.writeObject(this.key[i]);
/* 314 */       s.writeShort(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
/*     */   {
/* 320 */     s.defaultReadObject();
/* 321 */     this.key = new Object[this.size];
/* 322 */     this.value = new short[this.size];
/* 323 */     for (int i = 0; i < this.size; i++) {
/* 324 */       this.key[i] = s.readObject();
/* 325 */       this.value[i] = s.readShort();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Reference2ShortMap.Entry<K>>
/*     */     implements Reference2ShortMap.FastEntrySet<K>
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Reference2ShortMap.Entry<K>> iterator()
/*     */     {
/* 129 */       return new AbstractObjectIterator() {
/* 130 */         int next = 0;
/*     */ 
/* 132 */         public boolean hasNext() { return this.next < Reference2ShortArrayMap.this.size; }
/*     */ 
/*     */         public Reference2ShortMap.Entry<K> next()
/*     */         {
/* 136 */           if (!hasNext()) throw new NoSuchElementException();
/* 137 */           return new AbstractReference2ShortMap.BasicEntry(Reference2ShortArrayMap.this.key[this.next], Reference2ShortArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Reference2ShortMap.Entry<K>> fastIterator() {
/* 142 */       return new AbstractObjectIterator() {
/* 143 */         int next = 0;
/* 144 */         final AbstractReference2ShortMap.BasicEntry<K> entry = new AbstractReference2ShortMap.BasicEntry(null, (short)0);
/*     */ 
/* 146 */         public boolean hasNext() { return this.next < Reference2ShortArrayMap.this.size; }
/*     */ 
/*     */         public Reference2ShortMap.Entry<K> next()
/*     */         {
/* 150 */           if (!hasNext()) throw new NoSuchElementException();
/* 151 */           this.entry.key = Reference2ShortArrayMap.this.key[this.next];
/* 152 */           this.entry.value = Reference2ShortArrayMap.this.value[(this.next++)];
/* 153 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 158 */       return Reference2ShortArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 162 */       if (!(o instanceof Map.Entry)) return false;
/* 163 */       Map.Entry e = (Map.Entry)o;
/* 164 */       Object k = e.getKey();
/* 165 */       return (Reference2ShortArrayMap.this.containsKey(k)) && (Reference2ShortArrayMap.this.get(k).shortValue() == ((Short)e.getValue()).shortValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.Reference2ShortArrayMap
 * JD-Core Version:    0.6.2
 */