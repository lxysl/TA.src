package com.b.a.b;

import android.graphics.Rect;
import com.a.a.a.a.a.a.a;
import com.androlua.LuaLexer;
import com.androlua.LuaTokenTypes;
import java.util.ArrayList;
import java.util.List;

public class k
{
  private static h b = j.g();
  private static ArrayList<Rect> e = new ArrayList();
  a a = null;
  private f c;
  private b d = null;

  public k(a parama)
  {
    this.a = parama;
  }

  public static h a()
  {
    try
    {
      h localh = b;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(h paramh)
  {
    try
    {
      b = paramh;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static ArrayList<Rect> d()
  {
    return e;
  }

  public void a(f paramf)
  {
    if (!a().f())
      return;
    b(new f(paramf));
    if (this.d == null)
    {
      this.d = new b(this);
      this.d.start();
      return;
    }
    this.d.a();
  }

  void a(List<m> paramList)
  {
    if (this.a != null)
      this.a.a(paramList);
    this.d = null;
  }

  public void b()
  {
    if (this.d != null)
    {
      this.d.b();
      this.d = null;
    }
  }

  public void b(f paramf)
  {
    try
    {
      this.c = paramf;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public f c()
  {
    try
    {
      f localf = this.c;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract interface a
  {
    public abstract void a(List<m> paramList);
  }

  private class b extends Thread
  {
    private final k b;
    private final g c;
    private boolean d = false;
    private int e = 16;
    private ArrayList<m> f;

    public b(k arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new g();
    }

    private void d()
    {
      b localb = this;
      f localf = localb.a.c();
      int i = localf.f();
      ArrayList localArrayList1 = new ArrayList(8196);
      ArrayList localArrayList2 = new ArrayList(8196);
      ArrayList localArrayList3 = new ArrayList(8196);
      ArrayList localArrayList4 = new ArrayList(8196);
      LuaLexer localLuaLexer = new LuaLexer(localf);
      h localh = k.a();
      localh.e();
      while (true)
      {
        Object localObject2;
        int i2;
        try
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          Object localObject1 = "";
          StringBuilder localStringBuilder2 = localStringBuilder1;
          j = 0;
          localObject2 = null;
          Object localObject3 = null;
          int k = 1;
          Object localObject4 = null;
          int m = -1;
          if (!localb.c.c())
          {
            LuaTokenTypes localLuaTokenTypes1 = localLuaLexer.advance();
            if (localLuaTokenTypes1 != null)
            {
              int n = localLuaLexer.yylength();
              if ((j != 0) && (localObject2 == LuaTokenTypes.STRING) && (localLuaTokenTypes1 != LuaTokenTypes.STRING))
              {
                String str2 = localStringBuilder2.toString();
                if (localStringBuilder2.length() > 2)
                  localh.c(str2.substring(1, str2.length() - 1));
                localStringBuilder2 = new StringBuilder();
                j = 0;
              }
              int i1 = k.1.a[localLuaTokenTypes1.ordinal()];
              i2 = j;
              m localm3;
              m localm2;
              m localm1;
              switch (i1)
              {
              default:
                i3 = i;
                localObject5 = localObject2;
                break;
              case 44:
                localm3 = new m(n, 4);
                localArrayList1.add(localm3);
                i3 = i;
                localObject5 = localObject2;
                break;
              case 41:
              case 42:
              case 43:
                localm2 = new m(n, 30);
                break;
              case 40:
                if (i > 9999)
                {
                  localm3 = new m(n, 0);
                  continue;
                }
                if (localObject3 == LuaTokenTypes.NUMBER)
                {
                  m localm5 = (m)localArrayList1.get(localArrayList1.size() - 1);
                  localm5.b(0);
                  localm5.a(n + localm5.a());
                }
                String str1 = localLuaLexer.yytext();
                if (localObject2 == LuaTokenTypes.FUNCTION)
                {
                  localArrayList1.add(new m(n, 4));
                  localh.c(str1);
                }
                else
                {
                  m localm4;
                  if (localh.g(str1))
                  {
                    localm4 = new m(n, 4);
                    localArrayList1.add(localm4);
                  }
                  else
                  {
                    if ((localObject2 != LuaTokenTypes.GOTO) && (localObject2 != LuaTokenTypes.AT))
                    {
                      if (localObject2 == LuaTokenTypes.MULT)
                      {
                        LuaTokenTypes localLuaTokenTypes3 = LuaTokenTypes.LOCAL;
                        if (localObject4 == localLuaTokenTypes3)
                        {
                          localm4 = new m(n, 2);
                          continue;
                        }
                      }
                      if (localh.f(str1))
                      {
                        localm4 = new m(n, 3);
                        continue;
                      }
                      if ((localObject2 == LuaTokenTypes.DOT) && (localh.f((String)localObject1)) && (localh.a((String)localObject1, str1)))
                      {
                        localm4 = new m(n, 3);
                        continue;
                      }
                      if (localh.e(str1))
                      {
                        localm4 = new m(n, 3);
                        continue;
                      }
                      localm4 = new m(n, 0);
                      continue;
                    }
                    localm4 = new m(n, 4);
                    continue;
                  }
                }
                if ((localObject2 == LuaTokenTypes.ASSIGN) && (str1.equals("require")))
                {
                  localh.c((String)localObject1);
                  if (m >= 0)
                    ((m)localArrayList1.get(m - 1)).b(4);
                }
                int i9 = localArrayList1.size();
                localObject1 = str1;
                i3 = i;
                m = i9;
                localObject5 = localObject2;
                j = i2;
                break;
              case 38:
              case 39:
                localArrayList1.add(new m(n, 50));
                if (i > 9999)
                  break label1530;
                if (((String)localObject1).equals("require"))
                  i2 = 1;
                if (i2 == 0)
                  break label1530;
                localStringBuilder2.append(localLuaLexer.yytext());
                break;
              case 32:
              case 33:
              case 34:
              case 35:
              case 36:
              case 37:
                localm2 = new m(n, 2);
                localArrayList1.add(localm2);
                break;
              case 31:
                int i8 = localArrayList4.size();
                if (i8 > 0)
                {
                  Rect localRect2 = (Rect)localArrayList4.remove(i8 - 1);
                  localRect2.bottom = localLuaLexer.yyline();
                  localRect2.right = localLuaLexer.yychar();
                  if (localRect2.bottom - localRect2.top > 1)
                    localArrayList2.add(localRect2);
                }
                localm2 = new m(n, 2);
                break;
              case 30:
                int i5 = localLuaLexer.yychar();
                int i6 = localLuaLexer.yyline();
                i3 = i;
                int i7 = localLuaLexer.yyline();
                localObject5 = localObject2;
                localArrayList4.add(new Rect(i5, i6, 0, i7));
                localArrayList1.add(new m(n, 2));
                break;
              case 20:
                i3 = i;
                localObject5 = localObject2;
                int i4 = localArrayList3.size();
                if (i4 > 0)
                {
                  Rect localRect1 = (Rect)localArrayList3.remove(i4 - 1);
                  localRect1.bottom = localLuaLexer.yyline();
                  localRect1.right = localLuaLexer.yychar();
                  if (localRect1.bottom - localRect1.top > 1)
                    localArrayList2.add(localRect1);
                }
                localm1 = new m(n, 1);
                break;
              case 12:
              case 13:
                i3 = i;
                localObject5 = localObject2;
                localArrayList3.add(new Rect(localLuaLexer.yychar(), localLuaLexer.yyline(), 0, localLuaLexer.yyline()));
                localArrayList1.add(new m(n, 1));
                j = i2;
                k = 0;
                break;
              case 4:
              case 8:
              case 22:
                i3 = i;
                localObject5 = localObject2;
                localArrayList3.add(new Rect(localLuaLexer.yychar(), localLuaLexer.yyline(), 0, localLuaLexer.yyline()));
                localArrayList1.add(new m(n, 1));
                break;
              case 3:
                i3 = i;
                localObject5 = localObject2;
                if (k != 0)
                  localArrayList3.add(new Rect(localLuaLexer.yychar(), localLuaLexer.yyline(), 0, localLuaLexer.yyline()));
                localm1 = new m(n, 1);
                localArrayList1.add(localm1);
                j = i2;
                k = 1;
                break;
              case 1:
              case 2:
              case 5:
              case 6:
              case 7:
              case 9:
              case 10:
              case 11:
              case 14:
              case 15:
              case 16:
              case 17:
              case 18:
              case 19:
              case 21:
              case 23:
              case 24:
              case 25:
              case 26:
              case 27:
              case 28:
              case 29:
              }
              i3 = i;
              localObject5 = localObject2;
              localArrayList1.add(new m(n, 1));
              break label1544;
              localArrayList1.add(new m(n, 0));
              j = i2;
              LuaTokenTypes localLuaTokenTypes2 = LuaTokenTypes.WHITE_SPACE;
              if (localLuaTokenTypes1 != localLuaTokenTypes2)
                localObject2 = localLuaTokenTypes1;
              else
                localObject2 = localObject5;
              localObject3 = localLuaTokenTypes1;
              i = i3;
              localObject4 = localObject5;
              localb = this;
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          a.a(localException);
          q.a(localException.getMessage());
          if (localArrayList1.isEmpty())
            localArrayList1.add(new m(0, 0));
          localh.a();
          k.a(localArrayList2);
          this.f = localArrayList1;
          return;
        }
        break label1544;
        label1530: int i3 = i;
        Object localObject5 = localObject2;
        int j = i2;
        continue;
        label1544: j = i2;
      }
    }

    public void a()
    {
      this.d = true;
      this.c.a();
    }

    public void b()
    {
      this.c.a();
    }

    public void c()
    {
      f localf = k.this.c();
      h localh = k.a();
      ArrayList localArrayList = new ArrayList();
      if (!localh.f())
      {
        localArrayList.add(new m(0, 0));
        this.f = localArrayList;
        return;
      }
      char[] arrayOfChar = new char[127];
      localf.f(0);
      int i = -1;
      char c1 = '\000';
      int j = 0;
      label851: label855: for (int k = 0; (localf.a()) && (!this.c.c()); k++)
      {
        char c2 = localf.b();
        switch (i)
        {
        default:
          q.a("Invalid state in TokenScanner");
          break;
        case 51:
          if (((!localh.g(c2)) && (c2 != '\n')) || (localh.d(c1)))
            if ((!localh.d(c2)) || (!localh.d(c1)))
              break label851;
          break;
        case 50:
          if (((!localh.f(c2)) && (c2 != '\n')) || (localh.d(c1)))
          {
            if ((!localh.d(c2)) || (!localh.d(c1)))
              break label851;
            c1 = ' ';
          }
          break;
        case 40:
          if (!localh.c(c1, c2))
            break label851;
        case 20:
        case 21:
        case 30:
          while (true)
          {
            c1 = c2;
            i = -1;
            break label855;
            if (localh.b(c1, c2))
            {
              c1 = c2;
              i = 40;
              break label855;
            }
            if (c2 != '\n')
              break;
          }
        case -1:
        case 0:
        case 1:
        case 3:
        case 10:
        }
        int n;
        int m;
        if (localh.a(c1, c2))
        {
          n = 1;
          m = 30;
        }
        else if (localh.b(c1, c2))
        {
          n = 1;
          m = 40;
        }
        else if (localh.f(c2))
        {
          n = 1;
          m = 50;
        }
        else if (localh.g(c2))
        {
          n = 1;
          m = 51;
        }
        else if (localh.h(c2))
        {
          n = 1;
          m = 20;
        }
        else if (localh.i(c2))
        {
          n = 1;
          m = 21;
        }
        else
        {
          m = i;
          n = 0;
        }
        if (n != 0)
        {
          int i2;
          if ((m != 30) && (m != 40))
          {
            i2 = k;
          }
          else
          {
            i2 = k - 1;
            if (((m)localArrayList.get(localArrayList.size() - 1)).a() == i2)
              localArrayList.remove(localArrayList.size() - 1);
          }
          if ((j > 0) && (i != 0))
            localArrayList.add(new m(k - j, 0));
          localArrayList.add(new m(i2, m));
          c1 = c2;
          i = m;
          j = 0;
        }
        else
        {
          if ((!localh.b(c2)) && (!localh.a(c2)))
          {
            if (j < 127)
            {
              arrayOfChar[j] = c2;
              j++;
            }
          }
          else
          {
            if (j > 0)
            {
              if (localh.e(arrayOfChar[0]))
              {
                localArrayList.add(new m(k - j, 10));
                i = 10;
              }
              else if (localh.d(new String(arrayOfChar, 0, j)))
              {
                localArrayList.add(new m(k - j, 1));
                i = 1;
              }
              else if (localh.e(new String(arrayOfChar, 0, j)))
              {
                int i1 = k - j;
                i = 3;
                localArrayList.add(new m(i1, i));
              }
              else if (i != 0)
              {
                localArrayList.add(new m(k - j, 0));
                i = 0;
              }
              j = 0;
            }
            if ((i != 0) && (localh.a(c2)))
            {
              localArrayList.add(new m(k, 0));
              c1 = c2;
              i = 0;
              continue;
            }
          }
          c1 = c2;
        }
      }
      if (localArrayList.isEmpty())
        localArrayList.add(new m(0, 0));
      this.f = localArrayList;
    }

    public void run()
    {
      do
      {
        this.d = false;
        this.c.b();
        if ((k.a() instanceof i))
          d();
        else
          c();
      }
      while (this.d);
      if (!this.c.c())
        this.b.a(this.f);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.k
 * JD-Core Version:    0.6.2
 */