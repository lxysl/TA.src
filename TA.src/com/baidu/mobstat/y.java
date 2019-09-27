package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum y
{
  private int f;

  static
  {
    y[] arrayOfy = new y[5];
    arrayOfy[0] = a;
    arrayOfy[1] = b;
    arrayOfy[2] = c;
    arrayOfy[3] = d;
    arrayOfy[4] = e;
  }

  private y(int paramInt)
  {
    this.f = paramInt;
  }

  private int a(List<String> paramList, ArrayList<Long> paramArrayList, ArrayList<w> paramArrayList1, int paramInt1, int paramInt2)
  {
    int i = c();
    int j = 0;
    int k = 0;
    while (i > 0)
    {
      if (i < paramInt2)
        paramInt2 = i;
      ArrayList localArrayList = a(paramInt2, k);
      if ((k == 0) && (localArrayList.size() != 0))
        paramArrayList1.add((w)localArrayList.get(0));
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        long l = localw.a();
        String str = localw.b();
        int m = j + str.length();
        if (m > paramInt1)
          break;
        paramArrayList.add(Long.valueOf(l));
        paramList.add(str);
        j = m;
      }
      i -= paramInt2;
      k += paramInt2;
    }
    return j;
  }

  // ERROR //
  private int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 125	com/baidu/mobstat/y:a	()Lcom/baidu/mobstat/x;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 129	com/baidu/mobstat/x:a	()Z
    //   9: ifeq +20 -> 29
    //   12: aload_2
    //   13: invokevirtual 131	com/baidu/mobstat/x:b	()I
    //   16: istore 6
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   26: iload 6
    //   28: ireturn
    //   29: aload_2
    //   30: ifnull +43 -> 73
    //   33: goto +36 -> 69
    //   36: astore 4
    //   38: goto +37 -> 75
    //   41: astore_3
    //   42: goto +19 -> 61
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aconst_null
    //   52: astore_2
    //   53: goto +22 -> 75
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 139	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   83: aload 4
    //   85: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	18	36	finally
    //   61	65	36	finally
    //   5	18	41	java/lang/Exception
    //   0	5	45	finally
    //   0	5	56	java/lang/Exception
  }

  // ERROR //
  public int a(ArrayList<Long> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_1
    //   5: ifnull +202 -> 207
    //   8: aload_1
    //   9: invokevirtual 76	java/util/ArrayList:size	()I
    //   12: istore 4
    //   14: iload 4
    //   16: ifne +6 -> 22
    //   19: goto +188 -> 207
    //   22: aconst_null
    //   23: astore 5
    //   25: aload_0
    //   26: invokevirtual 125	com/baidu/mobstat/y:a	()Lcom/baidu/mobstat/x;
    //   29: astore 9
    //   31: aload 9
    //   33: invokevirtual 129	com/baidu/mobstat/x:a	()Z
    //   36: istore 10
    //   38: iload 10
    //   40: ifne +17 -> 57
    //   43: aload 9
    //   45: ifnull +8 -> 53
    //   48: aload 9
    //   50: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_1
    //   58: invokevirtual 76	java/util/ArrayList:size	()I
    //   61: istore 11
    //   63: iconst_0
    //   64: istore 7
    //   66: iload_2
    //   67: iload 11
    //   69: if_icmpge +59 -> 128
    //   72: aload 9
    //   74: aload_1
    //   75: iload_2
    //   76: invokevirtual 80	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   79: checkcast 113	java/lang/Long
    //   82: invokevirtual 153	java/lang/Long:longValue	()J
    //   85: invokevirtual 156	com/baidu/mobstat/x:b	(J)Z
    //   88: istore 12
    //   90: iload 12
    //   92: ifne +18 -> 110
    //   95: aload 9
    //   97: ifnull +8 -> 105
    //   100: aload 9
    //   102: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   105: aload_0
    //   106: monitorexit
    //   107: iload 7
    //   109: ireturn
    //   110: iinc 7 1
    //   113: iinc 2 1
    //   116: goto -50 -> 66
    //   119: astore 6
    //   121: aload 9
    //   123: astore 5
    //   125: goto +44 -> 169
    //   128: aload 9
    //   130: ifnull +54 -> 184
    //   133: aload 9
    //   135: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   138: goto +46 -> 184
    //   141: astore 8
    //   143: goto +46 -> 189
    //   146: astore 6
    //   148: aload 9
    //   150: astore 5
    //   152: goto +14 -> 166
    //   155: astore 8
    //   157: aload 5
    //   159: astore 9
    //   161: goto +28 -> 189
    //   164: astore 6
    //   166: iconst_0
    //   167: istore 7
    //   169: aload 6
    //   171: invokestatic 139	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   174: aload 5
    //   176: ifnull +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   184: aload_0
    //   185: monitorexit
    //   186: iload 7
    //   188: ireturn
    //   189: aload 9
    //   191: ifnull +8 -> 199
    //   194: aload 9
    //   196: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   199: aload 8
    //   201: athrow
    //   202: astore_3
    //   203: aload_0
    //   204: monitorexit
    //   205: aload_3
    //   206: athrow
    //   207: aload_0
    //   208: monitorexit
    //   209: iconst_0
    //   210: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   72	90	119	java/lang/Exception
    //   31	38	141	finally
    //   57	63	141	finally
    //   72	90	141	finally
    //   31	38	146	java/lang/Exception
    //   57	63	146	java/lang/Exception
    //   25	31	155	finally
    //   169	174	155	finally
    //   25	31	164	java/lang/Exception
    //   8	14	202	finally
    //   48	53	202	finally
    //   100	105	202	finally
    //   133	138	202	finally
    //   179	184	202	finally
    //   194	199	202	finally
    //   199	202	202	finally
  }

  // ERROR //
  public long a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 125	com/baidu/mobstat/y:a	()Lcom/baidu/mobstat/x;
    //   9: astore 10
    //   11: aload 10
    //   13: invokevirtual 129	com/baidu/mobstat/x:a	()Z
    //   16: istore 11
    //   18: iload 11
    //   20: ifne +19 -> 39
    //   23: aload 10
    //   25: ifnull +8 -> 33
    //   28: aload 10
    //   30: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc2_w 158
    //   38: lreturn
    //   39: aload 10
    //   41: lload_1
    //   42: invokestatic 162	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   45: aload_3
    //   46: invokevirtual 165	com/baidu/mobstat/x:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   49: lstore 6
    //   51: aload 10
    //   53: ifnull +56 -> 109
    //   56: aload 10
    //   58: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   61: goto +48 -> 109
    //   64: astore 9
    //   66: goto +48 -> 114
    //   69: astore 5
    //   71: aload 10
    //   73: astore 4
    //   75: goto +14 -> 89
    //   78: astore 9
    //   80: aload 4
    //   82: astore 10
    //   84: goto +30 -> 114
    //   87: astore 5
    //   89: aload 5
    //   91: invokestatic 139	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   104: ldc2_w 158
    //   107: lstore 6
    //   109: aload_0
    //   110: monitorexit
    //   111: lload 6
    //   113: lreturn
    //   114: aload 10
    //   116: ifnull +11 -> 127
    //   119: aload 10
    //   121: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   124: goto +3 -> 127
    //   127: aload 9
    //   129: athrow
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 8
    //   134: athrow
    //   135: astore 8
    //   137: goto -7 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   11	18	64	finally
    //   39	51	64	finally
    //   11	18	69	java/lang/Exception
    //   39	51	69	java/lang/Exception
    //   5	11	78	finally
    //   89	94	78	finally
    //   5	11	87	java/lang/Exception
    //   28	33	135	finally
    //   56	61	135	finally
    //   99	104	135	finally
    //   119	124	135	finally
    //   127	130	135	finally
  }

  public abstract x a();

  // ERROR //
  public ArrayList<w> a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 73	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 167	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_0
    //   14: invokevirtual 125	com/baidu/mobstat/y:a	()Lcom/baidu/mobstat/x;
    //   17: astore 9
    //   19: aload 9
    //   21: invokevirtual 129	com/baidu/mobstat/x:a	()Z
    //   24: istore 10
    //   26: iload 10
    //   28: ifne +17 -> 45
    //   31: aload 9
    //   33: ifnull +8 -> 41
    //   36: aload 9
    //   38: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_3
    //   44: areturn
    //   45: aload 9
    //   47: iload_1
    //   48: iload_2
    //   49: invokevirtual 168	com/baidu/mobstat/x:a	(II)Ljava/util/ArrayList;
    //   52: astore 6
    //   54: aload 9
    //   56: ifnull +54 -> 110
    //   59: aload 9
    //   61: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   64: goto +46 -> 110
    //   67: astore 8
    //   69: aload 9
    //   71: astore 4
    //   73: goto +42 -> 115
    //   76: astore 5
    //   78: aload 9
    //   80: astore 4
    //   82: goto +10 -> 92
    //   85: astore 8
    //   87: goto +28 -> 115
    //   90: astore 5
    //   92: aload 5
    //   94: invokestatic 139	com/baidu/mobstat/bd:b	(Ljava/lang/Throwable;)V
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   107: aload_3
    //   108: astore 6
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 6
    //   114: areturn
    //   115: aload 4
    //   117: ifnull +8 -> 125
    //   120: aload 4
    //   122: invokevirtual 134	com/baidu/mobstat/x:close	()V
    //   125: aload 8
    //   127: athrow
    //   128: astore 7
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 7
    //   134: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   19	26	67	finally
    //   45	54	67	finally
    //   19	26	76	java/lang/Exception
    //   45	54	76	java/lang/Exception
    //   13	19	85	finally
    //   92	97	85	finally
    //   13	19	90	java/lang/Exception
    //   2	10	128	finally
    //   36	41	128	finally
    //   59	64	128	finally
    //   102	107	128	finally
    //   120	125	128	finally
    //   125	128	128	finally
  }

  public List<String> a(int paramInt)
  {
    try
    {
      Object localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a((List)localObject1, localArrayList1, localArrayList2, paramInt, 500);
      if ((localArrayList2.size() != 0) && (((List)localObject1).size() == 0) && (localArrayList1.size() == 0))
      {
        w localw = (w)localArrayList2.get(0);
        long l = localw.a();
        String str = localw.b();
        localArrayList1.add(Long.valueOf(l));
        ((List)localObject1).add(str);
      }
      int i = a(localArrayList1);
      if (i != ((List)localObject1).size())
        localObject1 = ((List)localObject1).subList(0, i);
      return localObject1;
    }
    finally
    {
    }
  }

  public boolean b()
  {
    try
    {
      int i = c();
      boolean bool;
      if (i == 0)
        bool = true;
      else
        bool = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b(int paramInt)
  {
    try
    {
      int i = c();
      boolean bool;
      if (i >= paramInt)
        bool = true;
      else
        bool = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String toString()
  {
    return String.valueOf(this.f);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.y
 * JD-Core Version:    0.6.2
 */