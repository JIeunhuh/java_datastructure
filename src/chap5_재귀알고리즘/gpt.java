package chap5_재귀알고리즘;

import java.util.ArrayList;

class Stack2 {
    private ArrayList<Point1> stack = new ArrayList<>();
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public EmptyIntStackException() {
        }
    }

    public class OverFlowIntStackException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public OverFlowIntStackException() {
        }
    }

    public Stack2(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stack = new ArrayList<Point1>();
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(Point1 x) throws OverFlowIntStackException {
        if (ptr >= capacity) {
            throw new OverFlowIntStackException();
        }
        stack.add(x);
        ptr++;
        return 1;
    }

    public Point1 pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        Point1 x = stack.remove(ptr - 1);
        ptr--;
        return x;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public void dump() {
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

class Point1 {
    private int ix;
    private int iy;

    public Point1(int ix, int iy) {
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
        return "Point1 [ix=" + ix + ", iy=" + iy + "]";
    }

}

public class gpt {
    final static int numberqueen = 8;

    public static void SolveQueen(int[][] d) {
        int count = 0, mode = 0;
        int ix = 0, iy = 0;
        Stack2 st = new Stack2(10);
        Point1 p = new Point1(ix, iy);
        d[ix][iy] = 1;
        count++;

        while (count < numberqueen) {
            ix++;
            int cy = 0;

            while (ix < numberqueen) {
                while (cy < numberqueen) {
                    if (CheckMove(d, ix, cy)) {
                        p = new Point1(ix, cy);
                        st.push(p);
                        count++;
                        st.dump();
                        d[ix][cy] = 1;
                        break;
                    }
                    cy++;
                }

                if (cy != numberqueen) {
                    break;
                } else {
                    if (st.isEmpty()) {
                        System.out.println("해결할 수 없는 상태입니다.");
                        return;
                    }
                    p = st.pop();
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
        for (int i = 0; i < numberqueen; i++) {
            if (d[crow][i] == 1)
                return false;
        }
        return true;
    }

    public static boolean checkCol(int[][] d, int ccol) {
        for (int i = 0; i < numberqueen; i++) {
            if (d[i][ccol] == 1)
                return false;
        }
        return true;
    }

    public static boolean checkDiagSW(int[][] d, int x, int y) {
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

    public static boolean checkDiagSE(int[][] d, int x, int y) {
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

    public static boolean CheckMove(int[][] d, int x, int y) {
        return checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y) && d[x][y] == 0;
    }

    public static void main(String[] args) {
        int row = numberqueen, col = numberqueen;
        int[][] data = new int[row][col];
        for (int i = 0; i < numberqueen; i++) {
            for (int j = 0; j < numberqueen; j++) {
                data[i][j] = 0;
            }
        }

        SolveQueen(data);

        for (int i = 0; i < numberqueen; i++) {
            for (int j = 0; j < numberqueen; j++) {
                System.out.print(" " + data[i][j]);
            }
            System.out.println();
        }
    }
}
