package com.baidu.mobstat;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cx
{
  public static String a(File paramFile)
  {
    try
    {
      String str = cw.a(MessageDigest.getInstance("SHA-256"), paramFile);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      cz.b(localNoSuchAlgorithmException);
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str = cw.a(MessageDigest.getInstance("SHA-256"), paramArrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cx
 * JD-Core Version:    0.6.2
 */