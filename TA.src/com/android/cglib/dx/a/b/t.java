package com.android.cglib.dx.a.b;

import com.android.cglib.dx.a.b;
import com.android.cglib.dx.c.c.v;
import com.android.cglib.dx.d.a;
import com.android.cglib.dx.d.i;

public final class t extends w
{
  public y a()
  {
    return y.a;
  }

  public void a(l paraml)
  {
  }

  public void a(l paraml, a parama)
  {
    int i = paraml.f().g();
    ak localak1 = paraml.o();
    ak localak2 = paraml.p();
    int j = localak1.g();
    int k = localak2.g() + localak2.c_() - j;
    String str = paraml.a().a();
    if (parama.a())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("magic: ");
      localStringBuilder1.append(new v(str).f());
      parama.a(8, localStringBuilder1.toString());
      parama.a(4, "checksum");
      parama.a(20, "signature");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("file_size:       ");
      localStringBuilder2.append(i.a(paraml.b()));
      parama.a(4, localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("header_size:     ");
      localStringBuilder3.append(i.a(112));
      parama.a(4, localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("endian_tag:      ");
      localStringBuilder4.append(i.a(305419896));
      parama.a(4, localStringBuilder4.toString());
      parama.a(4, "link_size:       0");
      parama.a(4, "link_off:        0");
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("map_off:         ");
      localStringBuilder5.append(i.a(i));
      parama.a(4, localStringBuilder5.toString());
    }
    for (int m = 0; m < 8; m++)
      parama.b(str.charAt(m));
    parama.g(24);
    parama.d(paraml.b());
    parama.d(112);
    parama.d(305419896);
    parama.g(8);
    parama.d(i);
    paraml.g().b(parama);
    paraml.j().b(parama);
    paraml.k().b(parama);
    paraml.l().a(parama);
    paraml.m().a(parama);
    paraml.h().a(parama);
    if (parama.a())
    {
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("data_size:       ");
      localStringBuilder6.append(i.a(k));
      parama.a(4, localStringBuilder6.toString());
      StringBuilder localStringBuilder7 = new StringBuilder();
      localStringBuilder7.append("data_off:        ");
      localStringBuilder7.append(i.a(j));
      parama.a(4, localStringBuilder7.toString());
    }
    parama.d(k);
    parama.d(j);
  }

  public int b_()
  {
    return 112;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a.b.t
 * JD-Core Version:    0.6.2
 */