package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class q
{
  static q a = new q();

  public void a(Context paramContext, String paramString1, String paramString2)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str1;
    if (!"android.intent.action.PACKAGE_REMOVED".equals(paramString1))
      try
      {
        str1 = localPackageManager.getPackageInfo(paramString2, 8192).versionName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        bd.a(localNameNotFoundException);
      }
    else
      str1 = "unkown";
    String str2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("n", paramString2);
      localJSONObject1.put("a", paramString1);
      localJSONObject1.put("v", str1);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("app_change", localJSONArray);
      localJSONObject2.put("meta-data", localStringBuilder.toString());
      str2 = cq.a(localJSONObject2.toString().getBytes());
    }
    catch (Exception localException)
    {
      bd.b(localException.getMessage());
      str2 = "";
    }
    if (!TextUtils.isEmpty(str2))
    {
      long l = System.currentTimeMillis();
      y.d.a(l, str2);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.q
 * JD-Core Version:    0.6.2
 */