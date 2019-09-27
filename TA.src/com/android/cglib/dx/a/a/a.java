package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.b;
import com.android.cglib.dx.c.b.c;
import com.android.cglib.dx.c.b.f;
import com.android.cglib.dx.c.b.g;
import com.android.cglib.dx.c.b.q;
import com.android.cglib.dx.c.b.s;

public final class a
{
  private final e[] a;
  private final e[] b;
  private final e[] c;

  public a(q paramq)
  {
    int i = paramq.a().d();
    this.a = new e[i];
    this.b = new e[i];
    this.c = new e[i];
    a(paramq);
  }

  private void a(q paramq)
  {
    c localc = paramq.a();
    int i = localc.a();
    for (int j = 0; j < i; j++)
    {
      b localb = localc.a(j);
      int k = localb.a();
      f localf = localb.b().a(0);
      this.a[k] = new e(localf.e());
      s locals = localb.f().e();
      this.b[k] = new e(locals);
      this.c[k] = new e(locals);
    }
  }

  public e a(int paramInt)
  {
    return this.a[paramInt];
  }

  public e a(b paramb)
  {
    return this.a[paramb.a()];
  }

  public e b(b paramb)
  {
    return this.b[paramb.a()];
  }

  public e c(b paramb)
  {
    return this.c[paramb.a()];
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a
 * JD-Core Version:    0.6.2
 */