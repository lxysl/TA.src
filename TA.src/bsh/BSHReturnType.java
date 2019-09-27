package bsh;

class BSHReturnType extends SimpleNode
{
  public boolean isVoid;

  BSHReturnType(int paramInt)
  {
    super(paramInt);
  }

  BSHType a()
  {
    return (BSHType)jjtGetChild(0);
  }

  public Class evalReturnType(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (this.isVoid)
      return Void.TYPE;
    return a().getType(paramCallStack, paramInterpreter);
  }

  public String getTypeDescriptor(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    if (this.isVoid)
      return "V";
    return a().getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHReturnType
 * JD-Core Version:    0.6.2
 */