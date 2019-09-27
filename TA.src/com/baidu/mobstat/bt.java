package com.baidu.mobstat;

import android.content.Context;

class bt
{
  private static bt a = new bt();
  private boolean b = false;

  public static bt a()
  {
    return a;
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    cz.a("openExceptonAnalysis");
    if (this.b)
      return;
    this.b = true;
    bl.a().a(paramContext);
    if (!paramBoolean)
      NativeCrashHandler.init(paramContext);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bt
 * JD-Core Version:    0.6.2
 */