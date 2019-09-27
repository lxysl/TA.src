package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.h;
import java.util.BitSet;

public final class n extends h
  implements e
{
  public static final n a = new n(0);

  public n(int paramInt)
  {
    super(paramInt);
  }

  public static n a(m paramm)
  {
    n localn = new n(1);
    localn.a(0, paramm);
    return localn;
  }

  public static n a(m paramm1, m paramm2)
  {
    n localn = new n(2);
    localn.a(0, paramm1);
    localn.a(1, paramm2);
    return localn;
  }

  public static n a(m paramm1, m paramm2, m paramm3)
  {
    n localn = new n(3);
    localn.a(0, paramm1);
    localn.a(1, paramm2);
    localn.a(2, paramm3);
    return localn;
  }

  public n a(int paramInt, boolean paramBoolean, BitSet paramBitSet)
  {
    int i = a();
    if (i == 0)
      return this;
    n localn = new n(i);
    boolean bool = paramBoolean;
    int j = paramInt;
    for (int k = 0; k < i; k++)
    {
      m localm = (m)d(k);
      int m = 1;
      if ((paramBitSet != null) && (paramBitSet.get(k)))
        m = 0;
      if (m != 0)
      {
        localn.a(k, localm.b(j));
        if (!bool)
          j += localm.i();
      }
      else
      {
        localn.a(k, localm);
      }
      if (bool)
        bool = false;
    }
    if (f())
      localn.e();
    return localn;
  }

  public n a(BitSet paramBitSet)
  {
    int i = a() - paramBitSet.cardinality();
    if (i == 0)
      return a;
    n localn = new n(i);
    int j = 0;
    int k = 0;
    while (j < a())
    {
      if (!paramBitSet.get(j))
      {
        localn.a(k, d(j));
        k++;
      }
      j++;
    }
    if (f())
      localn.e();
    return localn;
  }

  public c a(int paramInt)
  {
    return b(paramInt).b().b();
  }

  public void a(int paramInt, m paramm)
  {
    a(paramInt, paramm);
  }

  public int b()
  {
    int i = a();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += a(j).g();
      j++;
    }
    return k;
  }

  public m b(int paramInt)
  {
    return (m)d(paramInt);
  }

  public n b(m paramm)
  {
    int i = a();
    n localn = new n(i + 1);
    int k;
    for (int j = 0; j < i; j = k)
    {
      k = j + 1;
      localn.a(k, d(j));
    }
    localn.a(0, paramm);
    if (f())
      localn.e();
    return localn;
  }

  public n c(int paramInt)
  {
    int i = a();
    if (i == 0)
      return this;
    n localn = new n(i);
    for (int j = 0; j < i; j++)
    {
      m localm = (m)d(j);
      if (localm != null)
        localn.a(j, localm.c(paramInt));
    }
    if (f())
      localn.e();
    return localn;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.n
 * JD-Core Version:    0.6.2
 */