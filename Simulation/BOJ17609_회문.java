package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609_회문 {
	static int flag;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			flag = 0;
			palindrome();
			sb.append(flag + "\n");
		}
		
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		br.close();
	}
	
	static void palindrome() {
		int start = 0;
		int end = str.length() - 1;
		
		while(start <= end) {
			char front = str.charAt(start);
			char back = str.charAt(end);
			if(front != back) {
				flag++;
				if(check(start+1,end)||check(start,end-1))return;
				flag++;
				return;
			}
			start++;
			end--;
		}
	}
	
	static boolean check(int s, int e) {
		int start = s;
		int end = e;
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
}
