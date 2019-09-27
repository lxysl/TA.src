package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.a.a.x;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.d.a;
import java.util.BitSet;

public final class e extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new e();

  public int a()
  {
    return 1;
  }

  public String a(h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = localn.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localn.b(i - 2).k());
    localStringBuilder.append(", ");
    localStringBuilder.append(localn.b(i - 1).k());
    return localStringBuilder.toString();
  }

  public void a(a parama, h paramh)
  {
    com.android.cglib.dx.c.b.n localn = paramh.i();
    int i = localn.a();
    a(parama, a(paramh, b(localn.b(i - 2).e(), localn.b(i - 1).e())));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return "";
  }

  public boolean b(h paramh)
  {
    if (!(paramh instanceof x))
      return false;
    com.android.cglib.dx.c.b.n localn = paramh.i();
    m localm1;
    m localm2;
    switch (localn.a())
    {
    default:
      return false;
    case 3:
      localm1 = localn.b(1);
      localm2 = localn.b(2);
      if (localm1.e() != localn.b(0).e())
        return false;
      break;
    case 2:
      localm1 = localn.b(0);
      localm2 = localn.b(1);
    }
    boolean bool1 = b(localm1.e());
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = b(localm2.e());
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
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
 * Qualified Name:     com.android.cglib.dx.a.a.a.e
 * JD-Core Version:    0.6.2
 */