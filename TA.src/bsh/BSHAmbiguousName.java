package bsh;

class BSHAmbiguousName extends SimpleNode
{
  public String text;

  BSHAmbiguousName(int paramInt)
  {
    super(paramInt);
  }

  Object a(CallStack paramCallStack, Interpreter paramInterpreter, boolean paramBoolean)
  {
    try
    {
      Object localObject = getName(paramCallStack.top()).toObject(paramCallStack, paramInterpreter, paramBoolean);
      return localObject;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    throw new InterpreterError("Don't know how to eval an ambiguous name!  Use toObject() if you want an object.");
  }

  public Name getName(NameSpace paramNameSpace)
  {
    return paramNameSpace.b(this.text);
  }

  public Class toClass(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    try
    {
      Class localClass = getName(paramCallStack.top()).toClass();
      return localClass;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new EvalError(localClassNotFoundException.getMessage(), this, paramCallStack);
    }
  }

  public LHS toLHS(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    try
    {
      LHS localLHS = getName(paramCallStack.top()).toLHS(paramCallStack, paramInterpreter);
      return localLHS;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      throw localUtilEvalError.toEvalError(this, paramCallStack);
    }
  }

  public Object toObject(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    return a(paramCallStack, paramInterpreter, false);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("AmbigousName: ");
    localStringBuffer.append(this.text);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHAmbiguousName
 * JD-Core Version:    0.6.2
 */