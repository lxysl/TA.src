package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;

class p
{
  private String a;
  private String b;
  private String c;
  private String d;

  public p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    if (paramString3 == null)
      paramString3 = "";
    if (paramString4 == null)
      paramString4 = "";
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", this.a);
      localJSONObject.put("v", this.b);
      localJSONObject.put("c", this.c);
      localJSONObject.put("a", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      bd.b(localJSONException);
    }
    return null;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.p
 * JD-Core Version:    0.6.2
 */