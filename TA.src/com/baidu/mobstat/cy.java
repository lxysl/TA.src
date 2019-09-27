package com.baidu.mobstat;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class cy
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null)
      try
      {
        paramCloseable.close();
        return;
      }
      catch (Throwable localThrowable)
      {
        cz.b(localThrowable);
      }
  }

  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if ((paramInputStream != null) && (paramOutputStream != null))
    {
      byte[] arrayOfByte = new byte[4048];
      try
      {
        while (true)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1)
            return true;
          paramOutputStream.write(arrayOfByte, 0, i);
        }
      }
      catch (IOException localIOException)
      {
        cz.b(localIOException);
      }
    }
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cy
 * JD-Core Version:    0.6.2
 */