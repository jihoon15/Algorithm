package BaekJoon.Dp;
// 1로 만들기
import java.util.Scanner;

public class BOJ1463_1로만들기 {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		arr[1] = 0;
		for(int i = 2; i <=N;i++) {
			arr[i] = arr[i - 1] + 1;
			if(i % 2 == 0) {arr[i] = Math.min(arr[i], arr[i/2] + 1);}
			if(i % 3 == 0) {arr[i] = Math.min(arr[i], arr[i/3] + 1);}
		}
		
		sc.close();
		System.out.println( arr[N]);
	}

}
