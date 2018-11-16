
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordPlay {
    public String emphasize(String phrase, char ch){
        StringBuilder str = new StringBuilder(phrase);
        char currChar;
        for(int i =0; i < str.length(); i++){
            currChar = str.charAt(i);
            if((Character.toLowerCase(currChar) == ch)&&(i%2 == 0))
            {
                str.setCharAt(i, '*');
            }
            else if((Character.toLowerCase(currChar) == ch)&&(i%2 != 0)){
                str.setCharAt(i, '+');
            }
        
        
        }
        return str.toString();
}
    public String replaceVowel(String phrase, char ch){
        char currChar;
        StringBuilder str = new StringBuilder(phrase);
        for(int i = 0; i < str.length(); i++){
            currChar = str.charAt(i);
            if(isVowel(currChar)==true)
            {
                str.setCharAt(i,ch); 
            }
            
        }
        return str.toString();
    }
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
       }
       return false;
    }
    public void testWordplay(){
        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            String result1 = replaceVowel(line,'*');
            String result2 = emphasize(line,'a');
            System.out.println(result1);
            System.out.println(result2);
        }
        
    }
    public static void main(String []args){
        WordPlay myword = new WordPlay();
        myword.testWordplay();
    }

}
