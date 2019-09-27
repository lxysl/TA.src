package com.android.cglib.dx.c.b;

import com.android.cglib.dx.d.i;

public final class a
{
  public static String a(int paramInt)
  {
    return a(paramInt, 30257, 1);
  }

  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    int i = paramInt1 & (paramInt2 ^ 0xFFFFFFFF);
    int j = paramInt1 & paramInt2;
    if ((j & 0x1) != 0)
      localStringBuffer.append("|public");
    if ((j & 0x2) != 0)
      localStringBuffer.append("|private");
    if ((j & 0x4) != 0)
      localStringBuffer.append("|protected");
    if ((j & 0x8) != 0)
      localStringBuffer.append("|static");
    if ((j & 0x10) != 0)
      localStringBuffer.append("|final");
    if ((j & 0x20) != 0)
    {
      if (paramInt3 == 1);
      for (String str3 = "|super"; ; str3 = "|synchronized")
      {
        localStringBuffer.append(str3);
        break;
      }
    }
    if ((j & 0x40) != 0)
    {
      if (paramInt3 == 3);
      for (String str2 = "|bridge"; ; str2 = "|volatile")
      {
        localStringBuffer.append(str2);
        break;
      }
    }
    if ((j & 0x80) != 0)
    {
      if (paramInt3 == 3);
      for (String str1 = "|varargs"; ; str1 = "|transient")
      {
        localStringBuffer.append(str1);
        break;
      }
    }
    if ((j & 0x100) != 0)
      localStringBuffer.append("|native");
    if ((j & 0x200) != 0)
      localStringBuffer.append("|interface");
    if ((j & 0x400) != 0)
      localStringBuffer.append("|abstract");
    if ((j & 0x800) != 0)
      localStringBuffer.append("|strictfp");
    if ((j & 0x1000) != 0)
      localStringBuffer.append("|synthetic");
    if ((j & 0x2000) != 0)
      localStringBuffer.append("|annotation");
    if ((j & 0x4000) != 0)
      localStringBuffer.append("|enum");
    if ((0x10000 & j) != 0)
      localStringBuffer.append("|constructor");
    if ((j & 0x20000) != 0)
      localStringBuffer.append("|declared_synchronized");
    if ((i != 0) || (localStringBuffer.length() == 0))
    {
      localStringBuffer.append('|');
      localStringBuffer.append(i.c(i));
    }
    return localStringBuffer.substring(1);
  }

  public static String b(int paramInt)
  {
    return a(paramInt, 20703, 2);
  }

  public static String c(int paramInt)
  {
    return a(paramInt, 204287, 3);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.a
 * JD-Core Version:    0.6.2
 */