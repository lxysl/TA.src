package com.luajava;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LuaTable<K, V> extends LuaObject
  implements Map<K, V>
{
  public LuaTable(LuaState paramLuaState)
  {
    super(paramLuaState);
    paramLuaState.newTable();
    a(-1);
  }

  protected LuaTable(LuaState paramLuaState, int paramInt)
  {
    super(paramLuaState, paramInt);
  }

  public void clear()
  {
    push();
    this.b.pushNil();
    while (this.b.next(-2) != 0)
    {
      this.b.pop(1);
      this.b.pushValue(-1);
      this.b.pushNil();
      this.b.setTable(-4);
    }
    this.b.pop(1);
  }

  public boolean containsKey(Object paramObject)
  {
    push();
    boolean bool;
    while (true)
      try
      {
        this.b.pushObjectValue(paramObject);
        if (this.b.getTable(-2) != 0)
        {
          bool = true;
          this.b.pop(1);
          this.b.pop(1);
          return bool;
        }
      }
      catch (LuaException localLuaException)
      {
        return false;
        bool = false;
        tmpTernaryOp = localLuaException;
      }
  }

  public boolean containsValue(Object paramObject)
  {
    return false;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    HashSet localHashSet = new HashSet();
    push();
    this.b.pushNil();
    while (this.b.next(-2) != 0)
    {
      try
      {
        localHashSet.add(new LuaEntry(this.b.toJavaObject(-2), this.b.toJavaObject(-1)));
      }
      catch (LuaException localLuaException)
      {
      }
      this.b.pop(1);
    }
    this.b.pop(1);
    return localHashSet;
  }

  // ERROR //
  public V get(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 28	com/luajava/LuaTable:push	()V
    //   4: aload_0
    //   5: getfield 32	com/luajava/LuaTable:b	Lcom/luajava/LuaState;
    //   8: aload_1
    //   9: invokevirtual 56	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   12: aload_0
    //   13: getfield 32	com/luajava/LuaTable:b	Lcom/luajava/LuaState;
    //   16: bipush 254
    //   18: invokevirtual 59	com/luajava/LuaState:getTable	(I)I
    //   21: pop
    //   22: aload_0
    //   23: getfield 32	com/luajava/LuaTable:b	Lcom/luajava/LuaState;
    //   26: iconst_m1
    //   27: invokevirtual 72	com/luajava/LuaState:toJavaObject	(I)Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 32	com/luajava/LuaTable:b	Lcom/luajava/LuaState;
    //   35: iconst_1
    //   36: invokevirtual 42	com/luajava/LuaState:pop	(I)V
    //   39: goto +8 -> 47
    //   42: aconst_null
    //   43: astore_2
    //   44: goto +4 -> 48
    //   47: pop
    //   48: aload_0
    //   49: getfield 32	com/luajava/LuaTable:b	Lcom/luajava/LuaState;
    //   52: iconst_1
    //   53: invokevirtual 42	com/luajava/LuaState:pop	(I)V
    //   56: aload_2
    //   57: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   4	31	42	com/luajava/LuaException
    //   31	39	47	com/luajava/LuaException
  }

  public boolean isEmpty()
  {
    push();
    this.b.pushNil();
    boolean bool;
    if (this.b.next(-2) == 0)
      bool = true;
    else
      bool = false;
    if (bool)
    {
      this.b.pop(1);
      return bool;
    }
    this.b.pop(3);
    return bool;
  }

  public boolean isList()
  {
    push();
    if (this.b.rawLen(-1) != 0)
    {
      pop();
      return true;
    }
    this.b.pushNil();
    boolean bool;
    if (this.b.next(-2) == 0)
      bool = true;
    else
      bool = false;
    if (bool)
    {
      this.b.pop(1);
      return bool;
    }
    this.b.pop(3);
    return bool;
  }

  public Set<K> keySet()
  {
    HashSet localHashSet = new HashSet();
    push();
    this.b.pushNil();
    while (this.b.next(-2) != 0)
    {
      try
      {
        localHashSet.add(this.b.toJavaObject(-2));
      }
      catch (LuaException localLuaException)
      {
      }
      this.b.pop(1);
    }
    this.b.pop(1);
    return localHashSet;
  }

  public int length()
  {
    push();
    int i = this.b.rawLen(-1);
    pop();
    return i;
  }

  public V put(K paramK, V paramV)
  {
    push();
    try
    {
      this.b.pushObjectValue(paramK);
      this.b.pushObjectValue(paramV);
      this.b.setTable(-3);
    }
    catch (LuaException localLuaException)
    {
    }
    this.b.pop(1);
    return null;
  }

  public void putAll(Map paramMap)
  {
  }

  public V remove(Object paramObject)
  {
    push();
    try
    {
      this.b.pushObjectValue(paramObject);
      this.b.setTable(-2);
    }
    catch (LuaException localLuaException)
    {
    }
    this.b.pop(1);
    return null;
  }

  public int size()
  {
    push();
    this.b.pushNil();
    int i = 0;
    while (this.b.next(-2) != 0)
    {
      i++;
      this.b.pop(1);
    }
    this.b.pop(1);
    return i;
  }

  public Collection values()
  {
    return null;
  }

  public class LuaEntry<K, V>
    implements Map.Entry<K, V>
  {
    private K b;
    private V c;

    public LuaEntry(V arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.c = localObject2;
    }

    public K getKey()
    {
      return this.b;
    }

    public V getValue()
    {
      return this.c;
    }

    public V setValue(V paramV)
    {
      Object localObject = this.c;
      this.c = paramV;
      return localObject;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaTable
 * JD-Core Version:    0.6.2
 */