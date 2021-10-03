package BaekJoon.Dp;
// N과 M
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649_N과M {
	static int[] arr;
	static int N;
	static int R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		permu(0,0, new int[R]);
		br.close();
	}
	
	static void permu(int cnt, int flag, int[] arr) {
		
		if(cnt == R) {
			for(int i = 0; i < R; i++) {
				System.out.print(arr[i] + 1 + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 <<i) != 0) continue;
			arr[cnt] =i;
			permu(cnt + 1, flag | 1 <<i,arr);
		}
	}
}
