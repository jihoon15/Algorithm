package BaekJoon;
// 일곱 난쟁이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309_일곱난쟁이 {
	
	static int sumOfSmall = 100;
	static final int resNum = 7;
	static final int inputNum = 9;
	static boolean endFlag = true;
	
	static int arr[] = new int [inputNum];
	static int res[] = new int [resNum];
	
	static void find(int start, int cnt, int sum) {

		if(cnt == resNum) {
			if(endFlag && sum ==100) {
				for(int i = 0; i < resNum; i++) {
					System.out.println(res[i]);
				}
				endFlag = false;
			}
			return;
		}
		
		for(int i = start; i < inputNum; i++) {
			res[cnt] = arr[i];
			find(i + 1, cnt + 1, sum + arr[i]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i< inputNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		find(0,0,0);
		
	}
}
