package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.i;

public final class p
{
  private final int a;
  private final c b;
  private final e c;
  private final e d;
  private final int e;
  private final boolean f;
  private final String g;

  public p(int paramInt1, c paramc, e parame, int paramInt2, String paramString)
  {
    this(paramInt1, paramc, parame, b.a, paramInt2, false, paramString);
  }

  public p(int paramInt1, c paramc, e parame1, e parame2, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramc == null)
      throw new NullPointerException("result == null");
    if (parame1 == null)
      throw new NullPointerException("sources == null");
    if (parame2 == null)
      throw new NullPointerException("exceptions == null");
    if ((paramInt2 >= 1) && (paramInt2 <= 6))
    {
      if ((parame2.a() != 0) && (paramInt2 != 6))
        throw new IllegalArgumentException("exceptions / branchingness mismatch");
      this.a = paramInt1;
      this.b = paramc;
      this.c = parame1;
      this.d = parame2;
      this.e = paramInt2;
      this.f = paramBoolean;
      this.g = paramString;
      return;
    }
    throw new IllegalArgumentException("bogus branchingness");
  }

  public p(int paramInt, c paramc, e parame1, e parame2, String paramString)
  {
    this(paramInt, paramc, parame1, parame2, 6, false, paramString);
  }

  public p(int paramInt, c paramc, e parame, String paramString)
  {
    this(paramInt, paramc, parame, b.a, 1, false, paramString);
  }

  public p(int paramInt, e parame1, e parame2)
  {
    this(paramInt, c.i, parame1, parame2, 6, true, null);
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.e;
  }

  public boolean c()
  {
    return this.f;
  }

  public boolean d()
  {
    int i = this.a;
    if ((i != 14) && (i != 16))
      switch (i)
      {
      default:
        return false;
      case 20:
      case 21:
      case 22:
      }
    return true;
  }

  public String e()
  {
    if (this.g != null)
      return this.g;
    return toString();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof p))
      return false;
    p localp = (p)paramObject;
    return (this.a == localp.a) && (this.e == localp.e) && (this.b == localp.b) && (this.c.equals(localp.c)) && (this.d.equals(localp.d));
  }

  public final boolean f()
  {
    return this.d.a() != 0;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * this.a + this.e) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(40);
    localStringBuffer.append("Rop{");
    localStringBuffer.append(l.a(this.a));
    if (this.b != c.i)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(this.b);
    }
    else
    {
      localStringBuffer.append(" .");
    }
    localStringBuffer.append(" <-");
    int i = this.c.a();
    int j = 0;
    if (i == 0)
      localStringBuffer.append(" .");
    else
      for (int k = 0; k < i; k++)
      {
        localStringBuffer.append(' ');
        localStringBuffer.append(this.c.a(k));
      }
    if (this.f)
      localStringBuffer.append(" call");
    int m = this.d.a();
    if (m != 0)
    {
      localStringBuffer.append(" throws");
      while (j < m)
      {
        localStringBuffer.append(' ');
        if (this.d.a(j) == c.r)
          localStringBuffer.append("<any>");
        else
          localStringBuffer.append(this.d.a(j));
        j++;
      }
    }
    String str;
    switch (this.e)
    {
    default:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(i.e(this.e));
      str = localStringBuilder.toString();
    case 5:
    case 4:
    case 3:
    case 2:
    case 1:
    }
    while (true)
    {
      localStringBuffer.append(str);
      break;
      str = " switches";
      continue;
      str = " ifs";
      continue;
      str = " gotos";
      continue;
      str = " returns";
      continue;
      str = " flows";
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.p
 * JD-Core Version:    0.6.2
 */