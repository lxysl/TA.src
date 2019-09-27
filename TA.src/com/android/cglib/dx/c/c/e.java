package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;

public final class e extends n
{
  public static final e a = new e(false);
  public static final e b = new e(true);

  private e(boolean paramBoolean)
  {
    super(paramBoolean);
  }

  public static e a(boolean paramBoolean)
  {
    if (paramBoolean)
      return b;
    return a;
  }

  public String a_()
  {
    if (d_())
      return "true";
    return "false";
  }

  public c b()
  {
    return c.a;
  }

  public boolean d_()
  {
    return g() != 0;
  }

  public String e()
  {
    return "boolean";
  }

  public String toString()
  {
    if (d_())
      return "boolean{true}";
    return "boolean{false}";
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.e
 * JD-Core Version:    0.6.2
 */