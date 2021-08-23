package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열 {
	static int max = Integer.MIN_VALUE;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= N - K; i++) {
			update(i,K);
		}
		System.out.println(max);
		br.close();
	}
	
	static void update(int start, int k) {
		int sum = 0;
		for(int i = start; i < start + k; i++) {
			sum += arr[i];
		}
		max = max>sum?max:sum;
	}
}
