package bsh;

public class DelayedEvalBshMethod extends BshMethod
{
  String d;
  BSHReturnType e;
  String[] f;
  BSHFormalParameters g;
  transient CallStack h;
  transient Interpreter i;

  DelayedEvalBshMethod(String paramString1, String paramString2, BSHReturnType paramBSHReturnType, String[] paramArrayOfString1, String[] paramArrayOfString2, BSHFormalParameters paramBSHFormalParameters, BSHBlock paramBSHBlock, NameSpace paramNameSpace, Modifiers paramModifiers, CallStack paramCallStack, Interpreter paramInterpreter)
  {
    super(paramString1, null, paramArrayOfString1, null, paramBSHBlock, paramNameSpace, paramModifiers);
    this.d = paramString2;
    this.e = paramBSHReturnType;
    this.f = paramArrayOfString2;
    this.g = paramBSHFormalParameters;
    this.h = paramCallStack;
    this.i = paramInterpreter;
  }

  public String[] getParamTypeDescriptors()
  {
    return this.f;
  }

  public Class[] getParameterTypes()
  {
    try
    {
      Class[] arrayOfClass = (Class[])this.g.eval(this.h, this.i);
      return arrayOfClass;
    }
    catch (EvalError localEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("can't eval param types: ");
      localStringBuffer.append(localEvalError);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  public Class getReturnType()
  {
    if (this.e == null)
      return null;
    try
    {
      Class localClass = this.e.evalReturnType(this.h, this.i);
      return localClass;
    }
    catch (EvalError localEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("can't eval return type: ");
      localStringBuffer.append(localEvalError);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  public String getReturnTypeDescriptor()
  {
    return this.d;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.DelayedEvalBshMethod
 * JD-Core Version:    0.6.2
 */