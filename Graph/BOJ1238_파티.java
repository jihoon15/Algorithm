package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1238_파티 {
	static final int INF = Integer.MAX_VALUE;
	static int N; 
	static int M; 
	static int X;
	static int map[][];
	static int reverse_map[][];
	static int dist[];
	static int reverse_dist[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());// 학생수
		M = Integer.parseInt(st.nextToken());//도로수 
		X = Integer.parseInt(st.nextToken()) - 1;// 몇번째 마을인지 
		
		map = new int [N][N];
		reverse_map = new int [N][N];
		dist = new int[N];
		reverse_dist = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			map[from][to] = w;
			reverse_map[to][from] = w;
		}
		
		djikstra(X);
		
		for(int a: dist) {
			System.out.print(a + " ");
		}
		System.out.println();
		for(int a: reverse_dist) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < N;i++) {
			if(i != X && res < (dist[i] + reverse_dist[i])) res = dist[i] + reverse_dist[i];
		}
		System.out.println(res);
		br.close();
	}
	private static void djikstra(int num) {//dist num에서부터 다른곳까지의 거리저장배열
		for(int i = 0; i< N; i++) {
			dist[i] = INF;
			reverse_dist[i] = INF;
		}
		dist[num] = 0;
		reverse_dist[num] = 0;
		boolean[] visit= new boolean[N];
		boolean[] reverse_visit = new boolean[N];
		
		while(true) {
			int curr = findMin(dist, visit);// -1이면 없는거
			if(curr == -1) break;
			visit[curr] = true;
			for(int i = 0; i < N;i ++) {
				if(map[curr][i] != 0 && dist[i] > map[curr][i] + dist[curr]) {
					// 갈수있는길이고 curr을 거쳐서가는게 더 빠를때
					dist[i] = map[curr][i] + dist[curr];
				}
			}
		}
		
		while(true) {
			int curr = findMin(reverse_dist, reverse_visit);// -1이면 없는거
			if(curr == -1) break;
			reverse_visit[curr] = true;
			for(int i = 0; i < N;i ++) {
				if(reverse_map[curr][i] != 0 && reverse_dist[i] > reverse_map[curr][i] + reverse_dist[curr]) {
					// 갈수있는길이고 curr을 거쳐서가는게 더 빠를때
					reverse_dist[i] = reverse_map[curr][i] + reverse_dist[curr];
				}
			}
		}
	}
	
	private static int findMin(int[] dist, boolean visit[]) {
		int min = INF;
		int index = -1;
		for(int i = 0; i < dist.length; i++) {
			if(visit[i]) continue;
			if(min > dist[i]) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}
}
