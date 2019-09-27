package bsh;

class BSHIfStatement extends SimpleNode
{
  BSHIfStatement(int paramInt)
  {
    super(paramInt);
  }

  public static boolean evaluateCondition(SimpleNode paramSimpleNode, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject = paramSimpleNode.eval(paramCallStack, paramInterpreter);
    if ((localObject instanceof Primitive))
    {
      if (localObject == Primitive.VOID)
        throw new EvalError("Condition evaluates to void type", paramSimpleNode, paramCallStack);
      localObject = ((Primitive)localObject).getValue();
    }
    if ((localObject instanceof Boolean))
      return ((Boolean)localObject).booleanValue();
    throw new EvalError("Condition must evaluate to a Boolean or boolean.", paramSimpleNode, paramCallStack);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (evaluateCondition((SimpleNode)jjtGetChild(0), paramCallStack, paramInterpreter));
    for (Node localNode = jjtGetChild(1); ; localNode = jjtGetChild(2))
    {
      localObject = ((SimpleNode)localNode).eval(paramCallStack, paramInterpreter);
      break label57;
      if (jjtGetNumChildren() <= 2)
        break;
    }
    Object localObject = null;
    label57: if ((localObject instanceof ReturnControl))
      return localObject;
    return Primitive.VOID;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHIfStatement
 * JD-Core Version:    0.6.2
 */