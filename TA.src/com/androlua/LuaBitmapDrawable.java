package com.androlua;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.a.a.a.a.a.a.a;
import com.androlua.util.AsyncTaskX;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LuaBitmapDrawable extends Drawable
  implements LuaGcable, Runnable
{
  public static final int CENTER = 5;
  public static final int CENTER_CROP = 6;
  public static final int CENTER_INSIDE = 7;
  public static final int FIT_CENTER = 3;
  public static final int FIT_END = 4;
  public static final int FIT_START = 2;
  public static final int FIT_XY = 1;
  public static final int MATRIX = 0;
  private static long q = 604800000L;
  private LuaContext a;
  private int b;
  private long c;
  private int d;
  private Movie e;
  private LoadingDrawable f;
  private Drawable g;
  private NineBitmapDrawable h;
  private ColorFilter i;
  private int j;
  private int k = 1;
  private GifDecoder l;
  private GifDecoder m;
  private GifDecoder.GifFrame n;
  private int o;
  private boolean p;

  public LuaBitmapDrawable(LuaContext paramLuaContext, String paramString)
  {
    this.a = paramLuaContext;
    this.f = new LoadingDrawable(paramLuaContext.getContext());
    if ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https://")))
    {
      if (!paramString.startsWith("/"))
        paramString = paramLuaContext.getLuaPath(paramString);
      a(paramString);
      return;
    }
    a(paramLuaContext, paramString);
  }

  public LuaBitmapDrawable(LuaContext paramLuaContext, String paramString, Drawable paramDrawable)
  {
    this(paramLuaContext, paramString);
    this.g = paramDrawable;
  }

  private void a(final LuaContext paramLuaContext, final String paramString)
  {
    new AsyncTaskX()
    {
      protected String a(String[] paramAnonymousArrayOfString)
      {
        try
        {
          String str = LuaBitmapDrawable.getHttpBitmap(paramLuaContext, paramString);
          return str;
        }
        catch (Exception localException)
        {
          a.a(localException);
        }
        return "";
      }

      protected void a(String paramAnonymousString)
      {
        LuaBitmapDrawable.a(LuaBitmapDrawable.this, paramAnonymousString);
      }
    }
    .execute(new String[0]);
  }

  private void a(final String paramString)
  {
    try
    {
      this.l = new GifDecoder(new FileInputStream(paramString), new GifDecoder.GifAction()
      {
        public void parseOk(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          if ((!paramAnonymousBoolean) && (paramAnonymousInt < 0))
          {
            LuaBitmapDrawable.b(LuaBitmapDrawable.this, paramString);
            return;
          }
          if ((paramAnonymousBoolean) && (LuaBitmapDrawable.a(LuaBitmapDrawable.this) == null) && (LuaBitmapDrawable.b(LuaBitmapDrawable.this).getFrameCount() > 1))
            LuaBitmapDrawable.a(LuaBitmapDrawable.this, LuaBitmapDrawable.b(LuaBitmapDrawable.this));
        }
      });
      this.l.start();
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
      b(paramString);
    }
  }

  // ERROR //
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 152	java/lang/String:isEmpty	()Z
    //   4: ifeq +30 -> 34
    //   7: new 154	android/os/Handler
    //   10: dup
    //   11: invokespecial 155	android/os/Handler:<init>	()V
    //   14: new 157	com/androlua/LuaBitmapDrawable$3
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 160	com/androlua/LuaBitmapDrawable$3:<init>	(Lcom/androlua/LuaBitmapDrawable;)V
    //   22: ldc2_w 161
    //   25: invokevirtual 166	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   28: pop
    //   29: aload_0
    //   30: invokevirtual 169	com/androlua/LuaBitmapDrawable:invalidateSelf	()V
    //   33: return
    //   34: aload_0
    //   35: getfield 171	com/androlua/LuaBitmapDrawable:e	Landroid/graphics/Movie;
    //   38: ifnull +31 -> 69
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 171	com/androlua/LuaBitmapDrawable:e	Landroid/graphics/Movie;
    //   46: invokevirtual 177	android/graphics/Movie:duration	()I
    //   49: putfield 179	com/androlua/LuaBitmapDrawable:b	I
    //   52: aload_0
    //   53: getfield 179	com/androlua/LuaBitmapDrawable:b	I
    //   56: ifne +55 -> 111
    //   59: aload_0
    //   60: sipush 1000
    //   63: putfield 179	com/androlua/LuaBitmapDrawable:b	I
    //   66: goto +45 -> 111
    //   69: aload_0
    //   70: new 181	com/androlua/NineBitmapDrawable
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 182	com/androlua/NineBitmapDrawable:<init>	(Ljava/lang/String;)V
    //   78: putfield 184	com/androlua/LuaBitmapDrawable:h	Lcom/androlua/NineBitmapDrawable;
    //   81: goto +30 -> 111
    //   84: aload_0
    //   85: new 186	android/graphics/drawable/BitmapDrawable
    //   88: dup
    //   89: aload_0
    //   90: getfield 64	com/androlua/LuaBitmapDrawable:a	Lcom/androlua/LuaContext;
    //   93: aload_1
    //   94: invokestatic 192	com/androlua/LuaBitmap:getLocalBitmap	(Lcom/androlua/LuaContext;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   97: invokespecial 195	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   100: putfield 107	com/androlua/LuaBitmapDrawable:g	Landroid/graphics/drawable/Drawable;
    //   103: goto +8 -> 111
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 146	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: getfield 171	com/androlua/LuaBitmapDrawable:e	Landroid/graphics/Movie;
    //   115: ifnonnull +39 -> 154
    //   118: aload_0
    //   119: getfield 107	com/androlua/LuaBitmapDrawable:g	Landroid/graphics/drawable/Drawable;
    //   122: ifnonnull +32 -> 154
    //   125: aload_0
    //   126: getfield 184	com/androlua/LuaBitmapDrawable:h	Lcom/androlua/NineBitmapDrawable;
    //   129: ifnonnull +25 -> 154
    //   132: new 154	android/os/Handler
    //   135: dup
    //   136: invokespecial 155	android/os/Handler:<init>	()V
    //   139: new 197	com/androlua/LuaBitmapDrawable$4
    //   142: dup
    //   143: aload_0
    //   144: invokespecial 198	com/androlua/LuaBitmapDrawable$4:<init>	(Lcom/androlua/LuaBitmapDrawable;)V
    //   147: ldc2_w 161
    //   150: invokevirtual 166	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   153: pop
    //   154: aload_0
    //   155: invokevirtual 169	com/androlua/LuaBitmapDrawable:invalidateSelf	()V
    //   158: return
    //
    // Exception table:
    //   from	to	target	type
    //   69	81	84	java/lang/Exception
    //   84	103	106	java/lang/Exception
  }

  public static long getCacheTime()
  {
    return q;
  }

  public static String getHttpBitmap(LuaContext paramLuaContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLuaContext.getLuaExtDir("cache"));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.hashCode());
    String str = localStringBuilder.toString();
    File localFile = new File(str);
    if ((localFile.exists()) && (System.currentTimeMillis() - localFile.lastModified() < q))
      return str;
    new File(str).delete();
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setConnectTimeout(120000);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.connect();
    InputStream localInputStream = localHttpURLConnection.getInputStream();
    FileOutputStream localFileOutputStream = new FileOutputStream(str);
    if (!LuaUtil.copyFile(localInputStream, localFileOutputStream))
    {
      localFileOutputStream.close();
      localInputStream.close();
      new File(str).delete();
      throw new RuntimeException("LoadHttpBitmap Error.");
    }
    localFileOutputStream.close();
    localInputStream.close();
    return str;
  }

  public static void setCacheTime(long paramLong)
  {
    q = paramLong;
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(this.j);
    if (this.m != null)
    {
      long l2 = System.currentTimeMillis();
      if ((this.c != 0L) && (this.n != null));
      while (l2 - this.c > this.o)
      {
        this.n = this.m.next();
        this.o = this.n.delay;
        this.c += this.o;
        continue;
        this.n = this.m.next();
        this.o = this.n.delay;
        this.c = l2;
      }
      if (this.n != null)
      {
        Rect localRect3 = getBounds();
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.n.image);
        int i10 = localBitmapDrawable.getIntrinsicWidth();
        int i11 = localBitmapDrawable.getIntrinsicHeight();
        float f38;
        float f39;
        if (this.k == 1)
        {
          float f34 = localRect3.right - localRect3.left;
          float f35 = i10;
          float f36 = f34 / f35;
          float f37 = localRect3.bottom - localRect3.top;
          f38 = i11;
          f39 = f37 / f38;
          i10 = (int)(f35 * f36);
        }
        float f28;
        float f32;
        for (float f33 = f38 * f39; ; f33 = f28 * f32)
        {
          i11 = (int)f33;
          break;
          if (this.k == 0)
            break;
          float f27 = localRect3.bottom - localRect3.top;
          f28 = i11;
          float f29 = f27 / f28;
          float f30 = localRect3.right - localRect3.left;
          float f31 = i10;
          f32 = Math.min(f29, f30 / f31);
          i10 = (int)(f31 * f32);
        }
        int i12 = localRect3.left;
        int i13 = localRect3.top;
        switch (this.k)
        {
        default:
          break;
        case 4:
          i13 = localRect3.bottom - localRect3.top - i11;
          break;
        case 3:
          i12 = (localRect3.right - localRect3.left - i10) / 2;
          i13 = (localRect3.bottom - localRect3.top - i11) / 2;
        }
        localBitmapDrawable.setBounds(new Rect(i12, i13, i10 + i12, i11 + i13));
        localBitmapDrawable.draw(paramCanvas);
      }
    }
    while (true)
    {
      invalidateSelf();
      return;
      if (this.e != null)
      {
        long l1 = System.currentTimeMillis();
        if (this.c == 0L)
          this.c = l1;
        this.d = ((int)((l1 - this.c) % this.b));
        this.e.setTime(this.d);
        Rect localRect2 = getBounds();
        paramCanvas.save();
        int i5 = this.e.width();
        int i6 = this.e.height();
        float f14 = 1.0F;
        float f25;
        float f26;
        if (this.k == 1)
        {
          float f21 = localRect2.right - localRect2.left;
          float f22 = i5;
          float f23 = f21 / f22;
          float f24 = localRect2.bottom - localRect2.top;
          f25 = i6;
          f26 = f24 / f25;
          paramCanvas.scale(f23, f26);
          i5 = (int)(f22 * f23);
        }
        float f16;
        for (float f20 = f25 * f26; ; f20 = f16 * f14)
        {
          i6 = (int)f20;
          break;
          if (this.k == 0)
            break;
          float f15 = localRect2.bottom - localRect2.top;
          f16 = i6;
          float f17 = f15 / f16;
          float f18 = localRect2.right - localRect2.left;
          float f19 = i5;
          f14 = Math.min(f17, f18 / f19);
          paramCanvas.scale(f14, f14);
          i5 = (int)(f19 * f14);
        }
        int i7 = localRect2.left;
        int i8 = localRect2.top;
        switch (this.k)
        {
        default:
          break;
        case 4:
          i8 = (int)(localRect2.bottom - localRect2.top - i6 / f14);
          break;
        case 3:
          int i9 = (int)((localRect2.right - localRect2.left - i5) / f14 / 2.0F);
          i8 = (int)((localRect2.bottom - localRect2.top - i6) / f14 / 2.0F);
          i7 = i9;
        }
        this.e.draw(paramCanvas, i7, i8, new Paint());
        paramCanvas.restore();
      }
      else
      {
        if (this.g != null)
        {
          Rect localRect1 = getBounds();
          int i1 = this.g.getIntrinsicWidth();
          int i2 = this.g.getIntrinsicHeight();
          float f12;
          float f13;
          if (this.k == 1)
          {
            float f8 = localRect1.right - localRect1.left;
            float f9 = i1;
            float f10 = f8 / f9;
            float f11 = localRect1.bottom - localRect1.top;
            f12 = i2;
            f13 = f11 / f12;
            i1 = (int)(f9 * f10);
          }
          float f2;
          float f6;
          for (float f7 = f12 * f13; ; f7 = f2 * f6)
          {
            i2 = (int)f7;
            break;
            if (this.k == 0)
              break;
            float f1 = localRect1.bottom - localRect1.top;
            f2 = i2;
            float f3 = f1 / f2;
            float f4 = localRect1.right - localRect1.left;
            float f5 = i1;
            f6 = Math.min(f3, f4 / f5);
            i1 = (int)(f5 * f6);
          }
          int i3 = localRect1.left;
          int i4 = localRect1.top;
          switch (this.k)
          {
          default:
            break;
          case 4:
            i4 = localRect1.bottom - localRect1.top - i2;
            break;
          case 3:
            i3 = (localRect1.right - localRect1.left - i1) / 2;
            i4 = (localRect1.bottom - localRect1.top - i2) / 2;
          }
          this.g.setBounds(new Rect(i3, i4, i1 + i3, i2 + i4));
          this.g.draw(paramCanvas);
          return;
        }
        if (this.h != null)
        {
          this.h.setBounds(getBounds());
          this.h.draw(paramCanvas);
          return;
        }
        if (this.f == null)
          break;
        this.f.setBounds(getBounds());
        this.f.draw(paramCanvas);
      }
    }
  }

  protected void finalize()
  {
    if (this.m != null)
      this.m.free();
  }

  public void gc()
  {
    if (this.m != null)
      this.m.free();
    if ((this.g != null) && ((this.g instanceof BitmapDrawable)))
      ((BitmapDrawable)this.g).getBitmap().recycle();
    if (this.h != null)
      this.h.gc();
    this.m = null;
    this.g = null;
    this.h = null;
    this.f.setState(-1);
    this.p = true;
  }

  public int getIntrinsicHeight()
  {
    if (this.e != null)
      return this.e.height();
    if (this.g != null)
      this.g.getIntrinsicHeight();
    else if (this.h != null)
      this.h.getIntrinsicHeight();
    return super.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    if (this.e != null)
      return this.e.width();
    if (this.g != null)
      this.g.getIntrinsicWidth();
    else if (this.h != null)
      this.h.getIntrinsicWidth();
    return super.getIntrinsicWidth();
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean isGc()
  {
    return this.p;
  }

  public void run()
  {
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.i = paramColorFilter;
  }

  public void setFillColor(int paramInt)
  {
    if (paramInt == this.j)
      return;
    this.j = paramInt;
  }

  public void setScaleType(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      invalidateSelf();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaBitmapDrawable
 * JD-Core Version:    0.6.2
 */