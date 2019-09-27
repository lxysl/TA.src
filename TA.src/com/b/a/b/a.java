package com.b.a.b;

import com.androlua.LuaLexer;
import com.androlua.LuaTokenTypes;
import java.io.IOException;

public class a
{
  private static int a(LuaTokenTypes paramLuaTokenTypes)
  {
    switch (1.a[paramLuaTokenTypes.ordinal()])
    {
    default:
      return 0;
    case 8:
    case 9:
    case 10:
      return -1;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    return 1;
  }

  public static int a(CharSequence paramCharSequence)
  {
    LuaLexer localLuaLexer = new LuaLexer(paramCharSequence);
    int i = 0;
    try
    {
      while (true)
      {
        LuaTokenTypes localLuaTokenTypes = localLuaLexer.advance();
        if (localLuaTokenTypes == null)
          return i;
        if (localLuaLexer.yytext().equals("switch"))
        {
          i++;
        }
        else
        {
          int j = a(localLuaTokenTypes);
          i += j;
        }
      }
    }
    catch (IOException localIOException)
    {
      com.a.a.a.a.a.a.a.a(localIOException);
    }
    return i;
  }

  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LuaLexer localLuaLexer = new LuaLexer(paramCharSequence);
    int i = 1;
    int j = 0;
    while (true)
    {
      try
      {
        LuaTokenTypes localLuaTokenTypes = localLuaLexer.advance();
        if (localLuaTokenTypes == null)
          return localStringBuilder;
        if (localLuaTokenTypes == LuaTokenTypes.NEW_LINE)
        {
          if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == ' '))
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          localStringBuilder.append('\n');
          j = Math.max(0, j);
          i = 1;
          continue;
        }
        if (i != 0)
        {
          char[] arrayOfChar;
          switch (1.a[localLuaTokenTypes.ordinal()])
          {
          case 11:
          default:
            arrayOfChar = a(j * paramInt);
            break;
          case 16:
          case 17:
            str = localLuaLexer.yytext();
            localStringBuilder.append(str);
            break;
          case 12:
          case 13:
          case 14:
          case 15:
            localStringBuilder.append(a(j * paramInt - paramInt / 2));
            str = localLuaLexer.yytext();
            break;
          case 8:
          case 9:
          case 10:
          }
          j--;
          localStringBuilder.append(a(j * paramInt));
          String str = localLuaLexer.yytext();
          continue;
          localStringBuilder.append(arrayOfChar);
          localStringBuilder.append(localLuaLexer.yytext());
          j += a(localLuaTokenTypes);
        }
        else
        {
          if (localLuaTokenTypes == LuaTokenTypes.WHITE_SPACE)
          {
            localStringBuilder.append(' ');
            continue;
          }
          localStringBuilder.append(localLuaLexer.yytext());
          int k = a(localLuaTokenTypes);
          j += k;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        com.a.a.a.a.a.a.a.a(localIOException);
        return localStringBuilder;
      }
      i = 0;
    }
  }

  private static char[] a(int paramInt)
  {
    int i = 0;
    if (paramInt < 0)
      return new char[0];
    char[] arrayOfChar = new char[paramInt];
    while (i < paramInt)
    {
      arrayOfChar[i] = ' ';
      i++;
    }
    return arrayOfChar;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.a
 * JD-Core Version:    0.6.2
 */