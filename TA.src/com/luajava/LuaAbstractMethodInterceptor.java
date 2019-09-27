package com.luajava;

import com.android.cglib.proxy.MethodInterceptor;
import com.android.cglib.proxy.MethodProxy;
import com.androlua.LuaContext;
import java.lang.reflect.Method;

public class LuaAbstractMethodInterceptor
  implements MethodInterceptor
{
  private final LuaContext a;
  private LuaObject b;

  public LuaAbstractMethodInterceptor(LuaObject paramLuaObject)
  {
    this.b = paramLuaObject;
    this.a = paramLuaObject.getLuaState().getContext();
  }

  public Object intercept(Object paramObject, Object[] paramArrayOfObject, MethodProxy paramMethodProxy)
  {
    synchronized (this.b.b)
    {
      Method localMethod = paramMethodProxy.getOriginalMethod();
      String str = localMethod.getName();
      LuaObject localLuaObject;
      if (this.b.isFunction())
        localLuaObject = this.b;
      else
        localLuaObject = this.b.getField(str);
      Class localClass = localMethod.getReturnType();
      boolean bool = localLuaObject.isNil();
      Object localObject2 = null;
      if (bool)
      {
        if ((!localClass.equals(Boolean.TYPE)) && (!localClass.equals(Boolean.class)))
        {
          if ((!localClass.isPrimitive()) && (!Number.class.isAssignableFrom(localClass)))
            return null;
          Integer localInteger1 = Integer.valueOf(0);
          return localInteger1;
        }
        Boolean localBoolean1 = Boolean.valueOf(false);
        return localBoolean1;
      }
      try
      {
        if ((!localClass.equals(Void.class)) && (!localClass.equals(Void.TYPE)))
        {
          Object localObject3 = localLuaObject.call(paramArrayOfObject);
          if (localObject3 != null)
            try
            {
              if ((localObject3 instanceof Double))
                localObject2 = LuaState.convertLuaNumber((Double)localObject3, localClass);
            }
            catch (LuaException localLuaException1)
            {
              localObject2 = localObject3;
              break label242;
            }
          localObject2 = localObject3;
        }
        else
        {
          localLuaObject.call(paramArrayOfObject);
          localObject2 = null;
        }
      }
      catch (LuaException localLuaException2)
      {
        label242: this.a.sendError(str, localLuaException2);
      }
      if (localObject2 == null)
        if ((!localClass.equals(Boolean.TYPE)) && (!localClass.equals(Boolean.class)))
        {
          if ((localClass.isPrimitive()) || (Number.class.isAssignableFrom(localClass)))
          {
            Integer localInteger2 = Integer.valueOf(0);
            return localInteger2;
          }
        }
        else
        {
          Boolean localBoolean2 = Boolean.valueOf(false);
          return localBoolean2;
        }
      return localObject2;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaAbstractMethodInterceptor
 * JD-Core Version:    0.6.2
 */