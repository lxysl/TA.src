package com.androlua;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.hardware.display.VirtualDisplay.Callback;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.a.a.a.a.a.a.a;
import com.androlua.util.ClickRunnable;
import com.androlua.util.ClickRunnable.ClickCallback;
import com.androlua.util.GlobalActionAutomator;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaTable;
import com.nirenr.Point;
import com.nirenr.screencapture.ScreenCaptureListener;
import com.nirenr.screencapture.ScreenShot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class LuaAccessibilityService extends AccessibilityService
{
  private static AccessibilityServiceCallbacks a;
  private static LuaAccessibilityService d;
  public static LuaFunction onAccessibilityEvent;
  private LuaApplication b;
  private Map c;
  private HashMap<String, ComponentName> e = new HashMap();
  private boolean f;
  private Handler g;
  private GlobalActionAutomator h;
  private ScreenShot i;
  private int j;
  private int k;
  private int l;

  private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return null;
    if (isListView2(paramAccessibilityNodeInfo))
      return paramAccessibilityNodeInfo;
    int m = paramAccessibilityNodeInfo.getChildCount();
    for (int n = 0; n < m; n++)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = a(paramAccessibilityNodeInfo.getChild(n));
      if (localAccessibilityNodeInfo != null)
        return localAccessibilityNodeInfo;
    }
    return null;
  }

  private void a()
  {
    WindowManager localWindowManager = (WindowManager)getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (localWindowManager == null)
      return;
    localWindowManager.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    this.j = localDisplayMetrics.densityDpi;
    this.k = localDisplayMetrics.widthPixels;
    this.l = localDisplayMetrics.heightPixels;
  }

  private void a(AccessibilityNodeInfo paramAccessibilityNodeInfo, ArrayList<String> paramArrayList)
  {
    if (paramAccessibilityNodeInfo == null)
      return;
    getNodeInfoText(paramAccessibilityNodeInfo);
    int m = paramAccessibilityNodeInfo.getChildCount();
    if (m > 0)
      for (int n = 0; n < m; n++)
        a(paramAccessibilityNodeInfo.getChild(n), paramArrayList);
  }

  private void a(AccessibilityNodeInfo paramAccessibilityNodeInfo1, ArrayList<String> paramArrayList, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    if (paramAccessibilityNodeInfo1 == null)
      return;
    if (!this.f)
      this.f = paramAccessibilityNodeInfo1.equals(paramAccessibilityNodeInfo2);
    String str = getNodeInfoText(paramAccessibilityNodeInfo1);
    if ((this.f) && (str != null))
      paramArrayList.add(str.toString());
    int m = paramAccessibilityNodeInfo1.getChildCount();
    if (m > 0)
      for (int n = 0; n < m; n++)
      {
        AccessibilityNodeInfo localAccessibilityNodeInfo = paramAccessibilityNodeInfo1.getChild(n);
        if (localAccessibilityNodeInfo != null)
        {
          if (!this.f)
            this.f = localAccessibilityNodeInfo.equals(paramAccessibilityNodeInfo2);
          a(localAccessibilityNodeInfo, paramArrayList, paramAccessibilityNodeInfo2);
        }
      }
  }

  private void a(String paramString, LuaException paramLuaException)
  {
  }

  private void a(List<AccessibilityNodeInfo> paramList, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString)
  {
    if (paramAccessibilityNodeInfo == null)
      return;
    CharSequence[] arrayOfCharSequence = new CharSequence[2];
    String[] arrayOfString = paramString.split("\\|");
    CharSequence localCharSequence1 = paramAccessibilityNodeInfo.getContentDescription();
    int m = 0;
    arrayOfCharSequence[0] = localCharSequence1;
    arrayOfCharSequence[1] = paramAccessibilityNodeInfo.getText();
    int n = arrayOfString.length;
    for (int i1 = 0; i1 < n; i1++)
    {
      String str1 = arrayOfString[i1];
      boolean bool1 = true ^ str1.startsWith("*");
      boolean bool2 = true ^ str1.endsWith("*");
      if (!bool1)
        str1 = str1.substring(1);
      if (!bool2)
        str1 = str1.substring(0, str1.length() - 1);
      int i3 = arrayOfCharSequence.length;
      for (int i4 = 0; i4 < i3; i4++)
      {
        CharSequence localCharSequence2 = arrayOfCharSequence[i4];
        if (localCharSequence2 != null)
        {
          String str2 = localCharSequence2.toString().trim();
          if ((bool1) && (bool2))
          {
            if (!str1.equals(str2));
          }
          else
            while (bool1 ? str2.startsWith(str1) : bool2 ? str2.endsWith(str1) : str2.contains(str1))
            {
              paramList.add(paramAccessibilityNodeInfo);
              break;
            }
        }
      }
    }
    int i2 = paramAccessibilityNodeInfo.getChildCount();
    while (m < i2)
    {
      a(paramList, paramAccessibilityNodeInfo.getChild(m), paramString);
      m++;
    }
  }

  private AccessibilityNodeInfo b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = paramAccessibilityNodeInfo;
    while (true)
      if (localAccessibilityNodeInfo != null)
        try
        {
          if (isClickable(localAccessibilityNodeInfo))
            return localAccessibilityNodeInfo;
          localAccessibilityNodeInfo = localAccessibilityNodeInfo.getParent();
        }
        catch (Exception localException)
        {
          a.a(localException);
        }
    return paramAccessibilityNodeInfo;
  }

  private void b()
  {
    new AsyncTask()
    {
      protected HashMap<String, ComponentName> a(String[] paramAnonymousArrayOfString)
      {
        HashMap localHashMap = new HashMap();
        PackageManager localPackageManager = LuaAccessibilityService.this.getPackageManager();
        Intent localIntent1 = new Intent("android.intent.action.MAIN", null);
        localIntent1.addCategory("android.intent.category.DEFAULT");
        int i = 0;
        List localList1 = localPackageManager.queryIntentActivities(localIntent1, 0);
        Collections.sort(localList1, new ResolveInfo.DisplayNameComparator(localPackageManager));
        int j = localList1.size();
        for (int k = 0; k < j; k++)
        {
          ResolveInfo localResolveInfo2 = (ResolveInfo)localList1.get(k);
          CharSequence localCharSequence2 = localResolveInfo2.loadLabel(localPackageManager);
          ComponentName localComponentName2 = new ComponentName(localResolveInfo2.activityInfo.applicationInfo.packageName, localResolveInfo2.activityInfo.name);
          localHashMap.put(localCharSequence2.toString().toLowerCase(), localComponentName2);
        }
        Intent localIntent2 = new Intent("android.intent.action.MAIN", null);
        localIntent2.addCategory("android.intent.category.LAUNCHER");
        List localList2 = localPackageManager.queryIntentActivities(localIntent2, 0);
        Collections.sort(localList2, new ResolveInfo.DisplayNameComparator(localPackageManager));
        int m = localList2.size();
        while (i < m)
        {
          ResolveInfo localResolveInfo1 = (ResolveInfo)localList2.get(i);
          CharSequence localCharSequence1 = localResolveInfo1.loadLabel(localPackageManager);
          ComponentName localComponentName1 = new ComponentName(localResolveInfo1.activityInfo.applicationInfo.packageName, localResolveInfo1.activityInfo.name);
          localHashMap.put(localCharSequence1.toString().toLowerCase(), localComponentName1);
          i++;
        }
        return localHashMap;
      }

      protected void a(HashMap<String, ComponentName> paramAnonymousHashMap)
      {
        super.onPostExecute(paramAnonymousHashMap);
        if ((paramAnonymousHashMap != null) && (!paramAnonymousHashMap.isEmpty()))
          LuaAccessibilityService.a(LuaAccessibilityService.this, paramAnonymousHashMap);
      }
    }
    .execute(new String[] { "" });
  }

  private void c()
  {
    PackageManager localPackageManager = getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    int m = 0;
    List localList = localPackageManager.queryIntentActivities(localIntent, 0);
    Collections.sort(localList, new ResolveInfo.DisplayNameComparator(localPackageManager));
    if (localList != null)
    {
      int n = localList.size();
      while (m < n)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(m);
        CharSequence localCharSequence = localResolveInfo.loadLabel(localPackageManager);
        ComponentName localComponentName = new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name);
        this.e.put(localCharSequence.toString().toLowerCase(), localComponentName);
        m++;
      }
    }
  }

  public static LuaAccessibilityService getInstance()
  {
    return d;
  }

  public static void setCallback(AccessibilityServiceCallbacks paramAccessibilityServiceCallbacks)
  {
    a = paramAccessibilityServiceCallbacks;
  }

  public boolean appendCopy()
  {
    return appendCopy(getText(getFocusView()));
  }

  public boolean appendCopy(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    ClipboardManager localClipboardManager = (ClipboardManager)getSystemService("clipboard");
    CharSequence localCharSequence = localClipboardManager.getText();
    String str = "";
    if (localCharSequence != null)
      str = localCharSequence.toString();
    if (str.length() > 1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(str);
      localStringBuilder1.append("\n");
      str = localStringBuilder1.toString();
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramCharSequence);
    localClipboardManager.setPrimaryClip(ClipData.newPlainText("label", localStringBuilder2.toString()));
    return true;
  }

  public boolean click(int paramInt1, int paramInt2)
  {
    if (this.h != null)
      return this.h.click(paramInt1, paramInt2);
    return false;
  }

  public boolean click(LuaTable paramLuaTable)
  {
    return new ClickRunnable(this, paramLuaTable).canClick();
  }

  public boolean click(LuaTable paramLuaTable, final LuaFunction paramLuaFunction)
  {
    return new ClickRunnable(this, paramLuaTable).canClick(new ClickRunnable.ClickCallback()
    {
      public void onDone(boolean paramAnonymousBoolean, LuaTable paramAnonymousLuaTable, String paramAnonymousString, int paramAnonymousInt)
      {
        try
        {
          LuaFunction localLuaFunction = paramLuaFunction;
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = Boolean.valueOf(paramAnonymousBoolean);
          arrayOfObject[1] = paramAnonymousLuaTable;
          arrayOfObject[2] = paramAnonymousString;
          arrayOfObject[3] = Integer.valueOf(paramAnonymousInt);
          localLuaFunction.call(arrayOfObject);
          return;
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
          LuaAccessibilityService.a(LuaAccessibilityService.this, "click", localLuaException);
        }
      }
    });
  }

  public boolean click(Point paramPoint)
  {
    return click(paramPoint.x, paramPoint.y);
  }

  public boolean click(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null)
        return false;
      if (!paramString1.equals(getAppName(getFocusView())))
        return false;
      AccessibilityNodeInfo localAccessibilityNodeInfo1 = getRootInActiveWindow();
      if (localAccessibilityNodeInfo1 == null)
        return false;
      if (localAccessibilityNodeInfo1.findAccessibilityNodeInfosByText(paramString2).isEmpty())
        return false;
      int m = paramArrayOfInt.length;
      AccessibilityNodeInfo localAccessibilityNodeInfo2 = localAccessibilityNodeInfo1;
      for (int n = 0; n < m; n++)
      {
        int i1 = paramArrayOfInt[n];
        if (localAccessibilityNodeInfo2.getChildCount() <= i1)
          return false;
        localAccessibilityNodeInfo2 = localAccessibilityNodeInfo2.getChild(i1);
        if (localAccessibilityNodeInfo2 == null)
          return false;
      }
      return toClick(localAccessibilityNodeInfo2);
    }
    return false;
  }

  public boolean copy()
  {
    return copy(getText(getFocusView()));
  }

  public boolean copy(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    String str = paramCharSequence.toString();
    ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
    return true;
  }

  public boolean deleteApp(String paramString)
  {
    this.e.clear();
    c();
    String str = paramString.toLowerCase();
    ComponentName localComponentName = (ComponentName)this.e.get(str);
    if (localComponentName == null)
      return false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("package:");
    localStringBuilder.append(localComponentName.getPackageName());
    Intent localIntent = new Intent("android.intent.action.DELETE", Uri.parse(localStringBuilder.toString()));
    localIntent.setFlags(270532608);
    startActivity(localIntent);
    return true;
  }

  public boolean execute(String paramString, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    switch (paramString.hashCode())
    {
    default:
      break;
    case 1119180876:
      if (paramString.equals("追加复制"))
        m = 8;
      break;
    case 821558167:
      if (paramString.equals("最近任务"))
        m = 5;
      break;
    case 697331565:
      if (paramString.equals("增加进度"))
        m = 3;
      break;
    case 661386612:
      if (paramString.equals("向下翻页"))
        m = 1;
      break;
    case 661385651:
      if (paramString.equals("向上翻页"))
        m = 0;
      break;
    case 647728589:
      if (paramString.equals("减少进度"))
        m = 2;
      break;
    case 36429412:
      if (paramString.equals("通知栏"))
        m = 13;
      break;
    case 20002657:
      if (paramString.equals("主屏幕"))
        m = 9;
      break;
    case 1211754:
      if (paramString.equals("长按"))
        m = 12;
      break;
    case 1163658:
      if (paramString.equals("返回"))
        m = 10;
      break;
    case 1024924:
      if (paramString.equals("粘贴"))
        m = 4;
      break;
    case 915554:
      if (paramString.equals("点击"))
        m = 11;
      break;
    case 904469:
      if (paramString.equals("清空"))
        m = 6;
      break;
    case 727753:
      if (paramString.equals("复制"))
        m = 7;
      break;
    case -1762910153:
      if (paramString.equals("打开通知栏"))
        m = 14;
      break;
    }
    int m = -1;
    switch (m)
    {
    default:
      return false;
    case 13:
    case 14:
      toNotifications();
      return true;
    case 12:
      toLongClick(paramAccessibilityNodeInfo);
      return true;
    case 11:
      toClick(paramAccessibilityNodeInfo);
      return true;
    case 10:
      toBack();
      return true;
    case 9:
      toHome();
      return true;
    case 8:
      appendCopy(getText(paramAccessibilityNodeInfo));
      return true;
    case 7:
      copy(getText(paramAccessibilityNodeInfo));
      return true;
    case 6:
      if (Build.VERSION.SDK_INT >= 21)
        return paramAccessibilityNodeInfo.performAction(2097152);
      return false;
    case 5:
      toRecents();
      return true;
    case 4:
      paste(paramAccessibilityNodeInfo);
      return true;
    case 3:
      return scrollForward(paramAccessibilityNodeInfo);
    case 2:
      return scrollBackward(paramAccessibilityNodeInfo);
    case 1:
      AccessibilityNodeInfo localAccessibilityNodeInfo2 = a(getRootInActiveWindow());
      if (localAccessibilityNodeInfo2 == null)
        return false;
      return scrollForward(localAccessibilityNodeInfo2);
    case 0:
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo1 = a(getRootInActiveWindow());
    if (localAccessibilityNodeInfo1 == null)
      return false;
    return scrollBackward(localAccessibilityNodeInfo1);
  }

  public AccessibilityNodeInfo findAccessibilityNodeInfo(String paramString)
  {
    int m = paramString.lastIndexOf("@");
    if (m > 0)
    {
      if (!paramString.substring(m + 1).equals(getAppName(getFocusView())))
        return null;
      paramString = paramString.substring(0, m);
    }
    int n = paramString.lastIndexOf("#");
    int i1 = -1;
    if (n > 0)
    {
      int i3 = n + 1;
      try
      {
        int i4 = Integer.valueOf(paramString.substring(i3)).intValue();
        i1 = i4;
      }
      catch (Exception localException)
      {
      }
      paramString = paramString.substring(0, n);
    }
    int i2 = paramString.charAt(0);
    if (i2 != 62)
    {
      if (i2 != 64)
      {
        switch (i2)
        {
        default:
          return findAccessibilityNodeInfoByText(paramString, i1);
        case 37:
          if (execute(paramString.substring(1), getFocusView()))
            return AccessibilityNodeInfo.obtain();
          return null;
        case 36:
        }
        return findAccessibilityNodeInfoByIndex(paramString.substring(1));
      }
      return findAccessibilityNodeInfoById(paramString.substring(1), i1);
    }
    if (startApp(paramString.substring(1)))
      return AccessibilityNodeInfo.obtain();
    return null;
  }

  public AccessibilityNodeInfo findAccessibilityNodeInfoById(String paramString, int paramInt)
  {
    List localList = findAccessibilityNodeInfoById(paramString);
    if (localList.isEmpty())
      return null;
    int m = localList.size();
    if (paramInt + 1 <= m)
    {
      if (0 - paramInt > m)
        return null;
      if (paramInt < 0);
      for (Object localObject = localList.get(paramInt + localList.size()); ; localObject = localList.get(paramInt))
        return (AccessibilityNodeInfo)localObject;
    }
    return null;
  }

  public List<AccessibilityNodeInfo> findAccessibilityNodeInfoById(String paramString)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = getRootInActiveWindow();
    if (localAccessibilityNodeInfo == null)
      return new ArrayList();
    return localAccessibilityNodeInfo.findAccessibilityNodeInfosByText(paramString);
  }

  public AccessibilityNodeInfo findAccessibilityNodeInfoByIndex(String paramString)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = getRootInActiveWindow();
    if (localAccessibilityNodeInfo == null)
      return null;
    String[] arrayOfString = paramString.split("-");
    int m = arrayOfString.length;
    int n = 0;
    while (n < m)
    {
      String str = arrayOfString[n];
      try
      {
        int i1 = Integer.valueOf(str).intValue();
        if (localAccessibilityNodeInfo.getChildCount() <= i1)
          return null;
        localAccessibilityNodeInfo = localAccessibilityNodeInfo.getChild(i1);
        if (localAccessibilityNodeInfo == null)
          return null;
        n++;
      }
      catch (Exception localException)
      {
        a.a(localException);
        return null;
      }
    }
    return localAccessibilityNodeInfo;
  }

  public AccessibilityNodeInfo findAccessibilityNodeInfoByText(String paramString, int paramInt)
  {
    List localList = findAccessibilityNodeInfoByText(paramString);
    if (localList.isEmpty())
      return null;
    int m = localList.size();
    if (paramInt + 1 <= m)
    {
      if (0 - paramInt > m)
        return null;
      if (paramInt < 0);
      for (Object localObject = localList.get(paramInt + localList.size()); ; localObject = localList.get(paramInt))
        return (AccessibilityNodeInfo)localObject;
    }
    return null;
  }

  public List<AccessibilityNodeInfo> findAccessibilityNodeInfoByText(String paramString)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo1 = getRootInActiveWindow();
    ArrayList localArrayList = new ArrayList();
    if (localAccessibilityNodeInfo1 == null)
      return localArrayList;
    String[] arrayOfString = paramString.split("\\|");
    int m = arrayOfString.length;
    int n = 0;
    while (n < m)
    {
      String str1 = arrayOfString[n];
      if (!str1.isEmpty())
      {
        if (str1.charAt(0) == '%')
          break label407;
        int i1 = str1.lastIndexOf('&');
        if (i1 > 0)
        {
          if (findAccessibilityNodeInfo(str1.substring(i1 + 1)) != null)
            str1 = str1.substring(0, i1);
        }
        else
        {
          boolean bool1 = true ^ str1.startsWith("*");
          boolean bool2 = true ^ str1.endsWith("*");
          if (!bool1)
            str1 = str1.substring(1);
          if (!bool2)
            str1 = str1.substring(0, str1.length() - 1);
          Iterator localIterator = localAccessibilityNodeInfo1.findAccessibilityNodeInfosByText(str1).iterator();
          while (localIterator.hasNext())
          {
            AccessibilityNodeInfo localAccessibilityNodeInfo2 = (AccessibilityNodeInfo)localIterator.next();
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append(localAccessibilityNodeInfo2.getText());
            localStringBuilder1.append("");
            String str2 = localStringBuilder1.toString().trim();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(localAccessibilityNodeInfo2.getContentDescription());
            localStringBuilder2.append("");
            String str3 = localStringBuilder2.toString().trim();
            if ((bool1) && (bool2))
              if ((!str1.equals(str2)) && (!str1.equals(str3)))
                break;
            else
              while (true)
              {
                localArrayList.add(localAccessibilityNodeInfo2);
                break;
                if (bool1)
                {
                  if (str2.startsWith(str1))
                    continue;
                  if (!str3.startsWith(str1))
                    break;
                  continue;
                }
                if (bool2)
                {
                  if (str2.endsWith(str1))
                    continue;
                  if (!str3.endsWith(str1))
                    break;
                  continue;
                }
                if (!str2.contains(str1))
                  if (!str3.contains(str1))
                    break;
              }
          }
        }
      }
      n++;
      continue;
      label407: execute(str1.substring(1), getFocusView());
      return localArrayList;
    }
    if (localArrayList.isEmpty())
      a(localArrayList, localAccessibilityNodeInfo1, paramString);
    return localArrayList;
  }

  public boolean findClick(String[] paramArrayOfString)
  {
    int m = paramArrayOfString.length;
    for (int n = 0; n < m; n++)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = findAccessibilityNodeInfoByText(paramArrayOfString[n], 0);
      if ((localAccessibilityNodeInfo != null) && (b(localAccessibilityNodeInfo).performAction(16)))
        return true;
    }
    return false;
  }

  public ArrayList<AccessibilityNodeInfo> getAllEditTextList()
  {
    ArrayList localArrayList = new ArrayList();
    getEditText(getRootInActiveWindow(), localArrayList);
    return localArrayList;
  }

  public String getAllText(int paramInt)
  {
    ArrayList localArrayList = getAllTextList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.length() > paramInt)
      {
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }

  public ArrayList<String> getAllTextList()
  {
    ArrayList localArrayList = new ArrayList();
    a(getRootInActiveWindow(), localArrayList);
    return localArrayList;
  }

  public ArrayList<String> getAllTextList(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    ArrayList localArrayList = new ArrayList();
    AccessibilityNodeInfo localAccessibilityNodeInfo = getRootInActiveWindow();
    this.f = (true ^ paramAccessibilityNodeInfo.isVisibleToUser());
    a(localAccessibilityNodeInfo, localArrayList, paramAccessibilityNodeInfo);
    return localArrayList;
  }

  public String getAppName(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return "";
    CharSequence localCharSequence = paramAccessibilityNodeInfo.getPackageName();
    if (localCharSequence == null)
      return "";
    String str1 = localCharSequence.toString();
    PackageManager localPackageManager = getPackageManager();
    try
    {
      String str2 = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str1, 0)).toString();
      return str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      a.a(localNameNotFoundException);
    }
    return "";
  }

  public int getDensity()
  {
    if (this.j == 0)
      a();
    return this.j;
  }

  public AccessibilityNodeInfo getEditText()
  {
    ArrayList localArrayList = getAllEditTextList();
    if (localArrayList.isEmpty())
      return null;
    AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)localArrayList.get(0);
    if (localAccessibilityNodeInfo != null)
      localAccessibilityNodeInfo.performAction(64);
    return localAccessibilityNodeInfo;
  }

  public void getEditText(AccessibilityNodeInfo paramAccessibilityNodeInfo, ArrayList<AccessibilityNodeInfo> paramArrayList)
  {
    if (paramAccessibilityNodeInfo == null)
      return;
    if (paramAccessibilityNodeInfo.isEditable())
      paramArrayList.add(paramAccessibilityNodeInfo);
    int m = paramAccessibilityNodeInfo.getChildCount();
    if (m > 0)
      for (int n = 0; n < m; n++)
        getEditText(paramAccessibilityNodeInfo.getChild(n), paramArrayList);
  }

  public AccessibilityNodeInfo getFocusView()
  {
    return getRootInActiveWindow();
  }

  public Handler getHandler()
  {
    return this.g;
  }

  public int getHeight()
  {
    if (this.l == 0)
      a();
    return this.l;
  }

  public String getNodeInfoText(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return null;
    CharSequence localCharSequence1 = paramAccessibilityNodeInfo.getContentDescription();
    CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
    String str;
    if (localCharSequence1 != null)
      str = localCharSequence1.toString();
    else
      str = null;
    if ((str != null) && (str.trim().length() > 0) && ((!paramAccessibilityNodeInfo.isEditable()) || (localCharSequence2 == null)))
      return str;
    if ((localCharSequence2 != null) && (localCharSequence2.length() > 0))
      return localCharSequence2.toString();
    return null;
  }

  public Bitmap getScreenshot()
  {
    if (this.i != null)
      return this.i.getScreenShot();
    return null;
  }

  public void getScreenshot(final LuaFunction paramLuaFunction)
  {
    ScreenShot.getScreenCaptureBitmap(this, new ScreenCaptureListener()
    {
      public void onScreenCaptureDone(Bitmap paramAnonymousBitmap)
      {
        try
        {
          paramLuaFunction.call(new Object[] { paramAnonymousBitmap });
          return;
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
        }
      }

      public void onScreenCaptureError(String paramAnonymousString)
      {
        try
        {
          paramLuaFunction.call(new Object[] { null, paramAnonymousString });
          return;
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
        }
      }
    });
  }

  public String getText(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return getNodeInfoText(paramAccessibilityNodeInfo);
  }

  public int getWidth()
  {
    if (this.k == 0)
      a();
    return this.k;
  }

  public boolean insert(AccessibilityNodeInfo paramAccessibilityNodeInfo, CharSequence paramCharSequence)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    if (paramCharSequence == null)
      return false;
    if (paramAccessibilityNodeInfo.isEditable())
    {
      if (!paramAccessibilityNodeInfo.isFocused())
        paramAccessibilityNodeInfo.performAction(1);
      ClipboardManager localClipboardManager = (ClipboardManager)getSystemService("clipboard");
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("label", paramCharSequence));
      localClipboardManager.setText(paramCharSequence);
      if (paramAccessibilityNodeInfo.performAction(32768))
        return true;
    }
    return false;
  }

  // ERROR //
  public boolean installApp(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 301	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 623
    //   18: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: new 205	android/content/Intent
    //   31: dup
    //   32: ldc_w 625
    //   35: aload_2
    //   36: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 402	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   42: invokespecial 210	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   45: astore 5
    //   47: aload 5
    //   49: ldc_w 403
    //   52: invokevirtual 407	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   55: pop
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 411	com/androlua/LuaAccessibilityService:startActivity	(Landroid/content/Intent;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: iconst_0
    //   65: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   56	62	64	java/lang/Exception
  }

  public boolean isClickable(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    if (paramAccessibilityNodeInfo.isClickable())
      return true;
    if (paramAccessibilityNodeInfo.isCheckable())
      return true;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramAccessibilityNodeInfo.getActionList().contains(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK))
        return true;
    }
    else if ((0x10 & paramAccessibilityNodeInfo.getActions()) != 0)
      return true;
    return false;
  }

  public boolean isListView2(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    CharSequence localCharSequence = paramAccessibilityNodeInfo.getClassName();
    if (localCharSequence != null)
    {
      String str = localCharSequence.toString();
      int m = -1;
      switch (str.hashCode())
      {
      default:
        break;
      case 1977625610:
        if (str.equals("android.widget.AbsListView"))
          m = 3;
        break;
      case 1928354017:
        if (str.equals("android.widget.HorizontalScrollView"))
          m = 8;
        break;
      case 1799238850:
        if (str.equals("android.widget.ExpandableListView"))
          m = 4;
        break;
      case 841510749:
        if (str.equals("android.widget.ScrollView"))
          m = 7;
        break;
      case -405438610:
        if (str.equals("android.widget.ListView"))
          m = 1;
        break;
      case -438596061:
        if (str.equals("flyme.support.v7.widget.RecyclerView"))
          m = 6;
        break;
      case -703660929:
        if (str.equals("android.support.v7.widget.RecyclerView"))
          m = 5;
        break;
      case -1102376577:
        if (str.equals("com.tencent.widget.GridView"))
          m = 9;
        break;
      case -1154346071:
        if (str.equals("android.widget.AdapterView"))
          m = 0;
        break;
      case -1433025002:
        if (str.equals("android.widget.GridView"))
          m = 2;
        break;
      }
      switch (m)
      {
      default:
        if (!str.endsWith("ScrollView"))
          break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        return true;
      }
      if (str.endsWith("GridView"))
        return true;
      if (str.endsWith("RecyclerView"))
        return true;
      if (str.endsWith("ListView"))
        return true;
    }
    return false;
  }

  public boolean longClick(int paramInt1, int paramInt2)
  {
    if (this.h != null)
      return this.h.longClick(paramInt1, paramInt2);
    return false;
  }

  public boolean longClick(Point paramPoint)
  {
    return longClick(paramPoint.x, paramPoint.y);
  }

  public ClickRunnable loopClick(final LuaTable paramLuaTable)
  {
    ClickRunnable localClickRunnable = new ClickRunnable(this, paramLuaTable);
    localClickRunnable.canClick(new ClickRunnable.ClickCallback()
    {
      public void onDone(boolean paramAnonymousBoolean, LuaTable paramAnonymousLuaTable, String paramAnonymousString, int paramAnonymousInt)
      {
        LuaAccessibilityService.this.loopClick(paramLuaTable);
      }
    });
    return localClickRunnable;
  }

  // ERROR //
  public void onAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    // Byte code:
    //   0: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   3: ifnull +13 -> 16
    //   6: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   9: aload_0
    //   10: aload_1
    //   11: invokeinterface 693 3 0
    //   16: getstatic 695	com/androlua/LuaAccessibilityService:onAccessibilityEvent	Lcom/luajava/LuaFunction;
    //   19: ifnull +63 -> 82
    //   22: getstatic 695	com/androlua/LuaAccessibilityService:onAccessibilityEvent	Lcom/luajava/LuaFunction;
    //   25: iconst_1
    //   26: anewarray 697	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_1
    //   32: aastore
    //   33: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: return
    //   38: astore 9
    //   40: new 301	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   47: astore 10
    //   49: aload 10
    //   51: ldc_w 705
    //   54: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 10
    //   60: aload 9
    //   62: invokevirtual 706	com/luajava/LuaException:toString	()Ljava/lang/String;
    //   65: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc_w 708
    //   72: aload 10
    //   74: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: return
    //   82: aload_0
    //   83: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   86: ldc_w 717
    //   89: invokeinterface 722 2 0
    //   94: ifne +4 -> 98
    //   97: return
    //   98: aload_0
    //   99: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   102: ldc_w 717
    //   105: invokeinterface 723 2 0
    //   110: checkcast 725	com/luajava/LuaTable
    //   113: astore_2
    //   114: aload_2
    //   115: ifnonnull +4 -> 119
    //   118: return
    //   119: aload_2
    //   120: ldc_w 726
    //   123: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 699	com/luajava/LuaFunction
    //   129: iconst_1
    //   130: anewarray 697	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: return
    //   142: astore_3
    //   143: aload_2
    //   144: ldc_w 729
    //   147: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 699	com/luajava/LuaFunction
    //   153: astore 4
    //   155: aload 4
    //   157: ifnonnull +15 -> 172
    //   160: ldc_w 726
    //   163: aload_3
    //   164: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   167: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: return
    //   172: aload 4
    //   174: iconst_1
    //   175: anewarray 697	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_3
    //   181: aastore
    //   182: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: return
    //   187: ldc_w 726
    //   190: aload_3
    //   191: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   194: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   197: pop
    //   198: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	37	38	com/luajava/LuaException
    //   119	141	142	com/luajava/LuaException
    //   172	186	187	com/luajava/LuaException
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (a != null)
      a.onConfigurationChanged(this, paramConfiguration);
  }

  // ERROR //
  public void onCreate()
  {
    // Byte code:
    //   0: ldc_w 708
    //   3: ldc_w 739
    //   6: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokespecial 741	android/accessibilityservice/AccessibilityService:onCreate	()V
    //   14: aload_0
    //   15: new 743	android/os/Handler
    //   18: dup
    //   19: invokespecial 744	android/os/Handler:<init>	()V
    //   22: putfield 590	com/androlua/LuaAccessibilityService:g	Landroid/os/Handler;
    //   25: aload_0
    //   26: putstatic 281	com/androlua/LuaAccessibilityService:d	Lcom/androlua/LuaAccessibilityService;
    //   29: getstatic 462	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 24
    //   34: if_icmplt +30 -> 64
    //   37: aload_0
    //   38: new 330	com/androlua/util/GlobalActionAutomator
    //   41: dup
    //   42: aload_0
    //   43: new 743	android/os/Handler
    //   46: dup
    //   47: invokespecial 744	android/os/Handler:<init>	()V
    //   50: invokespecial 747	com/androlua/util/GlobalActionAutomator:<init>	(Landroid/accessibilityservice/AccessibilityService;Landroid/os/Handler;)V
    //   53: putfield 328	com/androlua/LuaAccessibilityService:h	Lcom/androlua/util/GlobalActionAutomator;
    //   56: aload_0
    //   57: getfield 328	com/androlua/LuaAccessibilityService:h	Lcom/androlua/util/GlobalActionAutomator;
    //   60: aload_0
    //   61: invokevirtual 751	com/androlua/util/GlobalActionAutomator:setService	(Landroid/accessibilityservice/AccessibilityService;)V
    //   64: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   67: ifnull +12 -> 79
    //   70: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   73: aload_0
    //   74: invokeinterface 753 2 0
    //   79: aload_0
    //   80: invokespecial 755	com/androlua/LuaAccessibilityService:b	()V
    //   83: aload_0
    //   84: aload_0
    //   85: invokevirtual 759	com/androlua/LuaAccessibilityService:getApplication	()Landroid/app/Application;
    //   88: checkcast 761	com/androlua/LuaApplication
    //   91: putfield 763	com/androlua/LuaAccessibilityService:b	Lcom/androlua/LuaApplication;
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 763	com/androlua/LuaAccessibilityService:b	Lcom/androlua/LuaApplication;
    //   99: invokevirtual 767	com/androlua/LuaApplication:getGlobalData	()Ljava/util/Map;
    //   102: putfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   105: aload_0
    //   106: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   109: ldc_w 717
    //   112: invokeinterface 722 2 0
    //   117: ifne +4 -> 121
    //   120: return
    //   121: aload_0
    //   122: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   125: ldc_w 717
    //   128: invokeinterface 723 2 0
    //   133: checkcast 725	com/luajava/LuaTable
    //   136: astore_2
    //   137: aload_2
    //   138: ifnonnull +4 -> 142
    //   141: return
    //   142: aload_2
    //   143: ldc_w 739
    //   146: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 699	com/luajava/LuaFunction
    //   152: iconst_1
    //   153: anewarray 697	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_0
    //   159: aastore
    //   160: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: return
    //   165: astore_3
    //   166: aload_2
    //   167: ldc_w 729
    //   170: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 699	com/luajava/LuaFunction
    //   176: astore 4
    //   178: aload 4
    //   180: ifnonnull +15 -> 195
    //   183: ldc_w 739
    //   186: aload_3
    //   187: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   190: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   193: pop
    //   194: return
    //   195: aload 4
    //   197: iconst_1
    //   198: anewarray 697	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_3
    //   204: aastore
    //   205: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   208: pop
    //   209: return
    //   210: ldc_w 739
    //   213: aload_3
    //   214: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   217: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: return
    //
    // Exception table:
    //   from	to	target	type
    //   142	164	165	com/luajava/LuaException
    //   195	209	210	com/luajava/LuaException
  }

  public void onDestroy()
  {
    if (a != null)
      a.onDestroy(this);
    stopScreenshot();
    super.onDestroy();
  }

  public void onInterrupt()
  {
    if (a != null)
      a.onInterrupt(this);
  }

  protected boolean onKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((a != null) && (a.onKeyEvent(this, paramKeyEvent)))
      return true;
    return super.onKeyEvent(paramKeyEvent);
  }

  // ERROR //
  protected void onServiceConnected()
  {
    // Byte code:
    //   0: ldc_w 708
    //   3: ldc_w 787
    //   6: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokespecial 789	android/accessibilityservice/AccessibilityService:onServiceConnected	()V
    //   14: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   17: ifnull +12 -> 29
    //   20: getstatic 285	com/androlua/LuaAccessibilityService:a	Lcom/androlua/LuaAccessibilityService$AccessibilityServiceCallbacks;
    //   23: aload_0
    //   24: invokeinterface 791 2 0
    //   29: aload_0
    //   30: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   33: ldc_w 717
    //   36: invokeinterface 722 2 0
    //   41: ifne +4 -> 45
    //   44: return
    //   45: aload_0
    //   46: getfield 715	com/androlua/LuaAccessibilityService:c	Ljava/util/Map;
    //   49: ldc_w 717
    //   52: invokeinterface 723 2 0
    //   57: checkcast 725	com/luajava/LuaTable
    //   60: astore_2
    //   61: aload_2
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: aload_2
    //   67: ldc_w 787
    //   70: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 699	com/luajava/LuaFunction
    //   76: iconst_1
    //   77: anewarray 697	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_0
    //   83: aastore
    //   84: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: return
    //   89: astore_3
    //   90: aload_2
    //   91: ldc_w 729
    //   94: invokevirtual 727	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 699	com/luajava/LuaFunction
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +15 -> 119
    //   107: ldc_w 787
    //   110: aload_3
    //   111: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   114: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: return
    //   119: aload 4
    //   121: iconst_1
    //   122: anewarray 697	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_3
    //   128: aastore
    //   129: invokevirtual 703	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: return
    //   134: ldc_w 787
    //   137: aload_3
    //   138: invokevirtual 732	com/luajava/LuaException:getMessage	()Ljava/lang/String;
    //   141: invokestatic 713	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   144: pop
    //   145: return
    //
    // Exception table:
    //   from	to	target	type
    //   66	88	89	com/luajava/LuaException
    //   119	133	134	com/luajava/LuaException
  }

  public boolean paste()
  {
    ClipboardManager localClipboardManager = (ClipboardManager)getSystemService("clipboard");
    return paste(getFocusView(), localClipboardManager.getText());
  }

  public boolean paste(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return paste(paramAccessibilityNodeInfo, ((ClipboardManager)getSystemService("clipboard")).getText());
  }

  public boolean paste(AccessibilityNodeInfo paramAccessibilityNodeInfo, CharSequence paramCharSequence)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    if (paramCharSequence == null)
      return false;
    if (paramAccessibilityNodeInfo.isEditable())
    {
      if (!paramAccessibilityNodeInfo.isFocused())
        paramAccessibilityNodeInfo.performAction(1);
      ClipboardManager localClipboardManager = (ClipboardManager)getSystemService("clipboard");
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("label", paramCharSequence));
      localClipboardManager.setText(paramCharSequence);
      if (paramAccessibilityNodeInfo.performAction(32768))
        return true;
    }
    return paste(paramCharSequence);
  }

  public boolean paste(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    AccessibilityNodeInfo localAccessibilityNodeInfo = getEditText();
    if (localAccessibilityNodeInfo == null)
      return false;
    if ((getFocusView().isEditable()) && (getFocusView().getText() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getFocusView().getText().toString());
      localStringBuilder.append(paramCharSequence);
      paramCharSequence = localStringBuilder.toString();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", paramCharSequence);
      return localAccessibilityNodeInfo.performAction(2097152, localBundle);
    }
    return false;
  }

  public void postClick(long paramLong, final LuaTable paramLuaTable)
  {
    this.g.postDelayed(new Runnable()
    {
      public void run()
      {
        LuaAccessibilityService.this.click(paramLuaTable);
      }
    }
    , paramLong);
  }

  public void postClick(long paramLong, final LuaTable paramLuaTable, final LuaFunction paramLuaFunction)
  {
    this.g.postDelayed(new Runnable()
    {
      public void run()
      {
        LuaAccessibilityService.this.click(paramLuaTable, paramLuaFunction);
      }
    }
    , paramLong);
  }

  public void postExecute(long paramLong, final String paramString, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.g.postDelayed(new Runnable()
    {
      public void run()
      {
        LuaAccessibilityService.this.execute(paramString, paramAccessibilityNodeInfo);
      }
    }
    , paramLong);
  }

  public void postExecute(long paramLong, final String paramString, final AccessibilityNodeInfo paramAccessibilityNodeInfo, final LuaFunction paramLuaFunction)
  {
    this.g.postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          LuaFunction localLuaFunction = paramLuaFunction;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Boolean.valueOf(LuaAccessibilityService.this.execute(paramString, paramAccessibilityNodeInfo));
          arrayOfObject[1] = paramString;
          arrayOfObject[2] = paramAccessibilityNodeInfo;
          localLuaFunction.call(arrayOfObject);
          return;
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
          LuaAccessibilityService.a(LuaAccessibilityService.this, "postExecute", localLuaException);
        }
      }
    }
    , paramLong);
  }

  public boolean press(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.h != null)
      return this.h.press(paramInt1, paramInt2, paramInt3);
    return false;
  }

  public boolean press(Point paramPoint, int paramInt)
  {
    return press(paramPoint.x, paramPoint.y, paramInt);
  }

  public boolean scrollBackward(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    if (Build.VERSION.SDK_INT < 21)
    {
      if ((0x2000 & paramAccessibilityNodeInfo.getActions()) == 0)
        return false;
    }
    else if (!paramAccessibilityNodeInfo.getActionList().contains(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD))
      return false;
    return paramAccessibilityNodeInfo.performAction(8192);
  }

  public boolean scrollForward(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo == null)
      return false;
    if (Build.VERSION.SDK_INT < 21)
    {
      if ((0x1000 & paramAccessibilityNodeInfo.getActions()) == 0)
        return false;
    }
    else if (!paramAccessibilityNodeInfo.getActionList().contains(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD))
      return false;
    return paramAccessibilityNodeInfo.performAction(4096);
  }

  public boolean setText(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString)
  {
    if ((paramAccessibilityNodeInfo != null) && (paramAccessibilityNodeInfo.isEditable()))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        Bundle localBundle = new Bundle();
        localBundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", paramString);
        return paramAccessibilityNodeInfo.performAction(2097152, localBundle);
      }
      return paste(paramAccessibilityNodeInfo, paramString);
    }
    return false;
  }

  public boolean setText(String paramString)
  {
    return setText(getEditText(), paramString);
  }

  public boolean startApp(String paramString)
  {
    b();
    String str = paramString.toLowerCase();
    ComponentName localComponentName = (ComponentName)this.e.get(str);
    if (localComponentName == null)
      return false;
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setComponent(localComponentName);
    localIntent.setFlags(270532608);
    try
    {
      startActivity(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
    return false;
  }

  public void startScreenshot()
  {
    this.i = new ScreenShot(this, null);
  }

  public void startScreenshot(VirtualDisplay.Callback paramCallback)
  {
    this.i = new ScreenShot(this, paramCallback);
  }

  public void stopScreenshot()
  {
    if (this.i != null)
      this.i.release();
    this.i = null;
  }

  public boolean swipe(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.h != null)
      return this.h.swipe(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    return false;
  }

  public boolean swipe(Path paramPath, int paramInt)
  {
    if (this.h != null)
      return this.h.gesture(0L, paramInt, paramPath);
    return false;
  }

  public boolean swipe(Point paramPoint1, Point paramPoint2, int paramInt)
  {
    return swipe(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, paramInt);
  }

  public void toBack()
  {
    performGlobalAction(1);
  }

  public boolean toClick(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo != null)
      try
      {
        boolean bool = paramAccessibilityNodeInfo.performAction(16);
        return bool;
      }
      catch (Exception localException)
      {
        a.a(localException);
      }
    return false;
  }

  public void toClick2(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    toClick(b(paramAccessibilityNodeInfo));
  }

  public void toHome()
  {
    performGlobalAction(2);
  }

  public boolean toLongClick(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (paramAccessibilityNodeInfo != null)
      try
      {
        boolean bool = paramAccessibilityNodeInfo.performAction(32);
        return bool;
      }
      catch (Exception localException)
      {
        a.a(localException);
      }
    return false;
  }

  public void toNotifications()
  {
    performGlobalAction(4);
  }

  public void toRecents()
  {
    performGlobalAction(3);
  }

  public static abstract interface AccessibilityServiceCallbacks
  {
    public abstract void onAccessibilityEvent(LuaAccessibilityService paramLuaAccessibilityService, AccessibilityEvent paramAccessibilityEvent);

    public abstract void onConfigurationChanged(LuaAccessibilityService paramLuaAccessibilityService, Configuration paramConfiguration);

    public abstract void onCreate(LuaAccessibilityService paramLuaAccessibilityService);

    public abstract void onDestroy(LuaAccessibilityService paramLuaAccessibilityService);

    public abstract void onInterrupt(LuaAccessibilityService paramLuaAccessibilityService);

    public abstract boolean onKeyEvent(LuaAccessibilityService paramLuaAccessibilityService, KeyEvent paramKeyEvent);

    public abstract void onServiceConnected(LuaAccessibilityService paramLuaAccessibilityService);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaAccessibilityService
 * JD-Core Version:    0.6.2
 */