package com.android.cglib.dx.c.c;

public abstract class r extends x
{
  private final w a;
  private final t b;

  r(w paramw, t paramt)
  {
    if (paramw == null)
      throw new NullPointerException("definingClass == null");
    if (paramt == null)
      throw new NullPointerException("nat == null");
    this.a = paramw;
    this.b = paramt;
  }

  public final String a_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a_());
    localStringBuilder.append('.');
    localStringBuilder.append(this.b.a_());
    return localStringBuilder.toString();
  }

  protected int b(a parama)
  {
    r localr = (r)parama;
    int i = this.a.a(localr.a);
    if (i != 0)
      return i;
    return this.b.b().a(localr.b.b());
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass())
        return false;
      r localr = (r)paramObject;
      boolean bool2 = this.a.equals(localr.a);
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = this.b.equals(localr.b);
        bool1 = false;
        if (bool3)
          bool1 = true;
      }
    }
    return bool1;
  }

  public final w g()
  {
    return this.a;
  }

  public final t h()
  {
    return this.b;
  }

  public final int hashCode()
  {
    return 31 * this.a.hashCode() ^ this.b.hashCode();
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append('{');
    localStringBuilder.append(a_());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.r
 * JD-Core Version:    0.6.2
 */