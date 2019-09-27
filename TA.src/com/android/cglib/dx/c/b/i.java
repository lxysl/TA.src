package com.android.cglib.dx.c.b;

import java.util.HashMap;

public final class i extends com.android.cglib.dx.d.o
{
  private final o a;
  private final o[] b;
  private final HashMap<f, m> c;

  // ERROR //
  private o b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/android/cglib/dx/c/b/i:b	[Lcom/android/cglib/dx/c/b/o;
    //   4: iload_1
    //   5: aaload
    //   6: astore_2
    //   7: aload_2
    //   8: areturn
    //   9: new 18	java/lang/IllegalArgumentException
    //   12: dup
    //   13: ldc 20
    //   15: invokespecial 24	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	9	java/lang/ArrayIndexOutOfBoundsException
  }

  public int a()
  {
    return this.c.size();
  }

  public m a(f paramf)
  {
    return (m)this.c.get(paramf);
  }

  public o a(int paramInt)
  {
    o localo = b(paramInt);
    if (localo != null)
      return localo;
    return this.a;
  }

  public o a(b paramb)
  {
    return a(paramb.a());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.i
 * JD-Core Version:    0.6.2
 */