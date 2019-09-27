package bsh;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

class BSHAllocationExpression extends SimpleNode
{
  private static int a;

  BSHAllocationExpression(int paramInt)
  {
    super(paramInt);
  }

  private Object a(BSHAmbiguousName paramBSHAmbiguousName, BSHArguments paramBSHArguments, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    paramCallStack.top();
    Object[] arrayOfObject = paramBSHArguments.getArguments(paramCallStack, paramInterpreter);
    if (arrayOfObject == null)
      throw new EvalError("Null args in new.", this, paramCallStack);
    paramBSHAmbiguousName.a(paramCallStack, paramInterpreter, false);
    Object localObject = paramBSHAmbiguousName.a(paramCallStack, paramInterpreter, true);
    if ((localObject instanceof ClassIdentifier))
    {
      Class localClass = ((ClassIdentifier)localObject).getTargetClass();
      int i = jjtGetNumChildren();
      int j = 0;
      if (i > 2)
        j = 1;
      if (j != 0)
      {
        BSHBlock localBSHBlock = (BSHBlock)jjtGetChild(2);
        if (localClass.isInterface())
          return b(localClass, arrayOfObject, localBSHBlock, paramCallStack, paramInterpreter);
        return a(localClass, arrayOfObject, localBSHBlock, paramCallStack, paramInterpreter);
      }
      return a(localClass, arrayOfObject, paramCallStack);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Unknown class: ");
    localStringBuffer.append(paramBSHAmbiguousName.text);
    throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
  }

  private Object a(BSHAmbiguousName paramBSHAmbiguousName, BSHArrayDimensions paramBSHArrayDimensions, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    NameSpace localNameSpace = paramCallStack.top();
    Class localClass = paramBSHAmbiguousName.toClass(paramCallStack, paramInterpreter);
    if (localClass == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Class ");
      localStringBuffer.append(paramBSHAmbiguousName.getName(localNameSpace));
      localStringBuffer.append(" not found.");
      throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
    }
    return a(paramBSHArrayDimensions, localClass, paramCallStack, paramInterpreter);
  }

  private Object a(BSHArrayDimensions paramBSHArrayDimensions, Class paramClass, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    Object localObject = paramBSHArrayDimensions.eval(paramClass, paramCallStack, paramInterpreter);
    if (localObject != Primitive.VOID)
      return localObject;
    return a(paramClass, paramBSHArrayDimensions, paramCallStack);
  }

  private Object a(BSHPrimitiveType paramBSHPrimitiveType, BSHArrayDimensions paramBSHArrayDimensions, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    return a(paramBSHArrayDimensions, paramBSHPrimitiveType.getType(), paramCallStack, paramInterpreter);
  }

  private Object a(Class paramClass, BSHArrayDimensions paramBSHArrayDimensions, CallStack paramCallStack)
  {
    if (paramBSHArrayDimensions.numUndefinedDims > 0)
      paramClass = Array.newInstance(paramClass, new int[paramBSHArrayDimensions.numUndefinedDims]).getClass();
    try
    {
      Object localObject = Array.newInstance(paramClass, paramBSHArrayDimensions.definedDimensions);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Can't construct primitive array: ");
      localStringBuffer.append(localException.getMessage());
      throw new EvalError(localStringBuffer.toString(), this, paramCallStack);
    }
    catch (NegativeArraySizeException localNegativeArraySizeException)
    {
      throw new TargetError(localNegativeArraySizeException, this, paramCallStack);
    }
  }

  private Object a(Class paramClass, Object[] paramArrayOfObject, BSHBlock paramBSHBlock, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append(paramCallStack.top().getName());
    localStringBuffer1.append("$");
    int i = 1 + a;
    a = i;
    localStringBuffer1.append(i);
    String str = localStringBuffer1.toString();
    Modifiers localModifiers = new Modifiers();
    localModifiers.addModifier(0, "public");
    try
    {
      Class localClass = ClassGenerator.getClassGenerator().generateClass(str, localModifiers, null, paramClass, paramBSHBlock, false, paramCallStack, paramInterpreter);
      try
      {
        Object localObject = Reflect.a(localClass, paramArrayOfObject);
        return localObject;
      }
      catch (Exception localException1)
      {
        Exception localException2;
        if ((localException1 instanceof InvocationTargetException))
          localException2 = (Exception)((InvocationTargetException)localException1).getTargetException();
        else
          localException2 = localException1;
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Error constructing inner class instance: ");
        localStringBuffer2.append(localException2);
        throw new EvalError(localStringBuffer2.toString(), this, paramCallStack);
      }
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  private Object a(Class paramClass, Object[] paramArrayOfObject, CallStack paramCallStack)
  {
    try
    {
      Object localObject = Reflect.a(paramClass, paramArrayOfObject);
      String str = paramClass.getName();
      if (str.indexOf("$") == -1)
        return localObject;
      NameSpace localNameSpace = Name.a(paramCallStack.top().a(null).getNameSpace());
      if (localNameSpace != null)
      {
        StringBuffer localStringBuffer3 = new StringBuffer();
        localStringBuffer3.append(localNameSpace.getName());
        localStringBuffer3.append("$");
        if (str.startsWith(localStringBuffer3.toString()))
          try
          {
            ClassGenerator.getClassGenerator().setInstanceNameSpaceParent(localObject, str, localNameSpace);
            return localObject;
          }
          catch (UtilEvalError localUtilEvalError)
          {
            throw localUtilEvalError.toEvalError(this, paramCallStack);
          }
      }
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("The constructor threw an exception:\n\t");
      localStringBuffer2.append(localInvocationTargetException.getTargetException());
      Interpreter.debug(localStringBuffer2.toString());
      TargetError localTargetError = new TargetError("Object constructor", localInvocationTargetException.getTargetException(), this, paramCallStack, true);
      throw localTargetError;
    }
    catch (ReflectError localReflectError)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Constructor error: ");
      localStringBuffer1.append(localReflectError.getMessage());
      throw new EvalError(localStringBuffer1.toString(), this, paramCallStack);
    }
  }

  private Object b(Class paramClass, Object[] paramArrayOfObject, BSHBlock paramBSHBlock, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    NameSpace localNameSpace = new NameSpace(paramCallStack.top(), "AnonymousBlock");
    paramCallStack.push(localNameSpace);
    paramBSHBlock.eval(paramCallStack, paramInterpreter, true);
    paramCallStack.pop();
    localNameSpace.importStatic(paramClass);
    try
    {
      Object localObject = localNameSpace.a(paramInterpreter).getInterface(paramClass);
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    SimpleNode localSimpleNode1 = (SimpleNode)jjtGetChild(0);
    SimpleNode localSimpleNode2 = (SimpleNode)jjtGetChild(1);
    if ((localSimpleNode1 instanceof BSHAmbiguousName))
    {
      BSHAmbiguousName localBSHAmbiguousName = (BSHAmbiguousName)localSimpleNode1;
      if ((localSimpleNode2 instanceof BSHArguments))
        return a(localBSHAmbiguousName, (BSHArguments)localSimpleNode2, paramCallStack, paramInterpreter);
      return a(localBSHAmbiguousName, (BSHArrayDimensions)localSimpleNode2, paramCallStack, paramInterpreter);
    }
    return a((BSHPrimitiveType)localSimpleNode1, (BSHArrayDimensions)localSimpleNode2, paramCallStack, paramInterpreter);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHAllocationExpression
 * JD-Core Version:    0.6.2
 */