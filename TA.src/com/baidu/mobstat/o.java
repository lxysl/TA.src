package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
{
  static o a = new o();

  private void a(Context paramContext, ArrayList<p> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    String str;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = ((p)localIterator.next()).a();
        if (localJSONObject2 != null)
          localJSONArray.put(localJSONObject2);
      }
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("app_apk", localJSONArray);
      localJSONObject1.put("meta-data", localStringBuilder.toString());
      str = cq.a(localJSONObject1.toString().getBytes());
    }
    catch (Exception localException)
    {
      bd.b(localException);
      str = "";
    }
    if (!TextUtils.isEmpty(str))
      y.e.a(System.currentTimeMillis(), str);
  }

  private void b(Context paramContext)
  {
    a(paramContext, c(paramContext));
  }

  private ArrayList<p> c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d(paramContext).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      if (localApplicationInfo != null)
      {
        String str1 = localPackageInfo.packageName;
        String str2 = localPackageInfo.versionName;
        String str3 = "";
        Signature[] arrayOfSignature = localPackageInfo.signatures;
        if ((arrayOfSignature != null) && (arrayOfSignature.length != 0))
          str3 = arrayOfSignature[0].toChars().toString();
        String str4 = cx.a(str3.getBytes());
        String str5 = "";
        String str6 = localApplicationInfo.sourceDir;
        if (!TextUtils.isEmpty(str6))
          str5 = cx.a(new File(str6));
        localArrayList.add(new p(str1, str2, str4, str5));
      }
    }
    return localArrayList;
  }

  private ArrayList<PackageInfo> d(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
      return localArrayList1;
    ArrayList localArrayList2 = new ArrayList(1);
    Object localObject;
    try
    {
      localObject = localPackageManager.getInstalledPackages(64);
    }
    catch (Exception localException)
    {
      bd.b(localException);
      localObject = localArrayList2;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      if ((localApplicationInfo != null) && ((0x1 & localApplicationInfo.flags) == 0))
        localArrayList1.add(localPackageInfo);
    }
    return localArrayList1;
  }

  public void a(Context paramContext)
  {
    try
    {
      b(paramContext);
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
 * Qualified Name:     com.baidu.mobstat.o
 * JD-Core Version:    0.6.2
 */