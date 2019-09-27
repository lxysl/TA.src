package com.b.a.b;

public class p
{
  private m[] a = new m[4];

  public p()
  {
    this.a[0] = new m(0, 0);
    for (int i = 1; i < 4; i++)
      this.a[i] = new m(-1, -1);
  }

  private boolean b(int paramInt1, int paramInt2)
  {
    for (int i = 1; i < 4; i++)
      if (this.a[i].a() == paramInt1)
      {
        this.a[i].b(paramInt2);
        return true;
      }
    return false;
  }

  private void c(int paramInt1, int paramInt2)
  {
    d(3);
    this.a[1] = new m(paramInt1, paramInt2);
  }

  private void d(int paramInt)
  {
    if (paramInt == 0)
      return;
    m localm = this.a[paramInt];
    while (paramInt > 1)
    {
      this.a[paramInt] = this.a[(paramInt - 1)];
      paramInt--;
    }
    this.a[1] = localm;
  }

  public m a(int paramInt)
  {
    int i = 0;
    int j = 2147483647;
    int k = 0;
    while (i < 4)
    {
      int m = Math.abs(paramInt - this.a[i].a());
      if (m < j)
      {
        k = i;
        j = m;
      }
      i++;
    }
    m localm = this.a[k];
    d(k);
    return localm;
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
      return;
    if (!b(paramInt1, paramInt2))
      c(paramInt1, paramInt2);
  }

  public m b(int paramInt)
  {
    int i = 0;
    int j = 2147483647;
    int k = 0;
    while (i < 4)
    {
      int m = Math.abs(paramInt - this.a[i].b());
      if (m < j)
      {
        k = i;
        j = m;
      }
      i++;
    }
    m localm = this.a[k];
    d(k);
    return localm;
  }

  protected final void c(int paramInt)
  {
    for (int i = 1; i < 4; i++)
      if (this.a[i].b() >= paramInt)
        this.a[i] = new m(-1, -1);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.p
 * JD-Core Version:    0.6.2
 */