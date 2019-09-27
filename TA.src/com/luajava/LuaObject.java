package com.luajava;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LuaObject
  implements Serializable
{
  protected int a;
  protected final LuaState b;

  protected LuaObject(LuaObject paramLuaObject1, LuaObject paramLuaObject2)
  {
    if (paramLuaObject1.getLuaState() != paramLuaObject2.getLuaState())
      throw new LuaException("LuaStates must be the same!");
    synchronized (paramLuaObject1.getLuaState())
    {
      if ((!paramLuaObject1.isTable()) && (!paramLuaObject1.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
      this.b = paramLuaObject1.getLuaState();
      paramLuaObject1.push();
      paramLuaObject2.push();
      this.b.getTable(-2);
      this.b.remove(-2);
      a(-1);
      this.b.pop(1);
      return;
    }
  }

  protected LuaObject(LuaObject paramLuaObject, Number paramNumber)
  {
    synchronized (paramLuaObject.getLuaState())
    {
      this.b = paramLuaObject.getLuaState();
      if ((!paramLuaObject.isTable()) && (!paramLuaObject.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
      paramLuaObject.push();
      this.b.pushNumber(paramNumber.doubleValue());
      this.b.getTable(-2);
      this.b.remove(-2);
      a(-1);
      this.b.pop(1);
      return;
    }
  }

  protected LuaObject(LuaObject paramLuaObject, String paramString)
  {
    synchronized (paramLuaObject.getLuaState())
    {
      this.b = paramLuaObject.getLuaState();
      if ((!paramLuaObject.isTable()) && (!paramLuaObject.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
      paramLuaObject.push();
      this.b.pushString(paramString);
      this.b.getTable(-2);
      this.b.remove(-2);
      a(-1);
      this.b.pop(1);
      return;
    }
  }

  protected LuaObject(LuaState paramLuaState)
  {
    this.b = paramLuaState;
  }

  protected LuaObject(LuaState paramLuaState, int paramInt)
  {
    try
    {
      this.b = paramLuaState;
      a(paramInt);
      return;
    }
    finally
    {
    }
  }

  protected LuaObject(LuaState paramLuaState, String paramString)
  {
    try
    {
      this.b = paramLuaState;
      paramLuaState.getGlobal(paramString);
      a(-1);
      paramLuaState.pop(1);
      return;
    }
    finally
    {
    }
  }

  public LuaObject _call(Object[] paramArrayOfObject)
  {
    return _call_aux(paramArrayOfObject, 1)[0];
  }

  public LuaObject[] _call_aux(Object[] paramArrayOfObject, int paramInt)
  {
    while (true)
    {
      synchronized (this.b)
      {
        if ((!isFunction()) && (!isTable()) && (!isUserdata()))
          throw new LuaException("Invalid object. Not a function, table or userdata .");
        int i = this.b.getTop();
        push();
        if (paramArrayOfObject != null)
        {
          j = paramArrayOfObject.length;
          int k = 0;
          if (k < j)
          {
            Object localObject2 = paramArrayOfObject[k];
            this.b.pushObjectValue(localObject2);
            k++;
            continue;
          }
          int m = this.b.pcall(j, paramInt, 0);
          if (m != 0)
          {
            if (!this.b.isString(-1))
              break label404;
            str1 = this.b.toString(-1);
            this.b.pop(1);
            StringBuilder localStringBuilder1;
            String str2;
            if (m == 2)
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("Runtime error. ");
              localStringBuilder1.append(str1);
              str2 = localStringBuilder1.toString();
            }
            else
            {
              if (m == 4)
              {
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("Memory allocation error. ");
                localStringBuilder1.append(str1);
                continue;
              }
              if (m == 6)
              {
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("Error while running the error handler function. ");
                localStringBuilder1.append(str1);
                continue;
              }
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("Lua Error code ");
              localStringBuilder2.append(m);
              localStringBuilder2.append(". ");
              localStringBuilder2.append(str1);
              str2 = localStringBuilder2.toString();
            }
            throw new LuaException(str2);
          }
          if (paramInt == -1)
            paramInt = this.b.getTop() - i;
          if (this.b.getTop() - i < paramInt)
            throw new LuaException("Invalid Number of Results .");
          LuaObject[] arrayOfLuaObject = new LuaObject[paramInt];
          if (paramInt > 0)
          {
            arrayOfLuaObject[(paramInt - 1)] = this.b.getLuaObject(-1);
            this.b.pop(1);
            paramInt--;
            continue;
          }
          return arrayOfLuaObject;
        }
      }
      int j = 0;
      continue;
      label404: String str1 = "";
    }
  }

  protected void a(int paramInt)
  {
    synchronized (this.b)
    {
      this.b.pushValue(paramInt);
      this.a = this.b.Lref(-1001000);
      return;
    }
  }

  public Object[] asArray()
  {
    synchronized (this.b)
    {
      if (!isTable())
        throw new LuaException("Invalid object. Not a table .");
      push();
      int i = this.b.objLen(-1);
      Object localObject2 = Array.newInstance(Object.class, i);
      for (int j = 1; j <= i; j++)
      {
        this.b.pushInteger(j);
        this.b.getTable(-2);
        int k = j - 1;
        try
        {
          Array.set(localObject2, k, this.b.toJavaObject(-1));
        }
        catch (LuaException localLuaException)
        {
        }
        this.b.pop(1);
      }
      this.b.pop(1);
      Object[] arrayOfObject = (Object[])localObject2;
      return arrayOfObject;
    }
  }

  public Map asMap(LuaState paramLuaState, Class<?> paramClass, int paramInt)
  {
    try
    {
      if (!isTable())
        throw new LuaException("Invalid object. Not a table .");
      HashMap localHashMap = new HashMap();
      push();
      paramLuaState.pushNil();
      while (true)
      {
        int i = paramLuaState.next(paramInt);
        if (i == 0)
          break;
        try
        {
          localHashMap.put(paramLuaState.toJavaObject(-2), paramLuaState.toJavaObject(-1));
        }
        catch (LuaException localLuaException)
        {
        }
        paramLuaState.pop(1);
      }
      paramLuaState.pop(1);
      return localHashMap;
    }
    finally
    {
    }
  }

  public Object call(Object[] paramArrayOfObject)
  {
    return call_aux(paramArrayOfObject, 1)[0];
  }

  public Object[] call_aux(Object[] paramArrayOfObject, int paramInt)
  {
    while (true)
    {
      synchronized (this.b)
      {
        if ((!isFunction()) && (!isTable()) && (!isUserdata()))
          throw new LuaException("Invalid object. Not a function, table or userdata .");
        int i = this.b.getTop();
        push();
        if (paramArrayOfObject != null)
        {
          j = paramArrayOfObject.length;
          int k = 0;
          if (k < j)
          {
            Object localObject2 = paramArrayOfObject[k];
            this.b.pushObjectValue(localObject2);
            k++;
            continue;
          }
          int m = this.b.pcall(j, paramInt, 0);
          if (m != 0)
          {
            if (!this.b.isString(-1))
              break label404;
            str1 = this.b.toString(-1);
            this.b.pop(1);
            StringBuilder localStringBuilder1;
            String str2;
            if (m == 2)
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("Runtime error. ");
              localStringBuilder1.append(str1);
              str2 = localStringBuilder1.toString();
            }
            else
            {
              if (m == 4)
              {
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("Memory allocation error. ");
                localStringBuilder1.append(str1);
                continue;
              }
              if (m == 6)
              {
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("Error while running the error handler function. ");
                localStringBuilder1.append(str1);
                continue;
              }
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("Lua Error code ");
              localStringBuilder2.append(m);
              localStringBuilder2.append(". ");
              localStringBuilder2.append(str1);
              str2 = localStringBuilder2.toString();
            }
            throw new LuaException(str2);
          }
          if (paramInt == -1)
            paramInt = this.b.getTop() - i;
          if (this.b.getTop() - i < paramInt)
            throw new LuaException("Invalid Number of Results .");
          Object[] arrayOfObject = new Object[paramInt];
          if (paramInt > 0)
          {
            arrayOfObject[(paramInt - 1)] = this.b.toJavaObject(-1);
            this.b.pop(1);
            paramInt--;
            continue;
          }
          return arrayOfObject;
        }
      }
      int j = 0;
      continue;
      label404: String str1 = "";
    }
  }

  public Object createProxy(Class paramClass)
  {
    synchronized (this.b)
    {
      if ((!isTable()) && (!isFunction()))
        throw new LuaException("Invalid Object. Must be Table or Function.");
      if ((isFunction()) && (paramClass.getMethods().length != 1))
        throw new LuaException("Invalid Object. Must be a interface Method of Function.");
      if ((isTable()) && (getTable().isList()))
        throw new LuaException("Invalid Object. Must be Table is Not Array.");
      Class[] arrayOfClass = { paramClass };
      LuaInvocationHandler localLuaInvocationHandler = new LuaInvocationHandler(this);
      Object localObject2 = Proxy.newProxyInstance(paramClass.getClassLoader(), arrayOfClass, localLuaInvocationHandler);
      return localObject2;
    }
  }

  public Object createProxy(String paramString)
  {
    synchronized (this.b)
    {
      if (!isTable())
        throw new LuaException("Invalid Object. Must be Table.");
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
      Class[] arrayOfClass = new Class[localStringTokenizer.countTokens()];
      for (int i = 0; localStringTokenizer.hasMoreTokens(); i++)
        arrayOfClass[i] = Class.forName(localStringTokenizer.nextToken());
      LuaInvocationHandler localLuaInvocationHandler = new LuaInvocationHandler(this);
      Object localObject2 = Proxy.newProxyInstance(getClass().getClassLoader(), arrayOfClass, localLuaInvocationHandler);
      return localObject2;
    }
  }

  public byte[] dump()
  {
    synchronized (this.b)
    {
      if (!isFunction())
        throw new LuaException("Invalid object. Not a function .");
      push();
      byte[] arrayOfByte = this.b.dump(-1);
      this.b.pop(1);
      return arrayOfByte;
    }
  }

  // ERROR //
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   13: invokevirtual 274	com/luajava/LuaState:getPointer	()J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifeq +16 -> 34
    //   21: aload_0
    //   22: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   25: ldc 143
    //   27: aload_0
    //   28: getfield 148	com/luajava/LuaObject:a	I
    //   31: invokevirtual 278	com/luajava/LuaState:LunRef	(II)V
    //   34: aload 5
    //   36: monitorexit
    //   37: return
    //   38: astore 6
    //   40: aload 5
    //   42: monitorexit
    //   43: aload 6
    //   45: athrow
    //   46: getstatic 284	java/lang/System:err	Ljava/io/PrintStream;
    //   49: astore_1
    //   50: new 110	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc_w 286
    //   62: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: aload_0
    //   68: getfield 148	com/luajava/LuaObject:a	I
    //   71: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 291	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   83: return
    //
    // Exception table:
    //   from	to	target	type
    //   9	34	38	finally
    //   34	37	38	finally
    //   40	43	38	finally
    //   0	9	46	java/lang/Exception
    //   43	46	46	java/lang/Exception
  }

  public boolean getBoolean()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.toBoolean(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public LuaObject getField(String paramString)
  {
    return this.b.getLuaObject(this, paramString);
  }

  public LuaFunction<?> getFunction()
  {
    synchronized (this.b)
    {
      push();
      LuaFunction localLuaFunction = new LuaFunction(this.b, -1);
      this.b.pop(1);
      return localLuaFunction;
    }
  }

  public LuaObject getI(long paramLong)
  {
    return this.b.getLuaObject(this, Long.valueOf(paramLong));
  }

  public long getInteger()
  {
    synchronized (this.b)
    {
      push();
      long l = this.b.toInteger(-1);
      this.b.pop(1);
      return l;
    }
  }

  public LuaState getLuaState()
  {
    return this.b;
  }

  public double getNumber()
  {
    synchronized (this.b)
    {
      push();
      double d = this.b.toNumber(-1);
      this.b.pop(1);
      return d;
    }
  }

  public Object getObject()
  {
    synchronized (this.b)
    {
      push();
      Object localObject2 = this.b.getObjectFromUserdata(-1);
      this.b.pop(1);
      return localObject2;
    }
  }

  public String getString()
  {
    synchronized (this.b)
    {
      push();
      String str = this.b.toString(-1);
      this.b.pop(1);
      return str;
    }
  }

  public LuaTable<?, ?> getTable()
  {
    synchronized (this.b)
    {
      push();
      LuaTable localLuaTable = new LuaTable(this.b, -1);
      this.b.pop(1);
      return localLuaTable;
    }
  }

  public boolean isBoolean()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isBoolean(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isFunction()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isFunction(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isInteger()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isInteger(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isJavaFunction()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isJavaFunction(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isJavaObject()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isObject(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isNil()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isNil(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isNumber()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isNumber(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isString()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isString(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isTable()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isTable(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public boolean isUserdata()
  {
    synchronized (this.b)
    {
      push();
      boolean bool = this.b.isUserdata(-1);
      this.b.pop(1);
      return bool;
    }
  }

  public void pop()
  {
    this.b.pop(1);
  }

  public void push()
  {
    this.b.rawGetI(-1001000, this.a);
  }

  // ERROR //
  public void setField(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 40	com/luajava/LuaObject:push	()V
    //   4: aload_0
    //   5: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   8: aload_2
    //   9: invokevirtual 96	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   12: goto +10 -> 22
    //   15: aload_0
    //   16: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   19: invokevirtual 183	com/luajava/LuaState:pushNil	()V
    //   22: aload_0
    //   23: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   26: bipush 254
    //   28: aload_1
    //   29: invokevirtual 368	com/luajava/LuaState:setField	(ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   36: iconst_1
    //   37: invokevirtual 55	com/luajava/LuaState:pop	(I)V
    //   40: return
    //
    // Exception table:
    //   from	to	target	type
    //   4	12	15	com/luajava/LuaException
  }

  // ERROR //
  public void setI(long paramLong, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 40	com/luajava/LuaObject:push	()V
    //   4: aload_0
    //   5: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   8: aload_3
    //   9: invokevirtual 96	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   12: goto +10 -> 22
    //   15: aload_0
    //   16: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   19: invokevirtual 183	com/luajava/LuaState:pushNil	()V
    //   22: aload_0
    //   23: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   26: bipush 254
    //   28: lload_1
    //   29: invokevirtual 373	com/luajava/LuaState:setI	(IJ)V
    //   32: aload_0
    //   33: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   36: iconst_1
    //   37: invokevirtual 55	com/luajava/LuaState:pop	(I)V
    //   40: return
    //
    // Exception table:
    //   from	to	target	type
    //   4	12	15	com/luajava/LuaException
  }

  // ERROR //
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/luajava/LuaObject:b	Lcom/luajava/LuaState;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 375	com/luajava/LuaObject:isNil	()Z
    //   11: ifeq +9 -> 20
    //   14: aload_1
    //   15: monitorexit
    //   16: ldc_w 377
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 379	com/luajava/LuaObject:isBoolean	()Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: invokevirtual 381	com/luajava/LuaObject:getBoolean	()Z
    //   31: invokestatic 386	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   34: astore 6
    //   36: aload_1
    //   37: monitorexit
    //   38: aload 6
    //   40: areturn
    //   41: aload_0
    //   42: invokevirtual 388	com/luajava/LuaObject:isNumber	()Z
    //   45: ifeq +17 -> 62
    //   48: aload_0
    //   49: invokevirtual 390	com/luajava/LuaObject:getNumber	()D
    //   52: invokestatic 393	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   55: astore 5
    //   57: aload_1
    //   58: monitorexit
    //   59: aload 5
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 395	com/luajava/LuaObject:isString	()Z
    //   66: ifeq +14 -> 80
    //   69: aload_0
    //   70: invokevirtual 397	com/luajava/LuaObject:getString	()Ljava/lang/String;
    //   73: astore 4
    //   75: aload_1
    //   76: monitorexit
    //   77: aload 4
    //   79: areturn
    //   80: aload_0
    //   81: invokevirtual 86	com/luajava/LuaObject:isFunction	()Z
    //   84: ifeq +9 -> 93
    //   87: aload_1
    //   88: monitorexit
    //   89: ldc_w 399
    //   92: areturn
    //   93: aload_0
    //   94: invokevirtual 401	com/luajava/LuaObject:isJavaObject	()Z
    //   97: ifeq +15 -> 112
    //   100: aload_0
    //   101: invokevirtual 403	com/luajava/LuaObject:getObject	()Ljava/lang/Object;
    //   104: invokevirtual 404	java/lang/Object:toString	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_3
    //   111: areturn
    //   112: aload_0
    //   113: invokevirtual 33	com/luajava/LuaObject:isUserdata	()Z
    //   116: ifeq +9 -> 125
    //   119: aload_1
    //   120: monitorexit
    //   121: ldc_w 406
    //   124: areturn
    //   125: aload_0
    //   126: invokevirtual 30	com/luajava/LuaObject:isTable	()Z
    //   129: ifeq +9 -> 138
    //   132: aload_1
    //   133: monitorexit
    //   134: ldc_w 408
    //   137: areturn
    //   138: aload_0
    //   139: invokevirtual 410	com/luajava/LuaObject:isJavaFunction	()Z
    //   142: ifeq +9 -> 151
    //   145: aload_1
    //   146: monitorexit
    //   147: ldc_w 412
    //   150: areturn
    //   151: aload_1
    //   152: monitorexit
    //   153: aconst_null
    //   154: areturn
    //   155: aload_1
    //   156: monitorexit
    //   157: aconst_null
    //   158: areturn
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -5 -> 159
    //
    // Exception table:
    //   from	to	target	type
    //   7	14	155	com/luajava/LuaException
    //   20	36	155	com/luajava/LuaException
    //   41	57	155	com/luajava/LuaException
    //   62	75	155	com/luajava/LuaException
    //   80	87	155	com/luajava/LuaException
    //   93	108	155	com/luajava/LuaException
    //   112	119	155	com/luajava/LuaException
    //   125	132	155	com/luajava/LuaException
    //   138	145	155	com/luajava/LuaException
    //   7	14	163	finally
    //   14	16	163	finally
    //   20	36	163	finally
    //   36	38	163	finally
    //   41	57	163	finally
    //   57	59	163	finally
    //   62	75	163	finally
    //   75	77	163	finally
    //   80	87	163	finally
    //   87	89	163	finally
    //   93	108	163	finally
    //   108	110	163	finally
    //   112	119	163	finally
    //   119	121	163	finally
    //   125	132	163	finally
    //   132	134	163	finally
    //   138	145	163	finally
    //   145	147	163	finally
    //   151	153	163	finally
    //   155	157	163	finally
    //   159	161	163	finally
  }

  public int type()
  {
    synchronized (this.b)
    {
      push();
      int i = this.b.type(-1);
      this.b.pop(1);
      return i;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaObject
 * JD-Core Version:    0.6.2
 */