package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class p extends com.android.cglib.dx.d.h
{
  public static final p a = new p(0);

  public p(int paramInt)
  {
    super(paramInt);
  }

  public static p a(i parami)
  {
    int i = parami.a();
    c localc = new c(i);
    for (int j = 0; j < i; j++)
    {
      h localh = parami.a(j);
      if ((localh instanceof q))
      {
        com.android.cglib.dx.c.b.o localo = ((q)localh).b();
        localc.a(localh.f(), localo);
      }
      else if ((localh instanceof r))
      {
        m localm2 = ((r)localh).b();
        localc.a(localh.f(), localm2);
      }
      else if ((localh instanceof o))
      {
        m localm1 = ((o)localh).b();
        localc.b(localh.f(), localm1);
      }
    }
    return localc.a();
  }

  public b a(int paramInt)
  {
    return (b)d(paramInt);
  }

  public void a(int paramInt, b paramb)
  {
    a(paramInt, paramb);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }
  }

  public static class b
    implements Comparable<b>
  {
    private final int a;
    private final p.a b;
    private final m c;
    private final w d;

    // ERROR //
    public b(int paramInt, p.a parama, m paramm)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 22	java/lang/Object:<init>	()V
      //   4: iload_1
      //   5: ifge +13 -> 18
      //   8: new 24	java/lang/IllegalArgumentException
      //   11: dup
      //   12: ldc 26
      //   14: invokespecial 29	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   17: athrow
      //   18: aload_2
      //   19: ifnonnull +13 -> 32
      //   22: new 19	java/lang/NullPointerException
      //   25: dup
      //   26: ldc 31
      //   28: invokespecial 32	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   31: athrow
      //   32: aload_3
      //   33: invokevirtual 38	com/android/cglib/dx/c/b/m:g	()Lcom/android/cglib/dx/c/b/h;
      //   36: ifnonnull +13 -> 49
      //   39: new 19	java/lang/NullPointerException
      //   42: dup
      //   43: ldc 40
      //   45: invokespecial 32	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   48: athrow
      //   49: aload_0
      //   50: iload_1
      //   51: putfield 42	com/android/cglib/dx/a/a/p$b:a	I
      //   54: aload_0
      //   55: aload_2
      //   56: putfield 44	com/android/cglib/dx/a/a/p$b:b	Lcom/android/cglib/dx/a/a/p$a;
      //   59: aload_0
      //   60: aload_3
      //   61: putfield 46	com/android/cglib/dx/a/a/p$b:c	Lcom/android/cglib/dx/c/b/m;
      //   64: aload_0
      //   65: aload_3
      //   66: invokevirtual 49	com/android/cglib/dx/c/b/m:b	()Lcom/android/cglib/dx/c/d/c;
      //   69: invokestatic 54	com/android/cglib/dx/c/c/w:a	(Lcom/android/cglib/dx/c/d/c;)Lcom/android/cglib/dx/c/c/w;
      //   72: putfield 56	com/android/cglib/dx/a/a/p$b:d	Lcom/android/cglib/dx/c/c/w;
      //   75: return
      //   76: new 19	java/lang/NullPointerException
      //   79: dup
      //   80: ldc 58
      //   82: invokespecial 32	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   85: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   32	49	76	java/lang/NullPointerException
    }

    public int a()
    {
      return this.a;
    }

    public int a(b paramb)
    {
      int i = this.a;
      int j = paramb.a;
      int k = -1;
      if (i < j)
        return k;
      if (this.a > paramb.a)
        return 1;
      boolean bool = c();
      if (bool != paramb.c())
      {
        if (bool)
          k = 1;
        return k;
      }
      return this.c.c(paramb.c);
    }

    public b a(p.a parama)
    {
      if (parama == this.b)
        return this;
      return new b(this.a, parama, this.c);
    }

    public boolean a(m paramm)
    {
      return this.c.a(paramm);
    }

    public p.a b()
    {
      return this.b;
    }

    public boolean b(b paramb)
    {
      return a(paramb.c);
    }

    public boolean c()
    {
      return this.b == p.a.a;
    }

    public v d()
    {
      return this.c.g().a();
    }

    public v e()
    {
      return this.c.g().b();
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b))
        return false;
      int i = a((b)paramObject);
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }

    public w f()
    {
      return this.d;
    }

    public int g()
    {
      return this.c.e();
    }

    public m h()
    {
      return this.c;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(this.a));
      localStringBuilder.append(" ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
  }

  public static class c
  {
    private final ArrayList<p.b> a;
    private int b;
    private com.android.cglib.dx.c.b.o c;
    private int[] d;
    private int e;

    public c(int paramInt)
    {
      this.a = new ArrayList(paramInt);
      this.b = 0;
      this.c = null;
      this.d = null;
      this.e = 0;
    }

    private static m a(m paramm)
    {
      if ((paramm != null) && (paramm.b() == c.j))
        paramm = paramm.a(c.o);
      return paramm;
    }

    private void a(int paramInt1, int paramInt2)
    {
      int i;
      if (this.d == null)
        i = 1;
      else
        i = 0;
      if ((paramInt1 == this.e) && (i == 0))
        return;
      if (paramInt1 < this.e)
        throw new RuntimeException("shouldn't happen");
      if ((i != 0) || (paramInt2 >= this.d.length))
      {
        int j = paramInt2 + 1;
        com.android.cglib.dx.c.b.o localo = new com.android.cglib.dx.c.b.o(j);
        int[] arrayOfInt = new int[j];
        Arrays.fill(arrayOfInt, -1);
        if (i == 0)
        {
          localo.a(this.c);
          System.arraycopy(this.d, 0, arrayOfInt, 0, this.d.length);
        }
        this.c = localo;
        this.d = arrayOfInt;
      }
    }

    private void a(int paramInt, p.a parama, m paramm)
    {
      int i = paramm.e();
      this.a.add(new p.b(paramInt, parama, paramm));
      if (parama == p.a.a)
      {
        this.c.c(paramm);
        this.d[i] = -1;
        return;
      }
      this.c.b(paramm);
      this.d[i] = (-1 + this.a.size());
    }

    private void b(int paramInt, p.a parama, m paramm)
    {
      if (parama == p.a.a)
        throw new RuntimeException("shouldn't happen");
      int i = paramm.e();
      int j = this.d[i];
      if (j >= 0)
      {
        p.b localb = (p.b)this.a.get(j);
        if ((localb.a() == paramInt) && (localb.h().equals(paramm)))
        {
          this.a.set(j, localb.a(parama));
          this.c.b(paramm);
          return;
        }
      }
      a(paramInt, paramm, parama);
    }

    private boolean c(int paramInt, m paramm)
    {
      for (int i = this.a.size() - 1; i >= 0; i--)
      {
        p.b localb2 = (p.b)this.a.get(i);
        if (localb2 != null)
        {
          if (localb2.a() != paramInt)
            return false;
          if (localb2.a(paramm))
            break;
        }
      }
      this.c.b(paramm);
      ArrayList localArrayList = this.a;
      p.b localb1 = null;
      localArrayList.set(i, null);
      this.b = (1 + this.b);
      int j = paramm.e();
      do
      {
        i--;
        k = 0;
        if (i < 0)
          break;
        localb1 = (p.b)this.a.get(i);
      }
      while ((localb1 == null) || (localb1.h().e() != j));
      int k = 1;
      if (k != 0)
      {
        this.d[j] = i;
        if (localb1.a() == paramInt)
          this.a.set(i, localb1.a(p.a.b));
      }
      return true;
    }

    public p a()
    {
      int i = 0;
      a(2147483647, 0);
      int j = this.a.size();
      int k = j - this.b;
      if (k == 0)
        return p.a;
      p.b[] arrayOfb = new p.b[k];
      if (j == k)
      {
        this.a.toArray(arrayOfb);
      }
      else
      {
        Iterator localIterator = this.a.iterator();
        int m = 0;
        while (localIterator.hasNext())
        {
          p.b localb = (p.b)localIterator.next();
          if (localb != null)
          {
            int n = m + 1;
            arrayOfb[m] = localb;
            m = n;
          }
        }
      }
      Arrays.sort(arrayOfb);
      p localp = new p(k);
      while (i < k)
      {
        localp.a(i, arrayOfb[i]);
        i++;
      }
      localp.e();
      return localp;
    }

    public void a(int paramInt, m paramm)
    {
      int i = paramm.e();
      m localm1 = a(paramm);
      a(paramInt, i);
      m localm2 = this.c.a(i);
      if (localm1.a(localm2))
        return;
      m localm3 = this.c.a(localm1);
      if (localm3 != null)
        b(paramInt, p.a.d, localm3);
      int j = this.d[i];
      if (localm2 != null)
      {
        a(paramInt, p.a.c, localm2);
      }
      else if (j >= 0)
      {
        p.b localb1 = (p.b)this.a.get(j);
        if (localb1.a() == paramInt)
        {
          if (localb1.a(localm1))
          {
            this.a.set(j, null);
            this.b = (1 + this.b);
            this.c.c(localm1);
            this.d[i] = -1;
            return;
          }
          p.b localb2 = localb1.a(p.a.c);
          this.a.set(j, localb2);
        }
      }
      if (i > 0)
      {
        m localm5 = this.c.a(i - 1);
        if ((localm5 != null) && (localm5.j()))
          b(paramInt, p.a.f, localm5);
      }
      if (localm1.j())
      {
        m localm4 = this.c.a(i + 1);
        if (localm4 != null)
          b(paramInt, p.a.e, localm4);
      }
      a(paramInt, p.a.a, localm1);
    }

    public void a(int paramInt, m paramm, p.a parama)
    {
      int i = paramm.e();
      m localm = a(paramm);
      a(paramInt, i);
      if (this.d[i] >= 0)
        return;
      if (c(paramInt, localm))
        return;
      a(paramInt, parama, localm);
    }

    public void a(int paramInt, com.android.cglib.dx.c.b.o paramo)
    {
      int i = paramo.a();
      a(paramInt, i - 1);
      for (int j = 0; j < i; j++)
      {
        m localm1 = this.c.a(j);
        m localm2 = a(paramo.a(j));
        if (localm1 == null)
        {
          if (localm2 == null);
        }
        else
          while (true)
          {
            a(paramInt, localm2);
            break;
            if (localm2 == null)
            {
              b(paramInt, localm1);
              break;
            }
            if (localm2.a(localm1))
              break;
            b(paramInt, localm1);
          }
      }
    }

    public void b(int paramInt, m paramm)
    {
      a(paramInt, paramm, p.a.b);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.p
 * JD-Core Version:    0.6.2
 */