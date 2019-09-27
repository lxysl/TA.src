package android.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.androlua.util.TimerTaskX;
import com.androlua.util.TimerX;

public class RippleHelper extends Drawable
  implements View.OnTouchListener
{
  private final DisplayMetrics a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private int g;
  private TimerX h;
  private task i;
  private Paint j;
  private float k;
  private float l;
  private View m;
  private Drawable n;
  private int o;
  private boolean p;
  private int q;
  private int r;
  private int s;

  public RippleHelper(View paramView)
  {
    this.m = paramView;
    this.a = paramView.getResources().getDisplayMetrics();
    a();
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, this.a);
  }

  private void a()
  {
    if (this.m.isClickable())
      this.f = true;
    this.n = this.m.getBackground();
    this.m.setBackgroundDrawable(this);
    this.m.setOnTouchListener(this);
    this.j = new Paint();
    this.j.setColor(1152035498);
    this.j.setAntiAlias(true);
    this.j.setStrokeWidth(a(4.0F));
    this.o = this.j.getAlpha();
    this.h = new TimerX();
    this.i = new task(null);
    this.h.schedule(this.i, 0L, 16L);
    this.i.setEnabled(false);
    this.g = 0;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      this.n.setBounds(getBounds());
      this.n.draw(paramCanvas);
    }
    this.j.setColor(this.r);
    this.j.setAlpha(this.s);
    if (this.b != 0)
    {
      if (this.e)
        paramCanvas.drawCircle(this.k, this.l, this.c, this.j);
      else
        paramCanvas.drawRect(getBounds(), this.j);
      int i1 = this.c;
      if (this.p)
      {
        paramCanvas.drawCircle(this.k, this.l, Math.min(this.g, this.c), this.j);
        return;
      }
      int i2 = this.g;
      int i3 = 0;
      while (i2 >= 0)
      {
        paramCanvas.drawCircle(this.k, this.l, Math.min(i2, i1), this.j);
        i3++;
        if (i3 >= 2)
        {
          Paint localPaint = this.j;
          float f1 = this.k;
          float f2 = this.l;
          float f3 = a(6.0F);
          int[] arrayOfInt = new int[3];
          arrayOfInt[0] = 1157627903;
          arrayOfInt[1] = this.q;
          arrayOfInt[2] = 1140850688;
          RadialGradient localRadialGradient = new RadialGradient(f1, f2, f3, arrayOfInt, null, Shader.TileMode.MIRROR);
          localPaint.setShader(localRadialGradient);
          this.j.setStyle(Paint.Style.STROKE);
          this.j.setColor(this.q);
          paramCanvas.drawCircle(this.k, this.l, this.g % i1, this.j);
          break;
        }
        i2 -= i1;
      }
      this.j.setShader(null);
      this.j.setStyle(Paint.Style.FILL);
    }
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean isCircle()
  {
    return this.e;
  }

  public boolean isSingle()
  {
    return this.p;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    onTouchEvent(paramMotionEvent);
    return false;
  }

  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.m.hasOnClickListeners()) && (!this.f))
      return;
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return;
    case 1:
    case 3:
    case 4:
      this.b = 2;
      return;
    case 0:
    }
    Rect localRect = getBounds();
    if (this.e)
    {
      this.l = (localRect.bottom / 2);
      this.k = (localRect.right / 2);
    }
    for (int i1 = Math.max(localRect.bottom, localRect.right) / 2; ; i1 = (int)Math.hypot(localRect.bottom, localRect.right))
    {
      this.c = i1;
      break;
      this.k = paramMotionEvent.getX();
      this.l = paramMotionEvent.getY();
    }
    this.d = Math.max(this.c / 60, 1);
    this.g = 0;
    this.i.setEnabled(true);
    this.j.setAlpha(this.o);
    this.b = 1;
  }

  public void setAlpha(int paramInt)
  {
    this.o = paramInt;
    this.j.setAlpha(paramInt);
  }

  public void setBackgroundColor(int paramInt)
  {
    this.n = new ColorDrawable(paramInt);
  }

  public void setCircle(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.j.setColorFilter(paramColorFilter);
  }

  public void setRippleColor(int paramInt)
  {
    this.r = paramInt;
    this.j.setColor(paramInt);
    this.o = this.j.getAlpha();
  }

  public void setRippleLineColor(int paramInt)
  {
    this.q = paramInt;
  }

  public void setSingle(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  private class task extends TimerTaskX
  {
    private task()
    {
    }

    public void run()
    {
      switch (RippleHelper.a(RippleHelper.this))
      {
      default:
        RippleHelper.a(RippleHelper.this, 0);
        setEnabled(false);
        return;
      case 3:
        RippleHelper.b(RippleHelper.this, RippleHelper.h(RippleHelper.this) - Math.max(RippleHelper.h(RippleHelper.this) / 16, 4));
        RippleHelper.i(RippleHelper.this).setAlpha(RippleHelper.h(RippleHelper.this));
        RippleHelper.f(RippleHelper.this).postInvalidate();
        if (RippleHelper.h(RippleHelper.this) < 4)
        {
          RippleHelper.c(RippleHelper.this, 0);
          return;
        }
        break;
      case 2:
        RippleHelper.a(RippleHelper.this, RippleHelper.c(RippleHelper.this) + 4 * RippleHelper.d(RippleHelper.this));
        RippleHelper.b(RippleHelper.this, Math.min(RippleHelper.e(RippleHelper.this), 2 * (RippleHelper.c(RippleHelper.this) / RippleHelper.d(RippleHelper.this))));
        RippleHelper.f(RippleHelper.this).postInvalidate();
        if (RippleHelper.c(RippleHelper.this) / RippleHelper.g(RippleHelper.this) >= 1)
        {
          RippleHelper.a(RippleHelper.this, RippleHelper.g(RippleHelper.this));
          RippleHelper.b(RippleHelper.this, RippleHelper.e(RippleHelper.this));
          RippleHelper.c(RippleHelper.this, 3);
          return;
        }
        break;
      case 1:
        RippleHelper localRippleHelper;
        int i;
        if (RippleHelper.b(RippleHelper.this))
        {
          localRippleHelper = RippleHelper.this;
          i = RippleHelper.c(RippleHelper.this);
        }
        for (int j = Math.max(RippleHelper.c(RippleHelper.this) / 16, RippleHelper.d(RippleHelper.this)); ; j = RippleHelper.d(RippleHelper.this))
        {
          RippleHelper.a(localRippleHelper, i + j);
          break;
          localRippleHelper = RippleHelper.this;
          i = RippleHelper.c(RippleHelper.this);
        }
        RippleHelper.b(RippleHelper.this, Math.min(RippleHelper.e(RippleHelper.this), RippleHelper.c(RippleHelper.this) / RippleHelper.d(RippleHelper.this)));
        RippleHelper.f(RippleHelper.this).postInvalidate();
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.RippleHelper
 * JD-Core Version:    0.6.2
 */