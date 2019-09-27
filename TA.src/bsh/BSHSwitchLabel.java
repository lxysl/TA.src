package bsh;

class BSHSwitchLabel extends SimpleNode
{
  boolean a;

  public BSHSwitchLabel(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (this.a)
      return null;
    return ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHSwitchLabel
 * JD-Core Version:    0.6.2
 */