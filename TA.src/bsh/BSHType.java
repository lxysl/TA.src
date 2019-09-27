package bsh;

class BSHType extends SimpleNode
  implements BshClassManager.Listener
{
  String a;
  private Class b;
  private int c;
  private Class d;

  BSHType(int paramInt)
  {
    super(paramInt);
  }

  public static String getTypeDescriptor(Class paramClass)
  {
    if (paramClass == Boolean.TYPE)
      return "Z";
    if (paramClass == Character.TYPE)
      return "C";
    if (paramClass == Byte.TYPE)
      return "B";
    if (paramClass == Short.TYPE)
      return "S";
    if (paramClass == Integer.TYPE)
      return "I";
    if (paramClass == Long.TYPE)
      return "J";
    if (paramClass == Float.TYPE)
      return "F";
    if (paramClass == Double.TYPE)
      return "D";
    if (paramClass == Void.TYPE)
      return "V";
    String str = paramClass.getName().replace('.', '/');
    if (!str.startsWith("["))
    {
      if (str.endsWith(";"))
        return str;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("L");
      localStringBuffer.append(str.replace('.', '/'));
      localStringBuffer.append(";");
      str = localStringBuffer.toString();
    }
    return str;
  }

  SimpleNode a()
  {
    return (SimpleNode)jjtGetChild(0);
  }

  public void addArrayDimension()
  {
    this.c = (1 + this.c);
  }

  public void classLoaderChanged()
  {
    this.d = null;
    this.b = null;
  }

  public int getArrayDims()
  {
    return this.c;
  }

  public Class getBaseType()
  {
    return this.b;
  }

  // ERROR //
  public Class getType(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 113	bsh/BSHType:d	Ljava/lang/Class;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 113	bsh/BSHType:d	Ljava/lang/Class;
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 125	bsh/BSHType:a	()Lbsh/SimpleNode;
    //   16: astore_3
    //   17: aload_3
    //   18: instanceof 127
    //   21: ifeq +21 -> 42
    //   24: aload_3
    //   25: checkcast 127	bsh/BSHPrimitiveType
    //   28: invokevirtual 129	bsh/BSHPrimitiveType:getType	()Ljava/lang/Class;
    //   31: astore 4
    //   33: aload_0
    //   34: aload 4
    //   36: putfield 115	bsh/BSHType:b	Ljava/lang/Class;
    //   39: goto +17 -> 56
    //   42: aload_3
    //   43: checkcast 131	bsh/BSHAmbiguousName
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 134	bsh/BSHAmbiguousName:toClass	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Class;
    //   51: astore 4
    //   53: goto -20 -> 33
    //   56: aload_0
    //   57: getfield 110	bsh/BSHType:c	I
    //   60: ifle +42 -> 102
    //   63: aload_0
    //   64: getfield 110	bsh/BSHType:c	I
    //   67: newarray int
    //   69: astore 5
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 115	bsh/BSHType:b	Ljava/lang/Class;
    //   76: aload 5
    //   78: invokestatic 140	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;[I)Ljava/lang/Object;
    //   81: invokevirtual 145	java/lang/Object:getClass	()Ljava/lang/Class;
    //   84: putfield 113	bsh/BSHType:d	Ljava/lang/Class;
    //   87: goto +23 -> 110
    //   90: new 147	bsh/EvalError
    //   93: dup
    //   94: ldc 149
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 152	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   101: athrow
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 115	bsh/BSHType:b	Ljava/lang/Class;
    //   107: putfield 113	bsh/BSHType:d	Ljava/lang/Class;
    //   110: aload_2
    //   111: invokevirtual 158	bsh/Interpreter:getClassManager	()Lbsh/BshClassManager;
    //   114: aload_0
    //   115: invokevirtual 164	bsh/BshClassManager:addListener	(Lbsh/BshClassManager$Listener;)V
    //   118: aload_0
    //   119: getfield 113	bsh/BSHType:d	Ljava/lang/Class;
    //   122: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   63	87	90	java/lang/Exception
  }

  public String getTypeDescriptor(CallStack paramCallStack, Interpreter paramInterpreter, String paramString)
  {
    if (this.a != null)
      return this.a;
    SimpleNode localSimpleNode = a();
    String str2;
    if ((localSimpleNode instanceof BSHPrimitiveType))
    {
      str2 = getTypeDescriptor(((BSHPrimitiveType)localSimpleNode).type);
    }
    else
    {
      Object localObject1 = ((BSHAmbiguousName)localSimpleNode).text;
      String str1 = paramInterpreter.getClassManager().e((String)localObject1);
      Object localObject2 = null;
      if (str1 == null);
      label100: 
      try
      {
        Class localClass = ((BSHAmbiguousName)localSimpleNode).toClass(paramCallStack, paramInterpreter);
        localObject2 = localClass;
        break label100;
        localObject1 = str1;
        localObject2 = null;
      }
      catch (EvalError localEvalError)
      {
      }
      if (localObject2 != null)
      {
        str2 = getTypeDescriptor(localObject2);
      }
      else if ((paramString != null) && (!Name.isCompound((String)localObject1)))
      {
        StringBuffer localStringBuffer3 = new StringBuffer();
        localStringBuffer3.append("L");
        localStringBuffer3.append(paramString.replace('.', '/'));
        localStringBuffer3.append("/");
        localStringBuffer3.append((String)localObject1);
        localStringBuffer3.append(";");
        str2 = localStringBuffer3.toString();
      }
      else
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append("L");
        localStringBuffer1.append(((String)localObject1).replace('.', '/'));
        localStringBuffer1.append(";");
        str2 = localStringBuffer1.toString();
      }
    }
    for (int i = 0; ; i++)
    {
      if (i >= this.c)
      {
        this.a = str2;
        return str2;
      }
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("[");
      localStringBuffer2.append(str2);
      str2 = localStringBuffer2.toString();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHType
 * JD-Core Version:    0.6.2
 */