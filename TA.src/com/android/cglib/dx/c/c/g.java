package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class g extends n
{
  public static final g a = a('\000');

  private g(char paramChar)
  {
    super(paramChar);
  }

  public static g a(char paramChar)
  {
    return new g(paramChar);
  }

  public String a_()
  {
    return Integer.toString(g());
  }

  public c b()
  {
    return c.c;
  }

  public String e()
  {
    return "char";
  }

  public String toString()
  {
    int i = g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("char{0x");
    localStringBuilder.append(i.c(i));
    localStringBuilder.append(" / ");
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.g
 * JD-Core Version:    0.6.2
 */