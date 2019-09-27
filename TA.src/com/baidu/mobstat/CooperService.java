package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService extends bk
  implements ICooperService
{
  private static CooperService a;
  private bu b = new bu();

  static CooperService a()
  {
    try
    {
      if (a == null)
        a = new CooperService();
      CooperService localCooperService = a;
      return localCooperService;
    }
    finally
    {
    }
  }

  private static String a(Context paramContext)
  {
    String str = dc.j(paramContext);
    if (!TextUtils.isEmpty(str))
      str = str.replaceAll(":", "");
    return str;
  }

  private String a(Context paramContext, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
      str = b(paramContext);
    else
      str = a(paramContext);
    if (TextUtils.isEmpty(str))
      str = "";
    return str;
  }

  private static String b(Context paramContext)
  {
    String str = dc.i(paramContext);
    if (!TextUtils.isEmpty(str))
      str = str.replaceAll(":", "");
    return str;
  }

  private static String c(Context paramContext)
  {
    String str = dc.k(paramContext);
    if (!TextUtils.isEmpty(str))
      str = str.replaceAll(":", "");
    return str;
  }

  private String d(Context paramContext)
  {
    try
    {
      if ((this.b.m == null) || (this.b.m.equals("")))
      {
        boolean bool = bj.a().g(paramContext);
        if (bool)
          this.b.m = bj.a().f(paramContext);
        if ((!bool) || (this.b.m == null) || (this.b.m.equals("")))
          this.b.m = dc.a(paramContext, "BaiduMobAd_CHANNEL");
      }
    }
    catch (Exception localException)
    {
      cz.a(localException);
    }
    return this.b.m;
  }

  public boolean checkCellLocationSetting(Context paramContext)
  {
    return "true".equalsIgnoreCase(dc.a(paramContext, "BaiduMobAd_CELL_LOCATION"));
  }

  public boolean checkGPSLocationSetting(Context paramContext)
  {
    return "true".equals(dc.a(paramContext, "BaiduMobAd_GPS_LOCATION"));
  }

  public boolean checkWifiLocationSetting(Context paramContext)
  {
    return "true".equalsIgnoreCase(dc.a(paramContext, "BaiduMobAd_WIFI_LOCATION"));
  }

  public void enableDeviceMac(Context paramContext, boolean paramBoolean)
  {
    bj.a().d(paramContext, paramBoolean);
  }

  public String getAppChannel(Context paramContext)
  {
    return d(paramContext);
  }

  public String getAppKey(Context paramContext)
  {
    if (this.b.f == null)
      this.b.f = dc.a(paramContext, "BaiduMobAd_STAT_ID");
    return this.b.f;
  }

  public int getAppVersionCode(Context paramContext)
  {
    if (this.b.h == -1)
      this.b.h = dc.e(paramContext);
    return this.b.h;
  }

  public String getAppVersionName(Context paramContext)
  {
    if (TextUtils.isEmpty(this.b.i))
      this.b.i = dc.f(paramContext);
    return this.b.i;
  }

  public String getCUID(Context paramContext, boolean paramBoolean)
  {
    if (this.b.g == null)
    {
      this.b.g = bj.a().e(paramContext);
      if ((this.b.g == null) || ("".equalsIgnoreCase(this.b.g)))
        try
        {
          this.b.g = de.a(paramContext);
          Matcher localMatcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.g);
          this.b.g = localMatcher.replaceAll("");
          this.b.g = getSecretValue(this.b.g);
          bj.a().b(paramContext, this.b.g);
        }
        catch (Exception localException2)
        {
          cz.c(localException2.getMessage());
        }
    }
    if (paramBoolean)
      return this.b.g;
    try
    {
      String str1 = this.b.g;
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = new String(cr.b(1, ct.a(str1.getBytes())));
        return str2;
      }
    }
    catch (Exception localException1)
    {
      cz.a(localException1);
    }
    return null;
  }

  public String getDeviceId(TelephonyManager paramTelephonyManager, Context paramContext)
  {
    Object localObject1 = this.b.j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
      return this.b.j;
    bu localbu;
    if (bj.a().i(paramContext))
      localbu = this.b;
    for (String str2 = getMacIdForTv(paramContext); ; str2 = getSecretValue(this.b.j))
    {
      localbu.j = str2;
      break;
      if (paramTelephonyManager == null)
        break;
      Pattern localPattern = Pattern.compile("\\s*|\t|\r|\n");
      try
      {
        String str3 = paramTelephonyManager.getDeviceId();
        if (str3 != null)
        {
          String str4 = localPattern.matcher(str3).replaceAll("");
          localObject1 = str4;
        }
      }
      catch (Exception localException1)
      {
        cz.a(localException1);
      }
      if ((localObject1 == null) || (((String)localObject1).equals("000000000000000")))
        localObject1 = a(paramContext);
      Object localObject2;
      if ((dc.s(paramContext)) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("000000000000000"))))
        try
        {
          localObject2 = c(paramContext);
        }
        catch (Exception localException2)
        {
          cz.a(localException2);
        }
      else
        localObject2 = localObject1;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("000000000000000")))
        localObject2 = bj.a().d(paramContext);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("000000000000000")))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(new Date().getTime());
        localStringBuilder1.append("");
        String str1 = localStringBuilder1.toString();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("hol");
        localStringBuilder2.append(str1.hashCode());
        localStringBuilder2.append("mes");
        localObject2 = localStringBuilder2.toString();
        bj.a().a(paramContext, (String)localObject2);
      }
      this.b.j = ((String)localObject2);
      localbu = this.b;
    }
  }

  public bu getHeadObject()
  {
    return this.b;
  }

  public JSONObject getHeaderExt(Context paramContext)
  {
    String str = bj.a().k(paramContext);
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(str));
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      localObject = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localObject;
  }

  public String getHost()
  {
    return Config.LOG_SEND_URL;
  }

  public String getLinkedWay(Context paramContext)
  {
    if (TextUtils.isEmpty(this.b.s))
      this.b.s = dc.o(paramContext);
    return this.b.s;
  }

  public String getMTJSDKVersion()
  {
    return "3.7.5.5";
  }

  public String getMacAddress(Context paramContext, boolean paramBoolean)
  {
    String str1 = "02:00:00:00:00:00".replace(":", "");
    if ((!paramBoolean) && (Build.VERSION.SDK_INT >= 23))
      return getSecretValue(str1);
    if (!TextUtils.isEmpty(this.b.t));
    while (true)
    {
      return this.b.t;
      String str2 = bj.a().h(paramContext);
      if (!TextUtils.isEmpty(str2))
      {
        this.b.t = str2;
      }
      else
      {
        String str3 = a(paramContext, paramBoolean);
        if ((!TextUtils.isEmpty(str3)) && (!str1.equals(str3)))
        {
          String str4 = getSecretValue(str3);
          this.b.t = str4;
          bj.a().d(paramContext, this.b.t);
        }
        else
        {
          this.b.t = "";
        }
      }
    }
  }

  public String getMacIdForTv(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.b.u))
      return this.b.u;
    String str1 = bj.a().j(paramContext);
    bu localbu;
    if (!TextUtils.isEmpty(str1))
      localbu = this.b;
    while (true)
    {
      localbu.u = str1;
      break;
      String str2 = dc.c(1, paramContext);
      if (!TextUtils.isEmpty(str2))
      {
        this.b.u = str2;
        bj.a().e(paramContext, str2);
        break;
      }
      localbu = this.b;
      str1 = "";
    }
  }

  public String getManufacturer()
  {
    if (TextUtils.isEmpty(this.b.p))
      this.b.p = Build.MANUFACTURER;
    return this.b.p;
  }

  public String getOSSysVersion()
  {
    if (TextUtils.isEmpty(this.b.d))
      this.b.d = Build.VERSION.RELEASE;
    return this.b.d;
  }

  public String getOSVersion()
  {
    if (TextUtils.isEmpty(this.b.c))
      this.b.c = Integer.toString(Build.VERSION.SDK_INT);
    return this.b.c;
  }

  public String getOperator(TelephonyManager paramTelephonyManager)
  {
    if (TextUtils.isEmpty(this.b.n))
      this.b.n = paramTelephonyManager.getNetworkOperator();
    return this.b.n;
  }

  public String getPhoneModel()
  {
    if (TextUtils.isEmpty(this.b.o))
      this.b.o = Build.MODEL;
    return this.b.o;
  }

  public String getSecretValue(String paramString)
  {
    return cr.c(1, paramString.getBytes());
  }

  public int getTagValue()
  {
    return 1;
  }

  public String getUUID()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public void installHeader(Context paramContext, JSONObject paramJSONObject)
  {
    this.b.a(paramContext, paramJSONObject);
  }

  public boolean isDeviceMacEnabled(Context paramContext)
  {
    return bj.a().l(paramContext);
  }

  public void resetHeadSign()
  {
    this.b.x = a().getUUID();
  }

  public void setHeadSqCounted(boolean paramBoolean)
  {
    bu localbu;
    if (paramBoolean)
      localbu = this.b;
    for (int i = 0; ; i = 1 + localbu.z)
    {
      localbu.z = i;
      return;
      localbu = this.b;
    }
  }

  public void setHeaderExt(Context paramContext, ExtraInfo paramExtraInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramExtraInfo != null)
      localJSONObject = paramExtraInfo.dumpToJson();
    this.b.a(localJSONObject);
    bj.a().f(paramContext, localJSONObject.toString());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.CooperService
 * JD-Core Version:    0.6.2
 */