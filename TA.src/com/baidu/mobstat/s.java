package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class s
{
  static s a = new s();
  private String b = "";

  private String a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
      return "";
    String str;
    try
    {
      str = localPackageManager.getPackageInfo(paramString, 0).versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bd.b(localNameNotFoundException);
      str = "";
    }
    if (str == null)
      str = "";
    return str;
  }

  private ArrayList<t> a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return c(paramContext, paramInt);
    return b(paramContext, paramInt);
  }

  private void a(Context paramContext, ArrayList<t> paramArrayList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(System.currentTimeMillis());
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(paramBoolean);
    String str;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = ((t)localIterator.next()).a();
        if (localJSONObject2 != null)
          localJSONArray.put(localJSONObject2);
      }
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("app_trace", localJSONArray);
      localJSONObject1.put("meta-data", localStringBuilder1.toString());
      str = cq.a(localJSONObject1.toString().getBytes());
    }
    catch (Exception localException)
    {
      bd.b(localException);
      str = "";
    }
    if (!TextUtils.isEmpty(str))
      y.c.a(System.currentTimeMillis(), str);
  }

  private void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = a(paramContext, paramInt);
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0)
        return;
      if (paramBoolean)
      {
        String str = ((t)localArrayList.get(0)).b();
        if (a(str, this.b))
          this.b = str;
      }
      a(paramContext, localArrayList, paramBoolean);
    }
  }

  private boolean a(int paramInt)
  {
    return (paramInt == 100) || (paramInt == 200) || (paramInt == 130);
  }

  private boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.b));
  }

  private ArrayList<t> b(Context paramContext, int paramInt)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    List localList;
    try
    {
      localList = localActivityManager.getRunningTasks(50);
    }
    catch (Exception localException)
    {
      bd.b(localException);
      localList = null;
    }
    if (localList == null)
      return new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localIterator.next();
      if (localLinkedHashMap.size() > paramInt)
        break;
      ComponentName localComponentName = localRunningTaskInfo.topActivity;
      if (localComponentName != null)
      {
        String str = localComponentName.getPackageName();
        if ((!TextUtils.isEmpty(str)) && (!b(paramContext, str)) && (!localLinkedHashMap.containsKey(str)))
          localLinkedHashMap.put(str, new t(str, a(paramContext, str), ""));
      }
    }
    return new ArrayList(localLinkedHashMap.values());
  }

  private boolean b(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
      return false;
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getPackageInfo(paramString, 0).applicationInfo;
      if (localApplicationInfo == null)
        return false;
      int i = localApplicationInfo.flags;
      if ((i & 0x1) != 0)
        return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bd.b(localNameNotFoundException);
    }
    return false;
  }

  private ArrayList<t> c(Context paramContext, int paramInt)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList == null)
      return new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    for (int i = 0; (i < localList.size()) && (localLinkedHashMap.size() <= paramInt); i++)
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localList.get(i);
      if (a(localRunningAppProcessInfo.importance))
      {
        String[] arrayOfString = localRunningAppProcessInfo.pkgList;
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          String str = localRunningAppProcessInfo.pkgList[0];
          if ((!TextUtils.isEmpty(str)) && (!b(paramContext, str)) && (!localLinkedHashMap.containsKey(str)))
            localLinkedHashMap.put(str, new t(str, a(paramContext, str), String.valueOf(localRunningAppProcessInfo.importance)));
        }
      }
    }
    return new ArrayList(localLinkedHashMap.values());
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    if (!paramBoolean)
      i = 20;
    try
    {
      a(paramContext, paramBoolean, i);
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
 * Qualified Name:     com.baidu.mobstat.s
 * JD-Core Version:    0.6.2
 */