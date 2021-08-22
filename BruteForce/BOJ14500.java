package BaekJoon.BruteForce;
// 백준 14500 테트로미노

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ14500 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[] h = {7,11,13,14};//0111 1011 1101 1110 .. ㅗ
	static int [][] map;
	static boolean[][] visit;
	static int X;
	static int Y; 
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new int[X][Y];
		visit = new boolean[X][Y];
		for(int i=0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// get map
		
		// ㅗ 모양을 위한 
		for(int i=0; i < X; i++) {
			for(int j =0; j < Y; j++) {
				find_special(i,j);//조합을 이용하여 ㅗ 모양 회전하여 find
			}
		}
		
		//나머지
		for(int i=0; i < X; i++) {
			for(int j =0; j < Y; j++) {
				visit[i][j] = true;
				find(i,j,1,map[i][j]);//처음꺼 넣고
				visit[i][j] = false;
			}
		}
		System.out.println(max);
		br.close();
	}
	//ㅗ를 제외한 나머지 경우
	static void find(int x, int y,int cnt, int sum) {
		if(cnt == 4) {
			max = max > sum ? max:sum;
			return;
		}
		for(int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >=X || ny >= Y || visit[nx][ny]) continue;
			
			visit[nx][ny] = true;
			find(nx,ny, cnt+1, sum + map[nx][ny]);
			visit[nx][ny] = false;
		}
		
	}
	
	static void find_special(int x, int y) {//ㅗ 4개를 조합으로 선택
		for(int i = 0; i < 4; i++) {
			int sum = map[x][y];
			sum += getThreeDirSum(x,y,h[i]);
			max = max > sum ? max: sum;
		}
	}
	
	static int getThreeDirSum(int x, int y, int flag) {
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			if((flag & 1 << i) != 0) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >=X || ny >= Y) return 0;
				sum += map[nx][ny];
			}
		}
		return sum;
	}
}
