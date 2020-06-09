import java.util.Scanner;

public class Algorithm2 {
	public static int[][] visited;

	private static boolean isValidCell(int m, int n, int row, int column) {
		if (m < 0 || n < 0 || m >= row || n >= column)
			return false;

		return true;
	}

	public static int solve(char[][] map, int m, int n) {

		if (map[m][n] == '*')
			visited[m][n] = 0;
		else if (m == 0 && n == 0)
			visited[m][n] = 1;
		else if (isValidCell(m, n, visited.length, visited[0].length)) {
			if ((m - 1 >= 0) && (visited[m - 1][n] == -1))
				solve(map, m - 1, n);

			if ((n - 1 >= 0) && (visited[m][n - 1] == -1))
				solve(map, m, n - 1);
			
			
			int sum1 = 0;
			if((m - 1 >= 0))
				sum1=visited[m - 1][n];

			int sum2 = 0;
			if((n - 1 >= 0))
				sum2=visited[m][n-1];

			visited[m][n] = (sum1 + sum2) % (int) (Math.pow(10, 9) + 7);
		}
		return visited[m][n];
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		char map[][] = new char[m][n];

		for (int i = 0; i < m; i++) {
			String str = in.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = -1;
			}
		}
		System.out.println(solve(map, m - 1, n - 1));
	}
}