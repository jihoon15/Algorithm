package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//냉장고
class temper implements Comparable<temper>{
	int low;
	int high;
	public temper(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	
	@Override
	public int compareTo(temper o) {
		// TODO Auto-generated method stub
		int gap = this.high - o.high;
		if(gap != 0) return gap;
		
		return this.low - o.low;
	}
	
}

public class JUNGOL1828_냉장고 {
	static temper[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		list = new temper[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			list[i] = new temper(low, high);
		}
		
		Arrays.sort(list);
		temper curr = list[0];
		int cnt = 1;
		for(int i = 1; i < list.length; i++) {
			temper temp = list[i];
			if(curr.high < temp.low) {
				cnt++;
				curr = temp;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}
