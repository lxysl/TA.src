package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.b;
import com.android.cglib.dx.c.c.a;
import com.android.cglib.dx.c.c.i;
import com.android.cglib.dx.c.c.j;
import com.android.cglib.dx.c.c.v;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

public final class l
{
  private b a;
  private final af b;
  private final af c;
  private final af d;
  private final af e;
  private final ao f;
  private final aq g;
  private final aj h;
  private final s i;
  private final ae j;
  private final h k;
  private final af l;
  private final af m;
  private final u n;
  private final ak[] o;
  private int p;
  private int q;

  public l(b paramb)
  {
    this.a = paramb;
    this.n = new u(this);
    this.c = new af(null, this, 4, af.a.a);
    this.b = new af("word_data", this, 4, af.a.b);
    this.e = new af("string_data", this, 1, af.a.c);
    this.l = new af(null, this, 1, af.a.a);
    this.m = new af("byte_data", this, 1, af.a.b);
    this.f = new ao(this);
    this.g = new aq(this);
    this.h = new aj(this);
    this.i = new s(this);
    this.j = new ae(this);
    this.k = new h(this);
    this.d = new af("map", this, 4, af.a.a);
    ak[] arrayOfak = new ak[13];
    arrayOfak[0] = this.n;
    arrayOfak[1] = this.f;
    arrayOfak[2] = this.g;
    arrayOfak[3] = this.h;
    arrayOfak[4] = this.i;
    arrayOfak[5] = this.j;
    arrayOfak[6] = this.k;
    arrayOfak[7] = this.b;
    arrayOfak[8] = this.c;
    arrayOfak[9] = this.e;
    arrayOfak[10] = this.m;
    arrayOfak[11] = this.l;
    arrayOfak[12] = this.d;
    this.o = arrayOfak;
    this.p = -1;
    this.q = 79;
  }

