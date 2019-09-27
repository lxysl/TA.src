package com.baidu.mobstat;

import android.net.LocalServerSocket;
import java.io.IOException;

public final class db
{
  private LocalServerSocket a;

  // ERROR //
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/baidu/mobstat/db:a	Landroid/net/LocalServerSocket;
    //   6: ifnonnull +27 -> 33
    //   9: aload_0
    //   10: new 17	android/net/LocalServerSocket
    //   13: dup
    //   14: ldc 19
    //   16: invokespecial 22	android/net/LocalServerSocket:<init>	(Ljava/lang/String;)V
    //   19: putfield 15	com/baidu/mobstat/db:a	Landroid/net/LocalServerSocket;
    //   22: iconst_1
    //   23: istore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -11 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   2	22	28	finally
    //   2	22	33	java/io/IOException
  }

  public final void b()
  {
    try
    {
      LocalServerSocket localLocalServerSocket = this.a;
      if (localLocalServerSocket != null);
      try
      {
        this.a.close();
        this.a = null;
      }
      catch (IOException localIOException)
      {
      }
      return;
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.db
 * JD-Core Version:    0.6.2
 */