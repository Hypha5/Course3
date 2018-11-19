

/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java. util. Scanner;
public class CaesarBreaker 
{
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
    public String decryptTwoKeys(String encrypted)
    {
        CesarCipher cc = new CesarCipher();
        String firsthalf = halfOfString(encrypted,0);
        String secondhalf = halfOfString(encrypted,1);
        int key1 = getkey(firsthalf);
        int key2 = getkey(secondhalf);
        System.out.println("Two keys are" + "\t key1 =" + key1 + "\tkey2 =" + key2);
        String decrypted = cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
        return decrypted;
        
    }
    public String decrypt(String encrypted)
    {
        CesarCipher cc = new CesarCipher();
        int key = getkey(encrypted);
        System.out.println("The key is:" +key);
        String decrypted = cc.encrypt(encrypted, 26-key);
        return decrypted;
    }
    public void testDecrypttwokeys()
    {
       FileResource resource = new FileResource();
       String message = resource.asString();
       System.out.println(message);
       String decryptmessage = decryptTwoKeys(message);
       System.out.println(decryptmessage);
    }
     public void testDecryptonekey()
    {
       FileResource resource = new FileResource();
       String message = resource.asString();
       System.out.println(message);
       String decryptmessage = decrypt(message);
       System.out.println(decryptmessage);
    }
    public static void main(String []args)
    {
        CaesarBreaker mybreaker = new CaesarBreaker();
        Scanner s= new Scanner(System.in); 
        System.out.println("Enter your choice to decrypt by one key press 'o' or 'O' to decrypt by two keys press 't' or 'T'");
        char choice = s.next().charAt(0);
        choice = Character.toLowerCase(choice);
        switch(choice)
        {
            case 'o' : mybreaker.testDecryptonekey();
                        break;
            case 't' : mybreaker.testDecrypttwokeys();
                        break;
            default : System.out.println("Invalid Choice");
                        
        }
    }
    
}

