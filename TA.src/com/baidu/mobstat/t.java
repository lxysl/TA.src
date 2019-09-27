package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;

class t
{
  private String a;
  private String b;
  private String c;

  public t(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
      paramString1 = "";
    this.a = paramString1;
    if (paramString2 == null)
      paramString2 = "";
    this.b = paramString2;
    if (paramString3 == null)
      paramString3 = "";
    this.c = paramString3;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", this.a);
      localJSONObject.put("v", this.b);
      localJSONObject.put("w", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      bd.b(localJSONException);
    }
    return null;
  }

  public String b()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.t
 * JD-Core Version:    0.6.2
 */