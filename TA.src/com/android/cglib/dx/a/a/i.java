package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.c.d;
import com.android.cglib.dx.d.g;
import java.util.ArrayList;

public final class i extends com.android.cglib.dx.d.h
{
  private final int a;

  public i(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.a = paramInt2;
  }

  public static i a(ArrayList<h> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size();
    i locali = new i(i, paramInt);
    for (int j = 0; j < i; j++)
      locali.a(j, (h)paramArrayList.get(j));
    locali.e();
    return locali;
  }

  public h a(int paramInt)
  {
    return (h)d(paramInt);
  }

  public void a(int paramInt, h paramh)
  {
    a(paramInt, paramh);
  }

  public void a(com.android.cglib.dx.d.a parama)
  {
    int i = parama.g();
    int j = a();
    boolean bool1 = parama.a();
    int k = 0;
    if (bool1)
    {
      boolean bool2 = parama.b();
      for (int n = 0; ; n++)
      {
        k = 0;
        if (n >= j)
          break;
        h localh2 = (h)d(n);
        int i1 = 2 * localh2.n();
        String str;
        if ((i1 == 0) && (!bool2))
          str = null;
        else
          str = localh2.a("  ", parama.d(), true);
        if (str != null);
        while (true)
        {
          parama.a(i1, str);
          break;
          if (i1 == 0)
            break;
          str = "";
        }
      }
    }
    while (k < j)
    {
      h localh1 = (h)d(k);
      try
      {
        localh1.a(parama);
        k++;
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("...while writing ");
        localStringBuilder2.append(localh1);
        throw g.a(localRuntimeException, localStringBuilder2.toString());
      }
    }
    int m = (parama.g() - i) / 2;
    if (m != b())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("write length mismatch; expected ");
      localStringBuilder1.append(b());
      localStringBuilder1.append(" but actually wrote ");
      localStringBuilder1.append(m);
      throw new RuntimeException(localStringBuilder1.toString());
    }
  }

  public int b()
  {
    int i = a();
    if (i == 0)
      return 0;
    return a(i - 1).m();
  }

  public int c()
  {
    return this.a;
  }

  public int d()
  {
    int i = a();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      h localh = (h)d(j);
      if ((localh instanceof f))
      {
        com.android.cglib.dx.c.c.a locala = ((f)localh).b();
        if ((locala instanceof d))
        {
          boolean bool;
          if (localh.g().b() == 113)
            bool = true;
          else
            bool = false;
          int m = ((d)locala).b(bool);
          if (m > k)
            k = m;
        }
      }
      j++;
    }
    return k;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.i
 * JD-Core Version:    0.6.2
 */