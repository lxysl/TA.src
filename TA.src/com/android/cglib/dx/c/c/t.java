package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;

public final class t extends a
{
  public static final t a = new t(new v("TYPE"), new v("Ljava/lang/Class;"));
  private final v b;
  private final v c;

  public t(v paramv1, v paramv2)
  {
    if (paramv1 == null)
      throw new NullPointerException("name == null");
    if (paramv2 == null)
      throw new NullPointerException("descriptor == null");
    this.b = paramv1;
    this.c = paramv2;
  }

  public String a_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.a_());
    localStringBuilder.append(':');
    localStringBuilder.append(this.c.a_());
    return localStringBuilder.toString();
  }

  protected int b(a parama)
  {
    t localt = (t)parama;
    int i = this.b.a(localt.b);
    if (i != 0)
      return i;
    return this.c.a(localt.c);
  }

  public v b()
  {
    return this.b;
  }

  public v c()
  {
    return this.c;
  }

  public c d()
  {
    return c.a(this.c.g());
  }

  public String e()
  {
    return "nat";
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof t))
      return false;
    t localt = (t)paramObject;
    boolean bool1 = this.b.equals(localt.b);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.c.equals(localt.c);
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  public int hashCode()
  {
    return 31 * this.b.hashCode() ^ this.c.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nat{");
    localStringBuilder.append(a_());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.t
 * JD-Core Version:    0.6.2
 */