package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PageView extends ViewGroup
{
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final int[] a = { 16842931 };
  private static final Comparator<ItemInfo> b = new Comparator()
  {
    public int compare(PageView.ItemInfo paramAnonymousItemInfo1, PageView.ItemInfo paramAnonymousItemInfo2)
    {
      return paramAnonymousItemInfo1.b - paramAnonymousItemInfo2.b;
    }
  };
  private static final Interpolator c = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      float f = paramAnonymousFloat - 1.0F;
      return 1.0F + f * (f * (f * (f * f)));
    }
  };
  private static final ViewPositionComparator d = new ViewPositionComparator();
  private int A = 1;
  private boolean B;
  private boolean C;
  private int D;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private int K = -1;
  private VelocityTracker L;
  private int M;
  private int N;
  private int O;
  private int P;
  private boolean Q;
  private long R;
  private EdgeEffect S;
  private EdgeEffect T;
  private boolean U = true;
  private boolean V = false;
  private boolean W;
  private int aa;
  private List<OnPageChangeListener> ab;
  private OnPageChangeListener ac;
  private OnPageChangeListener ad;
  private OnAdapterChangeListener ae;
  private PageTransformer af;
  private Method ag;
  private int ah;
  private ArrayList<View> ai;
  private int aj = 0;
  private final Runnable ak = new Runnable()
  {
    public void run()
    {
      PageView.a(PageView.this, 0);
      PageView.this.c();
    }
  };
  private boolean al = true;
  private final ArrayList<ItemInfo> e = new ArrayList();
  private final ItemInfo f = new ItemInfo();
  private final Rect g = new Rect();
  private int h;
  private BasePageAdapter i;
  private int j;
  private int k = -1;
  private Parcelable l = null;
  private ClassLoader m = null;
  private Scroller n;
  private PageObserver o;
  private int p;
  private Drawable q;
  private int r;
  private int s;
  private float t = -3.402824E+038F;
  private float u = 3.4028235E+38F;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;

  public PageView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public PageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.O) && (Math.abs(paramInt2) > this.M))
    {
      if (paramInt2 <= 0)
        paramInt1++;
    }
    else
    {
      float f1;
      if (paramInt1 >= this.j)
        f1 = 0.4F;
      else
        f1 = 0.6F;
      paramInt1 = (int)(f1 + (paramFloat + paramInt1));
    }
    if (this.e.size() > 0)
    {
      ItemInfo localItemInfo1 = (ItemInfo)this.e.get(0);
      ItemInfo localItemInfo2 = (ItemInfo)this.e.get(-1 + this.e.size());
      paramInt1 = Math.max(localItemInfo1.b, Math.min(paramInt1, localItemInfo2.b));
    }
    return paramInt1;
  }

  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null)
      paramRect = new Rect();
    if (paramView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return paramRect;
    }
    paramRect.left = paramView.getLeft();
    paramRect.right = paramView.getRight();
    paramRect.top = paramView.getTop();
    paramRect.bottom = paramView.getBottom();
    ViewGroup localViewGroup;
    for (ViewParent localViewParent = paramView.getParent(); ((localViewParent instanceof ViewGroup)) && (localViewParent != this); localViewParent = localViewGroup.getParent())
    {
      localViewGroup = (ViewGroup)localViewParent;
      paramRect.left += localViewGroup.getLeft();
      paramRect.right += localViewGroup.getRight();
      paramRect.top += localViewGroup.getTop();
      paramRect.bottom += localViewGroup.getBottom();
    }
    return paramRect;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      int i2 = paramInt3 + (paramInt1 - getPaddingLeft() - getPaddingRight());
      int i3 = paramInt4 + (paramInt2 - getPaddingLeft() - getPaddingRight());
      int i4 = (int)(getScrollX() / i3 * i2);
      scrollTo(i4, getScrollY());
      if (!this.n.isFinished())
      {
        int i5 = this.n.getDuration() - this.n.timePassed();
        ItemInfo localItemInfo2 = b(this.j);
        this.n.startScroll(i4, 0, (int)(localItemInfo2.e * paramInt1), 0, i5);
      }
    }
    else
    {
      ItemInfo localItemInfo1 = b(this.j);
      float f1;
      if (localItemInfo1 != null)
        f1 = Math.min(localItemInfo1.e, this.u);
      else
        f1 = 0.0F;
      int i1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (i1 != getScrollX())
      {
        a(false);
        scrollTo(i1, getScrollY());
      }
    }
  }

  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = b(paramInt1);
    int i1;
    if (localItemInfo != null)
      i1 = (int)(getClientWidth() * Math.max(this.t, Math.min(localItemInfo.e, this.u)));
    else
      i1 = 0;
    if (paramBoolean1)
    {
      a(i1, 0, paramInt2);
      if (paramBoolean2)
        d(paramInt1);
    }
    else
    {
      if (paramBoolean2)
        d(paramInt1);
      a(false);
      scrollTo(i1, 0);
      c(i1);
    }
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.K)
    {
      int i2;
      if (i1 == 0)
        i2 = 1;
      else
        i2 = 0;
      this.G = paramMotionEvent.getX(i2);
      this.K = paramMotionEvent.getPointerId(i2);
      if (this.L != null)
        this.L.clear();
    }
  }

  private void a(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    int i1 = this.i.getCount();
    int i2 = getClientWidth();
    float f1;
    if (i2 > 0)
      f1 = this.p / i2;
    else
      f1 = 0.0F;
    if (paramItemInfo2 != null)
    {
      int i12 = paramItemInfo2.b;
      if (i12 < paramItemInfo1.b)
      {
        float f7 = f1 + (paramItemInfo2.e + paramItemInfo2.d);
        int i15 = i12 + 1;
        int i16 = 0;
        while ((i15 <= paramItemInfo1.b) && (i16 < this.e.size()))
        {
          ItemInfo localItemInfo4;
          while (true)
          {
            localItemInfo4 = (ItemInfo)this.e.get(i16);
            if ((i15 <= localItemInfo4.b) || (i16 >= -1 + this.e.size()))
              break;
            i16++;
          }
          while (i15 < localItemInfo4.b)
          {
            f7 += f1 + this.i.getPageWidth(i15);
            i15++;
          }
          localItemInfo4.e = f7;
          f7 += f1 + localItemInfo4.d;
          i15++;
        }
      }
      if (i12 > paramItemInfo1.b)
      {
        int i13 = -1 + this.e.size();
        float f6 = paramItemInfo2.e;
        for (int i14 = i12 - 1; (i14 >= paramItemInfo1.b) && (i13 >= 0); i14--)
        {
          ItemInfo localItemInfo3;
          while (true)
          {
            localItemInfo3 = (ItemInfo)this.e.get(i13);
            if ((i14 >= localItemInfo3.b) || (i13 <= 0))
              break;
            i13--;
          }
          while (i14 > localItemInfo3.b)
          {
            f6 -= f1 + this.i.getPageWidth(i14);
            i14--;
          }
          f6 -= f1 + localItemInfo3.d;
          localItemInfo3.e = f6;
        }
      }
    }
    int i3 = this.e.size();
    float f2 = paramItemInfo1.e;
    int i4 = -1 + paramItemInfo1.b;
    float f3;
    if (paramItemInfo1.b == 0)
      f3 = paramItemInfo1.e;
    else
      f3 = -3.402824E+038F;
    this.t = f3;
    int i5 = paramItemInfo1.b;
    int i6 = i1 - 1;
    float f4;
    if (i5 == i6)
      f4 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
    else
      f4 = 3.4028235E+38F;
    this.u = f4;
    int i7 = paramInt - 1;
    while (i7 >= 0)
    {
      ItemInfo localItemInfo2 = (ItemInfo)this.e.get(i7);
      while (i4 > localItemInfo2.b)
      {
        BasePageAdapter localBasePageAdapter2 = this.i;
        int i11 = i4 - 1;
        f2 -= f1 + localBasePageAdapter2.getPageWidth(i4);
        i4 = i11;
      }
      f2 -= f1 + localItemInfo2.d;
      localItemInfo2.e = f2;
      if (localItemInfo2.b == 0)
        this.t = f2;
      i7--;
      i4--;
    }
    float f5 = f1 + (paramItemInfo1.e + paramItemInfo1.d);
    int i8 = 1 + paramItemInfo1.b;
    int i9 = paramInt + 1;
    while (i9 < i3)
    {
      ItemInfo localItemInfo1 = (ItemInfo)this.e.get(i9);
      while (i8 < localItemInfo1.b)
      {
        BasePageAdapter localBasePageAdapter1 = this.i;
        int i10 = i8 + 1;
        f5 += f1 + localBasePageAdapter1.getPageWidth(i8);
        i8 = i10;
      }
      if (localItemInfo1.b == i6)
        this.u = (f5 + localItemInfo1.d - 1.0F);
      localItemInfo1.e = f5;
      f5 += f1 + localItemInfo1.d;
      i9++;
      i8++;
    }
    this.V = false;
  }

  private void a(boolean paramBoolean)
  {
    int i1;
    if (this.aj == 2)
      i1 = 1;
    else
      i1 = 0;
    if (i1 != 0)
    {
      setScrollingCacheEnabled(false);
      this.n.abortAnimation();
      int i4 = getScrollX();
      int i5 = getScrollY();
      int i6 = this.n.getCurrX();
      int i7 = this.n.getCurrY();
      if ((i4 != i6) || (i5 != i7))
      {
        scrollTo(i6, i7);
        if (i6 != i4)
          c(i6);
      }
    }
    this.z = false;
    int i2 = i1;
    for (int i3 = 0; i3 < this.e.size(); i3++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.e.get(i3);
      if (localItemInfo.c)
      {
        localItemInfo.c = false;
        i2 = 1;
      }
    }
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        postOnAnimation(this.ak);
        return;
      }
      this.ak.run();
    }
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.E) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.E) && (paramFloat2 < 0.0F));
  }

  private void b(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.ac != null)
      this.ac.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.ab != null)
    {
      int i1 = 0;
      int i2 = this.ab.size();
      while (i1 < i2)
      {
        OnPageChangeListener localOnPageChangeListener = (OnPageChangeListener)this.ab.get(i1);
        if (localOnPageChangeListener != null)
          localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
        i1++;
      }
    }
    if (this.ad != null)
      this.ad.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }

  private void b(boolean paramBoolean)
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3;
      if (paramBoolean)
        i3 = 2;
      else
        i3 = 0;
      getChildAt(i2).setLayerType(i3, null);
    }
  }

  private boolean b(float paramFloat)
  {
    float f1 = this.G - paramFloat;
    this.G = paramFloat;
    float f2 = f1 + getScrollX();
    float f3 = getClientWidth();
    float f4 = f3 * this.t;
    float f5 = f3 * this.u;
    ItemInfo localItemInfo1 = (ItemInfo)this.e.get(0);
    ArrayList localArrayList = this.e;
    int i1 = this.e.size();
    int i2 = 1;
    ItemInfo localItemInfo2 = (ItemInfo)localArrayList.get(i1 - i2);
    int i3;
    if (localItemInfo1.b != 0)
    {
      f4 = f3 * localItemInfo1.e;
      i3 = 0;
    }
    else
    {
      i3 = 1;
    }
    if (localItemInfo2.b != this.i.getCount() - i2)
    {
      f5 = f3 * localItemInfo2.e;
      i2 = 0;
    }
    if (f2 < f4)
    {
      if (i3 != 0)
      {
        float f8 = f4 - f2;
        this.S.onPull(Math.abs(f8) / f3);
      }
      f2 = f4;
    }
    else if (f2 > f5)
    {
      if (i2 != 0)
      {
        float f7 = f2 - f5;
        this.T.onPull(Math.abs(f7) / f3);
      }
      f2 = f5;
    }
    float f6 = this.G;
    int i4 = (int)f2;
    this.G = (f6 + (f2 - i4));
    scrollTo(i4, getScrollY());
    c(i4);
    return false;
  }

  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  private boolean c(int paramInt)
  {
    if (this.e.size() == 0)
    {
      this.W = false;
      a(0, 0.0F, 0);
      if (!this.W)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      return false;
    }
    ItemInfo localItemInfo = j();
    int i1 = getClientWidth();
    int i2 = i1 + this.p;
    float f1 = this.p;
    float f2 = i1;
    float f3 = f1 / f2;
    int i3 = localItemInfo.b;
    float f4 = (paramInt / f2 - localItemInfo.e) / (f3 + localItemInfo.d);
    int i4 = (int)(f4 * i2);
    this.W = false;
    a(i3, f4, i4);
    if (!this.W)
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    return true;
  }

  private void d(int paramInt)
  {
    if (this.ac != null)
    {
      this.ac.onPageSelected(paramInt);
      this.ac.onPageChange(getChildAt(paramInt), paramInt);
    }
    if (this.ab != null)
    {
      int i1 = 0;
      int i2 = this.ab.size();
      while (i1 < i2)
      {
        OnPageChangeListener localOnPageChangeListener = (OnPageChangeListener)this.ab.get(i1);
        if (localOnPageChangeListener != null)
          localOnPageChangeListener.onPageSelected(paramInt);
        i1++;
      }
    }
    if (this.ad != null)
      this.ad.onPageSelected(paramInt);
  }

  private void e(int paramInt)
  {
    if (this.ac != null)
      this.ac.onPageScrollStateChanged(paramInt);
    if (this.ab != null)
    {
      int i1 = 0;
      int i2 = this.ab.size();
      while (i1 < i2)
      {
        OnPageChangeListener localOnPageChangeListener = (OnPageChangeListener)this.ab.get(i1);
        if (localOnPageChangeListener != null)
          localOnPageChangeListener.onPageScrollStateChanged(paramInt);
        i1++;
      }
    }
    if (this.ad != null)
      this.ad.onPageScrollStateChanged(paramInt);
  }

  private void g()
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
      if (!((LayoutParams)getChildAt(i1).getLayoutParams()).isDecor)
      {
        removeViewAt(i1);
        i1--;
      }
  }

  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }

  private void h()
  {
    if (this.ah != 0)
    {
      if (this.ai == null)
        this.ai = new ArrayList();
      else
        this.ai.clear();
      int i1 = getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
      {
        View localView = getChildAt(i2);
        this.ai.add(localView);
      }
      Collections.sort(this.ai, d);
    }
  }

  private boolean i()
  {
    this.K = -1;
    k();
    this.S.onRelease();
    this.T.onRelease();
    return true;
  }

  private ItemInfo j()
  {
    int i1 = getClientWidth();
    float f1;
    if (i1 > 0)
      f1 = getScrollX() / i1;
    else
      f1 = 0.0F;
    float f2;
    if (i1 > 0)
      f2 = this.p / i1;
    else
      f2 = 0.0F;
    Object localObject = null;
    int i2 = 0;
    int i3 = 1;
    int i4 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i2 < this.e.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.e.get(i2);
      if (i3 == 0)
      {
        int i5 = localItemInfo.b;
        int i6 = i4 + 1;
        if (i5 != i6)
        {
          localItemInfo = this.f;
          localItemInfo.e = (f2 + (f3 + f4));
          localItemInfo.b = i6;
          localItemInfo.d = this.i.getPageWidth(localItemInfo.b);
          i2--;
        }
      }
      f3 = localItemInfo.e;
      float f5 = f2 + (f3 + localItemInfo.d);
      if ((i3 == 0) && (f1 < f3))
        return localObject;
      if (f1 >= f5)
      {
        if (i2 == this.e.size() - 1)
          return localItemInfo;
        i4 = localItemInfo.b;
        f4 = localItemInfo.d;
        i2++;
        localObject = localItemInfo;
        i3 = 0;
      }
      else
      {
        return localItemInfo;
      }
    }
    return localObject;
  }

  private void k()
  {
    this.B = false;
    this.C = false;
    if (this.L != null)
    {
      this.L.recycle();
      this.L = null;
    }
  }

  private void setScrollState(int paramInt)
  {
    if (this.aj == paramInt)
      return;
    this.aj = paramInt;
    if (this.af != null)
    {
      boolean bool;
      if (paramInt != 0)
        bool = true;
      else
        bool = false;
      b(bool);
    }
    e(paramInt);
  }

  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.y != paramBoolean)
      this.y = paramBoolean;
  }

  float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  ItemInfo a(int paramInt1, int paramInt2)
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.b = paramInt1;
    localItemInfo.a = this.i.instantiateItem(this, paramInt1);
    localItemInfo.d = this.i.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.e.size()))
    {
      this.e.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.e.add(localItemInfo);
    return localItemInfo;
  }

  ItemInfo a(View paramView)
  {
    for (int i1 = 0; i1 < this.e.size(); i1++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.e.get(i1);
      if (this.i.isViewFromObject(paramView, localItemInfo.a))
        return localItemInfo;
    }
    return null;
  }

  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.n = new Scroller(localContext, c);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.F = localViewConfiguration.getScaledPagingTouchSlop();
    this.M = ((int)(400.0F * f1));
    this.N = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.S = new EdgeEffect(localContext);
    this.T = new EdgeEffect(localContext);
    this.O = ((int)(25.0F * f1));
    this.P = ((int)(2.0F * f1));
    this.D = ((int)(f1 * 16.0F));
    setAccessibilityDelegate(new View.AccessibilityDelegate());
    if (Build.VERSION.SDK_INT < 16)
      return;
    if (getImportantForAccessibility() == 0)
      setImportantForAccessibility(1);
  }

  void a(int paramInt)
  {
    int i1;
    ItemInfo localItemInfo1;
    if (this.j != paramInt)
    {
      if (this.j < paramInt)
        i1 = 66;
      else
        i1 = 17;
      localItemInfo1 = b(this.j);
      this.j = paramInt;
    }
    else
    {
      i1 = 2;
      localItemInfo1 = null;
    }
    if (this.i == null)
    {
      h();
      return;
    }
    if (this.z)
    {
      h();
      return;
    }
    if (getWindowToken() == null)
      return;
    this.i.startUpdate(this);
    int i2 = this.A;
    int i3 = Math.max(0, this.j - i2);
    int i4 = this.i.getCount();
    int i5 = Math.min(i4 - 1, i2 + this.j);
    for (int i6 = 0; i6 < this.e.size(); i6++)
    {
      localItemInfo2 = (ItemInfo)this.e.get(i6);
      if (localItemInfo2.b >= this.j)
      {
        if (localItemInfo2.b != this.j)
          break;
        break label195;
      }
    }
    ItemInfo localItemInfo2 = null;
    label195: if ((localItemInfo2 == null) && (i4 > 0))
      localItemInfo2 = a(this.j, i6);
    if (localItemInfo2 != null)
    {
      int i11 = i6 - 1;
      Object localObject2;
      if (i11 >= 0)
        localObject2 = (ItemInfo)this.e.get(i11);
      else
        localObject2 = null;
      int i12 = getClientWidth();
      float f1;
      if (i12 <= 0)
        f1 = 0.0F;
      else
        f1 = 2.0F - localItemInfo2.d + getPaddingLeft() / i12;
      int i13 = -1 + this.j;
      int i14 = i6;
      float f2 = 0.0F;
      while (i13 >= 0)
      {
        if ((f2 >= f1) && (i13 < i3))
        {
          if (localObject2 == null)
            break;
          if ((i13 != ((ItemInfo)localObject2).b) || (((ItemInfo)localObject2).c))
            break label475;
          this.e.remove(i11);
          this.i.destroyItem(this, i13, ((ItemInfo)localObject2).a);
          i11--;
          i14--;
          if (i11 < 0)
            break label468;
        }
        else if ((localObject2 != null) && (i13 == ((ItemInfo)localObject2).b))
        {
          f2 += ((ItemInfo)localObject2).d;
          i11--;
          if (i11 < 0)
            break label468;
        }
        else
        {
          f2 += a(i13, i11 + 1).d;
          i14++;
          if (i11 < 0)
            break label468;
        }
        ItemInfo localItemInfo8 = (ItemInfo)this.e.get(i11);
        break label471;
        label468: localItemInfo8 = null;
        label471: localObject2 = localItemInfo8;
        label475: i13--;
      }
      float f3 = localItemInfo2.d;
      int i15 = i14 + 1;
      if (f3 < 2.0F)
      {
        ItemInfo localItemInfo6;
        if (i15 < this.e.size())
          localItemInfo6 = (ItemInfo)this.e.get(i15);
        else
          localItemInfo6 = null;
        float f4;
        if (i12 <= 0)
          f4 = 0.0F;
        else
          f4 = 2.0F + getPaddingRight() / i12;
        int i16 = this.j;
        label755: 
        while (true)
        {
          i16++;
          if (i16 >= i4)
            break;
          if ((f3 >= f4) && (i16 > i5))
          {
            if (localItemInfo6 == null)
              break;
            if ((i16 != localItemInfo6.b) || (localItemInfo6.c))
              break label755;
            this.e.remove(i15);
            this.i.destroyItem(this, i16, localItemInfo6.a);
            if (i15 >= this.e.size());
          }
          while (true)
          {
            localItemInfo6 = (ItemInfo)this.e.get(i15);
            break;
            do
            {
              do
              {
                localItemInfo6 = null;
                break label755;
                if ((localItemInfo6 == null) || (i16 != localItemInfo6.b))
                  break;
                f3 += localItemInfo6.d;
                i15++;
              }
              while (i15 >= this.e.size());
              break;
              ItemInfo localItemInfo7 = a(i16, i15);
              i15++;
              f3 += localItemInfo7.d;
            }
            while (i15 >= this.e.size());
          }
        }
      }
      a(localItemInfo2, i14, localItemInfo1);
    }
    BasePageAdapter localBasePageAdapter = this.i;
    int i7 = this.j;
    Object localObject1;
    if (localItemInfo2 != null)
      localObject1 = localItemInfo2.a;
    else
      localObject1 = null;
    localBasePageAdapter.setPrimaryItem(this, i7, localObject1);
    this.i.finishUpdate(this);
    int i8 = getChildCount();
    for (int i9 = 0; i9 < i8; i9++)
    {
      View localView3 = getChildAt(i9);
      LayoutParams localLayoutParams = (LayoutParams)localView3.getLayoutParams();
      localLayoutParams.d = i9;
      if ((!localLayoutParams.isDecor) && (localLayoutParams.a == 0.0F))
      {
        ItemInfo localItemInfo5 = a(localView3);
        if (localItemInfo5 != null)
        {
          localLayoutParams.a = localItemInfo5.d;
          localLayoutParams.c = localItemInfo5.b;
        }
      }
    }
    h();
    if (hasFocus())
    {
      View localView1 = findFocus();
      ItemInfo localItemInfo3;
      if (localView1 != null)
        localItemInfo3 = b(localView1);
      else
        localItemInfo3 = null;
      if ((localItemInfo3 == null) || (localItemInfo3.b != this.j))
        for (int i10 = 0; i10 < getChildCount(); i10++)
        {
          View localView2 = getChildAt(i10);
          ItemInfo localItemInfo4 = a(localView2);
          if ((localItemInfo4 != null) && (localItemInfo4.b == this.j) && (localView2.requestFocus(i1)))
            return;
        }
    }
  }

  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.aa;
    int i2 = 0;
    if (i1 > 0)
    {
      int i5 = getScrollX();
      int i6 = getPaddingLeft();
      int i7 = getPaddingRight();
      int i8 = getWidth();
      int i9 = getChildCount();
      int i10 = i7;
      int i11 = i6;
      for (int i12 = 0; i12 < i9; i12++)
      {
        View localView2 = getChildAt(i12);
        LayoutParams localLayoutParams = (LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams.isDecor)
        {
          int i13 = 0x7 & localLayoutParams.gravity;
          int i14;
          if (i13 != 1)
          {
            if (i13 != 3)
            {
              if (i13 != 5)
              {
                i16 = i11;
                break label194;
              }
              i14 = i8 - i10 - localView2.getMeasuredWidth();
              i10 += localView2.getMeasuredWidth();
            }
            else
            {
              i16 = i11 + localView2.getWidth();
              break label194;
            }
          }
          else
            i14 = Math.max((i8 - localView2.getMeasuredWidth()) / 2, i11);
          int i15 = i14;
          int i16 = i11;
          i11 = i15;
          label194: int i17 = i11 + i5 - localView2.getLeft();
          if (i17 != 0)
            localView2.offsetLeftAndRight(i17);
          i11 = i16;
        }
      }
    }
    b(paramInt1, paramFloat, paramInt2);
    if (this.af != null)
    {
      int i3 = getScrollX();
      int i4 = getChildCount();
      while (i2 < i4)
      {
        View localView1 = getChildAt(i2);
        if (!((LayoutParams)localView1.getLayoutParams()).isDecor)
        {
          float f1 = (localView1.getLeft() - i3) / getClientWidth();
          this.af.transformPage(localView1, f1);
        }
        i2++;
      }
    }
    this.W = true;
  }

  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int i5 = getClientWidth();
    int i6 = i5 / 2;
    float f1 = 1.0F * Math.abs(i3);
    float f2 = i5;
    float f3 = Math.min(1.0F, f1 / f2);
    float f4 = i6;
    float f5 = f4 + f4 * a(f3);
    int i7 = Math.abs(paramInt3);
    int i8;
    if (i7 > 0)
    {
      i8 = 4 * Math.round(1000.0F * Math.abs(f5 / i7));
    }
    else
    {
      float f6 = f2 * this.i.getPageWidth(this.j);
      i8 = (int)(100.0F * (1.0F + Math.abs(i3) / (f6 + this.p)));
    }
    int i9 = Math.min(i8, 600);
    this.n.startScroll(i1, i2, i3, i4, i9);
    postInvalidateOnAnimation();
  }

  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((this.i != null) && (this.i.getCount() > 0))
    {
      if ((!paramBoolean2) && (this.j == paramInt1) && (this.e.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      int i1 = 1;
      if (paramInt1 < 0)
        paramInt1 = 0;
      else if (paramInt1 >= this.i.getCount())
        paramInt1 = this.i.getCount() - i1;
      int i2 = this.A;
      if ((paramInt1 > i2 + this.j) || (paramInt1 < this.j - i2))
        for (int i3 = 0; i3 < this.e.size(); i3++)
          ((ItemInfo)this.e.get(i3)).c = i1;
      if (this.j == paramInt1)
        i1 = 0;
      if (this.U)
      {
        this.j = paramInt1;
        if (i1 != 0)
          d(paramInt1);
        requestLayout();
        return;
      }
      a(paramInt1);
      a(paramInt1, paramBoolean1, paramInt2, i1);
      return;
    }
    setScrollingCacheEnabled(false);
  }

  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      for (int i3 = localViewGroup.getChildCount() - 1; i3 >= 0; i3--)
      {
        View localView = localViewGroup.getChildAt(i3);
        int i4 = paramInt2 + i1;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i2;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop())))
            return true;
        }
      }
    }
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayList.size();
    int i2 = getDescendantFocusability();
    if (i2 != 393216)
      for (int i3 = 0; i3 < getChildCount(); i3++)
      {
        View localView = getChildAt(i3);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = a(localView);
          if ((localItemInfo != null) && (localItemInfo.b == this.j))
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
    if ((i2 != 262144) || (i1 == paramArrayList.size()))
    {
      if (!isFocusable())
        return;
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode()))
        return;
      if (paramArrayList != null)
        paramArrayList.add(this);
    }
  }

  public void addOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.ab == null)
      this.ab = new ArrayList();
    this.ab.add(paramOnPageChangeListener);
  }

  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.j))
          localView.addTouchables(paramArrayList);
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams))
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
    localLayoutParams.isDecor |= paramView instanceof Decor;
    if (this.x)
    {
      if ((localLayoutParams != null) && (localLayoutParams.isDecor))
        throw new IllegalStateException("Cannot add page decor view during layout");
      localLayoutParams.b = true;
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  public boolean arrowScroll(int paramInt)
  {
    View localView1 = findFocus();
    View localView2;
    if (localView1 == this)
    {
      localView2 = null;
    }
    else
    {
      if (localView1 != null)
      {
        for (ViewParent localViewParent1 = localView1.getParent(); (localViewParent1 instanceof ViewGroup); localViewParent1 = localViewParent1.getParent())
          if (localViewParent1 == this)
          {
            i5 = 1;
            break label60;
          }
        int i5 = 0;
        label60: if (i5 == 0)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(localView1.getClass().getSimpleName());
          for (ViewParent localViewParent2 = localView1.getParent(); (localViewParent2 instanceof ViewGroup); localViewParent2 = localViewParent2.getParent())
          {
            localStringBuilder1.append(" => ");
            localStringBuilder1.append(localViewParent2.getClass().getSimpleName());
          }
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("arrowScroll tried to find focus based on non-child current focused view ");
          localStringBuilder2.append(localStringBuilder1.toString());
          Log.e("PageView", localStringBuilder2.toString());
          localView2 = null;
          break label184;
        }
      }
      localView2 = localView1;
    }
    label184: View localView3 = FocusFinder.getInstance().findNextFocus(this, localView2, paramInt);
    boolean bool1;
    if ((localView3 != null) && (localView3 != localView2))
    {
      if (paramInt == 17)
      {
        int i3 = a(this.g, localView3).left;
        int i4 = a(this.g, localView2).left;
        if ((localView2 != null) && (i3 >= i4))
          bool2 = d();
      }
      for (boolean bool2 = localView3.requestFocus(); ; bool2 = e())
      {
        bool1 = bool2;
        break label376;
        bool1 = false;
        if (paramInt != 66)
          break label376;
        int i1 = a(this.g, localView3).left;
        int i2 = a(this.g, localView2).left;
        if ((localView2 == null) || (i1 > i2))
          break;
      }
    }
    if ((paramInt != 17) && (paramInt != 1))
    {
      if (paramInt != 66)
      {
        bool1 = false;
        if (paramInt != 2);
      }
      else
      {
        bool1 = e();
      }
    }
    else
      bool1 = d();
    label376: if (bool1)
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    return bool1;
  }

  ItemInfo b(int paramInt)
  {
    for (int i1 = 0; i1 < this.e.size(); i1++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.e.get(i1);
      if (localItemInfo.b == paramInt)
        return localItemInfo;
    }
    return null;
  }

  ItemInfo b(View paramView)
  {
    while (true)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this)
        break label34;
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
        break;
      paramView = (View)localViewParent;
    }
    return null;
    label34: return a(paramView);
  }

  void b()
  {
    int i1 = this.i.getCount();
    this.h = i1;
    int i2;
    if ((this.e.size() < 1 + 2 * this.A) && (this.e.size() < i1))
      i2 = 1;
    else
      i2 = 0;
    int i3 = this.j;
    int i4 = i2;
    int i5 = i3;
    int i6 = 0;
    int i7 = 0;
    while (i6 < this.e.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.e.get(i6);
      int i10 = this.i.getItemPosition(localItemInfo.a);
      if (i10 != -1)
      {
        if (i10 == -2)
        {
          this.e.remove(i6);
          i6--;
          if (i7 == 0)
          {
            this.i.startUpdate(this);
            i7 = 1;
          }
          this.i.destroyItem(this, localItemInfo.b, localItemInfo.a);
          if (this.j == localItemInfo.b)
            i5 = Math.max(0, Math.min(this.j, i1 - 1));
        }
        while (true)
        {
          i4 = 1;
          break;
          if (localItemInfo.b == i10)
            break;
          if (localItemInfo.b == this.j)
            i5 = i10;
          localItemInfo.b = i10;
        }
      }
      i6++;
    }
    if (i7 != 0)
      this.i.finishUpdate(this);
    Collections.sort(this.e, b);
    if (i4 != 0)
    {
      int i8 = getChildCount();
      for (int i9 = 0; i9 < i8; i9++)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i9).getLayoutParams();
        if (!localLayoutParams.isDecor)
          localLayoutParams.a = 0.0F;
      }
      a(i5, false, true);
      requestLayout();
    }
  }

  public boolean beginFakeDrag()
  {
    if (this.B)
      return false;
    this.Q = true;
    setScrollState(1);
    this.G = 0.0F;
    this.I = 0.0F;
    if (this.L == null)
      this.L = VelocityTracker.obtain();
    else
      this.L.clear();
    long l1 = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
    this.L.addMovement(localMotionEvent);
    localMotionEvent.recycle();
    this.R = l1;
    return true;
  }

  void c()
  {
    a(this.j);
  }

  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.i == null)
      return false;
    int i1 = getClientWidth();
    int i2 = getScrollX();
    if (paramInt < 0)
    {
      int i4 = (int)(i1 * this.t);
      boolean bool2 = false;
      if (i2 > i4)
        bool2 = true;
      return bool2;
    }
    boolean bool1 = false;
    if (paramInt > 0)
    {
      int i3 = (int)(i1 * this.u);
      bool1 = false;
      if (i2 < i3)
        bool1 = true;
    }
    return bool1;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void clearOnPageChangeListeners()
  {
    if (this.ab != null)
      this.ab.clear();
  }

  public void computeScroll()
  {
    if ((!this.n.isFinished()) && (this.n.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.n.getCurrX();
      int i4 = this.n.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!c(i3))
        {
          this.n.abortAnimation();
          scrollTo(0, i4);
        }
      }
      postInvalidateOnAnimation();
      return;
    }
    a(true);
  }

  boolean d()
  {
    if (this.j > 0)
    {
      setCurrentItem(this.j - 1, true);
      return true;
    }
    return false;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096)
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.j) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
          return true;
      }
    }
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1 = getOverScrollMode();
    boolean bool2;
    if ((i1 != 0) && ((i1 != 1) || (this.i == null) || (this.i.getCount() <= 1)))
    {
      this.S.finish();
      this.T.finish();
      bool2 = false;
    }
    else
    {
      boolean bool1 = this.S.isFinished();
      bool2 = false;
      if (!bool1)
      {
        int i5 = paramCanvas.save();
        int i6 = getHeight() - getPaddingTop() - getPaddingBottom();
        int i7 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i6 + getPaddingTop(), this.t * i7);
        this.S.setSize(i6, i7);
        bool2 = false | this.S.draw(paramCanvas);
        paramCanvas.restoreToCount(i5);
      }
      if (!this.T.isFinished())
      {
        int i2 = paramCanvas.save();
        int i3 = getWidth();
        int i4 = getHeight() - getPaddingTop() - getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(1.0F + this.u) * i3);
        this.T.setSize(i4, i3);
        bool2 |= this.T.draw(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    if (bool2)
      postInvalidateOnAnimation();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.q;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
  }

  boolean e()
  {
    if ((this.i != null) && (this.j < this.i.getCount() - 1))
    {
      setCurrentItem(1 + this.j, true);
      return true;
    }
    return false;
  }

  public void endFakeDrag()
  {
    if (!this.Q)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    VelocityTracker localVelocityTracker = this.L;
    localVelocityTracker.computeCurrentVelocity(1000, this.N);
    int i1 = (int)localVelocityTracker.getXVelocity(this.K);
    this.z = true;
    int i2 = getClientWidth();
    int i3 = getScrollX();
    ItemInfo localItemInfo = j();
    a(a(localItemInfo.b, (i3 / i2 - localItemInfo.e) / localItemInfo.d, i1, (int)(this.G - this.I)), true, true, i1);
    k();
    this.Q = false;
  }

  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i1 = paramKeyEvent.getKeyCode();
      if (i1 != 61)
        switch (i1)
        {
        default:
          break;
        case 22:
          i2 = 66;
          break;
        case 21:
        }
      for (int i2 = 17; ; i2 = 2)
      {
        return arrowScroll(i2);
        if (Build.VERSION.SDK_INT < 11)
          break label92;
        if (!paramKeyEvent.hasNoModifiers())
          break;
      }
      if (paramKeyEvent.hasModifiers(1))
        return arrowScroll(1);
    }
    label92: return false;
  }

  public void fakeDragBy(float paramFloat)
  {
    if (!this.Q)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    this.G = (paramFloat + this.G);
    float f1 = getScrollX() - paramFloat;
    float f2 = getClientWidth();
    float f3 = f2 * this.t;
    float f4 = f2 * this.u;
    ItemInfo localItemInfo1 = (ItemInfo)this.e.get(0);
    ItemInfo localItemInfo2 = (ItemInfo)this.e.get(-1 + this.e.size());
    if (localItemInfo1.b != 0)
      f3 = f2 * localItemInfo1.e;
    if (localItemInfo2.b != -1 + this.i.getCount())
      f4 = f2 * localItemInfo2.e;
    if (f1 < f3)
      f1 = f3;
    else if (f1 > f4)
      f1 = f4;
    float f5 = this.G;
    int i1 = (int)f1;
    this.G = (f5 + (f1 - i1));
    scrollTo(i1, getScrollY());
    c(i1);
    long l1 = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(this.R, l1, 2, this.G, 0.0F, 0);
    this.L.addMovement(localMotionEvent);
    localMotionEvent.recycle();
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }

  public BasePageAdapter getAdapter()
  {
    return this.i;
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.ah == 2)
      paramInt2 = paramInt1 - 1 - paramInt2;
    return ((LayoutParams)((View)this.ai.get(paramInt2)).getLayoutParams()).d;
  }

  public int getCurrentItem()
  {
    return this.j;
  }

  public int getOffscreenPageLimit()
  {
    return this.A;
  }

  public int getPageMargin()
  {
    return this.p;
  }

  public boolean isFakeDragging()
  {
    return this.Q;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.U = true;
  }

  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ak);
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.p > 0) && (this.q != null) && (this.e.size() > 0) && (this.i != null))
    {
      int i1 = getScrollX();
      int i2 = getWidth();
      float f1 = this.p;
      float f2 = i2;
      float f3 = f1 / f2;
      ArrayList localArrayList1 = this.e;
      int i3 = 0;
      ItemInfo localItemInfo = (ItemInfo)localArrayList1.get(0);
      float f4 = localItemInfo.e;
      int i4 = this.e.size();
      int i5 = localItemInfo.b;
      int i6 = ((ItemInfo)this.e.get(i4 - 1)).b;
      while (i5 < i6)
      {
        while ((i5 > localItemInfo.b) && (i3 < i4))
        {
          ArrayList localArrayList2 = this.e;
          i3++;
          localItemInfo = (ItemInfo)localArrayList2.get(i3);
        }
        float f6;
        if (i5 == localItemInfo.b)
        {
          float f8 = f2 * (localItemInfo.e + localItemInfo.d);
          float f9 = f3 + (localItemInfo.e + localItemInfo.d);
          f6 = f8;
          f4 = f9;
        }
        else
        {
          float f5 = this.i.getPageWidth(i5);
          f6 = f2 * (f4 + f5);
          f4 += f5 + f3;
        }
        float f7;
        if (f6 + this.p > i1)
        {
          Drawable localDrawable = this.q;
          int i7 = (int)f6;
          int i8 = this.r;
          int i9 = (int)(0.5F + (f6 + this.p));
          f7 = f3;
          localDrawable.setBounds(i7, i8, i9, this.s);
          this.q.draw(paramCanvas);
        }
        else
        {
          f7 = f3;
        }
        if (f6 > i1 + i2)
          return;
        i5++;
        f3 = f7;
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.al)
      return false;
    int i1 = 0xFF & paramMotionEvent.getAction();
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 != 0)
      {
        if (this.B)
          return true;
        if (this.C)
          return false;
      }
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 == 6)
            a(paramMotionEvent);
        }
        else
        {
          int i2 = this.K;
          if (i2 != -1)
          {
            int i3 = paramMotionEvent.findPointerIndex(i2);
            float f3 = paramMotionEvent.getX(i3);
            float f4 = f3 - this.G;
            float f5 = Math.abs(f4);
            float f6 = paramMotionEvent.getY(i3);
            float f7 = Math.abs(f6 - this.J);
            if ((f4 != 0.0F) && (!a(this.G, f4)) && (a(this, false, (int)f4, (int)f3, (int)f6)))
            {
              this.G = f3;
              this.H = f6;
              this.C = true;
              return false;
            }
            if ((f5 > this.F) && (f5 * 0.5F > f7))
            {
              this.B = true;
              c(true);
              setScrollState(1);
              float f8;
              if (f4 > 0.0F)
                f8 = this.I + this.F;
              else
                f8 = this.I - this.F;
              this.G = f8;
              this.H = f6;
              setScrollingCacheEnabled(true);
            }
            else if (f7 > this.F)
            {
              this.C = true;
            }
            if ((this.B) && (b(f3)))
              postInvalidateOnAnimation();
          }
        }
      }
      else
      {
        float f1 = paramMotionEvent.getX();
        this.I = f1;
        this.G = f1;
        float f2 = paramMotionEvent.getY();
        this.J = f2;
        this.H = f2;
        this.K = paramMotionEvent.getPointerId(0);
        this.C = false;
        this.n.computeScrollOffset();
        if ((this.aj == 2) && (Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.P))
        {
          this.n.abortAnimation();
          this.z = false;
          c();
          this.B = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.B = false;
        }
      }
      if (this.L == null)
        this.L = VelocityTracker.obtain();
      this.L.addMovement(paramMotionEvent);
      return this.B;
    }
    i();
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i6 = getPaddingRight();
    int i7 = getPaddingBottom();
    int i8 = getScrollX();
    int i9 = i7;
    int i10 = 0;
    int i11 = i5;
    int i12 = i4;
    for (int i13 = 0; i13 < i1; i13++)
    {
      View localView2 = getChildAt(i13);
      if (localView2.getVisibility() != 8)
      {
        LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams2.isDecor)
        {
          int i17 = 0x7 & localLayoutParams2.gravity;
          int i18 = 0x70 & localLayoutParams2.gravity;
          int i19;
          if (i17 != 1)
          {
            if (i17 != 3)
            {
              if (i17 != 5)
              {
                i19 = i12;
              }
              else
              {
                i19 = i2 - i6 - localView2.getMeasuredWidth();
                i6 += localView2.getMeasuredWidth();
              }
            }
            else
            {
              int i23 = i12 + localView2.getMeasuredWidth();
              i19 = i12;
              i12 = i23;
            }
          }
          else
            i19 = Math.max((i2 - localView2.getMeasuredWidth()) / 2, i12);
          int i20;
          if (i18 != 16)
          {
            if (i18 != 48)
            {
              if (i18 != 80)
              {
                i20 = i11;
              }
              else
              {
                i20 = i3 - i9 - localView2.getMeasuredHeight();
                i9 += localView2.getMeasuredHeight();
              }
            }
            else
            {
              int i22 = i11 + localView2.getMeasuredHeight();
              i20 = i11;
              i11 = i22;
            }
          }
          else
            i20 = Math.max((i3 - localView2.getMeasuredHeight()) / 2, i11);
          int i21 = i19 + i8;
          localView2.layout(i21, i20, i21 + localView2.getMeasuredWidth(), i20 + localView2.getMeasuredHeight());
          i10++;
        }
      }
    }
    int i14 = i2 - i12 - i6;
    for (int i15 = 0; i15 < i1; i15++)
    {
      View localView1 = getChildAt(i15);
      if (localView1.getVisibility() != 8)
      {
        LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if (!localLayoutParams1.isDecor)
        {
          ItemInfo localItemInfo = a(localView1);
          if (localItemInfo != null)
          {
            float f1 = i14;
            int i16 = i12 + (int)(f1 * localItemInfo.e);
            if (localLayoutParams1.b)
            {
              localLayoutParams1.b = false;
              localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams1.a), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - i11 - i9, 1073741824));
            }
            localView1.layout(i16, i11, i16 + localView1.getMeasuredWidth(), i11 + localView1.getMeasuredHeight());
          }
        }
      }
    }
    this.r = i11;
    this.s = (i3 - i9);
    this.aa = i10;
    if (this.U)
      a(this.j, false, 0, true);
    this.U = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i1 = getMeasuredWidth();
    this.E = Math.min(i1 / 10, this.D);
    int i2 = i1 - getPaddingLeft() - getPaddingRight();
    int i3 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int i5 = i3;
    int i6 = i2;
    boolean bool;
    int i8;
    for (int i7 = 0; ; i7++)
    {
      bool = true;
      i8 = 1073741824;
      if (i7 >= i4)
        break;
      View localView2 = getChildAt(i7);
      if (localView2.getVisibility() != 8)
      {
        LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        if ((localLayoutParams2 != null) && (localLayoutParams2.isDecor))
        {
          int i11 = 0x7 & localLayoutParams2.gravity;
          int i12 = 0x70 & localLayoutParams2.gravity;
          int i13;
          if ((i12 != 48) && (i12 != 80))
            i13 = 0;
          else
            i13 = 1;
          if ((i11 != 3) && (i11 != 5))
            bool = false;
          int i14 = -2147483648;
          if (i13 != 0)
            i14 = 1073741824;
          while (!bool)
          {
            i15 = -2147483648;
            break;
          }
          int i15 = 1073741824;
          int i16;
          if (localLayoutParams2.width != -2)
          {
            if (localLayoutParams2.width != -1)
              i16 = localLayoutParams2.width;
            else
              i16 = i6;
            i14 = 1073741824;
          }
          else
          {
            i16 = i6;
          }
          int i17;
          if (localLayoutParams2.height != -2)
          {
            if (localLayoutParams2.height != -1)
              i17 = localLayoutParams2.height;
            else
              i17 = i5;
          }
          else
          {
            i17 = i5;
            i8 = i15;
          }
          localView2.measure(View.MeasureSpec.makeMeasureSpec(i16, i14), View.MeasureSpec.makeMeasureSpec(i17, i8));
          if (i13 != 0)
            i5 -= localView2.getMeasuredHeight();
          else if (bool)
            i6 -= localView2.getMeasuredWidth();
        }
      }
    }
    this.v = View.MeasureSpec.makeMeasureSpec(i6, i8);
    this.w = View.MeasureSpec.makeMeasureSpec(i5, i8);
    this.x = bool;
    c();
    int i9 = 0;
    this.x = false;
    int i10 = getChildCount();
    while (i9 < i10)
    {
      View localView1 = getChildAt(i9);
      if (localView1.getVisibility() != 8)
      {
        LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if ((localLayoutParams1 == null) || (!localLayoutParams1.isDecor))
          localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i6 * localLayoutParams1.a), i8), this.w);
      }
      i9++;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = getChildCount();
    int i2 = paramInt & 0x2;
    int i3 = -1;
    int i5;
    int i4;
    if (i2 != 0)
    {
      i3 = i1;
      i5 = 1;
      i4 = 0;
    }
    else
    {
      i4 = i1 - 1;
      i5 = -1;
    }
    while (i4 != i3)
    {
      View localView = getChildAt(i4);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.j) && (localView.requestFocus(paramInt, paramRect)))
          return true;
      }
      i4 += i5;
    }
    return false;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.i != null)
    {
      this.i.restoreState(localSavedState.b, localSavedState.c);
      a(localSavedState.a, false, true);
      return;
    }
    this.k = localSavedState.a;
    this.l = localSavedState.b;
    this.m = localSavedState.c;
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.j;
    if (this.i != null)
      localSavedState.b = this.i.saveState();
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      a(paramInt1, paramInt3, this.p, this.p);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.Q)
      return true;
    int i1 = paramMotionEvent.getAction();
    boolean bool1 = false;
    if ((i1 == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      return false;
    if (this.i != null)
    {
      if (this.i.getCount() == 0)
        return false;
      if (this.L == null)
        this.L = VelocityTracker.obtain();
      this.L.addMovement(paramMotionEvent);
      switch (0xFF & paramMotionEvent.getAction())
      {
      case 4:
      default:
        bool1 = false;
        break;
      case 6:
        a(paramMotionEvent);
        this.G = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.K));
        bool1 = false;
        break;
      case 5:
        int i7 = paramMotionEvent.getActionIndex();
        this.G = paramMotionEvent.getX(i7);
        i2 = paramMotionEvent.getPointerId(i7);
        break;
      case 3:
        boolean bool4 = this.B;
        bool1 = false;
        if (!bool4)
          break label611;
        a(this.j, true, 0, false);
        break;
      case 2:
        if (!this.B)
        {
          int i6 = paramMotionEvent.findPointerIndex(this.K);
          if (i6 == -1)
            break;
          float f3 = paramMotionEvent.getX(i6);
          float f4 = Math.abs(f3 - this.G);
          float f5 = paramMotionEvent.getY(i6);
          float f6 = Math.abs(f5 - this.H);
          if ((f4 > this.F) && (f4 > f6))
          {
            this.B = true;
            c(true);
            float f7;
            if (f3 - this.I > 0.0F)
              f7 = this.I + this.F;
            else
              f7 = this.I - this.F;
            this.G = f7;
            this.H = f5;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            ViewParent localViewParent = getParent();
            if (localViewParent != null)
              localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        boolean bool3 = this.B;
        bool1 = false;
        if (!bool3)
          break label611;
        bool1 = false | b(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.K)));
        break;
      case 1:
        boolean bool2 = this.B;
        bool1 = false;
        if (!bool2)
          break label611;
        VelocityTracker localVelocityTracker = this.L;
        localVelocityTracker.computeCurrentVelocity(1000, this.N);
        int i3 = (int)localVelocityTracker.getXVelocity(this.K);
        this.z = true;
        int i4 = getClientWidth();
        int i5 = getScrollX();
        ItemInfo localItemInfo = j();
        a(a(localItemInfo.b, (i5 / i4 - localItemInfo.e) / localItemInfo.d, i3, (int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.K)) - this.I)), true, true, i3);
        bool1 = i();
        break;
      case 0:
      }
      this.n.abortAnimation();
      this.z = false;
      c();
      float f1 = paramMotionEvent.getX();
      this.I = f1;
      this.G = f1;
      float f2 = paramMotionEvent.getY();
      this.J = f2;
      this.H = f2;
      int i2 = paramMotionEvent.getPointerId(0);
      this.K = i2;
      label611: if (bool1)
        postInvalidateOnAnimation();
      return true;
    }
    return false;
  }

  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.ab != null)
      this.ab.remove(paramOnPageChangeListener);
  }

  public void removeView(View paramView)
  {
    if (this.x)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }

  public void setAdapter(BasePageAdapter paramBasePageAdapter)
  {
    if (this.i != null)
    {
      this.i.unregisterDataSetObserver(this.o);
      this.i.startUpdate(this);
      for (int i1 = 0; i1 < this.e.size(); i1++)
      {
        ItemInfo localItemInfo = (ItemInfo)this.e.get(i1);
        this.i.destroyItem(this, localItemInfo.b, localItemInfo.a);
      }
      this.i.finishUpdate(this);
      this.e.clear();
      g();
      this.j = 0;
      scrollTo(0, 0);
    }
    BasePageAdapter localBasePageAdapter = this.i;
    this.i = paramBasePageAdapter;
    this.h = 0;
    if (this.i != null)
    {
      if (this.o == null)
        this.o = new PageObserver(null);
      this.i.registerDataSetObserver(this.o);
      this.z = false;
      boolean bool = this.U;
      this.U = true;
      this.h = this.i.getCount();
      if (this.k >= 0)
      {
        this.i.restoreState(this.l, this.m);
        a(this.k, false, true);
        this.k = -1;
        this.l = null;
        this.m = null;
      }
      else if (!bool)
      {
        c();
      }
      else
      {
        requestLayout();
      }
    }
    if ((this.ae != null) && (localBasePageAdapter != paramBasePageAdapter))
      this.ae.onAdapterChanged(localBasePageAdapter, paramBasePageAdapter);
  }

  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 7)
    {
      if (this.ag == null)
        try
        {
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = Boolean.TYPE;
          this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("PageView", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      try
      {
        Method localMethod = this.ag;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        localMethod.invoke(this, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        Log.e("PageView", "Error changing children drawing order", localException);
      }
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.z = false;
    a(paramInt, true ^ this.U, false);
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.z = false;
    a(paramInt, paramBoolean, false);
  }

  public void setOffscreenPageLimit(int paramInt)
  {
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("PageView", localStringBuilder.toString());
      paramInt = 1;
    }
    if (paramInt != this.A)
    {
      this.A = paramInt;
      c();
    }
  }

  void setOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.ae = paramOnAdapterChangeListener;
  }

  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    this.ac = paramOnPageChangeListener;
  }

  public void setPageMargin(int paramInt)
  {
    int i1 = this.p;
    this.p = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }

  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.q = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState();
    boolean bool;
    if (paramDrawable == null)
      bool = true;
    else
      bool = false;
    setWillNotDraw(bool);
    invalidate();
  }

  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i1 = 1;
      boolean bool1;
      if (paramPageTransformer != null)
        bool1 = true;
      else
        bool1 = false;
      boolean bool2;
      if (this.af != null)
        bool2 = true;
      else
        bool2 = false;
      int i2;
      if (bool1 != bool2)
        i2 = 1;
      else
        i2 = 0;
      this.af = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (bool1)
      {
        if (paramBoolean)
          i1 = 2;
        this.ah = i1;
      }
      else
      {
        this.ah = 0;
      }
      if (i2 != 0)
        c();
    }
  }

  public void setScrollEnabled(boolean paramBoolean)
  {
    this.al = paramBoolean;
  }

  public void setTouchEnabled(boolean paramBoolean)
  {
    this.al = paramBoolean;
  }

  public void showPage(int paramInt)
  {
    setCurrentItem(paramInt, true);
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.q);
  }

  static abstract interface Decor
  {
  }

  static class ItemInfo
  {
    Object a;
    int b;
    boolean c;
    float d;
    float e;
  }

  public static class LayoutParams extends ViewGroup.LayoutParams
  {
    float a = 0.0F;
    boolean b;
    int c;
    int d;
    public int gravity;
    public boolean isDecor;

    public LayoutParams()
    {
      super(-1);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, PageView.f());
      this.gravity = localTypedArray.getInteger(0, 48);
      localTypedArray.recycle();
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super(-1);
    }
  }

  static abstract interface OnAdapterChangeListener
  {
    public abstract void onAdapterChanged(BasePageAdapter paramBasePageAdapter1, BasePageAdapter paramBasePageAdapter2);
  }

  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageChange(View paramView, int paramInt);

    public abstract void onPageScrollStateChanged(int paramInt);

    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);

    public abstract void onPageSelected(int paramInt);
  }

  private class PageObserver extends DataSetObserver
  {
    private PageObserver()
    {
    }

    public void onChanged()
    {
      PageView.this.b();
    }

    public void onInvalidated()
    {
      PageView.this.b();
    }
  }

  public static abstract interface PageTransformer
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PageView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PageView.SavedState(paramAnonymousParcel);
      }

      public PageView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new PageView.SavedState[paramAnonymousInt];
      }
    };
    int a;
    Parcelable b;
    ClassLoader c;

    SavedState(Parcel paramParcel)
    {
      super();
      ClassLoader localClassLoader = getClass().getClassLoader();
      this.a = paramParcel.readInt();
      this.b = paramParcel.readParcelable(localClassLoader);
      this.c = localClassLoader;
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentPage.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" position=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeParcelable(this.b, paramInt);
    }
  }

  public static class SimpleOnPageChangeListener
    implements PageView.OnPageChangeListener
  {
    public void onPageChange(View paramView, int paramInt)
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
    }
  }

  static class ViewPositionComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      PageView.LayoutParams localLayoutParams1 = (PageView.LayoutParams)paramView1.getLayoutParams();
      PageView.LayoutParams localLayoutParams2 = (PageView.LayoutParams)paramView2.getLayoutParams();
      if (localLayoutParams1.isDecor != localLayoutParams2.isDecor)
      {
        if (localLayoutParams1.isDecor)
          return 1;
        return -1;
      }
      return localLayoutParams1.c - localLayoutParams2.c;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.PageView
 * JD-Core Version:    0.6.2
 */