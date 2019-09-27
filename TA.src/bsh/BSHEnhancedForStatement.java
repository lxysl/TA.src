package bsh;

class BSHEnhancedForStatement extends SimpleNode
  implements ParserConstants
{
  String a;

  BSHEnhancedForStatement(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    NameSpace localNameSpace = paramCallStack.top();
    Object localObject1 = (SimpleNode)jjtGetChild(0);
    int i = jjtGetNumChildren();
    boolean bool = localObject1 instanceof BSHType;
    Object localObject2 = null;
    SimpleNode localSimpleNode1;
    if (bool)
    {
      Class localClass = ((BSHType)localObject1).getType(paramCallStack, paramInterpreter);
      SimpleNode localSimpleNode2 = (SimpleNode)jjtGetChild(1);
      SimpleNode localSimpleNode3 = null;
      if (i > 2)
        localSimpleNode3 = (SimpleNode)jjtGetChild(2);
      localSimpleNode1 = localSimpleNode3;
      localObject2 = localClass;
      localObject1 = localSimpleNode2;
    }
    else if (i > 1)
    {
      localSimpleNode1 = (SimpleNode)jjtGetChild(1);
      localObject2 = null;
    }
    else
    {
      localSimpleNode1 = null;
    }
    BlockNameSpace localBlockNameSpace = new BlockNameSpace(localNameSpace);
    paramCallStack.swap(localBlockNameSpace);
    Object localObject3 = ((SimpleNode)localObject1).eval(paramCallStack, paramInterpreter);
    if (localObject3 == Primitive.NULL)
      throw new EvalError("The collection, array, map, iterator, or enumeration portion of a for statement cannot be null.", this, paramCallStack);
    CollectionManager localCollectionManager = CollectionManager.getCollectionManager();
    if (!localCollectionManager.isBshIterable(localObject3))
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Can't iterate over type: ");
      localStringBuffer1.append(localObject3.getClass());
      throw new EvalError(localStringBuffer1.toString(), this, paramCallStack);
    }
    BshIterator localBshIterator = localCollectionManager.getBshIterator(localObject3);
    Object localObject4 = Primitive.VOID;
    while (true)
    {
      if ((!localBshIterator.hasNext()) || (localObject2 != null));
      try
      {
        localBlockNameSpace.setTypedVariable(this.a, localObject2, localBshIterator.next(), new Modifiers());
        break label298;
        localBlockNameSpace.setVariable(this.a, localBshIterator.next(), false);
        label298: if (localSimpleNode1 != null)
        {
          localObject5 = localSimpleNode1.eval(paramCallStack, paramInterpreter);
          if ((localObject5 instanceof ReturnControl))
          {
            int k = ((ReturnControl)localObject5).kind;
            if (k != 12)
            {
              if (k == 19)
                break label364;
              if (k != 46)
                break label364;
            }
            else
            {
              localObject5 = localObject4;
            }
            j = 1;
            break label371;
          }
        }
        label364: Object localObject5 = localObject4;
        int j = 0;
        label371: if (j != 0)
        {
          localObject4 = localObject5;
          paramCallStack.swap(localNameSpace);
          return localObject4;
        }
        localObject4 = localObject5;
        continue;
        label396: StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("for loop iterator variable:");
        localStringBuffer2.append(this.a);
        Object localObject6;
        throw localObject6.toEvalError(localStringBuffer2.toString(), this, paramCallStack);
      }
      catch (UtilEvalError localUtilEvalError)
      {
        break label396;
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHEnhancedForStatement
 * JD-Core Version:    0.6.2
 */