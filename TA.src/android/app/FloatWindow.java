package android.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class FloatWindow
{
  private Context a;
  private TitleBar b;
  private WindowManager c;
  private WindowManager.LayoutParams d;
  private LinearLayout e;
  private FrameLayout f;
  private int g;
  private DisplayMetrics h;
  private int i;
  private int j;

  public FloatWindow(Context paramContext)
  {
    this.a = paramContext;
    this.h = paramContext.getResources().getDisplayMetrics();
    this.i = a();
    this.j = b();
    a(paramContext);
  }

  private int a()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels;
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, this.h);
  }

  private void a(Context paramContext)
  {
    this.c = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    this.d = new WindowManager.LayoutParams();
    this.d.format = 1;
    this.d.flags = 262176;
    this.d.type = 2002;
    this.d.width = -2;
    this.d.height = -2;
    this.e = new ContentView(paramContext);
    this.e.setPadding(a(8.0F), a(8.0F), a(8.0F), a(8.0F));
    this.e.setOrientation(1);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(new int[] { 16842801, 16842806 });
    int k = localTypedArray.getColor(0, 16711935);
    this.g = localTypedArray.getColor(1, 16711935);
    localTypedArray.recycle();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(k);
    localGradientDrawable.setCornerRadius(4.0F);
    localGradientDrawable.setStroke(2, this.g);
    localGradientDrawable.setAlpha(136);
    this.e.setBackgroundDrawable(localGradientDrawable);
    this.c.addView(this.e, this.d);
    this.e.setVisibility(8);
    this.b = new TitleBar(paramContext);
    this.f = new FrameLayout(paramContext);
    this.e.addView(this.b);
    this.e.addView(this.f);
  }

  private void a(boolean paramBoolean)
  {
    int k = 8;
    WindowManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      if (this.d.flags != k)
        return;
      this.c.removeView(this.e);
      this.c.addView(this.e, this.d);
      localLayoutParams = this.d;
      k = 262176;
    }
    else
    {
      localLayoutParams = this.d;
    }
    localLayoutParams.flags = k;
    this.c.updateViewLayout(this.e, this.d);
  }

  private int b()
  {
    return this.a.getResources().getDisplayMetrics().heightPixels;
  }

  public void dismiss()
  {
    this.c.removeView(this.e);
  }

  public Drawable getBackground()
  {
    return this.e.getBackground();
  }

  public void hide()
  {
    this.e.setVisibility(8);
  }

  public void setBackground(Drawable paramDrawable)
  {
    this.e.setBackgroundDrawable(paramDrawable);
  }

  public void setContentView(View paramView)
  {
    this.f.removeAllViews();
    this.f.addView(paramView);
  }

  public void setFlags(int paramInt)
  {
    this.d.flags = paramInt;
    this.c.updateViewLayout(this.e, this.d);
  }

  public void setFormat(int paramInt)
  {
    this.d.format = paramInt;
    this.c.updateViewLayout(this.e, this.d);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.setTitle(paramCharSequence);
  }

  public void setType(int paramInt)
  {
    this.d.type = paramInt;
    this.c.updateViewLayout(this.e, this.d);
  }

  public void show()
  {
    this.e.setVisibility(0);
  }

  private class ContentView extends LinearLayout
  {
    private int b = 0;
    private int c = 0;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private int k = FloatWindow.a(FloatWindow.this, 8.0F);
    private boolean l;

    public ContentView(Context arg2)
    {
      super();
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      FloatWindow localFloatWindow;
      if (paramMotionEvent.getAction() == 4)
        localFloatWindow = FloatWindow.this;
      for (boolean bool = false; ; bool = true)
      {
        FloatWindow.a(localFloatWindow, bool);
        break;
        if (paramMotionEvent.getAction() != 0)
          break;
        localFloatWindow = FloatWindow.this;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      this.d = ((int)paramMotionEvent.getRawY());
      this.e = ((int)paramMotionEvent.getRawX());
      if (paramMotionEvent.getAction() == 4)
        FloatWindow.a(FloatWindow.this, false);
      else if (paramMotionEvent.getAction() == 0)
        FloatWindow.a(FloatWindow.this, true);
      if (paramMotionEvent.getAction() == 0)
      {
        if (getWidth() - paramMotionEvent.getX() < this.k)
          this.j = true;
        if (getHeight() - paramMotionEvent.getY() < this.k)
          this.l = true;
        this.f = getWidth();
        this.g = getHeight();
        this.c = this.d;
        this.b = this.e;
        this.h = FloatWindow.b(FloatWindow.this).x;
        this.i = FloatWindow.b(FloatWindow.this).y;
        return true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        FloatWindow.b(FloatWindow.this).x = this.h;
        FloatWindow.b(FloatWindow.this).y = this.i;
        if (this.j)
          FloatWindow.b(FloatWindow.this).width = Math.min(this.f + (this.e - this.b), FloatWindow.e(FloatWindow.this));
        if (this.l)
          FloatWindow.b(FloatWindow.this).height = Math.min(this.g + (this.d - this.c), FloatWindow.f(FloatWindow.this));
        FloatWindow.d(FloatWindow.this).updateViewLayout(FloatWindow.c(FloatWindow.this), FloatWindow.b(FloatWindow.this));
        return true;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.j = false;
        this.l = false;
      }
      return true;
    }
  }

  private class TitleBar extends LinearLayout
  {
    private TextView b;

    public TitleBar(Context arg2)
    {
      super();
      this.b = new FloatWindow.TitleView(FloatWindow.this, localContext);
      this.b.setSingleLine(true);
      TextView localTextView = new TextView(localContext);
      localTextView.setText("X");
      localTextView.setGravity(17);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(1140850943);
      localGradientDrawable.setCornerRadius(4.0F);
      localGradientDrawable.setStroke(2, FloatWindow.a(FloatWindow.this));
      localGradientDrawable.setAlpha(136);
      localTextView.setBackgroundDrawable(localGradientDrawable);
      localTextView.setTextSize(1, 18.0F);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FloatWindow.this.dismiss();
        }
      });
      addView(this.b, new LinearLayout.LayoutParams(-1, FloatWindow.a(FloatWindow.this, 24.0F), 1.0F));
      addView(localTextView, new LinearLayout.LayoutParams(FloatWindow.a(FloatWindow.this, 24.0F), FloatWindow.a(FloatWindow.this, 24.0F)));
    }

    public void setTitle(CharSequence paramCharSequence)
    {
      this.b.setText(paramCharSequence);
    }
  }

  private class TitleView extends TextView
  {
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g;
    private int h;

    public TitleView(Context arg2)
    {
      super();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.f = localRect.top;
      this.g = ((int)paramMotionEvent.getRawY());
      this.h = ((int)paramMotionEvent.getRawX());
      if (paramMotionEvent.getAction() == 0)
      {
        this.e = (this.g - (int)paramMotionEvent.getY());
        this.d = (this.h - (int)paramMotionEvent.getX());
        this.c = this.g;
        this.b = this.h;
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        FloatWindow.b(FloatWindow.this).gravity = 51;
        FloatWindow.b(FloatWindow.this).x = (this.d + (this.h - this.b));
        FloatWindow.b(FloatWindow.this).y = (3 + (this.e + (this.g - this.c) - this.f));
        FloatWindow.d(FloatWindow.this).updateViewLayout(FloatWindow.c(FloatWindow.this), FloatWindow.b(FloatWindow.this));
      }
      return true;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.app.FloatWindow
 * JD-Core Version:    0.6.2
 */