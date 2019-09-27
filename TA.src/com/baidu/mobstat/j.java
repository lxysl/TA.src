package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class j
{
  public String a;
  public String b;
  public int c = 2;

  public static j a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str1 = localJSONObject.getString("deviceid");
      String str2 = localJSONObject.getString("imei");
      int i = localJSONObject.getInt("ver");
      if ((!TextUtils.isEmpty(str1)) && (str2 != null))
      {
        j localj = new j();
        localj.a = str1;
        localj.b = str2;
        localj.c = i;
        return localj;
      }
    }
    catch (JSONException localJSONException)
    {
      g.a(localJSONException);
    }
    return null;
  }

  public String a()
  {
    try
    {
      String str = new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      g.a(localJSONException);
    }
    return null;
  }

  public String b()
  {
    String str1 = this.b;
    if (TextUtils.isEmpty(str1))
      str1 = "0";
    String str2 = new StringBuffer(str1).reverse().toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.j
 * JD-Core Version:    0.6.2
 */