package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.d.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public final class ao extends as
{
  private final TreeMap<v, an> a = new TreeMap();

  public ao(l paraml)
  {
    super("string_ids", paraml, 4);
  }

  public an a(an paraman)
  {
    if (paraman == null)
      throw new NullPointerException("string == null");
    j();
    v localv = paraman.c();
    an localan = (an)this.a.get(localv);
    if (localan != null)
      return localan;
    this.a.put(localv, paraman);
    return paraman;
  }

  public an a(v paramv)
  {
    return a(new an(paramv));
  }

  public w a(com.android.cglib.dx.c.c.a parama)
  {
    if (parama == null)
      throw new NullPointerException("cst == null");
    i();
    w localw = (w)this.a.get((v)parama);
    if (localw == null)
      throw new IllegalArgumentException("not found");
    return localw;
  }

  public Collection<? extends x> a()
  {
    return this.a.values();
  }

  public int b(v paramv)
  {
    if (paramv == null)
      throw new NullPointerException("string == null");
    i();
    an localan = (an)this.a.get(paramv);
    if (localan == null)
      throw new IllegalArgumentException("not found");
    return localan.g();
  }

  protected void b()
  {
    Iterator localIterator = this.a.values().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      ((an)localIterator.next()).a(i);
  }

  public void b(com.android.cglib.dx.d.a parama)
  {
    i();
    int i = this.a.size();
    int j;
    if (i == 0)
      j = 0;
    else
      j = g();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("string_ids_size: ");
      localStringBuilder1.append(i.a(i));
      parama.a(4, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("string_ids_off:  ");
      localStringBuilder2.append(i.a(j));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    parama.d(j);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ao
 * JD-Core Version:    0.6.2
 */