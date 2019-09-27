package bsh.org.objectweb.asm;

final class Item
{
  short a;
  int b;
  int c;
  long d;
  float e;
  double f;
  String g;
  String h;
  String i;
  int j;
  Item k;

  Item()
  {
  }

  Item(short paramShort, Item paramItem)
  {
    this.a = paramShort;
    this.b = paramItem.b;
    this.c = paramItem.c;
    this.d = paramItem.d;
    this.e = paramItem.e;
    this.f = paramItem.f;
    this.g = paramItem.g;
    this.h = paramItem.h;
    this.i = paramItem.i;
    this.j = paramItem.j;
  }

  void a(double paramDouble)
  {
    this.b = 6;
    this.f = paramDouble;
    this.j = (this.b + (int)paramDouble);
  }

  void a(float paramFloat)
  {
    this.b = 4;
    this.e = paramFloat;
    this.j = (this.b + (int)paramFloat);
  }

  void a(int paramInt)
  {
    this.b = 3;
    this.c = paramInt;
    this.j = (paramInt + this.b);
  }

  void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramInt;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    int n;
    int i1;
    if (paramInt != 1)
      if (paramInt != 12)
        switch (paramInt)
        {
        default:
          n = paramString1.hashCode() * paramString2.hashCode();
          i1 = paramString3.hashCode();
        case 7:
        case 8:
        }
    for (int m = n * i1; ; m = paramString1.hashCode())
    {
      this.j = (paramInt + m);
      return;
      n = paramString1.hashCode();
      i1 = paramString2.hashCode();
      break;
    }
  }

  void a(long paramLong)
  {
    this.b = 5;
    this.d = paramLong;
    this.j = (this.b + (int)paramLong);
  }

  boolean a(Item paramItem)
  {
    if (paramItem.b == this.b)
    {
      int m = this.b;
      if (m != 1)
      {
        if (m != 12);
        switch (m)
        {
        default:
          return (paramItem.g.equals(this.g)) && (paramItem.h.equals(this.h)) && (paramItem.i.equals(this.i));
        case 6:
          return paramItem.f == this.f;
        case 5:
          return paramItem.d == this.d;
        case 4:
          return paramItem.e == this.e;
        case 3:
          if (paramItem.c == this.c)
            return true;
          return false;
          return (paramItem.g.equals(this.g)) && (paramItem.h.equals(this.h));
        case 7:
        case 8:
        }
      }
      return paramItem.g.equals(this.g);
    }
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.Item
 * JD-Core Version:    0.6.2
 */