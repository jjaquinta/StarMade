/*     */ package it.unimi.dsi.fastutil.chars;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
/*     */ import it.unimi.dsi.fastutil.bytes.AbstractByteIterator;
/*     */ import it.unimi.dsi.fastutil.bytes.ByteCollection;
/*     */ import it.unimi.dsi.fastutil.bytes.ByteIterator;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectIterator;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectSet;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ public abstract class AbstractChar2ByteMap extends AbstractChar2ByteFunction
/*     */   implements Char2ByteMap, Serializable
/*     */ {
/*     */   public static final long serialVersionUID = -4940583368468432370L;
/*     */ 
/*     */   public boolean containsValue(Object ov)
/*     */   {
/*  70 */     return containsValue(((Byte)ov).byteValue());
/*     */   }
/*     */ 
/*     */   public boolean containsValue(byte v) {
/*  74 */     return values().contains(v);
/*     */   }
/*     */ 
/*     */   public boolean containsKey(char k) {
/*  78 */     return keySet().contains(k);
/*     */   }
/*     */ 
/*     */   public void putAll(Map<? extends Character, ? extends Byte> m)
/*     */   {
/*  88 */     int n = m.size();
/*  89 */     Iterator i = m.entrySet().iterator();
/*  90 */     if ((m instanceof Serializable))
/*     */     {
/*  92 */       while (n-- != 0) {
/*  93 */         Char2ByteMap.Entry e = (Char2ByteMap.Entry)i.next();
/*  94 */         put(e.getCharKey(), e.getByteValue());
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  99 */       while (n-- != 0) {
/* 100 */         Map.Entry e = (Map.Entry)i.next();
/* 101 */         put((Character)e.getKey(), (Byte)e.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/* 106 */   public boolean isEmpty() { return size() == 0; }
/*     */ 
/*     */ 
/*     */   public CharSet keySet()
/*     */   {
/* 191 */     return new AbstractCharSet() {
/*     */       public boolean contains(char k) {
/* 193 */         return AbstractChar2ByteMap.this.containsKey(k);
/*     */       }
/* 195 */       public int size() { return AbstractChar2ByteMap.this.size(); } 
/* 196 */       public void clear() { AbstractChar2ByteMap.this.clear(); }
/*     */ 
/*     */       public CharIterator iterator() {
/* 199 */         return new AbstractCharIterator() {
/* 200 */           final ObjectIterator<Map.Entry<Character, Byte>> i = AbstractChar2ByteMap.this.entrySet().iterator();
/*     */ 
/* 202 */           public char nextChar() { return ((Char2ByteMap.Entry)this.i.next()).getCharKey(); } 
/*     */           public boolean hasNext() {
/* 204 */             return this.i.hasNext();
/*     */           }
/*     */         };
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */   public ByteCollection values()
/*     */   {
/* 224 */     return new AbstractByteCollection() {
/*     */       public boolean contains(byte k) {
/* 226 */         return AbstractChar2ByteMap.this.containsValue(k);
/*     */       }
/* 228 */       public int size() { return AbstractChar2ByteMap.this.size(); } 
/* 229 */       public void clear() { AbstractChar2ByteMap.this.clear(); }
/*     */ 
/*     */       public ByteIterator iterator() {
/* 232 */         return new AbstractByteIterator() {
/* 233 */           final ObjectIterator<Map.Entry<Character, Byte>> i = AbstractChar2ByteMap.this.entrySet().iterator();
/*     */ 
/* 235 */           public byte nextByte() { return ((Char2ByteMap.Entry)this.i.next()).getByteValue(); } 
/*     */           public boolean hasNext() {
/* 237 */             return this.i.hasNext();
/*     */           }
/*     */         };
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */   public ObjectSet<Map.Entry<Character, Byte>> entrySet()
/*     */   {
/* 246 */     return char2ByteEntrySet();
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 259 */     int h = 0; int n = size();
/* 260 */     ObjectIterator i = entrySet().iterator();
/*     */ 
/* 262 */     while (n-- != 0) h += ((Map.Entry)i.next()).hashCode();
/* 263 */     return h;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object o) {
/* 267 */     if (o == this) return true;
/* 268 */     if (!(o instanceof Map)) return false;
/*     */ 
/* 270 */     Map m = (Map)o;
/* 271 */     if (m.size() != size()) return false;
/* 272 */     return entrySet().containsAll(m.entrySet());
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 277 */     StringBuilder s = new StringBuilder();
/* 278 */     ObjectIterator i = entrySet().iterator();
/* 279 */     int n = size();
/*     */ 
/* 281 */     boolean first = true;
/*     */ 
/* 283 */     s.append("{");
/*     */ 
/* 285 */     while (n-- != 0) {
/* 286 */       if (first) first = false; else {
/* 287 */         s.append(", ");
/*     */       }
/* 289 */       Char2ByteMap.Entry e = (Char2ByteMap.Entry)i.next();
/*     */ 
/* 294 */       s.append(String.valueOf(e.getCharKey()));
/* 295 */       s.append("=>");
/*     */ 
/* 299 */       s.append(String.valueOf(e.getByteValue()));
/*     */     }
/*     */ 
/* 302 */     s.append("}");
/* 303 */     return s.toString();
/*     */   }
/*     */ 
/*     */   public static class BasicEntry
/*     */     implements Char2ByteMap.Entry
/*     */   {
/*     */     protected char key;
/*     */     protected byte value;
/*     */ 
/*     */     public BasicEntry(Character key, Byte value)
/*     */     {
/* 118 */       this.key = key.charValue();
/* 119 */       this.value = value.byteValue();
/*     */     }
/*     */     public BasicEntry(char key, byte value) {
/* 122 */       this.key = key;
/* 123 */       this.value = value;
/*     */     }
/*     */ 
/*     */     public Character getKey()
/*     */     {
/* 128 */       return Character.valueOf(this.key);
/*     */     }
/*     */ 
/*     */     public char getCharKey()
/*     */     {
/* 133 */       return this.key;
/*     */     }
/*     */ 
/*     */     public Byte getValue()
/*     */     {
/* 138 */       return Byte.valueOf(this.value);
/*     */     }
/*     */ 
/*     */     public byte getByteValue()
/*     */     {
/* 143 */       return this.value;
/*     */     }
/*     */ 
/*     */     public byte setValue(byte value)
/*     */     {
/* 148 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     public Byte setValue(Byte value)
/*     */     {
/* 154 */       return Byte.valueOf(setValue(value.byteValue()));
/*     */     }
/*     */ 
/*     */     public boolean equals(Object o)
/*     */     {
/* 160 */       if (!(o instanceof Map.Entry)) return false;
/* 161 */       Map.Entry e = (Map.Entry)o;
/*     */ 
/* 163 */       return (this.key == ((Character)e.getKey()).charValue()) && (this.value == ((Byte)e.getValue()).byteValue());
/*     */     }
/*     */ 
/*     */     public int hashCode() {
/* 167 */       return this.key ^ this.value;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 172 */       return this.key + "->" + this.value;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap
 * JD-Core Version:    0.6.2
 */