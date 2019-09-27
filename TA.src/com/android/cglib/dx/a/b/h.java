package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public final class h extends as
{
  private final TreeMap<c, g> a = new TreeMap();
  private ArrayList<g> b = null;

  public h(l paraml)
  {
    super("class_defs", paraml, 4);
  }

  private int a(c paramc, int paramInt1, int paramInt2)
  {
    g localg = (g)this.a.get(paramc);
    if (localg != null)
    {
      if (localg.f())
        return paramInt1;
      if (paramInt2 < 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("class circularity with ");
        localStringBuilder.append(paramc);
        throw new RuntimeException(localStringBuilder.toString());
      }
      int i = paramInt2 - 1;
      w localw = localg.d();
      if (localw != null)
        paramInt1 = a(localw.f(), paramInt1, i);
      e locale = localg.e();
      int j = locale.a();
      for (int k = 0; k < j; k++)
        paramInt1 = a(locale.a(k), paramInt1, i);
      localg.a(paramInt1);
      this.b.add(localg);
      paramInt1++;
    }
    return paramInt1;
  }

  public Collection<? extends x> a()
  {
    if (this.b != null)
      return this.b;
    return this.a.values();
  }

  // ERROR //
  public void a(g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 100	com/android/cglib/dx/a/b/g:c	()Lcom/android/cglib/dx/c/c/w;
    //   4: invokevirtual 67	com/android/cglib/dx/c/c/w:f	()Lcom/android/cglib/dx/c/d/c;
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 103	com/android/cglib/dx/a/b/h:j	()V
    //   12: aload_0
    //   13: getfield 24	com/android/cglib/dx/a/b/h:a	Ljava/util/TreeMap;
    //   16: aload_2
    //   17: invokevirtual 31	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +36 -> 56
    //   23: new 39	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: ldc 105
    //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: aload_2
    //   40: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: new 107	java/lang/IllegalArgumentException
    //   47: dup
    //   48: aload_3
    //   49: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 108	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: aload_0
    //   57: getfield 24	com/android/cglib/dx/a/b/h:a	Ljava/util/TreeMap;
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 112	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: return
    //   67: new 97	java/lang/NullPointerException
    //   70: dup
    //   71: ldc 114
    //   73: invokespecial 115	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	67	java/lang/NullPointerException
  }

  public void a(a parama)
  {
    i();
    int i = this.a.size();
    int j;
    if (i == 0)
      j = 0;
    else
      j = g();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("class_defs_size: ");
      localStringBuilder1.append(i.a(i));
      parama.a(4, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("class_defs_off:  ");
      localStringBuilder2.append(i.a(j));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    parama.d(j);
  }

  protected void b()
  {
    int i = this.a.size();
    this.b = new ArrayList(i);
    Iterator localIterator = this.a.keySet().iterator();
    for (int j = 0; localIterator.hasNext(); j = a((c)localIterator.next(), j, i - j));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.h
 * JD-Core Version:    0.6.2
 */