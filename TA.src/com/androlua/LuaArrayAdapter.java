package com.androlua;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ArrayListAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import java.io.IOException;
import java.util.HashMap;

public class LuaArrayAdapter extends ArrayListAdapter
{
  private Resources a;
  private LuaContext b;
  private LuaState c;
  private LuaObject d;
  private LuaObject e;
  private Animation f;
  private Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      LuaArrayAdapter.this.notifyDataSetChanged();
    }
  };
  private HashMap<String, Boolean> h = new HashMap();

  public LuaArrayAdapter(LuaContext paramLuaContext, LuaObject paramLuaObject)
  {
    this(paramLuaContext, paramLuaObject, new String[0]);
  }

  public LuaArrayAdapter(LuaContext paramLuaContext, LuaObject paramLuaObject, Object[] paramArrayOfObject)
  {
    super(paramLuaContext.getContext(), 0, paramArrayOfObject);
    this.b = paramLuaContext;
    this.d = paramLuaObject;
    this.a = this.b.getContext().getResources();
    this.c = paramLuaContext.getLuaState();
    this.e = this.c.getLuaObject("loadlayout");
    this.c.newTable();
    LuaObject localLuaObject = this.e;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.d;
    arrayOfObject[1] = this.c.getLuaObject(-1);
    arrayOfObject[2] = AbsListView.class;
    localLuaObject.call(arrayOfObject);
    this.c.pop(1);
  }

  private void a(View paramView, Object paramObject)
  {
    if ((paramView instanceof TextView))
    {
      TextView localTextView;
      if ((paramObject instanceof CharSequence))
        localTextView = (TextView)paramView;
      for (Object localObject2 = (CharSequence)paramObject; ; localObject2 = paramObject.toString())
      {
        localTextView.setText((CharSequence)localObject2);
        return;
        localTextView = (TextView)paramView;
      }
    }
    if ((paramView instanceof ImageView))
      try
      {
        ImageView localImageView = (ImageView)paramView;
        Object localObject1;
        if ((paramObject instanceof Bitmap))
        {
          localObject1 = new BitmapDrawable(this.a, (Bitmap)paramObject);
        }
        else if ((paramObject instanceof String))
        {
          localObject1 = new AsyncLoader(null).getBitmap(this.b, (String)paramObject);
        }
        else if ((paramObject instanceof Drawable))
        {
          localObject1 = (Drawable)paramObject;
        }
        else
        {
          boolean bool = paramObject instanceof Number;
          localObject1 = null;
          if (bool)
            localObject1 = this.a.getDrawable(((Number)paramObject).intValue());
        }
        localImageView.setImageDrawable((Drawable)localObject1);
        if ((localObject1 instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject1).getBitmap();
          int i = localBitmap.getWidth();
          int j = localBitmap.getHeight();
          if (localImageView.getScaleType() == ImageView.ScaleType.FIT_XY)
          {
            int k = (int)(this.b.getWidth() * j / i);
            localImageView.setLayoutParams(new ViewGroup.LayoutParams(this.b.getWidth(), k));
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.i("lua", localException.getMessage());
      }
  }

  public Animation getAnimation()
  {
    return this.f;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }

  // ERROR //
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +91 -> 92
    //   4: aload_0
    //   5: getfield 68	com/androlua/LuaArrayAdapter:c	Lcom/luajava/LuaState;
    //   8: invokevirtual 81	com/luajava/LuaState:newTable	()V
    //   11: aload_0
    //   12: getfield 68	com/androlua/LuaArrayAdapter:c	Lcom/luajava/LuaState;
    //   15: iconst_m1
    //   16: invokevirtual 86	com/luajava/LuaState:getLuaObject	(I)Lcom/luajava/LuaObject;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 68	com/androlua/LuaArrayAdapter:c	Lcom/luajava/LuaState;
    //   25: iconst_1
    //   26: invokevirtual 98	com/luajava/LuaState:pop	(I)V
    //   29: aload_0
    //   30: getfield 78	com/androlua/LuaArrayAdapter:e	Lcom/luajava/LuaObject;
    //   33: astore 5
    //   35: iconst_3
    //   36: anewarray 83	java/lang/Object
    //   39: astore 6
    //   41: aload 6
    //   43: iconst_0
    //   44: aload_0
    //   45: getfield 54	com/androlua/LuaArrayAdapter:d	Lcom/luajava/LuaObject;
    //   48: aastore
    //   49: aload 6
    //   51: iconst_1
    //   52: aload 4
    //   54: aastore
    //   55: aload 6
    //   57: iconst_2
    //   58: ldc 88
    //   60: aastore
    //   61: aload 5
    //   63: aload 6
    //   65: invokevirtual 94	com/luajava/LuaObject:call	([Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 205	android/view/View
    //   71: astore_2
    //   72: goto +20 -> 92
    //   75: new 205	android/view/View
    //   78: dup
    //   79: aload_0
    //   80: getfield 52	com/androlua/LuaArrayAdapter:b	Lcom/androlua/LuaContext;
    //   83: invokeinterface 33 1 0
    //   88: invokespecial 208	android/view/View:<init>	(Landroid/content/Context;)V
    //   91: areturn
    //   92: aload_0
    //   93: aload_2
    //   94: aload_0
    //   95: iload_1
    //   96: invokevirtual 212	com/androlua/LuaArrayAdapter:getItem	(I)Ljava/lang/Object;
    //   99: invokespecial 214	com/androlua/LuaArrayAdapter:a	(Landroid/view/View;Ljava/lang/Object;)V
    //   102: aload_0
    //   103: getfield 196	com/androlua/LuaArrayAdapter:f	Landroid/view/animation/Animation;
    //   106: ifnull +11 -> 117
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 196	com/androlua/LuaArrayAdapter:f	Landroid/view/animation/Animation;
    //   114: invokevirtual 218	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   117: aload_2
    //   118: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   29	72	75	com/luajava/LuaException
  }

  public void setAnimation(Animation paramAnimation)
  {
    this.f = paramAnimation;
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
        return new BitmapDrawable(LuaArrayAdapter.a(LuaArrayAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (LuaBitmap.checkCache(paramLuaContext, paramString))
        return new BitmapDrawable(LuaArrayAdapter.a(LuaArrayAdapter.this), LuaBitmap.getBitmap(paramLuaContext, paramString));
      if (!LuaArrayAdapter.b(LuaArrayAdapter.this).containsKey(this.b))
      {
        start();
        LuaArrayAdapter.b(LuaArrayAdapter.this).put(this.b, Boolean.valueOf(true));
      }
      return new LoadingDrawable(this.c.getContext());
    }

    public void run()
    {
      try
      {
        LuaBitmap.getBitmap(this.c, this.b);
        LuaArrayAdapter.c(LuaArrayAdapter.this).sendEmptyMessage(0);
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
 * Qualified Name:     com.androlua.LuaArrayAdapter
 * JD-Core Version:    0.6.2
 */