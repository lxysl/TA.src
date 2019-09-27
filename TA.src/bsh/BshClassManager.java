package bsh;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Hashtable;

public class BshClassManager
{
  static Class h;
  private static Object i = new Object();
  protected ClassLoader a;
  protected transient Hashtable b = new Hashtable();
  protected transient Hashtable c = new Hashtable();
  protected transient Hashtable d = new Hashtable();
  protected transient Hashtable e = new Hashtable();
  protected transient Hashtable f = new Hashtable();
  protected transient Hashtable g = new Hashtable();
  private Interpreter j;

  protected static Error a(String paramString, Error paramError)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("A class required by class: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(" could not be loaded:\n");
    localStringBuffer.append(paramError.toString());
    return new NoClassDefFoundError(localStringBuffer.toString());
  }

  public static BshClassManager createClassManager(Interpreter paramInterpreter)
  {
    BshClassManager localBshClassManager;
    if ((Capabilities.classExists("java.lang.ref.WeakReference")) && (Capabilities.classExists("java.util.HashMap")) && (Capabilities.classExists("bsh.classpath.ClassManagerImpl")))
      try
      {
        localBshClassManager = (BshClassManager)Class.forName("bsh.classpath.ClassManagerImpl").newInstance();
      }
      catch (Exception localException)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Error loading classmanager: ");
        localStringBuffer.append(localException);
        throw new InterpreterError(localStringBuffer.toString());
      }
    else
      localBshClassManager = new BshClassManager();
    if (paramInterpreter == null)
      paramInterpreter = new Interpreter();
    localBshClassManager.j = paramInterpreter;
    return localBshClassManager;
  }

  protected static UtilEvalError e()
  {
    return new Capabilities.Unavailable("ClassLoading features unavailable.");
  }

  static Class g(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }

  // ERROR //
  protected Class a(String paramString)
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuffer:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 120
    //   11: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   14: pop
    //   15: aload_2
    //   16: aload_1
    //   17: bipush 46
    //   19: bipush 47
    //   21: invokevirtual 126	java/lang/String:replace	(CC)Ljava/lang/String;
    //   24: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   27: pop
    //   28: aload_2
    //   29: ldc 128
    //   31: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: aload_2
    //   36: invokevirtual 62	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: aload_0
    //   42: aload 6
    //   44: invokevirtual 132	bsh/BshClassManager:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnonnull +5 -> 56
    //   54: aconst_null
    //   55: areturn
    //   56: getstatic 138	java/lang/System:out	Ljava/io/PrintStream;
    //   59: astore 14
    //   61: new 44	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 45	java/lang/StringBuffer:<init>	()V
    //   68: astore 15
    //   70: aload 15
    //   72: ldc 140
    //   74: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload 15
    //   80: aload 6
    //   82: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: aload 14
    //   88: aload 15
    //   90: invokevirtual 62	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   93: invokevirtual 145	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 105	bsh/BshClassManager:j	Lbsh/Interpreter;
    //   100: new 147	java/io/InputStreamReader
    //   103: dup
    //   104: aload 7
    //   106: invokespecial 150	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: invokevirtual 154	bsh/Interpreter:eval	(Ljava/io/Reader;)Ljava/lang/Object;
    //   112: pop
    //   113: goto +13 -> 126
    //   116: astore 8
    //   118: getstatic 157	java/lang/System:err	Ljava/io/PrintStream;
    //   121: aload 8
    //   123: invokevirtual 160	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 163	bsh/BshClassManager:plainClassForName	(Ljava/lang/String;)Ljava/lang/Class;
    //   131: astore 13
    //   133: aload 13
    //   135: areturn
    //   136: getstatic 157	java/lang/System:err	Ljava/io/PrintStream;
    //   139: astore 9
    //   141: new 44	java/lang/StringBuffer
    //   144: dup
    //   145: invokespecial 45	java/lang/StringBuffer:<init>	()V
    //   148: astore 10
    //   150: aload 10
    //   152: ldc 165
    //   154: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   157: pop
    //   158: aload 10
    //   160: aload_1
    //   161: invokevirtual 51	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: aload 9
    //   167: aload 10
    //   169: invokevirtual 62	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   172: invokevirtual 145	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   175: aconst_null
    //   176: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   56	113	116	bsh/EvalError
    //   126	133	136	java/lang/ClassNotFoundException
  }

  protected Method a(Class paramClass, String paramString, Class[] paramArrayOfClass, boolean paramBoolean)
  {
    SignatureKey localSignatureKey = new SignatureKey(paramClass, paramString, paramArrayOfClass);
    Method localMethod = (Method)this.e.get(localSignatureKey);
    if ((localMethod == null) && (!paramBoolean))
      localMethod = (Method)this.d.get(localSignatureKey);
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer1;
      if (localMethod == null)
      {
        localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append("getResolvedMethod cache MISS: ");
        localStringBuffer1.append(paramClass);
        localStringBuffer1.append(" - ");
        localStringBuffer1.append(paramString);
      }
      StringBuffer localStringBuffer2;
      for (String str = localStringBuffer1.toString(); ; str = localStringBuffer2.toString())
      {
        Interpreter.debug(str);
        return localMethod;
        localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("getResolvedMethod cache HIT: ");
        localStringBuffer2.append(paramClass);
        localStringBuffer2.append(" - ");
        localStringBuffer2.append(localMethod);
      }
    }
    return localMethod;
  }

  protected void a()
  {
    this.c = new Hashtable();
    this.b = new Hashtable();
    this.d = new Hashtable();
    this.e = new Hashtable();
  }

  public void addClassPath(URL paramURL)
  {
  }

  public void addListener(Listener paramListener)
  {
  }

  protected String b(String paramString)
  {
    throw e();
  }

  protected void b()
  {
    throw e();
  }

  protected void c(String paramString)
  {
    String str1 = Name.suffix(paramString, 1);
    int k = str1.indexOf("$");
    if (k != -1)
      str1 = str1.substring(k + 1);
    String str2 = (String)this.g.get(str1);
    if (str2 != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Defining class problem: ");
      localStringBuffer.append(paramString);
      localStringBuffer.append(": BeanShell cannot yet simultaneously define two or more ");
      localStringBuffer.append("dependant classes of the same name.  Attempt to define: ");
      localStringBuffer.append(paramString);
      localStringBuffer.append(" while defining: ");
      localStringBuffer.append(str2);
      throw new InterpreterError(localStringBuffer.toString());
    }
    this.f.put(paramString, i);
    this.g.put(str1, paramString);
  }

  protected boolean c()
  {
    return false;
  }

  public void cacheClassInfo(String paramString, Class paramClass)
  {
    if (paramClass != null)
    {
      this.b.put(paramString, paramClass);
      return;
    }
    this.c.put(paramString, i);
  }

  public void cacheResolvedMethod(Class paramClass, Class[] paramArrayOfClass, Method paramMethod)
  {
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("cacheResolvedMethod putting: ");
      localStringBuffer.append(paramClass);
      localStringBuffer.append(" ");
      localStringBuffer.append(paramMethod);
      Interpreter.debug(localStringBuffer.toString());
    }
    SignatureKey localSignatureKey = new SignatureKey(paramClass, paramMethod.getName(), paramArrayOfClass);
    if (Modifier.isStatic(paramMethod.getModifiers()));
    for (Hashtable localHashtable = this.e; ; localHashtable = this.d)
    {
      localHashtable.put(localSignatureKey, paramMethod);
      return;
    }
  }

  public boolean classExists(String paramString)
  {
    return classForName(paramString) != null;
  }

  public Class classForName(String paramString)
  {
    if (d(paramString))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Attempting to load class in the process of being defined: ");
      localStringBuffer.append(paramString);
      throw new InterpreterError(localStringBuffer.toString());
    }
    Object localObject = null;
    try
    {
      Class localClass = plainClassForName(paramString);
      localObject = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    if (localObject == null)
      localObject = a(paramString);
    return localObject;
  }

  protected void d()
  {
  }

  protected boolean d(String paramString)
  {
    return this.f.get(paramString) != null;
  }

  public Class defineClass(String paramString, byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Can't create class (");
    localStringBuffer.append(paramString);
    localStringBuffer.append(") without class manager package.");
    throw new InterpreterError(localStringBuffer.toString());
  }

  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println("BshClassManager: no class manager.");
  }

  protected String e(String paramString)
  {
    String str = Name.suffix(paramString, 1);
    return (String)this.g.get(str);
  }

  protected void f(String paramString)
  {
    String str = Name.suffix(paramString, 1);
    this.f.remove(paramString);
    this.g.remove(str);
  }

  public URL getResource(String paramString)
  {
    URL localURL;
    if (this.a != null)
      localURL = this.a.getResource(paramString.substring(1));
    else
      localURL = null;
    if (localURL == null)
    {
      Class localClass;
      if (h == null)
      {
        localClass = g("bsh.Interpreter");
        h = localClass;
      }
      else
      {
        localClass = h;
      }
      localURL = localClass.getResource(paramString);
    }
    return localURL;
  }

  public InputStream getResourceAsStream(String paramString)
  {
    InputStream localInputStream;
    if (this.a != null)
      localInputStream = this.a.getResourceAsStream(paramString.substring(1));
    else
      localInputStream = null;
    if (localInputStream == null)
    {
      Class localClass;
      if (h == null)
      {
        localClass = g("bsh.Interpreter");
        h = localClass;
      }
      else
      {
        localClass = h;
      }
      localInputStream = localClass.getResourceAsStream(paramString);
    }
    return localInputStream;
  }

  public Class plainClassForName(String paramString)
  {
    try
    {
      Class localClass;
      if (this.a != null)
        localClass = this.a.loadClass(paramString);
      else
        localClass = Class.forName(paramString);
      cacheClassInfo(paramString, localClass);
      return localClass;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      throw a(paramString, localNoClassDefFoundError);
    }
  }

  public void reloadAllClasses()
  {
    throw e();
  }

  public void reloadClasses(String[] paramArrayOfString)
  {
    throw e();
  }

  public void reloadPackage(String paramString)
  {
    throw e();
  }

  public void removeListener(Listener paramListener)
  {
  }

  public void reset()
  {
    a();
  }

  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.a = paramClassLoader;
    d();
  }

  public void setClassPath(URL[] paramArrayOfURL)
  {
    throw e();
  }

  public static abstract interface Listener
  {
    public abstract void classLoaderChanged();
  }

  static class SignatureKey
  {
    Class a;
    Class[] b;
    String c;
    int d = 0;

    SignatureKey(Class paramClass, String paramString, Class[] paramArrayOfClass)
    {
      this.a = paramClass;
      this.c = paramString;
      this.b = paramArrayOfClass;
    }

    public boolean equals(Object paramObject)
    {
      SignatureKey localSignatureKey = (SignatureKey)paramObject;
      if (this.b == null)
        return localSignatureKey.b == null;
      if (this.a != localSignatureKey.a)
        return false;
      if (!this.c.equals(localSignatureKey.c))
        return false;
      if (this.b.length != localSignatureKey.b.length)
        return false;
      for (int i = 0; ; i++)
      {
        if (i >= this.b.length)
          return true;
        if (this.b[i] == null)
        {
          if (localSignatureKey.b[i] != null)
            return false;
        }
        else if (!this.b[i].equals(localSignatureKey.b[i]))
          return false;
      }
    }

    public int hashCode()
    {
      if (this.d == 0)
      {
        this.d = (this.a.hashCode() * this.c.hashCode());
        if (this.b == null)
          return this.d;
        int i = 0;
        while (i < this.b.length)
        {
          int j;
          if (this.b[i] == null)
            j = 21;
          else
            j = this.b[i].hashCode();
          int k = this.d;
          i++;
          this.d = (j + k * i);
        }
      }
      return this.d;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BshClassManager
 * JD-Core Version:    0.6.2
 */