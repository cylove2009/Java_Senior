import org.junit.Test;

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

//    public String decodeString(String s) {
//
//        Stack<Character> stack = new Stack<>();
//
//        for(char i: s.toCharArray()){
//
//            if(i != ']'){
//                stack.add(i);
//            }else{
//                String number= "";
//                String str = "";
//
//                while(!stack.empty() && stack.peek() != '[' ){
//                    if(stack.peek() > 0 && stack.peek() <= 9){
//                        number = stack.pop() + number;
//                    }else{
//                        str = stack.pop() + str;
//                    }
//                }
//
//                int num = Integer.parseInt(number);
//                String tempRes = "";
//                while(num > 0){
//                    tempRes+=tempRes;
//                }
//
//                //stack.add(tempRes.toCharArray());
//
//
//
//            }
//
//        }
//
//    }

    public String decodeString_after_idea_ac(String s) {

        Stack<String> stack = new Stack<>();
        String res = "";
        int num = 0;

        for (char i : s.toCharArray()) {

            if( i >= '0' && i <= '9'){
                //num = Integer.valueOf(i) + num*10;
                num = (i - '0') + num * 10;
                //System.out.println(num);
            }else if( i == '['){

                stack.add(String.valueOf(num));
                //stack.add("" + num);
                stack.add(String.valueOf(i));
                //stack.add("" + i);
                num = 0;
            }else if( i == ']'){

                String temp = "";
                int times = 0;
                while(!stack.empty() && stack.peek().charAt(0) != '['){ //      while(!stack.empty() && stack.peek() != String.valueOf('[')){ -> incorrect
                                                                        //while(!stack.empty() && ! (stack.peek().equals("["))){ - correct
                    temp = stack.pop() + temp;
                    System.out.println("temo is ---- " + temp);

                }
                stack.pop();
                times = Integer.valueOf(stack.pop());
                String tempSum = "";
                //System.out.println(times);
                while(times >0){

                    tempSum += temp;
                    times--;
                }
                stack.add(tempSum);
            }else
                stack.add(String.valueOf(i));

            System.out.println(stack);
        }

        while(!stack.empty()){
            res = stack.pop() + res;
        }

        return res;
    }

//    private boolean isChar(char c){
//
//        if( c >= 'a' && c <= 'z' || c >= 'A' && c <= 'z')
//            return true;
//        else
//            return false;
//    }

    @Test
    public void testSoltuion(){

        String s = "3[a]2[bc]";

        System.out.println(decodeString_after_idea_ac(s));



    }

}
