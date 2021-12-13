package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ7576_토마토 {
	static class TOMATO{
		int x,y;

		public TOMATO(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int X;
	static int Y;
	static int arr[][];
	static int total_cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		//반복
		st = new StringTokenizer(br.readLine(), " ");
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int [X][Y];
		total_cnt = X * Y;
		
		List<TOMATO> list = new ArrayList<>();
		
		for(int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < Y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) total_cnt--;
				if(arr[i][j] == 1) list.add(new TOMATO(i,j));
			}
		}//getmap
		int res = bfs(list);
		System.out.println(res);
		
		//
		br.close();
	}
	
	
	static int bfs(List<TOMATO> list) {
		
		Queue<TOMATO> Q = new LinkedList<TOMATO>();
		boolean visit[][] = new boolean[X][Y];
		
		TOMATO curr;
		for(int i = 0; i < list.size(); i++) {
			curr = list.get(i);
			Q.add(curr);
			visit[curr.x][curr.y] = true;
		}
		int cnt = -1;
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			while(--size >= 0) {
				curr = Q.poll();
				
				for(int i =0; i < 4; i++) {
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];
					if(nx < 0 || nx >=X || ny < 0 || ny >=Y || visit[nx][ny] || arr[nx][ny] != 0) continue;
					arr[nx][ny] = 1;
					visit[nx][ny] = true;
					Q.add(new TOMATO(nx,ny));
					total_cnt--;
				}
			}
			cnt++;
		}
		if(total_cnt == 0) return cnt;
		else return -1;
	}
}

