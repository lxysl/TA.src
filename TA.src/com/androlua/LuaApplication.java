package com.androlua;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.FileProvider;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LuaApplication extends Application
  implements LuaContext
{
  private static LuaApplication h;
  private static HashMap<String, Object> i = new HashMap();
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  private SharedPreferences j;

  private static SharedPreferences a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      Context localContext = paramContext.createDeviceProtectedStorageContext();
      if (localContext != null)
        return PreferenceManager.getDefaultSharedPreferences(localContext);
      return PreferenceManager.getDefaultSharedPreferences(paramContext);
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext);
  }

  public static LuaApplication getInstance()
  {
    return h;
  }

  public void call(String paramString, Object[] paramArrayOfObject)
  {
  }

  public Object doFile(String paramString, Object[] paramArrayOfObject)
  {
    return null;
  }

  public Object get(String paramString)
  {
    return i.get(paramString);
  }

  public ArrayList<ClassLoader> getClassLoaders()
  {
    return null;
  }

  public Context getContext()
  {
    return this;
  }

  public Map getGlobalData()
  {
    return i;
  }

  public int getHeight()
  {
    return getResources().getDisplayMetrics().heightPixels;
  }

  public String getLibDir()
  {
    return this.c;
  }

  public String getLocalDir()
  {
    return this.a;
  }

  public String getLuaCpath()
  {
    return this.e;
  }

  public String getLuaDir()
  {
    return this.a;
  }

  public String getLuaDir(String paramString)
  {
    return this.a;
  }

  public String getLuaExtDir()
  {
    return this.g;
  }

  public String getLuaExtDir(String paramString)
  {
    File localFile = new File(getLuaExtDir(), paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
      return localFile.getAbsolutePath();
    return localFile.getAbsolutePath();
  }

  public String getLuaExtPath(String paramString)
  {
    return new File(getLuaExtDir(), paramString).getAbsolutePath();
  }

  public String getLuaExtPath(String paramString1, String paramString2)
  {
    return new File(getLuaExtDir(paramString1), paramString2).getAbsolutePath();
  }

  public String getLuaLpath()
  {
    return this.f;
  }

  public String getLuaPath()
  {
    return null;
  }

  public String getLuaPath(String paramString)
  {
    return new File(getLuaDir(), paramString).getAbsolutePath();
  }

  public String getLuaPath(String paramString1, String paramString2)
  {
    return new File(getLuaDir(paramString1), paramString2).getAbsolutePath();
  }

  public LuaState getLuaState()
  {
    return null;
  }

  public String getMdDir()
  {
    return this.d;
  }

  public String getOdexDir()
  {
    return this.b;
  }

  public String getPathFromUri(Uri paramUri)
  {
    if (paramUri != null)
    {
      int k = 1;
      String[] arrayOfString = new String[k];
      arrayOfString[0] = getPackageName();
      String str1 = paramUri.getScheme();
      int m = str1.hashCode();
      if (m != 3143036)
      {
        if ((m == 951530617) && (str1.equals("content")))
        {
          k = 0;
          break label78;
        }
      }
      else
        if (str1.equals("file"))
          break label78;
      k = -1;
      switch (k)
      {
      default:
        break;
      case 1:
        return paramUri.getPath();
      case 0:
        label78: Cursor localCursor = getContentResolver().query(paramUri, arrayOfString, null, null, null);
        if (localCursor != null)
        {
          int n = localCursor.getColumnIndexOrThrow(getPackageName());
          if (n >= 0)
          {
            String str2 = localCursor.getString(n);
            localCursor.moveToFirst();
            localCursor.close();
            return str2;
          }
        }
        break;
      }
    }
    return null;
  }

  public Object getSharedData(String paramString)
  {
    return this.j.getAll().get(paramString);
  }

  public Object getSharedData(String paramString, Object paramObject)
  {
    Object localObject = this.j.getAll().get(paramString);
    if (localObject == null)
      return paramObject;
    return localObject;
  }

  public Uri getUriForFile(File paramFile)
  {
    return FileProvider.getUriForFile(this, getPackageName(), paramFile);
  }

  public Uri getUriForPath(String paramString)
  {
    return FileProvider.getUriForFile(this, getPackageName(), new File(paramString));
  }

  public int getWidth()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }

  public void onCreate()
  {
    super.onCreate();
    h = this;
    CrashHandler.getInstance().init(getApplicationContext());
    this.j = a(this);
    StringBuilder localStringBuilder4;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
      localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append(str2);
      localStringBuilder4.append("/AndroLua");
    }
    for (String str1 = localStringBuilder4.toString(); ; str1 = getDir("AndroLua", 0).getAbsolutePath())
    {
      this.g = str1;
      break;
      for (File localFile2 : new File("/storage").listFiles())
      {
        String[] arrayOfString = localFile2.list();
        if ((arrayOfString != null) && (arrayOfString.length > 5))
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(localFile2.getAbsolutePath());
          localStringBuilder3.append("/AndroLua");
          this.g = localStringBuilder3.toString();
        }
      }
      if (this.g != null)
        break;
    }
    File localFile1 = new File(this.g);
    if (!localFile1.exists())
      localFile1.mkdirs();
    this.a = getFilesDir().getAbsolutePath();
    this.b = getDir("odex", 0).getAbsolutePath();
    this.c = getDir("lib", 0).getAbsolutePath();
    this.d = getDir("lua", 0).getAbsolutePath();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(getApplicationInfo().nativeLibraryDir);
    localStringBuilder1.append("/lib?.so;");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("/lib?.so");
    this.e = localStringBuilder1.toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.d);
    localStringBuilder2.append("/?.lua;");
    localStringBuilder2.append(this.d);
    localStringBuilder2.append("/lua/?.lua;");
    localStringBuilder2.append(this.d);
    localStringBuilder2.append("/?/init.lua;");
    this.f = localStringBuilder2.toString();
  }

  public void regGc(LuaGcable paramLuaGcable)
  {
  }

  public void sendError(String paramString, Exception paramException)
  {
  }

  public void sendMsg(String paramString)
  {
    Toast.makeText(this, paramString, 0).show();
  }

  public void set(String paramString, Object paramObject)
  {
    i.put(paramString, paramObject);
  }

  public void setLuaExtDir(String paramString)
  {
    if (Environment.getExternalStorageState().equals("mounted"));
    for (String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), paramString).getAbsolutePath(); ; str = getDir(paramString, 0).getAbsolutePath())
    {
      this.g = str;
      return;
      for (File localFile : new File("/storage").listFiles())
      {
        String[] arrayOfString = localFile.list();
        if ((arrayOfString != null) && (arrayOfString.length > 5))
          this.g = new File(localFile, paramString).getAbsolutePath();
      }
      if (this.g != null)
        break;
    }
  }

  public boolean setSharedData(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = this.j.edit();
    if (paramObject == null)
    {
      localEditor.remove(paramString);
    }
    else if ((paramObject instanceof String))
    {
      localEditor.putString(paramString, paramObject.toString());
    }
    else if ((paramObject instanceof Long))
    {
      localEditor.putLong(paramString, ((Long)paramObject).longValue());
    }
    else if ((paramObject instanceof Integer))
    {
      localEditor.putInt(paramString, ((Integer)paramObject).intValue());
    }
    else if ((paramObject instanceof Float))
    {
      localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
    }
    else
    {
      if ((paramObject instanceof Set));
      for (Object localObject = (Set)paramObject; ; localObject = (HashSet)((LuaTable)paramObject).values())
      {
        localEditor.putStringSet(paramString, (Set)localObject);
        break label192;
        if (!(paramObject instanceof LuaTable))
          break;
      }
      if (!(paramObject instanceof Boolean))
        break label200;
      localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    label192: localEditor.apply();
    return true;
    label200: return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaApplication
 * JD-Core Version:    0.6.2
 */