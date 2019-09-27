package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.p;
import java.util.BitSet;

public final class c extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new c();

  public int a()
  {
    return 1;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    p localp = (p)((f)paramh).b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(0).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(a(localp));
    return localStringBuilder.toString();
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = ((p)((f)paramh).b()).g();
    a(parama, a(paramh, b(localn.b(0).e(), i & 0xF)));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return a((p)((f)paramh).b(), 4);
  }

  public boolean b(h paramh)
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
        if (!b(localn.b(0).e()))
          return false;
        com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
        if (!(locala instanceof p))
          return false;
        p localp = (p)locala;
        boolean bool3 = localp.f();
        bool2 = false;
        if (bool3)
        {
          boolean bool4 = a(localp.g());
          bool2 = false;
          if (bool4)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  public BitSet c(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    BitSet localBitSet = new BitSet(1);
    localBitSet.set(0, b(localn.b(0).e()));
    return localBitSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.c
 * JD-Core Version:    0.6.2
 */