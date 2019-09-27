package com.androlua.util;

public class VolatileDispose<T>
{
  private volatile T a;

  public T blockedGet()
  {
    try
    {
      if (this.a != null)
      {
        Object localObject2 = this.a;
        return localObject2;
      }
      try
      {
        wait(1000L);
        return this.a;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException);
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public T blockedGetOrThrow(java.lang.Class<? extends RuntimeException> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/androlua/util/VolatileDispose:a	Ljava/lang/Object;
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: getfield 18	com/androlua/util/VolatileDispose:a	Ljava/lang/Object;
    //   13: astore 5
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 5
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 37	java/lang/Object:wait	()V
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield 18	com/androlua/util/VolatileDispose:a	Ljava/lang/Object;
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 42	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   35: checkcast 26	java/lang/RuntimeException
    //   38: athrow
    //   39: astore 4
    //   41: new 26	java/lang/RuntimeException
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 29	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   50: athrow
    //   51: astore_3
    //   52: new 26	java/lang/RuntimeException
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 29	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   20	24	31	java/lang/InterruptedException
    //   31	39	39	java/lang/IllegalAccessException
    //   31	39	51	java/lang/InstantiationException
    //   2	17	61	finally
    //   20	24	61	finally
    //   24	26	61	finally
    //   31	39	61	finally
    //   41	51	61	finally
    //   52	61	61	finally
    //   62	64	61	finally
  }

  public void setAndNotify(T paramT)
  {
    try
    {
      this.a = paramT;
      notify();
      return;
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.VolatileDispose
 * JD-Core Version:    0.6.2
 */