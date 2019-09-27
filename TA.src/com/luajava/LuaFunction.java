package com.luajava;

public class LuaFunction<T> extends LuaObject
  implements LuaMetaTable
{
  protected LuaFunction(LuaState paramLuaState, int paramInt)
  {
    super(paramLuaState, paramInt);
  }

  protected LuaFunction(LuaState paramLuaState, String paramString)
  {
    super(paramLuaState, paramString);
  }

  public T __call(Object[] paramArrayOfObject)
  {
    return super.call(paramArrayOfObject);
  }

  public Object __index(String paramString)
  {
    return null;
  }

  public void __newIndex(String paramString, Object paramObject)
  {
  }

  public T call(Object[] paramArrayOfObject)
  {
    return super.call(paramArrayOfObject);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaFunction
 * JD-Core Version:    0.6.2
 */