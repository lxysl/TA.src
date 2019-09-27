package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.w;
import java.util.BitSet;

public final class l extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new l();

  public int a()
  {
    return 2;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(0).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(localn.b(1).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(f(paramh));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = ((f)paramh).c();
    a(parama, a(paramh, b(localn.b(0).e(), localn.b(1).e())), (short)i);
  }

  public String b(h paramh, boolean paramBoolean)
  {
    if (paramBoolean)
      return g(paramh);
    return "";
  }

  public boolean b(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    if (((paramh instanceof f)) && (localn.a() == 2) && (b(localn.b(0).e())))
    {
      int i = 1;
      if (!b(localn.b(i).e()))
        return false;
      f localf = (f)paramh;
      if (!f(localf.c()))
        return false;
      com.android.cglib.dx.c.c.a locala = localf.b();
      boolean bool;
      if (!(locala instanceof w))
      {
        if ((locala instanceof j))
          return i;
        bool = false;
      }
      return bool;
    }
    return false;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, b(localn.b(0).e()));
    localBitSet.set(1, b(localn.b(1).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.l
 * JD-Core Version:    0.6.2
 */