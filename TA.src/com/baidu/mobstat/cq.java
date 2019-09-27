package com.baidu.mobstat;

import android.annotation.SuppressLint;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class cq
{
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str = b(a(), b(), paramArrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  public static byte[] a()
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(128, new SecureRandom());
    return localKeyGenerator.generateKey().getEncoded();
  }

  @SuppressLint({"TrulyRandom"})
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
    return localCipher.doFinal(paramArrayOfByte3);
  }

  public static String b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      byte[] arrayOfByte = a(paramArrayOfByte1, paramArrayOfByte2, cv.a(paramArrayOfByte3));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ct.b(arrayOfByte));
      localStringBuilder.append("|");
      localStringBuilder.append(da.a(paramArrayOfByte1));
      localStringBuilder.append("|");
      localStringBuilder.append(da.a(paramArrayOfByte2));
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
      cz.b(localException);
    }
    return "";
  }

  public static byte[] b()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.cq
 * JD-Core Version:    0.6.2
 */