package problemSet_1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
// https://www.interviewbit.com/problems/redundant-braces/
public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        for(char ch : A.toCharArray()){
            if (ch == '(' || set.contains(ch)) {
                stack.push(ch);
            } else if (ch == ')'){
                if(!set.contains(stack.peek())) return 1;
                stack.pop();
                stack.pop();
            }
        }
        return 0;
    }
}
