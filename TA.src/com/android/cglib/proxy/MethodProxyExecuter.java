package com.android.cglib.proxy;

import com.a.a.a.a.a.a.a;
import java.lang.reflect.Method;

public class MethodProxyExecuter
{
  public static final String EXECUTE_INTERCEPTOR = "executeInterceptor";
  public static final String EXECUTE_METHOD = "executeMethod";

  public static Object executeInterceptor(MethodInterceptor paramMethodInterceptor, Class<?> paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramArrayOfObject == null)
      paramArrayOfObject = new Object[0];
    if (paramArrayOfClass == null)
      paramArrayOfClass = new Class[0];
    if (paramMethodInterceptor == null)
      return executeMethod(paramClass, paramString, paramArrayOfClass, paramArrayOfObject, paramObject);
    try
    {
      Object localObject = paramMethodInterceptor.intercept(paramObject, paramArrayOfObject, new MethodProxy(paramClass, paramString, paramArrayOfClass));
      return localObject;
    }
    catch (Exception localException)
    {
      a.a(localException);
      throw new ProxyException(localException.getMessage());
    }
  }

  public static Object executeMethod(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject, Object paramObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_Super");
      Method localMethod = paramClass.getMethod(localStringBuilder.toString(), paramArrayOfClass);
      localMethod.setAccessible(true);
      Object localObject = localMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (Exception localException)
    {
      a.a(localException);
      throw new ProxyException(localException.getCause());
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.proxy.MethodProxyExecuter
 * JD-Core Version:    0.6.2
 */