package BaekJoon.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int house[][] = new int[3][N+1];//집당 칠하는 가격 테이블
		int DP[][] = new int[3][N+1];// 최솟값 업데이트
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			house[0][i] = Integer.parseInt(st.nextToken()); 
			house[1][i] = Integer.parseInt(st.nextToken()); 
			house[2][i] = Integer.parseInt(st.nextToken()); 
		}
		
		//1 ~ 2 까지
		DP[0][1] = house[0][1];
		DP[1][1] = house[1][1];
		DP[2][1] = house[2][1];
		

		for(int i = 2; i<=N; i++) {
			DP[0][i] = Math.min(DP[1][i-1], DP[2][i-1]) + house[0][i];
			DP[1][i] = Math.min(DP[0][i-1], DP[2][i-1]) + house[1][i];
			DP[2][i] = Math.min(DP[0][i-1], DP[1][i-1]) + house[2][i];
		}
		
		System.out.println(Math.min(DP[0][N], Math.min(DP[1][N], DP[2][N]) ));
		br.close();
		
	}
}
