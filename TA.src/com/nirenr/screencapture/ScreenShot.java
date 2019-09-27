package com.nirenr.screencapture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplay.Callback;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.a.a.a.a.a.a.a;
import com.androlua.LuaAccessibilityService;
import java.nio.ByteBuffer;

@TargetApi(21)
public class ScreenShot
{
  private static LuaAccessibilityService a;
  public static String appName = "";
  private static ScreenCaptureListener b;
  private static Intent c;
  private static ScreenShot h;
  public static Bitmap mScreenCaptureBitmap;
  private final Context d;
  private final VirtualDisplay.Callback e;
  private ScreenCaptureListener f;
  private Image g;
  private MediaProjection i;
  private VirtualDisplay j;
  private ImageReader k;
  private int l;
  private int m;
  private int n;

  public ScreenShot(Context paramContext, VirtualDisplay.Callback paramCallback)
  {
    this.d = paramContext;
    this.e = paramCallback;
    c();
    if (c == null)
    {
      Intent localIntent = new Intent(this.d, ScreenCaptureActivity.class);
      localIntent.setFlags(268435456);
      this.d.startActivity(localIntent);
      return;
    }
    startVirtual();
  }

  private void c()
  {
    WindowManager localWindowManager = (WindowManager)this.d.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    this.n = localDisplayMetrics.densityDpi;
    this.l = localDisplayMetrics.widthPixels;
    this.m = localDisplayMetrics.heightPixels;
    d();
  }

  private void d()
  {
    this.k = ImageReader.newInstance(this.l, this.m, 1, 1);
  }

  private MediaProjectionManager e()
  {
    return (MediaProjectionManager)this.d.getSystemService("media_projection");
  }

