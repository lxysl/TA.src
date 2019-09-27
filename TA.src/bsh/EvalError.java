package bsh;

public class EvalError extends Exception
{
  SimpleNode a;
  String b;
  CallStack c;

  public EvalError(String paramString, SimpleNode paramSimpleNode, CallStack paramCallStack)
  {
    setMessage(paramString);
    this.a = paramSimpleNode;
    if (paramCallStack != null)
      this.c = paramCallStack.copy();
  }

  SimpleNode a()
  {
    return this.a;
  }

  void a(SimpleNode paramSimpleNode)
  {
    this.a = paramSimpleNode;
  }

  protected void a(String paramString)
  {
    if (paramString == null)
      return;
    if (this.b == null);
    while (true)
    {
      this.b = paramString;
      return;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString);
      localStringBuffer.append(" : ");
      localStringBuffer.append(this.b);
      paramString = localStringBuffer.toString();
    }
  }

  public int getErrorLineNumber()
  {
    if (this.a != null)
      return this.a.getLineNumber();
    return -1;
  }

  public String getErrorSourceFile()
  {
    if (this.a != null)
      return this.a.getSourceFile();
    return "<unknown file>";
  }

  public String getErrorText()
  {
    if (this.a != null)
      return this.a.getText();
    return "<unknown error>";
  }

  public String getMessage()
  {
    return this.b;
  }

  public String getScriptStackTrace()
  {
    if (this.c == null)
      return "<Unknown>";
    String str = "";
    CallStack localCallStack = this.c.copy();
    while (true)
    {
      if (localCallStack.depth() <= 0)
        return str;
      NameSpace localNameSpace = localCallStack.pop();
      SimpleNode localSimpleNode = localNameSpace.b();
      if (localNameSpace.c)
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append(str);
        localStringBuffer1.append("\nCalled from method: ");
        localStringBuffer1.append(localNameSpace.getName());
        str = localStringBuffer1.toString();
        if (localSimpleNode != null)
        {
          StringBuffer localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append(str);
          localStringBuffer2.append(" : at Line: ");
          localStringBuffer2.append(localSimpleNode.getLineNumber());
          localStringBuffer2.append(" : in file: ");
          localStringBuffer2.append(localSimpleNode.getSourceFile());
          localStringBuffer2.append(" : ");
          localStringBuffer2.append(localSimpleNode.getText());
          str = localStringBuffer2.toString();
        }
      }
    }
  }

  public void reThrow(String paramString)
  {
    a(paramString);
    throw this;
  }

  public void setMessage(String paramString)
  {
    this.b = paramString;
  }

  public String toString()
  {
    String str;
    if (this.a != null)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(" : at Line: ");
      localStringBuffer1.append(this.a.getLineNumber());
      localStringBuffer1.append(" : in file: ");
      localStringBuffer1.append(this.a.getSourceFile());
      localStringBuffer1.append(" : ");
      localStringBuffer1.append(this.a.getText());
      str = localStringBuffer1.toString();
    }
    else
    {
      str = ": <at unknown location>";
    }
    if (this.c != null)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(str);
      localStringBuffer2.append("\n");
      localStringBuffer2.append(getScriptStackTrace());
      str = localStringBuffer2.toString();
    }
    StringBuffer localStringBuffer3 = new StringBuffer();
    localStringBuffer3.append(getMessage());
    localStringBuffer3.append(str);
    return localStringBuffer3.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.EvalError
 * JD-Core Version:    0.6.2
 */