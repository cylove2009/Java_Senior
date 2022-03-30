import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_139_Word_Break {


    /*

    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word
     */

    public boolean wordBreak(String s, List<String> wordDict) {

        //char[] sr= s.toCharArray();

        int j = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++){

            if (wordDict.contains(s.substring(j, i + 1))) {

                ;
                count +=( i - j + 1);
                j = i;

                System.out.println(j);
                j++;
            }
        }

        System.out.println(count);

        if(count == s.length())
            return true;
        else
            return false;

    }

    @Test
    public void testWordBreak(){

        StringBuilder s = new StringBuilder("aaaaaaa");
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        wordBreak(s.toString(),wordDict);





    }
}
