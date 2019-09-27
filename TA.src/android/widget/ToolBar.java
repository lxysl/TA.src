package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

public class ToolBar extends LinearLayout
{
  private TextView a;
  private TextView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private LinearLayout f;
  private PopupMenu g;
  private OnLogoClickListener h;
  private OnNaviClickListener i;
  private OnMenuItemClickListener j;
  private DisplayMetrics k;
  private int l;

  public ToolBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, this.k);
  }

  private void a(Context paramContext)
  {
    this.k = paramContext.getResources().getDisplayMetrics();
    this.l = a(48.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.l, this.l);
    setMinimumHeight(this.l);
    this.c = new ImageView(paramContext);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.c.setVisibility(8);
    super.addView(this.c, localLayoutParams);
    this.d = new ImageView(paramContext);
    this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.d.setImageResource(2130771968);
    this.d.setVisibility(8);
    super.addView(this.d, localLayoutParams);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    int m = a(1.0F);
    localLinearLayout.setPadding(m * 4, m, m, m);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    super.addView(localLinearLayout, new LinearLayout.LayoutParams(-1, this.l, 1.0F));
    this.a = new TextView(paramContext);
    this.a.setTextSize(1, 20.0F);
    this.a.setSingleLine(true);
    this.a.setTypeface(Typeface.DEFAULT_BOLD);
    localLinearLayout.addView(this.a, new LinearLayout.LayoutParams(-1, a(26.0F)));
    this.b = new TextView(paramContext);
    this.b.setTextSize(1, 14.0F);
    this.b.setSingleLine(true);
    this.b.setVisibility(8);
    localLinearLayout.addView(this.b, new LinearLayout.LayoutParams(-1, a(20.0F)));
    this.f = new LinearLayout(paramContext);
    super.addView(this.f, new LinearLayout.LayoutParams(-2, this.l));
    this.e = new ImageView(paramContext);
    this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.e.setVisibility(8);
    super.addView(this.e, localLayoutParams);
    new RippleHelper(this.c);
    new RippleHelper(this.e);
    Paint localPaint = new Paint();
    localPaint.setColor(-7829368);
    Bitmap localBitmap1 = Bitmap.createBitmap(this.l, this.l, Bitmap.Config.ARGB_4444);
    Canvas localCanvas1 = new Canvas(localBitmap1);
    double d1 = this.l;
    double d2 = d1 / 4.0D;
    float f1 = (int)d2;
    double d3 = d1 / 32.0D;
    float f2 = (int)(10.0D * d3);
    float f3 = (int)(d2 * 3.0D);
    localCanvas1.drawRect(f1, f2, f3, (int)(12.0D * d3), localPaint);
    localCanvas1.drawRect(f1, (int)(15.0D * d3), f3, (int)(17.0D * d3), localPaint);
    localCanvas1.drawRect(f1, (int)(20.0D * d3), f3, (int)(d3 * 22.0D), localPaint);
    this.c.setImageBitmap(localBitmap1);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.l, this.l, Bitmap.Config.ARGB_4444);
    Canvas localCanvas2 = new Canvas(localBitmap2);
    float f4 = (int)(d1 / 2.0D);
    double d4 = d1 / 3.0D;
    float f5 = (int)d4;
    float f6 = (int)(d1 / 16.0D);
    localCanvas2.drawCircle(f4, f5, f6, localPaint);
    localCanvas2.drawCircle(f4, f4, f6, localPaint);
    localCanvas2.drawCircle(f4, (int)(d4 * 2.0D), f6, localPaint);
    this.e.setImageBitmap(localBitmap2);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ToolBar.a(ToolBar.this) != null)
          ToolBar.a(ToolBar.this).onNaviClick(paramAnonymousView);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ToolBar.b(ToolBar.this) != null)
          ToolBar.b(ToolBar.this).onLogoClick(paramAnonymousView);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ToolBar.c(ToolBar.this) != null)
          ToolBar.c(ToolBar.this).show();
      }
    });
    this.g = new PopupMenu(getContext(), this.e);
    this.g.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (ToolBar.d(ToolBar.this) != null)
          return ToolBar.d(ToolBar.this).onMenuItemClick(paramAnonymousMenuItem);
        return false;
      }
    });
  }

  public void addView(View paramView)
  {
    this.f.addView(paramView);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.f.addView(paramView, paramLayoutParams);
  }

  public Menu getMenu()
  {
    setMenuEnabled(true);
    return this.g.getMenu();
  }

  public void setLogo(Drawable paramDrawable)
  {
    this.d.setImageDrawable(paramDrawable);
  }

  public void setLogoEnabled(boolean paramBoolean)
  {
    ImageView localImageView = this.d;
    int m;
    if (paramBoolean)
      m = 0;
    else
      m = 8;
    localImageView.setVisibility(m);
  }

  public void setMenuEnabled(boolean paramBoolean)
  {
    ImageView localImageView = this.e;
    int m;
    if (paramBoolean)
      m = 0;
    else
      m = 8;
    localImageView.setVisibility(m);
  }

  public void setNaviEnabled(boolean paramBoolean)
  {
    ImageView localImageView = this.c;
    int m;
    if (paramBoolean)
      m = 0;
    else
      m = 8;
    localImageView.setVisibility(m);
  }

  public void setNaviIcon(Drawable paramDrawable)
  {
    this.c.setImageDrawable(paramDrawable);
  }

  public void setOnLogoClickListener(OnLogoClickListener paramOnLogoClickListener)
  {
    this.h = paramOnLogoClickListener;
  }

  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.j = paramOnMenuItemClickListener;
  }

  public void setOnNaviClickListener(OnNaviClickListener paramOnNaviClickListener)
  {
    this.i = paramOnNaviClickListener;
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    TextView localTextView;
    int m;
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      localTextView = this.b;
      m = 0;
    }
    else
    {
      localTextView = this.b;
      m = 8;
    }
    localTextView.setVisibility(m);
    this.b.setText(paramCharSequence);
  }

  public void setSubtitleColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }

  public void setTitleColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
  }

  public static abstract interface OnLogoClickListener
  {
    public abstract void onLogoClick(View paramView);
  }

  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }

  public static abstract interface OnNaviClickListener
  {
    public abstract void onNaviClick(View paramView);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.ToolBar
 * JD-Core Version:    0.6.2
 */