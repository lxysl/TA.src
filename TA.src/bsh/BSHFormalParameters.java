package bsh;

class BSHFormalParameters extends SimpleNode
{
  Class[] a;
  int b;
  String[] c;
  private String[] d;

  BSHFormalParameters(int paramInt)
  {
    super(paramInt);
  }

  void a()
  {
    if (this.d != null)
      return;
    this.b = jjtGetNumChildren();
    String[] arrayOfString = new String[this.b];
    for (int i = 0; ; i++)
    {
      if (i >= this.b)
      {
        this.d = arrayOfString;
        return;
      }
      arrayOfString[i] = ((BSHFormalParameter)jjtGetChild(i)).name;
    }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (this.a != null)
      return this.a;
    a();
    Class[] arrayOfClass = new Class[this.b];
    for (int i = 0; ; i++)
    {
      if (i >= this.b)
      {
        this.a = arrayOfClass;
        return arrayOfClass;
      }
      arrayOfClass[i] = ((Class)((BSHFormalParameter)jjtGetChild(i)).eval(paramCallStack, paramInterpreter));
    }
  }

  public String[] getParamNames()
  {
    a();
    return this.d;
  }

  public String[] getTypeDescriptors(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    if (this.c != null)
      return this.c;
    a();
    String[] arrayOfString = new String[this.b];
    for (int i = 0; ; i++)
    {
      if (i >= this.b)
      {
        this.c = arrayOfString;
        return arrayOfString;
      }
      arrayOfString[i] = ((BSHFormalParameter)jjtGetChild(i)).getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHFormalParameters
 * JD-Core Version:    0.6.2
 */