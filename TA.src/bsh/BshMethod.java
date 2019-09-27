package bsh;

import java.io.Serializable;
import java.lang.reflect.Method;

public class BshMethod
  implements Serializable
{
  NameSpace a;
  Modifiers b;
  BSHBlock c;
  private String d;
  private Class e;
  private String[] f;
  private int g;
  private Class[] h;
  private Method i;
  private Object j;

  BshMethod(BSHMethodDeclaration paramBSHMethodDeclaration, NameSpace paramNameSpace, Modifiers paramModifiers)
  {
    this(paramBSHMethodDeclaration.name, paramBSHMethodDeclaration.e, paramBSHMethodDeclaration.b.getParamNames(), paramBSHMethodDeclaration.b.a, paramBSHMethodDeclaration.c, paramNameSpace, paramModifiers);
  }

  BshMethod(String paramString, Class paramClass, String[] paramArrayOfString, Class[] paramArrayOfClass, BSHBlock paramBSHBlock, NameSpace paramNameSpace, Modifiers paramModifiers)
  {
    this.d = paramString;
    this.e = paramClass;
    this.f = paramArrayOfString;
    if (paramArrayOfString != null)
      this.g = paramArrayOfString.length;
    this.h = paramArrayOfClass;
    this.c = paramBSHBlock;
    this.a = paramNameSpace;
    this.b = paramModifiers;
  }

  BshMethod(Method paramMethod, Object paramObject)
  {
    this(paramMethod.getName(), paramMethod.getReturnType(), null, paramMethod.getParameterTypes(), null, null, null);
    this.i = paramMethod;
    this.j = paramObject;
  }

  private Object b(Object[] paramArrayOfObject, Interpreter paramInterpreter, CallStack paramCallStack, SimpleNode paramSimpleNode, boolean paramBoolean)
  {
    Class localClass = getReturnType();
    Class[] arrayOfClass = getParameterTypes();
    if (paramCallStack == null)
      paramCallStack = new CallStack(this.a);
    int k = 0;
    if (paramArrayOfObject == null)
      paramArrayOfObject = new Object[0];
    if (paramArrayOfObject.length != this.g)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Wrong number of arguments for local method: ");
      localStringBuffer1.append(this.d);
      throw new EvalError(localStringBuffer1.toString(), paramSimpleNode, paramCallStack);
    }
    NameSpace localNameSpace;
    if (paramBoolean)
    {
      localNameSpace = paramCallStack.top();
    }
    else
    {
      localNameSpace = new NameSpace(this.a, this.d);
      localNameSpace.c = true;
    }
    localNameSpace.a(paramSimpleNode);
    while (true)
    {
      if (k >= this.g)
      {
        if (!paramBoolean)
          paramCallStack.push(localNameSpace);
        Object localObject1 = this.c.eval(paramCallStack, paramInterpreter, true);
        CallStack localCallStack = paramCallStack.copy();
        if (!paramBoolean)
          paramCallStack.pop();
        boolean bool = localObject1 instanceof ReturnControl;
        ReturnControl localReturnControl = null;
        if (bool)
        {
          localReturnControl = (ReturnControl)localObject1;
          if (localReturnControl.kind == 46)
          {
            localObject1 = localReturnControl.value;
            if ((localClass == Void.TYPE) && (localObject1 != Primitive.VOID))
              throw new EvalError("Cannot return value from void method", localReturnControl.returnPoint, localCallStack);
          }
          else
          {
            throw new EvalError("'continue' or 'break' in method body", localReturnControl.returnPoint, localCallStack);
          }
        }
        if (localClass != null)
        {
          if (localClass == Void.TYPE)
            return Primitive.VOID;
          try
          {
            Object localObject2 = Types.castObject(localObject1, localClass, 1);
            return localObject2;
          }
          catch (UtilEvalError localUtilEvalError4)
          {
            if (localReturnControl != null)
              paramSimpleNode = localReturnControl.returnPoint;
            StringBuffer localStringBuffer4 = new StringBuffer();
            localStringBuffer4.append("Incorrect type returned from method: ");
            localStringBuffer4.append(this.d);
            localStringBuffer4.append(localUtilEvalError4.getMessage());
            throw localUtilEvalError4.toEvalError(localStringBuffer4.toString(), paramSimpleNode, paramCallStack);
          }
        }
        return localObject1;
      }
      if (arrayOfClass[k] != null)
      {
        try
        {
          paramArrayOfObject[k] = Types.castObject(paramArrayOfObject[k], arrayOfClass[k], 1);
          try
          {
            localNameSpace.setTypedVariable(this.f[k], arrayOfClass[k], paramArrayOfObject[k], null);
          }
          catch (UtilEvalError localUtilEvalError3)
          {
            throw localUtilEvalError3.toEvalError("Typed method parameter assignment", paramSimpleNode, paramCallStack);
          }
        }
        catch (UtilEvalError localUtilEvalError2)
        {
          StringBuffer localStringBuffer3 = new StringBuffer();
          localStringBuffer3.append("Invalid argument: `");
          localStringBuffer3.append(this.f[k]);
          localStringBuffer3.append("'");
          localStringBuffer3.append(" for method: ");
          localStringBuffer3.append(this.d);
          localStringBuffer3.append(" : ");
          localStringBuffer3.append(localUtilEvalError2.getMessage());
          throw new EvalError(localStringBuffer3.toString(), paramSimpleNode, paramCallStack);
        }
      }
      else if (paramArrayOfObject[k] == Primitive.VOID)
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Undefined variable or class name, parameter: ");
        localStringBuffer2.append(this.f[k]);
        localStringBuffer2.append(" to method: ");
        localStringBuffer2.append(this.d);
        throw new EvalError(localStringBuffer2.toString(), paramSimpleNode, paramCallStack);
      }
      try
      {
        localNameSpace.a(this.f[k], paramArrayOfObject[k], paramInterpreter.getStrictJava());
        k++;
      }
      catch (UtilEvalError localUtilEvalError1)
      {
        throw localUtilEvalError1.toEvalError(paramSimpleNode, paramCallStack);
      }
    }
  }

  // ERROR //
  Object a(Object[] paramArrayOfObject, Interpreter paramInterpreter, CallStack paramCallStack, SimpleNode paramSimpleNode, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +39 -> 40
    //   4: iconst_0
    //   5: istore 16
    //   7: iload 16
    //   9: aload_1
    //   10: arraylength
    //   11: if_icmplt +6 -> 17
    //   14: goto +26 -> 40
    //   17: aload_1
    //   18: iload 16
    //   20: aaload
    //   21: ifnonnull +13 -> 34
    //   24: new 223	java/lang/Error
    //   27: dup
    //   28: ldc 225
    //   30: invokespecial 228	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   33: athrow
    //   34: iinc 16 1
    //   37: goto -30 -> 7
    //   40: aload_0
    //   41: getfield 85	bsh/BshMethod:i	Ljava/lang/reflect/Method;
    //   44: ifnull +85 -> 129
    //   47: aload_0
    //   48: getfield 85	bsh/BshMethod:i	Ljava/lang/reflect/Method;
    //   51: aload_0
    //   52: getfield 87	bsh/BshMethod:j	Ljava/lang/Object;
    //   55: aload_1
    //   56: invokestatic 233	bsh/Reflect:a	(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 15
    //   61: aload 15
    //   63: areturn
    //   64: astore 13
    //   66: new 235	bsh/TargetError
    //   69: dup
    //   70: ldc 237
    //   72: aload 13
    //   74: aload 4
    //   76: aload_3
    //   77: iconst_1
    //   78: invokespecial 240	bsh/TargetError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lbsh/SimpleNode;Lbsh/CallStack;Z)V
    //   81: astore 14
    //   83: aload 14
    //   85: athrow
    //   86: astore 9
    //   88: new 99	java/lang/StringBuffer
    //   91: dup
    //   92: invokespecial 100	java/lang/StringBuffer:<init>	()V
    //   95: astore 10
    //   97: aload 10
    //   99: ldc 242
    //   101: invokevirtual 106	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: aload 10
    //   107: aload 9
    //   109: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   112: pop
    //   113: new 108	bsh/EvalError
    //   116: dup
    //   117: aload 10
    //   119: invokevirtual 111	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   122: aload 4
    //   124: aload_3
    //   125: invokespecial 114	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   128: athrow
    //   129: aload_0
    //   130: getfield 68	bsh/BshMethod:b	Lbsh/Modifiers;
    //   133: ifnull +88 -> 221
    //   136: aload_0
    //   137: getfield 68	bsh/BshMethod:b	Lbsh/Modifiers;
    //   140: ldc 247
    //   142: invokevirtual 253	bsh/Modifiers:hasModifier	(Ljava/lang/String;)Z
    //   145: ifeq +76 -> 221
    //   148: aload_0
    //   149: getfield 66	bsh/BshMethod:a	Lbsh/NameSpace;
    //   152: getfield 255	bsh/NameSpace:d	Z
    //   155: ifeq +26 -> 181
    //   158: aload_0
    //   159: getfield 66	bsh/BshMethod:a	Lbsh/NameSpace;
    //   162: invokevirtual 258	bsh/NameSpace:a	()Ljava/lang/Object;
    //   165: astore 6
    //   167: goto +24 -> 191
    //   170: new 260	bsh/InterpreterError
    //   173: dup
    //   174: ldc_w 262
    //   177: invokespecial 263	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   180: athrow
    //   181: aload_0
    //   182: getfield 66	bsh/BshMethod:a	Lbsh/NameSpace;
    //   185: aload_2
    //   186: invokevirtual 266	bsh/NameSpace:a	(Lbsh/Interpreter;)Lbsh/This;
    //   189: astore 6
    //   191: aload 6
    //   193: monitorenter
    //   194: aload_0
    //   195: aload_1
    //   196: aload_2
    //   197: aload_3
    //   198: aload 4
    //   200: iload 5
    //   202: invokespecial 268	bsh/BshMethod:b	([Ljava/lang/Object;Lbsh/Interpreter;Lbsh/CallStack;Lbsh/SimpleNode;Z)Ljava/lang/Object;
    //   205: astore 8
    //   207: aload 6
    //   209: monitorexit
    //   210: aload 8
    //   212: areturn
    //   213: astore 7
    //   215: aload 6
    //   217: monitorexit
    //   218: aload 7
    //   220: athrow
    //   221: aload_0
    //   222: aload_1
    //   223: aload_2
    //   224: aload_3
    //   225: aload 4
    //   227: iload 5
    //   229: invokespecial 268	bsh/BshMethod:b	([Ljava/lang/Object;Lbsh/Interpreter;Lbsh/CallStack;Lbsh/SimpleNode;Z)Ljava/lang/Object;
    //   232: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   47	61	64	java/lang/reflect/InvocationTargetException
    //   47	61	86	bsh/ReflectError
    //   158	167	170	bsh/UtilEvalError
    //   194	210	213	finally
    //   215	218	213	finally
  }

  public Modifiers getModifiers()
  {
    return this.b;
  }

  public String getName()
  {
    return this.d;
  }

  public String[] getParameterNames()
  {
    return this.f;
  }

  public Class[] getParameterTypes()
  {
    return this.h;
  }

  public Class getReturnType()
  {
    return this.e;
  }

  public boolean hasModifier(String paramString)
  {
    return (this.b != null) && (this.b.hasModifier(paramString));
  }

  public Object invoke(Object[] paramArrayOfObject, Interpreter paramInterpreter)
  {
    return a(paramArrayOfObject, paramInterpreter, null, null, false);
  }

  public Object invoke(Object[] paramArrayOfObject, Interpreter paramInterpreter, CallStack paramCallStack, SimpleNode paramSimpleNode)
  {
    return a(paramArrayOfObject, paramInterpreter, paramCallStack, paramSimpleNode, false);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Scripted Method: ");
    localStringBuffer.append(StringUtil.methodString(this.d, getParameterTypes()));
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BshMethod
 * JD-Core Version:    0.6.2
 */