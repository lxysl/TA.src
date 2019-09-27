package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;

class cb extends TimerTask
{
  cb(by paramby, Context paramContext)
  {
  }

  public void run()
  {
    if (!DataCore.instance().isPartEmpty())
      by.a(this.b, this.a);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cb
 * JD-Core Version:    0.6.2
 */