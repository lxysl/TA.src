package com.android.cglib.proxy;

public abstract interface EnhancerInterface
{
  public static final String EXECUTE_SUPER_METHOD_ENHANCER = "executeSuperMethod_Enhancer";
  public static final String SET_METHOD_INTERCEPTOR_ENHANCER = "setMethodInterceptor_Enhancer";

  public abstract Object executeSuperMethod_Enhancer(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject);

  public abstract void setMethodInterceptor_Enhancer(MethodInterceptor paramMethodInterceptor);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.proxy.EnhancerInterface
 * JD-Core Version:    0.6.2
 */