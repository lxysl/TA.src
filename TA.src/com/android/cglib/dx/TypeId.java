package com.android.cglib.dx;

import com.android.cglib.dx.c.c.w;
import com.android.cglib.dx.c.d.c;
import java.util.HashMap;
import java.util.Map;

public final class TypeId<T>
{
  public static final TypeId<Boolean> BOOLEAN = new TypeId(c.a);
  public static final TypeId<Byte> BYTE = new TypeId(c.b);
  public static final TypeId<Character> CHAR = new TypeId(c.c);
  public static final TypeId<Double> DOUBLE = new TypeId(c.d);
  public static final TypeId<Float> FLOAT = new TypeId(c.e);
  public static final TypeId<Integer> INT = new TypeId(c.f);
  public static final TypeId<Long> LONG = new TypeId(c.g);
  public static final TypeId<Object> OBJECT;
  public static final TypeId<Short> SHORT = new TypeId(c.h);
  public static final TypeId<String> STRING;
  public static final TypeId<Void> VOID = new TypeId(c.i);
  private static final Map<Class<?>, TypeId<?>> d;
  final String a;
  final c b;
  final w c;

  static
  {
    OBJECT = new TypeId(c.o);
    STRING = new TypeId(c.q);
    d = new HashMap();
    d.put(Boolean.TYPE, BOOLEAN);
    d.put(Byte.TYPE, BYTE);
    d.put(Character.TYPE, CHAR);
    d.put(Double.TYPE, DOUBLE);
    d.put(Float.TYPE, FLOAT);
    d.put(Integer.TYPE, INT);
    d.put(Long.TYPE, LONG);
    d.put(Short.TYPE, SHORT);
    d.put(Void.TYPE, VOID);
  }

  TypeId(c paramc)
  {
    this(paramc.e(), paramc);
  }

  TypeId(String paramString, c paramc)
  {
    if ((paramString != null) && (paramc != null))
    {
      this.a = paramString;
      this.b = paramc;
      this.c = w.a(paramc);
      return;
    }
    throw new NullPointerException();
  }

  public static <T> TypeId<T> get(Class<T> paramClass)
  {
    if (paramClass.isPrimitive())
      return (TypeId)d.get(paramClass);
    String str = paramClass.getName().replace('.', '/');
    if (!paramClass.isArray())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('L');
      localStringBuilder.append(str);
      localStringBuilder.append(';');
      str = localStringBuilder.toString();
    }
    return get(str);
  }

  public static <T> TypeId<T> get(String paramString)
  {
    return new TypeId(paramString, c.b(paramString));
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeId)) && (((TypeId)paramObject).a.equals(this.a));
  }

  public MethodId<T, Void> getConstructor(TypeId<?>[] paramArrayOfTypeId)
  {
    return new MethodId(this, VOID, "<init>", new TypeList(paramArrayOfTypeId));
  }

  public <V> FieldId<T, V> getField(TypeId<V> paramTypeId, String paramString)
  {
    return new FieldId(this, paramTypeId, paramString);
  }

  public <R> MethodId<T, R> getMethod(TypeId<R> paramTypeId, String paramString, TypeId<?>[] paramArrayOfTypeId)
  {
    return new MethodId(this, paramTypeId, paramString, new TypeList(paramArrayOfTypeId));
  }

  public String getName()
  {
    return this.a;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.TypeId
 * JD-Core Version:    0.6.2
 */