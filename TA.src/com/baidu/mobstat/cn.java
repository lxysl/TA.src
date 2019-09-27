package com.baidu.mobstat;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.support.a.a.a;
import android.support.v4.app.FragmentActivity;
import java.lang.ref.WeakReference;

class cn
  implements Runnable
{
  private long b;
  private WeakReference<Context> c;
  private WeakReference<a> d;
  private WeakReference<Object> e;
  private long f;
  private WeakReference<Context> g;
  private WeakReference<a> h;
  private WeakReference<Object> i;
  private int j;
  private String k;
  private String l;
  private boolean m;
  private ExtraInfo n;
  private cl o;

  public cn(ch paramch, long paramLong1, Context paramContext1, a parama1, long paramLong2, Context paramContext2, a parama2, int paramInt, String paramString1, Object paramObject1, Object paramObject2, String paramString2, boolean paramBoolean, ExtraInfo paramExtraInfo, cl paramcl)
  {
    this.b = paramLong1;
    this.f = paramLong2;
    this.c = new WeakReference(paramContext1);
    this.g = new WeakReference(paramContext2);
    this.d = new WeakReference(parama1);
    this.h = new WeakReference(parama2);
    this.i = new WeakReference(paramObject1);
    this.e = new WeakReference(paramObject2);
    this.j = paramInt;
    this.k = paramString1;
    this.l = paramString2;
    this.m = paramBoolean;
    this.n = paramExtraInfo;
    this.o = paramcl;
  }

  public void run()
  {
    Object localObject;
    String str10;
    long l3;
    StringBuilder localStringBuilder3;
    long l6;
    String str5;
    if (this.j == 1)
    {
      localObject = (Context)this.c.get();
      Context localContext2 = (Context)this.g.get();
      if ((localObject != null) && (localContext2 != null))
      {
        if (localObject != localContext2)
        {
          if (this.k != null);
          for (String str13 = "onPageStart() or onPageEnd() install error."; ; str13 = "onPause() or onResume() install error.")
          {
            cz.b(str13);
            return;
          }
        }
        str10 = "";
        l3 = this.b - this.f;
        localStringBuilder3 = new StringBuilder();
        if (this.k != null)
        {
          localStringBuilder3.append(this.k);
          if (this.o == null)
            break label271;
          l6 = this.o.d - this.o.c;
          StringBuilder localStringBuilder5 = new StringBuilder();
          localStringBuilder5.append("page time = ");
          localStringBuilder5.append(this.o.a);
          localStringBuilder5.append("; time = ");
          localStringBuilder5.append(l6);
          cz.c(localStringBuilder5.toString());
          if (l6 < 20L)
            str5 = "page time little than 20 mills.";
        }
      }
    }
    label271: label500: label763: Fragment localFragment1;
    label771: String str2;
    long l1;
    Context localContext1;
    while (true)
    {
      cz.c(str5);
      return;
      long l4 = l6;
      if (!(localObject instanceof Activity))
      {
        str5 = "onPause, pause is not a Activity";
      }
      else
      {
        localStringBuilder3.append(((Activity)localObject).getComponentName().getShortClassName());
        if (localStringBuilder3.charAt(0) == '.')
          localStringBuilder3.deleteCharAt(0);
        l4 = l3;
        if ((localObject instanceof Activity))
        {
          CharSequence localCharSequence = ((Activity)localObject).getTitle();
          if (localCharSequence != null)
            str10 = localCharSequence.toString();
        }
        String str11 = str10;
        StringBuilder localStringBuilder4 = new StringBuilder();
        localStringBuilder4.append("new page view, page name = ");
        localStringBuilder4.append(localStringBuilder3.toString());
        localStringBuilder4.append(", stay time = ");
        localStringBuilder4.append(l4);
        localStringBuilder4.append("(ms)");
        cz.a(localStringBuilder4.toString());
        String str12 = localStringBuilder3.toString();
        if (this.k == null)
          this.l = str12;
        cg localcg3 = new cg(str12, str11, this.l, l4, this.f, this.m, this.n);
        ch.a(this.a).a(localcg3);
        cf localcf;
        long l5;
        if (this.k != null)
        {
          if (this.o == null)
            return;
          localcf = ch.a(this.a);
          l5 = this.o.d;
        }
        else
        {
          localcf = ch.a(this.a);
          l5 = this.b;
        }
        localcf.d(l5);
        ch localch = this.a;
        break label763;
        a locala1;
        a locala2;
        do
        {
          str5 = "onPause, WeakReference is already been released";
          break;
          if (this.j != 2)
            break label771;
          locala1 = (a)this.d.get();
          locala2 = (a)this.h.get();
        }
        while ((locala1 == null) || (locala2 == null));
        if (locala1 != locala2);
        Fragment localFragment2;
        do
        {
          str5 = "onPause() or onResume() install error.";
          break;
          String str6 = "";
          FragmentActivity localFragmentActivity = locala1.getActivity();
          if (localFragmentActivity != null)
            str6 = localFragmentActivity.getTitle().toString();
          String str7 = str6;
          long l2 = this.b - this.f;
          String str8 = locala1.getClass().getName();
          String str9 = str8.substring(1 + str8.lastIndexOf("."));
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("Fragment new page view, page name = ");
          localStringBuilder2.append(str8.toString());
          localStringBuilder2.append(", stay time = ");
          localStringBuilder2.append(l2);
          localStringBuilder2.append("(ms)");
          cz.a(localStringBuilder2.toString());
          cg localcg2 = new cg(str9, str7, str9, l2, this.f, this.m, this.n);
          ch.a(this.a).a(localcg2);
          ch.a(this.a).d(this.b);
          localch = this.a;
          localObject = locala1.getActivity();
          ch.a(localch, (Context)localObject);
          return;
          if (this.j != 3)
            return;
          localFragment1 = (Fragment)this.e.get();
          localFragment2 = (Fragment)this.i.get();
          if ((localFragment1 == null) || (localFragment2 == null))
            break label500;
        }
        while (localFragment1 != localFragment2);
        String str1 = "";
        Activity localActivity = localFragment1.getActivity();
        if (localActivity != null)
          str1 = localActivity.getTitle().toString();
        str2 = str1;
        l1 = this.b - this.f;
        localContext1 = ch.a(localFragment1);
        if (localContext1 != null)
          break;
        str5 = "getContxtFromReverse faild.";
      }
    }
    String str3 = localFragment1.getClass().getName();
    String str4 = str3.substring(1 + str3.lastIndexOf("."));
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("android.app.Fragment new page view, page name = ");
    localStringBuilder1.append(str3.toString());
    localStringBuilder1.append("; stay time = ");
    localStringBuilder1.append(l1);
    localStringBuilder1.append("(ms)");
    cz.a(localStringBuilder1.toString());
    cg localcg1 = new cg(str4, str2, str4, l1, this.f, this.m, this.n);
    ch.a(this.a).a(localcg1);
    ch.a(this.a).d(this.b);
    ch.a(this.a, localContext1);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cn
 * JD-Core Version:    0.6.2
 */