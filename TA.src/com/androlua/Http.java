package com.androlua;

import android.util.Log;
import com.a.a.a.a.a.a.a;
import com.androlua.util.AsyncTaskX;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaString;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Http
{
  private static HashMap<String, String> a;

  private static String a(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("&");
    }
    if (!paramHashMap.isEmpty())
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private static byte[] a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString)
  {
    if (paramString == null)
      paramString = "UTF-8";
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Iterator localIterator1 = paramHashMap1.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      try
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = "----qwertyuiopasdfghjklzxcvbnm";
        arrayOfObject2[1] = localEntry2.getKey();
        arrayOfObject2[2] = localEntry2.getValue();
        localByteArrayOutputStream.write(String.format("--%s\r\nContent-Disposition:form-data;name=\"%s\"\r\n\r\n%s\r\n", arrayOfObject2).getBytes(paramString));
      }
      catch (IOException localIOException2)
      {
        a.a(localIOException2);
      }
    }
    Iterator localIterator2 = paramHashMap2.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      try
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = "----qwertyuiopasdfghjklzxcvbnm";
        arrayOfObject1[1] = localEntry1.getKey();
        arrayOfObject1[2] = localEntry1.getValue();
        localByteArrayOutputStream.write(String.format("--%s\r\nContent-Disposition:form-data;name=\"%s\";filename=\"%s\"\r\nContent-Type:application/octet-stream\r\n\r\n", arrayOfObject1).getBytes(paramString));
        localByteArrayOutputStream.write(LuaUtil.readAll(new FileInputStream((String)localEntry1.getValue())));
        localByteArrayOutputStream.write("\r\n".getBytes(paramString));
      }
      catch (IOException localIOException1)
      {
        a.a(localIOException1);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }

  public static HttpTask delete(String paramString, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString, "DELETE", null, null, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask delete(String paramString1, String paramString2, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString2.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString2)))
      localHttpTask = new HttpTask(paramString1, "DELETE", null, paramString2, null, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "DELETE", paramString2, null, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask delete(String paramString1, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "DELETE", paramString2, paramString3, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask delete(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "DELETE", paramString2, paramString3, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask delete(String paramString1, String paramString2, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString2.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString2)))
      localHttpTask = new HttpTask(paramString1, "DELETE", null, paramString2, paramHashMap, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "DELETE", paramString2, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask delete(String paramString, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString, "DELETE", null, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask download(String paramString1, String paramString2, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", null, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask download(String paramString1, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", paramString3, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask download(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", paramString3, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask download(String paramString1, String paramString2, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", null, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask get(String paramString, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString, "GET", null, null, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask get(String paramString1, String paramString2, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString2.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString2)))
      localHttpTask = new HttpTask(paramString1, "GET", null, paramString2, null, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "GET", paramString2, null, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask get(String paramString1, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", paramString2, paramString3, null, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask get(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "GET", paramString2, paramString3, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask get(String paramString1, String paramString2, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString2.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString2)))
      localHttpTask = new HttpTask(paramString1, "GET", null, paramString2, paramHashMap, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "GET", paramString2, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HttpTask get(String paramString, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString, "GET", null, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[0]);
    return localHttpTask;
  }

  public static HashMap<String, String> getHeader()
  {
    return a;
  }

  public static HttpTask post(String paramString1, String paramString2, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "POST", null, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString3.matches("[\\w\\-.:]+")) && (Charset.isSupported(paramString3)))
      localHttpTask = new HttpTask(paramString1, "POST", null, paramString3, null, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "POST", paramString3, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, String paramString2, String paramString3, String paramString4, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "POST", paramString3, paramString4, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "POST", paramString3, paramString4, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString3.matches("[\\w\\-.:]+")) && (Charset.isSupported(paramString3)))
      localHttpTask = new HttpTask(paramString1, "POST", null, paramString3, paramHashMap, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "POST", paramString3, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, String paramString2, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "POST", null, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask post(String paramString, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    return post(paramString, a(paramHashMap), paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap, String paramString2, LuaObject paramLuaObject)
  {
    return post(paramString1, a(paramHashMap), paramString2, paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    return post(paramString1, a(paramHashMap), paramString2, paramString3, paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, String paramString2, String paramString3, HashMap<String, String> paramHashMap2, LuaObject paramLuaObject)
  {
    return post(paramString1, a(paramHashMap1), paramString2, paramString3, paramHashMap2, paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, String paramString2, HashMap<String, String> paramHashMap2, LuaObject paramLuaObject)
  {
    return post(paramString1, a(paramHashMap1), paramString2, paramHashMap2, paramLuaObject);
  }

  public static HttpTask post(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, LuaObject paramLuaObject)
  {
    return post(paramString, paramHashMap1, paramHashMap2, null, null, null, paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2, LuaObject paramLuaObject)
  {
    return post(paramString1, paramHashMap1, paramHashMap2, paramString2, new HashMap(), paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    return post(paramString1, paramHashMap1, paramHashMap2, paramString2, paramString3, null, paramLuaObject);
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2, String paramString3, HashMap<String, String> paramHashMap3, LuaObject paramLuaObject)
  {
    if (paramHashMap3 == null)
      paramHashMap3 = new HashMap();
    HashMap<String, String> localHashMap = paramHashMap3;
    localHashMap.put("Content-Type", "multipart/form-data;boundary=----qwertyuiopasdfghjklzxcvbnm");
    HttpTask localHttpTask = new HttpTask(paramString1, "POST", paramString2, paramString3, localHashMap, paramLuaObject);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a(paramHashMap1, paramHashMap2, paramString3);
    localHttpTask.execute(arrayOfObject);
    return localHttpTask;
  }

  public static HttpTask post(String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2, HashMap<String, String> paramHashMap3, LuaObject paramLuaObject)
  {
    if ((paramString2.matches("[\\w\\-.:]+")) && (Charset.isSupported(paramString2)))
      return post(paramString1, paramHashMap1, paramHashMap2, paramString2, null, paramHashMap3, paramLuaObject);
    return post(paramString1, paramHashMap1, paramHashMap2, null, paramString2, paramHashMap3, paramLuaObject);
  }

  public static HttpTask post(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, HashMap<String, String> paramHashMap3, LuaObject paramLuaObject)
  {
    return post(paramString, paramHashMap1, paramHashMap2, null, paramHashMap3, paramLuaObject);
  }

  public static HttpTask put(String paramString1, String paramString2, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "PUT", null, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask put(String paramString1, String paramString2, String paramString3, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString3.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString3)))
      localHttpTask = new HttpTask(paramString1, "PUT", null, paramString3, null, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "PUT", paramString3, null, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask put(String paramString1, String paramString2, String paramString3, String paramString4, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "PUT", paramString3, paramString4, null, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask put(String paramString1, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "PUT", paramString3, paramString4, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask put(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask;
    if ((paramString3.matches("[\\w\\-\\.:]+")) && (Charset.isSupported(paramString3)))
      localHttpTask = new HttpTask(paramString1, "PUT", null, paramString3, paramHashMap, paramLuaObject);
    else
      localHttpTask = new HttpTask(paramString1, "PUT", paramString3, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static HttpTask put(String paramString1, String paramString2, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
  {
    HttpTask localHttpTask = new HttpTask(paramString1, "PUT", null, null, paramHashMap, paramLuaObject);
    localHttpTask.execute(new Object[] { paramString2 });
    return localHttpTask;
  }

  public static void setHeader(HashMap<String, String> paramHashMap)
  {
    a = paramHashMap;
  }

  public static void setUserAgent(String paramString)
  {
    if (a == null)
      a = new HashMap();
    a.put("User-Agent", paramString);
  }

  public static class HttpTask extends AsyncTaskX<Object, Object, Object>
  {
    private String a;
    private LuaObject b;
    private byte[] c;
    private String d;
    private String e;
    private String f;
    private HashMap<String, String> g;
    private String h;

    public HttpTask(String paramString1, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, LuaObject paramLuaObject)
    {
      this.a = paramString1;
      this.h = paramString2;
      this.f = paramString3;
      this.d = paramString4;
      this.e = paramString4;
      this.g = paramHashMap;
      this.b = paramLuaObject;
    }

    private byte[] a(Map<String, String> paramMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("&");
      }
      return localStringBuilder.toString().getBytes(this.d);
    }

    private byte[] d(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length == 1)
      {
        Object localObject = paramArrayOfObject[0];
        if ((localObject instanceof String))
          return ((String)localObject).getBytes(this.d);
        if (localObject.getClass().getComponentType() == Byte.TYPE)
          return (byte[])localObject;
        if ((localObject instanceof File))
          return LuaUtil.readAll(new FileInputStream((File)localObject));
        if ((localObject instanceof Map))
          return a((Map)localObject);
      }
      return null;
    }

    protected Object a(Object[] paramArrayOfObject)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
        localHttpURLConnection.setConnectTimeout(6000);
        HttpURLConnection.setFollowRedirects(true);
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.5");
        if (this.d == null)
          this.d = "UTF-8";
        localHttpURLConnection.setRequestProperty("Accept-Charset", this.d);
        if (this.f != null)
          localHttpURLConnection.setRequestProperty("Cookie", this.f);
        if (Http.a() != null)
        {
          Iterator localIterator4 = Http.a().entrySet().iterator();
          while (localIterator4.hasNext())
          {
            Map.Entry localEntry2 = (Map.Entry)localIterator4.next();
            localHttpURLConnection.setRequestProperty((String)localEntry2.getKey(), (String)localEntry2.getValue());
          }
        }
        if (this.g != null)
        {
          Iterator localIterator3 = this.g.entrySet().iterator();
          while (localIterator3.hasNext())
          {
            Map.Entry localEntry1 = (Map.Entry)localIterator3.next();
            localHttpURLConnection.setRequestProperty((String)localEntry1.getKey(), (String)localEntry1.getValue());
          }
        }
        if (this.h != null)
          localHttpURLConnection.setRequestMethod(this.h);
        if ((!"GET".equals(this.h)) && (paramArrayOfObject.length != 0))
        {
          this.c = d(paramArrayOfObject);
          localHttpURLConnection.setDoOutput(true);
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("");
          localStringBuilder3.append(this.c.length);
          localHttpURLConnection.setRequestProperty("Content-length", localStringBuilder3.toString());
        }
        localHttpURLConnection.connect();
        if (("GET".equals(this.h)) && (paramArrayOfObject.length != 0))
        {
          File localFile = new File((String)paramArrayOfObject[0]);
          if (!localFile.getParentFile().exists())
            localFile.getParentFile().mkdirs();
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
          LuaUtil.copyFile(localHttpURLConnection.getInputStream(), localFileOutputStream);
          Object[] arrayOfObject4 = new Object[3];
          arrayOfObject4[0] = Integer.valueOf(localHttpURLConnection.getResponseCode());
          arrayOfObject4[1] = paramArrayOfObject[0];
          arrayOfObject4[2] = localHttpURLConnection.getHeaderFields();
          return arrayOfObject4;
        }
        if (paramArrayOfObject.length != 0)
          localHttpURLConnection.getOutputStream().write(this.c);
        int i = localHttpURLConnection.getResponseCode();
        Map localMap = localHttpURLConnection.getHeaderFields();
        localHttpURLConnection.getContentEncoding();
        List localList1 = (List)localMap.get("Set-Cookie");
        StringBuilder localStringBuilder1 = new StringBuilder();
        if (localList1 != null)
        {
          Iterator localIterator1 = localList1.iterator();
          while (localIterator1.hasNext())
          {
            localStringBuilder1.append((String)localIterator1.next());
            localStringBuilder1.append(";");
          }
        }
        List localList2 = (List)localMap.get("Content-Type");
        if (localList2 != null)
        {
          Iterator localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            String str4 = (String)localIterator2.next();
            int j = str4.indexOf("charset");
            if (j != -1)
            {
              int k = str4.indexOf("=", j);
              if (k != -1)
              {
                int m = str4.indexOf(";", k);
                if (m == -1)
                  m = str4.length();
                this.d = str4.substring(k + 1, m);
              }
            }
          }
        }
        String str1 = this.e;
        if (str1 == null)
          try
          {
            InputStream localInputStream3 = localHttpURLConnection.getInputStream();
            byte[] arrayOfByte = LuaUtil.readAll(localInputStream3);
            localInputStream3.close();
            LuaString localLuaString = new LuaString(arrayOfByte);
            Object[] arrayOfObject3 = new Object[4];
            arrayOfObject3[0] = Integer.valueOf(i);
            arrayOfObject3[1] = localLuaString;
            arrayOfObject3[2] = localStringBuilder1.toString();
            arrayOfObject3[3] = localMap;
            return arrayOfObject3;
          }
          catch (Exception localException3)
          {
            a.a(localException3);
          }
        StringBuilder localStringBuilder2 = new StringBuilder();
        try
        {
          InputStream localInputStream2 = localHttpURLConnection.getInputStream();
          BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader(localInputStream2, this.d));
          while (true)
          {
            String str3 = localBufferedReader2.readLine();
            if ((str3 == null) || (isCancelled()))
              break;
            localStringBuilder2.append(str3);
            localStringBuilder2.append('\n');
          }
          localInputStream2.close();
        }
        catch (Exception localException2)
        {
          a.a(localException2);
        }
        InputStream localInputStream1 = localHttpURLConnection.getErrorStream();
        if (localInputStream1 != null)
        {
          BufferedReader localBufferedReader1 = new BufferedReader(new InputStreamReader(localInputStream1, this.d));
          while (true)
          {
            String str2 = localBufferedReader1.readLine();
            if ((str2 == null) || (isCancelled()))
              break;
            localStringBuilder2.append(str2);
            localStringBuilder2.append('\n');
          }
          localInputStream1.close();
        }
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = Integer.valueOf(i);
        arrayOfObject2[1] = new String(localStringBuilder2);
        arrayOfObject2[2] = localStringBuilder1.toString();
        arrayOfObject2[3] = localMap;
        return arrayOfObject2;
      }
      catch (Exception localException1)
      {
        a.a(localException1);
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Integer.valueOf(-1);
        arrayOfObject1[1] = localException1.getMessage();
        return arrayOfObject1;
      }
    }

    protected void a(Object paramObject)
    {
      if (isCancelled())
        return;
      try
      {
        this.b.call((Object[])paramObject);
        return;
      }
      catch (LuaException localLuaException1)
      {
        try
        {
          LuaObject localLuaObject = this.b.getLuaState().getLuaObject("print");
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localLuaException1.getMessage();
          localLuaObject.call(arrayOfObject);
        }
        catch (LuaException localLuaException2)
        {
        }
        Log.i("lua", localLuaException1.getMessage());
      }
    }

    public boolean cancel()
    {
      return super.cancel(true);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.Http
 * JD-Core Version:    0.6.2
 */