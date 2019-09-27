package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import java.util.Collection;

public abstract class ak
{
  private final String a;
  private final l b;
  private final int c;
  private int d;
  private boolean e;

  public ak(String paramString, l paraml, int paramInt)
  {
    if (paraml == null)
      throw new NullPointerException("file == null");
    a(paramInt);
    this.a = paramString;
    this.b = paraml;
    this.c = paramInt;
    this.d = -1;
    this.e = false;
  }

  public static void a(int paramInt)
  {
    if ((paramInt > 0) && ((paramInt & paramInt - 1) == 0))
      return;
    throw new IllegalArgumentException("invalid alignment");
  }

  public abstract int a(x paramx);

  public abstract Collection<? extends x> a();

  protected abstract void a_(a parama);

  public final int b(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("fileOffset < 0");
    if (this.d >= 0)
      throw new RuntimeException("fileOffset already set");
    int i = -1 + this.c;
    int j = paramInt + i & (i ^ 0xFFFFFFFF);
    this.d = j;
    return j;
  }

  public final int c(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("relative < 0");
    if (this.d < 0)
      throw new RuntimeException("fileOffset not yet set");
    return paramInt + this.d;
  }

  protected abstract void c();

  public final void c(a parama)
  {
    i();
    d(parama);
    int i = parama.g();
    if (this.d < 0)
    {
      this.d = i;
    }
    else if (this.d != i)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("alignment mismatch: for ");
      localStringBuilder1.append(this);
      localStringBuilder1.append(", at ");
      localStringBuilder1.append(i);
      localStringBuilder1.append(", but expected ");
      localStringBuilder1.append(this.d);
      throw new RuntimeException(localStringBuilder1.toString());
    }
    if (parama.a())
    {
      StringBuilder localStringBuilder2;
      if (this.a != null)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("\n");
        localStringBuilder2.append(this.a);
        localStringBuilder2.append(":");
      }
      for (String str = localStringBuilder2.toString(); ; str = "\n")
      {
        parama.a(0, str);
        break;
        if (i == 0)
          break;
      }
    }
    a_(parama);
  }

  public abstract int c_();

  protected final void d(a parama)
  {
    parama.h(this.c);
  }

  public final l e()
  {
    return this.b;
  }

  public final int f()
  {
    return this.c;
  }

  public final int g()
  {
    if (this.d < 0)
      throw new RuntimeException("fileOffset not set");
    return this.d;
  }

  public final void h()
  {
    j();
    c();
    this.e = true;
  }

  protected final void i()
  {
    if (!this.e)
      throw new RuntimeException("not prepared");
  }

  protected final void j()
  {
    if (this.e)
      throw new RuntimeException("already prepared");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ak
 * JD-Core Version:    0.6.2
 */