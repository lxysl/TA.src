package com.androlua;

import android.R.style;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.FileProvider;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.ArrayListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.a.a.a.a.a;
import com.baidu.mobstat.StatService;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LuaActivity extends Activity
  implements LuaBroadcastReceiver.OnReceiveListener, LuaContext
{
  private static String J;
  private static final HashMap<String, LuaActivity> K = new HashMap();
  private static ArrayList<String> a = new ArrayList();
  private String A;
  private LuaBroadcastReceiver B;
  private String C;
  private String D;
  private boolean E;
  private boolean F = true;
  private LuaResources G;
  private ArrayList<LuaGcable> H = new ArrayList();
  private String I = "main";
  private LuaObject L;
  private String b;
  private Handler c;
  private TextView d;
  private String e;
  private LuaDexLoader f;
  private int g;
  private int h;
  private ListView i;
  private ArrayListAdapter<String> j;
  private LuaState k;
  private String l;
  private StringBuilder m = new StringBuilder();
  private Boolean n = Boolean.valueOf(false);
  private Toast o;
  private LinearLayout p;
  private boolean q;
  private long r;
  private Menu s;
  private LuaObject t;
  private LuaObject u;
  private LuaObject v;
  private LuaObject w;
  private String x;
  private String y;
  private String z;

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

  private String a(File paramFile)
  {
    int i1 = paramFile.getName().lastIndexOf('.');
    if (i1 >= 0)
    {
      String str1 = paramFile.getName().substring(i1 + 1);
      String str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
      if (str2 != null)
        return str2;
    }
    return "application/octet-stream";
  }

  private void a()
  {
    try
    {
      Field localField = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").getDeclaredField("disableHooks");
      localField.setAccessible(true);
      localField.set(null, Boolean.valueOf(true));
    }
    catch (Exception localException)
    {
    }
  }

  private void a(Object paramObject, String paramString)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField(paramString);
      localField.setAccessible(true);
      ((HashMap)localField.get(paramObject)).clear();
      LuaDialog localLuaDialog = new LuaDialog(this);
      localLuaDialog.setTitle("提示3");
      localLuaDialog.setMessage("你的手机运行环境不安全");
      localLuaDialog.setPosButton("确定");
      localLuaDialog.show();
      return;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }

  private void a(String paramString, Object paramObject)
  {
    try
    {
      synchronized (this.k)
      {
        this.k.pushObjectValue(paramObject);
        this.k.setGlobal(paramString);
      }
    }
    catch (LuaException localLuaException)
    {
      sendError("setField", localLuaException);
      return;
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

  private void b()
  {
    try
    {
      Object localObject = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers").newInstance();
      if (localObject != null)
      {
        a(localObject, "fieldCache");
        a(localObject, "methodCache");
        a(localObject, "constructorCache");
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void c()
  {
    this.k = LuaStateFactory.newLuaState();
    this.k.openLibs();
    this.k.pushJavaObject(this);
    this.k.setGlobal("activity");
    this.k.getGlobal("activity");
    this.k.setGlobal("this");
    this.k.pushContext(this);
    this.k.getGlobal("luajava");
    this.k.pushString(this.A);
    this.k.setField(-2, "luaextdir");
    this.k.pushString(this.b);
    this.k.setField(-2, "luadir");
    this.k.pushString(this.l);
    this.k.setField(-2, "luapath");
    this.k.pop(1);
    d();
    new LuaPrint(this, this.k).register("print");
    this.k.getGlobal("package");
    this.k.pushString(this.C);
    this.k.setField(-2, "path");
    this.k.pushString(this.e);
    this.k.setField(-2, "cpath");
    this.k.pop(1);
    new JavaFunction(this.k)
    {
      public int execute()
      {
        ((LuaThread)this.b.toJavaObject(2)).set(this.b.toString(3), this.b.toJavaObject(4));
        return 0;
      }
    }
    .register("set");
    new JavaFunction(this.k)
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

  private void d()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.b);
    localStringBuilder1.append("/init.lua");
    if (!new File(localStringBuilder1.toString()).exists())
      return;
    while (true)
    {
      int i2;
      try
      {
        LuaState localLuaState = this.k;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.b);
        localStringBuilder2.append("/init.lua");
        i1 = localLuaState.LloadFile(localStringBuilder2.toString());
        if (i1 == 0)
        {
          this.k.newTable();
          LuaObject localLuaObject1 = this.k.getLuaObject(-1);
          this.k.setUpValue(-2, 1);
          i2 = this.k.pcall(0, 0, 0);
          if (i2 != 0)
            break label447;
          if (J == null)
          {
            LuaObject localLuaObject7 = localLuaObject1.getField("app_key");
            if (localLuaObject7.isString())
            {
              J = localLuaObject7.toString();
              StatService.setAppKey(localLuaObject7.toString());
            }
            LuaObject localLuaObject8 = localLuaObject1.getField("app_channel");
            if (localLuaObject8.isString())
              StatService.setAppChannel(this, localLuaObject8.toString(), true);
            StatService.setOn(this, 1);
          }
          LuaObject localLuaObject2 = localLuaObject1.getField("appname");
          if (localLuaObject2.isString())
            setTitle(localLuaObject2.getString());
          LuaObject localLuaObject3 = localLuaObject1.getField("app_name");
          if (localLuaObject3.isString())
            setTitle(localLuaObject3.getString());
          LuaObject localLuaObject4 = localLuaObject1.getField("debugmode");
          if (localLuaObject4.isBoolean())
            this.F = localLuaObject4.getBoolean();
          LuaObject localLuaObject5 = localLuaObject1.getField("debug_mode");
          if (localLuaObject5.isBoolean())
            this.F = localLuaObject5.getBoolean();
          LuaObject localLuaObject6 = localLuaObject1.getField("theme");
          if (localLuaObject6.isNumber())
          {
            setTheme((int)localLuaObject6.getInteger());
            return;
          }
          if (localLuaObject6.isString())
            setTheme(R.style.class.getField(localLuaObject6.getString()).getInt(null));
        }
        else
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(a(i1));
          localStringBuilder3.append(": ");
          localStringBuilder3.append(this.k.toString(-1));
          throw new LuaException(localStringBuilder3.toString());
        }
      }
      catch (Exception localException)
      {
        sendMsg(localException.getMessage());
        return;
      }
      return;
      label447: int i1 = i2;
    }
  }

  public static LuaActivity getActivity(String paramString)
  {
    return (LuaActivity)K.get(paramString);
  }

  public void assetsToSD(String paramString1, String paramString2)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
    InputStream localInputStream = getAssets().open(paramString1);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i1 = localInputStream.read(arrayOfByte);
      if (i1 <= 0)
        break;
      localFileOutputStream.write(arrayOfByte, 0, i1);
    }
    localFileOutputStream.flush();
    localInputStream.close();
    localFileOutputStream.close();
  }

  public boolean bindService(int paramInt)
  {
    return bindService(new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        LuaActivity localLuaActivity = LuaActivity.this;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousComponentName;
        arrayOfObject[1] = ((LuaService.LuaBinder)paramAnonymousIBinder).getService();
        localLuaActivity.runFunc("onServiceConnected", arrayOfObject);
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        LuaActivity.this.runFunc("onServiceDisconnected", new Object[] { paramAnonymousComponentName });
      }
    }
    , paramInt);
  }

  public boolean bindService(ServiceConnection paramServiceConnection, int paramInt)
  {
    Intent localIntent = new Intent(this, LuaService.class);
    localIntent.putExtra("luaDir", this.b);
    localIntent.putExtra("luaPath", this.l);
    return super.bindService(localIntent, paramServiceConnection, paramInt);
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

  public void createShortcut(String paramString1, String paramString2)
  {
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.addCategory("android.intent.category.DEFAULT");
    localIntent1.setClassName(getPackageName(), LuaActivity.class.getName());
    localIntent1.setData(Uri.parse(paramString1));
    if (Build.VERSION.SDK_INT >= 22)
    {
      localIntent1.addFlags(524288);
      localIntent1.addFlags(134217728);
    }
    String str;
    if (Build.VERSION.SDK_INT >= 26)
    {
      ShortcutManager localShortcutManager = (ShortcutManager)getSystemService("shortcut");
      ShortcutInfo localShortcutInfo = new ShortcutInfo.Builder(this, paramString1).setIcon(Icon.createWithResource(this, 2130771968)).setShortLabel(paramString2).setIntent(localIntent1).build();
      try
      {
        localShortcutManager.requestPinShortcut(localShortcutInfo, null);
        return;
      }
      catch (Exception localException)
      {
        a.a(localException);
        str = "添加快捷方式出错";
      }
    }
    else
    {
      Intent localIntent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(this, 2130771968);
      localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString2);
      localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
      localIntent2.putExtra("duplicate", 0);
      localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", localShortcutIconResource);
      sendBroadcast(localIntent2);
      str = "已添加快捷方式";
    }
    Toast.makeText(this, str, 0).show();
  }

  public void createShortcut(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.addCategory("android.intent.category.DEFAULT");
    localIntent1.setClassName(getPackageName(), LuaActivity.class.getName());
    localIntent1.setData(Uri.parse(paramString1));
    if (Build.VERSION.SDK_INT >= 22)
    {
      localIntent1.addFlags(524288);
      localIntent1.addFlags(134217728);
    }
    String str;
    if (Build.VERSION.SDK_INT >= 26)
    {
      ShortcutManager localShortcutManager = (ShortcutManager)getSystemService("shortcut");
      ShortcutInfo localShortcutInfo = new ShortcutInfo.Builder(this, paramString1).setIcon(Icon.createWithFilePath(paramString3)).setShortLabel(paramString2).setIntent(localIntent1).build();
      try
      {
        localShortcutManager.requestPinShortcut(localShortcutInfo, null);
        return;
      }
      catch (Exception localException)
      {
        a.a(localException);
        str = "添加快捷方式出错";
      }
    }
    else
    {
      Intent localIntent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString2);
      localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
      localIntent2.putExtra("duplicate", 0);
      localIntent2.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(paramString3));
      sendBroadcast(localIntent2);
      str = "已添加快捷方式";
    }
    Toast.makeText(this, str, 0).show();
  }

  // ERROR //
  public Object doAsset(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 683	com/androlua/LuaActivity:readAsset	(Ljava/lang/String;)[B
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   13: iconst_0
    //   14: invokevirtual 686	com/luajava/LuaState:setTop	(I)V
    //   17: aload_0
    //   18: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 690	com/luajava/LuaState:LloadBuffer	([BLjava/lang/String;)I
    //   27: istore 6
    //   29: iload 6
    //   31: ifne +198 -> 229
    //   34: aload_0
    //   35: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   38: ldc_w 692
    //   41: invokevirtual 318	com/luajava/LuaState:getGlobal	(Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   49: iconst_m1
    //   50: ldc_w 694
    //   53: invokevirtual 697	com/luajava/LuaState:getField	(ILjava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   61: bipush 254
    //   63: invokevirtual 700	com/luajava/LuaState:remove	(I)V
    //   66: aload_0
    //   67: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   70: bipush 254
    //   72: invokevirtual 703	com/luajava/LuaState:insert	(I)V
    //   75: aload_2
    //   76: arraylength
    //   77: istore 13
    //   79: iconst_0
    //   80: istore 14
    //   82: iload 14
    //   84: iload 13
    //   86: if_icmpge +20 -> 106
    //   89: aload_0
    //   90: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   93: aload_2
    //   94: iload 14
    //   96: aaload
    //   97: invokevirtual 246	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   100: iinc 14 1
    //   103: goto -21 -> 82
    //   106: aload_0
    //   107: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   110: iload 13
    //   112: iconst_0
    //   113: bipush 254
    //   115: iload 13
    //   117: isub
    //   118: invokevirtual 408	com/luajava/LuaState:pcall	(III)I
    //   121: istore_3
    //   122: iload_3
    //   123: ifne +12 -> 135
    //   126: aload_0
    //   127: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   130: iconst_m1
    //   131: invokevirtual 707	com/luajava/LuaState:toJavaObject	(I)Ljava/lang/Object;
    //   134: areturn
    //   135: new 85	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   142: astore 7
    //   144: aload 7
    //   146: aload_0
    //   147: iload_3
    //   148: invokespecial 477	com/androlua/LuaActivity:a	(I)Ljava/lang/String;
    //   151: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 7
    //   157: ldc_w 479
    //   160: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 7
    //   166: aload_0
    //   167: getfield 240	com/androlua/LuaActivity:k	Lcom/luajava/LuaState;
    //   170: iconst_m1
    //   171: invokevirtual 481	com/luajava/LuaState:toString	(I)Ljava/lang/String;
    //   174: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: new 238	com/luajava/LuaException
    //   181: dup
    //   182: aload 7
    //   184: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 482	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: astore 4
    //   193: aload_0
    //   194: aload_0
    //   195: iload_3
    //   196: invokespecial 477	com/androlua/LuaActivity:a	(I)Ljava/lang/String;
    //   199: invokevirtual 443	com/androlua/LuaActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   202: aload_0
    //   203: aload_0
    //   204: getfield 709	com/androlua/LuaActivity:p	Landroid/widget/LinearLayout;
    //   207: invokevirtual 713	com/androlua/LuaActivity:setContentView	(Landroid/view/View;)V
    //   210: aload_0
    //   211: aload 4
    //   213: invokevirtual 485	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 488	com/androlua/LuaActivity:sendMsg	(Ljava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore 4
    //   223: iload 6
    //   225: istore_3
    //   226: goto -33 -> 193
    //   229: iload 6
    //   231: istore_3
    //   232: goto -97 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   2	29	191	java/lang/Exception
    //   126	135	191	java/lang/Exception
    //   135	191	191	java/lang/Exception
    //   34	79	221	java/lang/Exception
    //   89	100	221	java/lang/Exception
    //   106	122	221	java/lang/Exception
  }

  public Object doFile(String paramString)
  {
    return doFile(paramString, new Object[0]);
  }

  public Object doFile(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      if (paramString.charAt(0) != '/')
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(this.b);
        localStringBuilder3.append("/");
        localStringBuilder3.append(paramString);
        paramString = localStringBuilder3.toString();
      }
      this.k.setTop(0);
      i1 = this.k.LloadFile(paramString);
      if (i1 == 0)
        try
        {
          this.k.getGlobal("debug");
          this.k.getField(-1, "traceback");
          this.k.remove(-2);
          this.k.insert(-2);
          int i5 = paramArrayOfObject.length;
          for (int i6 = 0; i6 < i5; i6++)
            this.k.pushObjectValue(paramArrayOfObject[i6]);
          int i7 = this.k.pcall(i5, 1, -2 - i5);
          if (i7 == 0)
            try
            {
              Object localObject2 = this.k.toJavaObject(-1);
              return localObject2;
            }
            catch (LuaException localLuaException4)
            {
              LuaException localLuaException2 = localLuaException4;
              i1 = i7;
            }
          i1 = i7;
        }
        catch (LuaException localLuaException3)
        {
          break label304;
        }
      Intent localIntent = new Intent();
      localIntent.putExtra("data", this.k.toString(-1));
      setResult(i1, localIntent);
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append(a(i1));
      localStringBuilder4.append(": ");
      localStringBuilder4.append(this.k.toString(-1));
      throw new LuaException(localStringBuilder4.toString());
    }
    catch (LuaException localLuaException1)
    {
      Object localObject1 = localLuaException1;
      int i1 = 0;
      label304: setTitle(a(i1));
      setContentView(this.p);
      sendMsg(localObject1.getMessage());
      String str1 = localObject1.getMessage();
      int i2 = str1.indexOf("android.permission.");
      if (i2 > 0)
      {
        int i3 = i2 + "android.permission.".length();
        int i4 = str1.indexOf(".", i3);
        if (i4 > i3)
        {
          String str2 = str1.substring(i3, i4);
          this.k.getGlobal("require");
          this.k.pushString("permission");
          this.k.pcall(1, 0, 0);
          this.k.getGlobal("permission_info");
          this.k.getField(-1, str2);
          if (this.k.isString(-1))
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append(str2);
            localStringBuilder1.append(" (");
            localStringBuilder1.append(this.k.toString(-1));
            localStringBuilder1.append(")");
            str2 = localStringBuilder1.toString();
          }
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("权限错误: ");
          localStringBuilder2.append(str2);
          sendMsg(localStringBuilder2.toString());
          return null;
        }
      }
    }
    return null;
  }

  public Object doString(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      LuaState localLuaState = this.k;
      int i1 = 0;
      localLuaState.setTop(0);
      int i2 = this.k.LloadString(paramString);
      if (i2 == 0)
      {
        this.k.getGlobal("debug");
        this.k.getField(-1, "traceback");
        this.k.remove(-2);
        this.k.insert(-2);
        int i3 = paramArrayOfObject.length;
        while (i1 < i3)
        {
          this.k.pushObjectValue(paramArrayOfObject[i1]);
          i1++;
        }
        i2 = this.k.pcall(i3, 1, -2 - i3);
        if (i2 == 0)
          return this.k.toJavaObject(-1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(i2));
      localStringBuilder.append(": ");
      localStringBuilder.append(this.k.toString(-1));
      throw new LuaException(localStringBuilder.toString());
    }
    catch (LuaException localLuaException)
    {
      sendMsg(localLuaException.getMessage());
    }
    return null;
  }

  public void finish(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.finish();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Intent localIntent = getIntent();
      if ((localIntent != null) && ((0x80000 & localIntent.getFlags()) != 0))
      {
        finishAndRemoveTask();
        return;
      }
    }
    super.finish();
  }

  public Object get(String paramString)
  {
    synchronized (this.k)
    {
      this.k.getGlobal(paramString);
      Object localObject2 = this.k.toJavaObject(-1);
      return localObject2;
    }
  }

  public Object getArg(int paramInt)
  {
    Object[] arrayOfObject = (Object[])getIntent().getSerializableExtra("arg");
    if ((arrayOfObject != null) && (arrayOfObject.length < paramInt))
      return arrayOfObject[paramInt];
    return null;
  }

  public AssetManager getAssets()
  {
    if ((this.f != null) && (this.f.getAssets() != null))
      return this.f.getAssets();
    return super.getAssets();
  }

  public ArrayList<ClassLoader> getClassLoaders()
  {
    return this.f.getClassLoaders();
  }

  public Context getContext()
  {
    return this;
  }

  public View getDecorView()
  {
    return getWindow().getDecorView();
  }

  public Map getGlobalData()
  {
    return ((LuaApplication)getApplication()).getGlobalData();
  }

  public int getHeight()
  {
    return this.h;
  }

  public HashMap<String, String> getLibrarys()
  {
    return this.f.getLibrarys();
  }

  public String getLocalDir()
  {
    return this.x;
  }

  public String getLuaCpath()
  {
    return this.e;
  }

  public String getLuaDir()
  {
    return this.b;
  }

  public String getLuaDir(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    File localFile = new File(localStringBuilder.toString());
    if ((!localFile.exists()) && (!localFile.mkdirs()))
      return null;
    return localFile.getAbsolutePath();
  }

  public String getLuaExtDir()
  {
    return this.A;
  }

  public String getLuaExtDir(String paramString)
  {
    File localFile = new File(getLuaExtDir(), paramString);
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
    return this.C;
  }

  public String getLuaPath()
  {
    Uri localUri = getIntent().getData();
    if (localUri == null)
      return null;
    String str1 = localUri.getPath();
    if ((!new File(str1).exists()) && (new File(getLuaPath(str1)).exists()))
      str1 = getLuaPath(str1);
    this.l = str1;
    File localFile = new File(str1);
    this.b = new File(this.l).getParent();
    if ((localFile.getName().equals("main.lua")) && (new File(this.b, "init.lua").exists()))
    {
      if (!a.contains(this.b))
      {
        a.add(this.b);
        return str1;
      }
    }
    else
      for (String str2 = this.b; ; str2 = new File(str2).getParent())
      {
        if (str2 == null)
          break label253;
        if (a.contains(str2))
        {
          this.b = str2;
          return str1;
        }
        if ((new File(str2, "main.lua").exists()) && (new File(str2, "init.lua").exists()))
        {
          this.b = str2;
          if (a.contains(this.b))
            break label253;
          break;
        }
      }
    label253: return str1;
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
    if ((this.f != null) && (this.f.getResources() != null))
      localResources = this.f.getResources();
    this.G = new LuaResources(getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
    this.G.setSuperResources(localResources);
    return this.G;
  }

  public LuaState getLuaState()
  {
    return this.k;
  }

  public Menu getOptionsMenu()
  {
    return this.s;
  }

  public String getPathFromUri(Uri paramUri)
  {
    if (paramUri != null)
    {
      int i1 = 1;
      String[] arrayOfString = new String[i1];
      arrayOfString[0] = "_data";
      String str1 = paramUri.getScheme();
      int i2 = str1.hashCode();
      if (i2 != 3143036)
      {
        if ((i2 == 951530617) && (str1.equals("content")))
        {
          i1 = 0;
          break label81;
        }
      }
      else
        if (str1.equals("file"))
          break label81;
      i1 = -1;
      switch (i1)
      {
      default:
        break;
      case 1:
        return paramUri.getPath();
      case 0:
        label81: Cursor localCursor = getContentResolver().query(paramUri, arrayOfString, null, null, null);
        if (localCursor != null)
        {
          int i3 = localCursor.getColumnIndexOrThrow(getPackageName());
          if (i3 >= 0)
          {
            String str2 = localCursor.getString(i3);
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

  public String getQuery(String paramString)
  {
    Uri localUri = getIntent().getData();
    if (localUri == null)
      return null;
    return localUri.getQueryParameter(paramString);
  }

  public Resources getResources()
  {
    if ((this.f != null) && (this.f.getResources() != null))
      return this.f.getResources();
    if (this.G != null)
      return this.G;
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
    return this.g;
  }

  public void initMain()
  {
    a.add(getLocalDir());
  }

  public void installApk(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    File localFile = new File(paramString);
    localIntent.setFlags(1);
    localIntent.setDataAndType(getUriForFile(localFile), a(localFile));
    localIntent.addFlags(268435456);
    startActivity(Intent.createChooser(localIntent, localFile.getName()));
  }

  public DexClassLoader loadApp(String paramString)
  {
    return this.f.loadApp(paramString);
  }

  public Bitmap loadBitmap(String paramString)
  {
    return LuaBitmap.getBitmap(this, paramString);
  }

  public DexClassLoader loadDex(String paramString)
  {
    return this.f.loadDex(paramString);
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
    localStringBuilder1.append(this.z);
    localStringBuilder1.append("/lib");
    localStringBuilder1.append(str1);
    localStringBuilder1.append(".so");
    if (!new File(localStringBuilder1.toString()).exists())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.b);
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
      localStringBuilder4.append(this.b);
      localStringBuilder4.append("/lib");
      localStringBuilder4.append(str1);
      localStringBuilder4.append(".so");
      String str2 = localStringBuilder4.toString();
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append(this.z);
      localStringBuilder5.append("/lib");
      localStringBuilder5.append(str1);
      localStringBuilder5.append(".so");
      LuaUtil.copyFile(str2, localStringBuilder5.toString());
    }
    return this.k.getLuaObject("require").call(new Object[] { paramString });
  }

  public void loadResources(String paramString)
  {
    this.f.loadResources(paramString);
  }

  public void newActivity(int paramInt, String paramString)
  {
    newActivity(paramInt, paramString, null);
  }

  public void newActivity(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    newActivity(paramInt1, paramString, paramInt2, paramInt3, null);
  }

  public void newActivity(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    newActivity(paramInt1, paramString, paramInt2, paramInt3, null, paramBoolean);
  }

  public void newActivity(int paramInt1, String paramString, int paramInt2, int paramInt3, Object[] paramArrayOfObject)
  {
    newActivity(paramInt1, paramString, paramInt2, paramInt3, paramArrayOfObject, false);
  }

  public void newActivity(int paramInt1, String paramString, int paramInt2, int paramInt3, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, LuaActivity.class);
    if (paramBoolean)
      localIntent = new Intent(this, LuaActivityX.class);
    localIntent.putExtra("name", paramString);
    if (paramString.charAt(0) != '/')
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.b);
      localStringBuilder1.append("/");
      localStringBuilder1.append(paramString);
      paramString = localStringBuilder1.toString();
    }
    File localFile = new File(paramString);
    StringBuilder localStringBuilder3;
    if (localFile.isDirectory())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("/main.lua");
      if (new File(localStringBuilder2.toString()).exists())
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(paramString);
      }
    }
    for (String str = "/main.lua"; ; str = ".lua")
    {
      localStringBuilder3.append(str);
      paramString = localStringBuilder3.toString();
      break;
      if (((!localFile.isDirectory()) && (localFile.exists())) || (paramString.endsWith(".lua")))
        break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(paramString);
    }
    if (!new File(paramString).exists())
      throw new FileNotFoundException(paramString);
    StringBuilder localStringBuilder4 = new StringBuilder();
    localStringBuilder4.append("file://");
    localStringBuilder4.append(paramString);
    localIntent.setData(Uri.parse(localStringBuilder4.toString()));
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 21))
    {
      localIntent.addFlags(524288);
      localIntent.addFlags(134217728);
    }
    if (paramArrayOfObject != null)
      localIntent.putExtra("arg", paramArrayOfObject);
    if (paramBoolean)
      startActivity(localIntent);
    else
      startActivityForResult(localIntent, paramInt1);
    overridePendingTransition(paramInt2, paramInt3);
  }

  public void newActivity(int paramInt, String paramString, boolean paramBoolean)
  {
    newActivity(paramInt, paramString, null, paramBoolean);
  }

  public void newActivity(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    newActivity(paramInt, paramString, paramArrayOfObject, false);
  }

  public void newActivity(int paramInt, String paramString, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, LuaActivity.class);
    if (paramBoolean)
      localIntent = new Intent(this, LuaActivityX.class);
    localIntent.putExtra("name", paramString);
    if (paramString.charAt(0) != '/')
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.b);
      localStringBuilder1.append("/");
      localStringBuilder1.append(paramString);
      paramString = localStringBuilder1.toString();
    }
    File localFile = new File(paramString);
    StringBuilder localStringBuilder3;
    if (localFile.isDirectory())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("/main.lua");
      if (new File(localStringBuilder2.toString()).exists())
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(paramString);
      }
    }
    for (String str = "/main.lua"; ; str = ".lua")
    {
      localStringBuilder3.append(str);
      paramString = localStringBuilder3.toString();
      break;
      if (((!localFile.isDirectory()) && (localFile.exists())) || (paramString.endsWith(".lua")))
        break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(paramString);
    }
    if (!new File(paramString).exists())
      throw new FileNotFoundException(paramString);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 21))
    {
      localIntent.addFlags(524288);
      localIntent.addFlags(134217728);
    }
    StringBuilder localStringBuilder4 = new StringBuilder();
    localStringBuilder4.append("file://");
    localStringBuilder4.append(paramString);
    localIntent.setData(Uri.parse(localStringBuilder4.toString()));
    if (paramArrayOfObject != null)
      localIntent.putExtra("arg", paramArrayOfObject);
    if (paramBoolean)
    {
      startActivity(localIntent);
      return;
    }
    startActivityForResult(localIntent, paramInt);
  }

  public void newActivity(String paramString)
  {
    newActivity(1, paramString, null);
  }

  public void newActivity(String paramString, int paramInt1, int paramInt2)
  {
    newActivity(1, paramString, paramInt1, paramInt2, null);
  }

  public void newActivity(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    newActivity(1, paramString, paramInt1, paramInt2, null, paramBoolean);
  }

  public void newActivity(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    newActivity(1, paramString, paramInt1, paramInt2, paramArrayOfObject);
  }

  public void newActivity(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    newActivity(1, paramString, paramInt1, paramInt2, paramArrayOfObject, paramBoolean);
  }

  public void newActivity(String paramString, boolean paramBoolean)
  {
    newActivity(1, paramString, null, paramBoolean);
  }

  public void newActivity(String paramString, Object[] paramArrayOfObject)
  {
    newActivity(1, paramString, paramArrayOfObject);
  }

  public void newActivity(String paramString, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    newActivity(1, paramString, paramArrayOfObject, paramBoolean);
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

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("name");
      if (str != null)
      {
        Object[] arrayOfObject2 = (Object[])paramIntent.getSerializableExtra("data");
        if (arrayOfObject2 == null)
        {
          runFunc("onResult", new Object[] { str });
        }
        else
        {
          Object[] arrayOfObject3 = new Object[1 + arrayOfObject2.length];
          arrayOfObject3[0] = str;
          int i2;
          for (int i1 = 0; i1 < arrayOfObject2.length; i1 = i2)
          {
            i2 = i1 + 1;
            arrayOfObject3[i2] = arrayOfObject2[i1];
          }
          Object localObject = runFunc("onResult", arrayOfObject3);
          if ((localObject != null) && (localObject.getClass() == Boolean.class) && (((Boolean)localObject).booleanValue()))
            return;
        }
      }
    }
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(paramInt1);
    arrayOfObject1[1] = Integer.valueOf(paramInt2);
    arrayOfObject1[2] = paramIntent;
    runFunc("onActivityResult", arrayOfObject1);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    WindowManager localWindowManager = (WindowManager)getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.g = localDisplayMetrics.widthPixels;
    this.h = localDisplayMetrics.heightPixels;
    runFunc("onConfigurationChanged", new Object[] { paramConfiguration });
  }

  public void onContentChanged()
  {
    super.onContentChanged();
    this.q = true;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    runFunc("onContextItemSelected", new Object[] { paramMenuItem });
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onCreate(Bundle paramBundle)
  {
    setTheme(16974064);
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    super.onCreate(null);
    WindowManager localWindowManager = (WindowManager)getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.g = localDisplayMetrics.widthPixels;
    this.h = localDisplayMetrics.heightPixels;
    this.p = new LinearLayout(this);
    ScrollView localScrollView = new ScrollView(this);
    int i1 = 1;
    localScrollView.setFillViewport(i1);
    this.d = new TextView(this);
    this.d.setTextColor(-16777216);
    localScrollView.addView(this.d, new ViewGroup.LayoutParams(-1, -2));
    this.d.setText("");
    this.d.setTextIsSelectable(i1);
    this.i = new ListView(this);
    this.i.setFastScrollEnabled(i1);
    this.j = new ArrayListAdapter(this, 17367043)
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        TextView localTextView = (TextView)super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        if (paramAnonymousView == null)
          localTextView.setTextIsSelectable(true);
        return localTextView;
      }
    };
    this.i.setAdapter(this.j);
    this.p.addView(this.i, new ViewGroup.LayoutParams(-1, -2));
    LuaApplication localLuaApplication = (LuaApplication)getApplication();
    while ((localLuaApplication.getClass() != LuaApplication.class) && (localLuaApplication.getClass() != LuaApplication.class));
    this.x = localLuaApplication.getLocalDir();
    this.y = localLuaApplication.getOdexDir();
    this.z = localLuaApplication.getLibDir();
    this.D = localLuaApplication.getMdDir();
    this.e = localLuaApplication.getLuaCpath();
    this.b = this.x;
    this.C = localLuaApplication.getLuaLpath();
    this.A = localLuaApplication.getLuaExtDir();
    this.c = new MainHandler();
    try
    {
      this.d.setText("");
      this.j.clear();
      Object[] arrayOfObject1 = (Object[])getIntent().getSerializableExtra("arg");
      if (arrayOfObject1 == null)
        arrayOfObject1 = new Object[0];
      this.l = getLuaPath();
      this.I = new File(this.l).getName();
      int i2 = this.I.lastIndexOf(".");
      if (i2 > 0)
        this.I = this.I.substring(0, i2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("/?.lua;");
      localStringBuilder.append(this.b);
      localStringBuilder.append("/lua/?.lua;");
      localStringBuilder.append(this.b);
      localStringBuilder.append("/?/init.lua;");
      localStringBuilder.append(this.C);
      this.C = localStringBuilder.toString();
      c();
      this.f = new LuaDexLoader(this);
      this.f.loadLibs();
      K.put(this.I, this);
      doFile(this.l, arrayOfObject1);
      this.n = Boolean.valueOf(i1);
      if (!this.I.equals("main"))
        runFunc("main", arrayOfObject1);
      runFunc(this.I, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[i1];
      arrayOfObject2[0] = paramBundle;
      runFunc("onCreate", arrayOfObject2);
      if (!this.q)
      {
        TypedArray localTypedArray = getTheme().obtainStyledAttributes(new int[] { 16842801, 16842806, 16843599 });
        int i3 = localTypedArray.getColor(0, 16711935);
        int i4 = localTypedArray.getColor(i1, 16711935);
        localTypedArray.recycle();
        this.d.setTextColor(i4);
        this.p.setBackgroundColor(i3);
        setContentView(this.p);
      }
      this.L = this.k.getLuaObject("onKeyShortcut");
      if (this.L.isNil())
        this.L = null;
      this.t = this.k.getLuaObject("onKeyDown");
      if (this.t.isNil())
        this.t = null;
      this.u = this.k.getLuaObject("onKeyUp");
      if (this.u.isNil())
        this.u = null;
      this.v = this.k.getLuaObject("onKeyLongPress");
      if (this.v.isNil())
        this.v = null;
      this.w = this.k.getLuaObject("onTouchEvent");
      if (this.w.isNil())
        this.w = null;
      LuaObject localLuaObject = this.k.getLuaObject("onAccessibilityEvent");
      if (localLuaObject.isFunction())
        LuaAccessibilityService.onAccessibilityEvent = localLuaObject.getFunction();
      a();
      b();
      try
      {
        throw new RuntimeException("");
      }
      catch (Exception localException2)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        a.a(localException2, new PrintStream(localByteArrayOutputStream));
        String[] arrayOfString = localByteArrayOutputStream.toString().split("\n");
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          if ((!str.contains("com.androlua")) && (!str.contains("com.nirenr.talkman")) && (!str.contains("android.app")) && (!str.contains("android.os")) && (!str.contains("java.lang")) && (!str.contains("com.android")))
          {
            runFunc("onHook", new Object[0]);
            return;
          }
          i1++;
        }
        return;
      }
    }
    catch (Exception localException1)
    {
      sendMsg(localException1.getMessage());
      setContentView(this.p);
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    runFunc("onCreateContextMenu", new Object[] { paramContextMenu, paramView, paramContextMenuInfo });
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.s = paramMenu;
    runFunc("onCreateOptionsMenu", new Object[] { paramMenu });
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    if (this.B != null)
      unregisterReceiver(this.B);
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
      ((LuaGcable)localIterator.next()).gc();
    K.remove(this.I);
    runFunc("onDestroy", new Object[0]);
    super.onDestroy();
    System.gc();
    this.k.gc(2, 1);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.t != null)
      try
      {
        LuaObject localLuaObject = this.t;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramKeyEvent;
        Object localObject = localLuaObject.call(arrayOfObject);
        if ((localObject != null) && (localObject.getClass() == Boolean.class))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          if (bool)
            return true;
        }
      }
      catch (LuaException localLuaException)
      {
        sendError("onKeyDown", localLuaException);
      }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.v != null)
      try
      {
        LuaObject localLuaObject = this.v;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramKeyEvent;
        Object localObject = localLuaObject.call(arrayOfObject);
        if ((localObject != null) && (localObject.getClass() == Boolean.class))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          if (bool)
            return true;
        }
      }
      catch (LuaException localLuaException)
      {
        sendError("onKeyLongPress", localLuaException);
      }
    return super.onKeyLongPress(paramInt, paramKeyEvent);
  }

  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.L != null)
      try
      {
        LuaObject localLuaObject = this.L;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramKeyEvent;
        Object localObject = localLuaObject.call(arrayOfObject);
        if ((localObject != null) && (localObject.getClass() == Boolean.class))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          if (bool)
            return true;
        }
      }
      catch (LuaException localLuaException)
      {
        sendError("onKeyShortcut", localLuaException);
      }
    return super.onKeyShortcut(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.u != null)
      try
      {
        LuaObject localLuaObject = this.u;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramKeyEvent;
        Object localObject = localLuaObject.call(arrayOfObject);
        if ((localObject != null) && (localObject.getClass() == Boolean.class))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          if (bool)
            return true;
        }
      }
      catch (LuaException localLuaException)
      {
        sendError("onKeyUp", localLuaException);
      }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (!paramMenuItem.hasSubMenu())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramMenuItem;
      runFunc("onMenuItemSelected", arrayOfObject);
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject;
    if (!paramMenuItem.hasSubMenu())
      localObject = runFunc("onOptionsItemSelected", new Object[] { paramMenuItem });
    else
      localObject = null;
    if ((localObject != null) && (localObject.getClass() == Boolean.class) && (((Boolean)localObject).booleanValue()))
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    runFunc("onPause", new Object[0]);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    runFunc("onReceive", new Object[] { paramContext, paramIntent });
  }

  protected void onResume()
  {
    super.onResume();
    runFunc("onResume", new Object[0]);
  }

  protected void onStart()
  {
    super.onStart();
    runFunc("onStart", new Object[0]);
    StatService.onPageStart(this, this.I);
  }

  protected void onStop()
  {
    super.onStop();
    runFunc("onStop", new Object[0]);
    StatService.onPageEnd(this, this.I);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.w != null)
      try
      {
        Object localObject = this.w.call(new Object[] { paramMotionEvent });
        if ((localObject != null) && (localObject.getClass() == Boolean.class))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          if (bool)
            return true;
        }
      }
      catch (LuaException localLuaException)
      {
        sendError("onTouchEvent", localLuaException);
      }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void push(int paramInt, String paramString)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localMessage.setData(localBundle);
    localMessage.what = paramInt;
    this.c.sendMessage(localMessage);
  }

  public void push(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localBundle.putSerializable("args", paramArrayOfObject);
    localMessage.setData(localBundle);
    localMessage.what = paramInt;
    this.c.sendMessage(localMessage);
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
    this.H.add(paramLuaGcable);
  }

  public Intent registerReceiver(IntentFilter paramIntentFilter)
  {
    if (this.B != null)
      unregisterReceiver(this.B);
    this.B = new LuaBroadcastReceiver(this);
    return super.registerReceiver(this.B, paramIntentFilter);
  }

  public Intent registerReceiver(LuaBroadcastReceiver.OnReceiveListener paramOnReceiveListener, IntentFilter paramIntentFilter)
  {
    return super.registerReceiver(new LuaBroadcastReceiver(paramOnReceiveListener), paramIntentFilter);
  }

  public Intent registerReceiver(LuaBroadcastReceiver paramLuaBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return super.registerReceiver(paramLuaBroadcastReceiver, paramIntentFilter);
  }

  public void result(Object[] paramArrayOfObject)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("name", getIntent().getStringExtra("name"));
    localIntent.putExtra("data", paramArrayOfObject);
    setResult(0, localIntent);
    finish();
  }

  public Object runFunc(String paramString, Object[] paramArrayOfObject)
  {
    if (this.k != null)
    {
      try
      {
        synchronized (this.k)
        {
          LuaState localLuaState2 = this.k;
          int i1 = 0;
          localLuaState2.setTop(0);
          this.k.pushGlobalTable();
          this.k.pushString(paramString);
          this.k.rawGet(-2);
          if (this.k.isFunction(-1))
          {
            this.k.getGlobal("debug");
            this.k.getField(-1, "traceback");
            this.k.remove(-2);
            this.k.insert(-2);
            int i2 = paramArrayOfObject.length;
            while (i1 < i2)
            {
              this.k.pushObjectValue(paramArrayOfObject[i1]);
              i1++;
            }
            int i3 = this.k.pcall(i2, 1, -2 - i2);
            if (i3 == 0)
            {
              Object localObject2 = this.k.toJavaObject(-1);
              return localObject2;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(a(i3));
            localStringBuilder.append(": ");
            localStringBuilder.append(this.k.toString(-1));
            throw new LuaException(localStringBuilder.toString());
          }
        }
      }
      catch (LuaException localLuaException)
      {
        sendError(paramString, localLuaException);
      }
      throw localObject1;
    }
    return null;
  }

  public void sendError(String paramString, Exception paramException)
  {
    Object localObject = runFunc("onError", new Object[] { paramString, paramException });
    if ((localObject != null) && (localObject.getClass() == Boolean.class) && (((Boolean)localObject).booleanValue()))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramException.getMessage());
    sendMsg(localStringBuilder.toString());
  }

  public void sendMsg(String paramString)
  {
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramString);
    localMessage.setData(localBundle);
    localMessage.what = 0;
    this.c.sendMessage(localMessage);
    Log.i("lua", paramString);
  }

  public void set(String paramString, Object paramObject)
  {
    push(1, paramString, new Object[] { paramObject });
  }

  public void setContentView(LuaObject paramLuaObject)
  {
    setContentView(paramLuaObject, null);
  }

  public void setContentView(LuaObject paramLuaObject1, LuaObject paramLuaObject2)
  {
    LuaObject localLuaObject = this.k.getLuaObject("loadlayout");
    Object[] arrayOfObject;
    if (paramLuaObject1.isString())
    {
      arrayOfObject = new Object[2];
      arrayOfObject[0] = paramLuaObject1.getString();
      arrayOfObject[1] = paramLuaObject2;
    }
    View localView;
    while (true)
    {
      localView = (View)localLuaObject.call(arrayOfObject);
      break;
      if (!paramLuaObject1.isTable())
        break label82;
      arrayOfObject = new Object[] { paramLuaObject1, paramLuaObject2 };
    }
    super.setContentView(localView);
    return;
    label82: throw new LuaException("layout may be table or string.");
  }

  public void setContentView(String paramString)
  {
    setContentView(paramString, null);
  }

  public void setContentView(String paramString, LuaObject paramLuaObject)
  {
    super.setContentView((View)this.k.getLuaObject("loadlayout").call(new Object[] { paramString, paramLuaObject }));
  }

  public void setDebug(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }

  public void setFragment(Fragment paramFragment)
  {
    this.q = true;
    getFragmentManager().beginTransaction().replace(16908290, paramFragment).commit();
  }

  public void setLuaDir(String paramString)
  {
    this.b = paramString;
  }

  public void setLuaExtDir(String paramString)
  {
    if (Environment.getExternalStorageState().equals("mounted"));
    for (String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), paramString).getAbsolutePath(); ; str = getDir(paramString, 0).getAbsolutePath())
    {
      this.A = str;
      break;
      for (File localFile2 : new File("/storage").listFiles())
      {
        String[] arrayOfString = localFile2.list();
        if ((arrayOfString != null) && (arrayOfString.length > 5))
          this.A = new File(localFile2, paramString).getAbsolutePath();
      }
      if (this.A != null)
        break;
    }
    File localFile1 = new File(this.A);
    if (!localFile1.exists())
      localFile1.mkdirs();
  }

  public boolean setSharedData(String paramString, Object paramObject)
  {
    return LuaApplication.getInstance().setSharedData(paramString, paramObject);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    if (Build.VERSION.SDK_INT >= 21)
    {
      ActivityManager.TaskDescription localTaskDescription;
      try
      {
        localTaskDescription = new ActivityManager.TaskDescription(paramCharSequence.toString(), loadBitmap(getLuaPath("icon.png")));
      }
      catch (IOException localIOException)
      {
        a.a(localIOException);
        localTaskDescription = new ActivityManager.TaskDescription(paramCharSequence.toString());
      }
      setTaskDescription(localTaskDescription);
    }
  }

  public void shareFile(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    File localFile = new File(paramString);
    localIntent.setType(a(localFile));
    localIntent.setFlags(1);
    localIntent.putExtra("android.intent.extra.STREAM", getUriForFile(localFile));
    startActivity(Intent.createChooser(localIntent, localFile.getName()));
  }

  @SuppressLint({"ShowToast"})
  public void showToast(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.o != null) && (l1 - this.r <= 1000L))
    {
      this.m.append("\n");
      this.m.append(paramString);
      this.o.setText(this.m.toString());
      this.o.setDuration(1);
    }
    else
    {
      this.m.setLength(0);
      this.o = Toast.makeText(this, paramString, 1);
      this.m.append(paramString);
      this.o.show();
    }
    this.r = l1;
  }

  public ComponentName startService()
  {
    return startService(null, null);
  }

  public ComponentName startService(String paramString)
  {
    return startService(paramString, null);
  }

  public ComponentName startService(String paramString, Object[] paramArrayOfObject)
  {
    Intent localIntent = new Intent(this, LuaService.class);
    localIntent.putExtra("luaDir", this.b);
    localIntent.putExtra("luaPath", this.l);
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (paramString.charAt(0) != '/')
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file://");
        localStringBuilder.append(this.b);
        localStringBuilder.append("/");
        localStringBuilder.append(paramString);
        paramString = ".lua";
      }
      while (true)
      {
        localStringBuilder.append(paramString);
        localIntent.setData(Uri.parse(localStringBuilder.toString()));
        break;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file://");
      }
    }
    if (paramArrayOfObject != null)
      localIntent.putExtra("arg", paramArrayOfObject);
    return super.startService(localIntent);
  }

  public ComponentName startService(Object[] paramArrayOfObject)
  {
    return startService(null, paramArrayOfObject);
  }

  public boolean stopService()
  {
    return stopService(new Intent(this, LuaService.class));
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

  public long test(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    for (int i1 = 0; i1 < paramInt; i1++)
      this.k.LdoString(paramString);
    return System.currentTimeMillis() - l1;
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
          LuaActivity.this.sendError("onTick", localLuaException);
        }
      }
    });
    localTicker.start();
    localTicker.setPeriod(paramLong);
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

  public void unZipAssets(String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString2);
    if (!localFile1.exists())
      localFile1.mkdirs();
    try
    {
      InputStream localInputStream = getAssets().open(paramString1);
      ZipInputStream localZipInputStream = new ZipInputStream(localInputStream);
      ZipEntry localZipEntry = localZipInputStream.getNextEntry();
      byte[] arrayOfByte = new byte[4096];
      while (localZipEntry != null)
      {
        if (localZipEntry.isDirectory())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramString2);
          localStringBuilder1.append(File.separator);
          localStringBuilder1.append(localZipEntry.getName());
          new File(localStringBuilder1.toString()).mkdir();
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramString2);
          localStringBuilder2.append(File.separator);
          localStringBuilder2.append(localZipEntry.getName());
          File localFile2 = new File(localStringBuilder2.toString());
          localFile2.createNewFile();
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
          while (true)
          {
            int i1 = localZipInputStream.read(arrayOfByte);
            if (i1 <= 0)
              break;
            localFileOutputStream.write(arrayOfByte, 0, i1);
          }
          localFileOutputStream.close();
        }
        localZipEntry = localZipInputStream.getNextEntry();
      }
      localZipInputStream.close();
    }
    catch (IOException localIOException)
    {
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
        LuaActivity.this.runFunc(str3, (Object[])localSerializable);
        return;
      case 2:
        String str2 = paramMessage.getData().getString("data");
        LuaActivity.this.runFunc(str2, new Object[0]);
        return;
      case 1:
        Bundle localBundle = paramMessage.getData();
        LuaActivity.a(LuaActivity.this, localBundle.getString("data"), ((Object[])localBundle.getSerializable("args"))[0]);
        return;
      case 0:
      }
      String str1 = paramMessage.getData().getString("data");
      if (LuaActivity.a(LuaActivity.this))
        LuaActivity.this.showToast(str1);
      TextView localTextView = LuaActivity.b(LuaActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append("\n");
      localTextView.append(localStringBuilder.toString());
      LuaActivity.c(LuaActivity.this).add(str1);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaActivity
 * JD-Core Version:    0.6.2
 */