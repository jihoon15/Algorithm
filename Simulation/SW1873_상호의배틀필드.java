package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW1873_상호의배틀필드 {

	static void printMap() {
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int tankDir;// 상 하 좌 우 순
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char map[][] = new char[20][20];
	
	static int R;//가로
	static int C;//세로
	static int X = 0;
	static int Y = 0;//시작점
	static int dir = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//반복해야함
		
		int N = Integer.parseInt(br.readLine());
		for(int time = 1; time <=N; time++) {
			
			sb.append("#" + time + " ");
			st = new StringTokenizer(br.readLine(), " ");
			
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < C ; i++) {
				String row = br.readLine();
				for(int j = 0; j < R; j++) {
					map[i][j] = row.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						dir = getTank(map[i][j]);
						X = i;
						Y = j;
					}
				}
			}
			
			// get map
			String len = br.readLine();
			String command = br.readLine();
			
			//명령어
			for(int i = 0; i < command.length(); i++) {
				tankAct(command.charAt(i));
			}
			for(int i = 0; i <C ;i++) {
				for(int j = 0; j <R ;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
	}
	
	static void move() {
		map[X][Y] = getTankDir();
		int x = X + dx[dir];
		int y = Y + dy[dir];
		if(x >= C || x < 0 || y >=R || y < 0 || map[x][y] == '#' || map[x][y] == '-' || map[x][y] == '*') {return;}
		map[X][Y] = '.';
		X = x; Y = y;
		map[X][Y] = getTankDir();
	}
	static void shoot() {
		int x = X;
		int y = Y;
		
		while(true) {
			x += dx[dir]; 
			y += dy[dir];
			if(x < 0 || x >=C || y < 0 || y >= R) {return;}//총알 아웃}
			if(map[x][y] =='#') {return;} //강철벽만날시 아무일 발생안함
			if(map[x][y] =='*') {//벽돌벽
				map[x][y] = '.';
				return;
			}
			
		}
	}
	
	
	static char getTankDir() {
		switch(dir) {
		case 0: return '^';
		case 1: return 'v';
		case 2: return '<';
		case 3: return '>';
		}
		return 'a';
	}
	
	static void tankAct(char ch) {
		switch(ch) {//방향바꾸고 한칸이동
		case 'U': dir = 0;move();
			break;
		case 'D': dir = 1;move();
			break;
		case 'L': dir = 2;move();
			break;
		case 'R': dir = 3;move();
			break;
		case 'S': shoot();
			break;
		}

	}
	
	static int getTank(char ch) {
		switch(ch) {
		case '^': return 0;
		case 'v': return 1;
		case '<': return 2;
		case '>': return 3;
		}
		return -1;
	}
}
