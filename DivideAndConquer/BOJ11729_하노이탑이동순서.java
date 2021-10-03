package BaekJoon.DivideAndConquer;
// 백준 11729 하노이탑 이동 순서
import java.util.Scanner;

public class BOJ11729_하노이탑이동순서 {
	
	static StringBuilder sb = new StringBuilder();
	static int res = 0;
	
	static void divideConquer(int n, char from, char temp, char to) {
		if(n==0) {
			return;
		}
		divideConquer(n-1,from,to,temp);
		sb.append(from + " " + to + "\n");
		res++;
		divideConquer(n-1,temp,from,to);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//1 2 3 고정
		char from = '1';
		char temp = '2';
		char to = '3';
		divideConquer(num, from, temp,to);
		System.out.println(res);
		System.out.println(sb.toString());
		
		sb.delete(0, sb.length());
	}
	
}
