package com.luajava;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.a.a.a.a.a.a.a;
import com.android.cglib.proxy.EnhancerInterface;
import com.android.cglib.proxy.MethodFilter;
import com.androlua.LuaBitmap;
import com.androlua.LuaEnhancer;
import com.androlua.LuaGcable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LuaJavaAPI
{
  private static final HashMap<Class<?>, HashMap<String, ArrayList<Method>>> a = new HashMap();
  private static HashMap<String, Method> b = new HashMap();
  private static HashMap<String, Method> c = new HashMap();
  private static HashMap<String, Method> d = new HashMap();
  private static HashMap<String, Method> e = new HashMap();
  private static HashMap<String, Method> f = new HashMap();
  public static final HashMap<String, Method[]> methodCache;
  public static final HashMap<Class<?>, Method[]> methodsMap = new HashMap();

  static
  {
    methodCache = new HashMap();
  }

  private static int a(LuaState paramLuaState, Class<?> paramClass)
  {
    Class localClass = new LuaEnhancer(paramClass).create(new MethodFilter()
    {
      public boolean filter(Method paramAnonymousMethod, String paramAnonymousString)
      {
        return (0x400 & paramAnonymousMethod.getModifiers()) == 0;
      }
    });
    try
    {
      EnhancerInterface localEnhancerInterface = (EnhancerInterface)localClass.newInstance();
      localEnhancerInterface.setMethodInterceptor_Enhancer(new LuaAbstractMethodInterceptor(paramLuaState.getLuaObject(-1)));
      paramLuaState.pushJavaObject(localEnhancerInterface);
      return 1;
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
    return 0;
  }

  private static int a(LuaState paramLuaState, Object paramObject)
  {
    try
    {
      paramLuaState.newTable();
      if (paramObject.getClass().isArray())
      {
        int k = Array.getLength(paramObject);
        int m = 0;
        while (m <= k - 1)
        {
          a(paramLuaState, Array.get(paramObject, m));
          m++;
          paramLuaState.rawSetI(-2, m);
        }
      }
      if ((paramObject instanceof Collection))
      {
        Iterator localIterator2 = ((Collection)paramObject).iterator();
        int j;
        for (int i = 1; localIterator2.hasNext(); i = j)
        {
          a(paramLuaState, localIterator2.next());
          j = i + 1;
          paramLuaState.rawSetI(-2, i);
        }
      }
      if ((paramObject instanceof Map))
      {
        Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramLuaState.pushObjectValue(localEntry.getKey());
          a(paramLuaState, localEntry.getValue());
          paramLuaState.setTable(-3);
        }
      }
      paramLuaState.pop(1);
      paramLuaState.pushObjectValue(paramObject);
      return 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not astable: ");
      localStringBuilder.append(localException.getMessage());
      throw new LuaException(localStringBuilder.toString());
      label253: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label253;
    }
  }

  // ERROR //
  private static int a(LuaState paramLuaState, Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: instanceof 58
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: checkcast 58	java/lang/Class
    //   21: astore_3
    //   22: iconst_1
    //   23: istore 4
    //   25: goto +11 -> 36
    //   28: aload_1
    //   29: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: astore_3
    //   33: iconst_0
    //   34: istore 4
    //   36: aload_2
    //   37: ldc 183
    //   39: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   42: istore 5
    //   44: aconst_null
    //   45: astore 6
    //   47: iload 5
    //   49: ifne +101 -> 150
    //   52: aload_2
    //   53: iconst_0
    //   54: invokevirtual 193	java/lang/String:charAt	(I)C
    //   57: istore 7
    //   59: iload 7
    //   61: invokestatic 199	java/lang/Character:isLowerCase	(C)Z
    //   64: ifeq +246 -> 310
    //   67: new 159	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   74: astore 8
    //   76: aload 8
    //   78: iload 7
    //   80: invokestatic 203	java/lang/Character:toUpperCase	(C)C
    //   83: invokevirtual 206	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: aload_2
    //   90: iconst_1
    //   91: invokevirtual 210	java/lang/String:substring	(I)Ljava/lang/String;
    //   94: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 8
    //   100: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 11
    //   105: goto +3 -> 108
    //   108: new 159	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   115: astore 12
    //   117: aload 12
    //   119: ldc 183
    //   121: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 12
    //   127: aload 11
    //   129: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 12
    //   135: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 15
    //   140: aload 15
    //   142: astore 6
    //   144: aconst_null
    //   145: astore 16
    //   147: goto +6 -> 153
    //   150: aconst_null
    //   151: astore 16
    //   153: aload_3
    //   154: ifnull +49 -> 203
    //   157: aload_3
    //   158: aload_2
    //   159: invokevirtual 214	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   162: astore 21
    //   164: aload 21
    //   166: astore 16
    //   168: goto +19 -> 187
    //   171: aload 6
    //   173: ifnull +14 -> 187
    //   176: aload_3
    //   177: aload 6
    //   179: invokevirtual 214	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   182: astore 21
    //   184: goto -20 -> 164
    //   187: aload 16
    //   189: ifnull +6 -> 195
    //   192: goto +11 -> 203
    //   195: aload_3
    //   196: invokevirtual 217	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   199: astore_3
    //   200: goto -47 -> 153
    //   203: aload 16
    //   205: ifnonnull +7 -> 212
    //   208: aload_0
    //   209: monitorexit
    //   210: iconst_0
    //   211: ireturn
    //   212: iload 4
    //   214: ifeq +18 -> 232
    //   217: aload 16
    //   219: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   222: invokestatic 229	java/lang/reflect/Modifier:isStatic	(I)Z
    //   225: ifne +7 -> 232
    //   228: aload_0
    //   229: monitorexit
    //   230: iconst_0
    //   231: ireturn
    //   232: aload 16
    //   234: invokevirtual 232	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   237: astore 18
    //   239: aload 16
    //   241: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   244: invokestatic 235	java/lang/reflect/Modifier:isPublic	(I)Z
    //   247: ifne +9 -> 256
    //   250: aload 16
    //   252: iconst_1
    //   253: invokevirtual 239	java/lang/reflect/Field:setAccessible	(Z)V
    //   256: aload 16
    //   258: aload_1
    //   259: aload_0
    //   260: aload 18
    //   262: aload_0
    //   263: invokevirtual 242	com/luajava/LuaState:getTop	()I
    //   266: invokestatic 245	com/luajava/LuaJavaAPI:e	(Lcom/luajava/LuaState;Ljava/lang/Class;I)Ljava/lang/Object;
    //   269: invokevirtual 249	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   272: goto +24 -> 296
    //   275: astore 20
    //   277: new 172	com/luajava/LuaException
    //   280: dup
    //   281: aload 20
    //   283: invokespecial 252	com/luajava/LuaException:<init>	(Ljava/lang/Exception;)V
    //   286: athrow
    //   287: aload_0
    //   288: aload_2
    //   289: iconst_3
    //   290: aload 18
    //   292: invokestatic 255	com/luajava/LuaJavaAPI:a	(Lcom/luajava/LuaState;Ljava/lang/String;ILjava/lang/Class;)Ljava/lang/String;
    //   295: pop
    //   296: aload_0
    //   297: monitorexit
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: monitorexit
    //   302: aload 17
    //   304: athrow
    //   305: astore 17
    //   307: goto -7 -> 300
    //   310: aconst_null
    //   311: astore 11
    //   313: goto -205 -> 108
    //
    // Exception table:
    //   from	to	target	type
    //   157	164	171	java/lang/NoSuchFieldException
    //   176	184	187	java/lang/NoSuchFieldException
    //   239	256	275	java/lang/Exception
    //   256	272	275	java/lang/Exception
    //   239	256	287	com/luajava/LuaException
    //   256	272	287	com/luajava/LuaException
    //   6	8	305	finally
    //   10	22	305	finally
    //   28	33	305	finally
    //   36	44	305	finally
    //   52	105	305	finally
    //   108	140	305	finally
    //   157	164	305	finally
    //   176	184	305	finally
    //   195	200	305	finally
    //   208	210	305	finally
    //   217	230	305	finally
    //   232	239	305	finally
    //   239	256	305	finally
    //   256	272	305	finally
    //   277	287	305	finally
    //   287	296	305	finally
    //   296	298	305	finally
    //   300	302	305	finally
  }

  private static int a(LuaState paramLuaState, Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOn");
      localStringBuilder.append(paramString.substring(2));
      localStringBuilder.append("Listener");
      String str = localStringBuilder.toString();
      Iterator localIterator = getMethod(paramObject.getClass(), str, paramBoolean).iterator();
      while (localIterator.hasNext())
      {
        Method localMethod = (Method)localIterator.next();
        if ((!paramBoolean) || (Modifier.isStatic(localMethod.getModifiers())))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          if ((arrayOfClass.length == 1) && (arrayOfClass[0].isInterface()))
          {
            paramLuaState.newTable();
            paramLuaState.pushValue(-2);
            paramLuaState.setField(-2, paramString);
            try
            {
              Object localObject2 = paramLuaState.getLuaObject(-1).createProxy(arrayOfClass[0]);
              paramLuaState.pop(1);
              localMethod.invoke(paramObject, new Object[] { localObject2 });
              return 1;
            }
            catch (Exception localException)
            {
              throw new LuaException(localException);
            }
          }
        }
      }
      return 0;
    }
    finally
    {
    }
  }

  private static int a(LuaState paramLuaState, String paramString)
  {
    try
    {
      paramLuaState.pushJavaObject(paramLuaState.getLuaObject(2).createProxy(paramString));
      return 1;
    }
    catch (Exception localException)
    {
      throw new LuaException(localException);
      label29: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label29;
    }
  }

  private static Object a(LuaState paramLuaState, Class paramClass, int paramInt)
  {
    try
    {
      Object localObject3 = paramLuaState.getLuaObject(paramInt).createProxy(paramClass);
      return localObject3;
    }
    catch (Exception localException)
    {
      throw new LuaException(localException);
      label28: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label28;
    }
  }

  private static Object a(LuaState paramLuaState, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
      return null;
    int i = 1;
    if (paramInt1 != i)
      switch (paramInt1)
      {
      default:
        throw new LuaException("Invalid Parameters.");
      case 7:
        if (paramLuaState.isObject(paramInt2))
        {
          Object localObject2 = paramLuaState.getObjectFromUserdata(paramInt2);
          if (localObject2 == null)
            return null;
          boolean bool4 = paramClass.isPrimitive();
          localObject1 = null;
          if (bool4)
          {
            localObject2.getClass();
            if (((paramClass != Byte.TYPE) || (!(localObject2 instanceof Byte))) && ((paramClass != Short.TYPE) || (!(localObject2 instanceof Short))) && ((paramClass != Integer.TYPE) || (!(localObject2 instanceof Integer))) && ((paramClass != Long.TYPE) || (!(localObject2 instanceof Long))) && ((paramClass != Float.TYPE) || (!(localObject2 instanceof Float))) && ((paramClass != Double.TYPE) || (!(localObject2 instanceof Double))))
            {
              Class localClass = Character.TYPE;
              localObject1 = null;
              if (paramClass == localClass)
              {
                boolean bool5 = localObject2 instanceof Character;
                localObject1 = null;
                if (!bool5);
              }
            }
            else
            {
              localObject1 = localObject2;
            }
          }
          if (localObject1 != null)
            break label571;
          if (paramClass.isAssignableFrom(localObject2.getClass()))
          {
            localObject1 = localObject2;
            break label571;
          }
        }
        else if (!paramClass.isAssignableFrom(LuaObject.class))
        {
          localObject1 = null;
        }
        break;
      case 6:
        if (!paramClass.isInterface())
          break;
      case 5:
        while (true)
        {
          localObject1 = a(paramLuaState, paramClass, paramInt2);
          break label571;
          if (!paramClass.isAssignableFrom(LuaFunction.class))
          {
            localObject1 = null;
            break;
            if (!paramClass.isAssignableFrom(LuaTable.class));
          }
          else
          {
            localObject1 = paramLuaState.getLuaObject(paramInt2);
            break label571;
          }
          if (paramClass.isArray())
          {
            localObject1 = b(paramLuaState, paramClass.getComponentType(), paramInt2);
            break label571;
          }
          if (List.class.isAssignableFrom(paramClass))
          {
            localObject1 = c(paramLuaState, paramClass, paramInt2);
            break label571;
          }
          if (Map.class.isAssignableFrom(paramClass))
          {
            localObject1 = d(paramLuaState, paramClass, paramInt2);
            break label571;
          }
          boolean bool3 = paramClass.isInterface();
          localObject1 = null;
          if (!bool3)
            break;
        }
      case 4:
        boolean bool2 = paramClass.isAssignableFrom(String.class);
        localObject1 = null;
        if (bool2);
        break;
      case 3:
      }
    while (true)
    {
      i = 0;
      break label571;
      localObject1 = paramLuaState.toString(paramInt2);
      break label571;
      if ((!paramClass.isPrimitive()) && (!paramClass.isAssignableFrom(Number.class)))
      {
        localObject1 = null;
      }
      else
      {
        if (paramLuaState.isInteger(paramInt2))
        {
          localObject1 = LuaState.convertLuaNumber(Long.valueOf(paramLuaState.toInteger(paramInt2)), paramClass);
          break label571;
        }
        boolean bool1 = paramLuaState.isNumber(paramInt2);
        localObject1 = null;
        if (!bool1)
          break label571;
        localObject1 = LuaState.convertLuaNumber(Double.valueOf(paramLuaState.toNumber(paramInt2)), paramClass);
        break label571;
        if ((!paramClass.isPrimitive()) || (paramClass == Boolean.TYPE) || (paramClass.isAssignableFrom(Boolean.class)))
          break;
        localObject1 = null;
      }
    }
    Object localObject1 = Boolean.valueOf(paramLuaState.toBoolean(paramInt2));
    label571: if ((i != 0) && (localObject1 != null))
      return localObject1;
    throw new LuaException("Invalid Parameter.");
  }

  private static String a(LuaState paramLuaState, int paramInt)
  {
    if (paramLuaState.isObject(paramInt))
      return paramLuaState.getObjectFromUserdata(paramInt).getClass().getName();
    switch (paramLuaState.type(paramInt))
    {
    default:
      return "unkown";
    case 8:
      return "thread";
    case 6:
      return "function";
    case 5:
      return "table";
    case 4:
      return "string";
    case 3:
      return "number";
    case 2:
    case 7:
      return "userdata";
    case 1:
    }
    return "boolean";
  }

  private static String a(LuaState paramLuaState, String paramString, int paramInt, Class paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bad argument to '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' (");
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append(" expected, got ");
    localStringBuilder.append(a(paramLuaState, paramInt));
    localStringBuilder.append(" value)");
    throw new LuaException(localStringBuilder.toString());
  }

  private static String a(LuaState paramLuaState, String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bad argument #");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" to '");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("' (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" expected, got ");
    localStringBuilder.append(a(paramLuaState, paramInt + 1));
    localStringBuilder.append(" value)");
    throw new LuaException(localStringBuilder.toString());
  }

  public static int asTable(long paramLong, Object paramObject)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      if ((???.isBoolean(-1)) && (???.toBoolean(-1)))
      {
        ???.pop(1);
        int n = a(???, paramObject);
        return n;
      }
      try
      {
        ???.newTable();
        if (paramObject.getClass().isArray())
        {
          int k = Array.getLength(paramObject);
          int m = 0;
          while (m <= k - 1)
          {
            ???.pushObjectValue(Array.get(paramObject, m));
            m++;
            ???.rawSetI(-2, m);
          }
        }
        if ((paramObject instanceof Collection))
        {
          Iterator localIterator2 = ((Collection)paramObject).iterator();
          int j;
          for (int i = 1; localIterator2.hasNext(); i = j)
          {
            ???.pushObjectValue(localIterator2.next());
            j = i + 1;
            ???.rawSetI(-2, i);
          }
        }
        if ((paramObject instanceof Map))
        {
          Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            ???.pushObjectValue(localEntry.getKey());
            ???.pushObjectValue(localEntry.getValue());
            ???.setTable(-3);
          }
        }
        ???.pushValue(-1);
        return 1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not astable: ");
        localStringBuilder.append(localException.getMessage());
        throw new LuaException(localStringBuilder.toString());
      }
    }
  }

  // ERROR //
  private static int b(LuaState paramLuaState, Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 242	com/luajava/LuaState:getTop	()I
    //   6: istore_3
    //   7: iconst_0
    //   8: istore 4
    //   10: iload_3
    //   11: iconst_1
    //   12: if_icmpne +65 -> 77
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 62	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   20: invokevirtual 83	com/luajava/LuaState:pushJavaObject	(Ljava/lang/Object;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: aload_1
    //   28: iconst_1
    //   29: anewarray 58	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 452
    //   37: aastore
    //   38: invokevirtual 456	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   41: astore 32
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: astore 33
    //   49: aload 33
    //   51: iconst_0
    //   52: aload_0
    //   53: invokevirtual 460	com/luajava/LuaState:getContext	()Lcom/androlua/LuaContext;
    //   56: invokeinterface 465 1 0
    //   61: aastore
    //   62: aload_0
    //   63: aload 32
    //   65: aload 33
    //   67: invokevirtual 470	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   70: invokevirtual 83	com/luajava/LuaState:pushJavaObject	(Ljava/lang/Object;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iconst_1
    //   76: ireturn
    //   77: iload_3
    //   78: iconst_1
    //   79: isub
    //   80: istore 5
    //   82: iload 5
    //   84: anewarray 4	java/lang/Object
    //   87: astore 6
    //   89: aload_1
    //   90: invokevirtual 474	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   93: astore 7
    //   95: new 159	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   102: astore 8
    //   104: aload 7
    //   106: arraylength
    //   107: istore 9
    //   109: iconst_0
    //   110: istore 10
    //   112: iload 10
    //   114: iload 9
    //   116: if_icmpge +160 -> 276
    //   119: aload 7
    //   121: iload 10
    //   123: aaload
    //   124: astore 11
    //   126: aload 11
    //   128: invokevirtual 475	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   131: astore 12
    //   133: aload 12
    //   135: arraylength
    //   136: iload 5
    //   138: if_icmpeq +276 -> 414
    //   141: goto +279 -> 420
    //   144: aload 12
    //   146: arraylength
    //   147: istore 14
    //   149: iload 13
    //   151: iload 14
    //   153: if_icmpge +33 -> 186
    //   156: aload 6
    //   158: iload 13
    //   160: aload_0
    //   161: aload 12
    //   163: iload 13
    //   165: aaload
    //   166: iload 13
    //   168: iconst_2
    //   169: iadd
    //   170: invokestatic 245	com/luajava/LuaJavaAPI:e	(Lcom/luajava/LuaState;Ljava/lang/Class;I)Ljava/lang/Object;
    //   173: aastore
    //   174: iinc 13 1
    //   177: goto -33 -> 144
    //   180: iconst_0
    //   181: istore 15
    //   183: goto +6 -> 189
    //   186: iconst_1
    //   187: istore 15
    //   189: iload 15
    //   191: ifeq +229 -> 420
    //   194: aload 11
    //   196: aload 6
    //   198: invokevirtual 470	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   201: astore 22
    //   203: aload_0
    //   204: aload 22
    //   206: invokevirtual 83	com/luajava/LuaState:pushJavaObject	(Ljava/lang/Object;)V
    //   209: aload_0
    //   210: monitorexit
    //   211: iconst_1
    //   212: ireturn
    //   213: astore 16
    //   215: aload 8
    //   217: ldc_w 477
    //   220: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 8
    //   226: aload 11
    //   228: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 8
    //   234: ldc_w 482
    //   237: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 16
    //   243: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   246: ifnull +10 -> 256
    //   249: aload 16
    //   251: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   254: astore 16
    //   256: aload 8
    //   258: aload 16
    //   260: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 8
    //   266: ldc_w 488
    //   269: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: goto +147 -> 420
    //   276: aload 8
    //   278: invokevirtual 491	java/lang/StringBuilder:length	()I
    //   281: ifle +45 -> 326
    //   284: new 159	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   291: astore 23
    //   293: aload 23
    //   295: ldc_w 493
    //   298: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 23
    //   304: aload 8
    //   306: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: new 172	com/luajava/LuaException
    //   316: dup
    //   317: aload 23
    //   319: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   325: athrow
    //   326: aload 7
    //   328: arraylength
    //   329: istore 26
    //   331: iload 4
    //   333: iload 26
    //   335: if_icmpge +32 -> 367
    //   338: aload 8
    //   340: aload 7
    //   342: iload 4
    //   344: aaload
    //   345: invokevirtual 494	java/lang/reflect/Constructor:toString	()Ljava/lang/String;
    //   348: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 8
    //   354: ldc_w 488
    //   357: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: iinc 4 1
    //   364: goto -33 -> 331
    //   367: new 159	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   374: astore 29
    //   376: aload 29
    //   378: ldc_w 496
    //   381: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 29
    //   387: aload 8
    //   389: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: new 172	com/luajava/LuaException
    //   399: dup
    //   400: aload 29
    //   402: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   408: athrow
    //   409: astore_2
    //   410: aload_0
    //   411: monitorexit
    //   412: aload_2
    //   413: athrow
    //   414: iconst_0
    //   415: istore 13
    //   417: goto -273 -> 144
    //   420: iinc 10 1
    //   423: goto -311 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   15	23	27	java/lang/Exception
    //   27	73	77	java/lang/Exception
    //   156	174	180	java/lang/Exception
    //   194	203	213	java/lang/Exception
    //   2	7	409	finally
    //   15	23	409	finally
    //   23	25	409	finally
    //   27	73	409	finally
    //   73	75	409	finally
    //   82	109	409	finally
    //   119	141	409	finally
    //   144	149	409	finally
    //   156	174	409	finally
    //   194	203	409	finally
    //   203	211	409	finally
    //   215	256	409	finally
    //   256	273	409	finally
    //   276	326	409	finally
    //   326	331	409	finally
    //   338	361	409	finally
    //   367	409	409	finally
    //   410	412	409	finally
  }

  private static int b(LuaState paramLuaState, Object paramObject, String paramString, boolean paramBoolean)
  {
    String str1 = paramString;
    while (true)
    {
      Method localMethod3;
      Method localMethod2;
      try
      {
        char c1 = str1.charAt(0);
        if (Character.isLowerCase(c1))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(Character.toUpperCase(c1));
          localStringBuilder1.append(str1.substring(1));
          str1 = localStringBuilder1.toString();
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("set");
        localStringBuilder2.append(str1);
        String str2 = localStringBuilder2.toString();
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(paramObject.getClass().getName());
        localStringBuilder3.append("@->");
        localStringBuilder3.append(str2);
        String str3 = localStringBuilder3.toString();
        Object[] arrayOfObject = new Object[1];
        int i = paramLuaState.type(-1);
        if (i != 1);
        switch (i)
        {
        case 4:
          localMethod3 = (Method)b.get(str3);
          if (localMethod3 == null)
            break;
          arrayOfObject[0] = paramLuaState.toString(-1);
          break;
        case 3:
          if (paramLuaState.isInteger(-1))
          {
            localObject2 = (Method)c.get(str3);
            if (localObject2 == null)
              break label839;
            arrayOfObject[0] = LuaState.convertLuaNumber(Long.valueOf(paramLuaState.toInteger(-1)), localObject2.getParameterTypes()[0]);
            break label839;
          }
          localMethod2 = (Method)d.get(str3);
          if (localMethod2 == null)
            break label846;
          arrayOfObject[0] = LuaState.convertLuaNumber(Double.valueOf(paramLuaState.toNumber(-1)), localMethod2.getParameterTypes()[0]);
          break label846;
          localObject2 = (Method)e.get(str3);
          if (localObject2 != null)
            arrayOfObject[0] = Boolean.valueOf(paramLuaState.toBoolean(-1));
          j = 1;
          if (localObject2 != null)
            try
            {
              ((Method)localObject2).invoke(paramObject, arrayOfObject);
              return 1;
            }
            catch (Exception localException2)
            {
              throw new LuaException(localException2);
            }
          ArrayList localArrayList = getMethod(paramObject.getClass(), str2, paramBoolean);
          StringBuilder localStringBuilder4 = new StringBuilder();
          Iterator localIterator = localArrayList.iterator();
          if (localIterator.hasNext())
          {
            Method localMethod1 = (Method)localIterator.next();
            if ((paramBoolean) && (!Modifier.isStatic(localMethod1.getModifiers())))
              continue;
            Class[] arrayOfClass = localMethod1.getParameterTypes();
            int i1 = arrayOfClass.length;
            if (i1 != 1)
              continue;
            try
            {
              Object localObject3 = e(paramLuaState, arrayOfClass[0], paramLuaState.getTop());
              HashMap localHashMap;
              if (j != 1)
              {
                if (j != 9)
                {
                  switch (j)
                  {
                  default:
                    break;
                  case 4:
                    localHashMap = b;
                    localHashMap.put(str3, localMethod1);
                    break;
                  case 3:
                    localHashMap = d;
                    break;
                  }
                }
                else
                {
                  localHashMap = c;
                  continue;
                }
              }
              else
              {
                localHashMap = e;
                continue;
              }
              try
              {
                localMethod1.invoke(paramObject, new Object[] { localObject3 });
                return 1;
              }
              catch (Exception localException1)
              {
                throw new LuaException(localException1);
              }
            }
            catch (LuaException localLuaException)
            {
              localStringBuilder4.append("-> ");
              localStringBuilder4.append(arrayOfClass[0]);
              localStringBuilder4.append("\n");
              tmpTernaryOp = localLuaException;
            }
            continue;
          }
          int k = paramLuaState.getTop();
          if (paramLuaState.type(k) == 5)
          {
            paramLuaState.getField(1, str2);
            LuaFunction localLuaFunction = paramLuaState.getFunction(-1);
            if ((paramLuaState.type(-1) == 6) && (localLuaFunction != null))
            {
              int m = paramLuaState.rawLen(k);
              int n = 0;
              if (n < m)
              {
                n++;
                paramLuaState.getI(k, n);
                continue;
              }
              if (paramLuaState.pcall(m, 0, 0) == 0)
                return 1;
              throw new LuaException(paramLuaState.toString(-1));
            }
          }
          if (localStringBuilder4.length() > 0)
          {
            StringBuilder localStringBuilder5 = new StringBuilder();
            localStringBuilder5.append("Invalid setter ");
            localStringBuilder5.append(str1);
            localStringBuilder5.append(". Invalid Parameters.\n");
            localStringBuilder5.append(localStringBuilder4.toString());
            localStringBuilder5.append(paramLuaState.toJavaObject(-1).getClass());
            throw new LuaException(localStringBuilder5.toString());
          }
          return 0;
        }
      }
      finally
      {
      }
      int j = -1;
      Object localObject2 = null;
      continue;
      localObject2 = localMethod3;
      j = 4;
      continue;
      label839: j = 9;
      continue;
      label846: localObject2 = localMethod2;
      j = 3;
    }
  }

  private static Object b(LuaState paramLuaState, Class<?> paramClass, int paramInt)
  {
    try
    {
      int i = paramLuaState.objLen(paramInt);
      Object localObject3 = Array.newInstance(paramClass, i);
      if (paramClass == String.class)
        for (int i5 = 1; i5 <= i; i5++)
        {
          paramLuaState.pushNumber(i5);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, i5 - 1, paramLuaState.toString(-1));
          paramLuaState.pop(1);
        }
      if (paramClass == Double.TYPE)
        for (int j = 1; j <= i; j++)
        {
          paramLuaState.pushNumber(j);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, j - 1, Double.valueOf(paramLuaState.toNumber(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Float.TYPE)
        for (int k = 1; k <= i; k++)
        {
          paramLuaState.pushNumber(k);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, k - 1, Float.valueOf((float)paramLuaState.toNumber(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Long.TYPE)
        for (int m = 1; m <= i; m++)
        {
          paramLuaState.pushNumber(m);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, m - 1, Long.valueOf(paramLuaState.toInteger(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Integer.TYPE)
        for (int n = 1; n <= i; n++)
        {
          paramLuaState.pushNumber(n);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, n - 1, Integer.valueOf((int)paramLuaState.toInteger(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Short.TYPE)
        for (int i1 = 1; i1 <= i; i1++)
        {
          paramLuaState.pushNumber(i1);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, i1 - 1, Short.valueOf((short)(int)paramLuaState.toInteger(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Character.TYPE)
        for (int i2 = 1; i2 <= i; i2++)
        {
          paramLuaState.pushNumber(i2);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, i2 - 1, Character.valueOf((char)(int)paramLuaState.toInteger(-1)));
          paramLuaState.pop(1);
        }
      if (paramClass == Byte.TYPE)
      {
        int i3 = 1;
        while (i3 <= i)
        {
          paramLuaState.pushNumber(i3);
          paramLuaState.getTable(paramInt);
          Array.set(localObject3, i3 - 1, Byte.valueOf((byte)(int)paramLuaState.toInteger(-1)));
          paramLuaState.pop(1);
          i3++;
          continue;
          while (i4 <= i)
          {
            paramLuaState.pushNumber(i4);
            paramLuaState.getTable(paramInt);
            Array.set(localObject3, i4 - 1, e(paramLuaState, paramClass, paramLuaState.getTop()));
            paramLuaState.pop(1);
            i4++;
          }
        }
        return localObject3;
      }
    }
    catch (Exception localException)
    {
      throw new LuaException(localException);
      label549: Object localObject1;
      throw localObject1;
      int i4 = 1;
    }
    finally
    {
      break label549;
    }
  }

  private static int c(LuaState paramLuaState, Class paramClass)
  {
    try
    {
      paramLuaState.pushJavaObject(a(paramLuaState, paramClass, 2));
      return 1;
    }
    finally
    {
    }
  }

  private static Object c(LuaState paramLuaState, Class<List<Object>> paramClass, int paramInt)
  {
    while (true)
    {
      try
      {
        int i = paramLuaState.objLen(paramInt);
        try
        {
          Object localObject2;
          if (paramClass.equals(List.class))
          {
            localObject2 = new ArrayList();
          }
          else
          {
            localObject2 = (List)paramClass.newInstance();
            break label109;
            if (j <= i)
            {
              paramLuaState.pushNumber(j);
              paramLuaState.getTable(paramInt);
              ((List)localObject2).add(paramLuaState.toJavaObject(-1));
              paramLuaState.pop(1);
              j++;
              continue;
            }
            return localObject2;
          }
        }
        catch (Exception localException)
        {
          throw new LuaException(localException);
        }
      }
      finally
      {
      }
      label109: int j = 1;
    }
  }

  // ERROR //
  public static int callMethod(long paramLong, Object paramObject, String paramString)
  {
    // Byte code:
    //   0: lload_0
    //   1: invokestatic 447	com/luajava/LuaStateFactory:getExistingState	(J)Lcom/luajava/LuaState;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: new 159	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   16: astore 5
    //   18: aload 4
    //   20: invokevirtual 242	com/luajava/LuaState:getTop	()I
    //   23: istore 7
    //   25: iconst_m1
    //   26: istore 8
    //   28: aconst_null
    //   29: astore 9
    //   31: iload 7
    //   33: ifne +174 -> 207
    //   36: getstatic 40	com/luajava/LuaJavaAPI:f	Ljava/util/HashMap;
    //   39: aload_3
    //   40: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 269	java/lang/reflect/Method
    //   46: astore 9
    //   48: aload 9
    //   50: ifnull +1155 -> 1205
    //   53: aload 9
    //   55: aload_2
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore 77
    //   65: aload 77
    //   67: ifnonnull +22 -> 89
    //   70: aload 9
    //   72: invokevirtual 578	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   75: getstatic 581	java/lang/Void:TYPE	Ljava/lang/Class;
    //   78: invokevirtual 569	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +8 -> 89
    //   84: aload 4
    //   86: monitorexit
    //   87: iconst_0
    //   88: ireturn
    //   89: aload 4
    //   91: aload 77
    //   93: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   96: aload 4
    //   98: monitorexit
    //   99: iconst_1
    //   100: ireturn
    //   101: astore 67
    //   103: aload 67
    //   105: astore 68
    //   107: aload 5
    //   109: ldc_w 477
    //   112: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: aload 9
    //   120: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 5
    //   126: ldc_w 482
    //   129: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 68
    //   135: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   138: ifnull +10 -> 148
    //   141: aload 68
    //   143: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   146: astore 68
    //   148: aload 5
    //   150: aload 68
    //   152: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: ldc_w 488
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new 159	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   172: astore 74
    //   174: aload 74
    //   176: ldc_w 583
    //   179: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 74
    //   185: aload 5
    //   187: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: new 172	com/luajava/LuaException
    //   197: dup
    //   198: aload 74
    //   200: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   206: athrow
    //   207: iload 7
    //   209: anewarray 4	java/lang/Object
    //   212: astore 10
    //   214: iload 7
    //   216: iconst_1
    //   217: if_icmpne +1009 -> 1226
    //   220: aload 4
    //   222: iconst_1
    //   223: invokevirtual 405	com/luajava/LuaState:type	(I)I
    //   226: istore 11
    //   228: iload 11
    //   230: iconst_1
    //   231: if_icmpeq +164 -> 395
    //   234: iload 11
    //   236: tableswitch	default:+975 -> 1211, 3:+57->293, 4:+24->260
    //   261: istore 14
    //   263: getstatic 32	com/luajava/LuaJavaAPI:b	Ljava/util/HashMap;
    //   266: aload_3
    //   267: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast 269	java/lang/reflect/Method
    //   273: astore 13
    //   275: aload 13
    //   277: ifnull +155 -> 432
    //   280: aload 10
    //   282: iconst_0
    //   283: aload 4
    //   285: iconst_1
    //   286: invokevirtual 356	com/luajava/LuaState:toString	(I)Ljava/lang/String;
    //   289: aastore
    //   290: goto +142 -> 432
    //   293: aload 4
    //   295: iconst_1
    //   296: invokevirtual 361	com/luajava/LuaState:isInteger	(I)Z
    //   299: ifeq +50 -> 349
    //   302: bipush 9
    //   304: istore 14
    //   306: getstatic 34	com/luajava/LuaJavaAPI:c	Ljava/util/HashMap;
    //   309: aload_3
    //   310: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   313: checkcast 269	java/lang/reflect/Method
    //   316: astore 13
    //   318: aload 13
    //   320: ifnull +112 -> 432
    //   323: aload 10
    //   325: iconst_0
    //   326: aload 4
    //   328: iconst_1
    //   329: invokevirtual 365	com/luajava/LuaState:toInteger	(I)J
    //   332: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: aload 13
    //   337: invokevirtual 274	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   340: iconst_0
    //   341: aaload
    //   342: invokestatic 373	com/luajava/LuaState:convertLuaNumber	(Ljava/lang/Long;Ljava/lang/Class;)Ljava/lang/Number;
    //   345: aastore
    //   346: goto +86 -> 432
    //   349: iconst_3
    //   350: istore 14
    //   352: getstatic 36	com/luajava/LuaJavaAPI:d	Ljava/util/HashMap;
    //   355: aload_3
    //   356: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   359: checkcast 269	java/lang/reflect/Method
    //   362: astore 13
    //   364: aload 13
    //   366: ifnull +66 -> 432
    //   369: aload 10
    //   371: iconst_0
    //   372: aload 4
    //   374: iconst_1
    //   375: invokevirtual 380	com/luajava/LuaState:toNumber	(I)D
    //   378: invokestatic 383	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   381: aload 13
    //   383: invokevirtual 274	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   386: iconst_0
    //   387: aaload
    //   388: invokestatic 386	com/luajava/LuaState:convertLuaNumber	(Ljava/lang/Double;Ljava/lang/Class;)Ljava/lang/Number;
    //   391: aastore
    //   392: goto +40 -> 432
    //   395: getstatic 38	com/luajava/LuaJavaAPI:e	Ljava/util/HashMap;
    //   398: aload_3
    //   399: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   402: checkcast 269	java/lang/reflect/Method
    //   405: astore 12
    //   407: aload 12
    //   409: ifnull +16 -> 425
    //   412: aload 10
    //   414: iconst_0
    //   415: aload 4
    //   417: iconst_1
    //   418: invokevirtual 392	com/luajava/LuaState:toBoolean	(I)Z
    //   421: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   424: aastore
    //   425: aload 12
    //   427: astore 13
    //   429: iconst_1
    //   430: istore 14
    //   432: aload 13
    //   434: ifnull +172 -> 606
    //   437: aload 13
    //   439: invokevirtual 270	java/lang/reflect/Method:getModifiers	()I
    //   442: invokestatic 235	java/lang/reflect/Modifier:isPublic	(I)Z
    //   445: ifne +9 -> 454
    //   448: aload 13
    //   450: iconst_1
    //   451: invokevirtual 584	java/lang/reflect/Method:setAccessible	(Z)V
    //   454: aload 13
    //   456: aload_2
    //   457: aload 10
    //   459: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   462: astore 65
    //   464: aload 65
    //   466: ifnonnull +22 -> 488
    //   469: aload 13
    //   471: invokevirtual 578	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   474: getstatic 581	java/lang/Void:TYPE	Ljava/lang/Class;
    //   477: invokevirtual 569	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   480: ifeq +8 -> 488
    //   483: aload 4
    //   485: monitorexit
    //   486: iconst_0
    //   487: ireturn
    //   488: aload 4
    //   490: aload 65
    //   492: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   495: aload 4
    //   497: monitorexit
    //   498: iconst_1
    //   499: ireturn
    //   500: astore 55
    //   502: aload 55
    //   504: astore 56
    //   506: aload 5
    //   508: ldc_w 477
    //   511: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 5
    //   517: aload 13
    //   519: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 5
    //   525: ldc_w 482
    //   528: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 56
    //   534: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   537: ifnull +10 -> 547
    //   540: aload 56
    //   542: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   545: astore 56
    //   547: aload 5
    //   549: aload 56
    //   551: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 5
    //   557: ldc_w 488
    //   560: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: new 159	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   571: astore 62
    //   573: aload 62
    //   575: ldc_w 583
    //   578: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 62
    //   584: aload 5
    //   586: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: new 172	com/luajava/LuaException
    //   596: dup
    //   597: aload 62
    //   599: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   605: athrow
    //   606: getstatic 30	com/luajava/LuaJavaAPI:methodCache	Ljava/util/HashMap;
    //   609: aload_3
    //   610: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   613: checkcast 586	[Ljava/lang/reflect/Method;
    //   616: astore 15
    //   618: iload 7
    //   620: newarray int
    //   622: astore 16
    //   624: iconst_0
    //   625: istore 17
    //   627: iload 17
    //   629: iload 7
    //   631: if_icmpge +28 -> 659
    //   634: iload 17
    //   636: iconst_1
    //   637: iadd
    //   638: istore 54
    //   640: aload 16
    //   642: iload 17
    //   644: aload 4
    //   646: iload 54
    //   648: invokevirtual 405	com/luajava/LuaState:type	(I)I
    //   651: iastore
    //   652: iload 54
    //   654: istore 17
    //   656: goto -29 -> 627
    //   659: aload 15
    //   661: arraylength
    //   662: istore 18
    //   664: iconst_0
    //   665: istore 19
    //   667: iload 19
    //   669: iload 18
    //   671: if_icmpge +390 -> 1061
    //   674: aload 15
    //   676: iload 19
    //   678: aaload
    //   679: astore 20
    //   681: aload 20
    //   683: invokevirtual 274	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   686: astore 21
    //   688: aload 21
    //   690: arraylength
    //   691: iload 7
    //   693: if_icmpeq +543 -> 1236
    //   696: iload 7
    //   698: istore 22
    //   700: aload 16
    //   702: astore 23
    //   704: goto +529 -> 1233
    //   707: aload 21
    //   709: arraylength
    //   710: istore 25
    //   712: iload 24
    //   714: iload 25
    //   716: if_icmpge +84 -> 800
    //   719: aload 21
    //   721: iload 24
    //   723: aaload
    //   724: astore 39
    //   726: iload 7
    //   728: istore 22
    //   730: aload 16
    //   732: iload 24
    //   734: iaload
    //   735: istore 41
    //   737: aload 16
    //   739: astore 23
    //   741: iload 24
    //   743: iconst_1
    //   744: iadd
    //   745: istore 42
    //   747: aload 10
    //   749: iload 24
    //   751: aload 4
    //   753: aload 39
    //   755: iload 41
    //   757: iload 42
    //   759: invokestatic 588	com/luajava/LuaJavaAPI:a	(Lcom/luajava/LuaState;Ljava/lang/Class;II)Ljava/lang/Object;
    //   762: aastore
    //   763: iload 42
    //   765: istore 24
    //   767: iload 22
    //   769: istore 7
    //   771: aload 23
    //   773: astore 16
    //   775: goto -68 -> 707
    //   778: iload 7
    //   780: istore 22
    //   782: goto +4 -> 786
    //   785: pop
    //   786: aload 16
    //   788: astore 23
    //   790: goto +4 -> 794
    //   793: pop
    //   794: iconst_0
    //   795: istore 26
    //   797: goto +14 -> 811
    //   800: iload 7
    //   802: istore 22
    //   804: aload 16
    //   806: astore 23
    //   808: iconst_1
    //   809: istore 26
    //   811: iload 26
    //   813: ifeq +420 -> 1233
    //   816: aload 20
    //   818: invokevirtual 270	java/lang/reflect/Method:getModifiers	()I
    //   821: invokestatic 235	java/lang/reflect/Modifier:isPublic	(I)Z
    //   824: istore 34
    //   826: iload 34
    //   828: ifne +21 -> 849
    //   831: aload 20
    //   833: iconst_1
    //   834: invokevirtual 584	java/lang/reflect/Method:setAccessible	(Z)V
    //   837: goto +12 -> 849
    //   840: astore 38
    //   842: aload 38
    //   844: astore 28
    //   846: goto +154 -> 1000
    //   849: aload 20
    //   851: aload_2
    //   852: aload 10
    //   854: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   857: astore 35
    //   859: iload 14
    //   861: lookupswitch	default:+51->912, 0:+95->956, 1:+87->948, 3:+79->940, 4:+71->932, 9:+54->915
    //   913: nop
    //   914: caload
    //   915: getstatic 34	com/luajava/LuaJavaAPI:c	Ljava/util/HashMap;
    //   918: astore 36
    //   920: aload 36
    //   922: aload_3
    //   923: aload 20
    //   925: invokevirtual 506	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   928: pop
    //   929: goto +35 -> 964
    //   932: getstatic 32	com/luajava/LuaJavaAPI:b	Ljava/util/HashMap;
    //   935: astore 36
    //   937: goto -17 -> 920
    //   940: getstatic 36	com/luajava/LuaJavaAPI:d	Ljava/util/HashMap;
    //   943: astore 36
    //   945: goto -25 -> 920
    //   948: getstatic 38	com/luajava/LuaJavaAPI:e	Ljava/util/HashMap;
    //   951: astore 36
    //   953: goto -33 -> 920
    //   956: getstatic 40	com/luajava/LuaJavaAPI:f	Ljava/util/HashMap;
    //   959: astore 36
    //   961: goto -41 -> 920
    //   964: aload 35
    //   966: ifnonnull +22 -> 988
    //   969: aload 20
    //   971: invokevirtual 578	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   974: getstatic 581	java/lang/Void:TYPE	Ljava/lang/Class;
    //   977: invokevirtual 569	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   980: ifeq +8 -> 988
    //   983: aload 4
    //   985: monitorexit
    //   986: iconst_0
    //   987: ireturn
    //   988: aload 4
    //   990: aload 35
    //   992: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   995: aload 4
    //   997: monitorexit
    //   998: iconst_1
    //   999: ireturn
    //   1000: aload 5
    //   1002: ldc_w 477
    //   1005: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: pop
    //   1009: aload 5
    //   1011: aload 20
    //   1013: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 5
    //   1019: ldc_w 482
    //   1022: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 28
    //   1028: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1031: ifnull +10 -> 1041
    //   1034: aload 28
    //   1036: invokevirtual 486	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1039: astore 28
    //   1041: aload 5
    //   1043: aload 28
    //   1045: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 5
    //   1051: ldc_w 488
    //   1054: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: goto +193 -> 1251
    //   1061: iconst_0
    //   1062: istore 44
    //   1064: aload 5
    //   1066: invokevirtual 491	java/lang/StringBuilder:length	()I
    //   1069: ifle +45 -> 1114
    //   1072: new 159	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1079: astore 45
    //   1081: aload 45
    //   1083: ldc_w 583
    //   1086: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload 45
    //   1092: aload 5
    //   1094: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: new 172	com/luajava/LuaException
    //   1104: dup
    //   1105: aload 45
    //   1107: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   1113: athrow
    //   1114: aload 15
    //   1116: arraylength
    //   1117: istore 48
    //   1119: iload 44
    //   1121: iload 48
    //   1123: if_icmpge +32 -> 1155
    //   1126: aload 5
    //   1128: aload 15
    //   1130: iload 44
    //   1132: aaload
    //   1133: invokevirtual 589	java/lang/reflect/Method:toString	()Ljava/lang/String;
    //   1136: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: aload 5
    //   1142: ldc_w 488
    //   1145: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: iinc 44 1
    //   1152: goto -33 -> 1119
    //   1155: new 159	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1162: astore 51
    //   1164: aload 51
    //   1166: ldc_w 591
    //   1169: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: aload 51
    //   1175: aload 5
    //   1177: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: new 172	com/luajava/LuaException
    //   1187: dup
    //   1188: aload 51
    //   1190: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokespecial 178	com/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   1196: athrow
    //   1197: astore 6
    //   1199: aload 4
    //   1201: monitorexit
    //   1202: aload 6
    //   1204: athrow
    //   1205: iconst_0
    //   1206: istore 8
    //   1208: goto -1001 -> 207
    //   1211: iload 8
    //   1213: istore 66
    //   1215: aload 9
    //   1217: astore 13
    //   1219: iload 66
    //   1221: istore 14
    //   1223: goto -791 -> 432
    //   1226: iload 8
    //   1228: istore 14
    //   1230: goto -624 -> 606
    //   1233: goto +18 -> 1251
    //   1236: iconst_0
    //   1237: istore 24
    //   1239: goto -532 -> 707
    //   1242: astore 27
    //   1244: aload 27
    //   1246: astore 28
    //   1248: goto -248 -> 1000
    //   1251: iinc 19 1
    //   1254: iload 22
    //   1256: istore 7
    //   1258: aload 23
    //   1260: astore 16
    //   1262: goto -595 -> 667
    //
    // Exception table:
    //   from	to	target	type
    //   53	65	101	java/lang/Exception
    //   437	454	500	java/lang/Exception
    //   454	464	500	java/lang/Exception
    //   719	726	778	java/lang/Exception
    //   730	737	785	java/lang/Exception
    //   747	763	793	java/lang/Exception
    //   831	837	840	java/lang/Exception
    //   9	25	1197	finally
    //   36	48	1197	finally
    //   53	65	1197	finally
    //   70	87	1197	finally
    //   89	99	1197	finally
    //   107	148	1197	finally
    //   148	207	1197	finally
    //   207	214	1197	finally
    //   220	228	1197	finally
    //   263	275	1197	finally
    //   280	290	1197	finally
    //   293	302	1197	finally
    //   306	318	1197	finally
    //   323	346	1197	finally
    //   352	364	1197	finally
    //   369	392	1197	finally
    //   395	407	1197	finally
    //   412	425	1197	finally
    //   437	454	1197	finally
    //   454	464	1197	finally
    //   469	486	1197	finally
    //   488	498	1197	finally
    //   506	547	1197	finally
    //   547	606	1197	finally
    //   606	624	1197	finally
    //   640	652	1197	finally
    //   659	664	1197	finally
    //   674	696	1197	finally
    //   707	712	1197	finally
    //   719	726	1197	finally
    //   730	737	1197	finally
    //   747	763	1197	finally
    //   816	826	1197	finally
    //   831	837	1197	finally
    //   849	859	1197	finally
    //   915	920	1197	finally
    //   920	929	1197	finally
    //   932	937	1197	finally
    //   940	945	1197	finally
    //   948	953	1197	finally
    //   956	961	1197	finally
    //   969	986	1197	finally
    //   988	998	1197	finally
    //   1000	1041	1197	finally
    //   1041	1058	1197	finally
    //   1064	1114	1197	finally
    //   1114	1119	1197	finally
    //   1126	1149	1197	finally
    //   1155	1197	1197	finally
    //   1199	1202	1197	finally
    //   816	826	1242	java/lang/Exception
    //   849	859	1242	java/lang/Exception
  }

  public static int checkClass(LuaState paramLuaState, Object paramObject, String paramString)
  {
    while (true)
    {
      int j;
      try
      {
        if ((paramObject instanceof Class))
        {
          Class[] arrayOfClass = ((Class)paramObject).getClasses();
          int i = arrayOfClass.length;
          j = 0;
          if (j < i)
          {
            Class localClass = arrayOfClass[j];
            if (localClass.getSimpleName().equals(paramString))
            {
              paramLuaState.pushJavaObject(localClass);
              return 3;
            }
          }
          else
          {
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
      finally
      {
      }
      j++;
    }
  }

  // ERROR //
  public static int checkField(LuaState paramLuaState, Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 58
    //   6: ifeq +15 -> 21
    //   9: aload_1
    //   10: checkcast 58	java/lang/Class
    //   13: astore 4
    //   15: iconst_1
    //   16: istore 5
    //   18: goto +12 -> 30
    //   21: aload_1
    //   22: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: astore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 602	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   36: astore 6
    //   38: aload 6
    //   40: ifnonnull +7 -> 47
    //   43: aload_0
    //   44: monitorexit
    //   45: iconst_0
    //   46: ireturn
    //   47: iload 5
    //   49: ifeq +18 -> 67
    //   52: aload 6
    //   54: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   57: invokestatic 229	java/lang/reflect/Modifier:isStatic	(I)Z
    //   60: ifne +7 -> 67
    //   63: aload_0
    //   64: monitorexit
    //   65: iconst_0
    //   66: ireturn
    //   67: aload 6
    //   69: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   72: invokestatic 235	java/lang/reflect/Modifier:isPublic	(I)Z
    //   75: ifne +9 -> 84
    //   78: aload 6
    //   80: iconst_1
    //   81: invokevirtual 239	java/lang/reflect/Field:setAccessible	(Z)V
    //   84: aload 6
    //   86: aload_1
    //   87: invokevirtual 603	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: astore 8
    //   92: aload_0
    //   93: aload 8
    //   95: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   98: aload 6
    //   100: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   103: invokestatic 606	java/lang/reflect/Modifier:isFinal	(I)Z
    //   106: ifeq +7 -> 113
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_5
    //   112: ireturn
    //   113: aload_0
    //   114: monitorexit
    //   115: iconst_1
    //   116: ireturn
    //   117: astore 7
    //   119: new 172	com/luajava/LuaException
    //   122: dup
    //   123: aload 7
    //   125: invokespecial 252	com/luajava/LuaException:<init>	(Ljava/lang/Exception;)V
    //   128: athrow
    //   129: aload_0
    //   130: monitorexit
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   67	84	117	java/lang/Exception
    //   84	92	117	java/lang/Exception
    //   30	38	129	java/lang/NoSuchFieldException
    //   2	15	133	finally
    //   21	27	133	finally
    //   30	38	133	finally
    //   43	45	133	finally
    //   52	65	133	finally
    //   67	84	133	finally
    //   84	92	133	finally
    //   92	111	133	finally
    //   113	115	133	finally
    //   119	129	133	finally
    //   129	131	133	finally
    //   134	136	133	finally
  }

  public static int checkMethod(LuaState paramLuaState, Object paramObject, String paramString)
  {
    try
    {
      Class localClass;
      boolean bool;
      if ((paramObject instanceof Class))
      {
        localClass = (Class)paramObject;
        bool = true;
      }
      else
      {
        localClass = paramObject.getClass();
        bool = false;
      }
      String str = paramLuaState.toString(-1);
      Method[] arrayOfMethod = (Method[])methodCache.get(str);
      if (arrayOfMethod == null)
      {
        ArrayList localArrayList = getMethod(localClass, paramString, bool);
        arrayOfMethod = new Method[localArrayList.size()];
        localArrayList.toArray(arrayOfMethod);
        methodCache.put(str, arrayOfMethod);
      }
      if (arrayOfMethod.length == 0)
        return 0;
      return 2;
    }
    finally
    {
    }
  }

  public static void clearCaches()
  {
    methodCache.clear();
    methodsMap.clear();
    b.clear();
    c.clear();
    d.clear();
    e.clear();
    f.clear();
  }

  public static int createArray(long paramLong, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      int i = d(???, javaBindClass(paramString));
      return i;
    }
  }

  public static int createProxy(long paramLong, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      int i = a(???, paramString);
      return i;
    }
  }

  private static int d(LuaState paramLuaState, Class<?> paramClass)
  {
    try
    {
      paramLuaState.pushJavaObject(b(paramLuaState, paramClass, 2));
      return 1;
    }
    finally
    {
    }
  }

  private static Object d(LuaState paramLuaState, Class<Map<Object, Object>> paramClass, int paramInt)
  {
    try
    {
      Object localObject3;
      if (paramClass.equals(Map.class))
        localObject3 = new HashMap();
      else
        localObject3 = (Map)paramClass.newInstance();
      paramLuaState.pushNil();
      while (paramLuaState.next(paramInt) != 0)
      {
        ((Map)localObject3).put(paramLuaState.toJavaObject(-2), paramLuaState.toJavaObject(-1));
        paramLuaState.pop(1);
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      throw new LuaException(localException);
      label86: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label86;
    }
  }

  private static int e(LuaState paramLuaState, Class<?> paramClass)
  {
    try
    {
      paramLuaState.pushJavaObject(c(paramLuaState, paramClass, 2));
      return 1;
    }
    finally
    {
    }
  }

  private static Object e(LuaState paramLuaState, Class<?> paramClass, int paramInt)
  {
    return a(paramLuaState, paramClass, paramLuaState.type(paramInt), paramInt);
  }

  private static int f(LuaState paramLuaState, Class<?> paramClass)
  {
    try
    {
      paramLuaState.pushJavaObject(d(paramLuaState, paramClass, 2));
      return 1;
    }
    finally
    {
    }
  }

  private static int f(LuaState paramLuaState, Class paramClass, int paramInt)
  {
    char c1;
    if ((paramClass == Character.TYPE) && (paramLuaState.type(paramInt) == 4))
    {
      String str = paramLuaState.toString(paramInt);
      if (str.length() == 1)
      {
        c1 = str.charAt(0);
      }
      else
      {
        localObject = str.toCharArray();
        break label274;
      }
    }
    else
    {
      if (!paramLuaState.isNumber(paramInt))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLuaState.toString(paramInt));
        localStringBuilder.append(" is not number");
        throw new LuaException(localStringBuilder.toString());
      }
      if (paramClass == Double.TYPE)
      {
        localObject = Double.valueOf(paramLuaState.toNumber(paramInt));
        break label274;
      }
      if (paramClass == Float.TYPE)
      {
        localObject = Float.valueOf((float)paramLuaState.toNumber(paramInt));
        break label274;
      }
      if (paramClass == Long.TYPE)
      {
        localObject = Long.valueOf(paramLuaState.toInteger(paramInt));
        break label274;
      }
      if (paramClass == Integer.TYPE)
      {
        localObject = Integer.valueOf((int)paramLuaState.toInteger(paramInt));
        break label274;
      }
      if (paramClass == Short.TYPE)
      {
        localObject = Short.valueOf((short)(int)paramLuaState.toInteger(paramInt));
        break label274;
      }
      if (paramClass != Character.TYPE)
        break label229;
      c1 = (char)(int)paramLuaState.toInteger(paramInt);
    }
    Object localObject = Character.valueOf(c1);
    break label274;
    label229: if (paramClass == Byte.TYPE)
      localObject = Byte.valueOf((byte)(int)paramLuaState.toInteger(paramInt));
    else if (paramClass == Boolean.TYPE)
      localObject = Boolean.valueOf(paramLuaState.toBoolean(paramInt));
    else
      localObject = null;
    label274: paramLuaState.pushJavaObject(localObject);
    return 1;
  }

  public static int getArrayValue(long paramLong, Object paramObject, int paramInt)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      Object localObject2;
      if (paramObject.getClass().isArray())
      {
        localObject2 = Array.get(paramObject, paramInt);
      }
      else if ((paramObject instanceof List))
      {
        localObject2 = ((List)paramObject).get(paramInt);
      }
      else
      {
        if (!(paramObject instanceof Map))
          break label86;
        localObject2 = ((Map)paramObject).get(Long.valueOf(paramInt));
      }
      ???.pushObjectValue(localObject2);
      return 1;
      label86: StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not get ");
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append(" value in ");
      localStringBuilder.append(paramInt);
      throw new LuaException(localStringBuilder.toString());
    }
  }

  public static int getContext(long paramLong)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      ???.pushJavaObject(???.getContext());
      return 1;
    }
  }

  public static ArrayList<Method> getMethod(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = (HashMap)a.get(paramClass);
    if (localHashMap == null)
    {
      localHashMap = new HashMap();
      a.put(paramClass, localHashMap);
    }
    ArrayList localArrayList1 = (ArrayList)localHashMap.get(paramString);
    if (localArrayList1 == null)
    {
      Method[] arrayOfMethod = (Method[])methodsMap.get(paramClass);
      if (arrayOfMethod == null)
      {
        arrayOfMethod = paramClass.getMethods();
        methodsMap.put(paramClass, arrayOfMethod);
      }
      int i = arrayOfMethod.length;
      for (int j = 0; j < i; j++)
      {
        Method localMethod2 = arrayOfMethod[j];
        String str = localMethod2.getName();
        ArrayList localArrayList3 = (ArrayList)localHashMap.get(str);
        if (localArrayList3 == null)
        {
          localArrayList3 = new ArrayList();
          localHashMap.put(str, localArrayList3);
        }
        localArrayList3.add(localMethod2);
      }
      localArrayList1 = (ArrayList)localHashMap.get(paramString);
    }
    if (localArrayList1 == null)
      localArrayList1 = new ArrayList();
    if (paramBoolean)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        Method localMethod1 = (Method)localIterator.next();
        if (Modifier.isStatic(localMethod1.getModifiers()))
          localArrayList2.add(localMethod1);
      }
      if (localArrayList2.isEmpty())
        localArrayList2 = getMethod(Class.class, paramString, false);
      return localArrayList2;
    }
    return localArrayList1;
  }

  public static Class javaBindClass(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (Exception localException)
    {
      int i = -1;
      switch (paramString.hashCode())
      {
      default:
        break;
      case 109413500:
        if (paramString.equals("short"))
        {
          i = 3;
          tmpTernaryOp = localException;
        }
        break;
      case 97526364:
        if (paramString.equals("float"))
          i = 6;
        break;
      case 64711720:
        if (paramString.equals("boolean"))
          i = 0;
        break;
      case 3327612:
        if (paramString.equals("long"))
          i = 5;
        break;
      case 3052374:
        if (paramString.equals("char"))
          i = 2;
        break;
      case 3039496:
        if (paramString.equals("byte"))
          i = 1;
        break;
      case 104431:
        if (paramString.equals("int"))
          i = 4;
        break;
      case -1325958191:
        if (paramString.equals("double"))
          i = 7;
        break;
      }
      switch (i)
      {
      default:
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Class not found: ");
        localStringBuilder.append(paramString);
        throw new LuaException(localStringBuilder.toString());
      case 7:
      case 6:
      case 5:
      case 4:
      case 3:
      case 2:
      case 1:
      case 0:
      }
    }
    return Double.TYPE;
    return Float.TYPE;
    return Long.TYPE;
    return Integer.TYPE;
    return Short.TYPE;
    return Character.TYPE;
    return Byte.TYPE;
    return Boolean.TYPE;
  }

  public static int javaCreate(long paramLong, Class<?> paramClass)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      if ((!paramClass.isPrimitive()) && (paramClass != String.class))
      {
        if (paramClass.isArray())
        {
          int i3 = d(???, paramClass);
          return i3;
        }
        if (List.class.isAssignableFrom(paramClass))
        {
          int i2 = e(???, paramClass);
          return i2;
        }
        if (Map.class.isAssignableFrom(paramClass))
        {
          int i1 = f(???, paramClass);
          return i1;
        }
        if (paramClass.isInterface())
        {
          int n = c(???, paramClass);
          return n;
        }
        if ((0x400 & paramClass.getModifiers()) != 0)
        {
          int m = a(???, paramClass);
          return m;
        }
        if (???.objLen(-1) == 0)
        {
          int k = d(???, paramClass);
          return k;
        }
        ???.getI(-1, 1L);
        Object localObject2 = ???.toJavaObject(-1);
        ???.pop(1);
        if (paramClass.isAssignableFrom(localObject2.getClass()))
        {
          int j = d(???, paramClass);
          return j;
        }
        int i = b(???, paramClass);
        return i;
      }
      int i4 = d(???, paramClass);
      return i4;
    }
  }

  public static int javaEquals(long paramLong, Object paramObject1, Object paramObject2)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      ???.pushBoolean(paramObject1.equals(paramObject2));
      return 1;
    }
  }

  public static void javaGc(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append("");
    Log.i("javaGc: ", localStringBuilder.toString());
    if (paramObject == null)
      return;
    try
    {
      if ((paramObject instanceof LuaGcable))
      {
        ((LuaGcable)paramObject).gc();
        return;
      }
      if ((paramObject instanceof Bitmap))
        LuaBitmap.removeBitmap((Bitmap)paramObject);
      for (Bitmap localBitmap = (Bitmap)paramObject; ; localBitmap = ((BitmapDrawable)paramObject).getBitmap())
      {
        localBitmap.recycle();
        return;
        if (!(paramObject instanceof BitmapDrawable))
          break;
      }
      if ((paramObject instanceof AutoCloseable))
      {
        ((AutoCloseable)paramObject).close();
        return;
      }
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
  }

  public static int javaGetType(long paramLong, Object paramObject)
  {
    LuaState localLuaState = LuaStateFactory.getExistingState(paramLong);
    String str;
    if (paramObject == null)
      str = "null";
    try
    {
      while (true)
      {
        localLuaState.pushString(str);
        break;
        str = paramObject.getClass().getName();
      }
      return 1;
      label41: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label41;
    }
  }

  // ERROR //
  public static int javaGetter(LuaState paramLuaState, Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 132
    //   6: ifeq +21 -> 27
    //   9: aload_0
    //   10: aload_1
    //   11: checkcast 132	java/util/Map
    //   14: aload_2
    //   15: invokeinterface 647 2 0
    //   20: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: aload_1
    //   28: instanceof 58
    //   31: ifeq +15 -> 46
    //   34: aload_1
    //   35: checkcast 58	java/lang/Class
    //   38: astore 4
    //   40: iconst_1
    //   41: istore 5
    //   43: goto +12 -> 55
    //   46: aload_1
    //   47: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: astore 4
    //   52: iconst_0
    //   53: istore 5
    //   55: aload_2
    //   56: iconst_0
    //   57: invokevirtual 193	java/lang/String:charAt	(I)C
    //   60: istore 6
    //   62: iload 6
    //   64: invokestatic 199	java/lang/Character:isLowerCase	(C)Z
    //   67: ifeq +40 -> 107
    //   70: new 159	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   77: astore 7
    //   79: aload 7
    //   81: iload 6
    //   83: invokestatic 203	java/lang/Character:toUpperCase	(C)C
    //   86: invokevirtual 206	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 7
    //   92: aload_2
    //   93: iconst_1
    //   94: invokevirtual 210	java/lang/String:substring	(I)Ljava/lang/String;
    //   97: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_2
    //   107: new 159	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   114: astore 10
    //   116: aload 10
    //   118: aload 4
    //   120: invokevirtual 749	java/lang/Class:toString	()Ljava/lang/String;
    //   123: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 10
    //   129: ldc_w 751
    //   132: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 10
    //   138: aload_2
    //   139: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 10
    //   145: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 14
    //   150: aconst_null
    //   151: astore 15
    //   153: iload 5
    //   155: ifne +16 -> 171
    //   158: getstatic 40	com/luajava/LuaJavaAPI:f	Ljava/util/HashMap;
    //   161: aload 14
    //   163: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast 269	java/lang/reflect/Method
    //   169: astore 15
    //   171: aload 15
    //   173: ifnonnull +130 -> 303
    //   176: new 159	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   183: astore 18
    //   185: aload 18
    //   187: ldc_w 752
    //   190: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 18
    //   196: aload_2
    //   197: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: aload 18
    //   205: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: iconst_0
    //   209: anewarray 58	java/lang/Class
    //   212: invokevirtual 755	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   215: astore 15
    //   217: goto +48 -> 265
    //   220: new 159	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   227: astore 19
    //   229: aload 19
    //   231: ldc_w 757
    //   234: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 19
    //   240: aload_2
    //   241: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 4
    //   247: aload 19
    //   249: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: iconst_0
    //   253: anewarray 58	java/lang/Class
    //   256: invokevirtual 755	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   259: astore 22
    //   261: aload 22
    //   263: astore 15
    //   265: iload 5
    //   267: ifeq +18 -> 285
    //   270: aload 15
    //   272: invokevirtual 270	java/lang/reflect/Method:getModifiers	()I
    //   275: invokestatic 229	java/lang/reflect/Modifier:isStatic	(I)Z
    //   278: ifne +7 -> 285
    //   281: aload_0
    //   282: monitorexit
    //   283: iconst_0
    //   284: ireturn
    //   285: getstatic 40	com/luajava/LuaJavaAPI:f	Ljava/util/HashMap;
    //   288: aload 14
    //   290: aload 15
    //   292: invokevirtual 506	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: goto +7 -> 303
    //   299: aload_0
    //   300: monitorexit
    //   301: iconst_0
    //   302: ireturn
    //   303: aload 15
    //   305: aload_1
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokevirtual 294	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   313: astore 17
    //   315: aload 17
    //   317: instanceof 759
    //   320: ifeq +15 -> 335
    //   323: aload_0
    //   324: aload 17
    //   326: invokevirtual 760	java/lang/Object:toString	()Ljava/lang/String;
    //   329: invokevirtual 745	com/luajava/LuaState:pushString	(Ljava/lang/String;)V
    //   332: goto +9 -> 341
    //   335: aload_0
    //   336: aload 17
    //   338: invokevirtual 147	com/luajava/LuaState:pushObjectValue	(Ljava/lang/Object;)V
    //   341: aload_0
    //   342: monitorexit
    //   343: iconst_1
    //   344: ireturn
    //   345: astore 16
    //   347: new 172	com/luajava/LuaException
    //   350: dup
    //   351: aload 16
    //   353: invokespecial 252	com/luajava/LuaException:<init>	(Ljava/lang/Exception;)V
    //   356: athrow
    //   357: astore_3
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_3
    //   361: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   176	217	220	java/lang/NoSuchMethodException
    //   220	261	299	java/lang/NoSuchMethodException
    //   303	315	345	java/lang/Exception
    //   2	25	357	finally
    //   27	40	357	finally
    //   46	52	357	finally
    //   55	107	357	finally
    //   107	150	357	finally
    //   158	171	357	finally
    //   176	217	357	finally
    //   220	261	357	finally
    //   270	283	357	finally
    //   285	296	357	finally
    //   299	301	357	finally
    //   303	315	357	finally
    //   315	332	357	finally
    //   335	341	357	finally
    //   341	343	357	finally
    //   347	357	357	finally
    //   358	360	357	finally
  }

  public static int javaLoadLib(long paramLong, String paramString1, String paramString2)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      try
      {
        Class localClass = Class.forName(paramString1);
        try
        {
          Object localObject3 = localClass.getMethod(paramString2, new Class[] { LuaState.class }).invoke(null, new Object[] { ??? });
          if ((localObject3 != null) && ((localObject3 instanceof Integer)))
          {
            int i = ((Integer)localObject3).intValue();
            return i;
          }
          return 0;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error on calling method. Library could not be loaded. ");
          localStringBuilder.append(localException.getMessage());
          throw new LuaException(localStringBuilder.toString());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new LuaException(localClassNotFoundException);
      }
      Object localObject1;
      throw localObject1;
    }
  }

  public static int javaNew(long paramLong, Class<?> paramClass)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      boolean bool = paramClass.isPrimitive();
      int i = 2;
      if (bool)
      {
        int j = ???.getTop();
        while (i <= j)
        {
          f(???, paramClass, i);
          i++;
        }
        int k = j - 1;
        return k;
      }
      if ((0x400 & paramClass.getModifiers()) != 0)
      {
        if (!???.isTable(i))
          a(???, "javaOverride", 1, "table");
        int n = javaOverride(paramLong, paramClass);
        return n;
      }
      int m = b(???, paramClass);
      return m;
    }
  }

  public static int javaNewInstance(long paramLong, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      Class localClass = javaBindClass(paramString);
      if (localClass.isPrimitive())
      {
        int j = f(???, localClass, -1);
        return j;
      }
      int i = b(???, localClass);
      return i;
    }
  }

  public static int javaObjectLength(long paramLong, Object paramObject)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      try
      {
        int i;
        if ((paramObject instanceof CharSequence))
          i = ((CharSequence)paramObject).length();
        else if ((paramObject instanceof Collection))
          i = ((Collection)paramObject).size();
        else if ((paramObject instanceof Map))
          i = ((Map)paramObject).size();
        else
          i = Array.getLength(paramObject);
        long l = i;
        ???.pushInteger(l);
        return 1;
      }
      catch (Exception localException)
      {
        throw new LuaException(localException);
      }
      Object localObject1;
      throw localObject1;
    }
  }

  public static int javaOverride(long paramLong, Class<?> paramClass)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      LuaTable localLuaTable = new LuaTable(???, 2);
      ???.remove(2);
      if (b(???, new LuaEnhancer(paramClass).create(new MethodFilter()
      {
        public boolean filter(Method paramAnonymousMethod, String paramAnonymousString)
        {
          return this.a.containsKey(paramAnonymousString);
        }
      })) == 0)
        return 0;
      EnhancerInterface localEnhancerInterface = (EnhancerInterface)???.toJavaObject(-1);
      localEnhancerInterface.setMethodInterceptor_Enhancer(new LuaMethodInterceptor(localLuaTable));
      ???.pushJavaObject(localEnhancerInterface);
      return 1;
    }
  }

  public static int javaSetter(LuaState paramLuaState, Object paramObject, String paramString)
  {
    try
    {
      boolean bool = paramObject instanceof Map;
      int i = 1;
      if (bool)
      {
        ((Map)paramObject).put(paramString, paramLuaState.toJavaObject(-1));
        return i;
      }
      if ((paramObject instanceof Class))
      {
        ((Class)paramObject);
      }
      else
      {
        paramObject.getClass();
        i = 0;
      }
      if ((paramString.length() > 2) && (paramString.substring(0, 2).equals("on")) && (paramLuaState.type(-1) == 6))
      {
        int m = a(paramLuaState, paramObject, paramString, i);
        return m;
      }
      int j = b(paramLuaState, paramObject, paramString, i);
      if (j != 0)
        return j;
      int k = a(paramLuaState, paramObject, paramString);
      return k;
    }
    finally
    {
    }
  }

  public static int javaSetter(LuaState paramLuaState, Object paramObject1, String paramString, Object paramObject2)
  {
    paramLuaState.pushObjectValue(paramObject2);
    int i = javaSetter(paramLuaState, paramObject1, paramString);
    paramLuaState.pop(1);
    return i;
  }

  public static int javaToString(long paramLong, Object paramObject)
  {
    LuaState localLuaState = LuaStateFactory.getExistingState(paramLong);
    String str;
    if (paramObject == null)
      str = "null";
    try
    {
      while (true)
      {
        localLuaState.pushString(str);
        break;
        str = paramObject.toString();
      }
      return 1;
      label38: Object localObject1;
      throw localObject1;
    }
    finally
    {
      break label38;
    }
  }

  public static int newArray(long paramLong, Class<?> paramClass)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      try
      {
        int i = ???.getTop() - 1;
        int[] arrayOfInt = new int[i];
        for (int j = 0; j < i; j++)
          arrayOfInt[j] = ((int)???.toInteger(j + 2));
        ???.pushJavaObject(Array.newInstance(paramClass, arrayOfInt));
        return 1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not create a array: ");
        localStringBuilder.append(localException.getMessage());
        throw new LuaException(localStringBuilder.toString());
      }
      Object localObject1;
      throw localObject1;
    }
  }

  public static int newArray(long paramLong, Class<?> paramClass, int paramInt)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      try
      {
        ???.pushJavaObject(Array.newInstance(paramClass, paramInt));
        return 1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not create a array: ");
        localStringBuilder.append(localException.getMessage());
        throw new LuaException(localStringBuilder.toString());
      }
      Object localObject1;
      throw localObject1;
    }
  }

  public static int objectCall(long paramLong, Object paramObject)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      boolean bool = paramObject instanceof LuaMetaTable;
      int i = 2;
      if (bool)
      {
        int j = ???.getTop();
        Object[] arrayOfObject = new Object[j - 1];
        while (i <= j)
        {
          arrayOfObject[(i - 2)] = ???.toJavaObject(i);
          i++;
        }
        ???.pushObjectValue(((LuaMetaTable)paramObject).__call(arrayOfObject));
        return 1;
      }
      if (???.isTable(i))
      {
        if ((paramObject.getClass().isArray()) && (Array.getLength(paramObject) == 0))
        {
          int k = d(???, paramObject.getClass());
          return k;
        }
        ???.pushNil();
        if ((paramObject instanceof List))
        {
          List localList = (List)paramObject;
          while (???.next(i) != 0)
          {
            localList.add(???.toJavaObject(-1));
            ???.pop(1);
          }
        }
        while (???.next(i) != 0)
        {
          if (???.isNumber(-2))
            setArrayValue(???, paramObject, (int)???.toInteger(-2));
          else
            javaSetter(???, paramObject, ???.toString(-2));
          ???.pop(1);
        }
        ???.setTop(1);
        return 1;
      }
      return 0;
    }
  }

  public static int objectIndex(long paramLong, Object paramObject, String paramString, int paramInt)
  {
    LuaState localLuaState = LuaStateFactory.getExistingState(paramLong);
    if (paramInt == 0);
    while (true)
    {
      try
      {
        if (checkMethod(localLuaState, paramObject, paramString) != 0)
        {
          return 2;
          int i = checkField(localLuaState, paramObject, paramString);
          if (i == 0)
            break label143;
          return i;
          if (javaGetter(localLuaState, paramObject, paramString) == 0)
            break label157;
          return 4;
          if (checkClass(localLuaState, paramObject, paramString) == 0)
            break label171;
          return 3;
          if ((paramObject instanceof LuaMetaTable))
          {
            localLuaState.pushObjectValue(((LuaMetaTable)paramObject).__index(paramString));
            return 6;
          }
          return 0;
          Object localObject1;
          throw localObject1;
        }
      }
      finally
      {
        continue;
      }
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 5))
        label143: if ((paramInt != 0) && (paramInt != 4))
          label157: if ((paramInt != 0) && (paramInt != 3))
            label171: if (paramInt != 0)
              if (paramInt != 6);
    }
  }

  public static int objectNewIndex(long paramLong, Object paramObject, String paramString, int paramInt)
  {
    LuaState localLuaState = LuaStateFactory.getExistingState(paramLong);
    if ((paramInt == 0) || (paramInt == 1));
    while (true)
    {
      try
      {
        if (setFieldValue(localLuaState, paramObject, paramString) != 0)
        {
          return 1;
          if (javaSetter(localLuaState, paramObject, paramString) == 0)
            break label105;
          return 2;
          if ((paramObject instanceof LuaMetaTable))
          {
            ((LuaMetaTable)paramObject).__newIndex(paramString, localLuaState.toJavaObject(-1));
            return 3;
          }
          return 0;
        }
      }
      finally
      {
      }
      if ((paramInt != 0) && (paramInt != 2))
        label105: if (paramInt != 0)
          if (paramInt != 3);
    }
  }

  public static int setArrayValue(long paramLong, Object paramObject, int paramInt)
  {
    synchronized (LuaStateFactory.getExistingState(paramLong))
    {
      if (paramObject.getClass().isArray())
      {
        Class localClass = paramObject.getClass().getComponentType();
        StringBuilder localStringBuilder2;
        try
        {
          Array.set(paramObject, paramInt, e(???, localClass, 3));
        }
        catch (LuaException localLuaException)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramObject.getClass().getName());
          localStringBuilder2.append(" [");
          localStringBuilder2.append(paramInt);
          localStringBuilder2.append("]");
          a(???, localStringBuilder2.toString(), 3, localClass);
          tmpTernaryOp = localLuaException;
        }
      }
      else if ((paramObject instanceof List))
      {
        ((List)paramObject).set(paramInt, ???.toJavaObject(3));
      }
      else
      {
        if (!(paramObject instanceof Map))
          break label168;
        ((Map)paramObject).put(Long.valueOf(paramInt), ???.toJavaObject(3));
      }
      return 0;
      label168: StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("can not set ");
      localStringBuilder1.append(paramObject.getClass().getName());
      localStringBuilder1.append(" value: ");
      localStringBuilder1.append(???.toJavaObject(3));
      localStringBuilder1.append(" in ");
      localStringBuilder1.append(paramInt);
      throw new LuaException(localStringBuilder1.toString());
    }
  }

  public static int setArrayValue(LuaState paramLuaState, Object paramObject, int paramInt)
  {
    try
    {
      if (paramObject.getClass().isArray())
      {
        Class localClass = paramObject.getClass().getComponentType();
        StringBuilder localStringBuilder2;
        try
        {
          Array.set(paramObject, paramInt, e(paramLuaState, localClass, -1));
        }
        catch (LuaException localLuaException)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramObject.getClass().getName());
          localStringBuilder2.append(" [");
          localStringBuilder2.append(paramInt);
          localStringBuilder2.append("]");
          a(paramLuaState, localStringBuilder2.toString(), 3, localClass);
          tmpTernaryOp = localLuaException;
        }
      }
      else if ((paramObject instanceof List))
      {
        ((List)paramObject).set(paramInt, paramLuaState.toJavaObject(-1));
      }
      else
      {
        if (!(paramObject instanceof Map))
          break label156;
        ((Map)paramObject).put(Long.valueOf(paramInt), paramLuaState.toJavaObject(-1));
      }
      return 0;
      label156: StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("can not set ");
      localStringBuilder1.append(paramObject.getClass().getName());
      localStringBuilder1.append(" value: ");
      localStringBuilder1.append(paramLuaState.toJavaObject(-1));
      localStringBuilder1.append(" in ");
      localStringBuilder1.append(paramInt);
      throw new LuaException(localStringBuilder1.toString());
    }
    finally
    {
    }
  }

  // ERROR //
  public static int setFieldValue(LuaState paramLuaState, Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: instanceof 58
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: checkcast 58	java/lang/Class
    //   21: astore_3
    //   22: iconst_1
    //   23: istore 4
    //   25: goto +11 -> 36
    //   28: aload_1
    //   29: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: astore_3
    //   33: iconst_0
    //   34: istore 4
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 602	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   41: astore 6
    //   43: aload 6
    //   45: ifnonnull +7 -> 52
    //   48: aload_0
    //   49: monitorexit
    //   50: iconst_0
    //   51: ireturn
    //   52: iload 4
    //   54: ifeq +18 -> 72
    //   57: aload 6
    //   59: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   62: invokestatic 229	java/lang/reflect/Modifier:isStatic	(I)Z
    //   65: ifne +7 -> 72
    //   68: aload_0
    //   69: monitorexit
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 6
    //   74: invokevirtual 232	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   77: astore 7
    //   79: aload 6
    //   81: invokevirtual 223	java/lang/reflect/Field:getModifiers	()I
    //   84: invokestatic 235	java/lang/reflect/Modifier:isPublic	(I)Z
    //   87: ifne +9 -> 96
    //   90: aload 6
    //   92: iconst_1
    //   93: invokevirtual 239	java/lang/reflect/Field:setAccessible	(Z)V
    //   96: aload 6
    //   98: aload_1
    //   99: aload_0
    //   100: aload 7
    //   102: aload_0
    //   103: invokevirtual 242	com/luajava/LuaState:getTop	()I
    //   106: invokestatic 245	com/luajava/LuaJavaAPI:e	(Lcom/luajava/LuaState;Ljava/lang/Class;I)Ljava/lang/Object;
    //   109: invokevirtual 249	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   112: goto +24 -> 136
    //   115: astore 9
    //   117: new 172	com/luajava/LuaException
    //   120: dup
    //   121: aload 9
    //   123: invokespecial 252	com/luajava/LuaException:<init>	(Ljava/lang/Exception;)V
    //   126: athrow
    //   127: aload_0
    //   128: aload_2
    //   129: iconst_m1
    //   130: aload 7
    //   132: invokestatic 255	com/luajava/LuaJavaAPI:a	(Lcom/luajava/LuaState;Ljava/lang/String;ILjava/lang/Class;)Ljava/lang/String;
    //   135: pop
    //   136: aload_0
    //   137: monitorexit
    //   138: iconst_1
    //   139: ireturn
    //   140: aload_0
    //   141: monitorexit
    //   142: iconst_0
    //   143: ireturn
    //   144: aload_0
    //   145: monitorexit
    //   146: aload 5
    //   148: athrow
    //   149: astore 5
    //   151: goto -7 -> 144
    //
    // Exception table:
    //   from	to	target	type
    //   79	96	115	java/lang/Exception
    //   96	112	115	java/lang/Exception
    //   79	96	127	com/luajava/LuaException
    //   96	112	127	com/luajava/LuaException
    //   36	43	140	java/lang/NoSuchFieldException
    //   6	8	149	finally
    //   10	22	149	finally
    //   28	33	149	finally
    //   36	43	149	finally
    //   48	50	149	finally
    //   57	70	149	finally
    //   72	79	149	finally
    //   79	96	149	finally
    //   96	112	149	finally
    //   117	127	149	finally
    //   127	136	149	finally
    //   136	138	149	finally
    //   140	142	149	finally
    //   144	146	149	finally
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaJavaAPI
 * JD-Core Version:    0.6.2
 */