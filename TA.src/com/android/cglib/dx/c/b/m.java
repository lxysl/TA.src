package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.d;
import com.android.cglib.dx.d.r;
import java.util.HashMap;

public final class m
  implements d, r, Comparable<m>
{
  private static final HashMap<Object, m> a = new HashMap(1000);
  private static final a b = new a(null);
  private final int c;
  private final d d;
  private final h e;

  private m(int paramInt, d paramd, h paramh)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("reg < 0");
    if (paramd == null)
      throw new NullPointerException("type == null");
    this.c = paramInt;
    this.d = paramd;
    this.e = paramh;
  }

  public static m a(int paramInt, d paramd)
  {
    return c(paramInt, paramd, null);
  }

  public static m a(int paramInt, d paramd, h paramh)
  {
    return c(paramInt, paramd, paramh);
  }

  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }

  private String a(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(40);
    localStringBuffer.append(k());
    localStringBuffer.append(":");
    if (this.e != null)
      localStringBuffer.append(this.e.toString());
    c localc = this.d.b();
    localStringBuffer.append(localc);
    if (localc != this.d)
    {
      localStringBuffer.append("=");
      if ((paramBoolean) && ((this.d instanceof v)));
      for (String str = ((v)this.d).f(); ; str = this.d.a_())
      {
        localStringBuffer.append(str);
        break label152;
        if ((!paramBoolean) || (!(this.d instanceof a)))
          break;
      }
      localStringBuffer.append(this.d);
    }
    label152: return localStringBuffer.toString();
  }

  private static m c(int paramInt, d paramd, h paramh)
  {
    synchronized (a)
    {
      b.a(paramInt, paramd, paramh);
      m localm1 = (m)a.get(b);
      if (localm1 != null)
        return localm1;
      m localm2 = b.a();
      a.put(localm2, localm2);
      return localm2;
    }
  }

  private boolean d(int paramInt, d paramd, h paramh)
  {
    return (this.c == paramInt) && (this.d.equals(paramd)) && ((this.e == paramh) || ((this.e != null) && (this.e.equals(paramh))));
  }

  private static int e(int paramInt, d paramd, h paramh)
  {
    int i;
    if (paramh != null)
      i = paramh.hashCode();
    else
      i = 0;
    return paramInt + 31 * (i * 31 + paramd.hashCode());
  }

  public m a(d paramd)
  {
    return a(this.c, paramd, this.e);
  }

  public boolean a(m paramm)
  {
    if (!b(paramm))
      return false;
    int i = this.c;
    int j = paramm.c;
    boolean bool = false;
    if (i == j)
      bool = true;
    return bool;
  }

  public String a_()
  {
    return a(true);
  }

  public m b(int paramInt)
  {
    if (this.c == paramInt)
      return this;
    return a(paramInt, this.d, this.e);
  }

  public c b()
  {
    return this.d.b();
  }

  public boolean b(m paramm)
  {
    if (paramm == null)
      return false;
    boolean bool1 = this.d.b().equals(paramm.d.b());
    boolean bool2 = false;
    if (bool1)
      if (this.e != paramm.e)
      {
        h localh = this.e;
        bool2 = false;
        if (localh != null)
        {
          boolean bool3 = this.e.equals(paramm.e);
          bool2 = false;
          if (!bool3);
        }
      }
      else
      {
        bool2 = true;
      }
    return bool2;
  }

  public final int c()
  {
    return this.d.c();
  }

  public int c(m paramm)
  {
    int i = this.c;
    int j = paramm.c;
    int k = -1;
    if (i < j)
      return k;
    if (this.c > paramm.c)
      return 1;
    int m = this.d.b().a(paramm.d.b());
    if (m != 0)
      return m;
    if (this.e == null)
    {
      if (paramm.e == null)
        k = 0;
      return k;
    }
    if (paramm.e == null)
      return 1;
    return this.e.a(paramm.e);
  }

  public m c(int paramInt)
  {
    if (paramInt == 0)
      return this;
    return b(paramInt + this.c);
  }

  public final int d()
  {
    return this.d.d();
  }

  public int e()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    a locala;
    int i;
    d locald;
    if (!(paramObject instanceof m))
      if ((paramObject instanceof a))
      {
        locala = (a)paramObject;
        i = a.a(locala);
        locald = a.b(locala);
      }
    m localm;
    for (h localh = a.c(locala); ; localh = localm.e)
    {
      return d(i, locald, localh);
      return false;
      localm = (m)paramObject;
      i = localm.c;
      locald = localm.d;
    }
  }

  public d f()
  {
    return this.d;
  }

  public h g()
  {
    return this.e;
  }

  public int h()
  {
    return this.c + i();
  }

  public int hashCode()
  {
    return e(this.c, this.d, this.e);
  }

  public int i()
  {
    return this.d.b().g();
  }

  public boolean j()
  {
    return this.d.b().h();
  }

  public String k()
  {
    return a(this.c);
  }

  public String toString()
  {
    return a(false);
  }

  private static class a
  {
    private int a;
    private d b;
    private h c;

    public m a()
    {
      return new m(this.a, this.b, this.c, null);
    }

    public void a(int paramInt, d paramd, h paramh)
    {
      this.a = paramInt;
      this.b = paramd;
      this.c = paramh;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof m))
        return false;
      return m.a((m)paramObject, this.a, this.b, this.c);
    }

    public int hashCode()
    {
      return m.b(this.a, this.b, this.c);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.m
 * JD-Core Version:    0.6.2
 */