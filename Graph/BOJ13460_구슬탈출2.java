package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13460_구슬탈출2 {
	
	static class state{
		int rx,ry,bx,by;
		int time;
		
		public state() {};
		public state(int rx, int ry, int bx, int by, int time) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.time = time;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char[][] map;
	static int N,M,endX,endY;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];// 3 ~ 10
		
		state start = new state();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
				}else if(map[i][j] == 'B') {
					start.bx = i;
					start.by = j;
				}else if(map[i][j] == 'O') {
					endX = i;
					endY = j;
				}
			}
		}
		
		int result = BFS(start);
		System.out.println(result);
		br.close();
	}
	
	static int BFS(state start) {
		boolean[][][][] visit = new boolean[N][M][N][M];
										 // Rx Ry Bx By
		Queue<state> Q = new LinkedList<>();
		Q.add(start);
		visit[start.rx][start.ry][start.bx][start.by] = true;
		
		while(!Q.isEmpty()) {
			state curr = Q.poll();
			if(curr.time >= 10)break;
			for(int i = 0; i < 4; i++) {
				int[] r_loc = BallMove(curr.rx,curr.ry, i);
				int nextRX = r_loc[0];
				int nextRY = r_loc[1];
				int[] b_loc = BallMove(curr.bx,curr.by, i);
				int nextBX = b_loc[0];
				int nextBY = b_loc[1];
				
				//파랑 나감
				if(nextBX == endX && nextBY == endY) continue;
				//끝
				if(nextRX == endX && nextRY == endY) return curr.time + 1;
				
				//동일선상에서 겹칠때
				if(nextRX == nextBX && nextRY == nextBY) {
					int distR = getDist(curr.rx, curr.ry,nextRX,nextRY);
					int distB = getDist(curr.bx, curr.by,nextBX,nextBY);
					if(distR > distB) {
						nextRX -= dx[i];
						nextRY -= dy[i];
					}else{
						nextBX -= dx[i];
						nextBY -= dy[i];
					}
				}
				
				if(visit[nextRX][nextRY][nextBX][nextBY]) continue;
				visit[nextRX][nextRY][nextBX][nextBY] = true;
				Q.add(new state(nextRX,nextRY,nextBX,nextBY,curr.time + 1));
			}
		}
		
		return -1;
	}
	
	static int[] BallMove(int x, int y,int dir) {
		int curr_x = x;
		int curr_y = y;
		while(true) {// 기울인 각도로 움직인다
			int nx = curr_x + dx[dir];
			int ny = curr_y + dy[dir];
			//부딪힐때 까지
			if(nx== endX &&ny == endY) return new int[] {nx,ny};
			if(map[nx][ny] == '#')break;
			curr_x = nx;
			curr_y = ny;
		}
		return new int[] {curr_x,curr_y};
	}
	static int getDist(int cx, int cy, int nx, int ny) {
		return Math.abs(cx - nx) +  Math.abs(cy - ny);
	}
}
