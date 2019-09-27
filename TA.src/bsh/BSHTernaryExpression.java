package bsh;

class BSHTernaryExpression extends SimpleNode
{
  BSHTernaryExpression(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    SimpleNode localSimpleNode1 = (SimpleNode)jjtGetChild(0);
    SimpleNode localSimpleNode2 = (SimpleNode)jjtGetChild(1);
    SimpleNode localSimpleNode3 = (SimpleNode)jjtGetChild(2);
    if (BSHIfStatement.evaluateCondition(localSimpleNode1, paramCallStack, paramInterpreter))
      return localSimpleNode2.eval(paramCallStack, paramInterpreter);
    return localSimpleNode3.eval(paramCallStack, paramInterpreter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHTernaryExpression
 * JD-Core Version:    0.6.2
 */