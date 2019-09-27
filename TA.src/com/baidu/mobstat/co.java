package com.baidu.mobstat;

import android.content.Context;
import android.support.a.a.a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class co
  implements Runnable
{
  private long b;
  private long c;
  private WeakReference<Context> d;
  private WeakReference<a> e;
  private WeakReference<Object> f;
  private long g;
  private int h;
  private int i = 1;

  public co(ch paramch, long paramLong1, long paramLong2, long paramLong3, Context paramContext, a parama, Object paramObject, int paramInt1, int paramInt2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = new WeakReference(paramContext);
    this.e = new WeakReference(parama);
    this.f = new WeakReference(paramObject);
    this.g = paramLong3;
    this.h = paramInt1;
    this.i = paramInt2;
  }

  public void run()
  {
    int j;
    if (this.c - this.b >= this.a.c())
      j = 1;
    else
      j = 0;
    if ((j != 0) && (this.b > 0L))
    {
      Object localObject1 = (Context)this.d.get();
      a locala = (a)this.e.get();
      Object localObject2 = this.f.get();
      if ((localObject1 != null) || (locala != null) || (localObject2 != null))
      {
        ch.a(this.a).d(this.b);
        String str = ch.a(this.a).c().toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new session:");
        localStringBuilder.append(str);
        cz.a(localStringBuilder.toString());
        DataCore.instance().putSession(str);
        if (this.i == 1);
        while (true)
        {
          DataCore.instance().flush((Context)localObject1);
          break label208;
          if (this.i == 2)
          {
            localObject1 = locala.getActivity();
          }
          else
          {
            if (this.i != 3)
              break;
            localObject1 = ch.a(localObject2);
          }
        }
        localObject1 = null;
        label208: this.a.e();
        this.a.a(this.g);
        this.a.c(this.h);
        if (localObject1 != null)
        {
          this.a.a((Context)localObject1);
          DataCore.instance().saveLogDataToSend((Context)localObject1);
          by.a().a((Context)localObject1);
        }
      }
    }
    else if ((j != 0) && (this.b == 0L))
    {
      this.a.c(this.h);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.co
 * JD-Core Version:    0.6.2
 */