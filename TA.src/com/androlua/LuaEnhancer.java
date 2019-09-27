package com.androlua;

import com.a.a.a.a.a.a.a;
import com.android.cglib.proxy.Enhancer;
import com.android.cglib.proxy.EnhancerInterface;
import com.android.cglib.proxy.MethodFilter;
import com.android.cglib.proxy.MethodInterceptor;

public class LuaEnhancer
{
  private Enhancer a = new Enhancer(LuaApplication.getInstance());

  public LuaEnhancer(Class<?> paramClass)
  {
    this.a.setSuperclass(paramClass);
  }

  public LuaEnhancer(String paramString)
  {
    this(Class.forName(paramString));
  }

  public Class<?> create()
  {
    try
    {
      Class localClass = this.a.create();
      return localClass;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
    return null;
  }

  public Class<?> create(MethodFilter paramMethodFilter)
  {
    try
    {
      this.a.setMethodFilter(paramMethodFilter);
      Class localClass = this.a.create();
      return localClass;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
    return null;
  }

  public void setInterceptor(EnhancerInterface paramEnhancerInterface, MethodInterceptor paramMethodInterceptor)
  {
    paramEnhancerInterface.setMethodInterceptor_Enhancer(paramMethodInterceptor);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaEnhancer
 * JD-Core Version:    0.6.2
 */