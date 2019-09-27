package bsh;

import java.io.Serializable;
import java.lang.reflect.Field;

class LHS
  implements ParserConstants, Serializable
{
  NameSpace a;
  boolean b;
  int c;
  String d;
  String e;
  Field f;
  Object g;
  int h;

  LHS(NameSpace paramNameSpace, String paramString, boolean paramBoolean)
  {
    this.c = 0;
    this.b = paramBoolean;
    this.d = paramString;
    this.a = paramNameSpace;
  }

  LHS(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new NullPointerException("constructed empty LHS");
    this.c = 3;
    this.g = paramObject;
    this.h = paramInt;
  }

  LHS(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new NullPointerException("constructed empty LHS");
    this.c = 2;
    this.g = paramObject;
    this.e = paramString;
  }

  LHS(Object paramObject, Field paramField)
  {
    if (paramObject == null)
      throw new NullPointerException("constructed empty LHS");
    this.c = 1;
    this.g = paramObject;
    this.f = paramField;
  }

  LHS(Field paramField)
  {
    this.c = 1;
    this.g = null;
    this.f = paramField;
  }

  // ERROR //
  public Object assign(Object paramObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	bsh/LHS:c	I
    //   4: ifne +40 -> 44
    //   7: aload_0
    //   8: getfield 31	bsh/LHS:b	Z
    //   11: ifeq +18 -> 29
    //   14: aload_0
    //   15: getfield 35	bsh/LHS:a	Lbsh/NameSpace;
    //   18: aload_0
    //   19: getfield 33	bsh/LHS:d	Ljava/lang/String;
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 71	bsh/NameSpace:a	(Ljava/lang/String;Ljava/lang/Object;Z)V
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 35	bsh/LHS:a	Lbsh/NameSpace;
    //   33: aload_0
    //   34: getfield 33	bsh/LHS:d	Ljava/lang/String;
    //   37: aload_1
    //   38: iload_2
    //   39: invokevirtual 74	bsh/NameSpace:setVariable	(Ljava/lang/String;Ljava/lang/Object;Z)V
    //   42: aload_1
    //   43: areturn
    //   44: aload_0
    //   45: getfield 29	bsh/LHS:c	I
    //   48: iconst_1
    //   49: if_icmpne +259 -> 308
    //   52: aload_1
    //   53: instanceof 76
    //   56: ifeq +464 -> 520
    //   59: aload_1
    //   60: checkcast 76	bsh/Primitive
    //   63: invokevirtual 80	bsh/Primitive:getValue	()Ljava/lang/Object;
    //   66: astore 34
    //   68: goto +3 -> 71
    //   71: aload_0
    //   72: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   75: invokestatic 86	bsh/ReflectManager:RMSetAccessible	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   83: aload_0
    //   84: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   87: aload 34
    //   89: invokevirtual 92	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: aload_1
    //   93: areturn
    //   94: aload_1
    //   95: instanceof 76
    //   98: ifeq +22 -> 120
    //   101: aload_1
    //   102: checkcast 76	bsh/Primitive
    //   105: invokevirtual 96	bsh/Primitive:getType	()Ljava/lang/Class;
    //   108: astore 27
    //   110: aload 27
    //   112: invokevirtual 102	java/lang/Class:getName	()Ljava/lang/String;
    //   115: astore 28
    //   117: goto +12 -> 129
    //   120: aload_1
    //   121: invokevirtual 105	java/lang/Object:getClass	()Ljava/lang/Class;
    //   124: astore 27
    //   126: goto -16 -> 110
    //   129: new 107	java/lang/StringBuffer
    //   132: dup
    //   133: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   136: astore 29
    //   138: aload 29
    //   140: ldc 110
    //   142: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   145: pop
    //   146: aload_1
    //   147: ifnonnull +7 -> 154
    //   150: ldc 116
    //   152: astore 28
    //   154: aload 29
    //   156: aload 28
    //   158: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   161: pop
    //   162: aload 29
    //   164: ldc 118
    //   166: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   169: pop
    //   170: aload 29
    //   172: aload_0
    //   173: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   176: invokevirtual 119	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   179: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: new 121	bsh/UtilEvalError
    //   186: dup
    //   187: aload 29
    //   189: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   192: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: astore 21
    //   198: new 107	java/lang/StringBuffer
    //   201: dup
    //   202: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   205: astore 22
    //   207: aload 22
    //   209: ldc 127
    //   211: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: aload 22
    //   217: aload_0
    //   218: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   221: invokevirtual 119	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   224: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   227: pop
    //   228: aload 22
    //   230: ldc 129
    //   232: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: aload 22
    //   238: aload 21
    //   240: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   243: pop
    //   244: new 121	bsh/UtilEvalError
    //   247: dup
    //   248: aload 22
    //   250: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   253: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   256: athrow
    //   257: new 107	java/lang/StringBuffer
    //   260: dup
    //   261: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   264: astore 17
    //   266: aload 17
    //   268: ldc 127
    //   270: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   273: pop
    //   274: aload 17
    //   276: aload_0
    //   277: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   280: invokevirtual 119	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   283: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: pop
    //   287: aload 17
    //   289: ldc 134
    //   291: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   294: pop
    //   295: new 121	bsh/UtilEvalError
    //   298: dup
    //   299: aload 17
    //   301: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   304: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   307: athrow
    //   308: aload_0
    //   309: getfield 29	bsh/LHS:c	I
    //   312: iconst_2
    //   313: if_icmpne +129 -> 442
    //   316: invokestatic 140	bsh/CollectionManager:getCollectionManager	()Lbsh/CollectionManager;
    //   319: astore 8
    //   321: aload 8
    //   323: aload_0
    //   324: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   327: invokevirtual 143	bsh/CollectionManager:isMap	(Ljava/lang/Object;)Z
    //   330: ifeq +20 -> 350
    //   333: aload 8
    //   335: aload_0
    //   336: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   339: aload_0
    //   340: getfield 50	bsh/LHS:e	Ljava/lang/String;
    //   343: aload_1
    //   344: invokevirtual 147	bsh/CollectionManager:putInMap	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: aload_1
    //   349: areturn
    //   350: aload_0
    //   351: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   354: aload_0
    //   355: getfield 50	bsh/LHS:e	Ljava/lang/String;
    //   358: aload_1
    //   359: invokestatic 153	bsh/Reflect:setObjectProperty	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   362: aload_1
    //   363: areturn
    //   364: astore 9
    //   366: new 107	java/lang/StringBuffer
    //   369: dup
    //   370: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   373: astore 10
    //   375: aload 10
    //   377: ldc 155
    //   379: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   382: pop
    //   383: aload 10
    //   385: aload 9
    //   387: invokevirtual 158	bsh/ReflectError:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   393: pop
    //   394: aload 10
    //   396: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   399: invokestatic 163	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   402: new 107	java/lang/StringBuffer
    //   405: dup
    //   406: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   409: astore 13
    //   411: aload 13
    //   413: ldc 165
    //   415: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   418: pop
    //   419: aload 13
    //   421: aload_0
    //   422: getfield 50	bsh/LHS:e	Ljava/lang/String;
    //   425: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   428: pop
    //   429: new 121	bsh/UtilEvalError
    //   432: dup
    //   433: aload 13
    //   435: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   438: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   441: athrow
    //   442: aload_0
    //   443: getfield 29	bsh/LHS:c	I
    //   446: iconst_3
    //   447: if_icmpne +63 -> 510
    //   450: aload_0
    //   451: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   454: aload_0
    //   455: getfield 47	bsh/LHS:h	I
    //   458: aload_1
    //   459: invokestatic 169	bsh/Reflect:setIndex	(Ljava/lang/Object;ILjava/lang/Object;)V
    //   462: aload_1
    //   463: areturn
    //   464: astore 4
    //   466: new 107	java/lang/StringBuffer
    //   469: dup
    //   470: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   473: astore 5
    //   475: aload 5
    //   477: ldc 155
    //   479: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   482: pop
    //   483: aload 5
    //   485: aload 4
    //   487: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   490: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   493: pop
    //   494: new 121	bsh/UtilEvalError
    //   497: dup
    //   498: aload 5
    //   500: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   503: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   506: athrow
    //   507: astore_3
    //   508: aload_3
    //   509: athrow
    //   510: new 172	bsh/InterpreterError
    //   513: dup
    //   514: ldc 174
    //   516: invokespecial 175	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   519: athrow
    //   520: aload_1
    //   521: astore 34
    //   523: goto -452 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   52	68	94	java/lang/IllegalArgumentException
    //   71	92	94	java/lang/IllegalArgumentException
    //   52	68	196	java/lang/IllegalAccessException
    //   71	92	196	java/lang/IllegalAccessException
    //   52	68	257	java/lang/NullPointerException
    //   71	92	257	java/lang/NullPointerException
    //   350	362	364	bsh/ReflectError
    //   450	462	464	java/lang/Exception
    //   450	462	507	bsh/UtilTargetError
  }

  // ERROR //
  public Object getValue()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	bsh/LHS:c	I
    //   4: ifne +15 -> 19
    //   7: aload_0
    //   8: getfield 35	bsh/LHS:a	Lbsh/NameSpace;
    //   11: aload_0
    //   12: getfield 33	bsh/LHS:d	Ljava/lang/String;
    //   15: invokevirtual 179	bsh/NameSpace:getVariable	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: areturn
    //   19: aload_0
    //   20: getfield 29	bsh/LHS:c	I
    //   23: iconst_1
    //   24: if_icmpne +69 -> 93
    //   27: aload_0
    //   28: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   31: aload_0
    //   32: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   35: invokevirtual 183	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: aload_0
    //   39: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   42: invokevirtual 184	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   45: invokestatic 188	bsh/Primitive:wrap	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   48: astore 14
    //   50: aload 14
    //   52: areturn
    //   53: new 107	java/lang/StringBuffer
    //   56: dup
    //   57: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   60: astore 11
    //   62: aload 11
    //   64: ldc 190
    //   66: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   69: pop
    //   70: aload 11
    //   72: aload_0
    //   73: getfield 53	bsh/LHS:f	Ljava/lang/reflect/Field;
    //   76: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: new 121	bsh/UtilEvalError
    //   83: dup
    //   84: aload 11
    //   86: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   89: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: aload_0
    //   94: getfield 29	bsh/LHS:c	I
    //   97: iconst_2
    //   98: if_icmpne +69 -> 167
    //   101: aload_0
    //   102: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   105: aload_0
    //   106: getfield 50	bsh/LHS:e	Ljava/lang/String;
    //   109: invokestatic 194	bsh/Reflect:getObjectProperty	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   112: astore 10
    //   114: aload 10
    //   116: areturn
    //   117: astore 6
    //   119: aload 6
    //   121: invokevirtual 158	bsh/ReflectError:getMessage	()Ljava/lang/String;
    //   124: invokestatic 163	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   127: new 107	java/lang/StringBuffer
    //   130: dup
    //   131: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: ldc 165
    //   140: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload 7
    //   146: aload_0
    //   147: getfield 50	bsh/LHS:e	Ljava/lang/String;
    //   150: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   153: pop
    //   154: new 121	bsh/UtilEvalError
    //   157: dup
    //   158: aload 7
    //   160: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   163: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: aload_0
    //   168: getfield 29	bsh/LHS:c	I
    //   171: iconst_3
    //   172: if_icmpne +53 -> 225
    //   175: aload_0
    //   176: getfield 45	bsh/LHS:g	Ljava/lang/Object;
    //   179: aload_0
    //   180: getfield 47	bsh/LHS:h	I
    //   183: invokestatic 198	bsh/Reflect:getIndex	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   186: astore 5
    //   188: aload 5
    //   190: areturn
    //   191: astore_1
    //   192: new 107	java/lang/StringBuffer
    //   195: dup
    //   196: invokespecial 108	java/lang/StringBuffer:<init>	()V
    //   199: astore_2
    //   200: aload_2
    //   201: ldc 200
    //   203: invokevirtual 114	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   206: pop
    //   207: aload_2
    //   208: aload_1
    //   209: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: new 121	bsh/UtilEvalError
    //   216: dup
    //   217: aload_2
    //   218: invokevirtual 124	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   221: invokespecial 125	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: new 172	bsh/InterpreterError
    //   228: dup
    //   229: ldc 202
    //   231: invokespecial 175	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   27	50	53	java/lang/IllegalAccessException
    //   101	114	117	bsh/ReflectError
    //   175	188	191	java/lang/Exception
  }

  public String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("LHS: ");
    String str1;
    if (this.f != null)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("field = ");
      localStringBuffer2.append(this.f.toString());
      str1 = localStringBuffer2.toString();
    }
    else
    {
      str1 = "";
    }
    localStringBuffer1.append(str1);
    String str2;
    if (this.d != null)
    {
      StringBuffer localStringBuffer3 = new StringBuffer();
      localStringBuffer3.append(" varName = ");
      localStringBuffer3.append(this.d);
      str2 = localStringBuffer3.toString();
    }
    else
    {
      str2 = "";
    }
    localStringBuffer1.append(str2);
    String str3;
    if (this.a != null)
    {
      StringBuffer localStringBuffer4 = new StringBuffer();
      localStringBuffer4.append(" nameSpace = ");
      localStringBuffer4.append(this.a.toString());
      str3 = localStringBuffer4.toString();
    }
    else
    {
      str3 = "";
    }
    localStringBuffer1.append(str3);
    return localStringBuffer1.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.LHS
 * JD-Core Version:    0.6.2
 */