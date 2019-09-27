package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.c;
import java.util.BitSet;

public final class v extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new v();

  private static int d(com.android.cglib.dx.c.b.n paramn)
  {
    int i = paramn.a();
    int j = -1;
    if (i > 5)
      return j;
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m localm = paramn.b(k);
      m += localm.i();
      if (!b(-1 + (localm.e() + localm.i())))
        return j;
      k++;
    }
    if (m <= 5)
      j = m;
    return j;
  }

  private static com.android.cglib.dx.c.b.n e(com.android.cglib.dx.c.b.n paramn)
  {
    int i = d(paramn);
    int j = paramn.a();
    if (i == j)
      return paramn;
    com.android.cglib.dx.c.b.n localn = new com.android.cglib.dx.c.b.n(i);
    int k = 0;
    int m = 0;
    while (k < j)
    {
      m localm = paramn.b(k);
      localn.a(m, localm);
      if (localm.i() == 2)
      {
        localn.a(m + 1, m.a(1 + localm.e(), c.i));
        m += 2;
      }
      else
      {
        m++;
      }
      k++;
    }
    localn.e();
    return localn;
  }

  public int a()
  {
    return 3;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = e(paramh.i());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(localn));
    localStringBuilder.append(", ");
    localStringBuilder.append(f(paramh));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    int i = ((f)paramh).c();
    com.android.cglib.dx.c.b.n localn = e(paramh.i());
    int j = localn.a();
    int k;
    if (j > 0)
      k = localn.b(0).e();
    else
      k = 0;
    int m;
    if (j > 1)
      m = localn.b(1).e();
    else
      m = 0;
    int n;
    if (j > 2)
      n = localn.b(2).e();
    else
      n = 0;
    int i1;
    if (j > 3)
      i1 = localn.b(3).e();
    else
      i1 = 0;
    int i2 = 0;
    if (j > 4)
      i2 = localn.b(4).e();
    a(parama, a(paramh, b(i2, j)), (short)i, a(k, m, n, i1));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    if (paramBoolean)
      return g(paramh);
    return "";
  }

  public boolean b(h paramh)
  {
    if (!(paramh instanceof f))
      return false;
    f localf = (f)paramh;
    if (!f(localf.c()))
      return false;
    com.android.cglib.dx.c.c.a locala = localf.b();
    if ((!(locala instanceof s)) && (!(locala instanceof w)))
      return false;
    int i = d(localf.i());
    boolean bool = false;
    if (i >= 0)
      bool = true;
    return bool;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = localn.a();
    BitSet localBitSet = new BitSet(i);
    for (int j = 0; j < i; j++)
    {
      m localm = localn.b(j);
      localBitSet.set(j, b(-1 + (localm.e() + localm.i())));
    }
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.v
 * JD-Core Version:    0.6.2
 */