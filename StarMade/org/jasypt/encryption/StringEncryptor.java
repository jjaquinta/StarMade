package org.jasypt.encryption;

public abstract interface StringEncryptor
{
  public abstract String encrypt(String paramString);

  public abstract String decrypt(String paramString);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.jasypt.encryption.StringEncryptor
 * JD-Core Version:    0.6.2
 */