package com.androlua;

import android.annotation.SuppressLint;
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
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.a.a.a.a.a;
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

public class LuaAdapter extends BaseAdapter
  implements Filterable
{
  private final LuaTable<Integer, LuaTable<String, Object>> a;
  private Resources b;
  private LuaState c;
  private LuaContext d;
  private final Object e = new Object();
  private LuaTable f;
  private LuaTable<Integer, LuaTable<String, Object>> g;
  private LuaTable<String, Object> h;
  private CharSequence i;
  private LuaFunction<View> j;
  private LuaFunction k;
  private LuaFunction l;
  private LuaFunction<Animation> m;
  private HashMap<View, Animation> n = new HashMap();
  private HashMap<View, Boolean> o = new HashMap();
  private boolean p = true;
  private boolean q;

  @SuppressLint({"HandlerLeak"})
  private Handler r = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 0)
      {
        LuaAdapter.this.notifyDataSetChanged();
        return;
      }
      try
      {
        LuaTable localLuaTable = new LuaTable(LuaAdapter.a(LuaAdapter.this).getLuaState());
        LuaFunction localLuaFunction = LuaAdapter.d(LuaAdapter.this);
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = LuaAdapter.b(LuaAdapter.this);
        arrayOfObject[1] = localLuaTable;
        arrayOfObject[2] = LuaAdapter.c(LuaAdapter.this);
        localLuaFunction.call(arrayOfObject);
        LuaAdapter.a(LuaAdapter.this, localLuaTable);
        LuaAdapter.this.notifyDataSetChanged();
        return;
      }
      catch (LuaException localLuaException)
      {
        a.a(localLuaException);
        LuaAdapter.e(LuaAdapter.this).sendError("performFiltering", localLuaException);
      }
    }
  };
  private HashMap<String, Boolean> s = new HashMap();
  private ArrayFilter t;
  private LuaFunction u;

  public LuaAdapter(LuaContext paramLuaContext, LuaTable paramLuaTable)
  {
    this(paramLuaContext, null, paramLuaTable);
  }

  public LuaAdapter(LuaContext paramLuaContext, LuaTable<Integer, LuaTable<String, Object>> paramLuaTable, LuaTable paramLuaTable1)
  {
    this.d = paramLuaContext;
    this.f = paramLuaTable1;
    this.b = this.d.getContext().getResources();
    this.c = paramLuaContext.getLuaState();
    if (paramLuaTable == null)
      paramLuaTable = new LuaTable(this.c);
    this.g = paramLuaTable;
    this.a = this.g;
    this.j = this.c.getLuaObject("loadlayout").getFunction();
    this.k = this.c.getLuaObject("table").getField("insert").getFunction();
    this.l = this.c.getLuaObject("table").getField("remove").getFunction();
    this.c.newTable();
    LuaFunction localLuaFunction = this.j;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.f;
    arrayOfObject[1] = this.c.getLuaObject(-1);
    arrayOfObject[2] = AbsListView.class;
    localLuaFunction.call(arrayOfObject);
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
    }
    catch (Exception localException)
    {
      this.d.sendError("setHelper", localException);
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

  public void add(LuaTable<String, Object> paramLuaTable)
  {
    LuaFunction localLuaFunction = this.k;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = paramLuaTable;
    localLuaFunction.call(arrayOfObject);
    if (this.p)
      notifyDataSetChanged();
  }

  public void addAll(LuaTable<Integer, LuaTable<String, Object>> paramLuaTable)
  {
    int i1 = paramLuaTable.length();
    for (int i2 = 1; i2 <= i1; i2++)
    {
      LuaFunction localLuaFunction = this.k;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.a;
      arrayOfObject[1] = paramLuaTable.get(Integer.valueOf(i2));
      localLuaFunction.call(arrayOfObject);
    }
    if (this.p)
      notifyDataSetChanged();
  }

  public void clear()
  {
    this.a.clear();
    if (this.p)
      notifyDataSetChanged();
  }

  public void filter(CharSequence paramCharSequence)
  {
    getFilter().filter(paramCharSequence);
  }

  public int getCount()
  {
    return this.g.length();
  }

  public LuaTable<Integer, LuaTable<String, Object>> getData()
  {
    return this.g;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }

  public Filter getFilter()
  {
    if (this.t == null)
      this.t = new ArrayFilter(null);
    return this.t;
  }

  public Object getItem(int paramInt)
  {
    return this.g.get(Integer.valueOf(paramInt + 1));
  }

  public long getItemId(int paramInt)
  {
    return paramInt + 1;
  }

  // ERROR //
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +99 -> 100
    //   4: aload_0
    //   5: getfield 103	com/androlua/LuaAdapter:c	Lcom/luajava/LuaState;
    //   8: invokevirtual 144	com/luajava/LuaState:newTable	()V
    //   11: aload_0
    //   12: getfield 103	com/androlua/LuaAdapter:c	Lcom/luajava/LuaState;
    //   15: iconst_m1
    //   16: invokevirtual 147	com/luajava/LuaState:getLuaObject	(I)Lcom/luajava/LuaObject;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 103	com/androlua/LuaAdapter:c	Lcom/luajava/LuaState;
    //   25: iconst_1
    //   26: invokevirtual 159	com/luajava/LuaState:pop	(I)V
    //   29: aload_0
    //   30: getfield 128	com/androlua/LuaAdapter:j	Lcom/luajava/LuaFunction;
    //   33: astore 25
    //   35: iconst_3
    //   36: anewarray 58	java/lang/Object
    //   39: astore 26
    //   41: aload 26
    //   43: iconst_0
    //   44: aload_0
    //   45: getfield 83	com/androlua/LuaAdapter:f	Lcom/luajava/LuaTable;
    //   48: aastore
    //   49: aload 26
    //   51: iconst_1
    //   52: aload 4
    //   54: aastore
    //   55: aload 26
    //   57: iconst_2
    //   58: ldc 149
    //   60: aastore
    //   61: aload 25
    //   63: aload 26
    //   65: invokevirtual 155	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 467	android/view/View
    //   71: astore 5
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 470	android/view/View:setTag	(Ljava/lang/Object;)V
    //   80: goto +32 -> 112
    //   83: new 467	android/view/View
    //   86: dup
    //   87: aload_0
    //   88: getfield 81	com/androlua/LuaAdapter:d	Lcom/androlua/LuaContext;
    //   91: invokeinterface 89 1 0
    //   96: invokespecial 473	android/view/View:<init>	(Landroid/content/Context;)V
    //   99: areturn
    //   100: aload_2
    //   101: invokevirtual 476	android/view/View:getTag	()Ljava/lang/Object;
    //   104: checkcast 122	com/luajava/LuaObject
    //   107: astore 4
    //   109: aload_2
    //   110: astore 5
    //   112: aload_0
    //   113: getfield 110	com/androlua/LuaAdapter:g	Lcom/luajava/LuaTable;
    //   116: iload_1
    //   117: iconst_1
    //   118: iadd
    //   119: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: invokevirtual 436	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 105	com/luajava/LuaTable
    //   128: astore 6
    //   130: aload 6
    //   132: ifnonnull +43 -> 175
    //   135: new 282	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   142: astore 7
    //   144: aload 7
    //   146: iload_1
    //   147: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 7
    //   153: ldc_w 481
    //   156: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc_w 483
    //   163: aload 7
    //   165: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 488	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload 5
    //   174: areturn
    //   175: aload_0
    //   176: getfield 68	com/androlua/LuaAdapter:o	Ljava/util/HashMap;
    //   179: aload 5
    //   181: invokevirtual 489	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: ifnonnull +9 -> 193
    //   187: iconst_1
    //   188: istore 11
    //   190: goto +6 -> 196
    //   193: iconst_0
    //   194: istore 11
    //   196: iload 11
    //   198: ifeq +17 -> 215
    //   201: aload_0
    //   202: getfield 68	com/androlua/LuaAdapter:o	Ljava/util/HashMap;
    //   205: aload 5
    //   207: iconst_1
    //   208: invokestatic 492	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   211: invokevirtual 496	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: aload 6
    //   217: invokevirtual 190	com/luajava/LuaTable:entrySet	()Ljava/util/Set;
    //   220: invokeinterface 196 1 0
    //   225: astore 12
    //   227: aload 12
    //   229: invokeinterface 202 1 0
    //   234: ifeq +120 -> 354
    //   237: aload 12
    //   239: invokeinterface 206 1 0
    //   244: checkcast 208	java/util/Map$Entry
    //   247: astore 18
    //   249: aload 18
    //   251: invokeinterface 211 1 0
    //   256: checkcast 162	java/lang/String
    //   259: astore 21
    //   261: aload 18
    //   263: invokeinterface 214 1 0
    //   268: astore 22
    //   270: aload 4
    //   272: aload 21
    //   274: invokevirtual 135	com/luajava/LuaObject:getField	(Ljava/lang/String;)Lcom/luajava/LuaObject;
    //   277: astore 23
    //   279: aload 23
    //   281: invokevirtual 499	com/luajava/LuaObject:isJavaObject	()Z
    //   284: ifeq -57 -> 227
    //   287: aload_0
    //   288: getfield 501	com/androlua/LuaAdapter:h	Lcom/luajava/LuaTable;
    //   291: ifnull +29 -> 320
    //   294: iload 11
    //   296: ifeq +24 -> 320
    //   299: aload_0
    //   300: aload 23
    //   302: invokevirtual 504	com/luajava/LuaObject:getObject	()Ljava/lang/Object;
    //   305: checkcast 467	android/view/View
    //   308: aload_0
    //   309: getfield 501	com/androlua/LuaAdapter:h	Lcom/luajava/LuaTable;
    //   312: aload 21
    //   314: invokevirtual 436	com/luajava/LuaTable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   317: invokespecial 223	com/androlua/LuaAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   320: aload_0
    //   321: aload 23
    //   323: invokevirtual 504	com/luajava/LuaObject:getObject	()Ljava/lang/Object;
    //   326: checkcast 467	android/view/View
    //   329: aload 22
    //   331: invokespecial 223	com/androlua/LuaAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   334: goto -107 -> 227
    //   337: astore 19
    //   339: ldc_w 483
    //   342: aload 19
    //   344: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   347: invokestatic 488	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   350: pop
    //   351: goto -124 -> 227
    //   354: aload_0
    //   355: getfield 280	com/androlua/LuaAdapter:q	Z
    //   358: ifeq +6 -> 364
    //   361: aload 5
    //   363: areturn
    //   364: aload_0
    //   365: getfield 506	com/androlua/LuaAdapter:m	Lcom/luajava/LuaFunction;
    //   368: ifnull +105 -> 473
    //   371: aload_2
    //   372: ifnull +101 -> 473
    //   375: aload_0
    //   376: getfield 66	com/androlua/LuaAdapter:n	Ljava/util/HashMap;
    //   379: aload_2
    //   380: invokevirtual 489	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: checkcast 508	android/view/animation/Animation
    //   386: astore 13
    //   388: aload 13
    //   390: ifnonnull +66 -> 456
    //   393: aload_0
    //   394: getfield 506	com/androlua/LuaAdapter:m	Lcom/luajava/LuaFunction;
    //   397: iconst_0
    //   398: anewarray 58	java/lang/Object
    //   401: invokevirtual 155	com/luajava/LuaFunction:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   404: checkcast 508	android/view/animation/Animation
    //   407: astore 15
    //   409: aload_0
    //   410: getfield 66	com/androlua/LuaAdapter:n	Ljava/util/HashMap;
    //   413: aload_2
    //   414: aload 15
    //   416: invokevirtual 496	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: aload 15
    //   422: astore 13
    //   424: goto +32 -> 456
    //   427: astore 16
    //   429: aload 16
    //   431: astore 14
    //   433: aload 15
    //   435: astore 13
    //   437: goto +5 -> 442
    //   440: astore 14
    //   442: aload_0
    //   443: getfield 81	com/androlua/LuaAdapter:d	Lcom/androlua/LuaContext;
    //   446: ldc_w 510
    //   449: aload 14
    //   451: invokeinterface 277 3 0
    //   456: aload 13
    //   458: ifnull +15 -> 473
    //   461: aload 5
    //   463: invokevirtual 513	android/view/View:clearAnimation	()V
    //   466: aload 5
    //   468: aload 13
    //   470: invokevirtual 517	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   473: aload 5
    //   475: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   4	80	83	com/luajava/LuaException
    //   249	294	337	java/lang/Exception
    //   299	320	337	java/lang/Exception
    //   320	334	337	java/lang/Exception
    //   409	420	427	java/lang/Exception
    //   393	409	440	java/lang/Exception
  }

  public void insert(int paramInt, LuaTable<String, Object> paramLuaTable)
  {
    LuaFunction localLuaFunction = this.k;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Integer.valueOf(paramInt + 1);
    arrayOfObject[2] = paramLuaTable;
    localLuaFunction.call(arrayOfObject);
    if (this.p)
      notifyDataSetChanged();
  }

  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (!this.q)
    {
      this.q = true;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          LuaAdapter.a(LuaAdapter.this, false);
        }
      }
      , 500L);
    }
  }

  public void remove(int paramInt)
  {
    LuaFunction localLuaFunction = this.l;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Integer.valueOf(paramInt + 1);
    localLuaFunction.call(arrayOfObject);
    if (this.p)
      notifyDataSetChanged();
  }

  public void setAnimation(LuaFunction<Animation> paramLuaFunction)
  {
    setAnimationUtil(paramLuaFunction);
  }

  public void setAnimationUtil(LuaFunction<Animation> paramLuaFunction)
  {
    this.n.clear();
    this.m = paramLuaFunction;
  }

  public void setFilter(LuaFunction paramLuaFunction)
  {
    this.u = paramLuaFunction;
  }

  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if (this.p)
      notifyDataSetChanged();
  }

  public void setStyle(LuaTable<String, Object> paramLuaTable)
  {
    this.o.clear();
    this.h = paramLuaTable;
  }

  private class ArrayFilter extends Filter
  {
    private ArrayFilter()
    {
    }

    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      LuaAdapter.a(LuaAdapter.this, paramCharSequence);
      if (LuaAdapter.a(LuaAdapter.this) == null)
        return localFilterResults;
      if (LuaAdapter.d(LuaAdapter.this) != null)
      {
        LuaAdapter.h(LuaAdapter.this).sendEmptyMessage(1);
        return null;
      }
      localFilterResults.values = LuaAdapter.a(LuaAdapter.this);
      localFilterResults.count = LuaAdapter.a(LuaAdapter.this).size();
      return localFilterResults;
    }

    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
    }
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
        return new BitmapDrawable(LuaAdapter.f(LuaAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (LuaBitmap.checkCache(paramLuaContext, paramString))
        return new BitmapDrawable(LuaAdapter.f(LuaAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (!LuaAdapter.g(LuaAdapter.this).containsKey(this.b))
      {
        start();
        LuaAdapter.g(LuaAdapter.this).put(this.b, Boolean.valueOf(true));
      }
      return new LoadingDrawable(this.c.getContext());
    }

    public void run()
    {
      try
      {
        LuaBitmap.getBitmap(this.c, this.b);
        LuaAdapter.h(LuaAdapter.this).sendEmptyMessage(0);
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
 * Qualified Name:     com.androlua.LuaAdapter
 * JD-Core Version:    0.6.2
 */