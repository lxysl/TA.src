package com.nirenr.screencapture;

import android.graphics.Bitmap;

public abstract interface ScreenCaptureListener
{
  public abstract void onScreenCaptureDone(Bitmap paramBitmap);

  public abstract void onScreenCaptureError(String paramString);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.screencapture.ScreenCaptureListener
 * JD-Core Version:    0.6.2
 */