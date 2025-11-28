import java.io.*;


public class Main {
	
	public static boolean[][] map;
	public static int count = 0;
	public static int N;
	
	public static void main(String[] args) throws IOException{
		init();
		
		backtracking(0);
		
		System.out.println(count);

	}

	private static void init() throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		
	}

	private static void backtracking(int row) {
		// 완료조건
		if(row == N) {
			count++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(possible(row, col)) {
				map[row][col] = true;
				backtracking(row + 1);
				map[row][col] = false;
			}
		}
	}

	private static boolean possible(int row, int col) {
		for(int i = 0; i < row; i++) {
			if(map[i][col]) return false;
		}
		int r = row - 1;
		int c = col - 1;
		while(r >= 0 && c >= 0) {
			if(map[r][c]) return false;
			r--;
			c--;
		}
		
		r = row - 1;
		c = col + 1;
		while(r >= 0 && c < N) {
			if(map[r][c]) return false;
			r--;
			c++;
		}
		return true;
	}

}
