package com.nirenr.screencapture;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.a.a.a.a.a;

@TargetApi(21)
public class ScreenCaptureActivity extends Activity
{
  public static final int REQUEST_MEDIA_PROJECTION = 18;
  private TextView a;

  public void finish()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      finishAndRemoveTask();
      return;
    }
    super.finish();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 18)
      ScreenShot.setResultData(null);
    else if ((paramInt2 == -1) && (paramIntent != null))
      ScreenShot.setResultData(paramIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new TextView(this);
    this.a.setText("请授予权限");
    setContentView(this.a);
    requesturePermission();
  }

  public void requesturePermission()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      Toast.makeText(this, "仅支持安卓5以上系统", 0).show();
      return;
    }
    try
    {
      startActivityForResult(((MediaProjectionManager)getSystemService("media_projection")).createScreenCaptureIntent(), 18);
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
      ScreenShot.setResultData(null);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.screencapture.ScreenCaptureActivity
 * JD-Core Version:    0.6.2
 */