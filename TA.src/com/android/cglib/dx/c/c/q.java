package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class q extends o
{
  public static final q a = a(0L);
  public static final q b = a(1L);

  private q(long paramLong)
  {
    super(paramLong);
  }

  public static q a(long paramLong)
  {
    return new q(paramLong);
  }

  public String a_()
  {
    return Long.toString(h());
  }

  public c b()
  {
    return c.g;
  }

  public String e()
  {
    return "long";
  }

  public String toString()
  {
    long l = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("long{0x");
    localStringBuilder.append(i.a(l));
    localStringBuilder.append(" / ");
    localStringBuilder.append(l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.q
 * JD-Core Version:    0.6.2
 */