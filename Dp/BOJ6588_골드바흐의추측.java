package BaekJoon.Dp;
// 골드바흐의 추측
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6588_골드바흐의추측 {
    public static int million = 1000000;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	boolean flag;
        boolean[] isPrime = new boolean[million+1];
        //false가 프라임
        
        for(int i = 2; i <= 1000; i++) {
            for(int j = i * 2; j <= million; j += i) {
                if(isPrime[j]) continue;
                isPrime[j] = true;
            }
        }
    	//초기화
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            flag = false;
            if(n == 0){break;}
            for(int i = 2; i <= n/2; i++) {
                if(!(isPrime[i]) && !(isPrime[n-i])) {
                    sb.append(n + " = " + i + " + " + (n-i) + "\n");
                    flag = true;
                    break;
                }
            }
            if(!flag)
                sb.append("Goldbach's conjecture is wrong.\n");
        }
        
        System.out.println(sb.toString());
        br.close();
        sb.delete(0, sb.length());
    }

}