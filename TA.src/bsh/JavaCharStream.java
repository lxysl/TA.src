package bsh;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JavaCharStream
{
  public static final boolean staticFlag;
  int a;
  int b;
  public int bufpos = -1;
  int c;
  protected int[] d;
  protected int[] e;
  protected int f = 0;
  protected int g = 1;
  protected boolean h = false;
  protected boolean i = false;
  protected Reader j;
  protected char[] k;
  protected char[] l;
  protected int m = 0;
  protected int n = -1;
  protected int o = 0;

  public JavaCharStream(InputStream paramInputStream)
  {
    this(paramInputStream, 1, 1, 4096);
  }

  public JavaCharStream(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    this(paramInputStream, paramInt1, paramInt2, 4096);
  }

  public JavaCharStream(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    this(new InputStreamReader(paramInputStream), paramInt1, paramInt2, 4096);
  }

  public JavaCharStream(Reader paramReader)
  {
    this(paramReader, 1, 1, 4096);
  }

  public JavaCharStream(Reader paramReader, int paramInt1, int paramInt2)
  {
    this(paramReader, paramInt1, paramInt2, 4096);
  }

  public JavaCharStream(Reader paramReader, int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = paramReader;
    this.g = paramInt1;
    this.f = (paramInt2 - 1);
    this.a = paramInt3;
    this.b = paramInt3;
    this.l = new char[paramInt3];
    this.d = new int[paramInt3];
    this.e = new int[paramInt3];
    this.k = new char[4096];
  }

  static final int a(char paramChar)
  {
    switch (paramChar)
    {
    default:
      switch (paramChar)
      {
      default:
        switch (paramChar)
        {
        default:
          throw new IOException();
        case 'f':
        case 'e':
        case 'd':
        case 'c':
        case 'b':
        case 'a':
        }
      case 'F':
        return 15;
      case 'E':
        return 14;
      case 'D':
        return 13;
      case 'C':
        return 12;
      case 'B':
        return 11;
      case 'A':
      }
      return 10;
    case '9':
      return 9;
    case '8':
      return 8;
    case '7':
      return 7;
    case '6':
      return 6;
    case '5':
      return 5;
    case '4':
      return 4;
    case '3':
      return 3;
    case '2':
      return 2;
    case '1':
      return 1;
    case '0':
    }
    return 0;
  }

  public char BeginToken()
  {
    if (this.o > 0)
    {
      this.o = (-1 + this.o);
      int i1 = 1 + this.bufpos;
      this.bufpos = i1;
      if (i1 == this.a)
        this.bufpos = 0;
      this.c = this.bufpos;
      return this.l[this.bufpos];
    }
    this.c = 0;
    this.bufpos = -1;
    return readChar();
  }

  public void Done()
  {
    this.k = null;
    this.l = null;
    this.d = null;
    this.e = null;
  }

  public String GetImage()
  {
    if (this.bufpos >= this.c)
      return new String(this.l, this.c, 1 + (this.bufpos - this.c));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(new String(this.l, this.c, this.a - this.c));
    localStringBuffer.append(new String(this.l, 0, 1 + this.bufpos));
    return localStringBuffer.toString();
  }

  public char[] GetSuffix(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    if (1 + this.bufpos >= paramInt)
    {
      System.arraycopy(this.l, 1 + (this.bufpos - paramInt), arrayOfChar, 0, paramInt);
      return arrayOfChar;
    }
    System.arraycopy(this.l, this.a - (-1 + (paramInt - this.bufpos)), arrayOfChar, 0, -1 + (paramInt - this.bufpos));
    System.arraycopy(this.l, 0, arrayOfChar, -1 + (paramInt - this.bufpos), 1 + this.bufpos);
    return arrayOfChar;
  }

  public void ReInit(InputStream paramInputStream)
  {
    ReInit(paramInputStream, 1, 1, 4096);
  }

  public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    ReInit(paramInputStream, paramInt1, paramInt2, 4096);
  }

  public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    ReInit(new InputStreamReader(paramInputStream), paramInt1, paramInt2, 4096);
  }

  public void ReInit(Reader paramReader)
  {
    ReInit(paramReader, 1, 1, 4096);
  }

  public void ReInit(Reader paramReader, int paramInt1, int paramInt2)
  {
    ReInit(paramReader, paramInt1, paramInt2, 4096);
  }

  public void ReInit(Reader paramReader, int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = paramReader;
    this.g = paramInt1;
    this.f = (paramInt2 - 1);
    if ((this.l == null) || (paramInt3 != this.l.length))
    {
      this.a = paramInt3;
      this.b = paramInt3;
      this.l = new char[paramInt3];
      this.d = new int[paramInt3];
      this.e = new int[paramInt3];
      this.k = new char[4096];
    }
    this.h = false;
    this.i = false;
    this.m = 0;
    this.o = 0;
    this.c = 0;
    this.bufpos = -1;
    this.n = -1;
  }

  protected void a()
  {
    if (this.m == 4096)
    {
      this.n = 0;
      this.m = 0;
    }
    try
    {
      int i1 = this.j.read(this.k, this.m, 4096 - this.m);
      if (i1 == -1)
      {
        this.j.close();
        throw new IOException();
      }
      this.m = (i1 + this.m);
      return;
    }
    catch (IOException localIOException)
    {
      if (this.bufpos != 0)
      {
        this.bufpos = (-1 + this.bufpos);
        backup(0);
      }
      else
      {
        this.d[this.bufpos] = this.g;
        this.e[this.bufpos] = this.f;
      }
      throw localIOException;
    }
  }

  protected void a(boolean paramBoolean)
  {
    char[] arrayOfChar = new char[2048 + this.a];
    int[] arrayOfInt1 = new int[2048 + this.a];
    int[] arrayOfInt2 = new int[2048 + this.a];
    if (paramBoolean);
    try
    {
      System.arraycopy(this.l, this.c, arrayOfChar, 0, this.a - this.c);
      System.arraycopy(this.l, 0, arrayOfChar, this.a - this.c, this.bufpos);
      this.l = arrayOfChar;
      System.arraycopy(this.d, this.c, arrayOfInt1, 0, this.a - this.c);
      System.arraycopy(this.d, 0, arrayOfInt1, this.a - this.c, this.bufpos);
      this.d = arrayOfInt1;
      System.arraycopy(this.e, this.c, arrayOfInt2, 0, this.a - this.c);
      System.arraycopy(this.e, 0, arrayOfInt2, this.a - this.c, this.bufpos);
      this.e = arrayOfInt2;
      this.bufpos += this.a - this.c;
      break label305;
      System.arraycopy(this.l, this.c, arrayOfChar, 0, this.a - this.c);
      this.l = arrayOfChar;
      System.arraycopy(this.d, this.c, arrayOfInt1, 0, this.a - this.c);
      this.d = arrayOfInt1;
      System.arraycopy(this.e, this.c, arrayOfInt2, 0, this.a - this.c);
      this.e = arrayOfInt2;
      this.bufpos -= this.c;
      label305: int i1 = 2048 + this.a;
      this.a = i1;
      this.b = i1;
      this.c = 0;
      return;
      label333: Object localObject;
      throw new Error(localObject.getMessage());
    }
    catch (Throwable localThrowable)
    {
      break label333;
    }
  }

  public void adjustBeginLineColumn(int paramInt1, int paramInt2)
  {
    int i1 = this.c;
    int i2;
    if (this.bufpos >= this.c)
      i2 = 1 + (this.bufpos - this.c + this.o);
    else
      i2 = 1 + (this.a - this.c + this.bufpos) + this.o;
    int i3 = 0;
    int i4 = 0;
    int i10;
    for (int i5 = 0; i3 < i2; i5 = i10)
    {
      int[] arrayOfInt5 = this.d;
      i10 = i1 % this.a;
      int i11 = arrayOfInt5[i10];
      int[] arrayOfInt6 = this.d;
      i1++;
      int i12 = i1 % this.a;
      if (i11 != arrayOfInt6[i12])
      {
        i5 = i10;
        break;
      }
      this.d[i10] = paramInt1;
      int i13 = i4 + this.e[i12] - this.e[i10];
      this.e[i10] = (i4 + paramInt2);
      i3++;
      i4 = i13;
    }
    if (i3 < i2)
    {
      int[] arrayOfInt1 = this.d;
      int i6 = paramInt1 + 1;
      arrayOfInt1[i5] = paramInt1;
      this.e[i5] = (paramInt2 + i4);
      int i7 = i3 + 1;
      if (i3 < i2)
      {
        int[] arrayOfInt2 = this.d;
        i5 = i1 % this.a;
        int i8 = arrayOfInt2[i5];
        int[] arrayOfInt3 = this.d;
        i1++;
        if (i8 != arrayOfInt3[(i1 % this.a)])
        {
          int[] arrayOfInt4 = this.d;
          int i9 = i6 + 1;
          arrayOfInt4[i5] = i6;
          i6 = i9;
        }
        while (true)
        {
          i3 = i7;
          break;
          this.d[i5] = i6;
        }
      }
    }
    this.g = this.d[i5];
    this.f = this.e[i5];
  }

  protected char b()
  {
    int i1 = 1 + this.n;
    this.n = i1;
    if (i1 >= this.m)
      a();
    return this.k[this.n];
  }

  protected void b(char paramChar)
  {
    this.f = (1 + this.f);
    if (this.i)
      this.i = false;
    do
    {
      int i1 = this.g;
      this.f = 1;
      this.g = (i1 + 1);
      break;
      if (!this.h)
        break;
      this.h = false;
    }
    while (paramChar != '\n');
    this.i = true;
    if (paramChar != '\r')
      switch (paramChar)
      {
      default:
        break;
      case '\n':
        this.i = true;
        break;
      case '\t':
        this.f -= 1;
        this.f += 8 - (0x7 & this.f);
        break;
      }
    else
      this.h = true;
    this.d[this.bufpos] = this.g;
    this.e[this.bufpos] = this.f;
  }

  public void backup(int paramInt)
  {
    this.o = (paramInt + this.o);
    int i1 = this.bufpos - paramInt;
    this.bufpos = i1;
    if (i1 < 0)
      this.bufpos += this.a;
  }

  protected void c()
  {
    if (this.b == this.a)
      if (this.c > 2048)
        this.bufpos = 0;
    do
      for (int i1 = this.c; ; i1 = this.a)
      {
        this.b = i1;
        return;
        a(false);
        return;
        if (this.b <= this.c)
          break;
      }
    while (this.c - this.b >= 2048);
    a(true);
  }

  public int getBeginColumn()
  {
    return this.e[this.c];
  }

  public int getBeginLine()
  {
    return this.d[this.c];
  }

  public int getColumn()
  {
    return this.e[this.bufpos];
  }

  public int getEndColumn()
  {
    return this.e[this.bufpos];
  }

  public int getEndLine()
  {
    return this.d[this.bufpos];
  }

  public int getLine()
  {
    return this.d[this.bufpos];
  }

  // ERROR //
  public char readChar()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	bsh/JavaCharStream:o	I
    //   4: ifle +51 -> 55
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 60	bsh/JavaCharStream:o	I
    //   12: iconst_1
    //   13: isub
    //   14: putfield 60	bsh/JavaCharStream:o	I
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 46	bsh/JavaCharStream:bufpos	I
    //   22: iadd
    //   23: istore 21
    //   25: aload_0
    //   26: iload 21
    //   28: putfield 46	bsh/JavaCharStream:bufpos	I
    //   31: iload 21
    //   33: aload_0
    //   34: getfield 64	bsh/JavaCharStream:a	I
    //   37: if_icmpne +8 -> 45
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 46	bsh/JavaCharStream:bufpos	I
    //   45: aload_0
    //   46: getfield 68	bsh/JavaCharStream:l	[C
    //   49: aload_0
    //   50: getfield 46	bsh/JavaCharStream:bufpos	I
    //   53: caload
    //   54: ireturn
    //   55: iconst_1
    //   56: aload_0
    //   57: getfield 46	bsh/JavaCharStream:bufpos	I
    //   60: iadd
    //   61: istore_1
    //   62: aload_0
    //   63: iload_1
    //   64: putfield 46	bsh/JavaCharStream:bufpos	I
    //   67: iload_1
    //   68: aload_0
    //   69: getfield 66	bsh/JavaCharStream:b	I
    //   72: if_icmpne +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 156	bsh/JavaCharStream:c	()V
    //   79: aload_0
    //   80: getfield 68	bsh/JavaCharStream:l	[C
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 46	bsh/JavaCharStream:bufpos	I
    //   88: istore_3
    //   89: aload_0
    //   90: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   93: istore 4
    //   95: aload_2
    //   96: iload_3
    //   97: iload 4
    //   99: castore
    //   100: iload 4
    //   102: bipush 92
    //   104: if_icmpne +338 -> 442
    //   107: aload_0
    //   108: iload 4
    //   110: invokevirtual 160	bsh/JavaCharStream:b	(C)V
    //   113: iconst_1
    //   114: istore 5
    //   116: iconst_1
    //   117: aload_0
    //   118: getfield 46	bsh/JavaCharStream:bufpos	I
    //   121: iadd
    //   122: istore 6
    //   124: aload_0
    //   125: iload 6
    //   127: putfield 46	bsh/JavaCharStream:bufpos	I
    //   130: iload 6
    //   132: aload_0
    //   133: getfield 66	bsh/JavaCharStream:b	I
    //   136: if_icmpne +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 156	bsh/JavaCharStream:c	()V
    //   143: aload_0
    //   144: getfield 68	bsh/JavaCharStream:l	[C
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 46	bsh/JavaCharStream:bufpos	I
    //   153: istore 8
    //   155: aload_0
    //   156: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   159: istore 9
    //   161: aload 7
    //   163: iload 8
    //   165: iload 9
    //   167: castore
    //   168: iload 9
    //   170: bipush 92
    //   172: if_icmpeq +243 -> 415
    //   175: aload_0
    //   176: iload 9
    //   178: invokevirtual 160	bsh/JavaCharStream:b	(C)V
    //   181: iload 9
    //   183: bipush 117
    //   185: if_icmpne +221 -> 406
    //   188: iload 5
    //   190: iconst_1
    //   191: iand
    //   192: iconst_1
    //   193: if_icmpne +213 -> 406
    //   196: aload_0
    //   197: getfield 46	bsh/JavaCharStream:bufpos	I
    //   200: iconst_1
    //   201: isub
    //   202: istore 10
    //   204: aload_0
    //   205: iload 10
    //   207: putfield 46	bsh/JavaCharStream:bufpos	I
    //   210: iload 10
    //   212: ifge +13 -> 225
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 64	bsh/JavaCharStream:a	I
    //   220: iconst_1
    //   221: isub
    //   222: putfield 46	bsh/JavaCharStream:bufpos	I
    //   225: aload_0
    //   226: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   229: istore 17
    //   231: iload 17
    //   233: bipush 117
    //   235: if_icmpeq +92 -> 327
    //   238: aload_0
    //   239: getfield 68	bsh/JavaCharStream:l	[C
    //   242: astore 18
    //   244: aload_0
    //   245: getfield 46	bsh/JavaCharStream:bufpos	I
    //   248: istore 19
    //   250: iload 17
    //   252: invokestatic 162	bsh/JavaCharStream:a	(C)I
    //   255: bipush 12
    //   257: ishl
    //   258: aload_0
    //   259: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   262: invokestatic 162	bsh/JavaCharStream:a	(C)I
    //   265: bipush 8
    //   267: ishl
    //   268: ior
    //   269: aload_0
    //   270: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   273: invokestatic 162	bsh/JavaCharStream:a	(C)I
    //   276: iconst_4
    //   277: ishl
    //   278: ior
    //   279: aload_0
    //   280: invokevirtual 158	bsh/JavaCharStream:b	()C
    //   283: invokestatic 162	bsh/JavaCharStream:a	(C)I
    //   286: ior
    //   287: i2c
    //   288: istore 20
    //   290: aload 18
    //   292: iload 19
    //   294: iload 20
    //   296: castore
    //   297: aload_0
    //   298: iconst_4
    //   299: aload_0
    //   300: getfield 48	bsh/JavaCharStream:f	I
    //   303: iadd
    //   304: putfield 48	bsh/JavaCharStream:f	I
    //   307: iload 5
    //   309: iconst_1
    //   310: if_icmpne +6 -> 316
    //   313: iload 20
    //   315: ireturn
    //   316: aload_0
    //   317: iload 5
    //   319: iconst_1
    //   320: isub
    //   321: invokevirtual 129	bsh/JavaCharStream:backup	(I)V
    //   324: bipush 92
    //   326: ireturn
    //   327: aload_0
    //   328: iconst_1
    //   329: aload_0
    //   330: getfield 48	bsh/JavaCharStream:f	I
    //   333: iadd
    //   334: putfield 48	bsh/JavaCharStream:f	I
    //   337: goto -112 -> 225
    //   340: new 95	java/lang/StringBuffer
    //   343: dup
    //   344: invokespecial 96	java/lang/StringBuffer:<init>	()V
    //   347: astore 11
    //   349: aload 11
    //   351: ldc 164
    //   353: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   356: pop
    //   357: aload 11
    //   359: aload_0
    //   360: getfield 50	bsh/JavaCharStream:g	I
    //   363: invokevirtual 167	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   366: pop
    //   367: aload 11
    //   369: ldc 169
    //   371: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   374: pop
    //   375: aload 11
    //   377: aload_0
    //   378: getfield 48	bsh/JavaCharStream:f	I
    //   381: invokevirtual 167	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   384: pop
    //   385: aload 11
    //   387: ldc 171
    //   389: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   392: pop
    //   393: new 134	java/lang/Error
    //   396: dup
    //   397: aload 11
    //   399: invokevirtual 103	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   402: invokespecial 140	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   405: athrow
    //   406: aload_0
    //   407: iload 5
    //   409: invokevirtual 129	bsh/JavaCharStream:backup	(I)V
    //   412: bipush 92
    //   414: ireturn
    //   415: aload_0
    //   416: iload 9
    //   418: invokevirtual 160	bsh/JavaCharStream:b	(C)V
    //   421: iinc 5 1
    //   424: goto -308 -> 116
    //   427: iload 5
    //   429: iconst_1
    //   430: if_icmple +9 -> 439
    //   433: aload_0
    //   434: iload 5
    //   436: invokevirtual 129	bsh/JavaCharStream:backup	(I)V
    //   439: bipush 92
    //   441: ireturn
    //   442: aload_0
    //   443: iload 4
    //   445: invokevirtual 160	bsh/JavaCharStream:b	(C)V
    //   448: iload 4
    //   450: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   225	231	340	java/io/IOException
    //   238	307	340	java/io/IOException
    //   327	337	340	java/io/IOException
    //   143	168	427	java/io/IOException
    //   175	181	427	java/io/IOException
    //   196	210	427	java/io/IOException
    //   215	225	427	java/io/IOException
    //   406	412	427	java/io/IOException
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.JavaCharStream
 * JD-Core Version:    0.6.2
 */