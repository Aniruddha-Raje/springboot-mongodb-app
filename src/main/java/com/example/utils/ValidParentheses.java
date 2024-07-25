package com.example.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Stack;

@Log4j2
public class ValidParentheses {

//    private static final System.Logger logger = System.getLogger(ValidParentheses.class.getName());

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.peek();

                if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[]}()";
        log.debug("hello");
//        logger.log(System.Logger.Level.DEBUG, "The input string \"" + input + "\" is " + (isValid(input) ? "valid" : "not valid"));
    }
}