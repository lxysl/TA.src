package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.a.g;
import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.n;

public final class p extends o
  implements Comparable<p>
{
  private final s a;
  private final i b;

  public p(s params, int paramInt, g paramg, e parame)
  {
    super(paramInt);
    if (params == null)
      throw new NullPointerException("method == null");
    this.a = params;
    if (paramg == null)
    {
      this.b = null;
      return;
    }
    boolean bool;
    if ((paramInt & 0x8) != 0)
      bool = true;
    else
      bool = false;
    this.b = new i(params, paramg, bool, parame);
  }

  public int a(l paraml, com.android.cglib.dx.d.a parama, int paramInt1, int paramInt2)
  {
    int i = paraml.m().b(this.a);
    int j = i - paramInt1;
    int k = c();
    int m = ag.b(this.b);
    int n;
    if (m != 0)
      n = 1;
    else
      n = 0;
    int i1;
    if ((k & 0x500) == 0)
      i1 = 1;
    else
      i1 = 0;
    if (n != i1)
      throw new UnsupportedOperationException("code vs. access_flags mismatch");
    if (parama.a())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      arrayOfObject[1] = this.a.a_();
      parama.a(0, String.format("  [%x] %s", arrayOfObject));
      int i2 = n.a(j);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("    method_idx:   ");
      localStringBuilder1.append(com.android.cglib.dx.d.i.a(i));
      parama.a(i2, localStringBuilder1.toString());
      int i3 = n.a(k);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("    access_flags: ");
      localStringBuilder2.append(com.android.cglib.dx.c.b.a.c(k));
      parama.a(i3, localStringBuilder2.toString());
      int i4 = n.a(m);
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("    code_off:     ");
      localStringBuilder3.append(com.android.cglib.dx.d.i.a(m));
      parama.a(i4, localStringBuilder3.toString());
    }
    parama.e(j);
    parama.e(k);
    parama.e(m);
    return i;
  }

  public int a(p paramp)
  {
    return this.a.a(paramp.a);
  }

  public void a(l paraml)
  {
    ae localae = paraml.m();
    af localaf = paraml.d();
    localae.a(this.a);
    if (this.b != null)
      localaf.a(this.b);
  }

  public final String a_()
  {
    return this.a.a_();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof p))
      return false;
    int i = a((p)paramObject);
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(com.android.cglib.dx.d.i.c(c()));
    localStringBuffer.append(' ');
    localStringBuffer.append(this.a);
    if (this.b != null)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(this.b);
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.p
 * JD-Core Version:    0.6.2
 */