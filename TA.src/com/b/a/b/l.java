package com.b.a.b;

public class l
{
  private int a = 0;

  public int a(f paramf, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.length() == 0)
      return -1;
    if (paramInt1 < 0)
    {
      q.a("TextBuffer.find: Invalid start position");
      paramInt1 = 0;
    }
    if (paramInt2 > paramf.g())
    {
      q.a("TextBuffer.find: Invalid end position");
      paramInt2 = paramf.g();
    }
    int i = Math.min(paramInt2, 1 + (paramf.g() - paramString.length()));
    while ((paramInt1 < i) && ((!a(paramf, paramString, paramInt1, paramBoolean1)) || ((paramBoolean2) && (!a(paramf, paramInt1, paramString.length())))))
    {
      paramInt1++;
      this.a = (1 + this.a);
    }
    if (paramInt1 < i)
      return paramInt1;
    return -1;
  }

  protected boolean a(f paramf, int paramInt1, int paramInt2)
  {
    h localh = k.a();
    boolean bool1;
    if (paramInt1 == 0)
      bool1 = true;
    else
      bool1 = localh.b(paramf.charAt(paramInt1 - 1));
    int i = paramInt1 + paramInt2;
    boolean bool2;
    if (i == paramf.g())
      bool2 = true;
    else
      bool2 = localh.b(paramf.charAt(i));
    return (bool1) && (bool2);
  }

  protected boolean a(f paramf, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramf.g() - paramInt < paramString.length())
      return false;
    for (int i = 0; i < paramString.length(); i++)
    {
      if ((paramBoolean) && (paramString.charAt(i) != paramf.charAt(i + paramInt)))
        return false;
      if ((!paramBoolean) && (Character.toLowerCase(paramString.charAt(i)) != Character.toLowerCase(paramf.charAt(i + paramInt))))
        return false;
    }
    return true;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.l
 * JD-Core Version:    0.6.2
 */