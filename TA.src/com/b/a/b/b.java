package com.b.a.b;

import java.util.HashMap;

public abstract class b
{
  protected HashMap<a, Integer> a = a();

  private HashMap<a, Integer> a()
  {
    HashMap localHashMap = new HashMap(a.values().length);
    localHashMap.put(a.a, Integer.valueOf(-16777216));
    localHashMap.put(a.b, Integer.valueOf(-32));
    localHashMap.put(a.c, Integer.valueOf(-32));
    localHashMap.put(a.d, Integer.valueOf(-6832092));
    localHashMap.put(a.e, Integer.valueOf(-32));
    localHashMap.put(a.f, Integer.valueOf(-12537601));
    localHashMap.put(a.g, Integer.valueOf(-8355712));
    localHashMap.put(a.h, Integer.valueOf(545818760));
    localHashMap.put(a.i, Integer.valueOf(-5592406));
    localHashMap.put(a.j, Integer.valueOf(-12615841));
    localHashMap.put(a.k, Integer.valueOf(-3129123));
    localHashMap.put(a.l, Integer.valueOf(-14008065));
    localHashMap.put(a.m, Integer.valueOf(-10452737));
    localHashMap.put(a.n, Integer.valueOf(-2276216));
    localHashMap.put(a.o, Integer.valueOf(-8355712));
    return localHashMap;
  }

  public int a(int paramInt)
  {
    a locala;
    if (paramInt != 10)
    {
      if ((paramInt != 30) && (paramInt != 40));
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
          switch (paramInt)
          {
          default:
            q.a("Invalid token type");
          case 50:
          case 51:
          }
          break;
        case 21:
        case 20:
        }
      case 0:
        locala = a.a;
        break;
        locala = a.n;
        break;
      case 4:
        locala = a.m;
        break;
      case 3:
        locala = a.l;
        break;
      case 1:
        locala = a.k;
        break;
        locala = a.j;
        break;
      case 2:
      }
    }
    else
    {
      locala = a.o;
    }
    return a(locala);
  }

  public int a(a parama)
  {
    Integer localInteger = (Integer)this.a.get(parama);
    if (localInteger == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Color not specified for ");
      localStringBuilder.append(parama);
      q.a(localStringBuilder.toString());
      return 0;
    }
    return localInteger.intValue();
  }

  public void a(a parama, int paramInt)
  {
    this.a.put(parama, Integer.valueOf(paramInt));
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[15];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      arrayOfa[12] = m;
      arrayOfa[13] = n;
      arrayOfa[14] = o;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.b
 * JD-Core Version:    0.6.2
 */