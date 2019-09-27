package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.a.c;
import com.android.cglib.dx.a.a.c.a;
import com.android.cglib.dx.a.a.d.a;
import com.android.cglib.dx.a.a.g;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class e
{
  private final g a;
  private com.android.cglib.dx.a.a.d b;
  private byte[] c;
  private int d;
  private TreeMap<c, Integer> e;

  public e(g paramg)
  {
    this.a = paramg;
    this.b = null;
    this.c = null;
    this.d = 0;
    this.e = null;
  }

  private static void a(c paramc, int paramInt1, int paramInt2, String paramString, PrintWriter paramPrintWriter, a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i.c(paramInt1));
    localStringBuilder.append(": ");
    String str = paramc.a(paramString, localStringBuilder.toString());
    if (paramPrintWriter != null)
      paramPrintWriter.println(str);
    parama.a(paramInt2, str);
  }

  private void a(String paramString, PrintWriter paramPrintWriter, a parama)
  {
    c();
    int i = 0;
    int j;
    if (parama != null)
      j = 1;
    else
      j = 0;
    int k;
    if (j != 0)
      k = 6;
    else
      k = 0;
    int m;
    if (j != 0)
      m = 2;
    else
      m = 0;
    int n = this.b.a();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("  ");
    String str1 = localStringBuilder1.toString();
    if (j != 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("tries:");
      parama.a(0, localStringBuilder2.toString());
    }
    else
    {
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append(paramString);
      localStringBuilder6.append("tries:");
      paramPrintWriter.println(localStringBuilder6.toString());
    }
    for (int i1 = 0; i1 < n; i1++)
    {
      d.a locala = this.b.a(i1);
      c localc2 = locala.c();
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append(str1);
      localStringBuilder5.append("try ");
      localStringBuilder5.append(i.d(locala.a()));
      localStringBuilder5.append("..");
      localStringBuilder5.append(i.d(locala.b()));
      String str2 = localStringBuilder5.toString();
      String str3 = localc2.a(str1, "");
      if (j != 0)
      {
        parama.a(k, str2);
        parama.a(m, str3);
      }
      else
      {
        paramPrintWriter.println(str2);
        paramPrintWriter.println(str3);
      }
    }
    if (j == 0)
      return;
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append(paramString);
    localStringBuilder3.append("handlers:");
    parama.a(0, localStringBuilder3.toString());
    int i2 = this.d;
    StringBuilder localStringBuilder4 = new StringBuilder();
    localStringBuilder4.append(str1);
    localStringBuilder4.append("size: ");
    localStringBuilder4.append(i.c(this.e.size()));
    parama.a(i2, localStringBuilder4.toString());
    Object localObject = null;
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      c localc1 = (c)localEntry.getKey();
      int i3 = ((Integer)localEntry.getValue()).intValue();
      if (localObject != null)
        a((c)localObject, i, i3 - i, str1, paramPrintWriter, parama);
      localObject = localc1;
      i = i3;
    }
    a((c)localObject, i, this.c.length - i, str1, paramPrintWriter, parama);
  }

  private void c()
  {
    if (this.b == null)
      this.b = this.a.g();
  }

  public int a()
  {
    c();
    return this.b.a();
  }

  public void a(l paraml)
  {
    c();
    aq localaq = paraml.j();
    int i = this.b.a();
    this.e = new TreeMap();
    for (int j = 0; j < i; j++)
      this.e.put(this.b.a(j).c(), null);
    if (this.e.size() > 65535)
      throw new UnsupportedOperationException("too many catch handlers");
    com.android.cglib.dx.d.d locald = new com.android.cglib.dx.d.d();
    this.d = locald.e(this.e.size());
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      c localc = (c)localEntry.getKey();
      int k = localc.a();
      boolean bool = localc.b();
      localEntry.setValue(Integer.valueOf(locald.g()));
      if (bool)
      {
        locald.f(-(k - 1));
        k--;
      }
      else
      {
        locald.f(k);
      }
      for (int m = 0; m < k; m++)
      {
        c.a locala = localc.a(m);
        locald.e(localaq.b(locala.a()));
        locald.e(locala.b());
      }
      if (bool)
        locald.e(localc.a(k).b());
    }
    this.c = locald.f();
  }

  public void a(l paraml, a parama)
  {
    c();
    if (parama.a())
      a("  ", null, parama);
    int i = this.b.a();
    for (int j = 0; j < i; j++)
    {
      d.a locala = this.b.a(j);
      int k = locala.a();
      int m = locala.b();
      int n = m - k;
      if (n >= 65536)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bogus exception range: ");
        localStringBuilder.append(i.a(k));
        localStringBuilder.append("..");
        localStringBuilder.append(i.a(m));
        throw new UnsupportedOperationException(localStringBuilder.toString());
      }
      parama.d(k);
      parama.c(n);
      parama.c(((Integer)this.e.get(locala.c())).intValue());
    }
    parama.a(this.c);
  }

  public int b()
  {
    return 8 * a() + this.c.length;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.e
 * JD-Core Version:    0.6.2
 */