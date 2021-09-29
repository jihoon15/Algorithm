package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458_키순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//1 5 = 1 < 5 1번이 5번보다 작다
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			//1번이 5번보다 작으면 [1][5] == -1 [5][1] == 1
			arr[from][to] = -1;
			arr[to][from] = 1;
		}
		
		//ex [1][5] 인데 [5][6] 이다 그러면 1 < 6
		for(int k = 0; k < V; k++) {// 거치는 곳   5
			for(int f = 0; f < V; f++) {//    1 
				for(int t = 0; t < V; t++) {//6
					if(arr[f][k] == arr[k][t] && arr[f][k] != 0 ) {
						arr[f][t] = arr[f][k];
					}
				}
			}
		}
		// 1 -1 로 상대적 비교를 끝마침
		int answer = 0;
		for(int i = 0; i < V; i++) {
			boolean flag = true;
			for(int j = 0; j < V; j++) {
				if(arr[i][j] == 0 && i != j) {
					flag = false;
					break;
				}
			}
			if(flag)answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
