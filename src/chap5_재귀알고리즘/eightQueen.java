package chap5_재귀알고리즘;

import java.util.ArrayList;

class Stack3 { // stack class
	private ArrayList<Point> stack = new ArrayList<>(); // 스택용 arraylist
	// private ArrayList<Items> stack1 = new ArrayList<>();
	private int capacity; // stack 용량
	private int ptr; // 스택 포인터

	public class EmptyIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyIntStackException() {
		}
	}

	public class OverFlowIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OverFlowIntStackException() {
		}
	}

	public Stack3(int maxlen) { // 생성자
		ptr = 0;
		capacity = maxlen;
		try {
			stack = new ArrayList<Point>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(Point x) throws OverFlowIntStackException { // stack push
		if (ptr >= capacity) {
			throw new OverFlowIntStackException();
		}
		stack.add(x);
		ptr++;
		return 1;
	}

	public Point pop() throws EmptyIntStackException {// stack pop
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		Point x = stack.remove(ptr - 1);
		ptr--;
		return x;
	}

	public boolean isEmpty() {
		return ptr <= 0;
	}

	public void dump() {// stack에 있는 값 다 보기
		if (isEmpty())
			System.out.println("stack이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.println("dump = " + stack.get(i) + " ");
				System.out.println();
			}
		}
	}

}

class Point {// point class
	private int ix;
	private int iy;

	public Point(int ix, int iy) {
		this.ix = ix;
		this.iy = iy;
	}

	public int GetX() {
		return ix;
	}

	public int GetY() {
		return iy;
	}

	@Override
	public String toString() {
		return "Point [ix=" + ix + ", iy=" + iy + "]";
	}

}

public class eightQueen {
	final static int numberqueen = 8; //numberqueen=4로 설정하면 문제 안풀림 대각선 방향에 무조건 걸림 !!

	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		// 최대 10개의 스택을 푸쉬할 수 있음
		Stack3 st = new Stack3(10);
		// 초기 위치에 queen 설정
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		// st.push(p);
		while (count < numberqueen) {
			ix++;
			int cy = 0;
			while (ix < numberqueen) { // 체스판의 가로길이보다 작을때 까지
				System.out.println("ix = " + ix + " iy = " + iy);
				while (cy < numberqueen) {// 체스판의 열보다 작을때
					if (CheckMove(d, ix, cy)) {
						p = new Point(ix, cy);
						st.push(p);
						count++;
						st.dump();
						d[ix][cy] = 1;
						break;
					}
					cy++; // y축 한칸 이동(아래로)
				}

				if (cy != numberqueen) {
					break;
				} else {
					if (st.isEmpty()) {
						System.out.println("stack이 비었음");
						return;
					}
					p = st.pop();
					System.out.println("pop(" + p + ")");
					ix = p.GetX();
					iy = p.GetY();
					count--;
					d[ix][iy] = 0;

					ix = ix;
					cy = iy + 1;

				}
			}
		}

	}

	public static boolean checkRow(int[][] d, int crow) {
		// 배열 d에서 crow 행에 queen을 놓을 수 있는지
		for (int i = 0; i < numberqueen; i++) {
			// System.out.println("checkrow : "+d[crow][i]);
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		// 배열 d에서 ccol열에 queen을 놓을 수 있는지
		for (int i = 0; i < numberqueen; i++) {
			if (d[i][ccol] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		// d[cx][cy]의 sw쪽 대각선에 배치 가능한지
		int cx = x;
		int cy = y;
		while (cx >= 0 && cx < numberqueen && cy >= 0 && cy < numberqueen) {
			if (d[cx][cy] == 1)
				return false;

			cx++;
			cy--;

		}
		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberqueen && cy >= 0 && cy < numberqueen) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		// d[cx][cy]의 se쪽 대각선에 배치 가능한지
		int cx = x;
		int cy = y;
		while (cx >= 0 && cx < numberqueen && cy >= 0 && cy < numberqueen) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;

		}
		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberqueen && cy >= 0 && cy < numberqueen) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy--;

		}
		return true;
	}

	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		return checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y) && d[x][y] == 0;
	
	}

	public static int NextMove(int[][] d, int row, int col) {// 다음 row에 대하여 이동할 col을 조사

		for (; col < numberqueen; col++) {
			System.out.println("row=" + row + "col = " + col);
			if (CheckMove(d, row, col))
				return col;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {

		int row = numberqueen, col = numberqueen;
		int[][] data = new int[row][col];
		for (int i = 0; i < numberqueen; i++)
			for (int j = 0; j < numberqueen; j++)
				data[i][j] = 0; // 체스판 완성

		SolveQueen(data);

		for (int i = 0; i < numberqueen; i++) {
			for (int j = 0; j < numberqueen; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
		
		ArrayList<int[][]> solutions = new ArrayList<>();
		
	}
}
