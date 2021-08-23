package BaekJoon.Greedy;

import java.util.Scanner;

public class BOJ2839_설탕배달 {
	static final int five = 5;
	static final int three = 3;
	static int five_cnt;
	static int three_cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean flag = true;
		five_cnt = N / five;
		three_cnt = 0;
		int left = N % five;
		
		for(int i = five_cnt; i >= 0; i--) {
			if((left % three) == 0) {
				three_cnt = left / three;
				System.out.println(i + three_cnt);
				flag = false;
				break;
			}
			left+=five;
		}
		
		if(flag) System.out.println("-1");
		sc.close();
	}

}
