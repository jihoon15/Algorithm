package BaekJoon;
// 배열돌리기 1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926_배열돌리기1 {
	static int[] dx_r = {1,0,-1,0};
	static int[] dy_r = {0,1,0,-1};
	static int[] dx_l = {0,1,0,-1};
	static int[] dy_l = {1,0,-1,0};
	static int[][] map;
	static int N;
	static int M;
	static int K;
	static int layer;
	static int min = Integer.MAX_VALUE;
	static String[] command;
	static boolean[] command_v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		command = new String[K];
		command_v = new boolean[K];
		//일단 저장
		for(int i = 0; i < K; i++) {
			command[i] = br.readLine();
		}
		//문자열 저장
		permu(0);
		
		System.out.println(min);
	}
	
	static void permu(int cnt) {
		if(cnt == K) {
			arr_min();return;}
		
		int x,y,X,Y;
		
		for(int i = 0; i < K; i++){
			if(command_v[i]){continue;}
			int r = Integer.parseInt(command[i].split(" ")[0]);
			int c = Integer.parseInt(command[i].split(" ")[1]);
			int s = Integer.parseInt(command[i].split(" ")[2]);
			x = r - s - 1; //0
			X = r + s; // 4
			y = c - s - 1; 
			Y = c + s;
			layer = s;
			rotate_r(x,y,x,y,X,Y,0,0);
			command_v[i] = true;
			
			permu(cnt + 1);
			
			layer = s;
			rotate_l(x,y,x,y,X,Y,0,0);
			command_v[i] = false;
		}
	}
	static void arr_min() {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			min = min < sum? min:sum; 
		}
			
		
	}
	
	static public void rotate_r(int x, int y, int min_x, int min_y, int max_x, int max_y, int dir, int level) {
		if(level ==layer) {return;}
		
		int nx = x + dx_r[dir];
		int ny = y + dy_r[dir];
		
		if(nx >= max_x  - level || nx < min_x + level || ny >= max_y - level || ny < min_y + level) {//|| visit[nx][ny])
			dir++;
			if(dir == 4) {//레이어 전체다했을때
				dir = 0;
				rotate_r(x+1, y+1, min_x, min_y, max_x, max_y, dir, level + 1);
				return;
			}
			//그냥 가로막혔을때
			rotate_r(x,y,min_x, min_y,max_x,max_y,dir,level);
			return;
		}
		int temp = map[nx][ny];// 가져올값 재귀 전에 저장
		rotate_r(nx,ny,min_x, min_y,max_x,max_y,dir,level);
		map[x][y] = temp;
			
	}
	
	static public void rotate_l(int x, int y, int min_x, int min_y, int max_x, int max_y, int dir, int level) {
		if(level ==layer) {return;}
		
		int nx = x + dx_l[dir];
		int ny = y + dy_l[dir];
		
		if(nx >= max_x  - level || nx < min_x + level || ny >= max_y - level || ny < min_y + level) {//|| visit[nx][ny])
			dir++;
			if(dir == 4) {//레이어 전체다했을때
				dir = 0;
				rotate_l(x+1, y+1, min_x, min_y,max_x, max_y, dir, level + 1);
				return;
			}
			//그냥 가로막혔을때
			rotate_l(x,y, min_x, min_y,max_x,max_y,dir,level);
			return;
		}
		int temp = map[nx][ny];// 가져올값 재귀 전에 저장
		rotate_l(nx,ny, min_x, min_y,max_x,max_y,dir,level);
		map[x][y] = temp;
			
	}
	
	static void print_map() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sb.delete(0, sb.length());
	}
}



