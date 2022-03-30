public class Leetcode_125_Valid_Palindrome {

    // two point, 思路没有问题，Character.isLetterOrDigit、Character.toLowerCase 不知道
    //需要算上数字
    public boolean isPalindrome(String s) {

        char[] sarry = s.toCharArray();
        int i = 0;
        int j = sarry.length - 1;

        while(i<j){

            char left = 'a';
            char right = 'a';

            if('a' <= sarry[i] && sarry[i]<= 'z'){
                left = sarry[i];
            }else if ('A' <= sarry[i] && sarry[i]<= 'Z')
                left = (char) (sarry[i] + 32);
            else
                i++;

            if('a' <= sarry[j] && sarry[j]<= 'z'){
                left = sarry[j];
            }else if ('A' <= sarry[j] && sarry[j]<= 'Z')
                left = (char) (sarry[j] + 32);
            else
                j--;

            if(sarry[i] == sarry[j]){
                i++;
                j--;
            }else
                return false;

        }
        return true;
    }
}
