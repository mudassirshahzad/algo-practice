package com.mudassirshahzad.algos;

import java.util.Stack;

class BalanceTheBrackets {

    public static void main(String... strings) {

        BalanceTheBrackets obj = new BalanceTheBrackets();
        String sample1 = "[]{}(){}()()()()[][][][][]";
        String sample2 = "[{([{([{(())}])}])}]";
        String sample3 = "[{([{([{(())}])}])}";

        if (obj.areBalanced(sample1) == Boolean.TRUE &&
            obj.areBalanced(sample2) == Boolean.TRUE &&
            obj.areBalanced(sample3) == Boolean.FALSE) {

            System.out.println("All tests passed");
        }
        else {

            System.out.println("Tests failures");
        }

    }

    private Boolean areBalanced(String brackets) {

        if (brackets == null || brackets.isEmpty()) {
            return Boolean.FALSE;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < brackets.length(); i++) {

            if (brackets.charAt(i) == '(' || brackets.charAt(i) == '{' || brackets.charAt(i) == '[') {
                stack.push(brackets.charAt(i));
            }
            else {

                if (stack.isEmpty()) {
                    return Boolean.FALSE;
                }

                char top = stack.pop();
                if (brackets.charAt(i) == ')' && top != '(') {
                    return Boolean.FALSE;
                }
                else if (brackets.charAt(i) == '}' && top != '{') {
                    return Boolean.FALSE;
                }
                else if (brackets.charAt(i) == ']' && top != '[') {
                    return Boolean.FALSE;
                }

            }

        }

        return stack.isEmpty();
    }

}