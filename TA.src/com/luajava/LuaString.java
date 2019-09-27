package com.luajava;

public class LuaString
  implements CharSequence
{
  private byte[] a = new byte[0];

  public LuaString(String paramString)
  {
    this.a = paramString.getBytes();
  }

  public LuaString(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }

  public char charAt(int paramInt)
  {
    return (char)this.a[paramInt];
  }

  public int length()
  {
    return this.a.length;
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(this.a, paramInt1, paramInt2);
  }

  public byte[] toByteArray()
  {
    return this.a;
  }

  public String toString()
  {
    return new String(this.a);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.luajava.LuaString
 * JD-Core Version:    0.6.2
 */