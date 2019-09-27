package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class az
{
  private static az a;
  private Context b;
  private JSONObject c = new JSONObject();
  private long d = 24L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 5L;
  private long i = 24L;
  private long j = 15L;
  private long k = 15L;
  private long l = 30L;
  private long m = 12L;
  private long n = 1L;
  private long o = 24L;
  private String p = "";
  private String q = "";

  private az(Context paramContext)
  {
    this.b = paramContext;
    m();
    j();
    k();
  }

  public static az a(Context paramContext)
  {
    if (a == null)
      try
      {
        if (a == null)
          a = new az(paramContext);
      }
      finally
      {
      }
    return a;
  }

  private long b(long paramLong)
  {
    if (paramLong - System.currentTimeMillis() > 0L)
      paramLong = 0L;
    return paramLong;
  }

  private void m()
  {
    String str = cs.b("backups/system/.timestamp");
    try
    {
      if (!TextUtils.isEmpty(str))
        this.c = new JSONObject(str);
    }
    catch (Exception localException)
    {
    }
  }

  public long a(u paramu)
  {
    long l1 = paramu.j;
    try
    {
      String str = paramu.toString();
      if (this.c.has(str))
      {
        long l2 = this.c.getLong(str);
        l1 = l2;
      }
    }
    catch (Exception localException)
    {
      bd.a(localException);
    }
    return b(l1);
  }

  public void a(u paramu, long paramLong)
  {
    paramu.j = paramLong;
    try
    {
      this.c.put(paramu.toString(), paramLong);
    }
    catch (Exception localException1)
    {
      bd.a(localException1);
    }
    try
    {
      cs.a("backups/system/.timestamp", this.c.toString(), false);
      return;
    }
    catch (Exception localException2)
    {
      bd.a(localException2);
    }
  }

  public void a(String paramString)
  {
    cs.a(this.b, ".config2", paramString, false);
    j();
  }

  public boolean a()
  {
    return this.e != 0L;
  }

  public boolean a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    return localSimpleDateFormat.format(Long.valueOf(paramLong)).equals(localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
  }

  public void b(String paramString)
  {
    cs.a(this.b, ".sign", paramString, false);
    k();
  }

  public boolean b()
  {
    return this.f != 0L;
  }

  public long c()
  {
    return 1000L * (60L * (60L * this.d));
  }

  public String c(String paramString)
  {
    if ((!TextUtils.isEmpty(this.p)) && (this.p.equals(paramString)) && (!TextUtils.isEmpty(this.q)))
      return this.q;
    return "";
  }

  public long d()
  {
    return 1000L * (60L * (60L * this.o));
  }

  public long e()
  {
    return 1000L * (60L * this.h);
  }

  public long f()
  {
    return 1000L * (60L * (60L * this.i));
  }

  public long g()
  {
    return 1000L * (60L * (60L * (24L * this.j)));
  }

  public long h()
  {
    return 1000L * (60L * (60L * (24L * this.k)));
  }

  public long i()
  {
    return 1000L * (60L * (60L * this.m));
  }

  public void j()
  {
    String str1 = cs.a(this.b, ".config2");
    try
    {
      String str2 = new String(da.b(false, cu.a(), ct.a(str1.getBytes())));
      if (TextUtils.isEmpty(str2))
        return;
      JSONObject localJSONObject = new JSONObject(str2);
      try
      {
        this.e = localJSONObject.getLong("c");
      }
      catch (JSONException localJSONException1)
      {
        bd.b(localJSONException1);
      }
      try
      {
        this.h = localJSONObject.getLong("d");
      }
      catch (JSONException localJSONException2)
      {
        bd.b(localJSONException2);
      }
      try
      {
        this.i = localJSONObject.getLong("e");
      }
      catch (JSONException localJSONException3)
      {
        bd.b(localJSONException3);
      }
      try
      {
        this.j = localJSONObject.getLong("i");
      }
      catch (JSONException localJSONException4)
      {
        bd.b(localJSONException4);
      }
      try
      {
        this.d = localJSONObject.getLong("f");
      }
      catch (JSONException localJSONException5)
      {
        bd.b(localJSONException5);
      }
      try
      {
        this.o = localJSONObject.getLong("s");
      }
      catch (JSONException localJSONException6)
      {
        bd.b(localJSONException6);
      }
      try
      {
        this.k = localJSONObject.getLong("pk");
      }
      catch (JSONException localJSONException7)
      {
        bd.b(localJSONException7);
      }
      try
      {
        this.l = localJSONObject.getLong("at");
      }
      catch (JSONException localJSONException8)
      {
        bd.b(localJSONException8);
      }
      try
      {
        this.m = localJSONObject.getLong("as");
      }
      catch (JSONException localJSONException9)
      {
        bd.b(localJSONException9);
      }
      try
      {
        this.n = localJSONObject.getLong("ac");
      }
      catch (JSONException localJSONException10)
      {
        bd.b(localJSONException10);
      }
      try
      {
        this.f = localJSONObject.getLong("mc");
      }
      catch (JSONException localJSONException11)
      {
        bd.b(localJSONException11);
      }
      try
      {
        this.g = localJSONObject.getLong("lsc");
        return;
      }
      catch (JSONException localJSONException12)
      {
        bd.b(localJSONException12);
        return;
      }
    }
    catch (Exception localException)
    {
      bd.b(localException);
    }
  }

  public void k()
  {
    String str1 = cs.a(this.b, ".sign");
    try
    {
      String str2 = new String(da.b(false, cu.a(), ct.a(str1.getBytes())));
      if (TextUtils.isEmpty(str2))
        return;
      JSONObject localJSONObject = new JSONObject(str2);
      try
      {
        this.q = localJSONObject.getString("sign");
      }
      catch (Exception localException2)
      {
        bd.b(localException2);
      }
      try
      {
        this.p = localJSONObject.getString("ver");
        return;
      }
      catch (Exception localException3)
      {
        bd.b(localException3);
        return;
      }
    }
    catch (Exception localException1)
    {
      bd.b(localException1);
    }
  }

  public boolean l()
  {
    long l1 = System.currentTimeMillis();
    long l2 = a(u.h);
    long l3 = d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canSend now=");
    localStringBuilder.append(l1);
    localStringBuilder.append(";lastSendTime=");
    localStringBuilder.append(l2);
    localStringBuilder.append(";sendLogTimeInterval=");
    localStringBuilder.append(l3);
    bd.a(localStringBuilder.toString());
    return (l1 - l2 > l3) || (!a(l2));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.az
 * JD-Core Version:    0.6.2
 */