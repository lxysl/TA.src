package com.luajava;

import java.util.HashMap;
import java.util.Map;

public final class LuaStateFactory
{
  private static final Map<Long, LuaState> a = new HashMap();

  public static LuaState getExistingState(long paramLong)
  {
    try
    {
      LuaState localLuaState = (LuaState)a.get(Long.valueOf(paramLong));
      if (localLuaState == null)
      {
        localLuaState = new LuaState(paramLong);
        a.put(Long.valueOf(paramLong), localLuaState);
      }
      return localLuaState;
    }
    finally
    {
    }
  }

  public static long insertLuaState(LuaState paramLuaState)
  {
    try
    {
      a.put(Long.valueOf(paramLuaState.getPointer()), paramLuaState);
      long l = paramLuaState.getPointer();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static LuaState newLuaState()
  {
    try
    {
      LuaState localLuaState = new LuaState();
      a.put(Long.valueOf(localLuaState.getPointer()), localLuaState);
      return localLuaState;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void removeLuaState(long paramLong)
  {
    try
    {
      a.put(Long.valueOf(paramLong), null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaStateFactory
 * JD-Core Version:    0.6.2
 */