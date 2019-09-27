package com.baidu.mobstat;

import java.util.HashMap;

class bp
  implements Runnable
{
  bp(bm parambm, long paramLong, String paramString1, String paramString2)
  {
  }

  public void run()
  {
    bv.a().d();
    bs localbs = new bs();
    localbs.c = this.a;
    localbs.a = this.b;
    localbs.b = this.c;
    String str = this.d.a(this.b, this.c);
    if (this.d.a.get(str) != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("EventStat: event_id[");
      localStringBuilder1.append(this.b);
      localStringBuilder1.append("] with label[");
      localStringBuilder1.append(this.c);
      localStringBuilder1.append("] is duplicated, older is removed");
      cz.b(localStringBuilder1.toString());
    }
    this.d.a.put(str, localbs);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("put a keyword[");
    localStringBuilder2.append(str);
    localStringBuilder2.append("] into durationlist");
    cz.a(localStringBuilder2.toString());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bp
 * JD-Core Version:    0.6.2
 */