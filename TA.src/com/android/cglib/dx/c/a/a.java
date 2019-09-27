package com.android.cglib.dx.c.a;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.d.o;
import com.android.cglib.dx.d.r;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public final class a extends o
  implements r, Comparable<a>
{
  private final w a;
  private final b b;
  private final TreeMap<v, d> c;

  public int a(a parama)
  {
    int i = this.a.a(parama.a);
    if (i != 0)
      return i;
    int j = this.b.compareTo(parama.b);
    if (j != 0)
      return j;
    Iterator localIterator1 = this.c.values().iterator();
    Iterator localIterator2 = parama.c.values().iterator();
    while ((localIterator1.hasNext()) && (localIterator2.hasNext()))
    {
      int k = ((d)localIterator1.next()).a((d)localIterator2.next());
      if (k != 0)
        return k;
    }
    if (localIterator1.hasNext())
      return 1;
    if (localIterator2.hasNext())
      return -1;
    return 0;
  }

  public String a_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.a_());
    localStringBuilder.append("-annotation ");
    localStringBuilder.append(this.a.a_());
    localStringBuilder.append(" {");
    Iterator localIterator = this.c.values().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (i != 0)
        i = 0;
      else
        localStringBuilder.append(", ");
      localStringBuilder.append(locald.a().a_());
      localStringBuilder.append(": ");
      localStringBuilder.append(locald.b().a_());
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public w b()
  {
    return this.a;
  }

  public b c()
  {
    return this.b;
  }

  public Collection<d> d()
  {
    return Collections.unmodifiableCollection(this.c.values());
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a))
      return false;
    a locala = (a)paramObject;
    if (this.a.equals(locala.a))
    {
      if (this.b != locala.b)
        return false;
      return this.c.equals(locala.c);
    }
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * this.a.hashCode() + this.c.hashCode()) + this.b.hashCode();
  }

  public String toString()
  {
    return a_();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.a.a
 * JD-Core Version:    0.6.2
 */