package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어 {
	
	static class fish{
		int x,y, time;

		public fish(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		
		
	}
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int sea[][];
	static int N;
	
	static int sx;
	static int sy;
	static int ssize = 2;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); 
		
		
		sea = new int[N][N];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j< N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				sea[i][j] = temp;
				// 0 1 2 3 4 5 6 .. 9
				if(temp == 9) {// 상어위치는그냥 0으로
					sx = i; sy = j;
					sea[i][j] = 0;
				}
			}
		}
		// get shark , fish
		int res = 0;
		while(true) {
			// bfs에서 초기화시켜줌
			int time = bfs();
			if(time == -1) break;//엄마부른다
			res += time;
		}
		
		System.out.println(res);
		br.close();
	}
	
	static int bfs() {
		boolean visit[][] = new boolean[N][N];
		Queue<fish> q = new LinkedList();
		
		visit[sx][sy] = true;
		q.add(new fish(sx,sy,0));
		
		
		boolean flag = false;
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			while(--size >=0) {//단계별로
				fish curr = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || sea[nx][ny] > ssize) continue;
					// 크기가같다 or 0이다  배열 keep 지나갈수만있게
					if(sea[nx][ny] == 0 || sea[nx][ny] == ssize) {
						visit[nx][ny] = true;
						q.add(new fish(nx,ny, curr.time + 1));continue;
					}
					// 만약 먹이다 배열 0으로바꾸고 위치 갱신
					if(sea[nx][ny] !=0 && sea[nx][ny] < ssize) {
						visit[nx][ny] = true;
						flag = true;
						q.add(new fish(nx,ny, curr.time + 1));continue;
						// 먹을게 있으면 flag를 true로바꿈
						// 이상태에서 break시에 같은거리의 위치만 큐에남음
						// x가 작거나(위) 동일할시엔 y가 작은(왼) 을 먹이로 지정
					}//prey
				}
		
			}
			if(flag) break;
		}
		
		if(flag) {
			int nx = Integer.MAX_VALUE;
			int ny = Integer.MAX_VALUE;
			int time = 0;
			
			while(!q.isEmpty()) {// 현재큐에는 이동경로와 먹이가 모두들어있다.
				fish curr = q.poll();
				//먹을수 있으면
				if(sea[curr.x][curr.y] < ssize && sea[curr.x][curr.y] != 0) {
					if(curr.x == nx) {//조건1
						if(curr.y < ny) {
							nx = curr.x;
							ny = curr.y;
							time = curr.time;
						}
					}else if(curr.x < nx) {//조건2
						nx = curr.x;
						ny = curr.y;
						time = curr.time;
					}
				}
			}
			
			sea[nx][ny] = 0;
			
			cnt++;
			if(cnt == ssize) {
				ssize++;
				cnt = 0;
			}
			
			sx = nx; sy = ny;
			return time;
		}
		
		return -1;
	}
	
}
