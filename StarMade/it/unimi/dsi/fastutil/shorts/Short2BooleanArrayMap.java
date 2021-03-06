/*     */ package it.unimi.dsi.fastutil.shorts;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanArraySet;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanArrays;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanCollection;
/*     */ import it.unimi.dsi.fastutil.booleans.BooleanCollections;
/*     */ import it.unimi.dsi.fastutil.objects.AbstractObjectIterator;
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
/*     */ public class Short2BooleanArrayMap extends AbstractShort2BooleanMap
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient short[] key;
/*     */   private transient boolean[] value;
/*     */   private int size;
/*     */ 
/*     */   public Short2BooleanArrayMap(short[] key, boolean[] value)
/*     */   {
/*  77 */     this.key = key;
/*  78 */     this.value = value;
/*  79 */     this.size = key.length;
/*  80 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap()
/*     */   {
/*  85 */     this.key = ShortArrays.EMPTY_ARRAY;
/*  86 */     this.value = BooleanArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap(int capacity)
/*     */   {
/*  93 */     this.key = new short[capacity];
/*  94 */     this.value = new boolean[capacity];
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap(Short2BooleanMap m)
/*     */   {
/* 101 */     this(m.size());
/* 102 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap(Map<? extends Short, ? extends Boolean> m)
/*     */   {
/* 109 */     this(m.size());
/* 110 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap(short[] key, boolean[] value, int size)
/*     */   {
/* 121 */     this.key = key;
/* 122 */     this.value = value;
/* 123 */     this.size = size;
/* 124 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 125 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Short2BooleanMap.FastEntrySet short2BooleanEntrySet()
/*     */   {
/* 170 */     return new EntrySet(null);
/*     */   }
/*     */   private int findKey(short k) {
/* 173 */     short[] key = this.key;
/* 174 */     for (int i = this.size; i-- != 0; ) if (key[i] == k) return i;
/* 175 */     return -1;
/*     */   }
/*     */ 
/*     */   public boolean get(short k)
/*     */   {
/* 184 */     short[] key = this.key;
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
/*     */   public boolean containsKey(short k) {
/* 199 */     return findKey(k) != -1;
/*     */   }
/*     */ 
/*     */   public boolean containsValue(boolean v)
/*     */   {
/* 204 */     for (int i = this.size; i-- != 0; ) if (this.value[i] == v) return true;
/* 205 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty() {
/* 209 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   public boolean put(short k, boolean v)
/*     */   {
/* 214 */     int oldKey = findKey(k);
/* 215 */     if (oldKey != -1) {
/* 216 */       boolean oldValue = this.value[oldKey];
/* 217 */       this.value[oldKey] = v;
/* 218 */       return oldValue;
/*     */     }
/* 220 */     if (this.size == this.key.length) {
/* 221 */       short[] newKey = new short[this.size == 0 ? 2 : this.size * 2];
/* 222 */       boolean[] newValue = new boolean[this.size == 0 ? 2 : this.size * 2];
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
/*     */   public boolean remove(short k)
/*     */   {
/* 238 */     int oldPos = findKey(k);
/* 239 */     if (oldPos == -1) return this.defRetValue;
/* 240 */     boolean oldValue = this.value[oldPos];
/* 241 */     int tail = this.size - oldPos - 1;
/* 242 */     for (int i = 0; i < tail; i++) {
/* 243 */       this.key[(oldPos + i)] = this.key[(oldPos + i + 1)];
/* 244 */       this.value[(oldPos + i)] = this.value[(oldPos + i + 1)];
/*     */     }
/* 246 */     this.size -= 1;
/* 247 */     return oldValue;
/*     */   }
/*     */ 
/*     */   public ShortSet keySet()
/*     */   {
/* 252 */     return new ShortArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public BooleanCollection values() {
/* 256 */     return BooleanCollections.unmodifiable(new BooleanArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Short2BooleanArrayMap clone()
/*     */   {
/*     */     Short2BooleanArrayMap c;
/*     */     try
/*     */     {
/* 269 */       c = (Short2BooleanArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 272 */       throw new InternalError();
/*     */     }
/* 274 */     c.key = ((short[])this.key.clone());
/* 275 */     c.value = ((boolean[])this.value.clone());
/* 276 */     return c;
/*     */   }
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 279 */     s.defaultWriteObject();
/* 280 */     for (int i = 0; i < this.size; i++) {
/* 281 */       s.writeShort(this.key[i]);
/* 282 */       s.writeBoolean(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 287 */     s.defaultReadObject();
/* 288 */     this.key = new short[this.size];
/* 289 */     this.value = new boolean[this.size];
/* 290 */     for (int i = 0; i < this.size; i++) {
/* 291 */       this.key[i] = s.readShort();
/* 292 */       this.value[i] = s.readBoolean();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Short2BooleanMap.Entry>
/*     */     implements Short2BooleanMap.FastEntrySet
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Short2BooleanMap.Entry> iterator()
/*     */     {
/* 130 */       return new AbstractObjectIterator() {
/* 131 */         int next = 0;
/*     */ 
/* 133 */         public boolean hasNext() { return this.next < Short2BooleanArrayMap.this.size; }
/*     */ 
/*     */         public Short2BooleanMap.Entry next()
/*     */         {
/* 137 */           if (!hasNext()) throw new NoSuchElementException();
/* 138 */           return new AbstractShort2BooleanMap.BasicEntry(Short2BooleanArrayMap.this.key[this.next], Short2BooleanArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Short2BooleanMap.Entry> fastIterator() {
/* 143 */       return new AbstractObjectIterator() {
/* 144 */         int next = 0;
/* 145 */         final AbstractShort2BooleanMap.BasicEntry entry = new AbstractShort2BooleanMap.BasicEntry((short)0, false);
/*     */ 
/* 147 */         public boolean hasNext() { return this.next < Short2BooleanArrayMap.this.size; }
/*     */ 
/*     */         public Short2BooleanMap.Entry next()
/*     */         {
/* 151 */           if (!hasNext()) throw new NoSuchElementException();
/* 152 */           this.entry.key = Short2BooleanArrayMap.this.key[this.next];
/* 153 */           this.entry.value = Short2BooleanArrayMap.this.value[(this.next++)];
/* 154 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 159 */       return Short2BooleanArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 163 */       if (!(o instanceof Map.Entry)) return false;
/* 164 */       Map.Entry e = (Map.Entry)o;
/* 165 */       short k = ((Short)e.getKey()).shortValue();
/* 166 */       return (Short2BooleanArrayMap.this.containsKey(k)) && (Short2BooleanArrayMap.this.get(k) == ((Boolean)e.getValue()).booleanValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.shorts.Short2BooleanArrayMap
 * JD-Core Version:    0.6.2
 */