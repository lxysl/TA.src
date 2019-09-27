package com.android.cglib.dx.c.c;

public final class v extends x
{
  public static final v a = new v("");
  private final String b;
  private final com.android.cglib.dx.d.c c;

  public v(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("string == null");
    this.b = paramString.intern();
    this.c = new com.android.cglib.dx.d.c(a(paramString));
  }

  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte1 = new byte[i * 3];
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = paramString.charAt(j);
      if ((m != 0) && (m < 128))
      {
        arrayOfByte1[k] = ((byte)m);
        k++;
      }
      else if (m < 2048)
      {
        arrayOfByte1[k] = ((byte)(0xC0 | 0x1F & m >> 6));
        arrayOfByte1[(k + 1)] = ((byte)(0x80 | m & 0x3F));
        k += 2;
      }
      else
      {
        arrayOfByte1[k] = ((byte)(0xE0 | 0xF & m >> 12));
        arrayOfByte1[(k + 1)] = ((byte)(0x80 | 0x3F & m >> 6));
        arrayOfByte1[(k + 2)] = ((byte)(0x80 | m & 0x3F));
        k += 3;
      }
      j++;
    }
    byte[] arrayOfByte2 = new byte[k];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, k);
    return arrayOfByte2;
  }

  public String a(int paramInt)
  {
    String str1 = a_();
    String str2;
    if (str1.length() <= paramInt - 2)
    {
      str2 = "";
    }
    else
    {
      str1 = str1.substring(0, paramInt - 5);
      str2 = "...";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }

  public String a_()
  {
    int i = this.b.length();
    StringBuilder localStringBuilder = new StringBuilder(i * 3 / 2);
    for (int j = 0; j < i; j++)
    {
      char c1 = this.b.charAt(j);
      if ((c1 >= ' ') && (c1 < ''))
      {
        if ((c1 == '\'') || (c1 == '"') || (c1 == '\\'))
          localStringBuilder.append('\\');
      }
      else
      {
        if (c1 <= '')
        {
          if (c1 != '\r')
            switch (c1)
            {
            default:
              int k;
              if (j < i - 1)
                k = this.b.charAt(j + 1);
              else
                k = 0;
              int m;
              if ((k >= 48) && (k <= 55))
                m = 1;
              else
                m = 0;
              localStringBuilder.append('\\');
              for (char c2 = '\006'; c2 >= 0; c2 -= 3)
              {
                char c3 = (char)(48 + (0x7 & c1 >> c2));
                if ((c3 != '0') || (m != 0))
                {
                  localStringBuilder.append(c3);
                  m = 1;
                }
              }
              if (m != 0)
                continue;
              localStringBuilder.append('0');
              break;
            case '\n':
              str = "\\n";
              break;
            case '\t':
            }
          for (String str = "\\t"; ; str = "\\r")
          {
            localStringBuilder.append(str);
            break;
          }
        }
        localStringBuilder.append("\\u");
        localStringBuilder.append(Character.forDigit(c1 >> '\f', 16));
        localStringBuilder.append(Character.forDigit(0xF & c1 >> '\b', 16));
        localStringBuilder.append(Character.forDigit(0xF & c1 >> '\004', 16));
        c1 = Character.forDigit(c1 & 0xF, 16);
      }
      localStringBuilder.append(c1);
    }
    return localStringBuilder.toString();
  }

  protected int b(a parama)
  {
    return this.b.compareTo(((v)parama).b);
  }

  public com.android.cglib.dx.c.d.c b()
  {
    return com.android.cglib.dx.c.d.c.q;
  }

  public String e()
  {
    return "utf8";
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof v))
      return false;
    return this.b.equals(((v)paramObject).b);
  }

  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    localStringBuilder.append(a_());
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }

  public String g()
  {
    return this.b;
  }

  public com.android.cglib.dx.d.c h()
  {
    return this.c;
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public int i()
  {
    return this.c.a();
  }

  public int j()
  {
    return this.b.length();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("string{\"");
    localStringBuilder.append(a_());
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.v
 * JD-Core Version:    0.6.2
 */