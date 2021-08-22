package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이자르기

public class BOJ2628_종이자르기 {
	static boolean[][]cut = new boolean [2][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int Y = Integer.parseInt(st.nextToken());//가로
		int X = Integer.parseInt(st.nextToken());//세로
		//최대 100
		
		cut[0] = new boolean[X];
		cut[1] = new boolean[Y];
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());// 0 가로 1 세로
			int index = Integer.parseInt(st.nextToken());// 자를 인덱스
			cut[dir][index] = true;
		}
		
		int max_row = find(X,cut[0]);
		int min_row = find(Y,cut[1]);
		System.out.println(min_row * max_row);
		br.close();
	}
	
	static int find(int len, boolean visit[]) {
		int res = 0;
		int front = 0;
		int end = 0;
		int i;
		for(i = 0; i < len; i++) {
			if(visit[i]) {
				//자른지점을 만날때마다 res값 최대값으로 갱신
				front = end;
				end = i;
				res = res > end - front ? res : end - front;
			}
		}
		//last check
		front = end;
		end = len;
		res = res > end - front ? res : end - front;
		
		return res;
	}
}
