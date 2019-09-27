package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import java.util.BitSet;

public final class r extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new r();

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
    localStringBuilder.append(f(paramh));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = ((f)paramh).c();
    a(parama, a(paramh, localn.b(0).e()), i);
  }

  public String b(h paramh, boolean paramBoolean)
  {
    if (paramBoolean)
      return g(paramh);
    return "";
  }

  public boolean b(h paramh)
  {
    if (!(paramh instanceof f))
      return false;
    com.android.cglib.dx.c.b.n localn = paramh.i();
    m localm;
    switch (localn.a())
    {
    default:
      return false;
    case 2:
      localm = localn.b(0);
      if (localm.e() != localn.b(1).e())
        return false;
      break;
    case 1:
      localm = localn.b(0);
    }
    if (!d(localm.e()))
      return false;
    com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
    boolean bool1;
    if ((!(locala instanceof w)) && (!(locala instanceof j)))
    {
      boolean bool2 = locala instanceof v;
      bool1 = false;
      if (!bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = localn.a();
    BitSet localBitSet = new BitSet(i);
    boolean bool = d(localn.b(0).e());
    if (i == 1)
    {
      localBitSet.set(0, bool);
      return localBitSet;
    }
    if (localn.b(0).e() == localn.b(1).e())
    {
      localBitSet.set(0, bool);
      localBitSet.set(1, bool);
    }
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.r
 * JD-Core Version:    0.6.2
 */