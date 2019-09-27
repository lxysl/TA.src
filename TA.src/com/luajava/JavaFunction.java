package com.luajava;

public abstract class JavaFunction
{
  protected LuaState b;

  public JavaFunction(LuaState paramLuaState)
  {
    this.b = paramLuaState;
  }

  public abstract int execute();

  public LuaObject getParam(int paramInt)
  {
    return this.b.getLuaObject(paramInt);
  }

  public void register(String paramString)
  {
    synchronized (this.b)
    {
      this.b.pushJavaFunction(this);
      this.b.setGlobal(paramString);
      return;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.JavaFunction
 * JD-Core Version:    0.6.2
 */