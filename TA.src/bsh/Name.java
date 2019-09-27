package bsh;

import java.io.Serializable;

class Name
  implements Serializable
{
  private static String f;
  String a = null;
  Class b;
  Class c;
  private String d;
  private String e;
  private Object g;
  private int h;
  public NameSpace namespace;

  Name(NameSpace paramNameSpace, String paramString)
  {
    this.namespace = paramNameSpace;
    this.a = paramString;
  }

  static int a(String paramString)
  {
    if (paramString == null)
      return 0;
    int i = -1;
    for (int j = 0; ; j++)
    {
      i = paramString.indexOf('.', i + 1);
      if (i == -1)
        return j + 1;
    }
  }

  static NameSpace a(NameSpace paramNameSpace)
  {
    if (paramNameSpace.d)
      return paramNameSpace;
    if ((paramNameSpace.c) && (paramNameSpace.getParent() != null) && (paramNameSpace.getParent().d))
      return paramNameSpace.getParent();
    return null;
  }

  // ERROR //
  private Object a(CallStack paramCallStack, Interpreter paramInterpreter, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   4: ifnonnull +56 -> 60
    //   7: aload_0
    //   8: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   11: invokestatic 60	bsh/Name:isCompound	(Ljava/lang/String;)Z
    //   14: ifne +46 -> 60
    //   17: iload_3
    //   18: ifne +42 -> 60
    //   21: aload_0
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   32: iconst_0
    //   33: invokevirtual 63	bsh/Name:a	(Lbsh/CallStack;Lbsh/NameSpace;Lbsh/Interpreter;Ljava/lang/String;Z)Ljava/lang/Object;
    //   36: astore 82
    //   38: aload 82
    //   40: getstatic 69	bsh/Primitive:VOID	Lbsh/Primitive;
    //   43: if_acmpeq +17 -> 60
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   51: getstatic 71	bsh/Name:f	Ljava/lang/String;
    //   54: aload 82
    //   56: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: aload_0
    //   61: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   64: iconst_1
    //   65: invokestatic 77	bsh/Name:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   74: ifnull +13 -> 87
    //   77: aload_0
    //   78: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   81: instanceof 79
    //   84: ifeq +178 -> 262
    //   87: iload_3
    //   88: ifne +174 -> 262
    //   91: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   94: ifeq +36 -> 130
    //   97: new 86	java/lang/StringBuffer
    //   100: dup
    //   101: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   104: astore 71
    //   106: aload 71
    //   108: ldc 89
    //   110: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   113: pop
    //   114: aload 71
    //   116: aload 5
    //   118: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   121: pop
    //   122: aload 71
    //   124: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   127: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   134: ifnonnull +29 -> 163
    //   137: aload_0
    //   138: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   141: astore 74
    //   143: iconst_0
    //   144: istore 75
    //   146: aload_0
    //   147: aload_1
    //   148: aload 74
    //   150: aload_2
    //   151: aload 5
    //   153: iload 75
    //   155: invokevirtual 63	bsh/Name:a	(Lbsh/CallStack;Lbsh/NameSpace;Lbsh/Interpreter;Ljava/lang/String;Z)Ljava/lang/Object;
    //   158: astore 76
    //   160: goto +21 -> 181
    //   163: aload_0
    //   164: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   167: checkcast 79	bsh/This
    //   170: getfield 103	bsh/This:a	Lbsh/NameSpace;
    //   173: astore 74
    //   175: iconst_1
    //   176: istore 75
    //   178: goto -32 -> 146
    //   181: aload 76
    //   183: getstatic 69	bsh/Primitive:VOID	Lbsh/Primitive;
    //   186: if_acmpeq +76 -> 262
    //   189: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   192: ifeq +54 -> 246
    //   195: new 86	java/lang/StringBuffer
    //   198: dup
    //   199: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   202: astore 77
    //   204: aload 77
    //   206: ldc 105
    //   208: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   211: pop
    //   212: aload 77
    //   214: aload 5
    //   216: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   219: pop
    //   220: aload 77
    //   222: ldc 107
    //   224: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   227: pop
    //   228: aload 77
    //   230: aload_0
    //   231: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   234: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   237: pop
    //   238: aload 77
    //   240: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   243: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: aload 5
    //   249: aload_0
    //   250: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   253: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   256: aload 76
    //   258: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: areturn
    //   262: aload_0
    //   263: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   266: ifnonnull +183 -> 449
    //   269: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   272: ifeq +38 -> 310
    //   275: new 86	java/lang/StringBuffer
    //   278: dup
    //   279: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   282: astore 62
    //   284: aload 62
    //   286: ldc 115
    //   288: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   291: pop
    //   292: aload 62
    //   294: aload_0
    //   295: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   298: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   301: pop
    //   302: aload 62
    //   304: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   307: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   310: aconst_null
    //   311: astore 65
    //   313: aconst_null
    //   314: astore 66
    //   316: iconst_1
    //   317: istore 67
    //   319: iload 67
    //   321: aload_0
    //   322: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   325: invokestatic 117	bsh/Name:a	(Ljava/lang/String;)I
    //   328: if_icmple +6 -> 334
    //   331: goto +30 -> 361
    //   334: aload_0
    //   335: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   338: iload 67
    //   340: invokestatic 77	bsh/Name:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   343: astore 66
    //   345: aload_0
    //   346: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   349: aload 66
    //   351: invokevirtual 121	bsh/NameSpace:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   354: astore 65
    //   356: aload 65
    //   358: ifnull +85 -> 443
    //   361: aload 65
    //   363: ifnull +36 -> 399
    //   366: aload_0
    //   367: aload 66
    //   369: aload_0
    //   370: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   373: aload_0
    //   374: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   377: invokestatic 117	bsh/Name:a	(Ljava/lang/String;)I
    //   380: iload 67
    //   382: isub
    //   383: invokestatic 124	bsh/Name:suffix	(Ljava/lang/String;I)Ljava/lang/String;
    //   386: new 126	bsh/ClassIdentifier
    //   389: dup
    //   390: aload 65
    //   392: invokespecial 129	bsh/ClassIdentifier:<init>	(Ljava/lang/Class;)V
    //   395: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: areturn
    //   399: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   402: ifeq +47 -> 449
    //   405: new 86	java/lang/StringBuffer
    //   408: dup
    //   409: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   412: astore 68
    //   414: aload 68
    //   416: ldc 131
    //   418: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   421: pop
    //   422: aload 68
    //   424: aload_0
    //   425: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   428: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   431: pop
    //   432: aload 68
    //   434: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   437: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   440: goto +9 -> 449
    //   443: iinc 67 1
    //   446: goto -127 -> 319
    //   449: aload_0
    //   450: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   453: ifnull +13 -> 466
    //   456: aload_0
    //   457: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   460: instanceof 79
    //   463: ifeq +111 -> 574
    //   466: iload_3
    //   467: ifne +107 -> 574
    //   470: iload 4
    //   472: ifeq +102 -> 574
    //   475: aload_0
    //   476: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   479: ifnonnull +12 -> 491
    //   482: aload_0
    //   483: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   486: astore 57
    //   488: goto +15 -> 503
    //   491: aload_0
    //   492: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   495: checkcast 79	bsh/This
    //   498: getfield 103	bsh/This:a	Lbsh/NameSpace;
    //   501: astore 57
    //   503: new 86	java/lang/StringBuffer
    //   506: dup
    //   507: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   510: astore 58
    //   512: aload 58
    //   514: ldc 133
    //   516: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   519: pop
    //   520: aload 58
    //   522: aload 5
    //   524: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   527: pop
    //   528: new 40	bsh/NameSpace
    //   531: dup
    //   532: aload 57
    //   534: aload 58
    //   536: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   539: invokespecial 135	bsh/NameSpace:<init>	(Lbsh/NameSpace;Ljava/lang/String;)V
    //   542: aload_2
    //   543: invokevirtual 138	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   546: astore 61
    //   548: aload 57
    //   550: aload 5
    //   552: aload 61
    //   554: iconst_0
    //   555: invokevirtual 142	bsh/NameSpace:setVariable	(Ljava/lang/String;Ljava/lang/Object;Z)V
    //   558: aload_0
    //   559: aload 5
    //   561: aload_0
    //   562: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   565: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   568: aload 61
    //   570: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: areturn
    //   574: aload_0
    //   575: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   578: ifnonnull +68 -> 646
    //   581: aload_0
    //   582: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   585: invokestatic 60	bsh/Name:isCompound	(Ljava/lang/String;)Z
    //   588: ifne +18 -> 606
    //   591: aload_0
    //   592: aload_0
    //   593: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   596: getstatic 71	bsh/Name:f	Ljava/lang/String;
    //   599: getstatic 69	bsh/Primitive:VOID	Lbsh/Primitive;
    //   602: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: areturn
    //   606: new 86	java/lang/StringBuffer
    //   609: dup
    //   610: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   613: astore 54
    //   615: aload 54
    //   617: ldc 144
    //   619: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   622: pop
    //   623: aload 54
    //   625: aload_0
    //   626: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   629: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   632: pop
    //   633: new 146	bsh/UtilEvalError
    //   636: dup
    //   637: aload 54
    //   639: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   642: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   645: athrow
    //   646: aload_0
    //   647: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   650: getstatic 151	bsh/Primitive:NULL	Lbsh/Primitive;
    //   653: if_acmpne +50 -> 703
    //   656: new 86	java/lang/StringBuffer
    //   659: dup
    //   660: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   663: astore 6
    //   665: aload 6
    //   667: ldc 153
    //   669: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   672: pop
    //   673: aload 6
    //   675: aload_0
    //   676: getfield 28	bsh/Name:a	Ljava/lang/String;
    //   679: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   682: pop
    //   683: new 155	bsh/UtilTargetError
    //   686: dup
    //   687: new 157	java/lang/NullPointerException
    //   690: dup
    //   691: aload 6
    //   693: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   696: invokespecial 158	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   699: invokespecial 161	bsh/UtilTargetError:<init>	(Ljava/lang/Throwable;)V
    //   702: athrow
    //   703: aload_0
    //   704: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   707: getstatic 69	bsh/Primitive:VOID	Lbsh/Primitive;
    //   710: if_acmpne +43 -> 753
    //   713: new 86	java/lang/StringBuffer
    //   716: dup
    //   717: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   720: astore 9
    //   722: aload 9
    //   724: ldc 163
    //   726: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   729: pop
    //   730: aload 9
    //   732: aload_0
    //   733: getfield 28	bsh/Name:a	Ljava/lang/String;
    //   736: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   739: pop
    //   740: new 146	bsh/UtilEvalError
    //   743: dup
    //   744: aload 9
    //   746: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   749: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   752: athrow
    //   753: aload_0
    //   754: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   757: instanceof 65
    //   760: ifeq +43 -> 803
    //   763: new 86	java/lang/StringBuffer
    //   766: dup
    //   767: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   770: astore 12
    //   772: aload 12
    //   774: ldc 165
    //   776: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   779: pop
    //   780: aload 12
    //   782: aload_0
    //   783: getfield 28	bsh/Name:a	Ljava/lang/String;
    //   786: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   789: pop
    //   790: new 146	bsh/UtilEvalError
    //   793: dup
    //   794: aload 12
    //   796: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   799: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   802: athrow
    //   803: aload_0
    //   804: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   807: instanceof 126
    //   810: ifeq +395 -> 1205
    //   813: aload_0
    //   814: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   817: checkcast 126	bsh/ClassIdentifier
    //   820: invokevirtual 169	bsh/ClassIdentifier:getTargetClass	()Ljava/lang/Class;
    //   823: astore 27
    //   825: aload_0
    //   826: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   829: iconst_1
    //   830: invokestatic 77	bsh/Name:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   833: astore 28
    //   835: aload 28
    //   837: ldc 171
    //   839: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   842: ifeq +102 -> 944
    //   845: aload_0
    //   846: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   849: astore 50
    //   851: aload 50
    //   853: ifnonnull +41 -> 894
    //   856: new 86	java/lang/StringBuffer
    //   859: dup
    //   860: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   863: astore 51
    //   865: aload 51
    //   867: ldc 177
    //   869: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   872: pop
    //   873: aload 51
    //   875: aload 27
    //   877: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   880: pop
    //   881: new 146	bsh/UtilEvalError
    //   884: dup
    //   885: aload 51
    //   887: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   890: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   893: athrow
    //   894: aload 50
    //   896: getfield 179	bsh/NameSpace:f	Ljava/lang/Object;
    //   899: ifnull +35 -> 934
    //   902: aload 50
    //   904: getfield 179	bsh/NameSpace:f	Ljava/lang/Object;
    //   907: invokevirtual 181	java/lang/Object:getClass	()Ljava/lang/Class;
    //   910: aload 27
    //   912: if_acmpne +22 -> 934
    //   915: aload_0
    //   916: aload 28
    //   918: aload_0
    //   919: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   922: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   925: aload 50
    //   927: getfield 179	bsh/NameSpace:f	Ljava/lang/Object;
    //   930: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   933: areturn
    //   934: aload 50
    //   936: invokevirtual 49	bsh/NameSpace:getParent	()Lbsh/NameSpace;
    //   939: astore 50
    //   941: goto -90 -> 851
    //   944: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   947: ifeq +52 -> 999
    //   950: new 86	java/lang/StringBuffer
    //   953: dup
    //   954: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   957: astore 45
    //   959: aload 45
    //   961: ldc 183
    //   963: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   966: pop
    //   967: aload 45
    //   969: aload 27
    //   971: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   974: pop
    //   975: aload 45
    //   977: ldc 185
    //   979: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload 45
    //   985: aload 28
    //   987: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   990: pop
    //   991: aload 45
    //   993: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   996: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   999: aload 27
    //   1001: aload 28
    //   1003: invokestatic 191	bsh/Reflect:getStaticFieldValue	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   1006: astore 33
    //   1008: goto +47 -> 1055
    //   1011: astore 29
    //   1013: getstatic 84	bsh/Interpreter:DEBUG	Z
    //   1016: ifeq +36 -> 1052
    //   1019: new 86	java/lang/StringBuffer
    //   1022: dup
    //   1023: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   1026: astore 30
    //   1028: aload 30
    //   1030: ldc 193
    //   1032: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1035: pop
    //   1036: aload 30
    //   1038: aload 29
    //   1040: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   1043: pop
    //   1044: aload 30
    //   1046: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1049: invokestatic 101	bsh/Interpreter:debug	(Ljava/lang/String;)V
    //   1052: aconst_null
    //   1053: astore 33
    //   1055: aload 33
    //   1057: ifnonnull +73 -> 1130
    //   1060: new 86	java/lang/StringBuffer
    //   1063: dup
    //   1064: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   1067: astore 34
    //   1069: aload 34
    //   1071: aload 27
    //   1073: invokevirtual 198	java/lang/Class:getName	()Ljava/lang/String;
    //   1076: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1079: pop
    //   1080: aload 34
    //   1082: ldc 200
    //   1084: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1087: pop
    //   1088: aload 34
    //   1090: aload 28
    //   1092: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1095: pop
    //   1096: aload 34
    //   1098: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1101: astore 38
    //   1103: aload_0
    //   1104: getfield 30	bsh/Name:namespace	Lbsh/NameSpace;
    //   1107: aload 38
    //   1109: invokevirtual 121	bsh/NameSpace:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   1112: astore 39
    //   1114: aload 39
    //   1116: ifnull +14 -> 1130
    //   1119: new 126	bsh/ClassIdentifier
    //   1122: dup
    //   1123: aload 39
    //   1125: invokespecial 129	bsh/ClassIdentifier:<init>	(Ljava/lang/Class;)V
    //   1128: astore 33
    //   1130: aload 33
    //   1132: ifnonnull +57 -> 1189
    //   1135: new 86	java/lang/StringBuffer
    //   1138: dup
    //   1139: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   1142: astore 40
    //   1144: aload 40
    //   1146: ldc 202
    //   1148: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1151: pop
    //   1152: aload 40
    //   1154: aload 28
    //   1156: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1159: pop
    //   1160: aload 40
    //   1162: ldc 204
    //   1164: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1167: pop
    //   1168: aload 40
    //   1170: aload 27
    //   1172: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   1175: pop
    //   1176: new 146	bsh/UtilEvalError
    //   1179: dup
    //   1180: aload 40
    //   1182: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1185: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   1188: athrow
    //   1189: aload_0
    //   1190: aload 28
    //   1192: aload_0
    //   1193: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   1196: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1199: aload 33
    //   1201: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1204: areturn
    //   1205: iload_3
    //   1206: ifeq +43 -> 1249
    //   1209: new 86	java/lang/StringBuffer
    //   1212: dup
    //   1213: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   1216: astore 15
    //   1218: aload 15
    //   1220: aload_0
    //   1221: getfield 28	bsh/Name:a	Ljava/lang/String;
    //   1224: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1227: pop
    //   1228: aload 15
    //   1230: ldc 206
    //   1232: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1235: pop
    //   1236: new 146	bsh/UtilEvalError
    //   1239: dup
    //   1240: aload 15
    //   1242: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1245: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   1248: athrow
    //   1249: aload_0
    //   1250: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   1253: iconst_1
    //   1254: invokestatic 77	bsh/Name:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1257: astore 18
    //   1259: aload 18
    //   1261: ldc 208
    //   1263: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1266: ifeq +48 -> 1314
    //   1269: aload_0
    //   1270: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   1273: invokevirtual 181	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1276: invokevirtual 212	java/lang/Class:isArray	()Z
    //   1279: ifeq +35 -> 1314
    //   1282: new 65	bsh/Primitive
    //   1285: dup
    //   1286: aload_0
    //   1287: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   1290: invokestatic 218	java/lang/reflect/Array:getLength	(Ljava/lang/Object;)I
    //   1293: invokespecial 221	bsh/Primitive:<init>	(I)V
    //   1296: astore 26
    //   1298: aload_0
    //   1299: aload 18
    //   1301: aload_0
    //   1302: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   1305: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1308: aload 26
    //   1310: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1313: areturn
    //   1314: aload_0
    //   1315: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   1318: aload 18
    //   1320: invokestatic 225	bsh/Reflect:getObjectFieldValue	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   1323: astore 24
    //   1325: aload_0
    //   1326: aload 18
    //   1328: aload_0
    //   1329: getfield 56	bsh/Name:d	Ljava/lang/String;
    //   1332: invokestatic 113	bsh/Name:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: aload 24
    //   1337: invokespecial 74	bsh/Name:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1340: astore 25
    //   1342: aload 25
    //   1344: areturn
    //   1345: new 86	java/lang/StringBuffer
    //   1348: dup
    //   1349: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   1352: astore 19
    //   1354: aload 19
    //   1356: ldc 227
    //   1358: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1361: pop
    //   1362: aload 19
    //   1364: aload 18
    //   1366: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1369: pop
    //   1370: aload 19
    //   1372: ldc 229
    //   1374: invokevirtual 93	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1377: pop
    //   1378: aload 19
    //   1380: aload_0
    //   1381: getfield 54	bsh/Name:g	Ljava/lang/Object;
    //   1384: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   1387: pop
    //   1388: new 146	bsh/UtilEvalError
    //   1391: dup
    //   1392: aload 19
    //   1394: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1397: invokespecial 148	bsh/UtilEvalError:<init>	(Ljava/lang/String;)V
    //   1400: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   944	999	1011	bsh/ReflectError
    //   999	1008	1011	bsh/ReflectError
    //   1314	1342	1345	bsh/ReflectError
  }

  private Object a(Interpreter paramInterpreter, Object[] paramArrayOfObject, CallStack paramCallStack, SimpleNode paramSimpleNode)
  {
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("invokeLocalMethod: ");
      localStringBuffer1.append(this.a);
      Interpreter.debug(localStringBuffer1.toString());
    }
    if (paramInterpreter == null)
      throw new InterpreterError("invokeLocalMethod: interpreter = null");
    String str = this.a;
    Class[] arrayOfClass = Types.getTypes(paramArrayOfObject);
    try
    {
      BshMethod localBshMethod1 = this.namespace.getMethod(str, arrayOfClass);
      if (localBshMethod1 != null)
        return localBshMethod1.invoke(paramArrayOfObject, paramInterpreter, paramCallStack, paramSimpleNode);
      paramInterpreter.getClassManager();
      try
      {
        Object localObject1 = this.namespace.getCommand(str, arrayOfClass, paramInterpreter);
        if (localObject1 == null)
          try
          {
            BshMethod localBshMethod2 = this.namespace.getMethod("invoke", new Class[] { null, null });
            if (localBshMethod2 != null)
              return localBshMethod2.invoke(new Object[] { str, paramArrayOfObject }, paramInterpreter, paramCallStack, paramSimpleNode);
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append("Command not found: ");
            localStringBuffer2.append(StringUtil.methodString(str, arrayOfClass));
            throw new EvalError(localStringBuffer2.toString(), paramSimpleNode, paramCallStack);
          }
          catch (UtilEvalError localUtilEvalError4)
          {
            throw localUtilEvalError4.toEvalError("Local method invocation", paramSimpleNode, paramCallStack);
          }
        if ((localObject1 instanceof BshMethod))
          return ((BshMethod)localObject1).invoke(paramArrayOfObject, paramInterpreter, paramCallStack, paramSimpleNode);
        if ((localObject1 instanceof Class))
          try
          {
            Object localObject2 = Reflect.invokeCompiledCommand((Class)localObject1, paramArrayOfObject, paramInterpreter, paramCallStack);
            return localObject2;
          }
          catch (UtilEvalError localUtilEvalError3)
          {
            throw localUtilEvalError3.toEvalError("Error invoking compiled command: ", paramSimpleNode, paramCallStack);
          }
        throw new InterpreterError("invalid command type");
      }
      catch (UtilEvalError localUtilEvalError2)
      {
        throw localUtilEvalError2.toEvalError("Error loading command: ", paramSimpleNode, paramCallStack);
      }
    }
    catch (UtilEvalError localUtilEvalError1)
    {
      throw localUtilEvalError1.toEvalError("Local method invocation", paramSimpleNode, paramCallStack);
    }
  }

  private Object a(String paramString1, String paramString2, Object paramObject)
  {
    if (paramObject == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("lastEvalName = ");
      localStringBuffer.append(paramString1);
      throw new InterpreterError(localStringBuffer.toString());
    }
    this.e = paramString1;
    this.d = paramString2;
    this.g = paramObject;
    return paramObject;
  }

  static String a(String paramString, int paramInt)
  {
    if (paramInt < 1)
      return null;
    int i = -1;
    int j = 0;
    do
    {
      i = paramString.indexOf('.', i + 1);
      if (i == -1)
        break;
      j++;
    }
    while (j < paramInt);
    if (i == -1)
      return paramString;
    return paramString.substring(0, i);
  }

  private void a()
  {
    this.d = this.a;
    this.g = null;
    this.h = 0;
  }

  static String b(String paramString)
  {
    if (!isCompound(paramString))
      return null;
    return a(paramString, -1 + a(paramString));
  }

  static String c(String paramString)
  {
    if (!isCompound(paramString))
      return null;
    return suffix(paramString, -1 + a(paramString));
  }

  public static boolean isCompound(String paramString)
  {
    return paramString.indexOf('.') != -1;
  }

  public static String suffix(String paramString, int paramInt)
  {
    if (paramInt < 1)
      return null;
    int i = 0;
    int j = 1 + paramString.length();
    do
    {
      j = paramString.lastIndexOf('.', j - 1);
      if (j == -1)
        break;
      i++;
    }
    while (i < paramInt);
    if (j == -1)
      return paramString;
    return paramString.substring(j + 1);
  }

  Object a(CallStack paramCallStack, NameSpace paramNameSpace, Interpreter paramInterpreter, String paramString, boolean paramBoolean)
  {
    if (paramString.equals("this"))
    {
      if (paramBoolean)
        throw new UtilEvalError("Redundant to call .this on This type");
      Object localObject2 = paramNameSpace.a(paramInterpreter);
      NameSpace localNameSpace2 = a(((This)localObject2).getNameSpace());
      if (localNameSpace2 != null)
      {
        if (isCompound(this.d))
          return localNameSpace2.a(paramInterpreter);
        localObject2 = localNameSpace2.a();
      }
      return localObject2;
    }
    if (paramString.equals("super"))
    {
      This localThis = paramNameSpace.getSuper(paramInterpreter);
      NameSpace localNameSpace1 = localThis.getNameSpace();
      if ((localNameSpace1.getParent() != null) && (localNameSpace1.getParent().d))
        localThis = localNameSpace1.getParent().a(paramInterpreter);
      return localThis;
    }
    boolean bool = paramString.equals("global");
    Object localObject1 = null;
    if (bool)
      localObject1 = paramNameSpace.getGlobal(paramInterpreter);
    if ((localObject1 == null) && (paramBoolean))
      if (paramString.equals("namespace"))
        localObject1 = paramNameSpace;
      else if (paramString.equals("variables"))
        localObject1 = paramNameSpace.getVariableNames();
      else if (paramString.equals("methods"))
        localObject1 = paramNameSpace.getMethodNames();
      else if (paramString.equals("interpreter"))
        if (this.e.equals("this"))
          localObject1 = paramInterpreter;
        else
          throw new UtilEvalError("Can only call .interpreter on literal 'this'");
    if ((localObject1 == null) && (paramBoolean) && (paramString.equals("caller")))
    {
      if ((!this.e.equals("this")) && (!this.e.equals("caller")))
        throw new UtilEvalError("Can only call .caller on literal 'this' or literal '.caller'");
      if (paramCallStack == null)
        throw new InterpreterError("no callstack");
      int i = 1 + this.h;
      this.h = i;
      return paramCallStack.get(i).a(paramInterpreter);
    }
    if ((localObject1 == null) && (paramBoolean) && (paramString.equals("callstack")))
    {
      if (this.e.equals("this"))
      {
        if (paramCallStack == null)
          throw new InterpreterError("no callstack");
      }
      else
        throw new UtilEvalError("Can only call .callstack on literal 'this'");
    }
    else
      paramCallStack = (CallStack)localObject1;
    if (paramCallStack == null)
      paramCallStack = paramNameSpace.getVariable(paramString);
    if (paramCallStack == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("null this field ref:");
      localStringBuffer.append(paramString);
      throw new InterpreterError(localStringBuffer.toString());
    }
    return paramCallStack;
  }

  public Object invokeMethod(Interpreter paramInterpreter, Object[] paramArrayOfObject, CallStack paramCallStack, SimpleNode paramSimpleNode)
  {
    String str1 = suffix(this.a, 1);
    BshClassManager localBshClassManager = paramInterpreter.getClassManager();
    NameSpace localNameSpace1 = paramCallStack.top();
    if (this.c != null)
      return Reflect.invokeStaticMethod(localBshClassManager, this.c, str1, paramArrayOfObject);
    if (!isCompound(this.a))
      return a(paramInterpreter, paramArrayOfObject, paramCallStack, paramSimpleNode);
    String str2 = b(this.a);
    if ((str2.equals("super")) && (a(this.a) == 2))
    {
      NameSpace localNameSpace2 = a(localNameSpace1.a(paramInterpreter).getNameSpace());
      if (localNameSpace2 != null)
      {
        Object localObject2 = localNameSpace2.a();
        return ClassGenerator.getClassGenerator().invokeSuperclassMethod(localBshClassManager, localObject2, str1, paramArrayOfObject);
      }
    }
    Name localName = localNameSpace1.b(str2);
    Object localObject1 = localName.toObject(paramCallStack, paramInterpreter);
    if (localObject1 == Primitive.VOID)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Attempt to resolve method: ");
      localStringBuffer1.append(str1);
      localStringBuffer1.append("() on undefined variable or class name: ");
      localStringBuffer1.append(localName);
      throw new UtilEvalError(localStringBuffer1.toString());
    }
    if (!(localObject1 instanceof ClassIdentifier))
    {
      if ((localObject1 instanceof Primitive))
      {
        if (localObject1 == Primitive.NULL)
          throw new UtilTargetError(new NullPointerException("Null Pointer in Method Invocation"));
        if (Interpreter.DEBUG)
          Interpreter.debug("Attempt to access method on primitive... allowing bsh.Primitive to peek through for debugging");
      }
      return Reflect.invokeObjectMethod(localObject1, str1, paramArrayOfObject, paramInterpreter, paramCallStack, paramSimpleNode);
    }
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("invokeMethod: trying static - ");
      localStringBuffer2.append(localName);
      Interpreter.debug(localStringBuffer2.toString());
    }
    Class localClass = ((ClassIdentifier)localObject1).getTargetClass();
    this.c = localClass;
    if (localClass != null)
      return Reflect.invokeStaticMethod(localBshClassManager, localClass, str1, paramArrayOfObject);
    StringBuffer localStringBuffer3 = new StringBuffer();
    localStringBuffer3.append("invokeMethod: unknown target: ");
    localStringBuffer3.append(localName);
    throw new UtilEvalError(localStringBuffer3.toString());
  }

  public Class toClass()
  {
    try
    {
      if (this.b != null)
      {
        Class localClass3 = this.b;
        return localClass3;
      }
      a();
      boolean bool = this.d.equals("var");
      Object localObject2 = null;
      if (bool)
      {
        this.b = null;
        return null;
      }
      Class localClass1 = this.namespace.getClass(this.d);
      if (localClass1 == null)
      {
        try
        {
          Object localObject3 = toObject(null, null, true);
          localObject2 = localObject3;
        }
        catch (UtilEvalError localUtilEvalError)
        {
        }
        if ((localObject2 instanceof ClassIdentifier))
          localClass1 = ((ClassIdentifier)localObject2).getTargetClass();
      }
      if (localClass1 == null)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Class: ");
        localStringBuffer.append(this.a);
        localStringBuffer.append(" not found in namespace");
        throw new ClassNotFoundException(localStringBuffer.toString());
      }
      this.b = localClass1;
      Class localClass2 = this.b;
      return localClass2;
    }
    finally
    {
    }
  }

  public LHS toLHS(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    try
    {
      a();
      if (!isCompound(this.d))
      {
        if (this.d.equals("this"))
          throw new UtilEvalError("Can't assign to 'this'.");
        LHS localLHS4 = new LHS(this.namespace, this.d, false);
        return localLHS4;
      }
      Object localObject2 = null;
      try
      {
        while ((this.d != null) && (isCompound(this.d)))
          localObject2 = a(paramCallStack, paramInterpreter, false, true);
        if ((this.d == null) && ((localObject2 instanceof ClassIdentifier)))
        {
          StringBuffer localStringBuffer5 = new StringBuffer();
          localStringBuffer5.append("Can't assign to class: ");
          localStringBuffer5.append(this.a);
          throw new UtilEvalError(localStringBuffer5.toString());
        }
        if (localObject2 == null)
        {
          StringBuffer localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append("Error in LHS: ");
          localStringBuffer2.append(this.a);
          throw new UtilEvalError(localStringBuffer2.toString());
        }
        if ((localObject2 instanceof This))
        {
          if ((!this.d.equals("namespace")) && (!this.d.equals("variables")) && (!this.d.equals("methods")) && (!this.d.equals("caller")))
          {
            Interpreter.debug("found This reference evaluating LHS");
            boolean bool = true ^ this.e.equals("super");
            LHS localLHS3 = new LHS(((This)localObject2).a, this.d, bool);
            return localLHS3;
          }
          StringBuffer localStringBuffer4 = new StringBuffer();
          localStringBuffer4.append("Can't assign to special variable: ");
          localStringBuffer4.append(this.d);
          throw new UtilEvalError(localStringBuffer4.toString());
        }
        String str = this.d;
        if (str != null)
          try
          {
            if ((localObject2 instanceof ClassIdentifier))
            {
              LHS localLHS2 = Reflect.a(((ClassIdentifier)localObject2).getTargetClass(), this.d);
              return localLHS2;
            }
            LHS localLHS1 = Reflect.a(localObject2, this.d);
            return localLHS1;
          }
          catch (ReflectError localReflectError)
          {
            StringBuffer localStringBuffer3 = new StringBuffer();
            localStringBuffer3.append("Field access: ");
            localStringBuffer3.append(localReflectError);
            throw new UtilEvalError(localStringBuffer3.toString());
          }
        throw new InterpreterError("Internal error in lhs...");
      }
      catch (UtilEvalError localUtilEvalError)
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append("LHS evaluation: ");
        localStringBuffer1.append(localUtilEvalError.getMessage());
        throw new UtilEvalError(localStringBuffer1.toString());
      }
    }
    finally
    {
    }
  }

  public Object toObject(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    return toObject(paramCallStack, paramInterpreter, false);
  }

  public Object toObject(CallStack paramCallStack, Interpreter paramInterpreter, boolean paramBoolean)
  {
    try
    {
      a();
      for (Object localObject2 = null; ; localObject2 = a(paramCallStack, paramInterpreter, paramBoolean, false))
        if (this.d == null)
        {
          if (localObject2 == null)
            throw new InterpreterError("null value in toObject()");
          return localObject2;
        }
    }
    finally
    {
    }
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Name
 * JD-Core Version:    0.6.2
 */