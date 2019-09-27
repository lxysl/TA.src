package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;

public final class c extends ag
{
  private b a;

  public y a()
  {
    return y.v;
  }

  public void a(l paraml)
  {
    this.a = ((b)paraml.d().b(this.a));
  }

  protected void a_(l paraml, a parama)
  {
    int i = this.a.e();
    if (parama.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  annotations_off: ");
      localStringBuilder.append(i.a(i));
      parama.a(4, localStringBuilder.toString());
    }
    parama.d(i);
  }

  public String b()
  {
    return this.a.b();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.c
 * JD-Core Version:    0.6.2
 */