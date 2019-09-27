package com.android.cglib.proxy;

import android.content.Context;
import com.a.a.a.a.a.a.a;
import com.android.cglib.dx.Code;
import com.android.cglib.dx.Comparison;
import com.android.cglib.dx.DexMaker;
import com.android.cglib.dx.FieldId;
import com.android.cglib.dx.Label;
import com.android.cglib.dx.Local;
import com.android.cglib.dx.MethodId;
import com.android.cglib.dx.TypeId;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Enhancer
{
  private Context a;
  private Class<?> b;
  private MethodInterceptor c;
  private MethodFilter d;

  public Enhancer(Context paramContext)
  {
    this.a = paramContext;
  }

  private <S> void a(DexMaker paramDexMaker, TypeId<?> paramTypeId, TypeId<S> paramTypeId1)
  {
    TypeId localTypeId1 = TypeId.get(MethodInterceptor.class);
    TypeId localTypeId2 = TypeId.get(MethodProxyExecuter.class);
    Object localObject1 = TypeId.get(Class.class);
    TypeId localTypeId3 = TypeId.get([Ljava.lang.Class.class);
    TypeId localTypeId4 = TypeId.get(String.class);
    TypeId localTypeId5 = TypeId.get(Object.class);
    Object localObject2 = TypeId.get([Ljava.lang.Object.class);
    Object localObject3 = paramTypeId1.getField(localTypeId1, "methodInterceptor");
    paramDexMaker.declare((FieldId)localObject3, 2, null);
    Object localObject4 = this.b.getDeclaredConstructors();
    int i = localObject4.length;
    int j = 0;
    while (j < i)
    {
      Object localObject7 = localObject3;
      Constructor localConstructor = localObject4[j];
      Object localObject10;
      int n;
      Object localObject8;
      Object localObject11;
      Object localObject9;
      if (((0x8 & localConstructor.getModifiers()) == 0) && ((0x10 & localConstructor.getModifiers()) == 0))
      {
        localObject10 = localObject1;
        n = i;
        localObject8 = localObject4;
        localObject11 = localObject7;
        localObject9 = localObject2;
        Object localObject12 = localObject11;
        try
        {
          a(paramDexMaker, paramTypeId, paramTypeId1, localConstructor, localObject12);
        }
        catch (Exception localException2)
        {
          a.a(localException2);
        }
      }
      else
      {
        n = i;
        localObject8 = localObject4;
        localObject9 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject7;
      }
      j++;
      i = n;
      localObject1 = localObject10;
      localObject4 = localObject8;
      localObject3 = localObject11;
      localObject2 = localObject9;
    }
    Object localObject5 = localObject3;
    Object localObject6 = localObject1;
    int k = 0;
    Code localCode1 = paramDexMaker.declare(paramTypeId1.getMethod(TypeId.VOID, "setMethodInterceptor_Enhancer", new TypeId[] { localTypeId1 }), 1);
    localCode1.iput(localObject5, localCode1.getThis(paramTypeId1), localCode1.getParameter(0, localTypeId1));
    localCode1.returnVoid();
    Code localCode2 = paramDexMaker.declare(paramTypeId1.getMethod(TypeId.OBJECT, "executeSuperMethod_Enhancer", new TypeId[] { localTypeId4, localTypeId3, localObject2 }), 1);
    Local localLocal1 = localCode2.newLocal(localTypeId5);
    Local localLocal2 = localCode2.newLocal(localObject6);
    Local localLocal3 = localCode2.getThis(paramTypeId1);
    localCode2.invokeVirtual(paramTypeId1.getMethod(localObject6, "getClass", new TypeId[0]), localLocal2, localLocal3, new Local[0]);
    MethodId localMethodId = localTypeId2.getMethod(TypeId.OBJECT, "executeMethod", new TypeId[] { localObject6, localTypeId4, localTypeId3, localObject2, localTypeId5 });
    Local[] arrayOfLocal = new Local[5];
    arrayOfLocal[0] = localLocal2;
    arrayOfLocal[1] = localCode2.getParameter(0, localTypeId4);
    arrayOfLocal[2] = localCode2.getParameter(1, localTypeId3);
    arrayOfLocal[3] = localCode2.getParameter(2, (TypeId)localObject2);
    arrayOfLocal[4] = localLocal3;
    localCode2.invokeStatic(localMethodId, localLocal1, arrayOfLocal);
    localCode2.returnValue(localLocal1);
    Method[] arrayOfMethod = this.b.getMethods();
    int m = arrayOfMethod.length;
    while (k < m)
    {
      Method localMethod = arrayOfMethod[k];
      String str = localMethod.getName();
      if ((!str.contains("_Enhancer")) && (!str.contains("_Super")) && ((0x8 & localMethod.getModifiers()) == 0) && ((0x10 & localMethod.getModifiers()) == 0) && ((0x100 & localMethod.getModifiers()) == 0) && (((0x400 & localMethod.getModifiers()) != 0) || (this.d == null) || (this.d.filter(localMethod, str))))
        try
        {
          a(paramDexMaker, paramTypeId, paramTypeId1, localMethod, str, localObject5);
        }
        catch (Exception localException1)
        {
          a.a(localException1);
        }
      k++;
    }
  }

  private void a(DexMaker paramDexMaker, TypeId<?> paramTypeId1, TypeId<?> paramTypeId2, Constructor paramConstructor, FieldId<?, MethodInterceptor> paramFieldId)
  {
    TypeId.get(MethodInterceptor.class);
    TypeId.get(Class.class);
    TypeId.get([Ljava.lang.Class.class);
    TypeId.get(String.class);
    TypeId.get(Object.class);
    TypeId.get([Ljava.lang.Object.class);
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    int i = 0;
    int j;
    if ((arrayOfClass != null) && (arrayOfClass.length > 0))
      j = 1;
    else
      j = 0;
    if (j != 0)
    {
      arrayOfTypeId = new TypeId[arrayOfClass.length];
      for (int k = 0; k < arrayOfClass.length; k++)
        arrayOfTypeId[k] = TypeId.get(arrayOfClass[k]);
    }
    TypeId[] arrayOfTypeId = null;
    MethodId localMethodId1;
    MethodId localMethodId2;
    if (j != 0)
    {
      localMethodId1 = paramTypeId2.getConstructor(arrayOfTypeId);
      localMethodId2 = paramTypeId1.getConstructor(arrayOfTypeId);
    }
    else
    {
      localMethodId1 = paramTypeId2.getConstructor(new TypeId[0]);
      localMethodId2 = paramTypeId1.getConstructor(new TypeId[0]);
    }
    Code localCode = paramDexMaker.declare(localMethodId1, paramConstructor.getModifiers());
    Local localLocal = localCode.getThis(paramTypeId2);
    if (j != 0)
    {
      arrayOfLocal = new Local[arrayOfClass.length];
      while (i < arrayOfClass.length)
      {
        arrayOfLocal[i] = localCode.getParameter(i, arrayOfTypeId[i]);
        i++;
      }
    }
    Local[] arrayOfLocal = new Local[0];
    localCode.invokeDirect(localMethodId2, null, localLocal, arrayOfLocal);
    localCode.returnVoid();
  }

  private void a(DexMaker paramDexMaker, TypeId<?> paramTypeId1, TypeId<?> paramTypeId2, Method paramMethod, String paramString, FieldId<?, MethodInterceptor> paramFieldId)
  {
    TypeId localTypeId1 = TypeId.get(MethodInterceptor.class);
    TypeId localTypeId2 = TypeId.get(MethodProxyExecuter.class);
    TypeId localTypeId3 = TypeId.get(Class.class);
    TypeId localTypeId4 = TypeId.get([Ljava.lang.Class.class);
    TypeId localTypeId5 = TypeId.get(String.class);
    TypeId localTypeId6 = TypeId.get(Object.class);
    TypeId localTypeId7 = TypeId.get([Ljava.lang.Object.class);
    Class localClass = paramMethod.getReturnType();
    boolean bool1 = localClass.getSimpleName().equals("void");
    TypeId localTypeId8 = TypeId.get(localClass);
    Object localObject1 = paramMethod.getParameterTypes();
    int i;
    if ((localObject1 != null) && (localObject1.length > 0))
      i = 1;
    else
      i = 0;
    TypeId[] arrayOfTypeId1;
    TypeId localTypeId9;
    boolean bool2;
    MethodId localMethodId1;
    if (i != 0)
    {
      arrayOfTypeId1 = new TypeId[localObject1.length];
      localTypeId9 = localTypeId2;
      bool2 = bool1;
      for (int m = 0; m < localObject1.length; m++)
        arrayOfTypeId1[m] = TypeId.get(localObject1[m]);
      localMethodId1 = paramTypeId2.getMethod(localTypeId8, paramString, arrayOfTypeId1);
    }
    else
    {
      localTypeId9 = localTypeId2;
      bool2 = bool1;
      localMethodId1 = paramTypeId2.getMethod(localTypeId8, paramString, new TypeId[0]);
      arrayOfTypeId1 = null;
    }
    Code localCode1 = paramDexMaker.declare(localMethodId1, 0xFFFFFBFF & paramMethod.getModifiers());
    Local localLocal1 = localCode1.newLocal(localTypeId8);
    Local localLocal3;
    Local localLocal2;
    if (localClass.isPrimitive())
    {
      localLocal3 = localCode1.newLocal(TypeId.get(Const.getPackedType(localClass)));
      localLocal2 = localLocal1;
    }
    else
    {
      localLocal2 = localLocal1;
      localLocal3 = null;
    }
    Local localLocal4 = localCode1.newLocal(TypeId.INT);
    Local localLocal5 = localCode1.newLocal(localTypeId1);
    Local localLocal6 = localLocal3;
    Local localLocal7 = localCode1.newLocal(TypeId.get(String.class));
    Object localObject2 = localCode1.newLocal(localTypeId3);
    Local localLocal8 = localCode1.newLocal(localTypeId3);
    Local localLocal9 = localCode1.newLocal(localTypeId4);
    Local localLocal10 = localCode1.newLocal(localTypeId7);
    Local localLocal11 = localCode1.newLocal(localTypeId6);
    Local localLocal12 = localCode1.newLocal(TypeId.OBJECT);
    Local localLocal13 = localCode1.getThis(paramTypeId2);
    Object localObject3 = localLocal11;
    localCode1.iget(paramFieldId, localLocal5, localLocal13);
    localCode1.loadConstant(localLocal7, paramString);
    localCode1.invokeVirtual(paramTypeId2.getMethod(localTypeId3, "getClass", new TypeId[0]), localLocal8, localLocal13, new Local[0]);
    Object localObject4;
    if (i != 0)
    {
      localCode1.loadConstant(localLocal4, Integer.valueOf(localObject1.length));
      localCode1.newArray(localLocal9, localLocal4);
      localCode1.newArray(localLocal10, localLocal4);
      int k = 0;
      while (k < localObject1.length)
      {
        localCode1.loadConstant(localLocal4, Integer.valueOf(k));
        localCode1.loadConstant((Local)localObject2, localObject1[k]);
        localCode1.aput(localLocal9, localLocal4, (Local)localObject2);
        Object localObject6;
        Object localObject7;
        Object localObject8;
        if (localObject1[k].isPrimitive())
        {
          TypeId localTypeId13 = TypeId.get(Const.getPackedType(localObject1[k]));
          localObject6 = localObject2;
          localObject7 = localObject1;
          TypeId[] arrayOfTypeId4 = new TypeId[1];
          arrayOfTypeId4[0] = arrayOfTypeId1[k];
          MethodId localMethodId6 = localTypeId13.getMethod(localTypeId13, "valueOf", arrayOfTypeId4);
          Local[] arrayOfLocal3 = new Local[1];
          arrayOfLocal3[0] = localCode1.getParameter(k, arrayOfTypeId1[k]);
          localObject8 = localObject3;
          localCode1.invokeStatic(localMethodId6, localObject8, arrayOfLocal3);
          localCode1.aput(localLocal10, localLocal4, localObject8);
        }
        else
        {
          localObject6 = localObject2;
          localObject7 = localObject1;
          localObject8 = localObject3;
          localCode1.aput(localLocal10, localLocal4, localCode1.getParameter(k, arrayOfTypeId1[k]));
        }
        k++;
        localObject3 = localObject8;
        localObject2 = localObject6;
        localObject1 = localObject7;
      }
      localObject4 = localObject1;
    }
    else
    {
      localObject4 = localObject1;
      localCode1.loadConstant(localLocal9, null);
      localCode1.loadConstant(localLocal10, null);
    }
    TypeId localTypeId10 = TypeId.OBJECT;
    TypeId[] arrayOfTypeId2 = { localTypeId1, localTypeId3, localTypeId5, localTypeId4, localTypeId7, localTypeId6 };
    MethodId localMethodId2 = localTypeId9.getMethod(localTypeId10, "executeInterceptor", arrayOfTypeId2);
    Local localLocal14;
    if (bool2)
      localLocal14 = null;
    else
      localLocal14 = localLocal12;
    localCode1.invokeStatic(localMethodId2, localLocal14, new Local[] { localLocal5, localLocal8, localLocal7, localLocal9, localLocal10, localLocal13 });
    TypeId localTypeId12;
    if (bool2)
    {
      localCode1.returnVoid();
      localTypeId12 = localTypeId8;
    }
    else
    {
      Local localLocal15;
      if (localClass.isPrimitive())
      {
        Label localLabel = new Label();
        localCode1.loadConstant(localLocal6, null);
        localCode1.compare(Comparison.EQ, localLabel, localLocal12, localLocal6);
        localCode1.cast(localLocal6, localLocal12);
        TypeId localTypeId11 = TypeId.get(Const.getPackedType(localClass));
        String str = Const.getPrimitiveValueMethodName(localClass);
        TypeId[] arrayOfTypeId3 = new TypeId[0];
        localTypeId12 = localTypeId8;
        MethodId localMethodId3 = localTypeId11.getMethod(localTypeId12, str, arrayOfTypeId3);
        Local[] arrayOfLocal1 = new Local[0];
        localLocal15 = localLocal2;
        localCode1.invokeVirtual(localMethodId3, localLocal15, localLocal6, arrayOfLocal1);
        localCode1.returnValue(localLocal15);
        localCode1.mark(localLabel);
        localCode1.loadConstant(localLocal15, Integer.valueOf(0));
      }
      while (true)
      {
        localCode1.returnValue(localLocal15);
        break;
        localLocal15 = localLocal2;
        localTypeId12 = localTypeId8;
        localCode1.cast(localLocal15, localLocal12);
      }
    }
    MethodId localMethodId4;
    MethodId localMethodId5;
    if (i != 0)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("_Super");
      localMethodId4 = paramTypeId2.getMethod(localTypeId12, localStringBuilder1.toString(), arrayOfTypeId1);
      localMethodId5 = paramTypeId1.getMethod(localTypeId12, paramString, arrayOfTypeId1);
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("_Super");
      localMethodId4 = paramTypeId2.getMethod(localTypeId12, localStringBuilder2.toString(), new TypeId[0]);
      localMethodId5 = paramTypeId1.getMethod(localTypeId12, paramString, new TypeId[0]);
    }
    Code localCode2 = paramDexMaker.declare(localMethodId4, paramMethod.getModifiers());
    Local localLocal16 = localCode2.newLocal(localTypeId12);
    Local localLocal17 = localCode2.getThis(paramTypeId2);
    if (i != 0)
    {
      Object localObject5 = localObject4;
      Local[] arrayOfLocal2 = new Local[localObject5.length];
      for (int j = 0; j < localObject5.length; j++)
        arrayOfLocal2[j] = localCode2.getParameter(j, arrayOfTypeId1[j]);
      Local localLocal19;
      if (bool2)
        localLocal19 = null;
      else
        localLocal19 = localLocal16;
      localCode2.invokeSuper(localMethodId5, localLocal19, localLocal17, arrayOfLocal2);
    }
    else
    {
      Local localLocal18 = null;
      if (!bool2)
        while (true)
          localLocal18 = localLocal16;
      localCode2.invokeSuper(localMethodId5, localLocal18, localLocal17, new Local[0]);
    }
    if (bool2)
    {
      localCode2.returnVoid();
      return;
    }
    localCode2.returnValue(localLocal16);
  }

  public Class<?> create()
  {
    String str1 = this.b.getName().replace(".", "/");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(str1);
    localStringBuilder1.append("_Enhancer");
    localStringBuilder1.append("_");
    localStringBuilder1.append(hashCode());
    String str2 = localStringBuilder1.toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("L");
    localStringBuilder2.append(str1);
    localStringBuilder2.append(";");
    TypeId localTypeId1 = TypeId.get(localStringBuilder2.toString());
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append("L");
    localStringBuilder3.append(str2);
    localStringBuilder3.append(";");
    TypeId localTypeId2 = TypeId.get(localStringBuilder3.toString());
    TypeId localTypeId3 = TypeId.get(EnhancerInterface.class);
    String str3 = this.a.getExternalFilesDir("dexfiles").getAbsolutePath();
    DexMaker localDexMaker = new DexMaker();
    StringBuilder localStringBuilder4 = new StringBuilder();
    localStringBuilder4.append(str1);
    localStringBuilder4.append(".proxy");
    localDexMaker.declare(localTypeId2, localStringBuilder4.toString(), 1, localTypeId1, new TypeId[] { localTypeId3 });
    a(localDexMaker, localTypeId1, localTypeId2);
    try
    {
      Class localClass = localDexMaker.generateAndLoad(Enhancer.class.getClassLoader(), new File(str3)).loadClass(str2);
      return localClass;
    }
    catch (IOException|ClassNotFoundException localIOException)
    {
      a.a(localIOException);
    }
    return null;
  }

  public void setInterceptor(MethodInterceptor paramMethodInterceptor)
  {
    this.c = paramMethodInterceptor;
  }

  public void setMethodFilter(MethodFilter paramMethodFilter)
  {
    this.d = paramMethodFilter;
  }

  public void setSuperclass(Class<?> paramClass)
  {
    this.b = paramClass;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.proxy.Enhancer
 * JD-Core Version:    0.6.2
 */