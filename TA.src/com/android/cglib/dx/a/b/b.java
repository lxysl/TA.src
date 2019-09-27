package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.a.c;
import com.android.cglib.dx.d.i;

public final class b extends ag
{
  private final c a;
  private final a[] b;

  protected int a(ag paramag)
  {
    b localb = (b)paramag;
    return this.a.a(localb.a);
  }

  public y a()
  {
    return y.k;
  }

  protected void a(ak paramak, int paramInt)
  {
    a.a(this.b);
  }

  public void a(l paraml)
  {
    af localaf = paraml.n();
    int i = this.b.length;
    for (int j = 0; j < i; j++)
      this.b[j] = ((a)localaf.b(this.b[j]));
  }

  protected void a_(l paraml, com.android.cglib.dx.d.a parama)
  {
    boolean bool = parama.a();
    int i = this.b.length;
    int j = 0;
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(" annotation set");
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  size: ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    while (j < i)
    {
      int k = this.b[j].e();
      if (bool)
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("  entries[");
        localStringBuilder3.append(Integer.toHexString(j));
        localStringBuilder3.append("]: ");
        localStringBuilder3.append(i.a(k));
        parama.a(4, localStringBuilder3.toString());
        this.b[j].a(parama, "    ");
      }
      parama.d(k);
      j++;
    }
  }

  public String b()
  {
    return this.a.toString();
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.b
 * JD-Core Version:    0.6.2
 */