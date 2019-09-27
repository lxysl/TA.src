package com.android.cglib.dx.d;

import java.util.Arrays;

public class h extends o
  implements r
{
  private Object[] a;

  // ERROR //
  public h(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +8 -> 9
    //   4: iconst_1
    //   5: istore_2
    //   6: goto +5 -> 11
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_0
    //   12: iload_2
    //   13: invokespecial 15	com/android/cglib/dx/d/o:<init>	(Z)V
    //   16: aload_0
    //   17: iload_1
    //   18: anewarray 17	java/lang/Object
    //   21: putfield 19	com/android/cglib/dx/d/h:a	[Ljava/lang/Object;
    //   24: return
    //   25: new 21	java/lang/IllegalArgumentException
    //   28: dup
    //   29: ldc 23
    //   31: invokespecial 26	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	24	25	java/lang/NegativeArraySizeException
  }

  private Object a(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException("n < 0");
    throw new IndexOutOfBoundsException("n >= size()");
  }

  private String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = this.a.length;
    StringBuffer localStringBuffer = new StringBuffer(10 + i * 10);
    if (paramString1 != null)
      localStringBuffer.append(paramString1);
    for (int j = 0; j < i; j++)
    {
      if ((j != 0) && (paramString2 != null))
        localStringBuffer.append(paramString2);
      if (paramBoolean)
        localStringBuffer.append(((r)this.a[j]).a_());
      else
        localStringBuffer.append(this.a[j]);
    }
    if (paramString3 != null)
      localStringBuffer.append(paramString3);
    return localStringBuffer.toString();
  }

  public final int a()
  {
    return this.a.length;
  }

  public String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false);
  }

  // ERROR //
  protected final void a(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	com/android/cglib/dx/d/h:h	()V
    //   4: aload_0
    //   5: getfield 19	com/android/cglib/dx/d/h:a	[Ljava/lang/Object;
    //   8: iload_1
    //   9: aload_2
    //   10: aastore
    //   11: return
    //   12: aload_0
    //   13: iload_1
    //   14: invokespecial 66	com/android/cglib/dx/d/h:a	(I)Ljava/lang/Object;
    //   17: pop
    //   18: return
    //
    // Exception table:
    //   from	to	target	type
    //   4	11	12	java/lang/ArrayIndexOutOfBoundsException
  }

  public String a_()
  {
    String str = getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(1 + str.lastIndexOf('.')));
    localStringBuilder.append('{');
    return a(localStringBuilder.toString(), ", ", "}", true);
  }

  public String b(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, true);
  }

  // ERROR //
  protected final Object d(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/android/cglib/dx/d/h:a	[Ljava/lang/Object;
    //   4: iload_1
    //   5: aaload
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +36 -> 44
    //   11: new 77	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 104
    //   22: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: iload_1
    //   28: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: new 109	java/lang/NullPointerException
    //   35: dup
    //   36: aload_3
    //   37: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 110	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload_2
    //   45: areturn
    //   46: aload_0
    //   47: iload_1
    //   48: invokespecial 66	com/android/cglib/dx/d/h:a	(I)Ljava/lang/Object;
    //   51: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	46	java/lang/ArrayIndexOutOfBoundsException
    //   11	44	46	java/lang/ArrayIndexOutOfBoundsException
  }

  protected final Object e(int paramInt)
  {
    return this.a[paramInt];
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      h localh = (h)paramObject;
      return Arrays.equals(this.a, localh.a);
    }
    return false;
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }

  public String toString()
  {
    String str = getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(1 + str.lastIndexOf('.')));
    localStringBuilder.append('{');
    return a(localStringBuilder.toString(), ", ", "}", false);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.d.h
 * JD-Core Version:    0.6.2
 */