import java.io.IOException;
import java.util.Scanner;

public class Algorithm1 {

	private static boolean isValidCell(int m, int n, int row, int column) {
		if (m < 0 || n < 0 || m >= row || n >= column)
			return false;

		return true;
	}

	public static int solve(char[][] map, int m, int n, int count, int row, int column) {
		int row1 = row;
		int column1 = column;
// if destination  is found,
// increment the path count
		if (m == 0 && n == 0) {
			count++;
			return count;
		}

// if current cell is a valid and open cell
		if (isValidCell(m, n, row1, column1) && map[m][n]=='.') {
// go up (m, m) --> (m - 1, n)
			if (m - 1 >= 0)
				count = solve(map, m - 1, n, count, row1, column1);

// go left (m, n) --> (m, n - 1)
			if (n - 1 >= 0)
				count = solve(map, m, n - 1, count, row1, column1);
		}

		return count;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int m=in.nextInt();
		int n=in.nextInt();
		

		char map[][]=new char[m][n];
	
		for(int i=0;i<m;i++){
			String str=in.next();
				for(int j=0;j<n;j++){				
				map[i][j]=str.charAt(j);
			}
		}
		int count = 0;
		int row = m;
		int column = n;
		System.out.println(solve(map, m - 1, n - 1, count, row, column)%(int)(Math.pow(10,9)+7));

	}
}