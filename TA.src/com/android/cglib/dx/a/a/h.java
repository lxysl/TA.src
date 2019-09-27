package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.util.BitSet;

public abstract class h
{
  private int a;
  private final j b;
  private final com.android.cglib.dx.c.b.s c;
  private final n d;

  public h(j paramj, com.android.cglib.dx.c.b.s params, n paramn)
  {
    if (paramj == null)
      throw new NullPointerException("opcode == null");
    if (params == null)
      throw new NullPointerException("position == null");
    if (paramn == null)
      throw new NullPointerException("registers == null");
    this.a = -1;
    this.b = paramj;
    this.c = params;
    this.d = paramn;
  }

  public static x a(com.android.cglib.dx.c.b.s params, com.android.cglib.dx.c.b.m paramm1, com.android.cglib.dx.c.b.m paramm2)
  {
    int i = paramm1.i();
    int j = 1;
    if (i != j)
      j = 0;
    boolean bool = paramm1.b().j();
    int k = paramm1.e();
    j localj;
    if ((k | paramm2.e()) < 16)
    {
      if (bool)
        localj = k.i;
      else if (j != 0)
        localj = k.c;
      else
        localj = k.f;
    }
    else if (k < 256)
    {
      if (bool)
        localj = k.j;
      else if (j != 0)
        localj = k.d;
      else
        localj = k.g;
    }
    else if (bool)
      localj = k.k;
    else if (j != 0)
      localj = k.e;
    else
      localj = k.h;
    return new x(localj, params, n.a(paramm1, paramm2));
  }

  public final int a(BitSet paramBitSet)
  {
    int i = j();
    int j = this.d.a();
    int k = 0;
    int m;
    if ((i != 0) && (!paramBitSet.get(0)))
    {
      m = this.d.b(0).i();
      k = 0;
    }
    else
    {
      m = 0;
    }
    while (i < j)
    {
      if (!paramBitSet.get(i))
        k += this.d.b(i).i();
      i++;
    }
    return Math.max(k, m);
  }

  public abstract h a(j paramj);

  public abstract h a(n paramn);

  protected abstract String a();

  public final String a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str1 = a(paramBoolean);
    if (str1 == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(l());
    localStringBuilder.append(": ");
    String str2 = localStringBuilder.toString();
    int i = str2.length();
    int j;
    if (paramInt == 0)
      j = str1.length();
    else
      j = paramInt - i;
    return com.android.cglib.dx.d.s.a(str2, i, "", str1, j);
  }

  protected abstract String a(boolean paramBoolean);

  public abstract void a(a parama);

  public h b(BitSet paramBitSet)
  {
    n localn1 = this.d;
    boolean bool = paramBitSet.get(0);
    if (j())
      paramBitSet.set(0);
    n localn2 = localn1.a(paramBitSet);
    if (j())
      paramBitSet.set(0, bool);
    if (localn2.a() == 0)
      return null;
    return new m(this.c, localn2);
  }

  public h c(BitSet paramBitSet)
  {
    if ((j()) && (!paramBitSet.get(0)))
    {
      com.android.cglib.dx.c.b.m localm = this.d.b(0);
      return a(this.c, localm, localm.b(0));
    }
    return null;
  }

  public final void c(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("address < 0");
    this.a = paramInt;
  }

  public abstract h d(int paramInt);

  public h d(BitSet paramBitSet)
  {
    return a(this.d.a(0, j(), paramBitSet));
  }

  public final boolean e()
  {
    return this.a >= 0;
  }

  public final int f()
  {
    if (this.a < 0)
      throw new RuntimeException("address not yet known");
    return this.a;
  }

  public final j g()
  {
    return this.b;
  }

  public final com.android.cglib.dx.c.b.s h()
  {
    return this.c;
  }

  public final n i()
  {
    return this.d;
  }

  public final boolean j()
  {
    return this.b.d();
  }

  public h k()
  {
    return a(this.d.a(0, j(), null));
  }

  public final String l()
  {
    if (this.a != -1)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.a);
      return String.format("%04x", arrayOfObject);
    }
    return i.a(System.identityHashCode(this));
  }

  public final int m()
  {
    return f() + n();
  }

  public abstract int n();

  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(l());
    localStringBuffer.append(' ');
    localStringBuffer.append(this.c);
    localStringBuffer.append(": ");
    localStringBuffer.append(this.b.e());
    int i;
    if (this.d.a() != 0)
    {
      localStringBuffer.append(this.d.b(" ", ", ", null));
      i = 1;
    }
    else
    {
      i = 0;
    }
    String str = a();
    if (str != null)
    {
      if (i != 0)
        localStringBuffer.append(',');
      localStringBuffer.append(' ');
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.h
 * JD-Core Version:    0.6.2
 */