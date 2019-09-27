package com.androlua;

import com.androlua.util.TimerTaskX;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import java.util.regex.Pattern;

public class LuaTimerTask extends TimerTaskX
{
  private LuaState a;
  private LuaContext g;
  private String h;
  private Object[] i = new Object[0];
  private boolean j = true;
  private byte[] k;

  public LuaTimerTask(LuaContext paramLuaContext, LuaObject paramLuaObject)
  {
    this(paramLuaContext, paramLuaObject, null);
  }

  public LuaTimerTask(LuaContext paramLuaContext, LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    this.g = paramLuaContext;
    if (paramArrayOfObject != null)
      this.i = paramArrayOfObject;
    this.k = paramLuaObject.dump();
  }

  public LuaTimerTask(LuaContext paramLuaContext, String paramString)
  {
    this(paramLuaContext, paramString, null);
  }

  public LuaTimerTask(LuaContext paramLuaContext, String paramString, Object[] paramArrayOfObject)
  {
    this.g = paramLuaContext;
    this.h = paramString;
    if (paramArrayOfObject != null)
      this.i = paramArrayOfObject;
  }

  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown error ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    case 6:
      return "error error";
    case 5:
      return "GC error";
    case 4:
      return "Out of memory";
    case 3:
      return "Syntax error";
    case 2:
      return "Runtime error";
    case 1:
    }
    return "Yield error";
  }

  private void a(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      if (Pattern.matches("^\\w+$", paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".lua");
        doAsset(localStringBuilder.toString(), paramArrayOfObject);
        return;
      }
      if (Pattern.matches("^[\\w\\.\\_/]+$", paramString))
      {
        this.a.getGlobal("luajava");
        this.a.pushString(this.g.getLuaDir());
        this.a.setField(-2, "luadir");
        this.a.pushString(paramString);
        this.a.setField(-2, "luapath");
        this.a.pop(1);
        b(paramString, paramArrayOfObject);
        return;
      }
      c(paramString, paramArrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      this.g.sendError(toString(), localException);
    }
  }

  private void a(byte[] paramArrayOfByte, Object[] paramArrayOfObject)
  {
    this.a.setTop(0);
    int m = this.a.LloadBuffer(paramArrayOfByte, "TimerTask");
    if (m == 0)
    {
      this.a.getGlobal("debug");
      this.a.getField(-1, "traceback");
      this.a.remove(-2);
      this.a.insert(-2);
      int n = paramArrayOfObject.length;
      for (int i1 = 0; i1 < n; i1++)
        this.a.pushObjectValue(paramArrayOfObject[i1]);
      m = this.a.pcall(n, 0, -2 - n);
      if (m == 0)
        return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(m));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.a.toString(-1));
    throw new LuaException(localStringBuilder.toString());
  }

  private void b()
  {
    this.a = LuaStateFactory.newLuaState();
    this.a.openLibs();
    this.a.pushJavaObject(this.g);
    LuaState localLuaState;
    if ((this.g instanceof LuaActivity))
      localLuaState = this.a;
    for (String str = "activity"; ; str = "service")
    {
      localLuaState.setGlobal(str);
      break;
      if (!(this.g instanceof LuaService))
        break;
      localLuaState = this.a;
    }
    this.a.pushJavaObject(this);
    this.a.setGlobal("this");
    this.a.pushContext(this.g);
    new LuaPrint(this.g, this.a).register("print");
    this.a.getGlobal("package");
    this.a.pushString(this.g.getLuaLpath());
    this.a.setField(-2, "path");
    this.a.pushString(this.g.getLuaCpath());
    this.a.setField(-2, "cpath");
    this.a.pop(1);
    new JavaFunction(this.a)
    {
      public int execute()
      {
        LuaTimerTask.a(LuaTimerTask.this).set(this.b.toString(2), this.b.toJavaObject(3));
        return 0;
      }
    }
    .register("set");
    new JavaFunction(this.a)
    {
      public int execute()
      {
        int i = this.b.getTop();
        Object[] arrayOfObject;
        LuaContext localLuaContext;
        String str;
        if (i > 2)
        {
          arrayOfObject = new Object[i - 2];
          for (int j = 3; j <= i; j++)
            arrayOfObject[(j - 3)] = this.b.toJavaObject(j);
          localLuaContext = LuaTimerTask.a(LuaTimerTask.this);
          str = this.b.toString(2);
        }
        else
        {
          if (i != 2)
            break label109;
          localLuaContext = LuaTimerTask.a(LuaTimerTask.this);
          str = this.b.toString(2);
          arrayOfObject = new Object[0];
        }
        localLuaContext.call(str, arrayOfObject);
        label109: return 0;
      }
    }
    .register("call");
  }

  private void b(String paramString, Object[] paramArrayOfObject)
  {
    this.a.setTop(0);
    int m = this.a.LloadFile(paramString);
    if (m == 0)
    {
      this.a.getGlobal("debug");
      this.a.getField(-1, "traceback");
      this.a.remove(-2);
      this.a.insert(-2);
      int n = paramArrayOfObject.length;
      for (int i1 = 0; i1 < n; i1++)
        this.a.pushObjectValue(paramArrayOfObject[i1]);
      m = this.a.pcall(n, 0, -2 - n);
      if (m == 0)
        return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(m));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.a.toString(-1));
    throw new LuaException(localStringBuilder.toString());
  }

  private void c(String paramString, Object[] paramArrayOfObject)
  {
    this.a.setTop(0);
    int m = this.a.LloadString(paramString);
    if (m == 0)
    {
      this.a.getGlobal("debug");
      this.a.getField(-1, "traceback");
      this.a.remove(-2);
      this.a.insert(-2);
      int n = paramArrayOfObject.length;
      for (int i1 = 0; i1 < n; i1++)
        this.a.pushObjectValue(paramArrayOfObject[i1]);
      m = this.a.pcall(n, 0, -2 - n);
      if (m == 0)
        return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(m));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.a.toString(-1));
    throw new LuaException(localStringBuilder.toString());
  }

  private void d(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      LuaState localLuaState = this.a;
      int m = 0;
      localLuaState.setTop(0);
      this.a.getGlobal(paramString);
      if (this.a.isFunction(-1))
      {
        this.a.getGlobal("debug");
        this.a.getField(-1, "traceback");
        this.a.remove(-2);
        this.a.insert(-2);
        int n = paramArrayOfObject.length;
        while (m < n)
        {
          this.a.pushObjectValue(paramArrayOfObject[m]);
          m++;
        }
        int i1 = this.a.pcall(n, 1, -2 - n);
        if (i1 == 0)
          return;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(a(i1));
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.a.toString(-1));
        throw new LuaException(localStringBuilder2.toString());
      }
    }
    catch (LuaException localLuaException)
    {
      LuaContext localLuaContext = this.g;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(toString());
      localStringBuilder1.append(" ");
      localStringBuilder1.append(paramString);
      localLuaContext.sendError(localStringBuilder1.toString(), localLuaException);
    }
  }

  public boolean cancel()
  {
    return super.cancel();
  }

  public void doAsset(String paramString, Object[] paramArrayOfObject)
  {
    byte[] arrayOfByte = LuaUtil.readAsset(this.g.getContext(), paramString);
    this.a.setTop(0);
    int m = this.a.LloadBuffer(arrayOfByte, paramString);
    if (m == 0)
    {
      this.a.getGlobal("debug");
      this.a.getField(-1, "traceback");
      this.a.remove(-2);
      this.a.insert(-2);
      int n = paramArrayOfObject.length;
      for (int i1 = 0; i1 < n; i1++)
        this.a.pushObjectValue(paramArrayOfObject[i1]);
      m = this.a.pcall(n, 0, -2 - n);
      if (m == 0)
        return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(m));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.a.toString(-1));
    throw new LuaException(localStringBuilder.toString());
  }

  public Object get(String paramString)
  {
    this.a.getGlobal(paramString);
    return this.a.toJavaObject(-1);
  }

  public boolean isEnabled()
  {
    return this.j;
  }

  public void run()
  {
    if (!this.j)
      return;
    try
    {
      byte[] arrayOfByte;
      Object[] arrayOfObject2;
      String str;
      if (this.a == null)
      {
        b();
        if (this.k != null)
        {
          arrayOfByte = this.k;
          arrayOfObject2 = this.i;
          a(arrayOfByte, arrayOfObject2);
        }
        else
        {
          str = this.h;
        }
      }
      else
      {
        for (Object[] arrayOfObject1 = this.i; ; arrayOfObject1 = this.i)
        {
          a(str, arrayOfObject1);
          break label160;
          this.a.getGlobal("run");
          if (!this.a.isNil(-1))
          {
            d("run", new Object[0]);
            break label160;
          }
          if (this.k != null)
          {
            arrayOfByte = this.k;
            arrayOfObject2 = this.i;
            break;
          }
          str = this.h;
        }
      }
    }
    catch (LuaException localLuaException)
    {
      this.g.sendError(toString(), localLuaException);
      label160: this.a.gc(2, 1);
      System.gc();
    }
  }

  public void set(String paramString, Object paramObject)
  {
    this.a.pushObjectValue(paramObject);
    this.a.setGlobal(paramString);
  }

  public void setArg(LuaObject paramLuaObject)
  {
    this.i = paramLuaObject.asArray();
  }

  public void setArg(Object[] paramArrayOfObject)
  {
    this.i = paramArrayOfObject;
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaTimerTask
 * JD-Core Version:    0.6.2
 */