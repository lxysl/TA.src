package com.android.cglib.dx.c.b;

import com.android.cglib.dx.d.i;

public final class c extends com.android.cglib.dx.d.m
{
  private int a = -1;

  public c(int paramInt)
  {
    super(paramInt);
  }

  public b a(int paramInt)
  {
    return (b)d(paramInt);
  }

  public b a(b paramb)
  {
    int i = paramb.d();
    com.android.cglib.dx.d.k localk = paramb.c();
    switch (localk.a())
    {
    default:
      if (i != -1)
        return b(i);
    case 1:
      return b(localk.a(0));
    case 0:
    }
    return null;
  }

  public void a(int paramInt, b paramb)
  {
    super.a(paramInt, paramb);
    this.a = -1;
  }

  public void a(f.b paramb)
  {
    int i = a();
    for (int j = 0; j < i; j++)
      a(j).b().a(paramb);
  }

  public int b()
  {
    if (this.a == -1)
    {
      a locala = new a();
      a(locala);
      this.a = locala.a();
    }
    return this.a;
  }

  public b b(int paramInt)
  {
    int i = c(paramInt);
    if (i < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such label: ");
      localStringBuilder.append(i.c(paramInt));
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return a(i);
  }

  public int c()
  {
    int i = a();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      b localb = (b)e(j);
      if (localb != null)
        k += localb.b().a();
      j++;
    }
    return k;
  }

  private static class a
    implements f.b
  {
    private int a = 0;

    private void a(f paramf)
    {
      m localm = paramf.f();
      if (localm != null)
        a(localm);
      n localn = paramf.g();
      int i = localn.a();
      for (int j = 0; j < i; j++)
        a(localn.b(j));
    }

    private void a(m paramm)
    {
      int i = paramm.h();
      if (i > this.a)
        this.a = i;
    }

    public int a()
    {
      return this.a;
    }

    public void a(j paramj)
    {
      a(paramj);
    }

    public void a(k paramk)
    {
      a(paramk);
    }

    public void a(t paramt)
    {
      a(paramt);
    }

    public void a(u paramu)
    {
      a(paramu);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.c
 * JD-Core Version:    0.6.2
 */