package com.android.cglib.dx.b;

public final class c
{
  public static boolean a(int paramInt)
  {
    if (paramInt < -1)
      return false;
    if (paramInt == -1)
      return true;
    int i = paramInt & 0xFF;
    if (i != 0)
    {
      if (i == 255)
        return true;
      int j = paramInt & 0xFF00;
      boolean bool = false;
      if (j == 0)
        bool = true;
      return bool;
    }
    return true;
  }

  public static boolean b(int paramInt)
  {
    return paramInt >= 255;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.b.c
 * JD-Core Version:    0.6.2
 */