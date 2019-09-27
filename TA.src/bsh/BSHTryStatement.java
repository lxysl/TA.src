package bsh;

class BSHTryStatement extends SimpleNode
{
  BSHTryStatement(int paramInt)
  {
    super(paramInt);
  }

  // ERROR //
  public java.lang.Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: iconst_0
    //   4: invokevirtual 18	bsh/BSHTryStatement:jjtGetChild	(I)Lbsh/Node;
    //   7: checkcast 20	bsh/BSHBlock
    //   10: astore 4
    //   12: new 22	java/util/Vector
    //   15: dup
    //   16: invokespecial 25	java/util/Vector:<init>	()V
    //   19: astore 5
    //   21: new 22	java/util/Vector
    //   24: dup
    //   25: invokespecial 25	java/util/Vector:<init>	()V
    //   28: astore 6
    //   30: aload_0
    //   31: invokevirtual 29	bsh/BSHTryStatement:jjtGetNumChildren	()I
    //   34: istore 7
    //   36: iconst_1
    //   37: istore 8
    //   39: iload 8
    //   41: iload 7
    //   43: if_icmpge +55 -> 98
    //   46: iload 8
    //   48: iconst_1
    //   49: iadd
    //   50: istore 34
    //   52: aload_0
    //   53: iload 8
    //   55: invokevirtual 18	bsh/BSHTryStatement:jjtGetChild	(I)Lbsh/Node;
    //   58: astore 9
    //   60: aload 9
    //   62: instanceof 31
    //   65: ifne +6 -> 71
    //   68: goto +33 -> 101
    //   71: aload 5
    //   73: aload 9
    //   75: invokevirtual 35	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   78: iload 34
    //   80: iconst_1
    //   81: iadd
    //   82: istore 8
    //   84: aload 6
    //   86: aload_0
    //   87: iload 34
    //   89: invokevirtual 18	bsh/BSHTryStatement:jjtGetChild	(I)Lbsh/Node;
    //   92: invokevirtual 35	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   95: goto -56 -> 39
    //   98: aconst_null
    //   99: astore 9
    //   101: aload 9
    //   103: ifnull +13 -> 116
    //   106: aload 9
    //   108: checkcast 20	bsh/BSHBlock
    //   111: astore 10
    //   113: goto +6 -> 119
    //   116: aconst_null
    //   117: astore 10
    //   119: aload_1
    //   120: invokevirtual 40	bsh/CallStack:depth	()I
    //   123: istore 11
    //   125: aload 4
    //   127: aload_1
    //   128: aload_2
    //   129: invokevirtual 42	bsh/BSHBlock:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   132: astore 33
    //   134: aload 33
    //   136: astore 19
    //   138: aconst_null
    //   139: astore 12
    //   141: goto +21 -> 162
    //   144: astore 12
    //   146: ldc 44
    //   148: astore 13
    //   150: aload_1
    //   151: invokevirtual 40	bsh/CallStack:depth	()I
    //   154: iload 11
    //   156: if_icmpgt +302 -> 458
    //   159: aconst_null
    //   160: astore 19
    //   162: aload 12
    //   164: ifnull +13 -> 177
    //   167: aload 12
    //   169: invokevirtual 48	bsh/TargetError:getTarget	()Ljava/lang/Throwable;
    //   172: astore 20
    //   174: goto +6 -> 180
    //   177: aconst_null
    //   178: astore 20
    //   180: aload 20
    //   182: ifnull +239 -> 421
    //   185: aload 5
    //   187: invokevirtual 51	java/util/Vector:size	()I
    //   190: istore 21
    //   192: iload_3
    //   193: iload 21
    //   195: if_icmplt +6 -> 201
    //   198: goto +223 -> 421
    //   201: aload 5
    //   203: iload_3
    //   204: invokevirtual 55	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   207: checkcast 31	bsh/BSHFormalParameter
    //   210: astore 22
    //   212: aload 22
    //   214: aload_1
    //   215: aload_2
    //   216: invokevirtual 56	bsh/BSHFormalParameter:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   219: pop
    //   220: aload 22
    //   222: getfield 60	bsh/BSHFormalParameter:type	Ljava/lang/Class;
    //   225: ifnonnull +22 -> 247
    //   228: aload_2
    //   229: invokevirtual 66	bsh/Interpreter:getStrictJava	()Z
    //   232: ifeq +15 -> 247
    //   235: new 68	bsh/EvalError
    //   238: dup
    //   239: ldc 70
    //   241: aload_0
    //   242: aload_1
    //   243: invokespecial 73	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   246: athrow
    //   247: aload 22
    //   249: getfield 60	bsh/BSHFormalParameter:type	Ljava/lang/Class;
    //   252: ifnull +28 -> 280
    //   255: aload 20
    //   257: aload 22
    //   259: getfield 60	bsh/BSHFormalParameter:type	Ljava/lang/Class;
    //   262: iconst_1
    //   263: invokestatic 79	bsh/Types:castObject	(Ljava/lang/Object;Ljava/lang/Class;I)Ljava/lang/Object;
    //   266: checkcast 81	java/lang/Throwable
    //   269: astore 24
    //   271: goto +13 -> 284
    //   274: iinc 3 1
    //   277: goto -85 -> 192
    //   280: aload 20
    //   282: astore 24
    //   284: aload 6
    //   286: iload_3
    //   287: invokevirtual 55	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   290: checkcast 20	bsh/BSHBlock
    //   293: astore 25
    //   295: aload_1
    //   296: invokevirtual 85	bsh/CallStack:top	()Lbsh/NameSpace;
    //   299: astore 26
    //   301: new 87	bsh/BlockNameSpace
    //   304: dup
    //   305: aload 26
    //   307: invokespecial 90	bsh/BlockNameSpace:<init>	(Lbsh/NameSpace;)V
    //   310: astore 27
    //   312: aload 22
    //   314: getfield 60	bsh/BSHFormalParameter:type	Ljava/lang/Class;
    //   317: getstatic 93	bsh/BSHFormalParameter:UNTYPED	Ljava/lang/Class;
    //   320: if_acmpne +18 -> 338
    //   323: aload 27
    //   325: aload 22
    //   327: getfield 97	bsh/BSHFormalParameter:name	Ljava/lang/String;
    //   330: aload 24
    //   332: invokevirtual 101	bsh/BlockNameSpace:setBlockVariable	(Ljava/lang/String;Ljava/lang/Object;)V
    //   335: goto +35 -> 370
    //   338: new 103	bsh/Modifiers
    //   341: dup
    //   342: invokespecial 104	bsh/Modifiers:<init>	()V
    //   345: pop
    //   346: aload 27
    //   348: aload 22
    //   350: getfield 97	bsh/BSHFormalParameter:name	Ljava/lang/String;
    //   353: aload 22
    //   355: getfield 60	bsh/BSHFormalParameter:type	Ljava/lang/Class;
    //   358: aload 24
    //   360: new 103	bsh/Modifiers
    //   363: dup
    //   364: invokespecial 104	bsh/Modifiers:<init>	()V
    //   367: invokevirtual 108	bsh/BlockNameSpace:setTypedVariable	(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Lbsh/Modifiers;)V
    //   370: aload_1
    //   371: aload 27
    //   373: invokevirtual 112	bsh/CallStack:swap	(Lbsh/NameSpace;)Lbsh/NameSpace;
    //   376: pop
    //   377: aload 25
    //   379: aload_1
    //   380: aload_2
    //   381: invokevirtual 42	bsh/BSHBlock:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   384: astore 19
    //   386: aload_1
    //   387: aload 26
    //   389: invokevirtual 112	bsh/CallStack:swap	(Lbsh/NameSpace;)Lbsh/NameSpace;
    //   392: pop
    //   393: aconst_null
    //   394: astore 12
    //   396: goto +25 -> 421
    //   399: astore 30
    //   401: aload_1
    //   402: aload 26
    //   404: invokevirtual 112	bsh/CallStack:swap	(Lbsh/NameSpace;)Lbsh/NameSpace;
    //   407: pop
    //   408: aload 30
    //   410: athrow
    //   411: new 114	bsh/InterpreterError
    //   414: dup
    //   415: ldc 116
    //   417: invokespecial 119	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   420: athrow
    //   421: aload 10
    //   423: ifnull +12 -> 435
    //   426: aload 10
    //   428: aload_1
    //   429: aload_2
    //   430: invokevirtual 42	bsh/BSHBlock:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   433: astore 19
    //   435: aload 12
    //   437: ifnull +6 -> 443
    //   440: aload 12
    //   442: athrow
    //   443: aload 19
    //   445: instanceof 121
    //   448: ifeq +6 -> 454
    //   451: aload 19
    //   453: areturn
    //   454: getstatic 127	bsh/Primitive:VOID	Lbsh/Primitive;
    //   457: areturn
    //   458: new 129	java/lang/StringBuffer
    //   461: dup
    //   462: invokespecial 130	java/lang/StringBuffer:<init>	()V
    //   465: astore 14
    //   467: aload 14
    //   469: aload 13
    //   471: invokevirtual 134	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   474: pop
    //   475: aload 14
    //   477: ldc 136
    //   479: invokevirtual 134	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   482: pop
    //   483: aload 14
    //   485: aload_1
    //   486: invokevirtual 139	bsh/CallStack:pop	()Lbsh/NameSpace;
    //   489: invokevirtual 142	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   492: pop
    //   493: aload 14
    //   495: ldc 144
    //   497: invokevirtual 134	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   500: pop
    //   501: aload 14
    //   503: invokevirtual 148	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   506: astore 13
    //   508: goto -358 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   125	134	144	bsh/TargetError
    //   255	271	274	bsh/UtilEvalError
    //   377	386	399	finally
    //   312	335	411	bsh/UtilEvalError
    //   338	370	411	bsh/UtilEvalError
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHTryStatement
 * JD-Core Version:    0.6.2
 */