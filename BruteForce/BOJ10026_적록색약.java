package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026_적록색약 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static char arr[][];
	static boolean visit[][];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		//get arr
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visit[i][j]) continue;
				if(arr[i][j] == 'B') dfs_1(i,j, 'B');
				else dfs_1(i,j, 'X');
				cnt++;
			}
		}
		
		int cnt2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) continue;
				dfs_2(i,j, arr[i][j]);
				cnt2++;
			}
		}
		System.out.println(cnt2 + " " + cnt);
		br.close();
		
	}
	
	static void dfs_1(int x, int y, char str) {
		
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
			//범위안에 들고 방문했는지
			if((arr[nx][ny] == 'B') && (str == 'B') )dfs_1(nx,ny,str);
			if((arr[nx][ny] != 'B') && (str == 'X') )dfs_1(nx,ny,str);
		}
	}
	
	static void dfs_2(int x, int y, char str) {
		
		visit[x][y] = false;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || !visit[nx][ny]) continue;
			//범위안에 들고 방문했는지
			if(arr[nx][ny] == str) dfs_2(nx,ny,str);
		}
	}
	
	
}
