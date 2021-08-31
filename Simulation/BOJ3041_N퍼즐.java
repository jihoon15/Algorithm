package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3041_N퍼즐 {
	
	static int cnt;
	
	static char[][] alpha = {{'A','B','C','D'},
			{'E','F','G','H'},
			{'I','J','K','L'},
			{'M','N','O','.'}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[4];
		
		for(int i = 0; i< 4; i++) {
			str[i] = br.readLine();
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				dist(str[i].charAt(j), i , j);
			}
				
		}
		
		br.close();
		System.out.println(cnt);
	}
	
	static void dist(char ch, int x, int y) {
		if(ch == '.') return;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(ch == alpha[i][j]) {
					cnt += Math.abs(x - i) + Math.abs(y - j);
					return;
				}
			}
				
		}
	}
}
