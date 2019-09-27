package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.p;
import java.util.BitSet;

public final class k extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new k();

  public int a()
  {
    return 2;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    p localp = (p)((f)paramh).b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(0).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(localn.b(1).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(a(localp));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = ((p)((f)paramh).b()).g();
    a(parama, a(paramh, localn.b(0).e()), a(localn.b(1).e(), i & 0xFF));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return a((p)((f)paramh).b(), 8);
  }

  public boolean b(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    if (((paramh instanceof f)) && (localn.a() == 2) && (d(localn.b(0).e())))
    {
      if (!d(localn.b(1).e()))
        return false;
      com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
      if (!(locala instanceof p))
        return false;
      p localp = (p)locala;
      return (localp.f()) && (c(localp.g()));
    }
    return false;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, d(localn.b(0).e()));
    localBitSet.set(1, d(localn.b(1).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.k
 * JD-Core Version:    0.6.2
 */