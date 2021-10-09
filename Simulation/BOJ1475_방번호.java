package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475_방번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int num[] = new int[10];// 0 ~ 9
		for(int i = 0; i < str.length(); i++) {
			num[Integer.parseInt(str.substring(i,i+1))]++;
		}
		
		int res = 0;
		//6,9를 제외한 제일 개수가 많은수 찾
		for(int i = 0; i<=9; i++) {
			if(!(i ==9 || i ==6)) res = Math.max(res, num[i]);
		}
		
		//6, 9 까지 비교
		res = Math.max(res, (num[6] + num[9] + 1) / 2);
		// 홀수일때 고려  +1
				
		System.out.println(res);
		br.close();
	}
}
