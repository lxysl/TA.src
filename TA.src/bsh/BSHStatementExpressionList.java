package bsh;

class BSHStatementExpressionList extends SimpleNode
{
  BSHStatementExpressionList(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    int i = jjtGetNumChildren();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return Primitive.VOID;
      ((SimpleNode)jjtGetChild(j)).eval(paramCallStack, paramInterpreter);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHStatementExpressionList
 * JD-Core Version:    0.6.2
 */