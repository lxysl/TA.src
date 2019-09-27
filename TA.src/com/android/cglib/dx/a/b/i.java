package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.a.g.a;
import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;
import java.util.HashSet;
import java.util.Iterator;

public final class i extends ag
{
  private final s a;
  private final com.android.cglib.dx.a.a.g b;
  private e c;
  private final boolean d;
  private final com.android.cglib.dx.c.d.e e;
  private k f;

  public i(s params, com.android.cglib.dx.a.a.g paramg, boolean paramBoolean, com.android.cglib.dx.c.d.e parame)
  {
    super(4, -1);
    if (params == null)
      throw new NullPointerException("ref == null");
    if (paramg == null)
      throw new NullPointerException("code == null");
    if (parame == null)
      throw new NullPointerException("throwsList == null");
    this.a = params;
    this.b = paramg;
    this.d = paramBoolean;
    this.e = parame;
    this.c = null;
    this.f = null;
  }

  private void b(l paraml, com.android.cglib.dx.d.a parama)
  {
    com.android.cglib.dx.a.a.i locali = this.b.f();
    try
    {
      locali.a(parama);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("...while writing instructions for ");
      localStringBuilder.append(this.a.a_());
      throw com.android.cglib.dx.d.g.a(localRuntimeException, localStringBuilder.toString());
    }
  }

  private int c()
  {
    return this.a.b(this.d);
  }

  private int d()
  {
    return this.b.f().d();
  }

  private int h()
  {
    return this.b.f().c();
  }

  public y a()
  {
    return y.m;
  }

  protected void a(ak paramak, int paramInt)
  {
    final l locall = paramak.e();
    this.b.a(new g.a()
    {
      public int a(com.android.cglib.dx.c.c.a paramAnonymousa)
      {
        w localw = locall.b(paramAnonymousa);
        if (localw == null)
          return -1;
        return localw.g();
      }
    });
    int i;
    if (this.c != null)
    {
      this.c.a(locall);
      i = this.c.b();
    }
    else
    {
      i = 0;
    }
    int j = this.b.f().b();
    if ((j & 0x1) != 0)
      j++;
    a(i + (16 + j * 2));
  }

  public void a(l paraml)
  {
    af localaf = paraml.n();
    aq localaq = paraml.j();
    if ((this.b.a()) || (this.b.b()))
    {
      this.f = new k(this.b, this.d, this.a);
      localaf.a(this.f);
    }
    if (this.b.c())
    {
      Iterator localIterator2 = this.b.d().iterator();
      while (localIterator2.hasNext())
        localaq.a((c)localIterator2.next());
      this.c = new e(this.b);
    }
    Iterator localIterator1 = this.b.e().iterator();
    while (localIterator1.hasNext())
      paraml.a((com.android.cglib.dx.c.c.a)localIterator1.next());
  }

  protected void a_(l paraml, com.android.cglib.dx.d.a parama)
  {
    boolean bool = parama.a();
    int i = h();
    int j = d();
    int k = c();
    int m = this.b.f().b();
    int n;
    if ((m & 0x1) != 0)
      n = 1;
    else
      n = 0;
    int i1;
    if (this.c == null)
      i1 = 0;
    else
      i1 = this.c.a();
    int i2;
    if (this.f == null)
      i2 = 0;
    else
      i2 = this.f.e();
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  registers_size: ");
      localStringBuilder2.append(com.android.cglib.dx.d.i.c(i));
      parama.a(2, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("  ins_size:       ");
      localStringBuilder3.append(com.android.cglib.dx.d.i.c(k));
      parama.a(2, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  outs_size:      ");
      localStringBuilder4.append(com.android.cglib.dx.d.i.c(j));
      parama.a(2, localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("  tries_size:     ");
      localStringBuilder5.append(com.android.cglib.dx.d.i.c(i1));
      parama.a(2, localStringBuilder5.toString());
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("  debug_off:      ");
      localStringBuilder6.append(com.android.cglib.dx.d.i.a(i2));
      parama.a(4, localStringBuilder6.toString());
      StringBuilder localStringBuilder7 = new StringBuilder();
      localStringBuilder7.append("  insns_size:     ");
      localStringBuilder7.append(com.android.cglib.dx.d.i.a(m));
      parama.a(4, localStringBuilder7.toString());
      if (this.e.a() != 0)
      {
        StringBuilder localStringBuilder8 = new StringBuilder();
        localStringBuilder8.append("  throws ");
        localStringBuilder8.append(b.a(this.e));
        parama.a(0, localStringBuilder8.toString());
      }
    }
    parama.c(i);
    parama.c(k);
    parama.c(j);
    parama.c(i1);
    parama.d(i2);
    parama.d(m);
    b(paraml, parama);
    if (this.c != null)
    {
      if (n != 0)
      {
        if (bool)
          parama.a(2, "  padding: 0");
        parama.c(0);
      }
      this.c.a(paraml, parama);
    }
    if ((bool) && (this.f != null))
    {
      parama.a(0, "  debug info");
      this.f.a(paraml, parama, "    ");
    }
  }

  public String b()
  {
    return this.a.a_();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CodeItem{");
    localStringBuilder.append(b());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.i
 * JD-Core Version:    0.6.2
 */