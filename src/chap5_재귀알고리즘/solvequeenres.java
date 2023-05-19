package chap5_재귀알고리즘;

public class solvequeenres {

	static final int qCount = 8;

	public static void SolveQueen(int[][] data) {
		int count = 0, mode = 0;
		int icol = 0, irow = 0;
		ObjectStack st = new ObjectStack(10); // 10개를 푸쉬할수 있는 스택

		// 초기 0,0 위치에 퀸 설정
		Point p = new Point();

		p.setRow(irow);
		p.setCol(icol);

		data[icol][irow] = 1;
		count++; // 퀸 넣기.
		st.push(p);

		while (count < qCount) { // 퀸 8개를 다 놓을 때 까지 반복
			icol++;
			int crow = 0;

			while (icol < data[0].length) // 체스판의 가로축 끝까지 반복
			{

				while (crow < data.length) { // 체스판의 세로축 끝까지 반복

					if (CheckMove(data, crow, icol) == true) {// 지금 퀸을 넣을 수 있는지 확인 하는것
						p = new Point(); // 지금 위치를 p 에 넣어 주기
						p.setRow(crow);
						p.setCol(icol);

						st.push(p);
						System.out.println("push(" + p + ")");
						count++;
						data[crow][icol] = 1; // 안전한 위치에 퀸 넣기
						break;

					}

					crow++;

				}
				if (crow < data.length) {
					break;
				} else {
					p = st.pop(); // 전의 내용을 빼겠다.
					System.out.println("pop(" + p + ")");
					count--;
					data[p.getRow()][p.getCol()] = 0; // 위치를 다시 영으로 바꿔 주겠다.

					icol = p.getCol();
					crow = p.getRow() + 1; // 한칸 내려 가야 함으로

				}

			}

		}
	}

	public static boolean checkRow(int[][] data, int row) {

		for (int c = 0; c < data[row].length; c++) { // → 방향 확인
			if (data[row][c] == 1) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkCol(int[][] data, int col) {

		for (int r = 0; r < data.length; r++) { // ↓ 방향 확인
			if (data[r][col] == 1)
				return false;
		}

		return true;
	}

	public static boolean checkDiagSW(int[][] data, int row, int col) { // x++, y-- or x--, y++ where 0<= x,y <= 7

		// ↙ row++ col --

		int r = row;
		int c = col;

		while (true) {
			r++;
			c--;

			if ((c < 0) || (r >= data.length)) {
				break;
			}
			if (data[r][c] == 1) {
				return false;
			}
		}

		r = row;
		c = col;

		while (true) { // ↗
			r--;
			c++;

			if ((c <= data.length) || (r < 0)) {
				break;
			}

			if (data[r][c] == 1) {
				return false;
			}

		}

		return true;
	}

	public static boolean checkDiagSE(int[][] data, int row, int col) {// x++, y++ or x--, y--

		int r = row;
		int c = col;

		while (true) {
			r++;
			c++;

			if ((c >= data.length) || (r >= data.length)) {
				break;
			}
			if (data[r][c] == 1) {
				return false;
			}
		}

		r = row;
		c = col;

		while (true) {
			r--;
			c--;

			if ((c < 0) || (r < 0)) {
				break;
			}

			if (data[r][c] == 1) {
				return false;
			}

		}

		return true;
	}

	public static boolean CheckMove(int[][] data, int row, int col) {// (x,y)로 이동 가능한지를 check

		// 행 방향에 퀸이 있는지 확인 하고 로우 방향에 있는지 확인 하고 se ↘sw ↙ 대각선 도 확인 해야 한다.

		if ((checkRow(data, row) == true) && (checkCol(data, col) == true) && (checkDiagSE(data, row, col) == true)
				&& (checkDiagSW(data, row, col) == true) && data[row][col] == 0) {

			return true;
		}

		return false;
	}

	public static boolean NextMove(int[][] data, int row, int col) {// 다음 row에 대하여 이동할 col을 조사

		return true;
	}

	public static void main(String[] args) {
		int row = qCount, col = qCount;
		int[][] data = new int[qCount][qCount];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0; // 체스판 완성

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
