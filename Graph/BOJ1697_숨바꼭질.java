package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {
	
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
		
		int res = BFS();
		System.out.println(res);
	}
	
	static int BFS() {
		int range = 0;
		if(N > K) return N - K;
		else range = 2 * K + 1;
		
		boolean visit[] = new boolean[range];
		Queue<loc> Q = new LinkedList<>();
		
		Q.add(new loc(N,0));
		visit[N] = true;
		
		while(!Q.isEmpty()) {
			loc curr = Q.poll();
			if(curr.x == K) return curr.time;
			
			for(int i = 0; i<3; i++) {
				int nx = (curr.x * multi[i]) + plus[i];
				if(nx < 0 || nx >= range || visit[nx]) continue;
				Q.add(new loc(nx,curr.time + 1));
				visit[nx] = true;
			}
		}
		
		return -1;
	}
}
