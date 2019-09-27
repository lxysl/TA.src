package com.baidu.mobstat;

public enum Config$EventViewType
{
  private int a;

  static
  {
    EventViewType[] arrayOfEventViewType = new EventViewType[1];
    arrayOfEventViewType[0] = BUTTON;
  }

  private Config$EventViewType(int paramInt)
  {
    this.a = paramInt;
  }

  public int getValue()
  {
    return this.a;
  }

  public String toString()
  {
    return String.valueOf(this.a);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.Config.EventViewType
 * JD-Core Version:    0.6.2
 */