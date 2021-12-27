package com.company;

import java.util.Stack;

public class Code20 {
    /**
     *   这道题 本身并不算难， 主要是考虑好边界条件
     *
     *   要考虑只有一个 char的场景 以及连续2个一样的((的场景
     *
     */
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (Character c:s.toCharArray()){
            if (c=='('){
                stack.push(')');
            }else if (c=='{'){
                stack.push('}');
            }else if (c=='['){
                stack.push(']');
            }else if (stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
