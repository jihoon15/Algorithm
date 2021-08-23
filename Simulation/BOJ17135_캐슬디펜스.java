package BaekJoon.Simulation;
// 캐슬 디펜스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class node{
	int x;
	int y;
	int dist;
	
	public node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class BOJ17135_캐슬디펜스 {
	static boolean isKill;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};// 확인순서 왼 위 오른
	static int castle[][];
	static int COPY[][];
	static boolean hit_enemy[][];
	static int X;
	static int Y;
	static int D;
	static int max = 0;
	static List<int[]> killList = new ArrayList<int[]>();
	
	static Queue<node> Q = new LinkedList<node>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		castle = new int[X][Y];
		COPY = new int[X][Y];
		for(int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < Y; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}//get map
		
		find_max_kill(0,0,0);
		System.out.println(max);
		br.close();
	}
	
	static void find_max_kill(int start, int cnt, int flag) {
		if(cnt == 3) {
			update(flag);
			return;
		}
		
		for(int i = start; i < Y; i++) {
			find_max_kill(i + 1, cnt + 1, flag | 1 << i);
		}
	}// 완성
	
	static void update(int flag) {// 게임단위
		int total_kill = 0;
		array_init();
		for(int i = 0; i < X; i++) {
			total_kill += shoot(flag);
			EnemyMove();
		}
		
		max = max > total_kill ? max : total_kill;
	}
	
	static int shoot(int flag) {// 라운드단위
		int round_kill = 0;
		killList.clear();
		
		for(int i = 0; i < Y; i++) {
			if((flag & 1 << i) != 0) {
				kill(X - 1 ,i,0);
			}
			
		}
		for(int i = 0; i < killList.size(); i++) {
			int[] t = killList.get(i);
			if(COPY[t[0]][t[1]] == 1) {
				round_kill++;
				COPY[t[0]][t[1]] = 0;
			}
		}
		return round_kill;
	}
	
	static void kill(int x, int y, int cnt) {//궁수단위
		
		Q.clear();
		Q.add(new node(x,y,1));
		boolean[][] visit = new boolean[X][Y];
		//첫원소 삽입
		
		while(!(Q.isEmpty())) {
			
			node curr = Q.poll();// 무적권 curr 
			if(COPY[curr.x][curr.y] == 1) {
				killList.add(new int[] {curr.x,curr.y}) ;
				return;
			}
			
			for(int i = 0; i <3; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int nd = curr.dist + 1;
				if(nx < 0 || ny < 0 || ny >=Y || visit[nx][ny] || nd > D) continue;
				Q.add(new node(nx, ny, nd));
				visit[nx][ny] = true;
			}
		}
		
		
		return;
		
	}
	
	static void EnemyMove() {
		
		for(int i = X - 1; i > 0; i--) {//i 는 1 까지
			for(int j = 0; j <Y; j++) {
				COPY[i][j] = COPY[i - 1][j];
			}
		}
		
		//제일위의 배열
		for(int j = 0; j <Y; j++) {
			COPY[0][j] = 0;
		}
	}
	
	static void array_init() {
		for(int i = 0; i < X; i++) {
			for(int j = 0; j < Y; j++) {
				COPY[i][j] = castle[i][j];
			}
			
		}
	}
	
}
