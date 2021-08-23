package BaekJoon.Dp;
// 백준11726 2 x N 타일링
import java.util.Scanner;

public class BOJ11726_2xN타일링 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		arr[0] = 1;
		arr[1] = 1;
		sc.close();
		
		for(int i = 2; i <= N; i++){
        	arr[i] = (arr[i-1] + arr[i-2]) % 10007;
    	}
		System.out.println(arr[N]);
		
	}
	
}
