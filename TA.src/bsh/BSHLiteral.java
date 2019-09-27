package bsh;

class BSHLiteral extends SimpleNode
{
  public Object value;

  BSHLiteral(int paramInt)
  {
    super(paramInt);
  }

  private char a(char paramChar)
  {
    if (paramChar != 'b')
    {
      if (paramChar != 'f')
      {
        if (paramChar != 'n')
        {
          if (paramChar != 'r')
          {
            if (paramChar != 't')
              return paramChar;
            return '\t';
          }
          return '\r';
        }
        return '\n';
      }
      return '\f';
    }
    return '\b';
  }

  void a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; ; i++)
    {
      if (i >= paramString.length())
      {
        this.value = localStringBuffer.toString().intern();
        return;
      }
      char c1 = paramString.charAt(i);
      if (c1 == '\\')
      {
        i++;
        char c2 = paramString.charAt(i);
        if (Character.isDigit(c2))
        {
          int k;
          for (int j = i; j < i + 2; j = k)
          {
            k = j + 1;
            if (!Character.isDigit(paramString.charAt(k)))
              break;
          }
          char c3 = (char)Integer.parseInt(paramString.substring(i, j + 1), 8);
          int m = j;
          c1 = c3;
          i = m;
        }
        else
        {
          c1 = a(c2);
        }
      }
      localStringBuffer.append(c1);
    }
  }

  public void charSetup(String paramString)
  {
    char c1 = paramString.charAt(0);
    if (c1 == '\\')
    {
      char c2 = paramString.charAt(1);
      if (Character.isDigit(c2))
        c1 = (char)Integer.parseInt(paramString.substring(1), 8);
      else
        c1 = a(c2);
    }
    this.value = new Primitive(new Character(c1).charValue());
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (this.value == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Null in bsh literal: ");
      localStringBuffer.append(this.value);
      throw new InterpreterError(localStringBuffer.toString());
    }
    return this.value;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHLiteral
 * JD-Core Version:    0.6.2
 */