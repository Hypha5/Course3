
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts)
    {
        String [] vocab = new String[31] ;
        for(String word : resource.words())
        {    
            int wordlength = word.length();
            
            if (wordlength >= counts.length) 
            {                
                wordlength = counts.length - 1;       
            }
            if((Character.isLetter(word.charAt(0)) == false)|| (Character.isLetter(word.charAt(word.length()-1))== false))
            {
                wordlength--;
            }
            if (wordlength > 0 ) 
            {            
                counts[wordlength] ++;
                if(vocab[wordlength] == null)
                {
                    vocab[wordlength] = word;
                }
                else
                {
                    vocab[wordlength] = vocab[wordlength] + " " + word;
                }
            }
        }
        for(int k = 0; k < counts.length; k ++)
        {
            if(counts[k] > 0)
            {
                System.out.println(counts[k] + "words of length" + k +":" +vocab[k]);
            }
        }
    }
    public int indexOfMax(int[] values)
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
    public void testCountWordLengths()
    {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        int idx = 0;
        countWordLengths(resource,counts);
        int maxdex = indexOfMax(counts);
        System.out.println("Maximum number of words with same length:" + maxdex +"in above list"); 
        
    }
    public static void main(String []args)
    {
        WordLengths myword = new WordLengths();
        myword.testCountWordLengths();
    }
}
