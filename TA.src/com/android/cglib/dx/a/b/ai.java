package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class ai extends w
{
  private final com.android.cglib.dx.c.d.a a;
  private final v b;
  private ar c;

  public ai(com.android.cglib.dx.c.d.a parama)
  {
    if (parama == null)
      throw new NullPointerException("prototype == null");
    this.a = parama;
    this.b = a(parama);
    b localb = parama.c();
    ar localar;
    if (localb.a() == 0)
      localar = null;
    else
      localar = new ar(localb);
    this.c = localar;
  }

  private static char a(c paramc)
  {
    char c1 = paramc.e().charAt(0);
    if (c1 == '[')
      c1 = 'L';
    return c1;
  }

  private static v a(com.android.cglib.dx.c.d.a parama)
  {
    b localb = parama.c();
    int i = localb.a();
    StringBuilder localStringBuilder = new StringBuilder(i + 1);
    localStringBuilder.append(a(parama.b()));
    for (int j = 0; j < i; j++)
      localStringBuilder.append(a(localb.a(j)));
    return new v(localStringBuilder.toString());
  }

  public y a()
  {
    return y.d;
  }

  public void a(l paraml)
  {
    ao localao = paraml.g();
    aq localaq = paraml.j();
    af localaf = paraml.e();
    localaq.a(this.a.b());
    localao.a(this.b);
    if (this.c != null)
      this.c = ((ar)localaf.b(this.c));
  }

  public void a(l paraml, com.android.cglib.dx.d.a parama)
  {
    int i = paraml.g().b(this.b);
    int j = paraml.j().b(this.a.b());
    int k = ag.b(this.c);
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.a.b().a_());
      localStringBuilder1.append(" proto(");
      b localb = this.a.c();
      int m = localb.a();
      for (int n = 0; n < m; n++)
      {
        if (n != 0)
          localStringBuilder1.append(", ");
        localStringBuilder1.append(localb.a(n).a_());
      }
      localStringBuilder1.append(")");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(h());
      localStringBuilder2.append(' ');
      localStringBuilder2.append(localStringBuilder1.toString());
      parama.a(0, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("  shorty_idx:      ");
      localStringBuilder3.append(i.a(i));
      localStringBuilder3.append(" // ");
      localStringBuilder3.append(this.b.f());
      parama.a(4, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  return_type_idx: ");
      localStringBuilder4.append(i.a(j));
      localStringBuilder4.append(" // ");
      localStringBuilder4.append(this.a.b().a_());
      parama.a(4, localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("  parameters_off:  ");
      localStringBuilder5.append(i.a(k));
      parama.a(4, localStringBuilder5.toString());
    }
    parama.d(i);
    parama.d(j);
    parama.d(k);
  }

  public int b_()
  {
    return 12;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ai
 * JD-Core Version:    0.6.2
 */