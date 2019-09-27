package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class af extends SQLiteOpenHelper
{
  private String a;
  private SQLiteDatabase b;

  public af(Context paramContext, String paramString)
  {
    super(paramContext, ".confd", null, 1);
    this.a = paramString;
  }

  public int a(String paramString, String[] paramArrayOfString)
  {
    return this.b.delete(this.a, paramString, paramArrayOfString);
  }

  public long a(String paramString, ContentValues paramContentValues)
  {
    return this.b.insert(this.a, paramString, paramContentValues);
  }

  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return this.b.query(this.a, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5);
  }

  public void a(String paramString)
  {
    getWritableDatabase().execSQL(paramString);
  }

  // ERROR //
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/baidu/mobstat/af:b	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnonnull +6 -> 12
    //   9: goto +92 -> 101
    //   12: aload_0
    //   13: getfield 20	com/baidu/mobstat/af:b	Landroid/database/sqlite/SQLiteDatabase;
    //   16: invokevirtual 50	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   19: istore 6
    //   21: iload 6
    //   23: ifne +6 -> 29
    //   26: goto +75 -> 101
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +24 -> 56
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 41	com/baidu/mobstat/af:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: putfield 20	com/baidu/mobstat/af:b	Landroid/database/sqlite/SQLiteDatabase;
    //   43: goto +13 -> 56
    //   46: new 47	java/lang/NullPointerException
    //   49: dup
    //   50: ldc 52
    //   52: invokespecial 54	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: aload_0
    //   57: getfield 20	com/baidu/mobstat/af:b	Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore_3
    //   61: iconst_0
    //   62: istore 4
    //   64: aload_3
    //   65: ifnull +26 -> 91
    //   68: aload_0
    //   69: getfield 20	com/baidu/mobstat/af:b	Landroid/database/sqlite/SQLiteDatabase;
    //   72: invokevirtual 50	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   75: istore 5
    //   77: iload 5
    //   79: ifne +9 -> 88
    //   82: iconst_0
    //   83: istore 4
    //   85: goto +6 -> 91
    //   88: iconst_1
    //   89: istore 4
    //   91: aload_0
    //   92: monitorexit
    //   93: iload 4
    //   95: ireturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: iconst_1
    //   102: istore_2
    //   103: goto -72 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   35	43	46	java/lang/NullPointerException
    //   2	9	96	finally
    //   12	21	96	finally
    //   35	43	96	finally
    //   46	56	96	finally
    //   56	61	96	finally
    //   68	77	96	finally
  }

  public final int b()
  {
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SELECT COUNT(*) FROM ");
      localStringBuilder.append(this.a);
      Cursor localCursor = localSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      if (localCursor != null)
        try
        {
          if (localCursor.moveToNext())
          {
            int i = localCursor.getInt(0);
            return i;
          }
        }
        finally
        {
          Object localObject2 = localObject4;
          localObject1 = localCursor;
          break label112;
        }
      return 0;
    }
    finally
    {
      label112: if (localObject1 != null)
        localObject1.close();
    }
  }

  public void close()
  {
    try
    {
      super.close();
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.b = paramSQLiteDatabase;
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.af
 * JD-Core Version:    0.6.2
 */