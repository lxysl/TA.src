package com.nirenr;

public class Color
{
  public int blue;
  public int green;
  public int red;

  public Color(int paramInt)
  {
    this.red = (paramInt << 8 >>> 24);
    this.green = (paramInt << 16 >>> 24);
    this.blue = (paramInt << 24 >>> 24);
  }

  public Color(int paramInt1, int paramInt2, int paramInt3)
  {
    this.red = paramInt1;
    this.green = paramInt2;
    this.blue = paramInt3;
  }

  public int getInt()
  {
    return 0xFF000000 | this.red << 16 | this.green << 8 | this.blue;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Color(");
    localStringBuilder.append(this.red);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.green);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.blue);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.nirenr.Color
 * JD-Core Version:    0.6.2
 */