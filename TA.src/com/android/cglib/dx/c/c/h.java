package com.android.cglib.dx.c.c;

import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.i;

public final class h extends o
{
  public static final h a = new h(Double.doubleToLongBits(0.0D));
  public static final h b = new h(Double.doubleToLongBits(1.0D));

  private h(long paramLong)
  {
    super(paramLong);
  }

  public static h a(long paramLong)
  {
    return new h(paramLong);
  }

  public String a_()
  {
    return Double.toString(Double.longBitsToDouble(h()));
  }

  public c b()
  {
    return c.d;
  }

  public String e()
  {
    return "double";
  }

  public String toString()
  {
    long l = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("double{0x");
    localStringBuilder.append(i.a(l));
    localStringBuilder.append(" / ");
    localStringBuilder.append(Double.longBitsToDouble(l));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.c.h
 * JD-Core Version:    0.6.2
 */