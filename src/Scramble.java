import java.util.List;

public class Scramble {

    public static String scrambleWord(String scrambleStr){
        //e.g. "A" or empty String "" will not make any changes to scrambleStr
        if (scrambleStr.length() < 2){
            return  scrambleStr;
        }

        for (int i = 0; i < scrambleStr.length() - 1; i++){
            //if 2 consecutive letters, 1st one is A and 2nd one IS NOT A
            if (scrambleStr.charAt(i) == 'A' && scrambleStr.charAt(i+1) != 'A'){
                //e.g. for "THANK", scrambleStr will scramble to TH + N + A + K
                scrambleStr = scrambleStr.substring(0,i) + scrambleStr.charAt(i+1) + scrambleStr.charAt(i) + scrambleStr.substring(i+2);
                i++;
            }
        }
        return scrambleStr;
    }

    public static List<String> scrambleOrRemove(List<String> wordList){
        for (int i = 0; i < wordList.size(); i++){
            //if wordList element at index is identical to scrambleWord( element at index )
            //a.k.a. if scrambleWord() doesn't change the element
            if (wordList.get(i).equals( Scramble.scrambleWord(wordList.get(i)) )){
                wordList.remove(i);
                i--;
                //must remember, once element removed, size decrease by 1, so index must decrease by 1 as well
            }
            else{
                wordList.set(i, Scramble.scrambleWord(wordList.get(i)) );
            }
        }
        return wordList;
    }
}
