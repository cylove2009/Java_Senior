import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_49_Group_Anagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        //List<String> ls = new ArrayList<>();

//        List<List<String>> ret = new ArrayList<>();
//
//        for(int i = 0 ; i < strs.length ; i++) {
//
//            List<String> ls = new ArrayList<>();
//            ls.add(strs[i]);
//            for(int j = i+1 ; j < strs.length ; j++)
//            {
//
//                if (isAnagram(strs[i], strs[j])) ;
//
//                    ls.add(strs[j+1]);
//
//            }
//            ret.add(ls);
//        }

        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();

        for(String s:strs){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String s2 = String.valueOf(array);

            if(!map.containsKey(s2)) {
                map.put(s2, new ArrayList<String>());
                map.get(s2).add(s);
            }
            else {

                map.get(s2).add(s);
                ret.add(map.get(s2));

            }

        }
        //how to return maps values?
        return ret;
    }


    public List<List<String>> groupAnagrams_accepted(String[] strs)  {

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String s2 = String.valueOf(array); //sorting the anagram string

            if(!map.containsKey(s2)) {
                map.put(s2, new ArrayList<String>());
                map.get(s2).add(s);
            }
            else {
                map.get(s2).add(s);
            }

        }

        return new ArrayList<>(map.values());

        //return ret;
    }
}
