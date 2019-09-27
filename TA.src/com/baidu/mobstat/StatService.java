package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.a.a.a;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StatService
{
  public static final int EXCEPTION_LOG = 1;
  public static final int JAVA_EXCEPTION_LOG = 16;
  private static boolean a;
  private static long b;

  // ERROR //
  private static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 27	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: invokevirtual 31	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   6: astore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_1
    //   11: arraylength
    //   12: if_icmpge +72 -> 84
    //   15: aload_1
    //   16: iload_2
    //   17: aaload
    //   18: invokevirtual 37	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +6 -> 32
    //   29: goto +49 -> 78
    //   32: aload_3
    //   33: invokestatic 49	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: astore 4
    //   38: goto +6 -> 44
    //   41: aconst_null
    //   42: astore 4
    //   44: aload 4
    //   46: ifnonnull +6 -> 52
    //   49: goto +29 -> 78
    //   52: ldc 51
    //   54: aload 4
    //   56: invokevirtual 55	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   59: ifeq +19 -> 78
    //   62: iload_0
    //   63: ifeq +9 -> 72
    //   66: aload 4
    //   68: invokevirtual 58	java/lang/Class:getName	()Ljava/lang/String;
    //   71: areturn
    //   72: aload 4
    //   74: invokevirtual 61	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   77: areturn
    //   78: iinc 2 1
    //   81: goto -72 -> 9
    //   84: ldc 63
    //   86: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   32	38	41	java/lang/Throwable
  }

  private static void a(Context paramContext)
  {
    bf.a().a(paramContext);
  }

  private static void a(Context paramContext, ExtraInfo paramExtraInfo)
  {
    try
    {
      boolean bool = a(paramContext, "onPause(...)");
      if (!bool)
        return;
      if (!a(Activity.class, "onPause"))
        throw new SecurityException("onPause(Context context)不在Activity.onPause()中被调用||onPause(Context context)is not called in Activity.onPause().");
      ch.a().a(paramContext, System.currentTimeMillis(), false, paramExtraInfo);
      return;
    }
    finally
    {
    }
  }

  private static void a(Context paramContext, String paramString, ExtraInfo paramExtraInfo)
  {
    if ((paramContext != null) && (paramString != null));
    try
    {
      if (!paramString.equals(""))
      {
        String str = a(false);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pageName is:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("; activityName is:");
        localStringBuilder.append(str);
        cz.a(localStringBuilder.toString());
        ch.a().a(paramContext, System.currentTimeMillis(), str, paramString, paramExtraInfo);
        return;
      }
      cz.c("onPageEnd :parame=null || empty");
      return;
    }
    finally
    {
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, ExtraInfo paramExtraInfo)
  {
    if (!a(paramContext, "onEvent(...)"))
      return;
    if (paramString1 != null)
    {
      if (paramString1.equals(""))
        return;
      a(paramContext);
      bv.a().a(paramContext);
      bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, paramInt, System.currentTimeMillis(), paramExtraInfo);
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo)
  {
    if (!a(paramContext, "onEventDuration(...)"))
      return;
    if (paramString1 != null)
    {
      if (paramString1.equals(""))
        return;
      if (paramLong <= 0L)
      {
        cz.b("onEventDuration: duration must be greater than zero");
        return;
      }
      a(paramContext);
      bv.a().a(paramContext);
      bm.a().b(paramContext.getApplicationContext(), paramString1, paramString2, paramLong, paramExtraInfo);
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
    a(paramContext, paramString1, paramString2, 1, paramExtraInfo);
  }

  private static void a(Context paramContext, boolean paramBoolean)
  {
    if (!a(paramContext, "onError(...)"))
      return;
    bt.a().a(paramContext.getApplicationContext(), paramBoolean);
  }

  private static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(":context=null");
      cz.b(localStringBuilder.toString());
      return false;
    }
    return true;
  }

  private static boolean a(Class<?> paramClass, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    boolean bool = false;
    for (int i = 2; i < arrayOfStackTraceElement.length; i++)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (localStackTraceElement.getMethodName().equals(paramString))
        try
        {
          for (Class localClass = Class.forName(localStackTraceElement.getClassName()); (localClass.getSuperclass() != null) && (localClass.getSuperclass() != paramClass); localClass = localClass.getSuperclass());
          bool = true;
        }
        catch (Exception localException)
        {
          cz.a(localException);
        }
    }
    return bool;
  }

  private static void b(Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
    if (!a(paramContext, "onEventEnd(...)"))
      return;
    if (paramString1 != null)
    {
      if (paramString1.equals(""))
        return;
      bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, System.currentTimeMillis(), paramExtraInfo);
    }
  }

  public static void bindJSInterface(Context paramContext, WebView paramWebView)
  {
    bindJSInterface(paramContext, paramWebView, null);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public static void bindJSInterface(Context paramContext, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context can't be null.");
    if (paramWebView == null)
      throw new IllegalArgumentException("webview can't be null.");
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    paramWebView.setWebViewClient(new bi(paramContext, paramWebViewClient));
    a(paramContext);
  }

  public static void enableDeviceMac(Context paramContext, boolean paramBoolean)
  {
    CooperService.a().enableDeviceMac(paramContext, paramBoolean);
    a(paramContext);
  }

  public static String getAppKey(Context paramContext)
  {
    return PrefOperate.getAppKey(paramContext);
  }

  public static String getSdkVersion()
  {
    return CooperService.a().getMTJSDKVersion();
  }

  public static void onErised(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (bv.a().b())
      return;
    if (!a(paramContext, "onErised(...)"))
      return;
    if ((paramString1 != null) && (!"".equals(paramString1)))
    {
      bv.a().a(paramContext, false);
      long l = System.currentTimeMillis();
      bm.a().a(paramContext, paramString2, paramString3, 1, l, 0L, null);
      DataCore.instance().saveLogDataToSend(paramContext);
      if ((l - b > 30000L) && (dc.n(paramContext)))
      {
        by.a().a(paramContext);
        b = l;
      }
      return;
    }
    cz.c("AppKey is invalid");
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, null);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramInt, null);
  }

  public static void onEventDuration(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    a(paramContext, paramString1, paramString2, paramLong, null);
  }

  public static void onEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2, null);
  }

  public static void onEventStart(Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramContext, "onEventStart(...)"))
      return;
    if (paramString1 != null)
    {
      if (paramString1.equals(""))
        return;
      a(paramContext);
      bv.a().a(paramContext);
      bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, System.currentTimeMillis());
    }
  }

  public static void onPageEnd(Context paramContext, String paramString)
  {
    try
    {
      a(paramContext, paramString, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void onPageStart(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null));
    try
    {
      if (!paramString.equals(""))
      {
        a(paramContext);
        bv.a().a(paramContext);
        ch.a().a(paramContext, System.currentTimeMillis(), paramString);
        return;
      }
      cz.c("onPageStart :parame=null || empty");
      return;
    }
    finally
    {
    }
  }

  @Deprecated
  @TargetApi(11)
  public static void onPause(Fragment paramFragment)
  {
    if (paramFragment == null)
      try
      {
        cz.c("android.app.Fragment onResume :parame=null");
        return;
      }
      finally
      {
        break label58;
      }
    if (!a(paramFragment.getClass(), "onPause"))
      throw new SecurityException("android.app.Fragment onPause(Context context)不在android.app.Fragment.onPause()中被调用||onPause(Context context)is not called in android.app.Fragment.onPause().");
    ch.a().b(paramFragment, System.currentTimeMillis());
    return;
    label58: throw localObject;
  }

  public static void onPause(Context paramContext)
  {
    try
    {
      a(paramContext, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Deprecated
  public static void onPause(a parama)
  {
    if (parama == null)
      try
      {
        cz.c("onResume :parame=null");
        return;
      }
      finally
      {
        break label57;
      }
    if (!a(a.class, "onPause"))
      throw new SecurityException("Fragment onPause(Context context)不在Fragment.onPause()中被调用||onPause(Context context)is not called in Fragment.onPause().");
    ch.a().b(parama, System.currentTimeMillis());
    return;
    label57: throw localObject;
  }

  @Deprecated
  @TargetApi(11)
  public static void onResume(Fragment paramFragment)
  {
    if (paramFragment == null)
      try
      {
        cz.c("onResume :parame=null");
        return;
      }
      finally
      {
        break label89;
      }
    if (!a(paramFragment.getClass(), "onResume"))
      throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
    Context localContext = ch.a(paramFragment);
    if (localContext == null)
    {
      cz.c("can not get correct context, fragment may not attached to activity");
      return;
    }
    a(localContext);
    bv.a().a(localContext);
    ch.a().a(paramFragment, System.currentTimeMillis());
    return;
    label89: throw localObject;
  }

  public static void onResume(Context paramContext)
  {
    try
    {
      boolean bool = a(paramContext, "onResume(...)");
      if (!bool)
        return;
      if (!a(Activity.class, "onResume"))
        throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
      a(paramContext);
      bv.a().a(paramContext);
      ch.a().a(paramContext, System.currentTimeMillis(), false);
      return;
    }
    finally
    {
    }
  }

  @Deprecated
  public static void onResume(a parama)
  {
    if (parama == null)
      try
      {
        cz.c("onResume :parame=null");
        return;
      }
      finally
      {
        break label88;
      }
    if (!a(a.class, "onResume"))
      throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
    FragmentActivity localFragmentActivity = parama.getActivity();
    if (localFragmentActivity == null)
    {
      cz.c("can not get correct fragmentActivity, fragment may not attached to activity");
      return;
    }
    a(localFragmentActivity);
    bv.a().a(localFragmentActivity);
    ch.a().a(parama, System.currentTimeMillis());
    return;
    label88: throw localObject;
  }

  public static void setAppChannel(Context paramContext, String paramString, boolean paramBoolean)
  {
    PrefOperate.setAppChannel(paramContext, paramString, paramBoolean);
    a(paramContext);
  }

  @Deprecated
  public static void setAppChannel(String paramString)
  {
    PrefOperate.setAppChannel(paramString);
  }

  public static void setAppKey(String paramString)
  {
    PrefOperate.setAppKey(paramString);
  }

  public static void setDebugOn(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
      i = 2;
    else
      i = 7;
    cz.a = i;
  }

  public static void setForTv(Context paramContext, boolean paramBoolean)
  {
    bj.a().c(paramContext, paramBoolean);
    a(paramContext);
  }

  public static void setLogSenderDelayed(int paramInt)
  {
    by.a().a(paramInt);
  }

  public static void setOn(Context paramContext, int paramInt)
  {
    if (!a(paramContext, "setOn(...)"))
      return;
    if (a)
      return;
    a = true;
    if ((paramInt & 0x1) != 0)
      a(paramContext, false);
    else if ((paramInt & 0x10) != 0)
      a(paramContext, true);
    a(paramContext);
  }

  @Deprecated
  public static void setSendLogStrategy(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt)
  {
    setSendLogStrategy(paramContext, paramSendStrategyEnum, paramInt, false);
  }

  @Deprecated
  public static void setSendLogStrategy(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt, boolean paramBoolean)
  {
    if (!a(paramContext, "setSendLogStrategy(...)"))
      return;
    a(paramContext);
    bv.a().a(paramContext);
    by.a().a(paramContext.getApplicationContext(), paramSendStrategyEnum, paramInt, paramBoolean);
  }

  public static void setSessionTimeOut(int paramInt)
  {
    if (paramInt <= 0)
    {
      cz.b("SessionTimeOut is between 1 and 600. Default value[30] is used");
      return;
    }
    if (paramInt <= 600)
    {
      ch.a().a(paramInt);
      return;
    }
    cz.b("SessionTimeOut is between 1 and 600. Value[600] is used");
    ch.a().a(600);
  }

  public static void start(Context paramContext)
  {
    if (!a(paramContext, "start(...)"))
      return;
    a(paramContext);
    bv.a().a(paramContext);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.StatService
 * JD-Core Version:    0.6.2
 */