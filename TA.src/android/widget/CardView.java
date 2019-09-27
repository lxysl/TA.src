package android.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;

public class CardView extends FrameLayout
  implements CardViewDelegate
{
  private static final CardViewImpl a;
  private DisplayMetrics b;
  private boolean c;
  private boolean d;
  private final Rect e = new Rect();
  private final Rect f = new Rect();

  static
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
      localObject = new CardViewApi21();
    while (true)
    {
      a = (CardViewImpl)localObject;
      break;
      if (Build.VERSION.SDK_INT >= 17)
        localObject = new CardViewJellybeanMr1();
      else
        localObject = new CardViewEclairMr1();
    }
    a.initStatic();
  }

  public CardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }

  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }

  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  private float a(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, this.b);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.b = paramContext.getResources().getDisplayMetrics();
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(new int[] { 16842801 });
    int i = localTypedArray.getColor(0, -328966);
    localTypedArray.recycle();
    float f1 = a(2.0F);
    float f2 = a(2.0F);
    float f3 = a(2.0F);
    this.c = false;
    this.d = true;
    this.e.left = 0;
    this.e.top = 0;
    this.e.right = 0;
    this.e.bottom = 0;
    float f4;
    if (f2 > f3)
      f4 = f2;
    else
      f4 = f3;
    a.initialize(this, paramContext, i, f1, f2, f4);
  }

  public float getCardElevation()
  {
    return a.getElevation(this);
  }

  public int getContentPaddingBottom()
  {
    return this.e.bottom;
  }

  public int getContentPaddingLeft()
  {
    return this.e.left;
  }

  public int getContentPaddingRight()
  {
    return this.e.right;
  }

  public int getContentPaddingTop()
  {
    return this.e.top;
  }

  public float getMaxCardElevation()
  {
    return a.getMaxElevation(this);
  }

  public boolean getPreventCornerOverlap()
  {
    return this.d;
  }

  public float getRadius()
  {
    return a.getRadius(this);
  }

  public boolean getUseCompatPadding()
  {
    return this.c;
  }

  @SuppressLint({"SwitchIntDef"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(a instanceof CardViewApi21))
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((i == -2147483648) || (i == 1073741824))
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(a.getMinWidth(this)), View.MeasureSpec.getSize(paramInt1)), i);
      int j = View.MeasureSpec.getMode(paramInt2);
      if ((j == -2147483648) || (j == 1073741824))
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(a.getMinHeight(this)), View.MeasureSpec.getSize(paramInt2)), j);
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setBackgroundColor(int paramInt)
  {
    a.setBackgroundColor(this, paramInt);
  }

  public void setCardBackgroundColor(int paramInt)
  {
    a.setBackgroundColor(this, paramInt);
  }

  public void setCardElevation(float paramFloat)
  {
    a.setElevation(this, paramFloat);
  }

  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a.updatePadding(this);
  }

  public void setMaxCardElevation(float paramFloat)
  {
    a.setMaxElevation(this, paramFloat);
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean == this.d)
      return;
    this.d = paramBoolean;
    a.onPreventCornerOverlapChanged(this);
  }

  public void setRadius(float paramFloat)
  {
    a.setRadius(this, paramFloat);
  }

  public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
    super.setPadding(paramInt1 + this.e.left, paramInt2 + this.e.top, paramInt3 + this.e.right, paramInt4 + this.e.bottom);
  }

  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.c == paramBoolean)
      return;
    this.c = paramBoolean;
    a.onCompatPaddingChanged(this);
  }

  @SuppressLint({"NewApi"})
  static class CardViewApi21
    implements CardViewImpl
  {
    public float getElevation(CardViewDelegate paramCardViewDelegate)
    {
      return ((View)paramCardViewDelegate).getElevation();
    }

    public float getMaxElevation(CardViewDelegate paramCardViewDelegate)
    {
      return ((RoundRectDrawable)paramCardViewDelegate.getBackground()).a();
    }

    public float getMinHeight(CardViewDelegate paramCardViewDelegate)
    {
      return 2.0F * getRadius(paramCardViewDelegate);
    }

    public float getMinWidth(CardViewDelegate paramCardViewDelegate)
    {
      return 2.0F * getRadius(paramCardViewDelegate);
    }

    public float getRadius(CardViewDelegate paramCardViewDelegate)
    {
      return ((RoundRectDrawable)paramCardViewDelegate.getBackground()).getRadius();
    }

    public void initStatic()
    {
    }

    public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      paramCardViewDelegate.setBackgroundDrawable(new RoundRectDrawable(paramInt, paramFloat1));
      View localView = (View)paramCardViewDelegate;
      localView.setClipToOutline(true);
      localView.setElevation(paramFloat2);
      setMaxElevation(paramCardViewDelegate, paramFloat3);
    }

    public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate)
    {
      setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
    {
      setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
    }

    public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, int paramInt)
    {
      ((RoundRectDrawable)paramCardViewDelegate.getBackground()).setColor(paramInt);
    }

    public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      ((View)paramCardViewDelegate).setElevation(paramFloat);
    }

    public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      ((RoundRectDrawable)paramCardViewDelegate.getBackground()).a(paramFloat, paramCardViewDelegate.getUseCompatPadding(), paramCardViewDelegate.getPreventCornerOverlap());
      updatePadding(paramCardViewDelegate);
    }

    public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      ((RoundRectDrawable)paramCardViewDelegate.getBackground()).a(paramFloat);
    }

    public void updatePadding(CardViewDelegate paramCardViewDelegate)
    {
      if (!paramCardViewDelegate.getUseCompatPadding())
      {
        paramCardViewDelegate.setShadowPadding(0, 0, 0, 0);
        return;
      }
      float f1 = getMaxElevation(paramCardViewDelegate);
      float f2 = getRadius(paramCardViewDelegate);
      int i = (int)Math.ceil(RoundRectDrawableWithShadow.b(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
      int j = (int)Math.ceil(RoundRectDrawableWithShadow.a(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
      paramCardViewDelegate.setShadowPadding(i, j, i, j);
    }
  }

  static class CardViewEclairMr1
    implements CardViewImpl
  {
    final RectF a = new RectF();

    private RoundRectDrawableWithShadow a(CardViewDelegate paramCardViewDelegate)
    {
      return (RoundRectDrawableWithShadow)paramCardViewDelegate.getBackground();
    }

    RoundRectDrawableWithShadow a(Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      RoundRectDrawableWithShadow localRoundRectDrawableWithShadow = new RoundRectDrawableWithShadow(paramContext.getResources(), paramInt, paramFloat1, paramFloat2, paramFloat3);
      return localRoundRectDrawableWithShadow;
    }

    public float getElevation(CardViewDelegate paramCardViewDelegate)
    {
      return a(paramCardViewDelegate).b();
    }

    public float getMaxElevation(CardViewDelegate paramCardViewDelegate)
    {
      return a(paramCardViewDelegate).c();
    }

    public float getMinHeight(CardViewDelegate paramCardViewDelegate)
    {
      return a(paramCardViewDelegate).e();
    }

    public float getMinWidth(CardViewDelegate paramCardViewDelegate)
    {
      return a(paramCardViewDelegate).d();
    }

    public float getRadius(CardViewDelegate paramCardViewDelegate)
    {
      return a(paramCardViewDelegate).a();
    }

    public void initStatic()
    {
      RoundRectDrawableWithShadow.c = new RoundRectDrawableWithShadow.RoundRectHelper()
      {
        public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
        {
          float f1 = 2.0F * paramAnonymousFloat;
          float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
          float f3 = paramAnonymousRectF.height() - f1 - 1.0F;
          float f4;
          if (paramAnonymousFloat >= 1.0F)
          {
            f4 = paramAnonymousFloat + 0.5F;
            RectF localRectF = CardView.CardViewEclairMr1.this.a;
            float f5 = -f4;
            localRectF.set(f5, f5, f4, f4);
            int i = paramAnonymousCanvas.save();
            paramAnonymousCanvas.translate(f4 + paramAnonymousRectF.left, f4 + paramAnonymousRectF.top);
            paramAnonymousCanvas.drawArc(CardView.CardViewEclairMr1.this.a, 180.0F, 90.0F, true, paramAnonymousPaint);
            paramAnonymousCanvas.translate(f2, 0.0F);
            paramAnonymousCanvas.rotate(90.0F);
            paramAnonymousCanvas.drawArc(CardView.CardViewEclairMr1.this.a, 180.0F, 90.0F, true, paramAnonymousPaint);
            paramAnonymousCanvas.translate(f3, 0.0F);
            paramAnonymousCanvas.rotate(90.0F);
            paramAnonymousCanvas.drawArc(CardView.CardViewEclairMr1.this.a, 180.0F, 90.0F, true, paramAnonymousPaint);
            paramAnonymousCanvas.translate(f2, 0.0F);
            paramAnonymousCanvas.rotate(90.0F);
            paramAnonymousCanvas.drawArc(CardView.CardViewEclairMr1.this.a, 180.0F, 90.0F, true, paramAnonymousPaint);
            paramAnonymousCanvas.restoreToCount(i);
            paramAnonymousCanvas.drawRect(f4 + paramAnonymousRectF.left - 1.0F, paramAnonymousRectF.top, 1.0F + (paramAnonymousRectF.right - f4), f4 + paramAnonymousRectF.top, paramAnonymousPaint);
            paramAnonymousCanvas.drawRect(f4 + paramAnonymousRectF.left - 1.0F, 1.0F + (paramAnonymousRectF.bottom - f4), 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.bottom, paramAnonymousPaint);
          }
          else
          {
            f4 = paramAnonymousFloat;
          }
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left, paramAnonymousRectF.top + Math.max(0.0F, f4 - 1.0F), paramAnonymousRectF.right, 1.0F + (paramAnonymousRectF.bottom - f4), paramAnonymousPaint);
        }
      };
    }

    public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      RoundRectDrawableWithShadow localRoundRectDrawableWithShadow = a(paramContext, paramInt, paramFloat1, paramFloat2, paramFloat3);
      localRoundRectDrawableWithShadow.setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
      paramCardViewDelegate.setBackgroundDrawable(localRoundRectDrawableWithShadow);
      updatePadding(paramCardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate)
    {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
    {
      a(paramCardViewDelegate).setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
      updatePadding(paramCardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, int paramInt)
    {
      a(paramCardViewDelegate).setColor(paramInt);
    }

    public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      a(paramCardViewDelegate).b(paramFloat);
    }

    public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      a(paramCardViewDelegate).c(paramFloat);
      updatePadding(paramCardViewDelegate);
    }

    public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
    {
      a(paramCardViewDelegate).a(paramFloat);
      updatePadding(paramCardViewDelegate);
    }

    public void updatePadding(CardViewDelegate paramCardViewDelegate)
    {
      Rect localRect = new Rect();
      a(paramCardViewDelegate).a(localRect);
      View localView = (View)paramCardViewDelegate;
      localView.setMinimumHeight((int)Math.ceil(getMinHeight(paramCardViewDelegate)));
      localView.setMinimumWidth((int)Math.ceil(getMinWidth(paramCardViewDelegate)));
      paramCardViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
    }
  }

  static class CardViewJellybeanMr1 extends CardView.CardViewEclairMr1
  {
    public void initStatic()
    {
      RoundRectDrawableWithShadow.c = new RoundRectDrawableWithShadow.RoundRectHelper()
      {
        public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
        {
          paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
        }
      };
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.CardView
 * JD-Core Version:    0.6.2
 */