package com.android.cglib.dx.a.b;

import com.android.cglib.dx.d.r;

public enum y
  implements r
{
  private final int w;
  private final String x;
  private final String y;

  static
  {
    y[] arrayOfy = new y[22];
    arrayOfy[0] = a;
    arrayOfy[1] = b;
    arrayOfy[2] = c;
    arrayOfy[3] = d;
    arrayOfy[4] = e;
    arrayOfy[5] = f;
    arrayOfy[6] = g;
    arrayOfy[7] = h;
    arrayOfy[8] = i;
    arrayOfy[9] = j;
    arrayOfy[10] = k;
    arrayOfy[11] = l;
    arrayOfy[12] = m;
    arrayOfy[13] = n;
    arrayOfy[14] = o;
    arrayOfy[15] = p;
    arrayOfy[16] = q;
    arrayOfy[17] = r;
    arrayOfy[18] = s;
    arrayOfy[19] = t;
    arrayOfy[20] = u;
    arrayOfy[21] = v;
  }

  private y(int paramInt, String paramString)
  {
    this.w = paramInt;
    this.x = paramString;
    if (paramString.endsWith("_item"))
      paramString = paramString.substring(0, -5 + paramString.length());
    this.y = paramString.replace('_', ' ');
  }

  public String a_()
  {
    return this.y;
  }

  public int b()
  {
    return this.w;
  }

  public String c()
  {
    return this.x;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.y
 * JD-Core Version:    0.6.2
 */