package com.a.a.a.a.a.a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public final class a
{
  static final a a;
  static final int b;

  // ERROR //
  static
  {
    // Byte code:
    //   0: invokestatic 15	com/a/a/a/a/a/a/a:b	()Ljava/lang/Integer;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull +24 -> 29
    //   8: aload_1
    //   9: invokevirtual 21	java/lang/Integer:intValue	()I
    //   12: bipush 19
    //   14: if_icmplt +15 -> 29
    //   17: new 23	com/a/a/a/a/a/a/a$c
    //   20: dup
    //   21: invokespecial 26	com/a/a/a/a/a/a/a$c:<init>	()V
    //   24: astore 7
    //   26: goto +96 -> 122
    //   29: invokestatic 29	com/a/a/a/a/a/a/a:a	()Z
    //   32: ifeq +15 -> 47
    //   35: new 31	com/a/a/a/a/a/a/a$b
    //   38: dup
    //   39: invokespecial 32	com/a/a/a/a/a/a/a$b:<init>	()V
    //   42: astore 7
    //   44: goto +78 -> 122
    //   47: new 31	com/a/a/a/a/a/a/a$b
    //   50: dup
    //   51: invokespecial 32	com/a/a/a/a/a/a/a$b:<init>	()V
    //   54: astore 7
    //   56: goto +66 -> 122
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: getstatic 38	java/lang/System:err	Ljava/io/PrintStream;
    //   65: astore_2
    //   66: new 40	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   73: astore_3
    //   74: aload_3
    //   75: ldc 43
    //   77: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: ldc 31
    //   84: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   87: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: ldc 55
    //   94: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: aload_3
    //   100: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 64	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: getstatic 38	java/lang/System:err	Ljava/io/PrintStream;
    //   110: invokevirtual 68	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   113: new 31	com/a/a/a/a/a/a/a$b
    //   116: dup
    //   117: invokespecial 32	com/a/a/a/a/a/a/a$b:<init>	()V
    //   120: astore 7
    //   122: aload 7
    //   124: putstatic 70	com/a/a/a/a/a/a/a:a	Lcom/a/a/a/a/a/a/a$a;
    //   127: aload_1
    //   128: ifnonnull +9 -> 137
    //   131: iconst_1
    //   132: istore 8
    //   134: goto +9 -> 143
    //   137: aload_1
    //   138: invokevirtual 21	java/lang/Integer:intValue	()I
    //   141: istore 8
    //   143: iload 8
    //   145: putstatic 72	com/a/a/a/a/a/a/a:b	I
    //   148: return
    //   149: astore_0
    //   150: goto -88 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   0	4	59	java/lang/Throwable
    //   8	26	149	java/lang/Throwable
    //   29	44	149	java/lang/Throwable
    //   47	56	149	java/lang/Throwable
  }

  public static void a(Throwable paramThrowable)
  {
    a.a(paramThrowable);
  }

  public static void a(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    a.a(paramThrowable, paramPrintStream);
  }

  public static void a(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    a.a(paramThrowable, paramPrintWriter);
  }

  private static boolean a()
  {
    return true ^ Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic");
  }

  private static Integer b()
  {
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
    }
    return null;
  }

  static abstract class a
  {
    protected static final Throwable[] a = new Throwable[0];

    public abstract void a(Throwable paramThrowable);

    public abstract void a(Throwable paramThrowable, PrintStream paramPrintStream);

    public abstract void a(Throwable paramThrowable, PrintWriter paramPrintWriter);
  }

  static final class b extends a.a
  {
    public void a(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }

    public void a(Throwable paramThrowable, PrintStream paramPrintStream)
    {
      paramThrowable.printStackTrace(paramPrintStream);
    }

    public void a(Throwable paramThrowable, PrintWriter paramPrintWriter)
    {
      paramThrowable.printStackTrace(paramPrintWriter);
    }
  }

  static final class c extends a.a
  {
    public void a(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }

    public void a(Throwable paramThrowable, PrintStream paramPrintStream)
    {
      paramThrowable.printStackTrace(paramPrintStream);
    }

    public void a(Throwable paramThrowable, PrintWriter paramPrintWriter)
    {
      paramThrowable.printStackTrace(paramPrintWriter);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.a.a.a
 * JD-Core Version:    0.6.2
 */