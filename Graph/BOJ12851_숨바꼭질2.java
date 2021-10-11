package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851_숨바꼭질2 {
	
	static class loc{
		int x;
		int time;
		public loc(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
	static int multi[] = {1,1,2};
	static int plus[] =  {-1,1,0};
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());//
		K = Integer.parseInt(st.nextToken());//0 ~ 십만
		
		int res[] = BFS();
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
	static int[] BFS() {
		int range = 0;
		//예외처리
		if(N > K) return new int[] {N - K, 1};
		else if(N == K) return new int[] {0,1};
		else range = 2 * K + 1;
		
		boolean visit[] = new boolean[range];
		Queue<loc> Q = new LinkedList<>();
		
		Q.add(new loc(N,0));
		visit[N] = true;
		
		
		boolean flag = true;
		int res = 0;
		int cnt = 0;
		
		while(!Q.isEmpty() && flag) {
			int size = Q.size();
			while(--size >=0) {
				loc curr = Q.poll();
				//위에서 방문처리
				visit[curr.x] = true;
				for(int i = 0; i<3; i++) {
					int nx = (curr.x * multi[i]) + plus[i];
					if(nx < 0 || nx >= range || visit[nx]) continue;// 그전단계에서 방문했응경우에만 차단함
					if(nx == K) {
						res = curr.time + 1;
						flag = false;
						cnt++;
					}
					Q.add(new loc(nx,curr.time + 1));
				}
			}
		}
		
		return new int[] {res,cnt};
	}
}
