import org.junit.Test;

import java.util.HashMap;

public class Leetcode_5_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {

        char[] sr = s.toCharArray();
        int i_gobal = 0;
        int len = Integer.MIN_VALUE;

        if(s.length() < 2) {

            if (sr[0] == sr[1])
                return s;
            else
                return "";

        }

        for(int i = 0; i < s.length(); i++) {

            //aba
            int left = i;
            int right = i;

            while (left > 0 && right < s.length()-1) {
                --left;
                ++right;
                if (sr[left] == sr[right]) {

                    if( len < right -left + 1) {
                        len = (len < right - left + 1) ? right - left + 1 : len;
                        i_gobal = left;
                    }
                    left--;
                    right++;

                } else
                    break;

            }
        }


            //abba

        for(int i = 0; i < s.length(); i++){

                int left = i;
                int right = i +1;

                while(left >= 0 && right < s.length()){
                    if (sr[left] == sr[right]){
                        if( len < right -left + 1) {
                            len = (len < right - left + 1) ? right - left + 1 : len;
                            i_gobal = left;
                        }
                        System.out.println("double case------" + left + "len" + len);
                        left--;
                        right++;

                    }else
                        break;
                }

        }

        return s.substring(i_gobal,len);

    }

//    public boolean isPalindrome(String s){
//
//
//    }


//    public String longestPalindrome_withreference(String s) {
//
//
//    }
    @Test
    public void testlongestPalindrome() {

        String s = "cbbd";

        System.out.println(longestPalindrome(s));

    }


    public String firstPalindrome(String[] words) {

        StringBuilder ret = null;

        for(String s : words){

            ret = new StringBuilder(s);

            if(ret.reverse().toString().equals(s));
                return s;

        }

        return "";

    }


    public int missingNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++){

            if(nums[i] < min);
                min = nums[i];
                map.put(nums[i],1);
        }

        for(int i = 0 ; i < nums.length; i++){

            if(map.containsKey(min))
                min++;
            else
                return min;
        }

        return min + 1;
    }
}
