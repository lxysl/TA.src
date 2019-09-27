package com.androlua;

public class ZipUtil
{
  // ERROR //
  public static boolean unzip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 18	com/androlua/LuaUtil:unZip	(Ljava/lang/String;Ljava/lang/String;)V
    //   5: iconst_1
    //   6: ireturn
    //   7: iconst_0
    //   8: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	7	java/io/IOException
  }

  public static boolean zip(String paramString1, String paramString2)
  {
    return LuaUtil.zip(paramString1, paramString2);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.ZipUtil
 * JD-Core Version:    0.6.2
 */