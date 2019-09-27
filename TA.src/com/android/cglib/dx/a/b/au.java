package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.a.d;
import com.android.cglib.dx.c.c.b;
import com.android.cglib.dx.c.c.c;
import com.android.cglib.dx.c.c.c.a;
import com.android.cglib.dx.c.c.e;
import com.android.cglib.dx.c.c.f;
import com.android.cglib.dx.c.c.g;
import com.android.cglib.dx.c.c.h;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.k;
import com.android.cglib.dx.c.c.m;
import com.android.cglib.dx.c.c.p;
import com.android.cglib.dx.c.c.q;
import com.android.cglib.dx.c.c.u;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import java.util.Collection;
import java.util.Iterator;

public final class au
{
  private final l a;
  private final com.android.cglib.dx.d.a b;

  public au(l paraml, com.android.cglib.dx.d.a parama)
  {
    if (paraml == null)
      throw new NullPointerException("file == null");
    if (parama == null)
      throw new NullPointerException("out == null");
    this.a = paraml;
    this.b = parama;
  }

  private void a(int paramInt, long paramLong)
  {
    int i = 7 + (65 - Long.numberOfLeadingZeros(paramLong ^ paramLong >> 63)) >> 3;
    this.b.b(paramInt | i - 1 << 5);
    while (i > 0)
    {
      this.b.b((byte)(int)paramLong);
      paramLong >>= 8;
      i--;
    }
  }

