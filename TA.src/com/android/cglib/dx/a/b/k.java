package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.a.i;
import com.android.cglib.dx.a.a.p;
import com.android.cglib.dx.a.a.u;
import com.android.cglib.dx.c.c.s;
import com.android.cglib.dx.d.a;
import java.io.PrintWriter;

public class k extends ag
{
  private final com.android.cglib.dx.a.a.g a;
  private byte[] b;
  private final boolean c;
  private final s d;

  public k(com.android.cglib.dx.a.a.g paramg, boolean paramBoolean, s params)
  {
    super(1, -1);
    if (paramg == null)
      throw new NullPointerException("code == null");
    this.a = paramg;
    this.c = paramBoolean;
    this.d = params;
  }

  private byte[] a(l paraml, String paramString, PrintWriter paramPrintWriter, a parama, boolean paramBoolean)
  {
    return b(paraml, paramString, paramPrintWriter, parama, paramBoolean);
  }

  private byte[] b(l paraml, String paramString, PrintWriter paramPrintWriter, a parama, boolean paramBoolean)
  {
    u localu = this.a.h();
    p localp = this.a.i();
    i locali = this.a.f();
    int i = locali.b();
    int j = locali.c();
    j localj = new j(localu, localp, paraml, i, j, this.c, this.d);
    if ((paramPrintWriter == null) && (parama == null))
      return localj.a();
    return localj.a(paramString, paramPrintWriter, parama, paramBoolean);
  }

  public y a()
  {
    return y.o;
  }

  protected void a(ak paramak, int paramInt)
  {
    try
    {
      this.b = a(paramak.e(), null, null, null, false);
      a(this.b.length);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("...while placing debug info for ");
      localStringBuilder.append(this.d.a_());
      throw com.android.cglib.dx.d.g.a(localRuntimeException, localStringBuilder.toString());
    }
  }

  public void a(l paraml)
  {
  }

  public void a(l paraml, a parama, String paramString)
  {
    a(paraml, paramString, null, parama, false);
  }

  protected void a_(l paraml, a parama)
  {
    if (parama.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g());
      localStringBuilder.append(" debug info");
      parama.a(localStringBuilder.toString());
      a(paraml, null, null, parama, true);
    }
    parama.a(this.b);
  }

  public String b()
  {
    throw new RuntimeException("unsupported");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.k
 * JD-Core Version:    0.6.2
 */