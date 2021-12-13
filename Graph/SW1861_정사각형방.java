package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1861_정사각형방 {

	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int[][] map;
	static int width;
	static int num_res;
	static int cnt_res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int time = 1; time <=N; time++) {
			num_res = -1;
			cnt_res = -1;
			sb.append("#" + time +" ");
			width = Integer.parseInt(br.readLine());
			map = new int[width][width];
			for(int i = 0; i < width; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < width; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			//get map
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < width; j++) {
					find(i,j,map[i][j], 1);
				}
			}
			sb.append(num_res + " " + cnt_res + "\n");
		}
		
		br.close();
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
	
	static void find(int x, int y, int num,int cnt) {//map[x][y] 검사
		
		int X;
		int Y;
		
		for(int i = 0; i < 4; i++) {
			X = x + dx[i];
			Y = y + dy[i];
			if(X < 0 || X >= width || Y < 0 || Y >= width) continue;
			if(map[X][Y] == map[x][y] + 1) {
				find(X,Y,num,cnt + 1);
				return;
			}
		}//어처피 제한이걸려있음
		update(num,cnt);
	}
	static void update(int num, int cnt) {
		if(cnt > cnt_res) {num_res = num; cnt_res = cnt;}
		else if(cnt == cnt_res) {
			if(num_res > num) {
					num_res = num; cnt_res = cnt;
			}
		}
	}
}
