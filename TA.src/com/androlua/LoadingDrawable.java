package com.androlua;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class LoadingDrawable extends Drawable
{
  private final DisplayMetrics a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 3;
  private int g = 1;
  private Paint h;
  private int i;

  public LoadingDrawable(Context paramContext)
  {
    this.a = paramContext.getResources().getDisplayMetrics();
    this.h = new Paint();
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setAntiAlias(true);
    this.h.setStrokeWidth(a(8.0F));
    this.h.setColor(-2004318072);
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, this.a);
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = new Rect(getBounds());
    int j = (int)Math.min(localRect.right, localRect.bottom);
    int k = localRect.right - j;
    int m = localRect.bottom - j;
    localRect.right = j;
    localRect.bottom = j;
    paramCanvas.save();
    paramCanvas.translate(k / 2, m / 2);
    float f1 = j;
    float f2 = 0.15F * f1;
    float f3 = f1 * 0.85F;
    RectF localRectF = new RectF(f2, f2, f3, f3);
    if ((this.b >= 360) && (this.i == 0))
    {
      this.g = 8;
      this.f = -6;
    }
    else if (this.b <= 6)
    {
      this.f = 6;
      this.g = 2;
    }
    if ((this.b < 360) || (this.i == 0))
    {
      int n;
      if (this.i == 0)
      {
        this.b += this.f;
        n = this.c;
      }
      for (int i1 = this.g; ; i1 = 2 * this.g)
      {
        this.c = (n + i1);
        this.c %= 360;
        break;
        this.b += 2 * this.f;
        n = this.c;
      }
    }
    paramCanvas.drawArc(localRectF, this.c, this.b, false, this.h);
    if (this.b >= 360)
    {
      this.f = -6;
      this.g = 8;
      if (this.i == 1)
      {
        Path localPath = new Path();
        localPath.moveTo(0.3F * localRect.right, 0.5F * localRect.bottom);
        localPath.lineTo(0.45F * localRect.right, 0.7F * localRect.bottom);
        localPath.lineTo(0.75F * localRect.right, 0.4F * localRect.bottom);
        paramCanvas.drawPath(localPath, this.h);
      }
      else if (this.i == -1)
      {
        paramCanvas.drawLine(localRect.right / 2, 0.25F * localRect.bottom, localRect.right / 2, 0.65F * localRect.bottom, this.h);
        paramCanvas.drawLine(localRect.right / 2, 0.7F * localRect.bottom, localRect.right / 2, 0.75F * localRect.bottom, this.h);
      }
    }
    paramCanvas.restore();
    invalidateSelf();
  }

  public int getOpacity()
  {
    return 0;
  }

  public void setAlpha(int paramInt)
  {
    this.h.setAlpha(paramInt);
  }

  public void setColor(int paramInt)
  {
    this.h.setColor(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.h.setColorFilter(paramColorFilter);
  }

  public void setState(int paramInt)
  {
    this.i = paramInt;
  }

  public void setStrokeWidth(float paramFloat)
  {
    this.h.setStrokeWidth(paramFloat);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LoadingDrawable
 * JD-Core Version:    0.6.2
 */