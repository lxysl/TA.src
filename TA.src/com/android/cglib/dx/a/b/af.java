package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class af extends ak
{
  private static final Comparator<ag> a = new Comparator()
  {
    public int a(ag paramAnonymousag1, ag paramAnonymousag2)
    {
      return paramAnonymousag1.a().compareTo(paramAnonymousag2.a());
    }
  };
  private final ArrayList<ag> b = new ArrayList(100);
  private final HashMap<ag, ag> c = new HashMap(100);
  private final a d;
  private int e;

  public af(String paramString, l paraml, int paramInt, a parama)
  {
    super(paramString, paraml, paramInt);
    this.d = parama;
    this.e = -1;
  }

  public int a(x paramx)
  {
    return ((ag)paramx).e();
  }

  public Collection<? extends x> a()
  {
    return this.b;
  }

  // ERROR //
  public void a(ag paramag)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 59	com/android/cglib/dx/a/b/af:j	()V
    //   4: aload_1
    //   5: invokevirtual 62	com/android/cglib/dx/a/b/ag:f	()I
    //   8: aload_0
    //   9: invokevirtual 63	com/android/cglib/dx/a/b/af:f	()I
    //   12: if_icmple +13 -> 25
    //   15: new 65	java/lang/IllegalArgumentException
    //   18: dup
    //   19: ldc 67
    //   21: invokespecial 70	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: aload_0
    //   26: getfield 37	com/android/cglib/dx/a/b/af:b	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 74	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: return
    //   35: new 56	java/lang/NullPointerException
    //   38: dup
    //   39: ldc 76
    //   41: invokespecial 77	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   4	25	35	java/lang/NullPointerException
  }

  public void a(a parama, y paramy, String paramString)
  {
    i();
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      ag localag2 = (ag)localIterator1.next();
      if (localag2.a() == paramy)
        localTreeMap.put(localag2.b(), localag2);
    }
    if (localTreeMap.size() == 0)
      return;
    parama.a(0, paramString);
    Iterator localIterator2 = localTreeMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      String str = (String)localEntry.getKey();
      ag localag1 = (ag)localEntry.getValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localag1.g());
      localStringBuilder.append(' ');
      localStringBuilder.append(str);
      localStringBuilder.append('\n');
      parama.a(0, localStringBuilder.toString());
    }
  }

  protected void a_(a parama)
  {
    boolean bool = parama.a();
    l locall = e();
    Iterator localIterator = this.b.iterator();
    int i = 0;
    int j = 1;
    while (localIterator.hasNext())
    {
      ag localag = (ag)localIterator.next();
      if (bool)
        if (j != 0)
          j = 0;
        else
          parama.a(0, "\n");
      int k = localag.f() - 1;
      int m = i + k & (k ^ 0xFFFFFFFF);
      if (i != m)
      {
        parama.g(m - i);
        i = m;
      }
      localag.a(locall, parama);
      i += localag.b_();
    }
    if (i != this.e)
      throw new RuntimeException("output size mismatch");
  }

  public <T extends ag> T b(T paramT)
  {
    j();
    ag localag = (ag)this.c.get(paramT);
    if (localag != null)
      return localag;
    a(paramT);
    this.c.put(paramT, paramT);
    return paramT;
  }

  protected void c()
  {
    l locall = e();
    int i = 0;
    while (true)
    {
      int j = this.b.size();
      if (i >= j)
        return;
      while (i < j)
      {
        ((ag)this.b.get(i)).a(locall);
        i++;
      }
    }
  }

  public int c_()
  {
    i();
    return this.e;
  }

  public void d()
  {
    i();
    switch (2.a[this.d.ordinal()])
    {
    default:
      break;
    case 2:
      Collections.sort(this.b, a);
      break;
    case 1:
      Collections.sort(this.b);
    }
    int i = this.b.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      ag localag = (ag)this.b.get(j);
      try
      {
        int m = localag.b(this, k);
        if (m < k)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("bogus place() result for ");
          localStringBuilder2.append(localag);
          throw new RuntimeException(localStringBuilder2.toString());
        }
        int n = localag.b_();
        k = n + m;
        j++;
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("...while placing ");
        localStringBuilder1.append(localag);
        throw g.a(localRuntimeException, localStringBuilder1.toString());
      }
    }
    this.e = k;
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.af
 * JD-Core Version:    0.6.2
 */