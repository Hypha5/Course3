
/**
 * Write a description of CesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java. util. Scanner;
public class CesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = alphabet1.substring(key) + alphabet1.substring(0, key);
        String shiftedAlphabet2 = alphabet2.substring(key) + alphabet2.substring(0, key);
        for(int i = 0; i < encrypted.length(); i++)
        {
            char currChar = encrypted.charAt(i);
            int idx1 = alphabet1.indexOf(currChar);
            int idx2 = alphabet2.indexOf(currChar);
            if(idx1 != -1)
            {
                char newChar = shiftedAlphabet1.charAt(idx1);
                encrypted.setCharAt(i, newChar);
            }
            else if(idx2 != -1)
            {
                char newChar2 = shiftedAlphabet2.charAt(idx2);
                encrypted.setCharAt(i, newChar2);
            }
       }
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++)
        {
            if(i%2 == 0)
            {
                String currString1 = String.valueOf(input.charAt(i));
                String result1 = encrypt(currString1, key1);
                char currchar1 = result1.charAt(0);
                encrypted.setCharAt(i,currchar1);
            }
            else if(i%2 != 0)
            {
                String currString2 = String.valueOf(input.charAt(i));
                String result2 = encrypt(currString2, key2);
                char currchar2 = result2.charAt(0);
                encrypted.setCharAt(i,currchar2);
            }
        }
        return encrypted.toString();
    }
    public void testCesar()
    {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter first key for encryption");
       String inputString = in.nextLine();
       int key1 = Integer.parseInt(inputString);
       Scanner in2 = new Scanner(System.in);
       System.out.println("Enter second key for encryption");
       String inputString2 = in2.nextLine();
       int key2 = Integer.parseInt(inputString2);
       FileResource fr = new FileResource();
       String message = fr.asString();
       String encrypted = encryptTwoKeys(message, key1, key2);
       System.out.println(message);
       System.out.println(encrypted);
    }
    public static void main(String []args){
        CesarCipher mycipher = new CesarCipher();
        mycipher.testCesar();
    }
}
