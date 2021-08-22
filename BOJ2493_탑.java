package BaekJoon;
// 탑
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {
	
	static Stack<int[]> S = new Stack<int[]>();
	static StringBuilder sb = new StringBuilder();
	
	static void act(int[] obj) {
		int index = 0;
		while(true) {
			
			if(S.empty())
			{
				S.push(obj);
				break;
			}//next가 가장 작은값이면
			
			if(S.peek()[0] < obj[0]) {//맨위 값이 작을때
				S.pop();
			}
			else{//맨위 값이 클때 top >= next
				index = S.peek()[1];
				S.push(obj);
				break;
			}
		}
		sb.append(index + " ");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int num_top = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < num_top; i++) {
			int[] obj = new int[2];
			obj[0] = Integer.parseInt(st.nextToken());
			obj[1] = i + 1;
			act(obj);
		}
		
		System.out.println((sb.toString()));
		sb.delete(0, sb.length());
		
	}
}

