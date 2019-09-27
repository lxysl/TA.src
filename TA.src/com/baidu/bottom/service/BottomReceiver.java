package com.baidu.bottom.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.at;
import com.baidu.mobstat.bd;
import com.baidu.mobstat.db;
import com.baidu.mobstat.n;

public class BottomReceiver extends BroadcastReceiver
{
  private static db a;
  private static long b;
  private static long c;

  private void a(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    long l = System.currentTimeMillis();
    if ((Math.abs(c - l) > 30000L) && (("android.net.wifi.STATE_CHANGE".equals(str)) || ("android.net.wifi.WIFI_STATE_CHANGED".equals(str)) || ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) || ("android.net.wifi.SCAN_RESULTS".equals(str))))
    {
      c = l;
      n.a(paramContext);
    }
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    if (("android.intent.action.PACKAGE_ADDED".equals(str1)) || ("android.intent.action.PACKAGE_REMOVED".equals(str1)) || ("android.intent.action.PACKAGE_REPLACED".equals(str1)))
    {
      Uri localUri = paramIntent.getData();
      String str2 = null;
      if (localUri != null)
        str2 = localUri.getSchemeSpecificPart();
      if (!TextUtils.isEmpty(str2))
        n.a(paramContext, str1, str2);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (a != null)
    {
      bd.a("Bottom has alread analyzed.");
      return;
    }
    db localdb = new db();
    if (localdb.a())
    {
      a = localdb;
      new at(this, paramContext, paramIntent, localdb).start();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.bottom.service.BottomReceiver
 * JD-Core Version:    0.6.2
 */