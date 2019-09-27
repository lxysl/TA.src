package com.androlua.util;

import android.util.Log;
import com.a.a.a.a.a.a.a;
import java.io.IOException;

public class RootUtil
{
  private static boolean a;

  // ERROR //
  public static String execRootCmd(String paramString)
  {
    // Byte code:
    //   0: ldc 19
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_2
    //   5: invokestatic 25	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: ldc 27
    //   10: invokevirtual 31	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   13: astore 11
    //   15: new 33	java/io/DataOutputStream
    //   18: dup
    //   19: aload 11
    //   21: invokevirtual 39	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   24: invokespecial 42	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 6
    //   29: new 44	java/io/DataInputStream
    //   32: dup
    //   33: aload 11
    //   35: invokevirtual 48	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 51	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore 4
    //   43: ldc 53
    //   45: aload_0
    //   46: invokestatic 59	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: new 61	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   57: astore 13
    //   59: aload 13
    //   61: aload_0
    //   62: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 13
    //   68: ldc 68
    //   70: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: aload 13
    //   78: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 76	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   84: aload 6
    //   86: invokevirtual 79	java/io/DataOutputStream:flush	()V
    //   89: aload 6
    //   91: ldc 81
    //   93: invokevirtual 76	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: invokevirtual 79	java/io/DataOutputStream:flush	()V
    //   101: aload 4
    //   103: invokevirtual 84	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   106: astore 16
    //   108: aload 16
    //   110: ifnull +44 -> 154
    //   113: new 61	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   120: astore 17
    //   122: aload 17
    //   124: aload_1
    //   125: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 17
    //   131: aload 16
    //   133: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 17
    //   139: ldc 68
    //   141: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 17
    //   147: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_1
    //   151: goto -50 -> 101
    //   154: aload 11
    //   156: invokevirtual 88	java/lang/Process:waitFor	()I
    //   159: pop
    //   160: aload 6
    //   162: ifnull +18 -> 180
    //   165: aload 6
    //   167: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   170: goto +10 -> 180
    //   173: astore 22
    //   175: aload 22
    //   177: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   180: aload 4
    //   182: ifnull +93 -> 275
    //   185: aload 4
    //   187: invokevirtual 97	java/io/DataInputStream:close	()V
    //   190: aload_1
    //   191: areturn
    //   192: astore 9
    //   194: aload 9
    //   196: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   199: aload_1
    //   200: areturn
    //   201: astore 5
    //   203: goto +79 -> 282
    //   206: astore_3
    //   207: goto +15 -> 222
    //   210: astore 5
    //   212: aconst_null
    //   213: astore 4
    //   215: goto +67 -> 282
    //   218: astore_3
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 6
    //   224: astore_2
    //   225: goto +18 -> 243
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 6
    //   233: aconst_null
    //   234: astore 4
    //   236: goto +46 -> 282
    //   239: astore_3
    //   240: aconst_null
    //   241: astore 4
    //   243: aload_3
    //   244: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   247: aload_2
    //   248: ifnull +17 -> 265
    //   251: aload_2
    //   252: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   255: goto +10 -> 265
    //   258: astore 10
    //   260: aload 10
    //   262: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   265: aload 4
    //   267: ifnull +8 -> 275
    //   270: aload 4
    //   272: invokevirtual 97	java/io/DataInputStream:close	()V
    //   275: aload_1
    //   276: areturn
    //   277: astore 5
    //   279: aload_2
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +18 -> 302
    //   287: aload 6
    //   289: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   292: goto +10 -> 302
    //   295: astore 8
    //   297: aload 8
    //   299: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   302: aload 4
    //   304: ifnull +18 -> 322
    //   307: aload 4
    //   309: invokevirtual 97	java/io/DataInputStream:close	()V
    //   312: goto +10 -> 322
    //   315: astore 7
    //   317: aload 7
    //   319: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   322: aload 5
    //   324: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   165	170	173	java/io/IOException
    //   185	190	192	java/io/IOException
    //   270	275	192	java/io/IOException
    //   43	101	201	finally
    //   101	108	201	finally
    //   113	151	201	finally
    //   154	160	201	finally
    //   43	101	206	java/lang/Exception
    //   101	108	206	java/lang/Exception
    //   113	151	206	java/lang/Exception
    //   154	160	206	java/lang/Exception
    //   29	43	210	finally
    //   29	43	218	java/lang/Exception
    //   5	29	228	finally
    //   5	29	239	java/lang/Exception
    //   251	255	258	java/io/IOException
    //   243	247	277	finally
    //   287	292	295	java/io/IOException
    //   307	312	315	java/io/IOException
  }

