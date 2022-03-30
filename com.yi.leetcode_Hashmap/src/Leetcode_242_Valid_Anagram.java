import com.sun.deploy.security.SelectableSecurityManager;
import org.junit.Test;

import java.util.HashMap;

public class Leetcode_242_Valid_Anagram {

    @Test
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) return false;

        int count = t.length();

        for (char i : s.toCharArray()) {

            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        for (char i : t.toCharArray()) {

            if (map.containsKey(i) && map.get(i) > 0) {
                //map.get(i)--;
                map.put(i,map.get(i)-1 );
                count--;
            }
            if(count == 0) return true;

        }

        return false;
    }


    public boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
