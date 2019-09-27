package com.b.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.b.a.b.b;
import com.b.a.b.b.a;
import com.b.a.b.m;

public class i extends g
{
  private final a e;
  private final a f;
  private final a g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private int l;

  public i(c paramc)
  {
    super(paramc);
    DisplayMetrics localDisplayMetrics = paramc.getContext().getResources().getDisplayMetrics();
    this.l = ((int)TypedValue.applyDimension(2, (float)(1.5D * c.d), localDisplayMetrics));
    this.e = new a();
    this.f = new a();
    this.g = new a();
  }

  private void a(a parama, MotionEvent paramMotionEvent)
  {
    int m = parama.c((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()).a();
    if (m >= 0)
    {
      this.c.moveCaret(m);
      Rect localRect = this.c.c(m);
      parama.a(localRect.left + this.c.getPaddingLeft(), localRect.bottom + this.c.getPaddingTop());
    }
  }

  public Rect a()
  {
    return this.e.a;
  }

  public void a(Canvas paramCanvas)
  {
    if (!this.c.isSelectText2())
    {
      this.e.d();
      this.f.e();
      this.g.e();
      if (!this.j)
      {
        Rect localRect3 = this.c.c(this.c.getCaretPosition());
        int i3 = localRect3.left + this.c.getPaddingLeft();
        int i4 = localRect3.bottom + this.c.getPaddingTop();
        this.e.b(i3, i4);
      }
      if (this.k)
        this.e.a(paramCanvas, this.j);
      this.k = false;
      return;
    }
    this.e.e();
    this.f.d();
    this.g.d();
    if ((!this.h) || (!this.i))
    {
      Rect localRect1 = this.c.c(this.c.getSelectionStart());
      int m = localRect1.left + this.c.getPaddingLeft();
      int n = localRect1.bottom + this.c.getPaddingTop();
      this.f.b(m, n);
      Rect localRect2 = this.c.c(this.c.getSelectionEnd());
      int i1 = localRect2.left + this.c.getPaddingLeft();
      int i2 = localRect2.bottom + this.c.getPaddingTop();
      this.g.b(i1, i2);
    }
    this.f.a(paramCanvas, this.h);
    this.g.a(paramCanvas, this.h);
  }

  public void a(b paramb)
  {
    this.e.a(paramb.a(b.a.f));
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.j = false;
    this.h = false;
    this.i = false;
    this.e.c();
    this.f.c();
    this.g.c();
    super.a(paramMotionEvent);
    return true;
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX() + this.c.getScrollX();
    int n = (int)paramMotionEvent.getY() + this.c.getScrollY();
    if (this.e.e(m, n))
    {
      this.c.selectText(true);
      return true;
    }
    if (this.f.e(m, n))
      return true;
    return super.onDoubleTap(paramMotionEvent);
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    super.onDown(paramMotionEvent);
    if (!this.d)
    {
      int m = (int)paramMotionEvent.getX() + this.c.getScrollX();
      int n = (int)paramMotionEvent.getY() + this.c.getScrollY();
      this.j = this.e.e(m, n);
      this.h = this.f.e(m, n);
      this.i = this.g.e(m, n);
      a locala;
      if (this.j)
      {
        this.k = true;
        this.e.d(m, n);
        locala = this.e;
      }
      while (true)
      {
        locala.b();
        return true;
        if (this.h)
        {
          this.f.d(m, n);
          this.c.focusSelectionStart();
          locala = this.f;
        }
        else
        {
          if (!this.i)
            break;
          this.g.d(m, n);
          this.c.focusSelectionEnd();
          locala = this.g;
        }
      }
    }
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.j) && (!this.h) && (!this.i))
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    a(paramMotionEvent2);
    return true;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    onDoubleTap(paramMotionEvent);
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.j)
    {
      if ((0xFF & paramMotionEvent2.getAction()) == 1)
      {
        a(paramMotionEvent2);
        return true;
      }
      this.k = true;
      a(this.e, paramMotionEvent2);
      return true;
    }
    if (this.h)
    {
      if ((0xFF & paramMotionEvent2.getAction()) == 1)
      {
        a(paramMotionEvent2);
        return true;
      }
      a(this.f, paramMotionEvent2);
      return true;
    }
    if (this.i)
    {
      if ((0xFF & paramMotionEvent2.getAction()) == 1)
      {
        a(paramMotionEvent2);
        return true;
      }
      a(this.g, paramMotionEvent2);
      return true;
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX() + this.c.getScrollX();
    int n = (int)paramMotionEvent.getY() + this.c.getScrollY();
    if ((!this.e.e(m, n)) && (!this.f.e(m, n)))
    {
      if (this.g.e(m, n))
        return true;
      this.k = true;
      return super.onSingleTapUp(paramMotionEvent);
    }
    return true;
  }

  private class a
  {
    public final Rect a = new Rect(a(), 0, 0, this.d.bottom + this.c);
    private final int c = i.a(i.this) / 3;
    private final Rect d = new Rect(0, 0, i.a(i.this), i.a(i.this));
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private final Paint k = new Paint();
    private boolean l;

    public a()
    {
      this.k.setColor(i.this.c.getColorScheme().a(b.a.f));
      this.k.setAntiAlias(true);
    }

    private void f()
    {
      int m = this.g + a();
      int n;
      if (m >= this.e)
      {
        int i3 = this.e;
        n = m + 1;
        m = i3;
      }
      else
      {
        n = 1 + this.e;
      }
      int i1;
      int i2;
      if (this.h >= this.f)
      {
        i1 = this.f;
        i2 = this.h;
      }
      else
      {
        i1 = this.h;
        i2 = this.f;
      }
      i.this.c.invalidate(m, i1, n, i2);
      b();
    }

    public final int a()
    {
      return this.d.right / 2;
    }

    public void a(int paramInt)
    {
      this.k.setColor(paramInt);
    }

    public void a(int paramInt1, int paramInt2)
    {
      f();
      b(paramInt1, paramInt2);
      f();
    }

    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      int m = a();
      paramCanvas.drawLine(this.e, this.f, m + this.g, m + this.h, this.k);
      float f1 = this.e - m;
      int n = this.f;
      int i1 = m / 2;
      paramCanvas.drawArc(new RectF(f1, n - i1 - this.c, this.g + m * 2, i1 + this.h), 60.0F, 60.0F, true, this.k);
      paramCanvas.drawOval(new RectF(this.g, this.h, this.g + this.d.right, this.h + this.d.bottom), this.k);
    }

    public void b()
    {
      Rect localRect = new Rect(this.g, this.h, this.g + this.d.right, this.h + this.d.bottom);
      i.this.c.invalidate(localRect);
    }

    public void b(int paramInt1, int paramInt2)
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = (paramInt1 - a());
      this.h = (paramInt2 + this.c);
    }

    public m c(int paramInt1, int paramInt2)
    {
      int m = i.this.a(paramInt1) - this.i + a();
      int n = -2 + (i.this.b(paramInt2) - this.j - this.c);
      return new m(i.this.c.a(m, n), i.this.c.b(m, n));
    }

    public void c()
    {
      this.i = 0;
      this.j = 0;
    }

    public void d()
    {
      this.l = true;
    }

    public void d(int paramInt1, int paramInt2)
    {
      this.i = (paramInt1 - this.g);
      this.j = (paramInt2 - this.h);
    }

    public void e()
    {
      this.l = false;
    }

    public boolean e(int paramInt1, int paramInt2)
    {
      return (this.l) && (paramInt1 >= this.g) && (paramInt1 < this.g + this.d.right) && (paramInt2 >= this.h) && (paramInt2 < this.h + this.d.bottom);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.a.i
 * JD-Core Version:    0.6.2
 */