import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static boolean[] visited;
	public static int[][] graph;
	
	public static int N, M, V;
	

	public static void main(String[] args) throws IOException{
		
		init();
		dfs(V);
		visited = new boolean[N + 1];
		System.out.println();
		bfs(V);
	
	}

	//입력을 명세함
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		graph = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
	}
	
	private static void dfs(int Node) {
		// TODO Auto-generated method stub
		visited[Node] = true;
		System.out.print(Node + " ");
		
		for(int i = 1; i <= N; i++) {
			if(graph[Node][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs(int start) {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new ArrayDeque<>();
		visited[start] = true;
		dq.offer(start);
		
		while(!dq.isEmpty()) {
			int node = dq.poll();
			System.out.print(node + " ");
			
			for(int i = 1; i <= N; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					visited[i] = true;
					dq.offer(i);
				}
			}
		}
		
	}

	
	
	

}
