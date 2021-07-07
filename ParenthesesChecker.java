package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesesChecker {

	static void checker(char[] arr) {
		Stack<Character> stack = new Stack<>();
		boolean valid = true;
		for(char temp: arr) {
			if(temp == '{' || temp == '[' || temp == '(') {
				stack.push(temp);
			} 
			else if(stack.empty()) {
				valid = false;
				break;
			}
			else {
				if(temp == '}' && stack.peek() == '{') stack.pop();
				else if(temp == ']' && stack.peek() == '[') stack.pop();
				else if(temp == ')' && stack.peek() == '(') stack.pop();
				else {
					valid = false;
					break;
				}
			}
		}
		if(!stack.empty() || !valid) System.out.println("Not balanced");
		else System.out.println("Balanced");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			char[] arr = br.readLine().toCharArray();
			checker(arr);
		}		
	}

}
