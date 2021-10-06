package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2239_스도쿠 {
	
	static boolean row[][] = new boolean[9][9];
	static boolean col[][] = new boolean[9][9];
	static boolean array[][] = new boolean[9][9];
	// 0 1 2 x0 0 0 y 0 1 2 
	// 3 4 5  1 1 1   0 1 2
	// 6 7 8  2 2 2   0 1 2
	static int sudoku[][] = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		for(int i = 0; i < 9; i++) {
			String str = br.readLine();
			for(int j = 0; j < 9; j++) {
				int num = Integer.parseInt(str.substring(j,j+1));
				sudoku[i][j] = num;
				if(num != 0) {
					row[i][num - 1] = true;// i번째 행의 num true
					col[j][num - 1] = true;// i번째 행의 num true
					array[(i/3) * 3 + (j/3)][num - 1] = true;
				}
			}
		}// get map
		
		backtracking(0);
		br.close();
	}

	private static void backtracking(int cnt) {
		// 000 111 222 333 ... 999
		// 012 012 012 ...
		int x = cnt / 9;
		int y = cnt % 9;
		
		
		if(cnt == 81) {
			//print
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			//
			System.exit(0);
		}
		
		if(sudoku[x][y] == 0) {
			for(int num = 1; num <=9; num++) {
				if(!row[x][num - 1] && !col[y][num - 1] && !array[(x/3)*3 + (y/3)][num - 1]) {
					//promising
					sudoku[x][y] = num;
					row[x][num - 1] = true;
					col[y][num - 1] = true;
					array[(x/3)*3 + (y/3)][num - 1] = true;
					
					backtracking(cnt + 1);
					
					sudoku[x][y] = 0;
					row[x][num - 1] = false;
					col[y][num - 1] = false;
					array[(x/3)*3 + (y/3)][num - 1] = false;
				}
			}
		}else {
			backtracking(cnt + 1);
		}
		
	}
}
