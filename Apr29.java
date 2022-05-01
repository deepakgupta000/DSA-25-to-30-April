package com.DSA_25_30_April;

/*"""1. Evaluate a postfix expression
https://www.techiedelight.com/evaluate-given-postfix-expression/

2. Basic Calculator
https://leetcode.com/problems/basic-calculator-ii/"""
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Apr29 {
	public static void main(String[] args) {
		System.out.println(calculate("3+5 / 2"));
		System.out.println(evalPostfix("138*+"));
	}

	public static int evalPostfix(String exp) {
		if (exp == null || exp.length() == 0) {
			System.exit(-1);
		}

		Stack<Integer> stack = new Stack<>();

		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else {
				int x = stack.pop();
				int y = stack.pop();

				if (c == '+') {
					stack.push(y + x);
				} else if (c == '-') {
					stack.push(y - x);
				} else if (c == '*') {
					stack.push(y * x);
				} else if (c == '/') {
					stack.push(y / x);
				}
			}
		}

		return stack.pop();
	}

	public int calculate1(String s) {
		s = s.replaceAll("\\s+", "");
		Set<String> operands = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
		Stack<String> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < s.length();) {
			int j = i;
			while (j < s.length() && !operands.contains(s.charAt(j) + ""))
				++j;
			if (i != j) {
				String num = s.substring(i, j);
				if (stack.size() > 0 && operands.contains(stack.peek())) {
					String operand = stack.pop();
					int temp = 0;
					if (operand.equals("+"))
						temp = Integer.parseInt(num);
					if (operand.equals("-"))
						temp = -1 * Integer.parseInt(num);
					if (operand.equals("/"))
						temp = Integer.parseInt(stack.pop()) / Integer.parseInt(num);
					if (operand.equals("*"))
						temp = Integer.parseInt(stack.pop()) * Integer.parseInt(num);
					stack.push(temp + "");
				} else
					stack.push(num);
				i = j;
			} else {
				stack.push(s.charAt(i) + "");
				i++;
			}
		}
		while (!stack.isEmpty())
			res += Integer.parseInt(stack.pop());
		return res;
	}

	private static int calculate(String s) {
		int currNo = 0;
		char op = '+';
		int len = s.length();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {
				currNo = (currNo * 10) + (ch - '0');
			}

			if (!Character.isDigit(ch) && ch != ' ' || i == len - 1) {
				if (op == '+') {
					stack.push(currNo);
				} else if (op == '-') {
					stack.push(-currNo);
				} else if (op == '*') {
					stack.push(stack.pop() * currNo);
				} else if (op == '/') {
					stack.push(stack.pop() / currNo);
				}
				currNo = 0;
				op = ch;
			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}