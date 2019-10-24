import java.util.HashMap;

/** Implementation of encryption and decryption operation through the usage of Julius Caesar method */
public class Caesar implements Cipher {

    /** The main body of encrypt method */
    public String encrypt( String alphabet, String plainText, String key ) {
       
        return helper( alphabet, plainText, key, true );

    }

    /** The main body of decrypt method */
    public String decrypt( String alphabet, String cipherText, String key ) {
        
        return helper( alphabet, cipherText, key, false );

    }

    private static String helper( String alphabet, String plainText, String key, boolean type ) {

        int intKey = Integer.parseInt( key );

        StringBuilder result = new StringBuilder();
        HashMap< Character, Integer > charIntHashMap = new HashMap<>();
        HashMap< Integer, Character > intCharHashMap = new HashMap<>();

        for ( int i = 0; i < alphabet.length(); i ++ ) {

            charIntHashMap.put( alphabet.charAt(i), i );
            intCharHashMap.put( i, alphabet.charAt(i) );

        }

        if ( type ) {

            for ( int i = 0; i < plainText.length(); i ++ ) {

                int value = charIntHashMap.get( plainText.charAt(i) );
                value = mod( ( value + intKey ), alphabet.length() );
                result.append( intCharHashMap.get( value ) );

            }
            return result.toString();

        } else {

            for ( int i = 0; i < plainText.length(); i ++ ) {

                int value = charIntHashMap.get( plainText.charAt(i) );
                value = mod( ( value - intKey ), alphabet.length() );
                result.append( intCharHashMap.get( value ) );

            }
            return result.toString();

        }

    }

    private static int mod( int first, int second ) {

        int modResult = first % second;

        if ( modResult < 0 ) {

            modResult += second;

        }
        return modResult;

    }

}
