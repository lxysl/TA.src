package com.baidu.mobstat;

import android.system.ErrnoException;
import android.system.Os;

class k
{
  static boolean a(String paramString, int paramInt)
  {
    try
    {
      Os.chmod(paramString, paramInt);
      return true;
    }
    catch (ErrnoException localErrnoException)
    {
      g.a(localErrnoException);
    }
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.k
 * JD-Core Version:    0.6.2
 */