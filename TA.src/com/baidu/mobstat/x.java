package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;

abstract class x
  implements Closeable
{
  private af a;

  public x(String paramString1, String paramString2)
  {
    ae localae = new ae();
    this.a = new af(localae, paramString1);
    if (localae.getDatabasePath(".confd") != null)
      a(paramString2);
  }

  private void a(String paramString)
  {
    this.a.a(paramString);
  }

  protected long a(ContentValues paramContentValues)
  {
    return this.a.a(null, paramContentValues);
  }

  public abstract long a(String paramString1, String paramString2);

  protected Cursor a(String paramString, int paramInt1, int paramInt2)
  {
    af localaf = this.a;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" desc");
    String str = localStringBuilder1.toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt2);
    localStringBuilder2.append(", ");
    localStringBuilder2.append(paramInt1);
    return localaf.a(null, null, null, null, null, str, localStringBuilder2.toString());
  }

  protected Cursor a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append("=? ");
    String str1 = localStringBuilder1.toString();
    String[] arrayOfString = { paramString2 };
    af localaf = this.a;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString3);
    localStringBuilder2.append(" desc");
    String str2 = localStringBuilder2.toString();
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append(paramInt);
    localStringBuilder3.append("");
    return localaf.a(null, str1, arrayOfString, null, null, str2, localStringBuilder3.toString());
  }

  public abstract ArrayList<w> a(int paramInt1, int paramInt2);

  // ERROR //
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/baidu/mobstat/x:a	Lcom/baidu/mobstat/af;
    //   6: invokevirtual 73	com/baidu/mobstat/af:a	()Z
    //   9: istore_3
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_3
    //   13: ireturn
    //   14: astore_2
    //   15: goto +12 -> 27
    //   18: astore_1
    //   19: aload_1
    //   20: invokestatic 79	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
    //   19	23	14	finally
    //   2	10	18	java/lang/Exception
  }

  protected boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    String[] arrayOfString = { localStringBuilder.toString() };
    return this.a.a("_id=? ", arrayOfString) > 0;
  }

  protected int b()
  {
    return this.a.b();
  }

  public abstract boolean b(long paramLong);

  // ERROR //
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/baidu/mobstat/x:a	Lcom/baidu/mobstat/af;
    //   6: invokevirtual 94	com/baidu/mobstat/af:close	()V
    //   9: goto +12 -> 21
    //   12: astore_2
    //   13: goto +11 -> 24
    //   16: astore_1
    //   17: aload_1
    //   18: invokestatic 79	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   17	21	12	finally
    //   2	9	16	java/lang/Exception
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.x
 * JD-Core Version:    0.6.2
 */