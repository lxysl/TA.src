package bsh;

import java.lang.reflect.InvocationTargetException;

class BSHMethodInvocation extends SimpleNode
{
  BSHMethodInvocation(int paramInt)
  {
    super(paramInt);
  }

  BSHAmbiguousName a()
  {
    return (BSHAmbiguousName)jjtGetChild(0);
  }

  BSHArguments b()
  {
    return (BSHArguments)jjtGetChild(1);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    NameSpace localNameSpace = paramCallStack.top();
    BSHAmbiguousName localBSHAmbiguousName = a();
    if ((localNameSpace.getParent() != null) && (localNameSpace.getParent().d) && ((localBSHAmbiguousName.text.equals("super")) || (localBSHAmbiguousName.text.equals("this"))))
      return Primitive.VOID;
    Name localName = localBSHAmbiguousName.getName(localNameSpace);
    Object[] arrayOfObject = b().getArguments(paramCallStack, paramInterpreter);
    try
    {
      Object localObject = localName.invokeMethod(paramInterpreter, arrayOfObject, paramCallStack, this);
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("Method Invocation ");
      localStringBuffer2.append(localName);
      String str = localStringBuffer2.toString();
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      boolean bool;
      if ((localThrowable instanceof EvalError))
      {
        if ((localThrowable instanceof TargetError))
          bool = ((TargetError)localThrowable).inNativeCode();
        else
          bool = false;
      }
      else
        bool = true;
      TargetError localTargetError = new TargetError(str, localThrowable, this, paramCallStack, bool);
      throw localTargetError;
    }
    catch (ReflectError localReflectError)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Error in method invocation: ");
      localStringBuffer1.append(localReflectError.getMessage());
      throw new EvalError(localStringBuffer1.toString(), this, paramCallStack);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHMethodInvocation
 * JD-Core Version:    0.6.2
 */