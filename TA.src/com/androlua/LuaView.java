package com.androlua;

import android.content.Context;
import android.view.View;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaTable;

public class LuaView extends View
{
  private LuaTable a;
  private LuaObject b;

  public LuaView(Context paramContext)
  {
    super(paramContext);
  }

  public LuaView(Context paramContext, LuaTable paramLuaTable)
  {
    super(paramContext);
    this.a = paramLuaTable;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a != null)
      try
      {
        this.b = this.a.getField("onMeasure");
        if (this.b.isFunction())
        {
          LuaObject localLuaObject = this.b;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Integer.valueOf(paramInt1);
          arrayOfObject[1] = Integer.valueOf(paramInt2);
          arrayOfObject[2] = this;
          localLuaObject.call(arrayOfObject);
          return;
        }
      }
      catch (LuaException localLuaException)
      {
        a.a(localLuaException);
      }
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaView
 * JD-Core Version:    0.6.2
 */