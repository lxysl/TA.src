package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class cf
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  private volatile long c = 0L;
  private volatile long d = 0L;
  private volatile long e = 0L;
  private volatile int f = 0;
  private volatile int g = 0;
  private List<cg> h = new ArrayList();

  public cf()
  {
    long l = System.currentTimeMillis();
    this.a = l;
    this.e = l;
  }

  public static JSONObject a(cg paramcg, long paramLong)
  {
    JSONObject localJSONObject1 = new JSONObject();
    while (true)
    {
      long l1;
      try
      {
        localJSONObject1.put("n", paramcg.a());
        localJSONObject1.put("d", paramcg.c());
        l1 = paramcg.d() - paramLong;
        l2 = 0L;
        if (l1 >= l2)
          break label122;
        localJSONObject1.put("ps", l2);
        localJSONObject1.put("t", paramcg.b());
        localJSONObject1.put("at", paramcg.f());
        JSONObject localJSONObject2 = paramcg.e();
        if ((localJSONObject2 != null) && (localJSONObject2.length() != 0))
        {
          localJSONObject1.put("ext", localJSONObject2);
          return localJSONObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        cz.b(localJSONException);
      }
      return localJSONObject1;
      label122: long l2 = l1;
    }
  }

  private void a(List<cg> paramList, cg paramcg)
  {
    if (paramList == null)
      return;
    if (paramcg == null)
      return;
    int i = paramList.size();
    if (i == 0)
    {
      paramList.add(paramcg);
      return;
    }
    cg localcg = (cg)paramList.get(i - 1);
    if ((!TextUtils.isEmpty(cg.b(localcg))) && (!TextUtils.isEmpty(cg.b(paramcg))))
    {
      if ((cg.b(localcg).equals(cg.b(paramcg))) && (cg.c(localcg) != cg.c(paramcg)))
      {
        if (cg.c(localcg))
          localcg.a(paramcg);
        return;
      }
      paramList.add(paramcg);
      return;
    }
    paramList.add(paramcg);
  }

  public void a()
  {
    long l = System.currentTimeMillis();
    c(l);
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = l;
    this.f = 0;
    this.g = 0;
    this.g = 0;
    this.h.clear();
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
  }

  public void a(cg paramcg)
  {
    a(this.h, paramcg);
  }

  public long b()
  {
    return this.a;
  }

  public void b(int paramInt)
  {
    this.f = paramInt;
  }

  public void b(long paramLong)
  {
    this.d = paramLong;
  }

  // ERROR //
  public JSONObject c()
  {
    // Byte code:
    //   0: new 50	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 51	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 143
    //   11: aload_0
    //   12: getfield 22	com/baidu/mobstat/cf:a	J
    //   15: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_1
    //   20: ldc 144
    //   22: aload_0
    //   23: getfield 24	com/baidu/mobstat/cf:b	J
    //   26: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_1
    //   31: ldc 146
    //   33: aload_0
    //   34: getfield 30	com/baidu/mobstat/cf:e	J
    //   37: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc 147
    //   44: aload_0
    //   45: getfield 32	com/baidu/mobstat/cf:f	I
    //   48: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_1
    //   53: ldc 149
    //   55: aload_0
    //   56: getfield 26	com/baidu/mobstat/cf:c	J
    //   59: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc 151
    //   66: aload_0
    //   67: getfield 28	com/baidu/mobstat/cf:d	J
    //   70: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_1
    //   75: ldc 153
    //   77: aload_0
    //   78: getfield 34	com/baidu/mobstat/cf:g	I
    //   81: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   84: pop
    //   85: new 155	org/json/JSONArray
    //   88: dup
    //   89: invokespecial 156	org/json/JSONArray:<init>	()V
    //   92: astore 9
    //   94: iconst_0
    //   95: istore 10
    //   97: iload 10
    //   99: aload_0
    //   100: getfield 39	com/baidu/mobstat/cf:h	Ljava/util/List;
    //   103: invokeinterface 104 1 0
    //   108: if_icmpge +36 -> 144
    //   111: aload 9
    //   113: aload_0
    //   114: getfield 39	com/baidu/mobstat/cf:h	Ljava/util/List;
    //   117: iload 10
    //   119: invokeinterface 112 2 0
    //   124: checkcast 55	com/baidu/mobstat/cg
    //   127: aload_0
    //   128: getfield 22	com/baidu/mobstat/cf:a	J
    //   131: invokestatic 158	com/baidu/mobstat/cf:a	(Lcom/baidu/mobstat/cg;J)Lorg/json/JSONObject;
    //   134: invokevirtual 161	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   137: pop
    //   138: iinc 10 1
    //   141: goto -44 -> 97
    //   144: aload_1
    //   145: ldc 163
    //   147: aload 9
    //   149: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: aload_1
    //   154: areturn
    //   155: ldc 165
    //   157: invokestatic 168	com/baidu/mobstat/cz:a	(Ljava/lang/String;)V
    //   160: aload_1
    //   161: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   8	94	155	org/json/JSONException
    //   97	138	155	org/json/JSONException
    //   144	153	155	org/json/JSONException
  }

  public void c(long paramLong)
  {
    this.a = paramLong;
  }

  public int d()
  {
    return this.f;
  }

  public void d(long paramLong)
  {
    this.b = paramLong;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cf
 * JD-Core Version:    0.6.2
 */