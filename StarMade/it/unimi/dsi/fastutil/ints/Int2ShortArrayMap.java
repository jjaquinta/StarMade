/*     */ package it.unimi.dsi.fastutil.ints;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.objects.AbstractObjectIterator;
/*     */ import it.unimi.dsi.fastutil.objects.AbstractObjectSet;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectIterator;
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
/*     */ public class Int2ShortArrayMap extends AbstractInt2ShortMap
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient int[] key;
/*     */   private transient short[] value;
/*     */   private int size;
/*     */ 
/*     */   public Int2ShortArrayMap(int[] key, short[] value)
/*     */   {
/*  77 */     this.key = key;
/*  78 */     this.value = value;
/*  79 */     this.size = key.length;
/*  80 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap()
/*     */   {
/*  85 */     this.key = IntArrays.EMPTY_ARRAY;
/*  86 */     this.value = ShortArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap(int capacity)
/*     */   {
/*  93 */     this.key = new int[capacity];
/*  94 */     this.value = new short[capacity];
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap(Int2ShortMap m)
/*     */   {
/* 101 */     this(m.size());
/* 102 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap(Map<? extends Integer, ? extends Short> m)
/*     */   {
/* 109 */     this(m.size());
/* 110 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap(int[] key, short[] value, int size)
/*     */   {
/* 121 */     this.key = key;
/* 122 */     this.value = value;
/* 123 */     this.size = size;
/* 124 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 125 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Int2ShortMap.FastEntrySet int2ShortEntrySet()
/*     */   {
/* 170 */     return new EntrySet(null);
/*     */   }
/*     */   private int findKey(int k) {
/* 173 */     int[] key = this.key;
/* 174 */     for (int i = this.size; i-- != 0; ) if (key[i] == k) return i;
/* 175 */     return -1;
/*     */   }
/*     */ 
/*     */   public short get(int k)
/*     */   {
/* 184 */     int[] key = this.key;
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
/* 195 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   public boolean containsKey(int k) {
/* 199 */     return findKey(k) != -1;
/*     */   }
/*     */ 
/*     */   public boolean containsValue(short v)
/*     */   {
/* 204 */     for (int i = this.size; i-- != 0; ) if (this.value[i] == v) return true;
/* 205 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty() {
/* 209 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   public short put(int k, short v)
/*     */   {
/* 214 */     int oldKey = findKey(k);
/* 215 */     if (oldKey != -1) {
/* 216 */       short oldValue = this.value[oldKey];
/* 217 */       this.value[oldKey] = v;
/* 218 */       return oldValue;
/*     */     }
/* 220 */     if (this.size == this.key.length) {
/* 221 */       int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
/* 222 */       short[] newValue = new short[this.size == 0 ? 2 : this.size * 2];
/* 223 */       for (int i = this.size; i-- != 0; ) {
/* 224 */         newKey[i] = this.key[i];
/* 225 */         newValue[i] = this.value[i];
/*     */       }
/* 227 */       this.key = newKey;
/* 228 */       this.value = newValue;
/*     */     }
/* 230 */     this.key[this.size] = k;
/* 231 */     this.value[this.size] = v;
/* 232 */     this.size += 1;
/* 233 */     return this.defRetValue;
/*     */   }
/*     */ 
/*     */   public short remove(int k)
/*     */   {
/* 238 */     int oldPos = findKey(k);
/* 239 */     if (oldPos == -1) return this.defRetValue;
/* 240 */     short oldValue = this.value[oldPos];
/* 241 */     int tail = this.size - oldPos - 1;
/* 242 */     for (int i = 0; i < tail; i++) {
/* 243 */       this.key[(oldPos + i)] = this.key[(oldPos + i + 1)];
/* 244 */       this.value[(oldPos + i)] = this.value[(oldPos + i + 1)];
/*     */     }
/* 246 */     this.size -= 1;
/* 247 */     return oldValue;
/*     */   }
/*     */ 
/*     */   public IntSet keySet()
/*     */   {
/* 252 */     return new IntArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public ShortCollection values() {
/* 256 */     return ShortCollections.unmodifiable(new ShortArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Int2ShortArrayMap clone()
/*     */   {
/*     */     Int2ShortArrayMap c;
/*     */     try
/*     */     {
/* 269 */       c = (Int2ShortArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 272 */       throw new InternalError();
/*     */     }
/* 274 */     c.key = ((int[])this.key.clone());
/* 275 */     c.value = ((short[])this.value.clone());
/* 276 */     return c;
/*     */   }
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 279 */     s.defaultWriteObject();
/* 280 */     for (int i = 0; i < this.size; i++) {
/* 281 */       s.writeInt(this.key[i]);
/* 282 */       s.writeShort(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 287 */     s.defaultReadObject();
/* 288 */     this.key = new int[this.size];
/* 289 */     this.value = new short[this.size];
/* 290 */     for (int i = 0; i < this.size; i++) {
/* 291 */       this.key[i] = s.readInt();
/* 292 */       this.value[i] = s.readShort();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Int2ShortMap.Entry>
/*     */     implements Int2ShortMap.FastEntrySet
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Int2ShortMap.Entry> iterator()
/*     */     {
/* 130 */       return new AbstractObjectIterator() {
/* 131 */         int next = 0;
/*     */ 
/* 133 */         public boolean hasNext() { return this.next < Int2ShortArrayMap.this.size; }
/*     */ 
/*     */         public Int2ShortMap.Entry next()
/*     */         {
/* 137 */           if (!hasNext()) throw new NoSuchElementException();
/* 138 */           return new AbstractInt2ShortMap.BasicEntry(Int2ShortArrayMap.this.key[this.next], Int2ShortArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Int2ShortMap.Entry> fastIterator() {
/* 143 */       return new AbstractObjectIterator() {
/* 144 */         int next = 0;
/* 145 */         final AbstractInt2ShortMap.BasicEntry entry = new AbstractInt2ShortMap.BasicEntry(0, (short)0);
/*     */ 
/* 147 */         public boolean hasNext() { return this.next < Int2ShortArrayMap.this.size; }
/*     */ 
/*     */         public Int2ShortMap.Entry next()
/*     */         {
/* 151 */           if (!hasNext()) throw new NoSuchElementException();
/* 152 */           this.entry.key = Int2ShortArrayMap.this.key[this.next];
/* 153 */           this.entry.value = Int2ShortArrayMap.this.value[(this.next++)];
/* 154 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 159 */       return Int2ShortArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 163 */       if (!(o instanceof Map.Entry)) return false;
/* 164 */       Map.Entry e = (Map.Entry)o;
/* 165 */       int k = ((Integer)e.getKey()).intValue();
/* 166 */       return (Int2ShortArrayMap.this.containsKey(k)) && (Int2ShortArrayMap.this.get(k) == ((Short)e.getValue()).shortValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.ints.Int2ShortArrayMap
 * JD-Core Version:    0.6.2
 */