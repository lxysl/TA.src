package bsh;

class BSHAssignment extends SimpleNode
  implements ParserConstants
{
  public int operator;

  BSHAssignment(int paramInt)
  {
    super(paramInt);
  }

  private Object a(Object paramObject1, Object paramObject2, int paramInt)
  {
    if (((paramObject1 instanceof String)) && (paramObject2 != Primitive.VOID))
    {
      if (paramInt != 102)
        throw new UtilEvalError("Use of non + operator with String LHS");
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append((String)paramObject1);
      localStringBuffer2.append(paramObject2);
      return localStringBuffer2.toString();
    }
    boolean bool = paramObject1 instanceof Primitive;
    if ((bool) || ((paramObject2 instanceof Primitive)))
    {
      if ((paramObject1 == Primitive.VOID) || (paramObject2 == Primitive.VOID))
        break label265;
      if ((paramObject1 == Primitive.NULL) || (paramObject2 == Primitive.NULL));
    }
    else
    {
      if (((!(paramObject1 instanceof Boolean)) && (!(paramObject1 instanceof Character)) && (!(paramObject1 instanceof Number)) && (!bool)) || ((!(paramObject2 instanceof Boolean)) && (!(paramObject2 instanceof Character)) && (!(paramObject2 instanceof Number)) && (!(paramObject2 instanceof Primitive))))
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append("Non primitive value in operator: ");
        localStringBuffer1.append(paramObject1.getClass());
        localStringBuffer1.append(" ");
        localStringBuffer1.append(ParserConstants.tokenImage[paramInt]);
        localStringBuffer1.append(" ");
        localStringBuffer1.append(paramObject2.getClass());
        throw new UtilEvalError(localStringBuffer1.toString());
      }
      return Primitive.binaryOperation(paramObject1, paramObject2, paramInt);
    }
    throw new UtilEvalError("Illegal use of null object or 'null' literal");
    label265: throw new UtilEvalError("Illegal use of undefined object or 'void' literal");
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    BSHPrimaryExpression localBSHPrimaryExpression = (BSHPrimaryExpression)jjtGetChild(0);
    if (localBSHPrimaryExpression == null)
      throw new InterpreterError("Error, null LHSnode");
    boolean bool = paramInterpreter.getStrictJava();
    LHS localLHS = localBSHPrimaryExpression.toLHS(paramCallStack, paramInterpreter);
    if (localLHS == null)
      throw new InterpreterError("Error, null LHS");
    int i = this.operator;
    Object localObject1 = null;
    if (i != 81)
      try
      {
        localObject1 = localLHS.getValue();
      }
      catch (UtilEvalError localUtilEvalError2)
      {
        throw localUtilEvalError2.toEvalError(this, paramCallStack);
      }
    Object localObject2 = ((SimpleNode)jjtGetChild(1)).eval(paramCallStack, paramInterpreter);
    if (localObject2 == Primitive.VOID)
      throw new EvalError("Void assignment.", this, paramCallStack);
    try
    {
      int j = this.operator;
      if (j != 81)
      {
        switch (j)
        {
        default:
          throw new InterpreterError("unimplemented operator in assignment BSH");
        case 132:
        case 133:
          return localLHS.assign(a(localObject1, localObject2, 116), bool);
        case 130:
        case 131:
          return localLHS.assign(a(localObject1, localObject2, 114), bool);
        case 128:
        case 129:
          return localLHS.assign(a(localObject1, localObject2, 112), bool);
        case 127:
          return localLHS.assign(a(localObject1, localObject2, 111), bool);
        case 126:
          return localLHS.assign(a(localObject1, localObject2, 110), bool);
        case 124:
        case 125:
          return localLHS.assign(a(localObject1, localObject2, 108), bool);
        case 122:
        case 123:
          return localLHS.assign(a(localObject1, localObject2, 106), bool);
        case 121:
          return localLHS.assign(a(localObject1, localObject2, 105), bool);
        case 120:
          return localLHS.assign(a(localObject1, localObject2, 104), bool);
        case 119:
          return localLHS.assign(a(localObject1, localObject2, 103), bool);
        case 118:
        }
        return localLHS.assign(a(localObject1, localObject2, 102), bool);
      }
      Object localObject3 = localLHS.assign(localObject2, bool);
      return localObject3;
    }
    catch (UtilEvalError localUtilEvalError1)
    {
      throw localUtilEvalError1.toEvalError(this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHAssignment
 * JD-Core Version:    0.6.2
 */