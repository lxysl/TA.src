package com.baidu.mobstat;

import android.content.Context;
import com.a.a.a.a.a.a.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;

class bl
  implements Thread.UncaughtExceptionHandler
{
  private static final bl a = new bl();
  private Thread.UncaughtExceptionHandler b = null;
  private Context c = null;
  private bu d = new bu();

  public static bl a()
  {
    return a;
  }

  public void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    ch.a().b(this.c, System.currentTimeMillis());
    if ((this.c != null) && (paramString1 != null))
    {
      if (paramString1.trim().equals(""))
        return;
      try
      {
        String str1 = CooperService.a().getAppVersionName(this.c);
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("t", paramLong);
        localJSONObject1.put("c", paramString1);
        localJSONObject1.put("y", paramString2);
        localJSONObject1.put("v", str1);
        localJSONObject1.put("ct", paramInt);
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(localJSONObject1);
        JSONObject localJSONObject2 = new JSONObject();
        this.d.a(this.c, localJSONObject2);
        localJSONObject2.put("ss", 0);
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("he", localJSONObject2);
        localJSONObject3.put("pr", new JSONArray());
        localJSONObject3.put("ev", new JSONArray());
        localJSONObject3.put("ex", localJSONArray);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("__send_data_");
        localStringBuilder.append(System.currentTimeMillis());
        String str2 = localStringBuilder.toString();
        cs.a(this.c, str2, localJSONObject3.toString(), false);
        cz.a("Dump exception successlly");
        return;
      }
      catch (Exception localException)
      {
        cz.b(localException);
      }
    }
  }

  public void a(Context paramContext)
  {
    if (this.b == null)
    {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
    }
    if (this.c == null)
      this.c = paramContext.getApplicationContext();
    this.d.a(this.c);
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = paramThrowable.toString();
    String str2 = "";
    if ((str1 != null) && (!str1.equals("")))
      try
      {
        String[] arrayOfString = str1.split(":");
        if (str1.length() > 1)
          str2 = arrayOfString[0];
        else
          str2 = str1;
      }
      catch (Exception localException)
      {
        cz.c(localException);
        str2 = "";
      }
    String str3;
    if ((str2 != null) && (!str2.equals("")))
      str3 = str2;
    else
      str3 = str1;
    StringWriter localStringWriter = new StringWriter();
    a.a(paramThrowable, new PrintWriter(localStringWriter));
    String str4 = localStringWriter.toString();
    cz.a(str4);
    a(System.currentTimeMillis(), str4, str3, 0);
    if (!this.b.equals(this))
      this.b.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bl
 * JD-Core Version:    0.6.2
 */