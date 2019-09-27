package com.androlua;

import I;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.a.a.a.a.a.a.a;
import dalvik.system.DexFile;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LuaUtil
{
  private static final byte[] a = new byte[4096];
  public static final HashMap<String, String> mFileTypes = new HashMap();

  static
  {
    mFileTypes.put("FFD8FF", "jpg");
    mFileTypes.put("89504E47", "png");
    mFileTypes.put("47494638", "gif");
    mFileTypes.put("49492A00", "tif");
    mFileTypes.put("424D", "bmp");
    mFileTypes.put("41433130", "dwg");
    mFileTypes.put("38425053", "psd");
    mFileTypes.put("7B5C727466", "rtf");
    mFileTypes.put("3C3F786D6C", "xml");
    mFileTypes.put("68746D6C3E", "html");
    mFileTypes.put("44656C69766572792D646174653A", "eml");
    mFileTypes.put("D0CF11E0", "doc");
    mFileTypes.put("5374616E64617264204A", "mdb");
    mFileTypes.put("252150532D41646F6265", "ps");
    mFileTypes.put("255044462D312E", "pdf");
    mFileTypes.put("504B0304", "docx");
    mFileTypes.put("52617221", "rar");
    mFileTypes.put("57415645", "wav");
    mFileTypes.put("41564920", "avi");
    mFileTypes.put("2E524D46", "rm");
    mFileTypes.put("000001BA", "mpg");
    mFileTypes.put("000001B3", "mpg");
    mFileTypes.put("6D6F6F76", "mov");
    mFileTypes.put("3026B2758E66CF11", "asf");
    mFileTypes.put("4D546864", "mid");
    mFileTypes.put("1F8B08", "gz");
  }

  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        String str = Integer.toHexString(0xFF & paramArrayOfByte[i]).toUpperCase();
        if (str.length() < 2)
          localStringBuilder.append(0);
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
    return null;
  }

  // ERROR //
  private static void a(File paramFile, java.util.zip.ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 168	java/io/File:isFile	()Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iload_3
    //   9: ifeq +225 -> 234
    //   12: aconst_null
    //   13: astore 12
    //   15: new 170	java/io/BufferedInputStream
    //   18: dup
    //   19: new 172	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: getstatic 13	com/androlua/LuaUtil:a	[B
    //   30: arraylength
    //   31: invokespecial 178	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   34: astore 13
    //   36: new 130	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   43: astore 14
    //   45: aload 14
    //   47: aload_2
    //   48: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 14
    //   54: aload_0
    //   55: invokevirtual 181	java/io/File:getName	()Ljava/lang/String;
    //   58: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 14
    //   64: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 22
    //   69: getstatic 187	java/lang/System:out	Ljava/io/PrintStream;
    //   72: aload 22
    //   74: invokevirtual 193	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: new 195	java/util/zip/ZipEntry
    //   81: dup
    //   82: aload 22
    //   84: invokespecial 197	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   87: invokevirtual 203	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   90: aload 13
    //   92: getstatic 13	com/androlua/LuaUtil:a	[B
    //   95: iconst_0
    //   96: getstatic 13	com/androlua/LuaUtil:a	[B
    //   99: arraylength
    //   100: invokevirtual 207	java/io/BufferedInputStream:read	([BII)I
    //   103: istore 23
    //   105: iload 23
    //   107: iconst_m1
    //   108: if_icmpeq +16 -> 124
    //   111: aload_1
    //   112: getstatic 13	com/androlua/LuaUtil:a	[B
    //   115: iconst_0
    //   116: iload 23
    //   118: invokevirtual 211	java/util/zip/ZipOutputStream:write	([BII)V
    //   121: goto -31 -> 90
    //   124: aload 13
    //   126: ifnull +221 -> 347
    //   129: aload 13
    //   131: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   134: return
    //   135: astore 17
    //   137: goto +74 -> 211
    //   140: astore 19
    //   142: aload 13
    //   144: astore 12
    //   146: goto +23 -> 169
    //   149: astore 15
    //   151: aload 13
    //   153: astore 12
    //   155: goto +32 -> 187
    //   158: astore 17
    //   160: aload 12
    //   162: astore 13
    //   164: goto +47 -> 211
    //   167: astore 19
    //   169: aload 19
    //   171: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   174: aload 12
    //   176: ifnull +171 -> 347
    //   179: aload 12
    //   181: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   184: return
    //   185: astore 15
    //   187: aload 15
    //   189: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   192: aload 12
    //   194: ifnull +153 -> 347
    //   197: aload 12
    //   199: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   202: return
    //   203: astore 16
    //   205: aload 16
    //   207: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   210: return
    //   211: aload 13
    //   213: ifnull +18 -> 231
    //   216: aload 13
    //   218: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   221: goto +10 -> 231
    //   224: astore 18
    //   226: aload 18
    //   228: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   231: aload 17
    //   233: athrow
    //   234: aload_0
    //   235: invokevirtual 222	java/io/File:isDirectory	()Z
    //   238: ifeq +109 -> 347
    //   241: aload_0
    //   242: invokevirtual 226	java/io/File:listFiles	()[Ljava/io/File;
    //   245: astore 5
    //   247: aload 5
    //   249: ifnull +98 -> 347
    //   252: aload 5
    //   254: arraylength
    //   255: ifle +92 -> 347
    //   258: aload 5
    //   260: arraylength
    //   261: istore 6
    //   263: iload 4
    //   265: iload 6
    //   267: if_icmpge +80 -> 347
    //   270: aload 5
    //   272: iload 4
    //   274: aaload
    //   275: astore 7
    //   277: aload 7
    //   279: invokevirtual 168	java/io/File:isFile	()Z
    //   282: ifeq +13 -> 295
    //   285: aload 7
    //   287: aload_1
    //   288: aload_2
    //   289: invokestatic 228	com/androlua/LuaUtil:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   292: goto +49 -> 341
    //   295: new 130	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   302: astore 8
    //   304: aload 8
    //   306: aload_2
    //   307: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 8
    //   313: aload 7
    //   315: invokevirtual 181	java/io/File:getName	()Ljava/lang/String;
    //   318: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 8
    //   324: ldc 230
    //   326: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 7
    //   332: aload_1
    //   333: aload 8
    //   335: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 228	com/androlua/LuaUtil:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   341: iinc 4 1
    //   344: goto -81 -> 263
    //   347: return
    //
    // Exception table:
    //   from	to	target	type
    //   36	90	135	finally
    //   90	105	135	finally
    //   111	121	135	finally
    //   36	90	140	java/io/IOException
    //   90	105	140	java/io/IOException
    //   111	121	140	java/io/IOException
    //   36	90	149	java/io/FileNotFoundException
    //   90	105	149	java/io/FileNotFoundException
    //   111	121	149	java/io/FileNotFoundException
    //   15	36	158	finally
    //   169	174	158	finally
    //   187	192	158	finally
    //   15	36	167	java/io/IOException
    //   15	36	185	java/io/FileNotFoundException
    //   129	134	203	java/io/IOException
    //   179	184	203	java/io/IOException
    //   197	202	203	java/io/IOException
    //   216	221	224	java/io/IOException
  }

  private boolean a(int paramInt1, int paramInt2, int[][] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int[] arrayOfInt = paramArrayOfInt[paramInt1];
      int j = paramInt2 + i;
      if (arrayOfInt[j] == 1)
      {
        if (paramArrayOfInt[(paramInt1 + paramInt4)][j] != 0)
          return false;
        i++;
      }
      else
      {
        return false;
      }
    }
    return true;
  }

  public static void assetsToSD(Context paramContext, String paramString1, String paramString2)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
    InputStream localInputStream = paramContext.getAssets().open(paramString1);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i = localInputStream.read(arrayOfByte);
      if (i <= 0)
        break;
      localFileOutputStream.write(arrayOfByte, 0, i);
    }
    localFileOutputStream.flush();
    localInputStream.close();
    localFileOutputStream.close();
  }

  public static Bitmap captureScreen(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    int j = localDisplayMetrics.widthPixels;
    int k = localDisplay.getPixelFormat();
    PixelFormat localPixelFormat = new PixelFormat();
    PixelFormat.getPixelFormatInfo(k, localPixelFormat);
    int m = localPixelFormat.bytesPerPixel;
    int n = i * j;
    byte[] arrayOfByte = new byte[m * n];
    int i1 = 0;
    try
    {
      Runtime.getRuntime().exec(new String[] { "/system/bin/su", "-c", "chmod 777 /dev/graphics/fb0" });
    }
    catch (IOException localIOException)
    {
      a.a(localIOException);
    }
    try
    {
      new DataInputStream(new FileInputStream(new File("/dev/graphics/fb0"))).readFully(arrayOfByte);
    }
    catch (Exception localException)
    {
      a.a(localException);
    }
    int[] arrayOfInt = new int[n];
    while (i1 < arrayOfInt.length)
    {
      int i2 = i1 * 4;
      int i3 = 0xFF & arrayOfByte[i2];
      int i4 = 0xFF & arrayOfByte[(i2 + 1)];
      arrayOfInt[i1] = ((0xFF & arrayOfByte[(i2 + 2)]) + (((0xFF & arrayOfByte[(i2 + 3)]) << 24) + (i3 << 16) + (i4 << 8)));
      i1++;
    }
    return Bitmap.createBitmap(arrayOfInt, j, i, Bitmap.Config.ARGB_8888);
  }

  public static boolean copyDir(File paramFile1, File paramFile2)
  {
    File localFile1 = paramFile2.getParentFile();
    if (!localFile1.exists())
      localFile1.mkdirs();
    boolean bool1 = paramFile1.isDirectory();
    int i = 0;
    boolean bool2;
    if (bool1)
    {
      File[] arrayOfFile = paramFile1.listFiles();
      boolean bool3 = true;
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int j = arrayOfFile.length;
        while (i < j)
        {
          File localFile2 = arrayOfFile[i];
          bool3 = copyDir(localFile2, new File(paramFile2, localFile2.getName()));
          i++;
        }
        return bool3;
      }
      if (!paramFile2.exists())
      {
        bool2 = paramFile2.mkdirs();
        break label148;
      }
      return true;
    }
    try
    {
      if (!paramFile2.exists())
        paramFile2.createNewFile();
      bool2 = copyFile(new FileInputStream(paramFile1), new FileOutputStream(paramFile2));
      label148: return bool2;
    }
    catch (IOException localIOException)
    {
      Log.i("lua", localIOException.getMessage());
    }
    return false;
  }

  public static boolean copyDir(String paramString1, String paramString2)
  {
    return copyDir(new File(paramString1), new File(paramString2));
  }

  public static void copyFile(String paramString1, String paramString2)
  {
    try
    {
      copyFile(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return;
    }
    catch (IOException localIOException)
    {
      Log.i("lua", localIOException.getMessage());
    }
  }

  public static boolean copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return true;
    }
    catch (Exception localException)
    {
      Log.i("lua", localException.getMessage());
    }
    return false;
  }

  public static String[] getAllName(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Enumeration localEnumeration2 = new DexFile(paramContext.getPackageCodePath()).entries();
      while (localEnumeration2.hasMoreElements())
        localArrayList.add(localEnumeration2.nextElement());
    }
    catch (IOException localIOException)
    {
      a.a(localIOException);
      try
      {
        Enumeration localEnumeration1 = new ZipFile(paramString).entries();
        while (localEnumeration1.hasMoreElements())
          localArrayList.add(((ZipEntry)localEnumeration1.nextElement()).getName().replaceAll("/", ".").replace(".class", ""));
      }
      catch (Exception localException)
      {
        a.a(localException);
        String[] arrayOfString = new String[localArrayList.size()];
        localArrayList.toArray(arrayOfString);
        return arrayOfString;
      }
    }
  }

  // ERROR //
  public static String getFileHeader(InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: astore 5
    //   5: aload_0
    //   6: aload 5
    //   8: iconst_0
    //   9: aload 5
    //   11: arraylength
    //   12: invokevirtual 445	java/io/InputStream:read	([BII)I
    //   15: pop
    //   16: aload 5
    //   18: invokestatic 447	com/androlua/LuaUtil:a	([B)Ljava/lang/String;
    //   21: astore_2
    //   22: aload_0
    //   23: ifnull +41 -> 64
    //   26: aload_0
    //   27: invokevirtual 260	java/io/InputStream:close	()V
    //   30: aload_2
    //   31: areturn
    //   32: astore_3
    //   33: aload_0
    //   34: ifnull +10 -> 44
    //   37: aload_0
    //   38: invokevirtual 260	java/io/InputStream:close	()V
    //   41: goto +4 -> 45
    //   44: pop
    //   45: aload_3
    //   46: athrow
    //   47: aload_0
    //   48: ifnull +10 -> 58
    //   51: aload_0
    //   52: invokevirtual 260	java/io/InputStream:close	()V
    //   55: goto +4 -> 59
    //   58: pop
    //   59: aconst_null
    //   60: astore_2
    //   61: goto +4 -> 65
    //   64: pop
    //   65: aload_2
    //   66: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	22	32	finally
    //   37	41	44	java/io/IOException
    //   0	22	47	java/lang/Exception
    //   51	55	58	java/io/IOException
    //   26	30	64	java/io/IOException
  }

  // ERROR //
  public static String getFileMD5(File paramFile)
  {
    // Byte code:
    //   0: new 172	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: invokestatic 451	com/androlua/LuaUtil:getFileMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: areturn
    //   14: aconst_null
    //   15: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	14	java/io/FileNotFoundException
  }

  // ERROR //
  public static String getFileMD5(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore_1
    //   6: ldc_w 453
    //   9: invokestatic 459	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 6
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 253	java/io/InputStream:read	([B)I
    //   19: istore 7
    //   21: iload 7
    //   23: iconst_m1
    //   24: if_icmpeq +15 -> 39
    //   27: aload 6
    //   29: aload_1
    //   30: iconst_0
    //   31: iload 7
    //   33: invokevirtual 462	java/security/MessageDigest:update	([BII)V
    //   36: goto -22 -> 14
    //   39: new 464	java/math/BigInteger
    //   42: dup
    //   43: iconst_1
    //   44: aload 6
    //   46: invokevirtual 468	java/security/MessageDigest:digest	()[B
    //   49: invokespecial 471	java/math/BigInteger:<init>	(I[B)V
    //   52: bipush 16
    //   54: invokevirtual 473	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   57: astore 8
    //   59: aload_0
    //   60: invokevirtual 260	java/io/InputStream:close	()V
    //   63: aload 8
    //   65: areturn
    //   66: astore 9
    //   68: aload 9
    //   70: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   73: aload 8
    //   75: areturn
    //   76: astore 4
    //   78: goto +21 -> 99
    //   81: astore_2
    //   82: aload_2
    //   83: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: invokevirtual 260	java/io/InputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_3
    //   93: aload_3
    //   94: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   97: aconst_null
    //   98: areturn
    //   99: aload_0
    //   100: invokevirtual 260	java/io/InputStream:close	()V
    //   103: goto +10 -> 113
    //   106: astore 5
    //   108: aload 5
    //   110: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   113: aload 4
    //   115: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   59	63	66	java/lang/Exception
    //   6	14	76	finally
    //   14	21	76	finally
    //   27	36	76	finally
    //   39	59	76	finally
    //   82	86	76	finally
    //   6	14	81	java/lang/Exception
    //   14	21	81	java/lang/Exception
    //   27	36	81	java/lang/Exception
    //   39	59	81	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   99	103	106	java/lang/Exception
  }

  public static String getFileMD5(String paramString)
  {
    return getFileMD5(new File(paramString));
  }

  // ERROR //
  public static String getFileSha1(File paramFile)
  {
    // Byte code:
    //   0: new 172	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: invokestatic 479	com/androlua/LuaUtil:getFileSha1	(Ljava/io/InputStream;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: areturn
    //   14: aconst_null
    //   15: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	14	java/io/FileNotFoundException
  }

  // ERROR //
  public static String getFileSha1(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore_1
    //   6: ldc_w 481
    //   9: invokestatic 459	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 6
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 253	java/io/InputStream:read	([B)I
    //   19: istore 7
    //   21: iload 7
    //   23: iconst_m1
    //   24: if_icmpeq +15 -> 39
    //   27: aload 6
    //   29: aload_1
    //   30: iconst_0
    //   31: iload 7
    //   33: invokevirtual 462	java/security/MessageDigest:update	([BII)V
    //   36: goto -22 -> 14
    //   39: new 464	java/math/BigInteger
    //   42: dup
    //   43: iconst_1
    //   44: aload 6
    //   46: invokevirtual 468	java/security/MessageDigest:digest	()[B
    //   49: invokespecial 471	java/math/BigInteger:<init>	(I[B)V
    //   52: bipush 16
    //   54: invokevirtual 473	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   57: astore 8
    //   59: aload_0
    //   60: invokevirtual 260	java/io/InputStream:close	()V
    //   63: aload 8
    //   65: areturn
    //   66: astore 9
    //   68: aload 9
    //   70: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   73: aload 8
    //   75: areturn
    //   76: astore 4
    //   78: goto +21 -> 99
    //   81: astore_2
    //   82: aload_2
    //   83: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: invokevirtual 260	java/io/InputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_3
    //   93: aload_3
    //   94: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   97: aconst_null
    //   98: areturn
    //   99: aload_0
    //   100: invokevirtual 260	java/io/InputStream:close	()V
    //   103: goto +10 -> 113
    //   106: astore 5
    //   108: aload 5
    //   110: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   113: aload 4
    //   115: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   59	63	66	java/lang/Exception
    //   6	14	76	finally
    //   14	21	76	finally
    //   27	36	76	finally
    //   39	59	76	finally
    //   82	86	76	finally
    //   6	14	81	java/lang/Exception
    //   14	21	81	java/lang/Exception
    //   27	36	81	java/lang/Exception
    //   39	59	81	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   99	103	106	java/lang/Exception
  }

  public static String getFileSha1(String paramString)
  {
    return getFileMD5(new File(paramString));
  }

  public static String getFileType(File paramFile)
  {
    try
    {
      String str = (String)mFileTypes.get(getFileHeader(new FileInputStream(paramFile)));
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a.a(localFileNotFoundException);
    }
    return "unknown";
  }

  public static String getFileType(InputStream paramInputStream)
  {
    return (String)mFileTypes.get(getFileHeader(paramInputStream));
  }

  public static String getFileType(String paramString)
  {
    try
    {
      String str = (String)mFileTypes.get(getFileHeader(new FileInputStream(paramString)));
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a.a(localFileNotFoundException);
    }
    return "unknown";
  }

  public static byte[] readAll(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(4096);
    byte[] arrayOfByte1 = new byte[4096];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte1);
      if (-1 == i)
        break;
      localByteArrayOutputStream.write(arrayOfByte1, 0, i);
    }
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return arrayOfByte2;
  }

  public static byte[] readAsset(Context paramContext, String paramString)
  {
    InputStream localInputStream = paramContext.getAssets().open(paramString);
    byte[] arrayOfByte = readAll(localInputStream);
    localInputStream.close();
    return arrayOfByte;
  }

  public static byte[] readZip(String paramString1, String paramString2)
  {
    ZipFile localZipFile = new ZipFile(paramString1);
    return readAll(localZipFile.getInputStream(localZipFile.getEntry(paramString2)));
  }

  public static void rmDir(File paramFile, String paramString)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        rmDir(arrayOfFile[j], paramString);
      paramFile.delete();
    }
    if (paramFile.getName().endsWith(paramString))
      paramFile.delete();
  }

  public static boolean rmDir(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        rmDir(arrayOfFile[j]);
    }
    return paramFile.delete();
  }

  public static void unZip(String paramString)
  {
    unZip(paramString, new File(paramString).getParent(), "");
  }

  public static void unZip(String paramString1, String paramString2)
  {
    unZip(paramString1, paramString2, "");
  }

  public static void unZip(String paramString1, String paramString2, String paramString3)
  {
    ZipFile localZipFile = new ZipFile(paramString1);
    Enumeration localEnumeration = localZipFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      String str = localZipEntry.getName();
      if (str.startsWith(paramString3))
        if (localZipEntry.isDirectory())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramString2);
          localStringBuilder1.append(File.separator);
          localStringBuilder1.append(str);
          File localFile1 = new File(localStringBuilder1.toString());
          if (!localFile1.exists())
            localFile1.mkdirs();
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramString2);
          localStringBuilder2.append(File.separator);
          localStringBuilder2.append(str);
          File localFile2 = new File(localStringBuilder2.toString()).getParentFile();
          if ((!localFile2.exists()) && (!localFile2.mkdirs()))
          {
            StringBuilder localStringBuilder4 = new StringBuilder();
            localStringBuilder4.append("create file ");
            localStringBuilder4.append(localFile2.getName());
            localStringBuilder4.append(" fail");
            throw new RuntimeException(localStringBuilder4.toString());
          }
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(paramString2);
          localStringBuilder3.append(File.separator);
          localStringBuilder3.append(str);
          FileOutputStream localFileOutputStream = new FileOutputStream(localStringBuilder3.toString());
          InputStream localInputStream = localZipFile.getInputStream(localZipEntry);
          byte[] arrayOfByte = new byte[4096];
          while (true)
          {
            int i = localInputStream.read(arrayOfByte);
            if (i == -1)
              break;
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
          localFileOutputStream.close();
          localInputStream.close();
        }
    }
    localZipFile.close();
  }

  public static void unZip(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      unZip(paramString);
      return;
    }
    String str = new File(paramString).getName();
    int i = str.lastIndexOf(".");
    if (i > 0)
      str = str.substring(0, i);
    int j = str.indexOf("_");
    if (j > 0)
      str = str.substring(0, j);
    int k = str.indexOf("(");
    if (k > 0)
      str = str.substring(0, k);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(paramString).getParent());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(str);
    unZip(paramString, localStringBuilder.toString(), "");
  }

  public static boolean zip(String paramString)
  {
    return zip(paramString, new File(paramString).getParent());
  }

  public static boolean zip(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getName());
    localStringBuilder.append(".zip");
    return zip(paramString1, paramString2, localStringBuilder.toString());
  }

  // ERROR //
  public static boolean zip(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 164	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: new 164	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: aload_2
    //   15: invokespecial 582	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 354	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 357	java/io/File:exists	()Z
    //   28: ifne +16 -> 44
    //   31: aload 4
    //   33: invokevirtual 354	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 360	java/io/File:mkdirs	()Z
    //   39: ifne +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload 4
    //   46: invokevirtual 357	java/io/File:exists	()Z
    //   49: ifeq +14 -> 63
    //   52: aload 4
    //   54: invokevirtual 368	java/io/File:createNewFile	()Z
    //   57: pop
    //   58: goto +5 -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: aconst_null
    //   64: astore 5
    //   66: new 584	java/util/zip/CheckedOutputStream
    //   69: dup
    //   70: new 235	java/io/FileOutputStream
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: new 586	java/util/zip/Adler32
    //   82: dup
    //   83: invokespecial 587	java/util/zip/Adler32:<init>	()V
    //   86: invokespecial 590	java/util/zip/CheckedOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/zip/Checksum;)V
    //   89: astore 6
    //   91: new 199	java/util/zip/ZipOutputStream
    //   94: dup
    //   95: new 592	java/io/BufferedOutputStream
    //   98: dup
    //   99: aload 6
    //   101: invokespecial 595	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: invokespecial 596	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   107: astore 7
    //   109: aload_3
    //   110: aload 7
    //   112: ldc_w 431
    //   115: invokestatic 228	com/androlua/LuaUtil:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   118: aload 6
    //   120: invokevirtual 600	java/util/zip/CheckedOutputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   123: invokeinterface 606 1 0
    //   128: pop2
    //   129: iconst_1
    //   130: istore 9
    //   132: aload 7
    //   134: ifnull +94 -> 228
    //   137: aload 7
    //   139: invokevirtual 609	java/util/zip/ZipOutputStream:closeEntry	()V
    //   142: goto +10 -> 152
    //   145: astore 17
    //   147: aload 17
    //   149: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   152: aload 7
    //   154: invokevirtual 610	java/util/zip/ZipOutputStream:close	()V
    //   157: iload 9
    //   159: ireturn
    //   160: astore 11
    //   162: aload 11
    //   164: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   167: iload 9
    //   169: ireturn
    //   170: astore 12
    //   172: aload 7
    //   174: astore 5
    //   176: goto +55 -> 231
    //   179: astore 8
    //   181: aload 7
    //   183: astore 5
    //   185: goto +10 -> 195
    //   188: astore 12
    //   190: goto +41 -> 231
    //   193: astore 8
    //   195: aload 8
    //   197: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   200: iconst_0
    //   201: istore 9
    //   203: aload 5
    //   205: ifnull +23 -> 228
    //   208: aload 5
    //   210: invokevirtual 609	java/util/zip/ZipOutputStream:closeEntry	()V
    //   213: goto +10 -> 223
    //   216: astore 10
    //   218: aload 10
    //   220: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   223: aload 5
    //   225: invokevirtual 610	java/util/zip/ZipOutputStream:close	()V
    //   228: iload 9
    //   230: ireturn
    //   231: aload 5
    //   233: ifnull +33 -> 266
    //   236: aload 5
    //   238: invokevirtual 609	java/util/zip/ZipOutputStream:closeEntry	()V
    //   241: goto +10 -> 251
    //   244: astore 13
    //   246: aload 13
    //   248: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   251: aload 5
    //   253: invokevirtual 610	java/util/zip/ZipOutputStream:close	()V
    //   256: goto +10 -> 266
    //   259: astore 14
    //   261: aload 14
    //   263: invokestatic 219	com/a/a/a/a/a/a/a:a	(Ljava/lang/Throwable;)V
    //   266: aload 12
    //   268: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   52	58	61	java/io/IOException
    //   137	142	145	java/io/IOException
    //   152	157	160	java/io/IOException
    //   223	228	160	java/io/IOException
    //   109	129	170	finally
    //   109	129	179	java/io/FileNotFoundException
    //   66	109	188	finally
    //   195	200	188	finally
    //   66	109	193	java/io/FileNotFoundException
    //   208	213	216	java/io/IOException
    //   236	241	244	java/io/IOException
    //   251	256	259	java/io/IOException
  }

  public int checkPixel(int paramInt1, int paramInt2, int[][] paramArrayOfInt)
  {
    int i = paramArrayOfInt[paramInt1][paramInt2];
    if (paramInt2 + 30 < paramArrayOfInt[paramInt1].length)
    {
      int j = 1;
      int k = 0;
      while (j <= 30)
      {
        if (paramArrayOfInt[paramInt1][(paramInt2 + j)] == 0)
          k++;
        j++;
      }
      if (k > 15)
        return 0;
    }
    return i;
  }

  public int getDifferenceValue(String paramString1, String paramString2)
  {
    new File(paramString1);
    new File(paramString2);
    while (true)
    {
      int i;
      int k;
      int i5;
      int i2;
      int i3;
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString1);
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString2);
        i = localBitmap1.getWidth();
        int j = localBitmap1.getHeight();
        int[][] arrayOfInt = (int[][])Array.newInstance(I.class, new int[] { i, j });
        k = 1;
        break label237;
        if (i5 < j)
          if (localBitmap1.getPixel(k, i5) == localBitmap2.getPixel(k, i5))
          {
            arrayOfInt[(k - 1)][(i5 - 1)] = 0;
          }
          else
          {
            arrayOfInt[(k - 1)][(i5 - 1)] = 1;
            break label250;
            if (i1 < arrayOfInt.length)
            {
              i2 = m;
              i3 = 0;
              if (i3 >= arrayOfInt[i1].length)
                break label293;
              if (arrayOfInt[i1][i3] != 1)
                break label287;
              arrayOfInt[i1][i3] = checkPixel(i1, i3, arrayOfInt);
              if (arrayOfInt[i1][i3] != 1)
                break label287;
              if (i1 <= i2)
                break label276;
              i2 = i1;
              break label287;
            }
            int i4 = (m + n) / 2;
            return i4;
          }
      }
      catch (Exception localException)
      {
        a.a(localException);
        return 0;
      }
      while (true)
      {
        label237: if (k >= i)
          break label262;
        i5 = 1;
        break;
        label250: i5++;
        break;
        k++;
      }
      label262: int m = -1;
      int n = 999;
      int i1 = 0;
      continue;
      label276: if (i1 < n)
        n = i1;
      label287: i3++;
      continue;
      label293: i1++;
      m = i2;
    }
  }

  public BitmapDrawable toBlack(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
    int k = i * j;
    int[] arrayOfInt = new int[k];
    float[] arrayOfFloat1 = new float[k];
    float[] arrayOfFloat2 = new float[3];
    int m = 0;
    float f3;
    for (float f1 = 0.0F; m < j; f1 = f3)
    {
      f3 = f1;
      for (int i5 = 0; i5 < i; i5++)
      {
        Color.colorToHSV(localBitmap.getPixel(i5, m), arrayOfFloat2);
        arrayOfFloat1[(i5 + i * m)] = arrayOfFloat2[2];
        f3 += arrayOfFloat2[2];
      }
      m++;
    }
    float f2 = paramFloat * (f1 / k);
    int[][] arrayOfInt1 = (int[][])Array.newInstance(I.class, new int[] { i, j });
    for (int n = 0; n < j; n++)
      for (int i3 = 0; i3 < i; i3++)
      {
        int i4 = i3 + i * n;
        if (arrayOfFloat1[i4] > f2)
        {
          arrayOfInt[i4] = -1;
          arrayOfInt1[i3][n] = 1;
        }
        else
        {
          arrayOfInt[i4] = -16777216;
          arrayOfInt1[i3][n] = 0;
        }
      }
    for (int i1 = i / 2; i1 < i - 10; i1++)
      for (int i2 = i / 3; i2 < i; i2++)
        if (a(i1, i2, arrayOfInt1, paramInt1, paramInt2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i1);
          localStringBuilder.append("");
          Log.i("find_color", localStringBuilder.toString());
          break;
        }
    return new BitmapDrawable(Bitmap.createBitmap(arrayOfInt, i, j, Bitmap.Config.RGB_565));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaUtil
 * JD-Core Version:    0.6.2
 */