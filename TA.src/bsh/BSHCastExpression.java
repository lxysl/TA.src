package bsh;

class BSHCastExpression extends SimpleNode
{
  public BSHCastExpression(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    paramCallStack.top();
    Class localClass = ((BSHType)jjtGetChild(0)).getType(paramCallStack, paramInterpreter);
    Object localObject1 = ((SimpleNode)jjtGetChild(1)).eval(paramCallStack, paramInterpreter);
    localObject1.getClass();
    try
    {
      Object localObject2 = Types.castObject(localObject1, localClass, 0);
      return localObject2;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHCastExpression
 * JD-Core Version:    0.6.2
 */