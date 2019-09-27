package com.androlua.util;

public abstract class TimerTaskX
  implements Runnable
{
  private long a;
  final Object b = new Object();
  boolean c;
  long d;
  long e;
  boolean f;
  private boolean g;

  boolean a()
  {
    while (true)
    {
      synchronized (this.b)
      {
        if (this.d > 0L)
          break label42;
        if (this.a > 0L)
        {
          break label42;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label42: bool = true;
    }
  }

  public boolean cancel()
  {
    while (true)
    {
      synchronized (this.b)
      {
        if ((!this.c) && (this.d > 0L))
        {
          bool = true;
          this.c = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public long getPeriod()
  {
    return this.e;
  }

  public boolean isEnabled()
  {
    return this.g;
  }

  public abstract void run();

  public long scheduledExecutionTime()
  {
    synchronized (this.b)
    {
      long l = this.a;
      return l;
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void setPeriod(long paramLong)
  {
    this.e = paramLong;
  }

  public void setScheduledTime(long paramLong)
  {
    synchronized (this.b)
    {
      this.a = paramLong;
      return;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.TimerTaskX
 * JD-Core Version:    0.6.2
 */