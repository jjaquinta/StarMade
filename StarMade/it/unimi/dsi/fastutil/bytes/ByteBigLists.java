/*     */ package it.unimi.dsi.fastutil.bytes;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.BigList;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class ByteBigLists
/*     */ {
/* 136 */   public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();
/*     */ 
/*     */   public static ByteBigList shuffle(ByteBigList l, Random random)
/*     */   {
/*  63 */     for (long i = l.size64(); i-- != 0L; ) {
/*  64 */       long p = (random.nextLong() & 0xFFFFFFFF) % (i + 1L);
/*  65 */       byte t = l.getByte(i);
/*  66 */       l.set(i, l.getByte(p));
/*  67 */       l.set(p, t);
/*     */     }
/*  69 */     return l;
/*     */   }
/*     */ 
/*     */   public static ByteBigList singleton(byte element)
/*     */   {
/* 219 */     return new Singleton(element, null);
/*     */   }
/*     */ 
/*     */   public static ByteBigList singleton(Object element)
/*     */   {
/* 229 */     return new Singleton(((Byte)element).byteValue(), null);
/*     */   }
/*     */ 
/*     */   public static ByteBigList synchronize(ByteBigList l)
/*     */   {
/* 303 */     return new SynchronizedBigList(l);
/*     */   }
/*     */ 
/*     */   public static ByteBigList synchronize(ByteBigList l, Object sync)
/*     */   {
/* 313 */     return new SynchronizedBigList(l, sync);
/*     */   }
/*     */ 
/*     */   public static ByteBigList unmodifiable(ByteBigList l)
/*     */   {
/* 380 */     return new UnmodifiableBigList(l);
/*     */   }
/*     */ 
/*     */   public static ByteBigList asBigList(ByteList list)
/*     */   {
/* 443 */     return new ListBigList(list);
/*     */   }
/*     */ 
/*     */   public static class ListBigList extends AbstractByteBigList
/*     */     implements Serializable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     private final ByteList list;
/*     */ 
/*     */     protected ListBigList(ByteList list)
/*     */     {
/* 391 */       this.list = list;
/*     */     }
/*     */ 
/*     */     private int intIndex(long index) {
/* 395 */       if (index >= 2147483647L) throw new IndexOutOfBoundsException("This big list is restricted to 32-bit indices");
/* 396 */       return (int)index;
/*     */     }
/*     */     public long size64() {
/* 399 */       return this.list.size(); } 
/* 401 */     @Deprecated
/*     */     public int size() { return this.list.size(); } 
/* 402 */     public void size(long size) { this.list.size(intIndex(size)); } 
/* 403 */     public ByteBigListIterator iterator() { return ByteBigListIterators.asBigListIterator(this.list.iterator()); } 
/* 404 */     public ByteBigListIterator listIterator() { return ByteBigListIterators.asBigListIterator(this.list.listIterator()); } 
/* 405 */     public boolean addAll(long index, Collection<? extends Byte> c) { return this.list.addAll(intIndex(index), c); } 
/* 406 */     public ByteBigListIterator listIterator(long index) { return ByteBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index))); } 
/* 407 */     public ByteBigList subList(long from, long to) { return new ListBigList(this.list.subList(intIndex(from), intIndex(to))); } 
/* 408 */     public boolean contains(byte key) { return this.list.contains(key); } 
/* 409 */     public byte[] toByteArray() { return this.list.toByteArray(); } 
/* 410 */     public void removeElements(long from, long to) { this.list.removeElements(intIndex(from), intIndex(to)); } 
/*     */     public byte[] toByteArray(byte[] a) {
/* 412 */       return this.list.toByteArray(a);
/*     */     }
/* 414 */     public void add(long index, byte key) { this.list.add(intIndex(index), key); } 
/* 415 */     public boolean addAll(long index, ByteCollection c) { return this.list.addAll(intIndex(index), c); } 
/* 416 */     public boolean addAll(long index, ByteBigList c) { return this.list.addAll(intIndex(index), c); } 
/* 417 */     public boolean add(byte key) { return this.list.add(key); } 
/* 418 */     public boolean addAll(ByteBigList c) { return this.list.addAll(c); } 
/* 419 */     public byte getByte(long index) { return this.list.getByte(intIndex(index)); } 
/* 420 */     public long indexOf(byte k) { return this.list.indexOf(k); } 
/* 421 */     public long lastIndexOf(byte k) { return this.list.lastIndexOf(k); } 
/* 422 */     public byte removeByte(long index) { return this.list.removeByte(intIndex(index)); } 
/* 423 */     public byte set(long index, byte k) { return this.list.set(intIndex(index), k); } 
/* 424 */     public boolean addAll(ByteCollection c) { return this.list.addAll(c); } 
/* 425 */     public boolean containsAll(ByteCollection c) { return this.list.containsAll(c); } 
/* 426 */     public boolean removeAll(ByteCollection c) { return this.list.removeAll(c); } 
/* 427 */     public boolean retainAll(ByteCollection c) { return this.list.retainAll(c); } 
/* 428 */     public boolean isEmpty() { return this.list.isEmpty(); } 
/* 429 */     public <T> T[] toArray(T[] a) { return this.list.toArray(a); } 
/* 430 */     public boolean containsAll(Collection<?> c) { return this.list.containsAll(c); } 
/* 431 */     public boolean addAll(Collection<? extends Byte> c) { return this.list.addAll(c); } 
/* 432 */     public boolean removeAll(Collection<?> c) { return this.list.removeAll(c); } 
/* 433 */     public boolean retainAll(Collection<?> c) { return this.list.retainAll(c); } 
/* 434 */     public void clear() { this.list.clear(); } 
/* 435 */     public int hashCode() { return this.list.hashCode(); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class UnmodifiableBigList extends ByteCollections.UnmodifiableCollection
/*     */     implements ByteBigList, Serializable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     protected final ByteBigList list;
/*     */ 
/*     */     protected UnmodifiableBigList(ByteBigList l)
/*     */     {
/* 326 */       super();
/* 327 */       this.list = l;
/*     */     }
/*     */     public byte getByte(long i) {
/* 330 */       return this.list.getByte(i); } 
/* 331 */     public byte set(long i, byte k) { throw new UnsupportedOperationException(); } 
/* 332 */     public void add(long i, byte k) { throw new UnsupportedOperationException(); } 
/* 333 */     public byte removeByte(long i) { throw new UnsupportedOperationException(); } 
/*     */     public long indexOf(byte k) {
/* 335 */       return this.list.indexOf(k); } 
/* 336 */     public long lastIndexOf(byte k) { return this.list.lastIndexOf(k); } 
/*     */     public boolean addAll(long index, Collection<? extends Byte> c) {
/* 338 */       throw new UnsupportedOperationException();
/*     */     }
/* 340 */     public void getElements(long from, byte[][] a, long offset, long length) { this.list.getElements(from, a, offset, length); } 
/* 341 */     public void removeElements(long from, long to) { throw new UnsupportedOperationException(); } 
/* 342 */     public void addElements(long index, byte[][] a, long offset, long length) { throw new UnsupportedOperationException(); } 
/* 343 */     public void addElements(long index, byte[][] a) { throw new UnsupportedOperationException(); } 
/* 344 */     public void size(long size) { this.list.size(size); } 
/* 345 */     public long size64() { return this.list.size64(); } 
/*     */     public ByteBigListIterator iterator() {
/* 347 */       return listIterator(); } 
/* 348 */     public ByteBigListIterator listIterator() { return ByteBigListIterators.unmodifiable(this.list.listIterator()); } 
/* 349 */     public ByteBigListIterator listIterator(long i) { return ByteBigListIterators.unmodifiable(this.list.listIterator(i)); } 
/*     */     public ByteBigList subList(long from, long to) {
/* 351 */       return ByteBigLists.unmodifiable(this.list.subList(from, to));
/*     */     }
/* 353 */     public boolean equals(Object o) { return this.list.equals(o); } 
/* 354 */     public int hashCode() { return this.list.hashCode(); }
/*     */ 
/*     */     public int compareTo(BigList<? extends Byte> o) {
/* 357 */       return this.list.compareTo(o);
/*     */     }
/*     */ 
/*     */     public boolean addAll(long index, ByteCollection c) {
/* 361 */       throw new UnsupportedOperationException(); } 
/* 362 */     public boolean addAll(ByteBigList l) { throw new UnsupportedOperationException(); } 
/* 363 */     public boolean addAll(long index, ByteBigList l) { throw new UnsupportedOperationException(); } 
/* 364 */     public Byte get(long i) { return (Byte)this.list.get(i); } 
/* 365 */     public void add(long i, Byte k) { throw new UnsupportedOperationException(); } 
/* 366 */     public Byte set(long index, Byte k) { throw new UnsupportedOperationException(); } 
/* 367 */     public Byte remove(long i) { throw new UnsupportedOperationException(); } 
/* 368 */     public long indexOf(Object o) { return this.list.indexOf(o); } 
/* 369 */     public long lastIndexOf(Object o) { return this.list.lastIndexOf(o); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class SynchronizedBigList extends ByteCollections.SynchronizedCollection
/*     */     implements ByteBigList, Serializable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     protected final ByteBigList list;
/*     */ 
/*     */     protected SynchronizedBigList(ByteBigList l, Object sync)
/*     */     {
/* 243 */       super(sync);
/* 244 */       this.list = l;
/*     */     }
/*     */ 
/*     */     protected SynchronizedBigList(ByteBigList l) {
/* 248 */       super();
/* 249 */       this.list = l;
/*     */     }
/*     */     public byte getByte(long i) {
/* 252 */       synchronized (this.sync) { return this.list.getByte(i); }  } 
/* 253 */     public byte set(long i, byte k) { synchronized (this.sync) { return this.list.set(i, k); }  } 
/* 254 */     public void add(long i, byte k) { synchronized (this.sync) { this.list.add(i, k); }  } 
/* 255 */     public byte removeByte(long i) { synchronized (this.sync) { return this.list.removeByte(i); }  } 
/*     */     public long indexOf(byte k) {
/* 257 */       synchronized (this.sync) { return this.list.indexOf(k); }  } 
/* 258 */     public long lastIndexOf(byte k) { synchronized (this.sync) { return this.list.lastIndexOf(k); }  } 
/*     */     public boolean addAll(long index, Collection<? extends Byte> c) {
/* 260 */       synchronized (this.sync) { return this.list.addAll(index, c); } 
/*     */     }
/* 262 */     public void getElements(long from, byte[][] a, long offset, long length) { synchronized (this.sync) { this.list.getElements(from, a, offset, length); }  } 
/* 263 */     public void removeElements(long from, long to) { synchronized (this.sync) { this.list.removeElements(from, to); }  } 
/* 264 */     public void addElements(long index, byte[][] a, long offset, long length) { synchronized (this.sync) { this.list.addElements(index, a, offset, length); }  } 
/* 265 */     public void addElements(long index, byte[][] a) { synchronized (this.sync) { this.list.addElements(index, a); }  } 
/* 266 */     public void size(long size) { synchronized (this.sync) { this.list.size(size); }  } 
/* 267 */     public long size64() { synchronized (this.sync) { return this.list.size64(); }  } 
/*     */     public ByteBigListIterator iterator() {
/* 269 */       return this.list.listIterator(); } 
/* 270 */     public ByteBigListIterator listIterator() { return this.list.listIterator(); } 
/* 271 */     public ByteBigListIterator listIterator(long i) { return this.list.listIterator(i); } 
/*     */     public ByteBigList subList(long from, long to) {
/* 273 */       synchronized (this.sync) { return ByteBigLists.synchronize(this.list.subList(from, to), this.sync); } 
/*     */     }
/* 275 */     public boolean equals(Object o) { synchronized (this.sync) { return this.list.equals(o); }  } 
/* 276 */     public int hashCode() { synchronized (this.sync) { return this.list.hashCode(); } }
/*     */ 
/*     */     public int compareTo(BigList<? extends Byte> o) {
/* 279 */       synchronized (this.sync) { return this.list.compareTo(o); }
/*     */     }
/*     */ 
/*     */     public boolean addAll(long index, ByteCollection c) {
/* 283 */       synchronized (this.sync) { return this.list.addAll(index, c); }  } 
/* 284 */     public boolean addAll(long index, ByteBigList l) { synchronized (this.sync) { return this.list.addAll(index, l); }  } 
/* 285 */     public boolean addAll(ByteBigList l) { synchronized (this.sync) { return this.list.addAll(l); }  } 
/*     */     public Byte get(long i) {
/* 287 */       synchronized (this.sync) { return (Byte)this.list.get(i); }  } 
/* 288 */     public void add(long i, Byte k) { synchronized (this.sync) { this.list.add(i, k); }  } 
/* 289 */     public Byte set(long index, Byte k) { synchronized (this.sync) { return (Byte)this.list.set(index, k); }  } 
/* 290 */     public Byte remove(long i) { synchronized (this.sync) { return (Byte)this.list.remove(i); }  } 
/* 291 */     public long indexOf(Object o) { synchronized (this.sync) { return this.list.indexOf(o); }  } 
/* 292 */     public long lastIndexOf(Object o) { synchronized (this.sync) { return this.list.lastIndexOf(o); }
/*     */ 
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Singleton extends AbstractByteBigList
/*     */     implements Serializable, Cloneable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */     private final byte element;
/*     */ 
/*     */     private Singleton(byte element)
/*     */     {
/* 153 */       this.element = element;
/*     */     }
/*     */     public byte getByte(long i) {
/* 156 */       if (i == 0L) return this.element; throw new IndexOutOfBoundsException(); } 
/* 157 */     public byte removeByte(long i) { throw new UnsupportedOperationException(); } 
/* 158 */     public boolean contains(byte k) { return k == this.element; } 
/*     */     public boolean addAll(Collection<? extends Byte> c) {
/* 160 */       throw new UnsupportedOperationException(); } 
/* 161 */     public boolean addAll(long i, Collection<? extends Byte> c) { throw new UnsupportedOperationException(); } 
/* 162 */     public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); } 
/* 163 */     public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
/*     */ 
/*     */ 
/*     */     public byte[] toByteArray()
/*     */     {
/* 168 */       byte[] a = new byte[1];
/* 169 */       a[0] = this.element;
/* 170 */       return a;
/*     */     }
/*     */ 
/*     */     public ByteBigListIterator listIterator() {
/* 174 */       return ByteBigListIterators.singleton(this.element);
/*     */     }
/* 176 */     public ByteBigListIterator iterator() { return listIterator(); }
/*     */ 
/*     */     public ByteBigListIterator listIterator(long i) {
/* 179 */       if ((i > 1L) || (i < 0L)) throw new IndexOutOfBoundsException();
/* 180 */       ByteBigListIterator l = listIterator();
/* 181 */       if (i == 1L) l.next();
/* 182 */       return l;
/*     */     }
/*     */ 
/*     */     public ByteBigList subList(long from, long to)
/*     */     {
/* 187 */       ensureIndex(from);
/* 188 */       ensureIndex(to);
/* 189 */       if (from > to) throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
/*     */ 
/* 191 */       if ((from != 0L) || (to != 1L)) return ByteBigLists.EMPTY_BIG_LIST;
/* 192 */       return this;
/*     */     }
/*     */     @Deprecated
/*     */     public int size() {
/* 196 */       return 1; } 
/* 197 */     public long size64() { return 1L; } 
/* 198 */     public void size(long size) { throw new UnsupportedOperationException(); } 
/* 199 */     public void clear() { throw new UnsupportedOperationException(); } 
/*     */     public Object clone() {
/* 201 */       return this;
/*     */     }
/*     */     public boolean rem(byte k) {
/* 204 */       throw new UnsupportedOperationException(); } 
/* 205 */     public boolean addAll(ByteCollection c) { throw new UnsupportedOperationException(); } 
/* 206 */     public boolean addAll(long i, ByteCollection c) { throw new UnsupportedOperationException(); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class EmptyBigList extends ByteCollections.EmptyCollection
/*     */     implements ByteBigList, Serializable, Cloneable
/*     */   {
/*     */     public static final long serialVersionUID = -7046029254386353129L;
/*     */ 
/*     */     public void add(long index, byte k)
/*     */     {
/*  79 */       throw new UnsupportedOperationException(); } 
/*  80 */     public boolean add(byte k) { throw new UnsupportedOperationException(); } 
/*  81 */     public byte removeByte(long i) { throw new UnsupportedOperationException(); } 
/*  82 */     public byte set(long index, byte k) { throw new UnsupportedOperationException(); } 
/*  83 */     public long indexOf(byte k) { return -1L; } 
/*  84 */     public long lastIndexOf(byte k) { return -1L; } 
/*  85 */     public boolean addAll(Collection<? extends Byte> c) { throw new UnsupportedOperationException(); } 
/*  86 */     public boolean addAll(long i, Collection<? extends Byte> c) { throw new UnsupportedOperationException(); } 
/*  87 */     public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); } 
/*  88 */     public Byte get(long i) { throw new IndexOutOfBoundsException(); } 
/*  89 */     public boolean addAll(ByteCollection c) { throw new UnsupportedOperationException(); } 
/*  90 */     public boolean addAll(ByteBigList c) { throw new UnsupportedOperationException(); } 
/*  91 */     public boolean addAll(long i, ByteCollection c) { throw new UnsupportedOperationException(); } 
/*  92 */     public boolean addAll(long i, ByteBigList c) { throw new UnsupportedOperationException(); } 
/*  93 */     public void add(long index, Byte k) { throw new UnsupportedOperationException(); } 
/*  94 */     public boolean add(Byte k) { throw new UnsupportedOperationException(); } 
/*  95 */     public Byte set(long index, Byte k) { throw new UnsupportedOperationException(); } 
/*  96 */     public byte getByte(long i) { throw new IndexOutOfBoundsException(); } 
/*  97 */     public Byte remove(long k) { throw new UnsupportedOperationException(); } 
/*  98 */     public long indexOf(Object k) { return -1L; } 
/*  99 */     public long lastIndexOf(Object k) { return -1L; } 
/*     */     public ByteBigListIterator listIterator() {
/* 101 */       return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR;
/*     */     }
/* 103 */     public ByteBigListIterator iterator() { return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR; }
/*     */ 
/*     */     public ByteBigListIterator listIterator(long i) {
/* 106 */       if (i == 0L) return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR; throw new IndexOutOfBoundsException(String.valueOf(i));
/*     */     }
/* 108 */     public ByteBigList subList(long from, long to) { if ((from == 0L) && (to == 0L)) return this; throw new IndexOutOfBoundsException(); } 
/*     */     public void getElements(long from, byte[][] a, long offset, long length) {
/* 110 */       ByteBigArrays.ensureOffsetLength(a, offset, length); if (from != 0L) throw new IndexOutOfBoundsException();  } 
/* 111 */     public void removeElements(long from, long to) { throw new UnsupportedOperationException(); } 
/*     */     public void addElements(long index, byte[][] a, long offset, long length) {
/* 113 */       throw new UnsupportedOperationException(); } 
/* 114 */     public void addElements(long index, byte[][] a) { throw new UnsupportedOperationException(); } 
/*     */     public void size(long s) {
/* 116 */       throw new UnsupportedOperationException(); } 
/* 117 */     public long size64() { return 0L; }
/*     */ 
/*     */     public int compareTo(BigList<? extends Byte> o) {
/* 120 */       if (o == this) return 0;
/* 121 */       return o.isEmpty() ? 0 : -1;
/*     */     }
/*     */     private Object readResolve() {
/* 124 */       return ByteBigLists.EMPTY_BIG_LIST; } 
/* 125 */     public Object clone() { return ByteBigLists.EMPTY_BIG_LIST; }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.bytes.ByteBigLists
 * JD-Core Version:    0.6.2
 */