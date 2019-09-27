package com.b.a.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.b.a.b.b;
import com.b.a.b.f;

public class g extends GestureDetector.SimpleOnGestureListener
{
  protected static int a = 10;
  protected static int b = 12;
  private static final Rect e = new Rect(0, 0, 0, 0);
  protected c c;
  protected boolean d = false;
  private GestureDetector f;
  private float g;
  private float h;
  private float i;
  private float j;
  private int k;

  private g()
  {
  }

  public g(c paramc)
  {
    this.c = paramc;
    this.f = new GestureDetector(paramc.getContext(), this);
    this.f.setIsLongpressEnabled(true);
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    int m = (int)paramFloat1 + this.c.getScrollX();
    int n = (int)paramFloat2 + this.c.getScrollY();
    int i1 = Math.max(this.c.getMaxScrollX(), this.c.getScrollX());
    if (m > i1)
      m = i1;
    else if (m < 0)
      m = 0;
    int i2 = Math.max(this.c.getMaxScrollY(), this.c.getScrollY());
    if (n > i2)
      n = i2;
    else if (n < 0)
      n = 0;
    this.c.smoothScrollTo(m, n);
  }

  private final boolean b()
  {
    return false;
  }

  private void c(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.c.isSelectText();
    boolean bool2 = true;
    if ((!bool1) && (b()))
      this.c.selectText(bool2);
    int n = (int)paramMotionEvent.getX() - this.c.getPaddingLeft();
    int i1 = (int)paramMotionEvent.getY() - this.c.getPaddingTop();
    c localc;
    int m;
    if (n < a)
    {
      localc = this.c;
      m = 2;
    }
    boolean bool3;
    while (true)
    {
      bool3 = localc.d(m);
      break;
      if (n >= this.c.getContentWidth() - a)
      {
        localc = this.c;
        m = 3;
      }
      else
      {
        if (i1 < a)
        {
          bool3 = this.c.d(0);
          break;
        }
        int i2 = this.c.getContentHeight() - a;
        bool3 = false;
        if (i1 < i2)
          break;
        localc = this.c;
      }
    }
    if (!bool3)
    {
      this.c.b();
      int i3 = this.c.a(a((int)paramMotionEvent.getX()), b((int)paramMotionEvent.getY()));
      if (i3 >= 0)
        this.c.moveCaret(i3);
    }
  }

  private float d(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  private boolean e(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (paramMotionEvent.getPointerCount() == 2))
    {
      if (this.g == 0.0F)
      {
        float f2 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        float f3 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        this.g = ((float)Math.sqrt(f2 * f2 + f3 * f3));
        this.h = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
        this.i = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
        this.j = this.c.getTextSize();
      }
      float f1 = d(paramMotionEvent);
      if (this.g != 0.0F)
        this.c.setTextSize((int)(this.j * (f1 / this.g)));
      return true;
    }
    this.g = 0.0F;
    return false;
  }

  protected final int a(int paramInt)
  {
    return paramInt - this.c.getPaddingLeft() + this.c.getScrollX();
  }

  public Rect a()
  {
    return e;
  }

  public void a(Canvas paramCanvas)
  {
  }

  public void a(b paramb)
  {
  }

  public void a(boolean paramBoolean)
  {
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = this.c.c(paramInt3);
    return (paramInt2 >= localRect.top - b) && (paramInt2 < localRect.bottom + b) && (paramInt1 >= localRect.left - b) && (paramInt1 < localRect.right + b);
  }

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.c.b();
    this.d = false;
    this.g = 0.0F;
    this.k = 0;
    return true;
  }

  protected final int b(int paramInt)
  {
    return paramInt - this.c.getPaddingTop() + this.c.getScrollY();
  }

  public boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean b(MotionEvent paramMotionEvent)
  {
    e(paramMotionEvent);
    boolean bool = this.f.onTouchEvent(paramMotionEvent);
    if ((!bool) && ((0xFF & paramMotionEvent.getAction()) == 1))
      bool = a(paramMotionEvent);
    return bool;
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.d = true;
    int m = a((int)paramMotionEvent.getX());
    int n = b((int)paramMotionEvent.getY());
    int i1 = this.c.a(m, n);
    int i2;
    if ((this.c.isSelectText()) && (this.c.inSelectionRange(i1)))
    {
      f localf2 = this.c.createDocumentProvider();
      int i3 = localf2.c(i1);
      i2 = localf2.e(i3);
      i1 = localf2.e(i3 + 1) - 1;
    }
    while (true)
    {
      this.c.setSelectionRange(i2, i1 - i2);
      return true;
      if (i1 < 0)
        break;
      this.c.moveCaret(i1);
      f localf1 = this.c.createDocumentProvider();
      for (i2 = i1; (i2 >= 0) && (Character.isJavaIdentifierPart(localf1.charAt(i2))); i2--);
      if (i2 != i1)
        i2++;
      while ((i1 >= 0) && (Character.isJavaIdentifierPart(localf1.charAt(i1))))
        i1++;
      this.c.selectText(true);
    }
    return true;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    int m = a((int)paramMotionEvent.getX());
    int n = b((int)paramMotionEvent.getY());
    this.d = a(m, n, this.c.getCaretPosition());
    if (this.c.isFlingScrolling())
    {
      this.c.stopFlingScrolling();
    }
    else if (this.c.isSelectText())
    {
      if (a(m, n, this.c.getSelectionStart()))
        this.c.focusSelectionStart();
      while (true)
      {
        this.c.performHapticFeedback(0);
        this.d = true;
        break;
        if (!a(m, n, this.c.getSelectionEnd()))
          break;
        this.c.focusSelectionEnd();
      }
    }
    if (this.d)
      this.c.performHapticFeedback(0);
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.d)
    {
      if (this.k == 1)
        paramFloat2 = 0.0F;
      else if (this.k == -1)
        paramFloat1 = 0.0F;
      this.c.c(2 * (int)-paramFloat1, 2 * (int)-paramFloat2);
    }
    a(paramMotionEvent2);
    return true;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    onDoubleTap(paramMotionEvent);
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.d)
    {
      c(paramMotionEvent2);
    }
    else if (paramMotionEvent2.getPointerCount() == 1)
    {
      if (this.k == 0)
        if (Math.abs(paramFloat1) > Math.abs(paramFloat2))
          this.k = 1;
        else
          this.k = -1;
      if (this.k == 1)
        paramFloat2 = 0.0F;
      else if (this.k == -1)
        paramFloat1 = 0.0F;
      a(paramFloat1, paramFloat2);
    }
    if ((0xFF & paramMotionEvent2.getAction()) == 1)
      a(paramMotionEvent2);
    return true;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.c.isAccessibilityEnabled())
    {
      this.c.a(true);
      return true;
    }
    int m = a((int)paramMotionEvent.getX());
    int n = b((int)paramMotionEvent.getY());
    int i1 = this.c.a(m, n);
    if (this.c.isSelectText())
    {
      i2 = this.c.b(m, n);
      if ((!this.c.inSelectionRange(i2)) && (!a(m, n, this.c.getSelectionStart())) && (!a(m, n, this.c.getSelectionEnd())))
      {
        this.c.selectText(false);
        if (i2 < 0);
      }
    }
    else
    {
      while (i1 >= 0)
      {
        int i2;
        this.c.moveCaret(i1);
        break;
      }
    }
    this.c.a(true);
    return true;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.a.g
 * JD-Core Version:    0.6.2
 */