package com.android.cglib.dx;

import com.android.cglib.dx.c.d.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TypeList
{
  final TypeId<?>[] a;
  final b b;

  TypeList(TypeId<?>[] paramArrayOfTypeId)
  {
    this.a = ((TypeId[])paramArrayOfTypeId.clone());
    this.b = new b(paramArrayOfTypeId.length);
    for (int i = 0; i < paramArrayOfTypeId.length; i++)
      this.b.a(i, paramArrayOfTypeId[i].b);
  }

  public List<TypeId<?>> asList()
  {
    return Collections.unmodifiableList(Arrays.asList(this.a));
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeList)) && (Arrays.equals(((TypeList)paramObject).a, this.a));
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < this.a.length; i++)
    {
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(this.a[i]);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.TypeList
 * JD-Core Version:    0.6.2
 */