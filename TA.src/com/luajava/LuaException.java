package com.luajava;

public class LuaException extends Exception
{
  public LuaException(Exception paramException)
  {
    super(paramException);
  }

  public LuaException(String paramString)
  {
    super(paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaException
 * JD-Core Version:    0.6.2
 */