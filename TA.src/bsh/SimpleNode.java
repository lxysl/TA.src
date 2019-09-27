package bsh;

import java.io.PrintStream;

class SimpleNode
  implements Node
{
  public static SimpleNode JAVACODE = new SimpleNode.1(-1);
  protected Node g;
  protected Node[] h;
  protected int i;
  Token j;
  Token k;
  String l;

  public SimpleNode(int paramInt)
  {
    this.i = paramInt;
  }

  public void dump(String paramString)
  {
    System.out.println(toString(paramString));
    if (this.h != null)
      for (int m = 0; ; m++)
      {
        if (m >= this.h.length)
          return;
        SimpleNode localSimpleNode = (SimpleNode)this.h[m];
        if (localSimpleNode != null)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(paramString);
          localStringBuffer.append(" ");
          localSimpleNode.dump(localStringBuffer.toString());
        }
      }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Unimplemented or inappropriate for ");
    localStringBuffer.append(getClass().getName());
    throw new InterpreterError(localStringBuffer.toString());
  }

  public SimpleNode getChild(int paramInt)
  {
    return (SimpleNode)jjtGetChild(paramInt);
  }

  public int getLineNumber()
  {
    return this.j.beginLine;
  }

  public String getSourceFile()
  {
    if (this.l == null)
    {
      if (this.g != null)
        return ((SimpleNode)this.g).getSourceFile();
      return "<unknown file>";
    }
    return this.l;
  }

  public String getText()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (Token localToken = this.j; localToken != null; localToken = localToken.next)
    {
      localStringBuffer.append(localToken.image);
      if (!localToken.image.equals("."))
        localStringBuffer.append(" ");
      if ((localToken == this.k) || (localToken.image.equals("{")) || (localToken.image.equals(";")))
        break;
    }
    return localStringBuffer.toString();
  }

  public void jjtAddChild(Node paramNode, int paramInt)
  {
    Node[] arrayOfNode;
    if (this.h == null)
      arrayOfNode = new Node[paramInt + 1];
    while (true)
    {
      this.h = arrayOfNode;
      break;
      if (paramInt < this.h.length)
        break;
      arrayOfNode = new Node[paramInt + 1];
      System.arraycopy(this.h, 0, arrayOfNode, 0, this.h.length);
    }
    this.h[paramInt] = paramNode;
  }

  public void jjtClose()
  {
  }

  public Node jjtGetChild(int paramInt)
  {
    return this.h[paramInt];
  }

  public int jjtGetNumChildren()
  {
    if (this.h == null)
      return 0;
    return this.h.length;
  }

  public Node jjtGetParent()
  {
    return this.g;
  }

  public void jjtOpen()
  {
  }

  public void jjtSetParent(Node paramNode)
  {
    this.g = paramNode;
  }

  public void prune()
  {
    jjtSetParent(null);
  }

  public void setSourceFile(String paramString)
  {
    this.l = paramString;
  }

  public String toString()
  {
    return ParserTreeConstants.jjtNodeName[this.i];
  }

  public String toString(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(toString());
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.SimpleNode
 * JD-Core Version:    0.6.2
 */