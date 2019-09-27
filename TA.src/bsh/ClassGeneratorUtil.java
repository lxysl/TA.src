package bsh;

import bsh.org.objectweb.asm.ClassWriter;
import bsh.org.objectweb.asm.CodeVisitor;
import bsh.org.objectweb.asm.Constants;
import bsh.org.objectweb.asm.Label;
import bsh.org.objectweb.asm.Type;
import com.a.a.a.a.a.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassGeneratorUtil
  implements Constants
{
  static Class m;
  static Class n;
  static Class o;
  static Class p;
  static Class q;
  static Class r;
  String a;
  String b;
  Class c;
  String d;
  Class[] e;
  Variable[] f;
  Constructor[] g;
  DelayedEvalBshMethod[] h;
  DelayedEvalBshMethod[] i;
  NameSpace j;
  Modifiers k;
  boolean l;

  // ERROR //
  public ClassGeneratorUtil(Modifiers paramModifiers, String paramString1, String paramString2, Class paramClass, Class[] paramArrayOfClass, Variable[] paramArrayOfVariable, DelayedEvalBshMethod[] paramArrayOfDelayedEvalBshMethod, NameSpace paramNameSpace, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 42	bsh/ClassGeneratorUtil:k	Lbsh/Modifiers;
    //   9: aload_0
    //   10: aload_2
    //   11: putfield 44	bsh/ClassGeneratorUtil:a	Ljava/lang/String;
    //   14: aload_3
    //   15: ifnull +53 -> 68
    //   18: new 46	java/lang/StringBuffer
    //   21: dup
    //   22: invokespecial 47	java/lang/StringBuffer:<init>	()V
    //   25: astore 10
    //   27: aload 10
    //   29: aload_3
    //   30: bipush 46
    //   32: bipush 47
    //   34: invokevirtual 53	java/lang/String:replace	(CC)Ljava/lang/String;
    //   37: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   40: pop
    //   41: aload 10
    //   43: ldc 59
    //   45: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   48: pop
    //   49: aload 10
    //   51: aload_2
    //   52: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: aload_0
    //   57: aload 10
    //   59: invokevirtual 63	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   62: putfield 65	bsh/ClassGeneratorUtil:b	Ljava/lang/String;
    //   65: goto +8 -> 73
    //   68: aload_0
    //   69: aload_2
    //   70: putfield 65	bsh/ClassGeneratorUtil:b	Ljava/lang/String;
    //   73: aload 4
    //   75: ifnonnull +36 -> 111
    //   78: getstatic 67	bsh/ClassGeneratorUtil:m	Ljava/lang/Class;
    //   81: ifnonnull +22 -> 103
    //   84: ldc 69
    //   86: invokestatic 72	bsh/ClassGeneratorUtil:a	(Ljava/lang/String;)Ljava/lang/Class;
    //   89: astore 20
    //   91: aload 20
    //   93: putstatic 67	bsh/ClassGeneratorUtil:m	Ljava/lang/Class;
    //   96: aload 20
    //   98: astore 4
    //   100: goto +11 -> 111
    //   103: getstatic 67	bsh/ClassGeneratorUtil:m	Ljava/lang/Class;
    //   106: astore 20
    //   108: goto -12 -> 96
    //   111: aload_0
    //   112: aload 4
    //   114: putfield 74	bsh/ClassGeneratorUtil:c	Ljava/lang/Class;
    //   117: aload_0
    //   118: aload 4
    //   120: invokestatic 80	bsh/org/objectweb/asm/Type:getInternalName	(Ljava/lang/Class;)Ljava/lang/String;
    //   123: putfield 82	bsh/ClassGeneratorUtil:d	Ljava/lang/String;
    //   126: aload 5
    //   128: ifnonnull +9 -> 137
    //   131: iconst_0
    //   132: anewarray 84	java/lang/Class
    //   135: astore 5
    //   137: aload_0
    //   138: aload 5
    //   140: putfield 86	bsh/ClassGeneratorUtil:e	[Ljava/lang/Class;
    //   143: aload_0
    //   144: aload 6
    //   146: putfield 88	bsh/ClassGeneratorUtil:f	[Lbsh/Variable;
    //   149: aload_0
    //   150: aload 8
    //   152: putfield 90	bsh/ClassGeneratorUtil:j	Lbsh/NameSpace;
    //   155: aload_0
    //   156: aload 4
    //   158: invokevirtual 94	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
    //   161: putfield 96	bsh/ClassGeneratorUtil:g	[Ljava/lang/reflect/Constructor;
    //   164: new 98	java/util/ArrayList
    //   167: dup
    //   168: invokespecial 99	java/util/ArrayList:<init>	()V
    //   171: astore 14
    //   173: new 98	java/util/ArrayList
    //   176: dup
    //   177: invokespecial 99	java/util/ArrayList:<init>	()V
    //   180: astore 15
    //   182: aload_2
    //   183: invokestatic 102	bsh/ClassGeneratorUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 16
    //   188: iconst_0
    //   189: istore 17
    //   191: iload 17
    //   193: aload 7
    //   195: arraylength
    //   196: if_icmplt +68 -> 264
    //   199: aload_0
    //   200: aload 14
    //   202: iconst_0
    //   203: anewarray 104	bsh/DelayedEvalBshMethod
    //   206: invokeinterface 110 2 0
    //   211: checkcast 111	[Lbsh/DelayedEvalBshMethod;
    //   214: putfield 113	bsh/ClassGeneratorUtil:h	[Lbsh/DelayedEvalBshMethod;
    //   217: aload_0
    //   218: aload 15
    //   220: iconst_0
    //   221: anewarray 104	bsh/DelayedEvalBshMethod
    //   224: invokeinterface 110 2 0
    //   229: checkcast 111	[Lbsh/DelayedEvalBshMethod;
    //   232: putfield 115	bsh/ClassGeneratorUtil:i	[Lbsh/DelayedEvalBshMethod;
    //   235: aload 8
    //   237: ldc 117
    //   239: aload_0
    //   240: getfield 113	bsh/ClassGeneratorUtil:h	[Lbsh/DelayedEvalBshMethod;
    //   243: iconst_0
    //   244: invokevirtual 122	bsh/NameSpace:a	(Ljava/lang/String;Ljava/lang/Object;Z)V
    //   247: aload_0
    //   248: iload 9
    //   250: putfield 124	bsh/ClassGeneratorUtil:l	Z
    //   253: return
    //   254: new 126	bsh/InterpreterError
    //   257: dup
    //   258: ldc 128
    //   260: invokespecial 131	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   263: athrow
    //   264: aload 7
    //   266: iload 17
    //   268: aaload
    //   269: invokevirtual 134	bsh/DelayedEvalBshMethod:getName	()Ljava/lang/String;
    //   272: aload 16
    //   274: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq +19 -> 296
    //   280: aload 14
    //   282: aload 7
    //   284: iload 17
    //   286: aaload
    //   287: invokeinterface 141 2 0
    //   292: pop
    //   293: goto +16 -> 309
    //   296: aload 15
    //   298: aload 7
    //   300: iload 17
    //   302: aaload
    //   303: invokeinterface 141 2 0
    //   308: pop
    //   309: iinc 17 1
    //   312: goto -121 -> 191
    //
    // Exception table:
    //   from	to	target	type
    //   235	247	254	bsh/UtilEvalError
  }

  static int a(Modifiers paramModifiers)
  {
    if (paramModifiers == null)
      return 0;
    boolean bool = paramModifiers.hasModifier("public");
    int i1 = 0;
    if (bool)
      i1 = 1;
    if (paramModifiers.hasModifier("protected"))
      i1 += 4;
    if (paramModifiers.hasModifier("static"))
      i1 += 8;
    if (paramModifiers.hasModifier("synchronized"))
      i1 += 32;
    if (paramModifiers.hasModifier("abstract"))
      i1 += 1024;
    return i1;
  }

  static This a(Class paramClass, String paramString)
  {
    try
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("_bshStatic");
      localStringBuffer1.append(paramString);
      This localThis = (This)Reflect.getStaticFieldValue(paramClass, localStringBuffer1.toString());
      return localThis;
    }
    catch (Exception localException)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("Unable to get class static space: ");
      localStringBuffer2.append(localException);
      throw new InterpreterError(localStringBuffer2.toString());
    }
  }

  static This a(Object paramObject, String paramString)
  {
    try
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("_bshThis");
      localStringBuffer1.append(paramString);
      This localThis = (This)Primitive.unwrap(Reflect.getObjectFieldValue(paramObject, localStringBuffer1.toString()));
      return localThis;
    }
    catch (Exception localException)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("Generated class: Error getting This");
      localStringBuffer2.append(localException);
      throw new InterpreterError(localStringBuffer2.toString());
    }
  }

  static Class a(String paramString)
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

  static String a(String paramString, String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer("(");
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramArrayOfString.length)
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append(")");
        localStringBuffer2.append(paramString);
        localStringBuffer1.append(localStringBuffer2.toString());
        return localStringBuffer1.toString();
      }
      localStringBuffer1.append(paramArrayOfString[i1]);
    }
  }

  static void a(int paramInt1, String paramString, String[] paramArrayOfString, Label paramLabel, Label[] paramArrayOfLabel, int paramInt2, CodeVisitor paramCodeVisitor)
  {
    paramCodeVisitor.visitLabel(paramArrayOfLabel[paramInt1]);
    int i1 = 0;
    paramCodeVisitor.visitVarInsn(25, 0);
    while (true)
    {
      if (i1 >= paramArrayOfString.length)
      {
        paramCodeVisitor.visitMethodInsn(183, paramString, "<init>", a("V", paramArrayOfString));
        paramCodeVisitor.visitJumpInsn(167, paramLabel);
        return;
      }
      String str1 = paramArrayOfString[i1];
      String str2;
      if (str1.equals("Z"))
        str2 = "getBoolean";
      else if (str1.equals("B"))
        str2 = "getByte";
      else if (str1.equals("C"))
        str2 = "getChar";
      else if (str1.equals("S"))
        str2 = "getShort";
      else if (str1.equals("I"))
        str2 = "getInt";
      else if (str1.equals("J"))
        str2 = "getLong";
      else if (str1.equals("D"))
        str2 = "getDouble";
      else if (str1.equals("F"))
        str2 = "getFloat";
      else
        str2 = "getObject";
      paramCodeVisitor.visitVarInsn(25, paramInt2);
      String str3;
      if (str2.equals("getObject"))
        str3 = "Ljava/lang/Object;";
      else
        str3 = str1;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("()");
      localStringBuffer.append(str3);
      paramCodeVisitor.visitMethodInsn(182, "bsh/ClassGeneratorUtil$ConstructorArgs", str2, localStringBuffer.toString());
      if (str2.equals("getObject"))
        paramCodeVisitor.visitTypeInsn(192, c(str1));
      i1++;
    }
  }

  static void a(String paramString, CodeVisitor paramCodeVisitor)
  {
    if (paramString.equals("V"));
    for (int i1 = 177; ; i1 = 176)
    {
      paramCodeVisitor.visitInsn(i1);
      return;
      if (b(paramString))
      {
        int i2 = 172;
        if (paramString.equals("D"))
          i2 = 175;
        else if (paramString.equals("F"))
          i2 = 174;
        else if (paramString.equals("J"))
          i2 = 173;
        paramCodeVisitor.visitInsn(i2);
        return;
      }
      paramCodeVisitor.visitTypeInsn(192, c(paramString));
    }
  }

  static void a(String paramString1, String paramString2, int paramInt, ClassWriter paramClassWriter)
  {
    paramClassWriter.visitField(paramInt, paramString1, paramString2, null);
  }

  static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, int paramInt, ClassWriter paramClassWriter)
  {
    boolean bool;
    if ((paramInt & 0x8) != 0)
      bool = true;
    else
      bool = false;
    if (paramString4 == null)
      paramString4 = "Ljava/lang/Object;";
    CodeVisitor localCodeVisitor = paramClassWriter.visitMethod(paramInt, paramString3, a(paramString4, paramArrayOfString), null);
    if ((paramInt & 0x400) != 0)
      return;
    int i1;
    StringBuffer localStringBuffer;
    if (bool)
    {
      i1 = 178;
      localStringBuffer = new StringBuffer();
    }
    for (String str = "_bshStatic"; ; str = "_bshThis")
    {
      localStringBuffer.append(str);
      localStringBuffer.append(paramString1);
      localCodeVisitor.visitFieldInsn(i1, paramString2, localStringBuffer.toString(), "Lbsh/This;");
      break;
      localCodeVisitor.visitVarInsn(25, 0);
      i1 = 180;
      localStringBuffer = new StringBuffer();
    }
    localCodeVisitor.visitLdcInsn(paramString3);
    generateParameterReifierCode(paramArrayOfString, bool, localCodeVisitor);
    localCodeVisitor.visitInsn(1);
    localCodeVisitor.visitInsn(1);
    localCodeVisitor.visitInsn(1);
    localCodeVisitor.visitInsn(4);
    Class localClass1;
    if (m == null)
    {
      localClass1 = a("java.lang.Object");
      m = localClass1;
    }
    else
    {
      localClass1 = m;
    }
    Type localType = Type.getType(localClass1);
    Type[] arrayOfType = new Type[6];
    Class localClass2;
    if (n == null)
    {
      localClass2 = a("java.lang.String");
      n = localClass2;
    }
    else
    {
      localClass2 = n;
    }
    arrayOfType[0] = Type.getType(localClass2);
    Class localClass3;
    if (o == null)
    {
      localClass3 = a("[Ljava.lang.Object;");
      o = localClass3;
    }
    else
    {
      localClass3 = o;
    }
    arrayOfType[1] = Type.getType(localClass3);
    Class localClass4;
    if (p == null)
    {
      localClass4 = a("bsh.Interpreter");
      p = localClass4;
    }
    else
    {
      localClass4 = p;
    }
    arrayOfType[2] = Type.getType(localClass4);
    Class localClass5;
    if (q == null)
    {
      localClass5 = a("bsh.CallStack");
      q = localClass5;
    }
    else
    {
      localClass5 = q;
    }
    arrayOfType[3] = Type.getType(localClass5);
    Class localClass6;
    if (r == null)
    {
      localClass6 = a("bsh.SimpleNode");
      r = localClass6;
    }
    else
    {
      localClass6 = r;
    }
    arrayOfType[4] = Type.getType(localClass6);
    arrayOfType[5] = Type.getType(Boolean.TYPE);
    localCodeVisitor.visitMethodInsn(182, "bsh/This", "invokeMethod", Type.getMethodDescriptor(localType, arrayOfType));
    localCodeVisitor.visitMethodInsn(184, "bsh/Primitive", "unwrap", "(Ljava/lang/Object;)Ljava/lang/Object;");
    generateReturnCode(paramString4, localCodeVisitor);
    localCodeVisitor.visitMaxs(20, 20);
  }

  static void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt, ClassWriter paramClassWriter)
  {
    if (paramString3 == null)
      paramString3 = "Ljava/lang/Object;";
    String str = a(paramString3, paramArrayOfString);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("_bshSuper");
    localStringBuffer.append(paramString2);
    CodeVisitor localCodeVisitor = paramClassWriter.visitMethod(paramInt, localStringBuffer.toString(), str, null);
    int i1 = 0;
    localCodeVisitor.visitVarInsn(25, 0);
    int i2 = 1;
    while (true)
    {
      if (i1 >= paramArrayOfString.length)
      {
        localCodeVisitor.visitMethodInsn(183, paramString1, paramString2, str);
        a(paramString3, localCodeVisitor);
        localCodeVisitor.visitMaxs(20, 20);
        return;
      }
      if (b(paramArrayOfString[i1]))
        localCodeVisitor.visitVarInsn(21, i2);
      else
        localCodeVisitor.visitVarInsn(25, i2);
      int i3;
      if ((!paramArrayOfString[i1].equals("D")) && (!paramArrayOfString[i1].equals("J")))
        i3 = 1;
      else
        i3 = 2;
      i2 += i3;
      i1++;
    }
  }

  static String[] a(Class[] paramArrayOfClass)
  {
    String[] arrayOfString = new String[paramArrayOfClass.length];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfString.length)
        return arrayOfString;
      arrayOfString[i1] = BSHType.getTypeDescriptor(paramArrayOfClass[i1]);
    }
  }

  private static boolean b(String paramString)
  {
    return paramString.length() == 1;
  }

  private static String c(String paramString)
  {
    if (!paramString.startsWith("["))
    {
      if (!paramString.startsWith("L"))
        return paramString;
      paramString = paramString.substring(1, paramString.length() - 1);
    }
    return paramString;
  }

  private static String d(String paramString)
  {
    int i1 = paramString.indexOf("$");
    if (i1 == -1)
      return paramString;
    return paramString.substring(i1 + 1);
  }

  public static void generateParameterReifierCode(String[] paramArrayOfString, boolean paramBoolean, CodeVisitor paramCodeVisitor)
  {
    paramCodeVisitor.visitIntInsn(17, paramArrayOfString.length);
    paramCodeVisitor.visitTypeInsn(189, "java/lang/Object");
    int i1 = paramBoolean ^ true;
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= paramArrayOfString.length)
        return;
      String str = paramArrayOfString[i3];
      paramCodeVisitor.visitInsn(89);
      paramCodeVisitor.visitIntInsn(17, i3);
      if (b(str))
      {
        int i5;
        if (str.equals("F"))
          i5 = 23;
        else if (str.equals("D"))
          i5 = 24;
        else if (str.equals("J"))
          i5 = 22;
        else
          i5 = 21;
        paramCodeVisitor.visitTypeInsn(187, "bsh/Primitive");
        paramCodeVisitor.visitInsn(89);
        paramCodeVisitor.visitVarInsn(i5, i1);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("(");
        localStringBuffer.append(str);
        localStringBuffer.append(")V");
        paramCodeVisitor.visitMethodInsn(183, "bsh/Primitive", "<init>", localStringBuffer.toString());
      }
      else
      {
        paramCodeVisitor.visitVarInsn(25, i1);
      }
      paramCodeVisitor.visitInsn(83);
      int i4;
      if ((!str.equals("D")) && (!str.equals("J")))
        i4 = 1;
      else
        i4 = 2;
      int i2;
      i1 += i4;
    }
  }

  public static void generateReturnCode(String paramString, CodeVisitor paramCodeVisitor)
  {
    if (paramString.equals("V"))
      paramCodeVisitor.visitInsn(87);
    for (int i1 = 177; ; i1 = 176)
    {
      paramCodeVisitor.visitInsn(i1);
      return;
      if (b(paramString))
      {
        int i2 = 172;
        String str1;
        String str2;
        if (paramString.equals("B"))
        {
          str1 = "java/lang/Byte";
          str2 = "byteValue";
        }
        else if (paramString.equals("I"))
        {
          str1 = "java/lang/Integer";
          str2 = "intValue";
        }
        else if (paramString.equals("Z"))
        {
          str1 = "java/lang/Boolean";
          str2 = "booleanValue";
        }
        else if (paramString.equals("D"))
        {
          i2 = 175;
          str1 = "java/lang/Double";
          str2 = "doubleValue";
        }
        else if (paramString.equals("F"))
        {
          i2 = 174;
          str1 = "java/lang/Float";
          str2 = "floatValue";
        }
        else if (paramString.equals("J"))
        {
          i2 = 173;
          str1 = "java/lang/Long";
          str2 = "longValue";
        }
        else if (paramString.equals("C"))
        {
          str1 = "java/lang/Character";
          str2 = "charValue";
        }
        else
        {
          str1 = "java/lang/Short";
          str2 = "shortValue";
        }
        paramCodeVisitor.visitTypeInsn(192, str1);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("()");
        localStringBuffer.append(paramString);
        paramCodeVisitor.visitMethodInsn(182, str1, str2, localStringBuffer.toString());
        paramCodeVisitor.visitInsn(i2);
        return;
      }
      paramCodeVisitor.visitTypeInsn(192, c(paramString));
    }
  }

  public static ConstructorArgs getConstructorArgs(String paramString, This paramThis, Object[] paramArrayOfObject, int paramInt)
  {
    try
    {
      DelayedEvalBshMethod[] arrayOfDelayedEvalBshMethod = (DelayedEvalBshMethod[])paramThis.getNameSpace().getVariable("_bshConstructors");
      int i1 = -1;
      if (paramInt == i1)
        return ConstructorArgs.DEFAULT;
      DelayedEvalBshMethod localDelayedEvalBshMethod = arrayOfDelayedEvalBshMethod[paramInt];
      if (localDelayedEvalBshMethod.c.jjtGetNumChildren() == 0)
        return ConstructorArgs.DEFAULT;
      BSHBlock localBSHBlock = localDelayedEvalBshMethod.c;
      int i2 = 0;
      SimpleNode localSimpleNode = (SimpleNode)localBSHBlock.jjtGetChild(0);
      if ((localSimpleNode instanceof BSHPrimaryExpression))
        localSimpleNode = (SimpleNode)localSimpleNode.jjtGetChild(0);
      if ((localSimpleNode instanceof BSHMethodInvocation))
      {
        BSHMethodInvocation localBSHMethodInvocation = (BSHMethodInvocation)localSimpleNode;
        BSHAmbiguousName localBSHAmbiguousName = localBSHMethodInvocation.a();
        if ((localBSHAmbiguousName.text.equals("super")) || (localBSHAmbiguousName.text.equals("this")))
        {
          str = localBSHAmbiguousName.text;
          localBSHArguments = localBSHMethodInvocation.b();
          break label161;
        }
      }
      BSHArguments localBSHArguments = null;
      String str = null;
      label161: if (str == null)
        return ConstructorArgs.DEFAULT;
      NameSpace localNameSpace = new NameSpace(paramThis.getNameSpace(), "consArgs");
      String[] arrayOfString = localDelayedEvalBshMethod.getParameterNames();
      Class[] arrayOfClass1 = localDelayedEvalBshMethod.getParameterTypes();
      int i3 = 0;
      while (true)
      {
        if (i3 >= paramArrayOfObject.length)
        {
          CallStack localCallStack = new CallStack();
          localCallStack.push(localNameSpace);
          Interpreter localInterpreter = paramThis.b;
          try
          {
            Object[] arrayOfObject1 = localBSHArguments.getArguments(localCallStack, localInterpreter);
            Class[] arrayOfClass2 = Types.getTypes(arrayOfObject1);
            Object[] arrayOfObject2 = Primitive.unwrap(arrayOfObject1);
            Class localClass = localInterpreter.getClassManager().classForName(paramString);
            if (localClass == null)
            {
              StringBuffer localStringBuffer3 = new StringBuffer();
              localStringBuffer3.append("can't find superclass: ");
              localStringBuffer3.append(paramString);
              throw new InterpreterError(localStringBuffer3.toString());
            }
            Constructor[] arrayOfConstructor = localClass.getDeclaredConstructors();
            if (str.equals("super"))
            {
              int i6 = Reflect.b(arrayOfClass2, arrayOfConstructor);
              if (i6 == i1)
                throw new InterpreterError("can't find constructor for args!");
              return new ConstructorArgs(i6, arrayOfObject2);
            }
            Class[][] arrayOfClass; = new Class[arrayOfDelayedEvalBshMethod.length][];
            while (true)
            {
              if (i2 >= arrayOfClass;.length)
              {
                int i4 = Reflect.a(arrayOfClass2, arrayOfClass;);
                if (i4 == i1)
                  throw new InterpreterError("can't find constructor for args 2!");
                int i5 = i4 + arrayOfConstructor.length;
                if (i5 == paramInt + arrayOfConstructor.length)
                  throw new InterpreterError("Recusive constructor call.");
                return new ConstructorArgs(i5, arrayOfObject2);
              }
              arrayOfClass;[i2] = arrayOfDelayedEvalBshMethod[i2].getParameterTypes();
              i2++;
            }
          }
          catch (EvalError localEvalError)
          {
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append("Error evaluating constructor args: ");
            localStringBuffer2.append(localEvalError);
            throw new InterpreterError(localStringBuffer2.toString());
          }
        }
        try
        {
          localNameSpace.setTypedVariable(arrayOfString[i3], arrayOfClass1[i3], paramArrayOfObject[i3], null);
          i3++;
          i1 = -1;
          i2 = 0;
        }
        catch (UtilEvalError localUtilEvalError)
        {
          StringBuffer localStringBuffer4 = new StringBuffer();
          localStringBuffer4.append("err setting local cons arg:");
          localStringBuffer4.append(localUtilEvalError);
          throw new InterpreterError(localStringBuffer4.toString());
        }
      }
    }
    catch (Exception localException)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("unable to get instance initializer: ");
      localStringBuffer1.append(localException);
      throw new InterpreterError(localStringBuffer1.toString());
    }
  }

  public static void initInstance(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = Types.getTypes(paramArrayOfObject);
    CallStack localCallStack = new CallStack();
    This localThis1 = a(paramObject, paramString);
    Object localObject;
    NameSpace localNameSpace;
    if (localThis1 == null)
    {
      This localThis2 = a(paramObject.getClass(), paramString);
      localObject = localThis2.b;
      try
      {
        BSHBlock localBSHBlock = (BSHBlock)localThis2.getNameSpace().getVariable("_bshInstanceInitializer");
        localNameSpace = new NameSpace(localThis2.getNameSpace(), paramString);
        localNameSpace.d = true;
        This localThis3 = localNameSpace.a((Interpreter)localObject);
        try
        {
          StringBuffer localStringBuffer4 = new StringBuffer();
          localStringBuffer4.append("_bshThis");
          localStringBuffer4.append(paramString);
          Reflect.a(paramObject, localStringBuffer4.toString()).assign(localThis3, false);
          localNameSpace.a(paramObject);
          localCallStack.push(localNameSpace);
          try
          {
            localBSHBlock.a(localCallStack, (Interpreter)localObject, true, ClassGeneratorImpl.ClassNodeFilter.CLASSINSTANCE);
            localCallStack.pop();
          }
          catch (Exception localException5)
          {
            StringBuffer localStringBuffer6 = new StringBuffer();
            localStringBuffer6.append("Error in class initialization: ");
            localStringBuffer6.append(localException5);
            throw new InterpreterError(localStringBuffer6.toString());
          }
        }
        catch (Exception localException4)
        {
          StringBuffer localStringBuffer5 = new StringBuffer();
          localStringBuffer5.append("Error in class gen setup: ");
          localStringBuffer5.append(localException4);
          throw new InterpreterError(localStringBuffer5.toString());
        }
      }
      catch (Exception localException3)
      {
        StringBuffer localStringBuffer3 = new StringBuffer();
        localStringBuffer3.append("unable to get instance initializer: ");
        localStringBuffer3.append(localException3);
        throw new InterpreterError(localStringBuffer3.toString());
      }
    }
    else
    {
      Interpreter localInterpreter = localThis1.b;
      localNameSpace = localThis1.getNameSpace();
      localObject = localInterpreter;
    }
    String str = d(paramString);
    try
    {
      BshMethod localBshMethod = localNameSpace.getMethod(str, arrayOfClass, true);
      if ((paramArrayOfObject.length > 0) && (localBshMethod == null))
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Can't find constructor: ");
        localStringBuffer2.append(paramString);
        throw new InterpreterError(localStringBuffer2.toString());
      }
      if (localBshMethod != null)
        localBshMethod.a(paramArrayOfObject, (Interpreter)localObject, localCallStack, null, false);
      return;
    }
    catch (Exception localException1)
    {
      Exception localException2;
      if ((localException1 instanceof TargetError))
        localException2 = (Exception)((TargetError)localException1).getTarget();
      if ((localException2 instanceof InvocationTargetException))
        localException2 = (Exception)((InvocationTargetException)localException2).getTargetException();
      a.a(localException2, System.err);
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Error in class initialization: ");
      localStringBuffer1.append(localException2);
      throw new InterpreterError(localStringBuffer1.toString());
    }
  }

  void a(int paramInt1, int paramInt2, int paramInt3, CodeVisitor paramCodeVisitor)
  {
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    int i1 = this.g.length + this.h.length;
    Label[] arrayOfLabel = new Label[i1];
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        paramCodeVisitor.visitLdcInsn(this.c.getName());
        String str1 = this.b;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("_bshStatic");
        localStringBuffer.append(this.a);
        paramCodeVisitor.visitFieldInsn(178, str1, localStringBuffer.toString(), "Lbsh/This;");
        paramCodeVisitor.visitVarInsn(25, paramInt2);
        paramCodeVisitor.visitIntInsn(16, paramInt1);
        paramCodeVisitor.visitMethodInsn(184, "bsh/ClassGeneratorUtil", "getConstructorArgs", "(Ljava/lang/String;Lbsh/This;[Ljava/lang/Object;I)Lbsh/ClassGeneratorUtil$ConstructorArgs;");
        paramCodeVisitor.visitVarInsn(58, paramInt3);
        paramCodeVisitor.visitVarInsn(25, paramInt3);
        paramCodeVisitor.visitFieldInsn(180, "bsh/ClassGeneratorUtil$ConstructorArgs", "selector", "I");
        paramCodeVisitor.visitTableSwitchInsn(0, i1 - 1, localLabel1, arrayOfLabel);
        int i3 = 0;
        for (int i4 = 0; ; i4++)
        {
          if (i3 >= this.g.length)
          {
            int i5 = 0;
            while (true)
            {
              if (i5 >= this.h.length)
              {
                paramCodeVisitor.visitLabel(localLabel1);
                paramCodeVisitor.visitVarInsn(25, 0);
                paramCodeVisitor.visitMethodInsn(183, this.d, "<init>", "()V");
                paramCodeVisitor.visitLabel(localLabel2);
                return;
              }
              String str3 = this.b;
              String[] arrayOfString2 = this.h[i5].getParamTypeDescriptors();
              a(i4, str3, arrayOfString2, localLabel2, arrayOfLabel, paramInt3, paramCodeVisitor);
              i5++;
              i4++;
            }
          }
          String str2 = this.d;
          String[] arrayOfString1 = a(this.g[i3].getParameterTypes());
          a(i4, str2, arrayOfString1, localLabel2, arrayOfLabel, paramInt3, paramCodeVisitor);
          i3++;
        }
      }
      arrayOfLabel[i2] = new Label();
    }
  }

  void a(int paramInt1, String[] paramArrayOfString, int paramInt2, ClassWriter paramClassWriter)
  {
    int i1 = 1 + paramArrayOfString.length;
    int i2 = 2 + paramArrayOfString.length;
    CodeVisitor localCodeVisitor = paramClassWriter.visitMethod(paramInt2, "<init>", a("V", paramArrayOfString), null);
    generateParameterReifierCode(paramArrayOfString, false, localCodeVisitor);
    localCodeVisitor.visitVarInsn(58, i1);
    a(paramInt1, i1, i2, localCodeVisitor);
    localCodeVisitor.visitVarInsn(25, 0);
    localCodeVisitor.visitLdcInsn(this.a);
    localCodeVisitor.visitVarInsn(25, i1);
    localCodeVisitor.visitMethodInsn(184, "bsh/ClassGeneratorUtil", "initInstance", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V");
    localCodeVisitor.visitInsn(177);
    localCodeVisitor.visitMaxs(20, 20);
  }

  boolean a(Class paramClass, String paramString, String[] paramArrayOfString)
  {
    if (paramClass == null)
      return false;
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfMethod.length)
      {
        paramClass = paramClass.getSuperclass();
        break;
      }
      if (arrayOfMethod[i1].getName().equals(paramString))
      {
        String[] arrayOfString = a(arrayOfMethod[i1].getParameterTypes());
        for (int i2 = 0; ; i2++)
        {
          int i3;
          if (i2 >= arrayOfString.length)
          {
            i3 = 1;
          }
          else
          {
            if (paramArrayOfString[i2].equals(arrayOfString[i2]))
              continue;
            i3 = 0;
          }
          if (i3 == 0)
            break;
          return true;
        }
      }
    }
  }

  public byte[] generateClass()
  {
    int i1 = 0x1 | a(this.k);
    if (this.l)
      i1 |= 512;
    int i2 = i1;
    String[] arrayOfString1 = new String[this.e.length];
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= this.e.length)
      {
        Object localObject1 = new ClassWriter(false);
        String str1 = this.b;
        String str2 = this.d;
        ((ClassWriter)localObject1).visit(i2, str1, str2, arrayOfString1, "BeanShell Generated via ASM (www.objectweb.org)");
        if (!this.l)
        {
          StringBuffer localStringBuffer1 = new StringBuffer();
          localStringBuffer1.append("_bshThis");
          localStringBuffer1.append(this.a);
          a(localStringBuffer1.toString(), "Lbsh/This;", 1, (ClassWriter)localObject1);
          StringBuffer localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append("_bshStatic");
          localStringBuffer2.append(this.a);
          a(localStringBuffer2.toString(), "Lbsh/This;", 9, (ClassWriter)localObject1);
        }
        int i4 = 0;
        while (true)
        {
          if (i4 >= this.f.length)
          {
            int i6 = 0;
            int i7 = 0;
            while (true)
            {
              if (i6 >= this.h.length)
              {
                if ((!this.l) && (i7 == 0))
                  a(-1, new String[0], 1, (ClassWriter)localObject1);
                int i9 = 0;
                while (true)
                {
                  if (i9 >= this.i.length)
                    return ((ClassWriter)localObject1).toByteArray();
                  String str4 = this.i[i9].getReturnTypeDescriptor();
                  Object localObject4;
                  if (this.i[i9].hasModifier("private"))
                  {
                    localObject4 = localObject1;
                  }
                  else
                  {
                    int i10 = a(this.i[i9].getModifiers());
                    if (this.l)
                      i10 |= 1025;
                    String str5 = this.a;
                    String str6 = this.b;
                    String str7 = this.i[i9].getName();
                    String[] arrayOfString2 = this.i[i9].getParamTypeDescriptors();
                    int i11 = i10;
                    localObject4 = localObject1;
                    a(str5, str6, str7, str4, arrayOfString2, i11, (ClassWriter)localObject1);
                    int i12;
                    if ((i10 & 0x8) > 0)
                      i12 = 1;
                    else
                      i12 = 0;
                    boolean bool = a(this.c, this.i[i9].getName(), this.i[i9].getParamTypeDescriptors());
                    if ((i12 == 0) && (bool))
                      a(this.d, this.i[i9].getName(), str4, this.i[i9].getParamTypeDescriptors(), i10, localObject4);
                  }
                  i9++;
                  localObject1 = localObject4;
                }
              }
              Object localObject3 = localObject1;
              if (!this.h[i6].hasModifier("private"))
              {
                int i8 = a(this.h[i6].getModifiers());
                a(i6, this.h[i6].getParamTypeDescriptors(), i8, localObject3);
                i7 = 1;
              }
              i6++;
              localObject1 = localObject3;
            }
          }
          Object localObject2 = localObject1;
          String str3 = this.f[i4].getTypeDescriptor();
          if ((!this.f[i4].hasModifier("private")) && (str3 != null))
          {
            int i5;
            if (this.l)
              i5 = 25;
            else
              i5 = a(this.f[i4].getModifiers());
            a(this.f[i4].getName(), str3, i5, localObject2);
          }
          i4++;
          localObject1 = localObject2;
        }
      }
      arrayOfString1[i3] = Type.getInternalName(this.e[i3]);
    }
  }

  public static class ConstructorArgs
  {
    public static ConstructorArgs DEFAULT = new ConstructorArgs();
    Object[] a;
    int b = 0;
    public int selector = -1;

    ConstructorArgs()
    {
    }

    ConstructorArgs(int paramInt, Object[] paramArrayOfObject)
    {
      this.selector = paramInt;
      this.a = paramArrayOfObject;
    }

    Object a()
    {
      Object[] arrayOfObject = this.a;
      int i = this.b;
      this.b = (i + 1);
      return arrayOfObject[i];
    }

    public boolean getBoolean()
    {
      return ((Boolean)a()).booleanValue();
    }

    public byte getByte()
    {
      return ((Byte)a()).byteValue();
    }

    public char getChar()
    {
      return ((Character)a()).charValue();
    }

    public double getDouble()
    {
      return ((Double)a()).doubleValue();
    }

    public float getFloat()
    {
      return ((Float)a()).floatValue();
    }

    public int getInt()
    {
      return ((Integer)a()).intValue();
    }

    public long getLong()
    {
      return ((Long)a()).longValue();
    }

    public Object getObject()
    {
      return a();
    }

    public short getShort()
    {
      return ((Short)a()).shortValue();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ClassGeneratorUtil
 * JD-Core Version:    0.6.2
 */