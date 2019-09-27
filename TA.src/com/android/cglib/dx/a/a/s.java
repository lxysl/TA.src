package com.android.cglib.dx.a.a;

import com.android.cglib.dx.a.b;
import java.util.ArrayList;

public final class s
{
  private final t a;
  private ArrayList<h> b;

  public s(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new t(paramb, paramInt1, paramInt3);
    this.b = new ArrayList(paramInt2);
  }

  private void b()
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      this.a.a((h)this.b.get(j));
    this.b = null;
  }

  public t a()
  {
    if (this.b == null)
      throw new UnsupportedOperationException("already processed");
    b();
    return this.a;
  }

  public void a(int paramInt, e parame)
  {
    this.a.a(paramInt, parame);
  }

  public void a(h paramh)
  {
    this.a.a(paramh);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.a.s
 * JD-Core Version:    0.6.2
 */