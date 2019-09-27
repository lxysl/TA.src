package bsh;

public class ParseException extends EvalError
{
  public Token currentToken;
  String d = "<unknown>";
  protected boolean e = false;
  public int[][] expectedTokenSequences;
  protected String f = System.getProperty("line.separator", "\n");
  public String[] tokenImage;

  public ParseException()
  {
    this("");
    this.e = false;
  }

  public ParseException(Token paramToken, int[][] paramArrayOfInt, String[] paramArrayOfString)
  {
    this();
    this.e = true;
    this.currentToken = paramToken;
    this.expectedTokenSequences = paramArrayOfInt;
    this.tokenImage = paramArrayOfString;
  }

  public ParseException(String paramString)
  {
    super(paramString, null, null);
  }

  protected String b(String paramString)
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

  public int getErrorLineNumber()
  {
    return this.currentToken.next.beginLine;
  }

  public String getErrorSourceFile()
  {
    return this.d;
  }

  public String getErrorText()
  {
    int i = 0;
    int j = 0;
    while (true)
    {
      if (i >= this.expectedTokenSequences.length)
      {
        Token localToken = this.currentToken.next;
        String str = "";
        for (int k = 0; ; k++)
        {
          if (k >= j)
            return str;
          if (k != 0)
          {
            StringBuffer localStringBuffer1 = new StringBuffer();
            localStringBuffer1.append(str);
            localStringBuffer1.append(" ");
            str = localStringBuffer1.toString();
          }
          if (localToken.kind == 0)
          {
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append(str);
            localStringBuffer2.append(this.tokenImage[0]);
            return localStringBuffer2.toString();
          }
          StringBuffer localStringBuffer3 = new StringBuffer();
          localStringBuffer3.append(str);
          localStringBuffer3.append(b(localToken.image));
          str = localStringBuffer3.toString();
          localToken = localToken.next;
        }
      }
      if (j < this.expectedTokenSequences[i].length)
        j = this.expectedTokenSequences[i].length;
      i++;
    }
  }

  public String getMessage()
  {
    return getMessage(false);
  }

  public String getMessage(boolean paramBoolean)
  {
    if (!this.e)
      return super.getMessage();
    String str1 = "";
    int i = 0;
    int j = 0;
    if (i >= this.expectedTokenSequences.length)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("In file: ");
      localStringBuffer1.append(this.d);
      localStringBuffer1.append(" Encountered \"");
      String str2 = localStringBuffer1.toString();
      Token localToken = this.currentToken.next;
      String str3 = str2;
      for (int k = 0; ; k++)
      {
        if (k < j)
        {
          if (k != 0)
          {
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append(str3);
            localStringBuffer2.append(" ");
            str3 = localStringBuffer2.toString();
          }
          if (localToken.kind == 0)
          {
            StringBuffer localStringBuffer3 = new StringBuffer();
            localStringBuffer3.append(str3);
            localStringBuffer3.append(this.tokenImage[0]);
            str3 = localStringBuffer3.toString();
          }
        }
        else
        {
          StringBuffer localStringBuffer4 = new StringBuffer();
          localStringBuffer4.append(str3);
          localStringBuffer4.append("\" at line ");
          localStringBuffer4.append(this.currentToken.next.beginLine);
          localStringBuffer4.append(", column ");
          localStringBuffer4.append(this.currentToken.next.beginColumn);
          localStringBuffer4.append(".");
          localStringBuffer4.append(this.f);
          String str4 = localStringBuffer4.toString();
          if (paramBoolean)
          {
            StringBuffer localStringBuffer5;
            if (this.expectedTokenSequences.length == 1)
            {
              localStringBuffer5 = new StringBuffer();
              localStringBuffer5.append(str4);
            }
            String str6;
            for (String str5 = "Was expecting:"; ; str5 = "Was expecting one of:")
            {
              localStringBuffer5.append(str5);
              localStringBuffer5.append(this.f);
              localStringBuffer5.append("    ");
              str6 = localStringBuffer5.toString();
              break;
              localStringBuffer5 = new StringBuffer();
              localStringBuffer5.append(str4);
            }
            StringBuffer localStringBuffer6 = new StringBuffer();
            localStringBuffer6.append(str6);
            localStringBuffer6.append(str1);
            str4 = localStringBuffer6.toString();
          }
          return str4;
        }
        StringBuffer localStringBuffer7 = new StringBuffer();
        localStringBuffer7.append(str3);
        localStringBuffer7.append(b(localToken.image));
        str3 = localStringBuffer7.toString();
        localToken = localToken.next;
      }
    }
    if (j < this.expectedTokenSequences[i].length)
      j = this.expectedTokenSequences[i].length;
    String str7 = str1;
    for (int m = 0; ; m++)
    {
      if (m >= this.expectedTokenSequences[i].length)
      {
        if (this.expectedTokenSequences[i][(this.expectedTokenSequences[i].length - 1)] != 0)
        {
          StringBuffer localStringBuffer9 = new StringBuffer();
          localStringBuffer9.append(str7);
          localStringBuffer9.append("...");
          str7 = localStringBuffer9.toString();
        }
        StringBuffer localStringBuffer10 = new StringBuffer();
        localStringBuffer10.append(str7);
        localStringBuffer10.append(this.f);
        localStringBuffer10.append("    ");
        str1 = localStringBuffer10.toString();
        i++;
        break;
      }
      StringBuffer localStringBuffer8 = new StringBuffer();
      localStringBuffer8.append(str7);
      localStringBuffer8.append(this.tokenImage[this.expectedTokenSequences[i][m]]);
      localStringBuffer8.append(" ");
      str7 = localStringBuffer8.toString();
    }
  }

  public void setErrorSourceFile(String paramString)
  {
    this.d = paramString;
  }

  public String toString()
  {
    return getMessage();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ParseException
 * JD-Core Version:    0.6.2
 */