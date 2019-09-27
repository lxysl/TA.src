package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import com.a.a.a.a.a.a.a;
import java.util.Timer;
import java.util.TimerTask;

public class PullingLayout extends RelativeLayout
{
  public static final int DONE = 5;
  public static final int FAIL = 1;
  public static final int INIT = 0;
  public static final int LOADING = 4;
  public static final int NOTHING = 2;
  public static final int REFRESHING = 2;
  public static final int RELEASE_TO_LOAD = 3;
  public static final int RELEASE_TO_REFRESH = 1;
  public static final int SUCCEED = 0;
  public static final String TAG = "PullToRefreshLayout";
  private View A;
  private int B;
  private boolean C = true;
  private boolean D = true;
  private Context E;
  private boolean F;
  private boolean G;
  private LayoutInflater H;
  private OnLoadMoreListener I;
  private OnPullUpListener J;
  private OnPullDownListener K;
  private DisplayMetrics L;
  private int M;
  public float MOVE_SPEED = 8.0F;
  private int N;
  private String O = "刷新成功";
  private String P = "暂无更新";
  private String Q = "刷新失败";
  private String R = "加载成功";
  private String S = "没有更多内容";
  private String T = "加载失败";
  private String U = "上拉加载更多";
  private String V = "释放立即刷新";
  private String W = "正在刷新...";
  Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      PullingLayout.this.MOVE_SPEED = ((float)(8.0D + 5.0D * Math.tan(1.570796326794897D / PullingLayout.this.getMeasuredHeight() * (PullingLayout.this.pullDownY + Math.abs(PullingLayout.a(PullingLayout.this))))));
      if (!PullingLayout.b(PullingLayout.this))
      {
        if ((PullingLayout.c(PullingLayout.this) == 2) && (PullingLayout.this.pullDownY <= PullingLayout.d(PullingLayout.this)))
          PullingLayout.this.pullDownY = PullingLayout.d(PullingLayout.this);
        while (true)
        {
          PullingLayout.e(PullingLayout.this).cancel();
          break;
          if ((PullingLayout.c(PullingLayout.this) != 4) || (-PullingLayout.a(PullingLayout.this) > PullingLayout.f(PullingLayout.this)))
            break;
          PullingLayout.a(PullingLayout.this, -PullingLayout.f(PullingLayout.this));
        }
      }
      if (PullingLayout.this.pullDownY > 0.0F)
      {
        PullingLayout localPullingLayout = PullingLayout.this;
        localPullingLayout.pullDownY -= PullingLayout.this.MOVE_SPEED;
      }
      else if (PullingLayout.a(PullingLayout.this) < 0.0F)
      {
        PullingLayout.a(PullingLayout.this, PullingLayout.a(PullingLayout.this) + PullingLayout.this.MOVE_SPEED);
      }
      if (PullingLayout.this.pullDownY < 0.0F)
      {
        PullingLayout.this.pullDownY = 0.0F;
        PullingLayout.g(PullingLayout.this).clearAnimation();
        if ((PullingLayout.c(PullingLayout.this) != 2) && (PullingLayout.c(PullingLayout.this) != 4))
          PullingLayout.a(PullingLayout.this, 0);
        PullingLayout.e(PullingLayout.this).cancel();
        PullingLayout.this.requestLayout();
      }
      if (PullingLayout.a(PullingLayout.this) > 0.0F)
      {
        PullingLayout.a(PullingLayout.this, 0.0F);
        PullingLayout.h(PullingLayout.this).clearAnimation();
        if ((PullingLayout.c(PullingLayout.this) != 2) && (PullingLayout.c(PullingLayout.this) != 4))
          PullingLayout.a(PullingLayout.this, 0);
        PullingLayout.e(PullingLayout.this).cancel();
        PullingLayout.this.requestLayout();
      }
      PullingLayout.this.requestLayout();
      if (PullingLayout.this.pullDownY + Math.abs(PullingLayout.a(PullingLayout.this)) == 0.0F)
        PullingLayout.e(PullingLayout.this).cancel();
    }
  };
  private String aa = "释放立即加载";
  private String ab = "下拉刷新";
  private String ac = "正在加载...";
  private int ad = 0;
  private int ae = 0;
  private int af = 0;
  private int ag = 0;
  private int ah = 6;
  private int ai = 2;
  private int b = 0;
  private OnRefreshListener c;
  private float d;
  private float e;
  private float f = 0.0F;
  private float g = 200.0F;
  private float h = 200.0F;
  private MyTimer i;
  private boolean j = false;
  private boolean k = false;
  private float l = 2.0F;
  private RotateAnimation m;
  private RotateAnimation n;
  private HeadView o;
  private View p;
  public float pullDownY = 0.0F;
  private View q;
  private ImageView r;
  private TextView s;
  private FootView t;
  private View u;
  private View v;
  private ImageView w;
  private TextView x;
  private int y;
  private FrameLayout z;

  public PullingLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PullingLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public PullingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, this.L);
  }

  private void a()
  {
    this.i.schedule(5L);
  }

  private void a(int paramInt)
  {
    this.b = paramInt;
    TextView localTextView;
    String str;
    View localView;
    switch (this.b)
    {
    default:
      return;
    case 4:
      this.u.clearAnimation();
      this.v.setVisibility(0);
      this.u.setVisibility(4);
      localTextView = this.x;
      str = this.ac;
      break;
    case 3:
      this.x.setText(this.aa);
      localView = this.u;
      break;
    case 2:
      this.p.clearAnimation();
      this.q.setVisibility(0);
      this.p.setVisibility(4);
      localTextView = this.s;
      str = this.W;
      localTextView.setText(str);
      return;
    case 1:
      this.s.setText(this.V);
      localView = this.p;
      localView.startAnimation(this.m);
      return;
    case 0:
    }
    this.r.setVisibility(8);
    this.s.setText(this.ab);
    this.p.clearAnimation();
    this.p.setVisibility(0);
    this.w.setVisibility(8);
    this.x.setText(this.U);
    this.u.clearAnimation();
    this.u.setVisibility(0);
  }

  private void a(Context paramContext)
  {
    this.L = paramContext.getResources().getDisplayMetrics();
    this.E = paramContext;
    TypedArray localTypedArray = this.E.getTheme().obtainStyledAttributes(new int[] { 16842800, 16842801 });
    this.M = localTypedArray.getColor(0, -1);
    this.N = localTypedArray.getColor(1, -16777216);
    localTypedArray.recycle();
    setStateColor(this.M);
    this.H = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.o = new HeadView(this.E);
    super.addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
    this.z = new FrameLayout(this.E);
    super.addView(this.z, new RelativeLayout.LayoutParams(-1, -1));
    this.t = new FootView(this.E);
    super.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
    this.z = ((FrameLayout)getChildAt(1));
    e();
    this.i = new MyTimer(this.a);
    RotateAnimation localRotateAnimation1 = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.m = localRotateAnimation1;
    this.m.setDuration(100L);
    this.m.setRepeatCount(0);
    this.m.setFillAfter(true);
    RotateAnimation localRotateAnimation2 = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.n = localRotateAnimation2;
    this.n.setDuration(1500L);
    this.n.setRepeatCount(-1);
    this.n.setFillAfter(true);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.m.setInterpolator(localLinearInterpolator);
    this.n.setInterpolator(localLinearInterpolator);
  }

  private boolean a(View paramView)
  {
    return paramView.getScrollY() == 0;
  }

  private boolean a(WebView paramWebView)
  {
    return paramWebView.getScrollY() >= paramWebView.getContentHeight() * paramWebView.getScale() - paramWebView.getMeasuredHeight();
  }

  private boolean a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getCount() == 0)
      return true;
    return (paramAbsListView.getFirstVisiblePosition() == 0) && (paramAbsListView.getChildAt(0).getTop() >= 0);
  }

  private boolean a(ExpandableListView paramExpandableListView)
  {
    if (paramExpandableListView.getCount() == 0)
      return true;
    return (paramExpandableListView.getLastVisiblePosition() == paramExpandableListView.getCount() - 1) && (paramExpandableListView.getChildAt(paramExpandableListView.getLastVisiblePosition() - paramExpandableListView.getFirstVisiblePosition()) != null) && (paramExpandableListView.getChildAt(paramExpandableListView.getLastVisiblePosition() - paramExpandableListView.getFirstVisiblePosition()).getBottom() <= paramExpandableListView.getMeasuredHeight());
  }

  private boolean a(GridView paramGridView)
  {
    if (paramGridView.getCount() == 0)
      return true;
    return (paramGridView.getLastVisiblePosition() == paramGridView.getCount() - 1) && (paramGridView.getChildAt(paramGridView.getLastVisiblePosition() - paramGridView.getFirstVisiblePosition()) != null) && (paramGridView.getChildAt(paramGridView.getLastVisiblePosition() - paramGridView.getFirstVisiblePosition()).getBottom() <= paramGridView.getMeasuredHeight());
  }

  private boolean a(ListView paramListView)
  {
    if (paramListView.getCount() == 0)
      return true;
    return (paramListView.getLastVisiblePosition() == paramListView.getCount() - 1) && (paramListView.getChildAt(paramListView.getLastVisiblePosition() - paramListView.getFirstVisiblePosition()) != null) && (paramListView.getChildAt(paramListView.getLastVisiblePosition() - paramListView.getFirstVisiblePosition()).getBottom() <= paramListView.getMeasuredHeight());
  }

  private boolean a(ScrollView paramScrollView)
  {
    return paramScrollView.getScrollY() >= paramScrollView.getChildAt(0).getHeight() - paramScrollView.getMeasuredHeight();
  }

  private void b()
  {
    this.C = true;
    this.D = true;
  }

  private boolean c()
  {
    if ((this.F) && (this.A != null))
    {
      if (this.J != null)
        return this.J.onPullUp(this.A);
      if ((this.A instanceof ListView))
        return a((ListView)this.A);
      if ((this.A instanceof GridView))
        return a((GridView)this.A);
      if ((this.A instanceof ExpandableListView))
        return a((ExpandableListView)this.A);
      if ((this.A instanceof ScrollView))
        return a((ScrollView)this.A);
      if ((this.A instanceof WebView))
        return a((WebView)this.A);
      return true;
    }
    return false;
  }

  private boolean d()
  {
    if ((this.G) && (this.A != null))
    {
      if (this.K != null)
        return this.K.onPullDown(this.A);
      if ((this.A instanceof AbsListView))
        return a((AbsListView)this.A);
      if ((this.A instanceof ScrollView))
        return a((ScrollView)this.A);
      if ((this.A instanceof WebView))
        return a((WebView)this.A);
      return true;
    }
    return false;
  }

  private void e()
  {
    this.p = this.o.getPullView();
    this.s = this.o.getStateText();
    this.q = this.o.getLoadingView();
    this.r = this.o.getStateView();
    this.u = this.t.getPullView();
    this.x = this.t.getStateText();
    this.v = this.t.getLoadingView();
    this.w = this.t.getStateView();
  }

  public void addView(View paramView)
  {
    this.A = paramView;
    this.z.addView(paramView);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(new FrameLayout.LayoutParams(paramLayoutParams.width, paramLayoutParams.height));
    this.A = paramView;
    this.z.addView(paramView);
  }

  public void autoLoad()
  {
    this.f = (-this.h);
    requestLayout();
    a(4);
    if (this.I != null)
      this.I.onLoadMore(this);
  }

  public void autoRefresh()
  {
    AutoRefreshAndLoadTask localAutoRefreshAndLoadTask = new AutoRefreshAndLoadTask(null);
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(20);
    localAutoRefreshAndLoadTask.execute(arrayOfInteger);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 3:
    case 4:
    default:
      break;
    case 5:
    case 6:
      this.B = -1;
      break;
    case 2:
      if (this.B == 0)
      {
        if ((this.pullDownY <= 0.0F) && ((!d()) || (!this.C) || (this.b == 4)))
        {
          if ((this.f >= 0.0F) && ((!c()) || (!this.D) || (this.b == 2)))
          {
            b();
            break label313;
          }
          this.f += (paramMotionEvent.getY() - this.e) / this.l;
          if (this.f > 0.0F)
          {
            this.f = 0.0F;
            this.C = true;
            this.D = false;
          }
          if (this.f < -getMeasuredHeight())
            this.f = (-getMeasuredHeight());
          if (this.b != 4)
            break label313;
        }
        else
        {
          this.pullDownY += (paramMotionEvent.getY() - this.e) / this.l;
          if (this.pullDownY < 0.0F)
          {
            this.pullDownY = 0.0F;
            this.C = false;
            this.D = true;
          }
          if (this.pullDownY > getMeasuredHeight())
            this.pullDownY = getMeasuredHeight();
          if (this.b != 2)
            break label313;
        }
        this.k = true;
      }
      else
      {
        this.B = 0;
      }
      this.e = paramMotionEvent.getY();
      this.l = ((float)(2.0D + 2.0D * Math.tan(1.570796326794897D / getMeasuredHeight() * (this.pullDownY + Math.abs(this.f)))));
      if ((this.pullDownY > 0.0F) || (this.f < 0.0F))
        requestLayout();
      if (this.pullDownY > 0.0F)
      {
        if ((this.pullDownY <= this.g) && ((this.b == 1) || (this.b == 5)))
          a(0);
        if ((this.pullDownY >= this.g) && (this.b == 0))
          a(1);
      }
      else if (this.f < 0.0F)
      {
        if ((-this.f <= this.h) && ((this.b == 3) || (this.b == 5)))
          a(0);
        if ((-this.f >= this.h) && (this.b == 0))
          a(3);
      }
      if (this.pullDownY + Math.abs(this.f) > 8.0F)
        paramMotionEvent.setAction(3);
      break;
    case 1:
      if ((this.pullDownY > this.g) || (-this.f > this.h))
        this.k = false;
      if (this.b == 1)
      {
        a(2);
        if (this.c != null)
          this.c.onRefresh(this);
      }
      else if (this.b == 3)
      {
        a(4);
        if (this.I != null)
          this.I.onLoadMore(this);
      }
      a();
      break;
    case 0:
      label313: this.d = paramMotionEvent.getY();
      this.e = this.d;
      this.i.cancel();
      this.B = 0;
      b();
    }
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }

  public String getLoadFail()
  {
    return this.T;
  }

  public String getLoadNothing()
  {
    return this.S;
  }

  public String getLoadSucceed()
  {
    return this.R;
  }

  public String getLoading()
  {
    return this.ac;
  }

  public String getPulldownToRefresh()
  {
    return this.ab;
  }

  public String getPullupToLoad()
  {
    return this.U;
  }

  public String getRefreshFail()
  {
    return this.Q;
  }

  public String getRefreshNothing()
  {
    return this.P;
  }

  public String getRefreshSucceed()
  {
    return this.O;
  }

  public String getRefreshing()
  {
    return this.W;
  }

  public String getReleaseToLoad()
  {
    return this.aa;
  }

  public String getReleaseToRefresh()
  {
    return this.V;
  }

  public void loadmoreFinish(int paramInt)
  {
    if (this.b != 4)
      return;
    this.v.clearAnimation();
    this.v.setVisibility(8);
    ImageView localImageView;
    Object localObject;
    if (paramInt != 0)
      if (paramInt != 2)
      {
        this.w.setVisibility(0);
        this.x.setText(this.T);
        localImageView = this.w;
        localObject = new FailDrawable();
      }
    while (true)
    {
      localImageView.setBackgroundDrawable((Drawable)localObject);
      break;
      this.w.setVisibility(0);
      this.x.setText(this.S);
      localImageView = this.w;
      localObject = new FailDrawable();
      continue;
      this.w.setVisibility(0);
      this.x.setText(this.R);
      localImageView = this.w;
      localObject = new SucceedDrawable();
    }
    if (this.f < 0.0F)
    {
      new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          PullingLayout.a(PullingLayout.this, 5);
          PullingLayout.i(PullingLayout.this);
        }
      }
      .sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(5);
    a();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.j)
    {
      this.j = true;
      this.g = this.o.getChildAt(0).getMeasuredHeight();
      this.h = this.t.getChildAt(0).getMeasuredHeight();
      this.x.setTextColor(this.y);
      this.s.setTextColor(this.y);
    }
    this.o.layout(0, (int)(this.pullDownY + this.f) - this.o.getMeasuredHeight(), this.o.getMeasuredWidth(), (int)(this.pullDownY + this.f));
    this.z.layout(0, (int)(this.pullDownY + this.f), this.z.getMeasuredWidth(), (int)(this.pullDownY + this.f) + this.z.getMeasuredHeight());
    this.t.layout(0, (int)(this.pullDownY + this.f) + this.z.getMeasuredHeight(), this.t.getMeasuredWidth(), (int)(this.pullDownY + this.f) + this.z.getMeasuredHeight() + this.t.getMeasuredHeight());
  }

  public void refreshFinish(int paramInt)
  {
    if (this.b != 2)
      return;
    this.q.clearAnimation();
    this.q.setVisibility(8);
    ImageView localImageView;
    Object localObject;
    if (paramInt != 0)
      if (paramInt != 2)
      {
        this.r.setVisibility(0);
        this.s.setText(this.Q);
        localImageView = this.r;
        localObject = new FailDrawable();
      }
    while (true)
    {
      localImageView.setBackgroundDrawable((Drawable)localObject);
      break;
      this.r.setVisibility(0);
      this.s.setText(this.P);
      localImageView = this.r;
      localObject = new FailDrawable();
      continue;
      this.r.setVisibility(0);
      this.s.setText(this.O);
      localImageView = this.r;
      localObject = new SucceedDrawable();
    }
    if (this.pullDownY > 0.0F)
    {
      new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          PullingLayout.a(PullingLayout.this, 5);
          PullingLayout.i(PullingLayout.this);
        }
      }
      .sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(5);
    a();
  }

  public void setLoadFail(String paramString)
  {
    this.T = paramString;
  }

  public void setLoadNothing(String paramString)
  {
    this.S = paramString;
  }

  public void setLoadSucceed(String paramString)
  {
    this.R = paramString;
  }

  public void setLoading(String paramString)
  {
    this.ac = paramString;
  }

  public void setOnLoadMoreListener(OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.I = paramOnLoadMoreListener;
  }

  public void setOnPullDownListener(OnPullDownListener paramOnPullDownListener)
  {
    this.K = paramOnPullDownListener;
  }

  public void setOnPullUpListener(OnPullUpListener paramOnPullUpListener)
  {
    this.J = paramOnPullUpListener;
  }

  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.c = paramOnRefreshListener;
  }

  public void setPullDownEnabled(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void setPullUpEnabled(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }

  public void setPulldownToRefresh(String paramString)
  {
    this.ab = paramString;
  }

  public void setPullupToLoad(String paramString)
  {
    this.U = paramString;
  }

  public void setRefreshFail(String paramString)
  {
    this.Q = paramString;
  }

  public void setRefreshNothing(String paramString)
  {
    this.P = paramString;
  }

  public void setRefreshSucceed(String paramString)
  {
    this.O = paramString;
  }

  public void setRefreshing(String paramString)
  {
    this.W = paramString;
  }

  public void setReleaseToLoad(String paramString)
  {
    this.aa = paramString;
  }

  public void setReleaseToRefresh(String paramString)
  {
    this.V = paramString;
  }

  public void setStateColor(int paramInt)
  {
    this.y = paramInt;
  }

  private class AutoRefreshAndLoadTask extends AsyncTask<Integer, Float, String>
  {
    private AutoRefreshAndLoadTask()
    {
    }

    protected String a(Integer[] paramArrayOfInteger)
    {
      while (PullingLayout.this.pullDownY < 1.0F * PullingLayout.d(PullingLayout.this))
      {
        PullingLayout localPullingLayout = PullingLayout.this;
        localPullingLayout.pullDownY += PullingLayout.this.MOVE_SPEED;
        Float[] arrayOfFloat = new Float[1];
        arrayOfFloat[0] = Float.valueOf(PullingLayout.this.pullDownY);
        publishProgress(arrayOfFloat);
        try
        {
          Thread.sleep(paramArrayOfInteger[0].intValue());
        }
        catch (InterruptedException localInterruptedException)
        {
          a.a(localInterruptedException);
        }
      }
      return null;
    }

    protected void a(String paramString)
    {
      PullingLayout.a(PullingLayout.this, 2);
      if (PullingLayout.j(PullingLayout.this) != null)
        PullingLayout.j(PullingLayout.this).onRefresh(PullingLayout.this);
      PullingLayout.i(PullingLayout.this);
    }

    protected void a(Float[] paramArrayOfFloat)
    {
      if (PullingLayout.this.pullDownY > PullingLayout.d(PullingLayout.this))
        PullingLayout.a(PullingLayout.this, 1);
      PullingLayout.this.requestLayout();
    }
  }

  private class FailDrawable extends PullingLayout.LoadingDrawable
  {
    FailDrawable()
    {
      super();
      b();
    }
  }

  private class FailDrawable2 extends Drawable
  {
    private Paint b;

    public void draw(Canvas paramCanvas)
    {
      this.b.setColor(PullingLayout.m(this.a));
      Rect localRect = getBounds();
      int i = (int)(0.35D * Math.min(localRect.right, localRect.bottom));
      paramCanvas.drawCircle(localRect.right / 2, localRect.bottom / 2, i, this.b);
      paramCanvas.drawLine(localRect.right / 2, 0.25F * localRect.bottom, localRect.right / 2, 0.65F * localRect.bottom, this.b);
      paramCanvas.drawLine(localRect.right / 2, 0.7F * localRect.bottom, localRect.right / 2, 0.75F * localRect.bottom, this.b);
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.b.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
  }

  public class FootView extends RelativeLayout
  {
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ImageView e;

    public FootView(Context arg2)
    {
      super();
      a(localContext);
    }

    public FootView(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
      a(paramAttributeSet);
    }

    public FootView(Context paramAttributeSet, AttributeSet paramInt, int arg4)
    {
      super(paramInt, i);
      a(paramAttributeSet);
    }

    private void a(Context paramContext)
    {
      int i = PullingLayout.b(PullingLayout.this, 30.0F);
      RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
      localRelativeLayout1.setPadding(0, PullingLayout.b(PullingLayout.this, 20.0F), 0, PullingLayout.b(PullingLayout.this, 20.0F));
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(10);
      addView(localRelativeLayout1, localLayoutParams1);
      RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(13);
      localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams2);
      this.e = new ImageView(paramContext);
      this.e.setBackgroundDrawable(new PullingLayout.PullUpDrawable(PullingLayout.this));
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams3.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams3.addRule(15);
      localRelativeLayout2.addView(this.e, localLayoutParams3);
      this.b = new ImageView(paramContext);
      this.b.setVisibility(8);
      this.b.setBackgroundDrawable(new PullingLayout.LoadingDrawable(PullingLayout.this));
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams4.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams4.addRule(15);
      localRelativeLayout2.addView(this.b, localLayoutParams4);
      this.c = new TextView(paramContext);
      this.c.setText(PullingLayout.l(PullingLayout.this));
      this.c.setTextSize(16.0F);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams5.addRule(13);
      localRelativeLayout2.addView(this.c, localLayoutParams5);
      this.d = new ImageView(paramContext);
      this.d.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams6 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams6.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams6.addRule(15);
      localRelativeLayout2.addView(this.d, localLayoutParams6);
    }

    public ImageView getLoadingView()
    {
      return this.b;
    }

    public ImageView getPullView()
    {
      return this.e;
    }

    public TextView getStateText()
    {
      return this.c;
    }

    public ImageView getStateView()
    {
      return this.d;
    }
  }

  public class HeadView extends RelativeLayout
  {
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ImageView e;

    public HeadView(Context arg2)
    {
      super();
      a(localContext);
    }

    public HeadView(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
      a(paramAttributeSet);
    }

    public HeadView(Context paramAttributeSet, AttributeSet paramInt, int arg4)
    {
      super(paramInt, i);
      a(paramAttributeSet);
    }

    private void a(Context paramContext)
    {
      int i = PullingLayout.b(PullingLayout.this, 30.0F);
      RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
      localRelativeLayout1.setPadding(0, PullingLayout.b(PullingLayout.this, 20.0F), 0, PullingLayout.b(PullingLayout.this, 20.0F));
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      addView(localRelativeLayout1, localLayoutParams1);
      RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(13);
      localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams2);
      this.e = new ImageView(paramContext);
      this.e.setBackgroundDrawable(new PullingLayout.PullDownDrawable(PullingLayout.this));
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams3.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams3.addRule(15);
      localRelativeLayout2.addView(this.e, localLayoutParams3);
      this.b = new ImageView(paramContext);
      this.b.setVisibility(8);
      this.b.setBackgroundDrawable(new PullingLayout.LoadingDrawable(PullingLayout.this));
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams4.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams4.addRule(15);
      localRelativeLayout2.addView(this.b, localLayoutParams4);
      this.c = new TextView(paramContext);
      this.c.setText(PullingLayout.k(PullingLayout.this));
      this.c.setTextSize(16.0F);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams5.addRule(13);
      localRelativeLayout2.addView(this.c, localLayoutParams5);
      this.d = new ImageView(paramContext);
      this.d.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams6 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams6.setMargins(PullingLayout.b(PullingLayout.this, 60.0F), 0, 0, 0);
      localLayoutParams6.addRule(15);
      localRelativeLayout2.addView(this.d, localLayoutParams6);
    }

    public ImageView getLoadingView()
    {
      return this.b;
    }

    public ImageView getPullView()
    {
      return this.e;
    }

    public TextView getStateText()
    {
      return this.c;
    }

    public ImageView getStateView()
    {
      return this.d;
    }
  }

  private class LoadingDrawable extends Drawable
  {
    private Paint a = new Paint();
    private int c;

    LoadingDrawable()
    {
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setAntiAlias(true);
      this.a.setStrokeWidth(PullingLayout.b(PullingLayout.this, 2.0F));
    }

    void a()
    {
      this.c = 1;
    }

    void b()
    {
      this.c = -1;
    }

    public void draw(Canvas paramCanvas)
    {
      this.a.setColor(PullingLayout.m(PullingLayout.this));
      Rect localRect = getBounds();
      float f1 = (int)Math.min(localRect.right, localRect.bottom);
      float f2 = 0.15F * f1;
      float f3 = f1 * 0.85F;
      RectF localRectF = new RectF(f2, f2, f3, f3);
      if ((PullingLayout.n(PullingLayout.this) >= 360) && (this.c == 0))
      {
        PullingLayout.c(PullingLayout.this, 8);
        PullingLayout.b(PullingLayout.this, -6);
      }
      else if (PullingLayout.n(PullingLayout.this) <= 6)
      {
        PullingLayout.b(PullingLayout.this, 6);
        PullingLayout.c(PullingLayout.this, 2);
      }
      if ((PullingLayout.n(PullingLayout.this) < 360) || (this.c == 0))
      {
        PullingLayout localPullingLayout;
        int i;
        if (this.c == 0)
        {
          PullingLayout.d(PullingLayout.this, PullingLayout.n(PullingLayout.this) + PullingLayout.o(PullingLayout.this));
          localPullingLayout = PullingLayout.this;
          i = PullingLayout.p(PullingLayout.this);
        }
        for (int j = PullingLayout.q(PullingLayout.this); ; j = 2 * PullingLayout.q(PullingLayout.this))
        {
          PullingLayout.e(localPullingLayout, i + j);
          PullingLayout.e(PullingLayout.this, PullingLayout.p(PullingLayout.this) % 360);
          break;
          PullingLayout.d(PullingLayout.this, PullingLayout.n(PullingLayout.this) + 2 * PullingLayout.o(PullingLayout.this));
          localPullingLayout = PullingLayout.this;
          i = PullingLayout.p(PullingLayout.this);
        }
      }
      paramCanvas.drawArc(localRectF, PullingLayout.p(PullingLayout.this), PullingLayout.n(PullingLayout.this), false, this.a);
      if (PullingLayout.n(PullingLayout.this) >= 360)
      {
        PullingLayout.b(PullingLayout.this, -6);
        PullingLayout.c(PullingLayout.this, 8);
        if (this.c == 1)
        {
          Path localPath = new Path();
          localPath.moveTo(0.3F * localRect.right, 0.5F * localRect.bottom);
          localPath.lineTo(0.45F * localRect.right, 0.7F * localRect.bottom);
          localPath.lineTo(0.75F * localRect.right, 0.4F * localRect.bottom);
          paramCanvas.drawPath(localPath, this.a);
        }
        else if (this.c == -1)
        {
          paramCanvas.drawLine(localRect.right / 2, 0.25F * localRect.bottom, localRect.right / 2, 0.65F * localRect.bottom, this.a);
          paramCanvas.drawLine(localRect.right / 2, 0.7F * localRect.bottom, localRect.right / 2, 0.75F * localRect.bottom, this.a);
        }
      }
      invalidateSelf();
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.a.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.a.setColorFilter(paramColorFilter);
    }
  }

  private class LoadingDrawable2 extends Drawable
  {
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;

    public void draw(Canvas paramCanvas)
    {
      this.b.setColor(PullingLayout.m(this.a));
      Rect localRect = getBounds();
      int i = (int)(0.35D * Math.min(localRect.right, localRect.bottom));
      float f1 = i / 2;
      float f2 = 2.5F * i;
      RectF localRectF = new RectF(f1, f1, f2, f2);
      if (this.c > 360)
      {
        this.f += this.e;
        this.e = (0 - this.e);
      }
      else if (this.c < 6)
      {
        this.e = 6;
        this.f = 2;
      }
      this.c += this.e;
      this.d += this.f;
      paramCanvas.drawArc(localRectF, this.d % 360, this.c, false, this.b);
      invalidateSelf();
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.b.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
  }

  class MyTimer
  {
    private Handler b;
    private Timer c;
    private MyTask d;

    public MyTimer(Handler arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new Timer();
    }

    public void cancel()
    {
      if (this.d != null)
      {
        this.d.cancel();
        this.d = null;
      }
    }

    public void schedule(long paramLong)
    {
      if (this.d != null)
      {
        this.d.cancel();
        this.d = null;
      }
      this.d = new MyTask(this.b);
      this.c.schedule(this.d, 0L, paramLong);
    }

    class MyTask extends TimerTask
    {
      private Handler b;

      public MyTask(Handler arg2)
      {
        Object localObject;
        this.b = localObject;
      }

      public void run()
      {
        this.b.obtainMessage().sendToTarget();
      }
    }
  }

  public static abstract interface OnLoadMoreListener
  {
    public abstract void onLoadMore(PullingLayout paramPullingLayout);
  }

  public static abstract interface OnPullDownListener
  {
    public abstract boolean onPullDown(View paramView);
  }

  public static abstract interface OnPullUpListener
  {
    public abstract boolean onPullUp(View paramView);
  }

  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh(PullingLayout paramPullingLayout);
  }

  private class PullDownDrawable extends Drawable
  {
    private Paint b = new Paint();

    PullDownDrawable()
    {
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setAntiAlias(true);
      this.b.setStrokeWidth(PullingLayout.b(PullingLayout.this, 2.0F));
    }

    public void draw(Canvas paramCanvas)
    {
      this.b.setColor(PullingLayout.m(PullingLayout.this));
      Rect localRect = getBounds();
      int i = (int)(0.35D * Math.min(localRect.right, localRect.bottom));
      paramCanvas.drawCircle(localRect.right / 2, localRect.bottom / 2, i, this.b);
      Path localPath = new Path();
      localPath.moveTo(0.5F * localRect.right, 0.25F * localRect.bottom);
      localPath.lineTo(0.5F * localRect.right, 0.75F * localRect.bottom);
      localPath.moveTo(0.25F * localRect.right, 0.5F * localRect.bottom);
      localPath.lineTo(0.5F * localRect.right, 0.75F * localRect.bottom);
      localPath.lineTo(0.75F * localRect.right, 0.5F * localRect.bottom);
      paramCanvas.drawPath(localPath, this.b);
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.b.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
  }

  private class PullUpDrawable extends Drawable
  {
    private Paint b = new Paint();

    PullUpDrawable()
    {
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setAntiAlias(true);
      this.b.setStrokeWidth(PullingLayout.b(PullingLayout.this, 2.0F));
    }

    public void draw(Canvas paramCanvas)
    {
      this.b.setColor(PullingLayout.m(PullingLayout.this));
      Rect localRect = getBounds();
      int i = (int)(0.35D * Math.min(localRect.right, localRect.bottom));
      paramCanvas.drawCircle(localRect.right / 2, localRect.bottom / 2, i, this.b);
      Path localPath = new Path();
      localPath.moveTo(0.5F * localRect.right, 0.25F * localRect.bottom);
      localPath.lineTo(0.5F * localRect.right, 0.75F * localRect.bottom);
      localPath.moveTo(0.25F * localRect.right, 0.5F * localRect.bottom);
      localPath.lineTo(0.5F * localRect.right, 0.25F * localRect.bottom);
      localPath.lineTo(0.75F * localRect.right, 0.5F * localRect.bottom);
      paramCanvas.drawPath(localPath, this.b);
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.b.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
  }

  private class SucceedDrawable extends PullingLayout.LoadingDrawable
  {
    SucceedDrawable()
    {
      super();
      a();
    }
  }

  private class SucceedDrawable2 extends Drawable
  {
    private Paint b;

    public void draw(Canvas paramCanvas)
    {
      this.b.setColor(PullingLayout.m(this.a));
      Rect localRect = getBounds();
      int i = (int)(0.35D * Math.min(localRect.right, localRect.bottom));
      paramCanvas.drawCircle(localRect.right / 2, localRect.bottom / 2, i, this.b);
      Path localPath = new Path();
      localPath.moveTo(0.3F * localRect.right, 0.5F * localRect.bottom);
      localPath.lineTo(0.45F * localRect.right, 0.7F * localRect.bottom);
      localPath.lineTo(0.75F * localRect.right, 0.4F * localRect.bottom);
      paramCanvas.drawPath(localPath, this.b);
    }

    public int getOpacity()
    {
      return 0;
    }

    public void setAlpha(int paramInt)
    {
      this.b.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.PullingLayout
 * JD-Core Version:    0.6.2
 */