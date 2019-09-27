package bsh;

class BSHBinaryExpression extends SimpleNode
  implements ParserConstants
{
  static Class a;
  public int kind;

  BSHBinaryExpression(int paramInt)
  {
    super(paramInt);
  }

  static Class a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }

  private boolean a(Object paramObject)
  {
    return ((paramObject instanceof Primitive)) && (paramObject != Primitive.VOID) && (paramObject != Primitive.NULL);
  }

  private boolean b(Object paramObject)
  {
    return ((paramObject instanceof Boolean)) || ((paramObject instanceof Character)) || ((paramObject instanceof Number));
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject1 = ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
    if (this.kind == 35)
    {
      if (localObject1 == Primitive.NULL)
        return new Primitive(false);
      Class localClass1 = ((BSHType)jjtGetChild(1)).getType(paramCallStack, paramInterpreter);
      if ((localObject1 instanceof Primitive))
      {
        Class localClass2;
        if (a == null)
        {
          localClass2 = a("bsh.Primitive");
          a = localClass2;
        }
        else
        {
          localClass2 = a;
        }
        if (localClass1 == localClass2)
          return new Primitive(true);
        return new Primitive(false);
      }
      return new Primitive(Types.b(localClass1, localObject1.getClass()));
    }
    if ((this.kind == 98) || (this.kind == 99))
    {
      Object localObject2;
      if (a(localObject1))
        localObject2 = ((Primitive)localObject1).getValue();
      else
        localObject2 = localObject1;
      if (((localObject2 instanceof Boolean)) && (!((Boolean)localObject2).booleanValue()))
        return new Primitive(false);
    }
    if ((this.kind == 96) || (this.kind == 97))
    {
      Object localObject3;
      if (a(localObject1))
        localObject3 = ((Primitive)localObject1).getValue();
      else
        localObject3 = localObject1;
      if (((localObject3 instanceof Boolean)) && (((Boolean)localObject3).booleanValue() == true))
        return new Primitive(true);
    }
    boolean bool1 = b(localObject1);
    Object localObject4 = ((SimpleNode)jjtGetChild(1)).eval(paramCallStack, paramInterpreter);
    boolean bool2 = b(localObject4);
    if (((!bool1) && (!a(localObject1))) || ((!bool2) && (!a(localObject4))) || ((bool1) && (bool2) && (this.kind == 90)))
    {
      int i = this.kind;
      if (i != 90)
      {
        if (i != 95)
        {
          if ((i != 102) || ((!(localObject1 instanceof String)) && (!(localObject4 instanceof String))))
          {
            if (((localObject1 instanceof Primitive)) || ((localObject4 instanceof Primitive)))
            {
              if ((localObject1 == Primitive.VOID) || (localObject4 == Primitive.VOID))
                break label509;
              if ((localObject1 == Primitive.NULL) || (localObject4 == Primitive.NULL));
            }
            else
            {
              StringBuffer localStringBuffer2 = new StringBuffer();
              localStringBuffer2.append("Operator: '");
              localStringBuffer2.append(ParserConstants.tokenImage[this.kind]);
              localStringBuffer2.append("' inappropriate for objects");
              throw new EvalError(localStringBuffer2.toString(), this, paramCallStack);
            }
            throw new EvalError("illegal use of null value or 'null' literal", this, paramCallStack);
            label509: throw new EvalError("illegal use of undefined variable, class, or 'void' literal", this, paramCallStack);
          }
          StringBuffer localStringBuffer1 = new StringBuffer();
          localStringBuffer1.append(localObject1.toString());
          localStringBuffer1.append(localObject4.toString());
          return localStringBuffer1.toString();
        }
        boolean bool4 = false;
        if (localObject1 != localObject4)
          bool4 = true;
        return new Primitive(bool4);
      }
      boolean bool3 = false;
      if (localObject1 == localObject4)
        bool3 = true;
      return new Primitive(bool3);
    }
    try
    {
      Object localObject5 = Primitive.binaryOperation(localObject1, localObject4, this.kind);
      return localObject5;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHBinaryExpression
 * JD-Core Version:    0.6.2
 */