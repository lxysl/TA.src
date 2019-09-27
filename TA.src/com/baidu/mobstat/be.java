package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;

public class be
{
  public boolean a = false;
  public String b = "";
  public boolean c = false;

  public be()
  {
  }

  public be(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getBoolean("SDK_BPLUS_SERVICE");
    }
    catch (Exception localException1)
    {
      bd.b(localException1);
    }
    try
    {
      this.b = paramJSONObject.getString("SDK_PRODUCT_LY");
    }
    catch (Exception localException2)
    {
      bd.b(localException2);
    }
    try
    {
      this.c = paramJSONObject.getBoolean("SDK_LOCAL_SERVER");
      return;
    }
    catch (Exception localException3)
    {
      bd.b(localException3);
    }
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("SDK_BPLUS_SERVICE", this.a);
    }
    catch (JSONException localJSONException1)
    {
      bd.b(localJSONException1);
    }
    try
    {
      localJSONObject.put("SDK_PRODUCT_LY", this.b);
    }
    catch (JSONException localJSONException2)
    {
      bd.b(localJSONException2);
    }
    try
    {
      localJSONObject.put("SDK_LOCAL_SERVER", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException3)
    {
      bd.b(localJSONException3);
    }
    return localJSONObject;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.be
 * JD-Core Version:    0.6.2
 */