  private void f()
  {
    if (this.i == null)
      setUpMediaProjection();
    if (this.i == null)
      return;
    if (this.j != null)
      return;
    try
    {
      this.j = this.i.createVirtualDisplay("screen-mirror", this.l, this.m, this.n, 16, this.k.getSurface(), this.e, null);
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }

  private void g()
  {
    if (this.g != null)
      return;
    this.g = this.k.acquireLatestImage();
    if (this.g == null)
    {
      if (this.f != null)
      {
        this.f.onScreenCaptureDone(null);
        this.f = null;
      }
    }
    else
    {
      SaveTask localSaveTask = new SaveTask();
      Image[] arrayOfImage = new Image[1];
      arrayOfImage[0] = this.g;
      localSaveTask.execute(arrayOfImage);
    }
  }

  public static void getResultData(LuaAccessibilityService paramLuaAccessibilityService)
  {
    if (paramLuaAccessibilityService == null)
      return;
    if (c == null)
    {
      Intent localIntent = new Intent(paramLuaAccessibilityService, ScreenCaptureActivity.class);
      localIntent.setFlags(268435456);
      paramLuaAccessibilityService.startActivity(localIntent);
    }
  }

  // ERROR //
  public static void getScreenCaptureBitmap(LuaAccessibilityService paramLuaAccessibilityService, ScreenCaptureListener paramScreenCaptureListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: putstatic 79	com/nirenr/screencapture/ScreenShot:a	Lcom/androlua/LuaAccessibilityService;
    //   9: aload_1
    //   10: putstatic 88	com/nirenr/screencapture/ScreenShot:b	Lcom/nirenr/screencapture/ScreenCaptureListener;
    //   13: getstatic 52	com/nirenr/screencapture/ScreenShot:c	Landroid/content/Intent;
    //   16: ifnonnull +41 -> 57
    //   19: new 54	android/content/Intent
    //   22: dup
    //   23: aload_0
    //   24: ldc 56
    //   26: invokespecial 59	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   29: astore 9
    //   31: aload 9
    //   33: ldc 60
    //   35: invokevirtual 64	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   38: pop
    //   39: aload_0
    //   40: aload 9
    //   42: invokevirtual 191	com/androlua/LuaAccessibilityService:startActivity	(Landroid/content/Intent;)V
    //   45: aconst_null
    //   46: astore 11
    //   48: aconst_null
    //   49: astore 5
    //   51: aconst_null
    //   52: astore 4
    //   54: goto +332 -> 386
    //   57: aload_0
    //   58: ldc 91
    //   60: invokevirtual 196	com/androlua/LuaAccessibilityService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   63: checkcast 97	android/view/WindowManager
    //   66: astore 12
    //   68: new 99	android/util/DisplayMetrics
    //   71: dup
    //   72: invokespecial 100	android/util/DisplayMetrics:<init>	()V
    //   75: astore 13
    //   77: aload 12
    //   79: ifnull +39 -> 118
    //   82: aload 12
    //   84: invokeinterface 104 1 0
    //   89: aload 13
    //   91: invokevirtual 110	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   94: aload 13
    //   96: getfield 113	android/util/DisplayMetrics:densityDpi	I
    //   99: istore 14
    //   101: aload 13
    //   103: getfield 118	android/util/DisplayMetrics:widthPixels	I
    //   106: istore 15
    //   108: aload 13
    //   110: getfield 123	android/util/DisplayMetrics:heightPixels	I
    //   113: istore 16
    //   115: goto +21 -> 136
    //   118: aload_0
    //   119: invokevirtual 200	com/androlua/LuaAccessibilityService:getHeight	()I
    //   122: istore 16
    //   124: aload_0
    //   125: invokevirtual 203	com/androlua/LuaAccessibilityService:getWidth	()I
    //   128: istore 15
    //   130: aload_0
    //   131: invokevirtual 206	com/androlua/LuaAccessibilityService:getDensity	()I
    //   134: istore 14
    //   136: iload 14
    //   138: istore 17
    //   140: iload 16
    //   142: istore 18
    //   144: iload 15
    //   146: istore 19
    //   148: iload 19
    //   150: iload 18
    //   152: iconst_1
    //   153: iconst_1
    //   154: invokestatic 133	android/media/ImageReader:newInstance	(IIII)Landroid/media/ImageReader;
    //   157: astore 5
    //   159: aload_0
    //   160: ldc 138
    //   162: invokevirtual 196	com/androlua/LuaAccessibilityService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   165: checkcast 140	android/media/projection/MediaProjectionManager
    //   168: iconst_m1
    //   169: getstatic 52	com/nirenr/screencapture/ScreenShot:c	Landroid/content/Intent;
    //   172: invokevirtual 210	android/media/projection/MediaProjectionManager:getMediaProjection	(ILandroid/content/Intent;)Landroid/media/projection/MediaProjection;
    //   175: astore 4
    //   177: aload 5
    //   179: invokevirtual 155	android/media/ImageReader:getSurface	()Landroid/view/Surface;
    //   182: astore 22
    //   184: aload 4
    //   186: ldc 151
    //   188: iload 19
    //   190: iload 18
    //   192: iload 17
    //   194: bipush 16
    //   196: aload 22
    //   198: aconst_null
    //   199: aconst_null
    //   200: invokevirtual 161	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   203: astore 6
    //   205: aload 5
    //   207: invokevirtual 170	android/media/ImageReader:acquireLatestImage	()Landroid/media/Image;
    //   210: astore 23
    //   212: aload 23
    //   214: astore 24
    //   216: iconst_0
    //   217: istore 25
    //   219: iload 25
    //   221: bipush 40
    //   223: if_icmpge +34 -> 257
    //   226: ldc2_w 211
    //   229: invokestatic 218	java/lang/Thread:sleep	(J)V
    //   232: goto +10 -> 242
    //   235: astore 33
    //   237: aload 33
    //   239: invokestatic 166	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   242: aload 5
    //   244: invokevirtual 170	android/media/ImageReader:acquireLatestImage	()Landroid/media/Image;
    //   247: astore 24
    //   249: aload 24
    //   251: ifnull +329 -> 580
    //   254: goto +3 -> 257
    //   257: aload 24
    //   259: ifnonnull +14 -> 273
    //   262: aload_1
    //   263: ldc 220
    //   265: invokeinterface 224 2 0
    //   270: goto +104 -> 374
    //   273: aload 24
    //   275: invokevirtual 225	android/media/Image:getWidth	()I
    //   278: istore 26
    //   280: aload 24
    //   282: invokevirtual 226	android/media/Image:getHeight	()I
    //   285: istore 27
    //   287: aload 24
    //   289: invokevirtual 230	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   292: astore 28
    //   294: aload 28
    //   296: iconst_0
    //   297: aaload
    //   298: invokevirtual 236	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   301: astore 29
    //   303: aload 28
    //   305: iconst_0
    //   306: aaload
    //   307: invokevirtual 239	android/media/Image$Plane:getPixelStride	()I
    //   310: istore 30
    //   312: iload 26
    //   314: aload 28
    //   316: iconst_0
    //   317: aaload
    //   318: invokevirtual 242	android/media/Image$Plane:getRowStride	()I
    //   321: iload 30
    //   323: iload 26
    //   325: imul
    //   326: isub
    //   327: iload 30
    //   329: idiv
    //   330: iadd
    //   331: iload 27
    //   333: getstatic 248	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   336: invokestatic 254	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   339: astore 31
    //   341: aload 31
    //   343: aload 29
    //   345: invokevirtual 258	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   348: aload 31
    //   350: iconst_0
    //   351: iconst_0
    //   352: iload 26
    //   354: iload 27
    //   356: invokestatic 261	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   359: astore 32
    //   361: aload 24
    //   363: invokevirtual 264	android/media/Image:close	()V
    //   366: aload_1
    //   367: aload 32
    //   369: invokeinterface 176 2 0
    //   374: aconst_null
    //   375: putstatic 79	com/nirenr/screencapture/ScreenShot:a	Lcom/androlua/LuaAccessibilityService;
    //   378: aconst_null
    //   379: putstatic 88	com/nirenr/screencapture/ScreenShot:b	Lcom/nirenr/screencapture/ScreenCaptureListener;
    //   382: aload 6
    //   384: astore 11
    //   386: aload 11
    //   388: ifnull +8 -> 396
    //   391: aload 11
    //   393: invokevirtual 269	android/hardware/display/VirtualDisplay:release	()V
    //   396: aload 5
    //   398: ifnull +8 -> 406
    //   401: aload 5
    //   403: invokevirtual 270	android/media/ImageReader:close	()V
    //   406: aload 4
    //   408: ifnull +136 -> 544
    //   411: goto +128 -> 539
    //   414: astore_3
    //   415: goto +77 -> 492
    //   418: astore 7
    //   420: aconst_null
    //   421: astore 6
    //   423: goto +124 -> 547
    //   426: astore_3
    //   427: aconst_null
    //   428: astore 6
    //   430: goto +62 -> 492
    //   433: astore 21
    //   435: aload 21
    //   437: astore 7
    //   439: aconst_null
    //   440: astore 6
    //   442: aconst_null
    //   443: astore 4
    //   445: goto +102 -> 547
    //   448: astore 20
    //   450: aload 20
    //   452: astore_3
    //   453: aconst_null
    //   454: astore 6
    //   456: aconst_null
    //   457: astore 4
    //   459: goto +33 -> 492
    //   462: astore 8
    //   464: aload 8
    //   466: astore 7
    //   468: aconst_null
    //   469: astore 5
    //   471: aconst_null
    //   472: astore 6
    //   474: aconst_null
    //   475: astore 4
    //   477: goto +70 -> 547
    //   480: astore_2
    //   481: aload_2
    //   482: astore_3
    //   483: aconst_null
    //   484: astore 4
    //   486: aconst_null
    //   487: astore 5
    //   489: aconst_null
    //   490: astore 6
    //   492: aload_3
    //   493: invokestatic 166	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   496: getstatic 88	com/nirenr/screencapture/ScreenShot:b	Lcom/nirenr/screencapture/ScreenCaptureListener;
    //   499: ldc 220
    //   501: invokeinterface 224 2 0
    //   506: aconst_null
    //   507: putstatic 79	com/nirenr/screencapture/ScreenShot:a	Lcom/androlua/LuaAccessibilityService;
    //   510: aconst_null
    //   511: putstatic 88	com/nirenr/screencapture/ScreenShot:b	Lcom/nirenr/screencapture/ScreenCaptureListener;
    //   514: aload 6
    //   516: ifnull +8 -> 524
    //   519: aload 6
    //   521: invokevirtual 269	android/hardware/display/VirtualDisplay:release	()V
    //   524: aload 5
    //   526: ifnull +8 -> 534
    //   529: aload 5
    //   531: invokevirtual 270	android/media/ImageReader:close	()V
    //   534: aload 4
    //   536: ifnull +8 -> 544
    //   539: aload 4
    //   541: invokevirtual 273	android/media/projection/MediaProjection:stop	()V
    //   544: return
    //   545: astore 7
    //   547: aload 6
    //   549: ifnull +8 -> 557
    //   552: aload 6
    //   554: invokevirtual 269	android/hardware/display/VirtualDisplay:release	()V
    //   557: aload 5
    //   559: ifnull +8 -> 567
    //   562: aload 5
    //   564: invokevirtual 270	android/media/ImageReader:close	()V
    //   567: aload 4
    //   569: ifnull +8 -> 577
    //   572: aload 4
    //   574: invokevirtual 273	android/media/projection/MediaProjection:stop	()V
    //   577: aload 7
    //   579: athrow
    //   580: iinc 25 1
    //   583: goto -364 -> 219
    //
    // Exception table:
    //   from	to	target	type
    //   226	232	235	java/lang/InterruptedException
    //   205	212	414	java/lang/Exception
    //   226	232	414	java/lang/Exception
    //   237	242	414	java/lang/Exception
    //   242	249	414	java/lang/Exception
    //   262	270	414	java/lang/Exception
    //   273	374	414	java/lang/Exception
    //   374	382	414	java/lang/Exception
    //   177	205	418	finally
    //   177	205	426	java/lang/Exception
    //   159	177	433	finally
    //   159	177	448	java/lang/Exception
    //   13	45	462	finally
    //   57	77	462	finally
    //   82	115	462	finally
    //   118	136	462	finally
    //   148	159	462	finally
    //   13	45	480	java/lang/Exception
    //   57	77	480	java/lang/Exception
    //   82	115	480	java/lang/Exception
    //   118	136	480	java/lang/Exception
    //   148	159	480	java/lang/Exception
    //   205	212	545	finally
    //   226	232	545	finally
    //   237	242	545	finally
    //   242	249	545	finally
    //   262	270	545	finally
    //   273	374	545	finally
    //   374	382	545	finally
    //   492	514	545	finally
  }

  private Bitmap h()
  {
    if (this.k == null)
      return null;
    this.g = this.k.acquireLatestImage();
    if (this.g == null)
      return null;
    int i1 = this.g.getWidth();
    int i2 = this.g.getHeight();
    Image.Plane[] arrayOfPlane = this.g.getPlanes();
    ByteBuffer localByteBuffer = arrayOfPlane[0].getBuffer();
    int i3 = arrayOfPlane[0].getPixelStride();
    Bitmap localBitmap1 = Bitmap.createBitmap(i1 + (arrayOfPlane[0].getRowStride() - i3 * i1) / i3, i2, Bitmap.Config.ARGB_8888);
    localBitmap1.copyPixelsFromBuffer(localByteBuffer);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i1, i2);
    this.g.close();
    this.g = null;
    return localBitmap2;
  }

