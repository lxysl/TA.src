package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.a.a.a;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

class ch
{
  private static final ch a = new ch();
  private static HashMap<String, cl> n = new HashMap();
  private cm b = new cm();
  private cm c = new cm();
  private cm d = new cm();
  private cm e = new cm();
  private long f = 0L;
  private boolean g = true;
  private boolean h;
  private cf i = new cf();
  private int j = -1;
  private volatile int k;
  private volatile long l;
  private Handler m;

  private ch()
  {
    HandlerThread localHandlerThread = new HandlerThread("SessionAnalysisThread");
    localHandlerThread.start();
    localHandlerThread.setPriority(10);
    this.m = new Handler(localHandlerThread.getLooper());
  }

  static Context a(Object paramObject)
  {
    try
    {
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = new Class[0];
      Object[] arrayOfObject = new Object[0];
      Context localContext = (Context)localClass.getMethod("getActivity", arrayOfClass).invoke(paramObject, arrayOfObject);
      return localContext;
    }
    catch (Throwable localThrowable)
    {
      cz.a(localThrowable.getMessage());
    }
    return null;
  }

  public static ch a()
  {
    return a;
  }

  private void a(String paramString)
  {
    HashMap localHashMap = n;
    if (paramString == null);
    try
    {
      cz.c("page Object is null");
      return;
      cl localcl = new cl(paramString);
      if (!n.containsKey(paramString))
        n.put(paramString, localcl);
      return;
      label49: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label49;
    }
  }

  private void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  private cl b(String paramString)
  {
    synchronized (n)
    {
      if (!n.containsKey(paramString))
        a(paramString);
      cl localcl = (cl)n.get(paramString);
      return localcl;
    }
  }

