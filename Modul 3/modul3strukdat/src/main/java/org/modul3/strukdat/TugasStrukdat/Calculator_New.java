/*  Farriel Arrianta Akbar Pratama
 *   202210370311077
 *   Struktur Data 4D
 */
package org.modul3.strukdat.TugasStrukdat;
import java.util.*;

public class Calculator_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ekspresi infix (tanpa spasi): ");
        String infix = scanner.next();
        String postfix = infixToPostfix(infix);
        System.out.println("Ekspresi postfix: " + postfix);
        int result = evaluatePostfix(postfix);
        System.out.println("Hasil perhitungan: " + result);
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(c, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2; // Ubah ke operasi pembagian
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
