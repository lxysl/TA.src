package bsh;

class BSHFormalParameter extends SimpleNode
{
  public static final Class UNTYPED;
  public String name;
  public Class type;

  BSHFormalParameter(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (jjtGetNumChildren() > 0);
    for (Class localClass = ((BSHType)jjtGetChild(0)).getType(paramCallStack, paramInterpreter); ; localClass = UNTYPED)
    {
      this.type = localClass;
      break;
    }
    return this.type;
  }

  public String getTypeDescriptor(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    if (jjtGetNumChildren() > 0)
      return ((BSHType)jjtGetChild(0)).getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
    return "Ljava/lang/Object;";
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHFormalParameter
 * JD-Core Version:    0.6.2
 */