package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.a.a.x;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.d.a;
import java.util.BitSet;

public final class u extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new u();

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
    localStringBuilder.append(localn.b(1).k());
    return localStringBuilder.toString();
  }

  public void a(a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    a(parama, a(paramh, 0), (short)localn.b(0).e(), (short)localn.b(1).e());
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return "";
  }

  public boolean b(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    return ((paramh instanceof x)) && (localn.a() == 2) && (f(localn.b(0).e())) && (f(localn.b(1).e()));
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, f(localn.b(0).e()));
    localBitSet.set(1, f(localn.b(1).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.u
 * JD-Core Version:    0.6.2
 */