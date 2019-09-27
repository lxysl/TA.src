package com.android.cglib.dx.c.c;

public abstract class o extends p
{
  private final long a;

  o(long paramLong)
  {
    this.a = paramLong;
  }

  protected int b(a parama)
  {
    long l = ((o)parama).a;
    if (this.a < l)
      return -1;
    if (this.a > l)
      return 1;
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (this.a == ((o)paramObject).a);
  }

  public final boolean f()
  {
    return (int)this.a == this.a;
  }

  public final int g()
  {
    return (int)this.a;
  }

  public final long h()
  {
    return this.a;
  }

  public final int hashCode()
  {
    return (int)this.a ^ (int)(this.a >> 32);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.o
 * JD-Core Version:    0.6.2
 */