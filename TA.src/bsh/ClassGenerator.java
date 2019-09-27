package bsh;

public abstract class ClassGenerator
{
  private static ClassGenerator a;

  public static ClassGenerator getClassGenerator()
  {
    if (a == null)
      try
      {
        a = (ClassGenerator)Class.forName("bsh.ClassGeneratorImpl").newInstance();
      }
      catch (Exception localException)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("ClassGenerator unavailable: ");
        localStringBuffer.append(localException);
        throw new Capabilities.Unavailable(localStringBuffer.toString());
      }
    return a;
  }

  public abstract Class generateClass(String paramString, Modifiers paramModifiers, Class[] paramArrayOfClass, Class paramClass, BSHBlock paramBSHBlock, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter);

  public abstract Object invokeSuperclassMethod(BshClassManager paramBshClassManager, Object paramObject, String paramString, Object[] paramArrayOfObject);

  public abstract void setInstanceNameSpaceParent(Object paramObject, String paramString, NameSpace paramNameSpace);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ClassGenerator
 * JD-Core Version:    0.6.2
 */