package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.d.i;

public final class n extends o
  implements Comparable<n>
{
  private final j a;

  public n(j paramj, int paramInt)
  {
    super(paramInt);
    if (paramj == null)
      throw new NullPointerException("field == null");
    this.a = paramj;
  }

  public int a(l paraml, com.android.cglib.dx.d.a parama, int paramInt1, int paramInt2)
  {
    int i = paraml.l().b(this.a);
    int j = i - paramInt1;
    int k = c();
    if (parama.a())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      arrayOfObject[1] = this.a.a_();
      parama.a(0, String.format("  [%x] %s", arrayOfObject));
      int m = com.android.cglib.dx.d.n.a(j);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("    field_idx:    ");
      localStringBuilder1.append(i.a(i));
      parama.a(m, localStringBuilder1.toString());
      int n = com.android.cglib.dx.d.n.a(k);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("    access_flags: ");
      localStringBuilder2.append(com.android.cglib.dx.c.b.a.b(k));
      parama.a(n, localStringBuilder2.toString());
    }
    parama.e(j);
    parama.e(k);
    return i;
  }

  public int a(n paramn)
  {
    return this.a.a(paramn.a);
  }

  public void a(l paraml)
  {
    paraml.l().a(this.a);
  }

  public String a_()
  {
    return this.a.a_();
  }

  public j b()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof n))
      return false;
    int i = a((n)paramObject);
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(i.c(c()));
    localStringBuffer.append(' ');
    localStringBuffer.append(this.a);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.n
 * JD-Core Version:    0.6.2
 */