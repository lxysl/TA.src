package com.androlua;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaTable;

public class LuaFragment extends Fragment
{
  private LuaTable a = null;
  private LuaObject b = null;
  private View c;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      if (this.c != null)
        return this.c;
      if (this.a != null)
      {
        LuaObject localLuaObject = (LuaObject)this.a.getLuaState().getLuaObject("require").call(new Object[] { "loadlayout" });
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.a;
        return (View)localLuaObject.call(arrayOfObject);
      }
      TextView localTextView = new TextView(getActivity());
      return localTextView;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(localException.getMessage());
    }
  }

  public void setLayout(View paramView)
  {
    this.c = paramView;
    this.a = null;
  }

  public void setLayout(LuaTable paramLuaTable)
  {
    this.a = paramLuaTable;
    this.c = null;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaFragment
 * JD-Core Version:    0.6.2
 */