package bsh;

class BSHUnaryExpression extends SimpleNode
  implements ParserConstants
{
  public int kind;
  public boolean postfix = false;

  BSHUnaryExpression(int paramInt)
  {
    super(paramInt);
  }

  private Object a(LHS paramLHS, boolean paramBoolean)
  {
    if (Interpreter.DEBUG)
      Interpreter.debug("lhsUnaryOperation");
    Object localObject1 = paramLHS.getValue();
    Object localObject2 = a(localObject1, this.kind);
    if (!this.postfix)
      localObject1 = localObject2;
    paramLHS.assign(localObject2, paramBoolean);
    return localObject1;
  }

  private Object a(Object paramObject, int paramInt)
  {
    if ((!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Number)))
    {
      if (!(paramObject instanceof Primitive))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Unary operation ");
        localStringBuffer.append(ParserConstants.tokenImage[paramInt]);
        localStringBuffer.append(" inappropriate for object");
        throw new UtilEvalError(localStringBuffer.toString());
      }
      return Primitive.unaryOperation((Primitive)paramObject, paramInt);
    }
    return b(paramObject, paramInt);
  }

  private Object b(Object paramObject, int paramInt)
  {
    Class localClass = paramObject.getClass();
    Object localObject = Primitive.a(paramObject);
    if ((localObject instanceof Boolean))
      return new Boolean(Primitive.a((Boolean)localObject, paramInt));
    if ((localObject instanceof Integer))
    {
      int i = Primitive.a((Integer)localObject, paramInt);
      if ((paramInt == 100) || (paramInt == 101))
      {
        if (localClass == Byte.TYPE)
          return new Byte((byte)i);
        if (localClass == Short.TYPE)
          return new Short((short)i);
        if (localClass == Character.TYPE)
          return new Character((char)i);
      }
      return new Integer(i);
    }
    if ((localObject instanceof Long))
      return new Long(Primitive.a((Long)localObject, paramInt));
    if ((localObject instanceof Float))
      return new Float(Primitive.a((Float)localObject, paramInt));
    if ((localObject instanceof Double))
      return new Double(Primitive.a((Double)localObject, paramInt));
    throw new InterpreterError("An error occurred.  Please call technical support.");
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    SimpleNode localSimpleNode = (SimpleNode)jjtGetChild(0);
    try
    {
      if ((this.kind != 100) && (this.kind != 101))
        return a(localSimpleNode.eval(paramCallStack, paramInterpreter), this.kind);
      Object localObject = a(((BSHPrimaryExpression)localSimpleNode).toLHS(paramCallStack, paramInterpreter), paramInterpreter.getStrictJava());
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHUnaryExpression
 * JD-Core Version:    0.6.2
 */