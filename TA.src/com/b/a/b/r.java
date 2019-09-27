package com.b.a.b;

import java.util.LinkedList;

public class r
{
  long a = -1L;
  private o b;
  private LinkedList<a> c = new LinkedList();
  private boolean d = false;
  private int e = 0;
  private int f = 0;

  public r(o paramo)
  {
    this.b = paramo;
  }

  private void a(a parama)
  {
    h();
    this.f = (1 + this.f);
    this.c.add(parama);
  }

  private void h()
  {
    while (this.c.size() > this.f)
      this.c.removeLast();
  }

  public int a()
  {
    if (c())
    {
      Object localObject = (a)this.c.get(-1 + this.f);
      int i = ((a)localObject).d;
      while (true)
      {
        a locala = (a)this.c.get(-1 + this.f);
        if (locala.d == i)
        {
          locala.a();
          this.f = (-1 + this.f);
          if (!c())
            localObject = locala;
        }
        else
        {
          return ((a)localObject).d();
        }
        localObject = locala;
      }
    }
    return -1;
  }

  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    int i;
    if (c())
    {
      a locala = (a)this.c.get(this.f - 1);
      if (((locala instanceof c)) && (locala.a(paramInt1, paramInt2, paramLong)))
        i = 1;
      else
        locala.c();
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      a(new c(paramInt1, paramInt2, this.e));
      if (!this.d)
        this.e = (1 + this.e);
    }
    this.a = paramLong;
  }

  public int b()
  {
    if (d())
    {
      Object localObject = (a)this.c.get(this.f);
      int i = ((a)localObject).d;
      while (true)
      {
        a locala = (a)this.c.get(this.f);
        if (locala.d == i)
        {
          locala.b();
          this.f = (1 + this.f);
          if (!d())
            localObject = locala;
        }
        else
        {
          return ((a)localObject).e();
        }
        localObject = locala;
      }
    }
    return -1;
  }

  public void b(int paramInt1, int paramInt2, long paramLong)
  {
    int i;
    if (c())
    {
      a locala = (a)this.c.get(this.f - 1);
      if (((locala instanceof b)) && (locala.a(paramInt1, paramInt2, paramLong)))
        i = 1;
      else
        locala.c();
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      a(new b(paramInt1, paramInt2, this.e));
      if (!this.d)
        this.e = (1 + this.e);
    }
    this.a = paramLong;
  }

  public final boolean c()
  {
    return this.f > 0;
  }

  public final boolean d()
  {
    return this.f < this.c.size();
  }

  public boolean e()
  {
    return this.d;
  }

  public void f()
  {
    this.d = true;
  }

  public void g()
  {
    this.d = false;
    this.e = (1 + this.e);
  }

  private abstract class a
  {
    public int a;
    public int b;
    public String c;
    public int d;

    private a()
    {
    }

    public abstract void a();

    public abstract boolean a(int paramInt1, int paramInt2, long paramLong);

    public abstract void b();

    public abstract void c();

    public abstract int d();

    public abstract int e();
  }

  private class b extends r.a
  {
    public b(int paramInt1, int paramInt2, int arg4)
    {
      super(null);
      this.a = paramInt1;
      this.b = paramInt2;
      int i;
      this.d = i;
    }

    public void a()
    {
      if (this.c == null)
      {
        c();
        r.b(r.this).a(this.b);
        return;
      }
      r.b(r.this).a(this.c.toCharArray(), this.a, 0L, false);
    }

    public boolean a(int paramInt1, int paramInt2, long paramLong)
    {
      if (r.this.a < 0L)
        return false;
      if ((paramLong - r.this.a < 1000000000L) && (paramInt1 == 1 + (this.a - this.b - paramInt2)))
      {
        this.a = paramInt1;
        this.b = (paramInt2 + this.b);
        r.a(r.this);
        return true;
      }
      return false;
    }

    public void b()
    {
      r.b(r.this).a(this.a, this.b, 0L, false);
    }

    public void c()
    {
      this.c = new String(r.b(r.this).j(this.b));
    }

    public int d()
    {
      return this.a + this.b;
    }

    public int e()
    {
      return this.a;
    }
  }

  private class c extends r.a
  {
    public c(int paramInt1, int paramInt2, int arg4)
    {
      super(null);
      this.a = paramInt1;
      this.b = paramInt2;
      int i;
      this.d = i;
    }

    public void a()
    {
      if (this.c == null)
      {
        c();
        r.b(r.this).a(-this.b);
        return;
      }
      r.b(r.this).a(this.a, this.b, 0L, false);
    }

    public boolean a(int paramInt1, int paramInt2, long paramLong)
    {
      if (r.this.a < 0L)
        return false;
      if ((paramLong - r.this.a < 1000000000L) && (paramInt1 == this.a + this.b))
      {
        this.b = (paramInt2 + this.b);
        r.a(r.this);
        return true;
      }
      return false;
    }

    public void b()
    {
      r.b(r.this).a(this.c.toCharArray(), this.a, 0L, false);
    }

    public void c()
    {
      this.c = r.b(r.this).subSequence(this.a, this.b).toString();
    }

    public int d()
    {
      return this.a;
    }

    public int e()
    {
      return this.a + this.b;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.r
 * JD-Core Version:    0.6.2
 */