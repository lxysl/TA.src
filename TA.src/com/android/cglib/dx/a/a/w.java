package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.b.c;
import com.android.cglib.dx.c.b.f.a;
import com.android.cglib.dx.c.b.f.b;
import com.android.cglib.dx.c.b.i;
import com.android.cglib.dx.c.b.m;
import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.b.o;
import com.android.cglib.dx.c.b.p;
import com.android.cglib.dx.c.b.t;
import com.android.cglib.dx.c.b.u;
import com.android.cglib.dx.c.c.l;

public final class w
{
  private final com.android.cglib.dx.a.b a;
  private final com.android.cglib.dx.c.b.q b;
  private final int c;
  private final i d;
  private final a e;
  private final s f;
  private final b g;
  private final int h;
  private int[] i;
  private final int j;
  private boolean k;

  private w(com.android.cglib.dx.c.b.q paramq, int paramInt1, i parami, int paramInt2, com.android.cglib.dx.a.b paramb)
  {
    this.a = paramb;
    this.b = paramq;
    this.c = paramInt1;
    this.d = parami;
    this.e = new a(paramq);
    this.j = paramInt2;
    this.i = null;
    this.k = a(paramq, paramInt2);
    c localc = paramq.a();
    int m = localc.a();
    int n = m * 3;
    int i1 = n + localc.c();
    if (parami != null)
      i1 += m + parami.a();
    int i2 = localc.b();
    int i3;
    if (this.k)
      i3 = 0;
    else
      i3 = this.j;
    this.h = (i2 + i3);
    this.f = new s(paramb, i1, n, this.h);
    if (parami != null);
    for (Object localObject = new a(this.f, parami); ; localObject = new b(this.f))
    {
      this.g = ((b)localObject);
      return;
    }
  }

  private g a()
  {
    c();
    b();
    y localy = new y(this.b, this.i, this.e);
    return new g(this.c, this.f.a(), localy);
  }

  public static g a(com.android.cglib.dx.c.b.q paramq, int paramInt1, i parami, int paramInt2, com.android.cglib.dx.a.b paramb)
  {
    w localw = new w(paramq, paramInt1, parami, paramInt2, paramb);
    return localw.a();
  }

  private void a(com.android.cglib.dx.c.b.b paramb, int paramInt)
  {
    e locale = this.e.a(paramb);
    this.f.a(locale);
    if (this.d != null)
    {
      o localo = this.d.a(paramb);
      this.f.a(new q(locale.h(), localo));
    }
    this.g.a(paramb, this.e.b(paramb));
    paramb.b().a(this.g);
    this.f.a(this.e.c(paramb));
    int m = paramb.d();
    com.android.cglib.dx.c.b.f localf = paramb.f();
    if ((m >= 0) && (m != paramInt))
    {
      if ((localf.d().b() == 4) && (paramb.e() == paramInt))
      {
        this.f.a(1, this.e.a(m));
        return;
      }
      z localz = new z(k.P, localf.e(), n.a, this.e.a(m));
      this.f.a(localz);
    }
  }

  private static boolean a(com.android.cglib.dx.c.b.q paramq, final int paramInt)
  {
    boolean[] arrayOfBoolean = { true };
    final int m = paramq.a().b();
    paramq.a().a(new f.a()
    {
      public void a(com.android.cglib.dx.c.b.j paramAnonymousj)
      {
        if (paramAnonymousj.d().a() == 3)
        {
          int i = ((l)paramAnonymousj.c()).e_();
          boolean[] arrayOfBoolean = this.a;
          int j;
          if ((this.a[0] != 0) && (i + (m - paramInt) == paramAnonymousj.f().e()))
            j = 1;
          else
            j = 0;
          arrayOfBoolean[0] = j;
        }
      }
    });
    return arrayOfBoolean[0];
  }

  private static n b(com.android.cglib.dx.c.b.f paramf)
  {
    return b(paramf, paramf.f());
  }

