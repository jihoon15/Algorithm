package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471_게리맨더링 {
	
	static int N;
	static boolean[][] map;
	static int[] population;
	static int min = Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 선거구 개수
		map = new boolean[N][N];
		population = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++)population[i] = Integer.parseInt(st.nextToken());
		
		for(int from = 0; from < N; from++) {//i번째 선거구
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				map[from][to] = true;
				map[to][from] = true;
			}
		}
		
		for(int flag = 1; flag < (1 << N) - 1; flag++) {
			gari(flag);
		}
		// get map
		br.close();
		if(min == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	static void gari(int flag) {
		ArrayList<Integer> Ateam = new ArrayList<Integer>();
		ArrayList<Integer> Bteam = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) {
				Ateam.add(i);
			}else {Bteam.add(i);}
		}
		//Ateam과 Bteam에 각각 node번호가 들억있음 길이만큼
		if(!bfs(Ateam)) return;
		if(!bfs(Bteam)) return;
		// 둘다 이어지면 통과 아니면 return
		update(flag);
		return;
	}
	
	static boolean bfs(ArrayList<Integer> curr) {//이어지면 false, 안이어지면
		
		boolean visit[] = new boolean[N]; 
		for(int i = 0; i < N; i++) {
			if(curr.contains(i)) continue;
			visit[i] = true;
		}
		// visit 에서 적군 인덱스만 true
		Queue<Integer> q = new LinkedList<>();
		int x = curr.get(0);
		visit[x] = true;
		q.add(x);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int i = 0; i < N; i++) {
				if(map[c][i] && !visit[i]) {// 방문을 아직안했고 길이있으면
					visit[i] = true;
					q.add(i);
				}
			}
		}
		for(int i = 0; i < curr.size(); i++) {
			if(!visit[curr.get(i)]) return false;//들어있는애들중에 방문을 안한곳이 있다면 -> 가망없음
		}
		return true;
	}
	
	static void update(int flag) {
		int a= 0;
		int b= 0;
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i)!= 0) {
				a+= population[i];
			}else {
				b+= population[i];
			}
		}
		int res = Math.abs(a - b);
		min = Math.min(res, min);
	}
}
