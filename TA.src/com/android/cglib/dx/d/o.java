package com.android.cglib.dx.d;

public class o
{
  private boolean a;

  public o()
  {
    this.a = true;
  }

  public o(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void e()
  {
    this.a = false;
  }

  public final boolean f()
  {
    return true ^ this.a;
  }

  public final boolean g()
  {
    return this.a;
  }

  public final void h()
  {
    if (!this.a)
      throw new p("immutable instance");
  }

  public final void i()
  {
    if (this.a)
      throw new p("mutable instance");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.d.o
 * JD-Core Version:    0.6.2
 */