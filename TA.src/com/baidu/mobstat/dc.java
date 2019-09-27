package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class dc
{
  private static String a;
  private static String b;
  private static final Pattern c = Pattern.compile("\\s*|\t|\r|\n");

  // ERROR //
  public static String a()
  {
    // Byte code:
    //   0: new 28	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuffer:<init>	()V
    //   7: astore_0
    //   8: bipush 20
    //   10: newarray char
    //   12: astore 6
    //   14: new 33	java/io/InputStreamReader
    //   17: dup
    //   18: new 35	java/io/FileInputStream
    //   21: dup
    //   22: ldc 37
    //   24: invokespecial 40	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 43	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload 6
    //   34: invokevirtual 49	java/io/Reader:read	([C)I
    //   37: istore 7
    //   39: iload 7
    //   41: iconst_m1
    //   42: if_icmpeq +65 -> 107
    //   45: iload 7
    //   47: aload 6
    //   49: arraylength
    //   50: if_icmpne +151 -> 201
    //   53: aload 6
    //   55: iconst_m1
    //   56: aload 6
    //   58: arraylength
    //   59: iadd
    //   60: caload
    //   61: bipush 13
    //   63: if_icmpeq +138 -> 201
    //   66: getstatic 55	java/lang/System:out	Ljava/io/PrintStream;
    //   69: aload 6
    //   71: invokevirtual 61	java/io/PrintStream:print	([C)V
    //   74: goto -43 -> 31
    //   77: iload 8
    //   79: iload 7
    //   81: if_icmpge -50 -> 31
    //   84: aload 6
    //   86: iload 8
    //   88: caload
    //   89: bipush 13
    //   91: if_icmpeq +116 -> 207
    //   94: aload_0
    //   95: aload 6
    //   97: iload 8
    //   99: caload
    //   100: invokevirtual 65	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   103: pop
    //   104: goto +103 -> 207
    //   107: aload_0
    //   108: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   111: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
    //   114: ldc 75
    //   116: ldc 77
    //   118: invokevirtual 81	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 10
    //   123: aload_2
    //   124: ifnull +17 -> 141
    //   127: aload_2
    //   128: invokevirtual 84	java/io/Reader:close	()V
    //   131: aload 10
    //   133: areturn
    //   134: astore 11
    //   136: aload 11
    //   138: invokestatic 89	com/baidu/mobstat/cz:a	(Ljava/lang/Throwable;)V
    //   141: aload 10
    //   143: areturn
    //   144: astore_1
    //   145: goto +12 -> 157
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_2
    //   151: goto +30 -> 181
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_1
    //   158: invokestatic 89	com/baidu/mobstat/cz:a	(Ljava/lang/Throwable;)V
    //   161: aload_2
    //   162: ifnull +16 -> 178
    //   165: aload_2
    //   166: invokevirtual 84	java/io/Reader:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore 5
    //   173: aload 5
    //   175: invokestatic 89	com/baidu/mobstat/cz:a	(Ljava/lang/Throwable;)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_3
    //   181: aload_2
    //   182: ifnull +17 -> 199
    //   185: aload_2
    //   186: invokevirtual 84	java/io/Reader:close	()V
    //   189: goto +10 -> 199
    //   192: astore 4
    //   194: aload 4
    //   196: invokestatic 89	com/baidu/mobstat/cz:a	(Ljava/lang/Throwable;)V
    //   199: aload_3
    //   200: athrow
    //   201: iconst_0
    //   202: istore 8
    //   204: goto -127 -> 77
    //   207: iinc 8 1
    //   210: goto -133 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   127	131	134	java/io/IOException
    //   31	39	144	java/lang/Exception
    //   45	74	144	java/lang/Exception
    //   84	104	144	java/lang/Exception
    //   107	123	144	java/lang/Exception
    //   8	31	148	finally
    //   8	31	154	java/lang/Exception
    //   165	169	171	java/io/IOException
    //   31	39	180	finally
    //   45	74	180	finally
    //   84	104	180	finally
    //   107	123	180	finally
    //   157	161	180	finally
    //   185	189	192	java/io/IOException
  }

  private static String a(byte paramByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("00");
    localStringBuilder.append(Integer.toHexString(paramByte));
    localStringBuilder.append(":");
    String str = localStringBuilder.toString();
    return str.substring(-3 + str.length());
  }

  public static String a(int paramInt, Context paramContext)
  {
    try
    {
      String str = cr.c(paramInt, a(paramContext).getBytes());
      return str;
    }
    catch (Exception localException)
    {
      cz.a(localException);
    }
    return "";
  }

  public static String a(Context paramContext)
  {
    String str = de.a(paramContext);
    return c.matcher(str).replaceAll("");
  }

  public static String a(Context paramContext, int paramInt)
  {
    String str = u(paramContext);
    if (TextUtils.isEmpty(str))
      return "";
    return cr.c(paramInt, str.getBytes());
  }

  public static String a(Context paramContext, String paramString)
  {
    String str = "";
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        Bundle localBundle = localApplicationInfo.metaData;
        Object localObject = null;
        if (localBundle != null)
          localObject = localApplicationInfo.metaData.get(paramString);
        if (localObject == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("null,can't find information for key:");
          localStringBuilder.append(paramString);
          cz.a(localStringBuilder.toString());
          return str;
        }
        str = localObject.toString();
      }
    }
    catch (Exception localException)
    {
    }
    return str;
  }

  public static int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    DisplayMetrics localDisplayMetrics2;
    try
    {
      localDisplayMetrics2 = d(paramContext);
    }
    catch (Exception localException)
    {
      cz.a(localException);
      localDisplayMetrics2 = localDisplayMetrics1;
    }
    return localDisplayMetrics2.widthPixels;
  }

  @TargetApi(9)
  private static String b()
  {
    if (Build.VERSION.SDK_INT < 9)
      return "";
    try
    {
      Iterator localIterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (localIterator.hasNext())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localIterator.next();
        if (localNetworkInterface.getName().equalsIgnoreCase("wlan0"))
        {
          byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
          if (arrayOfByte == null)
            return "";
          StringBuilder localStringBuilder = new StringBuilder();
          int i = arrayOfByte.length;
          for (int j = 0; j < i; j++)
          {
            byte b1 = arrayOfByte[j];
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Byte.valueOf(b1);
            localStringBuilder.append(String.format("%02x:", arrayOfObject));
          }
          if (localStringBuilder.length() > 0)
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          String str = localStringBuilder.toString();
          return str;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      cz.b(localThrowable);
    }
    return "";
  }

  public static String b(int paramInt, Context paramContext)
  {
    String str = j(paramContext);
    if (TextUtils.isEmpty(str))
      return "";
    return cr.c(paramInt, str.getBytes());
  }

  private static String b(Context paramContext, String paramString)
  {
    if (paramString == null)
      return null;
    int i = paramString.lastIndexOf(':');
    String str = null;
    if (i > 0)
    {
      int j = i + 1;
      int k = paramString.length();
      str = null;
      if (j < k)
        str = paramString.substring(j);
    }
    return str;
  }

  public static int c(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    DisplayMetrics localDisplayMetrics2;
    try
    {
      localDisplayMetrics2 = d(paramContext);
    }
    catch (Exception localException)
    {
      cz.a(localException);
      localDisplayMetrics2 = localDisplayMetrics1;
    }
    return localDisplayMetrics2.heightPixels;
  }

  public static String c(int paramInt, Context paramContext)
  {
    String str1 = d(paramInt, paramContext);
    String str2;
    if (!TextUtils.isEmpty(str1))
      str2 = cr.c(paramInt, str1.getBytes());
    else
      str2 = null;
    if (TextUtils.isEmpty(str2))
      str2 = "";
    return str2;
  }

  private static String c(Context paramContext, String paramString)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if (localApplicationInfo == null)
      return null;
    String str = localApplicationInfo.processName;
    if ((str != null) && (!str.equals(paramString)))
      return paramString;
    return null;
  }

  public static DisplayMetrics d(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static String d(int paramInt, Context paramContext)
  {
    String str = a();
    if (TextUtils.isEmpty(str))
      str = e(paramInt, paramContext);
    if (TextUtils.isEmpty(str))
      str = "";
    return str;
  }

  // ERROR //
  public static int e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 154	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 157	android/content/Context:getPackageName	()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_1
    //   11: aload_2
    //   12: iconst_0
    //   13: invokevirtual 313	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: getfield 318	android/content/pm/PackageInfo:versionCode	I
    //   19: istore_3
    //   20: iload_3
    //   21: ireturn
    //   22: ldc_w 320
    //   25: invokestatic 322	com/baidu/mobstat/cz:b	(Ljava/lang/String;)V
    //   28: iconst_1
    //   29: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	20	22	java/lang/Exception
  }

  @SuppressLint({"NewApi"})
  public static String e(int paramInt, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = null;
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      while (true)
      {
        if (!localEnumeration1.hasMoreElements())
          break label138;
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration1.nextElement();
        Enumeration localEnumeration2 = localNetworkInterface.getInetAddresses();
        InetAddress localInetAddress;
        while (localEnumeration2.hasMoreElements())
        {
          localInetAddress = (InetAddress)localEnumeration2.nextElement();
          if ((!localInetAddress.isAnyLocalAddress()) && ((localInetAddress instanceof Inet4Address)) && (!localInetAddress.isLoopbackAddress()))
          {
            if (!localInetAddress.isSiteLocalAddress())
              break label110;
            localObject = localNetworkInterface.getHardwareAddress();
          }
        }
        continue;
        label110: if (localInetAddress.isLinkLocalAddress())
          break;
        byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
        localObject = arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      cz.a(localException);
      label138: if (localObject != null)
      {
        for (int i = 0; i < localObject.length; i++)
          localStringBuffer.append(a(localObject[i]));
        return localStringBuffer.substring(0, -1 + localStringBuffer.length()).replaceAll(":", "");
      }
      String str = b(paramInt, paramContext);
      if (str != null)
        str = str.replaceAll(":", "");
      return str;
    }
  }

  public static String f(int paramInt, Context paramContext)
  {
    String str = k(paramContext);
    if (TextUtils.isEmpty(str))
      return "";
    return cr.c(paramInt, str.getBytes());
  }

  // ERROR //
  public static String f(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 154	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 157	android/content/Context:getPackageName	()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_1
    //   11: aload_2
    //   12: iconst_0
    //   13: invokevirtual 313	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: getfield 371	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: areturn
    //   22: ldc_w 373
    //   25: invokestatic 322	com/baidu/mobstat/cz:b	(Ljava/lang/String;)V
    //   28: ldc 77
    //   30: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	20	22	android/content/pm/PackageManager$NameNotFoundException
  }

  public static String g(int paramInt, Context paramContext)
  {
    String str = m(paramContext);
    if (TextUtils.isEmpty(str))
      return "";
    return cr.d(paramInt, str.getBytes());
  }

  public static String g(Context paramContext)
  {
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(0);
    arrayOfObject1[1] = Integer.valueOf(0);
    arrayOfObject1[2] = Integer.valueOf(0);
    String str1 = String.format("%s_%s_%s", arrayOfObject1);
    try
    {
      if ((cs.e(paramContext, "android.permission.ACCESS_FINE_LOCATION")) || (cs.e(paramContext, "android.permission.ACCESS_COARSE_LOCATION")))
      {
        CellLocation localCellLocation = ((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCellLocation);
        localStringBuilder.append("");
        cz.a(localStringBuilder.toString());
        if (localCellLocation == null)
          return str1;
        if ((localCellLocation instanceof GsmCellLocation))
        {
          GsmCellLocation localGsmCellLocation = (GsmCellLocation)localCellLocation;
          Object[] arrayOfObject3 = new Object[3];
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = Integer.valueOf(localGsmCellLocation.getCid());
          arrayOfObject3[0] = String.format("%d", arrayOfObject4);
          Object[] arrayOfObject5 = new Object[1];
          arrayOfObject5[0] = Integer.valueOf(localGsmCellLocation.getLac());
          arrayOfObject3[1] = String.format("%d", arrayOfObject5);
          arrayOfObject3[2] = Integer.valueOf(0);
          return String.format("%s_%s_%s", arrayOfObject3);
        }
        String[] arrayOfString = localCellLocation.toString().replace("[", "").replace("]", "").split(",");
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = arrayOfString[0];
        arrayOfObject2[1] = arrayOfString[3];
        arrayOfObject2[2] = arrayOfString[4];
        String str2 = String.format("%s_%s_%s", arrayOfObject2);
        return str2;
      }
    }
    catch (Exception localException)
    {
      cz.a("Get Location", localException);
    }
    return str1;
  }

  public static String h(int paramInt, Context paramContext)
  {
    String str1 = p(paramContext);
    if (!TextUtils.isEmpty(str1))
      try
      {
        String str2 = cr.c(paramInt, str1.getBytes());
        return str2;
      }
      catch (Exception localException)
      {
        cz.b(localException);
      }
    return "";
  }

  public static String h(Context paramContext)
  {
    try
    {
      if (cs.e(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        Location localLocation = ((LocationManager)paramContext.getSystemService("location")).getLastKnownLocation("gps");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("location: ");
        localStringBuilder.append(localLocation);
        cz.b(localStringBuilder.toString());
        if (localLocation != null)
        {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Long.valueOf(localLocation.getTime());
          arrayOfObject[1] = Double.valueOf(localLocation.getLongitude());
          arrayOfObject[2] = Double.valueOf(localLocation.getLatitude());
          String str = String.format("%s_%s_%s", arrayOfObject);
          return str;
        }
      }
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  public static String i(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23)
      return j(paramContext);
    return b();
  }

  public static String j(Context paramContext)
  {
    try
    {
      if (cs.e(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      {
        WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (localWifiInfo != null)
        {
          String str = localWifiInfo.getMacAddress();
          if (!TextUtils.isEmpty(str))
            return str;
        }
      }
      else
      {
        cz.c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add: android.permission.ACCESS_WIFI_STATE");
      }
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  @SuppressLint({"NewApi"})
  public static String k(Context paramContext)
  {
    String str1 = Build.BRAND;
    if (("4.1.1".equals(Build.VERSION.RELEASE)) && ("TCT".equals(str1)))
      return "";
    try
    {
      if (cs.e(paramContext, "android.permission.BLUETOOTH"))
      {
        BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (localBluetoothAdapter != null)
        {
          String str2 = localBluetoothAdapter.getAddress();
          if (str2 != null)
            return str2;
        }
      }
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  public static String l(Context paramContext)
  {
    String str = m(paramContext);
    if (TextUtils.isEmpty(str))
      return "";
    return cq.a(str.getBytes());
  }

  public static String m(Context paramContext)
  {
    if (paramContext == null)
      return "";
    if (!cs.e(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      return "";
    boolean bool;
    try
    {
      if (cs.e(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
        bool = ((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps");
      else
        bool = false;
    }
    catch (Exception localException1)
    {
      while (true)
        cz.a(localException1);
    }
    WifiInfo localWifiInfo;
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      localWifiInfo = localWifiManager.getConnectionInfo();
      try
      {
        localList = localWifiManager.getScanResults();
      }
      catch (Throwable localThrowable1)
      {
      }
    }
    catch (Throwable localThrowable2)
    {
      localWifiInfo = null;
    }
    cz.a(localThrowable2);
    List localList = null;
    if ((localList != null) && (localList.size() != 0))
      Collections.sort(localList, new dd());
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int j = 1;
    if ((localList != null) && (i < localList.size()) && (i < 30));
    while (true)
    {
      try
      {
        ScanResult localScanResult = (ScanResult)localList.get(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localScanResult.BSSID);
        localStringBuilder2.append("|");
        String str2 = localScanResult.SSID.replaceAll("\\|", "");
        if (str2.length() > 30)
          str2 = str2.substring(0, 30);
        localStringBuilder2.append(str2);
        localStringBuilder2.append("|");
        localStringBuilder2.append(localScanResult.level);
        localStringBuilder2.append("|");
        if ((localWifiInfo == null) || (!localScanResult.BSSID.equals(localWifiInfo.getBSSID())))
          break label475;
        localStringBuilder2.append(j);
        localJSONArray.put(localStringBuilder2.toString());
      }
      catch (Exception localException3)
      {
        cz.a(localException3);
      }
      i++;
      break;
      if (localJSONArray.length() == 0)
        return null;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(System.currentTimeMillis());
        localStringBuilder1.append("|");
        int k = 0;
        if (bool)
          k = 1;
        localStringBuilder1.append(k);
        localStringBuilder1.append("|");
        localStringBuilder1.append(h(paramContext));
        localJSONObject.put("ap-list", localJSONArray);
        localJSONObject.put("meta-data", localStringBuilder1.toString());
        String str1 = localJSONObject.toString();
        return str1;
      }
      catch (Exception localException2)
      {
        cz.a(localException2);
        return "";
      }
      label475: j = 0;
    }
  }

  public static boolean n(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
        if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
        {
          boolean bool = localNetworkInfo.isConnected();
          if (bool)
            return true;
        }
      }
      catch (Exception localException)
      {
        cz.a(localException);
      }
    return false;
  }

  public static String o(Context paramContext)
  {
    Object localObject = "";
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
        break label69;
      String str1 = localNetworkInfo.getTypeName();
      try
      {
        if ((!str1.equals("WIFI")) && (localNetworkInfo.getSubtypeName() != null))
        {
          String str2 = localNetworkInfo.getSubtypeName();
          return str2;
        }
        return str1;
      }
      catch (Exception localException1)
      {
        localObject = str1;
      }
    }
    catch (Exception localException2)
    {
    }
    cz.a(localException2);
    label69: return localObject;
  }

  public static String p(Context paramContext)
  {
    if (paramContext != null)
      return paramContext.getPackageName();
    return "";
  }

  public static String q(Context paramContext)
  {
    Object localObject = b;
    if (localObject == null)
    {
      String str1 = v(paramContext);
      String str2 = b(paramContext, str1);
      if (TextUtils.isEmpty(str2))
        str2 = c(paramContext, str1);
      if (str2 == null)
        localObject = "";
      else
        localObject = str2;
      b = (String)localObject;
    }
    return localObject;
  }

  // ERROR //
  public static String r(Context paramContext)
  {
    // Byte code:
    //   0: ldc 77
    //   2: astore_1
    //   3: aload_0
    //   4: invokestatic 628	com/baidu/mobstat/dc:v	(Landroid/content/Context;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull +5 -> 14
    //   12: aload_1
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 154	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: invokevirtual 157	android/content/Context:getPackageName	()Ljava/lang/String;
    //   24: iconst_4
    //   25: invokevirtual 313	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: astore 4
    //   30: goto +6 -> 36
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +5 -> 43
    //   41: aload_1
    //   42: areturn
    //   43: aload 4
    //   45: getfield 637	android/content/pm/PackageInfo:services	[Landroid/content/pm/ServiceInfo;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnonnull +5 -> 57
    //   55: aload_1
    //   56: areturn
    //   57: aload 5
    //   59: arraylength
    //   60: istore 6
    //   62: iconst_0
    //   63: istore 7
    //   65: iload 7
    //   67: iload 6
    //   69: if_icmpge +37 -> 106
    //   72: aload 5
    //   74: iload 7
    //   76: aaload
    //   77: astore 8
    //   79: aload_2
    //   80: aload 8
    //   82: getfield 640	android/content/pm/ServiceInfo:processName	Ljava/lang/String;
    //   85: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +12 -> 100
    //   91: aload 8
    //   93: getfield 643	android/content/pm/ServiceInfo:name	Ljava/lang/String;
    //   96: astore_1
    //   97: goto +9 -> 106
    //   100: iinc 7 1
    //   103: goto -38 -> 65
    //   106: aload_1
    //   107: ifnonnull +6 -> 113
    //   110: ldc 77
    //   112: astore_1
    //   113: aload_1
    //   114: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   19	30	33	android/content/pm/PackageManager$NameNotFoundException
  }

  public static boolean s(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        if (bool)
          return true;
      }
      catch (Exception localException)
      {
        cz.b(localException);
      }
    return false;
  }

  public static String t(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("m", localMemoryInfo.availMem);
      localJSONObject1.put("l", localMemoryInfo.lowMemory);
      localJSONObject1.put("t", localMemoryInfo.threshold);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("app_mem", localJSONArray);
      localJSONObject2.put("meta-data", localStringBuilder.toString());
      String str = cq.a(localJSONObject2.toString().getBytes());
      return str;
    }
    catch (Exception localException)
    {
      cz.a(localException);
    }
    return "";
  }

  private static String u(Context paramContext)
  {
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null)
      {
        String str = localBluetoothAdapter.getName();
        if (str != null)
          return str;
      }
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  private static String v(Context paramContext)
  {
    Object localObject = a;
    if (localObject == null)
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        for (int i = 0; (localList != null) && (i < localList.size()); i++)
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localList.get(i);
          if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.pid == Process.myPid()))
          {
            String str = localRunningAppProcessInfo.processName;
            localObject = str;
            break;
          }
        }
      }
      catch (Exception localException)
      {
        cz.b(localException);
        if (localObject == null)
          localObject = "";
        a = (String)localObject;
      }
    return localObject;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.dc
 * JD-Core Version:    0.6.2
 */