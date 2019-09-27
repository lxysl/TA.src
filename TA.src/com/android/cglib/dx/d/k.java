package com.android.cglib.dx.d;

import java.util.Arrays;

public final class k extends o
{
  public static final k a = new k(0);
  private int[] b;
  private int c;
  private boolean d;

  static
  {
    a.e();
  }

  public k()
  {
    this(4);
  }

  // ERROR //
  public k(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokespecial 28	com/android/cglib/dx/d/o:<init>	(Z)V
    //   5: aload_0
    //   6: iload_1
    //   7: newarray int
    //   9: putfield 30	com/android/cglib/dx/d/k:b	[I
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 32	com/android/cglib/dx/d/k:c	I
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 34	com/android/cglib/dx/d/k:d	Z
    //   22: return
    //   23: new 36	java/lang/IllegalArgumentException
    //   26: dup
    //   27: ldc 38
    //   29: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   32: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	12	23	java/lang/NegativeArraySizeException
  }

  private void c()
  {
    if (this.c == this.b.length)
    {
      int[] arrayOfInt = new int[10 + 3 * this.c / 2];
      System.arraycopy(this.b, 0, arrayOfInt, 0, this.c);
      this.b = arrayOfInt;
    }
  }

  public int a()
  {
    return this.c;
  }

  // ERROR //
  public int a(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: getfield 32	com/android/cglib/dx/d/k:c	I
    //   5: if_icmplt +13 -> 18
    //   8: new 53	java/lang/IndexOutOfBoundsException
    //   11: dup
    //   12: ldc 55
    //   14: invokespecial 56	java/lang/IndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: getfield 30	com/android/cglib/dx/d/k:b	[I
    //   22: iload_1
    //   23: iaload
    //   24: istore_2
    //   25: iload_2
    //   26: ireturn
    //   27: new 53	java/lang/IndexOutOfBoundsException
    //   30: dup
    //   31: ldc 58
    //   33: invokespecial 56	java/lang/IndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	25	27	java/lang/ArrayIndexOutOfBoundsException
  }

  // ERROR //
  public void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	com/android/cglib/dx/d/k:h	()V
    //   4: iload_1
    //   5: aload_0
    //   6: getfield 32	com/android/cglib/dx/d/k:c	I
    //   9: if_icmplt +13 -> 22
    //   12: new 53	java/lang/IndexOutOfBoundsException
    //   15: dup
    //   16: ldc 55
    //   18: invokespecial 56	java/lang/IndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_0
    //   23: getfield 30	com/android/cglib/dx/d/k:b	[I
    //   26: iload_1
    //   27: iload_2
    //   28: iastore
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 34	com/android/cglib/dx/d/k:d	Z
    //   34: return
    //   35: iload_1
    //   36: ifge +13 -> 49
    //   39: new 36	java/lang/IllegalArgumentException
    //   42: dup
    //   43: ldc 58
    //   45: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	34	35	java/lang/ArrayIndexOutOfBoundsException
  }

  public void b()
  {
    h();
    if (!this.d)
    {
      Arrays.sort(this.b, 0, this.c);
      this.d = true;
    }
  }

  public void b(int paramInt)
  {
    h();
    c();
    int[] arrayOfInt = this.b;
    int i = this.c;
    this.c = (i + 1);
    arrayOfInt[i] = paramInt;
    if (this.d)
    {
      int j = this.c;
      int k = 1;
      if (j > k)
      {
        if (paramInt < this.b[(-2 + this.c)])
          k = 0;
        this.d = k;
      }
    }
  }

  public void c(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("newSize < 0");
    if (paramInt > this.c)
      throw new IllegalArgumentException("newSize > size");
    h();
    this.c = paramInt;
  }

  public int d(int paramInt)
  {
    int i = e(paramInt);
    if (i >= 0)
      return i;
    return -1;
  }

  public int e(int paramInt)
  {
    int i = this.c;
    if (!this.d)
    {
      for (int n = 0; n < i; n++)
        if (this.b[n] == paramInt)
          return n;
      return -i;
    }
    int j = i;
    int k = -1;
    while (j > k + 1)
    {
      int m = k + (j - k >> 1);
      if (paramInt <= this.b[m])
        j = m;
      else
        k = m;
    }
    if (j != i)
    {
      if (paramInt == this.b[j])
        return j;
      return -1 + -j;
    }
    return -1 + -i;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof k))
      return false;
    k localk = (k)paramObject;
    if (this.d != localk.d)
      return false;
    if (this.c != localk.c)
      return false;
    for (int i = 0; i < this.c; i++)
      if (this.b[i] != localk.b[i])
        return false;
    return true;
  }

  public boolean f(int paramInt)
  {
    return d(paramInt) >= 0;
  }

  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.c)
    {
      j = j * 31 + this.b[i];
      i++;
    }
    return j;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(10 + 5 * this.c);
    localStringBuffer.append('{');
    for (int i = 0; i < this.c; i++)
    {
      if (i != 0)
        localStringBuffer.append(", ");
      localStringBuffer.append(this.b[i]);
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.d.k
 * JD-Core Version:    0.6.2
 */