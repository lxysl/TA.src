package bsh;

public class UtilTargetError extends UtilEvalError
{
  public Throwable t;

  public UtilTargetError(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.t = paramThrowable;
  }

  public UtilTargetError(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }

  public EvalError toEvalError(String paramString, SimpleNode paramSimpleNode, CallStack paramCallStack)
  {
    if (paramString == null);
    String str2;
    StringBuffer localStringBuffer;
    for (String str1 = getMessage(); ; str1 = localStringBuffer.toString())
    {
      str2 = str1;
      break;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString);
      localStringBuffer.append(": ");
      localStringBuffer.append(getMessage());
    }
    TargetError localTargetError = new TargetError(str2, this.t, paramSimpleNode, paramCallStack, false);
    return localTargetError;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.UtilTargetError
 * JD-Core Version:    0.6.2
 */