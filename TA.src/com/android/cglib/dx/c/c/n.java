package com.android.cglib.dx.c.c;

public abstract class n extends p
{
  private final int a;

  n(int paramInt)
  {
    this.a = paramInt;
  }

  protected int b(a parama)
  {
    int i = ((n)parama).a;
    if (this.a < i)
      return -1;
    if (this.a > i)
      return 1;
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (this.a == ((n)paramObject).a);
  }

  public final boolean f()
  {
    return true;
  }

  public final int g()
  {
    return this.a;
  }

  public final long h()
  {
    return this.a;
  }

  public final int hashCode()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.n
 * JD-Core Version:    0.6.2
 */