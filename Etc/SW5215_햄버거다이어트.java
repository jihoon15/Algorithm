package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW5215 {
	static int max = 0;
	static int num_food;
	static int max_cal;
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str;
		int N = Integer.parseInt(br.readLine());
		int score;
		int cal;
		
		for(int time = 1; time <= N; time++)
		{
			sb.append("#" + time + " ");
			str = br.readLine().split(" ");
			num_food = Integer.parseInt(str[0]);
			max_cal = Integer.parseInt(str[1]);
			arr = new int[2][num_food];
			
			for(int i = 0; i < num_food; i++) {
				str = br.readLine().split(" ");
				score = Integer.parseInt(str[0]);
				cal = Integer.parseInt(str[1]);
				arr[0][i] = score;
				arr[1][i] = cal;
			}
			find(0,0,0);
			sb.append(max + "\n");
			max = 0;
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		br.close();
	}
	
	public static void find(int start, int sum, int cal) {
		if(cal >= max_cal) {return;}
		
		max = max > sum ? max : sum;
		
		for(int i = start; i < num_food; i++) {
			find(i  + 1, sum + arr[0][i], cal + arr[1][i] );
		}
	}
}
