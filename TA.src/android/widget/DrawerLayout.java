package android.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DrawerLayout extends ViewGroup
  implements DrawerLayoutImpl
{
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNLOCKED = 0;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  static final DrawerLayoutCompatImpl a;
  private static final int[] b;
  private static final boolean c;
  private static final boolean d;
  private Drawable A;
  private CharSequence B;
  private CharSequence C;
  private Object D;
  private boolean E;
  private Drawable F = null;
  private Drawable G = null;
  private Drawable H = null;
  private Drawable I = null;
  private final ArrayList<View> J;
  private final View.AccessibilityDelegate e = new View.AccessibilityDelegate();
  private float f;
  private int g;
  private int h = -1728053248;
  private float i;
  private Paint j = new Paint();
  private final ViewDragHelper k;
  private final ViewDragHelper l;
  private final ViewDragCallback m;
  private final ViewDragCallback n;
  private int o;
  private boolean p;
  private boolean q = true;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private DrawerListener v;
  private float w;
  private float x;
  private Drawable y;
  private Drawable z;

  static
  {
    boolean bool1 = true;
    int[] arrayOfInt = new int[bool1];
    arrayOfInt[0] = 16842931;
    b = arrayOfInt;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 19)
      bool2 = true;
    else
      bool2 = false;
    c = bool2;
    if (Build.VERSION.SDK_INT < 21)
      bool1 = false;
    d = bool1;
    if (Build.VERSION.SDK_INT >= 21);
    for (Object localObject = new DrawerLayoutCompatImplApi21(); ; localObject = new DrawerLayoutCompatImplBase())
    {
      a = (DrawerLayoutCompatImpl)localObject;
      return;
    }
  }

  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.g = ((int)(0.5F + 64.0F * f1));
    float f2 = 400.0F * f1;
    this.m = new ViewDragCallback(3);
    this.n = new ViewDragCallback(5);
    this.k = ViewDragHelper.create(this, 1.0F, this.m);
    this.k.setEdgeTrackingEnabled(1);
    this.k.setMinVelocity(f2);
    this.m.setDragger(this.k);
    this.l = ViewDragHelper.create(this, 1.0F, this.n);
    this.l.setEdgeTrackingEnabled(2);
    this.l.setMinVelocity(f2);
    this.n.setDragger(this.l);
    setFocusableInTouchMode(true);
    setImportantForAccessibility(1);
    setAccessibilityDelegate(new View.AccessibilityDelegate());
    setMotionEventSplittingEnabled(false);
    if (getFitsSystemWindows())
    {
      a.configureApplyInsets(this);
      this.y = a.getDefaultStatusBarBackground(paramContext);
    }
    this.f = (f1 * 10.0F);
    this.J = new ArrayList();
  }

  private void a(View paramView, boolean paramBoolean)
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (((!paramBoolean) && (!f(localView))) || ((paramBoolean) && (localView == paramView)));
      for (int i3 = 1; ; i3 = 4)
      {
        localView.setImportantForAccessibility(i3);
        break;
        if (Build.VERSION.SDK_INT < 19)
          break;
      }
    }
  }

  private boolean a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null)
      return false;
    if ((Build.VERSION.SDK_INT >= 19) && (!paramDrawable.isAutoMirrored()))
      return false;
    setLayoutDirection(paramInt);
    return true;
  }

  static String b(int paramInt)
  {
    if ((paramInt & 0x3) == 3)
      return "LEFT";
    if ((paramInt & 0x5) == 5)
      return "RIGHT";
    return Integer.toHexString(paramInt);
  }

  private void d()
  {
    if (d)
      return;
    this.z = e();
    this.A = f();
  }

  private Drawable e()
  {
    int i1 = getLayoutDirection();
    if (i1 == 0)
    {
      if (this.F != null)
      {
        a(this.F, i1);
        return this.F;
      }
    }
    else if (this.G != null)
    {
      a(this.G, i1);
      return this.G;
    }
    return this.H;
  }

  private Drawable f()
  {
    int i1 = getLayoutDirection();
    if (i1 == 0)
    {
      if (this.G != null)
      {
        a(this.G, i1);
        return this.G;
      }
    }
    else if (this.F != null)
    {
      a(this.F, i1);
      return this.F;
    }
    return this.I;
  }

  private boolean g()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
      if (((LayoutParams)getChildAt(i2).getLayoutParams()).b)
        return true;
    return false;
  }

  private static boolean g(View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    boolean bool = false;
    if (localDrawable != null)
    {
      int i1 = localDrawable.getOpacity();
      bool = false;
      if (i1 == -1)
        bool = true;
    }
    return bool;
  }

  private boolean h()
  {
    return i() != null;
  }

  private View i()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if ((f(localView)) && (isDrawerVisible(localView)))
        return localView;
    }
    return null;
  }

  View a()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (((LayoutParams)localView.getLayoutParams()).c)
        return localView;
    }
    return null;
  }

  View a(int paramInt)
  {
    int i1 = 0x7 & Gravity.getAbsoluteGravity(paramInt, getLayoutDirection());
    int i2 = getChildCount();
    for (int i3 = 0; i3 < i2; i3++)
    {
      View localView = getChildAt(i3);
      if ((0x7 & d(localView)) == i1)
        return localView;
    }
    return null;
  }

  void a(int paramInt1, int paramInt2, View paramView)
  {
    int i1 = this.k.getViewDragState();
    int i2 = this.l.getViewDragState();
    int i3 = 2;
    if ((i1 != 1) && (i2 != 1))
    {
      if ((i1 != i3) && (i2 != i3))
        i3 = 0;
    }
    else
      i3 = 1;
    if ((paramView != null) && (paramInt2 == 0))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.a == 0.0F)
        a(paramView);
      else if (localLayoutParams.a == 1.0F)
        b(paramView);
    }
    if (i3 != this.o)
    {
      this.o = i3;
      if (this.v != null)
        this.v.onDrawerStateChanged(i3);
    }
  }

  void a(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.c)
    {
      localLayoutParams.c = false;
      if (this.v != null)
        this.v.onDrawerClosed(paramView);
      a(paramView, false);
      if (hasWindowFocus())
      {
        View localView = getRootView();
        if (localView != null)
          localView.sendAccessibilityEvent(32);
      }
    }
  }

  void a(View paramView, float paramFloat)
  {
    if (this.v != null)
      this.v.onDrawerSlide(paramView, paramFloat);
  }

  void a(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int i2 = 0;
    boolean bool1 = false;
    while (i2 < i1)
    {
      View localView = getChildAt(i2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((f(localView)) && ((!paramBoolean) || (localLayoutParams.b)))
      {
        int i3 = localView.getWidth();
        if (a(localView, 3));
        for (boolean bool2 = this.k.smoothSlideViewTo(localView, -i3, localView.getTop()); ; bool2 = this.l.smoothSlideViewTo(localView, getWidth(), localView.getTop()))
        {
          bool1 |= bool2;
          break;
        }
        localLayoutParams.b = false;
      }
      i2++;
    }
    this.m.removeCallbacks();
    this.n.removeCallbacks();
    if (bool1)
      invalidate();
  }

  boolean a(View paramView, int paramInt)
  {
    return (paramInt & d(paramView)) == paramInt;
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216)
      return;
    int i1 = getChildCount();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    while (i3 < i1)
    {
      View localView2 = getChildAt(i3);
      if (f(localView2))
      {
        if (isDrawerOpen(localView2))
        {
          localView2.addFocusables(paramArrayList, paramInt1, paramInt2);
          i4 = 1;
        }
      }
      else
        this.J.add(localView2);
      i3++;
    }
    if (i4 == 0)
    {
      int i5 = this.J.size();
      while (i2 < i5)
      {
        View localView1 = (View)this.J.get(i2);
        if (localView1.getVisibility() == 0)
          localView1.addFocusables(paramArrayList, paramInt1, paramInt2);
        i2++;
      }
    }
    this.J.clear();
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((a() == null) && (!f(paramView)));
    for (int i1 = 1; ; i1 = 4)
    {
      paramView.setImportantForAccessibility(i1);
      break;
      if (Build.VERSION.SDK_INT < 19)
        break;
    }
    if (!c)
      paramView.setAccessibilityDelegate(this.e);
  }

  void b()
  {
    if (!this.u)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      int i1 = getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
        getChildAt(i2).dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.u = true;
    }
  }

  void b(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.c)
    {
      localLayoutParams.c = true;
      if (this.v != null)
        this.v.onDrawerOpened(paramView);
      a(paramView, true);
      if (hasWindowFocus())
        sendAccessibilityEvent(32);
      paramView.requestFocus();
    }
  }

  void b(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.a)
      return;
    localLayoutParams.a = paramFloat;
    a(paramView, paramFloat);
  }

  float c(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).a;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void closeDrawer(int paramInt)
  {
    View localView = a(paramInt);
    if (localView == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No drawer view found with gravity ");
      localStringBuilder.append(b(paramInt));
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    closeDrawer(localView);
  }

  public void closeDrawer(View paramView)
  {
    if (!f(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a sliding drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (this.q)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      localLayoutParams.a = 0.0F;
      localLayoutParams.c = false;
    }
    else
    {
      ViewDragHelper localViewDragHelper;
      if (a(paramView, 3))
        localViewDragHelper = this.k;
      for (int i1 = -paramView.getWidth(); ; i1 = getWidth())
      {
        localViewDragHelper.smoothSlideViewTo(paramView, i1, paramView.getTop());
        break;
        localViewDragHelper = this.l;
      }
    }
    invalidate();
  }

  public void closeDrawers()
  {
    a(false);
  }

  public void computeScroll()
  {
    int i1 = getChildCount();
    float f1 = 0.0F;
    for (int i2 = 0; i2 < i1; i2++)
      f1 = Math.max(f1, ((LayoutParams)getChildAt(i2).getLayoutParams()).a);
    this.i = f1;
    if ((this.k.continueSettling(true) | this.l.continueSettling(true)))
      postInvalidateOnAnimation();
  }

  int d(View paramView)
  {
    return Gravity.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, getLayoutDirection());
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i1 = getHeight();
    boolean bool1 = e(paramView);
    int i2 = getWidth();
    int i3 = paramCanvas.save();
    int i4;
    int i5;
    if (bool1)
    {
      int i14 = getChildCount();
      i4 = i2;
      int i15 = 0;
      i5 = 0;
      while (i15 < i14)
      {
        View localView = getChildAt(i15);
        if ((localView != paramView) && (localView.getVisibility() == 0) && (g(localView)) && (f(localView)) && (localView.getHeight() >= i1))
          if (a(localView, 3))
          {
            int i17 = localView.getRight();
            if (i17 > i5)
              i5 = i17;
          }
          else
          {
            int i16 = localView.getLeft();
            if (i16 < i4)
              i4 = i16;
          }
        i15++;
      }
      paramCanvas.clipRect(i5, 0, i4, getHeight());
    }
    else
    {
      i4 = i2;
      i5 = 0;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i3);
    if ((this.i > 0.0F) && (bool1))
    {
      int i13 = (int)(((0xFF000000 & this.h) >>> 24) * this.i) << 24 | 0xFFFFFF & this.h;
      this.j.setColor(i13);
      paramCanvas.drawRect(i5, 0.0F, i4, getHeight(), this.j);
      return bool2;
    }
    if ((this.z != null) && (a(paramView, 3)))
    {
      int i10 = this.z.getIntrinsicWidth();
      int i11 = paramView.getRight();
      int i12 = this.k.getEdgeSize();
      float f2 = Math.max(0.0F, Math.min(i11 / i12, 1.0F));
      this.z.setBounds(i11, paramView.getTop(), i10 + i11, paramView.getBottom());
      this.z.setAlpha((int)(f2 * 255.0F));
    }
    for (Drawable localDrawable = this.z; ; localDrawable = this.A)
    {
      localDrawable.draw(paramCanvas);
      return bool2;
      if ((this.A == null) || (!a(paramView, 5)))
        break;
      int i6 = this.A.getIntrinsicWidth();
      int i7 = paramView.getLeft();
      int i8 = getWidth() - i7;
      int i9 = this.l.getEdgeSize();
      float f1 = Math.max(0.0F, Math.min(i8 / i9, 1.0F));
      this.A.setBounds(i7 - i6, paramView.getTop(), i7, paramView.getBottom());
      this.A.setAlpha((int)(f1 * 255.0F));
    }
    return bool2;
  }

  boolean e(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }

  boolean f(View paramView)
  {
    return (0x7 & Gravity.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, paramView.getLayoutDirection())) != 0;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
      return new LayoutParams((LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  public float getDrawerElevation()
  {
    if (d)
      return this.f;
    return 0.0F;
  }

  public int getDrawerLockMode(int paramInt)
  {
    int i1 = Gravity.getAbsoluteGravity(paramInt, getLayoutDirection());
    if (i1 == 3)
      return this.r;
    if (i1 == 5)
      return this.s;
    return 0;
  }

  public int getDrawerLockMode(View paramView)
  {
    int i1 = d(paramView);
    if (i1 == 3)
      return this.r;
    if (i1 == 5)
      return this.s;
    return 0;
  }

  public CharSequence getDrawerTitle(int paramInt)
  {
    int i1 = Gravity.getAbsoluteGravity(paramInt, getLayoutDirection());
    if (i1 == 3)
      return this.B;
    if (i1 == 5)
      return this.C;
    return null;
  }

  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.y;
  }

  public boolean isDrawerOpen(int paramInt)
  {
    View localView = a(paramInt);
    if (localView != null)
      return isDrawerOpen(localView);
    return false;
  }

  public boolean isDrawerOpen(View paramView)
  {
    if (!f(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return ((LayoutParams)paramView.getLayoutParams()).c;
  }

  public boolean isDrawerVisible(int paramInt)
  {
    View localView = a(paramInt);
    if (localView != null)
      return isDrawerVisible(localView);
    return false;
  }

  public boolean isDrawerVisible(View paramView)
  {
    if (!f(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return ((LayoutParams)paramView.getLayoutParams()).a > 0.0F;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.q = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.q = true;
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.E) && (this.y != null))
    {
      int i1 = a.getTopInset(this.D);
      if (i1 > 0)
      {
        this.y.setBounds(0, 0, getWidth(), i1);
        this.y.draw(paramCanvas);
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1 = this.k.shouldInterceptTouchEvent(paramMotionEvent) | this.l.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool2 = true;
    switch (i1)
    {
    default:
      break;
    case 2:
      if (this.k.checkTouchSlop(3))
      {
        this.m.removeCallbacks();
        this.n.removeCallbacks();
      }
      break;
    case 1:
    case 3:
      a(bool2);
      this.t = false;
      this.u = false;
      break;
    case 0:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.w = f1;
      this.x = f2;
      if (this.i > 0.0F)
      {
        View localView = this.k.findTopChildUnder((int)f1, (int)f2);
        if ((localView != null) && (e(localView)))
        {
          i2 = 1;
          break label177;
        }
      }
      i2 = 0;
      label177: this.t = false;
      this.u = false;
      break;
    }
    int i2 = 0;
    if ((!bool1) && (i2 == 0) && (!g()))
    {
      if (this.u)
        return bool2;
      bool2 = false;
    }
    return bool2;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (h()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      View localView = i();
      if ((localView != null) && (getDrawerLockMode(localView) == 0))
        closeDrawers();
      return localView != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p = true;
    int i1 = paramInt3 - paramInt1;
    int i2 = getChildCount();
    for (int i3 = 0; i3 < i2; i3++)
    {
      View localView = getChildAt(i3);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (e(localView))
        {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
        else
        {
          int i4 = localView.getMeasuredWidth();
          int i5 = localView.getMeasuredHeight();
          int i7;
          float f2;
          if (a(localView, 3))
          {
            int i14 = -i4;
            float f3 = i4;
            i7 = i14 + (int)(f3 * localLayoutParams.a);
            f2 = (i4 + i7) / f3;
          }
          else
          {
            float f1 = i4;
            int i6 = i1 - (int)(f1 * localLayoutParams.a);
            f2 = (i1 - i6) / f1;
            i7 = i6;
          }
          int i8;
          if (f2 != localLayoutParams.a)
            i8 = 1;
          else
            i8 = 0;
          int i9 = 0x70 & localLayoutParams.gravity;
          if (i9 != 16)
          {
            if (i9 != 80)
            {
              localView.layout(i7, localLayoutParams.topMargin, i4 + i7, i5 + localLayoutParams.topMargin);
            }
            else
            {
              int i13 = paramInt4 - paramInt2;
              localView.layout(i7, i13 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i4 + i7, i13 - localLayoutParams.bottomMargin);
            }
          }
          else
          {
            int i10 = paramInt4 - paramInt2;
            int i11 = (i10 - i5) / 2;
            if (i11 < localLayoutParams.topMargin)
              i11 = localLayoutParams.topMargin;
            else if (i11 + i5 > i10 - localLayoutParams.bottomMargin)
              i11 = i10 - localLayoutParams.bottomMargin - i5;
            localView.layout(i7, i11, i4 + i7, i5 + i11);
          }
          if (i8 != 0)
            b(localView, f2);
          int i12;
          if (localLayoutParams.a > 0.0F)
            i12 = 0;
          else
            i12 = 4;
          if (localView.getVisibility() != i12)
            localView.setVisibility(i12);
        }
      }
    }
    this.p = false;
    this.q = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if ((i1 != 1073741824) || (i2 != 1073741824))
    {
      if (!isInEditMode())
        break label542;
      if ((i1 != -2147483648) && (i1 == 0))
        i3 = 300;
      if ((i2 != -2147483648) && (i2 == 0))
        i4 = 300;
    }
    setMeasuredDimension(i3, i4);
    int i5;
    if ((this.D != null) && (getFitsSystemWindows()))
      i5 = 1;
    else
      i5 = 0;
    int i6 = getLayoutDirection();
    int i7 = getChildCount();
    int i8 = 0;
    while (i8 < i7)
    {
      View localView = getChildAt(i8);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (i5 != 0)
        {
          int i12 = Gravity.getAbsoluteGravity(localLayoutParams.gravity, i6);
          if (localView.getFitsSystemWindows())
            a.dispatchChildInsets(localView, this.D, i12);
          else
            a.applyMarginInsets(localLayoutParams, this.D, i12);
        }
        int i10;
        if (e(localView))
          i10 = View.MeasureSpec.makeMeasureSpec(i3 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824);
        for (int i11 = View.MeasureSpec.makeMeasureSpec(i4 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824); ; i11 = getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height))
        {
          localView.measure(i10, i11);
          break;
          if (!f(localView))
            break label476;
          if ((d) && (localView.getElevation() != this.f))
            localView.setElevation(this.f);
          int i9 = 0x7 & d(localView);
          if ((0x0 & i9) != 0)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("Child drawer has absolute gravity ");
            localStringBuilder2.append(b(i9));
            localStringBuilder2.append(" but this ");
            localStringBuilder2.append("DrawerLayout");
            localStringBuilder2.append(" already has a drawer view along that edge");
            throw new IllegalStateException(localStringBuilder2.toString());
          }
          i10 = getChildMeasureSpec(paramInt1, this.g + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width);
        }
      }
      i8++;
      continue;
      label476: StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Child ");
      localStringBuilder1.append(localView);
      localStringBuilder1.append(" at index ");
      localStringBuilder1.append(i8);
      localStringBuilder1.append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      throw new IllegalStateException(localStringBuilder1.toString());
    }
    return;
    label542: throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a != 0)
    {
      View localView = a(localSavedState.a);
      if (localView != null)
        openDrawer(localView);
    }
    setDrawerLockMode(localSavedState.b, 3);
    setDrawerLockMode(localSavedState.c, 5);
  }

  public void onRtlPropertiesChanged(int paramInt)
  {
    d();
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    View localView = a();
    if (localView != null)
      localSavedState.a = ((LayoutParams)localView.getLayoutParams()).gravity;
    localSavedState.b = this.r;
    localSavedState.c = this.s;
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.k.processTouchEvent(paramMotionEvent);
    this.l.processTouchEvent(paramMotionEvent);
    int i1 = 0xFF & paramMotionEvent.getAction();
    if (i1 != 3)
    {
      switch (i1)
      {
      default:
        return true;
      case 1:
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        View localView1 = this.k.findTopChildUnder((int)f3, (int)f4);
        if ((localView1 != null) && (e(localView1)))
        {
          float f5 = f3 - this.w;
          float f6 = f4 - this.x;
          int i2 = this.k.getTouchSlop();
          if (f5 * f5 + f6 * f6 < i2 * i2)
          {
            View localView2 = a();
            if ((localView2 != null) && (getDrawerLockMode(localView2) != 2))
            {
              bool = false;
              break label176;
            }
          }
        }
        boolean bool = true;
        label176: a(bool);
        this.t = false;
        return true;
      case 0:
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.w = f1;
      this.x = f2;
    }
    while (true)
    {
      this.t = false;
      this.u = false;
      return true;
      a(true);
    }
  }

  public void openDrawer(int paramInt)
  {
    View localView = a(paramInt);
    if (localView == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No drawer view found with gravity ");
      localStringBuilder.append(b(paramInt));
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    openDrawer(localView);
  }

  public void openDrawer(View paramView)
  {
    if (!f(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a sliding drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (this.q)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      localLayoutParams.a = 1.0F;
      localLayoutParams.c = true;
      a(paramView, true);
    }
    else
    {
      ViewDragHelper localViewDragHelper;
      if (a(paramView, 3))
        localViewDragHelper = this.k;
      for (int i1 = 0; ; i1 = getWidth() - paramView.getWidth())
      {
        localViewDragHelper.smoothSlideViewTo(paramView, i1, paramView.getTop());
        break;
        localViewDragHelper = this.l;
      }
    }
    invalidate();
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.t = paramBoolean;
    if (paramBoolean)
      a(true);
  }

  public void requestLayout()
  {
    if (!this.p)
      super.requestLayout();
  }

  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.D = paramObject;
    this.E = paramBoolean;
    boolean bool;
    if ((!paramBoolean) && (getBackground() == null))
      bool = true;
    else
      bool = false;
    setWillNotDraw(bool);
    requestLayout();
  }

  public void setDrawerElevation(float paramFloat)
  {
    this.f = paramFloat;
    if (Build.VERSION.SDK_INT >= 21)
      for (int i1 = 0; i1 < getChildCount(); i1++)
      {
        View localView = getChildAt(i1);
        if (f(localView))
          localView.setElevation(this.f);
      }
  }

  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    this.v = paramDrawerListener;
  }

  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }

  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i1 = Gravity.getAbsoluteGravity(paramInt2, getLayoutDirection());
    if (i1 == 3)
      this.r = paramInt1;
    else if (i1 == 5)
      this.s = paramInt1;
    if (paramInt1 != 0)
    {
      ViewDragHelper localViewDragHelper;
      if (i1 == 3)
        localViewDragHelper = this.k;
      else
        localViewDragHelper = this.l;
      localViewDragHelper.cancel();
    }
    switch (paramInt1)
    {
    default:
    case 2:
      View localView2 = a(i1);
      if (localView2 != null)
      {
        openDrawer(localView2);
        return;
      }
      break;
    case 1:
      View localView1 = a(i1);
      if (localView1 != null)
        closeDrawer(localView1);
      break;
    }
  }

  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (!f(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a drawer with appropriate layout_gravity");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
  }

  public void setDrawerShadow(int paramInt1, int paramInt2)
  {
    setDrawerShadow(getResources().getDrawable(paramInt1), paramInt2);
  }

  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (d)
      return;
    if ((paramInt & 0x800003) == 8388611)
    {
      this.F = paramDrawable;
    }
    else if ((paramInt & 0x800005) == 8388613)
    {
      this.G = paramDrawable;
    }
    else if ((paramInt & 0x3) == 3)
    {
      this.H = paramDrawable;
    }
    else
    {
      if ((paramInt & 0x5) != 5)
        return;
      this.I = paramDrawable;
    }
    d();
    invalidate();
  }

  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence)
  {
    int i1 = Gravity.getAbsoluteGravity(paramInt, getLayoutDirection());
    if (i1 == 3)
    {
      this.B = paramCharSequence;
      return;
    }
    if (i1 == 5)
      this.C = paramCharSequence;
  }

  public void setScrimColor(int paramInt)
  {
    this.h = paramInt;
    invalidate();
  }

  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0)
      localDrawable = getContext().getResources().getDrawable(paramInt);
    else
      localDrawable = null;
    this.y = localDrawable;
    invalidate();
  }

  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.y = paramDrawable;
    invalidate();
  }

  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.y = new ColorDrawable(paramInt);
    invalidate();
  }

  @SuppressLint({"NewApi"})
  public static class DrawerLayoutCompatApi21
  {
    private static final int[] a = { 16843828 };

    public static void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      WindowInsets localWindowInsets = (WindowInsets)paramObject;
      if (paramInt == 3)
        localWindowInsets = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
      else if (paramInt == 5)
        localWindowInsets = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
      paramMarginLayoutParams.leftMargin = localWindowInsets.getSystemWindowInsetLeft();
      paramMarginLayoutParams.topMargin = localWindowInsets.getSystemWindowInsetTop();
      paramMarginLayoutParams.rightMargin = localWindowInsets.getSystemWindowInsetRight();
      paramMarginLayoutParams.bottomMargin = localWindowInsets.getSystemWindowInsetBottom();
    }

    public static void configureApplyInsets(View paramView)
    {
      if ((paramView instanceof DrawerLayoutImpl))
      {
        paramView.setOnApplyWindowInsetsListener(new InsetsListener());
        paramView.setSystemUiVisibility(1280);
      }
    }

    public static void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
      WindowInsets localWindowInsets = (WindowInsets)paramObject;
      if (paramInt == 3)
        localWindowInsets = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
      else if (paramInt == 5)
        localWindowInsets = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
      paramView.dispatchApplyWindowInsets(localWindowInsets);
    }

    public static Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(a);
      try
      {
        Drawable localDrawable = localTypedArray.getDrawable(0);
        return localDrawable;
      }
      finally
      {
        localTypedArray.recycle();
      }
    }

    public static int getTopInset(Object paramObject)
    {
      if (paramObject != null)
        return ((WindowInsets)paramObject).getSystemWindowInsetTop();
      return 0;
    }

    static class InsetsListener
      implements View.OnApplyWindowInsetsListener
    {
      public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
      {
        DrawerLayoutImpl localDrawerLayoutImpl = (DrawerLayoutImpl)paramView;
        boolean bool;
        if (paramWindowInsets.getSystemWindowInsetTop() > 0)
          bool = true;
        else
          bool = false;
        localDrawerLayoutImpl.setChildInsets(paramWindowInsets, bool);
        return paramWindowInsets.consumeSystemWindowInsets();
      }
    }
  }

  static abstract interface DrawerLayoutCompatImpl
  {
    public abstract void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt);

    public abstract void configureApplyInsets(View paramView);

    public abstract void dispatchChildInsets(View paramView, Object paramObject, int paramInt);

    public abstract Drawable getDefaultStatusBarBackground(Context paramContext);

    public abstract int getTopInset(Object paramObject);
  }

  @SuppressLint({"NewApi"})
  static class DrawerLayoutCompatImplApi21
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      DrawerLayout.DrawerLayoutCompatApi21.applyMarginInsets(paramMarginLayoutParams, paramObject, paramInt);
    }

    public void configureApplyInsets(View paramView)
    {
      DrawerLayout.DrawerLayoutCompatApi21.configureApplyInsets(paramView);
    }

    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
      DrawerLayout.DrawerLayoutCompatApi21.dispatchChildInsets(paramView, paramObject, paramInt);
    }

    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return DrawerLayout.DrawerLayoutCompatApi21.getDefaultStatusBarBackground(paramContext);
    }

    public int getTopInset(Object paramObject)
    {
      return DrawerLayout.DrawerLayoutCompatApi21.getTopInset(paramObject);
    }
  }

  @SuppressLint({"NewApi"})
  static class DrawerLayoutCompatImplBase
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
    }

    public void configureApplyInsets(View paramView)
    {
    }

    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
    }

    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return null;
    }

    public int getTopInset(Object paramObject)
    {
      return 0;
    }
  }

  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed(View paramView);

    public abstract void onDrawerOpened(View paramView);

    public abstract void onDrawerSlide(View paramView, float paramFloat);

    public abstract void onDrawerStateChanged(int paramInt);
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface EdgeGravity
  {
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    float a;
    boolean b;
    boolean c;
    public int gravity = 0;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2);
      this.gravity = paramInt3;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.c());
      this.gravity = localTypedArray.getInt(0, 0);
      localTypedArray.recycle();
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface LockMode
  {
  }

  protected static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel);
      }

      public DrawerLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new DrawerLayout.SavedState[paramAnonymousInt];
      }
    };
    int a = 0;
    int b = 0;
    int c = 0;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
    }
  }

  public static abstract class SimpleDrawerListener
    implements DrawerLayout.DrawerListener
  {
    public void onDrawerClosed(View paramView)
    {
    }

    public void onDrawerOpened(View paramView)
    {
    }

    public void onDrawerSlide(View paramView, float paramFloat)
    {
    }

    public void onDrawerStateChanged(int paramInt)
    {
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface State
  {
  }

  private class ViewDragCallback extends ViewDragHelper.Callback
  {
    private final int b;
    private ViewDragHelper c;
    private final Runnable d = new Runnable()
    {
      public void run()
      {
        DrawerLayout.ViewDragCallback.a(DrawerLayout.ViewDragCallback.this);
      }
    };

    public ViewDragCallback(int arg2)
    {
      int i;
      this.b = i;
    }

    private void a()
    {
      int i = this.b;
      int j = 3;
      if (i == j)
        j = 5;
      View localView = DrawerLayout.this.a(j);
      if (localView != null)
        DrawerLayout.this.closeDrawer(localView);
    }

    private void b()
    {
      int i = this.c.getEdgeSize();
      int j;
      if (this.b == 3)
        j = 1;
      else
        j = 0;
      View localView;
      int k;
      if (j != 0)
      {
        localView = DrawerLayout.this.a(3);
        int m = 0;
        if (localView != null)
          m = -localView.getWidth();
        k = m + i;
      }
      else
      {
        localView = DrawerLayout.this.a(5);
        k = DrawerLayout.this.getWidth() - i;
      }
      if ((localView != null) && (((j != 0) && (localView.getLeft() < k)) || ((j == 0) && (localView.getLeft() > k) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.c.smoothSlideViewTo(localView, k, localView.getTop());
        localLayoutParams.b = true;
        DrawerLayout.this.invalidate();
        a();
        DrawerLayout.this.b();
      }
    }

    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      int j;
      int i;
      if (DrawerLayout.this.a(paramView, 3))
      {
        j = -paramView.getWidth();
        i = 0;
      }
      while (true)
      {
        return Math.max(j, Math.min(paramInt1, i));
        i = DrawerLayout.this.getWidth();
        j = i - paramView.getWidth();
      }
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }

    public int getViewHorizontalDragRange(View paramView)
    {
      if (DrawerLayout.this.f(paramView))
        return paramView.getWidth();
      return 0;
    }

    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      DrawerLayout localDrawerLayout;
      if ((paramInt1 & 0x1) == 1)
        localDrawerLayout = DrawerLayout.this;
      View localView;
      for (int i = 3; ; i = 5)
      {
        localView = localDrawerLayout.a(i);
        break;
        localDrawerLayout = DrawerLayout.this;
      }
      if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))
        this.c.captureChildView(localView, paramInt2);
    }

    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }

    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.d, 160L);
    }

    public void onViewCaptured(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).b = false;
      a();
    }

    public void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout.this.a(this.b, paramInt, this.c.getCapturedView());
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = paramView.getWidth();
      if (DrawerLayout.this.a(paramView, 3));
      float f2;
      for (float f1 = paramInt1 + i; ; f1 = DrawerLayout.this.getWidth() - paramInt1)
      {
        f2 = f1 / i;
        break;
      }
      DrawerLayout.this.b(paramView, f2);
      int j;
      if (f2 == 0.0F)
        j = 4;
      else
        j = 0;
      paramView.setVisibility(j);
      DrawerLayout.this.invalidate();
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      float f = DrawerLayout.this.c(paramView);
      int i = paramView.getWidth();
      int k;
      if (DrawerLayout.this.a(paramView, 3))
      {
        if ((paramFloat1 <= 0.0F) && ((paramFloat1 != 0.0F) || (f <= 0.5F)))
          k = -i;
        else
          k = 0;
      }
      else
      {
        int j = DrawerLayout.this.getWidth();
        if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (f > 0.5F)))
          j -= i;
        k = j;
      }
      this.c.settleCapturedViewAt(k, paramView.getTop());
      DrawerLayout.this.invalidate();
    }

    public void removeCallbacks()
    {
      DrawerLayout.this.removeCallbacks(this.d);
    }

    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      this.c = paramViewDragHelper;
    }

    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (DrawerLayout.this.f(paramView)) && (DrawerLayout.this.a(paramView, this.b)) && (DrawerLayout.this.getDrawerLockMode(paramView) == 0);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.DrawerLayout
 * JD-Core Version:    0.6.2
 */