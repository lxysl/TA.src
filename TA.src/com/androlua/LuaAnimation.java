package com.androlua;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaState;

public class LuaAnimation extends Animation
{
  private final LuaContext a;
  private LuaFunction b;
  private LuaFunction c;

  public LuaAnimation(LuaFunction paramLuaFunction)
  {
    this.b = paramLuaFunction;
    this.a = this.b.getLuaState().getContext();
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    try
    {
      LuaFunction localLuaFunction1 = this.b;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Float.valueOf(paramFloat);
      arrayOfObject1[1] = paramTransformation;
      localLuaFunction1.call(arrayOfObject1);
      if (this.c == null)
      {
        LuaFunction localLuaFunction3 = this.b;
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = Float.valueOf(paramFloat);
        arrayOfObject3[1] = paramTransformation;
        arrayOfObject3[2] = this;
        Object localObject = localLuaFunction3.call(arrayOfObject3);
        if ((localObject != null) && ((localObject instanceof LuaFunction)))
          this.c = ((LuaFunction)localObject);
      }
      if (this.c != null)
      {
        LuaFunction localLuaFunction2 = this.c;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Float.valueOf(paramFloat);
        arrayOfObject2[1] = paramTransformation;
        localLuaFunction2.call(arrayOfObject2);
        return;
      }
    }
    catch (LuaException localLuaException)
    {
      this.a.sendError("applyTransformation", localLuaException);
    }
  }

  protected float resolveSize(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    return super.resolveSize(paramInt1, paramFloat, paramInt2, paramInt3);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaAnimation
 * JD-Core Version:    0.6.2
 */