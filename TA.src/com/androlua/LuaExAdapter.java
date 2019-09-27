package com.androlua;

import com.luajava.LuaTable;

public class LuaExAdapter extends LuaExpandableListAdapter
{
  public LuaExAdapter(LuaContext paramLuaContext, LuaTable paramLuaTable1, LuaTable paramLuaTable2)
  {
    this(paramLuaContext, null, null, paramLuaTable1, paramLuaTable2);
  }

  public LuaExAdapter(LuaContext paramLuaContext, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable, LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>> paramLuaTable1, LuaTable paramLuaTable2, LuaTable paramLuaTable3)
  {
    super(paramLuaContext, paramLuaTable, paramLuaTable1, paramLuaTable2, paramLuaTable3);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaExAdapter
 * JD-Core Version:    0.6.2
 */