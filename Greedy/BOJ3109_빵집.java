package BaekJoon.Greedy;

// 빵집

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {
	
	static String[] str;
	static int dx[] = {-1,0,1};
	static int dy[] = {1,1,1};
	static int cnt = 0;
	static int X;
	static int Y;
	static boolean visit[][];
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		str = new String[X];
		visit = new boolean[X][Y];
		
		for(int i = 0; i < X; i++) {
			str[i] = br.readLine();
		}
		
		for(int i = 0; i < X; i++) {
			visit[i][0] = true;
			flag = false;
			find(i,0);
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	static boolean find(int x, int y) {
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < X && !visit[nx][ny] && str[nx].charAt(ny) != 'x') {
				//범위안에있다.
				if(ny == Y - 1) {
					cnt++;
					return true;
				}
				
				visit[nx][ny] = true;
				if(find(nx,ny)) return true;
			}
		}
		
		return false;
	}
	
}	
