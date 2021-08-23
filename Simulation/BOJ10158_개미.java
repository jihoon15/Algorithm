package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10158_개미 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str;
		
		str = br.readLine().split(" ");
		int w = Integer.parseInt(str[0]);// 6
		int h = Integer.parseInt(str[1]);// 4
		str = br.readLine().split(" ");
		int init_w = Integer.parseInt(str[0]); // 4
		int init_h = Integer.parseInt(str[1]); // 1
		int hour = Integer.parseInt(br.readLine());// 8
		
		int total_w = init_w + hour;// 12
		int total_h = init_h + hour; // 9
		
		int res_w = total_w % (2*w);
		int res_h = total_h % (2*h);
		if(res_w > w) {
			res_w = (2*w) - res_w;
		}
		if(res_h > h) {
			res_h = (2*h) - res_h;
		}
		
		bw.write((res_w)+ " " + (res_h));
		br.close();
		bw.flush();
	}
	
}
