package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.b.o;
import com.android.cglib.dx.c.b.s;

public final class q extends ab
{
  private final o a;

  public q(s params, o paramo)
  {
    super(params);
    if (paramo == null)
      throw new NullPointerException("locals == null");
    this.a = paramo;
  }

  public h a(n paramn)
  {
    return new q(h(), this.a);
  }

  protected String a()
  {
    return this.a.toString();
  }

  protected String a(boolean paramBoolean)
  {
    int i = this.a.b();
    int j = this.a.a();
    StringBuffer localStringBuffer = new StringBuffer(100 + i * 40);
    localStringBuffer.append("local-snapshot");
    for (int k = 0; k < j; k++)
    {
      m localm = this.a.a(k);
      if (localm != null)
      {
        localStringBuffer.append("\n  ");
        localStringBuffer.append(r.a(localm));
      }
    }
    return localStringBuffer.toString();
  }

  public o b()
  {
    return this.a;
  }

  public h d(int paramInt)
  {
    return new q(h(), this.a.b(paramInt));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.q
 * JD-Core Version:    0.6.2
 */