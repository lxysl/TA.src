package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.d.h;
import com.android.cglib.dx.d.i;

public final class c extends h
  implements Comparable<c>
{
  public static final c a = new c(0);

  public c(int paramInt)
  {
    super(paramInt);
  }

  public int a(c paramc)
  {
    if (this == paramc)
      return 0;
    int i = a();
    int j = paramc.a();
    int k = Math.min(i, j);
    for (int m = 0; m < k; m++)
    {
      int n = a(m).a(paramc.a(m));
      if (n != 0)
        return n;
    }
    if (i < j)
      return -1;
    if (i > j)
      return 1;
    return 0;
  }

  public a a(int paramInt)
  {
    return (a)d(paramInt);
  }

  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    int i = a();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append("catch ");
    for (int j = 0; j < i; j++)
    {
      a locala = a(j);
      if (j != 0)
      {
        localStringBuilder.append(",\n");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("  ");
      }
      String str;
      if ((j == i - 1) && (b()))
        str = "<any>";
      else
        str = locala.a().a_();
      localStringBuilder.append(str);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(i.d(locala.b()));
    }
    return localStringBuilder.toString();
  }

  public void a(int paramInt1, w paramw, int paramInt2)
  {
    a(paramInt1, new a(paramw, paramInt2));
  }

  public String a_()
  {
    return a("", "");
  }

  public boolean b()
  {
    int i = a();
    if (i == 0)
      return false;
    return a(i - 1).a().equals(w.a);
  }

  public static class a
    implements Comparable<a>
  {
    private final w a;
    private final int b;

    public a(w paramw, int paramInt)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("handler < 0");
      if (paramw == null)
        throw new NullPointerException("exceptionType == null");
      this.b = paramInt;
      this.a = paramw;
    }

    public int a(a parama)
    {
      if (this.b < parama.b)
        return -1;
      if (this.b > parama.b)
        return 1;
      return this.a.a(parama.a);
    }

    public w a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      if (bool1)
      {
        int i = a((a)paramObject);
        bool2 = false;
        if (i == 0)
          bool2 = true;
      }
      return bool2;
    }

    public int hashCode()
    {
      return 31 * this.b + this.a.hashCode();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.c
 * JD-Core Version:    0.6.2
 */