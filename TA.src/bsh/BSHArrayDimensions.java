package bsh;

class BSHArrayDimensions extends SimpleNode
{
  public Class baseType;
  public int[] definedDimensions;
  public int numDefinedDims;
  public int numUndefinedDims;

  BSHArrayDimensions(int paramInt)
  {
    super(paramInt);
  }

  public void addDefinedDimension()
  {
    this.numDefinedDims = (1 + this.numDefinedDims);
  }

  public void addUndefinedDimension()
  {
    this.numUndefinedDims = (1 + this.numUndefinedDims);
  }

  // ERROR //
  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: iconst_0
    //   4: invokevirtual 30	bsh/BSHArrayDimensions:jjtGetChild	(I)Lbsh/Node;
    //   7: checkcast 4	bsh/SimpleNode
    //   10: astore 4
    //   12: aload 4
    //   14: instanceof 32
    //   17: ifeq +194 -> 211
    //   20: aload_0
    //   21: getfield 34	bsh/BSHArrayDimensions:baseType	Ljava/lang/Class;
    //   24: ifnonnull +15 -> 39
    //   27: new 36	bsh/EvalError
    //   30: dup
    //   31: ldc 38
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 41	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   38: athrow
    //   39: aload 4
    //   41: checkcast 32	bsh/BSHArrayInitializer
    //   44: aload_0
    //   45: getfield 34	bsh/BSHArrayDimensions:baseType	Ljava/lang/Class;
    //   48: aload_0
    //   49: getfield 22	bsh/BSHArrayDimensions:numUndefinedDims	I
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 44	bsh/BSHArrayInitializer:eval	(Ljava/lang/Class;ILbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   57: astore 10
    //   59: aload 10
    //   61: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   64: invokestatic 56	bsh/Reflect:getArrayDimensions	(Ljava/lang/Class;)I
    //   67: istore 11
    //   69: aload_0
    //   70: iload 11
    //   72: newarray int
    //   74: putfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   77: aload_0
    //   78: getfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   81: arraylength
    //   82: aload_0
    //   83: getfield 22	bsh/BSHArrayDimensions:numUndefinedDims	I
    //   86: if_icmpeq +69 -> 155
    //   89: new 60	java/lang/StringBuffer
    //   92: dup
    //   93: invokespecial 62	java/lang/StringBuffer:<init>	()V
    //   96: astore 12
    //   98: aload 12
    //   100: ldc 64
    //   102: invokevirtual 68	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   105: pop
    //   106: aload 12
    //   108: aload_0
    //   109: getfield 22	bsh/BSHArrayDimensions:numUndefinedDims	I
    //   112: invokevirtual 71	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   115: pop
    //   116: aload 12
    //   118: ldc 73
    //   120: invokevirtual 68	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 12
    //   126: iload 11
    //   128: invokevirtual 71	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   131: pop
    //   132: aload 12
    //   134: ldc 75
    //   136: invokevirtual 68	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: new 36	bsh/EvalError
    //   143: dup
    //   144: aload 12
    //   146: invokevirtual 79	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   149: aload_0
    //   150: aload_1
    //   151: invokespecial 41	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   154: athrow
    //   155: aload 10
    //   157: astore 18
    //   159: iconst_0
    //   160: istore 19
    //   162: iload 19
    //   164: aload_0
    //   165: getfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   168: arraylength
    //   169: if_icmplt +6 -> 175
    //   172: aload 10
    //   174: areturn
    //   175: aload_0
    //   176: getfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   179: iload 19
    //   181: aload 18
    //   183: invokestatic 85	java/lang/reflect/Array:getLength	(Ljava/lang/Object;)I
    //   186: iastore
    //   187: aload_0
    //   188: getfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   191: iload 19
    //   193: iaload
    //   194: ifle +11 -> 205
    //   197: aload 18
    //   199: iconst_0
    //   200: invokestatic 89	java/lang/reflect/Array:get	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   203: astore 18
    //   205: iinc 19 1
    //   208: goto -46 -> 162
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 19	bsh/BSHArrayDimensions:numDefinedDims	I
    //   216: newarray int
    //   218: putfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   221: iload_3
    //   222: aload_0
    //   223: getfield 19	bsh/BSHArrayDimensions:numDefinedDims	I
    //   226: if_icmplt +7 -> 233
    //   229: getstatic 95	bsh/Primitive:VOID	Lbsh/Primitive;
    //   232: areturn
    //   233: aload_0
    //   234: iload_3
    //   235: invokevirtual 30	bsh/BSHArrayDimensions:jjtGetChild	(I)Lbsh/Node;
    //   238: checkcast 4	bsh/SimpleNode
    //   241: aload_1
    //   242: aload_2
    //   243: invokevirtual 97	bsh/SimpleNode:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   246: astore 9
    //   248: aload_0
    //   249: getfield 58	bsh/BSHArrayDimensions:definedDimensions	[I
    //   252: iload_3
    //   253: aload 9
    //   255: checkcast 91	bsh/Primitive
    //   258: invokevirtual 101	bsh/Primitive:intValue	()I
    //   261: iastore
    //   262: iinc 3 1
    //   265: goto -44 -> 221
    //   268: new 60	java/lang/StringBuffer
    //   271: dup
    //   272: invokespecial 62	java/lang/StringBuffer:<init>	()V
    //   275: astore 5
    //   277: aload 5
    //   279: ldc 103
    //   281: invokevirtual 68	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   284: pop
    //   285: aload 5
    //   287: iload_3
    //   288: invokevirtual 71	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   291: pop
    //   292: aload 5
    //   294: ldc 105
    //   296: invokevirtual 68	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   299: pop
    //   300: new 36	bsh/EvalError
    //   303: dup
    //   304: aload 5
    //   306: invokevirtual 79	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   309: aload_0
    //   310: aload_1
    //   311: invokespecial 41	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   314: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   233	262	268	java/lang/Exception
  }

  public Object eval(Class paramClass, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("array base type = ");
      localStringBuffer.append(paramClass);
      Interpreter.debug(localStringBuffer.toString());
    }
    this.baseType = paramClass;
    return eval(paramCallStack, paramInterpreter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHArrayDimensions
 * JD-Core Version:    0.6.2
 */