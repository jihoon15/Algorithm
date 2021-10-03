package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637_괄호추가하기 {
	
	static int N;
	static String str;
	static int res = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		int first = Integer.parseInt(str.substring(0,1));
		// 처음것을 자르고 +7+7+7 이런식으로
		//  +(7+7)+7 괄호치거나
		// 안치고 +7+7 로넘어가거나
		
		dfs(1,first);
		
		
		System.out.println(res);
		br.close();
	}
	
	//계산은 왼쪽에서부터하는것, 그다음것에 괄호를 칠지말지 정하면됨
	static void dfs(int index, int value) {// 처음 0 0 시작이니깐
		if(index >= N) {
			res = Integer.max(res, value);
			return;
		}
		
		// 1 3 5 7 ... 19 = N
		char op1 = str.charAt(index);
		int a = Integer.parseInt(str.substring(index+1,index+2));
		//여기까진 무조건 있음
		
		dfs(index + 2, cal(value,a,op1));//괄호 안치고다음
		
		if( N - index > 2) {// 괄호칠 수 있을때 괄호칠거임 
			char op2 = str.charAt(index + 2);
			int b1 = Integer.parseInt(str.substring(index + 3,index+4));
			int temp = cal(a,b1,op2);//뒤에것
			temp = cal(value,temp,op1);
			dfs(index + 4,temp);
		}
	}
	
	static int cal(int a, int b, char op) {
		switch(op) {
		case '+':return a + b;
		case '-':return a - b;
		case '*':return a * b;
		}
		
		return 0;
	}
}
