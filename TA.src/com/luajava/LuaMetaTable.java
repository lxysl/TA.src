package com.luajava;

public abstract interface LuaMetaTable
{
  public abstract Object __call(Object[] paramArrayOfObject);

  public abstract Object __index(String paramString);

  public abstract void __newIndex(String paramString, Object paramObject);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaMetaTable
 * JD-Core Version:    0.6.2
 */