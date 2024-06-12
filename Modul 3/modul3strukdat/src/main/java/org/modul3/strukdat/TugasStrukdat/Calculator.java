package org.modul3.strukdat.TugasStrukdat;

import java.util.Stack;

public class Calculator {
    public static int evaluateInfix(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }
            if (Character.isDigit(tokens[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && Character.isDigit(tokens[i])) {
                    sb.append(tokens[i++]);
                }
                i--;
                values.push(Integer.parseInt(sb.toString()));
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.empty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> values = new Stack<>();

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            if (Character.isDigit(token.charAt(0))) {
                values.push(Integer.parseInt(token));
            } else {
                int b = values.pop();
                int a = values.pop();
                values.push(applyOperator(token.charAt(0), a, b));
            }
        }

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    public static int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Tidak bisa dibagi dengan 0");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String infixExpression = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        String postfixExpression = "3 4 2 * 1 5 - 2 3 ^ ^ / +";

        System.out.println("Infix : " + infixExpression);
        System.out.println("Postfix : " + postfixExpression);

        int resultInfix = evaluateInfix(infixExpression);
        int resultPostfix = evaluatePostfix(postfixExpression);

        System.out.println("Hasil dari infix  " + resultInfix);
        System.out.println("Hasil dari postfix : " + resultPostfix);
    }
}
