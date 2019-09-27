package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

class bm
{
  private static HandlerThread b = new HandlerThread("EventHandleThread");
  private static Handler c;
  private static bm d = new bm();
  HashMap<String, bs> a = new HashMap();

  private bm()
  {
    b.start();
    b.setPriority(10);
    c = new Handler(b.getLooper());
  }

  public static bm a()
  {
    return d;
  }

  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__sdk_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("$|$");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }

  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, ExtraInfo paramExtraInfo)
  {
    DataCore.instance().putEvent(paramContext, paramString1, paramString2, paramInt, paramLong1, paramLong2, "", "", 0, false, paramExtraInfo);
    DataCore.instance().flush(paramContext);
  }

  public void a(Context paramContext, String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean)
  {
    DataCore.instance().putEvent(paramContext, paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramString3, paramString4, paramInt2, paramBoolean, null);
    DataCore.instance().flush(paramContext);
  }

  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong, ExtraInfo paramExtraInfo)
  {
    Handler localHandler = c;
    bo localbo = new bo(this, paramContext, paramString1, paramString2, paramInt, paramLong, paramExtraInfo);
    localHandler.post(localbo);
  }

  public void a(Context paramContext, String paramString1, String paramString2, int paramInt1, long paramLong, String paramString3, String paramString4, int paramInt2, boolean paramBoolean)
  {
    Handler localHandler = c;
    bn localbn = new bn(this, paramContext, paramString1, paramString2, paramInt1, paramLong, paramString3, paramString4, paramInt2, paramBoolean);
    localHandler.post(localbn);
  }

  public void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    Handler localHandler = c;
    bp localbp = new bp(this, paramLong, paramString1, paramString2);
    localHandler.post(localbp);
  }

  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo)
  {
    Handler localHandler = c;
    bq localbq = new bq(this, paramString1, paramString2, paramLong, paramContext, paramExtraInfo);
    localHandler.post(localbq);
  }

  public void b(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo)
  {
    Handler localHandler = c;
    br localbr = new br(this, paramLong, paramContext, paramString1, paramString2, paramExtraInfo);
    localHandler.post(localbr);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bm
 * JD-Core Version:    0.6.2
 */