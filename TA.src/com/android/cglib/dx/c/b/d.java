package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.c.a;

public abstract class d extends f
{
  private final a a;

  public d(p paramp, s params, m paramm, n paramn, a parama)
  {
    super(paramp, params, paramm, paramn);
    if (parama == null)
      throw new NullPointerException("cst == null");
    this.a = parama;
  }

  public String b()
  {
    return this.a.a_();
  }

  public a c()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.d
 * JD-Core Version:    0.6.2
 */