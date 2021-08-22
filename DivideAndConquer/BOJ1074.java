package BaekJoon.DivideAndConquer;

// 백준 1074 Z
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
	static int cnt = 0;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		Z(0,0, 1 << n);
		
		br.close();
	}
	static void Z(int x, int y, int len) {
		
		if(len==1) {
			System.out.println(cnt);
			return;
		}
		
		int X1 = x;//작
		int X2 = x + len/2;//큰
		int Y1 = y;//작
		int Y2 = y + len/2;//큰

		int curr = find(X1,X2,Y1,Y2);// 4조각중에 어디로 갈꺼냐
		// n 번째면  (n - 1)(전체 1/4) 만큼 더해줌 .. 1이면 0 2면 1/4 3이면 2/4 4면 3/4
		cnt +=  (len*len / 4) * (curr - 1);
		switch(curr) {//z 모양으로 1 2 3 4 분면순
		case 1:Z(X1,Y1,len/2);
			break;
		case 2:Z(X1,Y2,len/2);
		break;
		case 3:Z(X2,Y1,len/2);
		break;
		case 4:Z(X2,Y2,len/2);
		break;
		}
		
	}
	static int find(int x1, int x2, int y1, int y2)// z 모양으로 1234 
	{
		if(r < x2)
		{
			if(c < y2)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		else
		{
			if(c < y2)
			{
				return 3;
			}
			else
			{
				return 4;
			}
		}
	}
}
