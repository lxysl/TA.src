package com.androlua;

import com.androlua.util.TimerX;
import com.luajava.LuaObject;

public class LuaTimer extends TimerX
  implements LuaGcable
{
  private boolean a;
  private LuaTimerTask b;

  public LuaTimer(LuaContext paramLuaContext, LuaObject paramLuaObject)
  {
    this(paramLuaContext, paramLuaObject, null);
  }

  public LuaTimer(LuaContext paramLuaContext, LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    super("LuaTimer");
    paramLuaContext.regGc(this);
    this.b = new LuaTimerTask(paramLuaContext, paramLuaObject, paramArrayOfObject);
  }

  public LuaTimer(LuaContext paramLuaContext, String paramString)
  {
    this(paramLuaContext, paramString, null);
  }

  public LuaTimer(LuaContext paramLuaContext, String paramString, Object[] paramArrayOfObject)
  {
    super("LuaTimer");
    paramLuaContext.regGc(this);
    this.b = new LuaTimerTask(paramLuaContext, paramString, paramArrayOfObject);
  }

  public void gc()
  {
    stop();
    this.a = true;
  }

  public boolean getEnabled()
  {
    return this.b.isEnabled();
  }

  public long getPeriod()
  {
    return this.b.getPeriod();
  }

  public boolean isEnabled()
  {
    return this.b.isEnabled();
  }

  public boolean isGc()
  {
    return this.a;
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }

  public void setPeriod(long paramLong)
  {
    this.b.setPeriod(paramLong);
  }

  public void start(long paramLong)
  {
    schedule(this.b, paramLong);
  }

  public void start(long paramLong1, long paramLong2)
  {
    schedule(this.b, paramLong1, paramLong2);
  }

  public void stop()
  {
    this.b.cancel();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaTimer
 * JD-Core Version:    0.6.2
 */