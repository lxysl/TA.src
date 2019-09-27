package com.baidu.mobstat;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class dd
  implements Comparator<ScanResult>
{
  public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    return paramScanResult2.level - paramScanResult1.level;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.dd
 * JD-Core Version:    0.6.2
 */