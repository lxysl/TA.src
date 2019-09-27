package com.b.a.a;

import android.view.MotionEvent;

public class h extends g
{
  private static int f = 16;
  private int e;
  private float g = 0.0F;
  private float h = 0.0F;

  public h(c paramc)
  {
    super(paramc);
    f = 2 * this.c.a();
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    if (((this.g < 0.0F) && (paramFloat1 > 0.0F)) || ((this.g > 0.0F) && (paramFloat1 < 0.0F)))
      this.g = 0.0F;
    if (((this.h < 0.0F) && (paramFloat2 > 0.0F)) || ((this.h > 0.0F) && (paramFloat2 < 0.0F)))
      this.h = 0.0F;
    double d = Math.atan2(Math.abs(paramFloat1), Math.abs(paramFloat2));
    if (d >= 0.322D)
    {
      float f2 = paramFloat1 + this.g;
      int k = (int)f2 / f;
      this.g = (f2 - k * f);
      while (k > 0)
      {
        this.c.moveCaretRight();
        k--;
        if (this.e == 0)
          this.e = 1;
      }
      while (k < 0)
      {
        this.c.moveCaretLeft();
        k++;
        if (this.e == 0)
          this.e = 1;
      }
    }
    if (1.570796326794897D - d >= 0.322D)
    {
      float f1 = paramFloat2 + this.h;
      int i = (int)f1 / f;
      this.h = (f1 - i * f);
      for (int j = i; j > 0; j--)
      {
        this.c.moveCaretDown();
        if (this.e == 0)
          this.e = -1;
      }
      while (i < 0)
      {
        this.c.moveCaretUp();
        if (this.e == 0)
          this.e = -1;
        i++;
      }
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.g = 0.0F;
    this.h = 0.0F;
    this.e = 0;
    super.a(paramMotionEvent);
    return true;
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.c.setSelected(true ^ this.c.isSelectText());
    this.c.setSelectionRange(this.c.getCaretPosition(), 0);
    return true;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.e = 0;
    f = 2 * this.c.a();
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(paramMotionEvent2);
    return true;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.c.setSelected(true ^ this.c.isSelectText());
    this.c.setSelectionRange(this.c.getCaretPosition(), 0);
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.e == 1)
      paramFloat2 = 0.0F;
    else if (this.e == -1)
      paramFloat1 = 0.0F;
    a(-paramFloat1, -paramFloat2);
    if ((0xFF & paramMotionEvent2.getAction()) == 1)
      a(paramMotionEvent2);
    return true;
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.a.h
 * JD-Core Version:    0.6.2
 */