  private static n b(com.android.cglib.dx.c.b.f paramf, m paramm)
  {
    n localn = paramf.g();
    if ((paramf.d().d()) && (localn.a() == 2) && (paramm.e() == localn.b(1).e()))
      localn = n.a(localn.b(1), localn.b(0));
    if (paramm == null)
      return localn;
    return localn.b(paramm);
  }

  private void b()
  {
    c localc = this.b.a();
    int[] arrayOfInt = this.i;
    int m = arrayOfInt.length;
    int i1;
    for (int n = 0; n < m; n = i1)
    {
      i1 = n + 1;
      int i2;
      if (i1 == arrayOfInt.length)
        i2 = -1;
      else
        i2 = arrayOfInt[i1];
      a(localc.b(arrayOfInt[n]), i2);
    }
  }

  private void c()
  {
    c localc = this.b.a();
    int m = localc.a();
    int n = localc.d();
    int[] arrayOfInt1 = com.android.cglib.dx.d.b.a(n);
    int[] arrayOfInt2 = com.android.cglib.dx.d.b.a(n);
    for (int i1 = 0; i1 < m; i1++)
      com.android.cglib.dx.d.b.b(arrayOfInt1, localc.a(i1).a());
    int[] arrayOfInt3 = new int[m];
    int i2 = this.b.b();
    int i3 = 0;
    while (i2 != -1)
    {
      com.android.cglib.dx.d.k localk1 = this.b.a(i2);
      int i4 = localk1.a();
      for (int i5 = 0; ; i5++)
      {
        if (i5 >= i4)
          break label179;
        int i11 = localk1.a(i5);
        if (com.android.cglib.dx.d.b.a(arrayOfInt2, i11))
          break label179;
        if ((com.android.cglib.dx.d.b.a(arrayOfInt1, i11)) && (localc.b(i11).d() == i2))
        {
          com.android.cglib.dx.d.b.b(arrayOfInt2, i11);
          i2 = i11;
          break;
        }
      }
      label179: 
      while (i2 != -1)
      {
        com.android.cglib.dx.d.b.c(arrayOfInt1, i2);
        com.android.cglib.dx.d.b.c(arrayOfInt2, i2);
        arrayOfInt3[i3] = i2;
        i3++;
        com.android.cglib.dx.c.b.b localb1 = localc.b(i2);
        com.android.cglib.dx.c.b.b localb2 = localc.a(localb1);
        if (localb2 == null)
          break;
        int i6 = localb2.a();
        int i7 = localb1.d();
        if (com.android.cglib.dx.d.b.a(arrayOfInt1, i6))
        {
          i2 = i6;
        }
        else if ((i7 != i6) && (i7 >= 0) && (com.android.cglib.dx.d.b.a(arrayOfInt1, i7)))
        {
          i2 = i7;
        }
        else
        {
          com.android.cglib.dx.d.k localk2 = localb1.c();
          int i8 = localk2.a();
          for (int i9 = 0; ; i9++)
          {
            if (i9 >= i8)
              break label349;
            int i10 = localk2.a(i9);
            if (com.android.cglib.dx.d.b.a(arrayOfInt1, i10))
            {
              i2 = i10;
              break;
            }
          }
          label349: i2 = -1;
        }
      }
      i2 = com.android.cglib.dx.d.b.d(arrayOfInt1, 0);
    }
    if (i3 != m)
      throw new RuntimeException("shouldn't happen");
    this.i = arrayOfInt3;
  }

  private class a extends w.b
  {
    private i c;

    public a(s parami, i arg3)
    {
      super(parami);
      Object localObject;
      this.c = localObject;
    }

    public void a(com.android.cglib.dx.c.b.f paramf)
    {
      m localm = this.c.a(paramf);
      if (localm != null)
        a(new r(paramf.e(), localm));
    }

    public void a(com.android.cglib.dx.c.b.j paramj)
    {
      super.a(paramj);
      a(paramj);
    }

    public void a(com.android.cglib.dx.c.b.k paramk)
    {
      super.a(paramk);
      a(paramk);
    }

    public void a(t paramt)
    {
      super.a(paramt);
      a(paramt);
    }

