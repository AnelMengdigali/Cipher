/** The interface that have methods of encryption and decryption */
public interface Cipher {

    public String encrypt( String alphabet, String plainText, String key );

    public String decrypt( String alphabet, String cipherText, String key );

}
