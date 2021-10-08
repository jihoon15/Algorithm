package BaekJoon.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156_포도주시식 {
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//많이먹 , 3연은 불가능
		arr = new int[n+1];
		dp = new int[n+1];// i를 선택하느 최대값
		
		for(int i = 1; i <=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 110 101 011 중 큰값
		
		System.out.println(res(n));
		br.close();
	}
	private static int res(int n) {
		dp[1] = arr[1];
		if(n < 2) return dp[1];
		dp[2] = dp[1] + arr[2];
		if(n < 3) return dp[2];
		dp[3] = Math.max(arr[1] + arr[3], Math.max(arr[2] + arr[3], arr[1] + arr[2]));
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], arr[i-1] + arr[i] + dp[i-3]) );
			// ~~0 1101 1011
			// 선택x --i를선택할시 2가지
		}
		return dp[n];
	}
}
