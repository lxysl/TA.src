package bsh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Interpreter
  implements ConsoleInterface, Serializable, Runnable
{
  public static boolean DEBUG = false;
  public static boolean LOCALSCOPING = false;
  public static boolean TRACE = false;
  public static final String VERSION = "2.0b4";
  static transient PrintStream a;
  static String b = "\n";
  static This c;
  static Class n;
  transient Parser d;
  NameSpace e;
  transient Reader f;
  transient PrintStream g;
  transient PrintStream h;
  ConsoleInterface i;
  Interpreter j;
  String k;
  protected boolean l;
  protected boolean m;
  private boolean o = false;
  private boolean p = true;
  private boolean q;

  static
  {
    b();
  }

  public Interpreter()
  {
    this(new StringReader(""), System.out, System.err, false, null);
    this.l = true;
    a("bsh.evalOnly", new Primitive(true));
  }

  public Interpreter(ConsoleInterface paramConsoleInterface)
  {
    this(paramConsoleInterface, null);
  }

  public Interpreter(ConsoleInterface paramConsoleInterface, NameSpace paramNameSpace)
  {
    this(paramConsoleInterface.getIn(), paramConsoleInterface.getOut(), paramConsoleInterface.getErr(), true, paramNameSpace);
    setConsole(paramConsoleInterface);
  }

  public Interpreter(Reader paramReader, PrintStream paramPrintStream1, PrintStream paramPrintStream2, boolean paramBoolean)
  {
    this(paramReader, paramPrintStream1, paramPrintStream2, paramBoolean, null);
  }

  public Interpreter(Reader paramReader, PrintStream paramPrintStream1, PrintStream paramPrintStream2, boolean paramBoolean, NameSpace paramNameSpace)
  {
    this(paramReader, paramPrintStream1, paramPrintStream2, paramBoolean, paramNameSpace, null, null);
  }

  public Interpreter(Reader paramReader, PrintStream paramPrintStream1, PrintStream paramPrintStream2, boolean paramBoolean, NameSpace paramNameSpace, Interpreter paramInterpreter, String paramString)
  {
    this.d = new Parser(paramReader);
    long l1 = System.currentTimeMillis();
    this.f = paramReader;
    this.g = paramPrintStream1;
    this.h = paramPrintStream2;
    this.m = paramBoolean;
    a = paramPrintStream2;
    this.j = paramInterpreter;
    if (paramInterpreter != null)
      setStrictJava(paramInterpreter.getStrictJava());
    this.k = paramString;
    BshClassManager localBshClassManager = BshClassManager.createClassManager(this);
    if (paramNameSpace == null)
      this.e = new NameSpace(localBshClassManager, "global");
    else
      this.e = paramNameSpace;
    if (!(a("bsh") instanceof This))
      c();
    if (paramBoolean)
      a();
    long l2 = System.currentTimeMillis();
    if (DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Time to initialize interpreter: ");
      localStringBuffer.append(l2 - l1);
      debug(localStringBuffer.toString());
    }
  }

  static Class b(String paramString)
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

  static void b()
  {
    PrintStream localPrintStream;
    StringBuffer localStringBuffer;
    String str1;
    try
    {
      b = System.getProperty("line.separator");
      a = System.err;
      DEBUG = Boolean.getBoolean("debug");
      TRACE = Boolean.getBoolean("trace");
      LOCALSCOPING = Boolean.getBoolean("localscoping");
      String str2 = System.getProperty("outfile");
      if (str2 == null)
        return;
      redirectOutputToFile(str2);
      return;
    }
    catch (Throwable localThrowable)
    {
      localPrintStream = System.err;
      localStringBuffer = new StringBuffer();
      str1 = "Could not init static(3):";
    }
    catch (Exception localException)
    {
      localPrintStream = System.err;
      localStringBuffer = new StringBuffer();
      str1 = "Could not init static(2):";
    }
    catch (SecurityException localSecurityException)
    {
      localPrintStream = System.err;
      localStringBuffer = new StringBuffer();
      str1 = "Could not init static:";
    }
    localStringBuffer.append(str1);
    localStringBuffer.append(localSecurityException);
    localPrintStream.println(localStringBuffer.toString());
  }

  private String c(String paramString)
  {
    String str = paramString.replace('\n', ' ').replace('\r', ' ');
    if (str.length() > 80)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str.substring(0, 80));
      localStringBuffer.append(" . . . ");
      str = localStringBuffer.toString();
    }
    return str;
  }

  // ERROR //
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 270	bsh/Interpreter:getClassManager	()Lbsh/BshClassManager;
    //   4: astore_1
    //   5: aload_0
    //   6: ldc 158
    //   8: new 149	bsh/NameSpace
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 272
    //   16: invokespecial 154	bsh/NameSpace:<init>	(Lbsh/BshClassManager;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 275	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   23: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   26: getstatic 277	bsh/Interpreter:c	Lbsh/This;
    //   29: ifnonnull +21 -> 50
    //   32: new 149	bsh/NameSpace
    //   35: dup
    //   36: aload_1
    //   37: ldc_w 279
    //   40: invokespecial 154	bsh/NameSpace:<init>	(Lbsh/BshClassManager;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 275	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   47: putstatic 277	bsh/Interpreter:c	Lbsh/This;
    //   50: aload_0
    //   51: ldc_w 281
    //   54: getstatic 277	bsh/Interpreter:c	Lbsh/This;
    //   57: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   60: aload_0
    //   61: ldc_w 283
    //   64: getstatic 277	bsh/Interpreter:c	Lbsh/This;
    //   67: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   70: aload_0
    //   71: ldc_w 285
    //   74: new 149	bsh/NameSpace
    //   77: dup
    //   78: aload_1
    //   79: ldc_w 287
    //   82: invokespecial 154	bsh/NameSpace:<init>	(Lbsh/BshClassManager;Ljava/lang/String;)V
    //   85: aload_0
    //   86: invokevirtual 275	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   89: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   92: aload_0
    //   93: ldc_w 289
    //   96: ldc_w 291
    //   99: invokestatic 214	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   105: goto +13 -> 118
    //   108: aload_0
    //   109: ldc_w 289
    //   112: ldc_w 293
    //   115: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   118: aload_0
    //   119: ldc_w 295
    //   122: new 75	bsh/Primitive
    //   125: dup
    //   126: aload_0
    //   127: getfield 128	bsh/Interpreter:m	Z
    //   130: invokespecial 78	bsh/Primitive:<init>	(Z)V
    //   133: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload_0
    //   137: ldc 73
    //   139: new 75	bsh/Primitive
    //   142: dup
    //   143: aload_0
    //   144: getfield 71	bsh/Interpreter:l	Z
    //   147: invokespecial 78	bsh/Primitive:<init>	(Z)V
    //   150: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   153: return
    //
    // Exception table:
    //   from	to	target	type
    //   92	105	108	java/lang/SecurityException
  }

  private JJTParserState d()
  {
    return this.d.a;
  }

  public static final void debug(String paramString)
  {
    if (DEBUG)
    {
      PrintStream localPrintStream = a;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("// Debug: ");
      localStringBuffer.append(paramString);
      localPrintStream.println(localStringBuffer.toString());
    }
  }

  private boolean e()
  {
    return this.d.Line();
  }

  // ERROR //
  private String f()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 306
    //   4: invokevirtual 309	bsh/Interpreter:eval	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 252	java/lang/String
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: ldc_w 311
    //   16: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	13	java/lang/Exception
  }

  public static void invokeMain(Class paramClass, String[] paramArrayOfString)
  {
    Class[] arrayOfClass = new Class[1];
    Class localClass;
    if (n == null)
    {
      localClass = b("[Ljava.lang.String;");
      n = localClass;
    }
    else
    {
      localClass = n;
    }
    arrayOfClass[0] = localClass;
    Method localMethod = Reflect.a(null, paramClass, "main", arrayOfClass, true);
    if (localMethod != null)
      localMethod.invoke(null, new Object[] { paramArrayOfString });
  }

  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 0)
    {
      String str1 = paramArrayOfString[0];
      String[] arrayOfString;
      if (paramArrayOfString.length > 1)
      {
        arrayOfString = new String[paramArrayOfString.length - 1];
        System.arraycopy(paramArrayOfString, 1, arrayOfString, 0, paramArrayOfString.length - 1);
      }
      else
      {
        arrayOfString = new String[0];
      }
      Interpreter localInterpreter = new Interpreter();
      localInterpreter.a("bsh.args", arrayOfString);
      PrintStream localPrintStream1;
      StringBuffer localStringBuffer1;
      String str2;
      try
      {
        Object localObject2 = localInterpreter.source(str1, localInterpreter.e);
        boolean bool = localObject2 instanceof Class;
        if (!bool)
          return;
        try
        {
          invokeMain((Class)localObject2, arrayOfString);
          return;
        }
        catch (Exception localException)
        {
          Throwable localThrowable;
          if ((localException instanceof InvocationTargetException))
            localThrowable = ((InvocationTargetException)localException).getTargetException();
          PrintStream localPrintStream3 = System.err;
          StringBuffer localStringBuffer3 = new StringBuffer();
          localStringBuffer3.append("Class: ");
          localStringBuffer3.append(localObject2);
          localStringBuffer3.append(" main method threw exception:");
          localStringBuffer3.append(localThrowable);
          localPrintStream3.println(localStringBuffer3.toString());
          return;
        }
      }
      catch (IOException localIOException)
      {
        localPrintStream1 = System.out;
        localStringBuffer1 = new StringBuffer();
        str2 = "I/O Error: ";
      }
      catch (EvalError localEvalError)
      {
        localPrintStream1 = System.out;
        localStringBuffer1 = new StringBuffer();
        str2 = "Evaluation Error: ";
      }
      catch (TargetError localTargetError)
      {
        PrintStream localPrintStream2 = System.out;
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Script threw exception: ");
        localStringBuffer2.append(localTargetError);
        localPrintStream2.println(localStringBuffer2.toString());
        if (!localTargetError.inNativeCode())
          return;
        localTargetError.printStackTrace(DEBUG, System.err);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localPrintStream1 = System.out;
        localStringBuffer1 = new StringBuffer();
        str2 = "File not found: ";
      }
      localStringBuffer1.append(str2);
      localStringBuffer1.append(localFileNotFoundException);
      localPrintStream1.println(localStringBuffer1.toString());
    }
    else
    {
      Object localObject1;
      if ((System.getProperty("os.name").startsWith("Windows")) && (System.getProperty("java.version").startsWith("1.1.")))
        localObject1 = new Interpreter.1(System.in);
      else
        localObject1 = System.in;
      new Interpreter(new CommandLineReader(new InputStreamReader((InputStream)localObject1)), System.out, System.err, true).run();
    }
  }

  // ERROR //
  public static void redirectOutputToFile(String paramString)
  {
    // Byte code:
    //   0: new 247	java/io/PrintStream
    //   3: dup
    //   4: new 412	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 416	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 420	java/lang/System:setOut	(Ljava/io/PrintStream;)V
    //   20: aload_1
    //   21: invokestatic 423	java/lang/System:setErr	(Ljava/io/PrintStream;)V
    //   24: return
    //   25: getstatic 66	java/lang/System:err	Ljava/io/PrintStream;
    //   28: astore_2
    //   29: new 171	java/lang/StringBuffer
    //   32: dup
    //   33: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: ldc_w 425
    //   41: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   44: pop
    //   45: aload_3
    //   46: aload_0
    //   47: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   56: invokevirtual 250	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   59: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	24	25	java/io/IOException
  }

  Object a(String paramString)
  {
    try
    {
      Object localObject = get(paramString);
      return localObject;
    }
    catch (EvalError localEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("set: ");
      localStringBuffer.append(localEvalError);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  void a()
  {
    try
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(System.getProperty("user.home"));
      localStringBuffer1.append(File.separator);
      localStringBuffer1.append(".bshrc");
      source(localStringBuffer1.toString(), this.e);
      return;
    }
    catch (Exception localException)
    {
      if (DEBUG)
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Could not find rc file: ");
        localStringBuffer2.append(localException);
        debug(localStringBuffer2.toString());
      }
    }
  }

  void a(String paramString, Object paramObject)
  {
    try
    {
      set(paramString, paramObject);
      return;
    }
    catch (EvalError localEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("set: ");
      localStringBuffer.append(localEvalError);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  public final void error(Object paramObject)
  {
    if (this.i != null)
    {
      ConsoleInterface localConsoleInterface = this.i;
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("// Error: ");
      localStringBuffer2.append(paramObject);
      localStringBuffer2.append("\n");
      localConsoleInterface.error(localStringBuffer2.toString());
      return;
    }
    PrintStream localPrintStream = this.h;
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("// Error: ");
    localStringBuffer1.append(paramObject);
    localPrintStream.println(localStringBuffer1.toString());
    this.h.flush();
  }

  public Object eval(Reader paramReader)
  {
    return eval(paramReader, this.e, "eval stream");
  }

  // ERROR //
  public Object eval(Reader paramReader, NameSpace paramNameSpace, String paramString)
  {
    // Byte code:
    //   0: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   3: ifeq +36 -> 39
    //   6: new 171	java/lang/StringBuffer
    //   9: dup
    //   10: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 470
    //   20: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   23: pop
    //   24: aload 4
    //   26: aload_2
    //   27: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   30: pop
    //   31: aload 4
    //   33: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   36: invokestatic 188	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   39: new 2	bsh/Interpreter
    //   42: dup
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 124	bsh/Interpreter:g	Ljava/io/PrintStream;
    //   48: aload_0
    //   49: getfield 126	bsh/Interpreter:h	Ljava/io/PrintStream;
    //   52: iconst_0
    //   53: aload_2
    //   54: aload_0
    //   55: aload_3
    //   56: invokespecial 103	bsh/Interpreter:<init>	(Ljava/io/Reader;Ljava/io/PrintStream;Ljava/io/PrintStream;ZLbsh/NameSpace;Lbsh/Interpreter;Ljava/lang/String;)V
    //   59: astore 7
    //   61: new 472	bsh/CallStack
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 475	bsh/CallStack:<init>	(Lbsh/NameSpace;)V
    //   69: astore 8
    //   71: iconst_0
    //   72: istore 9
    //   74: aconst_null
    //   75: astore 10
    //   77: iload 9
    //   79: ifeq +6 -> 85
    //   82: goto +189 -> 271
    //   85: aload 7
    //   87: invokespecial 477	bsh/Interpreter:e	()Z
    //   90: istore 22
    //   92: aload 7
    //   94: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   97: invokevirtual 483	bsh/JJTParserState:d	()I
    //   100: ifle +279 -> 379
    //   103: aload 7
    //   105: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   108: invokevirtual 486	bsh/JJTParserState:b	()Lbsh/Node;
    //   111: checkcast 488	bsh/SimpleNode
    //   114: astore 15
    //   116: aload 15
    //   118: aload_3
    //   119: invokevirtual 491	bsh/SimpleNode:setSourceFile	(Ljava/lang/String;)V
    //   122: getstatic 227	bsh/Interpreter:TRACE	Z
    //   125: ifeq +41 -> 166
    //   128: new 171	java/lang/StringBuffer
    //   131: dup
    //   132: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   135: astore 49
    //   137: aload 49
    //   139: ldc_w 493
    //   142: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   145: pop
    //   146: aload 49
    //   148: aload 15
    //   150: invokevirtual 496	bsh/SimpleNode:getText	()Ljava/lang/String;
    //   153: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   156: pop
    //   157: aload_0
    //   158: aload 49
    //   160: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   163: invokevirtual 498	bsh/Interpreter:println	(Ljava/lang/Object;)V
    //   166: aload 15
    //   168: aload 8
    //   170: aload 7
    //   172: invokevirtual 501	bsh/SimpleNode:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   175: astore 24
    //   177: aload 8
    //   179: invokevirtual 504	bsh/CallStack:depth	()I
    //   182: iconst_1
    //   183: if_icmple +42 -> 225
    //   186: new 171	java/lang/StringBuffer
    //   189: dup
    //   190: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   193: astore 52
    //   195: aload 52
    //   197: ldc_w 506
    //   200: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   203: pop
    //   204: aload 52
    //   206: aload 8
    //   208: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   211: pop
    //   212: new 432	bsh/InterpreterError
    //   215: dup
    //   216: aload 52
    //   218: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   221: invokespecial 433	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: aload 24
    //   227: instanceof 508
    //   230: ifeq +47 -> 277
    //   233: aload 24
    //   235: checkcast 508	bsh/ReturnControl
    //   238: getfield 512	bsh/ReturnControl:value	Ljava/lang/Object;
    //   241: astore 10
    //   243: aload 7
    //   245: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   248: invokevirtual 513	bsh/JJTParserState:a	()V
    //   251: aload 8
    //   253: invokevirtual 504	bsh/CallStack:depth	()I
    //   256: iconst_1
    //   257: if_icmple +14 -> 271
    //   260: aload 8
    //   262: invokevirtual 516	bsh/CallStack:clear	()V
    //   265: aload 8
    //   267: aload_2
    //   268: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   271: aload 10
    //   273: invokestatic 523	bsh/Primitive:unwrap	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: areturn
    //   277: aload 7
    //   279: getfield 525	bsh/Interpreter:q	Z
    //   282: ifeq +55 -> 337
    //   285: aload 24
    //   287: getstatic 529	bsh/Primitive:VOID	Lbsh/Primitive;
    //   290: if_acmpeq +47 -> 337
    //   293: new 171	java/lang/StringBuffer
    //   296: dup
    //   297: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   300: astore 55
    //   302: aload 55
    //   304: ldc_w 531
    //   307: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   310: pop
    //   311: aload 55
    //   313: aload 24
    //   315: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   318: pop
    //   319: aload 55
    //   321: ldc_w 533
    //   324: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   327: pop
    //   328: aload_0
    //   329: aload 55
    //   331: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   334: invokevirtual 498	bsh/Interpreter:println	(Ljava/lang/Object;)V
    //   337: aload 24
    //   339: astore 10
    //   341: goto +38 -> 379
    //   344: astore 31
    //   346: goto +227 -> 573
    //   349: astore 25
    //   351: goto +324 -> 675
    //   354: astore 43
    //   356: goto +82 -> 438
    //   359: astore 36
    //   361: goto +139 -> 500
    //   364: astore 29
    //   366: goto +555 -> 921
    //   369: astore 21
    //   371: goto +292 -> 663
    //   374: astore 14
    //   376: goto +397 -> 773
    //   379: aload 7
    //   381: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   384: invokevirtual 513	bsh/JJTParserState:a	()V
    //   387: aload 8
    //   389: invokevirtual 504	bsh/CallStack:depth	()I
    //   392: iconst_1
    //   393: if_icmple +14 -> 407
    //   396: aload 8
    //   398: invokevirtual 516	bsh/CallStack:clear	()V
    //   401: aload 8
    //   403: aload_2
    //   404: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   407: iload 22
    //   409: istore 9
    //   411: goto -334 -> 77
    //   414: astore 29
    //   416: goto +502 -> 918
    //   419: astore 21
    //   421: goto +239 -> 660
    //   424: astore 12
    //   426: goto +443 -> 869
    //   429: astore 42
    //   431: aload 42
    //   433: astore 43
    //   435: aconst_null
    //   436: astore 15
    //   438: new 171	java/lang/StringBuffer
    //   441: dup
    //   442: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   445: astore 44
    //   447: aload 44
    //   449: ldc_w 535
    //   452: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   455: pop
    //   456: aload 44
    //   458: aload_3
    //   459: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   462: pop
    //   463: aload 44
    //   465: ldc_w 537
    //   468: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   471: pop
    //   472: aload 44
    //   474: aload 43
    //   476: invokevirtual 538	bsh/TokenMgrError:getMessage	()Ljava/lang/String;
    //   479: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   482: pop
    //   483: new 339	bsh/EvalError
    //   486: dup
    //   487: aload 44
    //   489: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   492: aload 15
    //   494: aload 8
    //   496: invokespecial 541	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   499: athrow
    //   500: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   503: ifeq +8 -> 511
    //   506: aload 36
    //   508: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   511: new 171	java/lang/StringBuffer
    //   514: dup
    //   515: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   518: astore 37
    //   520: aload 37
    //   522: ldc_w 535
    //   525: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   528: pop
    //   529: aload 37
    //   531: aload_3
    //   532: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   535: pop
    //   536: aload 37
    //   538: ldc_w 548
    //   541: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   544: pop
    //   545: aload 37
    //   547: aload 36
    //   549: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   555: pop
    //   556: new 339	bsh/EvalError
    //   559: dup
    //   560: aload 37
    //   562: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   565: aload 15
    //   567: aload 8
    //   569: invokespecial 541	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   572: athrow
    //   573: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   576: ifeq +8 -> 584
    //   579: aload 31
    //   581: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   584: aload 31
    //   586: invokevirtual 552	bsh/EvalError:a	()Lbsh/SimpleNode;
    //   589: ifnonnull +10 -> 599
    //   592: aload 31
    //   594: aload 15
    //   596: invokevirtual 555	bsh/EvalError:a	(Lbsh/SimpleNode;)V
    //   599: new 171	java/lang/StringBuffer
    //   602: dup
    //   603: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   606: astore 32
    //   608: aload 32
    //   610: ldc_w 535
    //   613: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   616: pop
    //   617: aload 32
    //   619: aload_3
    //   620: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   623: pop
    //   624: aload 31
    //   626: aload 32
    //   628: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   631: invokevirtual 558	bsh/EvalError:reThrow	(Ljava/lang/String;)V
    //   634: aload 7
    //   636: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   639: invokevirtual 513	bsh/JJTParserState:a	()V
    //   642: aload 8
    //   644: invokevirtual 504	bsh/CallStack:depth	()I
    //   647: iconst_1
    //   648: if_icmple +105 -> 753
    //   651: goto +91 -> 742
    //   654: astore 21
    //   656: iload 9
    //   658: istore 22
    //   660: aconst_null
    //   661: astore 15
    //   663: aload 21
    //   665: astore 23
    //   667: aload 10
    //   669: astore 24
    //   671: aload 23
    //   673: astore 25
    //   675: aload 25
    //   677: invokevirtual 559	bsh/TargetError:a	()Lbsh/SimpleNode;
    //   680: ifnonnull +10 -> 690
    //   683: aload 25
    //   685: aload 15
    //   687: invokevirtual 560	bsh/TargetError:a	(Lbsh/SimpleNode;)V
    //   690: new 171	java/lang/StringBuffer
    //   693: dup
    //   694: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   697: astore 26
    //   699: aload 26
    //   701: ldc_w 535
    //   704: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   707: pop
    //   708: aload 26
    //   710: aload_3
    //   711: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   714: pop
    //   715: aload 25
    //   717: aload 26
    //   719: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   722: invokevirtual 561	bsh/TargetError:reThrow	(Ljava/lang/String;)V
    //   725: aload 7
    //   727: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   730: invokevirtual 513	bsh/JJTParserState:a	()V
    //   733: aload 8
    //   735: invokevirtual 504	bsh/CallStack:depth	()I
    //   738: iconst_1
    //   739: if_icmple +14 -> 753
    //   742: aload 8
    //   744: invokevirtual 516	bsh/CallStack:clear	()V
    //   747: aload 8
    //   749: aload_2
    //   750: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   753: iload 22
    //   755: istore 9
    //   757: aload 24
    //   759: astore 10
    //   761: goto -684 -> 77
    //   764: astore 13
    //   766: aload 13
    //   768: astore 14
    //   770: aconst_null
    //   771: astore 15
    //   773: aload 14
    //   775: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   778: new 171	java/lang/StringBuffer
    //   781: dup
    //   782: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   785: astore 16
    //   787: aload 16
    //   789: ldc_w 535
    //   792: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   795: pop
    //   796: aload 16
    //   798: aload_3
    //   799: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   802: pop
    //   803: aload 16
    //   805: ldc_w 563
    //   808: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   811: pop
    //   812: aload 16
    //   814: aload 14
    //   816: invokevirtual 564	bsh/InterpreterError:getMessage	()Ljava/lang/String;
    //   819: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   822: pop
    //   823: new 339	bsh/EvalError
    //   826: dup
    //   827: aload 16
    //   829: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   832: aload 15
    //   834: aload 8
    //   836: invokespecial 541	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   839: athrow
    //   840: astore 11
    //   842: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   845: ifeq +15 -> 860
    //   848: aload_0
    //   849: aload 11
    //   851: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   854: invokevirtual 567	bsh/ParseException:getMessage	(Z)Ljava/lang/String;
    //   857: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   860: aload 11
    //   862: aload_3
    //   863: invokevirtual 571	bsh/ParseException:setErrorSourceFile	(Ljava/lang/String;)V
    //   866: aload 11
    //   868: athrow
    //   869: aload 7
    //   871: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   874: invokevirtual 513	bsh/JJTParserState:a	()V
    //   877: aload 8
    //   879: invokevirtual 504	bsh/CallStack:depth	()I
    //   882: iconst_1
    //   883: if_icmple +14 -> 897
    //   886: aload 8
    //   888: invokevirtual 516	bsh/CallStack:clear	()V
    //   891: aload 8
    //   893: aload_2
    //   894: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   897: aload 12
    //   899: athrow
    //   900: astore 35
    //   902: aload 35
    //   904: astore 36
    //   906: aconst_null
    //   907: astore 15
    //   909: goto -409 -> 500
    //   912: astore 29
    //   914: iload 9
    //   916: istore 22
    //   918: aconst_null
    //   919: astore 15
    //   921: aload 29
    //   923: astore 30
    //   925: aload 10
    //   927: astore 24
    //   929: aload 30
    //   931: astore 31
    //   933: goto -360 -> 573
    //
    // Exception table:
    //   from	to	target	type
    //   177	225	344	bsh/EvalError
    //   225	243	344	bsh/EvalError
    //   277	337	344	bsh/EvalError
    //   177	225	349	bsh/TargetError
    //   225	243	349	bsh/TargetError
    //   277	337	349	bsh/TargetError
    //   116	166	354	bsh/TokenMgrError
    //   166	177	354	bsh/TokenMgrError
    //   177	225	354	bsh/TokenMgrError
    //   225	243	354	bsh/TokenMgrError
    //   277	337	354	bsh/TokenMgrError
    //   116	166	359	java/lang/Exception
    //   166	177	359	java/lang/Exception
    //   177	225	359	java/lang/Exception
    //   225	243	359	java/lang/Exception
    //   277	337	359	java/lang/Exception
    //   116	166	364	bsh/EvalError
    //   166	177	364	bsh/EvalError
    //   116	166	369	bsh/TargetError
    //   166	177	369	bsh/TargetError
    //   116	166	374	bsh/InterpreterError
    //   166	177	374	bsh/InterpreterError
    //   177	225	374	bsh/InterpreterError
    //   225	243	374	bsh/InterpreterError
    //   277	337	374	bsh/InterpreterError
    //   92	116	414	bsh/EvalError
    //   92	116	419	bsh/TargetError
    //   85	92	424	finally
    //   92	116	424	finally
    //   116	166	424	finally
    //   166	177	424	finally
    //   177	225	424	finally
    //   225	243	424	finally
    //   277	337	424	finally
    //   438	500	424	finally
    //   500	511	424	finally
    //   511	573	424	finally
    //   573	584	424	finally
    //   584	599	424	finally
    //   599	634	424	finally
    //   675	690	424	finally
    //   690	725	424	finally
    //   773	840	424	finally
    //   842	860	424	finally
    //   860	869	424	finally
    //   85	92	429	bsh/TokenMgrError
    //   92	116	429	bsh/TokenMgrError
    //   85	92	654	bsh/TargetError
    //   85	92	764	bsh/InterpreterError
    //   92	116	764	bsh/InterpreterError
    //   85	92	840	bsh/ParseException
    //   92	116	840	bsh/ParseException
    //   116	166	840	bsh/ParseException
    //   166	177	840	bsh/ParseException
    //   177	225	840	bsh/ParseException
    //   225	243	840	bsh/ParseException
    //   277	337	840	bsh/ParseException
    //   85	92	900	java/lang/Exception
    //   92	116	900	java/lang/Exception
    //   85	92	912	bsh/EvalError
  }

  public Object eval(String paramString)
  {
    if (DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("eval(String): ");
      localStringBuffer.append(paramString);
      debug(localStringBuffer.toString());
    }
    return eval(paramString, this.e);
  }

  public Object eval(String paramString, NameSpace paramNameSpace)
  {
    if (!paramString.endsWith(";"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(paramString);
      localStringBuffer1.append(";");
      paramString = localStringBuffer1.toString();
    }
    StringReader localStringReader = new StringReader(paramString);
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append("inline evaluation of: ``");
    localStringBuffer2.append(c(paramString));
    localStringBuffer2.append("''");
    return eval(localStringReader, paramNameSpace, localStringBuffer2.toString());
  }

  public Object get(String paramString)
  {
    try
    {
      Object localObject = Primitive.unwrap(this.e.get(paramString, this));
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(SimpleNode.JAVACODE, new CallStack());
    }
  }

  public BshClassManager getClassManager()
  {
    return getNameSpace().getClassManager();
  }

  public PrintStream getErr()
  {
    return this.h;
  }

  public Reader getIn()
  {
    return this.f;
  }

  public Object getInterface(Class paramClass)
  {
    try
    {
      Object localObject = this.e.a(this).getInterface(paramClass);
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(SimpleNode.JAVACODE, new CallStack());
    }
  }

  public NameSpace getNameSpace()
  {
    return this.e;
  }

  public PrintStream getOut()
  {
    return this.g;
  }

  public Interpreter getParent()
  {
    return this.j;
  }

  public boolean getShowResults()
  {
    return this.q;
  }

  public String getSourceFileInfo()
  {
    if (this.k != null)
      return this.k;
    return "<unknown source>";
  }

  public boolean getStrictJava()
  {
    return this.o;
  }

  public File pathToFile(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.isAbsolute())
    {
      String str = (String)a("bsh.cwd");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append(File.separator);
      localStringBuffer.append(paramString);
      localFile = new File(localStringBuffer.toString());
    }
    return new File(localFile.getCanonicalPath());
  }

  public final void print(Object paramObject)
  {
    if (this.i != null)
    {
      this.i.print(paramObject);
      return;
    }
    this.g.print(paramObject);
    this.g.flush();
  }

  public final void println(Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf(paramObject));
    localStringBuffer.append(b);
    print(localStringBuffer.toString());
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	bsh/Interpreter:l	Z
    //   4: ifeq +14 -> 18
    //   7: new 635	java/lang/RuntimeException
    //   10: dup
    //   11: ldc_w 637
    //   14: invokespecial 638	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: getfield 128	bsh/Interpreter:m	Z
    //   22: ifeq +21 -> 43
    //   25: aload_0
    //   26: ldc_w 640
    //   29: invokevirtual 309	bsh/Interpreter:eval	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: pop
    //   33: goto +10 -> 43
    //   36: aload_0
    //   37: ldc_w 642
    //   40: invokevirtual 498	bsh/Interpreter:println	(Ljava/lang/Object;)V
    //   43: new 472	bsh/CallStack
    //   46: dup
    //   47: aload_0
    //   48: getfield 156	bsh/Interpreter:e	Lbsh/NameSpace;
    //   51: invokespecial 475	bsh/CallStack:<init>	(Lbsh/NameSpace;)V
    //   54: astore_1
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: ifeq +22 -> 80
    //   61: aload_0
    //   62: getfield 128	bsh/Interpreter:m	Z
    //   65: ifeq +14 -> 79
    //   68: aload_0
    //   69: getfield 109	bsh/Interpreter:p	Z
    //   72: ifeq +7 -> 79
    //   75: iconst_0
    //   76: invokestatic 646	java/lang/System:exit	(I)V
    //   79: return
    //   80: getstatic 63	java/lang/System:out	Ljava/io/PrintStream;
    //   83: invokevirtual 458	java/io/PrintStream:flush	()V
    //   86: getstatic 66	java/lang/System:err	Ljava/io/PrintStream;
    //   89: invokevirtual 458	java/io/PrintStream:flush	()V
    //   92: invokestatic 651	java/lang/Thread:yield	()V
    //   95: aload_0
    //   96: getfield 128	bsh/Interpreter:m	Z
    //   99: ifeq +11 -> 110
    //   102: aload_0
    //   103: aload_0
    //   104: invokespecial 653	bsh/Interpreter:f	()Ljava/lang/String;
    //   107: invokevirtual 633	bsh/Interpreter:print	(Ljava/lang/Object;)V
    //   110: aload_0
    //   111: invokespecial 477	bsh/Interpreter:e	()Z
    //   114: istore 4
    //   116: aload_0
    //   117: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   120: invokevirtual 483	bsh/JJTParserState:d	()I
    //   123: ifle +170 -> 293
    //   126: aload_0
    //   127: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   130: invokevirtual 486	bsh/JJTParserState:b	()Lbsh/Node;
    //   133: checkcast 488	bsh/SimpleNode
    //   136: astore 43
    //   138: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   141: ifeq +11 -> 152
    //   144: aload 43
    //   146: ldc_w 533
    //   149: invokevirtual 656	bsh/SimpleNode:dump	(Ljava/lang/String;)V
    //   152: aload 43
    //   154: aload_1
    //   155: aload_0
    //   156: invokevirtual 501	bsh/SimpleNode:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   159: astore 44
    //   161: aload_1
    //   162: invokevirtual 504	bsh/CallStack:depth	()I
    //   165: iconst_1
    //   166: if_icmple +41 -> 207
    //   169: new 171	java/lang/StringBuffer
    //   172: dup
    //   173: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   176: astore 45
    //   178: aload 45
    //   180: ldc_w 506
    //   183: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: aload 45
    //   189: aload_1
    //   190: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   193: pop
    //   194: new 432	bsh/InterpreterError
    //   197: dup
    //   198: aload 45
    //   200: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   203: invokespecial 433	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   206: athrow
    //   207: aload 44
    //   209: instanceof 508
    //   212: ifeq +13 -> 225
    //   215: aload 44
    //   217: checkcast 508	bsh/ReturnControl
    //   220: getfield 512	bsh/ReturnControl:value	Ljava/lang/Object;
    //   223: astore 44
    //   225: aload 44
    //   227: getstatic 529	bsh/Primitive:VOID	Lbsh/Primitive;
    //   230: if_acmpeq +63 -> 293
    //   233: aload_0
    //   234: ldc_w 658
    //   237: aload 44
    //   239: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   242: aload_0
    //   243: getfield 525	bsh/Interpreter:q	Z
    //   246: ifeq +47 -> 293
    //   249: new 171	java/lang/StringBuffer
    //   252: dup
    //   253: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   256: astore 48
    //   258: aload 48
    //   260: ldc_w 531
    //   263: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   266: pop
    //   267: aload 48
    //   269: aload 44
    //   271: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   274: pop
    //   275: aload 48
    //   277: ldc_w 533
    //   280: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   283: pop
    //   284: aload_0
    //   285: aload 48
    //   287: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   290: invokevirtual 498	bsh/Interpreter:println	(Ljava/lang/Object;)V
    //   293: aload_0
    //   294: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   297: invokevirtual 513	bsh/JJTParserState:a	()V
    //   300: aload_1
    //   301: invokevirtual 504	bsh/CallStack:depth	()I
    //   304: iconst_1
    //   305: if_icmple +15 -> 320
    //   308: aload_1
    //   309: invokevirtual 516	bsh/CallStack:clear	()V
    //   312: aload_1
    //   313: aload_0
    //   314: getfield 156	bsh/Interpreter:e	Lbsh/NameSpace;
    //   317: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   320: iload 4
    //   322: istore_2
    //   323: goto -266 -> 57
    //   326: astore 38
    //   328: goto +42 -> 370
    //   331: astore 32
    //   333: goto +141 -> 474
    //   336: astore 22
    //   338: goto +228 -> 566
    //   341: astore 17
    //   343: goto +371 -> 714
    //   346: astore 11
    //   348: goto +470 -> 818
    //   351: astore 5
    //   353: goto +552 -> 905
    //   356: astore 9
    //   358: goto +640 -> 998
    //   361: astore 37
    //   363: iload_2
    //   364: istore 4
    //   366: aload 37
    //   368: astore 38
    //   370: new 171	java/lang/StringBuffer
    //   373: dup
    //   374: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   377: astore 39
    //   379: aload 39
    //   381: ldc_w 660
    //   384: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   387: pop
    //   388: aload 39
    //   390: aload 38
    //   392: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   395: pop
    //   396: aload_0
    //   397: aload 39
    //   399: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   402: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   405: aload_0
    //   406: getfield 116	bsh/Interpreter:d	Lbsh/Parser;
    //   409: aload_0
    //   410: getfield 122	bsh/Interpreter:f	Ljava/io/Reader;
    //   413: invokevirtual 662	bsh/Parser:b	(Ljava/io/Reader;)V
    //   416: aload_0
    //   417: getfield 128	bsh/Interpreter:m	Z
    //   420: istore 42
    //   422: iload 42
    //   424: ifne +8 -> 432
    //   427: iconst_1
    //   428: istore_2
    //   429: goto +6 -> 435
    //   432: iload 4
    //   434: istore_2
    //   435: aload_0
    //   436: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   439: invokevirtual 513	bsh/JJTParserState:a	()V
    //   442: aload_1
    //   443: invokevirtual 504	bsh/CallStack:depth	()I
    //   446: iconst_1
    //   447: if_icmple -390 -> 57
    //   450: aload_1
    //   451: invokevirtual 516	bsh/CallStack:clear	()V
    //   454: aload_1
    //   455: aload_0
    //   456: getfield 156	bsh/Interpreter:e	Lbsh/NameSpace;
    //   459: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   462: goto -405 -> 57
    //   465: astore 31
    //   467: iload_2
    //   468: istore 4
    //   470: aload 31
    //   472: astore 32
    //   474: new 171	java/lang/StringBuffer
    //   477: dup
    //   478: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   481: astore 33
    //   483: aload 33
    //   485: ldc_w 664
    //   488: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   491: pop
    //   492: aload 33
    //   494: aload 32
    //   496: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   499: pop
    //   500: aload_0
    //   501: aload 33
    //   503: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   506: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   509: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   512: ifeq +8 -> 520
    //   515: aload 32
    //   517: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: getfield 128	bsh/Interpreter:m	Z
    //   524: istore 36
    //   526: iload 36
    //   528: ifne +8 -> 536
    //   531: iconst_1
    //   532: istore_2
    //   533: goto +6 -> 539
    //   536: iload 4
    //   538: istore_2
    //   539: aload_0
    //   540: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   543: invokevirtual 513	bsh/JJTParserState:a	()V
    //   546: aload_1
    //   547: invokevirtual 504	bsh/CallStack:depth	()I
    //   550: iconst_1
    //   551: if_icmple -494 -> 57
    //   554: goto -104 -> 450
    //   557: astore 21
    //   559: iload_2
    //   560: istore 4
    //   562: aload 21
    //   564: astore 22
    //   566: aload_0
    //   567: getfield 128	bsh/Interpreter:m	Z
    //   570: ifeq +48 -> 618
    //   573: new 171	java/lang/StringBuffer
    //   576: dup
    //   577: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   580: astore 23
    //   582: aload 23
    //   584: ldc_w 666
    //   587: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   590: pop
    //   591: aload 23
    //   593: aload 22
    //   595: invokevirtual 667	bsh/EvalError:toString	()Ljava/lang/String;
    //   598: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   601: pop
    //   602: aload 23
    //   604: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   607: astore 26
    //   609: aload_0
    //   610: aload 26
    //   612: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   615: goto +42 -> 657
    //   618: new 171	java/lang/StringBuffer
    //   621: dup
    //   622: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   625: astore 28
    //   627: aload 28
    //   629: ldc_w 666
    //   632: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   635: pop
    //   636: aload 28
    //   638: aload 22
    //   640: invokevirtual 668	bsh/EvalError:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   646: pop
    //   647: aload 28
    //   649: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   652: astore 26
    //   654: goto -45 -> 609
    //   657: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   660: ifeq +8 -> 668
    //   663: aload 22
    //   665: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   668: aload_0
    //   669: getfield 128	bsh/Interpreter:m	Z
    //   672: istore 27
    //   674: iload 27
    //   676: ifne +8 -> 684
    //   679: iconst_1
    //   680: istore_2
    //   681: goto +6 -> 687
    //   684: iload 4
    //   686: istore_2
    //   687: aload_0
    //   688: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   691: invokevirtual 513	bsh/JJTParserState:a	()V
    //   694: aload_1
    //   695: invokevirtual 504	bsh/CallStack:depth	()I
    //   698: iconst_1
    //   699: if_icmple -642 -> 57
    //   702: goto -252 -> 450
    //   705: astore 16
    //   707: iload_2
    //   708: istore 4
    //   710: aload 16
    //   712: astore 17
    //   714: new 171	java/lang/StringBuffer
    //   717: dup
    //   718: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   721: astore 18
    //   723: aload 18
    //   725: ldc_w 670
    //   728: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   731: pop
    //   732: aload 18
    //   734: aload 17
    //   736: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   739: pop
    //   740: aload_0
    //   741: aload 18
    //   743: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   746: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   749: aload 17
    //   751: invokevirtual 373	bsh/TargetError:inNativeCode	()Z
    //   754: ifeq +15 -> 769
    //   757: aload 17
    //   759: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   762: aload_0
    //   763: getfield 126	bsh/Interpreter:h	Ljava/io/PrintStream;
    //   766: invokevirtual 377	bsh/TargetError:printStackTrace	(ZLjava/io/PrintStream;)V
    //   769: aload_0
    //   770: getfield 128	bsh/Interpreter:m	Z
    //   773: ifne +6 -> 779
    //   776: iconst_1
    //   777: istore 4
    //   779: aload_0
    //   780: ldc_w 672
    //   783: aload 17
    //   785: invokevirtual 675	bsh/TargetError:getTarget	()Ljava/lang/Throwable;
    //   788: invokevirtual 81	bsh/Interpreter:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   791: aload_0
    //   792: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   795: invokevirtual 513	bsh/JJTParserState:a	()V
    //   798: aload_1
    //   799: invokevirtual 504	bsh/CallStack:depth	()I
    //   802: iconst_1
    //   803: if_icmple -483 -> 320
    //   806: goto -498 -> 308
    //   809: astore 10
    //   811: iload_2
    //   812: istore 4
    //   814: aload 10
    //   816: astore 11
    //   818: new 171	java/lang/StringBuffer
    //   821: dup
    //   822: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   825: astore 12
    //   827: aload 12
    //   829: ldc_w 677
    //   832: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   835: pop
    //   836: aload 12
    //   838: aload 11
    //   840: invokevirtual 564	bsh/InterpreterError:getMessage	()Ljava/lang/String;
    //   843: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   846: pop
    //   847: aload_0
    //   848: aload 12
    //   850: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   853: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   856: aload 11
    //   858: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   861: aload_0
    //   862: getfield 128	bsh/Interpreter:m	Z
    //   865: istore 15
    //   867: iload 15
    //   869: ifne +8 -> 877
    //   872: iconst_1
    //   873: istore_2
    //   874: goto +6 -> 880
    //   877: iload 4
    //   879: istore_2
    //   880: aload_0
    //   881: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   884: invokevirtual 513	bsh/JJTParserState:a	()V
    //   887: aload_1
    //   888: invokevirtual 504	bsh/CallStack:depth	()I
    //   891: iconst_1
    //   892: if_icmple -835 -> 57
    //   895: goto -445 -> 450
    //   898: astore_3
    //   899: iload_2
    //   900: istore 4
    //   902: aload_3
    //   903: astore 5
    //   905: new 171	java/lang/StringBuffer
    //   908: dup
    //   909: invokespecial 172	java/lang/StringBuffer:<init>	()V
    //   912: astore 6
    //   914: aload 6
    //   916: ldc_w 679
    //   919: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   922: pop
    //   923: aload 6
    //   925: aload 5
    //   927: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   930: invokevirtual 567	bsh/ParseException:getMessage	(Z)Ljava/lang/String;
    //   933: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   936: pop
    //   937: aload_0
    //   938: aload 6
    //   940: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   943: invokevirtual 568	bsh/Interpreter:error	(Ljava/lang/Object;)V
    //   946: getstatic 169	bsh/Interpreter:DEBUG	Z
    //   949: ifeq +8 -> 957
    //   952: aload 5
    //   954: invokestatic 546	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   957: aload_0
    //   958: getfield 128	bsh/Interpreter:m	Z
    //   961: ifne +67 -> 1028
    //   964: iconst_1
    //   965: istore_2
    //   966: goto +3 -> 969
    //   969: aload_0
    //   970: getfield 116	bsh/Interpreter:d	Lbsh/Parser;
    //   973: aload_0
    //   974: getfield 122	bsh/Interpreter:f	Ljava/io/Reader;
    //   977: invokevirtual 681	bsh/Parser:a	(Ljava/io/Reader;)V
    //   980: aload_0
    //   981: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   984: invokevirtual 513	bsh/JJTParserState:a	()V
    //   987: aload_1
    //   988: invokevirtual 504	bsh/CallStack:depth	()I
    //   991: iconst_1
    //   992: if_icmple -935 -> 57
    //   995: goto -545 -> 450
    //   998: aload_0
    //   999: invokespecial 479	bsh/Interpreter:d	()Lbsh/JJTParserState;
    //   1002: invokevirtual 513	bsh/JJTParserState:a	()V
    //   1005: aload_1
    //   1006: invokevirtual 504	bsh/CallStack:depth	()I
    //   1009: iconst_1
    //   1010: if_icmple +15 -> 1025
    //   1013: aload_1
    //   1014: invokevirtual 516	bsh/CallStack:clear	()V
    //   1017: aload_1
    //   1018: aload_0
    //   1019: getfield 156	bsh/Interpreter:e	Lbsh/NameSpace;
    //   1022: invokevirtual 519	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   1025: aload 9
    //   1027: athrow
    //   1028: iload 4
    //   1030: istore_2
    //   1031: goto -62 -> 969
    //
    // Exception table:
    //   from	to	target	type
    //   25	33	36	bsh/EvalError
    //   116	152	326	bsh/TokenMgrError
    //   152	207	326	bsh/TokenMgrError
    //   207	225	326	bsh/TokenMgrError
    //   225	293	326	bsh/TokenMgrError
    //   116	152	331	java/lang/Exception
    //   152	207	331	java/lang/Exception
    //   207	225	331	java/lang/Exception
    //   225	293	331	java/lang/Exception
    //   116	152	336	bsh/EvalError
    //   152	207	336	bsh/EvalError
    //   207	225	336	bsh/EvalError
    //   225	293	336	bsh/EvalError
    //   116	152	341	bsh/TargetError
    //   152	207	341	bsh/TargetError
    //   207	225	341	bsh/TargetError
    //   225	293	341	bsh/TargetError
    //   116	152	346	bsh/InterpreterError
    //   152	207	346	bsh/InterpreterError
    //   207	225	346	bsh/InterpreterError
    //   225	293	346	bsh/InterpreterError
    //   116	152	351	bsh/ParseException
    //   152	207	351	bsh/ParseException
    //   207	225	351	bsh/ParseException
    //   225	293	351	bsh/ParseException
    //   80	110	356	finally
    //   110	116	356	finally
    //   116	152	356	finally
    //   152	207	356	finally
    //   207	225	356	finally
    //   225	293	356	finally
    //   370	422	356	finally
    //   474	520	356	finally
    //   520	526	356	finally
    //   566	609	356	finally
    //   609	615	356	finally
    //   618	654	356	finally
    //   657	668	356	finally
    //   668	674	356	finally
    //   714	769	356	finally
    //   769	776	356	finally
    //   779	791	356	finally
    //   818	867	356	finally
    //   905	957	356	finally
    //   957	964	356	finally
    //   969	980	356	finally
    //   80	110	361	bsh/TokenMgrError
    //   110	116	361	bsh/TokenMgrError
    //   80	110	465	java/lang/Exception
    //   110	116	465	java/lang/Exception
    //   80	110	557	bsh/EvalError
    //   110	116	557	bsh/EvalError
    //   80	110	705	bsh/TargetError
    //   110	116	705	bsh/TargetError
    //   80	110	809	bsh/InterpreterError
    //   110	116	809	bsh/InterpreterError
    //   80	110	898	bsh/ParseException
    //   110	116	898	bsh/ParseException
  }

  public void set(String paramString, double paramDouble)
  {
    set(paramString, new Primitive(paramDouble));
  }

  public void set(String paramString, float paramFloat)
  {
    set(paramString, new Primitive(paramFloat));
  }

  public void set(String paramString, int paramInt)
  {
    set(paramString, new Primitive(paramInt));
  }

  public void set(String paramString, long paramLong)
  {
    set(paramString, new Primitive(paramLong));
  }

  public void set(String paramString, Object paramObject)
  {
    if (paramObject == null)
      paramObject = Primitive.NULL;
    CallStack localCallStack = new CallStack();
    try
    {
      if (Name.isCompound(paramString))
      {
        this.e.b(paramString).toLHS(localCallStack, this).assign(paramObject, false);
        return;
      }
      this.e.setVariable(paramString, paramObject, false);
      return;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(SimpleNode.JAVACODE, localCallStack);
    }
  }

  public void set(String paramString, boolean paramBoolean)
  {
    set(paramString, new Primitive(paramBoolean));
  }

  public void setClassLoader(ClassLoader paramClassLoader)
  {
    getClassManager().setClassLoader(paramClassLoader);
  }

  public void setConsole(ConsoleInterface paramConsoleInterface)
  {
    this.i = paramConsoleInterface;
    a("bsh.console", paramConsoleInterface);
    setOut(paramConsoleInterface.getOut());
    setErr(paramConsoleInterface.getErr());
  }

  public void setErr(PrintStream paramPrintStream)
  {
    this.h = paramPrintStream;
  }

  public void setExitOnEOF(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setNameSpace(NameSpace paramNameSpace)
  {
    this.e = paramNameSpace;
  }

  public void setOut(PrintStream paramPrintStream)
  {
    this.g = paramPrintStream;
  }

  public void setShowResults(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public void setStrictJava(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public Object source(String paramString)
  {
    return source(paramString, this.e);
  }

  public Object source(String paramString, NameSpace paramNameSpace)
  {
    File localFile = pathToFile(paramString);
    if (DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Sourcing file: ");
      localStringBuffer.append(localFile);
      debug(localStringBuffer.toString());
    }
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
    try
    {
      Object localObject2 = eval(localBufferedReader, paramNameSpace, paramString);
      return localObject2;
    }
    finally
    {
      localBufferedReader.close();
    }
  }

  public void unset(String paramString)
  {
    CallStack localCallStack = new CallStack();
    try
    {
      LHS localLHS = this.e.b(paramString).toLHS(localCallStack, this);
      if (localLHS.c != 0)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Can't unset, not a variable: ");
        localStringBuffer.append(paramString);
        throw new EvalError(localStringBuffer.toString(), SimpleNode.JAVACODE, new CallStack());
      }
      localLHS.a.unsetVariable(paramString);
      return;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw new EvalError(localUtilEvalError.getMessage(), SimpleNode.JAVACODE, new CallStack());
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Interpreter
 * JD-Core Version:    0.6.2
 */