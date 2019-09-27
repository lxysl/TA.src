package bsh;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class NameSpace
  implements BshClassManager.Listener, NameSource, Serializable
{
  public static final NameSpace JAVACODE = new NameSpace((BshClassManager)null, "Called from compiled Java code.");
  protected Hashtable a;
  SimpleNode b;
  boolean c;
  boolean d;
  Class e;
  Object f;
  Vector g;
  private String h;
  private NameSpace i;
  private Hashtable j;
  private Hashtable k;
  private Vector l;
  private Vector m;
  private Vector n;
  private Vector o;
  private String p;
  private transient BshClassManager q;
  private This r;
  private Hashtable s;
  private transient Hashtable t;

  static
  {
    JAVACODE.c = true;
  }

  public NameSpace(BshClassManager paramBshClassManager, String paramString)
  {
    this(null, paramBshClassManager, paramString);
  }

  public NameSpace(NameSpace paramNameSpace, BshClassManager paramBshClassManager, String paramString)
  {
    setName(paramString);
    setParent(paramNameSpace);
    a(paramBshClassManager);
    if (paramBshClassManager != null)
      paramBshClassManager.addListener(this);
  }

  public NameSpace(NameSpace paramNameSpace, String paramString)
  {
    this(paramNameSpace, null, paramString);
  }

  private BshMethod a(InputStream paramInputStream, String paramString1, Class[] paramArrayOfClass, String paramString2, Interpreter paramInterpreter)
  {
    try
    {
      paramInterpreter.eval(new InputStreamReader(paramInputStream), this, paramString2);
      return getMethod(paramString1, paramArrayOfClass);
    }
    catch (EvalError localEvalError)
    {
      Interpreter.debug(localEvalError.toString());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Error loading script: ");
      localStringBuffer.append(localEvalError.getMessage());
      throw new UtilEvalError(localStringBuffer.toString());
    }
  }

  private String[] a(Enumeration paramEnumeration)
  {
    Vector localVector = new Vector();
    while (true)
    {
      if (!paramEnumeration.hasMoreElements())
      {
        String[] arrayOfString = new String[localVector.size()];
        localVector.copyInto(arrayOfString);
        return arrayOfString;
      }
      localVector.addElement(paramEnumeration.nextElement());
    }
  }

  private BshMethod[] b(Enumeration paramEnumeration)
  {
    Vector localVector1 = new Vector();
    while (true)
    {
      if (!paramEnumeration.hasMoreElements())
      {
        BshMethod[] arrayOfBshMethod = new BshMethod[localVector1.size()];
        localVector1.copyInto(arrayOfBshMethod);
        return arrayOfBshMethod;
      }
      Object localObject = paramEnumeration.nextElement();
      if ((localObject instanceof BshMethod))
      {
        localVector1.addElement(localObject);
      }
      else
      {
        Vector localVector2 = (Vector)localObject;
        for (int i1 = 0; i1 < localVector2.size(); i1++)
          localVector1.addElement(localVector2.elementAt(i1));
      }
    }
  }

  private Class d(String paramString)
  {
    Class localClass1;
    if (this.t != null)
    {
      localClass1 = (Class)this.t.get(paramString);
      if (localClass1 != null)
        return localClass1;
    }
    else
    {
      localClass1 = null;
    }
    boolean bool = true ^ Name.isCompound(paramString);
    if (bool)
    {
      if (localClass1 == null)
        localClass1 = e(paramString);
      if (localClass1 != null)
      {
        a(paramString, localClass1);
        return localClass1;
      }
    }
    Class localClass2 = f(paramString);
    if (localClass2 != null)
    {
      if (bool)
        a(paramString, localClass2);
      return localClass2;
    }
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("getClass(): ");
      localStringBuffer.append(paramString);
      localStringBuffer.append(" not\tfound in ");
      localStringBuffer.append(this);
      Interpreter.debug(localStringBuffer.toString());
    }
    return null;
  }

  private Class e(String paramString)
  {
    String str1;
    if (this.a != null)
      str1 = (String)this.a.get(paramString);
    else
      str1 = null;
    if (str1 != null)
    {
      Object localObject = f(str1);
      if (localObject == null)
      {
        if (Name.isCompound(str1));
        label105: 
        try
        {
          Class localClass2 = b(str1).toClass();
          localObject = localClass2;
          break label105;
          if (Interpreter.DEBUG)
          {
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append("imported unpackaged name not found:");
            localStringBuffer2.append(str1);
            Interpreter.debug(localStringBuffer2.toString());
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
        }
        if (localObject != null)
        {
          getClassManager().cacheClassInfo(str1, (Class)localObject);
          return localObject;
        }
        return null;
      }
      return localObject;
    }
    if (this.l != null)
      for (int i1 = -1 + this.l.size(); i1 >= 0; i1--)
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append((String)this.l.elementAt(i1));
        localStringBuffer1.append(".");
        localStringBuffer1.append(paramString);
        Class localClass1 = f(localStringBuffer1.toString());
        if (localClass1 != null)
          return localClass1;
      }
    BshClassManager localBshClassManager = getClassManager();
    if (localBshClassManager.c())
    {
      String str2 = localBshClassManager.b(paramString);
      if (str2 != null)
        return f(str2);
    }
    return null;
  }

  private Class f(String paramString)
  {
    return getClassManager().classForName(paramString);
  }

  public static Class identifierToClass(ClassIdentifier paramClassIdentifier)
  {
    return paramClassIdentifier.getTargetClass();
  }

  protected BshMethod a(String paramString, Class[] paramArrayOfClass)
  {
    if (this.n != null)
      for (int i2 = 0; i2 < this.n.size(); i2++)
      {
        Object localObject = this.n.elementAt(i2);
        Class localClass2 = localObject.getClass();
        Method localMethod2 = Reflect.a(getClassManager(), localClass2, paramString, paramArrayOfClass, false);
        if (localMethod2 != null)
          return new BshMethod(localMethod2, localObject);
      }
    Vector localVector = this.o;
    int i1 = 0;
    if (localVector != null)
      while (true)
      {
        if (i1 >= this.o.size())
          return null;
        Class localClass1 = (Class)this.o.elementAt(i1);
        Method localMethod1 = Reflect.a(getClassManager(), localClass1, paramString, paramArrayOfClass, true);
        if (localMethod1 != null)
          return new BshMethod(localMethod1, null);
        i1++;
      }
    return null;
  }

  This a(Interpreter paramInterpreter)
  {
    if (this.r == null)
      this.r = This.a(this, paramInterpreter);
    return this.r;
  }

  protected Variable a(String paramString)
  {
    if (this.n != null)
      for (int i2 = 0; i2 < this.n.size(); i2++)
      {
        Object localObject = this.n.elementAt(i2);
        Field localField2 = Reflect.a(localObject.getClass(), paramString, false);
        if (localField2 != null)
          return new Variable(paramString, localField2.getType(), new LHS(localObject, localField2));
      }
    Vector localVector = this.o;
    int i1 = 0;
    if (localVector != null)
      while (i1 < this.o.size())
      {
        Field localField1 = Reflect.a((Class)this.o.elementAt(i1), paramString, true);
        if (localField1 != null)
          return new Variable(paramString, localField1.getType(), new LHS(localField1));
        i1++;
      }
    return null;
  }

  protected Variable a(String paramString, boolean paramBoolean)
  {
    Variable localVariable;
    if (this.d)
      localVariable = a(paramString);
    else
      localVariable = null;
    if ((localVariable == null) && (this.j != null))
      localVariable = (Variable)this.j.get(paramString);
    if ((localVariable == null) && (!this.d))
      localVariable = a(paramString);
    if ((paramBoolean) && (localVariable == null) && (this.i != null))
      localVariable = this.i.a(paramString, paramBoolean);
    return localVariable;
  }

  Object a()
  {
    if (this.f != null)
      return this.f;
    if (this.e != null)
      throw new UtilEvalError("Can't refer to class instance from static context.");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Can't resolve class instance 'this' in: ");
    localStringBuffer.append(this);
    throw new InterpreterError(localStringBuffer.toString());
  }

  protected Object a(Variable paramVariable)
  {
    if (paramVariable == null)
      return Primitive.VOID;
    return paramVariable.a();
  }

  void a(BshClassManager paramBshClassManager)
  {
    this.q = paramBshClassManager;
  }

  void a(SimpleNode paramSimpleNode)
  {
    this.b = paramSimpleNode;
  }

  void a(Class paramClass)
  {
    this.e = paramClass;
    importStatic(paramClass);
  }

  void a(Object paramObject)
  {
    this.f = paramObject;
    importObject(paramObject);
  }

  void a(String paramString, Class paramClass)
  {
    if (this.t == null)
      this.t = new Hashtable();
    this.t.put(paramString, paramClass);
  }

  void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    setVariable(paramString, paramObject, paramBoolean, false);
  }

  protected void a(Vector paramVector)
  {
    Enumeration localEnumeration1 = this.j.keys();
    while (true)
    {
      if (!localEnumeration1.hasMoreElements())
      {
        Enumeration localEnumeration2 = this.k.keys();
        while (true)
        {
          if (!localEnumeration2.hasMoreElements())
          {
            if (this.i != null)
              this.i.a(paramVector);
            return;
          }
          paramVector.addElement(localEnumeration2.nextElement());
        }
      }
      paramVector.addElement(localEnumeration1.nextElement());
    }
  }

  public void addNameSourceListener(NameSource.Listener paramListener)
  {
    if (this.g == null)
      this.g = new Vector();
    this.g.addElement(paramListener);
  }

  Name b(String paramString)
  {
    if (this.s == null)
      this.s = new Hashtable();
    Name localName = (Name)this.s.get(paramString);
    if (localName == null)
    {
      localName = new Name(this, paramString);
      this.s.put(paramString, localName);
    }
    return localName;
  }

  SimpleNode b()
  {
    if (this.b != null)
      return this.b;
    if (this.i != null)
      return this.i.b();
    return null;
  }

  String c()
  {
    if (this.p != null)
      return this.p;
    if (this.i != null)
      return this.i.c();
    return null;
  }

  void c(String paramString)
  {
    this.p = paramString;
  }

  public void classLoaderChanged()
  {
    nameSpaceChanged();
  }

  public void clear()
  {
    this.j = null;
    this.k = null;
    this.a = null;
    this.l = null;
    this.m = null;
    this.n = null;
    if (this.i == null)
      loadDefaultImports();
    this.t = null;
    this.s = null;
  }

  public void doSuperImport()
  {
    getClassManager().b();
  }

  public Object get(String paramString, Interpreter paramInterpreter)
  {
    CallStack localCallStack = new CallStack(this);
    return b(paramString).toObject(localCallStack, paramInterpreter);
  }

  public String[] getAllNames()
  {
    Vector localVector = new Vector();
    a(localVector);
    String[] arrayOfString = new String[localVector.size()];
    localVector.copyInto(arrayOfString);
    return arrayOfString;
  }

  public Class getClass(String paramString)
  {
    Class localClass = d(paramString);
    if (localClass != null)
      return localClass;
    if (this.i != null)
      return this.i.getClass(paramString);
    return null;
  }

  public BshClassManager getClassManager()
  {
    if (this.q != null)
      return this.q;
    if ((this.i != null) && (this.i != JAVACODE))
      return this.i.getClassManager();
    System.out.println("experiment: creating class manager");
    this.q = BshClassManager.createClassManager(null);
    return this.q;
  }

  public Object getCommand(String paramString, Class[] paramArrayOfClass, Interpreter paramInterpreter)
  {
    if (Interpreter.DEBUG)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("getCommand: ");
      localStringBuffer1.append(paramString);
      Interpreter.debug(localStringBuffer1.toString());
    }
    BshClassManager localBshClassManager = paramInterpreter.getClassManager();
    if (this.m != null)
      for (int i1 = this.m.size() - 1; i1 >= 0; i1--)
      {
        String str1 = (String)this.m.elementAt(i1);
        StringBuffer localStringBuffer2;
        if (str1.equals("/"))
        {
          localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append(str1);
        }
        String str2;
        while (true)
        {
          localStringBuffer2.append(paramString);
          localStringBuffer2.append(".bsh");
          str2 = localStringBuffer2.toString();
          break;
          localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append(str1);
          localStringBuffer2.append("/");
        }
        StringBuffer localStringBuffer3 = new StringBuffer();
        localStringBuffer3.append("searching for script: ");
        localStringBuffer3.append(str2);
        Interpreter.debug(localStringBuffer3.toString());
        InputStream localInputStream = localBshClassManager.getResourceAsStream(str2);
        if (localInputStream != null)
          return a(localInputStream, paramString, paramArrayOfClass, str2, paramInterpreter);
        String str3;
        if (str1.equals("/"))
        {
          str3 = paramString;
        }
        else
        {
          StringBuffer localStringBuffer4 = new StringBuffer();
          localStringBuffer4.append(str1.substring(1).replace('/', '.'));
          localStringBuffer4.append(".");
          localStringBuffer4.append(paramString);
          str3 = localStringBuffer4.toString();
        }
        StringBuffer localStringBuffer5 = new StringBuffer();
        localStringBuffer5.append("searching for class: ");
        localStringBuffer5.append(str3);
        Interpreter.debug(localStringBuffer5.toString());
        Class localClass = localBshClassManager.classForName(str3);
        if (localClass != null)
          return localClass;
      }
    if (this.i != null)
      return this.i.getCommand(paramString, paramArrayOfClass, paramInterpreter);
    return null;
  }

  public Variable[] getDeclaredVariables()
  {
    Hashtable localHashtable = this.j;
    int i1 = 0;
    if (localHashtable == null)
      return new Variable[0];
    Variable[] arrayOfVariable = new Variable[this.j.size()];
    Enumeration localEnumeration = this.j.elements();
    while (true)
    {
      if (!localEnumeration.hasMoreElements())
        return arrayOfVariable;
      int i2 = i1 + 1;
      arrayOfVariable[i1] = ((Variable)localEnumeration.nextElement());
      i1 = i2;
    }
  }

  public This getGlobal(Interpreter paramInterpreter)
  {
    if (this.i != null)
      return this.i.getGlobal(paramInterpreter);
    return a(paramInterpreter);
  }

  public int getInvocationLine()
  {
    SimpleNode localSimpleNode = b();
    if (localSimpleNode != null)
      return localSimpleNode.getLineNumber();
    return -1;
  }

  public String getInvocationText()
  {
    SimpleNode localSimpleNode = b();
    if (localSimpleNode != null)
      return localSimpleNode.getText();
    return "<invoked from Java code>";
  }

  public BshMethod getMethod(String paramString, Class[] paramArrayOfClass)
  {
    return getMethod(paramString, paramArrayOfClass, false);
  }

  public BshMethod getMethod(String paramString, Class[] paramArrayOfClass, boolean paramBoolean)
  {
    BshMethod localBshMethod;
    if ((this.d) && (!paramBoolean))
      localBshMethod = a(paramString, paramArrayOfClass);
    else
      localBshMethod = null;
    if ((localBshMethod == null) && (this.k != null))
    {
      Object localObject = this.k.get(paramString);
      if (localObject != null)
      {
        boolean bool = localObject instanceof Vector;
        int i1 = 0;
        BshMethod[] arrayOfBshMethod;
        if (bool)
        {
          Vector localVector = (Vector)localObject;
          arrayOfBshMethod = new BshMethod[localVector.size()];
          localVector.copyInto(arrayOfBshMethod);
        }
        else
        {
          arrayOfBshMethod = new BshMethod[1];
          arrayOfBshMethod[0] = ((BshMethod)localObject);
        }
        Class[][] arrayOfClass; = new Class[arrayOfBshMethod.length][];
        while (true)
        {
          if (i1 >= arrayOfBshMethod.length)
          {
            int i2 = Reflect.a(paramArrayOfClass, arrayOfClass;);
            if (i2 == -1)
              break;
            localBshMethod = arrayOfBshMethod[i2];
            break;
          }
          arrayOfClass;[i1] = arrayOfBshMethod[i1].getParameterTypes();
          i1++;
        }
      }
    }
    if ((localBshMethod == null) && (!this.d) && (!paramBoolean))
      localBshMethod = a(paramString, paramArrayOfClass);
    if ((!paramBoolean) && (localBshMethod == null) && (this.i != null))
      return this.i.getMethod(paramString, paramArrayOfClass);
    return localBshMethod;
  }

  public String[] getMethodNames()
  {
    if (this.k == null)
      return new String[0];
    return a(this.k.keys());
  }

  public BshMethod[] getMethods()
  {
    if (this.k == null)
      return new BshMethod[0];
    return b(this.k.elements());
  }

  public String getName()
  {
    return this.h;
  }

  public NameSpace getParent()
  {
    return this.i;
  }

  public This getSuper(Interpreter paramInterpreter)
  {
    if (this.i != null)
      return this.i.a(paramInterpreter);
    return a(paramInterpreter);
  }

  public Object getVariable(String paramString)
  {
    return getVariable(paramString, true);
  }

  public Object getVariable(String paramString, boolean paramBoolean)
  {
    return a(a(paramString, paramBoolean));
  }

  public String[] getVariableNames()
  {
    if (this.j == null)
      return new String[0];
    return a(this.j.keys());
  }

  public void importClass(String paramString)
  {
    if (this.a == null)
      this.a = new Hashtable();
    this.a.put(Name.suffix(paramString, 1), paramString);
    nameSpaceChanged();
  }

  public void importCommands(String paramString)
  {
    if (this.m == null)
      this.m = new Vector();
    String str = paramString.replace('.', '/');
    if (!str.startsWith("/"))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("/");
      localStringBuffer.append(str);
      str = localStringBuffer.toString();
    }
    if ((str.length() > 1) && (str.endsWith("/")))
      str = str.substring(0, str.length() - 1);
    if (this.m.contains(str))
      this.m.remove(str);
    this.m.addElement(str);
    nameSpaceChanged();
  }

  public void importObject(Object paramObject)
  {
    if (this.n == null)
      this.n = new Vector();
    if (this.n.contains(paramObject))
      this.n.remove(paramObject);
    this.n.addElement(paramObject);
    nameSpaceChanged();
  }

  public void importPackage(String paramString)
  {
    if (this.l == null)
      this.l = new Vector();
    if (this.l.contains(paramString))
      this.l.remove(paramString);
    this.l.addElement(paramString);
    nameSpaceChanged();
  }

  public void importStatic(Class paramClass)
  {
    if (this.o == null)
      this.o = new Vector();
    if (this.o.contains(paramClass))
      this.o.remove(paramClass);
    this.o.addElement(paramClass);
    nameSpaceChanged();
  }

  public Object invokeMethod(String paramString, Object[] paramArrayOfObject, Interpreter paramInterpreter)
  {
    return invokeMethod(paramString, paramArrayOfObject, paramInterpreter, null, null);
  }

  public Object invokeMethod(String paramString, Object[] paramArrayOfObject, Interpreter paramInterpreter, CallStack paramCallStack, SimpleNode paramSimpleNode)
  {
    return a(paramInterpreter).invokeMethod(paramString, paramArrayOfObject, paramInterpreter, paramCallStack, paramSimpleNode, false);
  }

  public void loadDefaultImports()
  {
    importClass("bsh.EvalError");
    importClass("bsh.Interpreter");
    importPackage("javax.swing.event");
    importPackage("javax.swing");
    importPackage("java.awt.event");
    importPackage("java.awt");
    importPackage("java.net");
    importPackage("java.util");
    importPackage("java.io");
    importPackage("java.lang");
    importCommands("/bsh/commands");
  }

  public void nameSpaceChanged()
  {
    this.t = null;
    this.s = null;
  }

  public void prune()
  {
    if (this.q == null)
      a(BshClassManager.createClassManager(null));
    setParent(null);
  }

  public void setMethod(String paramString, BshMethod paramBshMethod)
  {
    if (this.k == null)
      this.k = new Hashtable();
    Object localObject = this.k.get(paramString);
    if (localObject == null)
    {
      this.k.put(paramString, paramBshMethod);
      return;
    }
    if ((localObject instanceof BshMethod))
    {
      Vector localVector = new Vector();
      localVector.addElement(localObject);
      localVector.addElement(paramBshMethod);
      this.k.put(paramString, localVector);
      return;
    }
    ((Vector)localObject).addElement(paramBshMethod);
  }

  public void setName(String paramString)
  {
    this.h = paramString;
  }

  public void setParent(NameSpace paramNameSpace)
  {
    this.i = paramNameSpace;
    if (paramNameSpace == null)
      loadDefaultImports();
  }

  public void setTypedVariable(String paramString, Class paramClass, Object paramObject, Modifiers paramModifiers)
  {
    if (this.j == null)
      this.j = new Hashtable();
    Variable localVariable = a(paramString, false);
    if ((localVariable != null) && (localVariable.getType() != null))
    {
      if (localVariable.getType() != paramClass)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Typed variable: ");
        localStringBuffer.append(paramString);
        localStringBuffer.append(" was previously declared with type: ");
        localStringBuffer.append(localVariable.getType());
        throw new UtilEvalError(localStringBuffer.toString());
      }
      localVariable.setValue(paramObject, 0);
      return;
    }
    this.j.put(paramString, new Variable(paramString, paramClass, paramObject, paramModifiers));
  }

  public void setTypedVariable(String paramString, Class paramClass, Object paramObject, boolean paramBoolean)
  {
    Modifiers localModifiers = new Modifiers();
    if (paramBoolean)
      localModifiers.addModifier(2, "final");
    setTypedVariable(paramString, paramClass, paramObject, localModifiers);
  }

  public void setVariable(String paramString, Object paramObject, boolean paramBoolean)
  {
    boolean bool;
    if (Interpreter.LOCALSCOPING)
      bool = paramBoolean;
    else
      bool = true;
    setVariable(paramString, paramObject, paramBoolean, bool);
  }

  void setVariable(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.j == null)
      this.j = new Hashtable();
    if (paramObject == null)
      throw new InterpreterError("null variable value");
    Variable localVariable = a(paramString, paramBoolean2);
    if (localVariable != null)
      try
      {
        localVariable.setValue(paramObject, 1);
        return;
      }
      catch (UtilEvalError localUtilEvalError)
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("Variable assignment: ");
        localStringBuffer2.append(paramString);
        localStringBuffer2.append(": ");
        localStringBuffer2.append(localUtilEvalError.getMessage());
        throw new UtilEvalError(localStringBuffer2.toString());
      }
    if (paramBoolean1)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("(Strict Java mode) Assignment to undeclared variable: ");
      localStringBuffer1.append(paramString);
      throw new UtilEvalError(localStringBuffer1.toString());
    }
    this.j.put(paramString, new Variable(paramString, paramObject, null));
    nameSpaceChanged();
  }

  public String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("NameSpace: ");
    String str1;
    if (this.h == null)
    {
      str1 = super.toString();
    }
    else
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(this.h);
      localStringBuffer2.append(" (");
      localStringBuffer2.append(super.toString());
      localStringBuffer2.append(")");
      str1 = localStringBuffer2.toString();
    }
    localStringBuffer1.append(str1);
    String str2;
    if (this.d)
      str2 = " (isClass) ";
    else
      str2 = "";
    localStringBuffer1.append(str2);
    String str3;
    if (this.c)
      str3 = " (method) ";
    else
      str3 = "";
    localStringBuffer1.append(str3);
    String str4;
    if (this.e != null)
      str4 = " (class static) ";
    else
      str4 = "";
    localStringBuffer1.append(str4);
    String str5;
    if (this.f != null)
      str5 = " (class instance) ";
    else
      str5 = "";
    localStringBuffer1.append(str5);
    return localStringBuffer1.toString();
  }

  public void unsetVariable(String paramString)
  {
    if (this.j != null)
    {
      this.j.remove(paramString);
      nameSpaceChanged();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.NameSpace
 * JD-Core Version:    0.6.2
 */