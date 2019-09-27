package bsh;

class BSHClassDeclaration extends SimpleNode
{
  String a;
  Modifiers b;
  int c;
  boolean d;
  boolean e;

  BSHClassDeclaration(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    boolean bool = this.d;
    int i = 0;
    int j;
    Class localClass1;
    if (bool)
    {
      Class localClass3 = ((BSHAmbiguousName)jjtGetChild(0)).toClass(paramCallStack, paramInterpreter);
      j = 1;
      localClass1 = localClass3;
    }
    else
    {
      localClass1 = null;
      j = 0;
    }
    Class[] arrayOfClass = new Class[this.c];
    while (true)
    {
      if (i >= this.c)
      {
        if (j < jjtGetNumChildren());
        BSHBlock localBSHBlock2;
        for (BSHBlock localBSHBlock1 = (BSHBlock)jjtGetChild(j); ; localBSHBlock1 = new BSHBlock(25))
        {
          localBSHBlock2 = localBSHBlock1;
          break;
        }
        try
        {
          Class localClass2 = ClassGenerator.getClassGenerator().generateClass(this.a, this.b, arrayOfClass, localClass1, localBSHBlock2, this.e, paramCallStack, paramInterpreter);
          return localClass2;
        }
        catch (UtilEvalError localUtilEvalError)
        {
          throw localUtilEvalError.toEvalError(this, paramCallStack);
        }
      }
      int k = j + 1;
      BSHAmbiguousName localBSHAmbiguousName = (BSHAmbiguousName)jjtGetChild(j);
      arrayOfClass[i] = localBSHAmbiguousName.toClass(paramCallStack, paramInterpreter);
      if (!arrayOfClass[i].isInterface())
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Type: ");
        localStringBuffer.append(localBSHAmbiguousName.text);
        localStringBuffer.append(" is not an interface!");
        throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
      }
      i++;
      j = k;
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ClassDeclaration: ");
    localStringBuffer.append(this.a);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHClassDeclaration
 * JD-Core Version:    0.6.2
 */