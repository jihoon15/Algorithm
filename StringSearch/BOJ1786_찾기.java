package BaekJoon.StringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		int tlength = text.length;
		int plength = pattern.length;
		
		int[] kmp = new int[plength];
		
		for(int i = 1,j =0; i < plength; i++) {// i는 pattern 따라가는거고 j가 이제 같은거 체크하는인덱스
			while(j > 0 && pattern[j] != pattern[i]) {
				// j>0이고 접미사와 접두사이후의 char가 다를때
				j = kmp[j - 1];
			}
			if(pattern[j] == pattern[i]) {
				//같으면
				kmp[i] = ++j;
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();// 인덱스 담어줄 리스트
		for(int i = 0,j = 0 ; i < tlength; i++) {
			while(j > 0 && pattern[j] != text[i]) {
				j = kmp[j-1];
			}
			
			if(pattern[j] == text[i]) {
				if(j == plength - 1) {
					cnt++;
					list.add(i + 2 - plength);
					j = kmp[j];// 그다음에 같은게 나올수있으니깐 다시 맞은 문자열중에 접두사위치로 이동함
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		for(int index: list) System.out.print(index + " ");
		
		br.close();
	}
}
