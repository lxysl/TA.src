package com.b.a.b;

import android.util.Log;
import java.io.PrintStream;

public class q extends Exception
{
  public static void a(String paramString)
  {
    a(false, paramString);
  }

  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      System.err.print("TextWarrior assertion failed: ");
      System.err.println(paramString);
      Log.i("lua", paramString);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.q
 * JD-Core Version:    0.6.2
 */