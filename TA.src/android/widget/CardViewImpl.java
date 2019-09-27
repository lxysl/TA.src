package android.widget;

import android.content.Context;

abstract interface CardViewImpl
{
  public abstract float getElevation(CardViewDelegate paramCardViewDelegate);

  public abstract float getMaxElevation(CardViewDelegate paramCardViewDelegate);

  public abstract float getMinHeight(CardViewDelegate paramCardViewDelegate);

  public abstract float getMinWidth(CardViewDelegate paramCardViewDelegate);

  public abstract float getRadius(CardViewDelegate paramCardViewDelegate);

  public abstract void initStatic();

  public abstract void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate);

  public abstract void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate);

  public abstract void setBackgroundColor(CardViewDelegate paramCardViewDelegate, int paramInt);

  public abstract void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void updatePadding(CardViewDelegate paramCardViewDelegate);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.CardViewImpl
 * JD-Core Version:    0.6.2
 */