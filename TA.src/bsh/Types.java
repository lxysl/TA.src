package bsh;

import java.util.Hashtable;

class Types
{
  static Primitive a = new Primitive(1);
  static Primitive b = new Primitive(-1);
  static Class c;
  static Class d;
  static Class e;
  static Class f;

  static UtilEvalError a(Class paramClass1, Class paramClass2, int paramInt)
  {
    return a(Reflect.normalizeClassName(paramClass1), Reflect.normalizeClassName(paramClass2), paramInt);
  }

  static UtilEvalError a(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("Can't assign ");
      localStringBuffer1.append(paramString2);
      localStringBuffer1.append(" to ");
      localStringBuffer1.append(paramString1);
      return new UtilEvalError(localStringBuffer1.toString());
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append("Cannot cast ");
    localStringBuffer2.append(paramString2);
    localStringBuffer2.append(" to ");
    localStringBuffer2.append(paramString1);
    return new UtilTargetError(new ClassCastException(localStringBuffer2.toString()));
  }

  static Class a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }

  private static Object a(Class paramClass1, Class paramClass2, Object paramObject, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramObject != null))
      throw new InterpreterError("bad cast params 1");
    if ((!paramBoolean) && (paramObject == null))
      throw new InterpreterError("bad cast params 2");
    Class localClass1;
    if (e == null)
    {
      localClass1 = a("bsh.Primitive");
      e = localClass1;
    }
    else
    {
      localClass1 = e;
    }
    if (paramClass2 == localClass1)
      throw new InterpreterError("bad from Type, need to unwrap");
    if ((paramObject == Primitive.NULL) && (paramClass2 != null))
      throw new InterpreterError("inconsistent args 1");
    if ((paramObject == Primitive.VOID) && (paramClass2 != Void.TYPE))
      throw new InterpreterError("inconsistent args 2");
    if (paramClass1 == Void.TYPE)
      throw new InterpreterError("loose toType should be null");
    if ((paramClass1 != null) && (paramClass1 != paramClass2))
    {
      if (paramClass1.isPrimitive())
        if ((paramClass2 != Void.TYPE) && (paramClass2 != null) && (!paramClass2.isPrimitive()))
        {
          if (Primitive.isWrapperType(paramClass2))
          {
            Class localClass4 = Primitive.unboxType(paramClass2);
            Primitive localPrimitive;
            if (paramBoolean)
              localPrimitive = null;
            else
              localPrimitive = (Primitive)Primitive.wrap(paramObject, localClass4);
            return Primitive.a(paramClass1, localClass4, localPrimitive, paramBoolean, paramInt);
          }
          if (paramBoolean)
            return b;
          throw a(paramClass1, paramClass2, paramInt);
        }
      Class localClass2;
      do
      {
        return Primitive.a(paramClass1, paramClass2, (Primitive)paramObject, paramBoolean, paramInt);
        if ((paramClass2 != Void.TYPE) && (paramClass2 != null) && (!paramClass2.isPrimitive()))
        {
          if (paramClass1.isAssignableFrom(paramClass2))
          {
            if (paramBoolean)
              paramObject = a;
            return paramObject;
          }
          if (paramClass1.isInterface())
          {
            Class localClass3;
            if (f == null)
            {
              localClass3 = a("bsh.This");
              f = localClass3;
            }
            else
            {
              localClass3 = f;
            }
            if ((localClass3.isAssignableFrom(paramClass2)) && (Capabilities.canGenerateInterfaces()))
            {
              if (paramBoolean)
                return a;
              return ((This)paramObject).getInterface(paramClass1);
            }
          }
          if ((Primitive.isWrapperType(paramClass1)) && (Primitive.isWrapperType(paramClass2)))
          {
            if (paramBoolean)
              return a;
            return Primitive.a(paramClass1, paramObject);
          }
          if (paramBoolean)
            return b;
          throw a(paramClass1, paramClass2, paramInt);
        }
        if ((Primitive.isWrapperType(paramClass1)) && (paramClass2 != Void.TYPE) && (paramClass2 != null))
        {
          if (paramBoolean)
            return a;
          return Primitive.a(Primitive.unboxType(paramClass1), ((Primitive)paramObject).getValue());
        }
        if (c == null)
        {
          localClass2 = a("java.lang.Object");
          c = localClass2;
        }
        else
        {
          localClass2 = c;
        }
      }
      while ((paramClass1 != localClass2) || (paramClass2 == Void.TYPE) || (paramClass2 == null));
      if (paramBoolean)
        return a;
      return ((Primitive)paramObject).getValue();
    }
    if (paramBoolean)
      paramObject = a;
    return paramObject;
  }

  static boolean a(Class paramClass1, Class paramClass2)
  {
    return (b(paramClass1, paramClass2)) || (c(paramClass1, paramClass2));
  }

  private static boolean a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    return false;
  }

  static boolean a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, int paramInt)
  {
    if ((paramInt != 3) && (paramArrayOfClass1.length != paramArrayOfClass2.length))
      return false;
    switch (paramInt)
    {
    default:
      throw new InterpreterError("bad case");
    case 4:
      for (int k = 0; ; k++)
      {
        if (k >= paramArrayOfClass1.length)
          return true;
        if (!d(paramArrayOfClass2[k], paramArrayOfClass1[k]))
          return false;
      }
    case 3:
      return a(paramArrayOfClass1, paramArrayOfClass2);
    case 2:
      for (int j = 0; ; j++)
      {
        if (j >= paramArrayOfClass1.length)
          return true;
        if (!c(paramArrayOfClass2[j], paramArrayOfClass1[j]))
          return false;
      }
    case 1:
    }
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfClass1.length)
        return true;
      if (!b(paramArrayOfClass2[i], paramArrayOfClass1[i]))
        return false;
    }
  }

  static boolean b(Class paramClass1, Class paramClass2)
  {
    if (paramClass1 == null)
      return false;
    if (paramClass2 == null)
      return true ^ paramClass1.isPrimitive();
    if ((paramClass1.isPrimitive()) && (paramClass2.isPrimitive()))
    {
      if (paramClass1 == paramClass2)
        return true;
      if ((paramClass2 == Byte.TYPE) && ((paramClass1 == Short.TYPE) || (paramClass1 == Integer.TYPE) || (paramClass1 == Long.TYPE) || (paramClass1 == Float.TYPE) || (paramClass1 == Double.TYPE)))
        return true;
      if ((paramClass2 == Short.TYPE) && ((paramClass1 == Integer.TYPE) || (paramClass1 == Long.TYPE) || (paramClass1 == Float.TYPE) || (paramClass1 == Double.TYPE)))
        return true;
      if ((paramClass2 == Character.TYPE) && ((paramClass1 == Integer.TYPE) || (paramClass1 == Long.TYPE) || (paramClass1 == Float.TYPE) || (paramClass1 == Double.TYPE)))
        return true;
      if ((paramClass2 == Integer.TYPE) && ((paramClass1 == Long.TYPE) || (paramClass1 == Float.TYPE) || (paramClass1 == Double.TYPE)))
        return true;
      if ((paramClass2 == Long.TYPE) && ((paramClass1 == Float.TYPE) || (paramClass1 == Double.TYPE)))
        return true;
      if ((paramClass2 == Float.TYPE) && (paramClass1 == Double.TYPE))
        return true;
    }
    else if (paramClass1.isAssignableFrom(paramClass2))
    {
      return true;
    }
    return false;
  }

  static boolean c(Class paramClass1, Class paramClass2)
  {
    if (paramClass1 == null)
      return false;
    Class localClass1;
    if (c == null)
    {
      localClass1 = a("java.lang.Object");
      c = localClass1;
    }
    else
    {
      localClass1 = c;
    }
    if (paramClass1 == localClass1)
      return true;
    Class localClass2;
    if (d == null)
    {
      localClass2 = a("java.lang.Number");
      d = localClass2;
    }
    else
    {
      localClass2 = d;
    }
    if ((paramClass1 == localClass2) && (paramClass2 != Character.TYPE) && (paramClass2 != Boolean.TYPE))
      return true;
    return Primitive.a.get(paramClass1) == paramClass2;
  }

  public static Object castObject(Object paramObject, Class paramClass, int paramInt)
  {
    if (paramObject == null)
      throw new InterpreterError("null fromValue");
    Class localClass;
    if ((paramObject instanceof Primitive))
      localClass = ((Primitive)paramObject).getType();
    else
      localClass = paramObject.getClass();
    return a(paramClass, localClass, paramObject, paramInt, false);
  }

  static boolean d(Class paramClass1, Class paramClass2)
  {
    try
    {
      Object localObject = a(paramClass1, paramClass2, null, 1, true);
      Primitive localPrimitive = a;
      return localObject == localPrimitive;
    }
    catch (UtilEvalError localUtilEvalError)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("err in cast check: ");
      localStringBuffer.append(localUtilEvalError);
      throw new InterpreterError(localStringBuffer.toString());
    }
  }

  public static Class[] getTypes(Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramArrayOfObject == null)
      return new Class[0];
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    while (true)
    {
      if (i >= paramArrayOfObject.length)
        return arrayOfClass;
      if (paramArrayOfObject[i] == null)
        arrayOfClass[i] = null;
      else if ((paramArrayOfObject[i] instanceof Primitive))
        arrayOfClass[i] = ((Primitive)paramArrayOfObject[i]).getType();
      else
        arrayOfClass[i] = paramArrayOfObject[i].getClass();
      i++;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Types
 * JD-Core Version:    0.6.2
 */