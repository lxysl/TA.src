package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public final class al
{
  private final HashMap<String, a> a = new HashMap(50);

  public void a(ak paramak)
  {
    Iterator localIterator = paramak.a().iterator();
    while (localIterator.hasNext())
      a((x)localIterator.next());
  }

  public void a(x paramx)
  {
    String str = paramx.i();
    a locala = (a)this.a.get(str);
    if (locala == null)
    {
      this.a.put(str, new a(paramx, str));
      return;
    }
    locala.a(paramx);
  }

  public final void a(a parama)
  {
    if (this.a.size() == 0)
      return;
    parama.a(0, "\nstatistics:\n");
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator1 = this.a.values().iterator();
    while (localIterator1.hasNext())
    {
      a locala = (a)localIterator1.next();
      localTreeMap.put(a.a(locala), locala);
    }
    Iterator localIterator2 = localTreeMap.values().iterator();
    while (localIterator2.hasNext())
      ((a)localIterator2.next()).a(parama);
  }

  private static class a
  {
    private final String a;
    private int b;
    private int c;
    private int d;
    private int e;

    public a(x paramx, String paramString)
    {
      int i = paramx.b_();
      this.a = paramString;
      this.b = 1;
      this.c = i;
      this.d = i;
      this.e = i;
    }

    public String a()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("  ");
      localStringBuilder2.append(this.a);
      localStringBuilder2.append(": ");
      localStringBuilder2.append(this.b);
      localStringBuilder2.append(" item");
      String str1;
      if (this.b == 1)
        str1 = "";
      else
        str1 = "s";
      localStringBuilder2.append(str1);
      localStringBuilder2.append("; ");
      localStringBuilder2.append(this.c);
      localStringBuilder2.append(" bytes total\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      StringBuilder localStringBuilder3;
      if (this.e == this.d)
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("    ");
        localStringBuilder3.append(this.e);
        localStringBuilder3.append(" bytes/item\n");
      }
      StringBuilder localStringBuilder4;
      for (String str2 = localStringBuilder3.toString(); ; str2 = localStringBuilder4.toString())
      {
        localStringBuilder1.append(str2);
        break;
        int i = this.c / this.b;
        localStringBuilder4 = new StringBuilder();
        localStringBuilder4.append("    ");
        localStringBuilder4.append(this.e);
        localStringBuilder4.append("..");
        localStringBuilder4.append(this.d);
        localStringBuilder4.append(" bytes/item; average ");
        localStringBuilder4.append(i);
        localStringBuilder4.append("\n");
      }
      return localStringBuilder1.toString();
    }

    public void a(x paramx)
    {
      int i = paramx.b_();
      this.b = (1 + this.b);
      this.c = (i + this.c);
      if (i > this.d)
        this.d = i;
      if (i < this.e)
        this.e = i;
    }

    public void a(a parama)
    {
      parama.a(a());
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.al
 * JD-Core Version:    0.6.2
 */