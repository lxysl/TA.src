package com.baidu.mobstat;

import java.util.Comparator;

class h
  implements Comparator<i>
{
  h(g paramg)
  {
  }

  public int a(i parami1, i parami2)
  {
    int i = parami2.b - parami1.b;
    if (i == 0)
    {
      if ((parami1.d) && (parami2.d))
        return 0;
      if (parami1.d)
        return -1;
      if (parami2.d)
        return 1;
    }
    return i;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.h
 * JD-Core Version:    0.6.2
 */