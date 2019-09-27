package com.androlua.util;

import java.util.Date;

public class TimerX
{
  private static long a;
  private final TimerImpl b;
  private final FinalizerHelper c;

  public TimerX()
  {
    this(false);
  }

  public TimerX(String paramString)
  {
    this(paramString, false);
  }

  public TimerX(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      throw new NullPointerException("name is null");
    this.b = new TimerImpl(paramString, paramBoolean);
    this.c = new FinalizerHelper(this.b);
  }

  public TimerX(boolean paramBoolean)
  {
    this(localStringBuilder.toString(), paramBoolean);
  }

  private static long a()
  {
    try
    {
      long l = a;
      a = l + 1L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(TimerTaskX paramTimerTaskX, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      if (TimerImpl.a(this.b))
        throw new IllegalStateException("Timer was canceled");
      long l = paramLong1 + System.currentTimeMillis();
      if (l < 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Illegal delay to start the TimerTask: ");
        localStringBuilder.append(l);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      synchronized (paramTimerTaskX.b)
      {
        if (paramTimerTaskX.a())
          throw new IllegalStateException("TimerTask is scheduled already");
        if (paramTimerTaskX.c)
          throw new IllegalStateException("TimerTask is canceled");
        paramTimerTaskX.d = l;
        paramTimerTaskX.e = paramLong2;
        paramTimerTaskX.f = paramBoolean;
        TimerImpl.a(this.b, paramTimerTaskX);
        return;
      }
    }
  }

  public void cancel()
  {
    this.b.cancel();
  }

  public int purge()
  {
    synchronized (this.b)
    {
      int i = this.b.purge();
      return i;
    }
  }

  public void schedule(TimerTaskX paramTimerTaskX, long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException();
    a(paramTimerTaskX, paramLong, -1L, false);
  }

  public void schedule(TimerTaskX paramTimerTaskX, long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 > 0L))
    {
      a(paramTimerTaskX, paramLong1, paramLong2, false);
      return;
    }
    throw new IllegalArgumentException();
  }

  public void schedule(TimerTaskX paramTimerTaskX, Date paramDate)
  {
    if (paramDate.getTime() < 0L)
      throw new IllegalArgumentException();
    long l1 = paramDate.getTime() - System.currentTimeMillis();
    long l2;
    if (l1 < 0L)
      l2 = 0L;
    else
      l2 = l1;
    a(paramTimerTaskX, l2, -1L, false);
  }

  public void schedule(TimerTaskX paramTimerTaskX, Date paramDate, long paramLong)
  {
    if ((paramLong > 0L) && (paramDate.getTime() >= 0L))
    {
      long l1 = paramDate.getTime() - System.currentTimeMillis();
      long l2;
      if (l1 < 0L)
        l2 = 0L;
      else
        l2 = l1;
      a(paramTimerTaskX, l2, paramLong, false);
      return;
    }
    throw new IllegalArgumentException();
  }

