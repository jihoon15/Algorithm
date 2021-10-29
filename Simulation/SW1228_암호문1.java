package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW1228_암호문1 {
	
	static List<String> pw = new ArrayList<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int x,y, code_num;
		String str;
	
		// test case 10개
		for (int time = 1; time <= 10; time++) {
			
			sb.append("#" + time +" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			pw.clear();	
			for (int i = 0; i < N; i++) {
				pw.add(st.nextToken());
			}
			
			code_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < code_num; i++) {
				
				str = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<y; j++) {
					pw.add(x+j, st.nextToken());
				}
			}
			
			for(int i=0; i<10; i++) {
				sb.append(pw.get(i) + " ");
			}
			sb.append("\n");
		}	
	
		System.out.println(sb.toString());
		br.close();
		sb.delete(0, sb.length());
	}
}
