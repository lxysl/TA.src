package com.baidu.mobstat;

import java.security.MessageDigest;

public final class cw
{
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xF & paramArrayOfByte[i] >> 4;
      int k = 0xF & paramArrayOfByte[i];
      int m;
      if (j >= 10)
        m = j + 97 - 10;
      else
        m = j + 48;
      localStringBuilder.append((char)m);
      int n;
      if (k >= 10)
        n = k + 97 - 10;
      else
        n = k + 48;
      localStringBuilder.append((char)n);
    }
    return localStringBuilder.toString();
  }

  // ERROR //
  private static String b(MessageDigest paramMessageDigest, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 37	java/io/File:isFile	()Z
    //   4: ifeq +131 -> 135
    //   7: aconst_null
    //   8: astore_2
    //   9: new 39	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_3
    //   18: sipush 4048
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_3
    //   26: aload 8
    //   28: invokevirtual 46	java/io/FileInputStream:read	([B)I
    //   31: istore 9
    //   33: iload 9
    //   35: iconst_m1
    //   36: if_icmpne +14 -> 50
    //   39: aload_3
    //   40: ifnull +66 -> 106
    //   43: aload_3
    //   44: invokevirtual 49	java/io/FileInputStream:close	()V
    //   47: goto +59 -> 106
    //   50: aload_0
    //   51: aload 8
    //   53: iconst_0
    //   54: iload 9
    //   56: invokevirtual 55	java/security/MessageDigest:update	([BII)V
    //   59: goto -34 -> 25
    //   62: astore 6
    //   64: aload_3
    //   65: astore_2
    //   66: goto +48 -> 114
    //   69: astore 4
    //   71: aload_3
    //   72: astore_2
    //   73: goto +10 -> 83
    //   76: astore 6
    //   78: goto +36 -> 114
    //   81: astore 4
    //   83: aload 4
    //   85: invokestatic 60	com/baidu/mobstat/cz:b	(Ljava/lang/Throwable;)V
    //   88: aload_2
    //   89: ifnull +17 -> 106
    //   92: aload_2
    //   93: invokevirtual 49	java/io/FileInputStream:close	()V
    //   96: goto +10 -> 106
    //   99: astore 5
    //   101: aload 5
    //   103: invokestatic 60	com/baidu/mobstat/cz:b	(Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: invokevirtual 64	java/security/MessageDigest:digest	()[B
    //   110: invokestatic 66	com/baidu/mobstat/cw:a	([B)Ljava/lang/String;
    //   113: areturn
    //   114: aload_2
    //   115: ifnull +17 -> 132
    //   118: aload_2
    //   119: invokevirtual 49	java/io/FileInputStream:close	()V
    //   122: goto +10 -> 132
    //   125: astore 7
    //   127: aload 7
    //   129: invokestatic 60	com/baidu/mobstat/cz:b	(Ljava/lang/Throwable;)V
    //   132: aload 6
    //   134: athrow
    //   135: ldc 68
    //   137: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   18	25	62	finally
    //   25	33	62	finally
    //   50	59	62	finally
    //   18	25	69	java/lang/Exception
    //   25	33	69	java/lang/Exception
    //   50	59	69	java/lang/Exception
    //   9	18	76	finally
    //   83	88	76	finally
    //   9	18	81	java/lang/Exception
    //   43	47	99	java/io/IOException
    //   92	96	99	java/io/IOException
    //   118	122	125	java/io/IOException
  }

  private static String b(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    paramMessageDigest.update(paramArrayOfByte);
    return a(paramMessageDigest.digest());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cw
 * JD-Core Version:    0.6.2
 */