
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher 
{
    private String alphabet;
    private String shiftalphabet;
    private int mainkey;
    public CaesarCipher(int key)
    {
        mainkey = key;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftalphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);
        for(int k = 0; k < encrypted.length(); k++)
        {
            
            char currChar = encrypted.charAt(k);
            int idx = alphabet.indexOf(Character.toLowerCase(currChar));
            if(idx != -1)
            {
                char newChar = shiftalphabet.charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
            
        }
        return encrypted.toString();
    }
    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher(26-mainkey);
        String decrypt = cc.encrypt(encrypted);
        return decrypt;
    }
    
}
