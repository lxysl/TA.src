package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.g;

public abstract class ag extends x
  implements Comparable<ag>
{
  private final int a;
  private int b;
  private ak c;
  private int d;

  public ag(int paramInt1, int paramInt2)
  {
    ak.a(paramInt1);
    if (paramInt2 < -1)
      throw new IllegalArgumentException("writeSize < -1");
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = null;
    this.d = -1;
  }

  public static int b(ag paramag)
  {
    if (paramag == null)
      return 0;
    return paramag.e();
  }

  protected int a(ag paramag)
  {
    throw new UnsupportedOperationException("unsupported");
  }

  public final void a(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("writeSize < 0");
    if (this.b >= 0)
      throw new UnsupportedOperationException("writeSize already set");
    this.b = paramInt;
  }

  protected void a(ak paramak, int paramInt)
  {
  }

  public final void a(l paraml, a parama)
  {
    parama.h(this.a);
    try
    {
      if (this.b < 0)
        throw new UnsupportedOperationException("writeSize is unknown");
      parama.a(e());
      a_(paraml, parama);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("...while writing ");
      localStringBuilder.append(this);
      throw g.a(localRuntimeException, localStringBuilder.toString());
    }
  }

  protected abstract void a_(l paraml, a parama);

  public final int b(ak paramak, int paramInt)
  {
    if (paramak == null)
      throw new NullPointerException("addedTo == null");
    if (paramInt < 0)
      throw new IllegalArgumentException("offset < 0");
    if (this.c != null)
      throw new RuntimeException("already written");
    int i = -1 + this.a;
    int j = paramInt + i & (i ^ 0xFFFFFFFF);
    this.c = paramak;
    this.d = j;
    a(paramak, j);
    return j;
  }

  public abstract String b();

  public final int b_()
  {
    if (this.b < 0)
      throw new UnsupportedOperationException("writeSize is unknown");
    return this.b;
  }

  public final int c(ag paramag)
  {
    if (this == paramag)
      return 0;
    y localy1 = a();
    y localy2 = paramag.a();
    if (localy1 != localy2)
      return localy1.compareTo(localy2);
    return a(paramag);
  }

  public final int e()
  {
    if (this.d < 0)
      throw new RuntimeException("offset not yet known");
    return this.c.c(this.d);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    ag localag = (ag)paramObject;
    if (a() != localag.a())
      return false;
    return a(localag) == 0;
  }

  public final int f()
  {
    return this.a;
  }

  public final String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Integer.toHexString(e()));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ag
 * JD-Core Version:    0.6.2
 */