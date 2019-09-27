package bsh;

class BSHVariableDeclarator extends SimpleNode
{
  public String name;

  BSHVariableDeclarator(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(BSHType paramBSHType, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject;
    if (jjtGetNumChildren() > 0)
    {
      SimpleNode localSimpleNode = (SimpleNode)jjtGetChild(0);
      if ((paramBSHType != null) && ((localSimpleNode instanceof BSHArrayInitializer)))
        localObject = ((BSHArrayInitializer)localSimpleNode).eval(paramBSHType.getBaseType(), paramBSHType.getArrayDims(), paramCallStack, paramInterpreter);
      else
        localObject = localSimpleNode.eval(paramCallStack, paramInterpreter);
    }
    else
    {
      localObject = null;
    }
    if (localObject == Primitive.VOID)
      throw new EvalError("Void initializer.", this, paramCallStack);
    return localObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BSHVariableDeclarator ");
    localStringBuffer.append(this.name);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHVariableDeclarator
 * JD-Core Version:    0.6.2
 */