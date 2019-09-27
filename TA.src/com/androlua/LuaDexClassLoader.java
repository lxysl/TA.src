package com.androlua;

import dalvik.system.DexClassLoader;
import java.util.HashMap;

public class LuaDexClassLoader extends DexClassLoader
{
  private HashMap<String, Class<?>> a = new HashMap();
  private String b;

  public LuaDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.b = paramString1;
  }

  protected Class<?> findClass(String paramString)
  {
    Class localClass = (Class)this.a.get(paramString);
    if (localClass == null)
    {
      localClass = super.findClass(paramString);
      this.a.put(paramString, localClass);
    }
    return localClass;
  }

  public String getDexPath()
  {
    return this.b;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaDexClassLoader
 * JD-Core Version:    0.6.2
 */