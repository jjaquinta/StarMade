/*     */ package it.unimi.dsi.fastutil.bytes;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.floats.FloatArraySet;
/*     */ import it.unimi.dsi.fastutil.floats.FloatArrays;
/*     */ import it.unimi.dsi.fastutil.floats.FloatCollection;
/*     */ import it.unimi.dsi.fastutil.floats.FloatCollections;
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
/*     */ public class Byte2FloatArrayMap extends AbstractByte2FloatMap
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient byte[] key;
/*     */   private transient float[] value;
/*     */   private int size;
/*     */ 
/*     */   public Byte2FloatArrayMap(byte[] key, float[] value)
/*     */   {
/*  77 */     this.key = key;
/*  78 */     this.value = value;
/*  79 */     this.size = key.length;
/*  80 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap()
/*     */   {
/*  85 */     this.key = ByteArrays.EMPTY_ARRAY;
/*  86 */     this.value = FloatArrays.EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap(int capacity)
/*     */   {
/*  93 */     this.key = new byte[capacity];
/*  94 */     this.value = new float[capacity];
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap(Byte2FloatMap m)
/*     */   {
/* 101 */     this(m.size());
/* 102 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap(Map<? extends Byte, ? extends Float> m)
/*     */   {
/* 109 */     this(m.size());
/* 110 */     putAll(m);
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap(byte[] key, float[] value, int size)
/*     */   {
/* 121 */     this.key = key;
/* 122 */     this.value = value;
/* 123 */     this.size = size;
/* 124 */     if (key.length != value.length) throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
/* 125 */     if (size > key.length) throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
/*     */   }
/*     */ 
/*     */   public Byte2FloatMap.FastEntrySet byte2FloatEntrySet()
/*     */   {
/* 170 */     return new EntrySet(null);
/*     */   }
/*     */   private int findKey(byte k) {
/* 173 */     byte[] key = this.key;
/* 174 */     for (int i = this.size; i-- != 0; ) if (key[i] == k) return i;
/* 175 */     return -1;
/*     */   }
/*     */ 
/*     */   public float get(byte k)
/*     */   {
/* 184 */     byte[] key = this.key;
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
/*     */   public boolean containsKey(byte k) {
/* 199 */     return findKey(k) != -1;
/*     */   }
/*     */ 
/*     */   public boolean containsValue(float v)
/*     */   {
/* 204 */     for (int i = this.size; i-- != 0; ) if (this.value[i] == v) return true;
/* 205 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty() {
/* 209 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   public float put(byte k, float v)
/*     */   {
/* 214 */     int oldKey = findKey(k);
/* 215 */     if (oldKey != -1) {
/* 216 */       float oldValue = this.value[oldKey];
/* 217 */       this.value[oldKey] = v;
/* 218 */       return oldValue;
/*     */     }
/* 220 */     if (this.size == this.key.length) {
/* 221 */       byte[] newKey = new byte[this.size == 0 ? 2 : this.size * 2];
/* 222 */       float[] newValue = new float[this.size == 0 ? 2 : this.size * 2];
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
/*     */   public float remove(byte k)
/*     */   {
/* 238 */     int oldPos = findKey(k);
/* 239 */     if (oldPos == -1) return this.defRetValue;
/* 240 */     float oldValue = this.value[oldPos];
/* 241 */     int tail = this.size - oldPos - 1;
/* 242 */     for (int i = 0; i < tail; i++) {
/* 243 */       this.key[(oldPos + i)] = this.key[(oldPos + i + 1)];
/* 244 */       this.value[(oldPos + i)] = this.value[(oldPos + i + 1)];
/*     */     }
/* 246 */     this.size -= 1;
/* 247 */     return oldValue;
/*     */   }
/*     */ 
/*     */   public ByteSet keySet()
/*     */   {
/* 252 */     return new ByteArraySet(this.key, this.size);
/*     */   }
/*     */ 
/*     */   public FloatCollection values() {
/* 256 */     return FloatCollections.unmodifiable(new FloatArraySet(this.value, this.size));
/*     */   }
/*     */ 
/*     */   public Byte2FloatArrayMap clone()
/*     */   {
/*     */     Byte2FloatArrayMap c;
/*     */     try
/*     */     {
/* 269 */       c = (Byte2FloatArrayMap)super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException cantHappen) {
/* 272 */       throw new InternalError();
/*     */     }
/* 274 */     c.key = ((byte[])this.key.clone());
/* 275 */     c.value = ((float[])this.value.clone());
/* 276 */     return c;
/*     */   }
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 279 */     s.defaultWriteObject();
/* 280 */     for (int i = 0; i < this.size; i++) {
/* 281 */       s.writeByte(this.key[i]);
/* 282 */       s.writeFloat(this.value[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 287 */     s.defaultReadObject();
/* 288 */     this.key = new byte[this.size];
/* 289 */     this.value = new float[this.size];
/* 290 */     for (int i = 0; i < this.size; i++) {
/* 291 */       this.key[i] = s.readByte();
/* 292 */       this.value[i] = s.readFloat();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class EntrySet extends AbstractObjectSet<Byte2FloatMap.Entry>
/*     */     implements Byte2FloatMap.FastEntrySet
/*     */   {
/*     */     private EntrySet()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Byte2FloatMap.Entry> iterator()
/*     */     {
/* 130 */       return new AbstractObjectIterator() {
/* 131 */         int next = 0;
/*     */ 
/* 133 */         public boolean hasNext() { return this.next < Byte2FloatArrayMap.this.size; }
/*     */ 
/*     */         public Byte2FloatMap.Entry next()
/*     */         {
/* 137 */           if (!hasNext()) throw new NoSuchElementException();
/* 138 */           return new AbstractByte2FloatMap.BasicEntry(Byte2FloatArrayMap.this.key[this.next], Byte2FloatArrayMap.this.value[(this.next++)]);
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public ObjectIterator<Byte2FloatMap.Entry> fastIterator() {
/* 143 */       return new AbstractObjectIterator() {
/* 144 */         int next = 0;
/* 145 */         final AbstractByte2FloatMap.BasicEntry entry = new AbstractByte2FloatMap.BasicEntry((byte)0, 0.0F);
/*     */ 
/* 147 */         public boolean hasNext() { return this.next < Byte2FloatArrayMap.this.size; }
/*     */ 
/*     */         public Byte2FloatMap.Entry next()
/*     */         {
/* 151 */           if (!hasNext()) throw new NoSuchElementException();
/* 152 */           this.entry.key = Byte2FloatArrayMap.this.key[this.next];
/* 153 */           this.entry.value = Byte2FloatArrayMap.this.value[(this.next++)];
/* 154 */           return this.entry;
/*     */         } } ;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 159 */       return Byte2FloatArrayMap.this.size;
/*     */     }
/*     */ 
/*     */     public boolean contains(Object o) {
/* 163 */       if (!(o instanceof Map.Entry)) return false;
/* 164 */       Map.Entry e = (Map.Entry)o;
/* 165 */       byte k = ((Byte)e.getKey()).byteValue();
/* 166 */       return (Byte2FloatArrayMap.this.containsKey(k)) && (Byte2FloatArrayMap.this.get(k) == ((Float)e.getValue()).floatValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap
 * JD-Core Version:    0.6.2
 */