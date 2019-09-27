package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public final class aq extends as
{
  private final TreeMap<c, ap> a = new TreeMap();

  public aq(l paraml)
  {
    super("type_ids", paraml, 4);
  }

  public ap a(com.android.cglib.dx.c.c.w paramw)
  {
    if (paramw == null)
      throw new NullPointerException("type == null");
    j();
    c localc = paramw.f();
    ap localap = (ap)this.a.get(localc);
    if (localap == null)
    {
      localap = new ap(paramw);
      this.a.put(localc, localap);
    }
    return localap;
  }

  public ap a(c paramc)
  {
    if (paramc == null)
      throw new NullPointerException("type == null");
    j();
    ap localap = (ap)this.a.get(paramc);
    if (localap == null)
    {
      localap = new ap(new com.android.cglib.dx.c.c.w(paramc));
      this.a.put(paramc, localap);
    }
    return localap;
  }

  public w a(com.android.cglib.dx.c.c.a parama)
  {
    if (parama == null)
      throw new NullPointerException("cst == null");
    i();
    c localc = ((com.android.cglib.dx.c.c.w)parama).f();
    w localw = (w)this.a.get(localc);
    if (localw == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("not found: ");
      localStringBuilder.append(parama);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return localw;
  }

  public Collection<? extends x> a()
  {
    return this.a.values();
  }

  public int b(com.android.cglib.dx.c.c.w paramw)
  {
    if (paramw == null)
      throw new NullPointerException("type == null");
    return b(paramw.f());
  }

  public int b(c paramc)
  {
    if (paramc == null)
      throw new NullPointerException("type == null");
    i();
    ap localap = (ap)this.a.get(paramc);
    if (localap == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("not found: ");
      localStringBuilder.append(paramc);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return localap.g();
  }

  protected void b()
  {
    Iterator localIterator = a().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      ((ap)localIterator.next()).a(i);
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
    if (i > 65536)
      throw new UnsupportedOperationException("too many type ids");
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("type_ids_size:   ");
      localStringBuilder1.append(i.a(i));
      parama.a(4, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("type_ids_off:    ");
      localStringBuilder2.append(i.a(j));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    parama.d(j);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.aq
 * JD-Core Version:    0.6.2
 */