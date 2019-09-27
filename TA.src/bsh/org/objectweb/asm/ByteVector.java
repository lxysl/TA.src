package bsh.org.objectweb.asm;

final class ByteVector
{
  byte[] a;
  int b;

  public ByteVector()
  {
    this.a = new byte[64];
  }

  public ByteVector(int paramInt)
  {
    this.a = new byte[paramInt];
  }

  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[Math.max(2 * this.a.length, paramInt + this.b)];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }

  public ByteVector put1(int paramInt)
  {
    int i = this.b;
    int j = i + 1;
    if (j > this.a.length)
      a(1);
    this.a[i] = ((byte)paramInt);
    this.b = j;
    return this;
  }

  public ByteVector put11(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i + 2 > this.a.length)
      a(2);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)paramInt1);
    int k = j + 1;
    arrayOfByte[j] = ((byte)paramInt2);
    this.b = k;
    return this;
  }

  public ByteVector put12(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i + 3 > this.a.length)
      a(3);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)paramInt1);
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt2 >>> 8));
    int m = k + 1;
    arrayOfByte[k] = ((byte)paramInt2);
    this.b = m;
    return this;
  }

  public ByteVector put2(int paramInt)
  {
    int i = this.b;
    if (i + 2 > this.a.length)
      a(2);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8));
    int k = j + 1;
    arrayOfByte[j] = ((byte)paramInt);
    this.b = k;
    return this;
  }

  public ByteVector put4(int paramInt)
  {
    int i = this.b;
    if (i + 4 > this.a.length)
      a(4);
    byte[] arrayOfByte = this.a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 24));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 16));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(paramInt >>> 8));
    int n = m + 1;
    arrayOfByte[m] = ((byte)paramInt);
    this.b = n;
    return this;
  }

  public ByteVector put8(long paramLong)
  {
    int i = this.b;
    if (i + 8 > this.a.length)
      a(8);
    byte[] arrayOfByte = this.a;
    int j = (int)(paramLong >>> 32);
    int k = i + 1;
    arrayOfByte[i] = ((byte)(j >>> 24));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(j >>> 16));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(j >>> 8));
    int i1 = n + 1;
    arrayOfByte[n] = ((byte)j);
    int i2 = (int)paramLong;
    int i3 = i1 + 1;
    arrayOfByte[i1] = ((byte)(i2 >>> 24));
    int i4 = i3 + 1;
    arrayOfByte[i3] = ((byte)(i2 >>> 16));
    int i5 = i4 + 1;
    arrayOfByte[i4] = ((byte)(i2 >>> 8));
    int i6 = i5 + 1;
    arrayOfByte[i5] = ((byte)i2);
    this.b = i6;
    return this;
  }

  public ByteVector putByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 + this.b > this.a.length)
      a(paramInt2);
    if (paramArrayOfByte != null)
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b = (paramInt2 + this.b);
    return this;
  }

  public ByteVector putUTF(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m = 0;
    while (true)
    {
      if (k >= i)
      {
        if (m > 65535)
          throw new IllegalArgumentException();
        int i1 = this.b;
        if (m + (i1 + 2) > this.a.length)
          a(m + 2);
        byte[] arrayOfByte = this.a;
        int i2 = i1 + 1;
        arrayOfByte[i1] = ((byte)(m >>> 8));
        int i3 = i2 + 1;
        arrayOfByte[i2] = ((byte)m);
        while (true)
        {
          if (j >= i)
          {
            this.b = i3;
            return this;
          }
          int i4 = paramString.charAt(j);
          int i8;
          if ((i4 >= 1) && (i4 <= 127))
          {
            i8 = i3 + 1;
            arrayOfByte[i3] = ((byte)i4);
          }
          while (true)
          {
            i3 = i8;
            break label279;
            if (i4 <= 2047)
              break;
            int i6 = i3 + 1;
            arrayOfByte[i3] = ((byte)(0xE0 | 0xF & i4 >> 12));
            int i7 = i6 + 1;
            arrayOfByte[i6] = ((byte)(0x80 | 0x3F & i4 >> 6));
            i8 = i7 + 1;
            arrayOfByte[i7] = ((byte)(0x80 | i4 & 0x3F));
          }
          int i5 = i3 + 1;
          arrayOfByte[i3] = ((byte)(0xC0 | 0x1F & i4 >> 6));
          i3 = i5 + 1;
          arrayOfByte[i5] = ((byte)(0x80 | i4 & 0x3F));
          label279: j++;
        }
      }
      int n = paramString.charAt(k);
      if ((n >= 1) && (n <= 127))
        m++;
      else if (n > 2047)
        m += 3;
      else
        m += 2;
      k++;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.ByteVector
 * JD-Core Version:    0.6.2
 */