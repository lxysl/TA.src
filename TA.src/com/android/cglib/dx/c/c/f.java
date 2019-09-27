package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class f extends n
{
  public static final f a = a((byte)0);

  private f(byte paramByte)
  {
    super(paramByte);
  }

  public static f a(byte paramByte)
  {
    return new f(paramByte);
  }

  public String a_()
  {
    return Integer.toString(g());
  }

  public c b()
  {
    return c.b;
  }

  public String e()
  {
    return "byte";
  }

  public String toString()
  {
    int i = g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("byte{0x");
    localStringBuilder.append(i.e(i));
    localStringBuilder.append(" / ");
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.f
 * JD-Core Version:    0.6.2
 */