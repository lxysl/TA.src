package com.android.cglib.dx.c.b;

public final class o extends com.android.cglib.dx.d.o
{
  public static final o a = new o(0);
  private final m[] b;
  private int c;

  public o(int paramInt)
  {
    super(bool);
    this.b = new m[paramInt];
    this.c = 0;
  }

  public int a()
  {
    return this.b.length;
  }

  // ERROR //
  public m a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   4: iload_1
    //   5: aaload
    //   6: astore_2
    //   7: aload_2
    //   8: areturn
    //   9: new 33	java/lang/IllegalArgumentException
    //   12: dup
    //   13: ldc 35
    //   15: invokespecial 38	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	9	java/lang/ArrayIndexOutOfBoundsException
  }

  public m a(m paramm)
  {
    int i = this.b.length;
    for (int j = 0; j < i; j++)
    {
      m localm = this.b[j];
      if ((localm != null) && (paramm.b(localm)))
        return localm;
    }
    return null;
  }

  public void a(o paramo)
  {
    int i = paramo.a();
    for (int j = 0; j < i; j++)
    {
      m localm = paramo.a(j);
      if (localm != null)
        c(localm);
    }
  }

  public int b()
  {
    int i = this.c;
    if (i < 0)
    {
      int j = this.b.length;
      int k = 0;
      int m = 0;
      while (k < j)
      {
        if (this.b[k] != null)
          m++;
        k++;
      }
      this.c = m;
      i = m;
    }
    return i;
  }

  public o b(int paramInt)
  {
    int i = this.b.length;
    o localo = new o(i + paramInt);
    for (int j = 0; j < i; j++)
    {
      m localm = this.b[j];
      if (localm != null)
        localo.c(localm.c(paramInt));
    }
    localo.c = this.c;
    if (f())
      localo.e();
    return localo;
  }

  // ERROR //
  public void b(m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   4: aload_1
    //   5: invokevirtual 62	com/android/cglib/dx/c/b/m:e	()I
    //   8: aconst_null
    //   9: aastore
    //   10: aload_0
    //   11: iconst_m1
    //   12: putfield 27	com/android/cglib/dx/c/b/o:c	I
    //   15: return
    //   16: new 33	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc 35
    //   22: invokespecial 38	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	15	16	java/lang/ArrayIndexOutOfBoundsException
  }

  // ERROR //
  public void c(m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 65	com/android/cglib/dx/c/b/o:h	()V
    //   4: aload_1
    //   5: ifnonnull +13 -> 18
    //   8: new 67	java/lang/NullPointerException
    //   11: dup
    //   12: ldc 69
    //   14: invokespecial 70	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: iconst_m1
    //   20: putfield 27	com/android/cglib/dx/c/b/o:c	I
    //   23: aload_1
    //   24: invokevirtual 62	com/android/cglib/dx/c/b/m:e	()I
    //   27: istore_2
    //   28: aload_0
    //   29: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   32: iload_2
    //   33: aload_1
    //   34: aastore
    //   35: iload_2
    //   36: ifle +36 -> 72
    //   39: iload_2
    //   40: iconst_1
    //   41: isub
    //   42: istore_3
    //   43: aload_0
    //   44: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   47: iload_3
    //   48: aaload
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +19 -> 72
    //   56: aload 4
    //   58: invokevirtual 73	com/android/cglib/dx/c/b/m:i	()I
    //   61: iconst_2
    //   62: if_icmpne +10 -> 72
    //   65: aload_0
    //   66: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   69: iload_3
    //   70: aconst_null
    //   71: aastore
    //   72: aload_1
    //   73: invokevirtual 73	com/android/cglib/dx/c/b/m:i	()I
    //   76: iconst_2
    //   77: if_icmpne +12 -> 89
    //   80: aload_0
    //   81: getfield 25	com/android/cglib/dx/c/b/o:b	[Lcom/android/cglib/dx/c/b/m;
    //   84: iload_2
    //   85: iconst_1
    //   86: iadd
    //   87: aconst_null
    //   88: aastore
    //   89: return
    //   90: new 33	java/lang/IllegalArgumentException
    //   93: dup
    //   94: ldc 75
    //   96: invokespecial 38	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	35	90	java/lang/ArrayIndexOutOfBoundsException
    //   43	51	90	java/lang/ArrayIndexOutOfBoundsException
    //   56	72	90	java/lang/ArrayIndexOutOfBoundsException
    //   72	89	90	java/lang/ArrayIndexOutOfBoundsException
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof o))
      return false;
    o localo = (o)paramObject;
    m[] arrayOfm = localo.b;
    int i = this.b.length;
    if (i == arrayOfm.length)
    {
      if (b() != localo.b())
        return false;
      int j = 0;
      while (j < i)
      {
        m localm1 = this.b[j];
        m localm2 = arrayOfm[j];
        if (localm1 != localm2)
        {
          if (localm1 == null)
            break label104;
          if (!localm1.equals(localm2))
            return false;
        }
        j++;
        continue;
        label104: return false;
      }
      return true;
    }
    return false;
  }

  public int hashCode()
  {
    int i = this.b.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      m localm = this.b[j];
      int m;
      if (localm == null)
        m = 0;
      else
        m = localm.hashCode();
      k = m + k * 31;
      j++;
    }
    return k;
  }

  public String toString()
  {
    int i = this.b.length;
    StringBuffer localStringBuffer = new StringBuffer(i * 25);
    localStringBuffer.append('{');
    int j = 0;
    int k = 0;
    while (j < i)
    {
      m localm = this.b[j];
      if (localm != null)
      {
        if (k != 0)
          localStringBuffer.append(", ");
        else
          k = 1;
        localStringBuffer.append(localm);
      }
      j++;
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.o
 * JD-Core Version:    0.6.2
 */