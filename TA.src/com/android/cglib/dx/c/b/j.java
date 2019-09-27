package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.e;

public final class j extends d
{
  public j(p paramp, s params, m paramm, n paramn, a parama)
  {
    super(paramp, params, paramm, paramn, parama);
    if (paramp.b() != 1)
      throw new IllegalArgumentException("bogus branchingness");
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
 * Qualified Name:     com.android.cglib.dx.c.b.j
 * JD-Core Version:    0.6.2
 */