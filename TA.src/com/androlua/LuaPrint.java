package com.androlua;

import com.luajava.JavaFunction;
import com.luajava.LuaState;

public class LuaPrint extends JavaFunction
{
  private LuaState a;
  private LuaContext c;
  private StringBuilder d = new StringBuilder();

  public LuaPrint(LuaContext paramLuaContext, LuaState paramLuaState)
  {
    super(paramLuaState);
    this.a = paramLuaState;
    this.c = paramLuaContext;
  }

  public int execute()
  {
    int i = this.a.getTop();
    int j = 2;
    if (i < j)
    {
      this.c.sendMsg("");
      return 0;
    }
    while (j <= this.a.getTop())
    {
      int k = this.a.type(j);
      Object localObject1 = this.a.typeName(k);
      String str;
      if (((String)localObject1).equals("userdata"))
      {
        Object localObject2 = this.a.toJavaObject(j);
        str = null;
        if (localObject2 != null)
          str = localObject2.toString();
      }
      else if (((String)localObject1).equals("boolean"))
      {
        if (this.a.toBoolean(j))
          str = "true";
        else
          str = "false";
      }
      else
      {
        str = this.a.toString(j);
      }
      if (str != null)
        localObject1 = str;
      this.d.append("\t");
      this.d.append((String)localObject1);
      this.d.append("\t");
      j++;
    }
    this.c.sendMsg(this.d.toString().substring(1, this.d.length() - 1));
    this.d.setLength(0);
    return 0;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaPrint
 * JD-Core Version:    0.6.2
 */