package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
import java.util.Arrays;

class cc
  implements Runnable
{
  cc(by paramby, Context paramContext)
  {
  }

  public void run()
  {
    try
    {
      File localFile = this.a.getFilesDir();
      if (localFile != null)
      {
        if (!localFile.exists())
          return;
        String[] arrayOfString = localFile.list(new cd(this));
        if (arrayOfString != null)
        {
          int i = arrayOfString.length;
          if (i == 0)
            return;
          try
          {
            Arrays.sort(arrayOfString, new ce(this));
          }
          catch (Exception localException2)
          {
            cz.b(localException2);
          }
          int j = arrayOfString.length;
          int k = 0;
          int m = 0;
          while (k < j)
          {
            String str1 = arrayOfString[k];
            String str2 = cs.a(this.a, str1);
            if (by.a(this.b, this.a, str2))
            {
              cs.b(this.a, str1);
              m = 0;
            }
            else
            {
              m++;
              if (m >= 5)
                return;
            }
            k++;
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      cz.b(localException1);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cc
 * JD-Core Version:    0.6.2
 */