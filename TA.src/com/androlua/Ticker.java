package com.androlua;

import android.os.Handler;
import android.os.Message;

public class Ticker
{
  private Handler a;
  private OnTickListener b;
  private Thread c;
  private long d = 1000L;
  private boolean e = true;
  private boolean f = false;
  private long g;
  private long h;

  public Ticker()
  {
    a();
  }

  private void a()
  {
    this.a = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (Ticker.a(Ticker.this) != null)
          Ticker.a(Ticker.this).onTick();
      }
    };
    this.c = new Thread()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   4: iconst_1
        //   5: invokestatic 22	com/androlua/Ticker:a	(Lcom/androlua/Ticker;Z)Z
        //   8: pop
        //   9: goto +4 -> 13
        //   12: pop
        //   13: aload_0
        //   14: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   17: invokestatic 26	com/androlua/Ticker:b	(Lcom/androlua/Ticker;)Z
        //   20: ifeq +82 -> 102
        //   23: invokestatic 32	java/lang/System:currentTimeMillis	()J
        //   26: lstore_2
        //   27: aload_0
        //   28: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   31: invokestatic 35	com/androlua/Ticker:c	(Lcom/androlua/Ticker;)Z
        //   34: ifne +20 -> 54
        //   37: aload_0
        //   38: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   41: lload_2
        //   42: aload_0
        //   43: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   46: invokestatic 39	com/androlua/Ticker:d	(Lcom/androlua/Ticker;)J
        //   49: lsub
        //   50: invokestatic 42	com/androlua/Ticker:a	(Lcom/androlua/Ticker;J)J
        //   53: pop2
        //   54: lload_2
        //   55: aload_0
        //   56: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   59: invokestatic 45	com/androlua/Ticker:e	(Lcom/androlua/Ticker;)J
        //   62: lsub
        //   63: aload_0
        //   64: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   67: invokestatic 48	com/androlua/Ticker:f	(Lcom/androlua/Ticker;)J
        //   70: lcmp
        //   71: iflt +24 -> 95
        //   74: aload_0
        //   75: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   78: lload_2
        //   79: invokestatic 42	com/androlua/Ticker:a	(Lcom/androlua/Ticker;J)J
        //   82: pop2
        //   83: aload_0
        //   84: getfield 14	com/androlua/Ticker$2:a	Lcom/androlua/Ticker;
        //   87: invokestatic 52	com/androlua/Ticker:g	(Lcom/androlua/Ticker;)Landroid/os/Handler;
        //   90: iconst_0
        //   91: invokevirtual 58	android/os/Handler:sendEmptyMessage	(I)Z
        //   94: pop
        //   95: lconst_1
        //   96: invokestatic 62	com/androlua/Ticker$2:sleep	(J)V
        //   99: goto -87 -> 12
        //   102: return
        //
        // Exception table:
        //   from	to	target	type
        //   95	99	12	java/lang/InterruptedException
      }
    };
  }

  public boolean getEnabled()
  {
    return this.e;
  }

  public long getInterval()
  {
    return this.d;
  }

  public long getPeriod()
  {
    return this.d;
  }

  public boolean isRun()
  {
    return this.f;
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean)
      this.h = (System.currentTimeMillis() - this.g);
  }

  public void setInterval(long paramLong)
  {
    this.g = System.currentTimeMillis();
    this.d = paramLong;
  }

  public void setOnTickListener(OnTickListener paramOnTickListener)
  {
    this.b = paramOnTickListener;
  }

  public void setPeriod(long paramLong)
  {
    this.g = System.currentTimeMillis();
    this.d = paramLong;
  }

  public void start()
  {
    this.c.start();
  }

  public void stop()
  {
    this.f = false;
  }

  public static abstract interface OnTickListener
  {
    public abstract void onTick();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.Ticker
 * JD-Core Version:    0.6.2
 */