package com.androlua.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTaskX<Params, Progress, Result>
{
  public static final Executor SERIAL_EXECUTOR = new SerialExecutor(null);
  public static final Executor THREAD_POOL_EXECUTOR;
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final ThreadFactory b = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncTask #");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  private static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(1024);
  private static volatile Executor d = THREAD_POOL_EXECUTOR;
  private static InternalHandler e;
  private final WorkerRunnable<Params, Result> f;
  private final FutureTask<Result> g;
  private volatile Status h = Status.PENDING;
  private final AtomicBoolean i = new AtomicBoolean();
  private final AtomicBoolean j = new AtomicBoolean();
  private final Handler k;

  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(2, 128, 30L, TimeUnit.SECONDS, c, b);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
  }

  public AsyncTaskX()
  {
    this((Looper)null);
  }

  public AsyncTaskX(Handler paramHandler)
  {
    this(localLooper);
  }

  public AsyncTaskX(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 100	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: getstatic 105	com/androlua/util/AsyncTaskX$Status:PENDING	Lcom/androlua/util/AsyncTaskX$Status;
    //   8: putfield 107	com/androlua/util/AsyncTaskX:h	Lcom/androlua/util/AsyncTaskX$Status;
    //   11: aload_0
    //   12: new 109	java/util/concurrent/atomic/AtomicBoolean
    //   15: dup
    //   16: invokespecial 110	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   19: putfield 112	com/androlua/util/AsyncTaskX:i	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: aload_0
    //   23: new 109	java/util/concurrent/atomic/AtomicBoolean
    //   26: dup
    //   27: invokespecial 110	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   30: putfield 114	com/androlua/util/AsyncTaskX:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: aload_1
    //   34: ifnull +25 -> 59
    //   37: aload_1
    //   38: invokestatic 117	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   41: if_acmpne +6 -> 47
    //   44: goto +15 -> 59
    //   47: new 95	android/os/Handler
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 118	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   55: astore_2
    //   56: goto +7 -> 63
    //   59: invokestatic 121	com/androlua/util/AsyncTaskX:c	()Landroid/os/Handler;
    //   62: astore_2
    //   63: aload_0
    //   64: aload_2
    //   65: putfield 123	com/androlua/util/AsyncTaskX:k	Landroid/os/Handler;
    //   68: aload_0
    //   69: new 125	com/androlua/util/AsyncTaskX$2
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 128	com/androlua/util/AsyncTaskX$2:<init>	(Lcom/androlua/util/AsyncTaskX;)V
    //   77: putfield 130	com/androlua/util/AsyncTaskX:f	Lcom/androlua/util/AsyncTaskX$WorkerRunnable;
    //   80: aload_0
    //   81: new 132	com/androlua/util/AsyncTaskX$3
    //   84: dup
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 130	com/androlua/util/AsyncTaskX:f	Lcom/androlua/util/AsyncTaskX$WorkerRunnable;
    //   90: invokespecial 135	com/androlua/util/AsyncTaskX$3:<init>	(Lcom/androlua/util/AsyncTaskX;Ljava/util/concurrent/Callable;)V
    //   93: putfield 137	com/androlua/util/AsyncTaskX:g	Ljava/util/concurrent/FutureTask;
    //   96: return
  }

  private static Handler c()
  {
    try
    {
      if (e == null)
        e = new InternalHandler(Looper.getMainLooper());
      InternalHandler localInternalHandler = e;
      return localInternalHandler;
    }
    finally
    {
    }
  }

  private void c(Result paramResult)
  {
    if (!this.j.get())
      d(paramResult);
  }

  private Handler d()
  {
    return this.k;
  }

  private Result d(Result paramResult)
  {
    d().obtainMessage(1, new AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }

  private void e(Result paramResult)
  {
    if (isCancelled())
      b(paramResult);
    else
      a(paramResult);
    this.h = Status.FINISHED;
  }

  public static void execute(Runnable paramRunnable)
  {
    d.execute(paramRunnable);
  }

  public static void setDefaultExecutor(Executor paramExecutor)
  {
    d = paramExecutor;
  }

  protected abstract Result a(Params[] paramArrayOfParams);

  protected void a()
  {
  }

  protected void a(Result paramResult)
  {
  }

  protected void b()
  {
  }

  protected void b(Result paramResult)
  {
    b();
  }

  protected void b(Progress[] paramArrayOfProgress)
  {
  }

  protected final void c(Progress[] paramArrayOfProgress)
  {
    if (!isCancelled())
      d().obtainMessage(2, new AsyncTaskResult(this, paramArrayOfProgress)).sendToTarget();
  }

  public final boolean cancel(boolean paramBoolean)
  {
    this.i.set(true);
    return this.g.cancel(paramBoolean);
  }

  public final AsyncTaskX<Params, Progress, Result> execute(Params[] paramArrayOfParams)
  {
    return executeOnExecutor(d, paramArrayOfParams);
  }

  public final AsyncTaskX<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params[] paramArrayOfParams)
  {
    if (this.h != Status.PENDING)
      switch (4.a[this.h.ordinal()])
      {
      default:
        break;
      case 2:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
      case 1:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
    this.h = Status.RUNNING;
    a();
    this.f.b = paramArrayOfParams;
    paramExecutor.execute(this.g);
    return this;
  }

  public final Result get()
  {
    return this.g.get();
  }

  public final Result get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.g.get(paramLong, paramTimeUnit);
  }

  public final Status getStatus()
  {
    return this.h;
  }

  public final boolean isCancelled()
  {
    return this.i.get();
  }

  private static class AsyncTaskResult<Data>
  {
    final AsyncTaskX a;
    final Data[] b;

    AsyncTaskResult(AsyncTaskX paramAsyncTaskX, Data[] paramArrayOfData)
    {
      this.a = paramAsyncTaskX;
      this.b = paramArrayOfData;
    }
  }

  private static class InternalHandler extends Handler
  {
    public InternalHandler(Looper paramLooper)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      AsyncTaskX.AsyncTaskResult localAsyncTaskResult = (AsyncTaskX.AsyncTaskResult)paramMessage.obj;
      switch (paramMessage.what)
      {
      default:
        return;
      case 2:
        localAsyncTaskResult.a.b(localAsyncTaskResult.b);
        return;
      case 1:
      }
      AsyncTaskX.c(localAsyncTaskResult.a, localAsyncTaskResult.b[0]);
    }
  }

  private static class SerialExecutor
    implements Executor
  {
    final ArrayDeque<Runnable> a = new ArrayDeque();
    Runnable b;

    protected void a()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.a.poll();
        this.b = localRunnable;
        if (localRunnable != null)
          AsyncTaskX.THREAD_POOL_EXECUTOR.execute(this.b);
        return;
      }
      finally
      {
      }
    }

    public void execute(final Runnable paramRunnable)
    {
      try
      {
        this.a.offer(new Runnable()
        {
          public void run()
          {
            try
            {
              paramRunnable.run();
              return;
            }
            finally
            {
              AsyncTaskX.SerialExecutor.this.a();
            }
          }
        });
        if (this.b == null)
          a();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  public static enum Status
  {
    static
    {
      FINISHED = new Status("FINISHED", 2);
      Status[] arrayOfStatus = new Status[3];
      arrayOfStatus[0] = PENDING;
      arrayOfStatus[1] = RUNNING;
      arrayOfStatus[2] = FINISHED;
    }
  }

  private static abstract class WorkerRunnable<Params, Result>
    implements Callable<Result>
  {
    Params[] b;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.AsyncTaskX
 * JD-Core Version:    0.6.2
 */