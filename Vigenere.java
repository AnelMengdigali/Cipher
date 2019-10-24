import java.util.HashMap;

/** Implementation of encryption and decryption operation through the usage of Blaise de Vigenere method */
public class Vigenere implements Cipher {
    
    /** The main body of encrypt method */
    public String encrypt( String alphabet, String plainText, String key ) {

        return helper( alphabet, plainText, key, true );

    }

    /** The main body of decrypt method */
    public String decrypt( String alphabet, String cipherText, String key ) {

        return helper( alphabet, cipherText, key, false );

    }

    private static String helper( String alphabet, String plainText, String key, boolean type ){
       
        StringBuilder result = new StringBuilder();
        int[] intArrKey = new int[ key.length() ];
        HashMap< Character, Integer > charIntHashMap = new HashMap<>();
        HashMap< Integer, Character > intCharHashMap = new HashMap<>();

        for ( int i = 0; i < alphabet.length(); i++ ) {

            charIntHashMap.put( alphabet.charAt(i), i );
            intCharHashMap.put( i, alphabet.charAt(i) );

        }

        if( type ){

            for ( int i = 0; i < key.length(); i++ ) {

                intArrKey[i] = charIntHashMap.get( key.charAt(i) );

            }

            int keyCounter = 0; 

            for ( int i = 0; i < plainText.length(); i++ ) {

                int value = charIntHashMap.get( plainText.charAt(i) );
                value = mod( ( value + intArrKey[ keyCounter ] ), alphabet.length());
                keyCounter ++;

                if ( keyCounter > key.length() - 1 ) {

                    keyCounter = 0;

                }

                result.append( intCharHashMap.get( value ) );
            }
            return result.toString();

        }else {

            for ( int i = 0; i < key.length(); i++ ) {

                intArrKey[i] = charIntHashMap.get( key.charAt(i) );

            }

            int keyCounter = 0; 

            for ( int i = 0; i < plainText.length(); i++ ) {

                int value = charIntHashMap.get( plainText.charAt(i) );
                value = mod( ( value - intArrKey[ keyCounter ] ), alphabet.length() );
                keyCounter ++;

                if ( keyCounter > key.length() - 1 ) {

                    keyCounter = 0;

                }

                result.append( intCharHashMap.get( value ) );

            }
            return result.toString();

        }

    }

    private static int mod( int first, int second ) {

        int result = first % second;

        if ( result < 0 ) {

            result += second;

        }
        return result;

    }

}
