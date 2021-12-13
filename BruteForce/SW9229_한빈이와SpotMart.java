package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW9229_한빈이와SpotMart {
	static int num_snack;
	static int max_weight;
	static int max;
	static int snack[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str[];
		int N = Integer.parseInt(br.readLine());
		for(int time = 1; time <=N; time++) {
			sb.append("#" + time + " ");
			str = br.readLine().split(" ");
			num_snack = Integer.parseInt(str[0]);
			max_weight = Integer.parseInt(str[1]);
			snack = new int[num_snack];
			
			str = br.readLine().split(" ");
			for(int i =0; i < num_snack; i++) {
				snack[i] = Integer.parseInt(str[i]);
			}
			
			max = -1;
			find(0,0,0);
			sb.append(max + "\n");
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		br.close();
	}
	public static void find(int start, int weight, int cnt) {
		if(weight > max_weight) {return;}
		
		if(cnt == 2) {max = max > weight ? max: weight; return;}
		
		for(int i = start; i < num_snack; i++) {
			find(i + 1, weight + snack[i], cnt + 1);
		}
	} 
}
