package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ13913_숨바꼭질4{
    static int N, K;
    static int[] visit = new int[100001];

    static int[] multi = {2,1,1};
    static int[] plus = {0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = bfs();

        // reverse
        Stack<Integer> stack = new Stack<>();
        
        int index = K;
        while (index != N) {
            stack.push(index);
            index = visit[index];
        }

        // print
        sb.append(time + "\n" + N + " ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
        br.close();
        sb.delete(0, sb.length());
    }

    static int bfs() {
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(N);
        Arrays.fill(visit, -1);
        visit[N] = -2;
        int layer = 0;
        while (!Q.isEmpty()) {
        	int size = Q.size();
        	while(--size >= 0) {
        		
	        	int curr = Q.poll();
	            if (curr == K) return layer;
	            
	            for (int i=0; i<3; i++) {
	                int next = curr*multi[i] + plus[i];
	
	                if (next < 0 || next > 100000 || visit[next] != -1) continue;
                    visit[next] = curr;
                    Q.add(next);
	            }
            }
        	layer++;
        }
        return 0;
    }
}
/*class BOJ13913_숨바꼭질4{
	static int N, K;
	static int[] parent = new int[100001];
	static boolean[] visit = new boolean[100001];
	
	static int[] multi = {2,1,1};
	static int[] plus = {0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int time = bfs();
		
		// 순서대로 구하기 위해 stack 에 담았다가 다시 pop
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int index = K;
		
		while (index != N) {
			stack.push(parent[index]);
			index = parent[index];
		}
		
		// 최종 출력
		sb.append(time + "\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb.toString());
		br.close();
		sb.delete(0, sb.length());
	}
	
	static int bfs() {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(N);
		visit[N] = true;
		int layer = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			while(--size >= 0) {
				
				int curr = Q.poll();
				if (curr == K) return layer;
				
				for (int i=0; i<3; i++) {
					int next = curr*multi[i] + plus[i];
					
					if (next < 0 || next > 100000 || visit[next]) continue;
					visit[next] = true;
					parent[next] = curr;
					Q.add(next);
				}
			}
			layer++;
		}
		return 0;
	}
}
*/
