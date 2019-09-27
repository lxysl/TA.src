package bsh;

import java.lang.reflect.Array;
import java.util.Enumeration;

class CollectionManager$1
  implements Enumeration
{
  int a;
  int b;
  private final Object c;
  private final CollectionManager.BasicBshIterator d;

  CollectionManager$1(CollectionManager.BasicBshIterator paramBasicBshIterator, Object paramObject)
  {
    this.d = paramBasicBshIterator;
    this.c = paramObject;
    this.a = 0;
    this.b = Array.getLength(this.c);
  }

  public boolean hasMoreElements()
  {
    return this.a < this.b;
  }

  public Object nextElement()
  {
    Object localObject = this.c;
    int i = this.a;
    this.a = (i + 1);
    return Array.get(localObject, i);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.CollectionManager.1
 * JD-Core Version:    0.6.2
 */