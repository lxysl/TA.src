package bsh;

class BSHReturnStatement extends SimpleNode
  implements ParserConstants
{
  public int kind;

  BSHReturnStatement(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject;
    if (jjtGetNumChildren() > 0)
      localObject = ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
    else
      localObject = Primitive.VOID;
    return new ReturnControl(this.kind, localObject, this);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHReturnStatement
 * JD-Core Version:    0.6.2
 */