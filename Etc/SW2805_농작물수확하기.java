package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2805_농작물수확하기 {
	
	static int[][] arr = new int[49][49];
	static int width = 0;
	
	static int crop(int row_num, int mid_width) {
		int sum = 0;
		if(row_num == width) {return 0;}
		
			int start = ((width / 2) - (mid_width /2) );//
			for(int i = start ; i <=  width - start - 1; i++) {
				sum += arr[row_num][i];
			}
			return sum + crop(row_num + 1, mid_width + 2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int time = 1; time <= N; time++) {
			int res = 0;
			width = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < width; i++) {
				String row = br.readLine();
				for(int j = 0; j < width; j++) {
					arr[i][j] = Integer.parseInt((row.substring(j, j + 1)));
				}
			}
			// get arr
			
			res = crop(0,1);
			sb.append("#" + time + " " + res + "\n");
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
}

