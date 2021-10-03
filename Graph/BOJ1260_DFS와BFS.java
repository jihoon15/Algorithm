package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1260 DFS와 BFS
public class BOJ1260_DFS와BFS {
	
	static int vertex_num;
	static int edge_num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		//st = new StringTokenizer(br.readLine(), " ");
		
		st = new StringTokenizer(br.readLine()," ");
		
		vertex_num = Integer.parseInt(st.nextToken()); 
		edge_num = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[vertex_num + 1][vertex_num + 1];
		
		for(int i = 0; i < edge_num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = true;
			arr[to][from] = true;
		}
		
		dfs(start, arr,new boolean[vertex_num+1]);
		sb.append("\n");
		bfs(start, arr,new boolean[vertex_num+1]);
		
		bw.write(sb.toString());
		sb.delete(0, sb.length());
		bw.close();
		br.close();
	}
	
	static void bfs(int start, boolean[][] arr, boolean[] visit) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");
			if(arr[curr] == null) continue;
			
			for(int i = 1; i <= vertex_num; i++) {
				if(arr[curr][i] && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	
	static void dfs(int start, boolean[][] arr, boolean[] visit) {
		visit[start] = true;
		sb.append(start + " ");
		
		if(arr[start] == null) return;
		for(int i = 1; i <= vertex_num; i++) {
			if(arr[start][i] && !visit[i]) {
				dfs(i, arr, visit);
			}
		}
		
	}
	
	
}
