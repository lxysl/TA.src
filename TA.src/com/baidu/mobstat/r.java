package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class r
{
  static final r a = new r();

  private long a(String paramString)
  {
    if (paramString != null)
    {
      File localFile = new File(paramString);
      if ((localFile != null) && (localFile.exists()))
        return localFile.lastModified();
    }
    return 0L;
  }

  private void a(boolean paramBoolean, String paramString1, String paramString2, PackageInfo paramPackageInfo, JSONArray paramJSONArray)
  {
    if ((paramBoolean) && (paramPackageInfo.packageName.startsWith("com.android.")))
      return;
    long l1 = 0L;
    long l2;
    try
    {
      l2 = paramPackageInfo.firstInstallTime;
    }
    catch (Throwable localThrowable1)
    {
      bd.b(localThrowable1);
      l2 = l1;
    }
    try
    {
      long l4 = paramPackageInfo.lastUpdateTime;
      l1 = l4;
    }
    catch (Throwable localThrowable2)
    {
      bd.b(localThrowable2);
    }
    long l3 = a(paramString2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", paramPackageInfo.packageName);
      localJSONObject.put("a", paramString1);
      localJSONObject.put("v", String.valueOf(paramPackageInfo.versionName));
      localJSONObject.put("f", l2);
      localJSONObject.put("l", l1);
      localJSONObject.put("m", l3);
      paramJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      bd.b(localJSONException);
    }
  }

  // ERROR //
  private void b(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 104	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: new 106	java/util/ArrayList
    //   13: dup
    //   14: iconst_1
    //   15: invokespecial 109	java/util/ArrayList:<init>	(I)V
    //   18: astore 4
    //   20: aload_3
    //   21: iconst_0
    //   22: invokevirtual 115	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   25: astore 27
    //   27: aload 27
    //   29: astore 4
    //   31: goto +10 -> 41
    //   34: astore 5
    //   36: aload 5
    //   38: invokestatic 57	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   41: new 92	org/json/JSONArray
    //   44: dup
    //   45: invokespecial 116	org/json/JSONArray:<init>	()V
    //   48: astore 6
    //   50: aload 4
    //   52: invokeinterface 122 1 0
    //   57: astore 7
    //   59: aload 7
    //   61: invokeinterface 127 1 0
    //   66: ifeq +91 -> 157
    //   69: aload 7
    //   71: invokeinterface 131 1 0
    //   76: checkcast 35	android/content/pm/PackageInfo
    //   79: astore 22
    //   81: aload 22
    //   83: getfield 135	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   86: astore 23
    //   88: aload 23
    //   90: ifnonnull +6 -> 96
    //   93: goto -34 -> 59
    //   96: iconst_1
    //   97: aload 23
    //   99: getfield 141	android/content/pm/ApplicationInfo:flags	I
    //   102: iand
    //   103: ifeq +9 -> 112
    //   106: iconst_1
    //   107: istore 24
    //   109: goto +6 -> 115
    //   112: iconst_0
    //   113: istore 24
    //   115: aload 23
    //   117: aload_3
    //   118: invokevirtual 145	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   121: invokeinterface 151 1 0
    //   126: astore 25
    //   128: aload 23
    //   130: getfield 154	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   133: astore 26
    //   135: iload_2
    //   136: iload 24
    //   138: if_icmpne -79 -> 59
    //   141: aload_0
    //   142: iload_2
    //   143: aload 25
    //   145: aload 26
    //   147: aload 22
    //   149: aload 6
    //   151: invokespecial 156	com/baidu/mobstat/r:a	(ZLjava/lang/String;Ljava/lang/String;Landroid/content/pm/PackageInfo;Lorg/json/JSONArray;)V
    //   154: goto -95 -> 59
    //   157: aload 6
    //   159: invokevirtual 160	org/json/JSONArray:length	()I
    //   162: ifne +4 -> 166
    //   165: return
    //   166: new 162	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   173: astore 8
    //   175: new 162	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   182: astore 9
    //   184: aload 9
    //   186: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   189: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 9
    //   195: ldc 174
    //   197: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 8
    //   203: aload 9
    //   205: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 8
    //   214: iload_2
    //   215: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: new 64	org/json/JSONObject
    //   222: dup
    //   223: invokespecial 65	org/json/JSONObject:<init>	()V
    //   226: astore 14
    //   228: aload 14
    //   230: ldc 183
    //   232: aload 6
    //   234: invokevirtual 71	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload 14
    //   240: ldc 185
    //   242: aload 8
    //   244: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokevirtual 71	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   250: pop
    //   251: aload 14
    //   253: invokevirtual 186	org/json/JSONObject:toString	()Ljava/lang/String;
    //   256: invokevirtual 190	java/lang/String:getBytes	()[B
    //   259: invokestatic 195	com/baidu/mobstat/cq:a	([B)Ljava/lang/String;
    //   262: astore 15
    //   264: goto +7 -> 271
    //   267: ldc 197
    //   269: astore 15
    //   271: aload 15
    //   273: invokestatic 203	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   276: ifne +19 -> 295
    //   279: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   282: lstore 16
    //   284: getstatic 208	com/baidu/mobstat/y:b	Lcom/baidu/mobstat/y;
    //   287: lload 16
    //   289: aload 15
    //   291: invokevirtual 211	com/baidu/mobstat/y:a	(JLjava/lang/String;)J
    //   294: pop2
    //   295: return
    //
    // Exception table:
    //   from	to	target	type
    //   20	27	34	java/lang/Exception
    //   219	264	267	java/lang/Exception
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      b(paramContext, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.r
 * JD-Core Version:    0.6.2
 */