  private com.android.cglib.dx.d.d a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k.h();
    this.l.h();
    this.b.h();
    this.m.h();
    this.j.h();
    this.i.h();
    this.h.h();
    this.c.h();
    this.g.h();
    this.f.h();
    this.e.h();
    this.n.h();
    int i1 = this.o.length;
    int i2 = 0;
    int i3 = 0;
    while (i2 < i1)
    {
      ak localak2 = this.o[i2];
      int i6 = localak2.b(i3);
      if (i6 < i3)
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("bogus placement for section ");
        localStringBuilder3.append(i2);
        throw new RuntimeException(localStringBuilder3.toString());
      }
      try
      {
        if (localak2 == this.d)
        {
          z.a(this.o, this.d);
          this.d.h();
        }
        if ((localak2 instanceof af))
          ((af)localak2).d();
        int i7 = localak2.c_();
        i3 = i7 + i6;
        i2++;
      }
      catch (RuntimeException localRuntimeException2)
      {
        StringBuilder localStringBuilder4 = new StringBuilder();
        localStringBuilder4.append("...while writing section ");
        localStringBuilder4.append(i2);
        throw com.android.cglib.dx.d.g.a(localRuntimeException2, localStringBuilder4.toString());
      }
    }
    this.p = i3;
    byte[] arrayOfByte = new byte[this.p];
    com.android.cglib.dx.d.d locald = new com.android.cglib.dx.d.d(arrayOfByte);
    int i4 = 0;
    if (paramBoolean1)
      locald.a(this.q, paramBoolean2);
    while (i4 < i1)
      try
      {
        ak localak1 = this.o[i4];
        int i5 = localak1.g() - locald.g();
        if (i5 < 0)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("excess write of ");
          localStringBuilder2.append(-i5);
          throw new com.android.cglib.dx.d.g(localStringBuilder2.toString());
        }
        locald.g(localak1.g() - locald.g());
        localak1.c(locald);
        i4++;
      }
      catch (RuntimeException localRuntimeException1)
      {
        com.android.cglib.dx.d.g localg;
        if ((localRuntimeException1 instanceof com.android.cglib.dx.d.g))
          localg = (com.android.cglib.dx.d.g)localRuntimeException1;
        else
          localg = new com.android.cglib.dx.d.g(localRuntimeException1);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("...while writing section ");
        localStringBuilder1.append(i4);
        localg.a(localStringBuilder1.toString());
        throw localg;
      }
    if (locald.g() != this.p)
      throw new RuntimeException("foreshortened write");
    a(arrayOfByte);
    b(arrayOfByte);
    if (paramBoolean1)
    {
      this.b.a(locald, y.m, "\nmethod code index:\n\n");
      q().a(locald);
      locald.h();
    }
    return locald;
  }

  private static void a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - 32);
      try
      {
        int i1 = localMessageDigest.digest(paramArrayOfByte, 12, 20);
        if (i1 != 20)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unexpected digest write: ");
          localStringBuilder.append(i1);
          localStringBuilder.append(" bytes");
          throw new RuntimeException(localStringBuilder.toString());
        }
        return;
      }
      catch (DigestException localDigestException)
      {
        throw new RuntimeException(localDigestException);
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }

  private static void b(byte[] paramArrayOfByte)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - 12);
    int i1 = (int)localAdler32.getValue();
    paramArrayOfByte[8] = ((byte)i1);
    paramArrayOfByte[9] = ((byte)(i1 >> 8));
    paramArrayOfByte[10] = ((byte)(i1 >> 16));
    paramArrayOfByte[11] = ((byte)(i1 >> 24));
  }

  public b a()
  {
    return this.a;
  }

  public void a(g paramg)
  {
    this.k.a(paramg);
  }

  void a(a parama)
  {
    if ((parama instanceof v))
    {
      this.f.a((v)parama);
      return;
    }
    if ((parama instanceof com.android.cglib.dx.c.c.w))
    {
      this.g.a((com.android.cglib.dx.c.c.w)parama);
      return;
    }
    if ((parama instanceof com.android.cglib.dx.c.c.d))
    {
      this.j.a((com.android.cglib.dx.c.c.d)parama);
      return;
    }
    s locals;
    if ((parama instanceof j))
      locals = this.i;
    for (j localj = (j)parama; ; localj = ((i)parama).f())
    {
      locals.a(localj);
      return;
      if (!(parama instanceof i))
        break;
      locals = this.i;
    }
    if (parama == null)
      throw new NullPointerException("cst == null");
  }

  public byte[] a(Writer paramWriter, boolean paramBoolean)
  {
    boolean bool;
    if (paramWriter != null)
      bool = true;
    else
      bool = false;
    com.android.cglib.dx.d.d locald = a(bool, paramBoolean);
    if (bool)
      locald.a(paramWriter);
    return locald.e();
  }

  int b()
  {
    if (this.p < 0)
      throw new RuntimeException("file size not yet known");
    return this.p;
  }

  w b(a parama)
  {
    if ((parama instanceof v))
      return this.f.a(parama);
    if ((parama instanceof com.android.cglib.dx.c.c.w))
      return this.g.a(parama);
    if ((parama instanceof com.android.cglib.dx.c.c.d))
      return this.j.a(parama);
    if ((parama instanceof j))
      return this.i.a(parama);
    return null;
  }

  af c()
  {
    return this.e;
  }

  af d()
  {
    return this.b;
  }

  af e()
  {
    return this.c;
  }

  af f()
  {
    return this.d;
  }

  ao g()
  {
    return this.f;
  }

  h h()
  {
    return this.k;
  }

  af i()
  {
    return this.l;
  }

  aq j()
  {
    return this.g;
  }

  aj k()
  {
    return this.h;
  }

  s l()
  {
    return this.i;
  }

  ae m()
  {
    return this.j;
  }

  af n()
  {
    return this.m;
  }

  ak o()
  {
    return this.b;
  }

  ak p()
  {
    return this.d;
  }

  public al q()
  {
    al localal = new al();
    ak[] arrayOfak = this.o;
    int i1 = arrayOfak.length;
    for (int i2 = 0; i2 < i1; i2++)
      localal.a(arrayOfak[i2]);
    return localal;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.l
 * JD-Core Version:    0.6.2
 */