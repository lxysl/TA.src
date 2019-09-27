package com.android.cglib.dx;

import com.android.cglib.dx.c.b.p;
import com.android.cglib.dx.c.b.r;

public enum UnaryOp
{
  static
  {
    // Byte code:
    //   0: new 14	com/android/cglib/dx/UnaryOp$1
    //   3: dup
    //   4: ldc 15
    //   6: iconst_0
    //   7: invokespecial 19	com/android/cglib/dx/UnaryOp$1:<init>	(Ljava/lang/String;I)V
    //   10: putstatic 21	com/android/cglib/dx/UnaryOp:NOT	Lcom/android/cglib/dx/UnaryOp;
    //   13: new 23	com/android/cglib/dx/UnaryOp$2
    //   16: dup
    //   17: ldc 24
    //   19: iconst_1
    //   20: invokespecial 25	com/android/cglib/dx/UnaryOp$2:<init>	(Ljava/lang/String;I)V
    //   23: putstatic 27	com/android/cglib/dx/UnaryOp:NEGATE	Lcom/android/cglib/dx/UnaryOp;
    //   26: iconst_2
    //   27: anewarray 2	com/android/cglib/dx/UnaryOp
    //   30: astore_0
    //   31: aload_0
    //   32: iconst_0
    //   33: getstatic 21	com/android/cglib/dx/UnaryOp:NOT	Lcom/android/cglib/dx/UnaryOp;
    //   36: aastore
    //   37: aload_0
    //   38: iconst_1
    //   39: getstatic 27	com/android/cglib/dx/UnaryOp:NEGATE	Lcom/android/cglib/dx/UnaryOp;
    //   42: aastore
    //   43: aload_0
    //   44: putstatic 29	com/android/cglib/dx/UnaryOp:$VALUES	[Lcom/android/cglib/dx/UnaryOp;
    //   47: return
  }

  abstract p rop(TypeId<?> paramTypeId);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.UnaryOp
 * JD-Core Version:    0.6.2
 */