package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class z extends ag
{
  private final y a;
  private final ak b;
  private final x c;
  private final x d;
  private final int e;

  private z(ak paramak)
  {
    super(4, 12);
    if (paramak == null)
      throw new NullPointerException("section == null");
    this.a = y.h;
    this.b = paramak;
    this.c = null;
    this.d = null;
    this.e = 1;
  }

  private z(y paramy, ak paramak, x paramx1, x paramx2, int paramInt)
  {
    super(4, 12);
    if (paramy == null)
      throw new NullPointerException("type == null");
    if (paramak == null)
      throw new NullPointerException("section == null");
    if (paramx1 == null)
      throw new NullPointerException("firstItem == null");
    if (paramx2 == null)
      throw new NullPointerException("lastItem == null");
    if (paramInt <= 0)
      throw new IllegalArgumentException("itemCount <= 0");
    this.a = paramy;
    this.b = paramak;
    this.c = paramx1;
    this.d = paramx2;
    this.e = paramInt;
  }

  public static void a(ak[] paramArrayOfak, af paramaf)
  {
    if (paramArrayOfak == null)
      throw new NullPointerException("sections == null");
    if (paramaf.a().size() != 0)
      throw new IllegalArgumentException("mapSection.items().size() != 0");
    ArrayList localArrayList = new ArrayList(50);
    int i = paramArrayOfak.length;
    for (int j = 0; j < i; j++)
    {
      ak localak = paramArrayOfak[j];
      Iterator localIterator = localak.a().iterator();
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      int k = 0;
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        y localy = localx.a();
        if (localy != localObject1)
        {
          if (k != 0)
          {
            z localz2 = new z((y)localObject1, localak, (x)localObject2, (x)localObject3, k);
            localArrayList.add(localz2);
          }
          localObject2 = localx;
          localObject1 = localy;
          k = 0;
        }
        k++;
        localObject3 = localx;
      }
      if (k != 0);
      for (z localz1 = new z((y)localObject1, localak, (x)localObject2, (x)localObject3, k); ; localz1 = new z(paramaf))
      {
        localArrayList.add(localz1);
        break;
        if (localak != paramaf)
          break;
      }
    }
    paramaf.a(new at(y.h, localArrayList));
  }

  public y a()
  {
    return y.s;
  }

  public void a(l paraml)
  {
  }

  protected void a_(l paraml, a parama)
  {
    int i = this.a.b();
    int j;
    if (this.c == null)
      j = this.b.g();
    else
      j = this.b.a(this.c);
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(g());
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.a.c());
      localStringBuilder1.append(" map");
      parama.a(0, localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  type:   ");
      localStringBuilder2.append(i.c(i));
      localStringBuilder2.append(" // ");
      localStringBuilder2.append(this.a.toString());
      parama.a(2, localStringBuilder2.toString());
      parama.a(2, "  unused: 0");
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("  size:   ");
      localStringBuilder3.append(i.a(this.e));
      parama.a(4, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("  offset: ");
      localStringBuilder4.append(i.a(j));
      parama.a(4, localStringBuilder4.toString());
    }
    parama.c(i);
    parama.c(0);
    parama.d(this.e);
    parama.d(j);
  }

  public final String b()
  {
    return toString();
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(this.b.toString());
    localStringBuffer.append(' ');
    localStringBuffer.append(this.a.a_());
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.z
 * JD-Core Version:    0.6.2
 */