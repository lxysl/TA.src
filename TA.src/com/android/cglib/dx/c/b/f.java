package com.android.cglib.dx.c.b;

import com.android.cglib.dx.c.d.e;
import com.android.cglib.dx.d.r;

public abstract class f
  implements r
{
  private final p a;
  private final s b;
  private final m c;
  private final n d;

  public f(p paramp, s params, m paramm, n paramn)
  {
    if (paramp == null)
      throw new NullPointerException("opcode == null");
    if (params == null)
      throw new NullPointerException("position == null");
    if (paramn == null)
      throw new NullPointerException("sources == null");
    this.a = paramp;
    this.b = params;
    this.c = paramm;
    this.d = paramn;
  }

  protected final String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append("Insn{");
    localStringBuffer.append(this.b);
    localStringBuffer.append(' ');
    localStringBuffer.append(this.a);
    if (paramString != null)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(paramString);
    }
    localStringBuffer.append(" :: ");
    if (this.c != null)
    {
      localStringBuffer.append(this.c);
      localStringBuffer.append(" <- ");
    }
    localStringBuffer.append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }

  public abstract void a(b paramb);

  public String a_()
  {
    return b(b());
  }

  public String b()
  {
    return null;
  }

  protected final String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append(this.b);
    localStringBuffer.append(": ");
    localStringBuffer.append(this.a.e());
    if (paramString != null)
    {
      localStringBuffer.append("(");
      localStringBuffer.append(paramString);
      localStringBuffer.append(")");
    }
    if (this.c == null);
    for (String str = " ."; ; str = this.c.a_())
    {
      localStringBuffer.append(str);
      break;
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(" <-");
    int i = this.d.a();
    if (i == 0)
      localStringBuffer.append(" .");
    else
      for (int j = 0; j < i; j++)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(this.d.b(j).a_());
      }
    return localStringBuffer.toString();
  }

  public final p d()
  {
    return this.a;
  }

  public final s e()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    return this == paramObject;
  }

  public final m f()
  {
    return this.c;
  }

  public final n g()
  {
    return this.d;
  }

  public final boolean h()
  {
    return this.a.f();
  }

  public final int hashCode()
  {
    return System.identityHashCode(this);
  }

  public abstract e i();

  public String toString()
  {
    return a(b());
  }

  public static class a
    implements f.b
  {
    public void a(j paramj)
    {
    }

    public void a(k paramk)
    {
    }

    public void a(t paramt)
    {
    }

    public void a(u paramu)
    {
    }
  }

  public static abstract interface b
  {
    public abstract void a(j paramj);

    public abstract void a(k paramk);

    public abstract void a(t paramt);

    public abstract void a(u paramu);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.c.b.f
 * JD-Core Version:    0.6.2
 */