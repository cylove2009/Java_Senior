import java.util.Stack;

public class Leetcode_394_decode_string {


    /*


    Example 1:

    Input: s = "3[a]2[bc]"
    Output: "aaabcbc"
    Example 2:

    Input: s = "3[a2[c]]"
    Output: "accaccacc"
     */

    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for(char i: s.toCharArray()){

            if(i != ']'){
                stack.add(i);
            }else{
                String number= "";
                String str = "";

                while(!stack.empty() && stack.peek() != '[' ){
                    if(stack.peek() > 0 && stack.peek() <= 9){
                        number = stack.pop() + number;
                    }else{
                        str = stack.pop() + str;
                    }
                }

                int num = Integer.parseInt(number);
                String tempRes = "";
                while(num > 0){
                    tempRes+=tempRes;
                }

                stack.add(tempRes.toCharArray());



            }

        }

    }
}
