package com.androlua;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import com.a.a.a.a.a.a.a;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LuaService extends Service
  implements LuaBroadcastReceiver.OnReceiveListener, LuaContext
{
  private static LuaService b;
  LuaBinder a = new LuaBinder();
  private LuaDexLoader c;
  private ArrayList<LuaGcable> d = new ArrayList();
  private String e;
  private MainHandler f;
  private String g;
  private LuaState h;
  private String i;
  private String j;
  private String k;
  private String l;
  public String luaCpath;
  public String luaDir;
  private String m;
  private BroadcastReceiver n;
  private StringBuilder o = new StringBuilder();
  private Toast p;
  private StringBuilder q = new StringBuilder();
  private long r;
  private LuaResources s;

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

  private void a()
  {
    this.h = LuaStateFactory.newLuaState();
    this.h.openLibs();
    this.h.pushJavaObject(this);
    this.h.setGlobal("service");
    this.h.getGlobal("service");
    this.h.setGlobal("this");
    this.h.pushContext(this);
    this.h.getGlobal("luajava");
    this.h.pushString(this.m);
    this.h.setField(-2, "luaextdir");
    this.h.pushString(this.luaDir);
    this.h.setField(-2, "luadir");
    this.h.pushString(this.i);
    this.h.setField(-2, "luapath");
    this.h.pop(1);
    new LuaAssetLoader(this, this.h);
    this.h.getGlobal("package");
    this.h.pushString(this.e);
    this.h.setField(-2, "path");
    this.h.pushString(this.luaCpath);
    this.h.setField(-2, "cpath");
    this.h.pop(1);
    new JavaFunction(this.h)
    {
      public int execute()
      {
        int i = this.b.getTop();
        int j = 2;
        if (i < j)
        {
          LuaService.this.sendMsg("");
          return 0;
        }
        int m;
        while (true)
        {
          int k = this.b.getTop();
          m = 1;
          if (j > k)
            break;
          int n = this.b.type(j);
          Object localObject1 = this.b.typeName(n);
          int i1 = ((String)localObject1).hashCode();
          if (i1 != -266011147)
          {
            if ((i1 == 64711720) && (((String)localObject1).equals("boolean")))
              break label119;
          }
          else if (((String)localObject1).equals("userdata"))
          {
            m = 0;
            break label119;
          }
          m = -1;
          label119: Object localObject3;
          switch (m)
          {
          default:
            localObject3 = this.b.toString(j);
            break;
          case 1:
            if (this.b.toBoolean(j));
            for (String str = "true"; ; str = "false")
            {
              localObject3 = str;
              break;
            }
          case 0:
            Object localObject2 = this.b.toJavaObject(j);
            localObject3 = null;
            if (localObject2 != null)
              localObject3 = localObject2.toString();
            break;
          }
          if (localObject3 != null)
            localObject1 = localObject3;
          LuaService.a(LuaService.this).append("\t");
          LuaService.a(LuaService.this).append((String)localObject1);
          LuaService.a(LuaService.this).append("\t");
          j++;
        }
        LuaService.this.sendMsg(LuaService.a(LuaService.this).toString().substring(m, LuaService.a(LuaService.this).length() - m));
        LuaService.a(LuaService.this).setLength(0);
        return 0;
      }
    }
    .register("print");
    new JavaFunction(this.h)
    {
      public int execute()
      {
        ((LuaThread)this.b.toJavaObject(2)).set(this.b.toString(3), this.b.toJavaObject(4));
        return 0;
      }
    }
    .register("set");
    new JavaFunction(this.h)
    {
      public int execute()
      {
        LuaThread localLuaThread = (LuaThread)this.b.toJavaObject(2);
        int i = this.b.getTop();
        if (i > 3)
        {
          Object[] arrayOfObject = new Object[i - 3];
          for (int j = 4; j <= i; j++)
            arrayOfObject[(j - 4)] = this.b.toJavaObject(j);
          localLuaThread.call(this.b.toString(3), arrayOfObject);
        }
        else if (i == 3)
        {
          localLuaThread.call(this.b.toString(3));
        }
        return 0;
      }
    }
    .register("call");
  }

  private void a(String paramString, Object paramObject)
  {
    try
    {
      this.h.pushObjectValue(paramObject);
      this.h.setGlobal(paramString);
      return;
    }
    catch (LuaException localLuaException)
    {
      sendMsg(localLuaException.getMessage());
    }
  }

  private void a(String paramString1, String paramString2)
  {
    try
    {
      if (new File(paramString1).exists())
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
        byte[] arrayOfByte = new byte[4096];
        int i1 = 0;
        while (true)
        {
          int i2 = localFileInputStream.read(arrayOfByte);
          if (i2 == -1)
            break;
          i1 += i2;
          System.out.println(i1);
          localFileOutputStream.write(arrayOfByte, 0, i2);
        }
        localFileInputStream.close();
        return;
      }
    }
    catch (Exception localException)
    {
      System.out.println("复制文件操作出错");
      a.a(localException);
    }
  }

  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(4096);
    byte[] arrayOfByte1 = new byte[4096];
    while (true)
    {
      int i1 = paramInputStream.read(arrayOfByte1);
      if (-1 == i1)
        break;
      localByteArrayOutputStream.write(arrayOfByte1, 0, i1);
    }
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return arrayOfByte2;
  }

  public static LuaService getService()
  {
    return b;
  }

  public void call(String paramString)
  {
    push(2, paramString);
  }

  public void call(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 0)
    {
      push(2, paramString);
      return;
    }
    push(3, paramString, paramArrayOfObject);
  }

  public Object doAsset(String paramString, Object[] paramArrayOfObject)
  {
    while (true)
    {
      try
      {
        byte[] arrayOfByte = readAsset(paramString);
        this.h.setTop(0);
        int i1 = this.h.LloadBuffer(arrayOfByte, paramString);
        if (i1 == 0)
        {
          this.h.getGlobal("debug");
          this.h.getField(-1, "traceback");
          this.h.remove(-2);
          this.h.insert(-2);
          if (paramArrayOfObject == null)
            break label207;
          i2 = paramArrayOfObject.length;
          break label210;
          if (i3 < i2)
          {
            this.h.pushObjectValue(paramArrayOfObject[i3]);
            i3++;
            continue;
          }
          i1 = this.h.pcall(i2, 0, -2 - i2);
          if (i1 == 0)
            return this.h.toJavaObject(-1);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a(i1));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.h.toString(-1));
        throw new LuaException(localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        sendMsg(localException.getMessage());
        return null;
      }
      label207: int i2 = 0;
      label210: int i3 = 0;
    }
  }

  public Object doFile(String paramString)
  {
    return doFile(paramString, new Object[0]);
  }

  public Object doFile(String paramString, Object[] paramArrayOfObject)
  {
    while (true)
    {
      try
      {
        if (paramString.charAt(0) != '/')
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(this.luaDir);
          localStringBuilder1.append("/");
          localStringBuilder1.append(paramString);
          paramString = localStringBuilder1.toString();
        }
        this.h.setTop(0);
        int i1 = this.h.LloadFile(paramString);
        if (i1 == 0)
        {
          this.h.getGlobal("debug");
          this.h.getField(-1, "traceback");
          this.h.remove(-2);
          this.h.insert(-2);
          if (paramArrayOfObject == null)
            break label252;
          i2 = paramArrayOfObject.length;
          i3 = 0;
          if (i3 < i2)
          {
            this.h.pushObjectValue(paramArrayOfObject[i3]);
            i3++;
            continue;
          }
          i1 = this.h.pcall(i2, 1, -2 - i2);
          if (i1 == 0)
            return this.h.toJavaObject(-1);
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(a(i1));
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.h.toString(-1));
        throw new LuaException(localStringBuilder2.toString());
      }
      catch (LuaException localLuaException)
      {
        sendMsg(localLuaException.getMessage());
        return null;
      }
      label252: int i3 = 0;
      int i2 = 0;
    }
  }

  public Object doString(String paramString, Object[] paramArrayOfObject)
  {
    while (true)
    {
      try
      {
        this.h.setTop(0);
        int i1 = this.h.LloadString(paramString);
        if (i1 == 0)
        {
          this.h.getGlobal("debug");
          this.h.getField(-1, "traceback");
          this.h.remove(-2);
          this.h.insert(-2);
          if (paramArrayOfObject == null)
            break label201;
          i2 = paramArrayOfObject.length;
          i3 = 0;
          if (i3 < i2)
          {
            this.h.pushObjectValue(paramArrayOfObject[i3]);
            i3++;
            continue;
          }
          i1 = this.h.pcall(i2, 1, -2 - i2);
          if (i1 == 0)
            return this.h.toJavaObject(-1);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a(i1));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.h.toString(-1));
        throw new LuaException(localStringBuilder.toString());
      }
      catch (LuaException localLuaException)
      {
        sendMsg(localLuaException.getMessage());
        return null;
      }
      label201: int i3 = 0;
      int i2 = 0;
    }
  }

  public Object get(String paramString)
  {
    this.h.getGlobal(paramString);
    return this.h.toJavaObject(-1);
  }

  public AssetManager getAssets()
  {
    if ((this.c != null) && (this.c.getAssets() != null))
      return this.c.getAssets();
    return super.getAssets();
  }

  public LuaBinder getBinder()
  {
    return this.a;
  }

  public ArrayList<ClassLoader> getClassLoaders()
  {
    return this.c.getClassLoaders();
  }

  public Context getContext()
  {
    return this;
  }

  public Map getGlobalData()
  {
    return LuaApplication.getInstance().getGlobalData();
  }

  public int getHeight()
  {
    return getResources().getDisplayMetrics().heightPixels;
  }

  public HashMap<String, String> getLibrarys()
  {
    return this.c.getLibrarys();
  }

  public String getLuaCpath()
  {
    return this.luaCpath;
  }

  public String getLuaDir()
  {
    return this.luaDir;
  }

  public String getLuaDir(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.luaDir);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    File localFile = new File(localStringBuilder.toString());
    if ((!localFile.exists()) && (!localFile.mkdirs()))
      return null;
    return localFile.getAbsolutePath();
  }

  public String getLuaExtDir()
  {
    return this.m;
  }

  public String getLuaExtDir(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    File localFile = new File(localStringBuilder.toString());
    if ((!localFile.exists()) && (!localFile.mkdirs()))
      return null;
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
    return this.e;
  }

  public String getLuaPath()
  {
    return this.i;
  }

  public String getLuaPath(String paramString)
  {
    return new File(getLuaDir(), paramString).getAbsolutePath();
  }

  public String getLuaPath(String paramString1, String paramString2)
  {
    return new File(getLuaDir(paramString1), paramString2).getAbsolutePath();
  }

  public LuaResources getLuaResources()
  {
    Resources localResources = super.getResources();
    if ((this.c != null) && (this.c.getResources() != null))
      localResources = this.c.getResources();
    this.s = new LuaResources(getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
    this.s.setSuperResources(localResources);
    return this.s;
  }

  public LuaState getLuaState()
  {
    return this.h;
  }

  public Resources getResources()
  {
    if ((this.c != null) && (this.c.getResources() != null))
      return this.c.getResources();
    if (this.s != null)
      return this.s;
    return super.getResources();
  }

  public Object getSharedData(String paramString)
  {
    return LuaApplication.getInstance().getSharedData(paramString);
  }

  public Object getSharedData(String paramString, Object paramObject)
  {
    return LuaApplication.getInstance().getSharedData(paramString, paramObject);
  }

  public Resources getSuperResources()
  {
    return super.getResources();
  }

  public int getWidth()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }

  public DexClassLoader loadDex(String paramString)
  {
    return this.c.loadDex(paramString);
  }

  public Object loadLib(String paramString)
  {
    int i1 = paramString.indexOf(".");
    String str1;
    if (i1 > 0)
      str1 = paramString.substring(0, i1);
    else
      str1 = paramString;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.l);
    localStringBuilder1.append("/lib");
    localStringBuilder1.append(str1);
    localStringBuilder1.append(".so");
    if (!new File(localStringBuilder1.toString()).exists())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.luaDir);
      localStringBuilder2.append("/lib");
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
      localStringBuilder4.append(this.luaDir);
      localStringBuilder4.append("/lib");
      localStringBuilder4.append(str1);
      localStringBuilder4.append(".so");
      String str2 = localStringBuilder4.toString();
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append(this.l);
      localStringBuilder5.append("/lib");
      localStringBuilder5.append(str1);
      localStringBuilder5.append(".so");
      a(str2, localStringBuilder5.toString());
    }
    return this.h.getLuaObject("require").call(new Object[] { paramString });
  }

  public void loadResources(String paramString)
  {
    this.c.loadResources(paramString);
  }

  public LuaAsyncTask newTask(LuaObject paramLuaObject)
  {
    return newTask(paramLuaObject, null, null);
  }

  public LuaAsyncTask newTask(LuaObject paramLuaObject1, LuaObject paramLuaObject2)
  {
    return newTask(paramLuaObject1, null, paramLuaObject2);
  }

  public LuaAsyncTask newTask(LuaObject paramLuaObject1, LuaObject paramLuaObject2, LuaObject paramLuaObject3)
  {
    return new LuaAsyncTask(this, paramLuaObject1, paramLuaObject2, paramLuaObject3);
  }

  public LuaThread newThread(LuaObject paramLuaObject)
  {
    return newThread(paramLuaObject, null);
  }

  public LuaThread newThread(LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    return new LuaThread(this, paramLuaObject, true, paramArrayOfObject);
  }

  public LuaTimer newTimer(LuaObject paramLuaObject)
  {
    return newTimer(paramLuaObject, null);
  }

  public LuaTimer newTimer(LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    return new LuaTimer(this, paramLuaObject, paramArrayOfObject);
  }

  public IBinder onBind(Intent paramIntent)
  {
    startForeground(1, new Notification());
    return new LuaBinder();
  }

  public void onCreate()
  {
    super.onCreate();
    b = this;
    LuaApplication localLuaApplication = (LuaApplication)getApplication();
    this.j = localLuaApplication.getLocalDir();
    this.k = localLuaApplication.getOdexDir();
    this.l = localLuaApplication.getLibDir();
    this.g = localLuaApplication.getMdDir();
    this.luaCpath = localLuaApplication.getLuaCpath();
    this.luaDir = this.j;
    this.e = localLuaApplication.getLuaLpath();
    this.m = localLuaApplication.getLuaExtDir();
    this.f = new MainHandler();
  }

  public void onDestroy()
  {
    runFunc("onDestroy", new Object[0]);
    if (this.n != null)
      unregisterReceiver(this.n);
    super.onDestroy();
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    runFunc("onReceive", new Object[] { paramContext, paramIntent });
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    b = this;
    if (this.h == null)
    {
      startForeground(1, new Notification());
      this.i = paramIntent.getStringExtra("luaPath");
      this.luaDir = paramIntent.getStringExtra("luaDir");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.luaDir);
      localStringBuilder.append("/?.lua;");
      localStringBuilder.append(this.luaDir);
      localStringBuilder.append("/lua/?.lua;");
      localStringBuilder.append(this.luaDir);
      localStringBuilder.append("/?/init.lua;");
      localStringBuilder.append(this.e);
      this.e = localStringBuilder.toString();
      Uri localUri = paramIntent.getData();
      try
      {
        a();
        this.c = new LuaDexLoader(this);
        this.c.loadLibs();
        if (localUri != null);
        for (String str = localUri.getPath(); ; str = "service.lua")
        {
          doFile(str);
          break;
        }
      }
      catch (Exception localException)
      {
        sendMsg(localException.getMessage());
      }
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramIntent;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    runFunc("onStartCommand", arrayOfObject);
    runFunc("onStart", (Object[])paramIntent.getSerializableExtra("arg"));
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }

  public void push(int paramInt, String paramString)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localMessage.setData(localBundle);
    localMessage.what = paramInt;
    this.f.sendMessage(localMessage);
  }

  public void push(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localBundle.putSerializable("args", paramArrayOfObject);
    localMessage.setData(localBundle);
    localMessage.what = paramInt;
    this.f.sendMessage(localMessage);
  }

  public byte[] readAsset(String paramString)
  {
    InputStream localInputStream = getAssets().open(paramString);
    byte[] arrayOfByte = a(localInputStream);
    localInputStream.close();
    return arrayOfByte;
  }

  public void regGc(LuaGcable paramLuaGcable)
  {
    this.d.add(paramLuaGcable);
  }

  public Intent registerReceiver(IntentFilter paramIntentFilter)
  {
    if (this.n != null)
      unregisterReceiver(this.n);
    this.n = new LuaBroadcastReceiver(this);
    return super.registerReceiver(this.n, paramIntentFilter);
  }

  public Intent registerReceiver(LuaBroadcastReceiver.OnReceiveListener paramOnReceiveListener, IntentFilter paramIntentFilter)
  {
    return super.registerReceiver(new LuaBroadcastReceiver(paramOnReceiveListener), paramIntentFilter);
  }

  public Intent registerReceiver(LuaBroadcastReceiver paramLuaBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return super.registerReceiver(paramLuaBroadcastReceiver, paramIntentFilter);
  }

  public Object runFunc(String paramString, Object[] paramArrayOfObject)
  {
    if (this.h != null);
    while (true)
    {
      try
      {
        this.h.setTop(0);
        this.h.getGlobal(paramString);
        if (this.h.isFunction(-1))
        {
          this.h.getGlobal("debug");
          this.h.getField(-1, "traceback");
          this.h.remove(-2);
          this.h.insert(-2);
          if (paramArrayOfObject == null)
            break label249;
          i1 = paramArrayOfObject.length;
          i2 = 0;
          if (i2 < i1)
          {
            this.h.pushObjectValue(paramArrayOfObject[i2]);
            i2++;
            continue;
          }
          int i3 = this.h.pcall(i1, 1, -2 - i1);
          if (i3 == 0)
            return this.h.toJavaObject(-1);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(a(i3));
          localStringBuilder2.append(": ");
          localStringBuilder2.append(this.h.toString(-1));
          throw new LuaException(localStringBuilder2.toString());
        }
      }
      catch (LuaException localLuaException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(" ");
        localStringBuilder1.append(localLuaException.getMessage());
        sendMsg(localStringBuilder1.toString());
      }
      return null;
      label249: int i1 = 0;
      int i2 = 0;
    }
  }

  public void sendError(String paramString, Exception paramException)
  {
    runFunc("onError", new Object[] { paramString, paramException });
  }

  public void sendMsg(String paramString)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localMessage.setData(localBundle);
    localMessage.what = 0;
    this.f.sendMessage(localMessage);
    Log.i("lua", paramString);
  }

  public void set(String paramString, Object paramObject)
  {
    push(1, paramString, new Object[] { paramObject });
  }

  public void setBinder(LuaBinder paramLuaBinder)
  {
    this.a = paramLuaBinder;
  }

  public void setLuaExtDir(String paramString)
  {
    if (Environment.getExternalStorageState().equals("mounted"));
    for (String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), paramString).getAbsolutePath(); ; str = getDir(paramString, 0).getAbsolutePath())
    {
      this.m = str;
      break;
      for (File localFile2 : new File("/storage").listFiles())
      {
        String[] arrayOfString = localFile2.list();
        if ((arrayOfString != null) && (arrayOfString.length > 5))
          this.m = new File(localFile2, paramString).getAbsolutePath();
      }
      if (this.m != null)
        break;
    }
    File localFile1 = new File(this.m);
    if (!localFile1.exists())
      localFile1.mkdirs();
  }

  public boolean setSharedData(String paramString, Object paramObject)
  {
    return LuaApplication.getInstance().setSharedData(paramString, paramObject);
  }

  @SuppressLint({"ShowToast"})
  public void showToast(String paramString)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if ((this.p != null) && (l1 - this.r <= 1000L))
      {
        this.q.append("\n");
        this.q.append(paramString);
        this.p.setText(this.q.toString());
        this.p.setDuration(1);
      }
      else
      {
        this.q.setLength(0);
        this.p = Toast.makeText(this, paramString, 1);
        this.q.append(paramString);
      }
      this.r = l1;
      this.p.show();
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }

  public LuaAsyncTask task(long paramLong, LuaObject paramLuaObject)
  {
    return task(paramLong, null, null);
  }

  public LuaAsyncTask task(long paramLong, Object[] paramArrayOfObject, LuaObject paramLuaObject)
  {
    LuaAsyncTask localLuaAsyncTask = new LuaAsyncTask(this, paramLong, paramLuaObject);
    localLuaAsyncTask.execute(paramArrayOfObject);
    return localLuaAsyncTask;
  }

  public LuaAsyncTask task(LuaObject paramLuaObject)
  {
    return task(paramLuaObject, null, null, null);
  }

  public LuaAsyncTask task(LuaObject paramLuaObject1, LuaObject paramLuaObject2, LuaObject paramLuaObject3)
  {
    return task(paramLuaObject1, null, paramLuaObject2, paramLuaObject3);
  }

  public LuaAsyncTask task(LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    return task(paramLuaObject, paramArrayOfObject, null, null);
  }

  public LuaAsyncTask task(LuaObject paramLuaObject1, Object[] paramArrayOfObject, LuaObject paramLuaObject2)
  {
    return task(paramLuaObject1, null, null, paramLuaObject2);
  }

  public LuaAsyncTask task(LuaObject paramLuaObject1, Object[] paramArrayOfObject, LuaObject paramLuaObject2, LuaObject paramLuaObject3)
  {
    LuaAsyncTask localLuaAsyncTask = new LuaAsyncTask(this, paramLuaObject1, paramLuaObject2, paramLuaObject3);
    localLuaAsyncTask.execute(paramArrayOfObject);
    return localLuaAsyncTask;
  }

  public LuaThread thread(LuaObject paramLuaObject)
  {
    LuaThread localLuaThread = newThread(paramLuaObject, null);
    localLuaThread.start();
    return localLuaThread;
  }

  public LuaThread thread(LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    LuaThread localLuaThread = new LuaThread(this, paramLuaObject, true, paramArrayOfObject);
    localLuaThread.start();
    return localLuaThread;
  }

  public Ticker ticker(final LuaObject paramLuaObject, long paramLong)
  {
    Ticker localTicker = new Ticker();
    localTicker.setOnTickListener(new Ticker.OnTickListener()
    {
      public void onTick()
      {
        try
        {
          paramLuaObject.call(new Object[0]);
          return;
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
          LuaService.this.sendError("onTick", localLuaException);
        }
      }
    });
    localTicker.setPeriod(paramLong);
    localTicker.start();
    return localTicker;
  }

  public LuaTimer timer(LuaObject paramLuaObject, long paramLong)
  {
    return timer(paramLuaObject, 0L, paramLong, null);
  }

  public LuaTimer timer(LuaObject paramLuaObject, long paramLong1, long paramLong2)
  {
    return timer(paramLuaObject, paramLong1, paramLong2, null);
  }

  public LuaTimer timer(LuaObject paramLuaObject, long paramLong1, long paramLong2, Object[] paramArrayOfObject)
  {
    LuaTimer localLuaTimer = new LuaTimer(this, paramLuaObject, paramArrayOfObject);
    localLuaTimer.start(paramLong1, paramLong2);
    return localLuaTimer;
  }

  public LuaTimer timer(LuaObject paramLuaObject, long paramLong, Object[] paramArrayOfObject)
  {
    return timer(paramLuaObject, 0L, paramLong, paramArrayOfObject);
  }

  public class LuaBinder extends Binder
  {
    public LuaBinder()
    {
    }

    public LuaService getService()
    {
      return LuaService.this;
    }
  }

  public class MainHandler extends Handler
  {
    public MainHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default:
        return;
      case 3:
        String str3 = paramMessage.getData().getString("data");
        Serializable localSerializable = paramMessage.getData().getSerializable("args");
        LuaService.this.runFunc(str3, (Object[])localSerializable);
        return;
      case 2:
        String str2 = paramMessage.getData().getString("data");
        LuaService.this.runFunc(str2, new Object[0]);
        return;
      case 1:
        Bundle localBundle = paramMessage.getData();
        LuaService.a(LuaService.this, localBundle.getString("data"), ((Object[])localBundle.getSerializable("args"))[0]);
        return;
      case 0:
      }
      String str1 = paramMessage.getData().getString("data");
      LuaService.this.showToast(str1);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaService
 * JD-Core Version:    0.6.2
 */