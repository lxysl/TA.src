package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class bv
{
  private static final bv a = new bv();
  private Context b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private HandlerThread f;
  private Handler g;

  public static bv a()
  {
    return a;
  }

  private void c(Context paramContext)
  {
    if (paramContext == null)
      return;
    if (!this.c)
    {
      this.b = paramContext.getApplicationContext();
      e();
      this.c = true;
    }
  }

  private void e()
  {
    try
    {
      bx localbx = new bx(this, null);
      localbx.setPriority(10);
      localbx.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Context paramContext)
  {
    try
    {
      a().b(paramContext.getApplicationContext());
    }
    catch (Throwable localThrowable)
    {
    }
    c(paramContext.getApplicationContext());
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.d)
      return;
    PrefOperate.loadMetaDataConfig(paramContext);
    DataCore.instance().loadStatData(paramContext);
    DataCore.instance().loadLastSession(paramContext);
    DataCore.instance().installHeader(paramContext);
    if (paramBoolean)
      DataCore.instance().saveLogDataToSend(paramContext);
    this.d = true;
  }

  public void b(Context paramContext)
  {
    if (this.e)
      return;
    if (paramContext == null)
      return;
    if ((this.f == null) || (!this.f.isAlive()))
    {
      this.f = new HandlerThread("dataAnalyzeThread");
      this.f.start();
      Looper localLooper = this.f.getLooper();
      if (localLooper != null)
        this.g = new Handler(localLooper);
    }
    if (this.g == null)
      return;
    this.g.postDelayed(new bw(this, paramContext), 5000L);
    this.e = true;
  }

  public boolean b()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean c()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
  {
    if (!this.d)
      try
      {
        while (true)
        {
          boolean bool = this.d;
          if (bool)
            break;
          try
          {
            wait(50L);
          }
          catch (InterruptedException localInterruptedException)
          {
            cz.b(localInterruptedException.getMessage());
          }
        }
        return;
      }
      finally
      {
      }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bv
 * JD-Core Version:    0.6.2
 */