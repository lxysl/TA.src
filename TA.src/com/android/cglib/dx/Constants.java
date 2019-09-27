package com.android.cglib.dx;

import com.android.cglib.dx.c.c.e;
import com.android.cglib.dx.c.c.f;
import com.android.cglib.dx.c.c.g;
import com.android.cglib.dx.c.c.h;
import com.android.cglib.dx.c.c.k;
import com.android.cglib.dx.c.c.l;
import com.android.cglib.dx.c.c.m;
import com.android.cglib.dx.c.c.q;
import com.android.cglib.dx.c.c.u;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.c.x;

final class Constants
{
  static x a(Object paramObject)
  {
    if (paramObject == null)
      return m.a;
    if ((paramObject instanceof Boolean))
      return e.a(((Boolean)paramObject).booleanValue());
    if ((paramObject instanceof Byte))
      return f.a(((Byte)paramObject).byteValue());
    if ((paramObject instanceof Character))
      return g.a(((Character)paramObject).charValue());
    if ((paramObject instanceof Double))
      return h.a(Double.doubleToLongBits(((Double)paramObject).doubleValue()));
    if ((paramObject instanceof Float))
      return k.a(Float.floatToIntBits(((Float)paramObject).floatValue()));
    if ((paramObject instanceof Integer))
      return l.a(((Integer)paramObject).intValue());
    if ((paramObject instanceof Long))
      return q.a(((Long)paramObject).longValue());
    if ((paramObject instanceof Short))
      return u.a(((Short)paramObject).shortValue());
    if ((paramObject instanceof String))
      return new v((String)paramObject);
    if ((paramObject instanceof Class))
      return new w(TypeId.get((Class)paramObject).b);
    if ((paramObject instanceof TypeId))
      return new w(((TypeId)paramObject).b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a constant: ");
    localStringBuilder.append(paramObject);
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.Constants
 * JD-Core Version:    0.6.2
 */