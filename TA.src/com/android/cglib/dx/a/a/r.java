package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.b.s;
import com.android.cglib.dx.c.d.d;

public final class r extends ab
{
  private final m a;

  public r(s params, m paramm)
  {
    super(params);
    if (paramm == null)
      throw new NullPointerException("local == null");
    this.a = paramm;
  }

  public static String a(m paramm)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramm.k());
    localStringBuilder.append(' ');
    localStringBuilder.append(paramm.g().toString());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramm.f().a_());
    return localStringBuilder.toString();
  }

  public h a(n paramn)
  {
    return new r(h(), this.a);
  }

  protected String a()
  {
    return this.a.toString();
  }

  protected String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local-start ");
    localStringBuilder.append(a(this.a));
    return localStringBuilder.toString();
  }

  public m b()
  {
    return this.a;
  }

  public h d(int paramInt)
  {
    return new r(h(), this.a.c(paramInt));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.r
 * JD-Core Version:    0.6.2
 */