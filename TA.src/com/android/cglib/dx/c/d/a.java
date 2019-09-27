package com.android.cglib.dx.c.d;

import java.util.HashMap;

public final class a
  implements Comparable<a>
{
  private static final HashMap<String, a> a = new HashMap(500);
  private final String b;
  private final c c;
  private final b d;
  private b e;

  private a(String paramString, c paramc, b paramb)
  {
    if (paramString == null)
      throw new NullPointerException("descriptor == null");
    if (paramc == null)
      throw new NullPointerException("returnType == null");
    if (paramb == null)
      throw new NullPointerException("parameterTypes == null");
    this.b = paramString;
    this.c = paramc;
    this.d = paramb;
    this.e = null;
  }

  public static a a(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("descriptor == null");
    synchronized (a)
    {
      a locala = (a)a.get(paramString);
      if (locala != null)
        return locala;
      c[] arrayOfc = b(paramString);
      int i = 0;
      int j = 1;
      int k = 0;
      int m = paramString.charAt(j);
      if (m == 41)
      {
        c localc = c.b(paramString.substring(j + 1));
        b localb = new b(k);
        while (i < k)
        {
          localb.a(i, arrayOfc[i]);
          i++;
        }
        return b(new a(paramString, localc, localb));
      }
      int n = j;
      while (m == 91)
      {
        n++;
        m = paramString.charAt(n);
      }
      int i1;
      if (m == 76)
      {
        int i2 = paramString.indexOf(';', n);
        if (i2 == -1)
          throw new IllegalArgumentException("bad descriptor");
        i1 = i2 + 1;
      }
      else
      {
        i1 = n + 1;
      }
      arrayOfc[k] = c.a(paramString.substring(j, i1));
      k++;
      j = i1;
    }
  }

  private static a b(a parama)
  {
    synchronized (a)
    {
      String str = parama.a();
      a locala = (a)a.get(str);
      if (locala != null)
        return locala;
      a.put(str, parama);
      return parama;
    }
  }

  private static c[] b(String paramString)
  {
    int i = paramString.length();
    if (paramString.charAt(0) != '(')
      throw new IllegalArgumentException("bad descriptor");
    int j = 1;
    int k = 0;
    int m;
    while (true)
    {
      m = 0;
      if (j >= i)
        break;
      int n = paramString.charAt(j);
      if (n == 41)
      {
        m = j;
        break;
      }
      if ((n >= 65) && (n <= 90))
        k++;
      j++;
    }
    if ((m != 0) && (m != i - 1))
    {
      if (paramString.indexOf(')', m + 1) != -1)
        throw new IllegalArgumentException("bad descriptor");
      return new c[k];
    }
    throw new IllegalArgumentException("bad descriptor");
  }

  public int a(a parama)
  {
    if (this == parama)
      return 0;
    int i = this.c.a(parama.c);
    if (i != 0)
      return i;
    int j = this.d.a();
    int k = parama.d.a();
    int m = Math.min(j, k);
    for (int n = 0; n < m; n++)
    {
      int i1 = this.d.b(n).a(parama.d.b(n));
      if (i1 != 0)
        return i1;
    }
    if (j < k)
      return -1;
    if (j > k)
      return 1;
    return 0;
  }

  public a a(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramc.e());
    localStringBuilder.append(this.b.substring(1));
    String str = localStringBuilder.toString();
    b localb = this.d.b(paramc);
    localb.e();
    return b(new a(str, this.c, localb));
  }

  public String a()
  {
    return this.b;
  }

  public c b()
  {
    return this.c;
  }

  public b c()
  {
    return this.d;
  }

  public b d()
  {
    if (this.e == null)
    {
      int i = this.d.a();
      b localb = new b(i);
      int j = 0;
      int k = 0;
      while (j < i)
      {
        c localc = this.d.b(j);
        if (localc.i())
        {
          localc = c.f;
          k = 1;
        }
        localb.a(j, localc);
        j++;
      }
      if (k == 0)
        localb = this.d;
      this.e = localb;
    }
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof a))
      return false;
    return this.b.equals(((a)paramObject).b);
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public String toString()
  {
    return this.b;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.d.a
 * JD-Core Version:    0.6.2
 */