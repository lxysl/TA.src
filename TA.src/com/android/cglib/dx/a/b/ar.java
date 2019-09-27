package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;

public final class ar extends ag
{
  private final e a;

  public ar(e parame)
  {
    super(4, 4 + 2 * parame.a());
    this.a = parame;
  }

  protected int a(ag paramag)
  {
    return b.a(this.a, ((ar)paramag).a);
  }

  public y a()
  {
    return y.i;
  }

  public void a(l paraml)
  {
    aq localaq = paraml.j();
    int i = this.a.a();
    for (int j = 0; j < i; j++)
      localaq.a(this.a.a(j));
  }

  protected void a_(l paraml, a parama)
  {
    aq localaq = paraml.j();
    int i = this.a.a();
    boolean bool = parama.a();
    int j = 0;
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(" type_list");
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  size: ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
      for (int k = 0; k < i; k++)
      {
        c localc = this.a.a(k);
        int m = localaq.b(localc);
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("  ");
        localStringBuilder3.append(i.c(m));
        localStringBuilder3.append(" // ");
        localStringBuilder3.append(localc.a_());
        parama.a(2, localStringBuilder3.toString());
      }
    }
    parama.d(i);
    while (j < i)
    {
      parama.c(localaq.b(this.a.a(j)));
      j++;
    }
  }

  public String b()
  {
    throw new RuntimeException("unsupported");
  }

  public e c()
  {
    return this.a;
  }

  public int hashCode()
  {
    return b.b(this.a);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ar
 * JD-Core Version:    0.6.2
 */