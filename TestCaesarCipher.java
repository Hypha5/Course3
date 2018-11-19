
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
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
    public void simpleTests()
    {
        FileResource resource = new FileResource();
        String message = resource.asString();
        CaesarCipher myobject = new CaesarCipher(18);
        String encrypted = myobject.encrypt(message);
        System.out.println("Encrypted text:" +encrypted);
        String decrypted = myobject.decrypt(encrypted);
        System.out.println("Decrypted text:" +decrypted);
        String decryptmessage = breakCaesarCipher(encrypted);
        System.out.println("The CaesarCipher is broken:" +decryptmessage);
        
    }
    public String breakCaesarCipher(String input)
    {
        int[] freqs = countLetters(input);
        int maxdex = maxIndex(freqs);
        int dkey = maxdex - 4;
        if(maxdex < 4)
        {
            dkey = 26 - (4 - maxdex);
        }
        System.out.println("The key is:" +dkey);
        CaesarCipher cipher1 = new CaesarCipher(dkey);
        String decryptmessage = cipher1.decrypt(input);
        return decryptmessage;
        
    }

}
