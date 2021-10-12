package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549_숨바꼭질3 {
	
	static class loc implements Comparable<loc>{
		int x;
		int time;
		public loc(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		@Override
		public int compareTo(loc o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}

		
	}
	static int multi[] = {1,1,2};
	static int plus[] =  {-1,1,0};
	static int time[] = {1,1,0};
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
		//예외처리
		if(N > K) return N - K;
		else if(N == K) return 0;
		else range = 2 * K + 1;
		
		boolean visit[] = new boolean[range];
		PriorityQueue<loc> Q = new PriorityQueue<>();
		// 순간이동은 시간이 들지 않는다. 시간이 적은순으로 정렬하여 처음 K를 만날때가 정답
		Q.add(new loc(N,0));
		visit[N] = true;
		
		
		
		while(!Q.isEmpty()) {
			
			loc curr = Q.poll();
			if(curr.x == K) return curr.time;
			for(int i = 0; i<3; i++) {
				int nx = (curr.x * multi[i]) + plus[i];
				if(nx < 0 || nx >= range || visit[nx]) continue;// 그전단계에서 방문했응경우에만 차단함
				visit[curr.x] = true;
				Q.add(new loc(nx,curr.time + time[i]));
			}
		}
		
		return -1;
	}
}
