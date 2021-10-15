package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1218 {
	
	static boolean check(char top, char next) {
		if(top == '<' && next == '>')return false;
		if(top == '(' && next == ')')return false;
		if(top == '[' && next == ']')return false;
		if(top == '{' && next == '}')return false;
		
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		char next;
		
		for(int time = 1; time <= 10; time++) {
			
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			sb.append("#" + time + " ");
			
			for(int i = 0; i < str.length(); i++) {
				next = str.charAt(i);
				if(next == '<' ||next == '(' ||next == '[' ||next == '{') {st.push(next);}
				else {
					if((st.isEmpty() || check(st.pop(), next))) {
						st.clear();
						sb.append(0 + "\n");
						break;
					}
				}
				if(i == str.length() - 1) {sb.append(1 + "\n");}
			}		
		}
		
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
}
