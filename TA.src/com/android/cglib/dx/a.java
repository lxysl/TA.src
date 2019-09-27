package com.android.cglib.dx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class a
{
  // ERROR //
  private String a(ClassLoader paramClassLoader, Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 18
    //   3: invokevirtual 24	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   6: astore_3
    //   7: aload_3
    //   8: iconst_1
    //   9: invokevirtual 30	java/lang/reflect/Field:setAccessible	(Z)V
    //   12: aload_3
    //   13: aload_1
    //   14: invokevirtual 34	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 36	java/lang/String
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: aload_1
    //   26: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   29: invokestatic 43	com/android/cglib/dx/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   32: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	22	25	java/lang/NoSuchFieldException
    //   0	22	25	java/lang/IllegalAccessException
    //   0	22	25	java/lang/ClassCastException
  }

  static String a(String paramString)
  {
    if (paramString.contains("DexPathList"))
      return e(paramString);
    return d(paramString);
  }

  private ClassLoader b()
  {
    return a.class.getClassLoader();
  }

  static String[] c(String paramString)
  {
    if (paramString.startsWith("dexPath="))
    {
      int i = "dexPath=".length();
      int j = paramString.indexOf(',');
      if (j == -1)
        paramString = paramString.substring(i);
      else
        paramString = paramString.substring(i, j);
    }
    return paramString.split(":");
  }

  private static String d(String paramString)
  {
    int i = paramString.lastIndexOf('[');
    if (i != -1)
      paramString = paramString.substring(i + 1);
    int j = paramString.indexOf(']');
    if (j == -1)
      return paramString;
    return paramString.substring(0, j);
  }

  private static String e(String paramString)
  {
    int i = paramString.indexOf("DexPathList") + "DexPathList".length();
    if (paramString.length() > i + 4)
    {
      String str1 = paramString.substring(i);
      int j = str1.indexOf(']');
      int k = 0;
      if ((str1.charAt(0) == '[') && (str1.charAt(1) == '[') && (j >= 0))
      {
        String[] arrayOfString = str1.substring(2, j).split(",");
        for (int m = 0; m < arrayOfString.length; m++)
        {
          int i1 = arrayOfString[m].indexOf('"');
          int i2 = arrayOfString[m].lastIndexOf('"');
          if ((i1 > 0) && (i1 < i2))
            arrayOfString[m] = arrayOfString[m].substring(i1 + 1, i2);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int n = arrayOfString.length;
        while (k < n)
        {
          String str2 = arrayOfString[k];
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(':');
          localStringBuilder.append(str2);
          k++;
        }
        paramString = localStringBuilder.toString();
      }
    }
    return paramString;
  }

  // ERROR //
  public File a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 117	com/android/cglib/dx/a:b	()Ljava/lang/ClassLoader;
    //   4: astore_1
    //   5: ldc 119
    //   7: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: invokevirtual 126	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokespecial 128	com/android/cglib/dx/a:a	(Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/String;
    //   24: invokevirtual 131	com/android/cglib/dx/a:b	(Ljava/lang/String;)[Ljava/io/File;
    //   27: astore 4
    //   29: aload 4
    //   31: arraylength
    //   32: ifle +12 -> 44
    //   35: aload 4
    //   37: iconst_0
    //   38: aaload
    //   39: astore 5
    //   41: aload 5
    //   43: areturn
    //   44: aconst_null
    //   45: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	41	44	java/lang/ClassCastException
    //   0	41	44	java/lang/ClassNotFoundException
  }

  boolean a(File paramFile)
  {
    return paramFile.exists();
  }

  boolean b(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.canWrite());
  }

  File[] b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (String str1 : c(paramString))
      if (str1.startsWith("/data/app/"))
      {
        int k = "/data/app/".length();
        int m = str1.lastIndexOf(".apk");
        if (m == -4 + str1.length())
        {
          int n = str1.indexOf("-");
          if (n != -1)
            m = n;
          String str2 = str1.substring(k, m);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("/data/data/");
          localStringBuilder.append(str2);
          File localFile1 = new File(localStringBuilder.toString());
          if (b(localFile1))
          {
            File localFile2 = new File(localFile1, "cache");
            if (((a(localFile2)) || (localFile2.mkdir())) && (b(localFile2)))
              localArrayList.add(localFile2);
          }
        }
      }
    return (File[])localArrayList.toArray(new File[localArrayList.size()]);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.a
 * JD-Core Version:    0.6.2
 */