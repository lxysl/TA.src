package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import com.android.cglib.dx.d.r;

public final class q
  implements r, Comparable<q>
{
  private final j a;
  private b b;

  public int a(q paramq)
  {
    return this.a.a(paramq.a);
  }

  public void a(l paraml)
  {
    s locals = paraml.l();
    af localaf = paraml.d();
    locals.a(this.a);
    this.b = ((b)localaf.b(this.b));
  }

  public void a(l paraml, a parama)
  {
    int i = paraml.l().b(this.a);
    int j = this.b.e();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("    ");
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("      field_idx:       ");
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
    if (!(paramObject instanceof q))
      return false;
    return this.a.equals(((q)paramObject).a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.q
 * JD-Core Version:    0.6.2
 */