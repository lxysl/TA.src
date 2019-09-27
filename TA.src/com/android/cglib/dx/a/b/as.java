package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import java.util.Collection;
import java.util.Iterator;

public abstract class as extends ak
{
  public as(String paramString, l paraml, int paramInt)
  {
    super(paramString, paraml, paramInt);
  }

  public final int a(x paramx)
  {
    w localw = (w)paramx;
    return c(localw.g() * localw.b_());
  }

  protected final void a_(a parama)
  {
    l locall = e();
    int i = f();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ((x)localIterator.next()).a(locall, parama);
      parama.h(i);
    }
  }

  protected abstract void b();

  protected final void c()
  {
    l locall = e();
    b();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((x)localIterator.next()).a(locall);
  }

  public final int c_()
  {
    Collection localCollection = a();
    int i = localCollection.size();
    if (i == 0)
      return 0;
    return i * ((x)localCollection.iterator().next()).b_();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.as
 * JD-Core Version:    0.6.2
 */