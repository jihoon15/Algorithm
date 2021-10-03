package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
	 
public class BOJ9205_맥주마시면서걸어가기 {
 
	static class LOC {
	    int x;
	    int y;
	 
	    LOC(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int total = Integer.parseInt(br.readLine());
 
        for (int t = 0; t < total; t++) {
            int N = Integer.parseInt(br.readLine());
            LOC[] location = new LOC[N + 2];
            boolean[] bool = new boolean[N + 2];
            Queue<LOC> q = new LinkedList<LOC>();
            boolean success = false;
            String[] str;
            for (int i = 0; i < N + 2; i++) {
                str = br.readLine().split(" ");
                location[i] = new LOC(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            
            LOC start = location[0];    
            LOC end = location[N + 1];   
            q.add(start);    
            
            while (!q.isEmpty()) {
                LOC current = q.poll();
                if(current.equals(end)){
                    success = true;
                    break;
                }
                for (int i = 1; i < N + 2; i++) {
                    if (!bool[i] &&Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y) <= 1000) {
                        q.add(location[i]);
                        bool[i] = true;   
                    }
                }
            }
            if(success){
                sb.append("happy\n");
            }
            else{
            	sb.append("sad\n");
            }
        }
        System.out.println(sb.toString());
        sb.delete(0, sb.length());
        br.close();
    }
}
 
