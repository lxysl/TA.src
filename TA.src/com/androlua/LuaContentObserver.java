package com.androlua;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

public class LuaContentObserver extends ContentObserver
  implements LuaGcable
{
  private OnChangeListener a;
  private boolean b;

  private LuaContentObserver(Handler paramHandler)
  {
    super(paramHandler);
  }

  public LuaContentObserver(LuaContext paramLuaContext, Uri paramUri)
  {
    this(new Handler(LuaApplication.getInstance().getMainLooper()));
    paramLuaContext.regGc(this);
    LuaApplication.getInstance().getContentResolver().registerContentObserver(paramUri, true, this);
  }

  public LuaContentObserver(LuaContext paramLuaContext, String paramString)
  {
    this(new Handler(LuaApplication.getInstance().getMainLooper()));
    Uri localUri = Uri.parse(paramString);
    paramLuaContext.regGc(this);
    LuaApplication.getInstance().getContentResolver().registerContentObserver(localUri, true, this);
  }

  public void gc()
  {
    LuaApplication.getInstance().getContentResolver().unregisterContentObserver(this);
    this.b = true;
  }

  public boolean isGc()
  {
    return this.b;
  }

  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    if (this.a != null)
    {
      Cursor localCursor = LuaApplication.getInstance().getContentResolver().query(paramUri, null, null, null, null);
      if (localCursor != null)
        localCursor.moveToFirst();
      this.a.onChange(paramBoolean, paramUri, localCursor);
      if (localCursor != null)
        localCursor.close();
    }
  }

  public void setOnChangeListener(OnChangeListener paramOnChangeListener)
  {
    this.a = paramOnChangeListener;
  }

  public static abstract interface OnChangeListener
  {
    public abstract void onChange(boolean paramBoolean, Uri paramUri, Cursor paramCursor);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaContentObserver
 * JD-Core Version:    0.6.2
 */