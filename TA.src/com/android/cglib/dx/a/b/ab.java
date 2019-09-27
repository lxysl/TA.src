package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.f;
import java.util.Collection;
import java.util.Iterator;

public abstract class ab extends as
{
  public ab(String paramString, l paraml)
  {
    super(paramString, paraml, 4);
  }

  protected void b()
  {
    if (a().size() > 65536)
    {
      String str;
      if ((this instanceof ae))
        str = "methods";
      else
        str = "fields";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Too many ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(a().size());
      localStringBuilder.append("; max is ");
      localStringBuilder.append(65536);
      throw new f(localStringBuilder.toString());
    }
    Iterator localIterator = a().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      ((aa)localIterator.next()).a(i);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.ab
 * JD-Core Version:    0.6.2
 */