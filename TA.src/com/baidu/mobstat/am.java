package com.baidu.mobstat;

import android.content.Context;

class am
  implements Runnable
{
  am(al paramal, String paramString, Context paramContext)
  {
  }

  public void run()
  {
    try
    {
      al.a(this.c, this.a);
      if (this.b == null)
        return;
      Context localContext = this.b.getApplicationContext();
      al.a(this.c, localContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      bd.b(localThrowable);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.am
 * JD-Core Version:    0.6.2
 */