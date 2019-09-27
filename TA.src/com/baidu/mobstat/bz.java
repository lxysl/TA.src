package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import java.util.Timer;

class bz
  implements Runnable
{
  bz(by paramby, Context paramContext)
  {
  }

  public void run()
  {
    if (by.a(this.b) != null)
    {
      by.a(this.b).cancel();
      by.a(this.b, null);
    }
    by.a(this.b, SendStrategyEnum.values()[bj.a().a(this.a)]);
    by.a(this.b, bj.a().b(this.a));
    by.a(this.b, bj.a().c(this.a));
    if (by.b(this.b).equals(SendStrategyEnum.SET_TIME_INTERVAL));
    while (by.b(this.b).equals(SendStrategyEnum.ONCE_A_DAY))
    {
      this.b.b(this.a);
      break;
    }
    by.d(this.b).postDelayed(new ca(this), 1000 * by.c(this.b));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bz
 * JD-Core Version:    0.6.2
 */