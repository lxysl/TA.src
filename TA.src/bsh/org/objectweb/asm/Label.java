package bsh.org.objectweb.asm;

public class Label
{
  boolean a;
  int b;
  int c;
  int d;
  Edge e;
  Label f;
  boolean g;
  private int h;
  private int[] i;

  private void a(int paramInt1, int paramInt2)
  {
    if (this.i == null)
      this.i = new int[6];
    if (this.h >= this.i.length)
    {
      int[] arrayOfInt3 = new int[6 + this.i.length];
      System.arraycopy(this.i, 0, arrayOfInt3, 0, this.i.length);
      this.i = arrayOfInt3;
    }
    int[] arrayOfInt1 = this.i;
    int j = this.h;
    this.h = (j + 1);
    arrayOfInt1[j] = paramInt1;
    int[] arrayOfInt2 = this.i;
    int k = this.h;
    this.h = (k + 1);
    arrayOfInt2[k] = paramInt2;
  }

  void a(CodeWriter paramCodeWriter, ByteVector paramByteVector, int paramInt, boolean paramBoolean)
  {
    int j;
    if (this.a)
    {
      if (paramBoolean)
      {
        j = this.b - paramInt;
        paramByteVector.put4(j);
        return;
      }
      j = this.b - paramInt;
    }
    while (true)
    {
      paramByteVector.put2(j);
      return;
      j = -1;
      if (paramBoolean)
      {
        a(-1 - paramInt, paramByteVector.b);
        break;
      }
      a(paramInt, paramByteVector.b);
    }
  }

  boolean a(CodeWriter paramCodeWriter, int paramInt, byte[] paramArrayOfByte)
  {
    this.a = true;
    this.b = paramInt;
    int j = 0;
    boolean bool = false;
    while (true)
    {
      if (j >= this.h)
        return bool;
      int[] arrayOfInt1 = this.i;
      int k = j + 1;
      int m = arrayOfInt1[j];
      int[] arrayOfInt2 = this.i;
      int n = k + 1;
      int i1 = arrayOfInt2[k];
      if (m >= 0)
      {
        int i6 = paramInt - m;
        if ((i6 < -32768) || (i6 > 32767))
        {
          int i7 = i1 - 1;
          int i8 = 0xFF & paramArrayOfByte[i7];
          if (i8 <= 168)
            paramArrayOfByte[i7] = ((byte)(i8 + 49));
          else
            paramArrayOfByte[i7] = ((byte)(i8 + 20));
          bool = true;
        }
        int i9 = i1 + 1;
        paramArrayOfByte[i1] = ((byte)(i6 >>> 8));
        paramArrayOfByte[i9] = ((byte)i6);
      }
      else
      {
        int i2 = 1 + (m + paramInt);
        int i3 = i1 + 1;
        paramArrayOfByte[i1] = ((byte)(i2 >>> 24));
        int i4 = i3 + 1;
        paramArrayOfByte[i3] = ((byte)(i2 >>> 16));
        int i5 = i4 + 1;
        paramArrayOfByte[i4] = ((byte)(i2 >>> 8));
        paramArrayOfByte[i5] = ((byte)i2);
      }
      j = n;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.Label
 * JD-Core Version:    0.6.2
 */