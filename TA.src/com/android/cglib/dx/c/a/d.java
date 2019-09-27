package com.android.cglib.dx.c.a;

import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.c.v;

public final class d
  implements Comparable<d>
{
  private final v a;
  private final a b;

  public int a(d paramd)
  {
    int i = this.a.a(paramd.a);
    if (i != 0)
      return i;
    return this.b.a(paramd.b);
  }

  public v a()
  {
    return this.a;
  }

  public a b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d))
      return false;
    d locald = (d)paramObject;
    boolean bool1 = this.a.equals(locald.a);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.b.equals(locald.b);
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a_());
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.a.d
 * JD-Core Version:    0.6.2
 */