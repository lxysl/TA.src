package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

class ay extends Thread
{
  private Context a;
  private l b;

  public ay(Context paramContext, l paraml)
  {
    this.a = paramContext;
    this.b = paraml;
  }

  // ERROR //
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 21
    //   4: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 15	com/baidu/mobstat/ay:a	Landroid/content/Context;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 17	com/baidu/mobstat/ay:b	Lcom/baidu/mobstat/l;
    //   16: astore_3
    //   17: aload_0
    //   18: aload_2
    //   19: invokespecial 29	com/baidu/mobstat/ay:b	(Landroid/content/Context;)Ljava/lang/String;
    //   22: astore 4
    //   24: new 31	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: ldc 34
    //   37: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: aload 4
    //   45: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 45	com/baidu/mobstat/bd:c	(Ljava/lang/String;)V
    //   57: aload_2
    //   58: aload 4
    //   60: invokestatic 51	com/baidu/mobstat/cs:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   63: astore 8
    //   65: aload 8
    //   67: invokevirtual 56	java/net/HttpURLConnection:connect	()V
    //   70: aload 8
    //   72: ldc 58
    //   74: invokevirtual 62	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: new 31	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   86: astore 11
    //   88: aload 11
    //   90: ldc 64
    //   92: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 11
    //   98: aload 10
    //   100: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 11
    //   106: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   112: aload 8
    //   114: ldc 66
    //   116: invokevirtual 62	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 14
    //   121: new 31	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   128: astore 15
    //   130: aload 15
    //   132: ldc 68
    //   134: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 15
    //   140: aload 14
    //   142: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 15
    //   148: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   154: aload 8
    //   156: invokevirtual 72	java/net/HttpURLConnection:getResponseCode	()I
    //   159: istore 18
    //   161: new 31	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   168: astore 19
    //   170: aload 19
    //   172: ldc 74
    //   174: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 19
    //   180: iload 18
    //   182: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 19
    //   188: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   194: aload 8
    //   196: invokevirtual 80	java/net/HttpURLConnection:getContentLength	()I
    //   199: istore 22
    //   201: new 31	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   208: astore 23
    //   210: aload 23
    //   212: ldc 82
    //   214: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 23
    //   220: iload 22
    //   222: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 23
    //   228: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   234: iload 18
    //   236: sipush 200
    //   239: if_icmpne +79 -> 318
    //   242: iload 22
    //   244: ifle +74 -> 318
    //   247: aload_2
    //   248: ldc 84
    //   250: iconst_0
    //   251: invokevirtual 90	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   254: astore 28
    //   256: aload 8
    //   258: invokevirtual 94	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   261: aload 28
    //   263: invokestatic 99	com/baidu/mobstat/cy:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   266: ifeq +8 -> 274
    //   269: ldc 101
    //   271: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   274: aload 28
    //   276: invokestatic 104	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   279: goto +39 -> 318
    //   282: astore 27
    //   284: goto +16 -> 300
    //   287: astore 29
    //   289: aconst_null
    //   290: astore 28
    //   292: goto +18 -> 310
    //   295: astore 27
    //   297: aconst_null
    //   298: astore 28
    //   300: aload 27
    //   302: invokestatic 107	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   305: goto -31 -> 274
    //   308: astore 29
    //   310: aload 28
    //   312: invokestatic 104	com/baidu/mobstat/cy:a	(Ljava/io/Closeable;)V
    //   315: aload 29
    //   317: athrow
    //   318: aconst_null
    //   319: invokestatic 112	com/baidu/mobstat/ax:a	(Ldalvik/system/DexClassLoader;)Ldalvik/system/DexClassLoader;
    //   322: pop
    //   323: invokestatic 116	com/baidu/mobstat/au:a	()V
    //   326: aload 10
    //   328: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifne +12 -> 343
    //   334: aload_3
    //   335: aload_2
    //   336: aload 10
    //   338: invokeinterface 127 3 0
    //   343: aload 14
    //   345: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +12 -> 360
    //   351: aload_3
    //   352: aload_2
    //   353: aload 14
    //   355: invokeinterface 129 3 0
    //   360: aload 8
    //   362: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   365: ldc 134
    //   367: invokestatic 26	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   370: aload_0
    //   371: monitorexit
    //   372: return
    //   373: astore 9
    //   375: aload 8
    //   377: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   380: aload 9
    //   382: athrow
    //   383: astore_1
    //   384: aload_0
    //   385: monitorexit
    //   386: aload_1
    //   387: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   256	274	282	java/io/IOException
    //   247	256	287	finally
    //   247	256	295	java/io/IOException
    //   256	274	308	finally
    //   300	305	308	finally
    //   65	234	373	finally
    //   274	279	373	finally
    //   310	318	373	finally
    //   318	343	373	finally
    //   343	360	373	finally
    //   2	65	383	finally
    //   360	370	383	finally
    //   375	383	383	finally
  }

  private void a(Context paramContext)
  {
    this.b.a(paramContext, System.currentTimeMillis());
  }

  private String b(Context paramContext)
  {
    File localFile1 = paramContext.getFileStreamPath(".remote.jar");
    if ((localFile1 != null) && (localFile1.exists()))
    {
      File localFile2 = paramContext.getFileStreamPath(".remote.jar");
      if (localFile2 != null)
      {
        str1 = ax.a(localFile2.getAbsolutePath());
        StringBuilder localStringBuilder4 = new StringBuilder();
        localStringBuilder4.append("startDownload remote jar file version = ");
        localStringBuilder4.append(str1);
        bd.a(localStringBuilder4.toString());
        if (!TextUtils.isEmpty(str1))
          break label85;
      }
    }
    String str1 = "13";
    label85: ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("");
    localStringBuilder1.append(str1);
    localArrayList.add(new BasicNameValuePair("dynamicVersion", localStringBuilder1.toString()));
    localArrayList.add(new BasicNameValuePair("packageName", dc.p(paramContext)));
    localArrayList.add(new BasicNameValuePair("appVersion", dc.f(paramContext)));
    localArrayList.add(new BasicNameValuePair("cuid", dc.a(paramContext)));
    localArrayList.add(new BasicNameValuePair("platform", "Android"));
    localArrayList.add(new BasicNameValuePair("m", Build.MODEL));
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(Build.VERSION.SDK_INT);
    localStringBuilder2.append("");
    localArrayList.add(new BasicNameValuePair("s", localStringBuilder2.toString()));
    localArrayList.add(new BasicNameValuePair("o", Build.VERSION.RELEASE));
    localArrayList.add(new BasicNameValuePair("i", "13"));
    String str2 = URLEncodedUtils.format(localArrayList, "utf-8");
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append(bb.c);
    localStringBuilder3.append("?");
    localStringBuilder3.append(str2);
    return localStringBuilder3.toString();
  }

  public void run()
  {
    while (true)
    {
      try
      {
        if (!bb.a)
          break label86;
        i = 3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start version check in ");
        localStringBuilder.append(i);
        localStringBuilder.append("s");
        bd.a(localStringBuilder.toString());
        sleep(i * 1000);
        a();
        a(this.a);
      }
      catch (Exception localException)
      {
        bd.a(localException);
      }
      ax.a(false);
      return;
      label86: int i = 10;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ay
 * JD-Core Version:    0.6.2
 */