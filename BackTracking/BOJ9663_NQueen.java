package BaekJoon.BackTracking;

import java.util.Scanner;

//N-Queen
public class BOJ9663_NQueen {
	static int answer = 0;
	static int[] res;
	static boolean col[];
	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		res = new int[N];
		col = new boolean[N];
		Queen(0);
		System.out.println(answer);
		sc.close();
	}
	
	static void Queen(int cnt) {
		if(cnt  == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {// 열검사하는거임 
			if(col[i]) continue;
			if(isPromising(cnt,i)) {// 이미 선택된 열이거나
				col[i] = true;
				res[cnt] = i;
				Queen(cnt + 1);
				col[i] = false;
			}
		}
	}
	
	static boolean isPromising(int r,int c) {// n 열에 놓는게 타당한지
		for(int i = 0; i < r; i++) {
			if(Math.abs(res[i] - c) == Math.abs(r - i) || c == res[i]) return false;
		}
		
		return true;
	}
}
