package bsh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ExternalNameSpace extends NameSpace
{
  private Map h;

  public ExternalNameSpace()
  {
    this(null, "External Map Namespace", null);
  }

  public ExternalNameSpace(NameSpace paramNameSpace, String paramString, Map paramMap)
  {
    super(paramNameSpace, paramString);
    if (paramMap == null)
      paramMap = new HashMap();
    this.h = paramMap;
  }

  protected Variable a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.h.get(paramString);
    if (localObject == null)
    {
      super.unsetVariable(paramString);
      return super.a(paramString, paramBoolean);
    }
    Variable localVariable = super.a(paramString, false);
    if (localVariable == null)
      localVariable = new Variable(paramString, (Class)null, localObject, (Modifiers)null);
    return localVariable;
  }

  // ERROR //
  protected void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 38
    //   4: ifeq +25 -> 29
    //   7: aload_0
    //   8: aload_2
    //   9: checkcast 38	bsh/Variable
    //   12: invokevirtual 51	bsh/ExternalNameSpace:a	(Lbsh/Variable;)Ljava/lang/Object;
    //   15: astore_2
    //   16: goto +13 -> 29
    //   19: new 53	bsh/InterpreterError
    //   22: dup
    //   23: ldc 55
    //   25: invokespecial 57	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   28: athrow
    //   29: aload_2
    //   30: instanceof 59
    //   33: ifeq +11 -> 44
    //   36: aload_2
    //   37: checkcast 59	bsh/Primitive
    //   40: invokestatic 62	bsh/Primitive:unwrap	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 22	bsh/ExternalNameSpace:h	Ljava/util/Map;
    //   48: aload_1
    //   49: aload_2
    //   50: invokeinterface 66 3 0
    //   55: pop
    //   56: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	16	19	bsh/UtilEvalError
  }

  protected void a(Vector paramVector)
  {
    super.a(paramVector);
  }

  public void clear()
  {
    super.clear();
    this.h.clear();
  }

  public Variable[] getDeclaredVariables()
  {
    return super.getDeclaredVariables();
  }

  public Map getMap()
  {
    return this.h;
  }

  public BshMethod getMethod(String paramString, Class[] paramArrayOfClass, boolean paramBoolean)
  {
    return super.getMethod(paramString, paramArrayOfClass, paramBoolean);
  }

  public String[] getVariableNames()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(Arrays.asList(super.getVariableNames()));
    localHashSet.addAll(this.h.keySet());
    return (String[])localHashSet.toArray(new String[0]);
  }

  public void setMap(Map paramMap)
  {
    this.h = null;
    clear();
    this.h = paramMap;
  }

  public void setMethod(String paramString, BshMethod paramBshMethod)
  {
    super.setMethod(paramString, paramBshMethod);
  }

  public void setTypedVariable(String paramString, Class paramClass, Object paramObject, Modifiers paramModifiers)
  {
    super.setTypedVariable(paramString, paramClass, paramObject, paramModifiers);
    a(paramString, paramObject);
  }

  void setVariable(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setVariable(paramString, paramObject, paramBoolean1, paramBoolean2);
    a(paramString, paramObject);
  }

  public void unsetVariable(String paramString)
  {
    super.unsetVariable(paramString);
    this.h.remove(paramString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ExternalNameSpace
 * JD-Core Version:    0.6.2
 */