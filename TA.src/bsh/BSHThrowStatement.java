package bsh;

class BSHThrowStatement extends SimpleNode
{
  BSHThrowStatement(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject = ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
    if (!(localObject instanceof Exception))
      throw new EvalError("Expression in 'throw' must be Exception type", this, paramCallStack);
    throw new TargetError((Exception)localObject, this, paramCallStack);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHThrowStatement
 * JD-Core Version:    0.6.2
 */