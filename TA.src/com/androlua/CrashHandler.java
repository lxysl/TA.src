package com.androlua;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.a.a.a.a.a.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  public static final String TAG = "CrashHandler";
  private static CrashHandler b = new CrashHandler();
  private Thread.UncaughtExceptionHandler a;
  private Context c;
  private Map<String, String> d = new LinkedHashMap();
  private DateFormat e = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

  private boolean a(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return false;
    collectDeviceInfo(this.c);
    b(paramThrowable);
    return true;
  }

  private String b(Throwable paramThrowable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str3 = (String)localEntry.getKey();
      String str4 = (String)localEntry.getValue();
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(str3);
      localStringBuilder3.append("=");
      localStringBuilder3.append(str4);
      localStringBuilder3.append("\n");
      localStringBuffer.append(localStringBuilder3.toString());
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    do
    {
      a.a(paramThrowable, localPrintWriter);
      paramThrowable = paramThrowable.getCause();
    }
    while (paramThrowable != null);
    localPrintWriter.close();
    localStringBuffer.append(localStringWriter.toString());
    try
    {
      long l = System.currentTimeMillis();
      String str1 = this.e.format(new Date());
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("crash-");
      localStringBuilder1.append(str1);
      localStringBuilder1.append("-");
      localStringBuilder1.append(l);
      localStringBuilder1.append(".log");
      String str2 = localStringBuilder1.toString();
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File("/sdcard/androlua/crash/");
        if (!localFile.exists())
          localFile.mkdirs();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("/sdcard/androlua/crash/");
        localStringBuilder2.append(str2);
        FileOutputStream localFileOutputStream = new FileOutputStream(localStringBuilder2.toString());
        localFileOutputStream.write(localStringBuffer.toString().getBytes());
        Log.e("crash", localStringBuffer.toString());
        localFileOutputStream.close();
      }
      return str2;
    }
    catch (Exception localException)
    {
      Log.e("CrashHandler", "an error occured while writing file...", localException);
    }
    return null;
  }

  public static CrashHandler getInstance()
  {
    return b;
  }

  public void collectDeviceInfo(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1);
      if (localPackageInfo != null)
      {
        String str5;
        if (localPackageInfo.versionName == null)
          str5 = "null";
        else
          str5 = localPackageInfo.versionName;
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(localPackageInfo.versionCode);
        localStringBuilder3.append("");
        String str6 = localStringBuilder3.toString();
        this.d.put("versionName", str5);
        this.d.put("versionCode", str6);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("CrashHandler", "an error occured when collect package info", localNameNotFoundException);
    }
    Field[] arrayOfField1 = Build.class.getDeclaredFields();
    int i = arrayOfField1.length;
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      Field localField2 = arrayOfField1[k];
      try
      {
        localField2.setAccessible(true);
        Object localObject2 = localField2.get(null);
        Map localMap2;
        String str3;
        if ((localObject2 instanceof String[]))
        {
          localMap2 = this.d;
          str3 = localField2.getName();
        }
        for (String str4 = Arrays.toString((String[])localObject2); ; str4 = localObject2.toString())
        {
          localMap2.put(str3, str4);
          break;
          localMap2 = this.d;
          str3 = localField2.getName();
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localField2.getName());
        localStringBuilder2.append(" : ");
        localStringBuilder2.append(localField2.get(null));
        Log.d("CrashHandler", localStringBuilder2.toString());
      }
      catch (Exception localException2)
      {
        Log.e("CrashHandler", "an error occured when collect crash info", localException2);
      }
    }
    Field[] arrayOfField2 = Build.VERSION.class.getDeclaredFields();
    int m = arrayOfField2.length;
    while (j < m)
    {
      Field localField1 = arrayOfField2[j];
      try
      {
        localField1.setAccessible(true);
        Object localObject1 = localField1.get(null);
        Map localMap1;
        String str1;
        if ((localObject1 instanceof String[]))
        {
          localMap1 = this.d;
          str1 = localField1.getName();
        }
        for (String str2 = Arrays.toString((String[])localObject1); ; str2 = localObject1.toString())
        {
          localMap1.put(str1, str2);
          break;
          localMap1 = this.d;
          str1 = localField1.getName();
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(localField1.getName());
        localStringBuilder1.append(" : ");
        localStringBuilder1.append(localField1.get(null));
        Log.d("CrashHandler", localStringBuilder1.toString());
      }
      catch (Exception localException1)
      {
        Log.e("CrashHandler", "an error occured when collect crash info", localException1);
      }
      j++;
    }
  }

  public void init(Context paramContext)
  {
    this.c = paramContext;
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!a(paramThrowable)) && (this.a != null))
      this.a.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.CrashHandler
 * JD-Core Version:    0.6.2
 */