package BaekJoon.Simulation;
// 스위치 켜고 끄기
import java.util.Scanner;

public class BOJ1244_스위치켜고끄기 {

	static int Switch[];
	static int len;
	
	static void flip(int num) {
		if(Switch[num] == 0) {Switch[num] = 1;}
		else {Switch[num] = 0;}
	}
	
	static void man(int num) {
		int plus = num;
		while(num <= len) {
			flip(num);
			num += plus;
		}
	}
	
	static void woman(int num) {
		int start = num;
		int end = num;
		int width = getWidth(start,end,0) - 1;
		womanFlip(num , width);
		flip(num);
	}
	
	static int getWidth(int start, int end, int width) {// 리턴값  -1  해서 사용
		if(start < 1 || end > len ) {return 0;}
		if(Switch[start] != Switch[end]) {return 0;}
		else{return 1 + getWidth(start - 1, end + 1, width + 1);}//무조건 한번은
	}
	
	
	static void womanFlip(int num, int width) {
		int start = num - width;
		int end = num + width;
		for(int i = 0; i < width; i++) {
			flip(start++);
			flip(end--);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		len = sc.nextInt();//스위치길이
		Switch = new int[len + 1];
		
		for(int i = 1; i <= len; i++)
		{
			Switch[i] = sc.nextInt();
		}//get switch
		
		int person_num = sc.nextInt();
		for(int i = 0; i < person_num; i++)
		{
			int flag = sc.nextInt();
			int num = sc.nextInt();
			
			if(flag == 1) {
				man(num);
			}
			else {
				woman(num);
			}
		}
		
		//결과 출력
		for(int i = 1; i <= len; i++)
		{
			System.out.print(Switch[i] + " ");
			if(i % 20 == 0) {System.out.println();}
		}
	}
}
