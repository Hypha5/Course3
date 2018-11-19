
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    public int[] countLetters(String message)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k = 0; k < message.length(); k++)
        {
            char currchar = Character.toLowerCase(message.charAt(k));
            int idex = alph.indexOf(currchar);
            if(idex != -1)
            {
                counts[idex] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int[] values)
    {
        int maxdex = 0;
        for(int k = 0; k < values.length; k++)
        {
            if(values[k] > values[maxdex])
            {
                maxdex = k;
            }
        }
        return maxdex;
    }
    public String halfOfString(String message, int start)
    {
        StringBuilder halfString = new StringBuilder();
        for(int k = start; k < message.length(); k = k + 2)
        {
            halfString.append(message.charAt(k));
        }
        return halfString.toString();
    }
    public int getkey(String encrypted)
    {
        int[] freqs = countLetters(encrypted);
        int maxdex = maxIndex(freqs);
        int dkey = maxdex - 4;
        if(maxdex < 4)
        {
            dkey = 26 - (4 - maxdex);
        }
        return dkey;
        
    }
    public String breakCaesarCipher(String encrypted)
    {
        
        String firsthalf = halfOfString(encrypted,0);
        String secondhalf = halfOfString(encrypted,1);
        int key1 = getkey(firsthalf);
        int key2 = getkey(secondhalf);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        System.out.println("Two keys are" + "\t key1 =" + key1 + "\tkey2 =" + key2);
        String decrypted = cc.decrypt(encrypted);
        return decrypted;
        
    }
    public void simpleTests()
    {
        FileResource resource = new FileResource();
        String message = resource.asString();
        CaesarCipherTwo myobject = new CaesarCipherTwo(23, 2);
        String encrypted = myobject.encrypt(message);
        System.out.println("The encrypted message is :" + encrypted);
        String decrypted = myobject.decrypt(encrypted);
        System.out.println("The decrypted message is:" + decrypted);
        String decryptmessage = breakCaesarCipher(encrypted);
        System.out.println("Caesar Cipher has broken:" +decryptmessage);
        
        
    }
}
