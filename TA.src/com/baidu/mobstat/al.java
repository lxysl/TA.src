package com.baidu.mobstat;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;

public class al
{
  private static String a = str;
  private static al b;
  private Handler c;

  static
  {
    String str;
    if (Build.VERSION.SDK_INT < 9)
      str = "http://openrcv.baidu.com/1010/bplus.gif";
    else
      str = "https://openrcv.baidu.com/1010/bplus.gif";
  }

  private al()
  {
    HandlerThread localHandlerThread = new HandlerThread("LogSender");
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }

  public static al a()
  {
    if (b == null)
      try
      {
        if (b == null)
          b = new al();
      }
      finally
      {
      }
    return b;
  }

  // ERROR //
  private String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_2
    //   2: ldc 57
    //   4: invokevirtual 63	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7: ixor
    //   8: istore 4
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 69	com/baidu/mobstat/cs:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   15: astore 5
    //   17: aload 5
    //   19: iconst_1
    //   20: invokevirtual 75	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   23: aload 5
    //   25: iconst_0
    //   26: invokevirtual 78	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   29: aload 5
    //   31: iconst_0
    //   32: invokevirtual 81	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   35: aload 5
    //   37: ldc 83
    //   39: ldc 85
    //   41: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 5
    //   46: invokevirtual 92	java/net/HttpURLConnection:connect	()V
    //   49: aload 5
    //   51: invokevirtual 96	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   54: astore 8
    //   56: new 98	java/util/zip/GZIPOutputStream
    //   59: dup
    //   60: aload 8
    //   62: invokespecial 101	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 9
    //   67: aload 9
    //   69: iconst_4
    //   70: newarray byte
    //   72: dup
    //   73: iconst_0
    //   74: ldc 102
    //   76: bastore
    //   77: dup
    //   78: iconst_1
    //   79: ldc 103
    //   81: bastore
    //   82: dup
    //   83: iconst_2
    //   84: ldc 104
    //   86: bastore
    //   87: dup
    //   88: iconst_3
    //   89: ldc 105
    //   91: bastore
    //   92: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   95: aload 9
    //   97: iconst_4
    //   98: newarray byte
    //   100: dup
    //   101: iconst_0
    //   102: ldc 110
    //   104: bastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc 110
    //   109: bastore
    //   110: dup
    //   111: iconst_2
    //   112: ldc 110
    //   114: bastore
    //   115: dup
    //   116: iconst_3
    //   117: ldc 111
    //   119: bastore
    //   120: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   123: aload 9
    //   125: iconst_4
    //   126: newarray byte
    //   128: dup
    //   129: iconst_0
    //   130: ldc 110
    //   132: bastore
    //   133: dup
    //   134: iconst_1
    //   135: ldc 110
    //   137: bastore
    //   138: dup
    //   139: iconst_2
    //   140: ldc 112
    //   142: bastore
    //   143: dup
    //   144: iconst_3
    //   145: ldc 113
    //   147: bastore
    //   148: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   151: aload 9
    //   153: bipush 8
    //   155: newarray byte
    //   157: dup
    //   158: iconst_0
    //   159: ldc 110
    //   161: bastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc 110
    //   166: bastore
    //   167: dup
    //   168: iconst_2
    //   169: ldc 110
    //   171: bastore
    //   172: dup
    //   173: iconst_3
    //   174: ldc 110
    //   176: bastore
    //   177: dup
    //   178: iconst_4
    //   179: ldc 110
    //   181: bastore
    //   182: dup
    //   183: iconst_5
    //   184: ldc 110
    //   186: bastore
    //   187: dup
    //   188: bipush 6
    //   190: ldc 110
    //   192: bastore
    //   193: dup
    //   194: bipush 7
    //   196: ldc 110
    //   198: bastore
    //   199: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   202: aload 9
    //   204: iconst_2
    //   205: newarray byte
    //   207: dup
    //   208: iconst_0
    //   209: ldc 110
    //   211: bastore
    //   212: dup
    //   213: iconst_1
    //   214: ldc 114
    //   216: bastore
    //   217: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   220: iload 4
    //   222: ifeq +30 -> 252
    //   225: iconst_2
    //   226: newarray byte
    //   228: astore 10
    //   230: aload 10
    //   232: iconst_0
    //   233: ldc 110
    //   235: bastore
    //   236: aload 10
    //   238: iconst_1
    //   239: ldc 111
    //   241: bastore
    //   242: aload 9
    //   244: aload 10
    //   246: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   249: goto +21 -> 270
    //   252: iconst_2
    //   253: newarray byte
    //   255: dup
    //   256: iconst_0
    //   257: ldc 110
    //   259: bastore
    //   260: dup
    //   261: iconst_1
    //   262: ldc 110
    //   264: bastore
    //   265: astore 10
    //   267: goto -25 -> 242
    //   270: aload 9
    //   272: iconst_4
    //   273: newarray byte
    //   275: dup
    //   276: iconst_0
    //   277: ldc 102
    //   279: bastore
    //   280: dup
    //   281: iconst_1
    //   282: ldc 103
    //   284: bastore
    //   285: dup
    //   286: iconst_2
    //   287: ldc 104
    //   289: bastore
    //   290: dup
    //   291: iconst_3
    //   292: ldc 105
    //   294: bastore
    //   295: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   298: iload 4
    //   300: ifeq +162 -> 462
    //   303: invokestatic 119	com/baidu/mobstat/cq:a	()[B
    //   306: astore 11
    //   308: iconst_0
    //   309: invokestatic 122	com/baidu/mobstat/cu:a	()[B
    //   312: aload 11
    //   314: invokestatic 127	com/baidu/mobstat/da:a	(Z[B[B)[B
    //   317: astore 12
    //   319: aload 9
    //   321: aload 12
    //   323: arraylength
    //   324: i2l
    //   325: iconst_4
    //   326: invokestatic 130	com/baidu/mobstat/al:a	(JI)[B
    //   329: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   332: aload 9
    //   334: aload 12
    //   336: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   339: aload 11
    //   341: bipush 16
    //   343: newarray byte
    //   345: dup
    //   346: iconst_0
    //   347: ldc 111
    //   349: bastore
    //   350: dup
    //   351: iconst_1
    //   352: ldc 111
    //   354: bastore
    //   355: dup
    //   356: iconst_2
    //   357: ldc 111
    //   359: bastore
    //   360: dup
    //   361: iconst_3
    //   362: ldc 111
    //   364: bastore
    //   365: dup
    //   366: iconst_4
    //   367: ldc 111
    //   369: bastore
    //   370: dup
    //   371: iconst_5
    //   372: ldc 111
    //   374: bastore
    //   375: dup
    //   376: bipush 6
    //   378: ldc 111
    //   380: bastore
    //   381: dup
    //   382: bipush 7
    //   384: ldc 111
    //   386: bastore
    //   387: dup
    //   388: bipush 8
    //   390: ldc 111
    //   392: bastore
    //   393: dup
    //   394: bipush 9
    //   396: ldc 111
    //   398: bastore
    //   399: dup
    //   400: bipush 10
    //   402: ldc 111
    //   404: bastore
    //   405: dup
    //   406: bipush 11
    //   408: ldc 111
    //   410: bastore
    //   411: dup
    //   412: bipush 12
    //   414: ldc 111
    //   416: bastore
    //   417: dup
    //   418: bipush 13
    //   420: ldc 111
    //   422: bastore
    //   423: dup
    //   424: bipush 14
    //   426: ldc 111
    //   428: bastore
    //   429: dup
    //   430: bipush 15
    //   432: ldc 111
    //   434: bastore
    //   435: aload_3
    //   436: ldc 132
    //   438: invokevirtual 136	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   441: invokestatic 139	com/baidu/mobstat/cq:a	([B[B[B)[B
    //   444: astore 13
    //   446: aload 9
    //   448: aload 13
    //   450: arraylength
    //   451: i2l
    //   452: iconst_2
    //   453: invokestatic 130	com/baidu/mobstat/al:a	(JI)[B
    //   456: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   459: goto +11 -> 470
    //   462: aload_3
    //   463: ldc 132
    //   465: invokevirtual 136	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   468: astore 13
    //   470: aload 9
    //   472: aload 13
    //   474: invokevirtual 109	java/util/zip/GZIPOutputStream:write	([B)V
    //   477: aload 9
    //   479: invokevirtual 142	java/util/zip/GZIPOutputStream:close	()V
    //   482: aload 8
    //   484: invokevirtual 145	java/io/OutputStream:close	()V
    //   487: aload 5
    //   489: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   492: istore 14
    //   494: aload 5
    //   496: invokevirtual 152	java/net/HttpURLConnection:getContentLength	()I
    //   499: istore 15
    //   501: new 154	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   508: astore 16
    //   510: aload 16
    //   512: ldc 157
    //   514: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 16
    //   520: iload 14
    //   522: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 16
    //   528: ldc 166
    //   530: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 16
    //   536: iload 15
    //   538: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 16
    //   544: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 174	com/baidu/mobstat/bd:c	(Ljava/lang/String;)V
    //   550: iload 14
    //   552: sipush 200
    //   555: if_icmpne +79 -> 634
    //   558: iload 15
    //   560: ifeq +6 -> 566
    //   563: goto +71 -> 634
    //   566: new 176	java/io/BufferedReader
    //   569: dup
    //   570: new 178	java/io/InputStreamReader
    //   573: dup
    //   574: aload 5
    //   576: invokevirtual 182	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   579: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   582: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   585: astore 24
    //   587: new 154	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   594: astore 25
    //   596: aload 24
    //   598: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   601: astore 26
    //   603: aload 26
    //   605: ifnonnull +18 -> 623
    //   608: aload 25
    //   610: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: astore 27
    //   615: aload 5
    //   617: invokevirtual 194	java/net/HttpURLConnection:disconnect	()V
    //   620: aload 27
    //   622: areturn
    //   623: aload 25
    //   625: aload 26
    //   627: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: goto -35 -> 596
    //   634: new 154	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   641: astore 21
    //   643: aload 21
    //   645: ldc 196
    //   647: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 21
    //   653: aload 5
    //   655: invokevirtual 149	java/net/HttpURLConnection:getResponseCode	()I
    //   658: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: new 198	java/io/IOException
    //   665: dup
    //   666: aload 21
    //   668: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   674: athrow
    //   675: astore 7
    //   677: goto +18 -> 695
    //   680: astore 6
    //   682: aload 6
    //   684: invokestatic 202	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   687: aload 5
    //   689: invokevirtual 194	java/net/HttpURLConnection:disconnect	()V
    //   692: ldc 204
    //   694: areturn
    //   695: aload 5
    //   697: invokevirtual 194	java/net/HttpURLConnection:disconnect	()V
    //   700: aload 7
    //   702: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   49	220	675	finally
    //   225	242	675	finally
    //   242	249	675	finally
    //   252	267	675	finally
    //   270	298	675	finally
    //   303	459	675	finally
    //   462	470	675	finally
    //   470	550	675	finally
    //   566	596	675	finally
    //   596	603	675	finally
    //   608	615	675	finally
    //   623	631	675	finally
    //   634	675	675	finally
    //   682	687	675	finally
    //   49	220	680	java/lang/Exception
    //   225	242	680	java/lang/Exception
    //   242	249	680	java/lang/Exception
    //   252	267	680	java/lang/Exception
    //   270	298	680	java/lang/Exception
    //   303	459	680	java/lang/Exception
    //   462	470	680	java/lang/Exception
    //   470	550	680	java/lang/Exception
    //   566	596	680	java/lang/Exception
    //   596	603	680	java/lang/Exception
    //   608	615	680	java/lang/Exception
    //   623	631	680	java/lang/Exception
    //   634	675	680	java/lang/Exception
  }

  private void a(Context paramContext)
  {
    if (!"mounted".equals(cs.a()))
      return;
    File localFile1 = new File(Environment.getExternalStorageDirectory(), "backups/system");
    if (!localFile1.exists())
      return;
    File[] arrayOfFile = localFile1.listFiles();
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length == 0)
        return;
      try
      {
        Arrays.sort(arrayOfFile, new an(this));
      }
      catch (Exception localException)
      {
        bd.b(localException);
      }
      int i = arrayOfFile.length;
      int j = 0;
      int k = 0;
      while (j < i)
      {
        File localFile2 = arrayOfFile[j];
        if (localFile2.isFile())
        {
          String str1 = localFile2.getName();
          if ((!TextUtils.isEmpty(str1)) && (str1.startsWith("__send_log_data_")))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("backups/system");
            localStringBuilder.append(File.separator);
            localStringBuilder.append(str1);
            String str2 = localStringBuilder.toString();
            if (b(paramContext, cs.b(str2)))
            {
              cs.c(str2);
              k = 0;
            }
            else
            {
              k++;
              if (k >= 5)
                return;
            }
          }
        }
        j++;
      }
    }
  }

  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("backups/system");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("__send_log_data_");
    localStringBuilder.append(System.currentTimeMillis());
    cs.a(localStringBuilder.toString(), paramString, false);
  }

  private static byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++)
    {
      arrayOfByte[(-1 + (paramInt - i))] = ((byte)(int)(paramLong & 0xFF));
      paramLong >>= 8;
    }
    return arrayOfByte;
  }

  private boolean b(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      try
      {
        a(paramContext, a, paramString);
        return true;
      }
      catch (Exception localException)
      {
        bd.c(localException);
      }
    }
    return false;
  }

  public void a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data = ");
    localStringBuilder.append(paramString);
    bd.a(localStringBuilder.toString());
    if (paramString != null)
    {
      if ("".equals(paramString))
        return;
      this.c.post(new am(this, paramString, paramContext));
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.al
 * JD-Core Version:    0.6.2
 */