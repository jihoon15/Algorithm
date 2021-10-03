package BaekJoon.Simulation;
// 백준10157 자리배정
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157_자리배정 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int X;
	static int Y;
	static int num;
	static boolean map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new boolean[X][Y];
		num = Integer.parseInt(br.readLine());
		// 몇번째 좌석인지
		if(num > X*Y) {System.out.println(0); System.exit(0);}
		
		find(0,0);
		
		
		br.close();
	} 
	static void find(int x, int y) {
		int cnt = 0;
		int cx = x;
		int cy = y;
		int nx = 0,ny = 0;
		int dir = 0;
		map[x][y] = true;
		
		while(true) {
			if(cnt == num) {
				System.out.println((cy - dy[dir] + 1) + " " +(cx - dx[dir] + 1));
				return;
			}
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			if(nx < 0 || nx >= X || ny < 0 || ny >= Y || map[nx][ny]) {
				dir = (dir+1) % 4;
				nx = cx + dx[dir];
				ny = cy + dy[dir];
			}
			
			map[nx][ny] = true;
			cx = nx; cy = ny;
			cnt++;
		}
	}
}
