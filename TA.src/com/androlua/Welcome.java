package com.androlua;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaFunction;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Welcome extends Activity
{
  private boolean a;
  private LuaApplication b;
  private String c;
  private String d;
  private long e;
  private long f;
  private boolean g;
  private String h;
  private String i;
  private ArrayList<String> j;

  private void a(String paramString)
  {
    if (checkCallingOrSelfPermission(paramString) != 0)
      this.j.add(paramString);
  }

  public boolean checkInfo()
  {
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      long l1 = localPackageInfo.lastUpdateTime;
      String str1 = localPackageInfo.versionName;
      SharedPreferences localSharedPreferences = getSharedPreferences("appInfo", 0);
      String str2 = localSharedPreferences.getString("versionName", "");
      if (!str1.equals(str2))
      {
        SharedPreferences.Editor localEditor2 = localSharedPreferences.edit();
        localEditor2.putString("versionName", str1);
        localEditor2.apply();
        this.g = true;
        this.h = str1;
        this.i = str2;
      }
      long l2 = localSharedPreferences.getLong("lastUpdateTime", 0L);
      if (l2 != l1)
      {
        SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
        localEditor1.putLong("lastUpdateTime", l1);
        localEditor1.apply();
        this.a = true;
        this.e = l1;
        this.f = l2;
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      a.a(localNameNotFoundException);
    }
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TextView localTextView = new TextView(this);
    localTextView.setText(new String(new char[] { 80, 111, 119, 101, 114, 101, 100, 32, 98, 121, 32, 65, 110, 100, 111, 76, 117, 97, 43 }));
    localTextView.setTextColor(-7829368);
    localTextView.setGravity(48);
    this.b = ((LuaApplication)getApplication());
    this.c = this.b.d;
    this.d = this.b.a;
    try
    {
      if (new File(this.b.getLuaPath("setup.png")).exists())
        getWindow().setBackgroundDrawable(new LuaBitmapDrawable(this.b, this.b.getLuaPath("setup.png"), getResources().getDrawable(2130771969)));
    }
    catch (Exception localException1)
    {
      a.a(localException1);
    }
    if (checkInfo())
      if (Build.VERSION.SDK_INT < 23);
    while (true)
    {
      int m;
      try
      {
        this.j = new ArrayList();
        String[] arrayOfString1 = getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions;
        int k = arrayOfString1.length;
        m = 0;
        if (m < k)
        {
          String str = arrayOfString1[m];
          try
          {
            a(str);
          }
          catch (Exception localException3)
          {
            a.a(localException3);
          }
        }
        if (!this.j.isEmpty())
        {
          String[] arrayOfString2 = new String[this.j.size()];
          this.j.toArray(arrayOfString2);
          requestPermissions(arrayOfString2, 0);
          return;
        }
      }
      catch (Exception localException2)
      {
        a.a(localException2);
      }
      new UpdateTask(null).execute(new String[0]);
      return;
      startActivity();
      return;
      m++;
    }
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    new UpdateTask(null).execute(new String[0]);
  }

  public void startActivity()
  {
    Intent localIntent = new Intent(this, Main.class);
    if (this.g)
    {
      localIntent.putExtra("isVersionChanged", this.g);
      localIntent.putExtra("newVersionName", this.h);
      localIntent.putExtra("oldVersionName", this.i);
    }
    startActivity(localIntent);
    finish();
  }

  @SuppressLint({"StaticFieldLeak"})
  private class UpdateTask extends AsyncTask<String, String, String>
  {
    private UpdateTask()
    {
    }

    private void a(long paramLong1, long paramLong2)
    {
      LuaState localLuaState = LuaStateFactory.newLuaState();
      localLuaState.openLibs();
      try
      {
        if ((localLuaState.LloadBuffer(LuaUtil.readAsset(Welcome.this, "update.lua"), "update") == 0) && (localLuaState.pcall(0, 0, 0) == 0))
        {
          LuaFunction localLuaFunction = localLuaState.getFunction("onUpdate");
          if (localLuaFunction != null)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Welcome.c(Welcome.this);
            arrayOfObject[1] = Welcome.d(Welcome.this);
            localLuaFunction.call(arrayOfObject);
          }
        }
      }
      catch (Exception localException)
      {
        a.a(localException);
      }
      try
      {
        a("assets", Welcome.e(Welcome.this));
        a("lua", Welcome.f(Welcome.this));
        return;
      }
      catch (IOException localIOException)
      {
        b(localIOException.getMessage());
      }
    }

    private void a(String paramString1, String paramString2)
    {
      int i = 1 + paramString1.length();
      ZipFile localZipFile = new ZipFile(Welcome.this.getApplicationInfo().publicSourceDir);
      Enumeration localEnumeration = localZipFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
        String str1 = localZipEntry.getName();
        if (str1.indexOf(paramString1) == 0)
        {
          String str2 = str1.substring(i);
          if (localZipEntry.isDirectory())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append(paramString2);
            localStringBuilder1.append(File.separator);
            localStringBuilder1.append(str2);
            File localFile1 = new File(localStringBuilder1.toString());
            if (!localFile1.exists())
              localFile1.mkdirs();
          }
          else
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramString2);
            localStringBuilder2.append(File.separator);
            localStringBuilder2.append(str2);
            String str3 = localStringBuilder2.toString();
            File localFile2 = new File(str3);
            File localFile3 = new File(str3).getParentFile();
            if ((!localFile3.exists()) && (!localFile3.mkdirs()))
            {
              StringBuilder localStringBuilder4 = new StringBuilder();
              localStringBuilder4.append("create file ");
              localStringBuilder4.append(localFile3.getName());
              localStringBuilder4.append(" fail");
              throw new RuntimeException(localStringBuilder4.toString());
            }
            try
            {
              if ((localFile2.exists()) && (localZipEntry.getSize() == localFile2.length()))
              {
                boolean bool = LuaUtil.getFileMD5(localZipFile.getInputStream(localZipEntry)).equals(LuaUtil.getFileMD5(localFile2));
                if (!bool);
              }
            }
            catch (NullPointerException localNullPointerException)
            {
              StringBuilder localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append(paramString2);
              localStringBuilder3.append(File.separator);
              localStringBuilder3.append(str2);
              FileOutputStream localFileOutputStream = new FileOutputStream(localStringBuilder3.toString());
              InputStream localInputStream = localZipFile.getInputStream(localZipEntry);
              byte[] arrayOfByte = new byte[4096];
              int j = localInputStream.read(arrayOfByte);
              localFileOutputStream.write(arrayOfByte, 0, j);
              localFileOutputStream.close();
              localInputStream.close();
            }
          }
        }
      }
      localZipFile.close();
    }

    private void b(String paramString)
    {
    }

    protected String a(String[] paramArrayOfString)
    {
      a(Welcome.a(Welcome.this), Welcome.b(Welcome.this));
      return null;
    }

    protected void a(String paramString)
    {
      Welcome.this.startActivity();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.Welcome
 * JD-Core Version:    0.6.2
 */