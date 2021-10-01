package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕 {
	
	static int R, C, M;
    static int result;
    static Shark[][] map;
    static ArrayList<Shark> sharks = new ArrayList<>();
    // 상하우좌
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Shark {
        int x;
        int y;
        int speed;
        int dir;
        int size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        void updatePosition() {
            int move = this.speed;
            // 위 아래
            if(dir < 2) {
                move %= ((R-1) * 2);
                while (move > 0) {
                    if(x == 0) {
                        dir = 1;
                    }
                    if(x == R-1) {
                        dir = 0;
                    }
                    x += dx[dir];
                    move--;
                }
            }
            // 좌우
            else {
                move %= ((C-1) * 2);
                while (move > 0) {
                    if(y == 0) {
                        dir = 2;
                    }
                    if(y == C-1) {
                        dir = 3;
                    }
                    y += dy[dir];
                    move--;
                }
            }
        }
    } 
    

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, z);
            map[r][c] = shark;
            sharks.add(shark);
        }

        for(int i = 0; i < C; i++) {
            // 상어 낚시
            catchShark(i);

            // 상어 이동
            move();

            // 살아있는 상어
            survive();
        }

        System.out.println(result);
    }

    static void catchShark(int y) {
        for(int i = 0; i < R; i++) {
            // 만약 서있는 지점에 상어가 있으면 잡음
            if(map[i][y] != null) {
                Shark now = map[i][y];

                // 지도에서 상어 제거
                map[i][y] = null;

                // 잡은 상어의 크기
                result += now.size;
                sharks.remove(now);

                // 한마리만 잡을수 있으므로
                break;
            }
        }
    }

    static void move() {
        // 전체 상어 이동
        for(int i = 0; i < sharks.size(); i++) {
            sharks.get(i).updatePosition();
        }
    }

    // 이동후 상어리스트에서 살아남은 상어로만 map을 초기화
    static void survive() {
        map = new Shark[R][C];
        int size = sharks.size();
        for(int i = size - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);
            // map의 위치가 비어있는 경우
            if(map[shark.x][shark.y] == null) {
                map[shark.x][shark.y] = shark;
            }
            // map의 위치에 상어가 있는 경우
            else {
                if(map[shark.x][shark.y].size > shark.size) {
                    sharks.remove(shark);
                }else {
                    sharks.remove(map[shark.x][shark.y]);
                    map[shark.x][shark.y] = shark;
                }
            }
        }
    }
    
}
