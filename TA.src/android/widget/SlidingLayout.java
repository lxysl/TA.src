package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class SlidingLayout extends HorizontalScrollView
{
  private int a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private boolean e;
  private boolean f;
  private LinearLayout g;
  private OnMenuOpenedListener h;
  private OnMenuClosedListener i;
  private OnMenuStateChangeListener j;
  private boolean k;

  public SlidingLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public SlidingLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setHorizontalScrollBarEnabled(false);
    this.a = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.b = (this.a / 10);
    this.g = new LinearLayout(paramContext);
    super.addView(this.g);
  }

  public void addView(View paramView)
  {
    this.g.addView(paramView);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.g.addView(paramView, paramLayoutParams);
  }

  public void closeMenu()
  {
    smoothScrollTo(this.c, 0);
    if ((this.f) && (this.i != null))
      this.i.onMenuClosed(this);
    this.f = false;
  }

  public int getMenuWidth()
  {
    return this.c;
  }

  public int getTouchScale()
  {
    return this.b;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.f) && (paramMotionEvent.getX() >= this.b))
      return false;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (!this.e)
        scrollTo(this.c, 0);
      else
        closeMenu();
      this.e = true;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      View localView1 = this.g.getChildAt(0);
      View localView2 = this.g.getChildAt(1);
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      if ((this.c == 0) && (localLayoutParams.width < 0))
        localLayoutParams.width = ((int)(0.8D * this.a));
      this.c = localLayoutParams.width;
      this.d = (localLayoutParams.width / 2);
      localView2.getLayoutParams().width = this.a;
      this.g.getLayoutParams().width = (this.a + this.c);
    }
    if (this.f)
      openMenu();
    else
      closeMenu();
    super.onMeasure(paramInt1, paramInt2);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      break;
    case 2:
      if ((!this.k) && (this.j != null))
        this.j.onMenuStateChange(this, this.f);
      this.k = true;
      break;
    case 1:
      int m = getScrollX();
      if (this.f)
        if (m <= this.d / 2);
      while (true)
      {
        closeMenu();
        break;
        do
        {
          openMenu();
          break;
        }
        while (m <= 1.5D * this.d);
      }
      this.k = false;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void openMenu()
  {
    smoothScrollTo(0, 0);
    if ((!this.f) && (this.h != null))
      this.h.onMenuOpened(this);
    this.f = true;
  }

  public void setMenuWidth(int paramInt)
  {
    this.c = paramInt;
  }

  public void setOnMenuClosedListener(OnMenuClosedListener paramOnMenuClosedListener)
  {
    this.i = paramOnMenuClosedListener;
  }

  public void setOnMenuOpenedListener(OnMenuOpenedListener paramOnMenuOpenedListener)
  {
    this.h = paramOnMenuOpenedListener;
  }

  public void setOnMenuStateChangeListener(OnMenuStateChangeListener paramOnMenuStateChangeListener)
  {
    this.j = paramOnMenuStateChangeListener;
  }

  public void setTouchScale(int paramInt)
  {
    this.b = paramInt;
  }

  public void toggle()
  {
    if (this.f)
    {
      closeMenu();
      return;
    }
    openMenu();
  }

  public static abstract interface OnMenuClosedListener
  {
    public abstract void onMenuClosed(View paramView);
  }

  public static abstract interface OnMenuOpenedListener
  {
    public abstract void onMenuOpened(View paramView);
  }

  public static abstract interface OnMenuStateChangeListener
  {
    public abstract void onMenuStateChange(View paramView, boolean paramBoolean);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.SlidingLayout
 * JD-Core Version:    0.6.2
 */