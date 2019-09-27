package android.content;

import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider
{
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, PathStrategy> sCache = new HashMap();
  private PathStrategy mStrategy;

  private static File buildPath(File paramFile, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (str != null)
        paramFile = new File(paramFile, str);
    }
    return paramFile;
  }

  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }

  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }

  public static File[] getExternalCacheDirs(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramContext.getExternalCacheDirs();
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramContext.getExternalCacheDir();
    return arrayOfFile;
  }

  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramContext.getExternalFilesDirs(paramString);
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramContext.getExternalFilesDir(paramString);
    return arrayOfFile;
  }

  private static PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    synchronized (sCache)
    {
      PathStrategy localPathStrategy = (PathStrategy)sCache.get(paramString);
      if (localPathStrategy == null)
        try
        {
          localPathStrategy = parsePathStrategy(paramContext, paramString);
          sCache.put(paramString, localPathStrategy);
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localXmlPullParserException);
        }
        catch (IOException localIOException)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localIOException);
        }
      return localPathStrategy;
    }
  }

  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }

  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString))
      return 268435456;
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString))
        return 704643072;
      if ("rw".equals(paramString))
        return 939524096;
      if (!"rwt".equals(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid mode: ");
        localStringBuilder.append(paramString);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return 1006632960;
    }
    return 738197504;
  }

  private static PathStrategy parsePathStrategy(Context paramContext, String paramString)
  {
    SimplePathStrategy localSimplePathStrategy = new SimplePathStrategy(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null)
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    while (true)
    {
      int i = localXmlResourceParser.next();
      if (i == 1)
        break;
      if (i == 2)
      {
        String str1 = localXmlResourceParser.getName();
        String str2 = (String)null;
        String str3 = localXmlResourceParser.getAttributeValue(str2, "name");
        String str4 = localXmlResourceParser.getAttributeValue(str2, "path");
        File localFile;
        if ("root-path".equals(str1))
        {
          localFile = DEVICE_ROOT;
        }
        else if ("files-path".equals(str1))
        {
          localFile = paramContext.getFilesDir();
        }
        else if ("cache-path".equals(str1))
        {
          localFile = paramContext.getCacheDir();
        }
        else if ("external-path".equals(str1))
        {
          localFile = Environment.getExternalStorageDirectory();
        }
        else if ("external-files-path".equals(str1))
        {
          File[] arrayOfFile3 = getExternalFilesDirs(paramContext, str2);
          int n = arrayOfFile3.length;
          localFile = null;
          if (n > 0)
            localFile = arrayOfFile3[0];
        }
        else if ("external-cache-path".equals(str1))
        {
          File[] arrayOfFile2 = getExternalCacheDirs(paramContext);
          int m = arrayOfFile2.length;
          localFile = null;
          if (m > 0)
            localFile = arrayOfFile2[0];
        }
        else
        {
          int j = Build.VERSION.SDK_INT;
          localFile = null;
          if (j >= 21)
          {
            boolean bool = "external-media-path".equals(str1);
            localFile = null;
            if (bool)
            {
              File[] arrayOfFile1 = paramContext.getExternalMediaDirs();
              int k = arrayOfFile1.length;
              localFile = null;
              if (k > 0)
                localFile = arrayOfFile1[0];
            }
          }
        }
        if (localFile != null)
          localSimplePathStrategy.addRoot(str3, buildPath(localFile, new String[] { str4 }));
      }
    }
    return localSimplePathStrategy;
  }

  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported)
      throw new SecurityException("Provider must not be exported");
    if (!paramProviderInfo.grantUriPermissions)
      throw new SecurityException("Provider must grant uri permissions");
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return this.mStrategy.getFileForUri(paramUri).delete();
  }

  public String getType(Uri paramUri)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    int i = localFile.getName().lastIndexOf('.');
    if (i >= 0)
    {
      String str1 = localFile.getName().substring(i + 1);
      String str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
      if (str2 != null)
        return str2;
    }
    return "application/octet-stream";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }

  public boolean onCreate()
  {
    return true;
  }

  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    if (paramArrayOfString1 == null)
      paramArrayOfString1 = COLUMNS;
    String[] arrayOfString1 = new String[paramArrayOfString1.length];
    Object[] arrayOfObject1 = new Object[paramArrayOfString1.length];
    int i = paramArrayOfString1.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = paramArrayOfString1[j];
      int m;
      if ("_display_name".equals(str))
      {
        arrayOfString1[k] = "_display_name";
        m = k + 1;
        arrayOfObject1[k] = localFile.getName();
      }
      while (true)
      {
        k = m;
        break;
        if (!"_size".equals(str))
          break;
        arrayOfString1[k] = "_size";
        m = k + 1;
        arrayOfObject1[k] = Long.valueOf(localFile.length());
      }
      j++;
    }
    String[] arrayOfString2 = copyOf(arrayOfString1, k);
    Object[] arrayOfObject2 = copyOf(arrayOfObject1, k);
    MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString2, 1);
    localMatrixCursor.addRow(arrayOfObject2);
    return localMatrixCursor;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }

  static abstract interface PathStrategy
  {
    public abstract File getFileForUri(Uri paramUri);

    public abstract Uri getUriForFile(File paramFile);
  }

  static class SimplePathStrategy
    implements FileProvider.PathStrategy
  {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap();

    SimplePathStrategy(String paramString)
    {
      this.mAuthority = paramString;
    }

    void addRoot(String paramString, File paramFile)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("Name must not be empty");
      try
      {
        File localFile = paramFile.getCanonicalFile();
        this.mRoots.put(paramString, localFile);
        return;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to resolve canonical path for ");
        localStringBuilder.append(paramFile);
        throw new IllegalArgumentException(localStringBuilder.toString(), localIOException);
      }
    }

    // ERROR //
    public File getFileForUri(Uri paramUri)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 75	android/net/Uri:getEncodedPath	()Ljava/lang/String;
      //   4: astore_2
      //   5: aload_2
      //   6: bipush 47
      //   8: iconst_1
      //   9: invokevirtual 81	java/lang/String:indexOf	(II)I
      //   12: istore_3
      //   13: aload_2
      //   14: iconst_1
      //   15: iload_3
      //   16: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
      //   19: invokestatic 89	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
      //   22: astore 4
      //   24: aload_2
      //   25: iload_3
      //   26: iconst_1
      //   27: iadd
      //   28: invokevirtual 92	java/lang/String:substring	(I)Ljava/lang/String;
      //   31: invokestatic 89	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
      //   34: astore 5
      //   36: aload_0
      //   37: getfield 21	android/content/FileProvider$SimplePathStrategy:mRoots	Ljava/util/HashMap;
      //   40: aload 4
      //   42: invokevirtual 96	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   45: checkcast 41	java/io/File
      //   48: astore 6
      //   50: aload 6
      //   52: ifnonnull +40 -> 92
      //   55: new 51	java/lang/StringBuilder
      //   58: dup
      //   59: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   62: astore 7
      //   64: aload 7
      //   66: ldc 98
      //   68: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   71: pop
      //   72: aload 7
      //   74: aload_1
      //   75: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   78: pop
      //   79: new 35	java/lang/IllegalArgumentException
      //   82: dup
      //   83: aload 7
      //   85: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   91: athrow
      //   92: new 41	java/io/File
      //   95: dup
      //   96: aload 6
      //   98: aload 5
      //   100: invokespecial 101	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   103: astore 10
      //   105: aload 10
      //   107: invokevirtual 45	java/io/File:getCanonicalFile	()Ljava/io/File;
      //   110: astore 14
      //   112: aload 14
      //   114: invokevirtual 104	java/io/File:getPath	()Ljava/lang/String;
      //   117: aload 6
      //   119: invokevirtual 104	java/io/File:getPath	()Ljava/lang/String;
      //   122: invokevirtual 108	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   125: ifne +13 -> 138
      //   128: new 110	java/lang/SecurityException
      //   131: dup
      //   132: ldc 112
      //   134: invokespecial 113	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
      //   137: athrow
      //   138: aload 14
      //   140: areturn
      //   141: new 51	java/lang/StringBuilder
      //   144: dup
      //   145: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   148: astore 11
      //   150: aload 11
      //   152: ldc 54
      //   154: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: pop
      //   158: aload 11
      //   160: aload 10
      //   162: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   165: pop
      //   166: new 35	java/lang/IllegalArgumentException
      //   169: dup
      //   170: aload 11
      //   172: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   175: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   178: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   105	112	141	java/io/IOException
    }

    // ERROR //
    public Uri getUriForFile(File paramFile)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 118	java/io/File:getCanonicalPath	()Ljava/lang/String;
      //   4: astore 5
      //   6: aconst_null
      //   7: astore 6
      //   9: aload_0
      //   10: getfield 21	android/content/FileProvider$SimplePathStrategy:mRoots	Ljava/util/HashMap;
      //   13: invokevirtual 122	java/util/HashMap:entrySet	()Ljava/util/Set;
      //   16: invokeinterface 128 1 0
      //   21: astore 7
      //   23: aload 7
      //   25: invokeinterface 134 1 0
      //   30: ifne +186 -> 216
      //   33: aload 6
      //   35: ifnonnull +41 -> 76
      //   38: new 51	java/lang/StringBuilder
      //   41: dup
      //   42: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   45: astore 10
      //   47: aload 10
      //   49: ldc 136
      //   51: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: pop
      //   55: aload 10
      //   57: aload 5
      //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: new 35	java/lang/IllegalArgumentException
      //   66: dup
      //   67: aload 10
      //   69: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   72: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   75: athrow
      //   76: aload 6
      //   78: invokeinterface 142 1 0
      //   83: checkcast 41	java/io/File
      //   86: invokevirtual 104	java/io/File:getPath	()Ljava/lang/String;
      //   89: astore 13
      //   91: aload 13
      //   93: ldc 144
      //   95: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   98: ifeq +22 -> 120
      //   101: aload 13
      //   103: invokevirtual 151	java/lang/String:length	()I
      //   106: istore 14
      //   108: aload 5
      //   110: iload 14
      //   112: invokevirtual 92	java/lang/String:substring	(I)Ljava/lang/String;
      //   115: astore 15
      //   117: goto +15 -> 132
      //   120: iconst_1
      //   121: aload 13
      //   123: invokevirtual 151	java/lang/String:length	()I
      //   126: iadd
      //   127: istore 14
      //   129: goto -21 -> 108
      //   132: new 51	java/lang/StringBuilder
      //   135: dup
      //   136: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   139: astore 16
      //   141: aload 16
      //   143: aload 6
      //   145: invokeinterface 154 1 0
      //   150: checkcast 77	java/lang/String
      //   153: invokestatic 157	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
      //   156: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: pop
      //   160: aload 16
      //   162: bipush 47
      //   164: invokevirtual 160	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   167: pop
      //   168: aload 16
      //   170: aload 15
      //   172: ldc 144
      //   174: invokestatic 163	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: pop
      //   181: aload 16
      //   183: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   186: astore 20
      //   188: new 165	android/net/Uri$Builder
      //   191: dup
      //   192: invokespecial 166	android/net/Uri$Builder:<init>	()V
      //   195: ldc 168
      //   197: invokevirtual 172	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   200: aload_0
      //   201: getfield 23	android/content/FileProvider$SimplePathStrategy:mAuthority	Ljava/lang/String;
      //   204: invokevirtual 175	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   207: aload 20
      //   209: invokevirtual 178	android/net/Uri$Builder:encodedPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   212: invokevirtual 182	android/net/Uri$Builder:build	()Landroid/net/Uri;
      //   215: areturn
      //   216: aload 7
      //   218: invokeinterface 185 1 0
      //   223: checkcast 138	java/util/Map$Entry
      //   226: astore 8
      //   228: aload 8
      //   230: invokeinterface 142 1 0
      //   235: checkcast 41	java/io/File
      //   238: invokevirtual 104	java/io/File:getPath	()Ljava/lang/String;
      //   241: astore 9
      //   243: aload 5
      //   245: aload 9
      //   247: invokevirtual 108	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   250: ifeq -227 -> 23
      //   253: aload 6
      //   255: ifnull +27 -> 282
      //   258: aload 9
      //   260: invokevirtual 151	java/lang/String:length	()I
      //   263: aload 6
      //   265: invokeinterface 142 1 0
      //   270: checkcast 41	java/io/File
      //   273: invokevirtual 104	java/io/File:getPath	()Ljava/lang/String;
      //   276: invokevirtual 151	java/lang/String:length	()I
      //   279: if_icmple -256 -> 23
      //   282: aload 8
      //   284: astore 6
      //   286: goto -263 -> 23
      //   289: new 51	java/lang/StringBuilder
      //   292: dup
      //   293: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   296: astore_2
      //   297: aload_2
      //   298: ldc 54
      //   300: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: pop
      //   304: aload_2
      //   305: aload_1
      //   306: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   309: pop
      //   310: new 35	java/lang/IllegalArgumentException
      //   313: dup
      //   314: aload_2
      //   315: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   318: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   321: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   0	6	289	java/io/IOException
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.content.FileProvider
 * JD-Core Version:    0.6.2
 */