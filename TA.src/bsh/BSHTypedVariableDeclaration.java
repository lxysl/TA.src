package bsh;

class BSHTypedVariableDeclaration extends SimpleNode
{
  public Modifiers modifiers;

  BSHTypedVariableDeclaration(int paramInt)
  {
    super(paramInt);
  }

  private BSHType b()
  {
    return (BSHType)jjtGetChild(0);
  }

  BSHVariableDeclarator[] a()
  {
    int i = jjtGetNumChildren();
    BSHVariableDeclarator[] arrayOfBSHVariableDeclarator = new BSHVariableDeclarator[i - 1];
    for (int j = 1; ; j++)
    {
      if (j >= i)
        return arrayOfBSHVariableDeclarator;
      arrayOfBSHVariableDeclarator[(j - 1)] = ((BSHVariableDeclarator)jjtGetChild(j));
    }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    try
    {
      NameSpace localNameSpace = paramCallStack.top();
      BSHType localBSHType = b();
      Class localClass = localBSHType.getType(paramCallStack, paramInterpreter);
      BSHVariableDeclarator[] arrayOfBSHVariableDeclarator = a();
      int i = 0;
      while (true)
        if (i < arrayOfBSHVariableDeclarator.length)
        {
          BSHVariableDeclarator localBSHVariableDeclarator = arrayOfBSHVariableDeclarator[i];
          Object localObject = localBSHVariableDeclarator.eval(localBSHType, paramCallStack, paramInterpreter);
          try
          {
            localNameSpace.setTypedVariable(localBSHVariableDeclarator.name, localClass, localObject, this.modifiers);
            i++;
          }
          catch (UtilEvalError localUtilEvalError)
          {
            throw localUtilEvalError.toEvalError(this, paramCallStack);
          }
        }
    }
    catch (EvalError localEvalError)
    {
      localEvalError.reThrow("Typed variable declaration");
    }
    return Primitive.VOID;
  }

  public String getTypeDescriptor(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    return b().getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHTypedVariableDeclaration
 * JD-Core Version:    0.6.2
 */