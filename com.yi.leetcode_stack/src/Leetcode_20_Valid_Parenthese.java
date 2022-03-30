import java.util.Stack;

public class Leetcode_20_Valid_Parenthese {

    // use stack
    // my method goes with hashmap to maintain the left or right array of ({[
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){

            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){

                stack.push(s.charAt(i));
            }else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else
                return false;


        }

        return stack.empty();

    }
}
