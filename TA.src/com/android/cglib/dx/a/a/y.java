package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.f;
import com.android.cglib.dx.c.b.q;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.d.k;
import java.util.ArrayList;
import java.util.HashSet;

public final class y
  implements b
{
  private final q a;
  private final int[] b;
  private final a c;

  public y(q paramq, int[] paramArrayOfInt, a parama)
  {
    if (paramq == null)
      throw new NullPointerException("method == null");
    if (paramArrayOfInt == null)
      throw new NullPointerException("order == null");
    if (parama == null)
      throw new NullPointerException("addresses == null");
    this.a = paramq;
    this.b = paramArrayOfInt;
    this.c = parama;
  }

  private static c a(com.android.cglib.dx.c.b.b paramb, a parama)
  {
    k localk = paramb.c();
    int i = localk.a();
    int j = paramb.d();
    com.android.cglib.dx.c.d.e locale = paramb.f().i();
    int k = locale.a();
    if (k == 0)
      return c.a;
    if (((j == -1) && (i != k)) || ((j != -1) && ((i != k + 1) || (j != localk.a(k)))))
      throw new RuntimeException("shouldn't happen: weird successors list");
    int m = 0;
    for (int n = 0; n < k; n++)
      if (locale.a(n).equals(com.android.cglib.dx.c.d.c.o))
      {
        k = n + 1;
        break;
      }
    c localc = new c(k);
    while (m < k)
    {
      localc.a(m, new w(locale.a(m)), parama.a(localk.a(m)).f());
      m++;
    }
    localc.e();
    return localc;
  }

  private static d.a a(com.android.cglib.dx.c.b.b paramb1, com.android.cglib.dx.c.b.b paramb2, c paramc, a parama)
  {
    e locale1 = parama.b(paramb1);
    e locale2 = parama.c(paramb2);
    return new d.a(locale1.f(), locale2.f(), paramc);
  }

  public static d a(q paramq, int[] paramArrayOfInt, a parama)
  {
    int i = paramArrayOfInt.length;
    com.android.cglib.dx.c.b.c localc = paramq.a();
    ArrayList localArrayList = new ArrayList(i);
    c localc1 = c.a;
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localc1;
    for (int k = 0; k < i; k++)
    {
      com.android.cglib.dx.c.b.b localb = localc.b(paramArrayOfInt[k]);
      if (localb.g())
      {
        c localc2 = a(localb, parama);
        if (((c)localObject3).a() != 0)
        {
          if ((((c)localObject3).equals(localc2)) && (a((com.android.cglib.dx.c.b.b)localObject1, localb, parama)))
          {
            localObject2 = localb;
            continue;
          }
          if (((c)localObject3).a() != 0)
            localArrayList.add(a((com.android.cglib.dx.c.b.b)localObject1, localObject2, (c)localObject3, parama));
        }
        localObject1 = localb;
        localObject2 = localObject1;
        localObject3 = localc2;
      }
    }
    if (((c)localObject3).a() != 0)
      localArrayList.add(a((com.android.cglib.dx.c.b.b)localObject1, localObject2, (c)localObject3, parama));
    int m = localArrayList.size();
    if (m == 0)
      return d.a;
    d locald = new d(m);
    while (j < m)
    {
      locald.a(j, (d.a)localArrayList.get(j));
      j++;
    }
    locald.e();
    return locald;
  }

  private static boolean a(com.android.cglib.dx.c.b.b paramb1, com.android.cglib.dx.c.b.b paramb2, a parama)
  {
    if (paramb1 == null)
      throw new NullPointerException("start == null");
    if (paramb2 == null)
      throw new NullPointerException("end == null");
    int i = parama.b(paramb1).f();
    return parama.c(paramb2).f() - i <= 65535;
  }

  public d a()
  {
    return a(this.a, this.b, this.c);
  }

  public boolean b()
  {
    com.android.cglib.dx.c.b.c localc = this.a.a();
    int i = localc.a();
    for (int j = 0; j < i; j++)
      if (localc.a(j).f().i().a() != 0)
        return true;
    return false;
  }

  public HashSet<com.android.cglib.dx.c.d.c> c()
  {
    HashSet localHashSet = new HashSet(20);
    com.android.cglib.dx.c.b.c localc = this.a.a();
    int i = localc.a();
    for (int j = 0; j < i; j++)
    {
      com.android.cglib.dx.c.d.e locale = localc.a(j).f().i();
      int k = locale.a();
      for (int m = 0; m < k; m++)
        localHashSet.add(locale.a(m));
    }
    return localHashSet;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.y
 * JD-Core Version:    0.6.2
 */