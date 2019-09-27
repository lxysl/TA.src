package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;

public final class an extends w
  implements Comparable
{
  private final v a;
  private am b;

  public an(v paramv)
  {
    if (paramv == null)
      throw new NullPointerException("value == null");
    this.a = paramv;
    this.b = null;
  }

  public y a()
  {
    return y.b;
  }

  public void a(l paraml)
  {
    if (this.b == null)
    {
      af localaf = paraml.c();
      this.b = new am(this.a);
      localaf.a(this.b);
    }
  }

  public void a(l paraml, a parama)
  {
    int i = this.b.e();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(h());
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.a.a(100));
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  string_data_off: ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
  }

  public int b_()
  {
    return 4;
  }

  public v c()
  {
    return this.a;
  }

  public int compareTo(Object paramObject)
  {
    an localan = (an)paramObject;
    return this.a.a(localan.a);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof an))
      return false;
    an localan = (an)paramObject;
    return this.a.equals(localan.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.an
 * JD-Core Version:    0.6.2
 */