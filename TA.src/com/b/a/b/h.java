package com.b.a.b;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class h
{
  private static final char[] f = { 40, 41, 123, 125, 46, 44, 59, 61, 43, 45, 47, 42, 38, 33, 124, 58, 91, 93, 60, 62, 63, 126, 37, 94 };
  protected HashMap<String, Integer> a = new HashMap(0);
  protected HashMap<String, Integer> b = new HashMap(0);
  protected HashMap<String, String[]> c = new HashMap(0);
  protected HashMap<String, Integer> d = new HashMap(0);
  protected HashMap<Character, Integer> e = b(f);
  private ArrayList<String> g = new ArrayList();
  private String[] h = new String[0];
  private String[] i;
  private String[] j;

  private HashMap<Character, Integer> b(char[] paramArrayOfChar)
  {
    HashMap localHashMap = new HashMap(paramArrayOfChar.length);
    for (int k = 0; k < paramArrayOfChar.length; k++)
      localHashMap.put(Character.valueOf(paramArrayOfChar[k]), Integer.valueOf(2));
    return localHashMap;
  }

  public void a()
  {
    String[] arrayOfString = new String[this.g.size()];
    this.h = ((String[])this.g.toArray(arrayOfString));
  }

  public void a(String paramString, String[] paramArrayOfString)
  {
    this.c.put(paramString, paramArrayOfString);
  }

  protected void a(char[] paramArrayOfChar)
  {
    this.e = b(paramArrayOfChar);
  }

  public void a(String[] paramArrayOfString)
  {
    this.i = paramArrayOfString;
    this.a = new HashMap(paramArrayOfString.length);
    for (int k = 0; k < paramArrayOfString.length; k++)
      this.a.put(paramArrayOfString[k], Integer.valueOf(1));
  }

  public final boolean a(char paramChar)
  {
    return this.e.containsKey(Character.valueOf(paramChar));
  }

  public boolean a(char paramChar1, char paramChar2)
  {
    return (paramChar1 == '/') && (paramChar2 == '/');
  }

  public final boolean a(String paramString1, String paramString2)
  {
    String[] arrayOfString = (String[])this.c.get(paramString1);
    int k = arrayOfString.length;
    for (int m = 0; m < k; m++)
      if (arrayOfString[m].equals(paramString2))
        return true;
    return false;
  }

  public String[] a(String paramString)
  {
    return (String[])this.c.get(paramString);
  }

  public void b(String paramString)
  {
    this.c.remove(paramString);
  }

  public void b(String[] paramArrayOfString)
  {
    this.j = paramArrayOfString;
    ArrayList localArrayList = new ArrayList();
    this.b = new HashMap(paramArrayOfString.length);
    for (int k = 0; k < paramArrayOfString.length; k++)
    {
      if (!localArrayList.contains(paramArrayOfString[k]))
        localArrayList.add(paramArrayOfString[k]);
      this.b.put(paramArrayOfString[k], Integer.valueOf(3));
    }
    this.j = new String[localArrayList.size()];
    localArrayList.toArray(this.j);
  }

  public boolean b(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\n') || (paramChar == '\t') || (paramChar == '\r') || (paramChar == '\f') || (paramChar == 65535);
  }

  public boolean b(char paramChar1, char paramChar2)
  {
    return (paramChar1 == '/') && (paramChar2 == '*');
  }

  public String[] b()
  {
    return this.h;
  }

  public void c(String paramString)
  {
    if ((!this.g.contains(paramString)) && (!this.b.containsKey(paramString)))
      this.g.add(paramString);
    this.d.put(paramString, Integer.valueOf(3));
  }

  public boolean c(char paramChar)
  {
    return paramChar == '.';
  }

  public boolean c(char paramChar1, char paramChar2)
  {
    return (paramChar1 == '*') && (paramChar2 == '/');
  }

  public String[] c()
  {
    return this.j;
  }

  public boolean d(char paramChar)
  {
    return paramChar == '\\';
  }

  public final boolean d(String paramString)
  {
    return this.a.containsKey(paramString);
  }

  public String[] d()
  {
    return this.i;
  }

  public void e()
  {
    this.g.clear();
    this.d.clear();
  }

  public boolean e(char paramChar)
  {
    return false;
  }

  public final boolean e(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  public boolean f()
  {
    return true;
  }

  public boolean f(char paramChar)
  {
    return paramChar == '"';
  }

  public final boolean f(String paramString)
  {
    return this.c.containsKey(paramString);
  }

  public boolean g(char paramChar)
  {
    return paramChar == '\'';
  }

  public final boolean g(String paramString)
  {
    return this.d.containsKey(paramString);
  }

  public boolean h(char paramChar)
  {
    return paramChar == '#';
  }

  public boolean i(char paramChar)
  {
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.b.h
 * JD-Core Version:    0.6.2
 */