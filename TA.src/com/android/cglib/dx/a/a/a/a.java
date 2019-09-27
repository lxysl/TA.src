package com.android.cglib.dx.a.a.a;

import com.android.cglib.dx.a.a.h;
import com.android.cglib.dx.a.a.z;

public final class a extends com.android.cglib.dx.a.a.n
{
  public static final com.android.cglib.dx.a.a.n b = new a();

  public int a()
  {
    return 1;
  }

  public String a(h paramh)
  {
    return d(paramh);
  }

  public void a(com.android.cglib.dx.d.a parama, h paramh)
  {
    a(parama, a(paramh, 0xFF & ((z)paramh).d()));
  }

  public boolean a(z paramz)
  {
    int i = paramz.d();
    return (i != 0) && (c(i));
  }

  public String b(h paramh, boolean paramBoolean)
  {
    return e(paramh);
  }

  public boolean b(h paramh)
  {
    if (((paramh instanceof z)) && (paramh.i().a() == 0))
    {
      z localz = (z)paramh;
      if (localz.o())
        return a(localz);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.a.a
 * JD-Core Version:    0.6.2
 */