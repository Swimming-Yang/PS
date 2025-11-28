import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] map;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws IOException{
		init();
		
		backtracking(0);
		
		System.out.println(count);

	}



	private static void init() throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
	}
	
	private static void backtracking(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[depth] = i;
			
			if(possible(depth)) backtracking(depth + 1);
		}
		
	}



	private static boolean possible(int col) {
		// TODO Auto-generated method stub
		for(int i = 0; i < col; i++) {
			if(map[col] == map[i]) return false;
			else if(Math.abs(col - i) == Math.abs(map[col] - map[i])) return false;
		}
		return true;
	}

}
