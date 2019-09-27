package bsh;

import java.util.StringTokenizer;
import java.util.Vector;

public class StringUtil
{
  public static String[] bubbleSort(String[] paramArrayOfString)
  {
    Vector localVector = new Vector();
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
      {
        int j = localVector.size();
        int k = 1;
        if (k == 0)
        {
          String[] arrayOfString = new String[j];
          localVector.copyInto(arrayOfString);
          return arrayOfString;
        }
        int m = 0;
        int n = 0;
        while (true)
        {
          if (m >= j - 1)
          {
            k = n;
            break;
          }
          String str1 = (String)localVector.elementAt(m);
          int i1 = m + 1;
          if (str1.compareTo((String)localVector.elementAt(i1)) > 0)
          {
            String str2 = (String)localVector.elementAt(i1);
            localVector.removeElementAt(i1);
            localVector.insertElementAt(str2, m);
            n = 1;
          }
          m = i1;
        }
      }
      localVector.addElement(paramArrayOfString[i]);
    }
  }

  public static String maxCommonPrefix(String paramString1, String paramString2)
  {
    for (int i = 0; ; i++)
      if (!paramString1.regionMatches(0, paramString2, 0, i))
        return paramString1.substring(0, i - 1);
  }

  public static String methodString(String paramString, Class[] paramArrayOfClass)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append(paramString);
    localStringBuffer1.append("(");
    StringBuffer localStringBuffer2 = new StringBuffer(localStringBuffer1.toString());
    if (paramArrayOfClass.length > 0)
      localStringBuffer2.append(" ");
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfClass.length)
      {
        localStringBuffer2.append(")");
        return localStringBuffer2.toString();
      }
      Class localClass = paramArrayOfClass[i];
      StringBuffer localStringBuffer3 = new StringBuffer();
      String str1;
      if (localClass == null)
        str1 = "null";
      else
        str1 = localClass.getName();
      localStringBuffer3.append(str1);
      String str2;
      if (i < -1 + paramArrayOfClass.length)
        str2 = ", ";
      else
        str2 = " ";
      localStringBuffer3.append(str2);
      localStringBuffer2.append(localStringBuffer3.toString());
    }
  }

  public static String normalizeClassName(Class paramClass)
  {
    return Reflect.normalizeClassName(paramClass);
  }

  public static String[] split(String paramString1, String paramString2)
  {
    Vector localVector = new Vector();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
    while (true)
    {
      if (!localStringTokenizer.hasMoreTokens())
      {
        String[] arrayOfString = new String[localVector.size()];
        localVector.copyInto(arrayOfString);
        return arrayOfString;
      }
      localVector.addElement(localStringTokenizer.nextToken());
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.StringUtil
 * JD-Core Version:    0.6.2
 */