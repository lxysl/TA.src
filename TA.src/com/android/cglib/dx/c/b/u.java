package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.e;

public final class u extends f
{
  private final e a;

  public u(p paramp, s params, n paramn, e parame)
  {
    super(paramp, params, null, paramn);
    if (paramp.b() != 6)
      throw new IllegalArgumentException("bogus branchingness");
    if (parame == null)
      throw new NullPointerException("catches == null");
    this.a = parame;
  }

  public static String a(e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("catch");
    int i = parame.a();
    for (int j = 0; j < i; j++)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(parame.a(j).a_());
    }
    return localStringBuffer.toString();
  }

  public void a(f.b paramb)
  {
    paramb.a(this);
  }

  public String b()
  {
    return a(this.a);
  }

  public e i()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.u
 * JD-Core Version:    0.6.2
 */