  // ERROR //
  public static int execRootCmdSilent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 25	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: ldc 27
    //   7: invokevirtual 31	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   10: astore 8
    //   12: new 33	java/io/DataOutputStream
    //   15: dup
    //   16: aload 8
    //   18: invokevirtual 39	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   21: invokespecial 42	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore 6
    //   26: ldc 53
    //   28: aload_0
    //   29: invokestatic 59	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: new 61	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   40: astore 10
    //   42: aload 10
    //   44: aload_0
    //   45: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: ldc 68
    //   53: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: aload 10
    //   61: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 76	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   67: aload 6
    //   69: invokevirtual 79	java/io/DataOutputStream:flush	()V
    //   72: aload 6
    //   74: ldc 81
    //   76: invokevirtual 76	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   79: aload 6
    //   81: invokevirtual 79	java/io/DataOutputStream:flush	()V
    //   84: aload 8
    //   86: invokevirtual 88	java/lang/Process:waitFor	()I
    //   89: pop
    //   90: aload 8
    //   92: invokevirtual 102	java/lang/Process:exitValue	()I
    //   95: istore_3
    //   96: aload 6
    //   98: ifnull +64 -> 162
    //   101: aload 6
    //   103: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   106: iload_3
    //   107: ireturn
    //   108: astore 14
    //   110: aload 14
    //   112: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   115: iload_3
    //   116: ireturn
    //   117: astore 5
    //   119: goto +45 -> 164
    //   122: astore_2
    //   123: aload 6
    //   125: astore_1
    //   126: goto +12 -> 138
    //   129: astore 5
    //   131: aload_1
    //   132: astore 6
    //   134: goto +30 -> 164
    //   137: astore_2
    //   138: aload_2
    //   139: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   142: aload_1
    //   143: ifnull +17 -> 160
    //   146: aload_1
    //   147: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   150: goto +10 -> 160
    //   153: astore 4
    //   155: aload 4
    //   157: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   160: iconst_m1
    //   161: istore_3
    //   162: iload_3
    //   163: ireturn
    //   164: aload 6
    //   166: ifnull +18 -> 184
    //   169: aload 6
    //   171: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   174: goto +10 -> 184
    //   177: astore 7
    //   179: aload 7
    //   181: invokestatic 96	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   184: aload 5
    //   186: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   101	106	108	java/io/IOException
    //   26	96	117	finally
    //   26	96	122	java/lang/Exception
    //   2	26	129	finally
    //   138	142	129	finally
    //   2	26	137	java/lang/Exception
    //   146	150	153	java/io/IOException
    //   169	174	177	java/io/IOException
  }

  public static boolean haveRoot()
  {
    String str1;
    String str2;
    if (!a)
    {
      if (execRootCmdSilent("echo test") != -1)
      {
        Log.i("linin.root", "have root!");
        a = true;
        break label51;
      }
      str1 = "linin.root";
      str2 = "not root!";
    }
    else
    {
      str1 = "linin.root";
      str2 = "mHaveRoot = true, have root!";
    }
    Log.i(str1, str2);
    label51: return a;
  }

  public static boolean root()
  {
    try
    {
      Runtime.getRuntime().exec(new String[] { "/system/bin/su", "-c", "chmod 777 /dev/graphics/fb0" });
      Log.i("linin.root", "root success!");
      return true;
    }
    catch (IOException localIOException)
    {
      a.a(localIOException);
      Log.i("linin.root", "root fail!");
    }
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.RootUtil
 * JD-Core Version:    0.6.2
 */