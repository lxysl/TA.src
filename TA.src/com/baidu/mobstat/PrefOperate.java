package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;

public class PrefOperate
{
  public static String getAppKey(Context paramContext)
  {
    return CooperService.a().getAppKey(paramContext);
  }

  public static void loadMetaDataConfig(Context paramContext)
  {
    Object localObject1 = SendStrategyEnum.APP_START;
    try
    {
      String str4 = dc.a(paramContext, "BaiduMobAd_EXCEPTION_LOG");
      if ((!TextUtils.isEmpty(str4)) && ("true".equals(str4)))
        bt.a().a(paramContext, false);
    }
    catch (Exception localException1)
    {
      cz.a(localException1);
    }
    try
    {
      String str3 = dc.a(paramContext, "BaiduMobAd_SEND_STRATEGY");
      if (!TextUtils.isEmpty(str3))
      {
        if (str3.equals(SendStrategyEnum.APP_START.name()))
          localObject2 = SendStrategyEnum.APP_START;
        while (true)
        {
          try
          {
            localbj = bj.a();
            j = ((SendStrategyEnum)localObject2).ordinal();
            localbj.a(paramContext, j);
          }
          catch (Exception localException6)
          {
            Object localObject3 = localObject2;
            Exception localException2 = localException6;
            localObject1 = localObject3;
            break label206;
          }
          if (str3.equals(SendStrategyEnum.ONCE_A_DAY.name()))
          {
            localObject2 = SendStrategyEnum.ONCE_A_DAY;
            bj.a().a(paramContext, ((SendStrategyEnum)localObject2).ordinal());
            bj.a().b(paramContext, 24);
            break label199;
          }
          if (!str3.equals(SendStrategyEnum.SET_TIME_INTERVAL.name()))
            break;
          localObject2 = SendStrategyEnum.SET_TIME_INTERVAL;
          bj localbj = bj.a();
          int j = ((SendStrategyEnum)localObject2).ordinal();
        }
      }
      Object localObject2 = localObject1;
      label199: localObject1 = localObject2;
    }
    catch (Exception localException3)
    {
      label206: cz.a(localException3);
    }
    try
    {
      String str2 = dc.a(paramContext, "BaiduMobAd_TIME_INTERVAL");
      if (!TextUtils.isEmpty(str2))
      {
        int i = Integer.parseInt(str2);
        if ((((SendStrategyEnum)localObject1).ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal()) && (i > 0) && (i <= 24))
          bj.a().b(paramContext, i);
      }
    }
    catch (Exception localException4)
    {
      cz.a(localException4);
    }
    try
    {
      String str1 = dc.a(paramContext, "BaiduMobAd_ONLY_WIFI");
      if (!TextUtils.isEmpty(str1))
      {
        if ("true".equals(str1))
        {
          bj.a().a(paramContext, true);
          return;
        }
        if ("false".equals(str1))
        {
          bj.a().a(paramContext, false);
          return;
        }
      }
    }
    catch (Exception localException5)
    {
      cz.a(localException5);
    }
  }

  public static void setAppChannel(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.equals("")))
      cz.c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
    CooperService.a().getHeadObject().m = paramString;
    if ((paramBoolean) && (paramString != null) && (!paramString.equals("")))
    {
      bj.a().c(paramContext, paramString);
      bj.a().b(paramContext, true);
    }
    if (!paramBoolean)
    {
      bj.a().c(paramContext, "");
      bj.a().b(paramContext, false);
    }
  }

  public static void setAppChannel(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
      cz.c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
    CooperService.a().getHeadObject().m = paramString;
  }

  public static void setAppKey(String paramString)
  {
    CooperService.a().getHeadObject().f = paramString;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.PrefOperate
 * JD-Core Version:    0.6.2
 */