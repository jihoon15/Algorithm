package BaekJoon.BruteForce;
// 도영이가 만든 맛있는 음식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2961_도영이가만든맛있는음식 {
	static int[][] taste;//0 신 곱 , 1 쓴 힙
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str;
		N = Integer.parseInt(br.readLine());
		taste = new int[2][N];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			taste[0][i] = Integer.parseInt(str[0]);
			taste[1][i] = Integer.parseInt(str[1]);
		}
		
		for(int i = 1; i <(1 << N); i++) {
			update(i);
		}
		
		System.out.println(min);
		br.close();
	}
	
	static void update(int flag) {
		int sour = 1;
		int bitter = 0;
		for(int i = 0; i < N; i++) {
			if((flag & 1<<i) != 0) {
				sour *= taste[0][i];
				bitter += taste[1][i];
			}
		}
		int res = Math.abs(sour - bitter);
		min = min < res ? min:res;
	}
}
