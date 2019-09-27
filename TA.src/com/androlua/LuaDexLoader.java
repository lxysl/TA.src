package com.androlua;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class LuaDexLoader
{
  private static HashMap<String, LuaDexClassLoader> a = new HashMap();
  private ArrayList<ClassLoader> b = new ArrayList();
  private HashMap<String, String> c = new HashMap();
  private LuaContext d;
  private String e;
  private AssetManager f;
  private LuaResources g;
  private Resources.Theme h;
  private String i;

  public LuaDexLoader(LuaContext paramLuaContext)
  {
    this.d = paramLuaContext;
    this.e = paramLuaContext.getLuaDir();
    this.i = LuaApplication.getInstance().getOdexDir();
  }

  public AssetManager getAssets()
  {
    return this.f;
  }

  public ArrayList<ClassLoader> getClassLoaders()
  {
    return this.b;
  }

  public HashMap<String, String> getLibrarys()
  {
    return this.c;
  }

  public Resources getResources()
  {
    return this.g;
  }

  public Resources.Theme getTheme()
  {
    return this.h;
  }

  public LuaDexClassLoader loadApp(String paramString)
  {
    try
    {
      Object localObject = (LuaDexClassLoader)a.get(paramString);
      if (localObject == null)
      {
        ApplicationInfo localApplicationInfo = this.d.getContext().getPackageManager().getPackageInfo(paramString, 0).applicationInfo;
        LuaDexClassLoader localLuaDexClassLoader = new LuaDexClassLoader(localApplicationInfo.publicSourceDir, LuaApplication.getInstance().getOdexDir(), localApplicationInfo.nativeLibraryDir, this.d.getContext().getClassLoader());
        a.put(paramString, localLuaDexClassLoader);
        localObject = localLuaDexClassLoader;
      }
      if (!this.b.contains(localObject))
        this.b.add(localObject);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      a.a(localNameNotFoundException);
    }
    return null;
  }

  public DexClassLoader loadDex(String paramString)
  {
    LuaDexClassLoader localLuaDexClassLoader1 = (LuaDexClassLoader)a.get(paramString);
    if (localLuaDexClassLoader1 == null)
      localLuaDexClassLoader1 = loadApp(paramString);
    label284: LuaDexClassLoader localLuaDexClassLoader2;
    if (localLuaDexClassLoader1 == null)
    {
      String str2;
      if (paramString.charAt(0) != '/')
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.e);
        localStringBuilder1.append("/");
        localStringBuilder1.append(paramString);
        str2 = localStringBuilder1.toString();
      }
      else
      {
        str2 = paramString;
      }
      if (!new File(str2).exists())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str2);
        localStringBuilder2.append(".dex");
        StringBuilder localStringBuilder3;
        if (new File(localStringBuilder2.toString()).exists())
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(str2);
        }
        for (String str3 = ".dex"; ; str3 = ".jar")
        {
          localStringBuilder3.append(str3);
          str2 = localStringBuilder3.toString();
          break label284;
          StringBuilder localStringBuilder4 = new StringBuilder();
          localStringBuilder4.append(str2);
          localStringBuilder4.append(".jar");
          if (!new File(localStringBuilder4.toString()).exists())
            break;
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(str2);
        }
        StringBuilder localStringBuilder5 = new StringBuilder();
        localStringBuilder5.append(str2);
        localStringBuilder5.append(" not found");
        throw new LuaException(localStringBuilder5.toString());
      }
      String str4 = LuaUtil.getFileMD5(str2);
      if ((str4 == null) || (!str4.equals("0")))
        paramString = str4;
      localLuaDexClassLoader2 = (LuaDexClassLoader)a.get(paramString);
      if (localLuaDexClassLoader2 == null)
      {
        localLuaDexClassLoader2 = new LuaDexClassLoader(str2, this.i, LuaApplication.getInstance().getApplicationInfo().nativeLibraryDir, this.d.getContext().getClassLoader());
        a.put(paramString, localLuaDexClassLoader2);
      }
    }
    else
    {
      localLuaDexClassLoader2 = localLuaDexClassLoader1;
    }
    if (!this.b.contains(localLuaDexClassLoader2))
    {
      this.b.add(localLuaDexClassLoader2);
      String str1 = localLuaDexClassLoader2.getDexPath();
      if (str1.endsWith(".jar"))
        loadResources(str1);
    }
    return localLuaDexClassLoader2;
  }

  public void loadLib(String paramString)
  {
    int j = paramString.indexOf(".");
    String str1;
    if (j > 0)
      str1 = paramString.substring(0, j);
    else
      str1 = paramString;
    if (str1.startsWith("lib"))
      str1 = str1.substring(3);
    String str2 = this.d.getContext().getDir(str1, 0).getAbsolutePath();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(str2);
    localStringBuilder1.append("/lib");
    localStringBuilder1.append(str1);
    localStringBuilder1.append(".so");
    String str3 = localStringBuilder1.toString();
    if (!new File(str3).exists())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.e);
      localStringBuilder2.append("/libs/lib");
      localStringBuilder2.append(str1);
      localStringBuilder2.append(".so");
      if (!new File(localStringBuilder2.toString()).exists())
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("can not find lib ");
        localStringBuilder3.append(paramString);
        throw new LuaException(localStringBuilder3.toString());
      }
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append(this.e);
      localStringBuilder4.append("/libs/lib");
      localStringBuilder4.append(str1);
      localStringBuilder4.append(".so");
      LuaUtil.copyFile(localStringBuilder4.toString(), str3);
    }
    this.c.put(str1, str3);
  }

  public void loadLibs()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getLuaDir());
    localStringBuilder.append("/libs");
    File[] arrayOfFile = new File(localStringBuilder.toString()).listFiles();
    if (arrayOfFile == null)
      return;
    int j = arrayOfFile.length;
    for (int k = 0; k < j; k++)
    {
      File localFile = arrayOfFile[k];
      if (!localFile.isDirectory())
        if (localFile.getAbsolutePath().endsWith(".so"))
          loadLib(localFile.getName());
        else
          loadDex(localFile.getAbsolutePath());
    }
  }

  public void loadResources(String paramString)
  {
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      if (((Integer)localAssetManager.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString })).intValue() == 0)
        return;
      this.f = localAssetManager;
      Resources localResources = this.d.getContext().getResources();
      this.g = new LuaResources(this.f, localResources.getDisplayMetrics(), localResources.getConfiguration());
      this.g.setSuperResources(localResources);
      this.h = this.g.newTheme();
      this.h.setTo(this.d.getContext().getTheme());
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaDexLoader
 * JD-Core Version:    0.6.2
 */