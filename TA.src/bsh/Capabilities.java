package bsh;

import java.util.Hashtable;

public class Capabilities
{
  static Class a;
  private static boolean b;
  private static Hashtable c = new Hashtable();

  static Class a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }

  public static boolean canGenerateInterfaces()
  {
    return classExists("java.lang.reflect.Proxy");
  }

  public static boolean classExists(String paramString)
  {
    Object localObject = c.get(paramString);
    if (localObject == null)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        localObject = localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
      }
      if (localObject != null)
        c.put(localObject, "unused");
    }
    return localObject != null;
  }

  public static boolean haveAccessibility()
  {
    return b;
  }

  public static boolean haveSwing()
  {
    return classExists("javax.swing.JButton");
  }

  public static void setAccessibility(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
      bool = false;
    while (true)
    {
      b = bool;
      return;
      if ((classExists("java.lang.reflect.AccessibleObject")) && (classExists("bsh.reflect.ReflectManagerImpl")))
        try
        {
          Class localClass;
          if (a == null)
          {
            localClass = a("java.lang.String");
            a = localClass;
          }
          else
          {
            localClass = a;
          }
          localClass.getDeclaredMethods();
          bool = true;
        }
        catch (SecurityException localSecurityException)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append("Accessibility unavailable: ");
          localStringBuffer.append(localSecurityException);
          throw new Unavailable(localStringBuffer.toString());
        }
    }
    throw new Unavailable("Accessibility unavailable");
  }

  public static class Unavailable extends UtilEvalError
  {
    public Unavailable(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Capabilities
 * JD-Core Version:    0.6.2
 */