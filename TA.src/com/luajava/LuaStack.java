package com.luajava;

import java.util.HashMap;

public class LuaStack
{
  private static final HashMap<String, LuaState> a = new HashMap();

  public static Object call(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    return new LuaFunction(get(paramString1), paramString2).call(paramArrayOfObject);
  }

  public static LuaState get(String paramString)
  {
    return (LuaState)a.get(paramString);
  }

  public static void put(String paramString, LuaState paramLuaState)
  {
    a.put(paramString, paramLuaState);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaStack
 * JD-Core Version:    0.6.2
 */