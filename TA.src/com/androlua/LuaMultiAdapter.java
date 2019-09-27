package com.androlua;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
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

public class LuaMultiAdapter extends BaseAdapter
{
  private Resources a;
  private LuaState b;
  private LuaContext c;
  private LuaTable<Integer, LuaTable> d;
  private LuaTable<Integer, LuaTable<String, Object>> e;
  private LuaTable<String, Object> f;
  private LuaFunction<View> g;
  private LuaFunction h;
  private LuaFunction i;
  private LuaTable<Integer, LuaFunction<Animation>> j;
  private HashMap<View, Animation> k = new HashMap();
  private HashMap<View, Boolean> l = new HashMap();
  private boolean m = true;
  private boolean n;
  private Handler o = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      LuaMultiAdapter.this.notifyDataSetChanged();
    }
  };
  private HashMap<String, Boolean> p = new HashMap();

  public LuaMultiAdapter(LuaContext paramLuaContext, LuaTable paramLuaTable)
  {
    this(paramLuaContext, null, paramLuaTable);
  }

  public LuaMultiAdapter(LuaContext paramLuaContext, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable, LuaTable<Integer, LuaTable> paramLuaTable1)
  {
    this.c = paramLuaContext;
    this.d = paramLuaTable1;
    this.a = this.c.getContext().getResources();
    this.b = paramLuaContext.getLuaState();
    if (paramLuaTable == null)
      paramLuaTable = new LuaTable(this.b);
    this.e = paramLuaTable;
    this.g = this.b.getLuaObject("loadlayout").getFunction();
    this.h = this.b.getLuaObject("table").getField("insert").getFunction();
    this.i = this.b.getLuaObject("table").getField("remove").getFunction();
    int i1 = this.d.length();
    for (int i2 = 1; i2 <= i1; i2++)
    {
      this.b.newTable();
      LuaFunction localLuaFunction = this.g;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.d.get(Integer.valueOf(i2));
      arrayOfObject[1] = this.b.getLuaObject(-1);
      arrayOfObject[2] = AbsListView.class;
      localLuaFunction.call(arrayOfObject);
      this.b.pop(1);
    }
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
      String str = (String)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if (str.toLowerCase().equals("src"))
        a(paramView, localObject);
      else
        a(paramView, str, localObject);
    }
  }

  private void a(View paramView, Object paramObject)
  {
    try
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
      {
        if ((paramObject instanceof Bitmap))
        {
          ((ImageView)paramView).setImageBitmap((Bitmap)paramObject);
          return;
        }
        ImageView localImageView;
        if ((paramObject instanceof String))
          localImageView = (ImageView)paramView;
        for (Drawable localDrawable = new AsyncLoader(null).getBitmap(this.c, (String)paramObject); ; localDrawable = (Drawable)paramObject)
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
    }
    catch (Exception localException)
    {
      this.c.sendError("setHelper", localException);
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
        this.b.newTable();
        this.b.pushObjectValue(paramObject2);
        this.b.setField(-2, paramString);
        try
        {
          localMethod.invoke(paramObject1, new Object[] { this.b.getLuaObject(-1).createProxy(arrayOfClass[0]) });
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

  public void add(LuaTable<String, Object> paramLuaTable)
  {
    LuaFunction localLuaFunction = this.h;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = paramLuaTable;
    localLuaFunction.call(arrayOfObject);
    if (this.m)
      notifyDataSetChanged();
  }

  public void addAll(LuaTable<Integer, LuaTable<String, Object>> paramLuaTable)
  {
    int i1 = paramLuaTable.length();
    for (int i2 = 1; i2 <= i1; i2++)
    {
      LuaFunction localLuaFunction = this.h;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.e;
      arrayOfObject[1] = paramLuaTable.get(Integer.valueOf(i2));
      localLuaFunction.call(arrayOfObject);
    }
    if (this.m)
      notifyDataSetChanged();
  }

  public void clear()
  {
    this.e.clear();
    if (this.m)
      notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.e.length();
  }

  public LuaTable<Integer, LuaTable<String, Object>> getData()
  {
    return this.e;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }

  public Object getItem(int paramInt)
  {
    return this.e.get(Integer.valueOf(paramInt + 1));
  }

  public long getItemId(int paramInt)
  {
    return paramInt + 1;
  }

  public int getItemViewType(int paramInt)
  {
    int i1 = -1 + ((Long)((LuaTable)this.e.get(Integer.valueOf(paramInt + 1))).get("__type")).intValue();
    if (i1 < 0)
      i1 = 0;
    return i1;
  }

  // ERROR //
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 93	com/androlua/LuaMultiAdapter:e	Lcom/luajava/LuaTable;
    //   4: astore 4
    //   6: iload_1
    //   7: iconst_1
    //   8: iadd
    //   9: istore 5
    //   11: aload 4
    //   13: iload 5
    //   15: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 88	com/luajava/LuaTable
    //   24: ldc_w 428
    //   27: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 359	java/lang/Long
    //   33: invokevirtual 429	java/lang/Long:intValue	()I
    //   36: istore 6
    //   38: iload 6
    //   40: iconst_1
    //   41: if_icmpge +6 -> 47
    //   44: iconst_1
    //   45: istore 6
    //   47: aload_2
    //   48: ifnonnull +103 -> 151
    //   51: aload_0
    //   52: getfield 66	com/androlua/LuaMultiAdapter:d	Lcom/luajava/LuaTable;
    //   55: iload 6
    //   57: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 88	com/luajava/LuaTable
    //   66: astore 28
    //   68: aload_0
    //   69: getfield 86	com/androlua/LuaMultiAdapter:b	Lcom/luajava/LuaState;
    //   72: invokevirtual 129	com/luajava/LuaState:newTable	()V
    //   75: aload_0
    //   76: getfield 86	com/androlua/LuaMultiAdapter:b	Lcom/luajava/LuaState;
    //   79: iconst_m1
    //   80: invokevirtual 144	com/luajava/LuaState:getLuaObject	(I)Lcom/luajava/LuaObject;
    //   83: astore 7
    //   85: aload_0
    //   86: getfield 86	com/androlua/LuaMultiAdapter:b	Lcom/luajava/LuaState;
    //   89: iconst_1
    //   90: invokevirtual 156	com/luajava/LuaState:pop	(I)V
    //   93: aload_0
    //   94: getfield 109	com/androlua/LuaMultiAdapter:g	Lcom/luajava/LuaFunction;
    //   97: iconst_3
    //   98: anewarray 131	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload 28
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload 7
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: ldc 146
    //   115: aastore
    //   116: invokevirtual 152	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 431	android/view/View
    //   122: astore 8
    //   124: aload 8
    //   126: aload 7
    //   128: invokevirtual 434	android/view/View:setTag	(Ljava/lang/Object;)V
    //   131: goto +32 -> 163
    //   134: new 431	android/view/View
    //   137: dup
    //   138: aload_0
    //   139: getfield 64	com/androlua/LuaMultiAdapter:c	Lcom/androlua/LuaContext;
    //   142: invokeinterface 72 1 0
    //   147: invokespecial 437	android/view/View:<init>	(Landroid/content/Context;)V
    //   150: areturn
    //   151: aload_2
    //   152: invokevirtual 440	android/view/View:getTag	()Ljava/lang/Object;
    //   155: checkcast 103	com/luajava/LuaObject
    //   158: astore 7
    //   160: aload_2
    //   161: astore 8
    //   163: aload_0
    //   164: getfield 93	com/androlua/LuaMultiAdapter:e	Lcom/luajava/LuaTable;
    //   167: iload 5
    //   169: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: checkcast 88	com/luajava/LuaTable
    //   178: astore 9
    //   180: aload 9
    //   182: ifnonnull +43 -> 225
    //   185: new 272	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   192: astore 10
    //   194: aload 10
    //   196: iload_1
    //   197: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 10
    //   203: ldc_w 445
    //   206: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc_w 447
    //   213: aload 10
    //   215: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 452	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aload 8
    //   224: areturn
    //   225: aload_0
    //   226: getfield 51	com/androlua/LuaMultiAdapter:l	Ljava/util/HashMap;
    //   229: aload 8
    //   231: invokevirtual 453	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   234: ifnonnull +9 -> 243
    //   237: iconst_1
    //   238: istore 14
    //   240: goto +6 -> 246
    //   243: iconst_0
    //   244: istore 14
    //   246: iload 14
    //   248: ifeq +17 -> 265
    //   251: aload_0
    //   252: getfield 51	com/androlua/LuaMultiAdapter:l	Ljava/util/HashMap;
    //   255: aload 8
    //   257: iconst_1
    //   258: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   261: invokevirtual 460	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: aload 9
    //   267: invokevirtual 180	com/luajava/LuaTable:entrySet	()Ljava/util/Set;
    //   270: invokeinterface 186 1 0
    //   275: astore 15
    //   277: aload 15
    //   279: invokeinterface 192 1 0
    //   284: ifeq +134 -> 418
    //   287: aload 15
    //   289: invokeinterface 196 1 0
    //   294: checkcast 198	java/util/Map$Entry
    //   297: astore 21
    //   299: aload 21
    //   301: invokeinterface 201 1 0
    //   306: checkcast 159	java/lang/String
    //   309: astore 24
    //   311: aload 24
    //   313: ldc_w 462
    //   316: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +6 -> 325
    //   322: goto -45 -> 277
    //   325: aload 21
    //   327: invokeinterface 204 1 0
    //   332: astore 25
    //   334: aload 7
    //   336: aload 24
    //   338: invokevirtual 116	com/luajava/LuaObject:getField	(Ljava/lang/String;)Lcom/luajava/LuaObject;
    //   341: astore 26
    //   343: aload 26
    //   345: invokevirtual 465	com/luajava/LuaObject:isJavaObject	()Z
    //   348: ifeq -71 -> 277
    //   351: aload_0
    //   352: getfield 467	com/androlua/LuaMultiAdapter:f	Lcom/luajava/LuaTable;
    //   355: ifnull +29 -> 384
    //   358: iload 14
    //   360: ifeq +24 -> 384
    //   363: aload_0
    //   364: aload 26
    //   366: invokevirtual 470	com/luajava/LuaObject:getObject	()Ljava/lang/Object;
    //   369: checkcast 431	android/view/View
    //   372: aload_0
    //   373: getfield 467	com/androlua/LuaMultiAdapter:f	Lcom/luajava/LuaTable;
    //   376: aload 24
    //   378: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   381: invokespecial 213	com/androlua/LuaMultiAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   384: aload_0
    //   385: aload 26
    //   387: invokevirtual 470	com/luajava/LuaObject:getObject	()Ljava/lang/Object;
    //   390: checkcast 431	android/view/View
    //   393: aload 25
    //   395: invokespecial 213	com/androlua/LuaMultiAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   398: goto -121 -> 277
    //   401: astore 22
    //   403: ldc_w 447
    //   406: aload 22
    //   408: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   411: invokestatic 452	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: goto -138 -> 277
    //   418: aload_0
    //   419: getfield 270	com/androlua/LuaMultiAdapter:n	Z
    //   422: ifeq +6 -> 428
    //   425: aload 8
    //   427: areturn
    //   428: aload_0
    //   429: getfield 472	com/androlua/LuaMultiAdapter:j	Lcom/luajava/LuaTable;
    //   432: ifnull +116 -> 548
    //   435: aload_2
    //   436: ifnull +112 -> 548
    //   439: aload_0
    //   440: getfield 49	com/androlua/LuaMultiAdapter:k	Ljava/util/HashMap;
    //   443: aload_2
    //   444: invokevirtual 453	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   447: checkcast 474	android/view/animation/Animation
    //   450: astore 16
    //   452: aload 16
    //   454: ifnonnull +77 -> 531
    //   457: aload_0
    //   458: getfield 472	com/androlua/LuaMultiAdapter:j	Lcom/luajava/LuaTable;
    //   461: iload 6
    //   463: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokevirtual 141	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   469: checkcast 148	com/luajava/LuaFunction
    //   472: iconst_0
    //   473: anewarray 131	java/lang/Object
    //   476: invokevirtual 152	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   479: checkcast 474	android/view/animation/Animation
    //   482: astore 18
    //   484: aload_0
    //   485: getfield 49	com/androlua/LuaMultiAdapter:k	Ljava/util/HashMap;
    //   488: aload_2
    //   489: aload 18
    //   491: invokevirtual 460	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: aload 18
    //   497: astore 16
    //   499: goto +32 -> 531
    //   502: astore 19
    //   504: aload 19
    //   506: astore 17
    //   508: aload 18
    //   510: astore 16
    //   512: goto +5 -> 517
    //   515: astore 17
    //   517: aload_0
    //   518: getfield 64	com/androlua/LuaMultiAdapter:c	Lcom/androlua/LuaContext;
    //   521: ldc_w 476
    //   524: aload 17
    //   526: invokeinterface 267 3 0
    //   531: aload 16
    //   533: ifnull +15 -> 548
    //   536: aload 8
    //   538: invokevirtual 479	android/view/View:clearAnimation	()V
    //   541: aload 8
    //   543: aload 16
    //   545: invokevirtual 483	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   548: aload 8
    //   550: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   51	131	134	com/luajava/LuaException
    //   299	322	401	java/lang/Exception
    //   325	358	401	java/lang/Exception
    //   363	384	401	java/lang/Exception
    //   384	398	401	java/lang/Exception
    //   484	495	502	java/lang/Exception
    //   457	484	515	java/lang/Exception
  }

  public int getViewTypeCount()
  {
    return this.d.length();
  }

  public void insert(int paramInt, LuaTable<String, Object> paramLuaTable)
  {
    LuaFunction localLuaFunction = this.h;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = Integer.valueOf(paramInt + 1);
    arrayOfObject[2] = paramLuaTable;
    localLuaFunction.call(arrayOfObject);
    if (this.m)
      notifyDataSetChanged();
  }

  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (!this.n)
    {
      this.n = true;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          LuaMultiAdapter.a(LuaMultiAdapter.this, false);
        }
      }
      , 500L);
    }
  }

  public void remove(int paramInt)
  {
    LuaFunction localLuaFunction = this.i;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = Integer.valueOf(paramInt + 1);
    localLuaFunction.call(arrayOfObject);
    if (this.m)
      notifyDataSetChanged();
  }

  public void setAnimation(LuaTable<Integer, LuaFunction<Animation>> paramLuaTable)
  {
    setAnimationUtil(paramLuaTable);
  }

  public void setAnimationUtil(LuaTable<Integer, LuaFunction<Animation>> paramLuaTable)
  {
    this.k.clear();
    this.j = paramLuaTable;
  }

  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
      notifyDataSetChanged();
  }

  public void setStyle(LuaTable<String, Object> paramLuaTable)
  {
    this.l.clear();
    this.f = paramLuaTable;
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
        return new BitmapDrawable(LuaMultiAdapter.a(LuaMultiAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (LuaBitmap.checkCache(paramLuaContext, paramString))
        return new BitmapDrawable(LuaMultiAdapter.a(LuaMultiAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (!LuaMultiAdapter.b(LuaMultiAdapter.this).containsKey(this.b))
      {
        start();
        LuaMultiAdapter.b(LuaMultiAdapter.this).put(this.b, Boolean.valueOf(true));
      }
      return new LoadingDrawable(this.c.getContext());
    }

    public void run()
    {
      try
      {
        LuaBitmap.getBitmap(this.c, this.b);
        LuaMultiAdapter.c(LuaMultiAdapter.this).sendEmptyMessage(0);
        return;
      }
      catch (IOException localIOException)
      {
        this.c.sendError("AsyncLoader", localIOException);
      }
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaMultiAdapter
 * JD-Core Version:    0.6.2
 */