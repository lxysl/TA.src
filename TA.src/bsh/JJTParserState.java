package bsh;

import java.util.Stack;

class JJTParserState
{
  private Stack a = new Stack();
  private Stack b = new Stack();
  private int c = 0;
  private int d = 0;
  private boolean e;

  void a()
  {
    this.a.removeAllElements();
    this.b.removeAllElements();
    this.c = 0;
    this.d = 0;
  }

  void a(Node paramNode)
  {
    this.a.push(paramNode);
    this.c = (1 + this.c);
  }

  void a(Node paramNode, int paramInt)
  {
    this.d = ((Integer)this.b.pop()).intValue();
    while (true)
    {
      int i = paramInt - 1;
      if (paramInt <= 0)
      {
        paramNode.jjtClose();
        a(paramNode);
        this.e = true;
        return;
      }
      Node localNode = c();
      localNode.jjtSetParent(paramNode);
      paramNode.jjtAddChild(localNode, i);
      paramInt = i;
    }
  }

  void a(Node paramNode, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = d();
      this.d = ((Integer)this.b.pop()).intValue();
      while (true)
      {
        int j = i - 1;
        if (i <= 0)
        {
          paramNode.jjtClose();
          a(paramNode);
          bool = true;
          break;
        }
        Node localNode = c();
        localNode.jjtSetParent(paramNode);
        paramNode.jjtAddChild(localNode, j);
        i = j;
      }
    }
    this.d = ((Integer)this.b.pop()).intValue();
    boolean bool = false;
    this.e = bool;
  }

  Node b()
  {
    return (Node)this.a.elementAt(0);
  }

  void b(Node paramNode)
  {
    while (true)
    {
      if (this.c <= this.d)
      {
        this.d = ((Integer)this.b.pop()).intValue();
        return;
      }
      c();
    }
  }

  Node c()
  {
    int i = -1 + this.c;
    this.c = i;
    if (i < this.d)
      this.d = ((Integer)this.b.pop()).intValue();
    return (Node)this.a.pop();
  }

  void c(Node paramNode)
  {
    this.b.push(new Integer(this.d));
    this.d = this.c;
    paramNode.jjtOpen();
  }

  int d()
  {
    return this.c - this.d;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.JJTParserState
 * JD-Core Version:    0.6.2
 */