  private void b(Context paramContext)
  {
    String str1 = this.i.c().toString();
    this.k = str1.getBytes().length;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("cacheString = ");
    localStringBuilder1.append(str1);
    cz.a(localStringBuilder1.toString());
    String str2 = dc.q(paramContext);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str2);
    localStringBuilder2.append("__local_last_session.json");
    cs.a(paramContext, localStringBuilder2.toString(), str1, false);
  }

  private void c(String paramString)
  {
    HashMap localHashMap = n;
    if (paramString == null);
    try
    {
      cz.c("pageName is null");
      return;
      if (n.containsKey(paramString))
        n.remove(paramString);
      return;
      label39: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label39;
    }
  }

  private boolean h()
  {
    return this.g;
  }

  // ERROR //
  private int i()
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 200	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: goto +5 -> 11
    //   9: aconst_null
    //   10: astore_1
    //   11: ldc 202
    //   13: invokestatic 200	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   16: astore_2
    //   17: goto +5 -> 22
    //   20: aconst_null
    //   21: astore_2
    //   22: invokestatic 208	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 212	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   28: astore_3
    //   29: iconst_0
    //   30: istore 4
    //   32: iload 4
    //   34: aload_3
    //   35: arraylength
    //   36: if_icmpge +119 -> 155
    //   39: aload_3
    //   40: iload 4
    //   42: aaload
    //   43: invokevirtual 217	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   46: astore 5
    //   48: aload_3
    //   49: iload 4
    //   51: aaload
    //   52: invokevirtual 220	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 5
    //   59: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +87 -> 149
    //   65: aload 6
    //   67: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +79 -> 149
    //   73: aload 6
    //   75: ldc 228
    //   77: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifne +6 -> 86
    //   83: goto +66 -> 149
    //   86: aload 5
    //   88: invokestatic 200	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   91: astore 7
    //   93: goto +6 -> 99
    //   96: aconst_null
    //   97: astore 7
    //   99: aload 7
    //   101: ifnonnull +6 -> 107
    //   104: goto +45 -> 149
    //   107: ldc 233
    //   109: aload 7
    //   111: invokevirtual 237	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   114: ifeq +5 -> 119
    //   117: iconst_1
    //   118: ireturn
    //   119: aload_1
    //   120: ifnull +14 -> 134
    //   123: aload_1
    //   124: aload 7
    //   126: invokevirtual 237	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   129: ifeq +5 -> 134
    //   132: iconst_2
    //   133: ireturn
    //   134: aload_2
    //   135: ifnull +14 -> 149
    //   138: aload_2
    //   139: aload 7
    //   141: invokevirtual 237	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   144: ifeq +5 -> 149
    //   147: iconst_2
    //   148: ireturn
    //   149: iinc 4 1
    //   152: goto -120 -> 32
    //   155: iconst_3
    //   156: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	9	java/lang/ClassNotFoundException
    //   11	17	20	java/lang/ClassNotFoundException
    //   86	93	96	java/lang/Throwable
  }

  private void j()
  {
    boolean bool = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstResume:");
    localStringBuilder.append(bool);
    cz.a(localStringBuilder.toString());
    if (bool)
    {
      a(false);
      this.m.post(new ck(this));
    }
  }

  public void a(int paramInt)
  {
    this.j = (paramInt * 1000);
  }

  public void a(long paramLong)
  {
    this.i.a(paramLong);
  }

  @TargetApi(11)
  public void a(Fragment paramFragment, long paramLong)
  {
    cz.a("post resume job");
    if (this.d.c)
      cz.c("遗漏StatService.onPause() || missing StatService.onPause()");
    this.d.c = true;
    j();
    co localco = new co(this, this.f, paramLong, this.l, null, null, paramFragment, 2, 3);
    this.m.post(localco);
    this.d.b = new WeakReference(paramFragment);
    this.d.a = paramLong;
  }

  public void a(Context paramContext)
  {
    if (paramContext == null)
    {
      cz.a("clearLastSession context is null, invalid");
      return;
    }
    String str1 = new JSONObject().toString();
    String str2 = dc.q(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append("__local_last_session.json");
    cs.a(paramContext, localStringBuilder.toString(), str1, false);
  }

  public void a(Context paramContext, long paramLong)
  {
    if (this.l == 0L)
    {
      ci localci = new ci(this, paramLong);
      this.m.post(localci);
    }
    this.l = paramLong;
  }

  public void a(Context paramContext, long paramLong, String paramString)
  {
    cz.a("AnalysisPageStart");
    if (TextUtils.isEmpty(paramString))
    {
      cz.c("自定义页面 pageName 为 null");
      return;
    }
    cl localcl = b(paramString);
    if (localcl == null)
    {
      cz.c("get page info, PageInfo null");
      return;
    }
    if (localcl.b)
      cz.c("遗漏StatService.onPageEnd() || missing StatService.onPageEnd()");
    localcl.b = true;
    localcl.c = paramLong;
    j();
    if (!this.h)
    {
      co localco = new co(this, this.f, paramLong, this.l, paramContext, null, null, i(), 1);
      this.m.post(localco);
      this.h = true;
    }
    this.b.b = new WeakReference(paramContext);
    this.b.a = paramLong;
  }

  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
    cz.a("post pause job");
    this.h = false;
    if (TextUtils.isEmpty(paramString2))
    {
      cz.c("自定义页面 pageName 无效值");
      return;
    }
    cl localcl = b(paramString2);
    if (localcl == null)
    {
      cz.c("get page info, PageInfo null");
      return;
    }
    if (!localcl.b)
    {
      cz.c("Please check (1)遗漏StatService.onPageStart() || missing StatService.onPageStart()");
      return;
    }
    localcl.b = false;
    localcl.d = paramLong;
    cn localcn = new cn(this, paramLong, paramContext, null, localcl.c, (Context)this.b.b.get(), null, 1, paramString2, null, null, paramString1, false, paramExtraInfo, localcl);
    this.m.post(localcn);
    c(paramString2);
    this.f = paramLong;
  }

  public void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.c = true;
      this.e.b = new WeakReference(paramContext);
      this.e.a = paramLong;
    }
    cz.a("AnalysisResume job");
    if ((!paramBoolean) && (this.b.c))
      cz.c("遗漏StatService.onPause() || missing StatService.onPause()");
    if (!paramBoolean)
      this.b.c = true;
    j();
    if (!this.h)
    {
      co localco = new co(this, this.f, paramLong, this.l, paramContext, null, null, 1, 1);
      this.m.post(localco);
      this.h = true;
    }
    this.b.b = new WeakReference(paramContext);
    this.b.a = paramLong;
  }

  public void a(Context paramContext, long paramLong, boolean paramBoolean, ExtraInfo paramExtraInfo)
  {
    cz.a("post pause job");
    this.h = false;
    if (paramBoolean)
    {
      this.e.c = false;
      cn localcn2 = new cn(this, paramLong, paramContext, null, this.e.a, (Context)this.e.b.get(), null, 1, null, null, null, null, paramBoolean, paramExtraInfo, null);
      this.m.post(localcn2);
      this.f = paramLong;
      return;
    }
    if (!this.b.c)
    {
      cz.c("遗漏StatService.onResume() || missing StatService.onResume()");
      return;
    }
    this.b.c = false;
    cn localcn1 = new cn(this, paramLong, paramContext, null, this.b.a, (Context)this.b.b.get(), null, 1, null, null, null, null, paramBoolean, paramExtraInfo, null);
    this.m.post(localcn1);
    this.f = paramLong;
  }

  public void a(a parama, long paramLong)
  {
    cz.a("post resume job");
    if (this.c.c)
      cz.c("遗漏StatService.onPause() || missing StatService.onPause()");
    this.c.c = true;
    j();
    co localco = new co(this, this.f, paramLong, this.l, null, parama, null, 2, 2);
    this.m.post(localco);
    this.c.b = new WeakReference(parama);
    this.c.a = paramLong;
  }

  public int b()
  {
    return this.k;
  }

  public void b(int paramInt)
  {
    this.i.b(paramInt);
  }

  public void b(long paramLong)
  {
    this.i.b(paramLong);
  }

  @TargetApi(11)
  public void b(Fragment paramFragment, long paramLong)
  {
    cz.a("post pause job");
    if (!this.d.c)
    {
      cz.c("遗漏android.app.Fragment StatService.onResume() || android.app.Fragment missing StatService.onResume()");
      return;
    }
    this.d.c = false;
    cn localcn = new cn(this, paramLong, null, null, this.d.a, null, null, 3, null, this.d.b.get(), paramFragment, null, false, null, null);
    this.m.post(localcn);
    this.f = paramLong;
  }

  public void b(Context paramContext, long paramLong)
  {
    cj localcj = new cj(this, paramLong, paramContext);
    this.m.post(localcj);
  }

  public void b(a parama, long paramLong)
  {
    cz.a("post pause job");
    if (!this.c.c)
    {
      cz.c("遗漏android.support.v4.app.Fragment StatService.onResume() || android.support.v4.app.Fragment missing StatService.onResume()");
      return;
    }
    this.c.c = false;
    cn localcn = new cn(this, paramLong, null, parama, this.c.a, null, (a)this.c.b.get(), 2, null, null, null, null, false, null, null);
    this.m.post(localcn);
    this.f = paramLong;
  }

  public int c()
  {
    if (this.j == -1)
      this.j = 30000;
    return this.j;
  }

  public void c(int paramInt)
  {
    this.i.a(paramInt);
  }

  public void d()
  {
    b(1 + f());
  }

  public void e()
  {
    this.i.a();
  }

  public int f()
  {
    return this.i.d();
  }

  public long g()
  {
    return this.i.b();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ch
 * JD-Core Version:    0.6.2
 */