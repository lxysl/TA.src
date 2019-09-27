package com.baidu.mobstat;

import java.io.File;
import java.util.Comparator;

class an
  implements Comparator<File>
{
  an(al paramal)
  {
  }

  public int a(File paramFile1, File paramFile2)
  {
    return (int)(paramFile2.lastModified() - paramFile1.lastModified());
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.an
 * JD-Core Version:    0.6.2
 */