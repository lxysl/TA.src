package com.android.cglib.proxy;

import java.lang.reflect.Method;

public class MethodProxy
{
  private Class a;
  private String b;
  private Class[] c;

  public MethodProxy(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramArrayOfClass;
  }

  public String getMethodName()
  {
    return this.b;
  }

  public Method getOriginalMethod()
  {
    try
    {
      Method localMethod = this.a.getMethod(this.b, this.c);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ProxyException(localNoSuchMethodException.getMessage());
    }
  }

  public Method getProxyMethod()
  {
    try
    {
      Class localClass = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("_Super");
      Method localMethod = localClass.getMethod(localStringBuilder.toString(), this.c);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ProxyException(localNoSuchMethodException.getMessage());
    }
  }

  public Object invokeSuper(Object paramObject, Object[] paramArrayOfObject)
  {
    return ((EnhancerInterface)paramObject).executeSuperMethod_Enhancer(this.b, this.c, paramArrayOfObject);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.proxy.MethodProxy
 * JD-Core Version:    0.6.2
 */