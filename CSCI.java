import java.util.Scanner;
//I CLAIM THE ALPHABET BONUS

/** The runnable class that operates with encryption and decryption proccess */
public class CSCI {

    private static final String menu = "CSCI Cipher Operation:\n" +
                                       "-------------------------------------\n" +
                                       "1. Decrypt and verify Caesar cipher\n" +
                                       "2. Decrypt and verify Vigenere cipher\n" +
                                       "3. Display this menu again\n" +
                                       "4. Quit\n";

    private static final String choiceMessage = "Choice : ";
    private static final String invalidChoiceMessage = "Invalid choice! Try again.";
    private static final String quitMessage = "Have a crime-free day!";
    private static final String plainTextMessage = "Plain text                               : ";
    private static final String plainReEncryptMessage = "Plain text re-encrypted for verification : ";
    private static final String verificationMessage = "Are cipher text and encrypted text equal : ";
    private static final String enterAlphabet = "Enter alphabet    : ";
    private static final String enterCipherText = "Enter cipher text : ";
    private static final String enterKey = "Enter key         : ";

    private static final Caesar Caesar = new Caesar();
    private static final Vigenere Vigenere = new Vigenere();

    /** Main method that does main frame and work with Caesar and Vigenere classes */
    public static void main( String[] args ) {

        Scanner inputScanner = new Scanner( System.in );
        Scanner scannerForText = new Scanner( System.in );

        System.out.println( menu );
        System.out.print( choiceMessage );

        int choice = inputScanner.nextInt();
        System.out.println();

        do {

            if ( choice < 1 || choice > 4 ) {

                System.out.println( invalidChoiceMessage );
                System.out.println();

            } else if ( choice == 3 ) {

                System.out.println( menu );

            } else {

                System.out.print( enterAlphabet );
                String alphabet = scannerForText.next();
                System.out.print( enterCipherText );
                String text = scannerForText.next();
                System.out.print( enterKey );
                String key = inputScanner.next();
                System.out.println();

                if ( choice == 1 ) {

                    String plainText = Caesar.decrypt( alphabet, text, key );
                    System.out.println( plainTextMessage + plainText );
                    String cipherText = Caesar.encrypt( alphabet, plainText, key );
                    System.out.println( plainReEncryptMessage + cipherText );
                    System.out.println( verificationMessage + text.equals( cipherText ) );

                } else {

                    String plainText = Vigenere.decrypt( alphabet, text, key );
                    System.out.println( plainTextMessage + plainText );
                    String cipherText = Vigenere.encrypt( alphabet, plainText, key );
                    System.out.println( plainReEncryptMessage + cipherText );
                    System.out.println( verificationMessage + text.equals( cipherText ) );

                }

                System.out.println();

            }

            System.out.print( choiceMessage );
            choice = inputScanner.nextInt();
            System.out.println();

        } while ( choice != 4 );

        System.out.println( quitMessage );

    }

}
