package com.nirenr;

import F;
import I;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ColorFinder
{
  private int a;
  private int b;
  private int[][] c;
  private float[][] d;
  private float e;

  public ColorFinder(Bitmap paramBitmap)
  {
    a(paramBitmap);
  }

  public ColorFinder(String paramString)
  {
    a(BitmapFactory.decodeFile(paramString));
  }

  private int a(int paramInt1, int paramInt2, int[][] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 0;
    while (i < this.b - paramInt2 - paramInt3)
    {
      int[] arrayOfInt = paramArrayOfInt[paramInt1];
      int j = paramInt2 + i;
      if (arrayOfInt[j] == 1)
      {
        int k = paramInt1 + paramInt5;
        if ((paramArrayOfInt[k][j] == 0) && (paramArrayOfInt[(k + paramInt4)][j] == 0))
          i++;
      }
      else
      {
        if (i > paramInt3)
          return i;
        return -1;
      }
    }
    return this.b - paramInt2 - paramInt3;
  }

  private void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap.getWidth();
    this.b = paramBitmap.getHeight();
    int[] arrayOfInt = new int[this.a * this.b];
    paramBitmap.getPixels(arrayOfInt, 0, this.a, 0, 0, this.a, this.b);
    this.c = ((int[][])Array.newInstance(I.class, new int[] { this.a, this.b }));
    for (int i = 0; i < this.b; i++)
      for (int j = 0; j < this.a; j++)
        this.c[j][i] = arrayOfInt[(j + i * this.a)];
  }

  public Point find(int paramInt)
  {
    for (int i = 0; i < this.b; i++)
      for (int j = 0; j < this.a; j++)
        if (this.c[j][i] == paramInt)
          return new Point(j, i);
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3)
  {
    for (int i = 0; i < this.b; i++)
      for (int j = 0; j < this.a; j++)
      {
        int k = this.c[j][i];
        int m = k << 8 >>> 24;
        int n = k << 16 >>> 24;
        int i1 = k << 24 >>> 24;
        if ((m == paramInt1) && (n == paramInt2) && (i1 == paramInt3))
          return new Point(j, i);
      }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 - paramInt4;
    int j = paramInt1 + paramInt4;
    int k = paramInt2 - paramInt4;
    int m = paramInt2 + paramInt4;
    int n = paramInt3 - paramInt4;
    int i1 = paramInt3 + paramInt4;
    for (int i2 = 0; i2 < this.b; i2++)
      for (int i3 = 0; i3 < this.a; i3++)
      {
        int i4 = this.c[i3][i2];
        int i5 = i4 << 8 >>> 24;
        int i6 = i4 << 16 >>> 24;
        int i7 = i4 << 24 >>> 24;
        if ((i5 >= i) && (i5 <= j) && (i6 >= k) && (i6 <= m) && (i7 >= n) && (i7 <= i1))
          return new Point(i3, i2);
      }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    while (paramInt2 < paramInt4)
    {
      for (int i = paramInt1; i < paramInt3; i++)
        if (this.c[i][paramInt2] == paramInt5)
          return new Point(i, paramInt2);
      paramInt2++;
    }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    while (paramInt2 < paramInt4)
    {
      for (int i = paramInt1; i < paramInt3; i++)
      {
        int j = this.c[i][paramInt2];
        int k = j << 8 >>> 24;
        int m = j << 16 >>> 24;
        int n = j << 24 >>> 24;
        if ((k == paramInt5) && (m == paramInt6) && (n == paramInt7))
          return new Point(i, paramInt2);
      }
      paramInt2++;
    }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = paramInt5 - paramInt8;
    int j = paramInt5 + paramInt8;
    int k = paramInt6 - paramInt8;
    int m = paramInt6 + paramInt8;
    int n = paramInt7 - paramInt8;
    int i1 = paramInt7 + paramInt8;
    while (paramInt2 < paramInt4)
    {
      for (int i2 = paramInt1; i2 < paramInt3; i2++)
      {
        int i3 = this.c[i2][paramInt2];
        int i4 = i3 << 8 >>> 24;
        int i5 = i3 << 16 >>> 24;
        int i6 = i3 << 24 >>> 24;
        if ((i4 >= i) && (i4 <= j) && (i5 >= k) && (i5 <= m) && (i6 >= n) && (i6 <= i1))
          return new Point(i2, paramInt2);
      }
      paramInt2++;
    }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, ColorPoint[] paramArrayOfColorPoint)
  {
    ColorFinder localColorFinder = this;
    int i = paramInt5 - paramInt8;
    int j = paramInt5 + paramInt8;
    int k = paramInt6 - paramInt8;
    int m = paramInt6 + paramInt8;
    int n = paramInt7 - paramInt8;
    int i1 = paramInt7 + paramInt8;
    int i2 = paramInt2;
    while (i2 < paramInt4)
    {
      int i3 = paramInt1;
      while (i3 < paramInt3)
      {
        int i5 = localColorFinder.c[i3][i2];
        int i6 = i5 << 8 >>> 24;
        int i7 = i5 << 16 >>> 24;
        int i8 = i5 << 24 >>> 24;
        int i9;
        if ((i6 >= i) && (i6 <= j) && (i7 >= k) && (i7 <= m) && (i8 >= n) && (i8 <= i1))
        {
          int i10 = paramArrayOfColorPoint.length;
          int i11 = 0;
          while (i11 < i10)
          {
            ColorPoint localColorPoint = paramArrayOfColorPoint[i11];
            int[][] arrayOfInt = localColorFinder.c;
            i9 = j;
            if (!localColorPoint.check(arrayOfInt, paramInt1, paramInt2))
            {
              i12 = 0;
              break label220;
            }
            i11++;
            j = i9;
            localColorFinder = this;
          }
          i9 = j;
          int i12 = 1;
          label220: if (i12 != 0)
            return new Point(i3, i2);
        }
        else
        {
          i9 = j;
        }
        i3++;
        j = i9;
        localColorFinder = this;
      }
      int i4 = j;
      i2++;
      j = i4;
      localColorFinder = this;
    }
    return new Point(-1, -1);
  }

  public Point find(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[][] paramArrayOfInt)
  {
    ColorPoint[] arrayOfColorPoint = new ColorPoint[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++)
      arrayOfColorPoint[i] = new ColorPoint(paramArrayOfInt[i]);
    return find(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, arrayOfColorPoint);
  }

  public Point find(Color paramColor)
  {
    return find(paramColor.red, paramColor.green, paramColor.blue);
  }

  public Point find(Color paramColor, int paramInt)
  {
    return find(paramColor.red, paramColor.green, paramColor.blue, paramInt);
  }

  public Point find(Point paramPoint1, Point paramPoint2, Color paramColor)
  {
    return find(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, paramColor.red, paramColor.green, paramColor.blue);
  }

  public Point find(Point paramPoint1, Point paramPoint2, Color paramColor, int paramInt)
  {
    return find(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, paramColor.red, paramColor.green, paramColor.blue, paramInt);
  }

  public ArrayList<Rect> findLine(float paramFloat, int paramInt)
  {
    return findLine(this.a / 2, 10, -10 + this.a, this.b - paramInt * 16, paramFloat, paramInt * 8, paramInt * 4, paramInt);
  }

  public ArrayList<Rect> findLine(float paramFloat, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if (this.b < this.a)
    {
      i = this.a / 2;
      j = 0;
      k = -10 + this.a;
    }
    for (int m = this.b - paramInt1; ; m = this.a)
    {
      return findLine(i, j, k, m, paramFloat, paramInt1, paramInt2 * 4, paramInt2);
      i = this.a / 2;
      j = this.a / 3;
      k = -10 + this.a;
    }
  }

  public ArrayList<Rect> findLine(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    int k;
    if (this.b < this.a)
    {
      i = this.a / 2;
      j = 0;
      k = -10 + this.a;
    }
    for (int m = this.b - paramInt1; ; m = this.a)
    {
      return findLine(i, j, k, m, paramFloat, paramInt1, paramInt2, paramInt3);
      i = this.a / 2;
      j = this.a / 3;
      k = -10 + this.a;
    }
  }

  public ArrayList<Rect> findLine(int paramInt)
  {
    return findLine(this.a / 2, 10, -10 + this.a, this.b - paramInt * 16, 0.5F, paramInt * 8, paramInt * 4, paramInt);
  }

  public ArrayList<Rect> findLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (this.d == null)
    {
      this.d = ((float[][])Array.newInstance(F.class, new int[] { this.a, this.b }));
      float[] arrayOfFloat = new float[3];
      int i1 = 0;
      float f3;
      for (float f2 = 0.0F; i1 < this.b; f2 = f3)
      {
        f3 = f2;
        for (int i2 = 0; i2 < this.a; i2++)
        {
          android.graphics.Color.colorToHSV(this.c[i2][i1], arrayOfFloat);
          this.d[i2][i1] = arrayOfFloat[2];
          f3 += arrayOfFloat[2];
        }
        i1++;
      }
      this.e = (f2 / (this.a * this.b));
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(I.class, new int[] { this.a, this.b });
    float f1 = paramFloat * this.e;
    for (int i = 0; i < this.b; i++)
      for (int n = 0; n < this.a; n++)
        if (this.d[n][i] > f1)
          arrayOfInt[n][i] = 1;
        else
          arrayOfInt[n][i] = 0;
    ArrayList localArrayList = new ArrayList();
    for (int j = paramInt1; j < paramInt3; j++)
      for (int k = paramInt2; k < paramInt4; k++)
      {
        int m = a(j, k, arrayOfInt, paramInt5, paramInt6, paramInt7);
        if (m > -1)
        {
          j += paramInt7;
          localArrayList.add(new Rect(j, k, j, m + j));
          break;
        }
      }
    return localArrayList;
  }

  public int[][] getPixels()
  {
    return this.c;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.ColorFinder
 * JD-Core Version:    0.6.2
 */