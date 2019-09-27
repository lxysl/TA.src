package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import java.util.HashMap;

public final class w extends x
{
  public static final w a = a(c.o);
  public static final w b = a(c.s);
  public static final w c = a(c.t);
  public static final w d = a(c.u);
  public static final w e = a(c.v);
  public static final w f = a(c.w);
  public static final w g = a(c.y);
  public static final w h = a(c.x);
  public static final w i = a(c.z);
  public static final w j = a(c.A);
  public static final w k = a(c.B);
  public static final w l = a(c.C);
  public static final w m = a(c.D);
  public static final w n = a(c.E);
  public static final w o = a(c.F);
  public static final w p = a(c.H);
  public static final w q = a(c.G);
  public static final w r = a(c.J);
  private static final HashMap<c, w> s = new HashMap(100);
  private final c t;
  private v u;

  public w(c paramc)
  {
    if (paramc == null)
      throw new NullPointerException("type == null");
    if (paramc == c.j)
      throw new UnsupportedOperationException("KNOWN_NULL is not representable");
    this.t = paramc;
    this.u = null;
  }

  public static w a(c paramc)
  {
    synchronized (s)
    {
      w localw = (w)s.get(paramc);
      if (localw == null)
      {
        localw = new w(paramc);
        s.put(paramc, localw);
      }
      return localw;
    }
  }

  public String a_()
  {
    return this.t.a_();
  }

  protected int b(a parama)
  {
    return this.t.e().compareTo(((w)parama).t.e());
  }

  public c b()
  {
    return c.m;
  }

  public String e()
  {
    return "type";
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof w))
      return false;
    c localc1 = this.t;
    c localc2 = ((w)paramObject).t;
    boolean bool = false;
    if (localc1 == localc2)
      bool = true;
    return bool;
  }

  public c f()
  {
    return this.t;
  }

  public v g()
  {
    if (this.u == null)
      this.u = new v(this.t.e());
    return this.u;
  }

  public int hashCode()
  {
    return this.t.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type{");
    localStringBuilder.append(a_());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.w
 * JD-Core Version:    0.6.2
 */