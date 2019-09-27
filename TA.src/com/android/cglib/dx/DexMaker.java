package com.android.cglib.dx;

import com.android.cglib.dx.a.b.l;
import com.android.cglib.dx.a.b.n;
import com.android.cglib.dx.a.b.p;
import com.android.cglib.dx.c.b.q;
import com.android.cglib.dx.c.c.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public final class DexMaker
{
  private final Map<TypeId<?>, c> a = new LinkedHashMap();

  private c a(TypeId<?> paramTypeId)
  {
    c localc = (c)this.a.get(paramTypeId);
    if (localc == null)
    {
      localc = new c(paramTypeId);
      this.a.put(paramTypeId, localc);
    }
    return localc;
  }

  // ERROR //
  private ClassLoader a(File paramFile1, File paramFile2, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 51	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: iconst_4
    //   6: anewarray 47	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: ldc 53
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: ldc 53
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: ldc 53
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: ldc 55
    //   28: aastore
    //   29: invokevirtual 59	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   32: astore 6
    //   34: iconst_4
    //   35: anewarray 4	java/lang/Object
    //   38: astore 7
    //   40: aload 7
    //   42: iconst_0
    //   43: aload_1
    //   44: invokevirtual 65	java/io/File:getPath	()Ljava/lang/String;
    //   47: aastore
    //   48: aload 7
    //   50: iconst_1
    //   51: aload_2
    //   52: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: aastore
    //   56: aload 7
    //   58: iconst_2
    //   59: aconst_null
    //   60: aastore
    //   61: aload 7
    //   63: iconst_3
    //   64: aload_3
    //   65: aastore
    //   66: aload 6
    //   68: aload 7
    //   70: invokevirtual 74	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 55	java/lang/ClassLoader
    //   76: astore 8
    //   78: aload 8
    //   80: areturn
    //   81: new 76	java/lang/AssertionError
    //   84: dup
    //   85: invokespecial 77	java/lang/AssertionError:<init>	()V
    //   88: athrow
    //   89: new 76	java/lang/AssertionError
    //   92: dup
    //   93: invokespecial 77	java/lang/AssertionError:<init>	()V
    //   96: athrow
    //   97: new 76	java/lang/AssertionError
    //   100: dup
    //   101: invokespecial 77	java/lang/AssertionError:<init>	()V
    //   104: athrow
    //   105: astore 5
    //   107: new 79	java/lang/RuntimeException
    //   110: dup
    //   111: aload 5
    //   113: invokevirtual 83	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   116: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   119: athrow
    //   120: astore 4
    //   122: new 88	java/lang/UnsupportedOperationException
    //   125: dup
    //   126: ldc 90
    //   128: aload 4
    //   130: invokespecial 93	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	78	81	java/lang/IllegalAccessException
    //   0	78	89	java/lang/NoSuchMethodException
    //   0	78	97	java/lang/InstantiationException
    //   0	78	105	java/lang/reflect/InvocationTargetException
    //   0	78	120	java/lang/ClassNotFoundException
  }

  private String a()
  {
    Set localSet1 = this.a.keySet();
    Iterator localIterator = localSet1.iterator();
    int[] arrayOfInt = new int[localSet1.size()];
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      c localc = a((TypeId)localIterator.next());
      Set localSet2 = c.b(localc).keySet();
      if (c.d(localc) != null)
      {
        int n = j + 1;
        arrayOfInt[j] = (31 * c.d(localc).hashCode() + localSet2.hashCode());
        j = n;
      }
    }
    Arrays.sort(arrayOfInt);
    int k = arrayOfInt.length;
    int m = 1;
    while (i < k)
    {
      m = arrayOfInt[i] + m * 31;
      i++;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Generated_");
    localStringBuilder.append(m);
    localStringBuilder.append(".jar");
    return localStringBuilder.toString();
  }

  public Code declare(MethodId<?, ?> paramMethodId, int paramInt)
  {
    c localc = a(paramMethodId.a);
    if (c.b(localc).containsKey(paramMethodId))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("already declared: ");
      localStringBuilder1.append(paramMethodId);
      throw new IllegalStateException(localStringBuilder1.toString());
    }
    if ((paramInt & 0xFFFFFFC0) != 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Unexpected flag: ");
      localStringBuilder2.append(Integer.toHexString(paramInt));
      throw new IllegalArgumentException(localStringBuilder2.toString());
    }
    if ((paramInt & 0x20) != 0)
      paramInt = 0x20000 | paramInt & 0xFFFFFFDF;
    if (paramMethodId.isConstructor())
      paramInt |= 65536;
    b localb = new b(paramMethodId, paramInt);
    c.b(localc).put(paramMethodId, localb);
    return b.a(localb);
  }

  public void declare(FieldId<?, ?> paramFieldId, int paramInt, Object paramObject)
  {
    c localc = a(paramFieldId.a);
    if (c.c(localc).containsKey(paramFieldId))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("already declared: ");
      localStringBuilder1.append(paramFieldId);
      throw new IllegalStateException(localStringBuilder1.toString());
    }
    if ((paramInt & 0xFFFFFF20) != 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Unexpected flag: ");
      localStringBuilder2.append(Integer.toHexString(paramInt));
      throw new IllegalArgumentException(localStringBuilder2.toString());
    }
    if (((paramInt & 0x8) == 0) && (paramObject != null))
      throw new IllegalArgumentException("staticValue is non-null, but field is not static");
    a locala = new a(paramFieldId, paramInt, paramObject);
    c.c(localc).put(paramFieldId, locala);
  }

  public void declare(TypeId<?> paramTypeId1, String paramString, int paramInt, TypeId<?> paramTypeId2, TypeId<?>[] paramArrayOfTypeId)
  {
    c localc = a(paramTypeId1);
    if ((paramInt & 0xFFFFFBEE) != 0)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Unexpected flag: ");
      localStringBuilder1.append(Integer.toHexString(paramInt));
      throw new IllegalArgumentException(localStringBuilder1.toString());
    }
    if (c.a(localc))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("already declared: ");
      localStringBuilder2.append(paramTypeId1);
      throw new IllegalStateException(localStringBuilder2.toString());
    }
    c.a(localc, true);
    c.a(localc, paramInt);
    c.a(localc, paramTypeId2);
    c.a(localc, paramString);
    c.a(localc, new TypeList(paramArrayOfTypeId));
  }

  public byte[] generate()
  {
    com.android.cglib.dx.a.b localb = new com.android.cglib.dx.a.b();
    localb.a = 13;
    l locall = new l(localb);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
      locall.a(((c)localIterator.next()).a());
    try
    {
      byte[] arrayOfByte = locall.a(null, false);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  public ClassLoader generateAndLoad(ClassLoader paramClassLoader, File paramFile)
  {
    if (paramFile == null)
    {
      String str = System.getProperty("dexmaker.dexcache");
      if (str != null)
      {
        paramFile = new File(str);
      }
      else
      {
        paramFile = new a().a();
        if (paramFile == null)
          throw new IllegalArgumentException("dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)");
      }
    }
    File localFile = new File(paramFile, a());
    if (localFile.exists())
      return a(localFile, paramFile, paramClassLoader);
    byte[] arrayOfByte = generate();
    localFile.createNewFile();
    JarOutputStream localJarOutputStream = new JarOutputStream(new FileOutputStream(localFile));
    JarEntry localJarEntry = new JarEntry("classes.dex");
    localJarEntry.setSize(arrayOfByte.length);
    localJarOutputStream.putNextEntry(localJarEntry);
    localJarOutputStream.write(arrayOfByte);
    localJarOutputStream.closeEntry();
    localJarOutputStream.close();
    return a(localFile, paramFile, paramClassLoader);
  }

  static class a
  {
    final FieldId<?, ?> a;
    private final int b;
    private final Object c;

    a(FieldId<?, ?> paramFieldId, int paramInt, Object paramObject)
    {
      if (((paramInt & 0x8) == 0) && (paramObject != null))
        throw new IllegalArgumentException("instance fields may not have a value");
      this.a = paramFieldId;
      this.b = paramInt;
      this.c = paramObject;
    }

    n a()
    {
      return new n(this.a.e, this.b);
    }

    public boolean b()
    {
      return (0x8 & this.b) != 0;
    }
  }

  static class b
  {
    final MethodId<?, ?> a;
    private final int b;
    private final Code c;

    public b(MethodId<?, ?> paramMethodId, int paramInt)
    {
      this.a = paramMethodId;
      this.b = paramInt;
      this.c = new Code(this);
    }

    p a(com.android.cglib.dx.a.b paramb)
    {
      com.android.cglib.dx.a.a.g localg = com.android.cglib.dx.a.a.w.a(new q(this.c.c(), 0), 1, null, this.c.b(), paramb);
      return new p(this.a.f, this.b, localg, com.android.cglib.dx.c.d.b.a);
    }

    boolean a()
    {
      return (0x8 & this.b) != 0;
    }

    boolean b()
    {
      return (0x1000A & this.b) != 0;
    }
  }

  private static class c
  {
    private final TypeId<?> a;
    private boolean b;
    private int c;
    private TypeId<?> d;
    private String e;
    private TypeList f;
    private final Map<FieldId, DexMaker.a> g = new LinkedHashMap();
    private final Map<MethodId, DexMaker.b> h = new LinkedHashMap();

    c(TypeId<?> paramTypeId)
    {
      this.a = paramTypeId;
    }

    com.android.cglib.dx.a.b.g a()
    {
      if (!this.b)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Undeclared type ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" declares members: ");
        localStringBuilder.append(this.g.keySet());
        localStringBuilder.append(" ");
        localStringBuilder.append(this.h.keySet());
        throw new IllegalStateException(localStringBuilder.toString());
      }
      com.android.cglib.dx.a.b localb = new com.android.cglib.dx.a.b();
      localb.a = 13;
      com.android.cglib.dx.c.c.w localw = this.a.c;
      com.android.cglib.dx.a.b.g localg = new com.android.cglib.dx.a.b.g(localw, this.c, this.d.c, this.f.b, new v(this.e));
      Iterator localIterator1 = this.h.values().iterator();
      while (localIterator1.hasNext())
      {
        DexMaker.b localb1 = (DexMaker.b)localIterator1.next();
        p localp = localb1.a(localb);
        if (localb1.b())
          localg.a(localp);
        else
          localg.b(localp);
      }
      Iterator localIterator2 = this.g.values().iterator();
      while (localIterator2.hasNext())
      {
        DexMaker.a locala = (DexMaker.a)localIterator2.next();
        n localn = locala.a();
        if (locala.b())
          localg.a(localn, Constants.a(DexMaker.a.a(locala)));
        else
          localg.a(localn);
      }
      return localg;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.DexMaker
 * JD-Core Version:    0.6.2
 */