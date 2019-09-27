package bsh;

public abstract class ReflectManager
{
  private static ReflectManager a;

  public static boolean RMSetAccessible(Object paramObject)
  {
    return getReflectManager().setAccessible(paramObject);
  }

  public static ReflectManager getReflectManager()
  {
    if (a == null)
      try
      {
        a = (ReflectManager)Class.forName("bsh.reflect.ReflectManagerImpl").newInstance();
      }
      catch (Exception localException)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Reflect Manager unavailable: ");
        localStringBuffer.append(localException);
        throw new Capabilities.Unavailable(localStringBuffer.toString());
      }
    return a;
  }

  public abstract boolean setAccessible(Object paramObject);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ReflectManager
 * JD-Core Version:    0.6.2
 */