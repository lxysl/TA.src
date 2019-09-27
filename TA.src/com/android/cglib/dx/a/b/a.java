package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.a.b;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public final class a extends ag
{
  private static final a a = new a(null);
  private final com.android.cglib.dx.c.a.a b;
  private ap c;
  private byte[] d;

  public static void a(a[] paramArrayOfa)
  {
    Arrays.sort(paramArrayOfa, a);
  }

  protected int a(ag paramag)
  {
    a locala = (a)paramag;
    return this.b.a(locala.b);
  }

  public y a()
  {
    return y.p;
  }

  protected void a(ak paramak, int paramInt)
  {
    com.android.cglib.dx.d.d locald = new com.android.cglib.dx.d.d();
    new au(paramak.e(), locald).a(this.b, false);
    this.d = locald.f();
    a(1 + this.d.length);
  }

  public void a(l paraml)
  {
    this.c = paraml.j().a(this.b.b());
    au.a(paraml, this.b);
  }

  public void a(com.android.cglib.dx.d.a parama, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("visibility: ");
    localStringBuilder1.append(this.b.c().a_());
    parama.a(0, localStringBuilder1.toString());
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString);
    localStringBuilder2.append("type: ");
    localStringBuilder2.append(this.b.b().a_());
    parama.a(0, localStringBuilder2.toString());
    Iterator localIterator = this.b.d().iterator();
    while (localIterator.hasNext())
    {
      com.android.cglib.dx.c.a.d locald = (com.android.cglib.dx.c.a.d)localIterator.next();
      v localv = locald.a();
      com.android.cglib.dx.c.c.a locala = locald.b();
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(paramString);
      localStringBuilder3.append(localv.a_());
      localStringBuilder3.append(": ");
      localStringBuilder3.append(au.b(locala));
      parama.a(0, localStringBuilder3.toString());
    }
  }

  protected void a_(l paraml, com.android.cglib.dx.d.a parama)
  {
    boolean bool = parama.a();
    b localb = this.b.c();
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(" annotation");
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  visibility: VISBILITY_");
      localStringBuilder2.append(localb);
      parama.a(1, localStringBuilder2.toString());
    }
    switch (1.a[localb.ordinal()])
    {
    default:
      throw new RuntimeException("shouldn't happen");
    case 3:
      parama.b(2);
      break;
    case 2:
      parama.b(1);
      break;
    case 1:
      parama.b(0);
    }
    if (bool)
    {
      new au(paraml, parama).a(this.b, true);
      return;
    }
    parama.a(this.d);
  }

  public String b()
  {
    return this.b.a_();
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  private static class a
    implements Comparator<a>
  {
    public int a(a parama1, a parama2)
    {
      int i = a.a(parama1).g();
      int j = a.a(parama2).g();
      if (i < j)
        return -1;
      if (i > j)
        return 1;
      return 0;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.a
 * JD-Core Version:    0.6.2
 */