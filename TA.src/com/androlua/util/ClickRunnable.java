package com.androlua.util;

import android.view.accessibility.AccessibilityNodeInfo;
import com.androlua.LuaAccessibilityService;
import com.luajava.LuaTable;

public class ClickRunnable
  implements Runnable
{
  private final LuaAccessibilityService a;
  private LuaTable b;
  private int c = 1;
  private int d = -1;
  private int e = -1;
  private ClickCallback f;
  private boolean g = false;
  private ClickRunnable h;

  public ClickRunnable(LuaAccessibilityService paramLuaAccessibilityService, LuaTable paramLuaTable)
  {
    this.a = paramLuaAccessibilityService;
    this.b = paramLuaTable;
  }

  // ERROR //
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: ldc 45
    //   9: invokevirtual 51	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   12: istore_2
    //   13: ldc2_w 52
    //   16: lstore_3
    //   17: iload_2
    //   18: ifle +36 -> 54
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: istore 21
    //   26: aload_1
    //   27: iload 21
    //   29: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   32: invokestatic 63	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   35: invokevirtual 67	java/lang/Long:longValue	()J
    //   38: lstore 23
    //   40: lload 23
    //   42: lstore_3
    //   43: goto +4 -> 47
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 72
    //   57: invokevirtual 51	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   60: istore 5
    //   62: iload 5
    //   64: ifle +48 -> 112
    //   67: aload_0
    //   68: getfield 29	com/androlua/util/ClickRunnable:d	I
    //   71: ifge +33 -> 104
    //   74: iload 5
    //   76: iconst_1
    //   77: iadd
    //   78: istore 20
    //   80: aload_0
    //   81: aload_1
    //   82: iload 20
    //   84: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   87: invokestatic 77	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 81	java/lang/Integer:intValue	()I
    //   93: putfield 29	com/androlua/util/ClickRunnable:d	I
    //   96: goto +8 -> 104
    //   99: aload_0
    //   100: iconst_m1
    //   101: putfield 29	com/androlua/util/ClickRunnable:d	I
    //   104: aload_1
    //   105: iconst_0
    //   106: iload 5
    //   108: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   111: astore_1
    //   112: aload_1
    //   113: ldc 83
    //   115: invokevirtual 51	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   118: istore 6
    //   120: iload 6
    //   122: ifle +48 -> 170
    //   125: aload_0
    //   126: getfield 31	com/androlua/util/ClickRunnable:e	I
    //   129: ifge +33 -> 162
    //   132: iload 6
    //   134: iconst_1
    //   135: iadd
    //   136: istore 19
    //   138: aload_0
    //   139: aload_1
    //   140: iload 19
    //   142: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: invokestatic 77	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   148: invokevirtual 81	java/lang/Integer:intValue	()I
    //   151: putfield 31	com/androlua/util/ClickRunnable:e	I
    //   154: goto +8 -> 162
    //   157: aload_0
    //   158: iconst_m1
    //   159: putfield 31	com/androlua/util/ClickRunnable:e	I
    //   162: aload_1
    //   163: iconst_0
    //   164: iload 6
    //   166: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   169: astore_1
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 31	com/androlua/util/ClickRunnable:e	I
    //   175: iconst_1
    //   176: isub
    //   177: putfield 31	com/androlua/util/ClickRunnable:e	I
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 29	com/androlua/util/ClickRunnable:d	I
    //   185: iconst_1
    //   186: isub
    //   187: putfield 29	com/androlua/util/ClickRunnable:d	I
    //   190: aload_0
    //   191: getfield 35	com/androlua/util/ClickRunnable:a	Lcom/androlua/LuaAccessibilityService;
    //   194: aload_1
    //   195: invokevirtual 89	com/androlua/LuaAccessibilityService:findAccessibilityNodeInfo	(Ljava/lang/String;)Landroid/view/accessibility/AccessibilityNodeInfo;
    //   198: astore 7
    //   200: new 91	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   207: astore 8
    //   209: aload 8
    //   211: ldc 94
    //   213: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 8
    //   219: aload_1
    //   220: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 8
    //   226: ldc 100
    //   228: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 8
    //   234: aload_0
    //   235: getfield 29	com/androlua/util/ClickRunnable:d	I
    //   238: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 8
    //   244: ldc 100
    //   246: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 8
    //   252: aload_0
    //   253: getfield 31	com/androlua/util/ClickRunnable:e	I
    //   256: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 8
    //   262: ldc 100
    //   264: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 8
    //   270: aload 7
    //   272: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: ldc 108
    //   278: aload 8
    //   280: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 118	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   286: pop
    //   287: aload 7
    //   289: ifnull +32 -> 321
    //   292: aload_0
    //   293: iconst_m1
    //   294: putfield 29	com/androlua/util/ClickRunnable:d	I
    //   297: aload_0
    //   298: getfield 35	com/androlua/util/ClickRunnable:a	Lcom/androlua/LuaAccessibilityService;
    //   301: aload 7
    //   303: invokevirtual 122	com/androlua/LuaAccessibilityService:toClick2	(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    //   306: aload_0
    //   307: getfield 35	com/androlua/util/ClickRunnable:a	Lcom/androlua/LuaAccessibilityService;
    //   310: invokevirtual 126	com/androlua/LuaAccessibilityService:getHandler	()Landroid/os/Handler;
    //   313: aload_0
    //   314: lload_3
    //   315: invokevirtual 132	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   318: pop
    //   319: iconst_1
    //   320: ireturn
    //   321: aload_0
    //   322: getfield 29	com/androlua/util/ClickRunnable:d	I
    //   325: ifgt -19 -> 306
    //   328: aload_0
    //   329: getfield 31	com/androlua/util/ClickRunnable:e	I
    //   332: ifle +6 -> 338
    //   335: goto -29 -> 306
    //   338: aload_0
    //   339: getfield 134	com/androlua/util/ClickRunnable:f	Lcom/androlua/util/ClickRunnable$ClickCallback;
    //   342: ifnull +22 -> 364
    //   345: aload_0
    //   346: getfield 134	com/androlua/util/ClickRunnable:f	Lcom/androlua/util/ClickRunnable$ClickCallback;
    //   349: iconst_1
    //   350: aload_0
    //   351: getfield 37	com/androlua/util/ClickRunnable:b	Lcom/luajava/LuaTable;
    //   354: aload_1
    //   355: aload_0
    //   356: getfield 27	com/androlua/util/ClickRunnable:c	I
    //   359: invokeinterface 140 5 0
    //   364: iconst_0
    //   365: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   26	40	46	java/lang/Exception
    //   80	96	99	java/lang/Exception
    //   138	154	157	java/lang/Exception
  }

  public boolean canClick()
  {
    if (this.b.length() == 0)
      return false;
    int i = this.b.length();
    int k;
    for (int j = 0; j < i; j = k)
    {
      if (this.g)
      {
        if (this.f != null)
          this.f.onDone(false, this.b, null, -1);
        return false;
      }
      LuaTable localLuaTable1 = this.b;
      k = j + 1;
      Object localObject = localLuaTable1.get(Integer.valueOf(k));
      if ((localObject instanceof LuaTable))
      {
        LuaTable localLuaTable2 = (LuaTable)localObject;
        if (localLuaTable2.length() != 0)
        {
          String str2 = (String)localLuaTable2.get(Integer.valueOf(1));
          if ((str2 != null) && (a(str2)))
          {
            this.b = localLuaTable2;
            return true;
          }
        }
      }
      else if ((localObject instanceof String))
      {
        String str1 = (String)localObject;
        AccessibilityNodeInfo localAccessibilityNodeInfo = this.a.findAccessibilityNodeInfo(str1);
        if (localAccessibilityNodeInfo != null)
        {
          this.a.toClick2(localAccessibilityNodeInfo);
          if (this.f != null)
            this.f.onDone(true, this.b, str1, j);
          return true;
        }
      }
    }
    if (this.f != null)
      this.f.onDone(false, this.b, null, -1);
    return false;
  }

  public boolean canClick(ClickCallback paramClickCallback)
  {
    this.f = paramClickCallback;
    return canClick();
  }

  public void cancel()
  {
    this.g = true;
    if (this.h != null)
      this.h.cancel();
  }

  public void run()
  {
    if (this.g)
    {
      if (this.f != null)
        this.f.onDone(false, this.b, null, -1);
      return;
    }
    if ((this.d < 0) && (this.e < 0))
      this.c = (1 + this.c);
    Object localObject = this.b.get(Integer.valueOf(this.c));
    if (localObject == null)
    {
      if (this.f != null)
      {
        ClickCallback localClickCallback = this.f;
        int i = this.c;
        int j = this.b.length();
        boolean bool = false;
        if (i == j)
          bool = true;
        localClickCallback.onDone(bool, this.b, null, this.c);
      }
      return;
    }
    if ((localObject instanceof LuaTable))
    {
      LuaTable localLuaTable = (LuaTable)localObject;
      if (localLuaTable.length() == 0)
        return;
      this.h = new ClickRunnable(this.a, localLuaTable);
      this.h.canClick(new ClickCallback()
      {
        public void onDone(boolean paramAnonymousBoolean, LuaTable paramAnonymousLuaTable, String paramAnonymousString, int paramAnonymousInt)
        {
          ClickRunnable.a(ClickRunnable.this, null);
          ClickRunnable.this.run();
        }
      });
      return;
    }
    if ((localObject instanceof String))
      a((String)localObject);
  }

  public static abstract interface ClickCallback
  {
    public abstract void onDone(boolean paramBoolean, LuaTable paramLuaTable, String paramString, int paramInt);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.util.ClickRunnable
 * JD-Core Version:    0.6.2
 */