package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;

public final class g
{
  private static final String a = localStringBuilder.toString();
  private static j e;
  private final Context b;
  private int c = 0;
  private PublicKey d;

  static
  {
    String str1 = new String(b.a(new byte[] { 77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61 }));
    String str2 = new String(b.a(new byte[] { 90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61 }));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
  }

  private g(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    a();
  }

  public static String a(Context paramContext)
  {
    return c(paramContext).b();
  }

  // ERROR //
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: new 86	java/io/FileReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 89	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: sipush 8192
    //   12: newarray char
    //   14: astore 6
    //   16: new 91	java/io/CharArrayWriter
    //   19: dup
    //   20: invokespecial 92	java/io/CharArrayWriter:<init>	()V
    //   23: astore 7
    //   25: aload_1
    //   26: aload 6
    //   28: invokevirtual 96	java/io/FileReader:read	([C)I
    //   31: istore 8
    //   33: iload 8
    //   35: ifle +16 -> 51
    //   38: aload 7
    //   40: aload 6
    //   42: iconst_0
    //   43: iload 8
    //   45: invokevirtual 100	java/io/CharArrayWriter:write	([CII)V
    //   48: goto -23 -> 25
    //   51: aload 7
    //   53: invokevirtual 101	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   56: astore 9
    //   58: aload_1
    //   59: ifnull +17 -> 76
    //   62: aload_1
    //   63: invokevirtual 104	java/io/FileReader:close	()V
    //   66: aload 9
    //   68: areturn
    //   69: astore 10
    //   71: aload 10
    //   73: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   76: aload 9
    //   78: areturn
    //   79: astore 4
    //   81: goto +13 -> 94
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +32 -> 119
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_1
    //   94: aload 4
    //   96: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +16 -> 116
    //   103: aload_1
    //   104: invokevirtual 104	java/io/FileReader:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore 5
    //   111: aload 5
    //   113: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_2
    //   119: aload_1
    //   120: ifnull +15 -> 135
    //   123: aload_1
    //   124: invokevirtual 104	java/io/FileReader:close	()V
    //   127: goto +8 -> 135
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   62	66	69	java/lang/Exception
    //   9	25	79	java/lang/Exception
    //   25	33	79	java/lang/Exception
    //   38	48	79	java/lang/Exception
    //   51	58	79	java/lang/Exception
    //   0	9	84	finally
    //   0	9	90	java/lang/Exception
    //   103	107	109	java/lang/Exception
    //   9	25	118	finally
    //   25	33	118	finally
    //   38	48	118	finally
    //   51	58	118	finally
    //   94	99	118	finally
    //   123	127	130	java/lang/Exception
  }

  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    String str1 = "";
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      String str2 = Integer.toHexString(0xFF & paramArrayOfByte[i]);
      StringBuilder localStringBuilder;
      if (str2.length() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        str1 = "0";
      }
      while (true)
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        str1 = localStringBuilder.toString();
        break;
        localStringBuilder = new StringBuilder();
      }
    }
    return str1.toLowerCase();
  }

  // ERROR //
  private List<i> a(Intent paramIntent, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 135	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 136	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 71	com/baidu/mobstat/g:b	Landroid/content/Context;
    //   12: invokevirtual 140	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: astore 4
    //   17: aload 4
    //   19: aload_1
    //   20: iconst_0
    //   21: invokevirtual 146	android/content/pm/PackageManager:queryBroadcastReceivers	(Landroid/content/Intent;I)Ljava/util/List;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +391 -> 419
    //   31: aload 5
    //   33: invokeinterface 152 1 0
    //   38: astore 6
    //   40: goto +4 -> 44
    //   43: pop
    //   44: aload 6
    //   46: invokeinterface 158 1 0
    //   51: ifeq +368 -> 419
    //   54: aload 6
    //   56: invokeinterface 162 1 0
    //   61: checkcast 164	android/content/pm/ResolveInfo
    //   64: astore 7
    //   66: aload 7
    //   68: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   71: ifnull -28 -> 43
    //   74: aload 7
    //   76: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   79: getfield 174	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   82: ifnull -39 -> 43
    //   85: aload 4
    //   87: new 176	android/content/ComponentName
    //   90: dup
    //   91: aload 7
    //   93: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   96: getfield 179	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   99: aload 7
    //   101: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   104: getfield 182	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   107: invokespecial 185	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: sipush 128
    //   113: invokevirtual 189	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   116: getfield 193	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   119: astore 8
    //   121: aload 8
    //   123: ifnonnull +6 -> 129
    //   126: goto -83 -> 43
    //   129: aload 8
    //   131: ldc 195
    //   133: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 9
    //   138: aload 9
    //   140: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifeq +6 -> 149
    //   146: goto -103 -> 43
    //   149: aload 9
    //   151: ldc 209
    //   153: invokevirtual 213	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   156: invokestatic 32	com/baidu/mobstat/b:a	([B)[B
    //   159: astore 11
    //   161: new 215	org/json/JSONObject
    //   164: dup
    //   165: new 18	java/lang/String
    //   168: dup
    //   169: aload 11
    //   171: invokespecial 36	java/lang/String:<init>	([B)V
    //   174: invokespecial 216	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   177: astore 12
    //   179: new 218	com/baidu/mobstat/i
    //   182: dup
    //   183: aconst_null
    //   184: invokespecial 221	com/baidu/mobstat/i:<init>	(Lcom/baidu/mobstat/h;)V
    //   187: astore 13
    //   189: aload 13
    //   191: aload 12
    //   193: ldc 223
    //   195: invokevirtual 227	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   198: putfield 229	com/baidu/mobstat/i:b	I
    //   201: aload 13
    //   203: aload 7
    //   205: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   208: getfield 174	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   211: putfield 231	com/baidu/mobstat/i:a	Landroid/content/pm/ApplicationInfo;
    //   214: aload_0
    //   215: getfield 71	com/baidu/mobstat/g:b	Landroid/content/Context;
    //   218: invokevirtual 234	android/content/Context:getPackageName	()Ljava/lang/String;
    //   221: aload 7
    //   223: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   226: getfield 174	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   229: getfield 237	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   232: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifeq +9 -> 244
    //   238: aload 13
    //   240: iconst_1
    //   241: putfield 244	com/baidu/mobstat/i:d	Z
    //   244: iload_2
    //   245: ifeq +162 -> 407
    //   248: aload 8
    //   250: ldc 246
    //   252: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: astore 14
    //   257: aload 14
    //   259: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifne +145 -> 407
    //   265: aload 4
    //   267: aload 7
    //   269: getfield 168	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   272: getfield 174	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   275: getfield 237	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   278: bipush 64
    //   280: invokevirtual 250	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   283: astore 16
    //   285: aload 12
    //   287: ldc 252
    //   289: invokevirtual 256	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   292: astore 17
    //   294: aload 17
    //   296: invokevirtual 259	org/json/JSONArray:length	()I
    //   299: anewarray 18	java/lang/String
    //   302: astore 18
    //   304: iconst_0
    //   305: istore 19
    //   307: iload 19
    //   309: aload 18
    //   311: arraylength
    //   312: if_icmpge +21 -> 333
    //   315: aload 18
    //   317: iload 19
    //   319: aload 17
    //   321: iload 19
    //   323: invokevirtual 261	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   326: aastore
    //   327: iinc 19 1
    //   330: goto -23 -> 307
    //   333: aload_0
    //   334: aload 18
    //   336: aload_0
    //   337: aload 16
    //   339: getfield 267	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   342: invokespecial 270	com/baidu/mobstat/g:a	([Landroid/content/pm/Signature;)[Ljava/lang/String;
    //   345: invokespecial 273	com/baidu/mobstat/g:a	([Ljava/lang/String;[Ljava/lang/String;)Z
    //   348: ifeq +59 -> 407
    //   351: aload 14
    //   353: invokevirtual 276	java/lang/String:getBytes	()[B
    //   356: invokestatic 32	com/baidu/mobstat/b:a	([B)[B
    //   359: aload_0
    //   360: getfield 278	com/baidu/mobstat/g:d	Ljava/security/PublicKey;
    //   363: invokestatic 281	com/baidu/mobstat/g:a	([BLjava/security/PublicKey;)[B
    //   366: astore 20
    //   368: aload 11
    //   370: invokestatic 284	com/baidu/mobstat/d:a	([B)[B
    //   373: astore 21
    //   375: aload 20
    //   377: ifnull +56 -> 433
    //   380: aload 20
    //   382: aload 21
    //   384: invokestatic 289	java/util/Arrays:equals	([B[B)Z
    //   387: ifeq +46 -> 433
    //   390: iconst_1
    //   391: istore 22
    //   393: goto +3 -> 396
    //   396: iload 22
    //   398: ifeq +9 -> 407
    //   401: aload 13
    //   403: iconst_1
    //   404: putfield 291	com/baidu/mobstat/i:c	Z
    //   407: aload_3
    //   408: aload 13
    //   410: invokeinterface 294 2 0
    //   415: pop
    //   416: goto -373 -> 43
    //   419: aload_3
    //   420: new 296	com/baidu/mobstat/h
    //   423: dup
    //   424: aload_0
    //   425: invokespecial 299	com/baidu/mobstat/h:<init>	(Lcom/baidu/mobstat/g;)V
    //   428: invokestatic 305	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   431: aload_3
    //   432: areturn
    //   433: iconst_0
    //   434: istore 22
    //   436: goto -40 -> 396
    //
    // Exception table:
    //   from	to	target	type
    //   85	121	43	java/lang/Exception
    //   129	146	43	java/lang/Exception
    //   149	244	43	java/lang/Exception
    //   248	304	43	java/lang/Exception
    //   307	327	43	java/lang/Exception
    //   333	375	43	java/lang/Exception
    //   380	390	43	java/lang/Exception
    //   401	407	43	java/lang/Exception
    //   407	416	43	java/lang/Exception
  }

  // ERROR //
  private void a()
  {
    // Byte code:
    //   0: new 307	java/io/ByteArrayInputStream
    //   3: dup
    //   4: invokestatic 311	com/baidu/mobstat/f:a	()[B
    //   7: invokespecial 312	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_1
    //   11: aload_0
    //   12: ldc_w 314
    //   15: invokestatic 320	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   18: aload_1
    //   19: invokevirtual 324	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   22: invokevirtual 330	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   25: putfield 278	com/baidu/mobstat/g:d	Ljava/security/PublicKey;
    //   28: aload_1
    //   29: ifnull +62 -> 91
    //   32: aload_1
    //   33: invokevirtual 331	java/io/ByteArrayInputStream:close	()V
    //   36: return
    //   37: astore 4
    //   39: goto +11 -> 50
    //   42: astore 6
    //   44: aconst_null
    //   45: astore_1
    //   46: aload 6
    //   48: astore 4
    //   50: aload_1
    //   51: ifnull +17 -> 68
    //   54: aload_1
    //   55: invokevirtual 331	java/io/ByteArrayInputStream:close	()V
    //   58: goto +10 -> 68
    //   61: astore 5
    //   63: aload 5
    //   65: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   68: aload 4
    //   70: athrow
    //   71: aconst_null
    //   72: astore_1
    //   73: goto +4 -> 77
    //   76: pop
    //   77: aload_1
    //   78: ifnull +13 -> 91
    //   81: aload_1
    //   82: invokevirtual 331	java/io/ByteArrayInputStream:close	()V
    //   85: return
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   91: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	28	37	finally
    //   0	11	42	finally
    //   54	58	61	java/lang/Exception
    //   0	11	71	java/lang/Exception
    //   11	28	76	java/lang/Exception
    //   32	36	86	java/lang/Exception
    //   81	85	86	java/lang/Exception
  }

  // ERROR //
  @android.annotation.SuppressLint({"NewApi"})
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: getstatic 340	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +8 -> 13
    //   8: iconst_0
    //   9: istore_2
    //   10: goto +5 -> 15
    //   13: iconst_1
    //   14: istore_2
    //   15: aconst_null
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 71	com/baidu/mobstat/g:b	Landroid/content/Context;
    //   21: ldc_w 342
    //   24: iload_2
    //   25: invokevirtual 346	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   28: astore 8
    //   30: aload 8
    //   32: aload_1
    //   33: invokevirtual 276	java/lang/String:getBytes	()[B
    //   36: invokevirtual 350	java/io/FileOutputStream:write	([B)V
    //   39: aload 8
    //   41: invokevirtual 353	java/io/FileOutputStream:flush	()V
    //   44: aload 8
    //   46: ifnull +18 -> 64
    //   49: aload 8
    //   51: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   54: goto +10 -> 64
    //   57: astore 9
    //   59: aload 9
    //   61: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   64: iload_2
    //   65: ifne +30 -> 95
    //   68: new 356	java/io/File
    //   71: dup
    //   72: aload_0
    //   73: getfield 71	com/baidu/mobstat/g:b	Landroid/content/Context;
    //   76: invokevirtual 360	android/content/Context:getFilesDir	()Ljava/io/File;
    //   79: ldc_w 342
    //   82: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: invokevirtual 366	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: sipush 436
    //   91: invokestatic 371	com/baidu/mobstat/k:a	(Ljava/lang/String;I)Z
    //   94: ireturn
    //   95: iconst_1
    //   96: ireturn
    //   97: astore 6
    //   99: aload 8
    //   101: astore_3
    //   102: goto +42 -> 144
    //   105: astore 4
    //   107: aload 8
    //   109: astore_3
    //   110: goto +10 -> 120
    //   113: astore 6
    //   115: goto +29 -> 144
    //   118: astore 4
    //   120: aload 4
    //   122: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: ifnull +16 -> 142
    //   129: aload_3
    //   130: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore 5
    //   137: aload 5
    //   139: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: aload_3
    //   145: ifnull +17 -> 162
    //   148: aload_3
    //   149: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   152: goto +10 -> 162
    //   155: astore 7
    //   157: aload 7
    //   159: invokestatic 107	com/baidu/mobstat/g:b	(Ljava/lang/Throwable;)V
    //   162: aload 6
    //   164: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   49	54	57	java/lang/Exception
    //   30	44	97	finally
    //   30	44	105	java/lang/Exception
    //   17	30	113	finally
    //   120	125	113	finally
    //   17	30	118	java/lang/Exception
    //   129	133	135	java/lang/Exception
    //   148	152	155	java/lang/Exception
  }

  private boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = Settings.System.putString(this.b.getContentResolver(), paramString1, paramString2);
      return bool;
    }
    catch (Exception localException)
    {
      b(localException);
    }
    return false;
  }

  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null))
    {
      if (paramArrayOfString1.length != paramArrayOfString2.length)
        return false;
      HashSet localHashSet1 = new HashSet();
      int j = paramArrayOfString1.length;
      for (int k = 0; k < j; k++)
        localHashSet1.add(paramArrayOfString1[k]);
      HashSet localHashSet2 = new HashSet();
      int m = paramArrayOfString2.length;
      while (i < m)
      {
        localHashSet2.add(paramArrayOfString2[i]);
        i++;
      }
      return localHashSet1.equals(localHashSet2);
    }
    return false;
  }

  private static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }

  private String[] a(Signature[] paramArrayOfSignature)
  {
    String[] arrayOfString = new String[paramArrayOfSignature.length];
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString[i] = a(d.a(paramArrayOfSignature[i].toByteArray()));
    return arrayOfString;
  }

  private j b()
  {
    List localList1 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
    int i = 0;
    boolean bool1;
    int k;
    if ((localList1 != null) && (localList1.size() != 0))
    {
      i locali2 = (i)localList1.get(0);
      bool1 = locali2.c;
      if (!locali2.c)
        k = 0;
    }
    else
    {
      while (k < 3)
      {
        Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
        k++;
        continue;
        for (int j = 0; j < 3; j++)
          Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
        bool1 = false;
      }
    }
    File localFile1 = new File(this.b.getFilesDir(), "libcuid.so");
    Object localObject;
    if (localFile1.exists())
      localObject = j.a(f(a(localFile1)));
    else
      localObject = null;
    if (localObject == null)
    {
      this.c = (0x10 | this.c);
      List localList2 = a(new Intent("com.baidu.intent.action.GALAXY"), bool1);
      if (localList2 != null)
      {
        String str7 = "files";
        File localFile5 = this.b.getFilesDir();
        if (!str7.equals(localFile5.getName()))
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("fetal error:: app files dir name is unexpectedly :: ");
          localStringBuilder3.append(localFile5.getAbsolutePath());
          Log.e("DeviceId", localStringBuilder3.toString());
          str7 = localFile5.getName();
        }
        Iterator localIterator = localList2.iterator();
        do
        {
          File localFile6;
          do
          {
            i locali1;
            do
            {
              if (!localIterator.hasNext())
                break;
              locali1 = (i)localIterator.next();
            }
            while (locali1.d);
            localFile6 = new File(new File(locali1.a.dataDir, str7), "libcuid.so");
          }
          while (!localFile6.exists());
          localObject = j.a(f(a(localFile6)));
        }
        while (localObject == null);
      }
    }
    if (localObject == null)
      localObject = j.a(f(b("com.baidu.deviceid.v2")));
    boolean bool2 = c("android.permission.READ_EXTERNAL_STORAGE");
    if ((localObject == null) && (bool2))
    {
      this.c = (0x2 | this.c);
      localObject = e();
    }
    if (localObject == null)
    {
      this.c = (0x8 | this.c);
      localObject = d();
    }
    String str1;
    if ((localObject == null) && (bool2))
    {
      this.c = (0x1 | this.c);
      String str6 = h("");
      j localj = d(str6);
      i = 1;
      str1 = str6;
      localObject = localj;
    }
    else
    {
      str1 = null;
    }
    if (localObject == null)
    {
      this.c = (0x4 | this.c);
      if (i == 0)
        str1 = h("");
      localObject = new j(null);
      String str3 = b(this.b);
      String str4;
      if (Build.VERSION.SDK_INT < 23)
      {
        String str5 = UUID.randomUUID().toString();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str1);
        localStringBuilder2.append(str3);
        localStringBuilder2.append(str5);
        str4 = localStringBuilder2.toString();
      }
      else
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("com.baidu");
        localStringBuilder1.append(str3);
        str4 = localStringBuilder1.toString();
      }
      ((j)localObject).a = c.a(str4.getBytes(), true);
      ((j)localObject).b = str1;
    }
    File localFile2 = new File(this.b.getFilesDir(), "libcuid.so");
    String str2;
    if ((0x10 & this.c) == 0)
    {
      boolean bool5 = localFile2.exists();
      str2 = null;
      if (bool5);
    }
    else
    {
      boolean bool3 = TextUtils.isEmpty(null);
      str2 = null;
      if (bool3)
        str2 = e(((j)localObject).a());
      a(str2);
    }
    boolean bool4 = c();
    if ((bool4) && (((0x2 & this.c) != 0) || (TextUtils.isEmpty(b("com.baidu.deviceid.v2")))))
    {
      if (TextUtils.isEmpty(str2))
        str2 = e(((j)localObject).a());
      a("com.baidu.deviceid.v2", str2);
    }
    if (c("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      File localFile3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
      if (((0x8 & this.c) != 0) || (!localFile3.exists()))
      {
        if (TextUtils.isEmpty(str2))
          str2 = e(((j)localObject).a());
        g(str2);
      }
    }
    if ((bool4) && (((0x1 & this.c) != 0) || (TextUtils.isEmpty(b("com.baidu.deviceid")))))
    {
      a("com.baidu.deviceid", ((j)localObject).a);
      a("bd_setting_i", ((j)localObject).b);
    }
    if ((bool4) && (!TextUtils.isEmpty(((j)localObject).b)))
    {
      File localFile4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
      if (((0x2 & this.c) != 0) || (!localFile4.exists()))
        b(((j)localObject).b, ((j)localObject).a);
    }
    return localObject;
  }

  public static String b(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (TextUtils.isEmpty(str))
      str = "";
    return str;
  }

  private String b(String paramString)
  {
    try
    {
      String str = Settings.System.getString(this.b.getContentResolver(), paramString);
      return str;
    }
    catch (Exception localException)
    {
      b(localException);
    }
    return null;
  }

  private static void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append("=");
    localStringBuilder1.append(paramString2);
    File localFile1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    File localFile2 = new File(localFile1, ".cuid");
    try
    {
      if ((localFile1.exists()) && (!localFile1.isDirectory()))
      {
        Random localRandom = new Random();
        File localFile3 = localFile1.getParentFile();
        String str = localFile1.getName();
        File localFile4;
        do
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(str);
          localStringBuilder2.append(localRandom.nextInt());
          localStringBuilder2.append(".tmp");
          localFile4 = new File(localFile3, localStringBuilder2.toString());
        }
        while (localFile4.exists());
        localFile1.renameTo(localFile4);
        localFile4.delete();
      }
      localFile1.mkdirs();
      FileWriter localFileWriter = new FileWriter(localFile2, false);
      localFileWriter.write(b.a(a.a(a, a, localStringBuilder1.toString().getBytes()), "utf-8"));
      localFileWriter.flush();
      localFileWriter.close();
    }
    catch (IOException|Exception localIOException)
    {
    }
  }

  private static void b(Throwable paramThrowable)
  {
  }

  private static j c(Context paramContext)
  {
    if (e == null)
      try
      {
        if (e == null)
        {
          SystemClock.uptimeMillis();
          e = new g(paramContext).b();
          SystemClock.uptimeMillis();
        }
      }
      finally
      {
      }
    return e;
  }

  private boolean c()
  {
    return c("android.permission.WRITE_SETTINGS");
  }

  private boolean c(String paramString)
  {
    return this.b.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }

  private j d()
  {
    String str1 = b("com.baidu.deviceid");
    String str2 = b("bd_setting_i");
    if (TextUtils.isEmpty(str2))
    {
      str2 = h("");
      if (!TextUtils.isEmpty(str2))
        a("bd_setting_i", str2);
    }
    if (TextUtils.isEmpty(str1))
    {
      String str3 = b(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.baidu");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      str1 = b(c.a(localStringBuilder.toString().getBytes(), true));
    }
    if (!TextUtils.isEmpty(str1))
    {
      j localj = new j(null);
      localj.a = str1;
      localj.b = str2;
      return localj;
    }
    return null;
  }

  private j d(String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT < 23)
      i = 1;
    else
      i = 0;
    if ((i != 0) && (TextUtils.isEmpty(paramString)))
      return null;
    Object localObject = "";
    File localFile = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
    int j;
    if (localFile.exists())
    {
      j = 0;
    }
    else
    {
      localFile = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
      j = 1;
    }
    while (true)
    {
      String str2;
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = localBufferedReader.readLine();
        if (str1 != null)
        {
          localStringBuilder.append(str1);
          localStringBuilder.append("\r\n");
          continue;
        }
        localBufferedReader.close();
        String[] arrayOfString = new String(a.b(a, a, b.a(localStringBuilder.toString().getBytes()))).split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          if ((i != 0) && (paramString.equals(arrayOfString[0])))
          {
            str2 = arrayOfString[1];
            break label286;
          }
          if (i == 0)
          {
            if (TextUtils.isEmpty(paramString))
              paramString = arrayOfString[1];
            str2 = arrayOfString[1];
            break label286;
          }
        }
        if (j == 0)
          b(paramString, (String)localObject);
      }
      catch (FileNotFoundException|IOException|Exception localFileNotFoundException)
      {
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        j localj = new j(null);
        localj.a = ((String)localObject);
        localj.b = paramString;
        return localj;
      }
      return null;
      label286: localObject = str2;
    }
  }

  private j e()
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
    if (localFile.exists())
    {
      String str = a(localFile);
      if (!TextUtils.isEmpty(str))
        try
        {
          j localj = j.a(new String(a.b(a, a, b.a(str.getBytes()))));
          return localj;
        }
        catch (Exception localException)
        {
          com.a.a.a.a.a.a.a.a(localException);
        }
    }
    return null;
  }

  private static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      String str = b.a(a.a(a, a, paramString.getBytes()), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException|Exception localUnsupportedEncodingException)
    {
      b(localUnsupportedEncodingException);
    }
    return "";
  }

  private static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      String str = new String(a.b(a, a, b.a(paramString.getBytes())));
      return str;
    }
    catch (Exception localException)
    {
      b(localException);
    }
    return "";
  }

  private static void g(String paramString)
  {
    File localFile1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    File localFile2 = new File(localFile1, ".cuid2");
    try
    {
      if ((localFile1.exists()) && (!localFile1.isDirectory()))
      {
        Random localRandom = new Random();
        File localFile3 = localFile1.getParentFile();
        String str = localFile1.getName();
        File localFile4;
        do
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localRandom.nextInt());
          localStringBuilder.append(".tmp");
          localFile4 = new File(localFile3, localStringBuilder.toString());
        }
        while (localFile4.exists());
        localFile1.renameTo(localFile4);
        localFile4.delete();
      }
      localFile1.mkdirs();
      FileWriter localFileWriter = new FileWriter(localFile2, false);
      localFileWriter.write(paramString);
      localFileWriter.flush();
      localFileWriter.close();
    }
    catch (IOException|Exception localIOException)
    {
    }
  }

  private String h(String paramString)
  {
    Object localObject = null;
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
      localObject = null;
      if (localTelephonyManager != null)
      {
        String str2 = localTelephonyManager.getDeviceId();
        localObject = str2;
      }
    }
    catch (Exception localException)
    {
      Log.e("DeviceId", "Read IMEI failed", localException);
    }
    String str1 = i(localObject);
    if (TextUtils.isEmpty(str1))
      return paramString;
    return str1;
  }

  private static String i(String paramString)
  {
    if ((paramString != null) && (paramString.contains(":")))
      paramString = "";
    return paramString;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.g
 * JD-Core Version:    0.6.2
 */