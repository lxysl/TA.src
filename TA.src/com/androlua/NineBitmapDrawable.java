package com.androlua;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.a.a.a.a.a.a.a;

public class NineBitmapDrawable extends Drawable
  implements LuaGcable
{
  private Paint a = new Paint();
  private Bitmap b;
  private int c;
  private int d;
  private int e;
  private int f;
  private Rect g;
  private Rect h;
  private Rect i;
  private Rect j;
  private Rect k;
  private Rect l;
  private Rect m;
  private Rect n;
  private Rect o;
  private boolean p;

  public NineBitmapDrawable(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    for (int i3 = 0; i3 < i1; i3++)
      if (paramBitmap.getPixel(i3, 0) == -16777216)
      {
        i4 = i3;
        break label62;
      }
    int i4 = 0;
    label62: if ((i4 != 0) && (i4 != i1 - 1))
    {
      for (int i5 = i4; i5 < i1; i5++)
        if (paramBitmap.getPixel(i5, 0) != -16777216)
        {
          i6 = i1 - i5;
          break label118;
        }
      int i6 = 0;
      label118: if ((i6 != 0) && (i6 != 1))
      {
        for (int i7 = 0; i7 < i2; i7++)
          if (paramBitmap.getPixel(0, i7) == -16777216)
          {
            i8 = i7;
            break label169;
          }
        int i8 = 0;
        if ((i8 != 0) && (i8 != i2 - 1))
        {
          for (int i9 = i8; i9 < i2; i9++)
            if (paramBitmap.getPixel(0, i9) != -16777216)
            {
              i10 = i2 - i9;
              break label225;
            }
          int i10 = 0;
          if ((i10 != 0) && (i10 != 1))
          {
            a(paramBitmap, i4, i8, i6, i10);
            return;
          }
          throw new IllegalArgumentException("not found y2");
        }
        throw new IllegalArgumentException("not found y1");
      }
      label225: throw new IllegalArgumentException("not found x2");
    }
    label169: throw new IllegalArgumentException("not found x1");
  }

  public NineBitmapDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public NineBitmapDrawable(String paramString)
  {
    this(LuaBitmap.getLocalBitmap(paramString));
  }

  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramBitmap;
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    int i3 = i1 - paramInt3;
    int i4 = i2 - paramInt4;
    this.g = new Rect(1, 1, paramInt1, paramInt2);
    this.h = new Rect(paramInt1, 1, i3, paramInt2);
    int i5 = i1 - 1;
    this.i = new Rect(i3, 1, i5, paramInt2);
    this.j = new Rect(1, paramInt2, paramInt1, i4);
    this.k = new Rect(paramInt1, paramInt2, i3, i4);
    this.l = new Rect(i3, paramInt2, i5, i4);
    int i6 = i2 - 1;
    this.m = new Rect(1, i4, paramInt1, i6);
    this.n = new Rect(paramInt1, i4, i3, i6);
    this.o = new Rect(i3, i4, i5, i6);
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = getBounds();
    int i1 = localRect1.right;
    int i2 = localRect1.bottom;
    Rect localRect2 = new Rect(0, 0, this.c, this.d);
    Rect localRect3 = new Rect(this.c, 0, i1 - this.e, this.d);
    Rect localRect4 = new Rect(i1 - this.e, 0, i1, this.d);
    Rect localRect5 = new Rect(0, this.d, this.c, i2 - this.f);
    Rect localRect6 = new Rect(this.c, this.d, i1 - this.e, i2 - this.f);
    Rect localRect7 = new Rect(i1 - this.e, this.d, i1, i2 - this.f);
    Rect localRect8 = new Rect(0, i2 - this.f, this.c, i2);
    Rect localRect9 = new Rect(this.c, i2 - this.f, i1 - this.e, i2);
    Rect localRect10 = new Rect(i1 - this.e, i2 - this.f, i1, i2);
    paramCanvas.drawBitmap(this.b, this.g, localRect2, this.a);
    paramCanvas.drawBitmap(this.b, this.h, localRect3, this.a);
    paramCanvas.drawBitmap(this.b, this.i, localRect4, this.a);
    paramCanvas.drawBitmap(this.b, this.j, localRect5, this.a);
    paramCanvas.drawBitmap(this.b, this.k, localRect6, this.a);
    paramCanvas.drawBitmap(this.b, this.l, localRect7, this.a);
    paramCanvas.drawBitmap(this.b, this.m, localRect8, this.a);
    paramCanvas.drawBitmap(this.b, this.n, localRect9, this.a);
    paramCanvas.drawBitmap(this.b, this.o, localRect10, this.a);
  }

  public void gc()
  {
    try
    {
      this.b.recycle();
      this.p = true;
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean isGc()
  {
    return this.p;
  }

  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.NineBitmapDrawable
 * JD-Core Version:    0.6.2
 */