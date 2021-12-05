package com.yubaer.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String []argh) {
		
		Scanner sc = new Scanner(System.in);
		
		// read line till EOF
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
	
	// balance parentheses check
	public static boolean checkStack(char[] inputArray) {
		Stack<Character> charStack = new Stack<Character>();
		for(char c : inputArray) {
			if(c=='(' ||
			   c=='{' ||
			   c=='[') {
				charStack.push(c);
			}
			// if close parentheses found, check start one,
			//which is the head of the stack
			// case: ()
			else if(c==')'){
					if(!charStack.isEmpty() && charStack.peek() =='(') {
						charStack.pop();
					}else {
						// parentheses not closed/ or some other character found
						return false;
					}
			}
			// case: {}
			else if(c=='}') {
				if(!charStack.isEmpty() && charStack.peek() =='{') {
					charStack.pop();
				}else {
					return false;
				}
			}
			// case: []
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