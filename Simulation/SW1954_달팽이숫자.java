package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1954_달팽이숫자 {
	
	static int arr[][] = new int[10][10];
	static boolean visit[][] = new boolean[10][10];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		int a = 1;
		int b = 2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int len; 
		for(int time = 0; time < N; time++) {
			
			len = Integer.parseInt(br.readLine());
			
			snail(len);//arr생성
			
			sb.append("#" + (time + 1) + "\n");
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					if(j == len - 1) {sb.append(arr[i][j] + "\n");}
					else{sb.append(arr[i][j] + " ");}		
					visit[i][j] = false;
					}
			}
			
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
	
	static void snail(int len) {// 0 ~ len - 1
		
		int cnt = len * len;
		int num = 1;
		int x = 0;
		int y = 0;
		arr[x][y] = num++;
		int dir = 0;
		int nextX=0;
		int nextY=0;
		
		while(cnt >= num) {
			visit[x][y] = true;
			nextX = x + dx[dir];
			nextY = y + dy[dir];
			if(nextX < 0 || nextX >= len || nextY < 0 || nextY >= len || visit[nextX][nextY]) {
				dir = (dir + 1) % 4;// 4되면 돌아감 
				continue;
			}
			arr[nextX][nextY] = num++;
			x = nextX;
			y = nextY;
		}
	}
}
