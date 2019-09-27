package bsh;

import java.util.Vector;

public class CallStack
{
  private Vector a = new Vector(2);

  public CallStack()
  {
  }

  public CallStack(NameSpace paramNameSpace)
  {
    push(paramNameSpace);
  }

  public void clear()
  {
    this.a.removeAllElements();
  }

  public CallStack copy()
  {
    CallStack localCallStack = new CallStack();
    localCallStack.a = ((Vector)this.a.clone());
    return localCallStack;
  }

  public int depth()
  {
    return this.a.size();
  }

  public NameSpace get(int paramInt)
  {
    if (paramInt >= depth())
      return NameSpace.JAVACODE;
    return (NameSpace)this.a.elementAt(paramInt);
  }

  public NameSpace pop()
  {
    if (depth() < 1)
      throw new InterpreterError("pop on empty CallStack");
    NameSpace localNameSpace = top();
    this.a.removeElementAt(0);
    return localNameSpace;
  }

  public void push(NameSpace paramNameSpace)
  {
    this.a.insertElementAt(paramNameSpace, 0);
  }

  public void set(int paramInt, NameSpace paramNameSpace)
  {
    this.a.setElementAt(paramNameSpace, paramInt);
  }

  public NameSpace swap(NameSpace paramNameSpace)
  {
    NameSpace localNameSpace = (NameSpace)this.a.elementAt(0);
    this.a.setElementAt(paramNameSpace, 0);
    return localNameSpace;
  }

  public NameSpace[] toArray()
  {
    NameSpace[] arrayOfNameSpace = new NameSpace[depth()];
    this.a.copyInto(arrayOfNameSpace);
    return arrayOfNameSpace;
  }

  public String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("CallStack:\n");
    NameSpace[] arrayOfNameSpace = toArray();
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfNameSpace.length)
        return localStringBuffer1.toString();
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("\t");
      localStringBuffer2.append(arrayOfNameSpace[i]);
      localStringBuffer2.append("\n");
      localStringBuffer1.append(localStringBuffer2.toString());
    }
  }

  public NameSpace top()
  {
    return get(0);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.CallStack
 * JD-Core Version:    0.6.2
 */