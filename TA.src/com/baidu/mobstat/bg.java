package com.baidu.mobstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

class bg
  implements Application.ActivityLifecycleCallbacks
{
  bg(bf parambf)
  {
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
  }

  public void onActivityPaused(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    ch.a().b(localContext, System.currentTimeMillis());
    if (bf.a(this.a))
      bf.a(this.a, paramActivity, false);
  }

  public void onActivityResumed(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    ch.a().a(localContext, System.currentTimeMillis());
    if (bf.a(this.a))
    {
      bf.a(this.a, paramActivity, true);
      bf.a(this.a, paramActivity);
    }
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityStarted(Activity paramActivity)
  {
  }

  public void onActivityStopped(Activity paramActivity)
  {
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bg
 * JD-Core Version:    0.6.2
 */