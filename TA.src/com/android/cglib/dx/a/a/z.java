package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.b.s;

public final class z extends l
{
  private e a;

  public z(j paramj, s params, n paramn, e parame)
  {
    super(paramj, params, paramn);
    if (parame == null)
      throw new NullPointerException("target == null");
    this.a = parame;
  }

  public h a(j paramj)
  {
    return new z(paramj, h(), i(), this.a);
  }

  public h a(n paramn)
  {
    return new z(g(), h(), paramn, this.a);
  }

  public z a(e parame)
  {
    return new z(g().g(), h(), i(), parame);
  }

  protected String a()
  {
    if (this.a == null)
      return "????";
    return this.a.l();
  }

  public e b()
  {
    return this.a;
  }

  public int c()
  {
    return this.a.f();
  }

  public int d()
  {
    return this.a.f() - f();
  }

  public boolean o()
  {
    return (e()) && (this.a.e());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.z
 * JD-Core Version:    0.6.2
 */