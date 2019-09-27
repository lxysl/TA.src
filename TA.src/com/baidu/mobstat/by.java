package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;

class by
{
  private static by a = new by();
  private boolean b = false;
  private int c = 0;
  private int d = 1;
  private SendStrategyEnum e = SendStrategyEnum.APP_START;
  private Timer f;
  private Handler g;

  private by()
  {
    HandlerThread localHandlerThread = new HandlerThread("LogSenderThread");
    localHandlerThread.start();
    this.g = new Handler(localHandlerThread.getLooper());
  }

  public static by a()
  {
    return a;
  }

  private String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!paramString1.startsWith("https:"))
      return c(paramContext, paramString1, paramString2);
    return b(paramContext, paramString1, paramString2);
  }

  private String b(Context paramContext, String paramString1, String paramString2)
  {
    HttpURLConnection localHttpURLConnection = cs.d(paramContext, paramString1);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setInstanceFollowRedirects(false);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setRequestProperty("Content-Type", "gzip");
    localHttpURLConnection.connect();
    cz.a("AdUtil.httpPost connected");
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(localHttpURLConnection.getOutputStream())));
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
      StringBuilder localStringBuilder1 = new StringBuilder();
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        localStringBuilder1.append(str1);
      }
      int i = localHttpURLConnection.getContentLength();
      if ((localHttpURLConnection.getResponseCode() == 200) && (i == 0))
      {
        String str2 = localStringBuilder1.toString();
        return str2;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("http code = ");
      localStringBuilder2.append(localHttpURLConnection.getResponseCode());
      localStringBuilder2.append("; contentResponse = ");
      localStringBuilder2.append(localStringBuilder1);
      throw new IOException(localStringBuilder2.toString());
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
  }

  private boolean b(Context paramContext, String paramString)
  {
    boolean bool1 = this.b;
    boolean bool2 = false;
    if ((bool1) && (!dc.n(paramContext)))
      return false;
    try
    {
      a(paramContext, Config.LOG_SEND_URL, paramString);
      bool2 = true;
    }
    catch (Exception localException)
    {
      cz.c(localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send log data over. result = ");
    localStringBuilder.append(bool2);
    localStringBuilder.append("; data=");
    localStringBuilder.append(paramString);
    cz.a(localStringBuilder.toString());
    return bool2;
  }

  private String c(Context paramContext, String paramString1, String paramString2)
  {
    cz.a("httpPostEncrypt");
    HttpURLConnection localHttpURLConnection = cs.d(paramContext, paramString1);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setInstanceFollowRedirects(false);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setRequestProperty("Content-Type", "gzip");
    byte[] arrayOfByte1 = cq.a();
    byte[] arrayOfByte2 = cq.b();
    localHttpURLConnection.setRequestProperty("key", da.a(arrayOfByte1));
    localHttpURLConnection.setRequestProperty("iv", da.a(arrayOfByte2));
    byte[] arrayOfByte3 = cq.a(arrayOfByte1, arrayOfByte2, paramString2.getBytes("utf-8"));
    localHttpURLConnection.connect();
    cz.a("AdUtil.httpPost connected");
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localHttpURLConnection.getOutputStream());
      localGZIPOutputStream.write(arrayOfByte3);
      localGZIPOutputStream.flush();
      localGZIPOutputStream.close();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
      StringBuilder localStringBuilder1 = new StringBuilder();
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        localStringBuilder1.append(str1);
      }
      int i = localHttpURLConnection.getContentLength();
      if ((localHttpURLConnection.getResponseCode() == 200) && (i == 0))
      {
        String str2 = localStringBuilder1.toString();
        return str2;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("http code = ");
      localStringBuilder2.append(localHttpURLConnection.getResponseCode());
      localStringBuilder2.append("; contentResponse = ");
      localStringBuilder2.append(localStringBuilder1);
      throw new IOException(localStringBuilder2.toString());
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
  }

  private void c(Context paramContext)
  {
    if ((this.b) && (!dc.n(paramContext)))
      return;
    this.g.post(new cc(this, paramContext));
  }

  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 30))
      this.c = paramInt;
  }

  public void a(Context paramContext)
  {
    if (paramContext != null)
      paramContext = paramContext.getApplicationContext();
    if (paramContext == null)
      return;
    this.g.post(new bz(this, paramContext));
  }

  public void a(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt, boolean paramBoolean)
  {
    if (paramSendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL))
    {
      if ((paramInt > 0) && (paramInt <= 24))
      {
        this.d = paramInt;
        this.e = SendStrategyEnum.SET_TIME_INTERVAL;
        bj.a().a(paramContext, this.e.ordinal());
        bj.a().b(paramContext, this.d);
      }
      else
      {
        cz.c("timeInterval is invalid, new strategy does not work");
      }
    }
    else
    {
      this.e = paramSendStrategyEnum;
      bj.a().a(paramContext, this.e.ordinal());
      if (paramSendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY))
        bj.a().b(paramContext, 24);
    }
    this.b = paramBoolean;
    bj.a().a(paramContext, this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sstype is:");
    localStringBuilder.append(this.e.name());
    localStringBuilder.append(" And timeInterval is:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" And mOnlyWifi:");
    localStringBuilder.append(this.b);
    cz.a(localStringBuilder.toString());
  }

  public void a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__send_data_");
    localStringBuilder.append(System.currentTimeMillis());
    cs.a(paramContext, localStringBuilder.toString(), paramString, false);
  }

  public void b(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    long l = 3600000 * this.d;
    this.f = new Timer();
    this.f.schedule(new cb(this, localContext), l, l);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.by
 * JD-Core Version:    0.6.2
 */