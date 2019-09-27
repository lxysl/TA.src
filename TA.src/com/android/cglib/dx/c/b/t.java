package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.d.e;

public final class t extends d
{
  private final e a;

  public t(p paramp, s params, n paramn, e parame, a parama)
  {
    super(paramp, params, null, paramn, parama);
    if (paramp.b() != 6)
      throw new IllegalArgumentException("bogus branchingness");
    if (parame == null)
      throw new NullPointerException("catches == null");
    this.a = parame;
  }

  public void a(f.b paramb)
  {
    paramb.a(this);
  }

  public String b()
  {
    a locala = c();
    String str = locala.a_();
    if ((locala instanceof v))
      str = ((v)locala).f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(u.a(this.a));
    return localStringBuilder.toString();
  }

  public e i()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.t
 * JD-Core Version:    0.6.2
 */