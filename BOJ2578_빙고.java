package BaekJoon;
// 빙고
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ2578_빙고 {
	
	static int bingo[][] = new int[5][5];
	static int[] X = new int[6];// 오른대각
	static int[] Y = new int[6];// 왼 대각선
	static int[] xy = new int[2];
	
	static int check = 0;
	
	public static void main(String[] args) {
		Map map = new HashMap<String,int[]>();
		//					    숫자           [x][y]
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i <5; i++) {
			for(int j = 0; j <5; j++) {
				int[] a = new int[2];
				a[0] = i; a[1] = j;
				String str = sc.next();
				map.put(str, a);
			}
		}
		//get bingo
		
		for(int i = 0; i < 25; i++) {
			 String k = sc.next();
			 xy = (int[]) map.get(k);
			 X[xy[0]]++; // 세로 오른대각
			 if(X[xy[0]] == 5) {check++;}
			 Y[xy[1]]++; // 가로 왼대각
			 if(Y[xy[1]] == 5) {check++;}
			 //대각선 처리
			 if(xy[0] == xy[1]) {//오른대각선임
				 X[5]++;
				 if(X[5] == 5) {check++;}
			 }
			 if((xy[0] + xy[1]) == 4) {
				 Y[5]++;
				 if(Y[5] == 5) {check++;}
			 }
			 //검사
			 if(check >= 3) { System.out.println((i+1)); break;}
		}
		sc.close();
		map.clear();
		
		
	}
}

