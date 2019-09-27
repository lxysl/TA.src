package com.baidu.mobstat;

public class w
{
  private long a = -1L;
  private String b;
  private String c;

  public w(long paramLong, String paramString1, String paramString2)
  {
    if (paramString2 == null)
      paramString2 = "";
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
  }

  public long a()
  {
    return this.a;
  }

  public String b()
  {
    return this.c;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.w
 * JD-Core Version:    0.6.2
 */