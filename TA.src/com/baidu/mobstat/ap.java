package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;

 enum ap
{
  ap(int arg3)
  {
    super(paramInt, i, j, null);
  }

  public void a(Context paramContext)
  {
    if (!au.a(paramContext).b(paramContext))
      return;
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.baidu.bottom.service.BottomService"));
      localIntent.putExtra("SDK_PRODUCT_LY", "MS");
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      cz.b(localThrowable);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ap
 * JD-Core Version:    0.6.2
 */