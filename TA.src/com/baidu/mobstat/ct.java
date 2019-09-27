package com.baidu.mobstat;

public final class ct
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    int i = 4 * paramArrayOfByte.length / 3;
    byte[] arrayOfByte1 = new byte[i + (3 + i / 76)];
    int j = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int k = 0;
    int m = 0;
    int n = 0;
    while (k < j)
    {
      int i9 = m + 1;
      arrayOfByte1[m] = a[((0xFF & paramArrayOfByte[k]) >> 2)];
      int i10 = i9 + 1;
      byte[] arrayOfByte3 = a;
      int i11 = (0x3 & paramArrayOfByte[k]) << 4;
      int i12 = k + 1;
      arrayOfByte1[i9] = arrayOfByte3[(i11 | (0xFF & paramArrayOfByte[i12]) >> 4)];
      int i13 = i10 + 1;
      byte[] arrayOfByte4 = a;
      int i14 = (0xF & paramArrayOfByte[i12]) << 2;
      int i15 = k + 2;
      arrayOfByte1[i10] = arrayOfByte4[(i14 | (0xFF & paramArrayOfByte[i15]) >> 6)];
      m = i13 + 1;
      arrayOfByte1[i13] = a[(0x3F & paramArrayOfByte[i15])];
      if (((m - n) % 76 == 0) && (m != 0))
        n++;
      k += 3;
    }
    switch (paramArrayOfByte.length % 3)
    {
    default:
      break;
    case 2:
      int i4 = m + 1;
      arrayOfByte1[m] = a[((0xFF & paramArrayOfByte[j]) >> 2)];
      int i5 = i4 + 1;
      byte[] arrayOfByte2 = a;
      int i6 = (0x3 & paramArrayOfByte[j]) << 4;
      int i7 = j + 1;
      arrayOfByte1[i4] = arrayOfByte2[(i6 | (0xFF & paramArrayOfByte[i7]) >> 4)];
      int i8 = i5 + 1;
      arrayOfByte1[i5] = a[((0xF & paramArrayOfByte[i7]) << 2)];
      m = i8 + 1;
      arrayOfByte1[i8] = 61;
      break;
    case 1:
      int i1 = m + 1;
      arrayOfByte1[m] = a[((0xFF & paramArrayOfByte[j]) >> 2)];
      int i2 = i1 + 1;
      arrayOfByte1[i1] = a[((0x3 & paramArrayOfByte[j]) << 4)];
      int i3 = i2 + 1;
      arrayOfByte1[i2] = 61;
      m = i3 + 1;
      arrayOfByte1[i3] = 61;
    }
    return new String(arrayOfByte1, 0, m, paramString);
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 3 * (paramInt / 4);
    if (i == 0)
      return new byte[0];
    byte[] arrayOfByte1 = new byte[i];
    int j = paramInt;
    int k = 0;
    while (true)
    {
      int m = paramArrayOfByte[(j - 1)];
      int n = 10;
      if ((m != n) && (m != 13) && (m != 32) && (m != 9))
        if (m == 61)
        {
          k++;
        }
        else
        {
          int i1 = 0;
          int i2 = 0;
          int i3 = 0;
          int i4 = 0;
          while (i1 < j)
          {
            int i7 = paramArrayOfByte[i1];
            if ((i7 != n) && (i7 != 13) && (i7 != 32) && (i7 != 9))
            {
              int i8;
              if ((i7 >= 65) && (i7 <= 90))
              {
                i8 = i7 - 65;
              }
              else if ((i7 >= 97) && (i7 <= 122))
              {
                i8 = i7 - 71;
              }
              else if ((i7 >= 48) && (i7 <= 57))
              {
                i8 = i7 + 4;
              }
              else if (i7 == 43)
              {
                i8 = 62;
              }
              else
              {
                if (i7 != 47)
                  break label316;
                i8 = 63;
              }
              int i9 = i2 << 6 | (byte)i8;
              if (i4 % 4 == 3)
              {
                int i10 = i3 + 1;
                arrayOfByte1[i3] = ((byte)((i9 & 0xFF0000) >> 16));
                int i11 = i10 + 1;
                arrayOfByte1[i10] = ((byte)((i9 & 0xFF00) >> 8));
                i3 = i11 + 1;
                arrayOfByte1[i11] = ((byte)(i9 & 0xFF));
              }
              i4++;
              i2 = i9;
              break label318;
              label316: return null;
            }
            label318: i1++;
            n = 10;
          }
          if (k > 0)
          {
            int i5 = i2 << k * 6;
            int i6 = i3 + 1;
            arrayOfByte1[i3] = ((byte)((i5 & 0xFF0000) >> 16));
            if (k == 1)
            {
              i3 = i6 + 1;
              arrayOfByte1[i6] = ((byte)((i5 & 0xFF00) >> 8));
            }
            else
            {
              i3 = i6;
            }
          }
          byte[] arrayOfByte2 = new byte[i3];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i3);
          return arrayOfByte2;
        }
      j--;
    }
  }

  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, "utf-8");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.ct
 * JD-Core Version:    0.6.2
 */