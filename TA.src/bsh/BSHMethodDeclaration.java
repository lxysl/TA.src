package bsh;

class BSHMethodDeclaration extends SimpleNode
{
  BSHReturnType a;
  BSHFormalParameters b;
  BSHBlock c;
  int d;
  Class e;
  int f = 0;
  public Modifiers modifiers;
  public String name;

  BSHMethodDeclaration(int paramInt)
  {
    super(paramInt);
  }

  private void b(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    a();
    for (int i = this.d; ; i++)
    {
      if (i >= this.f + this.d)
      {
        this.b.eval(paramCallStack, paramInterpreter);
        if (paramInterpreter.getStrictJava())
          for (int j = 0; ; j++)
          {
            if (j >= this.b.a.length)
            {
              if (this.e != null)
                break;
              StringBuffer localStringBuffer2 = new StringBuffer();
              localStringBuffer2.append("(Strict Java Mode) Undeclared return type for method: ");
              localStringBuffer2.append(this.name);
              throw new EvalError(localStringBuffer2.toString(), this, null);
            }
            if (this.b.a[j] == null)
            {
              StringBuffer localStringBuffer1 = new StringBuffer();
              localStringBuffer1.append("(Strict Java Mode) Undeclared argument type, parameter: ");
              localStringBuffer1.append(this.b.getParamNames()[j]);
              localStringBuffer1.append(" in method: ");
              localStringBuffer1.append(this.name);
              throw new EvalError(localStringBuffer1.toString(), this, null);
            }
          }
        return;
      }
      ((BSHAmbiguousName)jjtGetChild(i)).toClass(paramCallStack, paramInterpreter);
    }
  }

  Class a(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    a();
    if (this.a != null)
      return this.a.evalReturnType(paramCallStack, paramInterpreter);
    return null;
  }

  String a(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    a();
    if (this.a == null)
      return null;
    return this.a.getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
  }

  void a()
  {
    try
    {
      BSHFormalParameters localBSHFormalParameters = this.b;
      if (localBSHFormalParameters != null)
        return;
      Node localNode = jjtGetChild(0);
      this.d = 1;
      if ((localNode instanceof BSHReturnType))
      {
        this.a = ((BSHReturnType)localNode);
        this.b = ((BSHFormalParameters)jjtGetChild(1));
        if (jjtGetNumChildren() > 2 + this.f)
          this.c = ((BSHBlock)jjtGetChild(2 + this.f));
        this.d = (1 + this.d);
      }
      else
      {
        this.b = ((BSHFormalParameters)jjtGetChild(0));
        this.c = ((BSHBlock)jjtGetChild(1 + this.f));
      }
      return;
    }
    finally
    {
    }
  }

  BSHReturnType b()
  {
    a();
    return this.a;
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    this.e = a(paramCallStack, paramInterpreter);
    b(paramCallStack, paramInterpreter);
    NameSpace localNameSpace = paramCallStack.top();
    BshMethod localBshMethod = new BshMethod(this, localNameSpace, this.modifiers);
    try
    {
      localNameSpace.setMethod(this.name, localBshMethod);
      return Primitive.VOID;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("MethodDeclaration: ");
    localStringBuffer.append(this.name);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHMethodDeclaration
 * JD-Core Version:    0.6.2
 */