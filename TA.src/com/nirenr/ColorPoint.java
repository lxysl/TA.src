package com.nirenr;

import android.graphics.Point;

public class ColorPoint
{
  public int blue;
  public int green;
  public int offset;
  public int red;
  public int x;
  public int y;

  public ColorPoint(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.red = paramInt3;
    this.green = paramInt4;
    this.blue = paramInt5;
    this.offset = paramInt6;
  }

  public ColorPoint(Point paramPoint, Color paramColor, int paramInt)
  {
    this(paramPoint.x, paramPoint.y, paramColor.red, paramColor.green, paramColor.blue, paramInt);
  }

  public ColorPoint(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt[0];
    this.y = paramArrayOfInt[1];
    this.red = paramArrayOfInt[2];
    this.green = paramArrayOfInt[3];
    this.blue = paramArrayOfInt[4];
    this.offset = paramArrayOfInt[5];
  }

  public boolean check(int[][] paramArrayOfInt)
  {
    return check(paramArrayOfInt, 0, 0);
  }

  public boolean check(int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = this.red - this.offset;
    int j = this.red + this.offset;
    int k = this.green - this.offset;
    int m = this.green + this.offset;
    int n = this.blue - this.offset;
    int i1 = this.blue + this.offset;
    int i2 = paramArrayOfInt[(paramInt2 + this.y)][(paramInt1 + this.x)];
    int i3 = i2 << 8 >>> 24;
    int i4 = i2 << 16 >>> 24;
    int i5 = i2 << 24 >>> 24;
    return (i3 >= i) && (i3 <= j) && (i4 >= k) && (i4 <= m) && (i5 >= n) && (i5 <= i1);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.ColorPoint
 * JD-Core Version:    0.6.2
 */