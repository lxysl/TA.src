package bsh;

import java.io.Serializable;

public class Variable
  implements Serializable
{
  String a;
  Class b = null;
  String c;
  Object d;
  Modifiers e;
  LHS f;

  Variable(String paramString, Class paramClass, LHS paramLHS)
  {
    this.a = paramString;
    this.f = paramLHS;
    this.b = paramClass;
  }

  Variable(String paramString, Class paramClass, Object paramObject, Modifiers paramModifiers)
  {
    this.a = paramString;
    this.b = paramClass;
    this.e = paramModifiers;
    setValue(paramObject, 0);
  }

  Variable(String paramString, Object paramObject, Modifiers paramModifiers)
  {
    this(paramString, (Class)null, paramObject, paramModifiers);
  }

  Variable(String paramString1, String paramString2, Object paramObject, Modifiers paramModifiers)
  {
    this(paramString1, (Class)null, paramObject, paramModifiers);
    this.c = paramString2;
  }

  Object a()
  {
    if (this.f != null)
      return this.f.getValue();
    return this.d;
  }

  public Modifiers getModifiers()
  {
    return this.e;
  }

  public String getName()
  {
    return this.a;
  }

  public Class getType()
  {
    return this.b;
  }

  public String getTypeDescriptor()
  {
    return this.c;
  }

  public boolean hasModifier(String paramString)
  {
    return (this.e != null) && (this.e.hasModifier(paramString));
  }

  public void setValue(Object paramObject, int paramInt)
  {
    if ((hasModifier("final")) && (this.d != null))
      throw new UtilEvalError("Final variable, can't re-assign.");
    if (paramObject == null)
      paramObject = Primitive.getDefaultValue(this.b);
    if (this.f != null)
    {
      this.f.assign(paramObject, false);
      return;
    }
    if (this.b != null)
    {
      Class localClass = this.b;
      int i;
      if (paramInt == 0)
        i = 0;
      else
        i = 1;
      paramObject = Types.castObject(paramObject, localClass, i);
    }
    this.d = paramObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Variable: ");
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" ");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", type:");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", value:");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", lhs = ");
    localStringBuffer.append(this.f);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Variable
 * JD-Core Version:    0.6.2
 */