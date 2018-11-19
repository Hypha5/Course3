
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {

    private String alphabet, shiftalphabet1, shiftalphabet2;
    private int mainkey1,mainkey2;
    public CaesarCipherTwo(int key1, int key2)
    {
        mainkey1 = key1;
        mainkey2 = key2;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftalphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftalphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
    }
    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);
        for(int k = 0; k < encrypted.length(); k++)
        {
            if(k%2 == 0)
            {
                char currChar = encrypted.charAt(k);
                int idx = alphabet.indexOf(Character.toLowerCase(currChar));
                if(idx != -1)
                {
                    char newChar = shiftalphabet1.charAt(idx);
                    encrypted.setCharAt(k, newChar);
                }
            }
            else if(k%2 != 0)
            {
                char currChar = encrypted.charAt(k);
                int idx = alphabet.indexOf(Character.toLowerCase(currChar));
                if(idx != -1)
                {
                    char newChar = shiftalphabet2.charAt(idx);
                    encrypted.setCharAt(k, newChar);
                }
            }
            
        }
        return encrypted.toString();
    }
    public String decrypt(String encrypted)
    {
        CaesarCipherTwo cc = new CaesarCipherTwo(26-mainkey1,26-mainkey2);
        String decrypt = cc.encrypt(encrypted);
        return decrypt;
    }
    
    
}
