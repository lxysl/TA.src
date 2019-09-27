package com.androlua;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.a.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class LuaBitmap
{
  static WeakHashMap<String, WeakReference<Bitmap>> a = new WeakHashMap();
  private static long b = 604800000L;

  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      j = 1;
      while (j < i)
        j <<= 1;
    }
    int j = 8 * ((i + 7) / 8);
    return j;
  }

  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    if (paramInt2 == -1)
      i = 1;
    else
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
    int j;
    if (paramInt1 == -1)
    {
      j = 128;
    }
    else
    {
      double d3 = paramInt1;
      j = (int)Math.min(Math.floor(d1 / d3), Math.floor(d2 / d3));
    }
    if (j < i)
      return i;
    if ((paramInt2 == -1) && (paramInt1 == -1))
      return 1;
    if (paramInt1 == -1)
      return i;
    return j;
  }

  public static boolean checkCache(LuaContext paramLuaContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLuaContext.getLuaExtDir("cache"));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.hashCode());
    File localFile = new File(localStringBuilder.toString());
    return (localFile.exists()) && (b != -1L) && (System.currentTimeMillis() - localFile.lastModified() < b);
  }

  public static Bitmap decodeScale(int paramInt, File paramFile)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    int i = 1;
    localOptions1.inJustDecodeBounds = i;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions1);
    if ((localOptions1.outHeight > paramInt * 4) || (localOptions1.outWidth > paramInt))
      i = (int)Math.pow(2.0D, (int)Math.round(Math.log(paramInt / Math.max(localOptions1.outHeight, localOptions1.outWidth)) / Math.log(0.5D)));
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inSampleSize = i;
    return BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions2);
  }

  public static Bitmap getAssetBitmap(Context paramContext, String paramString)
  {
    InputStream localInputStream = paramContext.getAssets().open(paramString);
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
    localInputStream.close();
    return localBitmap;
  }

  public static Bitmap getBitmap(LuaContext paramLuaContext, String paramString)
  {
    WeakReference localWeakReference = (WeakReference)a.get(paramString);
    if (localWeakReference != null)
    {
      Bitmap localBitmap2 = (Bitmap)localWeakReference.get();
      if (localBitmap2 != null)
        return localBitmap2;
    }
    Bitmap localBitmap1;
    if ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https://")))
    {
      if (paramString.charAt(0) != '/')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLuaContext.getLuaDir());
        localStringBuilder.append("/");
        localStringBuilder.append(paramString);
        localBitmap1 = getLocalBitmap(paramLuaContext, localStringBuilder.toString());
      }
      else
      {
        localBitmap1 = getLocalBitmap(paramLuaContext, paramString);
      }
    }
    else
      localBitmap1 = getHttpBitmap(paramLuaContext, paramString);
    a.put(paramString, new WeakReference(localBitmap1));
    return localBitmap1;
  }

  public static Bitmap getBitmapFromFile(File paramFile, int paramInt1, int paramInt2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      BitmapFactory.Options localOptions;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
        localOptions.inSampleSize = a(localOptions, Math.min(paramInt1, paramInt2), paramInt1 * paramInt2);
        localOptions.inJustDecodeBounds = false;
        localOptions.inInputShareable = true;
        localOptions.inPurgeable = true;
      }
      else
      {
        localOptions = null;
      }
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a.a(localOutOfMemoryError);
      }
    }
    return null;
  }

  public static long getCacheTime()
  {
    return b;
  }

  public static Bitmap getHttpBitmap(LuaContext paramLuaContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLuaContext.getLuaExtDir("cache"));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.hashCode());
    String str = localStringBuilder.toString();
    File localFile1 = new File(str);
    int i;
    if ((localFile1.exists()) && (b != -1L) && (System.currentTimeMillis() - localFile1.lastModified() < b))
      i = paramLuaContext.getWidth();
    for (File localFile2 = new File(str); ; localFile2 = new File(str))
    {
      return decodeScale(i, localFile2);
      new File(str).delete();
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setConnectTimeout(120000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      if (!LuaUtil.copyFile(localInputStream, localFileOutputStream))
      {
        localFileOutputStream.close();
        localInputStream.close();
        new File(str).delete();
        throw new RuntimeException("LoadHttpBitmap Error.");
      }
      localFileOutputStream.close();
      localInputStream.close();
      i = paramLuaContext.getWidth();
    }
  }

  public static Bitmap getHttpBitmap(String paramString)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.connect();
    InputStream localInputStream = localHttpURLConnection.getInputStream();
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
    localInputStream.close();
    return localBitmap;
  }

  // ERROR //
  public static Bitmap getImageFromPath(String paramString)
  {
    // Byte code:
    //   0: new 26	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 106	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: iconst_1
    //   10: putfield 110	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_0
    //   14: aload_1
    //   15: invokestatic 119	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: pop
    //   19: aload_1
    //   20: aload_1
    //   21: iconst_m1
    //   22: ldc_w 288
    //   25: invokestatic 218	com/androlua/LuaBitmap:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   28: putfield 140	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   31: aload_1
    //   32: iconst_0
    //   33: putfield 110	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 119	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   41: astore_3
    //   42: aload_3
    //   43: areturn
    //   44: aconst_null
    //   45: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   36	42	44	java/lang/Exception
  }

  public static Bitmap getLocalBitmap(LuaContext paramLuaContext, String paramString)
  {
    return decodeScale(paramLuaContext.getWidth(), new File(paramString));
  }

  public static Bitmap getLocalBitmap(String paramString)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    Bitmap localBitmap = BitmapFactory.decodeStream(localFileInputStream);
    localFileInputStream.close();
    return localBitmap;
  }

  public static void removeBitmap(Bitmap paramBitmap)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramBitmap.equals(((WeakReference)localEntry.getValue()).get()))
        a.remove(localEntry.getKey());
    }
  }

  public static void setCacheTime(long paramLong)
  {
    b = paramLong;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaBitmap
 * JD-Core Version:    0.6.2
 */