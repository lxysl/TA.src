package bsh;

import java.io.Serializable;

public class Token
  implements Serializable
{
  public int beginColumn;
  public int beginLine;
  public int endColumn;
  public int endLine;
  public String image;
  public int kind;
  public Token next;
  public Token specialToken;

  public static final Token newToken(int paramInt)
  {
    return new Token();
  }

  public String toString()
  {
    return this.image;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Token
 * JD-Core Version:    0.6.2
 */