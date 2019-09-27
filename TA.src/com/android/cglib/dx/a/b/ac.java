package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import com.android.cglib.dx.d.r;

public final class ac
  implements r, Comparable<ac>
{
  private final s a;
  private b b;

  public int a(ac paramac)
  {
    return this.a.a(paramac.a);
  }

  public void a(l paraml)
  {
    ae localae = paraml.m();
    af localaf = paraml.d();
    localae.a(this.a);
    this.b = ((b)localaf.b(this.b));
  }

  public void a(l paraml, a parama)
  {
    int i = paraml.m().b(this.a);
    int j = this.b.e();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("    ");
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("      method_idx:      ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("      annotations_off: ");
      localStringBuilder3.append(i.a(j));
      parama.a(4, localStringBuilder3.toString());
    }
    parama.d(i);
    parama.d(j);
  }

  public String a_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a_());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ac))
      return false;
    return this.a.equals(((ac)paramObject).a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ac
 * JD-Core Version:    0.6.2
 */