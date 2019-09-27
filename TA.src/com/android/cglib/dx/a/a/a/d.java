package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.a.a.x;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.d.a;
import java.util.BitSet;

public final class d extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new d();

  public int a()
  {
    return 1;
  }

  public String a(h paramh)
  {
    return paramh.i().b(0).k();
  }

  public void a(a parama, h paramh)
  {
    a(parama, a(paramh, paramh.i().b(0).e()));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return "";
  }

  public boolean b(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    boolean bool1 = paramh instanceof x;
    boolean bool2 = false;
    if (bool1)
    {
      int i = localn.a();
      bool2 = false;
      if (i == 1)
      {
        boolean bool3 = d(localn.b(0).e());
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
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
 * Qualified Name:     com.android.cglib.dx.a.a.a.d
 * JD-Core Version:    0.6.2
 */