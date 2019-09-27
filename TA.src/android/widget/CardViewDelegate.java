package android.widget;

import android.graphics.drawable.Drawable;

abstract interface CardViewDelegate
{
  public abstract Drawable getBackground();

  public abstract boolean getPreventCornerOverlap();

  public abstract float getRadius();

  public abstract boolean getUseCompatPadding();

  public abstract void setBackgroundDrawable(Drawable paramDrawable);

  public abstract void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.CardViewDelegate
 * JD-Core Version:    0.6.2
 */