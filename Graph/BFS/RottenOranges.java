package BFS;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
        queue.add(new Point(-1, -1));

        int numberOfDays = 0;
        boolean isRotten = false;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();

            if (x == -1 && y == -1) {
                if (!queue.isEmpty()) {
                    queue.add(new Point(-1, -1));
                    if (isRotten) {
                        numberOfDays++;
                        isRotten = false;
                    }
                } else {
                    break;
                }
            }

            if (isValid(x + 1, y, m, n, grid)) {
                grid[x + 1][y] = 2;
                isRotten = true;
                queue.add(new Point(x + 1, y));
            }

            if (isValid(x - 1, y, m, n, grid)) {
                grid[x - 1][y] = 2;
                isRotten = true;
                queue.add(new Point(x - 1, y));
            }

            if (isValid(x, y + 1, m, n, grid)) {
                grid[x][y + 1] = 2;
                isRotten = true;
                queue.add(new Point(x, y + 1));
            }

            if (isValid(x, y - 1, m, n, grid)) {
                grid[x][y - 1] = 2;
                isRotten = true;
                queue.add(new Point(x, y - 1));
            }

        }

        boolean isAllRotten = checkIfAllRotten(grid);

        return isAllRotten ? numberOfDays : -1;
    }

    private static boolean checkIfAllRotten(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y, int m, int n, int[][] grid) {
        return x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int days = orangesRotting(grid);
        System.out.println("Days to rot all oranges : " + days);
    }

}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
