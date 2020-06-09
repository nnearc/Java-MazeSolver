import java.util.Scanner;

public class Algorithm3 {

	static int solve(char[][] map, int row, int column) {

		int[][] cost = new int[row][column];

		if (map[row - 1][column - 1] == '*')
			return 0;
		
		for (int i = row-1; i >=0; i--) {
			if (map[i][column-1] == '.')
				cost[i][column-1] = 1;

			// If we encounter a blocked cell
			// in leftmost row, there is no way
			// of visiting any cell directly below it.
			else
				break;
		}

		// Similarly initialize the topmost row
		for (int i = column-2; i >=0; i--) {
			if (map[row-1][i] == '.')
				cost[row-1][i] = 1;

			// If we encounter a blocked cell in
			// bottommost row, there is no way of
			// visiting any cell directly below it.
			else
				break;
		}

		for (int i = row - 2; i >= 0; i--) {
			for (int j = column - 2; j >= 0; j--) {
				if (map[i][j] == '*')
					continue;

				if (map[i + 1][j] > 0)
					cost[i][j] = (cost[i][j] + (cost[i + 1][j] % (int) (Math.pow(10, 9) + 7)));

				if (map[i][j + 1] > 0)
					cost[i][j] = (cost[i][j] + (cost[i][j + 1] % (int) (Math.pow(10, 9) + 7)));
			}
		}

		return (cost[0][0] > 0) ? cost[0][0] % (int) (Math.pow(10, 9) + 7) : 0;
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

		System.out.println(solve(map, m, n));

	}
}