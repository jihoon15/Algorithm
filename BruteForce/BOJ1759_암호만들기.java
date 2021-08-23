package BaekJoon.BruteForce;
//백준 1759 암호만들기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {
	static int L;
	static int C;
	
	//최소 한개의 모음  a e i o u
	//a 97
	static boolean alpha[] = new boolean[26];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());//만들어야할 문자열길이
		C = Integer.parseInt(st.nextToken());//문자수
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) {
			int index = st.nextToken().charAt(0) - 97;
			alpha[index] = true;
		}
		
		dfs("",0,0);
		bw.write(sb.toString());
		sb.delete(0, sb.length());
		bw.close();
		br.close();
	}
	static void dfs(String str,int start, int cnt) {
		if(cnt == L) {
			if(check(str)) {
				sb.append(str + "\n");
			}
			return;
		}
		
		for(int i = start; i < 26; i++) {
			if(alpha[i]) {
				dfs(str + (char)(i + 97) ,i + 1 ,cnt + 1);
			}
		}
		
	}
	
	static boolean check(String str) {
		int consonant = 0;
		int vowel = 0;
		if(str.contains("a")) consonant++;
		if(str.contains("e")) consonant++;
		if(str.contains("i")) consonant++;
		if(str.contains("o")) consonant++;
		if(str.contains("u")) consonant++;

		vowel = L - consonant;
		
		if(vowel >= 2 && consonant >= 1) return true;
		return false;
	}
}
