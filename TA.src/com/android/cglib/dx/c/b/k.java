package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.e;

public final class k extends f
{
  public k(p paramp, s params, m paramm1, m paramm2)
  {
    this(paramp, params, paramm1, n.a(paramm2));
  }

  public k(p paramp, s params, m paramm, n paramn)
  {
    super(paramp, params, paramm, paramn);
    switch (paramp.b())
    {
    default:
      if ((paramm != null) && (paramp.b() != 1))
        throw new IllegalArgumentException("can't mix branchingness with result");
      break;
    case 5:
    case 6:
      throw new IllegalArgumentException("bogus branchingness");
    }
  }

  public void a(f.b paramb)
  {
    paramb.a(this);
  }

  public e i()
  {
    return b.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.k
 * JD-Core Version:    0.6.2
 */