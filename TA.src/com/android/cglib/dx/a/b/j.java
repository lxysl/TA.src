package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.a.p;
import com.android.cglib.dx.a.a.p.a;
import com.android.cglib.dx.a.a.p.b;
import com.android.cglib.dx.a.a.u;
import com.android.cglib.dx.a.a.u.a;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.b;
import com.android.cglib.dx.c.d.c;
import com.android.cglib.dx.d.d;
import com.android.cglib.dx.d.g;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class j
{
  private final u a;
  private final p b;
  private final d c;
  private final l d;
  private final int e;
  private final int f;
  private final com.android.cglib.dx.c.d.a g;
  private final boolean h;
  private int i = 0;
  private int j = 1;
  private com.android.cglib.dx.d.a k;
  private PrintWriter l;
  private String m;
  private boolean n;
  private final p.b[] o;

  public j(u paramu, p paramp, l paraml, int paramInt1, int paramInt2, boolean paramBoolean, com.android.cglib.dx.c.c.s params)
  {
    this.a = paramu;
    this.b = paramp;
    this.d = paraml;
    this.g = params.f();
    this.h = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    this.c = new d();
    this.o = new p.b[paramInt2];
  }

  private int a(int paramInt)
  {
    int i1 = this.b.a();
    while ((paramInt < i1) && (this.b.a(paramInt).a() == this.i))
    {
      p localp = this.b;
      int i2 = paramInt + 1;
      p.b localb1 = localp.a(paramInt);
      int i3 = localb1.g();
      p.b localb2 = this.o[i3];
      if (localb1 != localb2)
      {
        this.o[i3] = localb1;
        if (localb1.c())
        {
          if ((localb2 != null) && (localb1.b(localb2)))
          {
            if (localb2.c())
              throw new RuntimeException("shouldn't happen");
            b(localb1);
          }
          else
          {
            c(localb1);
          }
        }
        else if (localb1.b() != p.a.c)
          e(localb1);
      }
      paramInt = i2;
    }
    return paramInt;
  }

  private static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= -4) && (paramInt1 <= 10))
      return 10 + (paramInt1 + 4 + paramInt2 * 15);
    throw new RuntimeException("Parameter out of range");
  }

  private int a(int paramInt, ArrayList<u.a> paramArrayList)
  {
    int i1 = paramArrayList.size();
    while ((paramInt < i1) && (((u.a)paramArrayList.get(paramInt)).a() == this.i))
    {
      int i2 = paramInt + 1;
      a((u.a)paramArrayList.get(paramInt));
      paramInt = i2;
    }
    return paramInt;
  }

  private String a(p.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramb.g());
    localStringBuilder.append(' ');
    v localv1 = paramb.d();
    if (localv1 == null);
    for (String str1 = "null"; ; str1 = localv1.a_())
    {
      localStringBuilder.append(str1);
      break;
    }
    localStringBuilder.append(' ');
    w localw = paramb.f();
    if (localw == null);
    for (String str2 = "null"; ; str2 = localw.a_())
    {
      localStringBuilder.append(str2);
      break;
    }
    v localv2 = paramb.e();
    if (localv2 != null)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(localv2.a_());
    }
    return localStringBuilder.toString();
  }

  private void a(int paramInt, String paramString)
  {
    if (this.m != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.m);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    if (this.k != null)
    {
      com.android.cglib.dx.d.a locala = this.k;
      if (!this.n)
        paramInt = 0;
      locala.a(paramInt, paramString);
    }
    if (this.l != null)
      this.l.println(paramString);
  }

  private void a(u.a parama)
  {
    int i1 = parama.b().a();
    int i2 = parama.a();
    int i3 = i1 - this.j;
    int i4 = i2 - this.i;
    if (i4 < 0)
      throw new RuntimeException("Position entries must be in ascending address order");
    if ((i3 < -4) || (i3 > 10))
    {
      b(i3);
      i3 = 0;
    }
    int i5 = a(i3, i4);
    if ((i5 & 0xFFFFFF00) > 0)
    {
      c(i4);
      i5 = a(i3, 0);
      if ((i5 & 0xFFFFFF00) > 0)
      {
        b(i3);
        i5 = a(0, 0);
        i3 = 0;
        i4 = 0;
      }
      else
      {
        i4 = 0;
      }
    }
    this.c.b(i5);
    this.j = (i3 + this.j);
    this.i = (i4 + this.i);
    if ((this.k != null) || (this.l != null))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = Integer.valueOf(this.j);
      a(1, String.format("%04x: line %d", arrayOfObject));
    }
  }

  private void a(v paramv)
  {
    if ((paramv != null) && (this.d != null))
    {
      this.c.e(1 + this.d.g().b(paramv));
      return;
    }
    this.c.e(0);
  }

  private void a(w paramw)
  {
    if ((paramw != null) && (this.d != null))
    {
      this.c.e(1 + this.d.j().b(paramw));
      return;
    }
    this.c.e(0);
  }

  private void a(ArrayList<u.a> paramArrayList, ArrayList<p.b> paramArrayList1)
  {
    com.android.cglib.dx.d.a locala = this.k;
    int i1 = 0;
    int i2;
    if ((locala == null) && (this.l == null))
      i2 = 0;
    else
      i2 = 1;
    int i3 = this.c.g();
    if (paramArrayList.size() > 0)
      this.j = ((u.a)paramArrayList.get(0)).b().a();
    this.c.e(this.j);
    if (i2 != 0)
    {
      int i13 = this.c.g() - i3;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("line_start: ");
      localStringBuilder2.append(this.j);
      a(i13, localStringBuilder2.toString());
    }
    int i4 = d();
    b localb = this.g.c();
    int i5 = localb.a();
    if (!this.h)
    {
      Iterator localIterator2 = paramArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        p.b localb3 = (p.b)localIterator2.next();
        if (i4 == localb3.g())
          this.o[i4] = localb3;
      }
      i4++;
    }
    int i6 = this.c.g();
    this.c.e(i5);
    if (i2 != 0)
    {
      int i12 = this.c.g() - i6;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i5);
      a(i12, String.format("parameters_size: %04x", arrayOfObject));
    }
    int i7 = i4;
    for (int i8 = 0; i8 < i5; i8++)
    {
      c localc = localb.b(i8);
      int i10 = this.c.g();
      Iterator localIterator1 = paramArrayList1.iterator();
      while (localIterator1.hasNext())
      {
        localb2 = (p.b)localIterator1.next();
        if (i7 == localb2.g())
        {
          if (localb2.e() != null)
            a(null);
          else
            a(localb2.d());
          this.o[i7] = localb2;
          break label386;
        }
      }
      p.b localb2 = null;
      label386: if (localb2 == null)
        a(null);
      if (i2 != 0)
      {
        String str;
        if ((localb2 != null) && (localb2.e() == null))
          str = localb2.d().a_();
        else
          str = "<unnamed>";
        int i11 = this.c.g() - i10;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("parameter ");
        localStringBuilder1.append(str);
        localStringBuilder1.append(" ");
        localStringBuilder1.append("v");
        localStringBuilder1.append(i7);
        a(i11, localStringBuilder1.toString());
      }
      i7 += localc.g();
    }
    p.b[] arrayOfb = this.o;
    int i9 = arrayOfb.length;
    while (i1 < i9)
    {
      p.b localb1 = arrayOfb[i1];
      if ((localb1 != null) && (localb1.e() != null))
        d(localb1);
      i1++;
    }
  }

  private void b(int paramInt)
  {
    int i1 = this.c.g();
    this.c.b(2);
    this.c.f(paramInt);
    this.j = (paramInt + this.j);
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.j);
      a(i2, String.format("line = %d", arrayOfObject));
    }
  }

  private void b(p.b paramb)
  {
    int i1 = this.c.g();
    this.c.b(6);
    d(paramb.g());
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = a(paramb);
      a(i2, String.format("%04x: +local restart %s", arrayOfObject));
    }
  }

  private byte[] b()
  {
    ArrayList localArrayList = c();
    a(localArrayList, e());
    this.c.b(7);
    com.android.cglib.dx.d.a locala = this.k;
    int i1 = 0;
    if ((locala != null) || (this.l != null))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.i);
      a(1, String.format("%04x: prologue end", arrayOfObject));
    }
    int i2 = localArrayList.size();
    int i3 = this.b.a();
    int i4 = 0;
    while (true)
    {
      i1 = a(i1);
      i4 = a(i4, localArrayList);
      int i5;
      if (i1 < i3)
        i5 = this.b.a(i1).a();
      else
        i5 = 2147483647;
      int i6;
      if (i4 < i2)
        i6 = ((u.a)localArrayList.get(i4)).a();
      else
        i6 = 2147483647;
      int i7 = Math.min(i6, i5);
      if ((i7 == 2147483647) || ((i7 == this.e) && (i5 == 2147483647) && (i6 == 2147483647)))
      {
        f();
        return this.c.f();
      }
      if (i7 == i6)
      {
        int i8 = i4 + 1;
        a((u.a)localArrayList.get(i4));
        i4 = i8;
      }
      else
      {
        c(i7 - this.i);
      }
    }
  }

  private ArrayList<u.a> c()
  {
    u localu = this.a;
    int i1 = 0;
    int i2;
    if (localu == null)
      i2 = 0;
    else
      i2 = this.a.a();
    ArrayList localArrayList = new ArrayList(i2);
    while (i1 < i2)
    {
      localArrayList.add(this.a.a(i1));
      i1++;
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(u.a paramAnonymousa1, u.a paramAnonymousa2)
      {
        return paramAnonymousa1.a() - paramAnonymousa2.a();
      }

      public boolean equals(Object paramAnonymousObject)
      {
        return paramAnonymousObject == this;
      }
    });
    return localArrayList;
  }

  private void c(int paramInt)
  {
    int i1 = this.c.g();
    this.c.b(1);
    this.c.e(paramInt);
    this.i = (paramInt + this.i);
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.i);
      a(i2, String.format("%04x: advance pc", arrayOfObject));
    }
  }

  private void c(p.b paramb)
  {
    if (paramb.e() != null)
    {
      d(paramb);
      return;
    }
    int i1 = this.c.g();
    this.c.b(3);
    d(paramb.g());
    a(paramb.d());
    a(paramb.f());
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = a(paramb);
      a(i2, String.format("%04x: +local %s", arrayOfObject));
    }
  }

  private int d()
  {
    return this.f - this.g.c().b() - (true ^ this.h);
  }

  private void d(int paramInt)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Signed value where unsigned required: ");
      localStringBuilder.append(paramInt);
      throw new RuntimeException(localStringBuilder.toString());
    }
    this.c.e(paramInt);
  }

  private void d(p.b paramb)
  {
    int i1 = this.c.g();
    this.c.b(4);
    d(paramb.g());
    a(paramb.d());
    a(paramb.f());
    a(paramb.e());
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = a(paramb);
      a(i2, String.format("%04x: +localx %s", arrayOfObject));
    }
  }

  private ArrayList<p.b> e()
  {
    ArrayList localArrayList = new ArrayList(this.g.c().a());
    int i1 = d();
    BitSet localBitSet = new BitSet(this.f - i1);
    int i2 = this.b.a();
    for (int i3 = 0; i3 < i2; i3++)
    {
      p.b localb = this.b.a(i3);
      int i4 = localb.g();
      if (i4 >= i1)
      {
        int i5 = i4 - i1;
        if (!localBitSet.get(i5))
        {
          localBitSet.set(i5);
          localArrayList.add(localb);
        }
      }
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(p.b paramAnonymousb1, p.b paramAnonymousb2)
      {
        return paramAnonymousb1.g() - paramAnonymousb2.g();
      }

      public boolean equals(Object paramAnonymousObject)
      {
        return paramAnonymousObject == this;
      }
    });
    return localArrayList;
  }

  private void e(p.b paramb)
  {
    int i1 = this.c.g();
    this.c.b(5);
    this.c.e(paramb.g());
    if ((this.k != null) || (this.l != null))
    {
      int i2 = this.c.g() - i1;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = a(paramb);
      a(i2, String.format("%04x: -local %s", arrayOfObject));
    }
  }

  private void f()
  {
    this.c.b(0);
    if ((this.k != null) || (this.l != null))
      a(1, "end sequence");
  }

  public byte[] a()
  {
    try
    {
      byte[] arrayOfByte = b();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw g.a(localIOException, "...while encoding debug info");
    }
  }

  public byte[] a(String paramString, PrintWriter paramPrintWriter, com.android.cglib.dx.d.a parama, boolean paramBoolean)
  {
    this.m = paramString;
    this.l = paramPrintWriter;
    this.k = parama;
    this.n = paramBoolean;
    return a();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.j
 * JD-Core Version:    0.6.2
 */