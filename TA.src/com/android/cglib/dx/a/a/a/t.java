package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.a.a.z;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.d.a;
import java.util.BitSet;

public final class t extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new t();

  public int a()
  {
    return 3;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(0).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(d(paramh));
    return localStringBuilder.toString();
  }

  public void a(a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = ((z)paramh).d();
    a(parama, a(paramh, localn.b(0).e()), i);
  }

  public boolean a(z paramz)
  {
    return true;
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return e(paramh);
  }

  public boolean b(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    if (((paramh instanceof z)) && (localn.a() == 1))
      return d(localn.b(0).e());
    return false;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(1);
    localBitSet.set(0, d(localn.b(0).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.t
 * JD-Core Version:    0.6.2
 */