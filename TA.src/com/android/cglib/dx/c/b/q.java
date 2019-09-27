package com.android.cglib.dx.c.b;

import com.android.cglib.dx.d.i;
import com.android.cglib.dx.d.k;

public final class q
{
  private final c a;
  private final int b;
  private k[] c;
  private k d;

  public q(c paramc, int paramInt)
  {
    if (paramc == null)
      throw new NullPointerException("blocks == null");
    if (paramInt < 0)
      throw new IllegalArgumentException("firstLabel < 0");
    this.a = paramc;
    this.b = paramInt;
    this.c = null;
    this.d = null;
  }

  private void c()
  {
    int i = this.a.d();
    k[] arrayOfk = new k[i];
    k localk1 = new k(10);
    int j = this.a.a();
    int m;
    for (int k = 0; ; k++)
    {
      m = 0;
      if (k >= j)
        break;
      b localb = this.a.a(k);
      int n = localb.a();
      k localk3 = localb.c();
      int i1 = localk3.a();
      if (i1 == 0)
        localk1.b(n);
      else
        for (int i2 = 0; i2 < i1; i2++)
        {
          int i3 = localk3.a(i2);
          k localk4 = arrayOfk[i3];
          if (localk4 == null)
          {
            localk4 = new k(10);
            arrayOfk[i3] = localk4;
          }
          localk4.b(n);
        }
    }
    while (m < i)
    {
      k localk2 = arrayOfk[m];
      if (localk2 != null)
      {
        localk2.b();
        localk2.e();
      }
      m++;
    }
    localk1.b();
    localk1.e();
    if (arrayOfk[this.b] == null)
      arrayOfk[this.b] = k.a;
    this.c = arrayOfk;
    this.d = localk1;
  }

  public c a()
  {
    return this.a;
  }

  public k a(int paramInt)
  {
    if (this.d == null)
      c();
    k localk = this.c[paramInt];
    if (localk == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such block: ");
      localStringBuilder.append(i.c(paramInt));
      throw new RuntimeException(localStringBuilder.toString());
    }
    return localk;
  }

  public int b()
  {
    return this.b;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.q
 * JD-Core Version:    0.6.2
 */