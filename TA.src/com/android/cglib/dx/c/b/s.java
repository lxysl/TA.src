package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.d.i;

public final class s
{
  public static final s a = new s(null, -1, -1);
  private final v b;
  private final int c;
  private final int d;

  public s(v paramv, int paramInt1, int paramInt2)
  {
    if (paramInt1 < -1)
      throw new IllegalArgumentException("address < -1");
    if (paramInt2 < -1)
      throw new IllegalArgumentException("line < -1");
    this.b = paramv;
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public int a()
  {
    return this.d;
  }

  public boolean a(s params)
  {
    return this.d == params.d;
  }

  public boolean b(s params)
  {
    return (this.d == params.d) && ((this.b == params.b) || ((this.b != null) && (this.b.equals(params.b))));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof s))
      return false;
    if (this == paramObject)
      return true;
    s locals = (s)paramObject;
    return (this.c == locals.c) && (b(locals));
  }

  public int hashCode()
  {
    return this.b.hashCode() + this.c + this.d;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(50);
    if (this.b != null)
    {
      localStringBuffer.append(this.b.a_());
      localStringBuffer.append(":");
    }
    if (this.d >= 0)
      localStringBuffer.append(this.d);
    localStringBuffer.append('@');
    if (this.c < 0);
    for (String str = "????"; ; str = i.c(this.c))
    {
      localStringBuffer.append(str);
      break;
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.s
 * JD-Core Version:    0.6.2
 */