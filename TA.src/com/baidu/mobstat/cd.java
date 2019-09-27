package com.baidu.mobstat;

import java.io.File;
import java.io.FilenameFilter;

class cd
  implements FilenameFilter
{
  cd(cc paramcc)
  {
  }

  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("__send_data_");
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cd
 * JD-Core Version:    0.6.2
 */