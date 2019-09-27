package com.android.cglib.dx.d;

import java.io.Writer;
import java.util.ArrayList;

public final class d
  implements a, e
{
  private final boolean a;
  private byte[] b;
  private int c;
  private boolean d;
  private ArrayList<a> e;
  private int f;
  private int g;

  public d()
  {
    this(1000);
  }

  public d(int paramInt)
  {
    this(new byte[paramInt], true);
  }

  public d(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, false);
  }

  private d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("data == null");
    this.a = paramBoolean;
    this.b = paramArrayOfByte;
    this.c = 0;
    this.d = false;
    this.e = null;
    this.f = 0;
    this.g = 0;
  }

  private static void i()
  {
    throw new IndexOutOfBoundsException("attempt to write past the end");
  }

  private void i(int paramInt)
  {
    if (this.b.length < paramInt)
    {
      byte[] arrayOfByte = new byte[1000 + paramInt * 2];
      System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
      this.b = arrayOfByte;
    }
  }

  public void a(int paramInt)
  {
    if (this.c != paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expected cursor ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("; actual value: ");
      localStringBuilder.append(this.c);
      throw new g(localStringBuilder.toString());
    }
  }

  public void a(int paramInt, String paramString)
  {
    if (this.e == null)
      return;
    c();
    int i = this.e.size();
    int j;
    if (i == 0)
      j = 0;
    else
      j = ((a)this.e.get(i - 1)).b();
    if (j <= this.c)
      j = this.c;
    this.e.add(new a(j, paramInt + j, paramString));
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.e == null) && (this.c == 0))
    {
      if (paramInt < 40)
        throw new IllegalArgumentException("annotationWidth < 40");
      int i = 0xFFFFFFFE & 1 + (paramInt - 7) / 15;
      if (i < 6)
        i = 6;
      else if (i > 10)
        i = 10;
      this.e = new ArrayList(1000);
      this.f = paramInt;
      this.g = i;
      this.d = paramBoolean;
      return;
    }
    throw new RuntimeException("cannot enable annotations");
  }

  public void a(c paramc)
  {
    int i = paramc.a();
    int j = this.c;
    int k = i + j;
    if (this.a)
    {
      i(k);
    }
    else if (k > this.b.length)
    {
      i();
      return;
    }
    paramc.a(this.b, j);
    this.c = k;
  }

  public void a(Writer paramWriter)
  {
    int i = d();
    s locals = new s(paramWriter, -1 + (this.f - i), i, "|");
    Writer localWriter1 = locals.a();
    Writer localWriter2 = locals.b();
    int j = this.e.size();
    int k = 0;
    int i2;
    for (int m = 0; (m < this.c) && (k < j); m = i2)
    {
      a locala = (a)this.e.get(k);
      i2 = locala.a();
      String str;
      int i4;
      if (m < i2)
      {
        str = "";
        i4 = m;
      }
      else
      {
        int i3 = locala.b();
        str = locala.c();
        k++;
        i4 = i2;
        i2 = i3;
      }
      byte[] arrayOfByte2 = this.b;
      int i5 = i2 - i4;
      int i6 = this.g;
      localWriter1.write(i.a(arrayOfByte2, i4, i5, i4, i6, 6));
      localWriter2.write(str);
      locals.c();
    }
    if (m < this.c)
    {
      byte[] arrayOfByte1 = this.b;
      int n = this.c - m;
      int i1 = this.g;
      localWriter1.write(i.a(arrayOfByte1, m, n, m, i1, 6));
    }
    while (k < j)
    {
      localWriter2.write(((a)this.e.get(k)).c());
      k++;
    }
    locals.c();
  }

  public void a(String paramString)
  {
    if (this.e == null)
      return;
    c();
    this.e.add(new a(this.c, paramString));
  }

  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.c;
    int j = i + paramInt2;
    int k = paramInt1 + paramInt2;
    if (((j | (paramInt1 | paramInt2)) >= 0) && (k <= paramArrayOfByte.length))
    {
      if (this.a)
      {
        i(j);
      }
      else if (j > this.b.length)
      {
        i();
        return;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.b, i, paramInt2);
      this.c = j;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes.length ");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append("; ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("..!");
    localStringBuilder.append(j);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }

  public boolean a()
  {
    return this.e != null;
  }

  public void b(int paramInt)
  {
    int i = this.c;
    int j = i + 1;
    if (this.a)
    {
      i(j);
    }
    else if (j > this.b.length)
    {
      i();
      return;
    }
    this.b[i] = ((byte)paramInt);
    this.c = j;
  }

  public boolean b()
  {
    return this.d;
  }

  public void c()
  {
    if (this.e == null)
      return;
    int i = this.e.size();
    if (i != 0)
      ((a)this.e.get(i - 1)).a(this.c);
  }

  public void c(int paramInt)
  {
    int i = this.c;
    int j = i + 2;
    if (this.a)
    {
      i(j);
    }
    else if (j > this.b.length)
    {
      i();
      return;
    }
    this.b[i] = ((byte)paramInt);
    this.b[(i + 1)] = ((byte)(paramInt >> 8));
    this.c = j;
  }

  public int d()
  {
    int i = 8 + 2 * this.g + this.g / 2;
    return this.f - i;
  }

  public void d(int paramInt)
  {
    int i = this.c;
    int j = i + 4;
    if (this.a)
    {
      i(j);
    }
    else if (j > this.b.length)
    {
      i();
      return;
    }
    this.b[i] = ((byte)paramInt);
    this.b[(i + 1)] = ((byte)(paramInt >> 8));
    this.b[(i + 2)] = ((byte)(paramInt >> 16));
    this.b[(i + 3)] = ((byte)(paramInt >> 24));
    this.c = j;
  }

  public int e(int paramInt)
  {
    if (this.a)
      i(5 + this.c);
    int i = this.c;
    n.a(this, paramInt);
    return this.c - i;
  }

  public byte[] e()
  {
    return this.b;
  }

  public int f(int paramInt)
  {
    if (this.a)
      i(5 + this.c);
    int i = this.c;
    n.b(this, paramInt);
    return this.c - i;
  }

  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }

  public int g()
  {
    return this.c;
  }

  public void g(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("count < 0");
    int i = paramInt + this.c;
    if (this.a)
    {
      i(i);
    }
    else if (i > this.b.length)
    {
      i();
      return;
    }
    this.c = i;
  }

  public void h()
  {
    c();
    if (this.e != null)
    {
      int i = this.e.size();
      while (i > 0)
      {
        ArrayList localArrayList = this.e;
        int j = i - 1;
        a locala = (a)localArrayList.get(j);
        if (locala.a() > this.c)
        {
          this.e.remove(j);
          i--;
        }
        else if (locala.b() > this.c)
        {
          locala.b(this.c);
        }
      }
    }
  }

  public void h(int paramInt)
  {
    int i = paramInt - 1;
    if ((paramInt >= 0) && ((paramInt & i) == 0))
    {
      int j = i + this.c & (i ^ 0xFFFFFFFF);
      if (this.a)
      {
        i(j);
      }
      else if (j > this.b.length)
      {
        i();
        return;
      }
      this.c = j;
      return;
    }
    throw new IllegalArgumentException("bogus alignment");
  }

  private static class a
  {
    private final int a;
    private int b;
    private final String c;

    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
    }

    public a(int paramInt, String paramString)
    {
      this(paramInt, 2147483647, paramString);
    }

    public int a()
    {
      return this.a;
    }

    public void a(int paramInt)
    {
      if (this.b == 2147483647)
        this.b = paramInt;
    }

    public int b()
    {
      return this.b;
    }

    public void b(int paramInt)
    {
      this.b = paramInt;
    }

    public String c()
    {
      return this.c;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.d.d
 * JD-Core Version:    0.6.2
 */