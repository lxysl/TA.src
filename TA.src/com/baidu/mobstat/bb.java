package com.baidu.mobstat;

import android.os.Build.VERSION;

public final class bb
{
  public static boolean a = true;
  public static final String b;
  public static final String c = str2;

  static
  {
    String str1;
    if (Build.VERSION.SDK_INT < 9)
      str1 = "http://datax.baidu.com/xs.gif";
    else
      str1 = "https://datax.baidu.com/xs.gif";
    b = str1;
    String str2;
    if (Build.VERSION.SDK_INT < 9)
      str2 = "http://dxp.baidu.com/upgrade";
    else
      str2 = "https://dxp.baidu.com/upgrade";
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bb
 * JD-Core Version:    0.6.2
 */