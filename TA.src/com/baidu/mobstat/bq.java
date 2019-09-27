package com.baidu.mobstat;

import android.content.Context;
import java.util.HashMap;

class bq
  implements Runnable
{
  bq(bm parambm, String paramString1, String paramString2, long paramLong, Context paramContext, ExtraInfo paramExtraInfo)
  {
  }

  public void run()
  {
    bv.a().d();
    String str = this.f.a(this.a, this.b);
    bs localbs = (bs)this.f.a.get(str);
    if (localbs == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventStat: event_id[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] with label[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] is not started or alread done.");
      cz.b(localStringBuilder.toString());
      return;
    }
    if ((this.a.equals(localbs.a)) && (this.b.equals(localbs.b)))
    {
      this.f.a.remove(str);
      long l = this.c - localbs.c;
      if (l <= 0L)
      {
        cz.a("EventStat: Wrong Case, Duration must be positive");
        return;
      }
      this.f.a(this.d, this.a, this.b, 1, localbs.c, l, this.e);
      return;
    }
    cz.a("EventStat: Wrong Case, eventId/label pair not match");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bq
 * JD-Core Version:    0.6.2
 */