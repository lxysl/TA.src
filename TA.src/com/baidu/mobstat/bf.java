package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

class bf
{
  private static final bf b = new bf();
  private HashSet<String> a = new HashSet();
  private boolean c;
  private boolean d;

  private View.AccessibilityDelegate a(View paramView)
  {
    try
    {
      View.AccessibilityDelegate localAccessibilityDelegate = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
      return localAccessibilityDelegate;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      cz.b("getAccessibilityDelegate threw an exception when called.", localInvocationTargetException);
    }
    catch (NoSuchMethodException|IllegalAccessException localNoSuchMethodException)
    {
    }
    return null;
  }

  public static bf a()
  {
    return b;
  }

  private String a(View paramView, Activity paramActivity)
  {
    String str = "";
    if (paramView == null)
      return str;
    ViewGroup localViewGroup;
    try
    {
      localViewGroup = (ViewGroup)((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290)).getChildAt(0);
    }
    catch (Exception localException)
    {
      localViewGroup = null;
      localArrayList = new ArrayList();
      localArrayList.add(paramView.getClass().getName());
      if ((paramView == null) || (paramView == localViewGroup))
        break label82;
      paramView = (View)paramView.getParent();
      tmpTernaryOp = localException;
    }
    ArrayList localArrayList;
    while (true);
    label82: for (int i = -1 + localArrayList.size(); i >= 0; i--)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localArrayList.get(i));
      localStringBuilder.append("/");
      str = localStringBuilder.toString();
    }
    if (str.endsWith("/"))
      str = str.substring(0, -1 + str.length());
    return str;
  }

  // ERROR //
  private void a(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 71	android/app/Activity:getWindow	()Landroid/view/Window;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_2
    //   11: invokevirtual 77	android/view/Window:getDecorView	()Landroid/view/View;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: aload_3
    //   21: ldc 78
    //   23: invokevirtual 84	android/view/View:findViewById	(I)Landroid/view/View;
    //   26: checkcast 86	android/view/ViewGroup
    //   29: iconst_0
    //   30: invokevirtual 89	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   33: checkcast 86	android/view/ViewGroup
    //   36: astore 4
    //   38: goto +6 -> 44
    //   41: aconst_null
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: aload_1
    //   51: aload 4
    //   53: invokespecial 141	com/baidu/mobstat/bf:a	(Landroid/app/Activity;Landroid/view/ViewGroup;)V
    //   56: return
    //
    // Exception table:
    //   from	to	target	type
    //   20	38	41	java/lang/Exception
  }

  private void a(Activity paramActivity, View paramView)
  {
    if ((paramView instanceof Button))
    {
      String str = ((Button)paramView).getText().toString();
      if (TextUtils.isEmpty(str))
        return;
      a(paramActivity, paramView, str);
    }
  }

  private void a(Activity paramActivity, View paramView, String paramString)
  {
    View.AccessibilityDelegate localAccessibilityDelegate = a(paramView);
    bh localbh = new bh(this, paramActivity, paramView, paramString, localAccessibilityDelegate);
    paramView.setAccessibilityDelegate(localbh);
  }

  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    for (int i = -1 + paramViewGroup.getChildCount(); i >= 0; i--)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
        a(paramActivity, (ViewGroup)localView);
      a(paramActivity, localView);
    }
  }

  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity instanceof IIgnoreAutoTrace))
      return;
    if (paramBoolean)
      bv.a().a(paramActivity);
    if (paramBoolean)
    {
      ch.a().a(paramActivity, System.currentTimeMillis(), true);
      return;
    }
    ch.a().a(paramActivity, System.currentTimeMillis(), true, null);
  }

  @TargetApi(14)
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (this.d)
      return;
    if (Build.VERSION.SDK_INT < 14)
    {
      if (paramBoolean)
        cz.a("module autotrace only support android os version bigger than 4.0");
      return;
    }
    b(paramContext);
    this.d = true;
  }

  private void b(Activity paramActivity, View paramView, String paramString)
  {
    bv.a().a(paramActivity);
    String str1 = paramActivity.getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramView.hashCode());
    String str2 = localStringBuilder.toString();
    synchronized (this.a)
    {
      if (this.a.contains(str2))
        return;
      String str3 = a(paramView, paramActivity);
      int i = Config.EventViewType.BUTTON.getValue();
      bm.a().a(paramActivity.getApplicationContext(), paramString, "", 1, System.currentTimeMillis(), str3, str1, i, true);
      return;
    }
  }

  // ERROR //
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: new 271	com/baidu/mobstat/bg
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 274	com/baidu/mobstat/bg:<init>	(Lcom/baidu/mobstat/bf;)V
    //   8: astore_2
    //   9: aload_1
    //   10: invokevirtual 277	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: checkcast 279	android/app/Application
    //   16: aload_2
    //   17: invokevirtual 283	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   20: return
    //   21: ldc_w 285
    //   24: invokestatic 221	com/baidu/mobstat/cz:a	(Ljava/lang/String;)V
    //   27: return
    //
    // Exception table:
    //   from	to	target	type
    //   9	20	21	java/lang/Exception
  }

  public void a(Context paramContext)
  {
    a(paramContext, false);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bf
 * JD-Core Version:    0.6.2
 */