package com.android.cglib.dx.c.c;

import com.android.cglib.dx.d.r;

public abstract class a
  implements r, Comparable<a>
{
  public final int a(a parama)
  {
    Class localClass1 = getClass();
    Class localClass2 = parama.getClass();
    if (localClass1 != localClass2)
      return localClass1.getName().compareTo(localClass2.getName());
    return b(parama);
  }

  protected abstract int b(a parama);

  public abstract String e();
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.a
 * JD-Core Version:    0.6.2
 */