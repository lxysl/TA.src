package bsh;

class BSHWhileStatement extends SimpleNode
  implements ParserConstants
{
  public boolean isDoStatement;

  BSHWhileStatement(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    int i = jjtGetNumChildren();
    SimpleNode localSimpleNode1;
    SimpleNode localSimpleNode2;
    if (this.isDoStatement)
    {
      SimpleNode localSimpleNode3 = (SimpleNode)jjtGetChild(1);
      SimpleNode localSimpleNode4 = (SimpleNode)jjtGetChild(0);
      localSimpleNode1 = localSimpleNode3;
      localSimpleNode2 = localSimpleNode4;
    }
    else
    {
      localSimpleNode1 = (SimpleNode)jjtGetChild(0);
      if (i > 1)
        localSimpleNode2 = (SimpleNode)jjtGetChild(1);
      else
        localSimpleNode2 = null;
    }
    boolean bool = this.isDoStatement;
    while (true)
      if ((bool) || (BSHIfStatement.evaluateCondition(localSimpleNode1, paramCallStack, paramInterpreter)))
      {
        if (localSimpleNode2 != null)
        {
          Object localObject = localSimpleNode2.eval(paramCallStack, paramInterpreter);
          int j;
          if ((localObject instanceof ReturnControl))
          {
            int k = ((ReturnControl)localObject).kind;
            if (k != 12)
            {
              if (k != 19)
                if (k == 46)
                  return localObject;
            }
            else
              j = 1;
          }
          else
          {
            j = 0;
            if (j == 0);
          }
        }
      }
      else
      {
        return Primitive.VOID;
        bool = false;
      }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHWhileStatement
 * JD-Core Version:    0.6.2
 */