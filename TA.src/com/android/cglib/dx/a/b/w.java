package com.android.cglib.dx.a.b;

public abstract class w extends x
{
  private int a = -1;

  public final void a(int paramInt)
  {
    if (this.a != -1)
      throw new RuntimeException("index already set");
    this.a = paramInt;
  }

  public final boolean f()
  {
    return this.a >= 0;
  }

  public final int g()
  {
    if (this.a < 0)
      throw new RuntimeException("index not yet set");
    return this.a;
  }

  public final String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Integer.toHexString(this.a));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.w
 * JD-Core Version:    0.6.2
 */