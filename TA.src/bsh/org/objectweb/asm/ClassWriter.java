package bsh.org.objectweb.asm;

public class ClassWriter
  implements ClassVisitor
{
  static byte[] f;
  CodeWriter a;
  CodeWriter b;
  Item c = new Item();
  Item d = new Item();
  Item e = new Item();
  private short g = 1;
  private ByteVector h = new ByteVector();
  private Item[] i = new Item[64];
  private int j = (int)(0.75D * this.i.length);
  private int k;
  private int l;
  private int m;
  private int n;
  private int[] o;
  private Item p;
  private int q;
  private ByteVector r;
  private boolean s;
  private int t;
  private ByteVector u;

  static
  {
    byte[] arrayOfByte = new byte['Ü'];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfByte.length)
      {
        f = arrayOfByte;
        return;
      }
      arrayOfByte[i1] = ((byte)('﾿' + "AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHAFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII".charAt(i1)));
    }
  }

  public ClassWriter(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  private Item a(double paramDouble)
  {
    this.c.a(paramDouble);
    Item localItem = a(this.c);
    if (localItem == null)
    {
      this.h.put1(6).put8(Double.doubleToLongBits(paramDouble));
      localItem = new Item(this.g, this.c);
      b(localItem);
      this.g = ((short)(2 + this.g));
    }
    return localItem;
  }

  private Item a(float paramFloat)
  {
    this.c.a(paramFloat);
    Item localItem = a(this.c);
    if (localItem == null)
    {
      this.h.put1(4).put4(Float.floatToIntBits(paramFloat));
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.c);
      b(localItem);
    }
    return localItem;
  }

  private Item a(int paramInt)
  {
    this.c.a(paramInt);
    Item localItem = a(this.c);
    if (localItem == null)
    {
      this.h.put1(3).put4(paramInt);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.c);
      b(localItem);
    }
    return localItem;
  }

  private Item a(long paramLong)
  {
    this.c.a(paramLong);
    Item localItem = a(this.c);
    if (localItem == null)
    {
      this.h.put1(5).put8(paramLong);
      localItem = new Item(this.g, this.c);
      b(localItem);
      this.g = ((short)(2 + this.g));
    }
    return localItem;
  }

  private Item a(Item paramItem)
  {
    Item[] arrayOfItem = this.i;
    int i1 = paramItem.j;
    for (Item localItem = arrayOfItem[((0x7FFFFFFF & i1) % arrayOfItem.length)]; ; localItem = localItem.k)
    {
      if (localItem == null)
        return null;
      if ((localItem.j == i1) && (paramItem.a(localItem)))
        return localItem;
    }
  }

  private Item a(String paramString1, String paramString2)
  {
    this.d.a(12, paramString1, paramString2, null);
    Item localItem = a(this.d);
    if (localItem == null)
    {
      a(12, a(paramString1).a, a(paramString2).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.d);
      b(localItem);
    }
    return localItem;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h.put12(paramInt1, paramInt2).put2(paramInt3);
  }

  private void b(Item paramItem)
  {
    if (this.g > this.j)
    {
      int i2 = this.i.length;
      Item[] arrayOfItem1 = this.i;
      int i3 = 1 + i2 * 2;
      Item[] arrayOfItem2 = new Item[i3];
      this.j = ((int)(0.75D * i3));
      this.i = arrayOfItem2;
      int i4 = i2 - 1;
      if (i2 > 0)
      {
        Item localItem;
        for (Object localObject = arrayOfItem1[i4]; ; localObject = localItem)
        {
          if (localObject == null)
          {
            i2 = i4;
            break;
          }
          localItem = ((Item)localObject).k;
          int i5 = (0x7FFFFFFF & ((Item)localObject).j) % i3;
          ((Item)localObject).k = arrayOfItem2[i5];
          arrayOfItem2[i5] = localObject;
        }
      }
    }
    int i1 = (0x7FFFFFFF & paramItem.j) % this.i.length;
    paramItem.k = this.i[i1];
    this.i[i1] = paramItem;
  }

  private Item c(String paramString)
  {
    this.d.a(8, paramString, null, null);
    Item localItem = a(this.d);
    if (localItem == null)
    {
      this.h.put12(8, a(paramString).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.d);
      b(localItem);
    }
    return localItem;
  }

  Item a(Object paramObject)
  {
    if ((paramObject instanceof Integer))
      return a(((Integer)paramObject).intValue());
    if ((paramObject instanceof Float))
      return a(((Float)paramObject).floatValue());
    if ((paramObject instanceof Long))
      return a(((Long)paramObject).longValue());
    if ((paramObject instanceof Double))
      return a(((Double)paramObject).doubleValue());
    if ((paramObject instanceof String))
      return c((String)paramObject);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("value ");
    localStringBuffer.append(paramObject);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }

  Item a(String paramString)
  {
    this.c.a(1, paramString, null, null);
    Item localItem = a(this.c);
    if (localItem == null)
    {
      this.h.put1(1).putUTF(paramString);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.c);
      b(localItem);
    }
    return localItem;
  }

  Item a(String paramString1, String paramString2, String paramString3)
  {
    this.e.a(9, paramString1, paramString2, paramString3);
    Item localItem = a(this.e);
    if (localItem == null)
    {
      a(9, b(paramString1).a, a(paramString2, paramString3).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.e);
      b(localItem);
    }
    return localItem;
  }

  Item b(String paramString)
  {
    this.d.a(7, paramString, null, null);
    Item localItem = a(this.d);
    if (localItem == null)
    {
      this.h.put12(7, a(paramString).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.d);
      b(localItem);
    }
    return localItem;
  }

  Item b(String paramString1, String paramString2, String paramString3)
  {
    this.e.a(10, paramString1, paramString2, paramString3);
    Item localItem = a(this.e);
    if (localItem == null)
    {
      a(10, b(paramString1).a, a(paramString2, paramString3).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.e);
      b(localItem);
    }
    return localItem;
  }

  Item c(String paramString1, String paramString2, String paramString3)
  {
    this.e.a(11, paramString1, paramString2, paramString3);
    Item localItem = a(this.e);
    if (localItem == null)
    {
      a(11, b(paramString1).a, a(paramString2, paramString3).a);
      short s1 = this.g;
      this.g = ((short)(s1 + 1));
      localItem = new Item(s1, this.e);
      b(localItem);
    }
    return localItem;
  }

  public byte[] toByteArray()
  {
    int i1 = 24 + 2 * this.n;
    if (this.r != null)
      i1 += this.r.b;
    CodeWriter localCodeWriter1 = this.a;
    int i2 = 0;
    while (true)
    {
      if (localCodeWriter1 == null)
      {
        int i3 = i1 + this.h.b;
        int i4;
        if (this.p != null)
        {
          i3 += 8;
          i4 = 1;
        }
        else
        {
          i4 = 0;
        }
        if ((0x20000 & this.k) != 0)
        {
          i4++;
          i3 += 6;
        }
        if (this.u != null)
        {
          i4++;
          i3 += 8 + this.u.b;
        }
        int i5 = i4;
        ByteVector localByteVector = new ByteVector(i3);
        localByteVector.put4(-889275714).put2(3).put2(45);
        localByteVector.put2(this.g).putByteArray(this.h.a, 0, this.h.b);
        localByteVector.put2(this.k).put2(this.l).put2(this.m);
        localByteVector.put2(this.n);
        for (int i6 = 0; ; i6++)
        {
          if (i6 >= this.n)
          {
            localByteVector.put2(this.q);
            if (this.r != null)
              localByteVector.putByteArray(this.r.a, 0, this.r.b);
            localByteVector.put2(i2);
            for (CodeWriter localCodeWriter2 = this.a; ; localCodeWriter2 = localCodeWriter2.a)
            {
              if (localCodeWriter2 == null)
              {
                localByteVector.put2(i5);
                if (this.p != null)
                  localByteVector.put2(a("SourceFile").a).put4(2).put2(this.p.a);
                if ((0x20000 & this.k) != 0)
                  localByteVector.put2(a("Deprecated").a).put4(0);
                if (this.u != null)
                {
                  localByteVector.put2(a("InnerClasses").a);
                  localByteVector.put4(2 + this.u.b).put2(this.t);
                  localByteVector.putByteArray(this.u.a, 0, this.u.b);
                }
                return localByteVector.a;
              }
              localCodeWriter2.a(localByteVector);
            }
          }
          localByteVector.put2(this.o[i6]);
        }
      }
      i2++;
      i1 += localCodeWriter1.a();
      localCodeWriter1 = localCodeWriter1.a;
    }
  }

  public void visit(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    this.k = paramInt;
    this.l = b(paramString1).a;
    int i1 = 0;
    int i2;
    if (paramString2 == null)
      i2 = 0;
    else
      i2 = b(paramString2).a;
    this.m = i2;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.n = paramArrayOfString.length;
      this.o = new int[this.n];
      while (i1 < this.n)
      {
        this.o[i1] = b(paramArrayOfString[i1]).a;
        i1++;
      }
    }
    if (paramString3 != null)
    {
      a("SourceFile");
      this.p = a(paramString3);
    }
    if ((paramInt & 0x20000) != 0)
      a("Deprecated");
  }

  public void visitEnd()
  {
  }

  public void visitField(int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    int i1 = this.q;
    int i2 = 1;
    this.q = (i1 + i2);
    if (this.r == null)
      this.r = new ByteVector();
    this.r.put2(paramInt).put2(a(paramString1).a).put2(a(paramString2).a);
    if (paramObject == null)
      i2 = 0;
    int i3 = 0x10000 & paramInt;
    if (i3 != 0)
      i2++;
    int i4 = paramInt & 0x20000;
    if (i4 != 0)
      i2++;
    this.r.put2(i2);
    if (paramObject != null)
    {
      this.r.put2(a("ConstantValue").a);
      this.r.put4(2).put2(a(paramObject).a);
    }
    if (i3 != 0)
      this.r.put2(a("Synthetic").a).put4(0);
    if (i4 != 0)
      this.r.put2(a("Deprecated").a).put4(0);
  }

  public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.u == null)
    {
      a("InnerClasses");
      this.u = new ByteVector();
    }
    this.t = (1 + this.t);
    ByteVector localByteVector1 = this.u;
    int i1;
    if (paramString1 == null)
      i1 = 0;
    else
      i1 = b(paramString1).a;
    localByteVector1.put2(i1);
    ByteVector localByteVector2 = this.u;
    int i2;
    if (paramString2 == null)
      i2 = 0;
    else
      i2 = b(paramString2).a;
    localByteVector2.put2(i2);
    ByteVector localByteVector3 = this.u;
    int i3;
    if (paramString3 == null)
      i3 = 0;
    else
      i3 = a(paramString3).a;
    localByteVector3.put2(i3);
    this.u.put2(paramInt);
  }

  public CodeVisitor visitMethod(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    CodeWriter localCodeWriter = new CodeWriter(this, this.s);
    localCodeWriter.a(paramInt, paramString1, paramString2, paramArrayOfString);
    return localCodeWriter;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.ClassWriter
 * JD-Core Version:    0.6.2
 */