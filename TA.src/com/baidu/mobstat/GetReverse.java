package com.baidu.mobstat;

import android.content.Context;

public class GetReverse
{
  private static ICooperService a;

  public static ICooperService getCooperService(Context paramContext)
  {
    if (a == null)
      a = CooperService.a();
    return a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.GetReverse
 * JD-Core Version:    0.6.2
 */