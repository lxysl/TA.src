package bsh;

import java.io.Serializable;

public class This
  implements Serializable, Runnable
{
  NameSpace a;
  transient Interpreter b;

  protected This(NameSpace paramNameSpace, Interpreter paramInterpreter)
  {
    this.a = paramNameSpace;
    this.b = paramInterpreter;
  }

  static This a(NameSpace paramNameSpace, Interpreter paramInterpreter)
  {
    try
    {
      if (Capabilities.canGenerateInterfaces());
      Class localClass;
      for (String str = "bsh.XThis"; ; str = "bsh.JThis")
      {
        localClass = Class.forName(str);
        break;
        if (!Capabilities.haveSwing())
          break label54;
      }
      return (This)Reflect.a(localClass, new Object[] { paramNameSpace, paramInterpreter });
      label54: This localThis = new This(paramNameSpace, paramInterpreter);
      return localThis;
    }
    catch (Exception localException)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("internal error 1 in This: ");
      localStringBuffer.append(localException);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  static boolean a(String paramString)
  {
    return (paramString.equals("getClass")) || (paramString.equals("invokeMethod")) || (paramString.equals("getInterface")) || (paramString.equals("wait")) || (paramString.equals("notify")) || (paramString.equals("notifyAll"));
  }

  public static void bind(This paramThis, NameSpace paramNameSpace, Interpreter paramInterpreter)
  {
    paramThis.a.setParent(paramNameSpace);
    paramThis.b = paramInterpreter;
  }

  public Object getInterface(Class paramClass)
  {
    if (paramClass.isInstance(this))
      return this;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Dynamic proxy mechanism not available. Cannot construct interface type: ");
    localStringBuffer.append(paramClass);
    throw new UtilEvalError(localStringBuffer.toString());
  }

  public Object getInterface(Class[] paramArrayOfClass)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfClass.length)
        return this;
      if (!paramArrayOfClass[i].isInstance(this))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Dynamic proxy mechanism not available. Cannot construct interface type: ");
        localStringBuffer.append(paramArrayOfClass[i]);
        throw new UtilEvalError(localStringBuffer.toString());
      }
    }
  }

  public NameSpace getNameSpace()
  {
    return this.a;
  }

  public Object invokeMethod(String paramString, Object[] paramArrayOfObject)
  {
    return invokeMethod(paramString, paramArrayOfObject, null, null, null, false);
  }

  // ERROR //
  public Object invokeMethod(String paramString, Object[] paramArrayOfObject, Interpreter paramInterpreter, CallStack paramCallStack, SimpleNode paramSimpleNode, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +60 -> 61
    //   4: aload_2
    //   5: arraylength
    //   6: anewarray 4	java/lang/Object
    //   9: astore 18
    //   11: iconst_0
    //   12: istore 19
    //   14: iload 19
    //   16: aload_2
    //   17: arraylength
    //   18: if_icmplt +9 -> 27
    //   21: aload 18
    //   23: astore_2
    //   24: goto +37 -> 61
    //   27: aload_2
    //   28: iload 19
    //   30: aaload
    //   31: ifnonnull +11 -> 42
    //   34: getstatic 120	bsh/Primitive:NULL	Lbsh/Primitive;
    //   37: astore 20
    //   39: goto +9 -> 48
    //   42: aload_2
    //   43: iload 19
    //   45: aaload
    //   46: astore 20
    //   48: aload 18
    //   50: iload 19
    //   52: aload 20
    //   54: aastore
    //   55: iinc 19 1
    //   58: goto -44 -> 14
    //   61: aload_3
    //   62: ifnonnull +8 -> 70
    //   65: aload_0
    //   66: getfield 21	bsh/This:b	Lbsh/Interpreter;
    //   69: astore_3
    //   70: aload 4
    //   72: ifnonnull +16 -> 88
    //   75: new 122	bsh/CallStack
    //   78: dup
    //   79: aload_0
    //   80: getfield 19	bsh/This:a	Lbsh/NameSpace;
    //   83: invokespecial 124	bsh/CallStack:<init>	(Lbsh/NameSpace;)V
    //   86: astore 4
    //   88: aload 5
    //   90: ifnonnull +8 -> 98
    //   93: getstatic 130	bsh/SimpleNode:JAVACODE	Lbsh/SimpleNode;
    //   96: astore 5
    //   98: aload_2
    //   99: invokestatic 136	bsh/Types:getTypes	([Ljava/lang/Object;)[Ljava/lang/Class;
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 19	bsh/This:a	Lbsh/NameSpace;
    //   108: aload_1
    //   109: aload 7
    //   111: iload 6
    //   113: invokevirtual 140	bsh/NameSpace:getMethod	(Ljava/lang/String;[Ljava/lang/Class;Z)Lbsh/BshMethod;
    //   116: astore 8
    //   118: goto +6 -> 124
    //   121: aconst_null
    //   122: astore 8
    //   124: aload 8
    //   126: ifnull +15 -> 141
    //   129: aload 8
    //   131: aload_2
    //   132: aload_3
    //   133: aload 4
    //   135: aload 5
    //   137: invokevirtual 146	bsh/BshMethod:invoke	([Ljava/lang/Object;Lbsh/Interpreter;Lbsh/CallStack;Lbsh/SimpleNode;)Ljava/lang/Object;
    //   140: areturn
    //   141: aload_1
    //   142: ldc 147
    //   144: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifeq +8 -> 155
    //   150: aload_0
    //   151: invokevirtual 148	bsh/This:toString	()Ljava/lang/String;
    //   154: areturn
    //   155: aload_1
    //   156: ldc 150
    //   158: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +15 -> 176
    //   164: new 152	java/lang/Integer
    //   167: dup
    //   168: aload_0
    //   169: invokevirtual 155	java/lang/Object:hashCode	()I
    //   172: invokespecial 158	java/lang/Integer:<init>	(I)V
    //   175: areturn
    //   176: aload_1
    //   177: ldc 159
    //   179: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifeq +30 -> 212
    //   185: aload_2
    //   186: iconst_0
    //   187: aaload
    //   188: astore 16
    //   190: iconst_0
    //   191: istore 17
    //   193: aload_0
    //   194: aload 16
    //   196: if_acmpne +6 -> 202
    //   199: iconst_1
    //   200: istore 17
    //   202: new 161	java/lang/Boolean
    //   205: dup
    //   206: iload 17
    //   208: invokespecial 164	java/lang/Boolean:<init>	(Z)V
    //   211: areturn
    //   212: aload_0
    //   213: getfield 19	bsh/This:a	Lbsh/NameSpace;
    //   216: ldc 165
    //   218: iconst_2
    //   219: anewarray 34	java/lang/Class
    //   222: dup
    //   223: iconst_0
    //   224: aconst_null
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aconst_null
    //   229: aastore
    //   230: invokevirtual 168	bsh/NameSpace:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Lbsh/BshMethod;
    //   233: astore 15
    //   235: aload 15
    //   237: astore 8
    //   239: goto +4 -> 243
    //   242: pop
    //   243: aload 8
    //   245: ifnull +26 -> 271
    //   248: aload 8
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_1
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_2
    //   261: aastore
    //   262: aload_3
    //   263: aload 4
    //   265: aload 5
    //   267: invokevirtual 146	bsh/BshMethod:invoke	([Ljava/lang/Object;Lbsh/Interpreter;Lbsh/CallStack;Lbsh/SimpleNode;)Ljava/lang/Object;
    //   270: areturn
    //   271: new 52	java/lang/StringBuffer
    //   274: dup
    //   275: invokespecial 53	java/lang/StringBuffer:<init>	()V
    //   278: astore 10
    //   280: aload 10
    //   282: ldc 170
    //   284: invokevirtual 59	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   287: pop
    //   288: aload 10
    //   290: aload_1
    //   291: aload 7
    //   293: invokestatic 176	bsh/StringUtil:methodString	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/String;
    //   296: invokevirtual 59	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   299: pop
    //   300: aload 10
    //   302: ldc 178
    //   304: invokevirtual 59	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   307: pop
    //   308: aload 10
    //   310: aload_0
    //   311: getfield 19	bsh/This:a	Lbsh/NameSpace;
    //   314: invokevirtual 181	bsh/NameSpace:getName	()Ljava/lang/String;
    //   317: invokevirtual 59	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   320: pop
    //   321: new 183	bsh/EvalError
    //   324: dup
    //   325: aload 10
    //   327: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   330: aload 5
    //   332: aload 4
    //   334: invokespecial 186	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   337: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   104	118	121	bsh/UtilEvalError
    //   212	235	242	bsh/UtilEvalError
  }

  public void run()
  {
    try
    {
      invokeMethod("run", new Object[0]);
      return;
    }
    catch (EvalError localEvalError)
    {
      Interpreter localInterpreter = this.b;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Exception in runnable:");
      localStringBuffer.append(localEvalError);
      localInterpreter.error(localStringBuffer.toString());
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("'this' reference to Bsh object: ");
    localStringBuffer.append(this.a);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.This
 * JD-Core Version:    0.6.2
 */