package bsh;

public class ClassIdentifier
{
  Class a;

  public ClassIdentifier(Class paramClass)
  {
    this.a = paramClass;
  }

  public Class getTargetClass()
  {
    return this.a;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Class Identifier: ");
    localStringBuffer.append(this.a.getName());
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ClassIdentifier
 * JD-Core Version:    0.6.2
 */