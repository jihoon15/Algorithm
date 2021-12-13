package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001_파리퇴치 {
	
	static int max;
	static int arr[][] = new int[15][15];
	static int N;
	static int M;
	
	static void find() {
		int num = (N- M + 1);// 한칸당 수
		for(int i = 0; i < num* num; i++) {// 0 5 10, 5 10 15
			int sum = 0;
			int mod = i % num;// 0 1 2 0 1 2 0 1 2
			int mok = i / num;// 0 0 0 1 1 1 2 2 2
			for(int j = 0; j < M; j++) {
				int X = mod + j;
				int Y = mok; 
				for(int k =0; k < M; k++) {
					sum += arr[X][Y + k];//[X][Y} 가시작점
				}
			}
			max = max > sum ? max:sum;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
			int case_num = Integer.parseInt(br.readLine());
			for(int test = 1; test<= case_num; test++) {
				
				sb.append("#" + test + " ");
				st = new StringTokenizer(br.readLine(), " ");
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				
				for(int i = 0; i <N; i++) {
					String s[] = br.readLine().split(" ");
					for(int j = 0; j <N; j++) {
						arr[i][j] = Integer.parseInt(s[j]);
					}
				}//get
				
				max = 0;
				find();
				sb.append(max + "\n");
			}
		
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
}
