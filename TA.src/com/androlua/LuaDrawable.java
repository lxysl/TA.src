package com.androlua;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaObject;
import com.luajava.LuaState;

public class LuaDrawable extends Drawable
{
  private final LuaContext a;
  private LuaObject b;
  private Paint c;
  private LuaFunction d;

  public LuaDrawable(LuaFunction paramLuaFunction)
  {
    this.b = paramLuaFunction;
    this.c = new Paint();
    this.a = this.b.getLuaState().getContext();
  }

  public void draw(Canvas paramCanvas)
  {
    try
    {
      if (this.d == null)
      {
        LuaObject localLuaObject = this.b;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramCanvas;
        arrayOfObject[1] = this.c;
        arrayOfObject[2] = this;
        Object localObject = localLuaObject.call(arrayOfObject);
        if ((localObject != null) && ((localObject instanceof LuaFunction)))
          this.d = ((LuaFunction)localObject);
      }
      if (this.d != null)
      {
        this.d.call(new Object[] { paramCanvas });
        return;
      }
    }
    catch (LuaException localLuaException)
    {
      this.a.sendError("onDraw", localLuaException);
    }
  }

  public int getOpacity()
  {
    return 0;
  }

  public Paint getPaint()
  {
    return this.c;
  }

  public void setAlpha(int paramInt)
  {
    this.c.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaDrawable
 * JD-Core Version:    0.6.2
 */