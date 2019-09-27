package bsh;

class SimpleNode$1 extends SimpleNode
{
  SimpleNode$1(int paramInt)
  {
    super(paramInt);
  }

  public int getLineNumber()
  {
    return -1;
  }

  public String getSourceFile()
  {
    return "<Called from Java Code>";
  }

  public String getText()
  {
    return "<Compiled Java Code>";
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.SimpleNode.1
 * JD-Core Version:    0.6.2
 */