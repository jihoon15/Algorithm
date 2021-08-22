package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수열

public class BOJ2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");

		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 1;
		int cnt_up = 1;
		int cnt_down = 1;
		for(int i = 0; i < len - 1; i++){
			//증
			if(arr[i] > arr[i+1]) {
				res = res > cnt_up? res:cnt_up;
				cnt_up = 1;
			}else {
				cnt_up++;
			}
			//감
			if(arr[i] < arr[i+1]) {
				res = res > cnt_down? res:cnt_down;
				cnt_down = 1;
			}else {
				cnt_down++;
			}
		}
		int cnt = Math.max(cnt_down, cnt_up);
		res = res > cnt? res:cnt;

		
		System.out.println(res);
		br.close();
	}
}
