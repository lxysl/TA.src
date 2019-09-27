package com.android.cglib.proxy;

import java.lang.reflect.Method;

public abstract interface MethodFilter
{
  public abstract boolean filter(Method paramMethod, String paramString);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.proxy.MethodFilter
 * JD-Core Version:    0.6.2
 */