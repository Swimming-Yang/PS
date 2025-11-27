import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	public static int N, M;
	public static int[] cur_arr;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		init();
		backtracking(0);
		System.out.print(sb);
	}
	
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		cur_arr = new int[M];
	}
	
	private static void backtracking(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(cur_arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cur_arr[depth] = i;
				
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}