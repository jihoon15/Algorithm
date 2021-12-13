package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW1251_하나로 {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =  null;
		
		int total = Integer.parseInt(br.readLine());
		for(int time = 1; time <= total; time++) {
			int N = Integer.parseInt(br.readLine());
			double[][] arr = new double[N][N];
			boolean[] visit = new boolean[N];
			double[] minEdge = new double[N];
			
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			
			double tax = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					double temp = getDistance(x[i],y[i],x[j],y[j]);
					arr[i][j] = temp;
					arr[j][i] = temp;
				}
				minEdge[i] = INF;
			}
			
			double result = 0;
			minEdge[0] = 0;
			
			
			//
			for(int i = 0; i<N;i++) {
				double min = INF;
				int minVertex = -1;
				for(int j = 0; j < N; j++) {
					if(!visit[j] && min > minEdge[j]) {
						//방문하지 않은 정점중에 가장 최소인 정점을 찾는다
						min = minEdge[j];
						minVertex = j;
					}
				}
				
				//선택한 정점에 대해서 방문처리와 간선값 추가
				visit[minVertex] = true;
				result += min * min;
				for(int j =0; j < N; j++) {
					if(!visit[j] && arr[minVertex][j] != 0 && minEdge[j] > arr[minVertex][j]) {
						minEdge[j] = arr[minVertex][j];
					}
				}
			}
			
			sb.append("#" + time + " " + Math.round(result*tax) + "\n");
		}
		bw.write(sb.toString());
		sb.delete(0, sb.length());
		br.close();
		bw.close();
	}
	
	static double getDistance(String x1, String y1,String x2, String y2) {
		double X1 = Double.parseDouble(x1);
		double X2 = Double.parseDouble(x2);
		double Y1 = Double.parseDouble(y1);
		double Y2 = Double.parseDouble(y2);
		
		double row = Math.pow(X1 - X2, 2);
		double col = Math.pow(Y1 - Y2, 2);
		return Math.sqrt(row + col);
	}
}
