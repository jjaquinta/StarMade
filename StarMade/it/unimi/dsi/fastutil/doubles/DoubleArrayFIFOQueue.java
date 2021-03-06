/*     */ package it.unimi.dsi.fastutil.doubles;
/*     */ 
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ public class DoubleArrayFIFOQueue extends AbstractDoublePriorityQueue
/*     */ {
/*     */   public static final int INITIAL_CAPACITY = 16;
/*  58 */   protected double[] array = DoubleArrays.EMPTY_ARRAY;
/*     */   protected int length;
/*     */   protected int start;
/*     */   protected int end;
/*     */ 
/*     */   public DoubleArrayFIFOQueue(int capacity)
/*     */   {
/*  73 */     if (capacity > 0) this.array = new double[capacity];
/*  74 */     this.length = this.array.length;
/*     */   }
/*     */ 
/*     */   public DoubleArrayFIFOQueue()
/*     */   {
/*  79 */     this(16);
/*     */   }
/*     */ 
/*     */   public DoubleComparator comparator()
/*     */   {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   public double dequeueDouble() {
/*  90 */     if (this.start == this.end) throw new NoSuchElementException();
/*  91 */     double t = this.array[this.start];
/*  92 */     if (++this.start == this.length) this.start = 0;
/*  93 */     return t;
/*     */   }
/*     */ 
/*     */   public double dequeueLastDouble()
/*     */   {
/* 101 */     if (this.start == this.end) throw new NoSuchElementException();
/* 102 */     if (this.end == 0) this.end = this.length;
/* 103 */     double t = this.array[(--this.end)];
/*     */ 
/* 106 */     return t;
/*     */   }
/*     */ 
/*     */   private final void expand() {
/* 110 */     double[] newArray = DoubleArrays.grow(this.array, this.length + 1, 0);
/* 111 */     System.arraycopy(this.array, this.start, newArray, 0, this.length - this.start);
/* 112 */     System.arraycopy(this.array, 0, newArray, this.length - this.start, this.end);
/* 113 */     this.start = 0;
/* 114 */     this.end = this.length;
/* 115 */     this.length = (this.array = newArray).length;
/*     */   }
/*     */ 
/*     */   public void enqueue(double x)
/*     */   {
/* 120 */     this.array[(this.end++)] = x;
/* 121 */     if (this.end == this.length) this.end = 0;
/* 122 */     if (this.end == this.start) expand();
/*     */   }
/*     */ 
/*     */   public void enqueueFirst(double x)
/*     */   {
/* 128 */     if (this.start == 0) this.start = this.length;
/* 129 */     this.array[(--this.start)] = x;
/* 130 */     if (this.end == this.start) expand();
/*     */   }
/*     */ 
/*     */   public double firstDouble()
/*     */   {
/* 137 */     if (this.start == this.end) throw new NoSuchElementException();
/* 138 */     return this.array[this.start];
/*     */   }
/*     */ 
/*     */   public double lastDouble()
/*     */   {
/* 146 */     if (this.start == this.end) throw new NoSuchElementException();
/* 147 */     return this.array[(this.end - 1)];
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 159 */     this.start = (this.end = 0);
/*     */   }
/*     */ 
/*     */   public void trim()
/*     */   {
/* 165 */     int size = size();
/* 166 */     double[] newArray = new double[size + 1];
/*     */ 
/* 172 */     if (this.start <= this.end) { System.arraycopy(this.array, this.start, newArray, 0, this.end - this.start);
/*     */     } else {
/* 174 */       System.arraycopy(this.array, this.start, newArray, 0, this.length - this.start);
/* 175 */       System.arraycopy(this.array, 0, newArray, this.length - this.start, this.end);
/*     */     }
/* 177 */     this.start = 0;
/* 178 */     this.length = ((this.end = size) + 1);
/* 179 */     this.array = newArray;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/* 184 */     int apparentLength = this.end - this.start;
/* 185 */     return apparentLength >= 0 ? apparentLength : this.length + apparentLength;
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.doubles.DoubleArrayFIFOQueue
 * JD-Core Version:    0.6.2
 */