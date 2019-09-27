package bsh;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

class BSHPrimarySuffix extends SimpleNode
{
  public static final int CLASS = 0;
  public static final int INDEX = 1;
  public static final int NAME = 2;
  public static final int PROPERTY = 3;
  public String field;
  public int operation;

  BSHPrimarySuffix(int paramInt)
  {
    super(paramInt);
  }

  static int a(Object paramObject, CallStack paramCallStack, Interpreter paramInterpreter, SimpleNode paramSimpleNode)
  {
    if (!paramObject.getClass().isArray())
      throw new EvalError("Not an array", paramSimpleNode, paramCallStack);
    try
    {
      Object localObject = ((SimpleNode)paramSimpleNode.jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
      if (!(localObject instanceof Primitive))
        localObject = Types.castObject(localObject, Integer.TYPE, 1);
      int i = ((Primitive)localObject).intValue();
      return i;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("doIndex: ");
      localStringBuffer.append(localUtilEvalError);
      Interpreter.debug(localStringBuffer.toString());
      throw localUtilEvalError.toEvalError("Arrays may only be indexed by integer types.", paramSimpleNode, paramCallStack);
    }
  }

  private Object a(Object paramObject, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    while (true)
    {
      try
      {
        if ((this.field.equals("length")) && (paramObject.getClass().isArray()))
        {
          if (paramBoolean)
            throw new EvalError("Can't assign array length", this, paramCallStack);
          return new Primitive(Array.getLength(paramObject));
        }
        if (jjtGetNumChildren() == 0)
        {
          if (paramBoolean)
            return Reflect.a(paramObject, this.field);
          return Reflect.getObjectFieldValue(paramObject, this.field);
        }
        Object[] arrayOfObject = ((BSHArguments)jjtGetChild(0)).getArguments(paramCallStack, paramInterpreter);
        try
        {
          Object localObject = Reflect.invokeObjectMethod(paramObject, this.field, arrayOfObject, paramInterpreter, paramCallStack, this);
          return localObject;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          StringBuffer localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append("Method Invocation ");
          localStringBuffer2.append(this.field);
          String str = localStringBuffer2.toString();
          Throwable localThrowable = localInvocationTargetException.getTargetException();
          if (!(localThrowable instanceof EvalError))
            break label267;
          if ((localThrowable instanceof TargetError))
          {
            bool = ((TargetError)localThrowable).inNativeCode();
            TargetError localTargetError = new TargetError(str, localThrowable, this, paramCallStack, bool);
            throw localTargetError;
          }
        }
        catch (ReflectError localReflectError)
        {
          StringBuffer localStringBuffer1 = new StringBuffer();
          localStringBuffer1.append("Error in method invocation: ");
          localStringBuffer1.append(localReflectError.getMessage());
          throw new EvalError(localStringBuffer1.toString(), this, paramCallStack);
        }
      }
      catch (UtilEvalError localUtilEvalError)
      {
        throw localUtilEvalError.toEvalError(this, paramCallStack);
      }
      boolean bool = false;
      continue;
      label267: bool = true;
    }
  }

  // ERROR //
  private Object a(boolean paramBoolean, Object paramObject, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 173	bsh/Primitive:VOID	Lbsh/Primitive;
    //   4: if_acmpne +15 -> 19
    //   7: new 38	bsh/EvalError
    //   10: dup
    //   11: ldc 175
    //   13: aload_0
    //   14: aload_3
    //   15: invokespecial 43	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   18: athrow
    //   19: aload_2
    //   20: instanceof 53
    //   23: ifeq +15 -> 38
    //   26: new 38	bsh/EvalError
    //   29: dup
    //   30: ldc 177
    //   32: aload_0
    //   33: aload_3
    //   34: invokespecial 43	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   37: athrow
    //   38: aload_0
    //   39: iconst_0
    //   40: invokevirtual 136	bsh/BSHPrimarySuffix:jjtGetChild	(I)Lbsh/Node;
    //   43: checkcast 4	bsh/SimpleNode
    //   46: aload_3
    //   47: aload 4
    //   49: invokevirtual 51	bsh/SimpleNode:eval	(Lbsh/CallStack;Lbsh/Interpreter;)Ljava/lang/Object;
    //   52: astore 5
    //   54: aload 5
    //   56: instanceof 110
    //   59: ifne +15 -> 74
    //   62: new 38	bsh/EvalError
    //   65: dup
    //   66: ldc 179
    //   68: aload_0
    //   69: aload_3
    //   70: invokespecial 43	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   73: athrow
    //   74: iload_1
    //   75: ifeq +17 -> 92
    //   78: new 181	bsh/LHS
    //   81: dup
    //   82: aload_2
    //   83: aload 5
    //   85: checkcast 110	java/lang/String
    //   88: invokespecial 184	bsh/LHS:<init>	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: areturn
    //   92: invokestatic 190	bsh/CollectionManager:getCollectionManager	()Lbsh/CollectionManager;
    //   95: astore 6
    //   97: aload 6
    //   99: aload_2
    //   100: invokevirtual 193	bsh/CollectionManager:isMap	(Ljava/lang/Object;)Z
    //   103: ifeq +26 -> 129
    //   106: aload 6
    //   108: aload_2
    //   109: aload 5
    //   111: invokevirtual 197	bsh/CollectionManager:getFromMap	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: astore 15
    //   116: aload 15
    //   118: ifnonnull +8 -> 126
    //   121: getstatic 200	bsh/Primitive:NULL	Lbsh/Primitive;
    //   124: astore 15
    //   126: aload 15
    //   128: areturn
    //   129: aload_2
    //   130: aload 5
    //   132: checkcast 110	java/lang/String
    //   135: invokestatic 203	bsh/Reflect:getObjectProperty	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   138: astore 14
    //   140: aload 14
    //   142: areturn
    //   143: new 71	java/lang/StringBuffer
    //   146: dup
    //   147: invokespecial 74	java/lang/StringBuffer:<init>	()V
    //   150: astore 11
    //   152: aload 11
    //   154: ldc 205
    //   156: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: aload 11
    //   162: aload 5
    //   164: invokevirtual 83	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   167: pop
    //   168: new 38	bsh/EvalError
    //   171: dup
    //   172: aload 11
    //   174: invokevirtual 87	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   177: aload_0
    //   178: aload_3
    //   179: invokespecial 43	bsh/EvalError:<init>	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)V
    //   182: athrow
    //   183: astore 7
    //   185: new 71	java/lang/StringBuffer
    //   188: dup
    //   189: invokespecial 74	java/lang/StringBuffer:<init>	()V
    //   192: astore 8
    //   194: aload 8
    //   196: ldc 207
    //   198: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   201: pop
    //   202: aload 8
    //   204: aload 5
    //   206: invokevirtual 83	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   209: pop
    //   210: aload 7
    //   212: aload 8
    //   214: invokevirtual 87	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   217: aload_0
    //   218: aload_3
    //   219: invokevirtual 99	bsh/UtilEvalError:toEvalError	(Ljava/lang/String;Lbsh/SimpleNode;Lbsh/CallStack;)Lbsh/EvalError;
    //   222: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   129	140	143	bsh/ReflectError
    //   129	140	183	bsh/UtilEvalError
  }

  private Object b(Object paramObject, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    int i = a(paramObject, paramCallStack, paramInterpreter, this);
    if (paramBoolean)
      return new LHS(paramObject, i);
    try
    {
      Object localObject = Reflect.getIndex(paramObject, i);
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  public Object doSuffix(Object paramObject, boolean paramBoolean, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    if (this.operation == 0)
    {
      if ((paramObject instanceof BSHType))
      {
        if (paramBoolean)
          throw new EvalError("Can't assign .class", this, paramCallStack);
        paramCallStack.top();
        return ((BSHType)paramObject).getType(paramCallStack, paramInterpreter);
      }
      throw new EvalError("Attempt to use .class suffix on non class.", this, paramCallStack);
    }
    if ((paramObject instanceof SimpleNode))
    {
      if ((paramObject instanceof BSHAmbiguousName))
        paramObject = ((BSHAmbiguousName)paramObject).toObject(paramCallStack, paramInterpreter);
      else
        paramObject = ((SimpleNode)paramObject).eval(paramCallStack, paramInterpreter);
    }
    else if ((paramObject instanceof LHS))
      try
      {
        paramObject = ((LHS)paramObject).getValue();
      }
      catch (UtilEvalError localUtilEvalError)
      {
        throw localUtilEvalError.toEvalError(this, paramCallStack);
      }
    try
    {
      switch (this.operation)
      {
      default:
        break;
      case 3:
        return a(paramBoolean, paramObject, paramCallStack, paramInterpreter);
      case 2:
        return a(paramObject, paramBoolean, paramCallStack, paramInterpreter);
      case 1:
        return b(paramObject, paramBoolean, paramCallStack, paramInterpreter);
      }
      throw new InterpreterError("Unknown suffix type");
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      TargetError localTargetError = new TargetError("target exception", localInvocationTargetException.getTargetException(), this, paramCallStack, true);
      throw localTargetError;
    }
    catch (ReflectError localReflectError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("reflection error: ");
      localStringBuffer.append(localReflectError);
      throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHPrimarySuffix
 * JD-Core Version:    0.6.2
 */