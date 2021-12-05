package com.yubaer.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String []argh) {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
			char[] inputArray = input.toCharArray();
			
			if(checkStack(inputArray)) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}	
	}
	
	public static boolean checkStack(char[] inputArray) {
		Stack<Character> charStack = new Stack<Character>();
		for(char c : inputArray) {
			if(c=='(' ||
			   c=='{' ||
			   c=='[') {
				charStack.push(c);
			}
			else if(c==')'){
					if(!charStack.isEmpty() && charStack.peek() =='(') {
						charStack.pop();
					}else {
						return false;
					}
			}
			else if(c=='}') {
				if(!charStack.isEmpty() && charStack.peek() =='{') {
					charStack.pop();
				}else {
					return false;
				}
			}
			else if(c==']'){
				if(!charStack.isEmpty() && charStack.peek() =='[') {
					charStack.pop();
				}else {
					return false;
				}
			}
		}
		return charStack.isEmpty();
	}
}