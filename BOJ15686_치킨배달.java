package BaekJoon;
// 치킨 배달
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686_치킨배달 {
	
	static List<int[]> house = new ArrayList<int[]>();
	static List<int[]> chicken = new ArrayList<int[]>();
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 
		M = Integer.parseInt(st.nextToken()); // 치킨집 제한 개수
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j ++)
			{
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					house.add(new int[] {i,j});
				}
				else if(num == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		//...get
		
 		getAnswer(0, 0, 0);
		System.out.println(min);
		
		br.close();
	}
	
	static void getAnswer(int start, int cnt, int flag) {
		if(cnt == M) {
			int res = getCdist(flag);
			min = min < res ? min :res;
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			getAnswer(i + 1, cnt + 1, flag | 1 << i);
		}
	}
	
	static int getCdist(int flag) {
		int c_dist = 0;
		for(int i = 0; i < house.size(); i++) {
			int hx = house.get(i)[0];
			int hy = house.get(i)[1];
			int mini = Integer.MAX_VALUE;
			for(int j = 0; j <chicken.size(); j++) {
				if((flag & 1 << j) != 0) {
					int cx = chicken.get(j)[0];
					int cy = chicken.get(j)[1];
					int temp = Math.abs(cx - hx) + Math.abs(cy - hy);
					mini = mini < temp? mini:temp;
				}
			}
			c_dist += mini;
		}
		
		return c_dist;
	}
}