  public void scheduleAtFixedRate(TimerTaskX paramTimerTaskX, long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 > 0L))
    {
      a(paramTimerTaskX, paramLong1, paramLong2, true);
      return;
    }
    throw new IllegalArgumentException();
  }

  public void scheduleAtFixedRate(TimerTaskX paramTimerTaskX, Date paramDate, long paramLong)
  {
    if ((paramLong > 0L) && (paramDate.getTime() >= 0L))
    {
      a(paramTimerTaskX, paramDate.getTime() - System.currentTimeMillis(), paramLong, true);
      return;
    }
    throw new IllegalArgumentException();
  }

  private static final class FinalizerHelper
  {
    private final TimerX.TimerImpl a;

    FinalizerHelper(TimerX.TimerImpl paramTimerImpl)
    {
      this.a = paramTimerImpl;
    }

    protected void finalize()
    {
      try
      {
        synchronized (this.a)
        {
          TimerX.TimerImpl.a(this.a, true);
          this.a.notify();
          return;
        }
      }
      finally
      {
        super.finalize();
      }
    }
  }

  private static final class TimerImpl extends Thread
  {
    private boolean a;
    private boolean b;
    private TimerHeap c = new TimerHeap(null);

    TimerImpl(String paramString, boolean paramBoolean)
    {
      setName(paramString);
      setDaemon(paramBoolean);
      start();
    }

    private void a(TimerTaskX paramTimerTaskX)
    {
      this.c.insert(paramTimerTaskX);
      notify();
    }

    public void cancel()
    {
      try
      {
        this.a = true;
        this.c.reset();
        notify();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public int purge()
    {
      if (this.c.isEmpty())
        return 0;
      TimerHeap.a(this.c, 0);
      this.c.deleteIfCancelled();
      return TimerHeap.a(this.c);
    }

    public void run()
    {
      while (true)
        try
        {
          if (this.a)
            return;
          if (this.c.isEmpty())
            if (this.b)
              return;
          while (true)
          {
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException)
            {
            }
            break;
            long l1 = System.currentTimeMillis();
            localTimerTaskX = this.c.minimum();
            synchronized (localTimerTaskX.b)
            {
              if (localTimerTaskX.c)
              {
                this.c.delete(0);
                continue;
              }
              long l2 = localTimerTaskX.d - l1;
              if (l2 > 0L)
              {
                wait(l2);
                continue;
              }
              synchronized (localTimerTaskX.b)
              {
                boolean bool = this.c.minimum().d < localTimerTaskX.d;
                int i = 0;
                if (bool)
                  i = TimerHeap.a(this.c, localTimerTaskX);
                if (localTimerTaskX.c)
                {
                  this.c.delete(TimerHeap.a(this.c, localTimerTaskX));
                  continue;
                }
                localTimerTaskX.setScheduledTime(localTimerTaskX.d);
                this.c.delete(i);
                if (localTimerTaskX.e >= 0L)
                {
                  if (localTimerTaskX.f)
                    localTimerTaskX.d += localTimerTaskX.e;
                  else
                    localTimerTaskX.d = (System.currentTimeMillis() + localTimerTaskX.e);
                  a(localTimerTaskX);
                }
                else
                {
                  localTimerTaskX.d = 0L;
                }
              }
            }
          }
        }
        finally
        {
          try
          {
            TimerTaskX localTimerTaskX;
            if (!localTimerTaskX.isEnabled())
              continue;
            localTimerTaskX.run();
          }
          finally
          {
            try
            {
              this.a = true;
            }
            finally
            {
            }
          }
        }
    }

    private static final class TimerHeap
    {
      private int a = 256;
      private TimerTaskX[] b = new TimerTaskX[this.a];
      private int c = 0;
      private int d = 0;

      private int a(TimerTaskX paramTimerTaskX)
      {
        for (int i = 0; i < this.b.length; i++)
          if (this.b[i] == paramTimerTaskX)
            return i;
        return -1;
      }

      private void a()
      {
        int i = -1 + this.c;
        int j = (i - 1) / 2;
        while (this.b[i].d < this.b[j].d)
        {
          TimerTaskX localTimerTaskX = this.b[i];
          this.b[i] = this.b[j];
          this.b[j] = localTimerTaskX;
          int k = (j - 1) / 2;
          int m = j;
          j = k;
          i = m;
        }
      }

      private void a(int paramInt)
      {
        int i = 1 + paramInt * 2;
        while ((i < this.c) && (this.c > 0))
        {
          int j = i + 1;
          if ((j < this.c) && (this.b[j].d < this.b[i].d))
            i = j;
          if (this.b[paramInt].d < this.b[i].d)
            return;
          TimerTaskX localTimerTaskX = this.b[paramInt];
          this.b[paramInt] = this.b[i];
          this.b[i] = localTimerTaskX;
          int k = 1 + i * 2;
          int m = i;
          i = k;
          paramInt = m;
        }
      }

      public void adjustMinimum()
      {
        a(0);
      }

      public void delete(int paramInt)
      {
        if ((paramInt >= 0) && (paramInt < this.c))
        {
          TimerTaskX[] arrayOfTimerTaskX1 = this.b;
          TimerTaskX[] arrayOfTimerTaskX2 = this.b;
          int i = -1 + this.c;
          this.c = i;
          arrayOfTimerTaskX1[paramInt] = arrayOfTimerTaskX2[i];
          this.b[this.c] = null;
          a(paramInt);
        }
      }

      public void deleteIfCancelled()
      {
        for (int i = 0; i < this.c; i++)
          if (this.b[i].c)
          {
            this.d = (1 + this.d);
            delete(i);
            i--;
          }
      }

      public void insert(TimerTaskX paramTimerTaskX)
      {
        if (this.b.length == this.c)
        {
          TimerTaskX[] arrayOfTimerTaskX2 = new TimerTaskX[2 * this.c];
          System.arraycopy(this.b, 0, arrayOfTimerTaskX2, 0, this.c);
          this.b = arrayOfTimerTaskX2;
        }
        TimerTaskX[] arrayOfTimerTaskX1 = this.b;
        int i = this.c;
        this.c = (i + 1);
        arrayOfTimerTaskX1[i] = paramTimerTaskX;
        a();
      }

      public boolean isEmpty()
      {
        return this.c == 0;
      }

      public TimerTaskX minimum()
      {
        return this.b[0];
      }

      public void reset()
      {
        this.b = new TimerTaskX[this.a];
        this.c = 0;
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.TimerX
 * JD-Core Version:    0.6.2
 */