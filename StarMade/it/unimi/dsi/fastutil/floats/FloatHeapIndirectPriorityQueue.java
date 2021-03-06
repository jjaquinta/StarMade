/*     */ package it.unimi.dsi.fastutil.floats;
/*     */ 
/*     */ import it.unimi.dsi.fastutil.ints.IntArrays;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class FloatHeapIndirectPriorityQueue extends FloatHeapSemiIndirectPriorityQueue
/*     */ {
/*     */   protected int[] inv;
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int capacity, FloatComparator c)
/*     */   {
/*  66 */     super(refArray, capacity, c);
/*  67 */     if (capacity > 0) this.heap = new int[capacity];
/*  68 */     this.refArray = refArray;
/*  69 */     this.c = c;
/*  70 */     this.inv = new int[refArray.length];
/*  71 */     IntArrays.fill(this.inv, -1);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int capacity)
/*     */   {
/*  79 */     this(refArray, capacity, null);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, FloatComparator c)
/*     */   {
/*  87 */     this(refArray, refArray.length, c);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray)
/*     */   {
/*  93 */     this(refArray, refArray.length, null);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int[] a, int size, FloatComparator c)
/*     */   {
/* 107 */     this(refArray, 0, c);
/* 108 */     this.heap = a;
/* 109 */     this.size = size;
/* 110 */     int i = size;
/* 111 */     while (i-- != 0) {
/* 112 */       if (this.inv[a[i]] != -1) throw new IllegalArgumentException("Index " + a[i] + " appears twice in the heap");
/* 113 */       this.inv[a[i]] = i;
/*     */     }
/* 115 */     FloatIndirectHeaps.makeHeap(refArray, a, this.inv, size, c);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int[] a, FloatComparator c)
/*     */   {
/* 128 */     this(refArray, a, a.length, c);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int[] a, int size)
/*     */   {
/* 141 */     this(refArray, a, size, null);
/*     */   }
/*     */ 
/*     */   public FloatHeapIndirectPriorityQueue(float[] refArray, int[] a)
/*     */   {
/* 153 */     this(refArray, a, a.length);
/*     */   }
/*     */   public void enqueue(int x) {
/* 156 */     if (this.inv[x] >= 0) throw new IllegalArgumentException("Index " + x + " belongs to the queue");
/* 157 */     if (this.size == this.heap.length) this.heap = IntArrays.grow(this.heap, this.size + 1);
/*     */     int tmp83_82 = x; this.heap[this.size] = tmp83_82; this.inv[tmp83_82] = (this.size++);
/*     */ 
/* 161 */     FloatIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, this.size - 1, this.c);
/*     */   }
/*     */ 
/*     */   public boolean contains(int index) {
/* 165 */     return this.inv[index] >= 0;
/*     */   }
/*     */ 
/*     */   public int dequeue() {
/* 169 */     if (this.size == 0) throw new NoSuchElementException();
/* 170 */     int result = this.heap[0];
/* 171 */     if (--this.size != 0)
/*     */     {
/*     */       int tmp54_53 = this.heap[this.size]; this.heap[0] = tmp54_53; this.inv[tmp54_53] = 0;
/* 172 */     }this.inv[result] = -1;
/*     */ 
/* 174 */     if (this.size != 0) FloatIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.c);
/* 175 */     return result;
/*     */   }
/*     */ 
/*     */   public void changed() {
/* 179 */     FloatIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.c);
/*     */   }
/*     */ 
/*     */   public void changed(int index) {
/* 183 */     int pos = this.inv[index];
/* 184 */     if (pos < 0) throw new IllegalArgumentException("Index " + index + " does not belong to the queue");
/* 185 */     int newPos = FloatIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, pos, this.c);
/* 186 */     FloatIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, newPos, this.c);
/*     */   }
/*     */ 
/*     */   public void allChanged()
/*     */   {
/* 193 */     FloatIndirectHeaps.makeHeap(this.refArray, this.heap, this.inv, this.size, this.c);
/*     */   }
/*     */ 
/*     */   public boolean remove(int index)
/*     */   {
/* 198 */     int result = this.inv[index];
/* 199 */     if (result < 0) return false;
/* 200 */     this.inv[index] = -1;
/*     */ 
/* 202 */     if (result < --this.size)
/*     */     {
/*     */       int tmp53_52 = this.heap[this.size]; this.heap[result] = tmp53_52; this.inv[tmp53_52] = result;
/* 204 */       int newPos = FloatIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, result, this.c);
/* 205 */       FloatIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, newPos, this.c);
/*     */     }
/*     */ 
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 213 */     this.size = 0;
/* 214 */     IntArrays.fill(this.inv, -1);
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.floats.FloatHeapIndirectPriorityQueue
 * JD-Core Version:    0.6.2
 */