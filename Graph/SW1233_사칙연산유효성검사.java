package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1233_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//테케 10번 계산가능 1 불가능 0
		String[] str;
		int num;
		int answer;
		
		for(int time = 1; time <=10; time++){
			
			sb.append("#" + time + " ");
			num = Integer.parseInt(br.readLine());
			answer = 1;
			
			for(int i = 0; i < num; i++) {
				str = br.readLine().split(" ");
				if(str[1].equals("+") || str[1].equals("-") ||str[1].equals("/") ||str[1].equals("*")) {
					//사칙연산인 경우에는 무조건 숫자 두개가 와야함
					if(str.length != 4){answer = 0;}
				}
				else {
					// 숫자면 자식노드가 있어서는 안된다
					if(str.length > 2){answer = 0;}
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		sb.delete(0, sb.length());
	}
}
