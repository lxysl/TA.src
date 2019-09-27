package com.baidu.mobstat;

import android.util.Log;
import com.a.a.a.a.a.a.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class cz
{
  public static int a = 7;

  private static String a()
  {
    return "sdkstat";
  }

  private static void a(int paramInt, String paramString)
  {
    if (a(paramInt))
      Log.println(paramInt, a(), paramString);
  }

  public static void a(String paramString)
  {
    a(3, paramString);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    localStringBuilder.append(d(paramThrowable));
    a(3, localStringBuilder.toString());
  }

  public static void a(Throwable paramThrowable)
  {
    a(3, d(paramThrowable));
  }

  private static boolean a(int paramInt)
  {
    return paramInt >= a;
  }

  public static void b(String paramString)
  {
    a(5, paramString);
  }

  public static void b(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    localStringBuilder.append(d(paramThrowable));
    a(5, localStringBuilder.toString());
  }

  public static void b(Throwable paramThrowable)
  {
    a(5, d(paramThrowable));
  }

  public static void c(String paramString)
  {
    a(6, paramString);
  }

  public static void c(Throwable paramThrowable)
  {
    a(6, d(paramThrowable));
  }

  private static String d(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return "";
    for (Throwable localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause())
      if ((localThrowable instanceof UnknownHostException))
        return "";
    StringWriter localStringWriter = new StringWriter();
    a.a(paramThrowable, new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cz
 * JD-Core Version:    0.6.2
 */