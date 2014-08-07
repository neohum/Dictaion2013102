package com.honeyv.dictation2013102;

import java.util.Stack;

public class Calculator {
    @SuppressWarnings("rawtypes")
	public static Stack<Comparable> stack = new Stack<Comparable>();
    
    // 연산자 우선순위를 판정 숫자화 반환
    private static int operatorPriority(char operator) {
        if(operator == '(') return 0;
        if(operator == '+' || operator == '-') return 1;
        if(operator == '*' || operator == '/') return 2;
        return 3;
    }
    
    // 연산자를 표현한 문자인지 검사
    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
    
    // 숫자를 표현한 문자인지 검사
    public static boolean isNumeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }
    
    // 중위표현식을 후위표현식으로 변환
    public static String postfix(String expression) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] exp;
        char ch;

        if(expression == null) {
            throw new NullPointerException("expression is null");
        }

        exp = expression.toCharArray();
        for(int i=0; i<exp.length; i++) {
            if(exp[i] == '(') {
                stack.push(exp[i]);

            } else if(exp[i] == ')') {
                while((ch = (Character)stack.pop()) != '(') {
                    sb.append(ch);
                    sb.append(' ');
                }

            } else if(isOperator(exp[i])) {
                while(!stack.isEmpty() && operatorPriority((Character)stack.peek()) >= operatorPriority(exp[i])) {
                    sb.append(stack.pop());
                    sb.append(' ');
                }
                stack.push(exp[i]);
            
            } else if(isNumeric(exp[i])) {
                do {
                    sb.append(exp[i++]);
                } while(i<exp.length && isNumeric(exp[i]));
                sb.append(' '); i--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }

        return sb.toString();
    }
    
    // 후위표현식을 계산
    public static int postfixCalc(String expression) throws Exception {
        char[] exp;
        int num;

 

        if(expression == null) {
            throw new NullPointerException("expression is null");
        }
        
        exp = expression.toCharArray();
        for(int i=0; i<exp.length; i++) {
            if(isNumeric(exp[i])) {
                num = 0;

 

                do {
                    num = num * 10 + exp[i++] - '0';
                } while(i < exp.length && isNumeric(exp[i]));
                stack.push(num); i--;

 

            } else if(exp[i] == '+') {
                stack.push((Integer)stack.pop() + (Integer)stack.pop());

 

            } else if(exp[i] == '*') {
                stack.push((Integer)stack.pop() * (Integer)stack.pop());

 

            } else if(exp[i] == '-') {
                num = (Integer)stack.pop();
                stack.push((Integer)stack.pop() - num);
            
            } else if(exp[i] == '/') {
                num = (Integer)stack.pop();
                stack.push((Integer)stack.pop() / num);
            }
        }

 

        return (Integer)stack.pop();
    }

}


