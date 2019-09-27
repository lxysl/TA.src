package bsh.org.objectweb.asm;

public class CodeWriter
  implements CodeVisitor
{
  private static final int[] w;
  private static Edge z;
  CodeWriter a;
  private ClassWriter b;
  private Item c;
  private Item d;
  private int e;
  private int f;
  private int g;
  private ByteVector h = new ByteVector();
  private int i;
  private ByteVector j;
  private int k;
  private int[] l;
  private int m;
  private ByteVector n;
  private int o;
  private ByteVector p;
  private boolean q;
  private final boolean r;
  private int s;
  private int t;
  private Label u;
  private Label v;
  private Edge x;
  private Edge y;

  static
  {
    int[] arrayOfInt = new int['Ê'];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfInt.length)
      {
        w = arrayOfInt;
        return;
      }
      arrayOfInt[i1] = ('ﾻ' + "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i1));
    }
  }

  protected CodeWriter(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    if (paramClassWriter.a == null)
      paramClassWriter.a = this;
    while (true)
    {
      paramClassWriter.b = this;
      break;
      paramClassWriter.b.a = this;
    }
    this.b = paramClassWriter;
    this.r = paramBoolean;
    if (paramBoolean)
    {
      this.u = new Label();
      this.u.g = true;
      this.v = this.u;
    }
  }

  private static int a(String paramString)
  {
    int i1 = 1;
    int i2 = 1;
    int i3 = 1;
    while (true)
    {
      int i4 = i2 + 1;
      int i5 = paramString.charAt(i2);
      if (i5 == 41)
      {
        int i7 = paramString.charAt(i4);
        int i8 = i3 << 2;
        if (i7 == 86)
          i1 = 0;
        else if ((i7 == 68) || (i7 == 74))
          i1 = 2;
        return i8 | i1;
      }
      if (i5 == 76)
        while (true)
        {
          i2 = i4 + 1;
          if (paramString.charAt(i4) == ';')
          {
            i3++;
            break;
          }
          i4 = i2;
        }
      if (i5 == 91)
        for (i2 = i4; ; i2++)
        {
          int i6 = paramString.charAt(i2);
          if (i6 != 91)
          {
            if ((i6 != 68) && (i6 != 74))
              break;
            i3--;
            break;
          }
        }
      if ((i5 != 68) && (i5 != 74))
        i3++;
      else
        i3 += 2;
      i2 = i4;
    }
  }

  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 1)];
  }

  static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 - paramInt1;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= paramArrayOfInt1.length)
        return i1;
      if ((paramInt1 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt2))
        i1 += paramArrayOfInt2[i2];
      else if ((paramInt2 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt1))
        i1 -= paramArrayOfInt2[i2];
    }
  }

  private void a(int paramInt, Label paramLabel)
  {
    synchronized (w)
    {
      Edge localEdge;
      if (z == null)
      {
        localEdge = new Edge();
      }
      else
      {
        localEdge = z;
        z = z.d;
      }
      if (this.y == null)
        this.y = localEdge;
      localEdge.d = this.x;
      this.x = localEdge;
      localEdge.a = paramInt;
      localEdge.b = paramLabel;
      localEdge.c = this.u.e;
      this.u.e = localEdge;
      return;
    }
  }

  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }

  static short b(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)((0xFF & paramArrayOfByte[paramInt]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 1)]);
  }

  static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 24 | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 3)];
  }

  final int a()
  {
    if (this.q)
      a(new int[0], new int[0], 0);
    int i1;
    if (this.h.b > 0)
    {
      this.b.a("Code");
      i1 = 8 + (18 + this.h.b + 8 * this.i);
      if (this.n != null)
        i1 += 8 + this.n.b;
      if (this.p != null)
        i1 += 8 + this.p.b;
    }
    else
    {
      i1 = 8;
    }
    if (this.k > 0)
    {
      this.b.a("Exceptions");
      i1 += 8 + 2 * this.k;
    }
    if ((0x10000 & this.e) != 0)
    {
      this.b.a("Synthetic");
      i1 += 6;
    }
    if ((0x20000 & this.e) != 0)
    {
      this.b.a("Deprecated");
      i1 += 6;
    }
    return i1;
  }

  protected void a(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.e = paramInt;
    this.c = this.b.a(paramString1);
    this.d = this.b.a(paramString2);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.k = paramArrayOfString.length;
      this.l = new int[this.k];
      for (int i2 = 0; i2 < this.k; i2++)
        this.l[i2] = this.b.b(paramArrayOfString[i2]).a;
    }
    if (this.r)
    {
      int i1 = a(paramString2) >> 2;
      if ((paramInt & 0x8) != 0)
        i1--;
      if (i1 > this.g)
        this.g = i1;
    }
  }

  final void a(ByteVector paramByteVector)
  {
    paramByteVector.put2(this.e).put2(this.c.a).put2(this.d.a);
    int i1 = this.h.b;
    int i2 = 1;
    int i3;
    if (i1 > 0)
      i3 = 1;
    else
      i3 = 0;
    if (this.k > 0)
      i3++;
    if ((0x10000 & this.e) != 0)
      i3++;
    if ((0x20000 & this.e) != 0)
      i3++;
    paramByteVector.put2(i3);
    if (this.h.b > 0)
    {
      int i5 = 12 + this.h.b + 8 * this.i;
      if (this.n != null)
        i5 += 8 + this.n.b;
      if (this.p != null)
        i5 += 8 + this.p.b;
      paramByteVector.put2(this.b.a("Code").a).put4(i5);
      paramByteVector.put2(this.f).put2(this.g);
      paramByteVector.put4(this.h.b).putByteArray(this.h.a, 0, this.h.b);
      paramByteVector.put2(this.i);
      if (this.i > 0)
        paramByteVector.putByteArray(this.j.a, 0, this.j.b);
      if (this.n == null)
        i2 = 0;
      if (this.p != null)
        i2++;
      paramByteVector.put2(i2);
      if (this.n != null)
      {
        paramByteVector.put2(this.b.a("LocalVariableTable").a);
        paramByteVector.put4(2 + this.n.b).put2(this.m);
        paramByteVector.putByteArray(this.n.a, 0, this.n.b);
      }
      if (this.p != null)
      {
        paramByteVector.put2(this.b.a("LineNumberTable").a);
        paramByteVector.put4(2 + this.p.b).put2(this.o);
        paramByteVector.putByteArray(this.p.a, 0, this.p.b);
      }
    }
    if (this.k > 0)
    {
      paramByteVector.put2(this.b.a("Exceptions").a).put4(2 + 2 * this.k);
      paramByteVector.put2(this.k);
      for (int i4 = 0; i4 < this.k; i4++)
        paramByteVector.put2(this.l[i4]);
    }
    if ((0x10000 & this.e) != 0)
      paramByteVector.put2(this.b.a("Synthetic").a).put4(0);
    if ((0x20000 & this.e) != 0)
      paramByteVector.put2(this.b.a("Deprecated").a).put4(0);
  }

  protected int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    byte[] arrayOfByte1 = this.h.a;
    int[] arrayOfInt1 = new int[paramInt];
    int[] arrayOfInt2 = new int[paramInt];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt1, 0, paramInt);
    System.arraycopy(paramArrayOfInt2, 0, arrayOfInt2, 0, paramInt);
    boolean[] arrayOfBoolean = new boolean[this.h.b];
    int i1 = 3;
    Object localObject1 = arrayOfInt2;
    Object localObject2 = arrayOfInt1;
    int i2 = 3;
    if (i2 == i1)
      i2 = 2;
    Object localObject3 = localObject1;
    Object localObject4 = localObject2;
    int i3 = i2;
    int i4 = 0;
    while (true)
    {
      int i5 = arrayOfByte1.length;
      int i6 = 132;
      if (i4 >= i5)
      {
        if (i3 < i1)
          i3--;
        i2 = i3;
        if (i2 == 0)
        {
          ByteVector localByteVector = new ByteVector(this.h.b);
          int i16 = 0;
          if (i16 >= this.h.b)
          {
            if (this.j != null)
            {
              byte[] arrayOfByte4 = this.j.a;
              for (int i42 = 0; i42 < this.j.b; i42 += 8)
              {
                a(arrayOfByte4, i42, a(localObject4, localObject3, 0, a(arrayOfByte4, i42)));
                int i43 = i42 + 2;
                a(arrayOfByte4, i43, a(localObject4, localObject3, 0, a(arrayOfByte4, i43)));
                int i44 = i42 + 4;
                a(arrayOfByte4, i44, a(localObject4, localObject3, 0, a(arrayOfByte4, i44)));
              }
            }
            if (this.n != null)
            {
              byte[] arrayOfByte3 = this.n.a;
              for (int i39 = 0; i39 < this.n.b; i39 += 10)
              {
                int i40 = a(arrayOfByte3, i39);
                int i41 = a(localObject4, localObject3, 0, i40);
                a(arrayOfByte3, i39, i41);
                a(arrayOfByte3, i39, a(localObject4, localObject3, 0, i40 + a(arrayOfByte3, i39 + 2)) - i41);
              }
            }
            if (this.p != null)
            {
              byte[] arrayOfByte2 = this.p.a;
              for (int i38 = 0; i38 < this.p.b; i38 += 4)
                a(arrayOfByte2, i38, a(localObject4, localObject3, 0, a(arrayOfByte2, i38)));
            }
            this.h = localByteVector;
            return paramArrayOfInt1;
          }
          int i17 = localObject4.length - 1;
          while (true)
          {
            if (i17 < 0)
            {
              int i18 = 0xFF & arrayOfByte1[i16];
              switch (ClassWriter.f[i18])
              {
              case 15:
              default:
                localByteVector.putByteArray(arrayOfByte1, i16, 4);
                i16 += 4;
              case 16:
              case 14:
              case 13:
              case 9:
              case 8:
              case 7:
              case 2:
              case 5:
              case 6:
              case 11:
              case 12:
              case 1:
              case 3:
              case 10:
              case 0:
              case 4:
              }
              while (true)
              {
                i6 = 132;
                break;
                if ((0xFF & arrayOfByte1[(i16 + 1)]) == i6)
                {
                  localByteVector.putByteArray(arrayOfByte1, i16, 6);
                  i16 += 6;
                  break;
                }
                localByteVector.putByteArray(arrayOfByte1, i16, 4);
                i16 += 4;
                break;
                int i31 = i16 + 4 - (i16 & 0x3);
                localByteVector.put1(171);
                while (true)
                {
                  if (localByteVector.b % 4 == 0)
                  {
                    int i32 = i16 + c(arrayOfByte1, i31);
                    int i33 = i31 + 4;
                    localByteVector.put4(a(localObject4, localObject3, i16, i32));
                    int i34 = c(arrayOfByte1, i33);
                    int i35 = i33 + 4;
                    localByteVector.put4(i34);
                    while (true)
                    {
                      if (i34 <= 0)
                      {
                        i16 = i35;
                        break;
                      }
                      localByteVector.put4(c(arrayOfByte1, i35));
                      int i36 = i35 + 4;
                      int i37 = i16 + c(arrayOfByte1, i36);
                      i35 = i36 + 4;
                      localByteVector.put4(a(localObject4, localObject3, i16, i37));
                      i34--;
                      i6 = 132;
                    }
                  }
                  localByteVector.put1(0);
                  i6 = 132;
                }
                int i23 = i16 + 4 - (i16 & 0x3);
                localByteVector.put1(170);
                while (true)
                {
                  if (localByteVector.b % 4 == 0)
                  {
                    int i24 = i16 + c(arrayOfByte1, i23);
                    int i25 = i23 + 4;
                    localByteVector.put4(a(localObject4, localObject3, i16, i24));
                    int i26 = c(arrayOfByte1, i25);
                    int i27 = i25 + 4;
                    localByteVector.put4(i26);
                    int i28 = 1 + (c(arrayOfByte1, i27) - i26);
                    int i29 = i27 + 4;
                    localByteVector.put4(c(arrayOfByte1, i29 - 4));
                    while (true)
                    {
                      if (i28 <= 0)
                      {
                        i16 = i29;
                        break;
                      }
                      int i30 = i16 + c(arrayOfByte1, i29);
                      i29 += 4;
                      localByteVector.put4(a(localObject4, localObject3, i16, i30));
                      i28--;
                    }
                  }
                  localByteVector.put1(0);
                }
                int i22 = a(localObject4, localObject3, i16, i16 + c(arrayOfByte1, i16 + 1));
                localByteVector.put1(i18);
                localByteVector.put4(i22);
                break label1263;
                int i19;
                if (i18 > 201)
                {
                  if (i18 < 218)
                    i18 -= 49;
                  else
                    i18 -= 20;
                  i19 = a(arrayOfByte1, i16 + 1);
                }
                else
                {
                  i19 = b(arrayOfByte1, i16 + 1);
                }
                int i20 = a(localObject4, localObject3, i16, i19 + i16);
                if ((i20 >= -32768) && (i20 <= 32767))
                {
                  localByteVector.put1(i18);
                  localByteVector.put2(i20);
                }
                else
                {
                  if (i18 == 167)
                  {
                    localByteVector.put1(200);
                  }
                  else if (i18 == 168)
                  {
                    localByteVector.put1(201);
                  }
                  else
                  {
                    int i21;
                    if (i18 <= 166)
                      i21 = (0x1 ^ i18 + 1) - 1;
                    else
                      i21 = i18 ^ 0x1;
                    localByteVector.put1(i21);
                    localByteVector.put2(8);
                    localByteVector.put1(200);
                    i20 -= 3;
                  }
                  localByteVector.put4(i20);
                  break label1281;
                  localByteVector.putByteArray(arrayOfByte1, i16, 5);
                  label1263: i16 += 5;
                  continue;
                  localByteVector.putByteArray(arrayOfByte1, i16, i1);
                }
                label1281: i16 += 3;
                continue;
                localByteVector.putByteArray(arrayOfByte1, i16, 2);
                i16 += 2;
                continue;
                localByteVector.put1(i18);
                i16++;
              }
            }
            if ((localObject4[i17] == i16) && (i17 < paramInt))
            {
              if (paramArrayOfInt2[i17] > 0)
                localByteVector.putByteArray(null, 0, paramArrayOfInt2[i17]);
              else
                localByteVector.b += paramArrayOfInt2[i17];
              paramArrayOfInt1[i17] = localByteVector.b;
            }
            i17--;
            i6 = 132;
          }
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
      }
      int i7 = 0xFF & arrayOfByte1[i4];
      switch (ClassWriter.f[i7])
      {
      case 15:
      default:
        i4 += 4;
      case 16:
      case 14:
      case 13:
      case 8:
      case 7:
      case 9:
      case 2:
      case 5:
      case 6:
      case 11:
      case 12:
      case 1:
      case 3:
      case 10:
      case 0:
      case 4:
      }
      int i8;
      while (true)
      {
        i8 = 0;
        break label1886;
        if ((0xFF & arrayOfByte1[(i4 + 1)]) != 132)
          break;
        i4 += 6;
        continue;
        if (i3 == 1)
        {
          i8 = -(i1 & a(localObject4, localObject3, 0, i4));
        }
        else if (arrayOfBoolean[i4] == 0)
        {
          i8 = i4 & 0x3;
          arrayOfBoolean[i4] = true;
        }
        else
        {
          i8 = 0;
        }
        int i15 = i4 + 4 - (i4 & 0x3);
        i4 = i15 + (8 + 8 * c(arrayOfByte1, i15 + 4));
        break label1886;
        int i12;
        if (i3 == 1)
        {
          i12 = -(i1 & a(localObject4, localObject3, 0, i4));
        }
        else if (arrayOfBoolean[i4] == 0)
        {
          i12 = i4 & 0x3;
          arrayOfBoolean[i4] = true;
        }
        else
        {
          i12 = 0;
        }
        int i13 = i4 + 4 - (i4 & 0x3);
        int i14 = i13 + (12 + 4 * (1 + (c(arrayOfByte1, i13 + 8) - c(arrayOfByte1, i13 + 4))));
        i8 = i12;
        i4 = i14;
        break label1886;
        int i9;
        if (i7 > 201)
        {
          if (i7 < 218)
            i7 -= 49;
          else
            i7 -= 20;
          i9 = a(arrayOfByte1, i4 + 1);
        }
        else
        {
          i9 = b(arrayOfByte1, i4 + 1);
        }
        int i10 = a(localObject4, localObject3, i4, i9 + i4);
        int i11;
        if (((i10 < -32768) || (i10 > 32767)) && (arrayOfBoolean[i4] == 0))
        {
          if ((i7 != 167) && (i7 != 168))
            i11 = 5;
          else
            i11 = 2;
          arrayOfBoolean[i4] = true;
        }
        else
        {
          i11 = 0;
        }
        i4 += 3;
        i8 = i11;
        break label1886;
        i4 += 5;
        continue;
        i4 += 3;
        continue;
        i4 += 2;
        continue;
        i4++;
      }
      label1886: if (i8 != 0)
      {
        int[] arrayOfInt3 = new int[1 + localObject4.length];
        int[] arrayOfInt4 = new int[1 + localObject3.length];
        System.arraycopy(localObject4, 0, arrayOfInt3, 0, localObject4.length);
        System.arraycopy(localObject3, 0, arrayOfInt4, 0, localObject3.length);
        arrayOfInt3[localObject4.length] = i4;
        arrayOfInt4[localObject3.length] = i8;
        if (i8 > 0)
        {
          localObject4 = arrayOfInt3;
          localObject3 = arrayOfInt4;
          i3 = 3;
        }
        else
        {
          localObject4 = arrayOfInt3;
          localObject3 = arrayOfInt4;
        }
      }
      i1 = 3;
    }
  }

  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (this.r)
    {
      int i1 = paramString3.charAt(0);
      int i2 = -2;
      int i3 = 1;
      int i6;
      switch (paramInt)
      {
      default:
        i6 = this.s;
        if (i1 != 68)
          if (i1 != 74)
            break label173;
        break;
      case 180:
        int i7 = this.s;
        int i8;
        if (i1 != 68)
        {
          i8 = 0;
          if (i1 != 74);
        }
        else
        {
          i8 = 1;
        }
        i5 = i7 + i8;
        break;
      case 179:
        i6 = this.s;
        if ((i1 == 68) || (i1 == 74))
          break label173;
        i2 = -1;
        break;
      case 178:
        int i4 = this.s;
        if ((i1 == 68) || (i1 == 74))
          i3 = 2;
        i5 = i4 + i3;
        break;
      }
      i2 = -3;
      label173: int i5 = i2 + i6;
      if (i5 > this.t)
        this.t = i5;
      this.s = i5;
    }
    this.h.put12(paramInt, this.b.a(paramString1, paramString2, paramString3).a);
  }

  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    if (this.r)
    {
      int i1 = paramInt1 + 1;
      if (i1 > this.g)
        this.g = i1;
    }
    if ((paramInt1 <= 255) && (paramInt2 <= 127) && (paramInt2 >= -128))
    {
      this.h.put1(132).put11(paramInt1, paramInt2);
      return;
    }
    this.h.put1(196).put12(132, paramInt1).put2(paramInt2);
  }

  public void visitInsn(int paramInt)
  {
    if (this.r)
    {
      int i1 = this.s + w[paramInt];
      if (i1 > this.t)
        this.t = i1;
      this.s = i1;
      if (((paramInt >= 172) && (paramInt <= 177)) || ((paramInt == 191) && (this.u != null)))
      {
        this.u.d = this.t;
        this.u = null;
      }
    }
    this.h.put1(paramInt);
  }

  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    if ((this.r) && (paramInt1 != 188))
    {
      int i1 = 1 + this.s;
      if (i1 > this.t)
        this.t = i1;
      this.s = i1;
    }
    if (paramInt1 == 17)
    {
      this.h.put12(paramInt1, paramInt2);
      return;
    }
    this.h.put11(paramInt1, paramInt2);
  }

  public void visitJumpInsn(int paramInt, Label paramLabel)
  {
    if (this.r)
      if (paramInt == 167)
      {
        if (this.u != null)
        {
          this.u.d = this.t;
          a(this.s, paramLabel);
          this.u = null;
        }
      }
      else if (paramInt == 168)
      {
        if (this.u == null);
      }
      else
        for (int i3 = 1 + this.s; ; i3 = this.s)
        {
          a(i3, paramLabel);
          break;
          this.s += w[paramInt];
          if (this.u == null)
            break;
        }
    if ((paramLabel.a) && (paramLabel.b - this.h.b < -32768))
    {
      int i1 = 200;
      if (paramInt == 167);
      while (true)
      {
        ByteVector localByteVector2 = this.h;
        while (true)
        {
          localByteVector2.put1(i1);
          break label237;
          if (paramInt != 168)
            break;
          localByteVector2 = this.h;
          i1 = 201;
        }
        ByteVector localByteVector1 = this.h;
        int i2;
        if (paramInt <= 166)
          i2 = (0x1 ^ paramInt + 1) - 1;
        else
          i2 = paramInt ^ 0x1;
        localByteVector1.put1(i2);
        this.h.put2(8);
      }
      label237: paramLabel.a(this, this.h, this.h.b - 1, true);
      return;
    }
    this.h.put1(paramInt);
    paramLabel.a(this, this.h, this.h.b - 1, false);
  }

  public void visitLabel(Label paramLabel)
  {
    if (this.r)
    {
      if (this.u != null)
      {
        this.u.d = this.t;
        a(this.s, paramLabel);
      }
      this.u = paramLabel;
      this.s = 0;
      this.t = 0;
    }
    this.q |= paramLabel.a(this, this.h.b, this.h.a);
  }

  public void visitLdcInsn(Object paramObject)
  {
    Item localItem = this.b.a(paramObject);
    if (this.r)
    {
      int i3;
      if ((localItem.b != 5) && (localItem.b != 6))
        i3 = 1 + this.s;
      else
        i3 = 2 + this.s;
      if (i3 > this.t)
        this.t = i3;
      this.s = i3;
    }
    int i1 = localItem.a;
    ByteVector localByteVector;
    int i2;
    if ((localItem.b != 5) && (localItem.b != 6))
    {
      if (i1 >= 256)
      {
        localByteVector = this.h;
        i2 = 19;
      }
      else
      {
        this.h.put11(18, i1);
      }
    }
    else
    {
      localByteVector = this.h;
      i2 = 20;
    }
    localByteVector.put12(i2, i1);
  }

  public void visitLineNumber(int paramInt, Label paramLabel)
  {
    if (this.p == null)
    {
      this.b.a("LineNumberTable");
      this.p = new ByteVector();
    }
    this.o = (1 + this.o);
    this.p.put2(paramLabel.b);
    this.p.put2(paramInt);
  }

  public void visitLocalVariable(String paramString1, String paramString2, Label paramLabel1, Label paramLabel2, int paramInt)
  {
    if (this.n == null)
    {
      this.b.a("LocalVariableTable");
      this.n = new ByteVector();
    }
    this.m = (1 + this.m);
    this.n.put2(paramLabel1.b);
    this.n.put2(paramLabel2.b - paramLabel1.b);
    this.n.put2(this.b.a(paramString1).a);
    this.n.put2(this.b.a(paramString2).a);
    this.n.put2(paramInt);
  }

  public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfInt, Label[] paramArrayOfLabel)
  {
    boolean bool = this.r;
    int i1 = 0;
    if (bool)
    {
      this.s -= 1;
      if (this.u != null)
      {
        this.u.d = this.t;
        a(this.s, paramLabel);
        for (int i3 = 0; ; i3++)
        {
          if (i3 >= paramArrayOfLabel.length)
          {
            this.u = null;
            break;
          }
          a(this.s, paramArrayOfLabel[i3]);
        }
      }
    }
    int i2 = this.h.b;
    this.h.put1(171);
    while (true)
    {
      if (this.h.b % 4 == 0)
      {
        paramLabel.a(this, this.h, i2, true);
        this.h.put4(paramArrayOfLabel.length);
        while (true)
        {
          if (i1 >= paramArrayOfLabel.length)
            return;
          this.h.put4(paramArrayOfInt[i1]);
          paramArrayOfLabel[i1].a(this, this.h, i2, true);
          i1++;
        }
      }
      this.h.put1(0);
    }
  }

  public void visitMaxs(int paramInt1, int paramInt2)
  {
    if (this.r)
    {
      int i1 = 0;
      Object localObject1 = this.v;
      if (localObject1 == null)
      {
        this.f = i1;
        synchronized (w)
        {
          if (this.y != null)
          {
            this.y.d = z;
            z = this.x;
          }
          return;
        }
      }
      Label localLabel1 = ((Label)localObject1).f;
      int i2 = ((Label)localObject1).c;
      int i3 = i2 + ((Label)localObject1).d;
      if (i3 <= i1)
        i3 = i1;
      Edge localEdge = ((Label)localObject1).e;
      localObject1 = localLabel1;
      while (true)
      {
        if (localEdge == null)
        {
          i1 = i3;
          break;
        }
        Label localLabel2 = localEdge.b;
        if (!localLabel2.g)
        {
          localLabel2.c = (i2 + localEdge.a);
          localLabel2.g = true;
          localLabel2.f = ((Label)localObject1);
          localObject1 = localLabel2;
        }
        localEdge = localEdge.c;
      }
    }
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Item localItem;
    if (paramInt == 185)
      localItem = this.b.c(paramString1, paramString2, paramString3);
    else
      localItem = this.b.b(paramString1, paramString2, paramString3);
    int i1 = localItem.c;
    if (this.r)
    {
      if (i1 == 0)
      {
        i1 = a(paramString3);
        localItem.c = i1;
      }
      int i2;
      if (paramInt == 184)
        i2 = 1 + (this.s - (i1 >> 2) + (i1 & 0x3));
      else
        i2 = this.s - (i1 >> 2) + (i1 & 0x3);
      if (i2 > this.t)
        this.t = i2;
      this.s = i2;
    }
    if (paramInt == 185)
    {
      if ((!this.r) && (i1 == 0))
      {
        i1 = a(paramString3);
        localItem.c = i1;
      }
      this.h.put12(185, localItem.a).put11(i1 >> 2, 0);
      return;
    }
    this.h.put12(paramInt, localItem.a);
  }

  public void visitMultiANewArrayInsn(String paramString, int paramInt)
  {
    if (this.r)
      this.s += 1 - paramInt;
    Item localItem = this.b.b(paramString);
    this.h.put12(197, localItem.a).put1(paramInt);
  }

  public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label[] paramArrayOfLabel)
  {
    boolean bool = this.r;
    int i1 = 0;
    if (bool)
    {
      this.s -= 1;
      if (this.u != null)
      {
        this.u.d = this.t;
        a(this.s, paramLabel);
        for (int i3 = 0; ; i3++)
        {
          if (i3 >= paramArrayOfLabel.length)
          {
            this.u = null;
            break;
          }
          a(this.s, paramArrayOfLabel[i3]);
        }
      }
    }
    int i2 = this.h.b;
    this.h.put1(170);
    while (true)
    {
      if (this.h.b % 4 == 0)
      {
        paramLabel.a(this, this.h, i2, true);
        this.h.put4(paramInt1).put4(paramInt2);
        while (true)
        {
          if (i1 >= paramArrayOfLabel.length)
            return;
          paramArrayOfLabel[i1].a(this, this.h, i2, true);
          i1++;
        }
      }
      this.h.put1(0);
    }
  }

  public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString)
  {
    if ((this.r) && (!paramLabel3.g))
    {
      paramLabel3.c = 1;
      paramLabel3.g = true;
      paramLabel3.f = this.v;
      this.v = paramLabel3;
    }
    this.i = (1 + this.i);
    if (this.j == null)
      this.j = new ByteVector();
    this.j.put2(paramLabel1.b);
    this.j.put2(paramLabel2.b);
    this.j.put2(paramLabel3.b);
    ByteVector localByteVector = this.j;
    int i1;
    if (paramString != null)
      i1 = this.b.b(paramString).a;
    else
      i1 = 0;
    localByteVector.put2(i1);
  }

  public void visitTypeInsn(int paramInt, String paramString)
  {
    if ((this.r) && (paramInt == 187))
    {
      int i1 = 1 + this.s;
      if (i1 > this.t)
        this.t = i1;
      this.s = i1;
    }
    this.h.put12(paramInt, this.b.b(paramString).a);
  }

  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    if (this.r)
    {
      if (paramInt1 == 169)
      {
        if (this.u != null)
        {
          this.u.d = this.t;
          this.u = null;
        }
      }
      else
      {
        int i3 = this.s + w[paramInt1];
        if (i3 > this.t)
          this.t = i3;
        this.s = i3;
      }
      int i4;
      if ((paramInt1 != 22) && (paramInt1 != 24) && (paramInt1 != 55) && (paramInt1 != 57))
        i4 = paramInt2 + 1;
      else
        i4 = paramInt2 + 2;
      if (i4 > this.g)
        this.g = i4;
    }
    if ((paramInt2 < 4) && (paramInt1 != 169))
    {
      if (paramInt1 < 54);
      int i2;
      for (int i1 = 26 + (paramInt1 - 21 << 2); ; i1 = 59 + (paramInt1 - 54 << 2))
      {
        i2 = i1 + paramInt2;
        break;
      }
      this.h.put1(i2);
      return;
    }
    if (paramInt2 >= 256)
    {
      this.h.put1(196).put12(paramInt1, paramInt2);
      return;
    }
    this.h.put11(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.CodeWriter
 * JD-Core Version:    0.6.2
 */