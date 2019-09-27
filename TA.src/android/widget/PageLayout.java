package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class PageLayout extends HorizontalScrollView
{
  private int a = 0;
  private LinearLayout b;
  private OnPageChangeListener c;
  private int d;
  private Scroller e;
  private int f;
  private int g;
  private int h;
  private VelocityTracker i;
  private int j;
  private int k;

  public PageLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a()
  {
    if (this.i != null)
    {
      this.i.recycle();
      this.i = null;
    }
  }

  private void a(Context paramContext)
  {
    setHorizontalScrollBarEnabled(false);
    this.k = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.a = (this.k / 2);
    this.b = new LinearLayout(paramContext);
    super.addView(this.b);
    this.e = new Scroller(getContext());
    setFocusable(true);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.f = localViewConfiguration.getScaledTouchSlop();
    this.g = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.h = localViewConfiguration.getScaledMaximumFlingVelocity();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.i == null)
      this.i = VelocityTracker.obtain();
    this.i.addMovement(paramMotionEvent);
  }

  public void addView(View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(paramView);
    this.b.addView(localFrameLayout);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(paramView, paramLayoutParams);
    this.b.addView(localFrameLayout);
  }

  public View getPage(int paramInt)
  {
    return this.b.getChildAt(paramInt);
  }

  public int getTouchScale()
  {
    return this.a;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getX() >= this.a) && (paramMotionEvent.getX() <= this.k - this.a))
      return false;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      showPage(this.d);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getMeasuredWidth();
    int n = this.b.getChildCount();
    if ((this.j != n) || (this.k != m))
    {
      this.j = n;
      this.k = m;
      for (int i1 = 0; i1 < n; i1++)
      {
        ViewGroup localViewGroup = (ViewGroup)this.b.getChildAt(i1);
        ViewGroup.LayoutParams localLayoutParams2 = localViewGroup.getLayoutParams();
        localLayoutParams2.width = this.k;
        localViewGroup.setLayoutParams(localLayoutParams2);
        localViewGroup.requestLayout();
      }
      ViewGroup.LayoutParams localLayoutParams1 = this.b.getLayoutParams();
      localLayoutParams1.width = (n * this.k);
      this.b.setLayoutParams(localLayoutParams1);
      this.b.requestLayout();
      requestLayout();
    }
    super.onMeasure(paramInt1, paramInt2);
    showPage(this.d);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    a(paramMotionEvent);
    if (m != 1)
      return super.onTouchEvent(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.i;
    localVelocityTracker.computeCurrentVelocity(1000, this.h);
    int n = (int)localVelocityTracker.getYVelocity();
    int i1 = (int)localVelocityTracker.getXVelocity();
    a();
    int i2 = Math.abs(i1);
    int i3 = Math.abs(n);
    if ((i2 > this.g) && (i2 > i3))
    {
      if (i1 > 0);
      for (int i6 = Math.max(0, this.d - 1); ; i6 = Math.min(this.b.getChildCount() - 1, 1 + this.d))
      {
        showPage(i6);
        return true;
      }
    }
    int i4 = getScrollX();
    if (i4 % this.k < this.k / 2);
    for (int i5 = i4 / this.k; ; i5 = 1 + i4 / this.k)
    {
      showPage(i5);
      return true;
    }
  }

  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    this.c = paramOnPageChangeListener;
  }

  public void setTouchScale(int paramInt)
  {
    this.a = paramInt;
  }

  public void showPage(int paramInt)
  {
    smoothScrollTo(paramInt * this.k, 0);
    if ((this.c != null) && (this.d != paramInt))
      this.c.onPageChange(this, paramInt);
    this.d = paramInt;
  }

  public void showPage(View paramView)
  {
    int m = this.b.getChildCount();
    for (int n = 0; n < m; n++)
      if (this.b.getChildAt(n).equals(paramView))
        showPage(n);
  }

  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageChange(View paramView, int paramInt);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.PageLayout
 * JD-Core Version:    0.6.2
 */