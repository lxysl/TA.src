package com.android.cglib.dx.a.b;

import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import com.android.cglib.dx.d.r;
import java.util.Iterator;
import java.util.List;

public final class ah
  implements r, Comparable<ah>
{
  private final s a;
  private final at<c> b;

  public int a(ah paramah)
  {
    return this.a.a(paramah.a);
  }

  public void a(l paraml)
  {
    ae localae = paraml.m();
    af localaf = paraml.d();
    localae.a(this.a);
    localaf.a(this.b);
  }

  public void a(l paraml, a parama)
  {
    int i = paraml.m().b(this.a);
    int j = this.b.e();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("    ");
      localStringBuilder1.append(this.a.a_());
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("      method_idx:      ");
      localStringBuilder2.append(i.a(i));
      parama.a(4, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("      annotations_off: ");
      localStringBuilder3.append(i.a(j));
      parama.a(4, localStringBuilder3.toString());
    }
    parama.d(i);
    parama.d(j);
  }

  public String a_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a_());
    localStringBuilder.append(": ");
    Iterator localIterator = this.b.c().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (i != 0)
        i = 0;
      else
        localStringBuilder.append(", ");
      localStringBuilder.append(localc.b());
    }
    return localStringBuilder.toString();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ah))
      return false;
    return this.a.equals(((ah)paramObject).a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ah
 * JD-Core Version:    0.6.2
 */