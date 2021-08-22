package BaekJoon.Simulation;
// 백준1158 요세푸스 문제
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ1158 {
	static List<Integer> list = new LinkedList<Integer>();
	static int N;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		
		Josephus();
		
		sc.close();
	}	
	public static void Josephus() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int death_num = 0;
		
		while(N > 1) {
			death_num += (K - 1);
			death_num %= N;
			sb.append(list.get(death_num) + ", ");
			list.remove(death_num);
			N--;
		}
		sb.append(list.get(0) + ">");
		
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
	
}
