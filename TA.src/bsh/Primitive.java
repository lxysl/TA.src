package bsh;

import java.io.Serializable;
import java.util.Hashtable;

public final class Primitive
  implements ParserConstants, Serializable
{
  public static final Primitive NULL = new Primitive(Special.NULL_VALUE);
  public static final Primitive VOID = new Primitive(Special.VOID_TYPE);
  static Hashtable a = new Hashtable();
  static Class b;
  static Class c;
  static Class d;
  static Class e;
  static Class f;
  static Class g;
  static Class h;
  static Class i;
  static Class j;
  private Object k;

  static
  {
    Hashtable localHashtable1 = a;
    Class localClass1 = Boolean.TYPE;
    Class localClass2;
    if (b == null)
    {
      localClass2 = a("java.lang.Boolean");
      b = localClass2;
    }
    else
    {
      localClass2 = b;
    }
    localHashtable1.put(localClass1, localClass2);
    Hashtable localHashtable2 = a;
    Class localClass3 = Byte.TYPE;
    Class localClass4;
    if (c == null)
    {
      localClass4 = a("java.lang.Byte");
      c = localClass4;
    }
    else
    {
      localClass4 = c;
    }
    localHashtable2.put(localClass3, localClass4);
    Hashtable localHashtable3 = a;
    Class localClass5 = Short.TYPE;
    Class localClass6;
    if (d == null)
    {
      localClass6 = a("java.lang.Short");
      d = localClass6;
    }
    else
    {
      localClass6 = d;
    }
    localHashtable3.put(localClass5, localClass6);
    Hashtable localHashtable4 = a;
    Class localClass7 = Character.TYPE;
    Class localClass8;
    if (e == null)
    {
      localClass8 = a("java.lang.Character");
      e = localClass8;
    }
    else
    {
      localClass8 = e;
    }
    localHashtable4.put(localClass7, localClass8);
    Hashtable localHashtable5 = a;
    Class localClass9 = Integer.TYPE;
    Class localClass10;
    if (f == null)
    {
      localClass10 = a("java.lang.Integer");
      f = localClass10;
    }
    else
    {
      localClass10 = f;
    }
    localHashtable5.put(localClass9, localClass10);
    Hashtable localHashtable6 = a;
    Class localClass11 = Long.TYPE;
    Class localClass12;
    if (g == null)
    {
      localClass12 = a("java.lang.Long");
      g = localClass12;
    }
    else
    {
      localClass12 = g;
    }
    localHashtable6.put(localClass11, localClass12);
    Hashtable localHashtable7 = a;
    Class localClass13 = Float.TYPE;
    Class localClass14;
    if (h == null)
    {
      localClass14 = a("java.lang.Float");
      h = localClass14;
    }
    else
    {
      localClass14 = h;
    }
    localHashtable7.put(localClass13, localClass14);
    Hashtable localHashtable8 = a;
    Class localClass15 = Double.TYPE;
    Class localClass16;
    if (i == null)
    {
      localClass16 = a("java.lang.Double");
      i = localClass16;
    }
    else
    {
      localClass16 = i;
    }
    localHashtable8.put(localClass15, localClass16);
    Hashtable localHashtable9 = a;
    Class localClass17;
    if (b == null)
    {
      localClass17 = a("java.lang.Boolean");
      b = localClass17;
    }
    else
    {
      localClass17 = b;
    }
    localHashtable9.put(localClass17, Boolean.TYPE);
    Hashtable localHashtable10 = a;
    Class localClass18;
    if (c == null)
    {
      localClass18 = a("java.lang.Byte");
      c = localClass18;
    }
    else
    {
      localClass18 = c;
    }
    localHashtable10.put(localClass18, Byte.TYPE);
    Hashtable localHashtable11 = a;
    Class localClass19;
    if (d == null)
    {
      localClass19 = a("java.lang.Short");
      d = localClass19;
    }
    else
    {
      localClass19 = d;
    }
    localHashtable11.put(localClass19, Short.TYPE);
    Hashtable localHashtable12 = a;
    Class localClass20;
    if (e == null)
    {
      localClass20 = a("java.lang.Character");
      e = localClass20;
    }
    else
    {
      localClass20 = e;
    }
    localHashtable12.put(localClass20, Character.TYPE);
    Hashtable localHashtable13 = a;
    Class localClass21;
    if (f == null)
    {
      localClass21 = a("java.lang.Integer");
      f = localClass21;
    }
    else
    {
      localClass21 = f;
    }
    localHashtable13.put(localClass21, Integer.TYPE);
    Hashtable localHashtable14 = a;
    Class localClass22;
    if (g == null)
    {
      localClass22 = a("java.lang.Long");
      g = localClass22;
    }
    else
    {
      localClass22 = g;
    }
    localHashtable14.put(localClass22, Long.TYPE);
    Hashtable localHashtable15 = a;
    Class localClass23;
    if (h == null)
    {
      localClass23 = a("java.lang.Float");
      h = localClass23;
    }
    else
    {
      localClass23 = h;
    }
    localHashtable15.put(localClass23, Float.TYPE);
    Hashtable localHashtable16 = a;
    Class localClass24;
    if (i == null)
    {
      localClass24 = a("java.lang.Double");
      i = localClass24;
    }
    else
    {
      localClass24 = i;
    }
    localHashtable16.put(localClass24, Double.TYPE);
  }

  public Primitive(byte paramByte)
  {
    this(new Byte(paramByte));
  }

  public Primitive(char paramChar)
  {
    this(new Character(paramChar));
  }

  public Primitive(double paramDouble)
  {
    this(new Double(paramDouble));
  }

  public Primitive(float paramFloat)
  {
    this(new Float(paramFloat));
  }

  public Primitive(int paramInt)
  {
    this(new Integer(paramInt));
  }

  public Primitive(long paramLong)
  {
    this(new Long(paramLong));
  }

  public Primitive(Object paramObject)
  {
    if (paramObject == null)
      throw new InterpreterError("Use Primitve.NULL instead of Primitive(null)");
    if ((paramObject != Special.NULL_VALUE) && (paramObject != Special.VOID_TYPE) && (!isWrapperType(paramObject.getClass())))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Not a wrapper type: ");
      localStringBuffer.append(paramObject);
      throw new InterpreterError(localStringBuffer.toString());
    }
    this.k = paramObject;
  }

  public Primitive(short paramShort)
  {
    this(new Short(paramShort));
  }

  public Primitive(boolean paramBoolean)
  {
    this(new Boolean(paramBoolean));
  }

  static double a(Double paramDouble, int paramInt)
  {
    double d1 = paramDouble.doubleValue();
    switch (paramInt)
    {
    default:
      throw new InterpreterError("bad double unaryOperation");
    case 103:
      return -d1;
    case 102:
    }
    return d1;
  }

  static float a(Float paramFloat, int paramInt)
  {
    float f1 = paramFloat.floatValue();
    switch (paramInt)
    {
    default:
      throw new InterpreterError("bad float unaryOperation");
    case 103:
      f1 = -f1;
    case 102:
    }
    return f1;
  }

  static int a(Integer paramInteger, int paramInt)
  {
    int m = paramInteger.intValue();
    if (paramInt != 87)
    {
      switch (paramInt)
      {
      default:
        throw new InterpreterError("bad integer unaryOperation");
      case 103:
        m = -m;
      case 102:
        return m;
      case 101:
        return m - 1;
      case 100:
      }
      return m + 1;
    }
    return m ^ 0xFFFFFFFF;
  }

  static long a(Long paramLong, int paramInt)
  {
    long l = paramLong.longValue();
    if (paramInt != 87)
    {
      switch (paramInt)
      {
      default:
        throw new InterpreterError("bad long unaryOperation");
      case 103:
        return -l;
      case 102:
        return l;
      case 101:
        return l - 1L;
      case 100:
      }
      return l + 1L;
    }
    return l ^ 0xFFFFFFFF;
  }

  static Primitive a(Class paramClass1, Class paramClass2, Primitive paramPrimitive, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramPrimitive != null))
      throw new InterpreterError("bad cast param 1");
    if ((!paramBoolean) && (paramPrimitive == null))
      throw new InterpreterError("bad cast param 2");
    if ((paramClass2 != null) && (!paramClass2.isPrimitive()))
    {
      StringBuffer localStringBuffer3 = new StringBuffer();
      localStringBuffer3.append("bad fromType:");
      localStringBuffer3.append(paramClass2);
      throw new InterpreterError(localStringBuffer3.toString());
    }
    if ((paramPrimitive == NULL) && (paramClass2 != null))
      throw new InterpreterError("inconsistent args 1");
    if ((paramPrimitive == VOID) && (paramClass2 != Void.TYPE))
      throw new InterpreterError("inconsistent args 2");
    if (paramClass2 == Void.TYPE)
    {
      if (paramBoolean)
        return Types.b;
      throw Types.a(Reflect.normalizeClassName(paramClass1), "void value", paramInt);
    }
    Object localObject = null;
    if (paramPrimitive != null)
      localObject = paramPrimitive.getValue();
    if (paramClass1.isPrimitive())
    {
      if (paramClass2 == null)
      {
        if (paramBoolean)
          return Types.b;
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("primitive type:");
        localStringBuffer2.append(paramClass1);
        throw Types.a(localStringBuffer2.toString(), "Null value", paramInt);
      }
      if (paramClass2 == Boolean.TYPE)
      {
        if (paramClass1 != Boolean.TYPE)
        {
          if (paramBoolean)
            return Types.b;
          throw Types.a(paramClass1, paramClass2, paramInt);
        }
        if (paramBoolean)
          paramPrimitive = Types.a;
        return paramPrimitive;
      }
      if ((paramInt == 1) && (!Types.a(paramClass1, paramClass2)))
      {
        if (paramBoolean)
          return Types.b;
        throw Types.a(paramClass1, paramClass2, paramInt);
      }
      if (paramBoolean)
        return Types.a;
      return new Primitive(a(paramClass1, localObject));
    }
    if (paramClass2 == null)
    {
      if (paramBoolean)
        return Types.a;
      return NULL;
    }
    if (paramBoolean)
      return Types.b;
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("object type:");
    localStringBuffer1.append(paramClass1);
    throw Types.a(localStringBuffer1.toString(), "primitive value", paramInt);
  }

  static Boolean a(Boolean paramBoolean1, Boolean paramBoolean2, int paramInt)
  {
    boolean bool1 = paramBoolean1.booleanValue();
    boolean bool2 = paramBoolean2.booleanValue();
    if (paramInt != 90)
    {
      switch (paramInt)
      {
      default:
        throw new InterpreterError("unimplemented binary operator");
      case 98:
      case 99:
        boolean bool6 = false;
        if (bool1)
        {
          bool6 = false;
          if (bool2)
            bool6 = true;
        }
        return new Boolean(bool6);
      case 96:
      case 97:
        boolean bool5;
        if (!bool1)
        {
          bool5 = false;
          if (!bool2);
        }
        else
        {
          bool5 = true;
        }
        return new Boolean(bool5);
      case 95:
      }
      boolean bool4 = false;
      if (bool1 != bool2)
        bool4 = true;
      return new Boolean(bool4);
    }
    boolean bool3 = false;
    if (bool1 == bool2)
      bool3 = true;
    return new Boolean(bool3);
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

  static Object a(Class paramClass, Object paramObject)
  {
    if (!paramClass.isPrimitive())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("invalid type in castWrapper: ");
      localStringBuffer.append(paramClass);
      throw new InterpreterError(localStringBuffer.toString());
    }
    if (paramObject == null)
      throw new InterpreterError("null value in castWrapper, guard");
    if ((paramObject instanceof Boolean))
    {
      if (paramClass != Boolean.TYPE)
        throw new InterpreterError("bad wrapper cast of boolean");
      return paramObject;
    }
    if ((paramObject instanceof Character))
      paramObject = new Integer(((Character)paramObject).charValue());
    if (!(paramObject instanceof Number))
      throw new InterpreterError("bad type in cast");
    Number localNumber = (Number)paramObject;
    if (paramClass == Byte.TYPE)
      return new Byte(localNumber.byteValue());
    if (paramClass == Short.TYPE)
      return new Short(localNumber.shortValue());
    if (paramClass == Character.TYPE)
      return new Character((char)localNumber.intValue());
    if (paramClass == Integer.TYPE)
      return new Integer(localNumber.intValue());
    if (paramClass == Long.TYPE)
      return new Long(localNumber.longValue());
    if (paramClass == Float.TYPE)
      return new Float(localNumber.floatValue());
    if (paramClass == Double.TYPE)
      return new Double(localNumber.doubleValue());
    throw new InterpreterError("error in wrapper cast");
  }

  static Object a(Double paramDouble1, Double paramDouble2, int paramInt)
  {
    double d1 = paramDouble1.doubleValue();
    double d2 = paramDouble2.doubleValue();
    switch (paramInt)
    {
    default:
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
          switch (paramInt)
          {
          default:
            throw new InterpreterError("Unimplemented binary double operator");
          case 112:
          case 113:
          case 114:
          case 115:
          case 116:
          case 117:
            throw new UtilEvalError("Can't shift doubles");
          case 111:
          }
          return new Double(d1 % d2);
        case 105:
          return new Double(d1 / d2);
        case 104:
          return new Double(d1 * d2);
        case 103:
          return new Double(d1 - d2);
        case 102:
        }
        return new Double(d1 + d2);
      case 95:
        boolean bool11 = d1 < d2;
        boolean bool12 = false;
        if (bool11)
          bool12 = true;
        return new Boolean(bool12);
      case 93:
      case 94:
        boolean bool9 = d1 < d2;
        boolean bool10 = false;
        if (!bool9)
          bool10 = true;
        return new Boolean(bool10);
      case 91:
      case 92:
        boolean bool7 = d1 < d2;
        boolean bool8 = false;
        if (!bool7)
          bool8 = true;
        return new Boolean(bool8);
      case 90:
      }
      boolean bool5 = d1 < d2;
      boolean bool6 = false;
      if (!bool5)
        bool6 = true;
      return new Boolean(bool6);
    case 84:
    case 85:
      boolean bool3 = d1 < d2;
      boolean bool4 = false;
      if (bool3)
        bool4 = true;
      return new Boolean(bool4);
    case 82:
    case 83:
    }
    boolean bool1 = d1 < d2;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return new Boolean(bool2);
  }

  static Object a(Float paramFloat1, Float paramFloat2, int paramInt)
  {
    float f1 = paramFloat1.floatValue();
    float f2 = paramFloat2.floatValue();
    switch (paramInt)
    {
    default:
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
          switch (paramInt)
          {
          default:
            throw new InterpreterError("Unimplemented binary float operator");
          case 112:
          case 113:
          case 114:
          case 115:
          case 116:
          case 117:
            throw new UtilEvalError("Can't shift floats ");
          case 111:
          }
          return new Float(f1 % f2);
        case 105:
          return new Float(f1 / f2);
        case 104:
          return new Float(f1 * f2);
        case 103:
          return new Float(f1 - f2);
        case 102:
        }
        return new Float(f1 + f2);
      case 95:
        boolean bool11 = f1 < f2;
        boolean bool12 = false;
        if (bool11)
          bool12 = true;
        return new Boolean(bool12);
      case 93:
      case 94:
        boolean bool9 = f1 < f2;
        boolean bool10 = false;
        if (!bool9)
          bool10 = true;
        return new Boolean(bool10);
      case 91:
      case 92:
        boolean bool7 = f1 < f2;
        boolean bool8 = false;
        if (!bool7)
          bool8 = true;
        return new Boolean(bool8);
      case 90:
      }
      boolean bool5 = f1 < f2;
      boolean bool6 = false;
      if (!bool5)
        bool6 = true;
      return new Boolean(bool6);
    case 84:
    case 85:
      boolean bool3 = f1 < f2;
      boolean bool4 = false;
      if (bool3)
        bool4 = true;
      return new Boolean(bool4);
    case 82:
    case 83:
    }
    boolean bool1 = f1 < f2;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return new Boolean(bool2);
  }

  static Object a(Integer paramInteger1, Integer paramInteger2, int paramInt)
  {
    int m = paramInteger1.intValue();
    int n = paramInteger2.intValue();
    switch (paramInt)
    {
    default:
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
          throw new InterpreterError("Unimplemented binary integer operator");
        case 116:
        case 117:
          return new Integer(m >>> n);
        case 114:
        case 115:
          return new Integer(m >> n);
        case 112:
        case 113:
          return new Integer(m << n);
        case 111:
          return new Integer(m % n);
        case 110:
          return new Integer(m ^ n);
        case 108:
        case 109:
          return new Integer(m | n);
        case 106:
        case 107:
          return new Integer(m & n);
        case 105:
          return new Integer(m / n);
        case 104:
          return new Integer(m * n);
        case 103:
          return new Integer(m - n);
        case 102:
        }
        return new Integer(m + n);
      case 95:
        boolean bool6 = false;
        if (m != n)
          bool6 = true;
        return new Boolean(bool6);
      case 93:
      case 94:
        boolean bool5 = false;
        if (m >= n)
          bool5 = true;
        return new Boolean(bool5);
      case 91:
      case 92:
        boolean bool4 = false;
        if (m <= n)
          bool4 = true;
        return new Boolean(bool4);
      case 90:
      }
      boolean bool3 = false;
      if (m == n)
        bool3 = true;
      return new Boolean(bool3);
    case 84:
    case 85:
      boolean bool2 = false;
      if (m < n)
        bool2 = true;
      return new Boolean(bool2);
    case 82:
    case 83:
    }
    boolean bool1 = false;
    if (m > n)
      bool1 = true;
    return new Boolean(bool1);
  }

  static Object a(Long paramLong1, Long paramLong2, int paramInt)
  {
    long l1 = paramLong1.longValue();
    long l2 = paramLong2.longValue();
    switch (paramInt)
    {
    default:
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
          throw new InterpreterError("Unimplemented binary long operator");
        case 116:
        case 117:
          return new Long(l1 >>> (int)l2);
        case 114:
        case 115:
          return new Long(l1 >> (int)l2);
        case 112:
        case 113:
          return new Long(l1 << (int)l2);
        case 111:
          return new Long(l1 % l2);
        case 110:
          return new Long(l1 ^ l2);
        case 108:
        case 109:
          return new Long(l1 | l2);
        case 106:
        case 107:
          return new Long(l1 & l2);
        case 105:
          return new Long(l1 / l2);
        case 104:
          return new Long(l1 * l2);
        case 103:
          return new Long(l1 - l2);
        case 102:
        }
        return new Long(l1 + l2);
      case 95:
        boolean bool11 = l1 < l2;
        boolean bool12 = false;
        if (bool11)
          bool12 = true;
        return new Boolean(bool12);
      case 93:
      case 94:
        boolean bool9 = l1 < l2;
        boolean bool10 = false;
        if (!bool9)
          bool10 = true;
        return new Boolean(bool10);
      case 91:
      case 92:
        boolean bool7 = l1 < l2;
        boolean bool8 = false;
        if (!bool7)
          bool8 = true;
        return new Boolean(bool8);
      case 90:
      }
      boolean bool5 = l1 < l2;
      boolean bool6 = false;
      if (!bool5)
        bool6 = true;
      return new Boolean(bool6);
    case 84:
    case 85:
      boolean bool3 = l1 < l2;
      boolean bool4 = false;
      if (bool3)
        bool4 = true;
      return new Boolean(bool4);
    case 82:
    case 83:
    }
    boolean bool1 = l1 < l2;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return new Boolean(bool2);
  }

  static Object a(Object paramObject)
  {
    if ((paramObject instanceof Character))
      return new Integer(((Character)paramObject).charValue());
    if ((!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)))
      return paramObject;
    return new Integer(((Number)paramObject).intValue());
  }

  static Object a(Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 instanceof Boolean))
      return a((Boolean)paramObject1, (Boolean)paramObject2, paramInt);
    if ((paramObject1 instanceof Integer))
      return a((Integer)paramObject1, (Integer)paramObject2, paramInt);
    if ((paramObject1 instanceof Long))
      return a((Long)paramObject1, (Long)paramObject2, paramInt);
    if ((paramObject1 instanceof Float))
      return a((Float)paramObject1, (Float)paramObject2, paramInt);
    if ((paramObject1 instanceof Double))
      return a((Double)paramObject1, (Double)paramObject2, paramInt);
    throw new UtilEvalError("Invalid types in binary operator");
  }

  static boolean a(Boolean paramBoolean, int paramInt)
  {
    boolean bool = paramBoolean.booleanValue();
    if (paramInt != 86)
      throw new UtilEvalError("Operator inappropriate for boolean");
    return bool ^ true;
  }

  static Object[] a(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = a(paramObject1);
    Object localObject2 = a(paramObject2);
    if (((localObject1 instanceof Number)) && ((localObject2 instanceof Number)))
    {
      Number localNumber1 = (Number)localObject1;
      Number localNumber2 = (Number)localObject2;
      boolean bool1 = localNumber1 instanceof Double;
      if ((!bool1) && (!(localNumber2 instanceof Double)))
      {
        boolean bool2 = localNumber1 instanceof Float;
        if ((!bool2) && (!(localNumber2 instanceof Float)))
        {
          boolean bool3 = localNumber1 instanceof Long;
          if ((bool3) || ((localNumber2 instanceof Long)))
            if (bool3)
              localObject2 = new Long(localNumber2.longValue());
            else
              localObject1 = new Long(localNumber1.longValue());
        }
        else if (bool2)
        {
          localObject2 = new Float(localNumber2.floatValue());
        }
        else
        {
          localObject1 = new Float(localNumber1.floatValue());
        }
      }
      else if (bool1)
      {
        localObject2 = new Double(localNumber2.doubleValue());
      }
      else
      {
        localObject1 = new Double(localNumber1.doubleValue());
      }
    }
    return new Object[] { localObject1, localObject2 };
  }

  public static Object binaryOperation(Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 != NULL) && (paramObject2 != NULL))
    {
      if ((paramObject1 != VOID) && (paramObject2 != VOID))
      {
        Class localClass1 = paramObject1.getClass();
        Class localClass2 = paramObject2.getClass();
        if ((paramObject1 instanceof Primitive))
          paramObject1 = ((Primitive)paramObject1).getValue();
        if ((paramObject2 instanceof Primitive))
          paramObject2 = ((Primitive)paramObject2).getValue();
        Object[] arrayOfObject = a(paramObject1, paramObject2);
        Object localObject1 = arrayOfObject[0];
        Object localObject2 = arrayOfObject[1];
        if (localObject1.getClass() != localObject2.getClass())
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append("Type mismatch in operator.  ");
          localStringBuffer.append(localObject1.getClass());
          localStringBuffer.append(" cannot be used with ");
          localStringBuffer.append(localObject2.getClass());
          throw new UtilEvalError(localStringBuffer.toString());
        }
        try
        {
          Object localObject3 = a(localObject1, localObject2, paramInt);
          Class localClass3;
          if (j == null)
          {
            localClass3 = a("bsh.Primitive");
            j = localClass3;
          }
          else
          {
            localClass3 = j;
          }
          if (localClass1 == localClass3)
          {
            Class localClass4;
            if (j == null)
            {
              localClass4 = a("bsh.Primitive");
              j = localClass4;
            }
            else
            {
              localClass4 = j;
            }
            if (localClass2 == localClass4);
          }
          else
          {
            if (!(localObject3 instanceof Boolean))
              break label264;
          }
          return new Primitive(localObject3);
          label264: return localObject3;
        }
        catch (ArithmeticException localArithmeticException)
        {
          throw new UtilTargetError("Arithemetic Exception in binary op", localArithmeticException);
        }
      }
      throw new UtilEvalError("Undefined variable, class, or 'void' literal in binary operation");
    }
    throw new UtilEvalError("Null value or 'null' literal in binary operation");
  }

  public static Class boxType(Class paramClass)
  {
    Class localClass = (Class)a.get(paramClass);
    if (localClass != null)
      return localClass;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Not a primitive type: ");
    localStringBuffer.append(paramClass);
    throw new InterpreterError(localStringBuffer.toString());
  }

  // ERROR //
  public static Primitive getDefaultValue(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +56 -> 57
    //   4: aload_0
    //   5: invokevirtual 214	java/lang/Class:isPrimitive	()Z
    //   8: ifne +6 -> 14
    //   11: goto +46 -> 57
    //   14: aload_0
    //   15: getstatic 39	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   18: if_acmpne +12 -> 30
    //   21: new 2	bsh/Primitive
    //   24: dup
    //   25: iconst_0
    //   26: invokespecial 381	bsh/Primitive:<init>	(Z)V
    //   29: areturn
    //   30: new 2	bsh/Primitive
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 382	bsh/Primitive:<init>	(I)V
    //   38: aload_0
    //   39: iconst_0
    //   40: invokevirtual 386	bsh/Primitive:castToType	(Ljava/lang/Class;I)Lbsh/Primitive;
    //   43: astore_1
    //   44: aload_1
    //   45: areturn
    //   46: new 136	bsh/InterpreterError
    //   49: dup
    //   50: ldc_w 388
    //   53: invokespecial 141	bsh/InterpreterError:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: getstatic 110	bsh/Primitive:NULL	Lbsh/Primitive;
    //   60: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   30	44	46	bsh/UtilEvalError
  }

  public static boolean isWrapperType(Class paramClass)
  {
    return (a.get(paramClass) != null) && (!paramClass.isPrimitive());
  }

  public static Primitive unaryOperation(Primitive paramPrimitive, int paramInt)
  {
    if (paramPrimitive == NULL)
      throw new UtilEvalError("illegal use of null object or 'null' literal");
    if (paramPrimitive == VOID)
      throw new UtilEvalError("illegal use of undefined object or 'void' literal");
    Class localClass = paramPrimitive.getType();
    Object localObject = a(paramPrimitive.getValue());
    if ((localObject instanceof Boolean))
      return new Primitive(a((Boolean)localObject, paramInt));
    if ((localObject instanceof Integer))
    {
      int m = a((Integer)localObject, paramInt);
      if ((paramInt == 100) || (paramInt == 101))
      {
        if (localClass == Byte.TYPE)
          return new Primitive((byte)m);
        if (localClass == Short.TYPE)
          return new Primitive((short)m);
        if (localClass == Character.TYPE)
          return new Primitive((char)m);
      }
      return new Primitive(m);
    }
    if ((localObject instanceof Long))
      return new Primitive(a((Long)localObject, paramInt));
    if ((localObject instanceof Float))
      return new Primitive(a((Float)localObject, paramInt));
    if ((localObject instanceof Double))
      return new Primitive(a((Double)localObject, paramInt));
    throw new InterpreterError("An error occurred.  Please call technical support.");
  }

  public static Class unboxType(Class paramClass)
  {
    Class localClass = (Class)a.get(paramClass);
    if (localClass != null)
      return localClass;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Not a primitive wrapper type: ");
    localStringBuffer.append(paramClass);
    throw new InterpreterError(localStringBuffer.toString());
  }

  public static Object unwrap(Object paramObject)
  {
    if (paramObject == VOID)
      return null;
    if ((paramObject instanceof Primitive))
      paramObject = ((Primitive)paramObject).getValue();
    return paramObject;
  }

  public static Object[] unwrap(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = new Object[paramArrayOfObject.length];
    for (int m = 0; ; m++)
    {
      if (m >= paramArrayOfObject.length)
        return arrayOfObject;
      arrayOfObject[m] = unwrap(paramArrayOfObject[m]);
    }
  }

  public static Object wrap(Object paramObject, Class paramClass)
  {
    if (paramClass == Void.TYPE)
      return VOID;
    if (paramObject == null)
      return NULL;
    if (paramClass.isPrimitive())
      return new Primitive(paramObject);
    return paramObject;
  }

  public static Object[] wrap(Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    if (paramArrayOfObject == null)
      return null;
    Object[] arrayOfObject = new Object[paramArrayOfObject.length];
    for (int m = 0; ; m++)
    {
      if (m >= paramArrayOfObject.length)
        return arrayOfObject;
      arrayOfObject[m] = wrap(paramArrayOfObject[m], paramArrayOfClass[m]);
    }
  }

  public boolean booleanValue()
  {
    if ((this.k instanceof Boolean))
      return ((Boolean)this.k).booleanValue();
    throw new UtilEvalError("Primitive not a boolean");
  }

  public Primitive castToType(Class paramClass, int paramInt)
  {
    return a(paramClass, getType(), this, false, paramInt);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Primitive))
      return ((Primitive)paramObject).k.equals(this.k);
    return false;
  }

  public Class getType()
  {
    if (this == VOID)
      return Void.TYPE;
    if (this == NULL)
      return null;
    return unboxType(this.k.getClass());
  }

  public Object getValue()
  {
    if (this.k == Special.NULL_VALUE)
      return null;
    if (this.k == Special.VOID_TYPE)
      throw new InterpreterError("attempt to unwrap void type");
    return this.k;
  }

  public int hashCode()
  {
    return 21 * this.k.hashCode();
  }

  public int intValue()
  {
    if ((this.k instanceof Number))
      return ((Number)this.k).intValue();
    throw new UtilEvalError("Primitive not a number");
  }

  public boolean isNumber()
  {
    return (!(this.k instanceof Boolean)) && (this != NULL) && (this != VOID);
  }

  public Number numberValue()
  {
    Object localObject = this.k;
    if ((localObject instanceof Character))
      localObject = new Integer(((Character)localObject).charValue());
    if ((localObject instanceof Number))
      return (Number)localObject;
    throw new UtilEvalError("Primitive not a number");
  }

  public String toString()
  {
    if (this.k == Special.NULL_VALUE)
      return "null";
    if (this.k == Special.VOID_TYPE)
      return "void";
    return this.k.toString();
  }

  private static class Special
    implements Serializable
  {
    public static final Special NULL_VALUE = new Special();
    public static final Special VOID_TYPE = new Special();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.Primitive
 * JD-Core Version:    0.6.2
 */