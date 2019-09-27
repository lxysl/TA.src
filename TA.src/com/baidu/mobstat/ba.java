package com.baidu.mobstat;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ba
{
  public static final ba a = new ba();

  private void a(JSONObject paramJSONObject)
  {
    be localbe = new be(paramJSONObject);
    bc.b = localbe.a;
    bc.c = localbe.b;
    bc.d = localbe.c;
  }

  private boolean a()
  {
    if (!y.a.b())
      return true;
    if (!y.b.b())
      return true;
    if (!y.c.b())
      return true;
    if (!y.d.b())
      return true;
    return !y.e.b();
  }

  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int i = 0;
    try
    {
      localJSONObject1.put("he", paramJSONObject);
      int i4 = paramJSONObject.toString().length();
      i = 0 + i4;
    }
    catch (JSONException localJSONException1)
    {
      bd.a(localJSONException1);
    }
    bd.a("APP_MEM");
    if (!az.a(paramContext).b())
    {
      String str6 = dc.t(paramContext);
      JSONArray localJSONArray7 = new JSONArray();
      bd.a(str6);
      localJSONArray7.put(str6);
      if (localJSONArray7.length() > 0)
        try
        {
          localJSONObject1.put("app_mem3", localJSONArray7);
          int i3 = localJSONArray7.toString().length();
          i += i3;
        }
        catch (JSONException localJSONException7)
        {
          bd.a(localJSONException7);
        }
    }
    bd.a("APP_APK");
    List localList1 = y.e.a(20480);
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      String str5 = (String)localIterator1.next();
      bd.a(str5);
      localJSONArray1.put(str5);
    }
    if (localJSONArray1.length() > 0)
      try
      {
        localJSONObject1.put("app_apk3", localJSONArray1);
        int i2 = localJSONArray1.toString().length();
        i += i2;
      }
      catch (JSONException localJSONException6)
      {
        bd.a(localJSONException6);
      }
    bd.a("APP_CHANGE");
    List localList2 = y.d.a(10240);
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator2 = localList2.iterator();
    while (localIterator2.hasNext())
    {
      String str4 = (String)localIterator2.next();
      bd.a(str4);
      localJSONArray2.put(str4);
    }
    if (localJSONArray2.length() > 0)
      try
      {
        localJSONObject1.put("app_change3", localJSONArray2);
        int i1 = localJSONArray2.toString().length();
        i += i1;
      }
      catch (JSONException localJSONException5)
      {
        bd.a(localJSONException5);
      }
    bd.a("APP_TRACE");
    List localList3 = y.c.a(15360);
    JSONArray localJSONArray3 = new JSONArray();
    Iterator localIterator3 = localList3.iterator();
    while (localIterator3.hasNext())
    {
      String str3 = (String)localIterator3.next();
      bd.a(str3);
      localJSONArray3.put(str3);
    }
    if (localJSONArray3.length() > 0)
      try
      {
        localJSONObject1.put("app_trace3", localJSONArray3);
        int n = localJSONArray3.toString().length();
        i += n;
      }
      catch (JSONException localJSONException4)
      {
        bd.a(localJSONException4);
      }
    bd.a("APP_LIST");
    List localList4 = y.b.a(46080);
    JSONArray localJSONArray4 = new JSONArray();
    Iterator localIterator4 = localList4.iterator();
    while (localIterator4.hasNext())
    {
      String str2 = (String)localIterator4.next();
      bd.a(str2);
      localJSONArray4.put(str2);
    }
    if (localJSONArray4.length() > 0)
      try
      {
        localJSONObject1.put("app_list3", localJSONArray4);
        int m = localJSONArray4.toString().length();
        i += m;
      }
      catch (JSONException localJSONException3)
      {
        bd.a(localJSONException3);
      }
    bd.a("AP_LIST");
    int j = 184320 - i;
    List localList5 = y.a.a(j);
    JSONArray localJSONArray5 = new JSONArray();
    Iterator localIterator5 = localList5.iterator();
    while (localIterator5.hasNext())
    {
      String str1 = (String)localIterator5.next();
      bd.a(str1);
      localJSONArray5.put(str1);
    }
    if (localJSONArray5.length() > 0)
      try
      {
        localJSONObject1.put("ap_list3", localJSONArray5);
        int k = localJSONArray5.toString().length();
        i += k;
      }
      catch (JSONException localJSONException2)
      {
        bd.a(localJSONException2);
      }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("log in bytes is almost :");
    localStringBuilder.append(i);
    bd.a(localStringBuilder.toString());
    JSONArray localJSONArray6 = new JSONArray();
    localJSONArray6.put(localJSONObject1);
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("payload", localJSONArray6);
      al.a().a(paramContext, localJSONObject2.toString());
      return;
    }
    catch (Exception localException)
    {
      bd.a(localException);
    }
  }

  private void c(Context paramContext)
  {
    bd.a("collectAPWithStretegy 1");
    az localaz = az.a(paramContext);
    long l1 = localaz.a(u.a);
    long l2 = System.currentTimeMillis();
    long l3 = localaz.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now time: ");
    localStringBuilder.append(l2);
    localStringBuilder.append(": last time: ");
    localStringBuilder.append(l1);
    localStringBuilder.append("; time interval: ");
    localStringBuilder.append(l3);
    bd.a(localStringBuilder.toString());
    if ((l1 == 0L) || (l2 - l1 > l3))
    {
      bd.a("collectAPWithStretegy 2");
      n.a(paramContext);
    }
  }

  private void d(Context paramContext)
  {
    bd.a("collectAPPListWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.b);
    long l3 = localaz.f();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("now time: ");
    localStringBuilder1.append(l1);
    localStringBuilder1.append(": last time: ");
    localStringBuilder1.append(l2);
    localStringBuilder1.append("; userInterval : ");
    localStringBuilder1.append(l3);
    bd.a(localStringBuilder1.toString());
    if ((l2 == 0L) || (l1 - l2 > l3) || (!localaz.a(l2)))
    {
      bd.a("collectUserAPPListWithStretegy 2");
      n.a(paramContext, false);
    }
    long l4 = localaz.a(u.c);
    long l5 = localaz.g();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("now time: ");
    localStringBuilder2.append(l1);
    localStringBuilder2.append(": last time: ");
    localStringBuilder2.append(l4);
    localStringBuilder2.append("; sysInterval : ");
    localStringBuilder2.append(l5);
    bd.a(localStringBuilder2.toString());
    if ((l4 == 0L) || (l1 - l4 > l5))
    {
      bd.a("collectSysAPPListWithStretegy 2");
      n.a(paramContext, true);
    }
  }

  private void e(Context paramContext)
  {
    bd.a("collectAPPTraceWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.e);
    long l3 = localaz.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now time: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(": last time: ");
    localStringBuilder.append(l2);
    localStringBuilder.append("; time interval: ");
    localStringBuilder.append(l3);
    bd.a(localStringBuilder.toString());
    if ((l2 == 0L) || (l1 - l2 > l3))
    {
      bd.a("collectAPPTraceWithStretegy 2");
      n.b(paramContext, false);
    }
  }

  private void f(Context paramContext)
  {
    bd.a("collectAPKWithStretegy 1");
    long l1 = System.currentTimeMillis();
    az localaz = az.a(paramContext);
    long l2 = localaz.a(u.g);
    long l3 = localaz.h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now time: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(": last time: ");
    localStringBuilder.append(l2);
    localStringBuilder.append("; interval : ");
    localStringBuilder.append(l3);
    bd.a(localStringBuilder.toString());
    if ((l2 == 0L) || (l1 - l2 > l3))
    {
      bd.a("collectAPKWithStretegy 2");
      n.b(paramContext);
    }
  }

  private void g(Context paramContext)
  {
    az.a(paramContext).a(u.h, System.currentTimeMillis());
    JSONObject localJSONObject = v.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("header: ");
    localStringBuilder.append(localJSONObject);
    bd.a(localStringBuilder.toString());
    while (a())
      b(paramContext, localJSONObject);
  }

  public void a(Context paramContext, long paramLong)
  {
    az.a(paramContext).a(u.i, paramLong);
  }

  public void a(Context paramContext, String paramString)
  {
    az.a(paramContext).a(paramString);
  }

  public void a(Context paramContext, JSONObject paramJSONObject)
  {
    bd.a("startDataAnynalyzed start");
    a(paramJSONObject);
    az localaz = az.a(paramContext);
    boolean bool1 = localaz.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is data collect closed:");
    localStringBuilder.append(bool1);
    bd.a(localStringBuilder.toString());
    if (!bool1)
    {
      if (!y.a.b(10000))
        c(paramContext);
      if (!y.b.b(10000))
        d(paramContext);
      if (!y.c.b(10000))
        e(paramContext);
      if ((bc.e) && (!y.e.b(10000)))
        f(paramContext);
      boolean bool2 = dc.n(paramContext);
      if ((bool2) && (localaz.l()))
      {
        bd.a("sendLog");
        g(paramContext);
      }
      else
      {
        if (!bool2);
        for (String str = "isWifiAvailable = false, will not sendLog"; ; str = "can not sendLog due to time stratergy")
        {
          bd.a(str);
          break;
        }
      }
    }
    bd.a("startDataAnynalyzed finished");
  }

  public boolean a(Context paramContext)
  {
    az localaz = az.a(paramContext);
    long l1 = localaz.a(u.i);
    long l2 = localaz.c();
    long l3 = System.currentTimeMillis();
    if (l3 - l1 > l2)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("need to update, checkWithLastUpdateTime lastUpdateTime =");
      localStringBuilder1.append(l1);
      localStringBuilder1.append("nowTime=");
      localStringBuilder1.append(l3);
      localStringBuilder1.append(";timeInteveral=");
      localStringBuilder1.append(l2);
      bd.a(localStringBuilder1.toString());
      return true;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("no need to update, checkWithLastUpdateTime lastUpdateTime =");
    localStringBuilder2.append(l1);
    localStringBuilder2.append("nowTime=");
    localStringBuilder2.append(l3);
    localStringBuilder2.append(";timeInteveral=");
    localStringBuilder2.append(l2);
    bd.a(localStringBuilder2.toString());
    return false;
  }

  public void b(Context paramContext, String paramString)
  {
    az.a(paramContext).b(paramString);
  }

  public boolean b(Context paramContext)
  {
    return (!az.a(paramContext).a()) || (a(paramContext));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ba
 * JD-Core Version:    0.6.2
 */