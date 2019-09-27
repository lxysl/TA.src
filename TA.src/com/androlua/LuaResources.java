package com.androlua;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.luajava.LuaMetaTable;
import java.io.InputStream;
import java.util.HashMap;

@SuppressLint({"UseSparseArrays"})
public class LuaResources extends Resources
  implements LuaMetaTable
{
  private static int a = 2131034112;
  private final HashMap<Integer, String> b = new HashMap();
  private final HashMap<Integer, Drawable> c = new HashMap();
  private final HashMap<Integer, Integer> d = new HashMap();
  private final HashMap<Integer, String[]> e = new HashMap();
  private final HashMap<Integer, int[]> f = new HashMap();
  private final HashMap<Integer, Typeface> g = new HashMap();
  private final HashMap<Integer, Integer> h = new HashMap();
  private final HashMap<Integer, Float> i = new HashMap();
  private final HashMap<Integer, Boolean> j = new HashMap();
  private final HashMap<String, Integer> k = new HashMap();
  private Resources l;

  public LuaResources(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    super(paramAssetManager, paramDisplayMetrics, paramConfiguration);
  }

  public Object __call(Object[] paramArrayOfObject)
  {
    return null;
  }

  public Object __index(String paramString)
  {
    return get(paramString);
  }

  public void __newIndex(String paramString, Object paramObject)
  {
    put(paramString, paramObject);
  }

  public Object get(String paramString)
  {
    return this.k.get(paramString);
  }

  public XmlResourceParser getAnimation(int paramInt)
  {
    return this.l.getAnimation(paramInt);
  }

  public boolean getBoolean(int paramInt)
  {
    Boolean localBoolean = (Boolean)this.j.get(Integer.valueOf(paramInt));
    if (localBoolean != null)
      return localBoolean.booleanValue();
    return this.l.getBoolean(paramInt);
  }

  public int getColor(int paramInt)
  {
    Integer localInteger = (Integer)this.d.get(Integer.valueOf(paramInt));
    if (localInteger != null)
      return localInteger.intValue();
    return this.l.getColor(paramInt);
  }

  @TargetApi(23)
  public int getColor(int paramInt, Resources.Theme paramTheme)
  {
    Integer localInteger = (Integer)this.d.get(Integer.valueOf(paramInt));
    if (localInteger != null)
      return localInteger.intValue();
    return this.l.getColor(paramInt, paramTheme);
  }

  public ColorStateList getColorStateList(int paramInt)
  {
    return this.l.getColorStateList(paramInt);
  }

  @TargetApi(23)
  public ColorStateList getColorStateList(int paramInt, Resources.Theme paramTheme)
  {
    return this.l.getColorStateList(paramInt, paramTheme);
  }

  public Configuration getConfiguration()
  {
    return this.l.getConfiguration();
  }

  public float getDimension(int paramInt)
  {
    return this.l.getDimension(paramInt);
  }

  public int getDimensionPixelOffset(int paramInt)
  {
    return this.l.getDimensionPixelOffset(paramInt);
  }

  public int getDimensionPixelSize(int paramInt)
  {
    return this.l.getDimensionPixelSize(paramInt);
  }

  public DisplayMetrics getDisplayMetrics()
  {
    return this.l.getDisplayMetrics();
  }

  public Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = (Drawable)this.c.get(Integer.valueOf(paramInt));
    if (localDrawable != null)
      return localDrawable;
    return this.l.getDrawable(paramInt);
  }

  @TargetApi(21)
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    Drawable localDrawable = (Drawable)this.c.get(Integer.valueOf(paramInt));
    if (localDrawable != null)
      return localDrawable;
    return this.l.getDrawable(paramInt, paramTheme);
  }

  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    return this.l.getDrawableForDensity(paramInt1, paramInt2);
  }

  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    return this.l.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }

  @TargetApi(26)
  public Typeface getFont(int paramInt)
  {
    Typeface localTypeface = (Typeface)this.g.get(Integer.valueOf(paramInt));
    if (localTypeface != null)
      return localTypeface;
    return this.l.getFont(paramInt);
  }

  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.l.getFraction(paramInt1, paramInt2, paramInt3);
  }

  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    return this.l.getIdentifier(paramString1, paramString2, paramString3);
  }

  public int[] getIntArray(int paramInt)
  {
    int[] arrayOfInt = (int[])this.f.get(Integer.valueOf(paramInt));
    if (arrayOfInt != null)
      return arrayOfInt;
    return this.l.getIntArray(paramInt);
  }

  public int getInteger(int paramInt)
  {
    Integer localInteger = (Integer)this.h.get(Integer.valueOf(paramInt));
    if (localInteger != null)
      return localInteger.intValue();
    return this.l.getInteger(paramInt);
  }

  public XmlResourceParser getLayout(int paramInt)
  {
    return this.l.getLayout(paramInt);
  }

  public Movie getMovie(int paramInt)
  {
    return this.l.getMovie(paramInt);
  }

  public String getQuantityString(int paramInt1, int paramInt2)
  {
    return this.l.getQuantityString(paramInt1, paramInt2);
  }

  public String getQuantityString(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    return this.l.getQuantityString(paramInt1, paramInt2, paramArrayOfObject);
  }

  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    return this.l.getQuantityText(paramInt1, paramInt2);
  }

  public String getResourceEntryName(int paramInt)
  {
    return this.l.getResourceEntryName(paramInt);
  }

  public String getResourceName(int paramInt)
  {
    return this.l.getResourceName(paramInt);
  }

  public String getResourcePackageName(int paramInt)
  {
    return this.l.getResourcePackageName(paramInt);
  }

  public String getResourceTypeName(int paramInt)
  {
    return this.l.getResourceTypeName(paramInt);
  }

  public String getString(int paramInt)
  {
    return getText(paramInt).toString();
  }

  public String getString(int paramInt, Object[] paramArrayOfObject)
  {
    return String.format(getString(paramInt), paramArrayOfObject);
  }

  public String[] getStringArray(int paramInt)
  {
    String[] arrayOfString = (String[])this.e.get(Integer.valueOf(paramInt));
    if (arrayOfString != null)
      return arrayOfString;
    return this.l.getStringArray(paramInt);
  }

  public CharSequence getText(int paramInt)
  {
    String str = (String)this.b.get(Integer.valueOf(paramInt));
    if (str != null)
      return str;
    return this.l.getText(paramInt);
  }

  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    String str = (String)this.b.get(Integer.valueOf(paramInt));
    if (str != null)
      return str;
    return this.l.getText(paramInt, paramCharSequence);
  }

  public CharSequence[] getTextArray(int paramInt)
  {
    String[] arrayOfString = (String[])this.e.get(Integer.valueOf(paramInt));
    if (arrayOfString != null)
      return arrayOfString;
    return this.l.getTextArray(paramInt);
  }

  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.l.getValue(paramInt, paramTypedValue, paramBoolean);
  }

  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.l.getValue(paramString, paramTypedValue, paramBoolean);
  }

  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.l.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
  }

  public XmlResourceParser getXml(int paramInt)
  {
    return this.l.getXml(paramInt);
  }

  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return this.l.obtainAttributes(paramAttributeSet, paramArrayOfInt);
  }

  public TypedArray obtainTypedArray(int paramInt)
  {
    return this.l.obtainTypedArray(paramInt);
  }

  public InputStream openRawResource(int paramInt)
  {
    return this.l.openRawResource(paramInt);
  }

  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    return this.l.openRawResource(paramInt, paramTypedValue);
  }

  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    return this.l.openRawResourceFd(paramInt);
  }

  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.l.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
  }

  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    this.l.parseBundleExtras(paramXmlResourceParser, paramBundle);
  }

  public int put(String paramString, Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException();
    int m = a;
    a = m + 1;
    if ((paramObject instanceof Drawable))
    {
      setDrawable(m, (Drawable)paramObject);
    }
    else if ((paramObject instanceof String))
    {
      setText(m, (String)paramObject);
    }
    else if ((paramObject instanceof String[]))
    {
      setTextArray(m, (String[])paramObject);
    }
    else if ((paramObject instanceof Number))
    {
      setColor(m, ((Number)paramObject).intValue());
    }
    else
    {
      if (!(paramObject instanceof int[]))
        break label132;
      setIntArray(m, (int[])paramObject);
    }
    this.k.put(paramString, Integer.valueOf(m));
    return m;
    label132: throw new IllegalArgumentException();
  }

  public void setBoolean(int paramInt, Boolean paramBoolean)
  {
    this.j.put(Integer.valueOf(paramInt), paramBoolean);
  }

  public void setColor(int paramInt1, int paramInt2)
  {
    this.d.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }

  public void setDrawable(int paramInt, Drawable paramDrawable)
  {
    this.c.put(Integer.valueOf(paramInt), paramDrawable);
  }

  public void setFont(int paramInt, Typeface paramTypeface)
  {
    this.g.put(Integer.valueOf(paramInt), paramTypeface);
  }

  public void setIntArray(int paramInt, int[] paramArrayOfInt)
  {
    this.f.put(Integer.valueOf(paramInt), paramArrayOfInt);
  }

  public void setString(int paramInt, String paramString)
  {
    this.b.put(Integer.valueOf(paramInt), paramString);
  }

  public void setStringArray(int paramInt, String[] paramArrayOfString)
  {
    this.e.put(Integer.valueOf(paramInt), paramArrayOfString);
  }

  public void setSuperResources(Resources paramResources)
  {
    this.l = paramResources;
  }

  public void setText(int paramInt, String paramString)
  {
    this.b.put(Integer.valueOf(paramInt), paramString);
  }

  public void setTextArray(int paramInt, String[] paramArrayOfString)
  {
    this.e.put(Integer.valueOf(paramInt), paramArrayOfString);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaResources
 * JD-Core Version:    0.6.2
 */