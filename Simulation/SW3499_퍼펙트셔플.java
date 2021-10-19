package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int time = 1; time <=N; time++) {
			sb.append("#" + time + " ");
			int len = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");

			int first = 0;
			int second = ((len - 1) /2 + 1);// 0 1 2 3 4 5
			
			for(int i = 0; i < len; i++) {
				if(i%2 ==0) {
					sb.append(str[first++] + " ");
				}
				else {
					sb.append(str[second++] + " ");
				}
			}
			sb.append("\n");
		}	
		br.close();
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
}
