/*      */ package it.unimi.dsi.fastutil.longs;
/*      */ 
/*      */ import it.unimi.dsi.fastutil.HashCommon;
/*      */ import it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectListIterator;
/*      */ import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
/*      */ import it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
/*      */ import it.unimi.dsi.fastutil.shorts.ShortCollection;
/*      */ import it.unimi.dsi.fastutil.shorts.ShortIterator;
/*      */ import it.unimi.dsi.fastutil.shorts.ShortListIterator;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.SortedMap;
/*      */ 
/*      */ public class Long2ShortAVLTreeMap extends AbstractLong2ShortSortedMap
/*      */   implements Serializable, Cloneable
/*      */ {
/*      */   protected transient Entry tree;
/*      */   protected int count;
/*      */   protected transient Entry firstEntry;
/*      */   protected transient Entry lastEntry;
/*      */   protected volatile transient ObjectSortedSet<Long2ShortMap.Entry> entries;
/*      */   protected volatile transient LongSortedSet keys;
/*      */   protected volatile transient ShortCollection values;
/*      */   protected transient boolean modified;
/*      */   protected Comparator<? super Long> storedComparator;
/*      */   protected transient LongComparator actualComparator;
/*      */   public static final long serialVersionUID = -7046029254386353129L;
/*      */   private static final boolean ASSERTS = false;
/*      */   private transient boolean[] dirPath;
/*      */ 
/*      */   public Long2ShortAVLTreeMap()
/*      */   {
/*   93 */     allocatePaths();
/*      */ 
/*   98 */     this.tree = null;
/*   99 */     this.count = 0;
/*      */   }
/*      */ 
/*      */   private void setActualComparator()
/*      */   {
/*  114 */     if ((this.storedComparator == null) || ((this.storedComparator instanceof LongComparator))) this.actualComparator = ((LongComparator)this.storedComparator); else
/*  115 */       this.actualComparator = new LongComparator() {
/*      */         public int compare(long k1, long k2) {
/*  117 */           return Long2ShortAVLTreeMap.this.storedComparator.compare(Long.valueOf(k1), Long.valueOf(k2));
/*      */         }
/*      */         public int compare(Long ok1, Long ok2) {
/*  120 */           return Long2ShortAVLTreeMap.this.storedComparator.compare(ok1, ok2);
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(Comparator<? super Long> c)
/*      */   {
/*  133 */     this();
/*  134 */     this.storedComparator = c;
/*  135 */     setActualComparator();
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(Map<? extends Long, ? extends Short> m)
/*      */   {
/*  145 */     this();
/*  146 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(SortedMap<Long, Short> m)
/*      */   {
/*  155 */     this(m.comparator());
/*  156 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(Long2ShortMap m)
/*      */   {
/*  165 */     this();
/*  166 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(Long2ShortSortedMap m)
/*      */   {
/*  175 */     this(m.comparator());
/*  176 */     putAll(m);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(long[] k, short[] v, Comparator<? super Long> c)
/*      */   {
/*  188 */     this(c);
/*  189 */     if (k.length != v.length) throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
/*  190 */     for (int i = 0; i < k.length; i++) put(k[i], v[i]);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap(long[] k, short[] v)
/*      */   {
/*  201 */     this(k, v, null);
/*      */   }
/*      */ 
/*      */   final int compare(long k1, long k2)
/*      */   {
/*  228 */     return this.actualComparator == null ? 1 : k1 == k2 ? 0 : k1 < k2 ? -1 : this.actualComparator.compare(k1, k2);
/*      */   }
/*      */ 
/*      */   final Entry findKey(long k)
/*      */   {
/*  240 */     Entry e = this.tree;
/*      */     int cmp;
/*  243 */     while ((e != null) && ((cmp = compare(k, e.key)) != 0)) e = cmp < 0 ? e.left() : e.right();
/*      */ 
/*  245 */     return e;
/*      */   }
/*      */ 
/*      */   final Entry locateKey(long k)
/*      */   {
/*  256 */     Entry e = this.tree; Entry last = this.tree;
/*  257 */     int cmp = 0;
/*      */ 
/*  259 */     while ((e != null) && ((cmp = compare(k, e.key)) != 0)) {
/*  260 */       last = e;
/*  261 */       e = cmp < 0 ? e.left() : e.right();
/*      */     }
/*      */ 
/*  264 */     return cmp == 0 ? e : last;
/*      */   }
/*      */ 
/*      */   private void allocatePaths()
/*      */   {
/*  272 */     this.dirPath = new boolean[48];
/*      */   }
/*      */ 
/*      */   public short put(long k, short v)
/*      */   {
/*  280 */     this.modified = false;
/*      */ 
/*  282 */     if (this.tree == null) {
/*  283 */       this.count += 1;
/*  284 */       this.tree = (this.lastEntry = this.firstEntry = new Entry(k, v));
/*  285 */       this.modified = true;
/*      */     }
/*      */     else {
/*  288 */       Entry p = this.tree; Entry q = null; Entry y = this.tree; Entry z = null; Entry e = null; Entry w = null;
/*  289 */       int i = 0;
/*      */       while (true)
/*      */       {
/*      */         int cmp;
/*  292 */         if ((cmp = compare(k, p.key)) == 0) {
/*  293 */           short oldValue = p.value;
/*  294 */           p.value = v;
/*  295 */           return oldValue;
/*      */         }
/*      */ 
/*  298 */         if (p.balance() != 0) {
/*  299 */           i = 0;
/*  300 */           z = q;
/*  301 */           y = p;
/*      */         }
/*      */ 
/*  304 */         if ((this.dirPath[(i++)] = cmp > 0 ? 1 : 0) != 0) {
/*  305 */           if (p.succ()) {
/*  306 */             this.count += 1;
/*  307 */             e = new Entry(k, v);
/*      */ 
/*  309 */             this.modified = true;
/*  310 */             if (p.right == null) this.lastEntry = e;
/*      */ 
/*  312 */             e.left = p;
/*  313 */             e.right = p.right;
/*      */ 
/*  315 */             p.right(e);
/*      */ 
/*  317 */             break;
/*      */           }
/*      */ 
/*  320 */           q = p;
/*  321 */           p = p.right;
/*      */         }
/*      */         else {
/*  324 */           if (p.pred()) {
/*  325 */             this.count += 1;
/*  326 */             e = new Entry(k, v);
/*      */ 
/*  328 */             this.modified = true;
/*  329 */             if (p.left == null) this.firstEntry = e;
/*      */ 
/*  331 */             e.right = p;
/*  332 */             e.left = p.left;
/*      */ 
/*  334 */             p.left(e);
/*      */ 
/*  336 */             break;
/*      */           }
/*      */ 
/*  339 */           q = p;
/*  340 */           p = p.left;
/*      */         }
/*      */       }
/*      */ 
/*  344 */       p = y;
/*  345 */       i = 0;
/*      */ 
/*  347 */       while (p != e) {
/*  348 */         if (this.dirPath[i] != 0) p.incBalance(); else {
/*  349 */           p.decBalance();
/*      */         }
/*  351 */         p = this.dirPath[(i++)] != 0 ? p.right : p.left;
/*      */       }
/*      */ 
/*  354 */       if (y.balance() == -2) {
/*  355 */         Entry x = y.left;
/*      */ 
/*  357 */         if (x.balance() == -1) {
/*  358 */           w = x;
/*  359 */           if (x.succ()) {
/*  360 */             x.succ(false);
/*  361 */             y.pred(x);
/*      */           } else {
/*  363 */             y.left = x.right;
/*      */           }
/*  365 */           x.right = y;
/*  366 */           x.balance(0);
/*  367 */           y.balance(0);
/*      */         }
/*      */         else
/*      */         {
/*  372 */           w = x.right;
/*  373 */           x.right = w.left;
/*  374 */           w.left = x;
/*  375 */           y.left = w.right;
/*  376 */           w.right = y;
/*  377 */           if (w.balance() == -1) {
/*  378 */             x.balance(0);
/*  379 */             y.balance(1);
/*      */           }
/*  381 */           else if (w.balance() == 0) {
/*  382 */             x.balance(0);
/*  383 */             y.balance(0);
/*      */           }
/*      */           else {
/*  386 */             x.balance(-1);
/*  387 */             y.balance(0);
/*      */           }
/*  389 */           w.balance(0);
/*      */ 
/*  392 */           if (w.pred()) {
/*  393 */             x.succ(w);
/*  394 */             w.pred(false);
/*      */           }
/*  396 */           if (w.succ()) {
/*  397 */             y.pred(w);
/*  398 */             w.succ(false);
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*  403 */       else if (y.balance() == 2) {
/*  404 */         Entry x = y.right;
/*      */ 
/*  406 */         if (x.balance() == 1) {
/*  407 */           w = x;
/*  408 */           if (x.pred()) {
/*  409 */             x.pred(false);
/*  410 */             y.succ(x);
/*      */           } else {
/*  412 */             y.right = x.left;
/*      */           }
/*  414 */           x.left = y;
/*  415 */           x.balance(0);
/*  416 */           y.balance(0);
/*      */         }
/*      */         else
/*      */         {
/*  421 */           w = x.left;
/*  422 */           x.left = w.right;
/*  423 */           w.right = x;
/*  424 */           y.right = w.left;
/*  425 */           w.left = y;
/*  426 */           if (w.balance() == 1) {
/*  427 */             x.balance(0);
/*  428 */             y.balance(-1);
/*      */           }
/*  430 */           else if (w.balance() == 0) {
/*  431 */             x.balance(0);
/*  432 */             y.balance(0);
/*      */           }
/*      */           else {
/*  435 */             x.balance(1);
/*  436 */             y.balance(0);
/*      */           }
/*  438 */           w.balance(0);
/*      */ 
/*  441 */           if (w.pred()) {
/*  442 */             y.succ(w);
/*  443 */             w.pred(false);
/*      */           }
/*  445 */           if (w.succ()) {
/*  446 */             x.pred(w);
/*  447 */             w.succ(false);
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/*  452 */         return this.defRetValue;
/*      */       }
/*  454 */       if (z == null) this.tree = w;
/*  456 */       else if (z.left == y) z.left = w; else {
/*  457 */         z.right = w;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  462 */     return this.defRetValue;
/*      */   }
/*      */ 
/*      */   private Entry parent(Entry e)
/*      */   {
/*  472 */     if (e == this.tree) return null;
/*      */     Entry y;
/*  475 */     Entry x = y = e;
/*      */     while (true)
/*      */     {
/*  478 */       if (y.succ()) {
/*  479 */         Entry p = y.right;
/*  480 */         if ((p == null) || (p.left != e)) {
/*  481 */           while (!x.pred()) x = x.left;
/*  482 */           p = x.left;
/*      */         }
/*  484 */         return p;
/*      */       }
/*  486 */       if (x.pred()) {
/*  487 */         Entry p = x.left;
/*  488 */         if ((p == null) || (p.right != e)) {
/*  489 */           while (!y.succ()) y = y.right;
/*  490 */           p = y.right;
/*      */         }
/*  492 */         return p;
/*      */       }
/*      */ 
/*  495 */       x = x.left;
/*  496 */       y = y.right;
/*      */     }
/*      */   }
/*      */ 
/*      */   public short remove(long k)
/*      */   {
/*  506 */     this.modified = false;
/*      */ 
/*  508 */     if (this.tree == null) return this.defRetValue;
/*      */ 
/*  511 */     Entry p = this.tree; Entry q = null;
/*  512 */     boolean dir = false;
/*  513 */     long kk = k;
/*      */     int cmp;
/*  516 */     while ((cmp = compare(kk, p.key)) != 0) {
/*  517 */       if ((dir = cmp > 0 ? 1 : 0) != 0) {
/*  518 */         q = p;
/*  519 */         if ((p = p.right()) == null) return this.defRetValue; 
/*      */       }
/*      */       else
/*      */       {
/*  522 */         q = p;
/*  523 */         if ((p = p.left()) == null) return this.defRetValue;
/*      */       }
/*      */     }
/*      */ 
/*  527 */     if (p.left == null) this.firstEntry = p.next();
/*  528 */     if (p.right == null) this.lastEntry = p.prev();
/*      */ 
/*  530 */     if (p.succ()) {
/*  531 */       if (p.pred()) {
/*  532 */         if (q != null) {
/*  533 */           if (dir) q.succ(p.right); else
/*  534 */             q.pred(p.left);
/*      */         }
/*  536 */         else this.tree = (dir ? p.right : p.left); 
/*      */       }
/*      */       else
/*      */       {
/*  539 */         p.prev().right = p.right;
/*      */ 
/*  541 */         if (q != null) {
/*  542 */           if (dir) q.right = p.left; else
/*  543 */             q.left = p.left;
/*      */         }
/*  545 */         else this.tree = p.left; 
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  549 */       Entry r = p.right;
/*      */ 
/*  551 */       if (r.pred()) {
/*  552 */         r.left = p.left;
/*  553 */         r.pred(p.pred());
/*  554 */         if (!r.pred()) r.prev().right = r;
/*  555 */         if (q != null) {
/*  556 */           if (dir) q.right = r; else
/*  557 */             q.left = r;
/*      */         }
/*  559 */         else this.tree = r;
/*      */ 
/*  561 */         r.balance(p.balance());
/*  562 */         q = r;
/*  563 */         dir = true;
/*      */       }
/*      */       else
/*      */       {
/*      */         Entry s;
/*      */         while (true)
/*      */         {
/*  570 */           s = r.left;
/*  571 */           if (s.pred()) break;
/*  572 */           r = s;
/*      */         }
/*      */ 
/*  575 */         if (s.succ()) r.pred(s); else {
/*  576 */           r.left = s.right;
/*      */         }
/*  578 */         s.left = p.left;
/*      */ 
/*  580 */         if (!p.pred()) {
/*  581 */           p.prev().right = s;
/*  582 */           s.pred(false);
/*      */         }
/*      */ 
/*  585 */         s.right = p.right;
/*  586 */         s.succ(false);
/*      */ 
/*  588 */         if (q != null) {
/*  589 */           if (dir) q.right = s; else
/*  590 */             q.left = s;
/*      */         }
/*  592 */         else this.tree = s;
/*      */ 
/*  594 */         s.balance(p.balance());
/*  595 */         q = r;
/*  596 */         dir = false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  602 */     while (q != null) {
/*  603 */       Entry y = q;
/*  604 */       q = parent(y);
/*      */ 
/*  606 */       if (!dir) {
/*  607 */         dir = (q != null) && (q.left != y);
/*  608 */         y.incBalance();
/*      */ 
/*  610 */         if (y.balance() == 1) break;
/*  611 */         if (y.balance() == 2)
/*      */         {
/*  613 */           Entry x = y.right;
/*      */ 
/*  616 */           if (x.balance() == -1)
/*      */           {
/*  621 */             Entry w = x.left;
/*  622 */             x.left = w.right;
/*  623 */             w.right = x;
/*  624 */             y.right = w.left;
/*  625 */             w.left = y;
/*      */ 
/*  627 */             if (w.balance() == 1) {
/*  628 */               x.balance(0);
/*  629 */               y.balance(-1);
/*      */             }
/*  631 */             else if (w.balance() == 0) {
/*  632 */               x.balance(0);
/*  633 */               y.balance(0);
/*      */             }
/*      */             else
/*      */             {
/*  638 */               x.balance(1);
/*  639 */               y.balance(0);
/*      */             }
/*      */ 
/*  642 */             w.balance(0);
/*      */ 
/*  644 */             if (w.pred()) {
/*  645 */               y.succ(w);
/*  646 */               w.pred(false);
/*      */             }
/*  648 */             if (w.succ()) {
/*  649 */               x.pred(w);
/*  650 */               w.succ(false);
/*      */             }
/*      */ 
/*  653 */             if (q != null) {
/*  654 */               if (dir) q.right = w; else
/*  655 */                 q.left = w;
/*      */             }
/*  657 */             else this.tree = w; 
/*      */           }
/*      */           else
/*      */           {
/*  660 */             if (q != null) {
/*  661 */               if (dir) q.right = x; else
/*  662 */                 q.left = x;
/*      */             }
/*  664 */             else this.tree = x;
/*      */ 
/*  666 */             if (x.balance() == 0) {
/*  667 */               y.right = x.left;
/*  668 */               x.left = y;
/*  669 */               x.balance(-1);
/*  670 */               y.balance(1);
/*  671 */               break;
/*      */             }
/*      */ 
/*  675 */             if (x.pred()) {
/*  676 */               y.succ(true);
/*  677 */               x.pred(false);
/*      */             } else {
/*  679 */               y.right = x.left;
/*      */             }
/*  681 */             x.left = y;
/*  682 */             y.balance(0);
/*  683 */             x.balance(0);
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/*  688 */         dir = (q != null) && (q.left != y);
/*  689 */         y.decBalance();
/*      */ 
/*  691 */         if (y.balance() == -1) break;
/*  692 */         if (y.balance() == -2)
/*      */         {
/*  694 */           Entry x = y.left;
/*      */ 
/*  697 */           if (x.balance() == 1)
/*      */           {
/*  702 */             Entry w = x.right;
/*  703 */             x.right = w.left;
/*  704 */             w.left = x;
/*  705 */             y.left = w.right;
/*  706 */             w.right = y;
/*      */ 
/*  708 */             if (w.balance() == -1) {
/*  709 */               x.balance(0);
/*  710 */               y.balance(1);
/*      */             }
/*  712 */             else if (w.balance() == 0) {
/*  713 */               x.balance(0);
/*  714 */               y.balance(0);
/*      */             }
/*      */             else
/*      */             {
/*  719 */               x.balance(-1);
/*  720 */               y.balance(0);
/*      */             }
/*      */ 
/*  723 */             w.balance(0);
/*      */ 
/*  725 */             if (w.pred()) {
/*  726 */               x.succ(w);
/*  727 */               w.pred(false);
/*      */             }
/*  729 */             if (w.succ()) {
/*  730 */               y.pred(w);
/*  731 */               w.succ(false);
/*      */             }
/*      */ 
/*  734 */             if (q != null) {
/*  735 */               if (dir) q.right = w; else
/*  736 */                 q.left = w;
/*      */             }
/*  738 */             else this.tree = w; 
/*      */           }
/*      */           else
/*      */           {
/*  741 */             if (q != null) {
/*  742 */               if (dir) q.right = x; else
/*  743 */                 q.left = x;
/*      */             }
/*  745 */             else this.tree = x;
/*      */ 
/*  747 */             if (x.balance() == 0) {
/*  748 */               y.left = x.right;
/*  749 */               x.right = y;
/*  750 */               x.balance(1);
/*  751 */               y.balance(-1);
/*  752 */               break;
/*      */             }
/*      */ 
/*  756 */             if (x.succ()) {
/*  757 */               y.pred(true);
/*  758 */               x.succ(false);
/*      */             } else {
/*  760 */               y.left = x.right;
/*      */             }
/*  762 */             x.right = y;
/*  763 */             y.balance(0);
/*  764 */             x.balance(0);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  770 */     this.modified = true;
/*  771 */     this.count -= 1;
/*      */ 
/*  773 */     return p.value;
/*      */   }
/*      */ 
/*      */   public Short put(Long ok, Short ov)
/*      */   {
/*  779 */     short oldValue = put(ok.longValue(), ov.shortValue());
/*  780 */     return this.modified ? null : Short.valueOf(oldValue);
/*      */   }
/*      */ 
/*      */   public Short remove(Object ok)
/*      */   {
/*  788 */     short oldValue = remove(((Long)ok).longValue());
/*  789 */     return this.modified ? Short.valueOf(oldValue) : null;
/*      */   }
/*      */ 
/*      */   public boolean containsValue(short v)
/*      */   {
/*  795 */     ValueIterator i = new ValueIterator(null);
/*      */ 
/*  798 */     int j = this.count;
/*  799 */     while (j-- != 0) {
/*  800 */       short ev = i.nextShort();
/*  801 */       if (ev == v) return true;
/*      */     }
/*      */ 
/*  804 */     return false;
/*      */   }
/*      */ 
/*      */   public void clear() {
/*  808 */     this.count = 0;
/*  809 */     this.tree = null;
/*  810 */     this.entries = null;
/*  811 */     this.values = null;
/*  812 */     this.keys = null;
/*  813 */     this.firstEntry = (this.lastEntry = null);
/*      */   }
/*      */ 
/*      */   public boolean containsKey(long k)
/*      */   {
/* 1087 */     return findKey(k) != null;
/*      */   }
/*      */ 
/*      */   public int size() {
/* 1091 */     return this.count;
/*      */   }
/*      */ 
/*      */   public boolean isEmpty() {
/* 1095 */     return this.count == 0;
/*      */   }
/*      */ 
/*      */   public short get(long k)
/*      */   {
/* 1101 */     Entry e = findKey(k);
/* 1102 */     return e == null ? this.defRetValue : e.value;
/*      */   }
/*      */   public long firstLongKey() {
/* 1105 */     if (this.tree == null) throw new NoSuchElementException();
/* 1106 */     return this.firstEntry.key;
/*      */   }
/*      */   public long lastLongKey() {
/* 1109 */     if (this.tree == null) throw new NoSuchElementException();
/* 1110 */     return this.lastEntry.key;
/*      */   }
/*      */ 
/*      */   public ObjectSortedSet<Long2ShortMap.Entry> long2ShortEntrySet()
/*      */   {
/* 1202 */     if (this.entries == null) this.entries = new AbstractObjectSortedSet() {
/* 1203 */         final Comparator<? super Long2ShortMap.Entry> comparator = new Comparator() {
/*      */           public int compare(Long2ShortMap.Entry x, Long2ShortMap.Entry y) {
/* 1205 */             return Long2ShortAVLTreeMap.this.storedComparator.compare(x.getKey(), y.getKey());
/*      */           }
/* 1203 */         };
/*      */ 
/*      */         public Comparator<? super Long2ShortMap.Entry> comparator()
/*      */         {
/* 1209 */           return this.comparator;
/*      */         }
/*      */         public ObjectBidirectionalIterator<Long2ShortMap.Entry> iterator() {
/* 1212 */           return new Long2ShortAVLTreeMap.EntryIterator(Long2ShortAVLTreeMap.this);
/*      */         }
/*      */         public ObjectBidirectionalIterator<Long2ShortMap.Entry> iterator(Long2ShortMap.Entry from) {
/* 1215 */           return new Long2ShortAVLTreeMap.EntryIterator(Long2ShortAVLTreeMap.this, ((Long)from.getKey()).longValue());
/*      */         }
/*      */ 
/*      */         public boolean contains(Object o) {
/* 1219 */           if (!(o instanceof Map.Entry)) return false;
/* 1220 */           Map.Entry e = (Map.Entry)o;
/* 1221 */           Long2ShortAVLTreeMap.Entry f = Long2ShortAVLTreeMap.this.findKey(((Long)e.getKey()).longValue());
/* 1222 */           return e.equals(f);
/*      */         }
/*      */ 
/*      */         public boolean remove(Object o) {
/* 1226 */           if (!(o instanceof Map.Entry)) return false;
/* 1227 */           Map.Entry e = (Map.Entry)o;
/* 1228 */           Long2ShortAVLTreeMap.Entry f = Long2ShortAVLTreeMap.this.findKey(((Long)e.getKey()).longValue());
/* 1229 */           if (f != null) Long2ShortAVLTreeMap.this.remove(f.key);
/* 1230 */           return f != null;
/*      */         }
/* 1232 */         public int size() { return Long2ShortAVLTreeMap.this.count; } 
/* 1233 */         public void clear() { Long2ShortAVLTreeMap.this.clear(); } 
/* 1234 */         public Long2ShortMap.Entry first() { return Long2ShortAVLTreeMap.this.firstEntry; } 
/* 1235 */         public Long2ShortMap.Entry last() { return Long2ShortAVLTreeMap.this.lastEntry; } 
/* 1236 */         public ObjectSortedSet<Long2ShortMap.Entry> subSet(Long2ShortMap.Entry from, Long2ShortMap.Entry to) { return Long2ShortAVLTreeMap.this.subMap((Long)from.getKey(), (Long)to.getKey()).long2ShortEntrySet(); } 
/* 1237 */         public ObjectSortedSet<Long2ShortMap.Entry> headSet(Long2ShortMap.Entry to) { return Long2ShortAVLTreeMap.this.headMap((Long)to.getKey()).long2ShortEntrySet(); } 
/* 1238 */         public ObjectSortedSet<Long2ShortMap.Entry> tailSet(Long2ShortMap.Entry from) { return Long2ShortAVLTreeMap.this.tailMap((Long)from.getKey()).long2ShortEntrySet(); }
/*      */       };
/* 1240 */     return this.entries;
/*      */   }
/*      */ 
/*      */   public LongSortedSet keySet()
/*      */   {
/* 1274 */     if (this.keys == null) this.keys = new KeySet(null);
/* 1275 */     return this.keys;
/*      */   }
/*      */ 
/*      */   public ShortCollection values()
/*      */   {
/* 1302 */     if (this.values == null) this.values = new AbstractShortCollection() {
/*      */         public ShortIterator iterator() {
/* 1304 */           return new Long2ShortAVLTreeMap.ValueIterator(Long2ShortAVLTreeMap.this, null);
/*      */         }
/*      */         public boolean contains(short k) {
/* 1307 */           return Long2ShortAVLTreeMap.this.containsValue(k);
/*      */         }
/*      */         public int size() {
/* 1310 */           return Long2ShortAVLTreeMap.this.count;
/*      */         }
/*      */         public void clear() {
/* 1313 */           Long2ShortAVLTreeMap.this.clear();
/*      */         }
/*      */       };
/* 1316 */     return this.values;
/*      */   }
/*      */   public LongComparator comparator() {
/* 1319 */     return this.actualComparator;
/*      */   }
/*      */   public Long2ShortSortedMap headMap(long to) {
/* 1322 */     return new Submap(0L, true, to, false);
/*      */   }
/*      */   public Long2ShortSortedMap tailMap(long from) {
/* 1325 */     return new Submap(from, false, 0L, true);
/*      */   }
/*      */   public Long2ShortSortedMap subMap(long from, long to) {
/* 1328 */     return new Submap(from, false, to, false);
/*      */   }
/*      */ 
/*      */   public Long2ShortAVLTreeMap clone()
/*      */   {
/*      */     Long2ShortAVLTreeMap c;
/*      */     try
/*      */     {
/* 1677 */       c = (Long2ShortAVLTreeMap)super.clone();
/*      */     }
/*      */     catch (CloneNotSupportedException cantHappen) {
/* 1680 */       throw new InternalError();
/*      */     }
/* 1682 */     c.keys = null;
/* 1683 */     c.values = null;
/* 1684 */     c.entries = null;
/* 1685 */     c.allocatePaths();
/* 1686 */     if (this.count != 0)
/*      */     {
/* 1688 */       Entry rp = new Entry(); Entry rq = new Entry();
/* 1689 */       Entry p = rp;
/* 1690 */       rp.left(this.tree);
/* 1691 */       Entry q = rq;
/* 1692 */       rq.pred(null);
/*      */       while (true) {
/* 1694 */         if (!p.pred()) {
/* 1695 */           Entry e = p.left.clone();
/* 1696 */           e.pred(q.left);
/* 1697 */           e.succ(q);
/* 1698 */           q.left(e);
/* 1699 */           p = p.left;
/* 1700 */           q = q.left;
/*      */         }
/*      */         else {
/* 1703 */           while (p.succ()) {
/* 1704 */             p = p.right;
/* 1705 */             if (p == null) {
/* 1706 */               q.right = null;
/* 1707 */               c.tree = rq.left;
/* 1708 */               c.firstEntry = c.tree;
/* 1709 */               while (c.firstEntry.left != null) c.firstEntry = c.firstEntry.left;
/* 1710 */               c.lastEntry = c.tree;
/* 1711 */               while (c.lastEntry.right != null) c.lastEntry = c.lastEntry.right;
/* 1712 */               return c;
/*      */             }
/* 1714 */             q = q.right;
/*      */           }
/* 1716 */           p = p.right;
/* 1717 */           q = q.right;
/*      */         }
/* 1719 */         if (!p.succ()) {
/* 1720 */           Entry e = p.right.clone();
/* 1721 */           e.succ(q.right);
/* 1722 */           e.pred(q);
/* 1723 */           q.right(e);
/*      */         }
/*      */       }
/*      */     }
/* 1727 */     return c;
/*      */   }
/*      */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 1730 */     int n = this.count;
/* 1731 */     EntryIterator i = new EntryIterator();
/*      */ 
/* 1733 */     s.defaultWriteObject();
/* 1734 */     while (n-- != 0) {
/* 1735 */       Entry e = i.nextEntry();
/* 1736 */       s.writeLong(e.key);
/* 1737 */       s.writeShort(e.value);
/*      */     }
/*      */   }
/*      */ 
/*      */   private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ)
/*      */     throws IOException, ClassNotFoundException
/*      */   {
/* 1749 */     if (n == 1) {
/* 1750 */       Entry top = new Entry(s.readLong(), s.readShort());
/* 1751 */       top.pred(pred);
/* 1752 */       top.succ(succ);
/* 1753 */       return top;
/*      */     }
/* 1755 */     if (n == 2)
/*      */     {
/* 1758 */       Entry top = new Entry(s.readLong(), s.readShort());
/* 1759 */       top.right(new Entry(s.readLong(), s.readShort()));
/* 1760 */       top.right.pred(top);
/* 1761 */       top.balance(1);
/* 1762 */       top.pred(pred);
/* 1763 */       top.right.succ(succ);
/* 1764 */       return top;
/*      */     }
/*      */ 
/* 1767 */     int rightN = n / 2; int leftN = n - rightN - 1;
/* 1768 */     Entry top = new Entry();
/* 1769 */     top.left(readTree(s, leftN, pred, top));
/* 1770 */     top.key = s.readLong();
/* 1771 */     top.value = s.readShort();
/* 1772 */     top.right(readTree(s, rightN, top, succ));
/* 1773 */     if (n == (n & -n)) top.balance(1);
/* 1774 */     return top;
/*      */   }
/*      */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 1777 */     s.defaultReadObject();
/*      */ 
/* 1780 */     setActualComparator();
/* 1781 */     allocatePaths();
/* 1782 */     if (this.count != 0) {
/* 1783 */       this.tree = readTree(s, this.count, null, null);
/*      */ 
/* 1785 */       Entry e = this.tree;
/* 1786 */       while (e.left() != null) e = e.left();
/* 1787 */       this.firstEntry = e;
/* 1788 */       e = this.tree;
/* 1789 */       while (e.right() != null) e = e.right();
/* 1790 */       this.lastEntry = e;
/*      */     }
/*      */   }
/*      */ 
/*      */   private static int checkTree(Entry e) {
/* 1795 */     return 0;
/*      */   }
/*      */ 
/*      */   private final class Submap extends AbstractLong2ShortSortedMap
/*      */     implements Serializable
/*      */   {
/*      */     public static final long serialVersionUID = -7046029254386353129L;
/*      */     long from;
/*      */     long to;
/*      */     boolean bottom;
/*      */     boolean top;
/*      */     protected volatile transient ObjectSortedSet<Long2ShortMap.Entry> entries;
/*      */     protected volatile transient LongSortedSet keys;
/*      */     protected volatile transient ShortCollection values;
/*      */ 
/*      */     public Submap(long from, boolean bottom, long to, boolean top)
/*      */     {
/* 1366 */       if ((!bottom) && (!top) && (Long2ShortAVLTreeMap.this.compare(from, to) > 0)) throw new IllegalArgumentException(new StringBuilder().append("Start key (").append(from).append(") is larger than end key (").append(to).append(")").toString());
/* 1367 */       this.from = from;
/* 1368 */       this.bottom = bottom;
/* 1369 */       this.to = to;
/* 1370 */       this.top = top;
/* 1371 */       this.defRetValue = Long2ShortAVLTreeMap.this.defRetValue;
/*      */     }
/*      */     public void clear() {
/* 1374 */       SubmapIterator i = new SubmapIterator();
/* 1375 */       while (i.hasNext()) {
/* 1376 */         i.nextEntry();
/* 1377 */         i.remove();
/*      */       }
/*      */     }
/*      */ 
/*      */     final boolean in(long k)
/*      */     {
/* 1385 */       return ((this.bottom) || (Long2ShortAVLTreeMap.this.compare(k, this.from) >= 0)) && ((this.top) || (Long2ShortAVLTreeMap.this.compare(k, this.to) < 0));
/*      */     }
/*      */ 
/*      */     public ObjectSortedSet<Long2ShortMap.Entry> long2ShortEntrySet() {
/* 1389 */       if (this.entries == null) this.entries = new AbstractObjectSortedSet() {
/*      */           public ObjectBidirectionalIterator<Long2ShortMap.Entry> iterator() {
/* 1391 */             return new Long2ShortAVLTreeMap.Submap.SubmapEntryIterator(Long2ShortAVLTreeMap.Submap.this);
/*      */           }
/*      */           public ObjectBidirectionalIterator<Long2ShortMap.Entry> iterator(Long2ShortMap.Entry from) {
/* 1394 */             return new Long2ShortAVLTreeMap.Submap.SubmapEntryIterator(Long2ShortAVLTreeMap.Submap.this, ((Long)from.getKey()).longValue());
/*      */           }
/* 1396 */           public Comparator<? super Long2ShortMap.Entry> comparator() { return Long2ShortAVLTreeMap.this.entrySet().comparator(); }
/*      */ 
/*      */           public boolean contains(Object o) {
/* 1399 */             if (!(o instanceof Map.Entry)) return false;
/* 1400 */             Map.Entry e = (Map.Entry)o;
/* 1401 */             Long2ShortAVLTreeMap.Entry f = Long2ShortAVLTreeMap.this.findKey(((Long)e.getKey()).longValue());
/* 1402 */             return (f != null) && (Long2ShortAVLTreeMap.Submap.this.in(f.key)) && (e.equals(f));
/*      */           }
/*      */ 
/*      */           public boolean remove(Object o) {
/* 1406 */             if (!(o instanceof Map.Entry)) return false;
/* 1407 */             Map.Entry e = (Map.Entry)o;
/* 1408 */             Long2ShortAVLTreeMap.Entry f = Long2ShortAVLTreeMap.this.findKey(((Long)e.getKey()).longValue());
/* 1409 */             if ((f != null) && (Long2ShortAVLTreeMap.Submap.this.in(f.key))) Long2ShortAVLTreeMap.Submap.this.remove(f.key);
/* 1410 */             return f != null;
/*      */           }
/*      */           public int size() {
/* 1413 */             int c = 0;
/* 1414 */             for (Iterator i = iterator(); i.hasNext(); i.next()) c++;
/* 1415 */             return c;
/*      */           }
/*      */           public boolean isEmpty() {
/* 1418 */             return !new Long2ShortAVLTreeMap.Submap.SubmapIterator(Long2ShortAVLTreeMap.Submap.this).hasNext();
/*      */           }
/*      */           public void clear() {
/* 1421 */             Long2ShortAVLTreeMap.Submap.this.clear();
/*      */           }
/* 1423 */           public Long2ShortMap.Entry first() { return Long2ShortAVLTreeMap.Submap.this.firstEntry(); } 
/* 1424 */           public Long2ShortMap.Entry last() { return Long2ShortAVLTreeMap.Submap.this.lastEntry(); } 
/* 1425 */           public ObjectSortedSet<Long2ShortMap.Entry> subSet(Long2ShortMap.Entry from, Long2ShortMap.Entry to) { return Long2ShortAVLTreeMap.Submap.this.subMap((Long)from.getKey(), (Long)to.getKey()).long2ShortEntrySet(); } 
/* 1426 */           public ObjectSortedSet<Long2ShortMap.Entry> headSet(Long2ShortMap.Entry to) { return Long2ShortAVLTreeMap.Submap.this.headMap((Long)to.getKey()).long2ShortEntrySet(); } 
/* 1427 */           public ObjectSortedSet<Long2ShortMap.Entry> tailSet(Long2ShortMap.Entry from) { return Long2ShortAVLTreeMap.Submap.this.tailMap((Long)from.getKey()).long2ShortEntrySet(); }
/*      */         };
/* 1429 */       return this.entries;
/*      */     }
/*      */ 
/*      */     public LongSortedSet keySet()
/*      */     {
/* 1436 */       if (this.keys == null) this.keys = new KeySet(null);
/* 1437 */       return this.keys;
/*      */     }
/*      */     public ShortCollection values() {
/* 1440 */       if (this.values == null) this.values = new AbstractShortCollection() {
/*      */           public ShortIterator iterator() {
/* 1442 */             return new Long2ShortAVLTreeMap.Submap.SubmapValueIterator(Long2ShortAVLTreeMap.Submap.this, null);
/*      */           }
/*      */           public boolean contains(short k) {
/* 1445 */             return Long2ShortAVLTreeMap.Submap.this.containsValue(k);
/*      */           }
/*      */           public int size() {
/* 1448 */             return Long2ShortAVLTreeMap.Submap.this.size();
/*      */           }
/*      */           public void clear() {
/* 1451 */             Long2ShortAVLTreeMap.Submap.this.clear();
/*      */           }
/*      */         };
/* 1454 */       return this.values;
/*      */     }
/*      */ 
/*      */     public boolean containsKey(long k) {
/* 1458 */       return (in(k)) && (Long2ShortAVLTreeMap.this.containsKey(k));
/*      */     }
/*      */     public boolean containsValue(short v) {
/* 1461 */       SubmapIterator i = new SubmapIterator();
/*      */ 
/* 1463 */       while (i.hasNext()) {
/* 1464 */         short ev = i.nextEntry().value;
/* 1465 */         if (ev == v) return true;
/*      */       }
/* 1467 */       return false;
/*      */     }
/*      */ 
/*      */     public short get(long k)
/*      */     {
/* 1472 */       long kk = k;
/*      */       Long2ShortAVLTreeMap.Entry e;
/* 1473 */       return (in(kk)) && ((e = Long2ShortAVLTreeMap.this.findKey(kk)) != null) ? e.value : this.defRetValue;
/*      */     }
/*      */     public short put(long k, short v) {
/* 1476 */       Long2ShortAVLTreeMap.this.modified = false;
/* 1477 */       if (!in(k)) throw new IllegalArgumentException(new StringBuilder().append("Key (").append(k).append(") out of range [").append(this.bottom ? "-" : String.valueOf(this.from)).append(", ").append(this.top ? "-" : String.valueOf(this.to)).append(")").toString());
/* 1478 */       short oldValue = Long2ShortAVLTreeMap.this.put(k, v);
/* 1479 */       return Long2ShortAVLTreeMap.this.modified ? this.defRetValue : oldValue;
/*      */     }
/*      */     public Short put(Long ok, Short ov) {
/* 1482 */       short oldValue = put(ok.longValue(), ov.shortValue());
/* 1483 */       return Long2ShortAVLTreeMap.this.modified ? null : Short.valueOf(oldValue);
/*      */     }
/*      */ 
/*      */     public short remove(long k) {
/* 1487 */       Long2ShortAVLTreeMap.this.modified = false;
/* 1488 */       if (!in(k)) return this.defRetValue;
/* 1489 */       short oldValue = Long2ShortAVLTreeMap.this.remove(k);
/* 1490 */       return Long2ShortAVLTreeMap.this.modified ? oldValue : this.defRetValue;
/*      */     }
/*      */     public Short remove(Object ok) {
/* 1493 */       short oldValue = remove(((Long)ok).longValue());
/* 1494 */       return Long2ShortAVLTreeMap.this.modified ? Short.valueOf(oldValue) : null;
/*      */     }
/*      */     public int size() {
/* 1497 */       SubmapIterator i = new SubmapIterator();
/* 1498 */       int n = 0;
/* 1499 */       while (i.hasNext()) {
/* 1500 */         n++;
/* 1501 */         i.nextEntry();
/*      */       }
/* 1503 */       return n;
/*      */     }
/*      */     public boolean isEmpty() {
/* 1506 */       return !new SubmapIterator().hasNext();
/*      */     }
/*      */     public LongComparator comparator() {
/* 1509 */       return Long2ShortAVLTreeMap.this.actualComparator;
/*      */     }
/*      */     public Long2ShortSortedMap headMap(long to) {
/* 1512 */       if (this.top) return new Submap(Long2ShortAVLTreeMap.this, this.from, this.bottom, to, false);
/* 1513 */       return Long2ShortAVLTreeMap.this.compare(to, this.to) < 0 ? new Submap(Long2ShortAVLTreeMap.this, this.from, this.bottom, to, false) : this;
/*      */     }
/*      */     public Long2ShortSortedMap tailMap(long from) {
/* 1516 */       if (this.bottom) return new Submap(Long2ShortAVLTreeMap.this, from, false, this.to, this.top);
/* 1517 */       return Long2ShortAVLTreeMap.this.compare(from, this.from) > 0 ? new Submap(Long2ShortAVLTreeMap.this, from, false, this.to, this.top) : this;
/*      */     }
/*      */     public Long2ShortSortedMap subMap(long from, long to) {
/* 1520 */       if ((this.top) && (this.bottom)) return new Submap(Long2ShortAVLTreeMap.this, from, false, to, false);
/* 1521 */       if (!this.top) to = Long2ShortAVLTreeMap.this.compare(to, this.to) < 0 ? to : this.to;
/* 1522 */       if (!this.bottom) from = Long2ShortAVLTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
/* 1523 */       if ((!this.top) && (!this.bottom) && (from == this.from) && (to == this.to)) return this;
/* 1524 */       return new Submap(Long2ShortAVLTreeMap.this, from, false, to, false);
/*      */     }
/*      */ 
/*      */     public Long2ShortAVLTreeMap.Entry firstEntry()
/*      */     {
/* 1531 */       if (Long2ShortAVLTreeMap.this.tree == null) return null;
/* 1534 */       Long2ShortAVLTreeMap.Entry e;
/*      */       Long2ShortAVLTreeMap.Entry e;
/* 1534 */       if (this.bottom) { e = Long2ShortAVLTreeMap.this.firstEntry;
/*      */       } else {
/* 1536 */         e = Long2ShortAVLTreeMap.this.locateKey(this.from);
/*      */ 
/* 1538 */         if (Long2ShortAVLTreeMap.this.compare(e.key, this.from) < 0) e = e.next();
/*      */       }
/*      */ 
/* 1541 */       if ((e == null) || ((!this.top) && (Long2ShortAVLTreeMap.this.compare(e.key, this.to) >= 0))) return null;
/* 1542 */       return e;
/*      */     }
/*      */ 
/*      */     public Long2ShortAVLTreeMap.Entry lastEntry()
/*      */     {
/* 1549 */       if (Long2ShortAVLTreeMap.this.tree == null) return null;
/* 1552 */       Long2ShortAVLTreeMap.Entry e;
/*      */       Long2ShortAVLTreeMap.Entry e;
/* 1552 */       if (this.top) { e = Long2ShortAVLTreeMap.this.lastEntry;
/*      */       } else {
/* 1554 */         e = Long2ShortAVLTreeMap.this.locateKey(this.to);
/*      */ 
/* 1556 */         if (Long2ShortAVLTreeMap.this.compare(e.key, this.to) >= 0) e = e.prev();
/*      */       }
/*      */ 
/* 1559 */       if ((e == null) || ((!this.bottom) && (Long2ShortAVLTreeMap.this.compare(e.key, this.from) < 0))) return null;
/* 1560 */       return e;
/*      */     }
/*      */     public long firstLongKey() {
/* 1563 */       Long2ShortAVLTreeMap.Entry e = firstEntry();
/* 1564 */       if (e == null) throw new NoSuchElementException();
/* 1565 */       return e.key;
/*      */     }
/*      */     public long lastLongKey() {
/* 1568 */       Long2ShortAVLTreeMap.Entry e = lastEntry();
/* 1569 */       if (e == null) throw new NoSuchElementException();
/* 1570 */       return e.key;
/*      */     }
/*      */     public Long firstKey() {
/* 1573 */       Long2ShortAVLTreeMap.Entry e = firstEntry();
/* 1574 */       if (e == null) throw new NoSuchElementException();
/* 1575 */       return e.getKey();
/*      */     }
/*      */     public Long lastKey() {
/* 1578 */       Long2ShortAVLTreeMap.Entry e = lastEntry();
/* 1579 */       if (e == null) throw new NoSuchElementException();
/* 1580 */       return e.getKey();
/*      */     }
/*      */ 
/*      */     private final class SubmapValueIterator extends Long2ShortAVLTreeMap.Submap.SubmapIterator
/*      */       implements ShortListIterator
/*      */     {
/*      */       private SubmapValueIterator()
/*      */       {
/* 1655 */         super(); } 
/* 1656 */       public short nextShort() { return nextEntry().value; } 
/* 1657 */       public short previousShort() { return previousEntry().value; } 
/* 1658 */       public void set(short v) { throw new UnsupportedOperationException(); } 
/* 1659 */       public void add(short v) { throw new UnsupportedOperationException(); } 
/* 1660 */       public Short next() { return Short.valueOf(nextEntry().value); } 
/* 1661 */       public Short previous() { return Short.valueOf(previousEntry().value); } 
/* 1662 */       public void set(Short ok) { throw new UnsupportedOperationException(); } 
/* 1663 */       public void add(Short ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */     }
/*      */ 
/*      */     private final class SubmapKeyIterator extends Long2ShortAVLTreeMap.Submap.SubmapIterator
/*      */       implements LongListIterator
/*      */     {
/*      */       public SubmapKeyIterator()
/*      */       {
/* 1636 */         super(); } 
/* 1637 */       public SubmapKeyIterator(long from) { super(from); } 
/* 1638 */       public long nextLong() { return nextEntry().key; } 
/* 1639 */       public long previousLong() { return previousEntry().key; } 
/* 1640 */       public void set(long k) { throw new UnsupportedOperationException(); } 
/* 1641 */       public void add(long k) { throw new UnsupportedOperationException(); } 
/* 1642 */       public Long next() { return Long.valueOf(nextEntry().key); } 
/* 1643 */       public Long previous() { return Long.valueOf(previousEntry().key); } 
/* 1644 */       public void set(Long ok) { throw new UnsupportedOperationException(); } 
/* 1645 */       public void add(Long ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */     }
/*      */ 
/*      */     private class SubmapEntryIterator extends Long2ShortAVLTreeMap.Submap.SubmapIterator
/*      */       implements ObjectListIterator<Long2ShortMap.Entry>
/*      */     {
/*      */       SubmapEntryIterator()
/*      */       {
/* 1618 */         super();
/*      */       }
/* 1620 */       SubmapEntryIterator(long k) { super(k); } 
/*      */       public Long2ShortMap.Entry next() {
/* 1622 */         return nextEntry(); } 
/* 1623 */       public Long2ShortMap.Entry previous() { return previousEntry(); } 
/* 1624 */       public void set(Long2ShortMap.Entry ok) { throw new UnsupportedOperationException(); } 
/* 1625 */       public void add(Long2ShortMap.Entry ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */     }
/*      */ 
/*      */     private class SubmapIterator extends Long2ShortAVLTreeMap.TreeIterator
/*      */     {
/*      */       SubmapIterator()
/*      */       {
/* 1590 */         super();
/* 1591 */         this.next = Long2ShortAVLTreeMap.Submap.this.firstEntry();
/*      */       }
/*      */       SubmapIterator(long k) {
/* 1594 */         this();
/* 1595 */         if (this.next != null)
/* 1596 */           if ((!Long2ShortAVLTreeMap.Submap.this.bottom) && (Long2ShortAVLTreeMap.this.compare(k, this.next.key) < 0)) { this.prev = null;
/* 1597 */           } else if ((!Long2ShortAVLTreeMap.Submap.this.top) && (Long2ShortAVLTreeMap.this.compare(k, (this.prev = Long2ShortAVLTreeMap.Submap.this.lastEntry()).key) >= 0)) { this.next = null;
/*      */           } else {
/* 1599 */             this.next = Long2ShortAVLTreeMap.this.locateKey(k);
/* 1600 */             if (Long2ShortAVLTreeMap.this.compare(this.next.key, k) <= 0) {
/* 1601 */               this.prev = this.next;
/* 1602 */               this.next = this.next.next();
/*      */             } else {
/* 1604 */               this.prev = this.next.prev();
/*      */             }
/*      */           }
/*      */       }
/*      */ 
/* 1609 */       void updatePrevious() { this.prev = this.prev.prev();
/* 1610 */         if ((!Long2ShortAVLTreeMap.Submap.this.bottom) && (this.prev != null) && (Long2ShortAVLTreeMap.this.compare(this.prev.key, Long2ShortAVLTreeMap.Submap.this.from) < 0)) this.prev = null;  } 
/*      */       void updateNext()
/*      */       {
/* 1613 */         this.next = this.next.next();
/* 1614 */         if ((!Long2ShortAVLTreeMap.Submap.this.top) && (this.next != null) && (Long2ShortAVLTreeMap.this.compare(this.next.key, Long2ShortAVLTreeMap.Submap.this.to) >= 0)) this.next = null;
/*      */       }
/*      */     }
/*      */ 
/*      */     private class KeySet extends AbstractLong2ShortSortedMap.KeySet
/*      */     {
/*      */       private KeySet()
/*      */       {
/* 1431 */         super(); } 
/* 1432 */       public LongBidirectionalIterator iterator() { return new Long2ShortAVLTreeMap.Submap.SubmapKeyIterator(Long2ShortAVLTreeMap.Submap.this); } 
/* 1433 */       public LongBidirectionalIterator iterator(long from) { return new Long2ShortAVLTreeMap.Submap.SubmapKeyIterator(Long2ShortAVLTreeMap.Submap.this, from); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   private final class ValueIterator extends Long2ShortAVLTreeMap.TreeIterator
/*      */     implements ShortListIterator
/*      */   {
/*      */     private ValueIterator()
/*      */     {
/* 1283 */       super(); } 
/* 1284 */     public short nextShort() { return nextEntry().value; } 
/* 1285 */     public short previousShort() { return previousEntry().value; } 
/* 1286 */     public void set(short v) { throw new UnsupportedOperationException(); } 
/* 1287 */     public void add(short v) { throw new UnsupportedOperationException(); } 
/* 1288 */     public Short next() { return Short.valueOf(nextEntry().value); } 
/* 1289 */     public Short previous() { return Short.valueOf(previousEntry().value); } 
/* 1290 */     public void set(Short ok) { throw new UnsupportedOperationException(); } 
/* 1291 */     public void add(Short ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private class KeySet extends AbstractLong2ShortSortedMap.KeySet
/*      */   {
/*      */     private KeySet()
/*      */     {
/* 1261 */       super(); } 
/* 1262 */     public LongBidirectionalIterator iterator() { return new Long2ShortAVLTreeMap.KeyIterator(Long2ShortAVLTreeMap.this); } 
/* 1263 */     public LongBidirectionalIterator iterator(long from) { return new Long2ShortAVLTreeMap.KeyIterator(Long2ShortAVLTreeMap.this, from); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private final class KeyIterator extends Long2ShortAVLTreeMap.TreeIterator
/*      */     implements LongListIterator
/*      */   {
/*      */     public KeyIterator()
/*      */     {
/* 1249 */       super(); } 
/* 1250 */     public KeyIterator(long k) { super(k); } 
/* 1251 */     public long nextLong() { return nextEntry().key; } 
/* 1252 */     public long previousLong() { return previousEntry().key; } 
/* 1253 */     public void set(long k) { throw new UnsupportedOperationException(); } 
/* 1254 */     public void add(long k) { throw new UnsupportedOperationException(); } 
/* 1255 */     public Long next() { return Long.valueOf(nextEntry().key); } 
/* 1256 */     public Long previous() { return Long.valueOf(previousEntry().key); } 
/* 1257 */     public void set(Long ok) { throw new UnsupportedOperationException(); } 
/* 1258 */     public void add(Long ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private class EntryIterator extends Long2ShortAVLTreeMap.TreeIterator
/*      */     implements ObjectListIterator<Long2ShortMap.Entry>
/*      */   {
/*      */     EntryIterator()
/*      */     {
/* 1192 */       super();
/*      */     }
/* 1194 */     EntryIterator(long k) { super(k); } 
/*      */     public Long2ShortMap.Entry next() {
/* 1196 */       return nextEntry(); } 
/* 1197 */     public Long2ShortMap.Entry previous() { return previousEntry(); } 
/* 1198 */     public void set(Long2ShortMap.Entry ok) { throw new UnsupportedOperationException(); } 
/* 1199 */     public void add(Long2ShortMap.Entry ok) { throw new UnsupportedOperationException(); }
/*      */ 
/*      */   }
/*      */ 
/*      */   private class TreeIterator
/*      */   {
/*      */     Long2ShortAVLTreeMap.Entry prev;
/*      */     Long2ShortAVLTreeMap.Entry next;
/*      */     Long2ShortAVLTreeMap.Entry curr;
/* 1124 */     int index = 0;
/*      */ 
/* 1126 */     TreeIterator() { this.next = Long2ShortAVLTreeMap.this.firstEntry; }
/*      */ 
/*      */     TreeIterator(long k) {
/* 1129 */       if ((this.next = Long2ShortAVLTreeMap.this.locateKey(k)) != null)
/* 1130 */         if (Long2ShortAVLTreeMap.this.compare(this.next.key, k) <= 0) {
/* 1131 */           this.prev = this.next;
/* 1132 */           this.next = this.next.next();
/*      */         } else {
/* 1134 */           this.prev = this.next.prev(); }  
/*      */     }
/*      */ 
/* 1137 */     public boolean hasNext() { return this.next != null; } 
/* 1138 */     public boolean hasPrevious() { return this.prev != null; } 
/*      */     void updateNext() {
/* 1140 */       this.next = this.next.next();
/*      */     }
/*      */     Long2ShortAVLTreeMap.Entry nextEntry() {
/* 1143 */       if (!hasNext()) throw new NoSuchElementException();
/* 1144 */       this.curr = (this.prev = this.next);
/* 1145 */       this.index += 1;
/* 1146 */       updateNext();
/* 1147 */       return this.curr;
/*      */     }
/*      */     void updatePrevious() {
/* 1150 */       this.prev = this.prev.prev();
/*      */     }
/*      */     Long2ShortAVLTreeMap.Entry previousEntry() {
/* 1153 */       if (!hasPrevious()) throw new NoSuchElementException();
/* 1154 */       this.curr = (this.next = this.prev);
/* 1155 */       this.index -= 1;
/* 1156 */       updatePrevious();
/* 1157 */       return this.curr;
/*      */     }
/*      */     public int nextIndex() {
/* 1160 */       return this.index;
/*      */     }
/*      */     public int previousIndex() {
/* 1163 */       return this.index - 1;
/*      */     }
/*      */     public void remove() {
/* 1166 */       if (this.curr == null) throw new IllegalStateException();
/*      */ 
/* 1169 */       if (this.curr == this.prev) this.index -= 1;
/* 1170 */       this.next = (this.prev = this.curr);
/* 1171 */       updatePrevious();
/* 1172 */       updateNext();
/* 1173 */       Long2ShortAVLTreeMap.this.remove(this.curr.key);
/* 1174 */       this.curr = null;
/*      */     }
/*      */     public int skip(int n) {
/* 1177 */       int i = n;
/* 1178 */       while ((i-- != 0) && (hasNext())) nextEntry();
/* 1179 */       return n - i - 1;
/*      */     }
/*      */     public int back(int n) {
/* 1182 */       int i = n;
/* 1183 */       while ((i-- != 0) && (hasPrevious())) previousEntry();
/* 1184 */       return n - i - 1;
/*      */     }
/*      */   }
/*      */ 
/*      */   private static final class Entry
/*      */     implements Cloneable, Long2ShortMap.Entry
/*      */   {
/*      */     private static final int SUCC_MASK = -2147483648;
/*      */     private static final int PRED_MASK = 1073741824;
/*      */     private static final int BALANCE_MASK = 255;
/*      */     long key;
/*      */     short value;
/*      */     Entry left;
/*      */     Entry right;
/*      */     int info;
/*      */ 
/*      */     Entry()
/*      */     {
/*      */     }
/*      */ 
/*      */     Entry(long k, short v)
/*      */     {
/*  850 */       this.key = k;
/*  851 */       this.value = v;
/*  852 */       this.info = -1073741824;
/*      */     }
/*      */ 
/*      */     Entry left()
/*      */     {
/*  861 */       return (this.info & 0x40000000) != 0 ? null : this.left;
/*      */     }
/*      */ 
/*      */     Entry right()
/*      */     {
/*  870 */       return (this.info & 0x80000000) != 0 ? null : this.right;
/*      */     }
/*      */ 
/*      */     boolean pred()
/*      */     {
/*  877 */       return (this.info & 0x40000000) != 0;
/*      */     }
/*      */ 
/*      */     boolean succ()
/*      */     {
/*  884 */       return (this.info & 0x80000000) != 0;
/*      */     }
/*      */ 
/*      */     void pred(boolean pred)
/*      */     {
/*  891 */       if (pred) this.info |= 1073741824; else
/*  892 */         this.info &= -1073741825;
/*      */     }
/*      */ 
/*      */     void succ(boolean succ)
/*      */     {
/*  899 */       if (succ) this.info |= -2147483648; else
/*  900 */         this.info &= 2147483647;
/*      */     }
/*      */ 
/*      */     void pred(Entry pred)
/*      */     {
/*  907 */       this.info |= 1073741824;
/*  908 */       this.left = pred;
/*      */     }
/*      */ 
/*      */     void succ(Entry succ)
/*      */     {
/*  915 */       this.info |= -2147483648;
/*  916 */       this.right = succ;
/*      */     }
/*      */ 
/*      */     void left(Entry left)
/*      */     {
/*  923 */       this.info &= -1073741825;
/*  924 */       this.left = left;
/*      */     }
/*      */ 
/*      */     void right(Entry right)
/*      */     {
/*  931 */       this.info &= 2147483647;
/*  932 */       this.right = right;
/*      */     }
/*      */ 
/*      */     int balance()
/*      */     {
/*  939 */       return (byte)this.info;
/*      */     }
/*      */ 
/*      */     void balance(int level)
/*      */     {
/*  946 */       this.info &= -256;
/*  947 */       this.info |= level & 0xFF;
/*      */     }
/*      */ 
/*      */     void incBalance()
/*      */     {
/*  952 */       this.info = (this.info & 0xFFFFFF00 | (byte)this.info + 1 & 0xFF);
/*      */     }
/*      */ 
/*      */     protected void decBalance()
/*      */     {
/*  957 */       this.info = (this.info & 0xFFFFFF00 | (byte)this.info - 1 & 0xFF);
/*      */     }
/*      */ 
/*      */     Entry next()
/*      */     {
/*  966 */       Entry next = this.right;
/*  967 */       for ((this.info & 0x80000000) != 0; (next.info & 0x40000000) == 0; next = next.left);
/*  968 */       return next;
/*      */     }
/*      */ 
/*      */     Entry prev()
/*      */     {
/*  977 */       Entry prev = this.left;
/*  978 */       for ((this.info & 0x40000000) != 0; (prev.info & 0x80000000) == 0; prev = prev.right);
/*  979 */       return prev;
/*      */     }
/*      */ 
/*      */     public Long getKey() {
/*  983 */       return Long.valueOf(this.key);
/*      */     }
/*      */ 
/*      */     public long getLongKey()
/*      */     {
/*  988 */       return this.key;
/*      */     }
/*      */ 
/*      */     public Short getValue()
/*      */     {
/*  993 */       return Short.valueOf(this.value);
/*      */     }
/*      */ 
/*      */     public short getShortValue()
/*      */     {
/*  998 */       return this.value;
/*      */     }
/*      */ 
/*      */     public short setValue(short value)
/*      */     {
/* 1003 */       short oldValue = this.value;
/* 1004 */       this.value = value;
/* 1005 */       return oldValue;
/*      */     }
/*      */ 
/*      */     public Short setValue(Short value)
/*      */     {
/* 1011 */       return Short.valueOf(setValue(value.shortValue()));
/*      */     }
/*      */ 
/*      */     public Entry clone()
/*      */     {
/*      */       Entry c;
/*      */       try
/*      */       {
/* 1020 */         c = (Entry)super.clone();
/*      */       }
/*      */       catch (CloneNotSupportedException cantHappen) {
/* 1023 */         throw new InternalError();
/*      */       }
/*      */ 
/* 1026 */       c.key = this.key;
/* 1027 */       c.value = this.value;
/* 1028 */       c.info = this.info;
/*      */ 
/* 1030 */       return c;
/*      */     }
/*      */ 
/*      */     public boolean equals(Object o)
/*      */     {
/* 1035 */       if (!(o instanceof Map.Entry)) return false;
/* 1036 */       Map.Entry e = (Map.Entry)o;
/*      */ 
/* 1038 */       return (this.key == ((Long)e.getKey()).longValue()) && (this.value == ((Short)e.getValue()).shortValue());
/*      */     }
/*      */ 
/*      */     public int hashCode() {
/* 1042 */       return HashCommon.long2int(this.key) ^ this.value;
/*      */     }
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1047 */       return this.key + "=>" + this.value;
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.longs.Long2ShortAVLTreeMap
 * JD-Core Version:    0.6.2
 */