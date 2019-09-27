package bsh;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassGeneratorImpl extends ClassGenerator
{
  static Variable[] a(BSHBlock paramBSHBlock, CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= paramBSHBlock.jjtGetNumChildren())
        return (Variable[])localArrayList.toArray(new Variable[0]);
      SimpleNode localSimpleNode = (SimpleNode)paramBSHBlock.jjtGetChild(i);
      if ((localSimpleNode instanceof BSHTypedVariableDeclaration))
      {
        BSHTypedVariableDeclaration localBSHTypedVariableDeclaration = (BSHTypedVariableDeclaration)localSimpleNode;
        Modifiers localModifiers = localBSHTypedVariableDeclaration.modifiers;
        String str1 = localBSHTypedVariableDeclaration.getTypeDescriptor(paramCallStack, paramInterpreter, paramString);
        BSHVariableDeclarator[] arrayOfBSHVariableDeclarator = localBSHTypedVariableDeclaration.a();
        for (int j = 0; j < arrayOfBSHVariableDeclarator.length; j++)
        {
          String str2 = arrayOfBSHVariableDeclarator[j].name;
          try
          {
            localArrayList.add(new Variable(str2, str1, null, localModifiers));
          }
          catch (UtilEvalError localUtilEvalError)
          {
          }
        }
      }
    }
  }

  static DelayedEvalBshMethod[] b(BSHBlock paramBSHBlock, CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    String str1 = paramString;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      if (i >= paramBSHBlock.jjtGetNumChildren())
        return (DelayedEvalBshMethod[])localArrayList.toArray(new DelayedEvalBshMethod[0]);
      SimpleNode localSimpleNode = (SimpleNode)paramBSHBlock.jjtGetChild(i);
      int j;
      if ((localSimpleNode instanceof BSHMethodDeclaration))
      {
        BSHMethodDeclaration localBSHMethodDeclaration = (BSHMethodDeclaration)localSimpleNode;
        localBSHMethodDeclaration.a();
        Modifiers localModifiers = localBSHMethodDeclaration.modifiers;
        String str2 = localBSHMethodDeclaration.name;
        String str3 = localBSHMethodDeclaration.a(paramCallStack, paramInterpreter, str1);
        BSHReturnType localBSHReturnType = localBSHMethodDeclaration.b();
        BSHFormalParameters localBSHFormalParameters = localBSHMethodDeclaration.b;
        String[] arrayOfString1 = localBSHFormalParameters.getTypeDescriptors(paramCallStack, paramInterpreter, str1);
        String[] arrayOfString2 = localBSHMethodDeclaration.b.getParamNames();
        BSHBlock localBSHBlock = localBSHMethodDeclaration.c;
        j = i;
        DelayedEvalBshMethod localDelayedEvalBshMethod = new DelayedEvalBshMethod(str2, str3, localBSHReturnType, arrayOfString2, arrayOfString1, localBSHFormalParameters, localBSHBlock, null, localModifiers, paramCallStack, paramInterpreter);
        localArrayList.add(localDelayedEvalBshMethod);
      }
      else
      {
        j = i;
      }
      i = j + 1;
      str1 = paramString;
    }
  }

  // ERROR //
  public static Class generateClassImpl(String paramString, Modifiers paramModifiers, Class[] paramArrayOfClass, Class paramClass, BSHBlock paramBSHBlock, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    // Byte code:
    //   0: iconst_1
    //   1: invokestatic 114	bsh/Capabilities:setAccessibility	(Z)V
    //   4: aload 6
    //   6: invokevirtual 120	bsh/CallStack:top	()Lbsh/NameSpace;
    //   9: astore 8
    //   11: aload 8
    //   13: invokevirtual 125	bsh/NameSpace:c	()Ljava/lang/String;
    //   16: astore 9
    //   18: aload 8
    //   20: getfield 129	bsh/NameSpace:d	Z
    //   23: ifeq +48 -> 71
    //   26: new 131	java/lang/StringBuffer
    //   29: dup
    //   30: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   33: astore 10
    //   35: aload 10
    //   37: aload 8
    //   39: invokevirtual 135	bsh/NameSpace:getName	()Ljava/lang/String;
    //   42: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   45: pop
    //   46: aload 10
    //   48: ldc 141
    //   50: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   53: pop
    //   54: aload 10
    //   56: aload_0
    //   57: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   60: pop
    //   61: aload 10
    //   63: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   66: astore 14
    //   68: goto +6 -> 74
    //   71: aload_0
    //   72: astore 14
    //   74: aload 9
    //   76: ifnonnull +10 -> 86
    //   79: aload 14
    //   81: astore 19
    //   83: goto +43 -> 126
    //   86: new 131	java/lang/StringBuffer
    //   89: dup
    //   90: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   93: astore 15
    //   95: aload 15
    //   97: aload 9
    //   99: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   102: pop
    //   103: aload 15
    //   105: ldc 146
    //   107: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   110: pop
    //   111: aload 15
    //   113: aload 14
    //   115: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   118: pop
    //   119: aload 15
    //   121: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   124: astore 19
    //   126: aload 7
    //   128: invokevirtual 152	bsh/Interpreter:getClassManager	()Lbsh/BshClassManager;
    //   131: astore 20
    //   133: aload 20
    //   135: aload 19
    //   137: invokevirtual 157	bsh/BshClassManager:c	(Ljava/lang/String;)V
    //   140: new 122	bsh/NameSpace
    //   143: dup
    //   144: aload 8
    //   146: aload 14
    //   148: invokespecial 160	bsh/NameSpace:<init>	(Lbsh/NameSpace;Ljava/lang/String;)V
    //   151: astore 21
    //   153: aload 21
    //   155: iconst_1
    //   156: putfield 129	bsh/NameSpace:d	Z
    //   159: aload 6
    //   161: aload 21
    //   163: invokevirtual 164	bsh/CallStack:push	(Lbsh/NameSpace;)V
    //   166: aload 4
    //   168: aload 6
    //   170: aload 7
    //   172: iconst_1
    //   173: getstatic 170	bsh/ClassGeneratorImpl$ClassNodeFilter:CLASSCLASSES	Lbsh/ClassGeneratorImpl$ClassNodeFilter;
    //   176: invokevirtual 173	bsh/BSHBlock:a	(Lbsh/CallStack;Lbsh/Interpreter;ZLbsh/BSHBlock$NodeFilter;)Ljava/lang/Object;
    //   179: pop
    //   180: aload 4
    //   182: aload 6
    //   184: aload 7
    //   186: aload 9
    //   188: invokestatic 175	bsh/ClassGeneratorImpl:a	(Lbsh/BSHBlock;Lbsh/CallStack;Lbsh/Interpreter;Ljava/lang/String;)[Lbsh/Variable;
    //   191: astore 23
    //   193: aload 4
    //   195: aload 6
    //   197: aload 7
    //   199: aload 9
    //   201: invokestatic 177	bsh/ClassGeneratorImpl:b	(Lbsh/BSHBlock;Lbsh/CallStack;Lbsh/Interpreter;Ljava/lang/String;)[Lbsh/DelayedEvalBshMethod;
    //   204: astore 24
    //   206: aload 14
    //   208: astore 25
    //   210: aload 19
    //   212: astore 26
    //   214: aload 14
    //   216: astore 27
    //   218: new 179	bsh/ClassGeneratorUtil
    //   221: dup
    //   222: aload_1
    //   223: aload 25
    //   225: aload 9
    //   227: aload_3
    //   228: aload_2
    //   229: aload 23
    //   231: aload 24
    //   233: aload 21
    //   235: iload 5
    //   237: invokespecial 182	bsh/ClassGeneratorUtil:<init>	(Lbsh/Modifiers;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Lbsh/Variable;[Lbsh/DelayedEvalBshMethod;Lbsh/NameSpace;Z)V
    //   240: astore 28
    //   242: aload 28
    //   244: invokevirtual 186	bsh/ClassGeneratorUtil:generateClass	()[B
    //   247: astore 29
    //   249: ldc 188
    //   251: invokestatic 194	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 30
    //   256: aload 30
    //   258: ifnull +73 -> 331
    //   261: new 131	java/lang/StringBuffer
    //   264: dup
    //   265: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   268: astore 48
    //   270: aload 48
    //   272: aload 30
    //   274: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   277: pop
    //   278: aload 48
    //   280: ldc 196
    //   282: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   285: pop
    //   286: aload 48
    //   288: aload 27
    //   290: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: pop
    //   294: aload 48
    //   296: ldc 198
    //   298: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   301: pop
    //   302: new 200	java/io/FileOutputStream
    //   305: dup
    //   306: aload 48
    //   308: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   311: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   314: astore 53
    //   316: aload 53
    //   318: aload 29
    //   320: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   323: aload 53
    //   325: invokevirtual 209	java/io/FileOutputStream:close	()V
    //   328: goto +4 -> 332
    //   331: pop
    //   332: aload 20
    //   334: aload 26
    //   336: aload 29
    //   338: invokevirtual 213	bsh/BshClassManager:defineClass	(Ljava/lang/String;[B)Ljava/lang/Class;
    //   341: astore 32
    //   343: aload 8
    //   345: aload 26
    //   347: bipush 36
    //   349: bipush 46
    //   351: invokevirtual 219	java/lang/String:replace	(CC)Ljava/lang/String;
    //   354: invokevirtual 222	bsh/NameSpace:importClass	(Ljava/lang/String;)V
    //   357: aload 21
    //   359: ldc 224
    //   361: aload 4
    //   363: iconst_0
    //   364: invokevirtual 227	bsh/NameSpace:a	(Ljava/lang/String;Ljava/lang/Object;Z)V
    //   367: aload 21
    //   369: aload 32
    //   371: invokevirtual 230	bsh/NameSpace:a	(Ljava/lang/Class;)V
    //   374: aload 4
    //   376: aload 6
    //   378: aload 7
    //   380: iconst_1
    //   381: getstatic 233	bsh/ClassGeneratorImpl$ClassNodeFilter:CLASSSTATIC	Lbsh/ClassGeneratorImpl$ClassNodeFilter;
    //   384: invokevirtual 173	bsh/BSHBlock:a	(Lbsh/CallStack;Lbsh/Interpreter;ZLbsh/BSHBlock$NodeFilter;)Ljava/lang/Object;
    //   387: pop
    //   388: aload 6
    //   390: invokevirtual 236	bsh/CallStack:pop	()Lbsh/NameSpace;
    //   393: pop
    //   394: aload 32
    //   396: invokevirtual 242	java/lang/Class:isInterface	()Z
    //   399: ifne +98 -> 497
    //   402: new 131	java/lang/StringBuffer
    //   405: dup
    //   406: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   409: astore 39
    //   411: aload 39
    //   413: ldc 244
    //   415: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   418: pop
    //   419: aload 39
    //   421: aload 27
    //   423: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   426: pop
    //   427: aload 39
    //   429: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   432: astore 42
    //   434: aload 32
    //   436: aload 42
    //   438: invokestatic 249	bsh/Reflect:a	(Ljava/lang/Class;Ljava/lang/String;)Lbsh/LHS;
    //   441: aload 21
    //   443: aload 7
    //   445: invokevirtual 252	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   448: iconst_0
    //   449: invokevirtual 258	bsh/LHS:assign	(Ljava/lang/Object;Z)Ljava/lang/Object;
    //   452: pop
    //   453: goto +44 -> 497
    //   456: astore 43
    //   458: new 131	java/lang/StringBuffer
    //   461: dup
    //   462: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   465: astore 44
    //   467: aload 44
    //   469: ldc_w 260
    //   472: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   475: pop
    //   476: aload 44
    //   478: aload 43
    //   480: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   483: pop
    //   484: new 265	bsh/InterpreterError
    //   487: dup
    //   488: aload 44
    //   490: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   493: invokespecial 266	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   496: athrow
    //   497: aload 20
    //   499: aload 26
    //   501: invokevirtual 269	bsh/BshClassManager:f	(Ljava/lang/String;)V
    //   504: aload 32
    //   506: areturn
    //   507: astore 33
    //   509: new 131	java/lang/StringBuffer
    //   512: dup
    //   513: invokespecial 132	java/lang/StringBuffer:<init>	()V
    //   516: astore 34
    //   518: aload 34
    //   520: ldc_w 271
    //   523: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   526: pop
    //   527: aload 34
    //   529: aload 33
    //   531: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   534: pop
    //   535: new 265	bsh/InterpreterError
    //   538: dup
    //   539: aload 34
    //   541: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   544: invokespecial 266	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   547: athrow
    //   548: new 273	bsh/EvalError
    //   551: dup
    //   552: ldc_w 275
    //   555: aload 4
    //   557: aload 6
    //   559: invokespecial 278	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   562: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   261	328	331	java/io/IOException
    //   434	453	456	java/lang/Exception
    //   357	367	507	bsh/UtilEvalError
    //   0	4	548	bsh/Capabilities$Unavailable
  }

  public static Object invokeSuperclassMethodImpl(BshClassManager paramBshClassManager, Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("_bshSuper");
    localStringBuffer.append(paramString);
    String str = localStringBuffer.toString();
    Class localClass = paramObject.getClass();
    Method localMethod = Reflect.a(paramBshClassManager, localClass, str, Types.getTypes(paramArrayOfObject), false);
    if (localMethod != null)
      return Reflect.a(localMethod, paramObject, paramArrayOfObject);
    return Reflect.a(Reflect.a(paramBshClassManager, localClass.getSuperclass(), paramObject, paramString, paramArrayOfObject, false), paramObject, paramArrayOfObject);
  }

  public Class generateClass(String paramString, Modifiers paramModifiers, Class[] paramArrayOfClass, Class paramClass, BSHBlock paramBSHBlock, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    return generateClassImpl(paramString, paramModifiers, paramArrayOfClass, paramClass, paramBSHBlock, paramBoolean, paramCallStack, paramInterpreter);
  }

  public Object invokeSuperclassMethod(BshClassManager paramBshClassManager, Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return invokeSuperclassMethodImpl(paramBshClassManager, paramObject, paramString, paramArrayOfObject);
  }

  public void setInstanceNameSpaceParent(Object paramObject, String paramString, NameSpace paramNameSpace)
  {
    ClassGeneratorUtil.a(paramObject, paramString).getNameSpace().setParent(paramNameSpace);
  }

  static class ClassNodeFilter
    implements BSHBlock.NodeFilter
  {
    public static ClassNodeFilter CLASSCLASSES = new ClassNodeFilter(2);
    public static final int CLASSES = 2;
    public static ClassNodeFilter CLASSINSTANCE;
    public static ClassNodeFilter CLASSSTATIC = new ClassNodeFilter(0);
    public static final int INSTANCE = 1;
    public static final int STATIC;
    int a;

    static
    {
      CLASSINSTANCE = new ClassNodeFilter(1);
    }

    private ClassNodeFilter(int paramInt)
    {
      this.a = paramInt;
    }

    boolean a(SimpleNode paramSimpleNode)
    {
      if ((paramSimpleNode instanceof BSHTypedVariableDeclaration))
      {
        BSHTypedVariableDeclaration localBSHTypedVariableDeclaration = (BSHTypedVariableDeclaration)paramSimpleNode;
        return (localBSHTypedVariableDeclaration.modifiers != null) && (localBSHTypedVariableDeclaration.modifiers.hasModifier("static"));
      }
      if ((paramSimpleNode instanceof BSHMethodDeclaration))
      {
        BSHMethodDeclaration localBSHMethodDeclaration = (BSHMethodDeclaration)paramSimpleNode;
        return (localBSHMethodDeclaration.modifiers != null) && (localBSHMethodDeclaration.modifiers.hasModifier("static"));
      }
      if ((paramSimpleNode instanceof BSHBlock));
      return false;
    }

    public boolean isVisible(SimpleNode paramSimpleNode)
    {
      if (this.a == 2)
        return paramSimpleNode instanceof BSHClassDeclaration;
      if ((paramSimpleNode instanceof BSHClassDeclaration))
        return false;
      if (this.a == 0)
        return a(paramSimpleNode);
      if (this.a == 1)
        return true ^ a(paramSimpleNode);
      return true;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ClassGeneratorImpl
 * JD-Core Version:    0.6.2
 */