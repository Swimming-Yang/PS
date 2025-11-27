import java.io.*;
import java.util.*;

public class Main {
	
	public static int N, K, answer;
	
	public static int[] arr;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		init();
		backtracking(0, 500);
		System.out.println(answer);

	}

	private static void init() throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //N일동안
		K = Integer.parseInt(st.nextToken()); //운동 감소량
		answer = 0;
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void backtracking(int day, int weight) {
		if(day == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				int newWeight = weight - K + arr[i];
				
				if(newWeight >= 500) {
					visited[i] = true;
					backtracking(day + 1, newWeight);
					visited[i] = false;
				}
			}
		}
	}
}
