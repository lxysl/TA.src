package com.android.cglib.dx.c.b;

import com.android.cglib.dx.d.i;
import com.android.cglib.dx.d.k;
import com.android.cglib.dx.d.l;

public final class b
  implements l
{
  private final int a;
  private final g b;
  private final k c;
  private final int d;

  // ERROR //
  public b(int paramInt1, g paramg, k paramk, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 20	java/lang/Object:<init>	()V
    //   4: iload_1
    //   5: ifge +13 -> 18
    //   8: new 22	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 24
    //   14: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_2
    //   19: invokevirtual 32	com/android/cglib/dx/c/b/g:i	()V
    //   22: aload_2
    //   23: invokevirtual 35	com/android/cglib/dx/c/b/g:a	()I
    //   26: istore 5
    //   28: iload 5
    //   30: ifne +13 -> 43
    //   33: new 22	java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc 37
    //   39: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: iload 5
    //   45: iconst_2
    //   46: isub
    //   47: istore 6
    //   49: iload 6
    //   51: iflt +71 -> 122
    //   54: aload_2
    //   55: iload 6
    //   57: invokevirtual 40	com/android/cglib/dx/c/b/g:a	(I)Lcom/android/cglib/dx/c/b/f;
    //   60: invokevirtual 45	com/android/cglib/dx/c/b/f:d	()Lcom/android/cglib/dx/c/b/p;
    //   63: invokevirtual 49	com/android/cglib/dx/c/b/p:b	()I
    //   66: iconst_1
    //   67: if_icmpeq +49 -> 116
    //   70: new 51	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   77: astore 12
    //   79: aload 12
    //   81: ldc 54
    //   83: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 12
    //   89: iload 6
    //   91: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 12
    //   97: ldc 63
    //   99: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 22	java/lang/IllegalArgumentException
    //   106: dup
    //   107: aload 12
    //   109: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: iinc 6 255
    //   119: goto -70 -> 49
    //   122: aload_2
    //   123: iload 5
    //   125: iconst_1
    //   126: isub
    //   127: invokevirtual 40	com/android/cglib/dx/c/b/g:a	(I)Lcom/android/cglib/dx/c/b/f;
    //   130: invokevirtual 45	com/android/cglib/dx/c/b/f:d	()Lcom/android/cglib/dx/c/b/p;
    //   133: invokevirtual 49	com/android/cglib/dx/c/b/p:b	()I
    //   136: iconst_1
    //   137: if_icmpne +13 -> 150
    //   140: new 22	java/lang/IllegalArgumentException
    //   143: dup
    //   144: ldc 69
    //   146: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   149: athrow
    //   150: aload_3
    //   151: invokevirtual 72	com/android/cglib/dx/d/k:i	()V
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpge +13 -> 170
    //   160: new 22	java/lang/IllegalArgumentException
    //   163: dup
    //   164: ldc 74
    //   166: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   169: athrow
    //   170: iload 4
    //   172: iflt +65 -> 237
    //   175: aload_3
    //   176: iload 4
    //   178: invokevirtual 78	com/android/cglib/dx/d/k:f	(I)Z
    //   181: ifne +56 -> 237
    //   184: new 51	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   191: astore 7
    //   193: aload 7
    //   195: ldc 80
    //   197: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 7
    //   203: iload 4
    //   205: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 7
    //   211: ldc 82
    //   213: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 7
    //   219: aload_3
    //   220: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: new 22	java/lang/IllegalArgumentException
    //   227: dup
    //   228: aload 7
    //   230: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokespecial 27	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   236: athrow
    //   237: aload_0
    //   238: iload_1
    //   239: putfield 87	com/android/cglib/dx/c/b/b:a	I
    //   242: aload_0
    //   243: aload_2
    //   244: putfield 89	com/android/cglib/dx/c/b/b:b	Lcom/android/cglib/dx/c/b/g;
    //   247: aload_0
    //   248: aload_3
    //   249: putfield 91	com/android/cglib/dx/c/b/b:c	Lcom/android/cglib/dx/d/k;
    //   252: aload_0
    //   253: iload 4
    //   255: putfield 93	com/android/cglib/dx/c/b/b:d	I
    //   258: return
    //   259: new 17	java/lang/NullPointerException
    //   262: dup
    //   263: ldc 95
    //   265: invokespecial 96	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   268: athrow
    //   269: new 17	java/lang/NullPointerException
    //   272: dup
    //   273: ldc 98
    //   275: invokespecial 96	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   278: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   150	154	259	java/lang/NullPointerException
    //   18	22	269	java/lang/NullPointerException
  }

  public int a()
  {
    return this.a;
  }

  public g b()
  {
    return this.b;
  }

  public k c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    if (this.c.a() != 2)
      throw new UnsupportedOperationException("block doesn't have exactly two successors");
    int i = this.c.a(0);
    if (i == this.d)
      i = this.c.a(1);
    return i;
  }

  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }

  public f f()
  {
    return this.b.b();
  }

  public boolean g()
  {
    return this.b.b().h();
  }

  public int hashCode()
  {
    return System.identityHashCode(this);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    localStringBuilder.append(i.c(this.a));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.b
 * JD-Core Version:    0.6.2
 */