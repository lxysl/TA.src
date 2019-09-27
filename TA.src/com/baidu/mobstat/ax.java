package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;

class ax
{
  private static volatile DexClassLoader a;
  private static volatile boolean b;

  private static DexClassLoader a(Context paramContext)
  {
    try
    {
      if (a != null)
      {
        DexClassLoader localDexClassLoader2 = a;
        return localDexClassLoader2;
      }
      File localFile1 = paramContext.getFileStreamPath(".remote.jar");
      if (localFile1 != null)
      {
        boolean bool = localFile1.isFile();
        if (!bool)
          return null;
      }
      if (!b(paramContext, localFile1.getAbsolutePath()))
      {
        bd.a("remote jar version lower than min limit, need delete");
        if (localFile1.isFile())
          localFile1.delete();
        return null;
      }
      if (!c(paramContext, localFile1.getAbsolutePath()))
      {
        bd.a("remote jar md5 is not right, need delete");
        if (localFile1.isFile())
          localFile1.delete();
        return null;
      }
      File localFile2 = paramContext.getDir("outdex", 0);
      try
      {
        a = new DexClassLoader(localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), null, paramContext.getClassLoader());
      }
      catch (Exception localException)
      {
        bd.a(localException);
      }
      DexClassLoader localDexClassLoader1 = a;
      return localDexClassLoader1;
    }
    finally
    {
    }
  }

  public static Class<?> a(Context paramContext, String paramString)
  {
    DexClassLoader localDexClassLoader = a(paramContext);
    if (localDexClassLoader == null)
      return null;
    return localDexClassLoader.loadClass(paramString);
  }

  public static void a(Context paramContext, l paraml)
  {
    try
    {
      boolean bool = b;
      if (bool)
        return;
      if (!dc.n(paramContext))
      {
        bd.a("isWifiAvailable = false, will not to update");
        return;
      }
      if (!paraml.a(paramContext))
      {
        bd.a("check time, will not to update");
        return;
      }
      bd.a("can start update config");
      new ay(paramContext, paraml).start();
      b = true;
      return;
    }
    finally
    {
    }
  }

  // ERROR //
  private static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 25	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 113	java/io/File:exists	()Z
    //   15: istore 10
    //   17: aconst_null
    //   18: astore_1
    //   19: iload 10
    //   21: ifeq +38 -> 59
    //   24: new 115	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   31: astore 11
    //   33: aload 11
    //   35: ldc 119
    //   37: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 11
    //   43: aload_2
    //   44: invokevirtual 127	java/io/File:length	()J
    //   47: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 11
    //   53: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 135	com/baidu/mobstat/bd:b	(Ljava/lang/String;)V
    //   59: new 137	java/util/jar/JarFile
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 138	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   67: astore 14
    //   69: aload 14
    //   71: invokevirtual 142	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   74: invokevirtual 148	java/util/jar/Manifest:getMainAttributes	()Ljava/util/jar/Attributes;
    //   77: ldc 150
    //   79: invokevirtual 155	java/util/jar/Attributes:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 16
    //   84: aload 14
    //   86: ifnull +11 -> 97
    //   89: aload 14
    //   91: invokevirtual 158	java/util/jar/JarFile:close	()V
    //   94: goto +4 -> 98
    //   97: pop
    //   98: aload 16
    //   100: areturn
    //   101: astore 8
    //   103: aload 14
    //   105: astore_1
    //   106: goto +71 -> 177
    //   109: astore 15
    //   111: aload 15
    //   113: astore_3
    //   114: aload 14
    //   116: astore_1
    //   117: goto +9 -> 126
    //   120: astore 8
    //   122: goto +55 -> 177
    //   125: astore_3
    //   126: aload_3
    //   127: invokestatic 70	com/baidu/mobstat/bd:a	(Ljava/lang/Throwable;)V
    //   130: new 115	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   137: astore 4
    //   139: aload 4
    //   141: ldc 160
    //   143: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: aload_0
    //   150: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 4
    //   156: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 43	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: ifnull +10 -> 173
    //   166: aload_1
    //   167: invokevirtual 158	java/util/jar/JarFile:close	()V
    //   170: goto +4 -> 174
    //   173: pop
    //   174: ldc 162
    //   176: areturn
    //   177: aload_1
    //   178: ifnull +10 -> 188
    //   181: aload_1
    //   182: invokevirtual 158	java/util/jar/JarFile:close	()V
    //   185: goto +4 -> 189
    //   188: pop
    //   189: aload 8
    //   191: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   89	94	97	java/lang/Exception
    //   69	84	101	finally
    //   69	84	109	java/lang/Exception
    //   2	17	120	finally
    //   24	59	120	finally
    //   59	69	120	finally
    //   126	162	120	finally
    //   2	17	125	java/lang/Exception
    //   24	59	125	java/lang/Exception
    //   59	69	125	java/lang/Exception
    //   166	170	173	java/lang/Exception
    //   181	185	188	java/lang/Exception
  }

  private static boolean b(Context paramContext, String paramString)
  {
    String str = b(paramString);
    if (TextUtils.isEmpty(str))
      return false;
    int i;
    try
    {
      i = Integer.valueOf(str).intValue();
    }
    catch (Exception localException)
    {
      bd.b(localException);
      i = 0;
    }
    boolean bool = false;
    if (i >= 4)
      bool = true;
    return bool;
  }

  private static boolean c(Context paramContext, String paramString)
  {
    String str1 = cx.a(new File(paramString));
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("remote.jar local file digest value digest = ");
    localStringBuilder1.append(str1);
    bd.a(localStringBuilder1.toString());
    if (TextUtils.isEmpty(str1));
    String str3;
    for (String str4 = "remote.jar local file digest value fail"; ; str4 = "remote.jar config digest value lost")
    {
      bd.a(str4);
      return false;
      String str2 = b(paramString);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("remote.jar local file digest value version = ");
      localStringBuilder2.append(str2);
      bd.a(localStringBuilder2.toString());
      if (TextUtils.isEmpty(str2))
        return false;
      str3 = d(paramContext, str2);
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("remote.jar config digest value remoteJarMd5 = ");
      localStringBuilder3.append(str3);
      bd.a(localStringBuilder3.toString());
      if (!TextUtils.isEmpty(str3))
        break;
    }
    return str1.equals(str3);
  }

  private static String d(Context paramContext, String paramString)
  {
    return az.a(paramContext).c(paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ax
 * JD-Core Version:    0.6.2
 */