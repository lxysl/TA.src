package com.androlua;

import java.io.IOException;
import java.io.Reader;

public class LuaLexer
{
  public static final int YYEOF = -1;
  public static final int YYINITIAL = 0;
  private static final int[] a = { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
  private static final char[] b = a("");
  private static final int[] c = a();
  private static final int[] d = b();
  private static final int[] e = c();
  private static final String[] f = { "Unknown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
  private static final int[] g = d();
  public static final int xBLOCK_COMMENT = 12;
  public static final int xBLOCK_STRING = 8;
  public static final int xCOMMENT = 10;
  public static final int xDOUBLE_QUOTED_STRING = 4;
  public static final int xSHEBANG = 2;
  public static final int xSINGLE_QUOTED_STRING = 6;
  private Reader h;
  private int i;
  private int j = 0;
  private char[] k = new char[16384];
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private boolean s = true;
  private boolean t;
  private boolean u;
  private int v = 0;
  private int w = 0;

  public LuaLexer(Reader paramReader)
  {
    this.h = paramReader;
  }

  public LuaLexer(CharSequence paramCharSequence)
  {
    this(new CharSeqReader(paramCharSequence));
  }

  private static int a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = paramString.length();
    int i2 = 0;
    if (i2 < i1)
    {
      int i3 = i2 + 1;
      int i4 = paramString.charAt(i2);
      int i5 = i3 + 1;
      int i6 = paramString.charAt(i3);
      while (true)
      {
        int i7 = paramInt + 1;
        paramArrayOfInt[paramInt] = i6;
        i4--;
        if (i4 <= 0)
        {
          i2 = i5;
          paramInt = i7;
          break;
        }
        paramInt = i7;
      }
    }
    return paramInt;
  }

  // ERROR //
  private void a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 83	com/androlua/LuaLexer:f	[Ljava/lang/String;
    //   3: iload_1
    //   4: aaload
    //   5: astore_2
    //   6: goto +9 -> 15
    //   9: getstatic 83	com/androlua/LuaLexer:f	[Ljava/lang/String;
    //   12: iconst_0
    //   13: aaload
    //   14: astore_2
    //   15: new 124	java/lang/Error
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 127	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	9	java/lang/ArrayIndexOutOfBoundsException
  }

  private boolean a(char paramChar, int paramInt)
  {
    if (paramInt + this.l >= this.k.length)
      return false;
    char c1 = this.k[(paramInt + this.l)];
    boolean bool = false;
    if (c1 == paramChar)
      bool = true;
    return bool;
  }

  private static char[] a(String paramString)
  {
    char[] arrayOfChar = new char[1114112];
    int i1 = 0;
    int i2 = 0;
    if (i1 < 2884)
    {
      int i3 = i1 + 1;
      int i4 = paramString.charAt(i1);
      int i5 = i3 + 1;
      int i6 = paramString.charAt(i3);
      while (true)
      {
        int i7 = i2 + 1;
        arrayOfChar[i2] = i6;
        i4--;
        if (i4 <= 0)
        {
          i1 = i5;
          i2 = i7;
          break;
        }
        i2 = i7;
      }
    }
    return arrayOfChar;
  }

  private static int[] a()
  {
    int[] arrayOfInt = new int['à'];
    a("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private static int b(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = paramString.length();
    int i6;
    for (int i2 = 0; i2 < i1; i2 = i6)
    {
      int i3 = i2 + 1;
      int i4 = paramString.charAt(i2) << '\020';
      int i5 = paramInt + 1;
      i6 = i3 + 1;
      paramArrayOfInt[paramInt] = (i4 | paramString.charAt(i3));
      paramInt = i5;
    }
    return paramInt;
  }

  private static int[] b()
  {
    int[] arrayOfInt = new int['à'];
    b("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private static int c(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = paramString.length();
    int i2 = 0;
    if (i2 < i1)
    {
      int i3 = i2 + 1;
      int i4 = paramString.charAt(i2);
      int i5 = i3 + 1;
      int i6 = '����' + paramString.charAt(i3);
      while (true)
      {
        int i7 = paramInt + 1;
        paramArrayOfInt[paramInt] = i6;
        i4--;
        if (i4 <= 0)
        {
          i2 = i5;
          paramInt = i7;
          break;
        }
        paramInt = i7;
      }
    }
    return paramInt;
  }

  private static int[] c()
  {
    int[] arrayOfInt = new int[9796];
    c("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private static int d(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = paramString.length();
    int i2 = 0;
    if (i2 < i1)
    {
      int i3 = i2 + 1;
      int i4 = paramString.charAt(i2);
      int i5 = i3 + 1;
      int i6 = paramString.charAt(i3);
      while (true)
      {
        int i7 = paramInt + 1;
        paramArrayOfInt[paramInt] = i6;
        i4--;
        if (i4 <= 0)
        {
          i2 = i5;
          paramInt = i7;
          break;
        }
        paramInt = i7;
      }
    }
    return paramInt;
  }

  private static int[] d()
  {
    int[] arrayOfInt = new int['à'];
    d("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private boolean e()
  {
    this.w = 0;
    boolean bool1 = a('[', 0);
    boolean bool2 = false;
    if (bool1)
    {
      int i2;
      for (int i1 = 0; ; i1 = i2)
      {
        i2 = i1 + 1;
        if (!a('=', i2))
          break;
      }
      boolean bool3 = a('[', i2);
      bool2 = false;
      if (bool3)
      {
        this.w = i1;
        bool2 = true;
      }
    }
    return bool2;
  }

  private int f()
  {
    String str = yytext().toString();
    StringBuilder localStringBuilder = new StringBuilder("]");
    for (int i1 = 0; i1 < this.w; i1++)
      localStringBuilder.append('=');
    localStringBuilder.append(']');
    int i2 = str.indexOf(localStringBuilder.toString());
    if (i2 > 0)
      return -2 + (yylength() - i2 - this.w);
    return -1;
  }

  private boolean g()
  {
    if (this.n > 0)
    {
      this.o += this.v;
      this.v = 0;
      System.arraycopy(this.k, this.n, this.k, 0, this.o - this.n);
      this.o -= this.n;
      this.m -= this.n;
      this.l -= this.n;
      this.n = 0;
    }
    if (this.m >= this.k.length - this.v)
    {
      char[] arrayOfChar = new char[2 * this.k.length];
      System.arraycopy(this.k, 0, arrayOfChar, 0, this.k.length);
      this.k = arrayOfChar;
      this.o += this.v;
      this.v = 0;
    }
    int i1 = this.k.length - this.o;
    int i2 = this.h.read(this.k, this.o, i1);
    if (i2 == 0)
      throw new IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    if (i2 > 0)
    {
      this.o = (i2 + this.o);
      if ((i2 == i1) && (Character.isHighSurrogate(this.k[(this.o - 1)])))
      {
        this.o -= 1;
        this.v = 1;
      }
      return false;
    }
    return true;
  }

  public LuaTokenTypes advance()
  {
    int i1 = this.o;
    Object localObject1 = this.k;
    char[] arrayOfChar1 = b;
    int[] arrayOfInt1 = e;
    int[] arrayOfInt2 = d;
    int[] arrayOfInt3 = g;
    int i2 = this.l;
    this.q += i2 - this.n;
    int i3 = this.n;
    int i4 = 0;
    while (i3 < i2)
    {
      int i21 = Character.codePointAt((char[])localObject1, i3, i2);
      int i22 = Character.charCount(i21);
      if (i21 != 133)
        switch (i21)
        {
        default:
          switch (i21)
          {
          default:
            this.r = (i22 + this.r);
          case 8232:
          case 8233:
          }
          break;
        case 13:
        case 10:
        case 11:
        case 12:
        }
      while (true)
      {
        i4 = 0;
        break;
        this.p = (1 + this.p);
        this.r = 0;
        i4 = 1;
        break;
        if (i4 == 0)
        {
          this.p = (1 + this.p);
          this.r = 0;
          break;
          this.p = (1 + this.p);
          this.r = 0;
        }
      }
      i3 += i22;
    }
    if (i4 != 0)
    {
      int i18;
      int i19;
      Object localObject2;
      if (i2 < i1)
      {
        int i20;
        if (localObject1[i2] == '\n')
          i20 = 1;
        else
          i20 = 0;
        Object localObject3 = localObject1;
        i18 = i1;
        i19 = i20;
        localObject2 = localObject3;
      }
      else
      {
        if (this.t)
        {
          localObject2 = localObject1;
          i18 = i1;
        }
        boolean bool2;
        do
        {
          i19 = 0;
          break;
          bool2 = g();
          i18 = this.o;
          i2 = this.l;
          localObject2 = this.k;
        }
        while ((bool2) || (localObject2[i2] != '\n'));
        i19 = 1;
      }
      if (i19 != 0)
        this.p -= 1;
      i1 = i18;
      localObject1 = localObject2;
    }
    this.n = i2;
    this.m = i2;
    this.i = a[this.j];
    int i6;
    label414: int i5;
    if ((0x1 & arrayOfInt3[this.i]) == 1)
    {
      i6 = this.i;
      i5 = i2;
    }
    else
    {
      i5 = i2;
      i6 = -1;
    }
    label1889: 
    while (true)
    {
      int i11;
      if (i2 < i1)
      {
        i11 = Character.codePointAt((char[])localObject1, i2, i1);
        i2 += Character.charCount(i11);
      }
      else
      {
        if (this.t);
        int i7;
        char[] arrayOfChar2;
        int i8;
        while (true)
        {
          i11 = -1;
          break label629;
          this.m = i2;
          this.l = i5;
          boolean bool1 = g();
          i7 = this.m;
          i5 = this.l;
          arrayOfChar2 = this.k;
          i8 = this.o;
          if (!bool1)
            break;
          localObject1 = arrayOfChar2;
          i1 = i8;
        }
        int i9 = Character.codePointAt(arrayOfChar2, i7, i8);
        int i10 = i7 + Character.charCount(i9);
        i11 = i9;
        i1 = i8;
        i2 = i10;
        localObject1 = arrayOfChar2;
      }
      int i12 = arrayOfInt1[(arrayOfInt2[this.i] + arrayOfChar1[i11])];
      if (i12 != -1)
      {
        this.i = i12;
        int i13 = arrayOfInt3[this.i];
        if ((i13 & 0x1) != 1)
          break label1889;
        i6 = this.i;
        if ((i13 & 0x8) == 8)
          i5 = i2;
      }
      else
      {
        label629: this.l = i5;
        if ((i11 == -1) && (this.n == this.m))
        {
          this.t = true;
          return null;
        }
        if (i6 >= 0)
          i6 = c[i6];
        int i15;
        switch (i6)
        {
        case 85:
        case 86:
        case 87:
        case 88:
        case 89:
        case 90:
        case 91:
        case 92:
        case 93:
        case 94:
        case 95:
        case 96:
        case 97:
        case 98:
        case 99:
        case 100:
        case 101:
        case 102:
        case 103:
        case 104:
        case 105:
        case 106:
        case 107:
        case 108:
        case 109:
        case 110:
        case 111:
        case 112:
        case 113:
        case 114:
        case 115:
        case 116:
        case 117:
        case 118:
        case 119:
        case 120:
        case 121:
        case 122:
        case 123:
        case 124:
        case 125:
        case 126:
        case 127:
        case 128:
        case 129:
        case 130:
        case 131:
        case 132:
        case 133:
        case 134:
        case 135:
        case 136:
        case 137:
        case 138:
        case 139:
        case 140:
        case 141:
        case 142:
        case 143:
        case 144:
        case 145:
        case 146:
        case 147:
        case 148:
        case 149:
        case 150:
        case 151:
        case 152:
        case 153:
        case 154:
        case 155:
        case 156:
        case 157:
        case 158:
        case 159:
        case 160:
        case 161:
        case 162:
        case 163:
        case 164:
        case 165:
        case 166:
        case 167:
        case 168:
        default:
          a(1);
          break;
        case 84:
          return LuaTokenTypes.ENDREGION;
        case 83:
          return LuaTokenTypes.CONTINUE;
        case 82:
          return LuaTokenTypes.FUNCTION;
        case 81:
          return LuaTokenTypes.REGION;
        case 80:
          return LuaTokenTypes.DEFAULT;
        case 79:
          return LuaTokenTypes.SWITCH;
        case 78:
          return LuaTokenTypes.LAMBDA;
        case 77:
          return LuaTokenTypes.ELSEIF;
        case 76:
          return LuaTokenTypes.REPEAT;
        case 75:
          return LuaTokenTypes.RETURN;
        case 74:
          return LuaTokenTypes.WHILE;
        case 73:
          return LuaTokenTypes.UNTIL;
        case 72:
          return LuaTokenTypes.FALSE;
        case 71:
          return LuaTokenTypes.LOCAL;
        case 70:
          return LuaTokenTypes.BREAK;
        case 69:
          return LuaTokenTypes.DEFER;
        case 68:
          int i17 = f();
          if (i17 != -1)
          {
            yypushback(i17);
            yybegin(0);
            return LuaTokenTypes.BLOCK_COMMENT;
          }
          yybegin(0);
          return LuaTokenTypes.BLOCK_COMMENT;
        case 67:
          int i16 = f();
          if (i16 != -1)
          {
            yypushback(i16);
            yybegin(0);
            return LuaTokenTypes.LONG_STRING;
          }
          yybegin(0);
          return LuaTokenTypes.BAD_CHARACTER;
        case 66:
          return LuaTokenTypes.WHEN;
        case 65:
          return LuaTokenTypes.THEN;
        case 64:
          return LuaTokenTypes.TRUE;
        case 63:
          return LuaTokenTypes.CASE;
        case 62:
          return LuaTokenTypes.GOTO;
        case 61:
          return LuaTokenTypes.ELSE;
        case 60:
          yybegin(0);
          return LuaTokenTypes.DOC_COMMENT;
        case 59:
          return LuaTokenTypes.FOR;
        case 58:
          return LuaTokenTypes.MEAN;
        case 57:
          return LuaTokenTypes.LEF;
        case 56:
          return LuaTokenTypes.NIL;
        case 55:
          return LuaTokenTypes.END;
        case 54:
          return LuaTokenTypes.ELLIPSIS;
        case 53:
          yybegin(0);
          return LuaTokenTypes.SHORT_COMMENT;
        case 52:
          return LuaTokenTypes.AND;
        case 51:
          return LuaTokenTypes.DOUBLE_COLON;
        case 50:
          return LuaTokenTypes.DOUBLE_DIV;
        case 49:
          return LuaTokenTypes.BIT_LTLT;
        case 48:
          return LuaTokenTypes.LE;
        case 47:
          return LuaTokenTypes.BIT_RTRT;
        case 46:
          return LuaTokenTypes.GE;
        case 45:
          return LuaTokenTypes.NE;
        case 44:
          yybegin(2);
          return LuaTokenTypes.SHEBANG;
        case 43:
          return LuaTokenTypes.EQ;
        case 42:
          yybegin(8);
          yypushback(yylength());
          e();
          break;
        case 41:
          return LuaTokenTypes.DO;
        case 40:
          return LuaTokenTypes.OR;
        case 39:
          return LuaTokenTypes.IF;
        case 38:
          return LuaTokenTypes.IN;
        case 37:
          if (e())
          {
            yypushback(yylength());
            yybegin(12);
            break;
          }
          yypushback(yylength());
          i15 = 10;
        case 36:
        case 35:
          while (true)
          {
            yybegin(i15);
            break;
            return LuaTokenTypes.CONCAT;
            i15 = 10;
            yypushback(yylength());
          }
        case 34:
          yybegin(0);
          return LuaTokenTypes.STRING;
        case 33:
          return LuaTokenTypes.AT;
        case 32:
          return LuaTokenTypes.BIT_OR;
        case 31:
          return LuaTokenTypes.BIT_AND;
        case 30:
          return LuaTokenTypes.EXP;
        case 29:
          return LuaTokenTypes.COLON;
        case 28:
          return LuaTokenTypes.SEMI;
        case 27:
          return LuaTokenTypes.COMMA;
        case 26:
          return LuaTokenTypes.RCURLY;
        case 25:
          return LuaTokenTypes.LCURLY;
        case 24:
          return LuaTokenTypes.RPAREN;
        case 23:
          return LuaTokenTypes.LPAREN;
        case 22:
          return LuaTokenTypes.DIV;
        case 21:
          return LuaTokenTypes.MOD;
        case 20:
          return LuaTokenTypes.MULT;
        case 19:
          return LuaTokenTypes.BIT_TILDE;
        case 18:
          return LuaTokenTypes.LT;
        case 17:
          return LuaTokenTypes.GT;
        case 16:
          return LuaTokenTypes.NOT;
        case 15:
          return LuaTokenTypes.GETN;
        case 14:
        case 13:
          for (int i14 = 6; ; i14 = 4)
          {
            yybegin(i14);
            yypushback(yylength());
            break;
          }
        case 12:
          return LuaTokenTypes.RBRACK;
        case 11:
          return LuaTokenTypes.ASSIGN;
        case 10:
          return LuaTokenTypes.LBRACK;
        case 9:
          return LuaTokenTypes.MINUS;
        case 8:
          return LuaTokenTypes.DOT;
        case 7:
          return LuaTokenTypes.PLUS;
        case 6:
          return LuaTokenTypes.NUMBER;
        case 5:
          return LuaTokenTypes.NAME;
        case 4:
          return LuaTokenTypes.WHITE_SPACE;
        case 3:
          return LuaTokenTypes.NEW_LINE;
        case 2:
          return LuaTokenTypes.BAD_CHARACTER;
        case 1:
          yybegin(0);
          return LuaTokenTypes.SHEBANG_CONTENT;
        }
      }
      break label414;
    }
  }

  public final void yybegin(int paramInt)
  {
    this.j = paramInt;
  }

  public int yychar()
  {
    return this.q;
  }

  public final char yycharat(int paramInt)
  {
    return this.k[(paramInt + this.n)];
  }

  public final void yyclose()
  {
    this.t = true;
    this.o = this.n;
    if (this.h != null)
      this.h.close();
  }

  public int yycolumn()
  {
    return this.r;
  }

  public final int yylength()
  {
    return this.l - this.n;
  }

  public int yyline()
  {
    return this.p;
  }

  public void yypushback(int paramInt)
  {
    if (paramInt > yylength())
      a(2);
    this.l -= paramInt;
  }

  public final void yyreset(Reader paramReader)
  {
    this.h = paramReader;
    this.s = true;
    this.t = false;
    this.u = false;
    this.n = 0;
    this.o = 0;
    this.l = 0;
    this.m = 0;
    this.v = 0;
    this.r = 0;
    this.q = 0;
    this.p = 0;
    this.j = 0;
    if (this.k.length > 16384)
      this.k = new char[16384];
  }

  public final int yystate()
  {
    return this.j;
  }

  public final String yytext()
  {
    return new String(this.k, this.n, this.l - this.n);
  }

  static class CharSeqReader extends Reader
  {
    int a = 0;
    CharSequence b;

    CharSeqReader(CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
    }

    public void close()
    {
      this.b = null;
      this.a = 0;
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = Math.min(this.b.length() - this.a, paramInt2);
      for (int j = 0; j < i; j++)
        try
        {
          CharSequence localCharSequence = this.b;
          int k = this.a;
          this.a = (k + 1);
          int m = localCharSequence.charAt(k);
          int n = paramInt1 + 1;
          try
          {
            paramArrayOfChar[paramInt1] = m;
          }
          catch (Exception localException1)
          {
          }
          paramInt1 = n;
        }
        catch (Exception localException2)
        {
        }
      if (i <= 0)
        return -1;
      return i;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaLexer
 * JD-Core Version:    0.6.2
 */