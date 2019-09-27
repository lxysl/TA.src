package com.android.cglib.dx.d;

public final class i
{
  public static String a(int paramInt)
  {
    char[] arrayOfChar = new char[8];
    for (int i = 0; i < 8; i++)
    {
      arrayOfChar[(7 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
    }
    return new String(arrayOfChar);
  }

  public static String a(long paramLong)
  {
    char[] arrayOfChar = new char[16];
    for (int i = 0; i < 16; i++)
    {
      arrayOfChar[(15 - i)] = Character.forDigit(0xF & (int)paramLong, 16);
      paramLong >>= 4;
    }
    return new String(arrayOfChar);
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1 + paramInt2;
    if (((i | (paramInt1 | paramInt2)) >= 0) && (i <= paramArrayOfByte.length))
    {
      if (paramInt3 < 0)
        throw new IllegalArgumentException("outOffset < 0");
      if (paramInt2 == 0)
        return "";
      StringBuffer localStringBuffer = new StringBuffer(6 + paramInt2 * 4);
      int j = paramInt1;
      int k = 0;
      while (paramInt2 > 0)
      {
        if (k == 0)
        {
          String str;
          if (paramInt5 != 2)
          {
            if (paramInt5 != 4)
            {
              if (paramInt5 != 6)
                str = a(paramInt3);
              else
                str = b(paramInt3);
            }
            else
              str = c(paramInt3);
          }
          else
            str = e(paramInt3);
          localStringBuffer.append(str);
          localStringBuffer.append(": ");
        }
        else if ((k & 0x1) == 0)
        {
          localStringBuffer.append(' ');
        }
        localStringBuffer.append(e(paramArrayOfByte[j]));
        paramInt3++;
        j++;
        k++;
        if (k == paramInt4)
        {
          localStringBuffer.append('\n');
          k = 0;
        }
        paramInt2--;
      }
      if (k != 0)
        localStringBuffer.append('\n');
      return localStringBuffer.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arr.length ");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append("; ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("..!");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }

  public static String b(int paramInt)
  {
    char[] arrayOfChar = new char[6];
    for (int i = 0; i < 6; i++)
    {
      arrayOfChar[(5 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
    }
    return new String(arrayOfChar);
  }

  public static String c(int paramInt)
  {
    char[] arrayOfChar = new char[4];
    for (int i = 0; i < 4; i++)
    {
      arrayOfChar[(3 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
    }
    return new String(arrayOfChar);
  }

  public static String d(int paramInt)
  {
    if (paramInt == (char)paramInt)
      return c(paramInt);
    return a(paramInt);
  }

  public static String e(int paramInt)
  {
    char[] arrayOfChar = new char[2];
    for (int i = 0; i < 2; i++)
    {
      arrayOfChar[(1 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
    }
    return new String(arrayOfChar);
  }

  public static String f(int paramInt)
  {
    char[] arrayOfChar = new char[1];
    arrayOfChar[0] = Character.forDigit(paramInt & 0xF, 16);
    return new String(arrayOfChar);
  }

  public static String g(int paramInt)
  {
    char[] arrayOfChar = new char[9];
    int i = 0;
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
      i = 0;
    }
    else
    {
      arrayOfChar[0] = '+';
    }
    while (i < 8)
    {
      arrayOfChar[(8 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i++;
    }
    return new String(arrayOfChar);
  }

  public static String h(int paramInt)
  {
    char[] arrayOfChar = new char[5];
    int i = 0;
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
      i = 0;
    }
    else
    {
      arrayOfChar[0] = '+';
    }
    while (i < 4)
    {
      arrayOfChar[(4 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i++;
    }
    return new String(arrayOfChar);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.d.i
 * JD-Core Version:    0.6.2
 */