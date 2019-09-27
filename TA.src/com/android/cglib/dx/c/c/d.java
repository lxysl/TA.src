package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;

public abstract class d extends r
{
  private final com.android.cglib.dx.c.d.a a = com.android.cglib.dx.c.d.a.a(h().c().g());
  private com.android.cglib.dx.c.d.a b = null;

  d(w paramw, t paramt)
  {
    super(paramw, paramt);
  }

  public final com.android.cglib.dx.c.d.a a(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.a;
    if (this.b == null)
    {
      c localc = g().f();
      this.b = this.a.a(localc);
    }
    return this.b;
  }

  protected final int b(a parama)
  {
    int i = super.b(parama);
    if (i != 0)
      return i;
    d locald = (d)parama;
    return this.a.a(locald.a);
  }

  public final int b(boolean paramBoolean)
  {
    return a(paramBoolean).c().b();
  }

  public final c b()
  {
    return this.a.b();
  }

  public final com.android.cglib.dx.c.d.a f()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.d
 * JD-Core Version:    0.6.2
 */