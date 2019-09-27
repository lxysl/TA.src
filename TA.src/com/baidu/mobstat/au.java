package com.baidu.mobstat;

import android.content.Context;

public class au
{
  private static l a;

  public static l a(Context paramContext)
  {
    try
    {
      bd.a("getBPStretegyController begin");
      Object localObject2 = a;
      if (localObject2 == null)
      {
        try
        {
          Class localClass = ax.a(paramContext, "com.baidu.bottom.remote.BPStretegyController2");
          if (localClass == null)
            break label70;
          aw localaw = new aw(localClass.newInstance());
          try
          {
            bd.a("Get BPStretegyController load remote class v2");
            localObject2 = localaw;
          }
          catch (Exception localException3)
          {
            Exception localException1 = localException3;
            localObject2 = localaw;
          }
        }
        catch (Exception localException2)
        {
        }
        bd.a(localException2);
      }
      label70: if (localObject2 == null)
      {
        localObject2 = new av();
        bd.a("Get BPStretegyController load local class");
      }
      a = (l)localObject2;
      ax.a(paramContext, (l)localObject2);
      bd.a("getBPStretegyController end");
      return localObject2;
    }
    finally
    {
    }
  }

  public static void a()
  {
    try
    {
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.au
 * JD-Core Version:    0.6.2
 */