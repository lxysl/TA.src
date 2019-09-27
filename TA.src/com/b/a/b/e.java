package com.b.a.b;

import java.util.ArrayList;

public class e extends o
{
  private boolean f = false;
  private a g;
  private ArrayList<Integer> h;

  public e(a parama)
  {
    this.g = parama;
    m();
  }

  private void a(int paramInt1, int paramInt2)
  {
    while ((paramInt1 < this.h.size()) && (((Integer)this.h.get(paramInt1)).intValue() <= paramInt2))
      this.h.remove(paramInt1);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
      paramInt1--;
    int i = ((Integer)this.h.get(paramInt1)).intValue();
    int j = paramInt1 + 1;
    a(j, paramInt2 - paramInt3);
    b(j, paramInt3);
    b(j, i, paramInt2);
  }

  private void b(int paramInt1, int paramInt2)
  {
    while (paramInt1 < this.h.size())
    {
      this.h.set(paramInt1, Integer.valueOf(paramInt2 + ((Integer)this.h.get(paramInt1)).intValue()));
      paramInt1++;
    }
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f)
    {
      int i6 = p(paramInt2);
      int i7 = p(paramInt3);
      ArrayList localArrayList2 = new ArrayList();
      while (i6 < i7)
      {
        if (i6 == this.b)
          i6 = this.c;
        if (this.a[i6] == '\n')
          localArrayList2.add(Integer.valueOf(1 + q(i6)));
        i6++;
      }
      this.h.addAll(paramInt1, localArrayList2);
      return;
    }
    if (!n())
    {
      q.a("Not enough space to do word wrap");
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = p(paramInt2);
    int j = p(paramInt3);
    int k = this.g.getRowWidth();
    int m = paramInt2;
    int n = k;
    int i1 = 0;
    while (i < j)
    {
      if (i == this.b)
        i = this.c;
      int i2 = this.a[i];
      i1 += this.g.getAdvance(i2);
      int i3;
      if ((i2 != 32) && (i2 != 9) && (i2 != 10) && (i2 != 65535))
        i3 = 0;
      else
        i3 = 1;
      if (i3 != 0)
      {
        if (i1 <= n)
        {
          n -= i1;
        }
        else
        {
          if (i1 > k)
          {
            int i4 = p(m);
            if ((m != paramInt2) && ((localArrayList1.isEmpty()) || (m != ((Integer)localArrayList1.get(localArrayList1.size() - 1)).intValue())))
              localArrayList1.add(Integer.valueOf(m));
            n = k;
            while (i4 <= i)
            {
              if (i4 == this.b)
                i4 = this.c;
              int i5 = this.g.getAdvance(this.a[i4]);
              if (i5 > n)
              {
                localArrayList1.add(Integer.valueOf(q(i4)));
                n = k - i5;
              }
              else
              {
                n -= i5;
              }
              i4++;
            }
          }
          localArrayList1.add(Integer.valueOf(m));
          n = k - i1;
        }
        m = 1 + q(i);
        i1 = 0;
      }
      if (i2 == 10)
      {
        localArrayList1.add(Integer.valueOf(m));
        n = k;
      }
      i++;
    }
    this.h.addAll(paramInt1, localArrayList1);
  }

  private void m()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    this.h = localArrayList;
  }

  private boolean n()
  {
    return this.g.getRowWidth() >= 2 * this.g.getAdvance('M');
  }

  private int s(int paramInt)
  {
    for (int i = p(paramInt); i < this.a.length; i++)
    {
      if (i == this.b)
        i = this.c;
      if ((this.a[i] == '\n') || (this.a[i] == 65535))
        break;
    }
    return 1 + q(i);
  }

  void a(int paramInt)
  {
    try
    {
      super.a(paramInt);
      if (paramInt != 0)
      {
        int i;
        if (paramInt > 0)
          i = this.b - paramInt;
        else
          i = this.b;
        a(e(i), s(this.b), paramInt);
      }
      return;
    }
    finally
    {
    }
  }

  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    try
    {
      super.a(paramInt1, paramInt2, paramLong, paramBoolean);
      a(e(paramInt1), s(paramInt1), -paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    char[] arrayOfChar = new char[o.g(i)];
    int j = 1;
    for (int k = 0; k < i; k++)
    {
      arrayOfChar[k] = paramCharSequence.charAt(k);
      if (paramCharSequence.charAt(k) == '\n')
        j++;
    }
    a(arrayOfChar, i, j);
  }

  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.f));
    for (boolean bool = true; ; bool = false)
    {
      this.f = bool;
      b();
      return;
      if ((paramBoolean) || (!this.f))
        break;
    }
  }

  public void a(char[] paramArrayOfChar, int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      super.a(paramArrayOfChar, paramInt, paramLong, paramBoolean);
      a(e(paramInt), s(paramInt + paramArrayOfChar.length), paramArrayOfChar.length);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a()
  {
    return this.f;
  }

  public String b(int paramInt)
  {
    int i = c(paramInt);
    if (i == 0)
      return new String();
    return subSequence(((Integer)this.h.get(paramInt)).intValue(), i).toString();
  }

  public void b()
  {
    m();
    if ((this.f) && (!n()))
    {
      if (this.g.getRowWidth() > 0)
        q.a("Text field has non-zero width but still too small for word wrap");
      return;
    }
    b(1, 0, d());
  }

  public int c()
  {
    return this.h.size();
  }

  public int c(int paramInt)
  {
    if (f(paramInt))
      return 0;
    if (paramInt != -1 + this.h.size());
    for (int i = ((Integer)this.h.get(paramInt + 1)).intValue(); ; i = d())
      return i - ((Integer)this.h.get(paramInt)).intValue();
  }

  public int d(int paramInt)
  {
    if (f(paramInt))
      return -1;
    return ((Integer)this.h.get(paramInt)).intValue();
  }

  public int e(int paramInt)
  {
    if (!o(paramInt))
      return -1;
    int i = -1 + this.h.size();
    int j = 0;
    while (i >= j)
    {
      int k = (j + i) / 2;
      int m = k + 1;
      int n;
      if (m < this.h.size())
        n = ((Integer)this.h.get(m)).intValue();
      else
        n = d();
      if ((paramInt >= ((Integer)this.h.get(k)).intValue()) && (paramInt < n))
        return k;
      if (paramInt >= n)
        j = m;
      else
        i = k - 1;
    }
    return -1;
  }

  protected boolean f(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= this.h.size());
  }

  public static abstract interface a
  {
    public abstract int getAdvance(char paramChar);

    public abstract int getRowWidth();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.e
 * JD-Core Version:    0.6.2
 */