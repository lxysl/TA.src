package bsh;

class BSHForStatement extends SimpleNode
  implements ParserConstants
{
  private SimpleNode a;
  private SimpleNode b;
  private SimpleNode c;
  private SimpleNode d;
  public boolean hasExpression;
  public boolean hasForInit;
  public boolean hasForUpdate;

  BSHForStatement(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    int i;
    if (this.hasForInit)
    {
      this.a = ((SimpleNode)jjtGetChild(0));
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (this.hasExpression)
    {
      int n = i + 1;
      this.b = ((SimpleNode)jjtGetChild(i));
      i = n;
    }
    if (this.hasForUpdate)
    {
      int m = i + 1;
      this.c = ((SimpleNode)jjtGetChild(i));
      i = m;
    }
    if (i < jjtGetNumChildren())
      this.d = ((SimpleNode)jjtGetChild(i));
    NameSpace localNameSpace = paramCallStack.top();
    paramCallStack.swap(new BlockNameSpace(localNameSpace));
    if (this.hasForInit)
      this.a.eval(paramCallStack, paramInterpreter);
    Object localObject2;
    for (Object localObject1 = Primitive.VOID; ; localObject1 = localObject2)
    {
      if ((!this.hasExpression) || (BSHIfStatement.evaluateCondition(this.b, paramCallStack, paramInterpreter)))
      {
        if (this.d != null)
        {
          localObject2 = this.d.eval(paramCallStack, paramInterpreter);
          if ((localObject2 instanceof ReturnControl))
          {
            int k = ((ReturnControl)localObject2).kind;
            if (k != 12)
            {
              if (k == 19)
                break label234;
              if (k != 46)
                break label234;
            }
            else
            {
              localObject2 = localObject1;
            }
            j = 1;
            break label241;
          }
        }
        label234: localObject2 = localObject1;
        int j = 0;
        label241: if (j != 0)
          localObject1 = localObject2;
      }
      else
      {
        paramCallStack.swap(localNameSpace);
        return localObject1;
      }
      if (this.hasForUpdate)
        this.c.eval(paramCallStack, paramInterpreter);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHForStatement
 * JD-Core Version:    0.6.2
 */