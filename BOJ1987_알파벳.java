package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳

public class BOJ1987_알파벳 {
	static int dx[] = {0,0,-1,1}; 
	static int dy[] = {1,-1,0,0}; 
	static int max = Integer.MIN_VALUE;
	static int X;
	static int Y;
	static String[] map;
	static boolean[] alphabet = new boolean[26];
	// A = 65
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new String[X];
		
		for(int i = 0; i < X; i++) {
			map[i] = br.readLine();
		}
		find(0,0,0);
		
		System.out.println(max);
		br.close();
	}
	
	static void find(int x, int y, int cnt) {
		char character = map[x].charAt(y);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || ny >=Y || nx >= X) continue;
			// 유효성 통과하고나서
			if(alphabet[(int)character - 65]) {
				max = Math.max(max, cnt);
				return;
			}
			
			alphabet[(int)character - 65] = true;
			find(nx,ny, cnt + 1);
			alphabet[(int)character - 65] = false;
		}
	}
}
/*package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳

public class BOJ1987_알파벳 {
	static int dx[] = {0,0,-1,1}; 
	static int dy[] = {1,-1,0,0}; 
	static int max = Integer.MIN_VALUE;
	static int X;
	static int Y;
	static String[] map;
	static boolean[] alphabet = new boolean[26];
	// A = 65
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new String[X];
		
		for(int i = 0; i < X; i++) {
			map[i] = br.readLine();
		}
		find(0,0,0);
		
		System.out.println(max);
		br.close();
	}
	
	static void find(int x, int y, int cnt) {
		char character = map[x].charAt(y);
		if(alphabet[(int)character - 65]) {
			max = Math.max(max, cnt);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || ny >=Y || nx >= X) continue;
			alphabet[(int)character - 65] = true;
			find(nx,ny, cnt + 1);
			alphabet[(int)character - 65] = false;
		}
	}
}
*/