package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_최단경로 {
	
	static class Edge implements Comparable<Edge>{
		int to, w;

		
		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;// INF
	static boolean visit[];
	static int dist[];
	static int V;
	static int E;
	static ArrayList<Edge>[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());// vertex num
		E = Integer.parseInt(st.nextToken());// edge num
		
		visit = new boolean[V+1];
		dist = new int[V+1];
		map = new ArrayList[V+1];
		for(int i = 1; i <=V; i++) map[i] = new ArrayList<Edge>();
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[from].add(new Edge(to,w));
		}

		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		bw.write(sb.toString());
		sb.delete(0, sb.length());
		bw.close();
		br.close();
	}
	
	static void dijkstra(int start) {
		//dist 초기화
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge cx = pq.poll();
			int dest = cx.to;
			int w = cx.w;
			//방문검사
			if(visit[dest]) continue;
			visit[dest] = true;
			
			for(Edge nx: map[dest]) {
				//cx : from 
				//nx : temp
				//nx.to : target
				if(!visit[nx.to] && dist[nx.to] > w + nx.w) {
									// dist[target] > temp까지의 거리(w) + temp에서 target까지의거리(nx.w)
					dist[nx.to] = w + nx.w;
					pq.add(new Edge(nx.to, dist[nx.to]));//from 에서 target까지의 최단거리를 거리로 넣어야함
				}
			}
		}
		
	}
	
}
