package com.androlua;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaJavaAPI;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class LuaExpandableListAdapter extends BaseExpandableListAdapter
{
  private BitmapDrawable a;
  private Resources b;
  private LuaState c;
  private LuaContext d;
  private LuaTable<Integer, LuaTable<String, Object>> e;
  private LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>> f;
  private HashMap<View, Animation> g = new HashMap();
  private LuaTable h;
  private LuaTable i;
  private LuaFunction<View> j;
  private LuaFunction<?> k;
  private LuaFunction<?> l;
  private boolean m;
  private LuaFunction<Animation> n;
  private boolean o;
  private Handler p = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      LuaExpandableListAdapter.this.notifyDataSetChanged();
    }
  };
  private HashMap<String, Boolean> q = new HashMap();

  public LuaExpandableListAdapter(LuaContext paramLuaContext, LuaTable paramLuaTable1, LuaTable paramLuaTable2)
  {
    this(paramLuaContext, null, null, paramLuaTable1, paramLuaTable2);
  }

  public LuaExpandableListAdapter(LuaContext paramLuaContext, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable, LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>> paramLuaTable1, LuaTable paramLuaTable2, LuaTable paramLuaTable3)
  {
    this.d = paramLuaContext;
    this.c = paramLuaContext.getLuaState();
    this.b = this.d.getContext().getResources();
    this.a = new BitmapDrawable(this.b, getClass().getResourceAsStream("/res/drawable/icon.png"));
    this.a.setColorFilter(-1996488705, PorterDuff.Mode.SRC_ATOP);
    this.h = paramLuaTable2;
    this.i = paramLuaTable3;
    if (paramLuaTable == null)
      paramLuaTable = new LuaTable(this.c);
    if (paramLuaTable1 == null)
      paramLuaTable1 = new LuaTable(this.c);
    this.e = paramLuaTable;
    this.f = paramLuaTable1;
    this.j = this.c.getLuaObject("loadlayout").getFunction();
    this.k = this.c.getLuaObject("table").getField("insert").getFunction();
    this.l = this.c.getLuaObject("table").getField("remove").getFunction();
    this.c.newTable();
    LuaFunction localLuaFunction1 = this.j;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = this.h;
    arrayOfObject1[1] = this.c.getLuaObject(-1);
    arrayOfObject1[2] = AbsListView.class;
    localLuaFunction1.call(arrayOfObject1);
    LuaFunction localLuaFunction2 = this.j;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = this.i;
    arrayOfObject2[1] = this.c.getLuaObject(-1);
    arrayOfObject2[2] = AbsListView.class;
    localLuaFunction2.call(arrayOfObject2);
    this.c.pop(1);
  }

  private int a(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((paramString.length() > 2) && (paramString.substring(0, 2).equals("on")) && ((paramObject2 instanceof LuaFunction)))
      return b(paramObject1, paramString, paramObject2);
    return c(paramObject1, paramString, paramObject2);
  }

  private void a(View paramView, LuaTable<String, Object> paramLuaTable)
  {
    Iterator localIterator = paramLuaTable.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        String str = (String)localEntry.getKey();
        Object localObject = localEntry.getValue();
        if (str.toLowerCase().equals("src"))
          a(paramView, localObject);
        else
          a(paramView, str, localObject);
      }
      catch (Exception localException)
      {
        Log.i("lua", localException.getMessage());
      }
    }
  }

  private void a(View paramView, Object paramObject)
  {
    if ((paramObject instanceof LuaTable))
    {
      a(paramView, (LuaTable)paramObject);
      return;
    }
    if ((paramView instanceof TextView))
    {
      TextView localTextView;
      if ((paramObject instanceof CharSequence))
        localTextView = (TextView)paramView;
      for (Object localObject = (CharSequence)paramObject; ; localObject = paramObject.toString())
      {
        localTextView.setText((CharSequence)localObject);
        return;
        localTextView = (TextView)paramView;
      }
    }
    if ((paramView instanceof ImageView))
      try
      {
        if ((paramObject instanceof Bitmap))
        {
          ((ImageView)paramView).setImageBitmap((Bitmap)paramObject);
          return;
        }
        ImageView localImageView;
        if ((paramObject instanceof String))
          localImageView = (ImageView)paramView;
        for (Drawable localDrawable = new AsyncLoader(null).getBitmap(this.d, (String)paramObject); ; localDrawable = (Drawable)paramObject)
        {
          localImageView.setImageDrawable(localDrawable);
          return;
          if (!(paramObject instanceof Drawable))
            break;
          localImageView = (ImageView)paramView;
        }
        if ((paramObject instanceof Number))
        {
          ((ImageView)paramView).setImageResource(((Number)paramObject).intValue());
          return;
        }
      }
      catch (Exception localException)
      {
        Log.i("lua", localException.getMessage());
      }
  }

  private int b(Object paramObject1, String paramString, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOn");
    localStringBuilder.append(paramString.substring(2));
    localStringBuilder.append("Listener");
    String str = localStringBuilder.toString();
    Iterator localIterator = LuaJavaAPI.getMethod(paramObject1.getClass(), str, false).iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      Class[] arrayOfClass = localMethod.getParameterTypes();
      if ((arrayOfClass.length == 1) && (arrayOfClass[0].isInterface()))
      {
        this.c.newTable();
        this.c.pushObjectValue(paramObject2);
        this.c.setField(-2, paramString);
        try
        {
          localMethod.invoke(paramObject1, new Object[] { this.c.getLuaObject(-1).createProxy(arrayOfClass[0]) });
          return 1;
        }
        catch (Exception localException)
        {
          throw new LuaException(localException);
        }
      }
    }
    return 0;
  }

  private int c(Object paramObject1, String paramString, Object paramObject2)
  {
    if (Character.isLowerCase(paramString.charAt(0)))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(Character.toUpperCase(paramString.charAt(0)));
      localStringBuilder1.append(paramString.substring(1));
      paramString = localStringBuilder1.toString();
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("set");
    localStringBuilder2.append(paramString);
    String str = localStringBuilder2.toString();
    Class localClass = paramObject2.getClass();
    StringBuilder localStringBuilder3 = new StringBuilder();
    Iterator localIterator = LuaJavaAPI.getMethod(paramObject1.getClass(), str, false).iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      Class[] arrayOfClass = localMethod.getParameterTypes();
      if (arrayOfClass.length == 1)
        if (arrayOfClass[0].isPrimitive())
        {
          try
          {
            Object[] arrayOfObject1;
            if ((!(paramObject2 instanceof Double)) && (!(paramObject2 instanceof Float)))
            {
              if ((!(paramObject2 instanceof Long)) && (!(paramObject2 instanceof Integer)))
              {
                if (!(paramObject2 instanceof Boolean))
                  continue;
                Object[] arrayOfObject2 = new Object[1];
                arrayOfObject2[0] = ((Boolean)paramObject2);
                localMethod.invoke(paramObject1, arrayOfObject2);
                return 1;
              }
              arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = LuaState.convertLuaNumber(Long.valueOf(((Number)paramObject2).longValue()), arrayOfClass[0]);
            }
            while (true)
            {
              localMethod.invoke(paramObject1, arrayOfObject1);
              return 1;
              arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = LuaState.convertLuaNumber(Double.valueOf(((Number)paramObject2).doubleValue()), arrayOfClass[0]);
            }
          }
          catch (Exception localException)
          {
            localStringBuilder3.append(localException.getMessage());
            localStringBuilder3.append("\n");
          }
        }
        else if (arrayOfClass[0].isAssignableFrom(localClass))
        {
          localMethod.invoke(paramObject1, new Object[] { paramObject2 });
          return 1;
        }
    }
    if (localStringBuilder3.length() > 0)
    {
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("Invalid setter ");
      localStringBuilder4.append(paramString);
      localStringBuilder4.append(". Invalid Parameters.\n");
      localStringBuilder4.append(localStringBuilder3.toString());
      localStringBuilder4.append(localClass.toString());
      throw new LuaException(localStringBuilder4.toString());
    }
    StringBuilder localStringBuilder5 = new StringBuilder();
    localStringBuilder5.append("Invalid setter ");
    localStringBuilder5.append(paramString);
    localStringBuilder5.append(" is not a method.\n");
    throw new LuaException(localStringBuilder5.toString());
  }

  public GroupItem add(LuaTable<String, Object> paramLuaTable)
  {
    this.e.put(Integer.valueOf(1 + this.e.length()), paramLuaTable);
    LuaTable localLuaTable = new LuaTable(this.c);
    this.f.put(Integer.valueOf(this.e.length()), localLuaTable);
    if (this.o)
      notifyDataSetChanged();
    return new GroupItem(localLuaTable);
  }

  public GroupItem add(LuaTable<String, Object> paramLuaTable, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable1)
  {
    this.e.put(Integer.valueOf(1 + this.e.length()), paramLuaTable);
    this.f.put(Integer.valueOf(this.e.length()), paramLuaTable1);
    if (this.o)
      notifyDataSetChanged();
    return new GroupItem(paramLuaTable1);
  }

  public void clear()
  {
    this.e.clear();
    this.f.clear();
    if (this.o)
      notifyDataSetChanged();
  }

  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((LuaTable)this.f.get(Integer.valueOf(paramInt1 + 1))).get(Integer.valueOf(paramInt2 + 1));
  }

  public LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>> getChildData()
  {
    return this.f;
  }

  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2 + 1;
  }

  // ERROR //
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +87 -> 89
    //   5: new 119	com/luajava/LuaTable
    //   8: dup
    //   9: aload_0
    //   10: getfield 69	com/androlua/LuaExpandableListAdapter:c	Lcom/luajava/LuaState;
    //   13: invokespecial 122	com/luajava/LuaTable:<init>	(Lcom/luajava/LuaState;)V
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 142	com/androlua/LuaExpandableListAdapter:j	Lcom/luajava/LuaFunction;
    //   22: astore 26
    //   24: iconst_3
    //   25: anewarray 85	java/lang/Object
    //   28: astore 27
    //   30: aload 27
    //   32: iconst_0
    //   33: aload_0
    //   34: getfield 117	com/androlua/LuaExpandableListAdapter:i	Lcom/luajava/LuaTable;
    //   37: aastore
    //   38: aload 27
    //   40: iconst_1
    //   41: aload 6
    //   43: aastore
    //   44: aload 27
    //   46: iconst_2
    //   47: ldc 163
    //   49: aastore
    //   50: aload 26
    //   52: aload 27
    //   54: invokevirtual 169	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 459	android/view/View
    //   60: astore 7
    //   62: aload 7
    //   64: aload 6
    //   66: invokevirtual 462	android/view/View:setTag	(Ljava/lang/Object;)V
    //   69: goto +34 -> 103
    //   72: new 459	android/view/View
    //   75: dup
    //   76: aload_0
    //   77: getfield 61	com/androlua/LuaExpandableListAdapter:d	Lcom/androlua/LuaContext;
    //   80: invokeinterface 73 1 0
    //   85: invokespecial 465	android/view/View:<init>	(Landroid/content/Context;)V
    //   88: areturn
    //   89: aload 4
    //   91: invokevirtual 468	android/view/View:getTag	()Ljava/lang/Object;
    //   94: checkcast 119	com/luajava/LuaTable
    //   97: astore 6
    //   99: aload 4
    //   101: astore 7
    //   103: aload_0
    //   104: getfield 126	com/androlua/LuaExpandableListAdapter:f	Lcom/luajava/LuaTable;
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: invokestatic 429	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: invokevirtual 451	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 119	com/luajava/LuaTable
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: invokestatic 429	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 451	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 119	com/luajava/LuaTable
    //   131: astore 8
    //   133: aload 8
    //   135: ifnonnull +42 -> 177
    //   138: new 295	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   145: astore 9
    //   147: aload 9
    //   149: iload_2
    //   150: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 9
    //   156: ldc_w 473
    //   159: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 238
    //   165: aload 9
    //   167: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: aload 7
    //   176: areturn
    //   177: aload 8
    //   179: invokevirtual 201	com/luajava/LuaTable:entrySet	()Ljava/util/Set;
    //   182: invokeinterface 207 1 0
    //   187: astore 13
    //   189: aload 13
    //   191: invokeinterface 213 1 0
    //   196: ifeq +80 -> 276
    //   199: aload 13
    //   201: invokeinterface 217 1 0
    //   206: checkcast 219	java/util/Map$Entry
    //   209: astore 20
    //   211: aload 20
    //   213: invokeinterface 222 1 0
    //   218: checkcast 176	java/lang/String
    //   221: astore 23
    //   223: aload 20
    //   225: invokeinterface 225 1 0
    //   230: astore 24
    //   232: aload 6
    //   234: aload 23
    //   236: invokevirtual 451	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: checkcast 459	android/view/View
    //   242: astore 25
    //   244: aload 25
    //   246: ifnull -57 -> 189
    //   249: aload_0
    //   250: aload 25
    //   252: aload 24
    //   254: invokespecial 234	com/androlua/LuaExpandableListAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   257: goto -68 -> 189
    //   260: astore 21
    //   262: ldc 238
    //   264: aload 21
    //   266: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   269: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   272: pop
    //   273: goto -84 -> 189
    //   276: aload_0
    //   277: getfield 475	com/androlua/LuaExpandableListAdapter:m	Z
    //   280: ifeq +6 -> 286
    //   283: aload 7
    //   285: areturn
    //   286: aload_0
    //   287: getfield 477	com/androlua/LuaExpandableListAdapter:n	Lcom/luajava/LuaFunction;
    //   290: ifnull +105 -> 395
    //   293: aload 4
    //   295: ifnull +100 -> 395
    //   298: aload_0
    //   299: getfield 50	com/androlua/LuaExpandableListAdapter:g	Ljava/util/HashMap;
    //   302: aload 4
    //   304: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast 480	android/view/animation/Animation
    //   310: astore 14
    //   312: aload 14
    //   314: ifnonnull +64 -> 378
    //   317: aload_0
    //   318: getfield 477	com/androlua/LuaExpandableListAdapter:n	Lcom/luajava/LuaFunction;
    //   321: iconst_0
    //   322: anewarray 85	java/lang/Object
    //   325: invokevirtual 169	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   328: checkcast 480	android/view/animation/Animation
    //   331: astore 17
    //   333: aload_0
    //   334: getfield 50	com/androlua/LuaExpandableListAdapter:g	Ljava/util/HashMap;
    //   337: aload 4
    //   339: aload 17
    //   341: invokevirtual 481	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: aload 17
    //   347: astore 14
    //   349: goto +29 -> 378
    //   352: astore 18
    //   354: aload 18
    //   356: astore 15
    //   358: aload 17
    //   360: astore 14
    //   362: goto +5 -> 367
    //   365: astore 15
    //   367: ldc 238
    //   369: aload 15
    //   371: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   374: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   377: pop
    //   378: aload 14
    //   380: ifnull +15 -> 395
    //   383: aload 7
    //   385: invokevirtual 484	android/view/View:clearAnimation	()V
    //   388: aload 7
    //   390: aload 14
    //   392: invokevirtual 488	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   395: aload 7
    //   397: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   5	69	72	com/luajava/LuaException
    //   211	244	260	java/lang/Exception
    //   249	257	260	java/lang/Exception
    //   333	345	352	java/lang/Exception
    //   317	333	365	java/lang/Exception
  }

  public int getChildrenCount(int paramInt)
  {
    return ((LuaTable)this.f.get(Integer.valueOf(paramInt + 1))).length();
  }

  public Object getGroup(int paramInt)
  {
    return this.e.get(Integer.valueOf(paramInt + 1));
  }

  public int getGroupCount()
  {
    return this.e.length();
  }

  public LuaTable<Integer, LuaTable<String, Object>> getGroupData()
  {
    return this.e;
  }

  public long getGroupId(int paramInt)
  {
    return paramInt + 1;
  }

  public GroupItem getGroupItem(int paramInt)
  {
    return new GroupItem((LuaTable)this.f.get(Integer.valueOf(paramInt + 1)));
  }

  // ERROR //
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +87 -> 88
    //   4: new 119	com/luajava/LuaTable
    //   7: dup
    //   8: aload_0
    //   9: getfield 69	com/androlua/LuaExpandableListAdapter:c	Lcom/luajava/LuaState;
    //   12: invokespecial 122	com/luajava/LuaTable:<init>	(Lcom/luajava/LuaState;)V
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 142	com/androlua/LuaExpandableListAdapter:j	Lcom/luajava/LuaFunction;
    //   21: astore 25
    //   23: iconst_3
    //   24: anewarray 85	java/lang/Object
    //   27: astore 26
    //   29: aload 26
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 115	com/androlua/LuaExpandableListAdapter:h	Lcom/luajava/LuaTable;
    //   36: aastore
    //   37: aload 26
    //   39: iconst_1
    //   40: aload 5
    //   42: aastore
    //   43: aload 26
    //   45: iconst_2
    //   46: ldc 163
    //   48: aastore
    //   49: aload 25
    //   51: aload 26
    //   53: invokevirtual 169	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 459	android/view/View
    //   59: astore 6
    //   61: aload 6
    //   63: aload 5
    //   65: invokevirtual 462	android/view/View:setTag	(Ljava/lang/Object;)V
    //   68: goto +32 -> 100
    //   71: new 459	android/view/View
    //   74: dup
    //   75: aload_0
    //   76: getfield 61	com/androlua/LuaExpandableListAdapter:d	Lcom/androlua/LuaContext;
    //   79: invokeinterface 73 1 0
    //   84: invokespecial 465	android/view/View:<init>	(Landroid/content/Context;)V
    //   87: areturn
    //   88: aload_3
    //   89: invokevirtual 468	android/view/View:getTag	()Ljava/lang/Object;
    //   92: checkcast 119	com/luajava/LuaTable
    //   95: astore 5
    //   97: aload_3
    //   98: astore 6
    //   100: aload_0
    //   101: getfield 124	com/androlua/LuaExpandableListAdapter:e	Lcom/luajava/LuaTable;
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: invokestatic 429	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokevirtual 451	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast 119	com/luajava/LuaTable
    //   116: astore 7
    //   118: aload 7
    //   120: ifnonnull +42 -> 162
    //   123: new 295	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   130: astore 8
    //   132: aload 8
    //   134: iload_1
    //   135: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 8
    //   141: ldc_w 473
    //   144: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: ldc 238
    //   150: aload 8
    //   152: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload 6
    //   161: areturn
    //   162: aload 7
    //   164: invokevirtual 201	com/luajava/LuaTable:entrySet	()Ljava/util/Set;
    //   167: invokeinterface 207 1 0
    //   172: astore 12
    //   174: aload 12
    //   176: invokeinterface 213 1 0
    //   181: ifeq +80 -> 261
    //   184: aload 12
    //   186: invokeinterface 217 1 0
    //   191: checkcast 219	java/util/Map$Entry
    //   194: astore 19
    //   196: aload 19
    //   198: invokeinterface 222 1 0
    //   203: checkcast 176	java/lang/String
    //   206: astore 22
    //   208: aload 19
    //   210: invokeinterface 225 1 0
    //   215: astore 23
    //   217: aload 5
    //   219: aload 22
    //   221: invokevirtual 451	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: checkcast 459	android/view/View
    //   227: astore 24
    //   229: aload 24
    //   231: ifnull -57 -> 174
    //   234: aload_0
    //   235: aload 24
    //   237: aload 23
    //   239: invokespecial 234	com/androlua/LuaExpandableListAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   242: goto -68 -> 174
    //   245: astore 20
    //   247: ldc 238
    //   249: aload 20
    //   251: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   254: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: goto -84 -> 174
    //   261: aload_0
    //   262: getfield 475	com/androlua/LuaExpandableListAdapter:m	Z
    //   265: ifeq +6 -> 271
    //   268: aload 6
    //   270: areturn
    //   271: aload_0
    //   272: getfield 477	com/androlua/LuaExpandableListAdapter:n	Lcom/luajava/LuaFunction;
    //   275: ifnull +102 -> 377
    //   278: aload_3
    //   279: ifnull +98 -> 377
    //   282: aload_0
    //   283: getfield 50	com/androlua/LuaExpandableListAdapter:g	Ljava/util/HashMap;
    //   286: aload_3
    //   287: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: checkcast 480	android/view/animation/Animation
    //   293: astore 13
    //   295: aload 13
    //   297: ifnonnull +63 -> 360
    //   300: aload_0
    //   301: getfield 477	com/androlua/LuaExpandableListAdapter:n	Lcom/luajava/LuaFunction;
    //   304: iconst_0
    //   305: anewarray 85	java/lang/Object
    //   308: invokevirtual 169	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   311: checkcast 480	android/view/animation/Animation
    //   314: astore 16
    //   316: aload_0
    //   317: getfield 50	com/androlua/LuaExpandableListAdapter:g	Ljava/util/HashMap;
    //   320: aload_3
    //   321: aload 16
    //   323: invokevirtual 481	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: pop
    //   327: aload 16
    //   329: astore 13
    //   331: goto +29 -> 360
    //   334: astore 17
    //   336: aload 17
    //   338: astore 14
    //   340: aload 16
    //   342: astore 13
    //   344: goto +5 -> 349
    //   347: astore 14
    //   349: ldc 238
    //   351: aload 14
    //   353: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   356: invokestatic 246	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   359: pop
    //   360: aload 13
    //   362: ifnull +15 -> 377
    //   365: aload 6
    //   367: invokevirtual 484	android/view/View:clearAnimation	()V
    //   370: aload 6
    //   372: aload 13
    //   374: invokevirtual 488	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   377: aload 6
    //   379: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   4	68	71	com/luajava/LuaException
    //   196	229	245	java/lang/Exception
    //   234	242	245	java/lang/Exception
    //   316	327	334	java/lang/Exception
    //   300	316	347	java/lang/Exception
  }

  public boolean hasStableIds()
  {
    return false;
  }

  public GroupItem insert(int paramInt, LuaTable<String, Object> paramLuaTable, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable1)
  {
    LuaFunction localLuaFunction1 = this.k;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = this.e;
    int i1 = paramInt + 1;
    arrayOfObject1[1] = Integer.valueOf(i1);
    arrayOfObject1[2] = paramLuaTable;
    localLuaFunction1.call(arrayOfObject1);
    LuaFunction localLuaFunction2 = this.k;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = this.f;
    arrayOfObject2[1] = Integer.valueOf(i1);
    arrayOfObject2[2] = paramLuaTable1;
    localLuaFunction2.call(arrayOfObject2);
    if (this.o)
      notifyDataSetChanged();
    return new GroupItem(paramLuaTable1);
  }

  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }

  public void remove(int paramInt)
  {
    LuaFunction localLuaFunction = this.l;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = Integer.valueOf(paramInt + 1);
    localLuaFunction.call(arrayOfObject);
    if (this.o)
      notifyDataSetChanged();
  }

  public void setAnimationUtil(LuaFunction<Animation> paramLuaFunction)
  {
    this.g.clear();
    this.n = paramLuaFunction;
  }

  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.o)
      notifyDataSetChanged();
  }

  private class AsyncLoader extends Thread
  {
    private String b;
    private LuaContext c;

    private AsyncLoader()
    {
    }

    public Drawable getBitmap(LuaContext paramLuaContext, String paramString)
    {
      this.c = paramLuaContext;
      this.b = paramString;
      if ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https://")))
        return new BitmapDrawable(LuaExpandableListAdapter.d(LuaExpandableListAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (LuaBitmap.checkCache(paramLuaContext, paramString))
        return new BitmapDrawable(LuaExpandableListAdapter.d(LuaExpandableListAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (!LuaExpandableListAdapter.e(LuaExpandableListAdapter.this).containsKey(this.b))
      {
        start();
        LuaExpandableListAdapter.e(LuaExpandableListAdapter.this).put(this.b, Boolean.valueOf(true));
      }
      return LuaExpandableListAdapter.f(LuaExpandableListAdapter.this);
    }

    public void run()
    {
      try
      {
        LuaBitmap.getBitmap(this.c, this.b);
        LuaExpandableListAdapter.g(LuaExpandableListAdapter.this).sendEmptyMessage(0);
        return;
      }
      catch (IOException localIOException)
      {
        this.c.sendError("AsyncLoader", localIOException);
      }
    }
  }

  private class GroupItem
  {
    private LuaTable<Integer, LuaTable<String, Object>> b;

    public GroupItem()
    {
      Object localObject;
      this.b = localObject;
    }

    public void add(LuaTable<String, Object> paramLuaTable)
    {
      this.b.put(Integer.valueOf(1 + this.b.length()), paramLuaTable);
      if (LuaExpandableListAdapter.a(LuaExpandableListAdapter.this))
        LuaExpandableListAdapter.this.notifyDataSetChanged();
    }

    public void clear()
    {
      this.b.clear();
      if (LuaExpandableListAdapter.a(LuaExpandableListAdapter.this))
        LuaExpandableListAdapter.this.notifyDataSetChanged();
    }

    public LuaTable<Integer, LuaTable<String, Object>> getData()
    {
      return this.b;
    }

    public void insert(int paramInt, LuaTable<String, Object> paramLuaTable)
    {
      LuaFunction localLuaFunction = LuaExpandableListAdapter.b(LuaExpandableListAdapter.this);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.b;
      arrayOfObject[1] = Integer.valueOf(paramInt + 1);
      arrayOfObject[2] = paramLuaTable;
      localLuaFunction.call(arrayOfObject);
      if (LuaExpandableListAdapter.a(LuaExpandableListAdapter.this))
        LuaExpandableListAdapter.this.notifyDataSetChanged();
    }

    public void remove(int paramInt)
    {
      LuaFunction localLuaFunction = LuaExpandableListAdapter.c(LuaExpandableListAdapter.this);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.b;
      arrayOfObject[1] = Integer.valueOf(paramInt + 1);
      localLuaFunction.call(arrayOfObject);
      if (LuaExpandableListAdapter.a(LuaExpandableListAdapter.this))
        LuaExpandableListAdapter.this.notifyDataSetChanged();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaExpandableListAdapter
 * JD-Core Version:    0.6.2
 */