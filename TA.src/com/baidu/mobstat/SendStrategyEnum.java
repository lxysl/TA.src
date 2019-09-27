package com.baidu.mobstat;

public enum SendStrategyEnum
{
  static
  {
    SendStrategyEnum[] arrayOfSendStrategyEnum = new SendStrategyEnum[3];
    arrayOfSendStrategyEnum[0] = APP_START;
    arrayOfSendStrategyEnum[1] = ONCE_A_DAY;
    arrayOfSendStrategyEnum[2] = SET_TIME_INTERVAL;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.SendStrategyEnum
 * JD-Core Version:    0.6.2
 */