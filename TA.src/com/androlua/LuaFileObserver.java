package com.androlua;

import android.os.FileObserver;

public class LuaFileObserver extends FileObserver
{
  private OnEventListener a;

  public LuaFileObserver(String paramString)
  {
    super(paramString);
  }

  public LuaFileObserver(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }

  public void onEvent(int paramInt, String paramString)
  {
    if (this.a != null)
      this.a.onEvent(paramInt, paramString);
  }

  public void setOnEventListener(OnEventListener paramOnEventListener)
  {
    this.a = paramOnEventListener;
  }

  public static abstract interface OnEventListener
  {
    public abstract void onEvent(int paramInt, String paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaFileObserver
 * JD-Core Version:    0.6.2
 */