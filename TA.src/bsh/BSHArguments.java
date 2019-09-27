package bsh;

class BSHArguments extends SimpleNode
{
  BSHArguments(int paramInt)
  {
    super(paramInt);
  }

  public Object[] getArguments(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object[] arrayOfObject = new Object[jjtGetNumChildren()];
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfObject.length)
        return arrayOfObject;
      arrayOfObject[i] = ((SimpleNode)jjtGetChild(i)).eval(paramCallStack, paramInterpreter);
      if (arrayOfObject[i] == Primitive.VOID)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Undefined argument: ");
        localStringBuffer.append(((SimpleNode)jjtGetChild(i)).getText());
        throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHArguments
 * JD-Core Version:    0.6.2
 */