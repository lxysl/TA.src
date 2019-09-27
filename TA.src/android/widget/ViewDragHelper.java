package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final Interpolator v = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      float f = paramAnonymousFloat - 1.0F;
      return 1.0F + f * (f * (f * (f * f)));
    }
  };
  private int a;
  private int b;
  private int c = -1;
  private float[] d;
  private float[] e;
  private float[] f;
  private float[] g;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private VelocityTracker l;
  private float m;
  private float n;
  private int o;
  private int p;
  private Scroller q;
  private final Callback r;
  private View s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w = new Runnable()
  {
    public void run()
    {
      ViewDragHelper.this.a(0);
    }
  };

  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null)
      throw new IllegalArgumentException("Parent view may not be null");
    if (paramCallback == null)
      throw new IllegalArgumentException("Callback may not be null");
    this.u = paramViewGroup;
    this.r = paramCallback;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.o = ((int)(0.5F + 20.0F * paramContext.getResources().getDisplayMetrics().density));
    this.b = localViewConfiguration.getScaledTouchSlop();
    this.m = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.n = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.q = new Scroller(paramContext, v);
  }

  private float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2)
      return 0.0F;
    if (f1 > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
        return paramFloat3;
      return -paramFloat3;
    }
    return paramFloat1;
  }

  private int a(int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 < this.u.getLeft() + this.o)
      i1 = 1;
    else
      i1 = 0;
    if (paramInt2 < this.u.getTop() + this.o)
      i1 |= 4;
    if (paramInt1 > this.u.getRight() - this.o)
      i1 |= 2;
    if (paramInt2 > this.u.getBottom() - this.o)
      i1 |= 8;
    return i1;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
      return 0;
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f2 = i2;
    float f3 = f2 + f2 * a(f1);
    int i3 = Math.abs(paramInt2);
    int i4;
    if (i3 > 0)
      i4 = 4 * Math.round(1000.0F * Math.abs(f3 / i3));
    else
      i4 = (int)(256.0F * (1.0F + Math.abs(paramInt1) / paramInt3));
    return Math.min(i4, 600);
  }

  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = b(paramInt3, (int)this.n, (int)this.m);
    int i2 = b(paramInt4, (int)this.n, (int)this.m);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(i1);
    int i6 = Math.abs(i2);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    float f1;
    if (i1 != 0)
      f1 = i5;
    float f3;
    for (float f2 = i7; ; f2 = i8)
    {
      f3 = f1 / f2;
      break;
      f1 = i3;
    }
    float f4;
    if (i2 != 0)
      f4 = i6;
    float f6;
    for (float f5 = i7; ; f5 = i8)
    {
      f6 = f4 / f5;
      break;
      f4 = i4;
    }
    int i9 = a(paramInt1, i1, this.r.getViewHorizontalDragRange(paramView));
    int i10 = a(paramInt2, i2, this.r.getViewVerticalDragRange(paramView));
    return (int)(f3 * i9 + f6 * i10);
  }

  private void a()
  {
    if (this.d == null)
      return;
    Arrays.fill(this.d, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    this.t = true;
    this.r.onViewReleased(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1)
      a(0);
  }

  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    c(paramInt);
    float[] arrayOfFloat1 = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat1[paramInt] = paramFloat1;
    float[] arrayOfFloat2 = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat2[paramInt] = paramFloat2;
    this.h[paramInt] = a((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = paramMotionEvent.getPointerId(i2);
      float f1 = paramMotionEvent.getX(i2);
      float f2 = paramMotionEvent.getY(i2);
      this.f[i3] = f1;
      this.g[i3] = f2;
    }
  }

  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramFloat1);
    float f2 = Math.abs(paramFloat2);
    int i1 = paramInt2 & this.h[paramInt1];
    boolean bool1 = false;
    if (i1 == paramInt2)
    {
      int i2 = paramInt2 & this.p;
      bool1 = false;
      if (i2 != 0)
      {
        int i3 = paramInt2 & this.j[paramInt1];
        bool1 = false;
        if (i3 != paramInt2)
        {
          int i4 = paramInt2 & this.i[paramInt1];
          bool1 = false;
          if (i4 != paramInt2)
          {
            if ((f1 <= this.b) && (f2 <= this.b))
              return false;
            if ((f1 < f2 * 0.5F) && (this.r.onEdgeLock(paramInt2)))
            {
              int[] arrayOfInt = this.j;
              arrayOfInt[paramInt1] = (paramInt2 | arrayOfInt[paramInt1]);
              return false;
            }
            int i5 = paramInt2 & this.i[paramInt1];
            bool1 = false;
            if (i5 == 0)
            {
              boolean bool2 = f1 < this.b;
              bool1 = false;
              if (bool2)
                bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      this.q.abortAnimation();
      a(0);
      return false;
    }
    int i5 = a(this.s, i3, i4, paramInt3, paramInt4);
    this.q.startScroll(i1, i2, i3, i4, i5);
    a(2);
    return true;
  }

  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null)
      return false;
    int i1;
    if (this.r.getViewHorizontalDragRange(paramView) > 0)
      i1 = 1;
    else
      i1 = 0;
    int i2;
    if (this.r.getViewVerticalDragRange(paramView) > 0)
      i2 = 1;
    else
      i2 = 0;
    if ((i1 != 0) && (i2 != 0))
    {
      boolean bool5 = paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 < this.b * this.b;
      boolean bool6 = false;
      if (bool5)
        bool6 = true;
      return bool6;
    }
    if (i1 != 0)
    {
      boolean bool3 = Math.abs(paramFloat1) < this.b;
      boolean bool4 = false;
      if (bool3)
        bool4 = true;
      return bool4;
    }
    boolean bool1 = false;
    if (i2 != 0)
    {
      boolean bool2 = Math.abs(paramFloat2) < this.b;
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2)
      return 0;
    if (i1 > paramInt3)
    {
      if (paramInt1 > 0)
        return paramInt3;
      return -paramInt3;
    }
    return paramInt1;
  }

  private void b()
  {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
  }

  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i1 = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, i1))
      i1 = 0;
    if (a(paramFloat2, paramFloat1, paramInt, 4))
      i1 |= 4;
    if (a(paramFloat1, paramFloat2, paramInt, 2))
      i1 |= 2;
    if (a(paramFloat2, paramFloat1, paramInt, 8))
      i1 |= 8;
    if (i1 != 0)
    {
      int[] arrayOfInt = this.i;
      arrayOfInt[paramInt] = (i1 | arrayOfInt[paramInt]);
      this.r.onEdgeDragStarted(i1, paramInt);
    }
  }

  private void b(int paramInt)
  {
    if (this.d == null)
      return;
    this.d[paramInt] = 0.0F;
    this.e[paramInt] = 0.0F;
    this.f[paramInt] = 0.0F;
    this.g[paramInt] = 0.0F;
    this.h[paramInt] = 0;
    this.i[paramInt] = 0;
    this.j[paramInt] = 0;
    this.k &= (0xFFFFFFFF ^ 1 << paramInt);
  }

  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.r.clampViewPositionHorizontal(this.s, paramInt1, paramInt3);
      this.s.offsetLeftAndRight(paramInt1 - i1);
    }
    int i3 = paramInt1;
    if (paramInt4 != 0)
    {
      paramInt2 = this.r.clampViewPositionVertical(this.s, paramInt2, paramInt4);
      this.s.offsetTopAndBottom(paramInt2 - i2);
    }
    int i4 = paramInt2;
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      int i5 = i3 - i1;
      int i6 = i4 - i2;
      this.r.onViewPositionChanged(this.s, i3, i4, i5, i6);
    }
  }

  private void c(int paramInt)
  {
    if ((this.d == null) || (this.d.length <= paramInt))
    {
      int i1 = paramInt + 1;
      float[] arrayOfFloat1 = new float[i1];
      float[] arrayOfFloat2 = new float[i1];
      float[] arrayOfFloat3 = new float[i1];
      float[] arrayOfFloat4 = new float[i1];
      int[] arrayOfInt1 = new int[i1];
      int[] arrayOfInt2 = new int[i1];
      int[] arrayOfInt3 = new int[i1];
      if (this.d != null)
      {
        System.arraycopy(this.d, 0, arrayOfFloat1, 0, this.d.length);
        System.arraycopy(this.e, 0, arrayOfFloat2, 0, this.e.length);
        System.arraycopy(this.f, 0, arrayOfFloat3, 0, this.f.length);
        System.arraycopy(this.g, 0, arrayOfFloat4, 0, this.g.length);
        System.arraycopy(this.h, 0, arrayOfInt1, 0, this.h.length);
        System.arraycopy(this.i, 0, arrayOfInt2, 0, this.i.length);
        System.arraycopy(this.j, 0, arrayOfInt3, 0, this.j.length);
      }
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    }
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    ViewDragHelper localViewDragHelper = create(paramViewGroup, paramCallback);
    localViewDragHelper.b = ((int)(localViewDragHelper.b * (1.0F / paramFloat)));
    return localViewDragHelper;
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }

  void a(int paramInt)
  {
    this.u.removeCallbacks(this.w);
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.r.onViewDragStateChanged(paramInt);
      if (this.a == 0)
        this.s = null;
    }
  }

  boolean a(View paramView, int paramInt)
  {
    if ((paramView == this.s) && (this.c == paramInt))
      return true;
    if ((paramView != null) && (this.r.tryCaptureView(paramView, paramInt)))
    {
      this.c = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }

  public void abort()
  {
    cancel();
    if (this.a == 2)
    {
      int i1 = this.q.getCurrX();
      int i2 = this.q.getCurrY();
      this.q.abortAnimation();
      int i3 = this.q.getCurrX();
      int i4 = this.q.getCurrY();
      this.r.onViewPositionChanged(this.s, i3, i4, i3 - i1, i4 - i2);
    }
    a(0);
  }

  public void cancel()
  {
    this.c = -1;
    a();
    if (this.l != null)
    {
      this.l.recycle();
      this.l = null;
    }
  }

  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.u)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
      localStringBuilder.append(this.u);
      localStringBuilder.append(")");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.s = paramView;
    this.c = paramInt;
    this.r.onViewCaptured(paramView, paramInt);
    a(1);
  }

  public boolean checkTouchSlop(int paramInt)
  {
    int i1 = this.d.length;
    for (int i2 = 0; i2 < i1; i2++)
      if (checkTouchSlop(paramInt, i2))
        return true;
    return false;
  }

  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    if (!isPointerDown(paramInt2))
      return false;
    int i1;
    if ((paramInt1 & 0x1) == 1)
      i1 = 1;
    else
      i1 = 0;
    int i2;
    if ((paramInt1 & 0x2) == 2)
      i2 = 1;
    else
      i2 = 0;
    float f1 = this.f[paramInt2] - this.d[paramInt2];
    float f2 = this.g[paramInt2] - this.e[paramInt2];
    if ((i1 != 0) && (i2 != 0))
    {
      boolean bool5 = f1 * f1 + f2 * f2 < this.b * this.b;
      boolean bool6 = false;
      if (bool5)
        bool6 = true;
      return bool6;
    }
    if (i1 != 0)
    {
      boolean bool3 = Math.abs(f1) < this.b;
      boolean bool4 = false;
      if (bool3)
        bool4 = true;
      return bool4;
    }
    boolean bool1 = false;
    if (i2 != 0)
    {
      boolean bool2 = Math.abs(f2) < this.b;
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  public boolean continueSettling(boolean paramBoolean)
  {
    if (this.a == 2)
    {
      boolean bool2 = this.q.computeScrollOffset();
      int i2 = this.q.getCurrX();
      int i3 = this.q.getCurrY();
      int i4 = i2 - this.s.getLeft();
      int i5 = i3 - this.s.getTop();
      if (i4 != 0)
        this.s.offsetLeftAndRight(i4);
      if (i5 != 0)
        this.s.offsetTopAndBottom(i5);
      if ((i4 != 0) || (i5 != 0))
        this.r.onViewPositionChanged(this.s, i2, i3, i4, i5);
      if ((bool2) && (i2 == this.q.getFinalX()) && (i3 == this.q.getFinalY()))
      {
        this.q.abortAnimation();
        bool2 = false;
      }
      if (!bool2)
        if (paramBoolean)
          this.u.post(this.w);
        else
          a(0);
    }
    int i1 = this.a;
    boolean bool1 = false;
    if (i1 == 2)
      bool1 = true;
    return bool1;
  }

  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    for (int i1 = -1 + this.u.getChildCount(); i1 >= 0; i1--)
    {
      View localView = this.u.getChildAt(this.r.getOrderedChildIndex(i1));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
        return localView;
    }
    return null;
  }

  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.t)
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    this.q.fling(this.s.getLeft(), this.s.getTop(), (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c), paramInt1, paramInt3, paramInt2, paramInt4);
    a(2);
  }

  public int getActivePointerId()
  {
    return this.c;
  }

  public View getCapturedView()
  {
    return this.s;
  }

  public int getEdgeSize()
  {
    return this.o;
  }

  public float getMinVelocity()
  {
    return this.n;
  }

  public int getTouchSlop()
  {
    return this.b;
  }

  public int getViewDragState()
  {
    return this.a;
  }

  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.s, paramInt1, paramInt2);
  }

  public boolean isEdgeTouched(int paramInt)
  {
    int i1 = this.h.length;
    for (int i2 = 0; i2 < i1; i2++)
      if (isEdgeTouched(paramInt, i2))
        return true;
    return false;
  }

  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    return (isPointerDown(paramInt2)) && ((paramInt1 & this.h[paramInt2]) != 0);
  }

  public boolean isPointerDown(int paramInt)
  {
    return (this.k & 1 << paramInt) != 0;
  }

  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
      return false;
    int i1 = paramView.getLeft();
    boolean bool = false;
    if (paramInt1 >= i1)
    {
      int i2 = paramView.getRight();
      bool = false;
      if (paramInt1 < i2)
      {
        int i3 = paramView.getTop();
        bool = false;
        if (paramInt2 >= i3)
        {
          int i4 = paramView.getBottom();
          bool = false;
          if (paramInt2 < i4)
            bool = true;
        }
      }
    }
    return bool;
  }

  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0)
      cancel();
    if (this.l == null)
      this.l = VelocityTracker.obtain();
    this.l.addMovement(paramMotionEvent);
    int i3 = 0;
    switch (i1)
    {
    case 4:
    default:
      return;
    case 6:
      int i13 = paramMotionEvent.getPointerId(i2);
      if ((this.a == 1) && (i13 == this.c))
      {
        int i14 = paramMotionEvent.getPointerCount();
        while (i3 < i14)
        {
          int i16 = paramMotionEvent.getPointerId(i3);
          if (i16 != this.c)
          {
            float f11 = paramMotionEvent.getX(i3);
            float f12 = paramMotionEvent.getY(i3);
            if ((findTopChildUnder((int)f11, (int)f12) == this.s) && (a(this.s, i16)))
            {
              i15 = this.c;
              break label210;
            }
          }
          i3++;
        }
        int i15 = -1;
        if (i15 == -1)
          b();
      }
      b(i13);
      return;
    case 5:
      int i11 = paramMotionEvent.getPointerId(i2);
      float f9 = paramMotionEvent.getX(i2);
      float f10 = paramMotionEvent.getY(i2);
      a(f9, f10, i11);
      if (this.a == 0)
      {
        a(findTopChildUnder((int)f9, (int)f10), i11);
        int i12 = this.h[i11];
        if ((i12 & this.p) == 0)
          return;
        this.r.onEdgeTouched(i12 & this.p, i11);
        return;
      }
      if (!isCapturedViewUnder((int)f9, (int)f10))
        return;
      a(this.s, i11);
      return;
    case 3:
      if (this.a == 1)
        a(0.0F, 0.0F);
      break;
    case 2:
      if (this.a == 1)
      {
        int i8 = paramMotionEvent.findPointerIndex(this.c);
        float f7 = paramMotionEvent.getX(i8);
        float f8 = paramMotionEvent.getY(i8);
        int i9 = (int)(f7 - this.f[this.c]);
        int i10 = (int)(f8 - this.g[this.c]);
        b(i9 + this.s.getLeft(), i10 + this.s.getTop(), i9, i10);
        a(paramMotionEvent);
        return;
      }
      int i6 = paramMotionEvent.getPointerCount();
      while (i3 < i6)
      {
        int i7 = paramMotionEvent.getPointerId(i3);
        float f3 = paramMotionEvent.getX(i3);
        float f4 = paramMotionEvent.getY(i3);
        float f5 = f3 - this.d[i7];
        float f6 = f4 - this.e[i7];
        b(f5, f6, i7);
        if (this.a == 1)
          break;
        View localView2 = findTopChildUnder((int)f3, (int)f4);
        if ((a(localView2, f5, f6)) && (a(localView2, i7)))
          break;
        i3++;
      }
    case 1:
      label210: if (this.a == 1)
        b();
      cancel();
      return;
    case 0:
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i4 = paramMotionEvent.getPointerId(0);
    View localView1 = findTopChildUnder((int)f1, (int)f2);
    a(f1, f2, i4);
    a(localView1, i4);
    int i5 = this.h[i4];
    if ((i5 & this.p) != 0)
      this.r.onEdgeTouched(i5 & this.p, i4);
  }

  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.p = paramInt;
  }

  public void setMinVelocity(float paramFloat)
  {
    this.n = paramFloat;
  }

  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.t)
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    return a(paramInt1, paramInt2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
  }

  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0)
      cancel();
    if (this.l == null)
      this.l = VelocityTracker.obtain();
    this.l.addMovement(paramMotionEvent);
    switch (i1)
    {
    case 4:
    default:
    case 6:
    case 5:
    case 2:
    case 1:
    case 3:
    case 0:
    }
    while (true)
    {
      break;
      b(paramMotionEvent.getPointerId(i2));
      continue;
      int i20 = paramMotionEvent.getPointerId(i2);
      float f7 = paramMotionEvent.getX(i2);
      float f8 = paramMotionEvent.getY(i2);
      a(f7, f8, i20);
      if (this.a == 0)
      {
        int i21 = this.h[i20];
        if ((i21 & this.p) != 0)
          this.r.onEdgeTouched(i21 & this.p, i20);
      }
      else if (this.a == 2)
      {
        View localView3 = findTopChildUnder((int)f7, (int)f8);
        if (localView3 == this.s)
        {
          a(localView3, i20);
          continue;
          if ((this.d != null) && (this.e != null))
          {
            int i6 = paramMotionEvent.getPointerCount();
            for (int i7 = 0; i7 < i6; i7++)
            {
              int i8 = paramMotionEvent.getPointerId(i7);
              float f3 = paramMotionEvent.getX(i7);
              float f4 = paramMotionEvent.getY(i7);
              float f5 = f3 - this.d[i8];
              float f6 = f4 - this.e[i8];
              View localView2 = findTopChildUnder((int)f3, (int)f4);
              int i9;
              if ((localView2 != null) && (a(localView2, f5, f6)))
                i9 = 1;
              else
                i9 = 0;
              if (i9 != 0)
              {
                int i10 = localView2.getLeft();
                int i11 = (int)f5;
                int i12 = i10 + i11;
                int i13 = this.r.clampViewPositionHorizontal(localView2, i12, i11);
                int i14 = localView2.getTop();
                int i15 = (int)f6;
                int i16 = i14 + i15;
                int i17 = this.r.clampViewPositionVertical(localView2, i16, i15);
                int i18 = this.r.getViewHorizontalDragRange(localView2);
                int i19 = this.r.getViewVerticalDragRange(localView2);
                if (((i18 == 0) || ((i18 > 0) && (i13 == i10))) && ((i19 == 0) || ((i19 > 0) && (i17 == i14))))
                  break;
              }
              else
              {
                b(f5, f6, i8);
                if ((this.a == 1) || ((i9 != 0) && (a(localView2, i8))))
                  break;
              }
            }
            a(paramMotionEvent);
            continue;
            cancel();
            continue;
            float f1 = paramMotionEvent.getX();
            float f2 = paramMotionEvent.getY();
            int i3 = paramMotionEvent.getPointerId(0);
            a(f1, f2, i3);
            View localView1 = findTopChildUnder((int)f1, (int)f2);
            if ((localView1 == this.s) && (this.a == 2))
              a(localView1, i3);
            int i4 = this.h[i3];
            if ((i4 & this.p) != 0)
              this.r.onEdgeTouched(i4 & this.p, i3);
          }
        }
      }
    }
    int i5 = this.a;
    boolean bool = false;
    if (i5 == 1)
      bool = true;
    return bool;
  }

  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.s = paramView;
    this.c = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.a == 0) && (this.s != null))
      this.s = null;
    return bool;
  }

  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }

    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }

    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }

    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }

    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
    }

    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }

    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
    }

    public void onViewCaptured(View paramView, int paramInt)
    {
    }

    public void onViewDragStateChanged(int paramInt)
    {
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
    }

    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.ViewDragHelper
 * JD-Core Version:    0.6.2
 */