package com.android.cglib.dx;

import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.d.c;

public final class Local<T>
{
  final TypeId<T> a;
  private final Code b;
  private int c = -1;
  private m d;

  private Local(Code paramCode, TypeId<T> paramTypeId)
  {
    this.b = paramCode;
    this.a = paramTypeId;
  }

  static <T> Local<T> a(Code paramCode, TypeId<T> paramTypeId)
  {
    return new Local(paramCode, paramTypeId);
  }

  int a()
  {
    return this.a.b.g();
  }

  int a(int paramInt)
  {
    this.c = paramInt;
    this.d = m.a(paramInt, this.a.b);
    return a();
  }

  m b()
  {
    if (this.d == null)
    {
      this.b.a();
      if (this.d == null)
        throw new AssertionError();
    }
    return this.d;
  }

  public TypeId getType()
  {
    return this.a;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(this.c);
    localStringBuilder.append("(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.Local
 * JD-Core Version:    0.6.2
 */