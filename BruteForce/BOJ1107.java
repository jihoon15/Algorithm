package BaekJoon.BruteForce;
// 백준1107 리모컨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
	static boolean IsDisable[] = new boolean[10];
	static int num[] = new int[6];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int target = Integer.parseInt(br.readLine()); // n
		int disabled_num = Integer.parseInt(br.readLine()); // m
		if(disabled_num != 0) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i < disabled_num; i++) {
				IsDisable[Integer.parseInt(st.nextToken())] = true;
			}
		}//고장난거 없을때 고려
		//get 
		
		int res = Math.abs(target - 100);
		
		for(int i = 0; i < 1000000; i++) {// 바로 이동할 수 있는 채널 전체 탐색
			int channel = i;
			int len = check(channel);
			
			if(len > 0) {// 바로이동하고
				int press = Math.abs(channel - target);// 더해줘서 작으면 교체
				if(res > press + len) res = press + len;
			}
		}
		
		System.out.println(res);
	
	}
	
	static int check(int ch) {
		if(ch == 0) {
			if(IsDisable[0]) return 0;
			else return 1;// 아무 한자리수나 이동
		}
		int len = 0;
		while(ch > 0) {
			if(IsDisable[ch % 10]) return 0;
			ch /= 10;
			len += 1;
		}
		return len;
	}
}
