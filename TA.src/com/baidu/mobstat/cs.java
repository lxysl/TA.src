package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;

public final class cs
{
  private static final Proxy a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
  private static final Proxy b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

  // ERROR //
  public static File a(String paramString)
  {
    // Byte code:
    //   0: ldc 39
    //   2: invokestatic 42	com/baidu/mobstat/cs:a	()Ljava/lang/String;
    //   5: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 54	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   16: astore_1
    //   17: goto +5 -> 22
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 56	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_0
    //   34: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   13	17	20	java/lang/Exception
  }

  // ERROR //
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 62	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: astore_0
    //   4: aload_0
    //   5: areturn
    //   6: aconst_null
    //   7: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	4	6	java/lang/Exception
  }

  // ERROR //
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 69	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 72	com/baidu/mobstat/cs:a	(Ljava/io/InputStream;)[B
    //   10: astore 5
    //   12: aload 5
    //   14: ifnull +41 -> 55
    //   17: new 44	java/lang/String
    //   20: dup
    //   21: aload 5
    //   23: ldc 74
    //   25: invokespecial 77	java/lang/String:<init>	([BLjava/lang/String;)V
    //   28: astore 6
    //   30: aload_2
    //   31: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   34: aload 6
    //   36: areturn
    //   37: astore_3
    //   38: goto +6 -> 44
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   48: aload_3
    //   49: athrow
    //   50: aconst_null
    //   51: astore_2
    //   52: goto +4 -> 56
    //   55: pop
    //   56: aload_2
    //   57: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   60: ldc 84
    //   62: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   6	12	37	finally
    //   17	30	37	finally
    //   0	6	41	finally
    //   0	6	50	java/lang/Exception
    //   6	12	55	java/lang/Exception
    //   17	30	55	java/lang/Exception
  }

  @SuppressLint({"DefaultLocale"})
  public static HttpURLConnection a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    URL localURL = new URL(paramString);
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo1 = localConnectivityManager.getNetworkInfo(0);
    NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(1);
    if ((localNetworkInfo2 != null) && (localNetworkInfo2.isAvailable()))
      cz.a("WIFI is available");
    Proxy localProxy;
    for (URLConnection localURLConnection = localURL.openConnection(); ; localURLConnection = localURL.openConnection(localProxy))
    {
      localHttpURLConnection = (HttpURLConnection)localURLConnection;
      break label187;
      if ((localNetworkInfo1 == null) || (!localNetworkInfo1.isAvailable()))
        break;
      String str1 = localNetworkInfo1.getExtraInfo();
      String str2;
      if (str1 != null)
        str2 = str1.toLowerCase();
      else
        str2 = "";
      cz.a(str2);
      if ((!str2.startsWith("cmwap")) && (!str2.startsWith("uniwap")) && (!str2.startsWith("3gwap")))
      {
        if (!str2.startsWith("ctwap"))
          break;
        localProxy = b;
      }
      else
      {
        localProxy = a;
      }
    }
    HttpURLConnection localHttpURLConnection = null;
    label187: if (localHttpURLConnection == null)
      localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
    localHttpURLConnection.setConnectTimeout(paramInt1);
    localHttpURLConnection.setReadTimeout(paramInt2);
    return localHttpURLConnection;
  }

  // ERROR //
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: iload_3
    //   6: ifeq +10 -> 16
    //   9: ldc 153
    //   11: istore 4
    //   13: goto +6 -> 19
    //   16: iconst_0
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: iload 4
    //   23: invokevirtual 157	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   26: astore 5
    //   28: new 159	java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_2
    //   33: ldc 74
    //   35: invokevirtual 163	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   38: invokespecial 166	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: aload 5
    //   43: invokestatic 169	com/baidu/mobstat/cy:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   46: pop
    //   47: goto +27 -> 74
    //   50: astore 6
    //   52: goto +8 -> 60
    //   55: astore 6
    //   57: aconst_null
    //   58: astore 5
    //   60: aload 5
    //   62: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   65: aload 6
    //   67: athrow
    //   68: aconst_null
    //   69: astore 5
    //   71: goto +4 -> 75
    //   74: pop
    //   75: aload 5
    //   77: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   80: return
    //
    // Exception table:
    //   from	to	target	type
    //   28	47	50	finally
    //   19	28	55	finally
    //   19	28	68	java/lang/Exception
    //   28	47	74	java/lang/Exception
  }

  // ERROR //
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 172	com/baidu/mobstat/cs:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload 5
    //   12: ifnull +94 -> 106
    //   15: aload 5
    //   17: invokevirtual 175	java/io/File:exists	()Z
    //   20: istore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: iload 6
    //   26: ifne +23 -> 49
    //   29: aload 5
    //   31: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   34: astore 7
    //   36: aconst_null
    //   37: astore_3
    //   38: aload 7
    //   40: ifnull +9 -> 49
    //   43: aload 7
    //   45: invokevirtual 181	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: new 183	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: iload_2
    //   56: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   59: astore 9
    //   61: new 159	java/io/ByteArrayInputStream
    //   64: dup
    //   65: aload_1
    //   66: ldc 74
    //   68: invokevirtual 163	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   71: invokespecial 166	java/io/ByteArrayInputStream:<init>	([B)V
    //   74: aload 9
    //   76: invokestatic 169	com/baidu/mobstat/cy:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   79: pop
    //   80: goto +11 -> 91
    //   83: astore 4
    //   85: aload 9
    //   87: astore_3
    //   88: goto +11 -> 99
    //   91: aload 9
    //   93: astore_3
    //   94: goto +12 -> 106
    //   97: astore 4
    //   99: aload_3
    //   100: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   103: aload 4
    //   105: athrow
    //   106: aload_3
    //   107: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   110: return
    //
    // Exception table:
    //   from	to	target	type
    //   61	80	83	finally
    //   61	80	91	java/lang/Exception
    //   2	8	97	finally
    //   15	22	97	finally
    //   29	36	97	finally
    //   43	49	97	finally
    //   49	61	97	finally
    //   2	8	106	java/lang/Exception
    //   15	22	106	java/lang/Exception
    //   29	36	106	java/lang/Exception
    //   43	49	106	java/lang/Exception
    //   49	61	106	java/lang/Exception
  }

  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (cy.a(paramInputStream, localByteArrayOutputStream))
      return localByteArrayOutputStream.toByteArray();
    return null;
  }

  // ERROR //
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	com/baidu/mobstat/cs:a	(Ljava/lang/String;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +76 -> 82
    //   9: aload_1
    //   10: invokevirtual 175	java/io/File:exists	()Z
    //   13: ifeq +69 -> 82
    //   16: new 197	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokestatic 72	com/baidu/mobstat/cs:a	(Ljava/io/InputStream;)[B
    //   29: astore 5
    //   31: aload 5
    //   33: ifnull +44 -> 77
    //   36: new 44	java/lang/String
    //   39: dup
    //   40: aload 5
    //   42: ldc 74
    //   44: invokespecial 77	java/lang/String:<init>	([BLjava/lang/String;)V
    //   47: astore 6
    //   49: aload_2
    //   50: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   53: aload 6
    //   55: areturn
    //   56: astore 4
    //   58: goto +7 -> 65
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   69: aload 4
    //   71: athrow
    //   72: aconst_null
    //   73: astore_2
    //   74: goto +4 -> 78
    //   77: pop
    //   78: aload_2
    //   79: invokestatic 82	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   82: ldc 84
    //   84: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   25	31	56	finally
    //   36	49	56	finally
    //   16	25	61	finally
    //   16	25	72	java/lang/Exception
    //   25	31	77	java/lang/Exception
    //   36	49	77	java/lang/Exception
  }

  public static boolean b(Context paramContext, String paramString)
  {
    return paramContext.deleteFile(paramString);
  }

  public static boolean c(Context paramContext, String paramString)
  {
    return paramContext.getFileStreamPath(paramString).exists();
  }

  public static boolean c(String paramString)
  {
    File localFile = a(paramString);
    if ((localFile != null) && (localFile.isFile()))
      return localFile.delete();
    return false;
  }

  public static HttpURLConnection d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 50000, 50000);
  }

  // ERROR //
  public static boolean e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 224	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   5: istore_2
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_2
    //   9: iconst_m1
    //   10: if_icmpeq +5 -> 15
    //   13: iconst_1
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: ldc 226
    //   19: invokestatic 228	com/baidu/mobstat/cz:b	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	17	java/lang/Exception
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cs
 * JD-Core Version:    0.6.2
 */