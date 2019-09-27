package bsh;

import com.a.a.a.a.a.a.a;

public class UtilEvalError extends Exception
{
  protected UtilEvalError()
  {
  }

  public UtilEvalError(String paramString)
  {
    super(paramString);
  }

  public EvalError toEvalError(SimpleNode paramSimpleNode, CallStack paramCallStack)
  {
    return toEvalError(null, paramSimpleNode, paramCallStack);
  }

  public EvalError toEvalError(String paramString, SimpleNode paramSimpleNode, CallStack paramCallStack)
  {
    if (Interpreter.DEBUG)
      a.a(this);
    String str;
    if (paramString == null)
    {
      str = "";
    }
    else
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(paramString);
      localStringBuffer1.append(": ");
      str = localStringBuffer1.toString();
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append(str);
    localStringBuffer2.append(getMessage());
    return new EvalError(localStringBuffer2.toString(), paramSimpleNode, paramCallStack);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.UtilEvalError
 * JD-Core Version:    0.6.2
 */