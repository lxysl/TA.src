package android.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

class RoundRectDrawableWithShadow extends Drawable
{
  static final double a = Math.cos(Math.toRadians(45.0D));
  static RoundRectHelper c;
  final int b;
  Paint d;
  Paint e;
  Paint f;
  final RectF g;
  float h;
  Path i;
  float j;
  float k;
  float l;
  float m;
  private boolean n = true;
  private final int o = 922746880;
  private final int p = 50331648;
  private boolean q = true;
  private boolean r = false;
  private DisplayMetrics s;

  RoundRectDrawableWithShadow(Resources paramResources, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.s = paramResources.getDisplayMetrics();
    this.b = ((int)d(1.0F));
    this.d = new Paint(5);
    this.d.setColor(paramInt);
    this.e = new Paint(5);
    this.e.setStyle(Paint.Style.FILL);
    this.h = ((int)(paramFloat1 + 0.5F));
    this.g = new RectF();
    this.f = new Paint(this.e);
    this.f.setAntiAlias(false);
    a(paramFloat2, paramFloat3);
  }

  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
      return (float)(paramFloat1 * 1.5F + (1.0D - a) * paramFloat2);
    return paramFloat1 * 1.5F;
  }

  private void a(Canvas paramCanvas)
  {
    float f1 = -this.h - this.l;
    float f2 = this.h + this.b + this.m / 2.0F;
    float f3 = this.g.width();
    float f4 = f2 * 2.0F;
    int i1;
    if (f3 - f4 > 0.0F)
      i1 = 1;
    else
      i1 = 0;
    int i2;
    if (this.g.height() - f4 > 0.0F)
      i2 = 1;
    else
      i2 = 0;
    int i3 = paramCanvas.save();
    paramCanvas.translate(f2 + this.g.left, f2 + this.g.top);
    paramCanvas.drawPath(this.i, this.e);
    if (i1 != 0)
      paramCanvas.drawRect(0.0F, f1, this.g.width() - f4, -this.h, this.f);
    paramCanvas.restoreToCount(i3);
    int i4 = paramCanvas.save();
    paramCanvas.translate(this.g.right - f2, this.g.bottom - f2);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (i1 != 0)
      paramCanvas.drawRect(0.0F, f1, this.g.width() - f4, -this.h + this.l, this.f);
    paramCanvas.restoreToCount(i4);
    int i5 = paramCanvas.save();
    paramCanvas.translate(f2 + this.g.left, this.g.bottom - f2);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (i2 != 0)
      paramCanvas.drawRect(0.0F, f1, this.g.height() - f4, -this.h, this.f);
    paramCanvas.restoreToCount(i5);
    int i6 = paramCanvas.save();
    paramCanvas.translate(this.g.right - f2, f2 + this.g.top);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (i2 != 0)
      paramCanvas.drawRect(0.0F, f1, this.g.height() - f4, -this.h, this.f);
    paramCanvas.restoreToCount(i6);
  }

  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
      paramFloat1 = (float)(paramFloat1 + (1.0D - a) * paramFloat2);
    return paramFloat1;
  }

  private void b(Rect paramRect)
  {
    float f1 = 1.5F * this.k;
    this.g.set(paramRect.left + this.k, f1 + paramRect.top, paramRect.right - this.k, paramRect.bottom - f1);
    f();
  }

  private float d(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, this.s);
  }

  private int e(float paramFloat)
  {
    int i1 = (int)(paramFloat + 0.5F);
    if (i1 % 2 == 1)
      i1--;
    return i1;
  }

  private void f()
  {
    RectF localRectF1 = new RectF(-this.h, -this.h, this.h, this.h);
    RectF localRectF2 = new RectF(localRectF1);
    localRectF2.inset(-this.l, -this.l);
    if (this.i == null)
      this.i = new Path();
    else
      this.i.reset();
    this.i.setFillType(Path.FillType.EVEN_ODD);
    this.i.moveTo(-this.h, 0.0F);
    this.i.rLineTo(-this.l, 0.0F);
    this.i.arcTo(localRectF2, 180.0F, 90.0F, false);
    this.i.arcTo(localRectF1, 270.0F, -90.0F, false);
    this.i.close();
    float f1 = this.h / (this.h + this.l);
    Paint localPaint1 = this.e;
    float f2 = this.h + this.l;
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = this.o;
    arrayOfInt1[1] = this.o;
    arrayOfInt1[2] = this.p;
    RadialGradient localRadialGradient = new RadialGradient(0.0F, 0.0F, f2, arrayOfInt1, new float[] { 0.0F, f1, 1.0F }, Shader.TileMode.CLAMP);
    localPaint1.setShader(localRadialGradient);
    Paint localPaint2 = this.f;
    float f3 = -this.h + this.l;
    float f4 = -this.h - this.l;
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = this.o;
    arrayOfInt2[1] = this.o;
    arrayOfInt2[2] = this.p;
    LinearGradient localLinearGradient = new LinearGradient(0.0F, f3, 0.0F, f4, arrayOfInt2, new float[] { 0.0F, 0.5F, 1.0F }, Shader.TileMode.CLAMP);
    localPaint2.setShader(localLinearGradient);
    this.f.setAntiAlias(false);
  }

  float a()
  {
    return this.h;
  }

  void a(float paramFloat)
  {
    float f1 = (int)(paramFloat + 0.5F);
    if (this.h == f1)
      return;
    this.h = f1;
    this.n = true;
    invalidateSelf();
  }

  void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F))
    {
      float f1 = e(paramFloat1);
      float f2 = e(paramFloat2);
      if (f1 > f2)
      {
        if (!this.r)
          this.r = true;
        f1 = f2;
      }
      if ((this.m == f1) && (this.k == f2))
        return;
      this.m = f1;
      this.k = f2;
      this.l = ((int)(0.5F + (f1 * 1.5F + this.b)));
      this.j = (f2 + this.b);
      this.n = true;
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException("invalid shadow size");
  }

  void a(Rect paramRect)
  {
    getPadding(paramRect);
  }

  float b()
  {
    return this.m;
  }

  void b(float paramFloat)
  {
    a(paramFloat, this.k);
  }

  float c()
  {
    return this.k;
  }

  void c(float paramFloat)
  {
    a(this.m, paramFloat);
  }

  float d()
  {
    return 2.0F * Math.max(this.k, this.h + this.b + this.k / 2.0F) + 2.0F * (this.k + this.b);
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.n)
    {
      b(getBounds());
      this.n = false;
    }
    paramCanvas.translate(0.0F, this.m / 2.0F);
    a(paramCanvas);
    paramCanvas.translate(0.0F, -this.m / 2.0F);
    c.drawRoundRect(paramCanvas, this.g, this.h, this.d);
  }

  float e()
  {
    return 2.0F * Math.max(this.k, this.h + this.b + 1.5F * this.k / 2.0F) + 2.0F * (1.5F * this.k + this.b);
  }

  public int getOpacity()
  {
    return -3;
  }

  public boolean getPadding(Rect paramRect)
  {
    int i1 = (int)Math.ceil(a(this.k, this.h, this.q));
    int i2 = (int)Math.ceil(b(this.k, this.h, this.q));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.n = true;
  }

  public void setAddPaddingForCorners(boolean paramBoolean)
  {
    this.q = paramBoolean;
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
    this.e.setAlpha(paramInt);
    this.f.setAlpha(paramInt);
  }

  public void setColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
    this.e.setColorFilter(paramColorFilter);
    this.f.setColorFilter(paramColorFilter);
  }

  static abstract interface RoundRectHelper
  {
    public abstract void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.RoundRectDrawableWithShadow
 * JD-Core Version:    0.6.2
 */