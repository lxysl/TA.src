package com.android.cglib.dx.c.d;

import com.android.cglib.dx.d.h;

public final class b extends h
  implements e
{
  public static final b A = a(c.J, c.f);
  public static final b B = a(c.f, c.G, c.f);
  public static final b C = a(c.g, c.H, c.f);
  public static final b D = a(c.e, c.F, c.f);
  public static final b E = a(c.d, c.E, c.f);
  public static final b F = a(c.o, c.I, c.f);
  public static final b G = a(c.f, c.B, c.f);
  public static final b H = a(c.f, c.C, c.f);
  public static final b I = a(c.f, c.D, c.f);
  public static final b J = a(c.f, c.J, c.f);
  public static final b a = new b(0);
  public static final b b = a(c.f);
  public static final b c = a(c.g);
  public static final b d = a(c.e);
  public static final b e = a(c.d);
  public static final b f = a(c.o);
  public static final b g = a(c.k);
  public static final b h = a(c.r);
  public static final b i = a(c.f, c.f);
  public static final b j = a(c.g, c.g);
  public static final b k = a(c.e, c.e);
  public static final b l = a(c.d, c.d);
  public static final b m = a(c.o, c.o);
  public static final b n = a(c.f, c.o);
  public static final b o = a(c.g, c.o);
  public static final b p = a(c.e, c.o);
  public static final b q = a(c.d, c.o);
  public static final b r = a(c.g, c.f);
  public static final b s = a(c.G, c.f);
  public static final b t = a(c.H, c.f);
  public static final b u = a(c.F, c.f);
  public static final b v = a(c.E, c.f);
  public static final b w = a(c.I, c.f);
  public static final b x = a(c.B, c.f);
  public static final b y = a(c.C, c.f);
  public static final b z = a(c.D, c.f);

  public b(int paramInt)
  {
    super(paramInt);
  }

  public static int a(e parame1, e parame2)
  {
    int i1 = parame1.a();
    int i2 = parame2.a();
    int i3 = Math.min(i1, i2);
    for (int i4 = 0; i4 < i3; i4++)
    {
      int i5 = parame1.a(i4).a(parame2.a(i4));
      if (i5 != 0)
        return i5;
    }
    if (i1 == i2)
      return 0;
    if (i1 < i2)
      return -1;
    return 1;
  }

  public static b a(c paramc)
  {
    b localb = new b(1);
    localb.a(0, paramc);
    return localb;
  }

  public static b a(c paramc1, c paramc2)
  {
    b localb = new b(2);
    localb.a(0, paramc1);
    localb.a(1, paramc2);
    return localb;
  }

  public static b a(c paramc1, c paramc2, c paramc3)
  {
    b localb = new b(3);
    localb.a(0, paramc1);
    localb.a(1, paramc2);
    localb.a(2, paramc3);
    return localb;
  }

  public static b a(c paramc1, c paramc2, c paramc3, c paramc4)
  {
    b localb = new b(4);
    localb.a(0, paramc1);
    localb.a(1, paramc2);
    localb.a(2, paramc3);
    localb.a(3, paramc4);
    return localb;
  }

  public static String a(e parame)
  {
    int i1 = parame.a();
    if (i1 == 0)
      return "<empty>";
    StringBuffer localStringBuffer = new StringBuffer(100);
    for (int i2 = 0; i2 < i1; i2++)
    {
      if (i2 != 0)
        localStringBuffer.append(", ");
      localStringBuffer.append(parame.a(i2).a_());
    }
    return localStringBuffer.toString();
  }

  public static int b(e parame)
  {
    int i1 = parame.a();
    int i2 = 0;
    int i3 = 0;
    while (i2 < i1)
    {
      i3 = i3 * 31 + parame.a(i2).hashCode();
      i2++;
    }
    return i3;
  }

  public c a(int paramInt)
  {
    return b(paramInt);
  }

  public void a(int paramInt, c paramc)
  {
    a(paramInt, paramc);
  }

  public int b()
  {
    int i1 = a();
    int i2 = 0;
    int i3 = 0;
    while (i2 < i1)
    {
      i3 += b(i2).g();
      i2++;
    }
    return i3;
  }

  public b b(c paramc)
  {
    int i1 = a();
    b localb = new b(i1 + 1);
    int i2 = 0;
    localb.a(0, paramc);
    while (i2 < i1)
    {
      int i3 = i2 + 1;
      localb.a(i3, e(i2));
      i2 = i3;
    }
    return localb;
  }

  public c b(int paramInt)
  {
    return (c)d(paramInt);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.d.b
 * JD-Core Version:    0.6.2
 */