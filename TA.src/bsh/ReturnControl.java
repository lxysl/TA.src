package bsh;

class ReturnControl
  implements ParserConstants
{
  public int kind;
  public SimpleNode returnPoint;
  public Object value;

  public ReturnControl(int paramInt, Object paramObject, SimpleNode paramSimpleNode)
  {
    this.kind = paramInt;
    this.value = paramObject;
    this.returnPoint = paramSimpleNode;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ReturnControl
 * JD-Core Version:    0.6.2
 */