package com.androlua;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.a.a.a.a.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class GifDecoder extends Thread
{
  public static final int STATUS_FINISH = -1;
  public static final int STATUS_FORMAT_ERROR = 1;
  public static final int STATUS_OPEN_ERROR = 2;
  public static final int STATUS_PARSING;
  private boolean A = false;
  private byte[] B = new byte[256];
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private boolean F = false;
  private int G = 0;
  private int H;
  private short[] I;
  private byte[] J;
  private byte[] K;
  private byte[] L;
  private GifFrame M;
  private int N;
  private GifAction O = null;
  private byte[] P = null;
  private InputStream a;
  private int b;
  private boolean c;
  private int d;
  private int e = 1;
  private int[] f;
  private int[] g;
  private int[] h;
  public int height;
  private int i;
  private int j;
  private int k;
  private int l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  public int width;
  private Bitmap x;
  private Bitmap y;
  private GifFrame z = null;

  public GifDecoder(InputStream paramInputStream, GifAction paramGifAction)
  {
    this.a = paramInputStream;
    this.O = paramGifAction;
  }

  public GifDecoder(String paramString, GifAction paramGifAction)
  {
    this.a = new FileInputStream(paramString);
    this.O = paramGifAction;
  }

  public GifDecoder(byte[] paramArrayOfByte, GifAction paramGifAction)
  {
    this.P = paramArrayOfByte;
    this.O = paramGifAction;
  }

  private void a()
  {
    int[] arrayOfInt = new int[this.width * this.height];
    int i1 = this.E;
    int i2 = 0;
    if (i1 > 0)
    {
      if (this.E == 3)
      {
        int i19 = this.N - 2;
        if (i19 > 0);
        for (Bitmap localBitmap = getFrameImage(i19 - 1); ; localBitmap = null)
        {
          this.y = localBitmap;
          break;
        }
      }
      if (this.y != null)
      {
        this.y.getPixels(arrayOfInt, 0, this.width, 0, 0, this.width, this.height);
        if (this.E == 2)
        {
          int i15;
          if (!this.F)
            i15 = this.k;
          else
            i15 = 0;
          for (int i16 = 0; i16 < this.w; i16++)
          {
            int i17 = (i16 + this.u) * this.width + this.t;
            int i18 = i17 + this.v;
            while (i17 < i18)
            {
              arrayOfInt[i17] = i15;
              i17++;
            }
          }
        }
      }
    }
    int i3 = 0;
    int i4 = 1;
    int i5 = 8;
    while (i2 < this.s)
    {
      int i6;
      if (this.n)
      {
        if (i3 >= this.s)
        {
          i4++;
          switch (i4)
          {
          default:
            break;
          case 4:
            i3 = 1;
            i5 = 2;
            break;
          case 3:
            i3 = 2;
            i5 = 4;
            break;
          case 2:
            i3 = 4;
          }
        }
        i6 = i3 + i5;
      }
      else
      {
        i6 = i3;
        i3 = i2;
      }
      int i7 = i3 + this.q;
      if (i7 < this.height)
      {
        int i8 = i7 * this.width;
        int i9 = i8 + this.p;
        int i10 = i9 + this.r;
        if (i8 + this.width < i10)
          i10 = i8 + this.width;
        int i12;
        for (int i11 = i2 * this.r; i9 < i10; i11 = i12)
        {
          byte[] arrayOfByte = this.L;
          i12 = i11 + 1;
          int i13 = 0xFF & arrayOfByte[i11];
          int i14 = this.h[i13];
          if (i14 != 0)
            arrayOfInt[i9] = i14;
          i9++;
        }
      }
      i2++;
      i3 = i6;
    }
    this.x = Bitmap.createBitmap(arrayOfInt, this.width, this.height, Bitmap.Config.ARGB_4444);
  }

  private int[] a(int paramInt)
  {
    int i1 = paramInt * 3;
    byte[] arrayOfByte = new byte[i1];
    int i2 = 0;
    int i3;
    try
    {
      i3 = this.a.read(arrayOfByte);
    }
    catch (Exception localException)
    {
      a.a(localException);
      i3 = 0;
    }
    if (i3 < i1)
    {
      this.b = 1;
      return null;
    }
    int[] arrayOfInt = new int[256];
    int i4 = 0;
    while (i2 < paramInt)
    {
      int i5 = i4 + 1;
      int i6 = 0xFF & arrayOfByte[i4];
      int i7 = i5 + 1;
      int i8 = 0xFF & arrayOfByte[i5];
      int i9 = i7 + 1;
      int i10 = 0xFF & arrayOfByte[i7];
      int i11 = i2 + 1;
      arrayOfInt[i2] = (i10 | (0xFF000000 | i6 << 16 | i8 << 8));
      i4 = i9;
      i2 = i11;
    }
    return arrayOfInt;
  }

  private int b()
  {
    this.a = new ByteArrayInputStream(this.P);
    this.P = null;
    return c();
  }

  private int c()
  {
    f();
    if (this.a != null)
    {
      k();
      if (!e())
      {
        i();
        if (this.N < 0)
        {
          this.b = 1;
        }
        else
        {
          this.b = -1;
          this.O.parseOk(true, -1);
          break label71;
        }
      }
      this.O.parseOk(false, -1);
      try
      {
        label71: this.a.close();
      }
      catch (Exception localException)
      {
        a.a(localException);
      }
    }
    else
    {
      this.b = 2;
      this.O.parseOk(false, -1);
    }
    return this.b;
  }

  private void d()
  {
    int i1 = this.r * this.s;
    if ((this.L == null) || (this.L.length < i1))
      this.L = new byte[i1];
    if (this.I == null)
      this.I = new short[4096];
    if (this.J == null)
      this.J = new byte[4096];
    if (this.K == null)
      this.K = new byte[4097];
    int i2 = g();
    int i3 = 1 << i2;
    int i4 = i3 + 1;
    int i5 = i3 + 2;
    int i6 = i2 + 1;
    int i7 = (1 << i6) - 1;
    for (int i8 = 0; i8 < i3; i8++)
    {
      this.I[i8] = 0;
      this.J[i8] = ((byte)i8);
    }
    int i9 = i6;
    int i10 = i5;
    int i11 = i7;
    int i12 = -1;
    int i13 = 0;
    int i14 = 0;
    int i15 = 0;
    int i16 = 0;
    int i17 = 0;
    int i18 = 0;
    int i19 = 0;
    int i20 = 0;
    while (i13 < i1)
    {
      int i22;
      int i23;
      if (i14 == 0)
      {
        if (i15 < i9)
        {
          if (i16 == 0)
          {
            i16 = h();
            if (i16 <= 0)
              break;
            i18 = 0;
          }
          i17 += ((0xFF & this.B[i18]) << i15);
          i15 += 8;
          i18++;
          i16--;
        }
        else
        {
          int i25 = i17 & i11;
          i17 >>= i9;
          i15 -= i9;
          if ((i25 > i10) || (i25 == i4))
            break;
          if (i25 == i3)
          {
            i9 = i6;
            i10 = i5;
            i11 = i7;
            i12 = -1;
          }
          else if (i12 == -1)
          {
            byte[] arrayOfByte5 = this.K;
            int i33 = i14 + 1;
            int i34 = i6;
            arrayOfByte5[i14] = this.J[i25];
            i12 = i25;
            i19 = i12;
            i14 = i33;
            i6 = i34;
          }
          else
          {
            i22 = i6;
            int i27;
            int i26;
            int i28;
            if (i25 == i10)
            {
              byte[] arrayOfByte4 = this.K;
              i27 = i14 + 1;
              i26 = i25;
              arrayOfByte4[i14] = ((byte)i19);
              i28 = i12;
            }
            else
            {
              i26 = i25;
              i27 = i14;
              i28 = i26;
            }
            while (i28 > i3)
            {
              byte[] arrayOfByte3 = this.K;
              int i31 = i27 + 1;
              int i32 = i3;
              arrayOfByte3[i27] = this.J[i28];
              i28 = this.I[i28];
              i27 = i31;
              i3 = i32;
            }
            i23 = i3;
            int i29 = 0xFF & this.J[i28];
            if (i10 >= 4096)
              break;
            byte[] arrayOfByte2 = this.K;
            i14 = i27 + 1;
            int i30 = (byte)i29;
            arrayOfByte2[i27] = i30;
            this.I[i10] = ((short)i12);
            this.J[i10] = i30;
            i10++;
            if (((i10 & i11) == 0) && (i10 < 4096))
            {
              i9++;
              i11 += i10;
            }
            i19 = i29;
            i12 = i26;
          }
        }
      }
      else
      {
        i22 = i6;
        i23 = i3;
        i14--;
        byte[] arrayOfByte1 = this.L;
        int i24 = i20 + 1;
        arrayOfByte1[i20] = this.K[i14];
        i13++;
        i20 = i24;
        i6 = i22;
        i3 = i23;
      }
    }
    for (int i21 = i20; i21 < i1; i21++)
      this.L[i21] = 0;
  }

  private boolean e()
  {
    return this.b != 0;
  }

  private void f()
  {
    this.b = 0;
    this.N = 0;
    this.M = null;
    this.f = null;
    this.g = null;
  }

  // ERROR //
  private int g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/androlua/GifDecoder:a	Ljava/io/InputStream;
    //   4: invokevirtual 214	java/io/InputStream:read	()I
    //   7: istore_1
    //   8: iload_1
    //   9: ireturn
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 169	com/androlua/GifDecoder:b	I
    //   15: iconst_0
    //   16: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	10	java/lang/Exception
  }

  private int h()
  {
    this.C = g();
    int i1 = this.C;
    int i2 = 0;
    if (i1 > 0)
      try
      {
        while (i2 < this.C)
        {
          int i3 = this.a.read(this.B, i2, this.C - i2);
          if (i3 == -1)
            break;
          i2 += i3;
        }
      }
      catch (Exception localException)
      {
        a.a(localException);
        if (i2 < this.C)
          this.b = 1;
      }
    return i2;
  }

  private void i()
  {
    int i1 = 0;
    while ((i1 == 0) && (!e()))
    {
      int i2 = g();
      if (i2 != 0)
        if (i2 != 33)
        {
          if (i2 != 44)
          {
            if (i2 != 59)
              this.b = 1;
            else
              i1 = 1;
          }
          else
            l();
        }
        else
        {
          int i3 = g();
          if (i3 != 249)
          {
            if (i3 != 255);
            String str;
            do
            {
              q();
              break;
              h();
              str = "";
              for (int i4 = 0; i4 < 11; i4++)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str);
                localStringBuilder.append((char)this.B[i4]);
                str = localStringBuilder.toString();
              }
            }
            while (!str.equals("NETSCAPE2.0"));
            n();
          }
          else
          {
            j();
          }
        }
    }
  }

  private void j()
  {
    g();
    int i1 = g();
    this.D = ((i1 & 0x1C) >> 2);
    int i2 = this.D;
    int i3 = 1;
    if (i2 == 0)
      this.D = i3;
    if ((i1 & i3) == 0)
      i3 = 0;
    this.F = i3;
    this.G = (10 * o());
    this.H = g();
    g();
  }

  private void k()
  {
    String str = "";
    for (int i1 = 0; i1 < 6; i1++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((char)g());
      str = localStringBuilder.toString();
    }
    if (!str.startsWith("GIF"))
    {
      this.b = 1;
      return;
    }
    m();
    if ((this.c) && (!e()))
    {
      this.f = a(this.d);
      this.j = this.f[this.i];
    }
  }

  private void l()
  {
    this.p = o();
    this.q = o();
    this.r = o();
    this.s = o();
    int i1 = g();
    boolean bool1;
    if ((i1 & 0x80) != 0)
      bool1 = true;
    else
      bool1 = false;
    this.m = bool1;
    boolean bool2;
    if ((i1 & 0x40) != 0)
      bool2 = true;
    else
      bool2 = false;
    this.n = bool2;
    this.o = (2 << (i1 & 0x7));
    if (this.m)
    {
      this.g = a(this.o);
      this.h = this.g;
    }
    else
    {
      this.h = this.f;
      if (this.i == this.H)
        this.j = 0;
    }
    int i2;
    if (this.F)
    {
      i2 = this.h[this.H];
      this.h[this.H] = 0;
    }
    else
    {
      i2 = 0;
    }
    if (this.h == null)
      this.b = 1;
    if (e())
      return;
    d();
    q();
    if (e())
      return;
    this.N = (1 + this.N);
    this.x = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
    a();
    if (this.M == null)
    {
      this.M = new GifFrame(this.x, this.G);
      this.z = this.M;
    }
    else
    {
      for (GifFrame localGifFrame = this.M; localGifFrame.nextFrame != null; localGifFrame = localGifFrame.nextFrame);
      localGifFrame.nextFrame = new GifFrame(this.x, this.G);
    }
    if (this.F)
      this.h[this.H] = i2;
    p();
    this.O.parseOk(true, this.N);
  }

  private void m()
  {
    this.width = o();
    this.height = o();
    int i1 = g();
    boolean bool;
    if ((i1 & 0x80) != 0)
      bool = true;
    else
      bool = false;
    this.c = bool;
    this.d = (2 << (i1 & 0x7));
    this.i = g();
    this.l = g();
  }

  private void n()
  {
    do
    {
      h();
      if (this.B[0] == 1)
        this.e = (0xFF & this.B[1] | (0xFF & this.B[2]) << 8);
    }
    while ((this.C > 0) && (!e()));
  }

  private int o()
  {
    return g() | g() << 8;
  }

  private void p()
  {
    this.E = this.D;
    this.t = this.p;
    this.u = this.q;
    this.v = this.r;
    this.w = this.s;
    this.y = this.x;
    this.k = this.j;
    this.D = 0;
    this.F = false;
    this.G = 0;
    this.g = null;
  }

  private void q()
  {
    do
      h();
    while ((this.C > 0) && (!e()));
  }

  public void free()
  {
    while (true)
    {
      GifFrame localGifFrame = this.M;
      if (localGifFrame == null)
        break;
      localGifFrame.image = null;
      this.M = this.M.nextFrame;
    }
    if (this.a != null)
    {
      try
      {
        this.a.close();
      }
      catch (Exception localException)
      {
      }
      this.a = null;
    }
    this.P = null;
  }

  public GifFrame getCurrentFrame()
  {
    return this.z;
  }

  public int getDelay(int paramInt)
  {
    this.G = -1;
    if ((paramInt >= 0) && (paramInt < this.N))
    {
      GifFrame localGifFrame = getFrame(paramInt);
      if (localGifFrame != null)
        this.G = localGifFrame.delay;
    }
    return this.G;
  }

  public int[] getDelays()
  {
    GifFrame localGifFrame = this.M;
    int[] arrayOfInt = new int[this.N];
    for (int i1 = 0; (localGifFrame != null) && (i1 < this.N); i1++)
    {
      arrayOfInt[i1] = localGifFrame.delay;
      localGifFrame = localGifFrame.nextFrame;
    }
    return arrayOfInt;
  }

  public GifFrame getFrame(int paramInt)
  {
    GifFrame localGifFrame = this.M;
    for (int i1 = 0; localGifFrame != null; i1++)
    {
      if (i1 == paramInt)
        return localGifFrame;
      localGifFrame = localGifFrame.nextFrame;
    }
    return null;
  }

  public int getFrameCount()
  {
    return this.N;
  }

  public Bitmap getFrameImage(int paramInt)
  {
    GifFrame localGifFrame = getFrame(paramInt);
    if (localGifFrame == null)
      return null;
    return localGifFrame.image;
  }

  public Bitmap getImage()
  {
    return getFrameImage(0);
  }

  public int getLoopCount()
  {
    return this.e;
  }

  public int getStatus()
  {
    return this.b;
  }

  public GifFrame next()
  {
    if (!this.A)
    {
      this.A = true;
      return this.M;
    }
    if (this.b == 0)
    {
      if (this.z.nextFrame == null);
    }
    else
      for (GifFrame localGifFrame = this.z.nextFrame; ; localGifFrame = this.M)
      {
        this.z = localGifFrame;
        break;
        this.z = this.z.nextFrame;
        if (this.z != null)
          break;
      }
    return this.z;
  }

  public boolean parseOk()
  {
    return this.b == -1;
  }

  public void reset()
  {
    this.z = this.M;
  }

  public void run()
  {
    if (this.a != null)
    {
      c();
      return;
    }
    if (this.P != null)
      b();
  }

  public static abstract interface GifAction
  {
    public abstract void parseOk(boolean paramBoolean, int paramInt);
  }

  public static class GifFrame
  {
    public int delay;
    public Bitmap image;
    public GifFrame nextFrame = null;

    public GifFrame(Bitmap paramBitmap, int paramInt)
    {
      this.image = paramBitmap;
      this.delay = paramInt;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.GifDecoder
 * JD-Core Version:    0.6.2
 */