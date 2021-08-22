package BaekJoon;
// 배열 돌리기 4
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406_배열돌리기4 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static int layer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rotate;
		
		st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		rotate = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		layer = Math.min(X, Y) / 2;
		//visit = new boolean[X][Y];
		for(int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//...~ get map
		for(int i = 0; i < rotate; i++) {
			snail(0,0,X,Y,0,0);
		}
		
		print_map(X,Y);
		br.close();
	}
	static public void snail(int x, int y, int X, int Y, int dir, int level) {
		if(level ==layer) {return;}
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx >= X  - level || nx < 0 + level || ny >= Y - level || ny < 0 + level) {//|| visit[nx][ny])
			dir++;
			if(dir == 4) {//레이어 전체다했을때
				dir = 0;
				snail(x+1, y+1, X, Y, dir, level + 1);
				return;
			}
			//그냥 가로막혔을때
			snail(x,y,X,Y,dir,level);
			return;
		}
		int temp = map[nx][ny];// 가져올값 재귀 전에 저장
		snail(nx,ny,X,Y,dir,level);
		map[x][y] = temp;
			
	}
	
	static void print_map(int X, int Y) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sb.delete(0, sb.length());
	}
}

