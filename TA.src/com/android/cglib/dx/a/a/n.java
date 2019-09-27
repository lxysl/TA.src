package com.android.cglib.dx.a.a;

import com.android.cglib.dx.c.c.o;
import com.android.cglib.dx.c.c.p;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.d.i;
import java.util.BitSet;

public abstract class n
{
  public static boolean a = true;

  protected static String a(com.android.cglib.dx.c.b.n paramn)
  {
    int i = paramn.a();
    StringBuffer localStringBuffer = new StringBuffer(2 + i * 5);
    localStringBuffer.append('{');
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        localStringBuffer.append(", ");
      localStringBuffer.append(paramn.b(j).k());
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }

  protected static String a(p paramp)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append('#');
    if ((paramp instanceof com.android.cglib.dx.c.c.m));
    for (String str = "null"; ; str = paramp.a_())
    {
      localStringBuffer.append(str);
      break;
      localStringBuffer.append(paramp.e());
      localStringBuffer.append(' ');
    }
    return localStringBuffer.toString();
  }

  protected static String a(p paramp, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("#");
    long l;
    if ((paramp instanceof o))
      l = ((o)paramp).h();
    else
      l = paramp.g();
    String str;
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 32)
          {
            if (paramInt != 64)
              throw new RuntimeException("shouldn't happen");
            str = i.a(l);
          }
          else
          {
            str = i.a((int)l);
          }
        }
        else
          str = i.c((int)l);
      }
      else
        str = i.e((int)l);
    }
    else
      str = i.f((int)l);
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }

  protected static short a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0xFF) != paramInt1)
      throw new IllegalArgumentException("low out of range 0..255");
    if ((paramInt2 & 0xFF) != paramInt2)
      throw new IllegalArgumentException("high out of range 0..255");
    return (short)(paramInt1 | paramInt2 << 8);
  }

  protected static short a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 & 0xF) != paramInt1)
      throw new IllegalArgumentException("n0 out of range 0..15");
    if ((paramInt2 & 0xF) != paramInt2)
      throw new IllegalArgumentException("n1 out of range 0..15");
    if ((paramInt3 & 0xF) != paramInt3)
      throw new IllegalArgumentException("n2 out of range 0..15");
    if ((paramInt4 & 0xF) != paramInt4)
      throw new IllegalArgumentException("n3 out of range 0..15");
    return (short)(paramInt1 | paramInt2 << 4 | paramInt3 << 8 | paramInt4 << 12);
  }

  protected static short a(h paramh, int paramInt)
  {
    if ((paramInt & 0xFF) != paramInt)
      throw new IllegalArgumentException("arg out of range 0..255");
    int i = paramh.g().a();
    if ((i & 0xFF) != i)
      throw new IllegalArgumentException("opcode out of range 0..255");
    return (short)(i | paramInt << 8);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort)
  {
    parama.c(paramShort);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort, int paramInt)
  {
    a(parama, paramShort, (short)paramInt, (short)(paramInt >> 16));
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, int paramInt, short paramShort2)
  {
    a(parama, paramShort1, (short)paramInt, (short)(paramInt >> 16), paramShort2);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, int paramInt, short paramShort2, short paramShort3)
  {
    a(parama, paramShort1, (short)paramInt, (short)(paramInt >> 16), paramShort2, paramShort3);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort, long paramLong)
  {
    a(parama, paramShort, (short)(int)paramLong, (short)(int)(paramLong >> 16), (short)(int)(paramLong >> 32), (short)(int)(paramLong >> 48));
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, short paramShort2)
  {
    parama.c(paramShort1);
    parama.c(paramShort2);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, short paramShort2, short paramShort3)
  {
    parama.c(paramShort1);
    parama.c(paramShort2);
    parama.c(paramShort3);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    parama.c(paramShort1);
    parama.c(paramShort2);
    parama.c(paramShort3);
    parama.c(paramShort4);
  }

  protected static void a(com.android.cglib.dx.d.a parama, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5)
  {
    parama.c(paramShort1);
    parama.c(paramShort2);
    parama.c(paramShort3);
    parama.c(paramShort4);
    parama.c(paramShort5);
  }

  protected static boolean a(int paramInt)
  {
    return (paramInt >= -8) && (paramInt <= 7);
  }

  protected static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0xF) != paramInt1)
      throw new IllegalArgumentException("low out of range 0..15");
    if ((paramInt2 & 0xF) != paramInt2)
      throw new IllegalArgumentException("high out of range 0..15");
    return paramInt1 | paramInt2 << 4;
  }

  protected static String b(com.android.cglib.dx.c.b.n paramn)
  {
    int i = paramn.a();
    StringBuilder localStringBuilder = new StringBuilder(30);
    localStringBuilder.append("{");
    com.android.cglib.dx.c.b.m localm;
    switch (i)
    {
    default:
      localm = paramn.b(i - 1);
      if (localm.i() == 2)
        localm = localm.c(1);
      break;
    case 1:
      for (String str = paramn.b(0).k(); ; str = localm.k())
      {
        localStringBuilder.append(str);
        break;
        localStringBuilder.append(paramn.b(0).k());
        localStringBuilder.append("..");
      }
    case 0:
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  protected static boolean b(int paramInt)
  {
    return paramInt == (paramInt & 0xF);
  }

  protected static boolean c(int paramInt)
  {
    return (byte)paramInt == paramInt;
  }

  protected static boolean c(com.android.cglib.dx.c.b.n paramn)
  {
    int i = paramn.a();
    if (i < 2)
      return true;
    int j = paramn.b(0).e();
    for (int k = 0; k < i; k++)
    {
      com.android.cglib.dx.c.b.m localm = paramn.b(k);
      if (localm.e() != j)
        return false;
      j += localm.i();
    }
    return true;
  }

  protected static String d(h paramh)
  {
    int i = ((z)paramh).c();
    if (i == (char)i)
      return i.c(i);
    return i.a(i);
  }

  protected static boolean d(int paramInt)
  {
    return paramInt == (paramInt & 0xFF);
  }

  protected static String e(h paramh)
  {
    int i = ((z)paramh).d();
    if (i == (short)i)
      return i.h(i);
    return i.g(i);
  }

  protected static boolean e(int paramInt)
  {
    return (short)paramInt == paramInt;
  }

  protected static String f(h paramh)
  {
    com.android.cglib.dx.c.c.a locala = ((f)paramh).b();
    if ((locala instanceof v))
      return ((v)locala).f();
    return locala.a_();
  }

  protected static boolean f(int paramInt)
  {
    return paramInt == (0xFFFF & paramInt);
  }

  protected static String g(h paramh)
  {
    f localf = (f)paramh;
    if (!localf.d())
      return "";
    StringBuilder localStringBuilder = new StringBuilder(20);
    int i = localf.c();
    localStringBuilder.append(localf.b().e());
    localStringBuilder.append('@');
    if (i < 65536);
    for (String str = i.c(i); ; str = i.a(i))
    {
      localStringBuilder.append(str);
      break;
    }
    return localStringBuilder.toString();
  }

  protected static short h(h paramh)
  {
    int i = paramh.g().a();
    if ((i >= 255) && (i <= 65535))
      return (short)i;
    throw new IllegalArgumentException("extended opcode out of range 255..65535");
  }

  public abstract int a();

  public abstract String a(h paramh);

  public final String a(h paramh, boolean paramBoolean)
  {
    String str1 = paramh.g().e();
    String str2 = a(paramh);
    String str3 = b(paramh, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(str1);
    if (str2.length() != 0)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(str2);
    }
    if (str3.length() != 0)
    {
      localStringBuilder.append(" // ");
      localStringBuilder.append(str3);
    }
    return localStringBuilder.toString();
  }

  public abstract void a(com.android.cglib.dx.d.a parama, h paramh);

  public boolean a(z paramz)
  {
    return false;
  }

  public abstract String b(h paramh, boolean paramBoolean);

  public abstract boolean b(h paramh);

  public BitSet c(h paramh)
  {
    return new BitSet();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.n
 * JD-Core Version:    0.6.2
 */