  public static void a(l paraml, com.android.cglib.dx.c.a.a parama)
  {
    aq localaq = paraml.j();
    ao localao = paraml.g();
    localaq.a(parama.b());
    Iterator localIterator = parama.d().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      localao.a(locald.a());
      a(paraml, locald.b());
    }
  }

  public static void a(l paraml, com.android.cglib.dx.c.c.a parama)
  {
    if ((parama instanceof b))
    {
      a(paraml, ((b)parama).b());
      return;
    }
    if ((parama instanceof c))
    {
      c.a locala = ((c)parama).b();
      int i = locala.a();
      for (int j = 0; j < i; j++)
        a(paraml, locala.a(j));
    }
    paraml.a(parama);
  }

  public static String b(com.android.cglib.dx.c.c.a parama)
  {
    if (c(parama) == 30)
      return "null";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.e());
    localStringBuilder.append(' ');
    localStringBuilder.append(parama.a_());
    return localStringBuilder.toString();
  }

  private void b(int paramInt, long paramLong)
  {
    int i = 64 - Long.numberOfLeadingZeros(paramLong);
    if (i == 0)
      i = 1;
    int j = i + 7 >> 3;
    this.b.b(paramInt | j - 1 << 5);
    while (j > 0)
    {
      this.b.b((byte)(int)paramLong);
      paramLong >>= 8;
      j--;
    }
  }

  private static int c(com.android.cglib.dx.c.c.a parama)
  {
    if ((parama instanceof f))
      return 0;
    if ((parama instanceof u))
      return 2;
    if ((parama instanceof g))
      return 3;
    if ((parama instanceof com.android.cglib.dx.c.c.l))
      return 4;
    if ((parama instanceof q))
      return 6;
    if ((parama instanceof k))
      return 16;
    if ((parama instanceof h))
      return 17;
    if ((parama instanceof v))
      return 23;
    if ((parama instanceof w))
      return 24;
    if ((parama instanceof j))
      return 25;
    if ((parama instanceof com.android.cglib.dx.c.c.s))
      return 26;
    if ((parama instanceof com.android.cglib.dx.c.c.i))
      return 27;
    if ((parama instanceof c))
      return 28;
    if ((parama instanceof b))
      return 29;
    if ((parama instanceof m))
      return 30;
    if ((parama instanceof e))
      return 31;
    throw new RuntimeException("Shouldn't happen");
  }

  private void c(int paramInt, long paramLong)
  {
    int i = 64 - Long.numberOfTrailingZeros(paramLong);
    if (i == 0)
      i = 1;
    int j = i + 7 >> 3;
    long l = paramLong >> 64 - j * 8;
    this.b.b(paramInt | j - 1 << 5);
    while (j > 0)
    {
      this.b.b((byte)(int)l);
      l >>= 8;
      j--;
    }
  }

  public void a(com.android.cglib.dx.c.a.a parama, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (this.b.a()))
      i = 1;
    else
      i = 0;
    ao localao = this.a.g();
    aq localaq = this.a.j();
    w localw = parama.b();
    int j = localaq.b(localw);
    if (i != 0)
    {
      com.android.cglib.dx.d.a locala5 = this.b;
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("  type_idx: ");
      localStringBuilder5.append(com.android.cglib.dx.d.i.a(j));
      localStringBuilder5.append(" // ");
      localStringBuilder5.append(localw.a_());
      locala5.a(localStringBuilder5.toString());
    }
    this.b.e(localaq.b(parama.b()));
    Collection localCollection = parama.d();
    int k = localCollection.size();
    if (i != 0)
    {
      com.android.cglib.dx.d.a locala4 = this.b;
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  size: ");
      localStringBuilder4.append(com.android.cglib.dx.d.i.a(k));
      locala4.a(localStringBuilder4.toString());
    }
    this.b.e(k);
    Iterator localIterator = localCollection.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      v localv = locald.a();
      int n = localao.b(localv);
      com.android.cglib.dx.c.c.a locala = locald.b();
      if (i != 0)
      {
        com.android.cglib.dx.d.a locala2 = this.b;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("  elements[");
        localStringBuilder2.append(m);
        localStringBuilder2.append("]:");
        locala2.a(0, localStringBuilder2.toString());
        m++;
        com.android.cglib.dx.d.a locala3 = this.b;
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("    name_idx: ");
        localStringBuilder3.append(com.android.cglib.dx.d.i.a(n));
        localStringBuilder3.append(" // ");
        localStringBuilder3.append(localv.a_());
        locala3.a(localStringBuilder3.toString());
      }
      this.b.e(n);
      if (i != 0)
      {
        com.android.cglib.dx.d.a locala1 = this.b;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("    value: ");
        localStringBuilder1.append(b(locala));
        locala1.a(localStringBuilder1.toString());
      }
      a(locala);
    }
    if (i != 0)
      this.b.c();
  }

  public void a(com.android.cglib.dx.c.c.a parama)
  {
    int i = c(parama);
    if ((i != 0) && (i != 6))
    {
      long l1;
      switch (i)
      {
      default:
        long l2;
        switch (i)
        {
        default:
          j localj;
          s locals;
          switch (i)
          {
          default:
            throw new RuntimeException("Shouldn't happen");
          case 31:
            int k = ((e)parama).g();
            this.b.b(i | k << 5);
            return;
          case 30:
            this.b.b(i);
            return;
          case 29:
            this.b.b(i);
            a(((b)parama).b(), false);
            return;
          case 28:
            this.b.b(i);
            a((c)parama, false);
            return;
          case 27:
            localj = ((com.android.cglib.dx.c.c.i)parama).f();
            locals = this.a.l();
            break;
          case 26:
            j = this.a.m().b((com.android.cglib.dx.c.c.s)parama);
            break;
          case 25:
            locals = this.a.l();
            localj = (j)parama;
            j = locals.b(localj);
            break;
          case 24:
            j = this.a.j().b((w)parama);
            break;
          case 23:
          }
          int j = this.a.g().b((v)parama);
          l1 = j;
          break;
        case 17:
          l2 = ((h)parama).h();
          break;
        case 16:
          l2 = ((k)parama).h() << 32;
        }
        c(i, l2);
        return;
      case 3:
        l1 = ((p)parama).h();
        b(i, l1);
        return;
      case 2:
      case 4:
      }
    }
    a(i, ((p)parama).h());
  }

  public void a(c paramc, boolean paramBoolean)
  {
    int i = 0;
    int j;
    if ((paramBoolean) && (this.b.a()))
      j = 1;
    else
      j = 0;
    c.a locala = paramc.b();
    int k = locala.a();
    if (j != 0)
    {
      com.android.cglib.dx.d.a locala3 = this.b;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  size: ");
      localStringBuilder2.append(com.android.cglib.dx.d.i.a(k));
      locala3.a(localStringBuilder2.toString());
    }
    this.b.e(k);
    while (i < k)
    {
      com.android.cglib.dx.c.c.a locala1 = locala.a(i);
      if (j != 0)
      {
        com.android.cglib.dx.d.a locala2 = this.b;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("  [");
        localStringBuilder1.append(Integer.toHexString(i));
        localStringBuilder1.append("] ");
        localStringBuilder1.append(b(locala1));
        locala2.a(localStringBuilder1.toString());
      }
      a(locala1);
      i++;
    }
    if (j != 0)
      this.b.c();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.au
 * JD-Core Version:    0.6.2
 */