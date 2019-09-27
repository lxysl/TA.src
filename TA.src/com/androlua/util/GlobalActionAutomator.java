package com.androlua.util;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityService.GestureResultCallback;
import android.accessibilityservice.GestureDescription;
import android.accessibilityservice.GestureDescription.Builder;
import android.accessibilityservice.GestureDescription.StrokeDescription;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewConfiguration;

public class GlobalActionAutomator
{
  private AccessibilityService a;
  private ScreenMetrics b;
  private Handler c;

  @TargetApi(24)
  public GlobalActionAutomator(AccessibilityService paramAccessibilityService, Handler paramHandler)
  {
    this.a = paramAccessibilityService;
    this.c = paramHandler;
  }

  private Path a(int[][] paramArrayOfInt)
  {
    Path localPath = new Path();
    localPath.moveTo(b(paramArrayOfInt[0][0]), c(paramArrayOfInt[0][1]));
    for (int i = 1; i < paramArrayOfInt.length; i++)
    {
      int[] arrayOfInt = paramArrayOfInt[i];
      localPath.lineTo(b(arrayOfInt[0]), c(arrayOfInt[1]));
    }
    return localPath;
  }

  private void a()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
      localLooper.quit();
  }

  @TargetApi(16)
  private boolean a(int paramInt)
  {
    if (this.a == null)
      return false;
    return this.a.performGlobalAction(paramInt);
  }

  private boolean a(GestureDescription paramGestureDescription)
  {
    final VolatileDispose localVolatileDispose = new VolatileDispose();
    Log.i("GlobalActionAutomator", "dispatchGesture");
    return this.a.dispatchGesture(paramGestureDescription, new AccessibilityService.GestureResultCallback()
    {
      public void onCancelled(GestureDescription paramAnonymousGestureDescription)
      {
        Log.i("GlobalActionAutomator", "onCancelled");
        localVolatileDispose.setAndNotify(Boolean.valueOf(false));
      }

      public void onCompleted(GestureDescription paramAnonymousGestureDescription)
      {
        Log.i("GlobalActionAutomator", "onCompleted");
        localVolatileDispose.setAndNotify(Boolean.valueOf(true));
      }
    }
    , this.c);
  }

  private int b(int paramInt)
  {
    if (this.b == null)
      return paramInt;
    return this.b.scaleX(paramInt);
  }

  private void b()
  {
    if (Looper.myLooper() == null)
      Looper.prepare();
  }

  private boolean b(GestureDescription paramGestureDescription)
  {
    b();
    final VolatileBox localVolatileBox = new VolatileBox(Boolean.valueOf(false));
    Handler localHandler = new Handler(Looper.myLooper());
    this.a.dispatchGesture(paramGestureDescription, new AccessibilityService.GestureResultCallback()
    {
      public void onCancelled(GestureDescription paramAnonymousGestureDescription)
      {
        localVolatileBox.set(Boolean.valueOf(false));
        GlobalActionAutomator.a(GlobalActionAutomator.this);
      }

      public void onCompleted(GestureDescription paramAnonymousGestureDescription)
      {
        localVolatileBox.set(Boolean.valueOf(true));
        GlobalActionAutomator.a(GlobalActionAutomator.this);
      }
    }
    , localHandler);
    Looper.loop();
    return ((Boolean)localVolatileBox.get()).booleanValue();
  }

  private int c(int paramInt)
  {
    if (this.b == null)
      return paramInt;
    return this.b.scaleY(paramInt);
  }

  public boolean back()
  {
    return a(1);
  }

  public boolean click(int paramInt1, int paramInt2)
  {
    return press(paramInt1, paramInt2, ViewConfiguration.getTapTimeout());
  }

  public boolean gesture(long paramLong1, long paramLong2, Path paramPath)
  {
    GestureDescription.StrokeDescription[] arrayOfStrokeDescription = new GestureDescription.StrokeDescription[1];
    GestureDescription.StrokeDescription localStrokeDescription = new GestureDescription.StrokeDescription(paramPath, paramLong1, paramLong2);
    arrayOfStrokeDescription[0] = localStrokeDescription;
    return gestures(arrayOfStrokeDescription);
  }

  public boolean gesture(long paramLong1, long paramLong2, int[][] paramArrayOfInt)
  {
    Path localPath = a(paramArrayOfInt);
    GestureDescription.StrokeDescription[] arrayOfStrokeDescription = new GestureDescription.StrokeDescription[1];
    GestureDescription.StrokeDescription localStrokeDescription = new GestureDescription.StrokeDescription(localPath, paramLong1, paramLong2);
    arrayOfStrokeDescription[0] = localStrokeDescription;
    return gestures(arrayOfStrokeDescription);
  }

  public void gestureAsync(long paramLong1, long paramLong2, int[][] paramArrayOfInt)
  {
    Path localPath = a(paramArrayOfInt);
    GestureDescription.StrokeDescription[] arrayOfStrokeDescription = new GestureDescription.StrokeDescription[1];
    GestureDescription.StrokeDescription localStrokeDescription = new GestureDescription.StrokeDescription(localPath, paramLong1, paramLong2);
    arrayOfStrokeDescription[0] = localStrokeDescription;
    gesturesAsync(arrayOfStrokeDescription);
  }

  public boolean gestures(GestureDescription.StrokeDescription[] paramArrayOfStrokeDescription)
  {
    AccessibilityService localAccessibilityService = this.a;
    int i = 0;
    if (localAccessibilityService == null)
      return false;
    GestureDescription.Builder localBuilder = new GestureDescription.Builder();
    int j = paramArrayOfStrokeDescription.length;
    while (i < j)
    {
      localBuilder.addStroke(paramArrayOfStrokeDescription[i]);
      i++;
    }
    if (this.c == null)
      return b(localBuilder.build());
    return a(localBuilder.build());
  }

  public void gesturesAsync(GestureDescription.StrokeDescription[] paramArrayOfStrokeDescription)
  {
    if (this.a == null)
      return;
    GestureDescription.Builder localBuilder = new GestureDescription.Builder();
    int i = paramArrayOfStrokeDescription.length;
    for (int j = 0; j < i; j++)
      localBuilder.addStroke(paramArrayOfStrokeDescription[j]);
    this.a.dispatchGesture(localBuilder.build(), null, null);
  }

  public boolean home()
  {
    return a(2);
  }

  public boolean longClick(int paramInt1, int paramInt2)
  {
    return gesture(0L, 200 + ViewConfiguration.getLongPressTimeout(), new int[][] { { paramInt1, paramInt2 } });
  }

  public boolean notifications()
  {
    return a(4);
  }

  public boolean powerDialog()
  {
    return a(6);
  }

  public boolean press(int paramInt1, int paramInt2, int paramInt3)
  {
    return gesture(0L, paramInt3, new int[][] { { paramInt1, paramInt2 } });
  }

  public boolean quickSettings()
  {
    return a(5);
  }

  public boolean recents()
  {
    return a(3);
  }

  public void setScreenMetrics(ScreenMetrics paramScreenMetrics)
  {
    this.b = paramScreenMetrics;
  }

  public void setService(AccessibilityService paramAccessibilityService)
  {
    this.a = paramAccessibilityService;
  }

  public boolean splitScreen()
  {
    return a(7);
  }

  public boolean swipe(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return gesture(0L, paramInt5, new int[][] { { paramInt1, paramInt2 }, { paramInt3, paramInt4 } });
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.GlobalActionAutomator
 * JD-Core Version:    0.6.2
 */