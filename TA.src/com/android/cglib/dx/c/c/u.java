package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class u extends n
{
  public static final u a = a((short)0);

  private u(short paramShort)
  {
    super(paramShort);
  }

  public static u a(short paramShort)
  {
    return new u(paramShort);
  }

  public String a_()
  {
    return Integer.toString(g());
  }

  public c b()
  {
    return c.h;
  }

  public String e()
  {
    return "short";
  }

  public String toString()
  {
    int i = g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short{0x");
    localStringBuilder.append(i.c(i));
    localStringBuilder.append(" / ");
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.u
 * JD-Core Version:    0.6.2
 */