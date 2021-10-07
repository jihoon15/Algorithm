package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890_경사로 { 
	private static int n, x; 
	private static int[][] map1, map2; 
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken()); 
		x = Integer.parseInt(st.nextToken()); 
		map1 = new int[n][n]; map2 = new int[n][n]; 
		for (int i = 0; i < n; i++) { 
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < n; j++) { 
				int num = Integer.parseInt(st.nextToken()); 
				map1[i][j] = num; map2[j][i] = num; 
			} 
		} 
		System.out.println(solution());
		br.close();
	} 
	private static int solution() { 
		int answer = 0; 
		for (int i = 0; i < n; i++) { 
			answer += isOk(map1[i]); 
			answer += isOk(map2[i]); 
			} 
		return answer; 
	} 
	private static int isOk(int[] array) { // 활주로 건설할 수 있으면 1, 없으면 0 리턴 
		boolean[] check = new boolean[n]; 
		for (int i = 0; i < n - 1; i++) { 
			int prev = array[i]; 
			int next = array[i + 1]; 
			if (Math.abs(prev - next) > 1) return 0; 
			if (check[i + 1] || prev == next) continue;  
			if (prev > next) { 
				for (int j = i + 1; j <= i + x; j++) {  
					if (j == n || array[j] != next || check[j]) return 0; 
					if (j != i + x) array[j] = next + 1; check[j] = true; 
				} 
			} else { 
				for (int j = i; j > i - x; j--) { 
					if (j < 0 || array[j] != prev || check[j]) return 0; 
					if (j != i - x + 1) array[j] = prev + 1; 
					check[j] = true; 
				} 
			} 
		} 
		return 1; 
	}
				
}


