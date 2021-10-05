package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961_회전초밥 {
	static int N,d,k,c;
	static int[] sushiKinds;
	static int sushi[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());//접시의 수
		d = Integer.parseInt(st.nextToken());// 초밥의 종류
		k = Integer.parseInt(st.nextToken());// 접시의수 k <= N 추가초밥 x
		c = Integer.parseInt(st.nextToken());//쿠폰번호 c
		
		sushi = new int[N]; 
		sushiKinds = new int[d + 1];
		
		for(int i = 0; i< N; i++) {//초밥의 종류를 나타내는 정수
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int max = 0;
		
		//init
		for(int i = 0; i < k; i++) {
			if(sushiKinds[sushi[i]] == 0) cnt++;
			sushiKinds[sushi[i]]++;
		}
		
		//쿠폰확인
		if(sushiKinds[c] == 0) {
			max = Math.max(max, cnt + 1);
		}else {
			max = Math.max(max, cnt);
		}
		
		//메인 루프
		// ptr1 빼야할 것  0 ~ n-1  
		// ptr2 추가할 것  k ~ k - 1까지
		for(int i = 0; i < N; i++) {
			//앞에거 빼고
			sushiKinds[sushi[i]]--;
			if(sushiKinds[sushi[i]] == 0)cnt--;
			
			//뒤에거 더하고
			//0부터시작했으니깐 시작이 n 끝이 k-1인 순회까지확인
			if(sushiKinds[sushi[(i + k) % N]] == 0)cnt++;
			sushiKinds[sushi[(i + k) % N]]++;
			
			
			//쿠폰확인
			if(sushiKinds[c] == 0) {
				max = Math.max(max, cnt + 1);
			}else {
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);
		br.close();
	}
}