    public void a(u paramu)
    {
      super.a(paramu);
      a(paramu);
    }
  }

  private class b
    implements f.b
  {
    private final s a;
    private com.android.cglib.dx.c.b.b c;
    private e d;

    public b(s arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    private m a()
    {
      int i = this.c.d();
      if (i < 0)
        return null;
      com.android.cglib.dx.c.b.f localf = w.e(w.this).a().b(i).b().a(0);
      if (localf.d().a() != 56)
        return null;
      return localf.f();
    }

    protected void a(h paramh)
    {
      this.a.a(paramh);
    }

    public void a(com.android.cglib.dx.c.b.b paramb, e parame)
    {
      this.c = paramb;
      this.d = parame;
    }

    public void a(com.android.cglib.dx.c.b.j paramj)
    {
      com.android.cglib.dx.c.b.s locals = paramj.e();
      j localj = v.a(paramj);
      p localp = paramj.d();
      int i = localp.a();
      if (localp.b() != 1)
        throw new RuntimeException("shouldn't happen");
      Object localObject;
      if (i == 3)
      {
        if (w.b(w.this))
          return;
        m localm = paramj.f();
        localObject = new x(localj, locals, n.a(localm, m.a(((l)paramj.c()).e_() + (w.c(w.this) - w.d(w.this)), localm.b())));
      }
      else
      {
        localObject = new f(localj, locals, w.a(paramj), paramj.c());
      }
      a((h)localObject);
    }

    public void a(com.android.cglib.dx.c.b.k paramk)
    {
      p localp = paramk.d();
      if (localp.a() == 54)
        return;
      if (localp.a() == 56)
        return;
      com.android.cglib.dx.c.b.s locals = paramk.e();
      j localj = v.a(paramk);
      int i = localp.b();
      Object localObject;
      if (i != 6)
        switch (i)
        {
        default:
          throw new RuntimeException("shouldn't happen");
        case 4:
          int j = this.c.c().a(1);
          localObject = new z(localj, locals, w.a(paramk), w.a(w.this).a(j));
          break;
        case 3:
          return;
        case 1:
        case 2:
        }
      else
        localObject = new x(localj, locals, w.a(paramk));
      a((h)localObject);
    }

    public void a(t paramt)
    {
      com.android.cglib.dx.c.b.s locals = paramt.e();
      j localj = v.a(paramt);
      p localp = paramt.d();
      com.android.cglib.dx.c.c.a locala = paramt.c();
      if (localp.b() != 6)
        throw new RuntimeException("shouldn't happen");
      a(this.d);
      if (localp.c())
      {
        a(new f(localj, locals, paramt.g(), locala));
        return;
      }
      m localm = a();
      n localn = w.a(paramt, localm);
      boolean bool = localj.d();
      int i = 1;
      int j;
      if ((!bool) && (localp.a() != 43))
        j = 0;
      else
        j = 1;
      if (localm == null)
        i = 0;
      if (j != i)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Insn with result/move-result-pseudo mismatch ");
        localStringBuilder.append(paramt);
        throw new RuntimeException(localStringBuilder.toString());
      }
      Object localObject;
      if ((localp.a() == 41) && (localj.a() != 35))
        localObject = new x(localj, locals, localn);
      else
        localObject = new f(localj, locals, localn, locala);
      a((h)localObject);
    }

    public void a(u paramu)
    {
      com.android.cglib.dx.c.b.s locals = paramu.e();
      j localj = v.a(paramu);
      if (paramu.d().b() != 6)
        throw new RuntimeException("shouldn't happen");
      m localm = a();
      boolean bool1 = localj.d();
      boolean bool2;
      if (localm != null)
        bool2 = true;
      else
        bool2 = false;
      if (bool1 != bool2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Insn with result/move-result-pseudo mismatch");
        localStringBuilder.append(paramu);
        throw new RuntimeException(localStringBuilder.toString());
      }
      a(this.d);
      a(new x(localj, locals, w.a(paramu, localm)));
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.w
 * JD-Core Version:    0.6.2
 */