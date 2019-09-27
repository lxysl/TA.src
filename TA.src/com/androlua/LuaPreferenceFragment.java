package com.androlua;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaException;
import com.luajava.LuaJavaAPI;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import com.luajava.LuaTable.LuaEntry;
import java.util.Iterator;
import java.util.Set;

public class LuaPreferenceFragment extends PreferenceFragment
  implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener
{
  private LuaTable<Integer, LuaTable> a;
  private Preference.OnPreferenceChangeListener b;
  private Preference.OnPreferenceClickListener c;

  private void a(LuaTable<Integer, LuaTable> paramLuaTable)
  {
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    int i = paramLuaTable.length();
    LuaState localLuaState = paramLuaTable.getLuaState();
    for (int j = 1; j <= i; j++)
    {
      LuaTable localLuaTable = (LuaTable)paramLuaTable.get(Integer.valueOf(j));
      try
      {
        LuaObject localLuaObject = localLuaTable.getI(1L);
        if (localLuaObject.isNil())
          throw new IllegalArgumentException("Fist value Must be a Class<Preference>, checked import package.");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = getActivity();
        Preference localPreference = (Preference)localLuaObject.call(arrayOfObject);
        Iterator localIterator = localLuaTable.entrySet().iterator();
        while (localIterator.hasNext())
        {
          LuaTable.LuaEntry localLuaEntry = (LuaTable.LuaEntry)localIterator.next();
          Object localObject = localLuaEntry.getKey();
          boolean bool = localObject instanceof String;
          if (bool)
            try
            {
              LuaJavaAPI.javaSetter(localLuaState, localPreference, (String)localObject, localLuaEntry.getValue());
            }
            catch (LuaException localLuaException)
            {
              a.a(localLuaException);
            }
        }
        localPreference.setOnPreferenceChangeListener(this);
        localPreference.setOnPreferenceClickListener(this);
        localPreferenceScreen.addPreference(localPreference);
      }
      catch (Exception localException)
      {
        localLuaState.getContext().sendError("LuaPreferenceFragment", localException);
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 24)
      getPreferenceManager().setStorageDeviceProtected();
    setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getActivity()));
    a(this.a);
  }

  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (this.b != null)
      return this.b.onPreferenceChange(paramPreference, paramObject);
    return true;
  }

  public boolean onPreferenceClick(Preference paramPreference)
  {
    if (this.c != null)
      return this.c.onPreferenceClick(paramPreference);
    return false;
  }

  public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener paramOnPreferenceChangeListener)
  {
    this.b = paramOnPreferenceChangeListener;
  }

  public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener paramOnPreferenceClickListener)
  {
    this.c = paramOnPreferenceClickListener;
  }

  public void setPreference(LuaTable<Integer, LuaTable> paramLuaTable)
  {
    this.a = paramLuaTable;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaPreferenceFragment
 * JD-Core Version:    0.6.2
 */