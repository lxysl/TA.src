package bsh;

class BSHBlock extends SimpleNode
{
  public boolean isSynchronized = false;

  BSHBlock(int paramInt)
  {
    super(paramInt);
  }

  Object a(CallStack paramCallStack, Interpreter paramInterpreter, boolean paramBoolean, NodeFilter paramNodeFilter)
  {
    Object localObject1 = Primitive.VOID;
    NameSpace localNameSpace;
    if (!paramBoolean)
    {
      localNameSpace = paramCallStack.top();
      paramCallStack.swap(new BlockNameSpace(localNameSpace));
    }
    else
    {
      localNameSpace = null;
    }
    int i = this.isSynchronized;
    int j = jjtGetNumChildren();
    int k = i;
    while (true)
    {
      if ((k < j) || (i < j));
      try
      {
        SimpleNode localSimpleNode2 = (SimpleNode)jjtGetChild(i);
        if ((!(localSimpleNode2 instanceof BSHClassDeclaration)) && ((paramNodeFilter == null) || (paramNodeFilter.isVisible(localSimpleNode2))))
        {
          localObject1 = localSimpleNode2.eval(paramCallStack, paramInterpreter);
          boolean bool = localObject1 instanceof ReturnControl;
          if (bool)
            return localObject1;
        }
        i++;
        continue;
        SimpleNode localSimpleNode1 = (SimpleNode)jjtGetChild(k);
        if (((paramNodeFilter == null) || (paramNodeFilter.isVisible(localSimpleNode1))) && ((localSimpleNode1 instanceof BSHClassDeclaration)))
          localSimpleNode1.eval(paramCallStack, paramInterpreter);
        k++;
      }
      finally
      {
        if (!paramBoolean)
          paramCallStack.swap(localNameSpace);
      }
    }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    return eval(paramCallStack, paramInterpreter, false);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter, boolean paramBoolean)
  {
    Object localObject1;
    if (this.isSynchronized)
      localObject1 = ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
    else
      localObject1 = null;
    if (this.isSynchronized)
      try
      {
        Object localObject3 = a(paramCallStack, paramInterpreter, paramBoolean, null);
        return localObject3;
      }
      finally
      {
      }
    return a(paramCallStack, paramInterpreter, paramBoolean, null);
  }

  public static abstract interface NodeFilter
  {
    public abstract boolean isVisible(SimpleNode paramSimpleNode);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHBlock
 * JD-Core Version:    0.6.2
 */