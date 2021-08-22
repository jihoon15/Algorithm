package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 경비원

public class BOJ2564_경비원 {
	
	static List<int[]> list = new ArrayList<int[]>();
	static int X;
	static int Y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		Y = Integer.parseInt(st.nextToken());// 가로
		X = Integer.parseInt(st.nextToken());// 세로
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 1 위, 2 아래 , 3 왼 , 4 오른
			switch(a) {
			case 1: list.add(new int[] {0,b});
				break;
			case 2: list.add(new int[] {X,b});
				break;
			case 3: list.add(new int[] {b,0});
				break;
			case 4: list.add(new int[] {b,Y});
				break;
			}
		}
		// list 에 get 마지막이 동근이
		int[] me = list.get(list.size() - 1);
		
		System.out.println(findMin(me));
		br.close();
	}
	
	static int findMin(int[] me) {
		int res = 0;
		for(int i = 0; i < list.size() - 1; i++) {
			// X 좌표가 0과 X -1 일때 반대, Y 좌표가 0일때와 Y -1 일때
			res += findShort(i,me);
		}
		return res;
	}
	
	static int findShort(int index, int[] me) {
		int[] target = list.get(index);
		if(Math.abs(target[0] - me[0]) == X)// 위아래
		{
			return Math.min(target[1] + me[1], 2*Y - target[1] - me[1]) + X;
		}
		if(Math.abs(target[1] - me[1]) == Y)// 왼 오른
		{
			return Math.min(target[0] + me[0], 2*Y - target[0] - me[0]) + Y;
		}
		
		return Math.abs(me[0] - target[0]) + Math.abs(me[1] - target[1]);
	}
	
}
