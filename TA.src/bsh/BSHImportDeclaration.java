package bsh;

class BSHImportDeclaration extends SimpleNode
{
  public boolean importPackage;
  public boolean staticImport;
  public boolean superImport;

  BSHImportDeclaration(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    NameSpace localNameSpace = paramCallStack.top();
    if (this.superImport)
    {
      try
      {
        localNameSpace.doSuperImport();
      }
      catch (UtilEvalError localUtilEvalError)
      {
        throw localUtilEvalError.toEvalError(this, paramCallStack);
      }
    }
    else if (this.staticImport)
    {
      if (this.importPackage)
        localNameSpace.importStatic(((BSHAmbiguousName)jjtGetChild(0)).toClass(paramCallStack, paramInterpreter));
      else
        throw new EvalError("static field imports not supported yet", this, paramCallStack);
    }
    else
    {
      String str = ((BSHAmbiguousName)jjtGetChild(0)).text;
      if (this.importPackage)
        localNameSpace.importPackage(str);
      else
        localNameSpace.importClass(str);
    }
    return Primitive.VOID;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHImportDeclaration
 * JD-Core Version:    0.6.2
 */