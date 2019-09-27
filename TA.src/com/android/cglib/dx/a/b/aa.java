package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.r;
import com.android.cglib.dx.c.c.t;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;

public abstract class aa extends v
{
  private final r a;

  public aa(r paramr)
  {
    super(paramr.g());
    this.a = paramr;
  }

  public void a(l paraml)
  {
    super.a(paraml);
    paraml.g().a(j().h().b());
  }

  public final void a(l paraml, a parama)
  {
    aq localaq = paraml.j();
    ao localao = paraml.g();
    t localt = this.a.h();
    int i = localaq.b(e());
    int j = localao.b(localt.b());
    int k = b(paraml);
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(h());
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  class_idx: ");
      localStringBuilder2.append(i.c(i));
      parama.a(2, localStringBuilder2.toString());
      Object[] arrayOfObject = new Object[2];
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(d());
      localStringBuilder3.append(':');
      arrayOfObject[0] = localStringBuilder3.toString();
      arrayOfObject[1] = i.c(k);
      parama.a(2, String.format("  %-10s %s", arrayOfObject));
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  name_idx:  ");
      localStringBuilder4.append(i.a(j));
      parama.a(4, localStringBuilder4.toString());
    }
    parama.c(i);
    parama.c(k);
    parama.d(j);
  }

  protected abstract int b(l paraml);

  public int b_()
  {
    return 8;
  }

  protected abstract String d();

  public final r j()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.aa
 * JD-Core Version:    0.6.2
 */