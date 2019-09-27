package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.f;
import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.w;
import java.util.BitSet;

public final class z extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new z();

  public int a()
  {
    return 5;
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
    a(parama, h(paramh), i, (short)localn.b(0).e(), (short)localn.b(1).e());
  }

  public String b(h paramh, boolean paramBoolean)
  {
    if (paramBoolean)
      return g(paramh);
    return "";
  }

  public boolean b(h paramh)
  {
    if (!a)
      return false;
    com.android.cglib.dx.c.b.n localn = paramh.i();
    boolean bool1 = paramh instanceof f;
    boolean bool2 = false;
    if (bool1)
    {
      int i = localn.a();
      bool2 = false;
      if (i == 2)
      {
        boolean bool3 = f(localn.b(0).e());
        bool2 = false;
        if (bool3)
        {
          if (!f(localn.b(1).e()))
            return false;
          com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
          if (!(locala instanceof w))
          {
            boolean bool4 = locala instanceof j;
            bool2 = false;
            if (!bool4);
          }
          else
          {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
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
 * Qualified Name:     com.android.cglib.dx.a.a.a.z
 * JD-Core Version:    0.6.2
 */