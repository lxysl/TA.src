package com.b.a.b;

import java.util.List;
import java.util.Vector;

public class o
  implements CharSequence
{
  protected char[] a = new char[51];
  protected int b;
  protected int c;
  protected int d;
  protected List<m> e;
  private int f;
  private p g;
  private r h;

  public o()
  {
    this.a[50] = 65535;
    this.f = 1;
    this.b = 0;
    this.c = 50;
    this.d = 1;
    this.g = new p();
    this.h = new r(this);
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = p(paramInt3);
    q.a(o(paramInt3), "findCharOffsetBackward: Invalid startingOffset given");
    while ((paramInt2 < paramInt1) && (i < this.a.length))
    {
      if (this.a[i] == '\n')
        paramInt2++;
      i++;
      if (i == this.b)
        i = this.c;
    }
    if (paramInt2 != paramInt1)
      return -1;
    return q(i);
  }

  private void a(int paramInt1, int paramInt2)
  {
    m localm1 = b(paramInt1);
    m localm2 = (m)this.e.get(localm1.a());
    localm2.a(paramInt2 + localm2.a());
  }

  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
      return 0;
    q.a(o(paramInt3), "findCharOffsetBackward: Invalid startOffset given");
    int i = p(paramInt3);
    while ((paramInt2 > paramInt1 - 1) && (i >= 0))
    {
      if (i == this.c)
        i = this.b;
      i--;
      if (this.a[i] == '\n')
        paramInt2--;
    }
    if (i >= 0)
      return 1 + q(i);
    q.a(false, "findCharOffsetBackward: Invalid cache entry or line arguments");
    return -1;
  }

  private m b(int paramInt)
  {
    int i = this.e.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = ((m)this.e.get(j)).a();
      k += m;
      if (k >= paramInt)
        return new m(j, k - m);
      j++;
    }
    return new m(0, 0);
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (length() == 0)
    {
      f();
      return;
    }
    m localm1 = c(paramInt1);
    if (paramInt2 == 1)
    {
      m localm4 = (m)this.e.get(localm1.a());
      if (localm4.a() > 1)
      {
        localm4.a(localm4.a() - 1);
        return;
      }
      this.e.remove(localm1.a());
      return;
    }
    int i = paramInt1 - localm1.b();
    m localm2 = (m)this.e.get(localm1.a());
    if (localm2.a() > i)
      localm2.a(localm2.a() - i);
    else
      this.e.remove(localm1.a());
    int j = paramInt2 - i;
    if (j > 0)
    {
      int k = localm1.a();
      while (k >= 0)
      {
        m localm3 = (m)this.e.get(k);
        int m = localm3.a();
        if (j > m)
        {
          j -= m;
          this.e.remove(k);
          k--;
        }
        else
        {
          localm3.a(localm3.a() - j);
        }
      }
    }
  }

  private int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = 0;
    while (i < paramInt1 + paramInt2)
    {
      if (this.a[i] == '\n')
        j++;
      i++;
    }
    return j;
  }

  private m c(int paramInt)
  {
    int i = this.e.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = ((m)this.e.get(j)).a();
      k += m;
      if (k > paramInt)
        return new m(j, k - m);
      j++;
    }
    return new m(0, 0);
  }

  public static int g(int paramInt)
  {
    long l = 1 + (paramInt + 50);
    if (l < 2147483647L)
      return (int)l;
    return -1;
  }

  void a(int paramInt)
  {
    if (paramInt >= 0);
    try
    {
      a(this.b, paramInt);
      this.d += c(this.b, paramInt);
      break label68;
      b(this.b, 0 - paramInt);
      this.d -= c(paramInt + this.b, -paramInt);
      label68: this.b = (paramInt + this.b);
      this.g.c(1 + q(-1 + this.b));
      return;
      label100: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label100;
    }
  }

  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      this.h.b(paramInt1, paramInt2, paramLong);
      int i = paramInt1 + paramInt2;
      if (i != this.b)
        if (r(i))
        {
          k(i);
        }
        else
        {
          l(i + e());
          break label136;
          if (j < paramInt2)
          {
            this.b = (-1 + this.b);
            if (this.a[this.b] != '\n')
              break label142;
            this.d = (-1 + this.d);
            break label142;
          }
          this.g.c(paramInt1);
          b(paramInt1, paramInt2);
          return;
          Object localObject1;
          throw localObject1;
        }
    }
    finally
    {
      while (true)
      {
        continue;
        label136: int j = 0;
        continue;
        label142: j++;
      }
    }
  }

  public void a(List<m> paramList)
  {
    this.e = paramList;
  }

  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    try
    {
      this.a = paramArrayOfChar;
      m(paramInt1);
      this.d = paramInt2;
      this.f = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(char[] paramArrayOfChar, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      this.h.a(paramInt, paramArrayOfChar.length, paramLong);
      int i = p(paramInt);
      if (i != this.c)
        if (r(i))
          k(i);
        else
          l(i);
      if (paramArrayOfChar.length >= e())
      {
        n(paramArrayOfChar.length - e());
        break label167;
        while (j < paramArrayOfChar.length)
        {
          if (paramArrayOfChar[j] == '\n')
            this.d = (1 + this.d);
          this.a[this.b] = paramArrayOfChar[j];
          this.b = (1 + this.b);
          j++;
        }
        this.g.c(paramInt);
        a(paramInt, paramArrayOfChar.length);
        return;
        Object localObject1;
        throw localObject1;
      }
    }
    finally
    {
      while (true)
      {
        continue;
        label167: int j = 0;
      }
    }
  }

  public char charAt(int paramInt)
  {
    try
    {
      char c1 = this.a[p(paramInt)];
      return c1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final int d()
  {
    try
    {
      int i = this.a.length;
      int j = e();
      int k = i - j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final int e()
  {
    return this.c - this.b;
  }

  public void f()
  {
    this.e = new Vector();
    this.e.add(new m(length(), 0));
  }

  public List<m> g()
  {
    return this.e;
  }

  public int h(int paramInt)
  {
    if (paramInt < 0)
      return -1;
    try
    {
      m localm = this.g.a(paramInt);
      int i = localm.a();
      int j = localm.b();
      if (paramInt > i)
        j = a(paramInt, i, j);
      else if (paramInt < i)
        j = b(paramInt, i, j);
      if (j >= 0)
        this.g.a(paramInt, j);
      return j;
    }
    finally
    {
    }
  }

  public boolean h()
  {
    return this.h.e();
  }

  public int i(int paramInt)
  {
    while (true)
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      try
      {
        boolean bool = o(paramInt);
        if (!bool)
          return -1;
        m localm = this.g.b(paramInt);
        i = localm.a();
        j = p(localm.b());
        k = p(paramInt);
        if (k > j)
        {
          m = i;
          n = -1;
          i1 = -1;
          if ((j < k) && (j < this.a.length))
          {
            if (this.a[j] == '\n')
            {
              n = m + 1;
              i1 = 1 + q(j);
              m = n;
            }
            j++;
            if (j != this.b)
              continue;
            j = this.c;
            continue;
            if ((j > k) && (j > 0))
            {
              if (j == this.c)
                j = this.b;
              j--;
              if (this.a[j] != '\n')
                continue;
              i1 = 1 + q(j);
              int i2 = m - 1;
              int i3 = m;
              m = i2;
              n = i3;
              continue;
            }
          }
          if (j == k)
          {
            if (n != -1)
              this.g.a(n, i1);
            return m;
          }
          return -1;
        }
      }
      finally
      {
      }
      if (k < j)
      {
        m = i;
        n = -1;
        i1 = -1;
      }
      else
      {
        m = i;
        n = -1;
        i1 = -1;
      }
    }
  }

  public void i()
  {
    this.h.f();
  }

  public void j()
  {
    this.h.g();
  }

  char[] j(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfChar[i] = this.a[(i + this.b)];
    return arrayOfChar;
  }

  public int k()
  {
    return this.h.a();
  }

  protected final void k(int paramInt)
  {
    while (this.b > paramInt)
    {
      this.c = (-1 + this.c);
      this.b = (-1 + this.b);
      this.a[this.c] = this.a[this.b];
    }
  }

  public int l()
  {
    return this.h.b();
  }

  protected final void l(int paramInt)
  {
    while (this.c < paramInt)
    {
      this.a[this.b] = this.a[this.c];
      this.b = (1 + this.b);
      this.c = (1 + this.c);
    }
  }

  public int length()
  {
    return -1 + d();
  }

  protected void m(int paramInt)
  {
    int i = -1 + this.a.length;
    char[] arrayOfChar1 = this.a;
    int j = i - 1;
    arrayOfChar1[i] = 65535;
    int n;
    for (int k = paramInt - 1; k >= 0; k = n)
    {
      char[] arrayOfChar2 = this.a;
      int m = j - 1;
      char[] arrayOfChar3 = this.a;
      n = k - 1;
      arrayOfChar2[j] = arrayOfChar3[k];
      j = m;
    }
    this.b = 0;
    this.c = (j + 1);
  }

  protected void n(int paramInt)
  {
    int i = paramInt + 50 * this.f;
    char[] arrayOfChar = new char[i + this.a.length];
    for (int j = 0; j < this.b; j++)
      arrayOfChar[j] = this.a[j];
    for (int k = this.c; k < this.a.length; k++)
      arrayOfChar[(k + i)] = this.a[k];
    this.c = (i + this.c);
    this.a = arrayOfChar;
    this.f <<= 1;
  }

  public final boolean o(int paramInt)
  {
    if (paramInt >= 0);
    boolean bool;
    try
    {
      int i = d();
      if (paramInt < i)
        bool = true;
    }
    finally
    {
    }
    return bool;
  }

  protected final int p(int paramInt)
  {
    if (r(paramInt))
      return paramInt;
    return paramInt + e();
  }

  protected final int q(int paramInt)
  {
    if (r(paramInt))
      return paramInt;
    return paramInt - e();
  }

  protected final boolean r(int paramInt)
  {
    return paramInt < this.b;
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    while (true)
    {
      int j;
      try
      {
        if ((o(paramInt1)) && (paramInt2 > 0))
        {
          if (paramInt1 + paramInt2 > d())
            paramInt2 = d() - paramInt1;
          int i = p(paramInt1);
          char[] arrayOfChar = new char[paramInt2];
          j = 0;
          if (j < paramInt2)
          {
            arrayOfChar[j] = this.a[i];
            i++;
            if (i == this.b)
              i = this.c;
          }
          else
          {
            String str1 = new String(arrayOfChar);
            return str1;
          }
        }
        else
        {
          String str2 = new String();
          return str2;
        }
      }
      finally
      {
      }
      j++;
    }
  }

  public String toString()
  {
    int i = d();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int j = 0; j < i; j++)
    {
      int k = charAt(j);
      if (k == 65535)
        break;
      localStringBuffer.append(k);
    }
    return new String(localStringBuffer);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.o
 * JD-Core Version:    0.6.2
 */