  private void i()
  {
    if (this.i != null)
    {
      this.i.stop();
      this.i = null;
    }
  }

  private void j()
  {
    if (this.j == null)
      return;
    this.j.release();
    this.j = null;
  }

  private void k()
  {
    if (this.k != null)
      this.k.close();
    this.k = null;
  }

  public static void setResultData(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (a != null)
        Toast.makeText(a, "未获得权限", 0).show();
      if (b != null)
        b.onScreenCaptureError("未获得权限");
      return;
    }
    c = paramIntent;
    if (a != null)
      a.getHandler().postDelayed(new Runnable()
      {
        public void run()
        {
          ScreenShot.getScreenCaptureBitmap(ScreenShot.a(), ScreenShot.b());
        }
      }
      , 500L);
  }

  public Bitmap getScreenShot()
  {
    return h();
  }

  public void reSize()
  {
    j();
    k();
    c();
    startVirtual();
  }

  public void release()
  {
    j();
    i();
    k();
    h = null;
  }

  public void setScreenCaptureBitmap(Bitmap paramBitmap)
  {
    mScreenCaptureBitmap = paramBitmap;
  }

  public void setUpMediaProjection()
  {
    if (this.i != null)
      return;
    if (c == null)
    {
      Intent localIntent = new Intent(this.d, ScreenCaptureActivity.class);
      localIntent.setFlags(268435456);
      this.d.startActivity(localIntent);
      return;
    }
    this.i = e().getMediaProjection(-1, c);
  }

  public void startScreenShot()
  {
    Handler localHandler = new Handler();
    localHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        ScreenShot.this.startVirtual();
      }
    }
    , 5L);
    localHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        ScreenShot.a(ScreenShot.this);
      }
    }
    , 100L);
  }

  public void startScreenShot(ScreenCaptureListener paramScreenCaptureListener)
  {
    if (this.f != null)
      return;
    this.f = paramScreenCaptureListener;
    startScreenShot();
  }

  public void startVirtual()
  {
    if (this.i != null);
    while (true)
    {
      f();
      return;
      setUpMediaProjection();
    }
  }

  public class SaveTask extends AsyncTask<Image, Void, Bitmap>
  {
    public SaveTask()
    {
    }

    protected Bitmap a(Image[] paramArrayOfImage)
    {
      if ((paramArrayOfImage != null) && (paramArrayOfImage.length >= 1))
      {
        if (paramArrayOfImage[0] == null)
          return null;
        Image localImage = paramArrayOfImage[0];
        int i = localImage.getWidth();
        int j = localImage.getHeight();
        Image.Plane[] arrayOfPlane = localImage.getPlanes();
        ByteBuffer localByteBuffer = arrayOfPlane[0].getBuffer();
        int k = arrayOfPlane[0].getPixelStride();
        Bitmap localBitmap1 = Bitmap.createBitmap(i + (arrayOfPlane[0].getRowStride() - k * i) / k, j, Bitmap.Config.ARGB_8888);
        localBitmap1.copyPixelsFromBuffer(localByteBuffer);
        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j);
        localImage.close();
        ScreenShot.a(ScreenShot.this, null);
        if (ScreenShot.b(ScreenShot.this) != null)
        {
          ScreenShot.b(ScreenShot.this).onScreenCaptureDone(localBitmap2);
          ScreenShot.a(ScreenShot.this, null);
        }
      }
      return null;
    }

    protected void a(Bitmap paramBitmap)
    {
      super.onPostExecute(paramBitmap);
      if (paramBitmap != null)
      {
        ScreenShot.this.setScreenCaptureBitmap(paramBitmap);
        Log.e("ryze", "获取图片成功");
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.screencapture.ScreenShot
 * JD-Core Version:    0.6.2
 */