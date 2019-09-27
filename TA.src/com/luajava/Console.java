package com.luajava;

import com.a.a.a.a.a.a.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console
{
  public static void main(String[] paramArrayOfString)
  {
    while (true)
    {
      int i;
      try
      {
        LuaState localLuaState = LuaStateFactory.newLuaState();
        localLuaState.openLibs();
        if (paramArrayOfString.length > 0)
        {
          i = 0;
          if (i >= paramArrayOfString.length)
            break;
          int j = localLuaState.LloadFile(paramArrayOfString[i]);
          if (j == 0)
            j = localLuaState.pcall(0, 0, 0);
          if (j != 0)
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("Error on file: ");
            localStringBuilder1.append(paramArrayOfString[i]);
            localStringBuilder1.append(". ");
            localStringBuilder1.append(localLuaState.toString(-1));
            throw new LuaException(localStringBuilder1.toString());
          }
        }
        else
        {
          System.out.println("API Lua Java - console mode.");
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(System.in));
          PrintStream localPrintStream1 = System.out;
          String str1 = "> ";
          localPrintStream1.print(str1);
          String str2 = localBufferedReader.readLine();
          if ((str2 != null) && (!str2.equals("exit")))
          {
            int k = localLuaState.LloadBuffer(str2.getBytes(), "from console");
            if (k == 0)
              k = localLuaState.pcall(0, 0, 0);
            if (k != 0)
            {
              PrintStream localPrintStream2 = System.err;
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("Error on line: ");
              localStringBuilder2.append(str2);
              localPrintStream2.println(localStringBuilder2.toString());
              System.err.println(localLuaState.toString(-1));
            }
            localPrintStream1 = System.out;
            str1 = "> ";
            continue;
          }
          localLuaState.close();
          return;
        }
      }
      catch (Exception localException)
      {
        a.a(localException);
        return;
      }
      i++;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.Console
 * JD-Core Version:    0.6.2
 */