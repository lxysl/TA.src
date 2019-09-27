package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.p;
import java.util.BitSet;

public final class h extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new h();

  public int a()
  {
    return 2;
  }

  public String a(com.android.cglib.dx.a.a.h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    p localp = (p)((f)paramh).b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(0).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(a(localp));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, com.android.cglib.dx.a.a.h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    p localp = (p)((f)paramh).b();
    if (localn.b(0).i() == 1);
    short s;
    for (int i = localp.g() >>> 16; ; i = (int)(localp.h() >>> 48))
    {
      s = (short)i;
      break;
    }
    a(parama, a(paramh, localn.b(0).e()), s);
  }

  public String b(com.android.cglib.dx.a.a.h paramh, boolean paramBoolean)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    p localp = (p)((f)paramh).b();
    int i;
    if (localn.b(0).i() == 1)
      i = 32;
    else
      i = 64;
    return a(localp, i);
  }

  public boolean b(com.android.cglib.dx.a.a.h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    boolean bool1 = paramh instanceof f;
    boolean bool2 = false;
    if (bool1)
    {
      int i = localn.a();
      bool2 = false;
      if (i == 1)
      {
        if (!d(localn.b(0).e()))
          return false;
        com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
        if (!(locala instanceof p))
          return false;
        p localp = (p)locala;
        if (localn.b(0).i() == 1)
        {
          int j = 0xFFFF & localp.g();
          boolean bool4 = false;
          if (j == 0)
            bool4 = true;
          return bool4;
        }
        boolean bool3 = (0xFFFFFFFF & localp.h()) < 0L;
        bool2 = false;
        if (!bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  public BitSet c(com.android.cglib.dx.a.a.h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(1);
    localBitSet.set(0, d(localn.b(0).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.h
 * JD-Core Version:    0.6.2
 */