package BaekJoon.Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW1225_암호생성기 {
	
	
	public static void main(String[] args) {
		//1 ~ 5까지줄어드는게 한 싸이클 >=0 일때 종료
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> Q = new LinkedList<Integer>();
		
		
		for(int time = 0; time < 10; time++){
			int N = sc.nextInt();
			sb.append("#" + N + " ");
			for(int i = 0; i < 8; i++) {
				Q.add(sc.nextInt());
			}
			
			int minus = 0;
			int head;
			
			while(true) {
				head = Q.poll();
				head -= (minus++ + 1);
				if(head <= 0) {Q.add(0);break;}
				minus %= 5;
				Q.add(head);
			}
			
			for(int i = 0; i < 8; i++) {
				sb.append(Q.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
}
