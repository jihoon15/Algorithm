package BaekJoon.Simulation;
// 색종이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563_색종이 {
	static int cnt = 0;
	static boolean[][] map = new boolean[101][101];//false
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x,y;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			paste(x,y);
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	static public void paste(int x,int y) {
		for(int i = x; i < x + 10; i++) {
			for(int j = y; j < y + 10; j++) {
				if(!(map[i][j])) {
					map[i][j] = true;
					cnt++;
				}
			}
		}
	}
	
}
