package BaekJoon.BruteForce;
// 백설 공주와 일곱 난쟁이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3040_백설공주와일곱난쟁이 {
	
	static int sumOfSmall = 100;
	static final int resNum = 7;
	static final int inputNum = 9;
	
	static int arr[] = new int [inputNum];
	
	static void find(int start, int cnt, int flag, int sum) {
		
		if(cnt == resNum) {
			if(sum == 100) {
				for(int i = 0; i < inputNum;i++) {
					if((flag & 1 << i) != 0)
					{
						System.out.println(arr[i]);
					}
				}
				System.exit(0);
			}
			return;
		}
		
		for(int i = start; i < inputNum; i++) {
			if((flag & 1 << i) != 0) {continue;}
			find(i + 1,cnt + 1,flag | (1 << i),arr[i] + sum);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i< inputNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		find(0,0,0,0);
		
	}
}
