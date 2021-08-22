package BaekJoon;
// 줄 세우기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List list = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
	
		//int arr = new 
		String[] str = br.readLine().split(" ");//명령어임
		
		for(int i = 0; i < N; i++) {// i 가 학생번호
			int n = Integer.parseInt(str[i]);//번호표
			list.add(i - n, i + 1);
		}
		
		for(int i = 0; i <N; i++) {
			System.out.print(list.get(i) + " ");
		}
		
		br.close();
	}
}
