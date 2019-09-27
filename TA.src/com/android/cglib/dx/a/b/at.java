package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.util.Iterator;
import java.util.List;

public final class at<T extends ag> extends ag
{
  private final y a;
  private final List<T> b;

  public at(y paramy, List<T> paramList)
  {
    super(a(paramList), b(paramList));
    if (paramy == null)
      throw new NullPointerException("itemType == null");
    this.b = paramList;
    this.a = paramy;
  }

  // ERROR //
  private static int a(List<? extends ag> paramList)
  {
    // Byte code:
    //   0: iconst_4
    //   1: aload_0
    //   2: iconst_0
    //   3: invokeinterface 39 2 0
    //   8: checkcast 5	com/android/cglib/dx/a/b/ag
    //   11: invokevirtual 43	com/android/cglib/dx/a/b/ag:f	()I
    //   14: invokestatic 49	java/lang/Math:max	(II)I
    //   17: istore_1
    //   18: iload_1
    //   19: ireturn
    //   20: new 22	java/lang/NullPointerException
    //   23: dup
    //   24: ldc 51
    //   26: invokespecial 27	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: new 53	java/lang/IllegalArgumentException
    //   33: dup
    //   34: ldc 55
    //   36: invokespecial 56	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	20	java/lang/NullPointerException
    //   0	18	30	java/lang/IndexOutOfBoundsException
  }

  private static int b(List<? extends ag> paramList)
  {
    ag localag = (ag)paramList.get(0);
    return paramList.size() * localag.b_() + a(paramList);
  }

  private int d()
  {
    return f();
  }

  public y a()
  {
    return this.a;
  }

  protected void a(ak paramak, int paramInt)
  {
    int i = paramInt + d();
    Iterator localIterator = this.b.iterator();
    int j = -1;
    int k = 1;
    int m = i;
    int n = -1;
    while (localIterator.hasNext())
    {
      ag localag = (ag)localIterator.next();
      int i1 = localag.b_();
      if (k != 0)
      {
        n = localag.f();
        j = i1;
        k = 0;
      }
      else
      {
        if (i1 != j)
          throw new UnsupportedOperationException("item size mismatch");
        if (localag.f() != n)
          throw new UnsupportedOperationException("item alignment mismatch");
      }
      m = i1 + localag.b(paramak, m);
    }
  }

  public void a(l paraml)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((ag)localIterator.next()).a(paraml);
  }

  protected void a_(l paraml, a parama)
  {
    int i = this.b.size();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(" ");
      localStringBuilder1.append(i());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  size: ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
    }
    parama.d(i);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((ag)localIterator.next()).a(paraml, parama);
  }

  public final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("{");
    Iterator localIterator = this.b.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      ag localag = (ag)localIterator.next();
      if (i != 0)
        i = 0;
      else
        localStringBuffer.append(", ");
      localStringBuffer.append(localag.b());
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }

  public final List<T> c()
  {
    return this.b;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append(this.b);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.at
 * JD-Core Version:    0.6.2
 */