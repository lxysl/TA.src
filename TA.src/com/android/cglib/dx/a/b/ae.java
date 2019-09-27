package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.d;
import com.android.cglib.dx.d.i;
import java.util.Collection;
import java.util.TreeMap;

public final class ae extends ab
{
  private final TreeMap<d, ad> a = new TreeMap();

  public ae(l paraml)
  {
    super("method_ids", paraml);
  }

  public ad a(d paramd)
  {
    if (paramd == null)
      throw new NullPointerException("method == null");
    j();
    ad localad = (ad)this.a.get(paramd);
    if (localad == null)
    {
      localad = new ad(paramd);
      this.a.put(paramd, localad);
    }
    return localad;
  }

  public w a(com.android.cglib.dx.c.c.a parama)
  {
    if (parama == null)
      throw new NullPointerException("cst == null");
    i();
    w localw = (w)this.a.get((d)parama);
    if (localw == null)
      throw new IllegalArgumentException("not found");
    return localw;
  }

  public Collection<? extends x> a()
  {
    return this.a.values();
  }

  public void a(com.android.cglib.dx.d.a parama)
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
      localStringBuilder1.append("method_ids_size: ");
      localStringBuilder1.append(i.a(i));
      parama.a(4, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("method_ids_off:  ");
      localStringBuilder2.append(i.a(j));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    parama.d(j);
  }

  public int b(d paramd)
  {
    if (paramd == null)
      throw new NullPointerException("ref == null");
    i();
    ad localad = (ad)this.a.get(paramd);
    if (localad == null)
      throw new IllegalArgumentException("not found");
    return localad.g();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ae
 * JD-Core Version:    0.6.2
 */