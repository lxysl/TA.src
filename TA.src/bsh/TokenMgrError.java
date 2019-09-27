package bsh;

public class TokenMgrError extends Error
{
  int a;

  public TokenMgrError()
  {
  }

  public TokenMgrError(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }

  public TokenMgrError(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, char paramChar, int paramInt4)
  {
    this(a(paramBoolean, paramInt1, paramInt2, paramInt3, paramString, paramChar), paramInt4);
  }

  protected static final String a(String paramString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    for (int i = 0; ; i++)
    {
      if (i >= paramString.length())
        return localStringBuffer1.toString();
      int j = paramString.charAt(i);
      if (j != 0)
      {
        String str1;
        if (j != 34)
          if (j != 39)
            if (j != 92)
              switch (j)
              {
              default:
                switch (j)
                {
                default:
                  char c = paramString.charAt(i);
                  if ((c >= ' ') && (c <= '~'))
                  {
                    localStringBuffer1.append(c);
                    continue;
                  }
                  StringBuffer localStringBuffer2 = new StringBuffer();
                  localStringBuffer2.append("0000");
                  localStringBuffer2.append(Integer.toString(c, 16));
                  String str2 = localStringBuffer2.toString();
                  StringBuffer localStringBuffer3 = new StringBuffer();
                  localStringBuffer3.append("\\u");
                  localStringBuffer3.append(str2.substring(-4 + str2.length(), str2.length()));
                  str1 = localStringBuffer3.toString();
                  break;
                case 13:
                  str1 = "\\r";
                  break;
                case 12:
                  str1 = "\\f";
                }
                break;
              case 10:
                str1 = "\\n";
                break;
              case 9:
                str1 = "\\t";
                break;
              case 8:
                str1 = "\\b";
              }
        while (true)
        {
          localStringBuffer1.append(str1);
          break;
          str1 = "\\\\";
          continue;
          str1 = "\\'";
          continue;
          str1 = "\\\"";
        }
      }
    }
  }

  protected static String a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, char paramChar)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Lexical error at line ");
    localStringBuffer1.append(paramInt2);
    localStringBuffer1.append(", column ");
    localStringBuffer1.append(paramInt3);
    localStringBuffer1.append(".  Encountered: ");
    String str;
    if (paramBoolean)
    {
      str = "<EOF> ";
    }
    else
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("\"");
      localStringBuffer2.append(a(String.valueOf(paramChar)));
      localStringBuffer2.append("\"");
      localStringBuffer2.append(" (");
      localStringBuffer2.append(paramChar);
      localStringBuffer2.append("), ");
      str = localStringBuffer2.toString();
    }
    localStringBuffer1.append(str);
    localStringBuffer1.append("after : \"");
    localStringBuffer1.append(a(paramString));
    localStringBuffer1.append("\"");
    return localStringBuffer1.toString();
  }

  public String getMessage()
  {
    return super.getMessage();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.TokenMgrError
 * JD-Core Version:    0.6.2
 */