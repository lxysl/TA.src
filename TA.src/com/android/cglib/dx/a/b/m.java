package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.c;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.d;

public final class m extends ag
{
  private final c a;
  private byte[] b;

  public m(c paramc)
  {
    super(1, -1);
    if (paramc == null)
      throw new NullPointerException("array == null");
    this.a = paramc;
    this.b = null;
  }

  protected int a(ag paramag)
  {
    m localm = (m)paramag;
    return this.a.a(localm.a);
  }

  public y a()
  {
    return y.q;
  }

  protected void a(ak paramak, int paramInt)
  {
    d locald = new d();
    new au(paramak.e(), locald).a(this.a, false);
    this.b = locald.f();
    a(this.b.length);
  }

  public void a(l paraml)
  {
    au.a(paraml, this.a);
  }

  protected void a_(l paraml, a parama)
  {
    if (parama.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g());
      localStringBuilder.append(" encoded array");
      parama.a(0, localStringBuilder.toString());
      new au(paraml, parama).a(this.a, true);
      return;
    }
    parama.a(this.b);
  }

  public String b()
  {
    return this.a.a_();
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.m
 * JD-Core Version:    0.6.2
 */