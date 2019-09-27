package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

public enum ao
{
  private int e;

  static
  {
    ao[] arrayOfao = new ao[4];
    arrayOfao[0] = a;
    arrayOfao[1] = b;
    arrayOfao[2] = c;
    arrayOfao[3] = d;
  }

  private ao(int paramInt)
  {
    this.e = paramInt;
  }

  public static ao a(int paramInt)
  {
    for (ao localao : values())
      if (localao.e == paramInt)
        return localao;
    return b;
  }

  public static boolean b(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    if (localActivityManager != null)
      try
      {
        List localList = localActivityManager.getRunningServices(2147483647);
        for (int i = 0; (localList != null) && (i < localList.size()); i++)
        {
          boolean bool = "com.baidu.bottom.service.BottomService".equals(((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName());
          if (bool)
            return true;
        }
      }
      catch (Exception localException)
      {
        cz.a(localException);
      }
    return false;
  }

  public abstract void a(Context paramContext);

  public String toString()
  {
    return String.valueOf(this.e);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ao
 * JD-Core Version:    0.6.2
 */