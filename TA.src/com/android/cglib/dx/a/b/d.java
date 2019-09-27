package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class d extends ag
{
  private b a = null;
  private ArrayList<q> b = null;
  private ArrayList<ac> c = null;
  private ArrayList<ah> d = null;

  public d()
  {
    super(4, -1);
  }

  private static int a(ArrayList<?> paramArrayList)
  {
    if (paramArrayList == null)
      return 0;
    return paramArrayList.size();
  }

  public int a(ag paramag)
  {
    if (!d())
      throw new UnsupportedOperationException("uninternable instance");
    d locald = (d)paramag;
    return this.a.c(locald.a);
  }

  public y a()
  {
    return y.r;
  }

  protected void a(ak paramak, int paramInt)
  {
    a(16 + 8 * (a(this.b) + a(this.c) + a(this.d)));
  }

  public void a(l paraml)
  {
    af localaf = paraml.d();
    if (this.a != null)
      this.a = ((b)localaf.b(this.a));
    if (this.b != null)
    {
      Iterator localIterator3 = this.b.iterator();
      while (localIterator3.hasNext())
        ((q)localIterator3.next()).a(paraml);
    }
    if (this.c != null)
    {
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
        ((ac)localIterator2.next()).a(paraml);
    }
    if (this.d != null)
    {
      Iterator localIterator1 = this.d.iterator();
      while (localIterator1.hasNext())
        ((ah)localIterator1.next()).a(paraml);
    }
  }

  protected void a_(l paraml, a parama)
  {
    boolean bool = parama.a();
    int i = ag.b(this.a);
    int j = a(this.b);
    int k = a(this.c);
    int m = a(this.d);
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(" annotations directory");
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  class_annotations_off: ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("  fields_size:           ");
      localStringBuilder3.append(i.a(j));
      parama.a(4, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  methods_size:          ");
      localStringBuilder4.append(i.a(k));
      parama.a(4, localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("  parameters_size:       ");
      localStringBuilder5.append(i.a(m));
      parama.a(4, localStringBuilder5.toString());
    }
    parama.d(i);
    parama.d(j);
    parama.d(k);
    parama.d(m);
    if (j != 0)
    {
      Collections.sort(this.b);
      if (bool)
        parama.a(0, "  fields:");
      Iterator localIterator3 = this.b.iterator();
      while (localIterator3.hasNext())
        ((q)localIterator3.next()).a(paraml, parama);
    }
    if (k != 0)
    {
      Collections.sort(this.c);
      if (bool)
        parama.a(0, "  methods:");
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
        ((ac)localIterator2.next()).a(paraml, parama);
    }
    if (m != 0)
    {
      Collections.sort(this.d);
      if (bool)
        parama.a(0, "  parameters:");
      Iterator localIterator1 = this.d.iterator();
      while (localIterator1.hasNext())
        ((ah)localIterator1.next()).a(paraml, parama);
    }
  }

  public String b()
  {
    throw new RuntimeException("unsupported");
  }

  public boolean c()
  {
    return (this.a == null) && (this.b == null) && (this.c == null) && (this.d == null);
  }

  public boolean d()
  {
    return (this.a != null) && (this.b == null) && (this.c == null) && (this.d == null);
  }

  public int hashCode()
  {
    if (this.a == null)
      return 0;
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.d
 * JD-Core Version:    0.6.2
 */