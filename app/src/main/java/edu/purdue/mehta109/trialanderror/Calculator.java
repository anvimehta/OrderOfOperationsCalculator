package edu.purdue.mehta109.trialanderror;

import java.util.Stack;
import java.util.Scanner;
public class Calculator {
    public static int flag;
    public static String finalValueString;
    public static boolean flagValue=false;
    public static String evaluate(String expression) {
        char[] array = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ')
                continue;
            if (array[i] >= '0' && array[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < array.length && array[i] >= '0' && array[i] <= '9')
                    buffer.append(array[i++]);
                values.push(Integer.parseInt(buffer.toString()));
            }
            else if (array[i] == '(')
                operations.push(array[i]);
            else if (array[i] == ')') {
                while (operations.peek() != '(')
                    values.push(applyOp(operations.pop(), values.pop(), values.pop()));
                operations.pop();
            }
            else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/') {
                while (!operations.empty() && hasPrecedence(array[i], operations.peek()))
                    values.push(applyOp(operations.pop(), values.pop(), values.pop()));
                operations.push(array[i]);
            }
        }
        while (!operations.empty())
            values.push(applyOp(operations.pop(), values.pop(), values.pop()));
        int finalValue = values.pop();
        if(flag == 0) {
            finalValueString=Integer.toString(finalValue);
        }
        return finalValueString;
    }
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if(a == 0 && b == 0) {
                    flag = 1;
                    //System.out.println("Result    \t:\tError");
                }else if(a != 0 && b == 0){
                    flag = 2;
                    //System.out.println("Result    \t:\t∞");
                } else{
                    return a / b;
                }
        }
        return 0;
    }
    public static String bugFix(String eq){
        flag = 0;
        //System.out.println("Enter an expression:");
        Scanner scanner = new Scanner(System.in);
        String input=eq;
        if(input.charAt(0)=='-'){
            input = "0" + input;
        }else if(input.charAt(0)=='+' || input.charAt(0)=='*' || input.charAt(0)=='/'){
            input  = input.substring(1);
        }
        if(input.contains("(")){
            int x = input.indexOf('(');
            if(x!=0) {
                Character s = input.charAt(x - 1);
                String sub = s.toString();
                String temp = input;
                if (!sub.equals("+") && !sub.equals("-") && !sub.equals("*") && !sub.equals("/")) {
                    if (x == 1) {
                        Character t = input.charAt(0);
                        String te = t.toString();
                        temp = te + "*" + input.substring(1, input.length());
                    } else {
                        temp = input.substring(0, x) + "*" + input.substring(x, input.length());
                    }
                }
                input = temp;
            }
        }
        if(input.contains(")")){
            int y = input.length()-1;
            int x = input.indexOf(')');
            if(x!=y) {
                Character s = input.charAt(x + 1);
                String sub = s.toString();
                String temp = input;
                if (!sub.equals("+") && !sub.equals("-") && !sub.equals("*") && !sub.equals("/")) {
                    temp = input.substring(0, x + 1) + "*" + input.substring(x + 1, input.length());
                }
                input = temp;
            }
        }

        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("-", " - ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("/", " / ");
        input = input.replaceAll("\\(", "( ");
        input = input.replaceAll("\\)", " )");
        return input;
    }
    public static String total(String equation){
        //System.out.println("Welcome to the calculator!");
        int one = 1;
        do {
            String input = Calculator.bugFix(equation);
            //System.out.println("Expression\t:\t" + input);
            Calculator.evaluate(input);
            if(flag==1) {
                return "Error";
            }else if(flag==2){
                return "∞";
            }else {
                return finalValueString;
            }
        }while (one==1);
    }
}