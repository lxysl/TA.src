package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtraInfo
{
  String a = "";
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  String h = "";
  String i = "";
  String j = "";

  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    if (a(paramString, 1024))
      paramString = "";
    return paramString;
  }

  // ERROR //
  private static boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 59	java/lang/String:getBytes	()[B
    //   10: arraylength
    //   11: istore_2
    //   12: goto +5 -> 17
    //   15: iconst_0
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_2
    //   20: iload_1
    //   21: if_icmple +5 -> 26
    //   24: iconst_1
    //   25: istore_3
    //   26: iload_3
    //   27: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   6	12	15	java/lang/Exception
  }

  public JSONObject dumpToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.a))
        localJSONObject.put("v1", this.a);
      if (!TextUtils.isEmpty(this.b))
        localJSONObject.put("v2", this.b);
      if (!TextUtils.isEmpty(this.c))
        localJSONObject.put("v3", this.c);
      if (!TextUtils.isEmpty(this.d))
        localJSONObject.put("v4", this.d);
      if (!TextUtils.isEmpty(this.e))
        localJSONObject.put("v5", this.e);
      if (!TextUtils.isEmpty(this.f))
        localJSONObject.put("v6", this.f);
      if (!TextUtils.isEmpty(this.g))
        localJSONObject.put("v7", this.g);
      if (!TextUtils.isEmpty(this.h))
        localJSONObject.put("v8", this.h);
      if (!TextUtils.isEmpty(this.i))
        localJSONObject.put("v9", this.i);
      if (!TextUtils.isEmpty(this.j))
      {
        localJSONObject.put("v10", this.j);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      cz.c(localJSONException);
    }
    return localJSONObject;
  }

  public String getV1()
  {
    return this.a;
  }

  public String getV10()
  {
    return this.j;
  }

  public String getV2()
  {
    return this.b;
  }

  public String getV3()
  {
    return this.c;
  }

  public String getV4()
  {
    return this.d;
  }

  public String getV5()
  {
    return this.e;
  }

  public String getV6()
  {
    return this.f;
  }

  public String getV7()
  {
    return this.g;
  }

  public String getV8()
  {
    return this.h;
  }

  public String getV9()
  {
    return this.i;
  }

  public void setV1(String paramString)
  {
    this.a = a(paramString);
  }

  public void setV10(String paramString)
  {
    this.j = a(paramString);
  }

  public void setV2(String paramString)
  {
    this.b = a(paramString);
  }

  public void setV3(String paramString)
  {
    this.c = a(paramString);
  }

  public void setV4(String paramString)
  {
    this.d = a(paramString);
  }

  public void setV5(String paramString)
  {
    this.e = a(paramString);
  }

  public void setV6(String paramString)
  {
    this.f = a(paramString);
  }

  public void setV7(String paramString)
  {
    this.g = a(paramString);
  }

  public void setV8(String paramString)
  {
    this.h = a(paramString);
  }

  public void setV9(String paramString)
  {
    this.i = a(paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ExtraInfo
 * JD-Core Version:    0.6.2
 */