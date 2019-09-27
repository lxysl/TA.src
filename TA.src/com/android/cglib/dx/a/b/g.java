package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.i;

public final class g extends w
{
  private final com.android.cglib.dx.c.c.w a;
  private final int b;
  private final com.android.cglib.dx.c.c.w c;
  private ar d;
  private final v e;
  private final f f;
  private m g;
  private d h;

  public g(com.android.cglib.dx.c.c.w paramw1, int paramInt, com.android.cglib.dx.c.c.w paramw2, e parame, v paramv)
  {
    if (paramw1 == null)
      throw new NullPointerException("thisClass == null");
    if (parame == null)
      throw new NullPointerException("interfaces == null");
    this.a = paramw1;
    this.b = paramInt;
    this.c = paramw2;
    ar localar;
    if (parame.a() == 0)
      localar = null;
    else
      localar = new ar(parame);
    this.d = localar;
    this.e = paramv;
    this.f = new f(paramw1);
    this.g = null;
    this.h = new d();
  }

  public y a()
  {
    return y.g;
  }

  public void a(l paraml)
  {
    aq localaq = paraml.j();
    af localaf1 = paraml.n();
    af localaf2 = paraml.d();
    af localaf3 = paraml.e();
    ao localao = paraml.g();
    localaq.a(this.a);
    if (!this.f.c())
    {
      paraml.i().a(this.f);
      com.android.cglib.dx.c.c.c localc = this.f.d();
      if (localc != null)
        this.g = ((m)localaf1.b(new m(localc)));
    }
    if (this.c != null)
      localaq.a(this.c);
    if (this.d != null)
      this.d = ((ar)localaf3.b(this.d));
    if (this.e != null)
      localao.a(this.e);
    if (!this.h.c())
    {
      if (this.h.d())
      {
        this.h = ((d)localaf2.b(this.h));
        return;
      }
      localaf2.a(this.h);
    }
  }

  public void a(l paraml, com.android.cglib.dx.d.a parama)
  {
    boolean bool = parama.a();
    aq localaq = paraml.j();
    int i = localaq.b(this.a);
    com.android.cglib.dx.c.c.w localw = this.c;
    int j = -1;
    int k;
    if (localw == null)
      k = -1;
    else
      k = localaq.b(this.c);
    int m = ag.b(this.d);
    int n;
    if (this.h.c())
      n = 0;
    else
      n = this.h.e();
    if (this.e != null)
      j = paraml.g().b(this.e);
    int i1;
    if (this.f.c())
      i1 = 0;
    else
      i1 = this.f.e();
    int i2 = ag.b(this.g);
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(h());
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  class_idx:           ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("  access_flags:        ");
      localStringBuilder3.append(com.android.cglib.dx.c.b.a.a(this.b));
      parama.a(4, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  superclass_idx:      ");
      localStringBuilder4.append(i.a(k));
      localStringBuilder4.append(" // ");
      String str1;
      if (this.c == null)
        str1 = "<none>";
      else
        str1 = this.c.a_();
      localStringBuilder4.append(str1);
      parama.a(4, localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("  interfaces_off:      ");
      localStringBuilder5.append(i.a(m));
      parama.a(4, localStringBuilder5.toString());
      if (m != 0)
      {
        e locale = this.d.c();
        int i3 = locale.a();
        for (int i4 = 0; i4 < i3; i4++)
        {
          StringBuilder localStringBuilder10 = new StringBuilder();
          localStringBuilder10.append("    ");
          localStringBuilder10.append(locale.a(i4).a_());
          parama.a(0, localStringBuilder10.toString());
        }
      }
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("  source_file_idx:     ");
      localStringBuilder6.append(i.a(j));
      localStringBuilder6.append(" // ");
      String str2;
      if (this.e == null)
        str2 = "<none>";
      else
        str2 = this.e.a_();
      localStringBuilder6.append(str2);
      parama.a(4, localStringBuilder6.toString());
      StringBuilder localStringBuilder7 = new StringBuilder();
      localStringBuilder7.append("  annotations_off:     ");
      localStringBuilder7.append(i.a(n));
      parama.a(4, localStringBuilder7.toString());
      StringBuilder localStringBuilder8 = new StringBuilder();
      localStringBuilder8.append("  class_data_off:      ");
      localStringBuilder8.append(i.a(i1));
      parama.a(4, localStringBuilder8.toString());
      StringBuilder localStringBuilder9 = new StringBuilder();
      localStringBuilder9.append("  static_values_off:   ");
      localStringBuilder9.append(i.a(i2));
      parama.a(4, localStringBuilder9.toString());
    }
    parama.d(i);
    parama.d(this.b);
    parama.d(k);
    parama.d(m);
    parama.d(j);
    parama.d(n);
    parama.d(i1);
    parama.d(i2);
  }

  public void a(n paramn)
  {
    this.f.a(paramn);
  }

  public void a(n paramn, com.android.cglib.dx.c.c.a parama)
  {
    this.f.a(paramn, parama);
  }

  public void a(p paramp)
  {
    this.f.a(paramp);
  }

  public void b(p paramp)
  {
    this.f.b(paramp);
  }

  public int b_()
  {
    return 32;
  }

  public com.android.cglib.dx.c.c.w c()
  {
    return this.a;
  }

  public com.android.cglib.dx.c.c.w d()
  {
    return this.c;
  }

  public e e()
  {
    if (this.d == null)
      return b.a;
    return this.d.c();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.g
 * JD-Core Version:    0.6.2
 */