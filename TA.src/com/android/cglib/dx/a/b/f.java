package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.c;
import com.android.cglib.dx.c.c.c.a;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public final class f extends ag
{
  private final w a;
  private final ArrayList<n> b;
  private final HashMap<n, com.android.cglib.dx.c.c.a> c;
  private final ArrayList<n> d;
  private final ArrayList<p> e;
  private final ArrayList<p> f;
  private c g;
  private byte[] h;

  public f(w paramw)
  {
    super(1, -1);
    if (paramw == null)
      throw new NullPointerException("thisClass == null");
    this.a = paramw;
    this.b = new ArrayList(20);
    this.c = new HashMap(40);
    this.d = new ArrayList(20);
    this.e = new ArrayList(20);
    this.f = new ArrayList(20);
    this.g = null;
  }

  private static void a(l paraml, com.android.cglib.dx.d.a parama, String paramString, int paramInt)
  {
    if (parama.a())
    {
      Object[] arrayOfObject = new Object[2];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_size:");
      arrayOfObject[0] = localStringBuilder.toString();
      arrayOfObject[1] = Integer.valueOf(paramInt);
      parama.a(String.format("  %-21s %08x", arrayOfObject));
    }
    parama.e(paramInt);
  }

  private static void a(l paraml, com.android.cglib.dx.d.a parama, String paramString, ArrayList<? extends o> paramArrayList)
  {
    int i = paramArrayList.size();
    if (i == 0)
      return;
    boolean bool = parama.a();
    int j = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(":");
      parama.a(0, localStringBuilder.toString());
    }
    int k = 0;
    while (j < i)
    {
      k = ((o)paramArrayList.get(j)).a(paraml, parama, k, j);
      j++;
    }
  }

  private void b(l paraml, com.android.cglib.dx.d.a parama)
  {
    boolean bool = parama.a();
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g());
      localStringBuilder.append(" class data for ");
      localStringBuilder.append(this.a.a_());
      parama.a(0, localStringBuilder.toString());
    }
    a(paraml, parama, "static_fields", this.b.size());
    a(paraml, parama, "instance_fields", this.d.size());
    a(paraml, parama, "direct_methods", this.e.size());
    a(paraml, parama, "virtual_methods", this.f.size());
    a(paraml, parama, "static_fields", this.b);
    a(paraml, parama, "instance_fields", this.d);
    a(paraml, parama, "direct_methods", this.e);
    a(paraml, parama, "virtual_methods", this.f);
    if (bool)
      parama.c();
  }

  private c h()
  {
    Collections.sort(this.b);
    for (int i = this.b.size(); i > 0; i--)
    {
      n localn2 = (n)this.b.get(i - 1);
      com.android.cglib.dx.c.c.a locala2 = (com.android.cglib.dx.c.c.a)this.c.get(localn2);
      if ((locala2 instanceof com.android.cglib.dx.c.c.p) ? ((com.android.cglib.dx.c.c.p)locala2).h() != 0L : locala2 != null)
        break;
    }
    if (i == 0)
      return null;
    c.a locala = new c.a(i);
    for (int j = 0; j < i; j++)
    {
      n localn1 = (n)this.b.get(j);
      com.android.cglib.dx.c.c.a locala1 = (com.android.cglib.dx.c.c.a)this.c.get(localn1);
      if (locala1 == null)
        locala1 = com.android.cglib.dx.c.c.y.a(localn1.b().b());
      locala.a(j, locala1);
    }
    locala.e();
    return new c(locala);
  }

  public y a()
  {
    return y.l;
  }

  protected void a(ak paramak, int paramInt)
  {
    d locald = new d();
    b(paramak.e(), locald);
    this.h = locald.f();
    a(this.h.length);
  }

  public void a(l paraml)
  {
    if (!this.b.isEmpty())
    {
      d();
      Iterator localIterator4 = this.b.iterator();
      while (localIterator4.hasNext())
        ((n)localIterator4.next()).a(paraml);
    }
    if (!this.d.isEmpty())
    {
      Collections.sort(this.d);
      Iterator localIterator3 = this.d.iterator();
      while (localIterator3.hasNext())
        ((n)localIterator3.next()).a(paraml);
    }
    if (!this.e.isEmpty())
    {
      Collections.sort(this.e);
      Iterator localIterator2 = this.e.iterator();
      while (localIterator2.hasNext())
        ((p)localIterator2.next()).a(paraml);
    }
    if (!this.f.isEmpty())
    {
      Collections.sort(this.f);
      Iterator localIterator1 = this.f.iterator();
      while (localIterator1.hasNext())
        ((p)localIterator1.next()).a(paraml);
    }
  }

  public void a(n paramn)
  {
    if (paramn == null)
      throw new NullPointerException("field == null");
    this.d.add(paramn);
  }

  public void a(n paramn, com.android.cglib.dx.c.c.a parama)
  {
    if (paramn == null)
      throw new NullPointerException("field == null");
    if (this.g != null)
      throw new UnsupportedOperationException("static fields already sorted");
    this.b.add(paramn);
    this.c.put(paramn, parama);
  }

  public void a(p paramp)
  {
    if (paramp == null)
      throw new NullPointerException("method == null");
    this.e.add(paramp);
  }

  public void a_(l paraml, com.android.cglib.dx.d.a parama)
  {
    if (parama.a())
    {
      b(paraml, parama);
      return;
    }
    parama.a(this.h);
  }

  public String b()
  {
    return toString();
  }

  public void b(p paramp)
  {
    if (paramp == null)
      throw new NullPointerException("method == null");
    this.f.add(paramp);
  }

  public boolean c()
  {
    return (this.b.isEmpty()) && (this.d.isEmpty()) && (this.e.isEmpty()) && (this.f.isEmpty());
  }

  public c d()
  {
    if ((this.g == null) && (this.b.size() != 0))
      this.g = h();
    return this.g;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.f
 * JD-Core Version:    0.6.2
 */