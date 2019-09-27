package com.baidu.mobstat;

import android.content.Context;

class br
  implements Runnable
{
  br(bm parambm, long paramLong, Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
  }

  public void run()
  {
    bv.a().d();
    if (this.a <= 0L)
    {
      cz.a("EventStat: Wrong Case, Duration must be positive");
      return;
    }
    this.f.a(this.b, this.c, this.d, 1, System.currentTimeMillis(), this.a, this.e);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.br
 * JD-Core Version:    0.6.2
 */