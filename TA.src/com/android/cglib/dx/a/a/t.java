package com.android.cglib.dx.a.a;

import com.android.cglib.dx.a.b;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.b.o;
import com.android.cglib.dx.c.b.s;
import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.c;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public final class t
{
  private final b a;
  private final int b;
  private ArrayList<h> c;
  private boolean d;
  private boolean e;
  private int f;

  public t(b paramb, int paramInt1, int paramInt2)
  {
    this.a = paramb;
    this.b = paramInt2;
    this.c = new ArrayList(paramInt1);
    this.f = -1;
    this.d = false;
    this.e = false;
  }

  private j a(h paramh, j paramj)
  {
    while (paramj != null)
    {
      if (paramj.c().b(paramh))
        return paramj;
      paramj = k.a(paramj, this.a);
    }
    return paramj;
  }

  private static void a(f paramf, g.a parama)
  {
    a locala = paramf.b();
    int i = parama.a(locala);
    if (i >= 0)
      paramf.a(i);
    if ((locala instanceof com.android.cglib.dx.c.c.r))
    {
      int j = parama.a(((com.android.cglib.dx.c.c.r)locala).g());
      if (j >= 0)
        paramf.b(j);
    }
  }

  private static void a(HashSet<a> paramHashSet, h paramh)
  {
    if ((paramh instanceof f))
    {
      paramHashSet.add(((f)paramh).b());
      return;
    }
    if ((paramh instanceof q))
    {
      o localo = ((q)paramh).b();
      int i = localo.b();
      for (int j = 0; j < i; j++)
        a(paramHashSet, localo.a(j));
    }
    if ((paramh instanceof r))
      a(paramHashSet, ((r)paramh).b());
  }

  private static void a(HashSet<a> paramHashSet, m paramm)
  {
    if (paramm == null)
      return;
    com.android.cglib.dx.c.b.h localh = paramm.g();
    v localv1 = localh.a();
    v localv2 = localh.b();
    c localc = paramm.b();
    if (localc != c.j)
      paramHashSet.add(w.a(localc));
    if (localv1 != null)
      paramHashSet.add(localv1);
    if (localv2 != null)
      paramHashSet.add(localv2);
  }

  private void a(j[] paramArrayOfj)
  {
    if (this.f < 0)
      i = 0;
    int j;
    for (int i = this.f; ; i = j)
    {
      j = b(paramArrayOfj);
      if (i >= j)
      {
        this.f = i;
        return;
      }
      int k = j - i;
      int m = this.c.size();
      for (int n = 0; n < m; n++)
      {
        h localh = (h)this.c.get(n);
        if (!(localh instanceof e))
          this.c.set(n, localh.d(k));
      }
    }
  }

  private static boolean a(m paramm)
  {
    return (paramm != null) && (paramm.g().a() != null);
  }

  private int b(j[] paramArrayOfj)
  {
    int i = this.c.size();
    int j = this.f;
    for (int k = 0; k < i; k++)
    {
      h localh = (h)this.c.get(k);
      j localj1 = paramArrayOfj[k];
      j localj2 = a(localh, localj1);
      if (localj2 == null)
      {
        int m = localh.a(d(localh).c().c(localh));
        if (m > j)
          j = m;
      }
      else
      {
        if (localj1 == localj2)
          continue;
      }
      paramArrayOfj[k] = localj2;
    }
    return j;
  }

  private static boolean b(h paramh)
  {
    if ((paramh instanceof q))
    {
      o localo = ((q)paramh).b();
      int i = localo.b();
      for (int j = 0; j < i; j++)
        if (a(localo.a(j)))
          return true;
    }
    return ((paramh instanceof r)) && (a(((r)paramh).b()));
  }

  private void c(h paramh)
  {
    if ((!this.d) && (paramh.h().a() >= 0))
      this.d = true;
    if ((!this.e) && (b(paramh)))
      this.e = true;
  }

  private void c(j[] paramArrayOfj)
  {
    if (this.f == 0)
    {
      int i = this.c.size();
      for (int j = 0; j < i; j++)
      {
        h localh = (h)this.c.get(j);
        j localj1 = localh.g();
        j localj2 = paramArrayOfj[j];
        if (localj1 != localj2)
          this.c.set(j, localh.a(localj2));
      }
    }
    this.c = d(paramArrayOfj);
  }

  private j d(h paramh)
  {
    j localj = a(paramh.k(), paramh.g());
    if (localj == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No expanded opcode for ");
      localStringBuilder.append(paramh);
      throw new com.android.cglib.dx.d.f(localStringBuilder.toString());
    }
    return localj;
  }

  private ArrayList<h> d(j[] paramArrayOfj)
  {
    int i = this.c.size();
    ArrayList localArrayList = new ArrayList(i * 2);
    for (int j = 0; j < i; j++)
    {
      h localh1 = (h)this.c.get(j);
      j localj1 = localh1.g();
      j localj2 = paramArrayOfj[j];
      Object localObject;
      h localh2;
      if (localj2 != null)
      {
        localObject = null;
        localh2 = null;
      }
      else
      {
        localj2 = d(localh1);
        BitSet localBitSet = localj2.c().c(localh1);
        h localh3 = localh1.b(localBitSet);
        localh2 = localh1.c(localBitSet);
        localh1 = localh1.d(localBitSet);
        localObject = localh3;
      }
      if (localObject != null)
        localArrayList.add(localObject);
      if (localj2 != localj1)
        localh1 = localh1.a(localj2);
      localArrayList.add(localh1);
      if (localh2 != null)
        localArrayList.add(localh2);
    }
    return localArrayList;
  }

  private j[] e()
  {
    int i = this.c.size();
    j[] arrayOfj = new j[i];
    for (int j = 0; j < i; j++)
      arrayOfj[j] = ((h)this.c.get(j)).g();
    return arrayOfj;
  }

  private void f()
  {
    do
      g();
    while (h());
  }

  private void g()
  {
    int i = this.c.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      h localh = (h)this.c.get(j);
      localh.c(k);
      k += localh.n();
      j++;
    }
  }

  // ERROR //
  private boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   4: invokevirtual 135	java/util/ArrayList:size	()I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_2
    //   13: iload_1
    //   14: if_icmpge +221 -> 235
    //   17: aload_0
    //   18: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   21: iload_2
    //   22: invokevirtual 139	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 141	com/android/cglib/dx/a/a/h
    //   28: astore 4
    //   30: aload 4
    //   32: instanceof 233
    //   35: ifne +6 -> 41
    //   38: goto +169 -> 207
    //   41: aload 4
    //   43: invokevirtual 177	com/android/cglib/dx/a/a/h:g	()Lcom/android/cglib/dx/a/a/j;
    //   46: astore 5
    //   48: aload 4
    //   50: checkcast 233	com/android/cglib/dx/a/a/z
    //   53: astore 6
    //   55: aload 5
    //   57: invokevirtual 43	com/android/cglib/dx/a/a/j:c	()Lcom/android/cglib/dx/a/a/n;
    //   60: aload 6
    //   62: invokevirtual 236	com/android/cglib/dx/a/a/n:a	(Lcom/android/cglib/dx/a/a/z;)Z
    //   65: ifeq +6 -> 71
    //   68: goto +139 -> 207
    //   71: aload 5
    //   73: invokevirtual 237	com/android/cglib/dx/a/a/j:b	()I
    //   76: bipush 40
    //   78: if_icmpne +47 -> 125
    //   81: aload_0
    //   82: aload 4
    //   84: aload 5
    //   86: invokespecial 153	com/android/cglib/dx/a/a/t:a	(Lcom/android/cglib/dx/a/a/h;Lcom/android/cglib/dx/a/a/j;)Lcom/android/cglib/dx/a/a/j;
    //   89: astore 12
    //   91: aload 12
    //   93: ifnonnull +13 -> 106
    //   96: new 239	java/lang/UnsupportedOperationException
    //   99: dup
    //   100: ldc 241
    //   102: invokespecial 242	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   105: athrow
    //   106: aload_0
    //   107: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   110: iload_2
    //   111: aload 4
    //   113: aload 12
    //   115: invokevirtual 180	com/android/cglib/dx/a/a/h:a	(Lcom/android/cglib/dx/a/a/j;)Lcom/android/cglib/dx/a/a/h;
    //   118: invokevirtual 150	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto +83 -> 205
    //   125: aload_0
    //   126: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   129: astore 7
    //   131: iload_2
    //   132: iconst_1
    //   133: iadd
    //   134: istore 8
    //   136: aload 7
    //   138: iload 8
    //   140: invokevirtual 139	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   143: checkcast 143	com/android/cglib/dx/a/a/e
    //   146: astore 9
    //   148: new 233	com/android/cglib/dx/a/a/z
    //   151: dup
    //   152: getstatic 246	com/android/cglib/dx/a/a/k:P	Lcom/android/cglib/dx/a/a/j;
    //   155: aload 6
    //   157: invokevirtual 247	com/android/cglib/dx/a/a/z:h	()Lcom/android/cglib/dx/c/b/s;
    //   160: getstatic 252	com/android/cglib/dx/c/b/n:a	Lcom/android/cglib/dx/c/b/n;
    //   163: aload 6
    //   165: invokevirtual 255	com/android/cglib/dx/a/a/z:b	()Lcom/android/cglib/dx/a/a/e;
    //   168: invokespecial 258	com/android/cglib/dx/a/a/z:<init>	(Lcom/android/cglib/dx/a/a/j;Lcom/android/cglib/dx/c/b/s;Lcom/android/cglib/dx/c/b/n;Lcom/android/cglib/dx/a/a/e;)V
    //   171: astore 10
    //   173: aload_0
    //   174: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   177: iload_2
    //   178: aload 10
    //   180: invokevirtual 150	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   188: iload_2
    //   189: aload 6
    //   191: aload 9
    //   193: invokevirtual 261	com/android/cglib/dx/a/a/z:a	(Lcom/android/cglib/dx/a/a/e;)Lcom/android/cglib/dx/a/a/z;
    //   196: invokevirtual 264	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   199: iinc 1 1
    //   202: iload 8
    //   204: istore_2
    //   205: iconst_1
    //   206: istore_3
    //   207: iinc 2 1
    //   210: goto -198 -> 12
    //   213: new 266	java/lang/IllegalStateException
    //   216: dup
    //   217: ldc_w 268
    //   220: invokespecial 269	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   223: athrow
    //   224: new 266	java/lang/IllegalStateException
    //   227: dup
    //   228: ldc_w 271
    //   231: invokespecial 269	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: iload_3
    //   236: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   125	131	213	java/lang/ClassCastException
    //   136	148	213	java/lang/ClassCastException
    //   125	131	224	java/lang/IndexOutOfBoundsException
    //   136	148	224	java/lang/IndexOutOfBoundsException
  }

  // ERROR //
  public void a(int paramInt, e parame)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_0
    //   2: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   5: invokevirtual 135	java/util/ArrayList:size	()I
    //   8: iload_1
    //   9: isub
    //   10: iadd
    //   11: istore_3
    //   12: aload_0
    //   13: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   16: iload_3
    //   17: invokevirtual 139	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   20: checkcast 233	com/android/cglib/dx/a/a/z
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 31	com/android/cglib/dx/a/a/t:c	Ljava/util/ArrayList;
    //   29: iload_3
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 261	com/android/cglib/dx/a/a/z:a	(Lcom/android/cglib/dx/a/a/e;)Lcom/android/cglib/dx/a/a/z;
    //   36: invokevirtual 150	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: return
    //   41: new 274	java/lang/IllegalArgumentException
    //   44: dup
    //   45: ldc_w 276
    //   48: invokespecial 277	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: new 274	java/lang/IllegalArgumentException
    //   55: dup
    //   56: ldc_w 279
    //   59: invokespecial 277	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	25	41	java/lang/ClassCastException
    //   12	25	52	java/lang/IndexOutOfBoundsException
  }

  public void a(g.a parama)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((localh instanceof f))
        a((f)localh, parama);
    }
  }

  public void a(h paramh)
  {
    this.c.add(paramh);
    c(paramh);
  }

  public boolean a()
  {
    return this.d;
  }

  public boolean b()
  {
    return this.e;
  }

  public HashSet<a> c()
  {
    HashSet localHashSet = new HashSet(20);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      a(localHashSet, (h)localIterator.next());
    return localHashSet;
  }

  public i d()
  {
    if (this.f >= 0)
      throw new UnsupportedOperationException("already processed");
    j[] arrayOfj = e();
    a(arrayOfj);
    c(arrayOfj);
    f();
    return i.a(this.c, this.f + this.b);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.t
 * JD-Core Version:    0.6.2
 */