import java.util.HashMap;

public class Leetcode_205_Isomorphic_Strings {


    // non working
//    String s="bbbaaaba";
//    String t="aaabbbba";
//    values [6, 3]
//    values [3, 6]

    public boolean isIsomorphic(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();

        for(int i = 0 ; i < s1.length; i++){

            if(smap.containsKey(s1[i]))

                smap.put(s1[i],smap.get(s1[i])+1);
            else
                smap.put(s1[i], i);

        }

        for(int i = 0 ; i < t1.length; i++){

            if(tmap.containsKey(t1[i]))

                tmap.put(t1[i],tmap.get(t1[i])+1);
            else
                tmap.put(t1[i], i);

        }

        if(smap.values().containsAll(tmap.values()) &&  tmap.values().containsAll(smap.values()))
            return true;
        else
            return false;

    }
}
